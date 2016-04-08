$(function(){
	//查看站内信历史记录
	$('.obtn-msgc-record').on('click', function(){
	    layer.open({
	        type: 2,
	        title: '站内信历史记录',
	        maxmin: true,
	        shadeClose: true, //点击遮罩关闭层
	        area : ['980px' , '620px'],
	        content: 'web/config/msgc-record.jsp'
	    });
	});
	//查看短信发送历史记录
	$('.obtn-msgp-record').on('click', function(){
		layer.open({
			type: 2,
			title: '站内信历史记录',
			maxmin: true,
			shadeClose: true, //点击遮罩关闭层
			area : ['980px' , '620px'],
			content: 'web/config/msgp-record.jsp'
		});
	});
	//查看邮件发送历史记录
	$('.obtn-msge-record').on('click', function(){
		layer.open({
			type: 2,
			title: '站内信历史记录',
			maxmin: true,
			shadeClose: true, //点击遮罩关闭层
			area : ['980px' , '620px'],
			content: 'web/config/msge-record.jsp'
		});
	});
});