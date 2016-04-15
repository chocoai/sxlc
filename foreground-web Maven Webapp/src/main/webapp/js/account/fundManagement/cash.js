$(function(){
	$(".TC").addClass("down");
	$(".TC2").addClass("down2");
});


/* 2016-04-06  胥福星   弹出层提示  */
$(function(){
	$(".cashInput1").focus(function(){
		$(this).parent().layoutFocus("需大于1元");
	});
	$(".cashInput1").blur(function(){
		$(this).parent().parent().find(".tip").remove();
	});
});
/* 获取动态验证码的弹出提示层js代码  */
jQuery.fn.layoutCode = function(str){
	var s = str;
	var m = '<span class="dynamicVerificationSpan">' + s + '</span>';
	this.parent().css('position','relative');
	this.parent().append(m);
	this.parent().find(".dynamicVerificationSpan").css("left",this.offset().left - this.parent().offset().left + this.innerWidth() + 10);
	this.parent().find(".dynamicVerificationSpan").css("top",this.offset().top - this.parent().offset().top );
};
$(function(){
	/* 验证码提示层      */
	$(".codeGet").click(function(){
		if($(this).parent().parent().find(".dynamicVerificationSpan").length > 0){
			return false;
		}else{
			$(this).parent().layoutCode("已发送，3分钟后可重新获取");
			$(this).parent().parent().find(".tipOk").remove();
			$(this).parent().parent().find(".tipError").remove();
		}
		setTimeout(function(){
			$(".codeGet").parent().parent().find(".dynamicVerificationSpan").remove();
			$(".codeGet").html("重新获取");
		},30000);
	});
	$(".cashCodeGet").blur(function(){
		var str = this.value;
		var reg = new RegExp("^[0-9]{5,6}$");
		if(reg.test(str)){
			$(this).parent().layoutSuccess();
			$(this).parent().parent().find(".tipError").remove();
			$(this).css("border-color","#ddd");
			$(".codeGet").parent().parent().find(".dynamicVerificationSpan").remove();
		}else{
			$(this).parent().layoutWarning("验证码错误,请重新输入");
			$(this).parent().parent().find(".tipOk").remove();
			$(this).css("border-color","red");
			$(".codeGet").parent().parent().find(".dynamicVerificationSpan").remove();
		}
	});
});

/* 判断是否小于起充值   */
$(function(){
	$(".cashFormat").blur(function(){
		if(parseFloat(this.value) < 1){
			this.value = parseFloat(1).toFixed(2);
		}
	});
});