$(document).ready(function() {
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
});

/* 底部网站认证管理添加部分开始 */
function addAuthentication(title,page,type){
	//参数判断，自己写全
	//console.log(title+","+page+","+type);
	if(title == "" || page == "" || type == ""){
		console.log("参数异常,请检查参数");
		return;
	}
	layer.open({
	    type: 2,
	    area: ['500px', '350px'], //高宽
	    title: title,
	    maxmin: true,
	    content: page,//DOM或内容
	    btn:['确定', '取消']
		  ,yes: function(index, layero){ //或者使用btn1
		    //确定的回调
		  	//判断执行不同方法
		  	
		  },cancel: function(index){//或者使用btn2（concel）
		  	//取消的回调
		  }
	});
}
/* 底部网站认证管理部分结束 */

/* 底部网站认证管理修改部分开始 */
function modAuthentication(title,page,type){
	//参数判断，自己写全
	//console.log(title+","+page+","+type);
	if(title == "" || page == "" || type == ""){
		console.log("参数异常,请检查参数");
		return;
	}
	layer.open({
	    type: 2,
	    area: ['500px', '350px'], //高宽
	    title: title,
	    maxmin: true,
	    content: page,//DOM或内容
	    btn:['确定', '取消']
		  ,yes: function(index, layero){ //或者使用btn1
		    //确定的回调
		  	//判断执行不同方法
		  	
		  },cancel: function(index){//或者使用btn2（concel）
		  	//取消的回调
		  }
	});
}
/* 底部网站认证管理修改部分结束 */