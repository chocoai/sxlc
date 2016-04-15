/*伍成然2016-3-27*/

$(function(){
	/*跳转流程*/
	$(".next-btn").click(function(){
		$(".input-group1").removeClass("on");
		$(".input-group2").addClass("on");
		layer.closeAll('tips'); //关闭所有的tips层
	});
	$(".submit-btn").click(function(){
		$(".input-group2").removeClass("on");
		$(".info").addClass("on");				
	});
});


/*弹出层:提示输入手机号&提示密码*/	
/* 弹出提示框的js代码  */
jQuery.fn.layoutWarning = function(str){
	var s = str;
	var m = '<div class="tipError"><div class="pre"></div><div class="after">' + s + '</div></div>';
	this.parent().css('position','relative');
	this.parent().append(m);
	this.parent().find(".tipError").css("left",this.offset().left - this.parent().offset().left + this.innerWidth() + 5);
	this.parent().find(".tipError").css("top",this.offset().top - this.parent().offset().top - 2 );
};
jQuery.fn.layoutFocus = function(str){
	var s = str;
	var m = '<div class="tip"><div class="preTip"></div><div class="afterTip">' + s + '</div></div>';
	this.parent().css('position','relative');
	this.parent().append(m);
	this.parent().find(".tip").css("left",this.offset().left - this.parent().offset().left + this.innerWidth() + 5);
	this.parent().find(".tip").css("top",this.offset().top - this.parent().offset().top - 2 );
};
jQuery.fn.layoutSuccess = function(){
	var m = '<div class="tipOk"></div>';
	this.parent().css('position','relative');
	this.parent().append(m);
	this.parent().find(".tipOk").css("left",this.offset().left - this.parent().offset().left + this.innerWidth() + 5);
	this.parent().find(".tipOk").css("top",this.offset().top - this.parent().offset().top + 12 );
};
/* 获取动态验证码的弹出提示层js代码  */
jQuery.fn.layoutCode = function(str){
	var s = str;
	var m = '<span class="dynamicVerificationSpan">' + s + '</span>';
	this.parent().css('position','relative');
	this.parent().append(m);
	this.parent().find(".dynamicVerificationSpan").css("left",this.offset().left - this.parent().offset().left + this.innerWidth() + 10);
	this.parent().find(".dynamicVerificationSpan").css("top",this.offset().top - this.parent().offset().top );
};
/* 胥福星   2016-04-06  注册弹出提示框js*/
$(function(){
	/* 用户名弹出提示框代码*/
	$(".input-user-name").focus(function(){
		if($(this).val() == ""){
			$(this).layoutFocus("请输入用户名");
			$(this).parent().find(".tipError").remove();
			$(this).parent().find(".tipOk").remove();
		}
	});
	$(".input-user-name").keyup(function(){
		var str = this.value;
		var reg = new RegExp("^[a-zA-Z0-9]{6,30}$");
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
				$(this).layoutWarning("无此用户");
				$(this).parent().find(".tipOk").remove();
			}
		}
	});
	/* 验证手机号码js */
	$(".input-tel-num").focus(function(){
		if($(this).val() == ""){
			$(this).layoutFocus("11位数字");
			$(this).parent().find(".tipError").remove();
			$(this).parent().find(".tipOk").remove();
		}
	});
	$(".input-tel-num").keyup(function(){
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
	$(".input-tel-num").blur(function(){
		$(this).parent().find(".tip").remove();
	});
	/* 密码验证    */
	$(".input-password").focus(function(){
		if(this.value == ""){
			$(this).layoutFocus("6~16位字符，可以使用字母、数字、字符组合");
			$(this).parent().find(".tipError").remove();
			$(this).parent().find(".tipOk").remove();
		}
	});
	$(".input-password").blur(function(){
		$(this).parent().find(".tip").remove();
		var str = this.value;
		var reg = new RegExp(/^[a-zA-Z0-9]{6,16}$/);
		$(this).parent().find(".tip").remove();
		if(reg.test(str)){
			$(this).layoutSuccess();
			$(this).parent().find(".tipError").remove();
		}else{
			$(this).layoutWarning("密码错误，请出新输入！");
			$(this).parent().find(".tipOk").remove();
		}
	});
	/* 确认密码  */
	$(".input-password2").focus(function(){
		if(this.value == ""){
			$(this).layoutFocus("6~16位字符，可以使用字母、数字、字符组合");
			$(this).parent().find(".tipError").remove();
			$(this).parent().find(".tipOk").remove();
		}
		$(this).css("border-color","#ddd");
	});
	$(".input-password2").blur(function(){
		$(this).parent().find(".tip").remove();
		if($(this).val() == $(".input-password").val()){
			$(this).layoutSuccess();
			$(this).css("border-color","#ddd");
		}else{
			$(this).layoutWarning("输入的密码不一致");
			$(this).css("border-color","red");
		}
	});

	$(".registerCode > .img-check").focus(function(){
		if($(this).val() == ""){
			$(this).parent().layoutFocus("请输入您的验证码");
			$(this).parent().parent().find(".tipError").remove();
			$(this).parent().parent().find(".tipOk").remove();
		}
	});
	$(".registerCode > .img-check").blur(function(){
		$(this).parent().find(".tip").remove();
		var str = this.value;
		var reg = new RegExp("^[a-zA-Z0-9]{4}$");
		$(this).parent().parent().find(".tip").remove();
		if(reg.test(str)){
			$(this).parent().layoutSuccess();
			$(this).parent().parent().find(".tipError").remove();
		}else{
			$(this).parent().layoutWarning("验证码错误");
			$(this).parent().parent().find(".tipOk").remove();
		}
	});
	/* 验证码提示层      */
	$(".get-tel-check").click(function(){
		if($(this).parent().parent().find(".dynamicVerificationSpan").length > 0){
			return false;
		}else{
			$(this).parent().layoutCode("已发送，3分钟后可重新获取");
			$(this).parent().parent().find(".tipOk").remove();
			$(this).parent().parent().find(".tipError").remove();
		}
		setTimeout(function(){
			$(".telCode").parent().parent().find(".dynamicVerificationSpan").remove();
			$(".get-tel-check").html("重新获取");
		},30000);
	});
	$(".tel-check").blur(function(){
		var str = this.value;
		var reg = new RegExp("^[0-9]{5,6}$");
		if(reg.test(str)){
			$(this).parent().layoutSuccess();
			$(this).parent().parent().find(".tipError").remove();
			$(this).css("border-color","#ddd");
			$(".telCode").parent().parent().find(".dynamicVerificationSpan").remove();
		}else{
			$(this).parent().layoutWarning("验证码错误,请重新输入");
			$(this).parent().parent().find(".tipOk").remove();
			$(this).css("border-color","red");
			$(".telCode").parent().parent().find(".dynamicVerificationSpan").remove();
		}
		$(this).parent().find(".tip").remove();
	});
	/* 密码验证    */
	$(".password-new").focus(function(){
		if(this.value == ""){
			$(this).layoutFocus("6~16位字符，可以使用字母、数字、字符组合");
			$(this).parent().find(".tipError").remove();
			$(this).parent().find(".tipOk").remove();
		}
	});
	$(".password-new").blur(function(){
		$(this).parent().find(".tip").remove();
		var str = this.value;
		var reg = new RegExp(/^[a-zA-Z0-9]{6,16}$/);
		$(this).parent().find(".tip").remove();
		if(reg.test(str)){
			$(this).layoutSuccess();
			$(this).parent().find(".tipError").remove();
		}else{
			$(this).layoutWarning("密码错误，请出新输入！");
			$(this).parent().find(".tipOk").remove();
		}
	});
	/* 确认密码  */
	$(".password-new2").focus(function(){
		if(this.value == ""){
			$(this).layoutFocus("6~16位字符，可以使用字母、数字、字符组合");
			$(this).parent().find(".tipError").remove();
			$(this).parent().find(".tipOk").remove();
		}
		$(this).css("border-color","#ddd");
	});
	$(".password-new2").blur(function(){
		$(this).parent().find(".tip").remove();
		if($(this).val() == $(".password-new").val()){
			$(this).layoutSuccess();
			$(this).css("border-color","#ddd");
		}else{
			$(this).layoutWarning("输入的密码不一致");
			$(this).css("border-color","red");
		}
	});

	$(".imgCode > .img-check").focus(function(){
		if($(this).val() == ""){
			$(this).parent().layoutFocus("请输入您的验证码");
			$(this).parent().parent().find(".tipError").remove();
			$(this).parent().parent().find(".tipOk").remove();
		}
	});
	$(".imgCode > .img-check").blur(function(){
		$(this).parent().parent().find(".tip").remove();
		var str = this.value;
		var reg = new RegExp("^[a-zA-Z0-9]{4}$");
		$(this).parent().parent().find(".tip").remove();
		if(reg.test(str)){
			$(this).parent().layoutSuccess();
			$(this).parent().parent().find(".tipError").remove();
		}else{
			$(this).parent().layoutWarning("验证码错误");
			$(this).parent().parent().find(".tipOk").remove();
		}
	});
});
/* 判断是否为数字   */
$(function(){
	$(".numberReg").each(function(){
		$(this).focus(function(){
			$(this).keyup(function(){
				if(this.value.length > 0){
					this.value = this.value.replace(/[^0-9]/g,'');
				}
			});
		});
	});
});