
/**��***************项目管理列表查询*******************  **/
$(document).ready(function() {
    /*** *************状态改变功能״̬********* ***/
    $(function(){
    	$("#modify_state").click(function(){
    		/*var text=$(".current_state").text();
    		if(text=="已启用"){
    			layer.confirm('你确定要停用吗？', {
    				title:'状态',
    				btn: ['确定','取消'] //按钮
    			}, function(){
    				layer.msg('已停用', {icon: 1});
    				$(".current_state").text("已停用");
    			});
    		}
    		else{
    			layer.confirm('你确定要启用吗？', {
    				btn: ['确定','取消'] //按钮
    			}, function(){
    				layer.msg('已启用', {icon: 1});
    				$(".current_state").text("已启用");
    			});
    		}*/
    	});
    });
    
    
    /******************添加产品类型**********************/
    $('#add_type').on('click', function(){
    	layer.open({
    		type: 2,
    		title: '添加产品类型',
    		maxmin: true,
    		shadeClose: true, //点击遮罩关闭层
    		area : ['980px' , '620px'],
    		content: 'web/project/add_type.jsp'
    	});
    });
    /*$("input[name='type_name']").focus(function(){
	layer.tips('请输入类型名称','#type_name',{
		tips:[1,'#456']
	});
});*/
    
    /** *************修改产品类型************** **/
    $('#modify_type').on('click', function(){
    	layer.open({
    		type: 2,
    		title: '修改产品类型',
    		maxmin: true,
    		shadeClose: true, //点击遮罩关闭层
    		area : ['980px' , '620px'],
    		content: 'web/project/modify_type.jsp'
    	});
    });
});