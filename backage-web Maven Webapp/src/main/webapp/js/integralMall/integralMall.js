function bankManagementAdd(title,page,type){
	if(title == "" || page == "" || type == "" ){
		return;
	}
	layer.open({
	    type: 2,
	    area: ['500px', '460px'], 
	    title: title,
	    maxmin: true,
	    content: page,
	    btn:['确认', '取消']
		  ,yes: function(index, layero){ 
		  	
		  },cancel: function(index){
		  }
	});
	
	
}


function bankManagementMod(title,page,type,id){
	if(title == "" || page == "" || type == "" || id == "" ){
		return;
	}
	layer.open({
	    type: 2,
	    area: ['500px', '460px'], 
	    title: title,
	    maxmin: true,
	    content: page,
	    btn:['确认', '取消']
		  ,yes: function(index, layero){ 
		  	
		  },cancel: function(index){
		  }
	});
	
	
}
//启用
$(function () {
	var appPath = getRootPath();//项目根路径
	//删除部门
	$(".btn-qiyong").on("click touchstart",function(){
		//获得选取的对象
		
		layer.confirm('确定启用该商品？', {
		  btn: ['确定', '取消']
		});
	});
});
//停用
$(function () {
	var appPath = getRootPath();//项目根路径
	//删除部门
	$(".btn-ting").on("click touchstart",function(){
		//获得选取的对象
		
		layer.confirm('确定停用该商品？', {
		  btn: ['确定', '取消']
		});
	});
});

//查询按钮
/**
 * 查询按钮
 */
$(".glyphicon-search").on("click",function(){
	$('#table_id').DataTable().ajax.reload();
	
});
