/**
 * 
 */
/* 添加担保机构信息部分开始 */
function manageAdd(){
	layer.open({
	    type: 1,
	    area: ['700px', '480px'], //高宽
	    title: "添加担保机构信息",
	    maxmin: true,
	    content: $("#manage-add"),//DOM或内容
	    btn:['确定', '取消']
		  ,yes: function(index, layero){ //或者使用btn1
		    //确定的回调
		  	//判断执行不同方法
		  	
		  },cancel: function(index){//或者使用btn2（concel）
		  	//取消的回调
		  }
	});
}
/* 添加担保机构信息部分结束 */

/* 修改担保机构信息部分开始 */
function manageMod(){
	layer.open({
		type: 1,
		area: ['700px', '480px'], //高宽
		title: "修改担保机构信息",
		maxmin: true,
		content: $("#manageMod"),//DOM或内容
		btn:['确定', '取消']
	,yes: function(index, layero){ //或者使用btn1
		//确定的回调
		//判断执行不同方法
		
	},cancel: function(index){//或者使用btn2（concel）
		//取消的回调
	}
	});
}
/* 修改担保机构信息部分结束 */

/* 查看担保机构信息部分开始 */
function checkDetail(){
	layer.open({
		type: 1,
		area: ['700px', '510px'], //高宽
		title: "查看担保机构信息",
		maxmin: true,
		content: $("#checkDetail"),//DOM或内容
		btn:['返回']
	/*,yes: function(index, layero){ //或者使用btn1
		//确定的回调
		//判断执行不同方法
		
	}*/,cancel: function(index){//或者使用btn2（concel）
		//取消的回调
	}
	});
}
/* 查看担保机构信息部分结束 */

/* 担保机构管理员管理部分开始 */
function manageAdmain(){
	layer.open({
		type: 1,
		area: ['750px', '480px'], //高宽
		title: "担保机构管理员管理",
		maxmin: true,
		content: $("#manageAdmain"),//DOM或内容
		btn:['确定', '取消']
	,yes: function(index, layero){ //或者使用btn1
		//确定的回调
		//判断执行不同方法
		
	},cancel: function(index){//或者使用btn2（concel）
		//取消的回调
	}
	});
}
/* 担保机构管理员管理部分结束 */

/* 担保项目查询部分开始 */
function checkProject(){
	layer.open({
		type: 1,
		area: ['1080px', '550px'], //高宽
		title: "担保项目查询",
		maxmin: true,
		content: $("#checkProject"),//DOM或内容
		btn:['确定', '取消']
	,yes: function(index, layero){ //或者使用btn1
		//确定的回调
		//判断执行不同方法
		
	},cancel: function(index){//或者使用btn2（concel）
		//取消的回调
	}
	});
}
/* 担保项目查询部分结束 */

/* 代偿记录查询部分开始 */
function checkRecord(){
	layer.open({
		type: 1,
		area: ['1280px', '550px'], //高宽
		title: "代偿记录查询",
		maxmin: true,
		content: $("#checkRecord"),//DOM或内容
		btn:['确定', '取消']
	,yes: function(index, layero){ //或者使用btn1
		//确定的回调
		//判断执行不同方法
		
	},cancel: function(index){//或者使用btn2（concel）
		//取消的回调
	}
	});
}
/* 代偿记录查询部分结束 */

/* 代偿回款记录查询部分开始 */
function checkPayment(){
	layer.open({
		type: 1,
		area: ['850px', '550px'], //高宽
		title: "代偿记录查询",
		maxmin: true,
		content: $("#checkPayment"),//DOM或内容
		btn:['确定', '取消']
	,yes: function(index, layero){ //或者使用btn1
		//确定的回调
		//判断执行不同方法
		
	},cancel: function(index){//或者使用btn2（concel）
		//取消的回调
	}
	});
}
/* 代偿回款记录查询部分结束 */




