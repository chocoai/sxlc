/* 添加部分开始 */
function assetAdd(){
	layer.open({
	    type: 1,
	    area: ['690px', '480px'], //高宽
	    title: "添加资产管理方信息",
	    maxmin: true,
	    content: $("#assetadd"),//DOM或内容
	    btn:['确定', '取消']
		  ,yes: function(index, layero){ //或者使用btn1
		    //确定的回调
		  	//判断执行不同方法
		  	
		  },cancel: function(index){//或者使用btn2（concel）
		  	//取消的回调
		  }
	});
}
/* 添加部分结束 */
/* 修改部分开始 */
function assetMod(){
	layer.open({
		type: 1,
		area: ['690px', '480px'], //高宽
		title: "修改资产管理方信息",
		maxmin: true,
		content: $("#assetmod"),//DOM或内容
		btn:['确定', '取消']
	,yes: function(index, layero){ //或者使用btn1
		//确定的回调
		//判断执行不同方法
		
	},cancel: function(index){//或者使用btn2（concel）
		//取消的回调
	}
	});
}
/* 修改部分结束 */
/* 查看部分开始 */
function assetDetail(){
	layer.open({
		type: 1,
		area: ['690px', '480px'], //高宽
		title: "查看资产管理方信息详情",
		maxmin: true,
		content: $("#assetmod"),//DOM或内容
		btn:['返回'],
	/*,yes: function(index, layero){ //或者使用btn1
		//确定的回调
		//判断执行不同方法
		
	},*/cancel: function(index){//或者使用btn2（concel）
		//取消的回调
	}
	});
}
/* 查看部分结束 */
/*资产管理方管理员管理部分开始 */
function admainManager(){
	layer.open({
		type: 1,
		area: ['690px', '480px'], //高宽
		title: "查看资产管理方信息详情",
		maxmin: true,
		content: $("#assetmod"),//DOM或内容
		btn:['返回'],
		/*,yes: function(index, layero){ //或者使用btn1
		//确定的回调
		//判断执行不同方法
		
	},*/cancel: function(index){//或者使用btn2（concel）
		//取消的回调
	}
	});
}
/* 添加 */
function manageAdmainAdd(){
	layer.open({
		type: 1,
		area: ['550px', '480px'], //高宽
		title: "添加管理员管理",
		maxmin: true,
		content: $("#manageAdmainAdd"),//DOM或内容
		btn:['确定', '取消']
	,yes: function(index, layero){ //或者使用btn1
		//确定的回调
		//判断执行不同方法
		
	},cancel: function(index){//或者使用btn2（concel）
		//取消的回调
	}
	});
}
/* 添加 */
/* 修改 */
function manageAdmainMod(){
	layer.open({
		type: 1,
		area: ['550px', '480px'], //高宽
		title: "修改管理员管理",
		maxmin: true,
		content: $("#manageAdmainAdd"),//DOM或内容
		btn:['确定', '取消']
	,yes: function(index, layero){ //或者使用btn1
		//确定的回调
		//判断执行不同方法
		
	},cancel: function(index){//或者使用btn2（concel）
		//取消的回调
	}
	});
}
/* 修改 */
/* 资产管理方管理员管理部分开始  */
function assetAdmainManager(){
	$(".right_col").load("web/recommend/re-add/assetAdmainManager.jsp");
}
