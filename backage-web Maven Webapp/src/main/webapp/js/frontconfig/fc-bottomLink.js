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

/* 导航内容添加部分开始 */
function addNavigation(){
	layer.open({
	    type: 1,
	    area: ['450px', '300px'], //高宽
	    title: "导航内容添加",
	    maxmin: true,
	    content: $("#bottomnav-add"),//DOM或内容
	    btn:['确定', '取消']
		  ,yes: function(index, layero){ //或者使用btn1
		    //确定的回调
		  	//判断执行不同方法
		  	
		  },cancel: function(index){//或者使用btn2（concel）
		  	//取消的回调
		  }
	});
}
/* 导航内容添加部分结束 */

/* 导航内容修改部分开始 */
function modNavigation(){
	layer.open({
		type: 1,
		area: ['450px', '300px'], //高宽
		title: "导航内容修改",
		maxmin: true,
		content: $("#bottomnav-mod"),//DOM或内容
		btn:['确定', '取消']
	,yes: function(index, layero){ //或者使用btn1
		//确定的回调
		//判断执行不同方法
		
	},cancel: function(index){//或者使用btn2（concel）
		//取消的回调
	}
	});
}
/* 导航内容修改部分结束 */