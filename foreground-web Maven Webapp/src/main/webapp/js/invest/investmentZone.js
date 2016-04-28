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
	/*进度条*/
	$(".progress").each(function(){
		$(this).find(".barline").css("width",$(this).find(".progress_totle").html());
	});

	/**
	 * 倒计时
	 */
	$(function(){	
		ttCountDown();
	});
	function ttCountDown() {
		/*var startTimeValue = $.trim($("#startTimeValue").text());
		var endTimeValue = $.trim($("#endTimeValue").text());
	    var cServerTt = $("#cServerTt").val();
	    var	nowTime = $("#currentDate").val();*/
		var startTimeValue = $.trim("2015-05-10 17:00:00");
		var endTimeValue = $.trim("2016-05-10 17:00:00");
	    var date = Date.parse(new Date());//实际操作中使用服务器时间
	    var cServerTt = $.trim("2016-04-10 17:00:00");
	    //var	nowTime = $("#currentDate").val();
	    //开始倒计时
	    /*if(startTimeValue != null && startTimeValue != '') {
		    $('#startTimeValue-d').countDown({
		        "startTime":startTimeValue,
		        //"endTime":endTimeValue,
		        "nowTime":cServerTt,
		        "startTips":'',
		        "endTips":''
		    });
	    }*/
	    //截止倒计时
	    if(endTimeValue != null && endTimeValue != '') {
		    $('#endTimeValue-d').countDown({
		        //"startTime":startTimeValue,
		        "endTime":endTimeValue,
		        "nowTime":date,
		        "startTips":'',
		        "endTips":''
		        /*"timeStamp": false*/
		    });
	    }
	}


//	2016-4-28付晨早
//	查询出借款类型
	
	var investmentZone = {
//		//加密
//		addEncrypt:function(str){
//			return encrypt.encrypt(str+"");
//		},
		getInvestmentList : function(wd,projectStatu,reward,loanType,
									 annualInterest,repayment,deadlineType,
									 deadlinemin,page){
			//String wd				=	request.getParameter("wd");						//赛选条件名称(项目名称)
			//String projectStatu		= 	request.getParameter("projectStatu");			//项目状态
			//String reward			=	request.getParameter("reward");					//奖励
			//String loanType			=	request.getParameter("loanType");				//借款类型
			//String annualInterest	=	request.getParameter("annualInterest");			//年利率
			//String repayment 		=	request.getParameter("repayment");				//还款方式
			//String deadlineType		= 	request.getParameter("deadlineType");			//借款期限
			//String deadline			= 	request.getParameter("deadlinemin");			//期限
			//int page				=	Integer.parseInt(request.getParameter("page"));	//页码
			var url = "invest/fundList.html";
//			var data = {};
//			data.wd = investmentZone.addEncrypt(wd);
//			var encrypt = new JSEncrypt();
//			encrypt.setPublicKey(publickey);
			var data = {wd:wd,projectStatu:projectStatu,reward:reward,
				loanType:loanType,annualInterest:annualInterest,
				repayment:repayment,deadlineType:deadlineType,
				deadlinemin:deadlinemin,page:page};
			console.log(data);

			NetUtil.ajax(
				url,
				data,
				function(r){
					console.log(r)
				}
			)
		}
	};

	//初始化
	investmentZone.getInvestmentList(null,"-1","-1","-1","-1","-1","-1","-1","0");

});

