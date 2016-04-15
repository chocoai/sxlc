$(function(){
	$(".choose8").attr("selected","selected");//Ĭ��ѡ����ʽ ���� 20160327
	/*流程切换部分开始 王延君 2016-03-30*/
	$(".procedureLoan").css("color","#72c0f3");
	$(".procedureLoan").click(function(){
		$(".procedureLoan").css("color","#72c0f3").siblings().css("color","#000");
		$(".procedureLoanImg").show().siblings().hide();
	});
	$(".procedureInvest").click(function(){
		$(".procedureInvest").css("color","#72c0f3").siblings().css("color","#000");
		$(".procedureInvestImg").show().siblings().hide();
	});
	/*流程切换部分结束 王延君 2016-03-30*/
});

