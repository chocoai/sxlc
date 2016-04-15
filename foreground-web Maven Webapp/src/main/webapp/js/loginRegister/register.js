/*伍成然2016-3-27*/

$(function(){
	/*单选框切换*/
	$(".radioclass2").click(function(){
		$(".radio-select2").addClass("on");
		$(".radio-select1").removeClass("on");
		$(".content2").addClass("activeUp");
		$(".content1").removeClass("activeUp");
	});
	$(".radioclass1").click(function(){
		$(".radio-select1").addClass("on");
		$(".radio-select2").removeClass("on");
		$(".content1").addClass("activeUp");
		$(".content2").removeClass("activeUp");
	});
	/*密码可见不可见切换*/	
	$(".eye-ico1").click(function(){
		$(".eye-ico2").addClass("show");
		$(".eye-ico1").removeClass("show");
		$(".input-password").attr("type","text");
	});
	$(".eye-ico2").click(function(){
		$(".eye-ico1").addClass("show");
		$(".eye-ico2").removeClass("show");
		$(".input-password").attr("type","password");
	});
	/*同意条款*/	
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
	/* 用户名弹出提示框代码*/
	$(".input-user-name").focus(function(){
		if($(this).val() == ""){
			$(this).layoutFocus("6~16位的数字、字母、至少2种");
			$(this).parent().find(".tipError").remove();
			$(this).parent().find(".tipOk").remove();
		}
	});
	$(".input-user-name").keyup(function(){
		var str = this.value;
		var reg = new RegExp("(?!^(\\d+|[a-zA-Z]+|[\u4e00-\u9fa5]+)$)^[\\w\u4e00-\u9fa5]{6,16}$");
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
				$(this).layoutWarning("6~16位的数字、字母、或汉字至少2种");
				$(this).parent().find(".tipOk").remove();
			}
		}
	});
	$(".input-user-name").blur(function(){
		$(this).parent().find(".tip").remove();
	});
	/* 验证手机号码js */
	$(".input-tel-num").focus(function(){
		if($(this).val() == ""){
			$(this).layoutFocus("11位手机号");
			$(this).parent().find(".tipError").remove();
			$(this).parent().find(".tipOk").remove();
		}
	});
	$(".input-tel-num").keyup(function(){
		$(this).parent().find(".tip").remove();
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
				$(this).layoutWarning("请输入正确手机号");
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
			$(this).layoutFocus("6~16位的数字和字母组成");
			$(this).parent().find(".tipError").remove();
			$(this).parent().find(".tipOk").remove();
		}
	});
	$(".input-password").blur(function(){
		var str = this.value;
		var reg = new RegExp(/^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$/);
		$(this).parent().find(".tip").remove();
		if(reg.test(str)){
			$(this).layoutSuccess();
			$(this).parent().find(".tipError").remove();
		}else{
			$(this).layoutWarning("密码输入格式错误，请重新输入！");
			$(this).parent().find(".tipOk").remove();
		}
	});
	/* 确认密码  */
	$(".input-password2").focus(function(){
		if($(this).val() == ""){
			$(this).layoutFocus("6~16位的数字和字母组成");
			$(this).parent().find(".tipError").remove();
			$(this).parent().find(".tipOk").remove();
		}
		$(this).css("border-color","#ddd");
	});
	$(".input-password2").blur(function(){
		$(this).parent().find(".tip").remove();
		if($(this).val() == $(".input-password").val() && $(".input-password").val() != ""){
			$(this).layoutSuccess();
			$(this).css("border-color","#ddd");
		}else{
			$(this).layoutWarning("两次输入的密码不一致");
			$(this).css("border-color","red");
		}
	});

	$(".registerCode > .img-check").focus(function(){
		if($(this).val() == ""){
			$(this).parent().layoutFocus("请输入验证码");
			$(this).parent().parent().find(".tipError").remove();
			$(this).parent().parent().find(".tipOk").remove();
		}
	});
	$(".registerCode > .img-check").blur(function(){
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
	$(".ctnt").each(function(){
		var csp = $(this);
		$(this).find(".get-tel-check").click(function(){
			if($(this).parent().parent().find(".dynamicVerificationSpan").length > 0){
				return false;
			}else{
				var phone = $(".content1 .input-tel-num").val();
				$.ajax({
					url:"sendRegisterPhoneVarCode.html",
					type:"post",
					dataType:"json",
					data:{codePhone:phone},
					success:function(json){
						if(json.statu == 1){
							csp.find(".get-tel-check").parent().layoutCode("已发送，3分钟后可重新获取");
							csp.find(".get-tel-check").parent().parent().find(".tipOk").remove();
							csp.find(".get-tel-check").parent().parent().find(".tipError").remove();
						}else{
							csp.find(".get-tel-check").parent().layoutCode(json.message);
							csp.find(".get-tel-check").parent().parent().find(".tipOk").remove();
							csp.find(".get-tel-check").parent().parent().find(".tipError").remove();
						}
					}
				});
			}
			setTimeout(function(){
				$(".telCode").parent().parent().find(".dynamicVerificationSpan").remove();
				$(".get-tel-check").html("重新获取");
			},30000);
		});
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
/* 胥福星     2016-04-06  密码框提示span模拟   */
$(function(){
	$(".hint1").click(function(){
		 $(".input-password").focus();
	});
	$(".hint2").click(function(){
		 $(".input-password2").focus();
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
	$(".input-password2").focus(function(){
		$(this).parent().find(".hint").hide();
	});
	$(".input-password2").blur(function(){
		if($(this).val() == ""){
			$(this).parent().find(".hint").show();
		}else{
			$(this).parent().find(".hint").hide();
		}
	});
	
	//个人登录
	$(".content1 .register-btn").on("click",function(){
		
		
		
		var userName = $(".content1 .input-user-name").val();
		var userPhone= $(".content1 .input-tel-num").val();
		var userpassword= $(".content1 .input-password").val();
		var ruserpassword = $(".content1 .input-password2").val();
		var inviteCode= $(".content1 .input-invite-code").val();
		var imgCheck = $(".content1 .img-check").val();
		var telCheck = $(".content1 .tel-check").val();
		var optionsRadios = $("input[name='optionsRadios']:checked").val();
		
		
		var doorCtrl = true;
		
		
		var reg1 = new RegExp("^[a-zA-Z0-9]{6,30}$");
		if(!reg1.test(userName)){
			doorCtrl = false;
			$(".content1 .input-user-name").css("border-color","red");
			if($(".content1 .input-user-name").parent().find(".tipError").length > 0){
			}else{
				$(".content1 .input-user-name").layoutWarning("请输入数字或名字");
				$(".content1 .input-user-name").parent().find(".tipOk").remove();
			}
		}
		var reg2 = new RegExp("^[0-9]{11}$");
		if(!reg2.test(userPhone)){
			doorCtrl = false;
			$(".content1 .input-tel-num").css("border-color","red");
			if($(".content1 .input-tel-num").parent().find(".tipError").length > 0){
			}else{
				$(".content1 .input-tel-num").layoutWarning("11位数字");
				$(".content1 .input-tel-num").parent().find(".tipOk").remove();
			}
		}
		var reg3 = new RegExp(/^[a-zA-Z0-9]{6,16}$/);
		if(!reg3.test(userpassword)){
			doorCtrl = false;
			$(".content1 .input-password").layoutWarning("密码输入格式错误，请重新输入！");
			$(".content1 .input-password").parent().find(".tipOk").remove();
			$(".content1 .input-password").css("border-color","red");
		}
		if(!(ruserpassword == userpassword && userpassword != "")){
			doorCtrl = false;
			$(".content1 .input-password2").layoutWarning("输入的密码不一致");
			$(".content1 .input-password2").css("border-color","red");
		}
		var reg4 = new RegExp(/^[0-9]{12}$/);
		if(inviteCode != ""  && !reg4.test(inviteCode) && $(".content1 .input-invite-code").attr("value") != inviteCode){
			doorCtrl = false;
			$(".content1 .input-invite-code").layoutWarning("邀请码错误");
			$(".content1 .input-invite-code").css("border-color","red");
		}
		
	
		var reg5 = new RegExp("/^\d$/");
		if(!reg5.test(imgCheck)){
			doorCtrl = false;
			$(".content1 .img-check").css("border-color","red");
			$(".content1 .img-check").parent().layoutWarning("验证码错误");
			$(".content1 .img-check").parent().parent().find(".tipOk").remove();
		}

		var reg6 = new RegExp("/^[0-9]{5,6}$/");
		if(reg6.test(telCheck)){
			doorCtrl = false;
			$(".content1 .tel-check").parent().layoutSuccess();
			$(".content1 .tel-check").parent().parent().find(".tipError").remove();
			$(".content1 .tel-check").css("border-color","#ddd");
			$(".content1 .tel-check").parent().parent().find(".dynamicVerificationSpan").remove();
		}else{
			$(".content1 .tel-check").parent().layoutWarning("验证码错误,请重新输入");
			$(".content1 .tel-check").parent().parent().find(".tipOk").remove();
			$(".content1 .tel-check").css("border-color","red");
			$(".content1 .tel-check").parent().parent().find(".dynamicVerificationSpan").remove();
		}
		
		
		
		if(!doorCtrl){
			return false;
		}
		
		$.ajax({
			url:"register.html",
			type:"post",
			dataType:"json",
			data:{logname:userName,memberPwd:userpassword,confirmPassword:ruserpassword,beinvitateCode:inviteCode,personalPhone:userPhone,checkCoede:imgCheck,phoneCheckCode:telCheck,memberType:optionsRadios},
			success:function(json){
				if(json.statu == 0){
					alert("注册成功");
				}else{
					alert(json.message);
				}
			}
		});
	});
	
	//企业登录
	$(".content2 .register-btn").on("click",function(){
		
	});
	
	
	
	
	
	
	
	
	
	
	
});
//验证
/*$(function(){
	validform5(".register-btn",,postonce,tipsType,fun)
})*/