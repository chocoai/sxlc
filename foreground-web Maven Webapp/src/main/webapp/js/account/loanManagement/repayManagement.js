$(function(){
	$(".TE").addClass("down");
	$(".TE3").addClass("down2");
	$(".my-repay-tab li").each(function(index){
		var liNode =$(this);
		$(this).click(function(){
			$(".tab-content .my-repay-content").removeClass("active");
			$(".my-repay-tab .tab-li").removeClass("tab-ing");
			$(".tab-content .my-repay-content").eq(index).addClass("active");
			liNode.addClass("tab-ing");
		});
	});
	/*伍成然2016-4-6*/
	/*还款管理-待还计划-还款*/
	/*弹出层*/
	$('.repay').on('click', function(){
		layer.open({
			title :'还款',//标题
			skin: 'layer-ext-myskin',//皮肤
	        type: 1,
	        area: ['525px', '670px'],//大小宽*高
	        shadeClose: true, //点击遮罩关闭
	        content: $('.repay-content')//内容，里边是包含内容的div的class
	    });
	});
	/*提前还款*/
	$('.early-repay').on('click', function(){
		layer.open({
			title :'提前还款',//标题
			skin: 'layer-ext-myskin',//皮肤
	        type: 1,
	        area: ['540px', '500px'],//大小宽*高
	        shadeClose: true, //点击遮罩关闭
	        content: $('.early-repay-content')//内容，里边是包含内容的div的class
	    });
	});
});




$(function(){
	$(".numberReg").each(function(){
		$(this).focus(function(){
			$(this).keyup(function(){
				if(this.value.length > 0){
					this.value = this.value.replace(/[^0-9.]/g,'');
				}
			});
		});
	});
});


//还款管理-chenzhen
//我的账户-借款管理-还款管理：待还计划
function getStayStillPlans(curr){
	$.ajax({
		url:"loanManagement/stayStillPlans.html",
		data:{
			"start": curr || 1,		//当前页
			"length":1				//每页条数为预留数据，后台有默认值
		},
		type:"get",
		dataType:"json",
		timeout:10000,
		success:function(data){
			//debugger;
			if(data){
				creatStayStillPlans(data);//拼接数据
				laypage({//分页
				    cont: $("#pager-stayStillPlans"),//容器。值支持id名、原生dom对象，jquery对象。【如该容器为】：<div id="page1"></div>
				    curr:data.pageNum,//初始化当前页			连续分页必须参数
				    pages: data.totalPage,//通过后台拿到的总页数	连续分页必须参数
					first: false,
				    last: false,
				    prev: "&lt;",
				    next: "&gt;",
				    skip: true, //是否开启跳页
				    skin: '#72c0f3',
				    groups: 5, //连续显示分页数
				    jump: function(obj,first){
				    	if(!first){ //点击跳页触发函数自身，并传递当前页：obj.curr
		                    getStayStillPlans(obj.curr);
		                }
				    }
				});
			}
		},
		error:function(){
			layer.alert("请求异常，请稍后再试",{icon:2});
		}
	});
}

//我的账户-借款管理-还款管理：待还计划拼接代码
function creatStayStillPlans(data){
	var _html = "";
	$(".my-loan-table .data-item").remove();
	if(data.results.length != 0){
		for(var i=0;i<data.results.length;i++){
			_html+='<li class="data-item">'+
					'<div class="contentOut0">'+
						'<div class="c-content" title="'+data.results[i].index+'">'+data.results[i].index+'</div>'+
					'</div>'+
					'<div class="contentOut1">'+
						'<div class="c-content" title="'+data.results[i].sSDRepayPrincipal+'">'+data.results[i].sSDRepayPrincipal+'</div>'+
					'</div>'+
					'<div class="contentOut1">'+
						'<div class="c-content" title="'+data.results[i].sSDRepayInterest+'">'+data.results[i].sSDRepayInterest+'</div>'+
					'</div>'+
					'<div class="contentOut2">'+
						'<div class="c-content" title="'+data.results[i].repayMaxTime+'">'+data.results[i].repayMaxTime+'</div>'+
					'</div>'+
					'<div class="contentOut1">'+
						'<div class="c-content mark" title="'+data.results[i].statuName+'">'+data.results[i].statuName+'</div>'+
					'</div>'+
					'<div class="contentOut4">'+
						'<div class="c-content mark">'+data.results[i].sRepayOverdueInterest+'/'+data.results[i].sRepayOverdue+'</div>'+
					'</div>'+
					'<div class="contentOut1">'+
						'<div class="c-content">';
						if(data.results[i].isCompensatory != ""){
							if(data.results[i].isCompensatory == 0){
								_html+='是';
							}else if(data.results[i].isCompensatory == 1){
								_html+='否';
							}
						}
					_html+='</div>'+
					'</div>'+
					'<div class="contentOut3">'+
						'<div class="c-content">'+data.results[i].sRepayPrincipal+'/'+data.results[i].sRepayInterest+'</div>'+
					'</div>'+
					'<div class="contentOut4">'+
						'<div class="c-content">'+data.results[i].sYiHuanYuQiLiXi+'/'+data.results[i].sYiHuanYuQiLiXi+'</div>'+
					'</div>'+
					'<div class="contentOut1">'+
						'<div class="c-content" title="'+data.results[i].projectName+'">'+data.results[i].projectName+'</div>'+
					'</div>'+
					'<div class="contentOut1">'+
						'<div class="c-content">'+
							'<div class="repay">还款</div>'+
						'</div>'+
					'</div>'+
				'</li>';
		}
	}else{
		_html+='<li class="data-item noData"><div>暂无数据！</div></li>';
	}
	//赋值
	$(".my-loan-table.stayStillPlans").append(_html);
}




//我的账户-借款管理-还款管理：还款中的借款
function getRepayManagementin(curr){
	$.ajax({
		url:"loanManagement/repayManagementin.html",
		data:{
			"start": curr || 1,		//当前页
			"length":1				//每页条数为预留数据，后台有默认值
		},
		type:"get",
		dataType:"json",
		timeout:10000,
		success:function(data){
			if(data){
				creatRepayManagementin(data);//拼接数据
				laypage({//分页
				    cont: $("#pager-repayManagementin"),//容器。值支持id名、原生dom对象，jquery对象。【如该容器为】：<div id="page1"></div>
				    curr:data.pageNum,//初始化当前页			连续分页必须参数
				    pages: data.totalPage,//通过后台拿到的总页数	连续分页必须参数
					first: false,
				    last: false,
				    prev: "&lt;",
				    next: "&gt;",
				    skip: true, //是否开启跳页
				    skin: '#72c0f3',
				    groups: 5, //连续显示分页数
				    jump: function(obj,first){
				    	if(!first){ //点击跳页触发函数自身，并传递当前页：obj.curr
		                    getRepayManagementin(obj.curr);
		                }
				    }
				});
			}
		},
		error:function(){
			layer.alert("请求异常，请稍后再试",{icon:2});
		}
	});
}

//我的账户-借款管理-还款管理：还款中的借款拼接代码
function creatRepayManagementin(data){
	var _html = "";
	$(".my-loan-table.repayManagementin .data-item").remove();
	if(data.results.length != 0){
		for(var i=0;i<data.results.length;i++){
			_html+='<li class="data-item">'+
					'<div class="contentOut1">'+
						'<div class="c-content ot-a" title="'+data.results[i].projectNo+'">'+data.results[i].projectNo+'</div>'+
					'</div>'+
					'<div class="contentOut2">'+
						'<div class="c-content ot-a" title="'+data.results[i].projectName+'">'+data.results[i].projectName+'</div>'+
					'</div>'+
					'<div class="contentOut2">'+
						'<div class="c-content ot-a" title="'+data.results[i].lendingTime+'">'+data.results[i].lendingTime+'</div>'+
					'</div>'+
					'<div class="contentOut1">'+
						'<div class="c-content ot-a" title="'+data.results[i].sPrincipal+'">'+data.results[i].sPrincipal+'</div>'+
					'</div>'+
					'<div class="contentOut1">'+
						'<div class="c-content ot-a" title="'+data.results[i].sInterestRates+'">'+data.results[i].sInterestRates+'</div>'+
					'</div>'+
					'<div class="contentOut1">'+
						'<div class="c-content">'+data.results[i].termOfLoan;
						if(data.results[i].termOfLoanType !=""){
							if(data.results[i].termOfLoanType == 0){
								_html+="天";
							}else if(data.results[i].termOfLoanType == 1){
								_html+="个月";
							}else if(data.results[i].termOfLoanType == 2){
								_html+="年";
							}
						}
						'</div>'+
					'</div>'+
					'<div class="contentOut1">'+
						'<div class="c-content" title="'+data.results[i].repaymentTypeName+'">'+data.results[i].repaymentTypeName+'</div>'+
					'</div>'+
					'<div class="contentOut1">'+
						'<div class="c-content" title="'+data.results[i].sAlsoHasInterest+'">'+data.results[i].sAlsoHasInterest+'</div>'+
					'</div>'+
					'<div class="contentOut1">'+
						'<div class="c-content" title="'+data.results[i].sNoHasInterest+'">'+data.results[i].sNoHasInterest+'</div>'+
					'</div>'+
					'<div class="contentOut2">'+
						'<div class="c-content" title="'+data.results[i].nextRepaymentTime+'">'+data.results[i].nextRepaymentTime+'</div>'+
					'</div>'+
					'<div class="contentOut1">'+
						'<div class="c-content" title="'+data.results[i].sRepaymentAount+'">'+data.results[i].sRepaymentAount+'</div>'+
					'</div>'+
					'<div class="contentOut1">'+
						'<div class="c-content">'+
							'<a href="loanManagement/RM_repayPlan.html">还款计划</a><br>'+
							'<a href="" class="loan-agreement">协议</a><!--跳转未知  -->'+
						'</div>'+
					'</div>'+
				'</li>';
		}
	}else{
		_html+='<li class="data-item noData"><div>暂无数据！</div></li>';
	}
	//赋值
	$(".my-loan-table.repayManagementin").append(_html);
}