/*伍成然2016-3-27*/
$(function(){
	/*企业个人单选框切换*/
	$(".radioclass2").click(function(){
		$(".radio-select2").addClass("on");
		$(".radio-select1").removeClass("on");
	});
	$(".radioclass1").click(function(){
		$(".radio-select1").addClass("on");
		$(".radio-select2").removeClass("on");
	});
	/*记住用户名*/	
	$(".check-box").click(function(){
		if($(".checkBox").hasClass("active"))
		{
			$(".checkBox").removeClass("active");
		}
		else
		{
			$(".checkBox").addClass("active");	
		}		
	});
	/*弹出层,样式待改*/	
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
	this.parent().find(".tip").css("left",this.offset().left - this.parent().offset().left + this.innerWidth() + 3);
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
/* 胥福星     2016-04-06  密码框提示span模拟   */
$(function(){
	$(".hint").click(function(){
		 $(".input-password").focus();
	});
	$(".input-password").focus(function(){
		$(this).parent().find(".hint").hide();
	});
	$(".input-password").blur(function(){
		if($(this).val() == ""){
			$(this).parent().find(".hint").show();
		}else{
			$(this).parent().find(".hint").hide();
		}
	});
});
/*  end  */
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
	$(".input-user-name").blur(function(){
		$(this).parent().find(".tip").remove();
	});
	/* 密码验证    */
	$(".input-password").focus(function(){
		if(this.value == ""){
			$(this).layoutFocus("请输入密码");
			$(this).parent().find(".tipError").remove();
			$(this).parent().find(".tipOk").remove();
		}
	});
	$(".input-password").blur(function(){
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
	/* 验证码提示层     */
	$(".codeDiv > .img-check").focus(function(){
		if($(this).val() == ""){
			$(this).parent().layoutFocus("请输入您的验证码");
			$(this).parent().parent().find(".tipError").remove();
			$(this).parent().parent().find(".tipOk").remove();
		}
	});
	$(".codeDiv > .img-check").blur(function(){
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

