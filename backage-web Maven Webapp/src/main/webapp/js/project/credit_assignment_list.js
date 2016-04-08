$(function(){
	//	审核
	$('#credit_assignment_exam').click(function(){
		
	});
	
//	投标结束时间延长
	$('#credit_assignment_end_timealong').click(function(){
		layer.open({
			type: 1,
			title:'投标结束时间延长',
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
