/*  添加SEO设置     */
function addEnv(){
	layer.open({
		type: 1,
		area: ['450px', '200px'], //高宽
		title: "添加红包配置",
		maxmin: true,
		content: $("#addEnv")//DOM或内容
	});
}


/*  修改SEO设置     */
function alertEnv(){
	layer.open({
		type: 1,
		area: ['450px', '200px'], //高宽
		title: "修改红包配置",
		maxmin: true,
		content: $("#alertEnv")//DOM或内容
	});
}


/* 红包个数增加  */
$(function(){
	var content = "<div class='redEContent'><span class='tt t1'></span><span class='col'><input datatype='acountM' class='moneyInput'>元<input datatype='nNum1' class='moneyInput'>个<a class='redDelete'>删除</a></span></div>";
	$(".redEAdd").on("click",function(){
		$(this).parent().parent().parent().append(content);
		$(".redDelete").on("click",function(){
			$(this).parent().parent().remove();
		});
	});
});

$(function(){
	validform5(".addBtn","addRedEForm",false,3);
	validform5(".alertBtn","alertRedEForm",false,3);
	validform5(".okBtn","conForm",false,3);
	$(".cancelBtn").bind("click",function(){
		layer.closeAll();
	});
});


