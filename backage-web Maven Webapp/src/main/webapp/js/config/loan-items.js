/**
 * 版块：配置中心-----借款认证项配置
 * 内容介绍：
 */
$(function(){
	/*添加个人认证项*/
	$(".obtn-loanitem-add").on("click touchstart",function(){
		layer.open({
		    type: 1,
		    area: ['500px', '300px'], //高宽
		    title: "添加个人认证项",
		    content: $(".loanitem-add"),//DOM或内容
		    btn:['确定', '取消']
			  ,yes: function(index, layero){ //或者使用btn1
			    //确定的回调
			  	
			  },cancel: function(index){//或者使用btn2（concel）
			  	//取消的回调
			  }
		});
	});
	/*修改个人认证项*/
	$(".obtn-loanitem-mod").on("click touchstart",function(){
		layer.open({
		    type: 1,
		    area: ['500px', '300px'], //高宽
		    title: "修改个人借款认证项",
		    content: $(".loanitem-mod"),//DOM或内容
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
});










