$(function(){
	$(".TE").addClass("down");
	$(".TE3").addClass("down2");
	$(".my-repay-tab li").each(function(index){
		var liNode =$(this);
		$(this).click(function(){
			$(".tab-content .my-repay-content").removeClass("active");
			$(".my-repay-tab .tab-li").removeClass("tab-ing");
			$(".tab-content .my-repay-content").eq(index).addClass("active");
			liNode.addClass("tab-ing");
		});
	});
	/*伍成然2016-4-6*/
	/*还款管理-待还计划-还款*/
	/*弹出层*/
	$('.repay').on('click', function(){
		layer.open({
			title :'还款',//标题
			skin: 'layer-ext-myskin',//皮肤
	        type: 1,
	        area: ['525px', '670px'],//大小宽*高
	        shadeClose: true, //点击遮罩关闭
	        content: $('.repay-content')//内容，里边是包含内容的div的class
	    });
	});
	/*提前还款*/
	$('.early-repay').on('click', function(){
		layer.open({
			title :'提前还款',//标题
			skin: 'layer-ext-myskin',//皮肤
	        type: 1,
	        area: ['540px', '500px'],//大小宽*高
	        shadeClose: true, //点击遮罩关闭
	        content: $('.early-repay-content')//内容，里边是包含内容的div的class
	    });
	});
});




$(function(){
	$(".numberReg").each(function(){
		$(this).focus(function(){
			$(this).keyup(function(){
				if(this.value.length > 0){
					this.value = this.value.replace(/[^0-9.]/g,'');
				}
			});
		});
	});
});