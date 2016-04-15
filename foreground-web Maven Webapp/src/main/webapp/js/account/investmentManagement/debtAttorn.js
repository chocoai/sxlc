$(function(){
	$(".TD").addClass("down");
	$(".TD4").addClass("down2");
	/*切换显示部分开始 王延君 2016-04-01*/
	$(".inTransfer").css("color","#72c0f3");
	$(".inTransfer").css("border-bottom","2px solid #72c0f3");
	$(".debtAttornH div").click(function(){
		var index=$(this).index();
		$(this).css("color","#72c0f3").siblings().css("color","#000");
		$(this).css("border-bottom","2px solid #72c0f3").siblings().css("border-bottom","none");
		$(".debtAttornM ul").eq(index).show().siblings("ul").hide();
	});
	/*切换显示部分结束 王延君 2016-04-01*/
	/*分页部分结束*/
	/*伍成然弹出层2016-4-6*/
	$('.attornBtn').on('click', function(){
		layer.open({
			title :'转让',//标题
			skin: 'layer-ext-myskin',//皮肤
	        type: 1,
	        area: ['541px', '499px'],//大小宽*高
	        shadeClose: true, //点击遮罩关闭
	        content: $('.layerWindow')//内容，里边是包含内容的div的class
	    });
	});
});
