/**
 */
$(".glyphicon-search").on("click",function(){
	$('#table_id').DataTable().ajax.reload();
	
});
function bankManagementAdd(title,page,type){
	if(title == "" || page == "" || type == "" ){
		return;
	}
	layer.open({
	    type: 2,
	    area: ['500px', '720px'], 
	    title: title,
	    maxmin: true,
	    content: page,
	    btn:['确定', '取消']
		  ,yes: function(index, layero){ 
		  	
		  },cancel: function(index){
		  }
	});
}

function bankManagementXdd(title,page,type){
	if(title == "" || page == "" || type == "" ){
		return;
	}
	layer.open({
	    type: 2,
	    area: ['500px', '720px'], 
	    title: title,
	    maxmin: true,
	    content: page,
	    btn:['确定', '取消']
		  ,yes: function(index, layero){ 
		  	
		  },cancel: function(index){
		  }
	});
}
function bankManagementRdd(title,page,type){
	if(title == "" || page == "" || type == "" ){
		return;
	}
	layer.open({
	    type: 2,
	    area: ['500px', '220px'], 
	    title: title,
	    maxmin: true,
	    content: page,
	    btn:['确定', '取消']
		  ,yes: function(index, layero){ 
		  	
		  },cancel: function(index){
		  }
	});
}
function bankManagementKdd(title,page,type){
	if(title == "" || page == "" || type == "" ){
		return;
	}
	layer.open({
	    type: 2,
	    area: ['500px', '150px'], 
	    title: title,
	    maxmin: true,
	    content: page,
	    btn:['确定', '取消']
		  ,yes: function(index, layero){ 
		  	
		  },cancel: function(index){
		  }
	});
}
function bankManagementVdd(title,page,type){
	if(title == "" || page == "" || type == "" ){
		return;
	}
	layer.open({
	    type: 2,
	    area: ['500px', '150px'], 
	    title: title,
	    maxmin: true,
	    content: page,
	    btn:['确定', '取消']
		  ,yes: function(index, layero){ 
		  	
		  },cancel: function(index){
		  }
	});
}
//上架
$(function () {
	var appPath = getRootPath();//项目根路径
	//删除部门
	$(".obtn-export1").on("click touchstart",function(){
		//获得选取的对象
		
		layer.confirm('确定上架该商品？', {
		  btn: ['确定', '取消']
		});
	});
});
//下架
$(function () {
	var appPath = getRootPath();//项目根路径
	//删除部门
	$(".obtn-export2").on("click touchstart",function(){
		//获得选取的对象
		
		layer.confirm('确定下架该商品？', {
		  btn: ['确定', '取消']
		});
	});
});
//推荐到商城首页
$(function () {
	var appPath = getRootPath();//项目根路径
	//删除部门
	$(".obtn-export3").on("click touchstart",function(){
		//获得选取的对象
		
		layer.confirm('确定推荐该商品到商城首页？', {
		  btn: ['确定', '取消']
		});
	});
});
//查看入库记录
