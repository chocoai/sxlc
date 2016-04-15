$(function() {
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
	$(".productDetail").each(function(){
		$(this).mouseover(function(){
			if($(this).find(".sellOutHide").length > 0){
				$(this).find(".detailProduct").hide();
				$(this).find(".flowTop").show();
			}
		}).mouseout(function(){
			$(this).find(".detailProduct").show();
			$(this).find(".flowTop").hide();
		});
	});
});