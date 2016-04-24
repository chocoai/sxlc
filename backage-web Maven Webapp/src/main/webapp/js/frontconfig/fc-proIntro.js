/* 产品介绍管理模块      */
/* 产品添加     */
/**
 * 添加动态
 */
function proInfoAdd(title,page,type){
	//参数判断，自己写全
	//console.log(title+","+page+","+type);
	if(title == "" || page == "" || type == "" ){
		console.log("参数异常,请检查参数");
		return;
	}
	layer.open({
	    type: 2,
	    area: ['800px', '450px'], //高宽
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



function proInfoAlert(title,page,type,id){
	//参数判断，自己写全
	//console.log(title+","+page+","+type);
	if(title == "" || page == "" || type == "" || id == ""){
		console.log("参数异常,请检查参数");
		return;
	}
	layer.open({
	    type: 2,
	    area: ['800px', '450px'], //高宽
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


/*    滚动条显示                 */
$(function(){
	$(".addContainer").css({"height":"350px","overflow-y":"scroll"});
	$(".line").css({"display":"inline-block","width":"15px","height":"1px","background":"#888","margin":"0 9px","vertical-align":"inherit"});
});


$(function(){
	$('#table_id').DataTable({
		"aaSorting" : [ [ 1, "desc" ] ],//默认第几个排序
		"aoColumnDefs" : [
		//{"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
		{
			"orderable" : false,
			"aTargets" : [0,2,3,4,5,6,7]
		} // 制定列不参与排序
		],
	});
});


/*   验证           */
$(function(){
	validform5("layui-layer-btn0","productName",false,"3");
	validform5("layui-layer-btn0","loanScope",false,"3");
	validform5("layui-layer-btn0","rateScope",false,"3");
	validform5("layui-layer-btn0","alertProductName",false,"3");
	validform5("layui-layer-btn0","alertLoanScope",false,"3");
	validform5("layui-layer-btn0","alertRateScope",false,"3");
});
