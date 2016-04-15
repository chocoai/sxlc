/*折叠显示部分开始 王延君2016-03-29*/
	$(".glyphicon").addClass("glyphicon-chevron-right");
	$(function(){
		$(".contentMiddleH").each(function(){
			$(this).click(function(){
				if($(this).children("span").children("i").hasClass('glyphicon-chevron-right')){
					$(this).parent().children(".job_middle_main").slideDown();
					$(this).children("span").children("i").removeClass("glyphicon-chevron-right").addClass("glyphicon-chevron-down");
					$(this).children("h4").css("color","#72c0f3");
				}else{
					$(this).parent().children(".job_middle_main").slideUp();
					$(this).children("span").children("i").removeClass("glyphicon-chevron-down").addClass("glyphicon-chevron-right");
					$(this).children("h4").css("color","#868686");
				}
			});
		});
	});
	/*折叠显示部分结束 王延君2016-03-29*/