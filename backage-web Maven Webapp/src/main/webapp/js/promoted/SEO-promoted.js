/*  添加SEO设置     */
function addSEO(){
	layer.open({
		type: 1,
		area: ['500px', '300px'], //高宽
		title: "添加SEO设置",
		maxmin: true,
		content: $("#addSEO")//DOM或内容
	});
}


/*  修改SEO设置     */
function alertSEO(){
	layer.open({
		type: 1,
		area: ['500px', '300px'], //高宽
		title: "修改SEO设置",
		maxmin: true,
		content: $("#alertSEO")//DOM或内容
	});
}

$(function(){
	validform5(".addBtn","addSEOForm",false,3);
	validform5(".alertBtn","alertSEOForm",false,3);
	$(".cancelBtn").bind("click",function(){
		layer.closeAll();
	});
});