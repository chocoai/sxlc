$(function(){
	$(".TB").addClass("down");
	$(".TB9").addClass("down2");
	/*站内消息部分开始 王延君 2016-04-02*/
	/*列表内容部分开始*/
	$(".readUl").hide();
	$(".unRead").css("color","#45a7e6").siblings().css("color","#000");
	$(".unRead").css("border-bottom","2px solid #45a7e6").siblings().css("border-bottom","0");
	$(".stationMessageH>div").click(function(){
		var index=$(this).index();
		$(this).css("color","#45a7e6").siblings().css("color","#000");
		$(this).css("border-bottom","2px solid #45a7e6").siblings().css("border-bottom","0");
		$(".stationMessageM ul").eq(index).show().siblings("ul").hide();
	});
	$(".contentInfo").hide();
	$("li .contentMessage").each(function(){
		$(this).click(function(){
			if($(this).parent().find(".contentInfo").is(":hidden")){
				$(this).find(".messageContent").css("color","#87412C");
				$(this).parent().find(".contentInfo").slideDown();
				$(this).parent().parent().siblings("li").each(function(){
					$(this).find(".contentInfo").slideUp();
				});
			}else{
				$(this).parent().find(".contentInfo").slideUp();
		    }
		});
	});
	/*列表内容部分结束*/
	/*站内消息部分结束 王延君 2016-04-02*/
});
