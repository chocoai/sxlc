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

/* 添加担保机构管理员管理部分开始 */
function manageAdmainAdd(){
	layer.open({
		type: 1,
		area: ['550px', '480px'], //高宽
		title: "添加管理员管理",
		/*maxmin: true,*/
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
/* 添加担保机构管理员管理部分结束 */

/* 修改担保机构管理员管理部分开始 */
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
/* 修改担保机构管理员管理部分结束 */

/**
 * 启用
 */
function enable(){
	layer.confirm('is not?', {title:'提示'}, function(index){
		  //do something
	  layer.close(index);
	});
}
/* 代偿记录查询部分开始 */
function checkRecord(){
	$(".right_col").load("web/recommend/re-add/checkRecord.jsp");
}
/* 代偿记录查询部分结束 */

/* 担保机构管理员管理部分开始 */
function manageAdmain(){
	$(".right_col").load("web/recommend/re-add/guaranteeAdmainManage.jsp");
}
/* 担保机构管理员管理部分结束 */

/* 担保项目查询部分开始  */
function checkProject(){
	$(".right_col").load("web/recommend/re-add/checkProject.jsp");
}
/* 担保项目查询部分结束  */

/* 代偿回款记录查询部分开始 */
function checkPayment(){
	$(".right_col").load("web/recommend/re-add/checkPayment.jsp");
}
/* 代偿回款记录查询部分结束 */



