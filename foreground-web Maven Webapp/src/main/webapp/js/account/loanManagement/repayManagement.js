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
	
	/*提前还款*/
	/*$('.early-repay').on('click', function(){
		layer.open({
			title :'提前还款',//标题
			skin: 'layer-ext-myskin',//皮肤
	        type: 1,
	        area: ['540px', '500px'],//大小宽*高
	        shadeClose: true, //点击遮罩关闭
	        content: $('.early-repay-content')//内容，里边是包含内容的div的class
	    });
	});*/
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
var noData = '<li class="data-item noData"><div>暂无数据！</div></li>';

function getStayStillPlans(curr,length){
	$.ajax({
		url:"loanManagement/stayStillPlans.html",
		data:{
			"start": curr || 1,		//当前页
			"length":length || 10	//每页条数为预留数据，后台有默认值
		},
		type:"get",
		dataType:"json",
		timeout:10000,
		success:function(data){
			//console.log(data);
			$(".my-loan-table .data-item").remove();
			if(data.results.length > 0){
				creatStayStillPlans(data);//拼接数据
				/*creatStayStillPlans(data);//拼接数据
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
				});*/
				pager.generPageHtml({//调用分页
					pno : data.pageNum,				//当前页
					total : data.totalPage,			//总页码
					totalRecords : data.recordsTotal,		//总数据条数
					mode : 'click',				//默认值是link，可选link或者click
					click : function(n) {
						getStayStillPlans(n,length);
						this.selectPage(n);//点击重复调用
						return false;
					}
				});
			}else{
				$(".my-loan-table.stayStillPlans").append(noData);
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
	//$(".my-loan-table .data-item").remove();
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
							'<div class="repay" data-repalyId="'+data.results[i].lrId+'">还款</div>'+
						'</div>'+
					'</div>'+
				'</li>';
		}
	}else{
		_html+='<li class="data-item noData"><div>暂无数据！</div></li>';
	}
	//赋值
	$(".my-loan-table.stayStillPlans").append(_html);
	//绑定弹窗
	getRepayInfo();
}




//我的账户-借款管理-还款管理：还款中的借款
function getRepayManagementin(curr,length){
	$.ajax({
		url:"loanManagement/repayManagementin.html",
		data:{
			"start": curr || 1,		//当前页
			"length":length || 10	//每页条数为预留数据，后台有默认值
		},
		type:"get",
		dataType:"json",
		timeout:10000,
		success:function(data){
			//console.log(data);
			$(".my-loan-table.repayManagementin .data-item").remove();
			if(data.results.length > 0){
				creatRepayManagementin(data);//拼接数据
				/*creatRepayManagementin(data);//拼接数据
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
				});*/
				pager1.generPageHtml({//调用分页
					pno : data.pageNum,				//当前页
					total : data.totalPage,			//总页码
					totalRecords : data.recordsTotal,		//总数据条数
					mode : 'click',				//默认值是link，可选link或者click
					click : function(n) {
						getRepayManagementin(n,length);
						this.selectPage(n);//点击重复调用
						return false;
					}
				});
			}else{
				$(".my-loan-table.repayManagementin").append(noData);
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
	//$(".my-loan-table.repayManagementin .data-item").remove();
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
						'<div class="c-content ot-a" title="';
						if(data.results[i].lendingTime != null){
							_html+=data.results[i].lendingTime+'">'+data.results[i].lendingTime+'</div>';
						}else{
							_html+='"></div>';
						}
					_html+='</div>'+
					'<div class="contentOut1">'+
						'<div class="c-content ot-a" title="'+data.results[i].sPrincipal+'">'+data.results[i].sPrincipal+'</div>'+
					'</div>'+
					'<div class="contentOut1">'+
						'<div class="c-content ot-a" title="'+data.results[i].sInterestRates+'%">'+data.results[i].sInterestRates+'%</div>'+
					'</div>'+
					'<div class="contentOut1">'+
						'<div class="c-content">'+data.results[i].termOfLoan;
						if(data.results[i].termOfLoanType != null){
							if(data.results[i].termOfLoanType == 0){
								_html+="天";
							}else if(data.results[i].termOfLoanType == 1){
								_html+="个月";
							}else if(data.results[i].termOfLoanType == 2){
								_html+="年";
							}
						}
					_html+='</div>'+
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
						'<div class="c-content" title="';
						if(data.results[i].nextRepaymentTime != null){
							_html+=data.results[i].nextRepaymentTime+'">'+data.results[i].nextRepaymentTime+'</div>';
						}else{
							_html+='"></div>';
						}
					_html+='</div>'+
					'<div class="contentOut1">'+
						'<div class="c-content" title="'+data.results[i].sRepaymentAount+'">'+data.results[i].sRepaymentAount+'</div>'+
					'</div>'+
					'<div class="contentOut1">'+
						'<div class="c-content">'+
							'<a href="loanManagement/RM_repayPlan.html?projectId='+data.results[i].projectId+'">还款计划</a><br>'+
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


//根据还款ID获取正常还款详情,还款
function getRepayInfo(){
	$('.repay').on('click', function(){
		var repalyId = $(this).attr("data-repalyId");//还款计划编号
		if(repalyId == null || repalyId == ""){return;}
		
		//加密
		var url = "loanManagement/ReplayDetail_"+repalyId+".html";
		
		//查询还款详情
		var toRepayFlg = false;
		var userBalance = 0;
		var applyId = null;//申请编号
		$.ajax({
			url:url,
			type:"get",
			dataType:"json",
			timeout:10000,
			success:function(data){
				////console.log(data);
				var unit = "元";//单位
				applyId = data.applyID;
				$("#sLoanAmount").text(Number(data.sLoanAmount).toFixed(2)+unit);
				$("#sLoanInterest").text(Number(data.sLoanInterest).toFixed(2)+unit);
				$("#sOverdueInterest").text(Number(data.sOverdueInterest).toFixed(2)+unit);
				$("#sOberdueFine").text(Number(data.sOberdueFine).toFixed(2)+unit);
				$("#sdReplayTotals").text(Number(data.sdReplayTotals).toFixed(2)+unit);
				$("#userBalances").text(Number(data.userBalances).toFixed(2)+unit);
				userBalance = Number(data.userBalances).toFixed(2);
				$("#sPaidAmount").val(Number(data.sPaidAmount).toFixed(2));
				$("#sPaidInterest").val(Number(data.sPaidInterest).toFixed(2));
				$("#paidSOberdueFine").val(Number(data.paidSOberdueFine).toFixed(2));
				$("#paidSOverdueInterest").val(Number(data.paidSOverdueInterest).toFixed(2));
				$("#paisdReplayTotals").text(Number(data.paisdReplayTotals).toFixed(2)+unit);
				toRepayFlg = true;
			},
			error:function(){
				layer.alert("请求异常，请稍后再试",{icon:2});
			}
		});
		
		layer.open({
			title :'还款',//标题
			skin: 'layer-ext-myskin',//皮肤
	        type: 1,
	        area: ['525px', '670px'],//大小宽*高
	        shadeClose: true, //点击遮罩关闭
	        content: $('.repay-content')//内容，里边是包含内容的div的class
	    });
	    
	    $(".repay-confirm").click(function(){
	    	$(".repay-confirm").attr("disabled",true);//按钮禁用
	    	//判断余额
	    	if(userBalance <= "0.00"){
	    		layer.confirm('账户余额不足，立即前往充值？', {icon: 3, title:'提示'}, function(index){
					window.location.href = "fundManagement/recharge.html";//前往充值
					layer.close(index);
				});
				return;
	    	} 
	    	//判断申请ID
			if(applyId ==null || applyId == ""){
				return;
			} 
			var encrypt = new JSEncrypt();
			encrypt.setPublicKey(publickey);
			alert(encrypt.encrypt(repalyId+""));
			$("#repalyId").val(encrypt.encrypt(repalyId+""));
			$("#applyId").val(encrypt.encrypt(applyId+""));
			document.form1.submit();   
		});
		//
	});
}

//还款中的还款-根据id获取还款计划
function getRepayPlan(curr,length){
	var temp = window.location.href;
	projectId = temp.split("projectId=")[1] || temp.split("a=")[1];
	////console.log(projectId);
	if(projectId == null || isNaN(projectId)){
		return;
	}
	var data = {};//参数
	var encrypt = new JSEncrypt();
	encrypt.setPublicKey(publickey);
	data.applyId = encrypt.encrypt(projectId+"");
	
	if(curr != undefined){
		data.start = curr;
	}
	if(length != undefined){
		data.length = length;		
	}
	var url = "loanManagement/RMrepayPlan.html";
	NetUtil.ajax(
		url,
		data,
		function(r) {
			var data = JSON.parse(r);
			////console.log(data);
			//列表赋值
			$("#repayPlanTop").siblings().remove();
			if(data.results.length > 0){
				var html = template("repayPlanList", data);
				$("#repayPlanUl").append(html);
				
				//绑定根据还款ID获取还款详情,还款
				getRepayInfo();
				
				pager.generPageHtml({
					pno: data.pageNum,			//当前页
					total: data.totalPage,		//总页码
					totalRecords: data.recordsTotal,//总数据条数
					mode: 'click', //默认值是link，可选link或者click
					click: function(n) {
						getRepayPlan(n,length);
						this.selectPage(n);
						return false;
					}
				});
				
			}else{
				//var noData = '<li class="data-item noData">暂无数据</li>';
				$("#repayPlanUl").append(noData);
			}
			
		}
	);
	//
}


//还款中的借款-提前还款
function getEarlyRepayInfo(){
	var data= {};
	var temp = window.location.href;
	var applyId = null;//申请id
	projectId = temp.split("projectId=")[1] || temp.split("a=")[1];
	////console.log(projectId);
	if(projectId == null || isNaN(projectId)){
		return;
	}
	
	
	var encrypt = new JSEncrypt();
	encrypt.setPublicKey(publickey);
	data.applyId = encrypt.encrypt(projectId+"");
	
	var url = "loanManagement/getAdvanceReplay.html";
	
	
	NetUtil.ajax(
		url,
		data,
		function(r){
			var rdb = JSON.parse(r);
			var unit = "元";//单位
			applyId = rdb.applyId;
			$("#repayPrincipals").text(Number(rdb.repayPrincipals).toFixed(2)+unit);
			$("#repayInterests").text(Number(rdb.repayInterests).toFixed(2)+unit);
			$("#penaltyTotals").text(Number(rdb.penaltyTotals).toFixed(2)+unit);
			$("#replayTotals").text(Number(rdb.replayTotals).toFixed(2)+unit);
		}
	);
	
	
	layer.open({
		title :'提前还款',//标题
		skin: 'layer-ext-myskin',//皮肤
        type: 1,
        area: ['540px', '500px'],//大小宽*高
        shadeClose: true, //点击遮罩关闭
        content: $('.early-repay-content')//内容，里边是包含内容的div的class
    });
	
    //提前还款操作
	$(".early-repay-confirm").click(function(){
		$(".early-repay-confirm").attr("disabled",true);//按钮禁用
    	//判断余额
    	/*if(userBalance <= "0.00"){
    		layer.confirm('账户余额不足，立即前往充值？', {icon: 3, title:'提示'}, function(index){
				window.location.href = "fundManagement/recharge.html";//前往充值
				layer.close(index);
			});
			return;
    	}*/
		
		//判断申请ID
		if(applyId ==null || applyId == ""){
			return;
		}
		
    	var url1 = "loanManagement/AdvcancePost_"+applyId+".html";
    	window.location.href = url1;
	});
	//
}