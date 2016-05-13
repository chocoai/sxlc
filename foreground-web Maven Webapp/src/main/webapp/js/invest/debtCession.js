/*伍成然2016-3-28*/
$(function(){
	/*轮播图切换*/
	var slidey = $('.banner').unslider({
		speed: 500,			   
		delay: 3000,			
		complete: function() {}, 
		keys: true,			 
		dots: true,			  
		fluid: true
	});
	data = slidey.data('unslider'); 
	data.move(2, function() {});
	/*search-icon切换*/	
	$(".search").bind({ 
		focus:function(){ 
			$(this).removeClass("show");
		}, 
		blur:function(){ 
			$(this).addClass("show");
		} 
	});
	
	
	/*tags切换*/
	$(".tags-list label").click(function(){
		$(this).parent().children().removeClass("active"); 
		$(this).addClass("active");
	});
	
	
	//2016-5-6 付晨早
//	默认值
	var wd = null;
	var projectStatu = $("input:radio[name='projectStatu']:checked").val();
	var loanType =  $("input:radio[name='loanType']:checked").val();
	//console.log(loanType);
	var annualInterest = $("input:radio[name='annualInterest']:checked").val();
	var repayment = $("input:radio[name='repayment']:checked").val();
	var deadlineType = "-1";
	var deadlinemin = "-1";
	var deadlinemax = "-1";
	var page = "1";
	
	template.helper("$toFixed",function(content){
		return parseInt(content).toFixed(2)
	});
	template.helper("$toDelete",function(content){
		var index = content.indexOf(".");
		return content.substring(0,index)
	});
	
	var debtCession = {
			//判断期限
			determinePeriod :function(){
				var arr = [];//index(0):借款期限 index(1):最小期限 index(2):最大期限
//				//console.log($("input:radio[name='investDay']:checked").val())
				if ($("input:radio[name='investDay']:checked").val()!='-1'){
					arr[0] = "0";
					arr[1] = $("input:radio[name='investDay']:checked").val().split(",")[0];
					arr[2] = $("input:radio[name='investDay']:checked").val().split(",")[1];
				}else if($("input:radio[name='investMonth']:checked").val()!='-1'){
					
					arr[0] = "1";
					arr[1] = $("input:radio[name='investMonth']:checked").val().split(",")[0];
					arr[2] = $("input:radio[name='investMonth']:checked").val().split(",")[1];
				}else if($("input:radio[name='investYear']:checked").val()!='-1'){
					//console.log($("input:radio[name='investYear']:checked").val());
					arr[0] = "2";
					arr[1] = $("input:radio[name='investMonth']:checked").val().split(",")[0];
					arr[2] = $("input:radio[name='investMonth']:checked").val().split(",")[1];
				}else{
					arr[0] = "-1";
					arr[1] = "-1";
					arr[2] = "-1";
				}
				return arr;
			},
			getInvestmentList : function(wd,projectStatu,loanType,
					 annualInterest,repayment,deadlineType,
					 deadlinemin,deadlinemax,page){
/*				String wd				=	request.getParameter("wd");						//赛选条件名称(项目名称)
				String projectStatu		= 	request.getParameter("projectStatu");			//项目状态
				String projectType		=	request.getParameter("projectType");			//借款类型
				String annualInterest	=	request.getParameter("annualInterest");			//年利率
				String repayment 		=	request.getParameter("repayment");				//还款方式
				String deadlineType		= 	request.getParameter("deadlineType");			//借款期限
				String deadlinemin		= 	request.getParameter("deadlinemin");			//最小期限
				String deadlinemax		= 	request.getParameter("deadlinemax");			//最大期限
				int page				=	Integer.parseInt(request.getParameter("page"));	//页码
*/		
		var url = "invest/loanList.html";
		var data = {wd:wd,projectStatu:projectStatu,
		loanType:loanType,annualInterest:annualInterest,
		repayment:repayment,deadlineType:deadlineType,
		deadlinemin:deadlinemin,deadlinemax:deadlinemax,page:page};
		//console.log(data);
		NetUtil.ajax(
			url,
			data,
			function(r){
					var data = JSON.parse(r);
					//console.log(data)
					var html = template("debt_list",data);
					document.getElementById("debtList").innerHTML = html;
				
					/*进度条*/
					$(".progress").each(function(){
						$(this).find(".barline").css("width",$(this).find(".progress_totle").html());
					});
					
					var tol = data.tol;
					var cpage = data.cpage;
					var pageSize = data.pageSize;
					if(tol>0){
						debtCession.byPage(tol,cpage,pageSize);
					}else{
						$("#pager").html("");
					}
				}
			);
		},
		//分页 参数1 总条数 参数2 当前页 参数3 每页条数
		byPage:function(tol,cpage,pagesize){
			var totalRecords =tol;
			var pageNo = cpage;
			var pagesize = pagesize;
			//总页数
			var totalPage = Math.ceil(totalRecords/pagesize);
			pager.generPageHtml({
				pno : pageNo,
				//总页码
				total : totalPage,
				//总数据条数
				totalRecords : totalRecords,
				mode : 'click',//默认值是link，可选link或者click
				click : function(n) {
					if($("#wd").val()=="undefined"||$("#wd").val()=="null"||$("#wd").val()==""){
						var wd = null;
					}else{
						var wd =$("#wd").val();
					}
					var projectStatu = $("input:radio[name='projectStatu']:checked").val();
					var loanType =  $("input:radio[name='loanType']:checked").val();
					var annualInterest = $("input:radio[name='annualInterest']:checked").val();
					var repayment = $("input:radio[name='repayment']:checked").val();
					var deadlineType = debtCession.determinePeriod()[0];
					var deadlinemin = debtCession.determinePeriod()[1];
					var deadlinemax = debtCession.determinePeriod()[2];
					var page = n;
					debtCession.getInvestmentList(wd,projectStatu,loanType,annualInterest,repayment,deadlineType,
							 deadlinemin,deadlinemax,page);
					this.selectPage(n);
					return false;
					
				}
			});
		}
	}
	
	
	//期限
	$(".tags-list label input[name='investDay']").on("change",function(){
		if (!($(this).val()=="-1")){
			$(".tags-list label>input[name='investMonth']").eq(0).parent().click();
			$(".tags-list label>input[name='investYear']").eq(0).parent().click();
		}
	});
	$(".tags-list label input[name='investMonth']").on("change",function(){
		if (!($(this).val()=="-1")){
			$(".tags-list label>input[name='investYear']").eq(0).parent().click();
			$(".tags-list label>input[name='investDay']").eq(0).parent().click();
		}
	});
	$(".tags-list label input[name='investYear']").on("change",function(){
		if (!($(this).val()=="-1")){
			$(".tags-list label>input[name='investMonth']").eq(0).parent().click();
			$(".tags-list label>input[name='investDay']").eq(0).parent().click();
		}
	});
	
	//点击上面的选项
	$(".tags-list label input[type='radio']").on("click",function(){
		if($("#wd").val()==undefined||$("#wd").val()=="null"||$("#wd").val()==""){
			var wd = null;
		}else{
			var wd =$("#wd").val();
		}
		var projectStatu = $("input:radio[name='projectStatu']:checked").val();
		var loanType =  $("input:radio[name='loanType']:checked").val();
		var annualInterest = $("input:radio[name='annualInterest']:checked").val();
		var repayment = $("input:radio[name='repayment']:checked").val();
		var deadlineType = debtCession.determinePeriod()[0];
		var deadlinemin = debtCession.determinePeriod()[1];
		var deadlinemax = debtCession.determinePeriod()[2];
		var page = "1";
		debtCession.getInvestmentList(wd,projectStatu,loanType,annualInterest,repayment,deadlineType,
				 deadlinemin,deadlinemax,page);
	});
	//点击搜索
	$("#searchContent").on("click",function(){
		if($("#wd").val()=="undefined"||$("#wd").val()=="null"||$("#wd").val()==""){
			var wd = null;
		}else{
			var wd =$("#wd").val();
		}
		var projectStatu = $("input:radio[name='projectStatu']:checked").val();
		var loanType =  $("input:radio[name='loanType']:checked").val();
		var annualInterest = $("input:radio[name='annualInterest']:checked").val();
		var repayment = $("input:radio[name='repayment']:checked").val();
		var deadlineType = debtCession.determinePeriod()[0];
		var deadlinemin = debtCession.determinePeriod()[1];
		var deadlinemax = debtCession.determinePeriod()[2];
		var page = "1";
		debtCession.getInvestmentList(wd,projectStatu,loanType,annualInterest,repayment,deadlineType,
				 deadlinemin,deadlinemax,page);
	})
	
	
	//初始化
	//名称，状态，奖励，借款类型，年利率，还款方式，借款期限，最小期限，最大期限，页码
	debtCession.getInvestmentList(wd,projectStatu,loanType,annualInterest,repayment,deadlineType,
									 deadlinemin,deadlinemax,page);
	
	
});
