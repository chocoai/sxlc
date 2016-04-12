/**
 * 版块：配置中心-----会员等级配置
 * 内容介绍：
 */
$(function(){
	/*添加会员信用等级*/
	$(".obtn-memcredit-grade-add").on("click touchstart",function(){
		layer.open({
		    type: 1,
		    area: ['400px', '300px'], //高宽
		    title: "添加会员信用等级",
		    content: $(".memcredit-grade-add"),//DOM或内容
		    btn:['确定', '取消']
			  ,yes: function(index, layero){ //或者使用btn1
			    //确定的回调
			  	
			  },cancel: function(index){//或者使用btn2（concel）
			  	//取消的回调
			  }
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










