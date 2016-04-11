$(function(){
//	项目发布
	$('#post').click(function(){
    	layer.open({
            type: 2,
            title: '发布',
            maxmin: true,
            shadeClose: true, //点击遮罩关闭层
            area : ['900px' , '580px'],
            content: 'web/project/post.jsp'
        });
	});
	
//	拒绝
	$('#refuse').click(function(){
		layer.confirm('你确定要拒绝吗？', {
			  btn: ['确定','取消'] //按钮
			},function(){
				layer.msg('你选择了拒绝');
			});
	});
	
//	查看项目详情
	$('#post_pro_detail').on('click', function(){
    	layer.open({
    		type: 2,
    		title: '项目详情',
    		maxmin: true,
    		shadeClose: true, //点击遮罩关闭层
    		area : ['800px' , '520px'],
    		content: 'web/project/post_pro_detail.jsp'
    	});
    });
	
//	项目借款结束日期延长
	$('#end_time_along').click(function(){
		layer.open({
			type: 1,
			title:'项目借款结束日期延长',
			skin: 'layui-layer-rim', //加上边框
			area: ['500px', '240px'], //宽高
    		content: '<div class="container add_type_contianer">'+
    					'<form class="form-horizontal">'+
    						'<div class="form-group">'+
	    						'<label for="modify_endTime" class="col-sm-4 control-label">项目借款结束日期:</label>'+
	    						'<div class="col-sm-8">'+
	    							'<input type="date" class="form-control" name="modify_endTime" id="modify_endTime" placeholder="填写之前设置的日期">'+
	    						'</div>'+
	    					'</div>'+
	    					'<div class="form-group">'+
	    						'<div class="col-sm-offset-4 col-sm-8">'+
	    							'<button type="submit" class="btn btn-success">确认延长</button>'+
	    						'</div>'+
	    					'</div>'+
    					'</form>'+
    				'</div>'
    	});
	});
	
});
