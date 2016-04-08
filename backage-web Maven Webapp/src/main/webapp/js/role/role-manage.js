/**
 * 角色管理-管理员管理
 * 添加修改部分代码直接写在页面上的，加快渲染速度
 * 每次执行操作前请清空目标盒子的数值
 */




/**
 * 管理员详情
 * @param {String} title	标题
 */
function manageDet(title){
	
	//获取参数
	
	//执行查询
	
	layer.open({
	    type: 1,
	    area: ['750px', '550px'], //高宽
	    title: title,
	    //maxmin: true,
	    content: $("#manage-det"),//DOM或内容
	    btn:['返回']
		  ,btn0: function(index, layero){ //或者使用btn1
			layer.close();				
		  }
	});
}


/**
 * 添加管理员	内部外部公用	判断类型执行不同函数
 * @param {String} title	标题		
 * @param {String} type		类型		0：内部	1：外部
 */
function manageAdd(title,type){
	console.log(title+","+type);
	
	//表单置空，清除上次遗留数据
	
	//判断参数
	if(title == "" || type == ""){
		console.log("参数错误，请检查参数");
		return;
	}
	
	layer.open({
	    type: 1,
	    area: ['750px', '550px'], //高宽
	    title: title,
	    //maxmin: true,
	    content: $("#manage-add"),//DOM或内容
	    btn:['确定', '取消']
		  ,yes: function(index, layero){ //或者使用btn1
		    //确定的回调
		  	//判断type执行不同方法
		  	
		  	
		  },cancel: function(index){//或者使用btn2（concel）
		  	//取消的回调
		  }
	});
}

/**
 * 根据管理员id修改管理员
 * @param {} title
 * @param {} type
 */
function manageMod(title,type){
	//由于添加和修改字段一样，可以考虑克隆，若存在差别，请复制一份到#manage-mod
	$("#manage-mod").html($("#manage-add table").clone());
	//表单置空，清除上次遗留数据
	
	//获取管理员id
	
	//查询管理员信息
	
	//赋值
	layer.open({
	    type: 1,
	    area: ['750px', '550px'], //高宽
	    title: title,
	    //maxmin: true,
	    content: $("#manage-mod"),//DOM或内容
	    btn:['确定', '取消']
		  ,yes: function(index, layero){ //或者使用btn1
		    //确定的回调
		  	//判断type执行不同方法
		  	
		  	
		  },cancel: function(index){//或者使用btn2（concel）
		  	//取消的回调
		  }
	});
}

/**
 * 删除管理员	内部外部公用	
 */
function manageDel(){
	//获得选取的对象
		
	//删除某个职务，当有员工拥有改职务时，不能进行删除
	layer.confirm('确定删除该管理员？', {
	  btn: ['确定', '取消']
	}, function(index, layero){
	  //按钮【按钮一】的回调
		
		//执行完关闭
	  	layer.close(index);
	}, function(index){
	  //按钮【按钮二】的回调
	});
}



//加载执行
$(function(){
	$("#manage-det input").attr("disabled",true);
});