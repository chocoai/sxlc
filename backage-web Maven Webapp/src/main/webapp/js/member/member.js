/* 查看详情页面加载    */

function detailView(){
	$(".right_col").load("web/member/allMembers/memberDetail.jsp");
}
/*  借款查询      */
function loanView(){
	$(".right_col").load("web/member/allMembers/loanView.jsp");
}
/*   投资查询       */
function investView(){
	$(".right_col").load("web/member/allMembers/investView.jsp");
} 
/*   交易记录       */
function transactionRecord(){
	$(".right_col").load("web/member/allMembers/transactionRecord.jsp");
}
/*   查看邀请会员列表          */
function inviteView(){
	$(".right_col").load("web/member/allMembers/inviteView.jsp");
}
/*   银行卡查询          */
function cardView(){
	$(".right_col").load("web/member/allMembers/cardView.jsp");
}
/*   重置密码          */
function resetPWDRecord(){
	$(".right_col").load("web/member/allMembers/resetPWD.jsp");
}
/*   修改邀请会员          */
function inviteVip(){
	$(".right_col").load("web/member/allMembers/inviteVIP-change.jsp");
}
/*   修改邀请会员          */
function messageSendPer(){
	$(".right_col").load("web/member/allMembers/per-messageSend.jsp");
}
/*   提现记录查询          */
function recordQuery(){
	$(".right_col").load("web/member/allMembers/member-recordQuery.jsp");
}
/*   充值记录查询          */
function rechargeRecord(){
	$(".right_col").load("web/member/allMembers/member-rechargeRecord.jsp");
}
/*   充值记录查询          */
function memeberBlackRecord(){
	$(".right_col").load("web/member/allMembers/memberBlackRecord.jsp");
}
/*   查看提交认证信息          */
function perSubmitAuthentication(){
	$(".right_col").load("web/member/allMembers/per-submitAuthentication.jsp");
}
/*   债券转让记录         */
function bondTransforRecord(){
	$(".right_col").load("web/member/allMembers/bondTransforRecord.jsp");
}
/*   分配理财顾问         */
function financialAdvisor(){
	$(".right_col").load("web/member/allMembers/per-financialAdvisor.jsp");
}
/*   变更理财顾问         */
function changeFinancialAdvisor(){
	$(".right_col").load("web/member/allMembers/per-changeFinancialAdvisor.jsp");
}
/*   查询历史理财顾问         */
function inquiryFinancialAdvisor(){
	$(".right_col").load("web/member/allMembers/per-inquiryFinancialAdvisor.jsp");
}


/**
 * 拉黑会员
 */
$(function () {
	var appPath = getRootPath();//项目根路径
	//删除部门
	$(".defriend").on("click touchstart",function(){
		//获得选取的对象
		
		layer.confirm('确定拉黑该会员？', {
		  btn: ['确定', '取消']
		});
	});
});



/* 取消拉黑会员*/
function cancelBlackList(){
	layer.open({
		type: 1,
		area: ['400px', '200px'], //高宽
		title: "取消拉黑会员",
		maxmin: true,
		content: $("#cancelBlackList"),//DOM或内容
		btn:['确定', '取消']
	,yes: function(index, layero){ //或者使用btn1
		//确定的回调
		//判断执行不同方法
		
	},cancel: function(index){//或者使用btn2（concel）
		//取消的回调
	}
	});
}



/* 取消拉黑会员*/
function prohibitedItem(){
	layer.open({
		type: 1,
		area: ['400px', '200px'], //高宽
		title: "取消拉黑会员",
		maxmin: true,
		content: $("#prohibitedItem"),//DOM或内容
		btn:['确定', '取消']
	,yes: function(index, layero){ //或者使用btn1
		//确定的回调
		//判断执行不同方法
		
	},cancel: function(index){//或者使用btn2（concel）
		//取消的回调
	}
	});
}







