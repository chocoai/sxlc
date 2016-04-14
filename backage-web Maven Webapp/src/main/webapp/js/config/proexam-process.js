/**
 * 版块：配置中心-----项目审批流程配置----审批流程配置
 * 内容介绍：
 */
$(function(){
	/*添加审批流程*/
	$(".obtn-proexam-process-add").on("click touchstart",function(){
		alert("添加成功");    /*还需要判断选择的是哪个审批点*/
	});
	//上移
	$(".btn-up").on("click touchstart",function(){
		//获取选取对象
		
		layer.confirm('确定上移？', {
			btn: ['确定', '取消']
		}, function(index, layero){
			//按钮【按钮一】的回调
			
			//执行完关闭
			layer.close(index);
		}, function(index){
			//按钮【按钮二】的回调
		});
	});
	/*下移*/
	$(".btn-down").on("click touchstart",function(){
		//获取选取对象
		
		layer.confirm('确定下移？', {
			btn: ['确定', '取消']
		}, function(index, layero){
			//按钮【按钮一】的回调
			
			//执行完关闭
			layer.close(index);
		}, function(index){
			//按钮【按钮二】的回调
		});
	});
	
	//删除
	$(".btn-del").on("click touchstart",function(){
		//获取选取对象
		
		layer.confirm('确定要删除该条记录吗？', {
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










