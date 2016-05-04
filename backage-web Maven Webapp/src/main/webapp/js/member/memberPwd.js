/* 重置密码      */
/**
 * 密码修改
 */
function resetPWD(title,page,type){
	//参数判断，自己写全
	//console.log(title+","+page+","+type);
	
	if(title == "" || page == "" || type == "" ){
		console.log("参数异常,请检查参数");
		return;
	}
	layer.open({
	    type: 2,
	    area: ['350px', '210px'], //高宽
	    title: title,
	    maxmin: true,
	    content: page,//DOM或内容
	    success:function(){
	    	
	    }
	});
};
/* 企业会员重置密码      */
/**
 * 密码修改
 */
function companyResetPWD(title,page,type){
	//参数判断，自己写全
	//console.log(title+","+page+","+type);
	
	if(title == "" || page == "" || type == "" ){
		console.log("参数异常,请检查参数");
		return;
	}
	layer.open({
	    type: 2,
	    area: ['350px', '210px'], //高宽
	    title: title,
	    maxmin: true,
	    content: page,//DOM或内容
	    success:function(){
	    	
	    }
	});
};