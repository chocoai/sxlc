$(function(){
	$(".TD").addClass("down");
	$(".TD3").addClass("down2");
	/*弹出层伍成然2016-4-6*/
	$('.allowBidBtn').on('click', function(){
		layer.open({
			title :'自动投标设置',//标题
			skin: 'layer-ext-myskin',//皮肤
	        type: 1,
	        area: ['583px', '768px'],//大小宽*高
	        shadeClose: true, //点击遮罩关闭
	        content: $('.autoBidSet')//内容，里边是包含内容的div的class
	    });
	});
	/*radio切换*/
	$(".info label").click(function(){
		$(this).parent().children().removeClass("active"); 
		$(this).addClass("active");
	});
});


/* 胥福星     2016-04-08   弹窗的tips的js代码    */
$(function(){
	$(".input-group input").each(function(){
		$(this).focus(function(){
			$(this).parent().layoutFocus("请输入项目期限");
		});
		$(this).blur(function(){
			$(this).parent().parent().find(".tip").remove();
		});
	});
});