/*  银行卡管理部分      */
/**
 * 添加动态
 */
function bankManagementAdd(title,page,type){
	//参数判断，自己写全
	//console.log(title+","+page+","+type);
	if(title == "" || page == "" || type == "" ){
		console.log("参数异常,请检查参数");
		return;
	}
	layer.open({
	    type: 2,
	    area: ['500px', '380px'], //高宽
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


function bankManagementMod(title,page,type,id){
	//参数判断，自己写全
	//console.log(title+","+page+","+type);
	if(title == "" || page == "" || type == "" || id == "" ){
		console.log("参数异常,请检查参数");
		return;
	}
	layer.open({
	    type: 2,
	    area: ['500px', '380px'], //高宽
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

/**
 * 删除银行卡
 */
$(function () {
	var appPath = getRootPath();//项目根路径
	//删除部门
	$(".obtn-dept-del").on("click touchstart",function(){
		//获得选取的对象
		
		layer.confirm('确定删除该银行卡？', {
		  btn: ['确定', '取消']
		});
	});
});


/*   验证           */
$(function(){
	$(".cardTypeOption").css({
		"width":"186px",
		"padding":"5px 8px",
		"border":"1px solid #ccc",
		"cursor":"pointer"
	});
	validform5(".commonbtn0","card_id",false,"3");
});