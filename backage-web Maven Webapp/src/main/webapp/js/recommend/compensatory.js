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
/* 代偿开始  */
function compenFunction(){
	layer.open({
		type: 1,
		area: ['500px', '300px'], //高宽
		title: "代偿",
		maxmin: true,
		content: $("#compenfunction"),//DOM或内容
		btn:['确定','返回'],
		yes: function(index, layero){ //或者使用btn1
		//确定的回调
		//判断执行不同方法
		
	},cancel: function(index){//或者使用btn2（concel）
		//取消的回调
	}
	});
}
/* 代偿结束  */