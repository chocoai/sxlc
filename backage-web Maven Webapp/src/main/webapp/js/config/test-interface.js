/**
 * 版块：配置中心-----托管平台配置
 * 内容介绍：
 */
$(function(){
	/*添加接口配置*/
	$(".obtn-test-inter-add").on("click touchstart",function(){
		layer.open({
			type: 1,
			area: ['565px', '260px'], //高宽
			title: "添加接口配置",
			content: $(".test-inter-add"),//DOM或内容
			btn:['确定', '取消']
		,yes: function(index, layero){ //或者使用btn1
			//确定的回调
			
		},cancel: function(index){//或者使用btn2（concel）
			//取消的回调
		}
		});
	});
	/*修改接口配置*/
	$(".obtn-test-inter-modify").on("click touchstart",function(){
		layer.open({
		    type: 1,
		    area: ['565px', '260px'], //高宽
		    title: "修改接口配置",
		    content: $(".test-inter-modify"),//DOM或内容
		    btn:['确定', '取消']
			  ,yes: function(index, layero){ //或者使用btn1
			    //确定的回调
			  	
			  },cancel: function(index){//或者使用btn2（concel）
			  	//取消的回调
			  }
		});
	});
	
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
	$(".testinterfaceselect").css("color","#aaa");
	$(".testinterfaceselect").change(function(){
		if($(this).val()!="请选择"){
			$(this).css("color","#000");
		}else{
			$(this).css("color","#aaa");
		}
	});
});










