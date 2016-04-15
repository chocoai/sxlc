/* 黄鑫2016-4-2 */
$(function(){
	$(".TB").addClass("down");
	$(".TB1").addClass("down2");
	/* 伍成然2016-4-2 */
	/* 内容显示切换 */
	$(".modify").click(function(){
		$(".content1").removeClass("active");
		$(".content2").addClass("active");
	});
	$(".preserve").click(function(){
		$(".content2").removeClass("active");
		$(".content1").addClass("active");
	});
	$(".cancel").click(function(){
		$(".content2").removeClass("active");
		$(".content1").addClass("active");
	});
	$(".radioclass2").click(function(){
		$(".radio-select2").addClass("on");
		$(".radio-select1").removeClass("on");
	});
	$(".radioclass1").click(function(){
		$(".radio-select1").addClass("on");
		$(".radio-select2").removeClass("on");
	});
});


/*   胥福星    20160411  邮箱验证    */
$(".entryEmail").focus(function(){
	if(this.value == ""){
		$(this).layoutFocus("请输入邮箱");
		$(this).parent().find(".tipError").remove();
		$(this).parent().find(".tipOk").remove();
	}
});
$(".entryEmail").blur(function(){
	var str = this.value;
	var reg = new RegExp( /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/);
	$(this).parent().find(".tip").remove();
	if(reg.test(str)){
		$(this).layoutSuccess();
		$(this).parent().find(".tipError").remove();
	}else{
		$(this).layoutWarning("请输入正确的邮箱格式");
		$(this).parent().find(".tipOk").remove();
	}
});

/* 手机验证  */
$(".phoneBind").focus(function(){ 
	if($(this).val() == ""){
		$(this).layoutFocus("请输入手机号");
		$(this).parent().find(".tipError").remove();
		$(this).parent().find(".tipOk").remove();
	}
});
$(".phoneBind").keyup(function(){
	var str = this.value;
	var reg = new RegExp("^[0-9]{11}$");
	$(this).parent().find(".tip").remove();
	if(reg.test(str)){
		if($(this).parent().find(".tipOk").length > 0){
			return false;
		}else{
			$(this).layoutSuccess();
			$(this).parent().find(".tipError").remove();
		}
	}else{
		if($(this).parent().find(".tipError").length > 0){
			return false;
		}else{
			$(this).layoutWarning("11位数字");
			$(this).parent().find(".tipOk").remove();
		}
	}
});