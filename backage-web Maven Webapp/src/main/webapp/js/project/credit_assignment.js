$(function(){
	//	审核
	$('#credit_assignment_exam').click(function(){
		layer.open({
		    type: 1,
		    area: ['400px', '230px'], //高宽
		    title: "审核",
		    content: $(".assignment_exam"),//DOM或内容
		    btn:['确定', '取消']
			  ,yes: function(index, layero){ //或者使用btn1
			    //确定的回调
			  	
			  },cancel: function(index){//或者使用btn2（concel）
			  	//取消的回调
			  }
		});
	});
	
//	投标结束时间延长
	$('#credit_assignment_late').click(function(){
		layer.open({
		    type: 1,
		    area: ['400px', '230px'], //高宽
		    title: "审核",
		    content: $(".assignment_late"),//DOM或内容
		    btn:['确定', '取消']
			  ,yes: function(index, layero){ //或者使用btn1
			    //确定的回调
			  	
			  },cancel: function(index){//或者使用btn2（concel）
			  	//取消的回调
			  }
		});
	});
	
});
