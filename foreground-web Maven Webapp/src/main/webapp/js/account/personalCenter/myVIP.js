$(function(){
	$(".TB").addClass("down");
	$(".TB4").addClass("down2");
	$(".buy-VIP").click(function(){
		layer.open({
			title :'购买VIP',//标题
			skin: 'layer-ext-myskin',//皮肤
	        type: 1,
	        area: ['488px', '441px'],//大小宽*高
	        shadeClose: true, //点击遮罩关闭
	        content: $('.buyVip')//内容，里边是包含内容的div的class
	    });
	});
});