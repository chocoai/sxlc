//积分商城-商品列表
$(function(){
	$(".filterLi li").click(function(){
		$(this).children("span").addClass("selected");
		$(this).siblings().children("span").removeClass("selected");
	});
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


//function

//获取商品列表
function getGoodsList(){
		
}