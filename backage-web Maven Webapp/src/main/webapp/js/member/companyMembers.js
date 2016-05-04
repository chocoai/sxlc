/* 查看详情页面加载    */

function companyDetailView(){
	$(".right_col").load("web/member/allMembers/companyMembersDetail.jsp");
}




/*   提现记录查询          */
function companyRecordQuery(){
	$(".right_col").load("web/member/allMembers/companyRecordQuery.jsp");
}
/*   充值记录查询          */
function companyRechargeRecord(){
	$(".right_col").load("web/member/allMembers/companyRechargeRecord.jsp");
}
/*   黑名单查询          */
function memeberBlackRecord(){
	$(".right_col").load("web/member/allMembers/memberBlackRecord.jsp");
}
/*   查看提交认证信息          */
function companySubmitAuthen(){
	$(".right_col").load("web/member/allMembers/companySubmitAuthen.jsp");
}
/*   债券转让记录         */
function companyBTRecord(){
	$(".right_col").load("web/member/allMembers/companyBTRecord.jsp");
}
/*   分配理财顾问         */
function comFinancialAdvisor(){
	$(".right_col").load("web/member/allMembers/company-FinancialAdvisor.jsp");
}
/*   变更理财顾问         */
function changeFinAdvisorCom(){
	$(".right_col").load("web/member/allMembers/changeFinAdvisorCom.jsp");
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
	//拉黑会员
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


/*  发送信息弹出框            */
/**
 * 发送信息弹出框
 */
function messageSendCompany(title,page,type){
	//参数判断，自己写全
	//console.log(title+","+page+","+type);
	
	if(title == "" || page == "" || type == "" ){
		console.log("参数异常,请检查参数");
		return;
	}
	layer.open({
	    type: 2,
	    area: ['600px', '400px'], //高宽
	    title: title,
	    maxmin: true,
	    content: page,//DOM或内容
	    btn:  ['发送','取消']
			,yes: function(index, layero){ //或者使用btn1
				//确定的回调
				//判断执行不同方法
				
			},cancel: function(index){//或者使用btn2（concel）
				//取消的回调
			}
	});
};


/* 禁止黑名单权限*/
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







