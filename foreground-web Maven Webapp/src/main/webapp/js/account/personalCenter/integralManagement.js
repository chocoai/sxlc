$(function(){
	$(".TB").addClass("down");
	$(".TB5").addClass("down2");
	$(".tab-head li").each(function(index){
		var liNode =$(this);
		$(this).click(function(){
			$(".tab-content .content").removeClass("content-active");
			$(".tab-head li").removeClass("tab-ing");
			$(".tab-content .content").eq(index).addClass("content-active");
			liNode.addClass("tab-ing");
		});
	});
});