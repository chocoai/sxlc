/**
 * 版块：前台界面配置-专家顾问
 * 内容介绍：
 */
 
 
 
/**
 * 添加专家顾问
 * @param {String} title	窗口标题
 * @param {URL} page		页面链接
 * @param {Int} type		上传图片类型
 * type{
 * 		1:
 * }
 */
function expAdd(title,page,type){
	//参数判断，自己写全
	console.log(title+","+page+","+type);
	if(title == "" || page == "" || type == ""){
		console.log("参数异常,请检查参数");
		return;
	}
	layer.open({
	    type: 2,
	    area: ['750px', '550px'], //高宽
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
 * 修改专家顾问
 * @param {} title
 * @param {} page
 * @param {} type
 * @param {} id
 */
function expMod(title,page,type,id){
	//参数判断，自己写全
	console.log(title+","+page+","+type);
	if(title == "" || page == "" || type == ""){
		console.log("参数异常,请检查参数");
		return;
	}
	layer.open({
	    type: 2,
	    area: ['750px', '550px'], //高宽
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









