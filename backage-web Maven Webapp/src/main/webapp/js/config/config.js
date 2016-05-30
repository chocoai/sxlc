$(function(){
//	添加提奖达人规则的特殊配置中的推荐达人提奖 
	$(".obtn-master-add").on("click touchstart",function(){
		layer.open({
		    type: 1,
		    area: ['520px', '400px'], //高宽
		    title: "添加推荐达人提奖",
		    content: $(".master-add"),//DOM或内容
		    btn:['确定', '取消']
			  ,yes: function(index, layero){ //或者使用btn1
			    //确定的回调
			  },cancel: function(index){//或者使用btn2（concel）
			  	//取消的回调
			  }
		});
	});
//	删除提奖达人规则的特殊配置中的推荐达人提奖 
	$(".obtn-master-del").on("click touchstart",function(){
		//获得选取的对象
		
		layer.confirm('确定删除该时间段信息？', {
		  btn: ['确定', '取消']
		}, function(index, layero){
		  //按钮【按钮一】的回调
			
			//执行完关闭
		  	layer.close(index);
		}, function(index){
		  //按钮【按钮二】的回调
		});
	});
//	添加提奖达人规则的特殊配置中的理财顾问提奖 
	$(".obtn-adviser-add").on("click touchstart",function(){
		layer.open({
		    type: 1,
		    area: ['520px', '400px'], //高宽
		    title: "添加理财顾问提奖",
		    content: $(".adviser-add"),//DOM或内容
		    btn:['确定', '取消']
			  ,yes: function(index, layero){ //或者使用btn1
			    //确定的回调
			  },cancel: function(index){//或者使用btn2（concel）
			  	//取消的回调
			  }
		});
	});
//	删除提奖达人规则的特殊配置中的理财顾问提奖 
	$(".obtn-adviser-del").on("click touchstart",function(){
		//获得选取的对象
		
		layer.confirm('确定删除该条信息？', {
		  btn: ['确定', '取消']
		}, function(index, layero){
		  //按钮【按钮一】的回调
			
			//执行完关闭
		  	layer.close(index);
		}, function(index){
		  //按钮【按钮二】的回调
		});
	});
//	删除--当前逾期费用设置记录
	$(".invest-fee-del").on("click touchstart",function(){
		//获得选取的对象
		
		layer.confirm('确定删除该条信息？', {
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
