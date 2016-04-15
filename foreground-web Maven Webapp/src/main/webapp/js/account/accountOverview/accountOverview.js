$(function(){
	$(".TA").addClass("down");
	/*账户总资产部分开始*/
	/*label背景切换部分开始*/
	$(".accountOverviewM label").mouseover(function(){
		$(this).removeClass("tipOrigin").addClass("tipChange");
	});
	$(".accountOverviewM label").mouseout(function(){
		$(this).addClass("tipOrigin").removeClass("tipChange");
	});
	/*label背景切换部分结束*/
	$(".planMSecond").hide();
	$(".planHCont>div").each(function(i){
		$(this).click(function(){
			$(this).addClass("active").siblings("div").removeClass("active");
			$(".planM").eq(i).show().siblings(".planM").hide();
		});
		$(".more").click(function(){
			if($(".payment").hasClass("active")){
				window.location = "myInvestment.html";
			}else if($(".repayment").hasClass("active")){
				window.location = "repayPlan.html";
			}
		});
	});
	/*账户总资产部分结束*/
	/* 资金动态开始  */
	var count = 0;
	$(".capitalDynamicsM li").each(function(){
		$(this).find(".DynamicsMLBottom").css("height",$(this).find(".capitalDynamicsMR").height()+40);
		$(this).find(".triangleTip").addClass((count % 2 == 0 )?"triangleHyacinth":"triangleBlue");
		count++;
	});
	/* 资金动态结束  */
});

