$(function(){
	$(".TD").addClass("down");
	$(".TD1").addClass("down2");
	/*切换背景图部分开始 王延君 2016-04-01*/
	$(".myInvestmentMTitle div em").on("click",function(){
		if($(this).hasClass("iconDown")){
			$(this).removeClass("iconDown").addClass("iconUp");
		}else{
			$(this).removeClass("iconUp").addClass("iconDown");
		}
	});
	/*切换背景图部分结束 王延君 2016-04-01*/
	/*切换显示部分开始*/
	$(".recycle").css("color","#45a7e6");
	$(".recycle").css("border-bottom","2px solid #45a7e6");
	$(".myInvestmentH div").click(function(){
		var index=$(this).index();
		$(this).css("color","#45a7e6").siblings().css("color","#000");
		$(this).css("border-bottom","2px solid #45a7e6").siblings().css("border-bottom","none");
		$(".myInvestmentM ul").eq(index).show().siblings("ul").hide();
	});
	
	/*切换显示部分结束*/
});
