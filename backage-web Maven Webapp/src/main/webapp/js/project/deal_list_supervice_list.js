/*项目管理----成交项目列表----贷后监管*/
$(function(){
	/*添加贷后信息*/
	$(".obtn-addmsg").on("click touchstart",function(){
		layer.open({
		    type: 1,
		    area: ['600px', '500px'], //高宽
		    title: "添加贷后信息",
		    content: $(".addmsg"),//DOM或内容
		    btn:['确定', '取消']
			  ,yes: function(index, layero){ //或者使用btn1
			    //确定的回调
			  	
			  },cancel: function(index){//或者使用btn2（concel）
			  	//取消的回调
			  }
		});
	});
	/*贷后信息查询*/
	$(".obtn-searchmsg").on("click touchstart",function(){
		layer.open({
		    type: 1,
		    area: ['800px', '580px'], //高宽
		    title: "贷后信息查询",
		    content: $(".searchmsg"),//DOM或内容
		    btn:['确定', '取消']
			  ,yes: function(index, layero){ //或者使用btn1
			    //确定的回调
			  	
			  },cancel: function(index){//或者使用btn2（concel）
			  	//取消的回调
			  }
		});
	});
	/*删除*/
    $(".btn-del").on('click',function(){
    	layer.confirm('确定要删除该条记录吗？', {
			btn: ['确定', '取消']
		}, function(index, layero){    //点确定回调
			
		}, function(index){    //点取消回调
			
		});
    });
});










