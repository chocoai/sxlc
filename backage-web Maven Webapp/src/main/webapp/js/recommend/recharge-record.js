//function
//添加图片
/**
* 添加图片
* @param {String} title	窗口标题
* @param {URL} page		页面链接
* @param {Int} type		上传图片类型
* type{
* 		1:
* }
*/
function picAdd(title,page,type){
	//参数判断，自己写全
	//console.log(title+","+page+","+type);
	if(title == "" || page == "" || type == ""){
		console.log("参数异常,请检查参数");
		return;
	}
	layer.open({
	    type: 2,
	    area: ['530px', '350px'], //宽高
	    title: title,
	    maxmin: true,
	    content: page,//DOM或内容
	    /*btn:['确定', '取消']
		  ,yes: function(index, layero){ //或者使用btn1
		    //确定的回调
		  	//判断执行不同方法
		  	
		  },cancel: function(index){//或者使用btn2（concel）
		  	//取消的回调
		  }*/
	});
}

//function
//添加图片
/**
* 添加图片
* @param {String} title	窗口标题
* @param {URL} page		页面链接
* @param {Int} type		上传图片类型
* type{
* 		1:
* }
*/
function pAdd(){
	$(".right_col").load("web/recommend/re-add/acc-withdraw.jsp");
}
	//参数判断，自己写全
	//console.log(title+","+page+","+type);
	/*if(title == "" || page == "" || type == ""){
		console.log("参数异常,请检查参数");
		return;
	}
	layer.open({
	    type: 2,
	    area: ['450px', '300px'], //宽高
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
*/

/**
* 修改图片
* @param {String} title
* @param {URL} page
* @param {Int} type
* @param {Int} id
*/
function picMod(title,page,type,id){
	//console.log(title+","+page+","+type+","+id);
	//参数判断，自己写全
	if(title == "" || page == "" || type == "" || id == ""){
		console.log("参数异常,请检查参数");
		return;
	}
	layer.open({
	    type: 2,
	    area: ['300px', '300px'], //高宽
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
/*$(function(){
	validform5(".commonbtn0","rechargeform",false,"3");
});*/

