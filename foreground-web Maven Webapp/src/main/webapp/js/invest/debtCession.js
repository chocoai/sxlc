/*伍成然2016-3-28*/
$(function(){
	/*轮播图切换*/
	var slidey = $('.banner').unslider({
		speed: 500,			   
		delay: 3000,			
		complete: function() {}, 
		keys: true,			 
		dots: true,			  
		fluid: true
	});
	data = slidey.data('unslider'); 
	data.move(2, function() {});
	/*search-icon切换*/	
	$(".search").bind({ 
		focus:function(){ 
			$(this).removeClass("show");
		}, 
		blur:function(){ 
			$(this).addClass("show");
		} 
	});
	/*tags切换*/
	$(".tags-list label").click(function(){
		$(this).parent().children().removeClass("active"); 
		$(this).addClass("active");
	});
	/*进度条*/
	$(".progress").each(function(){
		$(this).find(".barline").css("width",$(this).find(".progress_totle").html());
	});
});
