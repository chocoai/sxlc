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
	
	getNewbieGuide();
});


//获取新手指南
function getNewbieGuide(){
	$.ajax({
    	url:"aboutUs/newHand.html",
    	type:"get",
    	timeout:10000,
    	dataType:"json",
    	success:function(data){
    		if(data.content){
	    		$(".guideContent").append(data.content);
    		}else{
    			var noData = '<div class="noData">暂无数据</div>';
	    		$(".guideContent").append(noData);
    		}
    	},
    	error:function(XMLHttpRequest, textStatus, errorThrown){
        	layer.alert("请求异常，请稍后再试",{icon:2});
		}
    });
}

