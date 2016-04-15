$(function(){
	$(".TE").addClass("down");
	$(".TE1").addClass("down2");
	/*弹出层*/	
	/*待确认——查看详情*/
	$('.viewDetails').on('click', function(){
		layer.open({
			title :'项目基本信息',//标题
			skin: 'layer-ext-myskin',//皮肤
	        type: 1,
	        area: ['440px', '580px'],//大小宽*高
	        shadeClose: true, //点击遮罩关闭
	        content: $('.view-details')//内容，里边是包含内容的div的class
	    });
	});
	/*待确认——发布待确认，提交审核待确认*/
	$('.toConfirm').on('click', function(){
		layer.open({
			title :'项目基本信息',//标题
			skin: 'layer-ext-myskin',//皮肤
	        type: 1,
	        area: ['440px', '620px'],//大小宽*高
	        shadeClose: true, //点击遮罩关闭
	        content: $('.to-confirm')//内容，里边是包含内容的div的class
	    });
	});
	/*借款记录-融资中-投资记录*/
	$('.invRecord').on('click', function(){
		layer.open({
			title :'查看投资记录',//标题
			skin: 'layer-ext-myskin',//皮肤
	        type: 1,
	        area: ['645px', '470px'],//大小宽*高
	        shadeClose: true, //点击遮罩关闭
	        content: $('.inv-record')//内容，里边是包含内容的div的class
	    });
	});
	/*借款记录-融资中-投资记录*/
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