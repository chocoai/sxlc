
/**��***************项目管理列表查询*******************  **/
$(document).ready(function() {
    /*** *************状态改变功能״̬********* ***/
	//启用停用
	$(".btn-enable").on("click touchstart",function(){
		//获取选取对象
		
		layer.confirm('确定启用？', {
			btn: ['确定', '取消']
		}, function(index, layero){
			//按钮【按钮一】的回调
			
			//执行完关闭
			layer.close(index);
		}, function(index){
			//按钮【按钮二】的回调
		});
	});

	$(".btn-disable").on("click touchstart",function(){
		//获取选取对象
		
		layer.confirm('确定停用？', {
			btn: ['确定', '取消']
		}, function(index, layero){
			//按钮【按钮一】的回调
			
			//执行完关闭
			layer.close(index);
		}, function(index){
			//按钮【按钮二】的回调
		});
	});
    /******************添加产品类型**********************/
    $('#add_type').on('click', function(){
    	layer.open({
    		type: 2,
    		title: '添加产品类型',
    		maxmin: true,
    		shadeClose: true, //点击遮罩关闭层
    		area : ['940px' , '520px'],
    		content: 'web/project/add_type.jsp'
    	});
    });
    /** *************修改产品类型************** **/
    $('#modify_type').on('click', function(){
    	layer.open({
    		type: 2,
    		title: '修改产品类型',
    		maxmin: true,
    		shadeClose: true, //点击遮罩关闭层
    		area : ['940px' , '520px'],
    		content: 'web/project/modify_type.jsp'
    	});
    });
    /***********简介的显示和隐藏*************/
    
    $(".introduce").each(function(index){
    	var intro=$(this).text();    //回去项目类型简介描述内容
    	if(intro.length>8){        //当内容长度大于8时隐藏详细信息，其中参数可以修改
    		$(this).text(intro.substring(0,2));
    		$(this).hover(function(e){
    			$(".all").show().html(intro);   //将类型简介赋值到隐藏div
    			var y = e.clientY-20;
    			var x = e.clientX -212;
    			$(".all").css({position:'absolute',top:y+"px",left:x+"px"});
    		},function(){
    			$(".all").hide();
    		});
    	}
    	else{
    		$(this).text(intro);
    	}
    });
});