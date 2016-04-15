
/* input标签的输入改变  20160410  胥福星    */
$(function(){
	$(".aboutUsNav input").each(function(){
	/*	$(this).click(function(){
			if($(this).parent().find(".selectChose").is(":hidden")){
				$(this).parent().find(".selectChose").slideDown(200);
			}else{
				$(this).parent().find(".selectChose").slideUp(200);
			}
		});*/
		$(this).focus(function(){
			$(this).parent().find(".selectChose").slideDown(200);
		});
		$(this).blur(function(){
			$(this).parent().find(".selectChose").slideUp(200);
		});
	});
});