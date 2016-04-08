/*计算本页面的高度*/
function tabelFixWindow(){
	var big = $('.right_col').height();
	var small = $('.memberselect_a').outerHeight(true);
	var aimHeight =  big - small;
	$(".tScroll").css("height",aimHeight + "px");    
}
window.onresize = function(){tabelFixWindow();};
$(function(){
    tabelFixWindow();
    $(".memberRest").click(function(){
    	$(".memberPwd").toggle();
    });
});

$(function(){
	/*查看会员详情*/
	$(".viewMembershipDetails").click(function(){
		layer.open({
			area: ['60%', '80%'],
			/*skin: 'layui-layer-rim', //���ϱ߿�       */	
			title: '查看会员详情', 
			/*maxmin: true,  //�����ķŴ���С*/
		    type:1,
		    content: $(".membershipDetails")//DOM;
		   /* style:'position:fiex;left:0;top:1000px;width:100%;height:100%;border:none;background-color:#F05133; text-align:center;'*/
		});
	});
	
	/*借款项目查询*/
	$(".loanItemQueryCunt").click(function(){
		layer.open({
			area: ['80%', '80%'],
			title: '借款项目查询', 
		    type:1,
		    content: $(".loanItemQuery")//DOM;
		});
	});
	
	/*投资项目查询*/
	$(".nvestmentProjectInquiryCunt").click(function(){
		layer.open({
			area: ['80%', '80%'],
			title: '投资项目查询', 
		    type:1,
		    content: $(".nvestmentProjectInquiry")//DOM;
		});
	});
	
	/*交易记录*/
	$(".transactionRecordCunt").click(function(){
		layer.open({
			area: ['60%', '60%'],
			title: '交易记录', 
		    type:1,
		    content: $(".transactionRecord")//DOM;
		});
	});
	
	/*银行卡查询*/
	$(".bankCardInquiryCunt").click(function(){
		layer.open({
			area: ['80%', '80%'],
			title: '银行卡查询', 
		    type:1,
		    content: $(".bankCardInquiry")//DOM;
		});
	});
	
	/*查看邀请会员记录*/
	$(".inviteMembersCunt").click(function(){
		layer.open({
			area: ['80%', '80%'],
			title: '银行卡查询', 
		    type:1,
		    content: $(".inviteMembers")//DOM;
		});
	});
	
	/*拉黑*/
	$(".pullTheBlackCunt").click(function(){
		layer.open({
			area: ['80%', '80%'],
			title: '拉黑', 
		    type:1,
		    content: $(".pullTheBlack")//DOM;
		});
	});
	
	/*会员密码重置*/
	$(".memberPasswordResetCunt").click(function(){
		layer.open({
			area: ['80%', '80%'],
			title: '会员密码重置', 
		    type:1,
		    content: $(".memberPasswordReset")//DOM;
		});
	});
	
	/*修改邀请会员*/
	$(".modifyInviteMemberCunt").click(function(){
		layer.open({
			area: ['80%', '80%'],
			title: '修改邀请会员', 
		    type:1,
		    content: $(".modifyInviteMember")//DOM;
		});
	});
	
	/*发送消息*/
	$(".sendMessageCunt").click(function(){
		layer.open({
			area: ['40%', '100%'],
			title: '发送消息', 
		    type:1,
		    content: $(".sendMessage")//DOM;
		});
	});
	
	/*查看认证提交消息*/
	$(".checkAuthenticationInformationCu").click(function(){ 
		layer.open({
			area: ['80%', '80%'],
			title: '查看认证提交消息', 
		    type:1,
		    content: $(".checkAuthenticationInformation")//DOM;
		});
	});
	
	/*提现记录查询*/
	$(".queryRecordQueryCunt").click(function(){
		layer.open({
			area: ['80%', '80%'],
			title: '提现记录查询', 
		    type:1,
		    content: $(".queryRecordQuery")//DOM;
		});
	});
	
	/*充值记录*/
	$(".rechargeRecordCunt").click(function(){
		layer.open({
			area: ['80%', '80%'],
			title: '充值记录', 
		    type:1,
		    content: $(".rechargeRecord")//DOM;
		});
	});
	
	/*投资会员*/
	$(".assignmentRecordCunt").click(function(){
		layer.open({
			area: ['80%', '80%'],
			title: '投资会员', 
		    type:1,
		    content: $(".assignmentRecord")//DOM;
		});
	});
	
	/*会员黑名单*/
	$(".pullBlackRecord").click(function(){
		layer.open({
			area: ['80%', '80%'],
			title: '会员黑名单', 
		    type:1,
		    content: $(".pullBlackRecordToggle")//DOM;
		});
	});
	
	/*资料认证*/
	$(".memberCertificationDetailsCunt").click(function(){
		layer.open({
			area: ['80%', '80%'],
			title: '资料认证', 
		    type:1,
		    content: $(".memberCertificationDetails")//DOM;
		});
	});
	
	/*查询历史理财顾问变更记录*/
	$(".queryHistoryAdvisorCunt").click(function(){
		layer.open({
			area: ['80%', '80%'],
			title: '资料认证', 
		    type:1,
		    content: $(".queryHistoryAdvisor")//DOM;
		});
	});
	
	/*变更理财顾问*/
	$(".changeFinancialAdvisorCunt").click(function(){
		layer.open({
			area: ['80%', '80%'],
			title: '变更理财顾问', 
		    type:1,
		    content: $(".changeFinancialAdvisor_a")//DOM;
		});
	});
	
	/*取消拉黑*/
	$(".cancelPullBlackCunt").click(function(){
		layer.open({
			area: ['80%', '80%'],
			title: '取消拉黑', 
		    type:1,
		    content: $(".cancelPullBlack")//DOM;
		});
	});
	
	/*黑名单会员受限设置*/
	$(".blacklistRestrictionCunt").click(function(){
		layer.open({
			area: ['80%', '80%'],
			title: '黑名单会员受限设置', 
		    type:1,
		    content: $(".blacklistRestriction")//DOM;
		});
	});
});

/*会员管理弹出层*/
$(document).ready(function() {
    /*$('#memberSelect').dataTable();
    $('#membershipDetails').dataTable({
	  "paging":   false,
	    "ordering": false,
	    "info":     false
    });
    $('#loanItemQuery').dataTable({
  	  "paging":   false,
	    "ordering": false,
	    "info":     false
    });
    $("#nvestmentProjectInquiry").dataTable({
  	  "paging":   false,
	    "ordering": false,
	    "info":     false
    });
    $("#transactionRecord").dataTable({
  	  "paging":   false,
	    "ordering": false,
	    "info":     false
    });
    $('#bankCardInquiry').dataTable({
  	  "paging":   false,
	    "ordering": false,
	    "info":     false
    });
    $("#inviteMembers").dataTable({
  	  "paging":   false,
	    "ordering": false,
	    "info":     false
    });
    $("#pullTheBlack").dataTable({
  	  "paging":   false,
	    "ordering": false,
	    "info":     false
    });
    $('#memberPasswordReset').dataTable({
  	  "paging":   false,
	    "ordering": false,
	    "info":     false
    });
    $("#modifyInviteMember").dataTable({
  	  "paging":   false,
	    "ordering": false,
	    "info":     false
    });
    $("#sendMessage").dataTable({
  	  "paging":   false,
	    "ordering": false,
	    "info":     false
    });*/
    
});

$(function(){
	/*李丽梅*/
	/*会员管理-全部会员*/
	/*2016-03-24*/
	$(".allMembersCu").click(function(){
		window.location.href="web/member/member.jsp" ;
	});
	

	/*李丽梅*/
	/*会员管理-VIP会员*/
	/*2016-03-24*/
	$(".membersVipCu").click(function(){
		window.location.href="web/member/membersVip.jsp" ;
	});
	
	/*李丽梅*/
	/*会员管理-注册会员*/
	/*2016-03-24*/
	$(".registeredMemberCu").click(function(){
		window.location.href="web/member/registeredMember.jsp" ;
	});
	
	/*李丽梅*/
	/*会员管理-认证会员*/
	/*2016-03-25*/
	$(".authenticationInformation").click(function(){
		window.location.href="web/member/certifiedMember.jsp" ;
	});
	

	/*李丽梅*/
	/*会员管理-借款会员*/
	/*2016-03-25*/
	$(".loanMemberCu").click(function(){
		window.location.href="web/member/loanMember.jsp" ;
	});
	
	/*李丽梅*/
	/*会员管理-投资会员*/
	/*2016-03-*/
	$(".investmentMemberCu").click(function(){
		window.location.href="web/member/investmentMember.jsp" ;
	});
	
	
	
	$(".compositeMemberCu").click(function(){
		window.location.href="web/member/compositeMember.jsp" ;
	});
	
	
	/*会员管理*/
	/*个人会员-会员黑名单*/
	/*2016-03-28*/
	$(".memberBlackListCu").click(function(){
		window.location.href="web/member/memberBlackList.jsp" ;
	});
	
	/*会员管理*/
	/*个人会员-资料认证*/
	/*2016-03-28*/
	$(".dataAuthenticationCu").click(function(){
		window.location.href="web/member/dataAuthentication.jsp" ;
	});
	
	/*会员管理*/
	/*个人会员-会员分配理财顾问*/
	/*2016-03-28*/
	$(".memberFinancialAdvisorCu").click(function(){
		window.location.href="web/member/memberFinancialAdvisor.jsp" ;
	});
	
	/*会员管理*/
	/*个人会员-理财顾问变更*/
	/*2016-03-28*/
	$(".changeOfFinancialAdvisorCu").click(function(){
		window.location.href="web/member/changeOfFinancialAdvisor.jsp" ;
	});
});

$(function(){

});

$(function(){
	var clickValue;
	function memberPersonalInformation(){
		$(this).click(function(){
			clickValue = $(this).html();
		});
		$("membershipEncoding").click(function(){
			//alert(clickValue);
		});
	}
});