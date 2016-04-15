$(function(){
	$(".TB").addClass("down");
	$(".TB2").addClass("down2");
});
/* 安全中心页面js代码  */
$(function(){
	$(".tdSpan").each(function(){
		if($(this).html().match("已验证") || $(this).html().match("已绑定") || $(this).html().match("已开通") || $(this).html().match("已设置") || $(this).html().match("已选择")){
			$(this).addClass("tdAuthen");
		}else if($(this).html().match("未验证") || $(this).html().match("未开通")  || $(this).html().match("未绑定")  || $(this).html().match("未设置")  || $(this).html().match("未选择")){
			$(this).addClass("tdUnauth");
		}
		if($(".certification").html().match("已验证") && $(".account").html().match("未开通")){
			$(this).parent().find(".certificationSpan").show();
			$(this).parent().find(".accountSpan").show();
		}else if($(".certification").html().match("未验证")){
			$(this).parent().find(".linkUnauthen").show();
			$(this).parent().find(".accountSpan").hide();
		}
		if($(this).html().match("已设置")){
			$(this).parent().find(".linkUnset").hide();
		}else{
			$(this).parent().find(".linkUnset").show();
		}
		if($(this).html().match("已绑定")){
			$(this).parent().find(".linkAlert").show();
		}else{
			$(this).parent().find(".unbound").show();
		}
		if($(this).html().match("已选择") || $(this).html().match("--")){
			$(this).parent().find(".linkAlert").show();
		}
	});
});
/* 单选框点击事件     */
$(function(){
	$(".radio").click(function(){
		$(this).addClass("checked").siblings(".radio").removeClass("checked");
	});
	$("#contetnList").focus(function(){
		$(this).tip1("请输入邮箱");
	});
});

$(function(){
	/*弹出层伍成然2016-4-6*/
	$(".email-btn").click(function(){
		layer.open({
			title :false,//标题
			closeBtn:false,
	        type: 1,
	        area: ['386px', '148px'],//大小宽*高
	        shadeClose: true, //点击遮罩关闭
	        content: $('.emailChange')//内容，里边是包含内容的div的class
	    });
	});
	$(".changeValidate").click(function(){
		layer.open({
			title :'选择登录验证方式',//标题
			skin: 'layer-ext-myskin',//皮肤
	        type: 1,
	        area: ['488px', '354px'],//大小宽*高
	        shadeClose: true, //点击遮罩关闭
	        content: $('.validateMethod')//内容，里边是包含内容的div的class
	    });
	});
	/*弹出层中单选框切换伍成然2016-4-6*/
	$(".radioclass2").click(function(){
		$(".radio-select2").addClass("on");
		$(".radio-select1").removeClass("on");
	});
	$(".radioclass1").click(function(){
		$(".radio-select1").addClass("on");
		$(".radio-select2").removeClass("on");
	});
	
});
/* 邮箱绑定弹出提示层 */
$(function(){
	/* 绑定邮箱js */
	$(".entryEmail").focus(function(){
		if(this.value == ""){
			$(this).layoutFocus("邮箱号和绑定的邮箱号一致才可以修改");
			$(this).parent().find(".tipError").remove();
			$(this).parent().find(".tipOk").remove();
		}
	});
	$(".entryEmail").blur(function(){
		var str = this.value;
		var reg = new RegExp("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$");
		$(this).parent().find(".tip").remove();
		if(reg.test(str)){
			$(this).layoutSuccess();
			$(this).parent().find(".tipError").remove();
		}else{
			$(this).layoutWarning("请输入正确的邮箱格式");
			$(this).parent().find(".tipOk").remove();
		}
	});
	/* 更换邮箱js */
	$(".entryEmailChange").focus(function(){
		if(this.value == ""){
			$(this).layoutFocus("邮箱号和绑定的邮箱号一致才可以修改");
			$(this).parent().find(".tipError").remove();
			$(this).parent().find(".tipOk").remove();
		}
	});
	$(".entryEmailChange").blur(function(){
		var str = this.value;
		var reg = new RegExp("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$");
		$(this).parent().find(".tip").remove();
		if(reg.test(str)){
			$(this).layoutSuccess();
			$(this).parent().find(".tipError").remove();
		}else{
			$(this).layoutWarning("请输入正确的邮箱格式");
			$(this).parent().find(".tipOk").remove();
		}
	});
	$(".captChaChange > .code").focus(function(){
		if($(this).val() == ""){
			$(this).parent().layoutFocus("请输入您的验证码");
			$(this).parent().parent().find(".tipError").remove();
			$(this).parent().parent().find(".tipOk").remove();
		}
	});
	$(".captChaChange > .code").blur(function(){
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
	$(".newEmail").focus(function(){
		if(this.value == ""){
			$(this).layoutFocus("请输入您的新邮箱号码");
			$(this).parent().find(".tipError").remove();
			$(this).parent().find(".tipOk").remove();
		}
	});
	$(".newEmail").blur(function(){
		var str = this.value;
		var reg = new RegExp("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$");
		$(this).parent().find(".tip").remove();
		if(reg.test(str)){
			$(this).layoutSuccess();
			$(this).parent().find(".tipError").remove();
		}else{
			$(this).layoutWarning("请输入正确的邮箱格式");
			$(this).parent().find(".tipOk").remove();
		}
	});
	/* 更换手机绑定   */
	$(".phoneBind").focus(function(){ 
		if($(this).val() == ""){
			$(this).layoutFocus("手机号和绑定的手机号一致才可以修改");
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
	$(".phoneBind").blur(function(){
		$(this).parent().find(".tip").remove();
	});
	/* 更换手机号码    修改    2016-04-10  胥福星 */
	$(".newphone").focus(function(){
		if($(this).val() == ""){
			$(this).layoutFocus("手机号和绑定的手机号一致才可以修改");
			$(this).parent().find(".tipError").remove();
			$(this).parent().find(".tipOk").remove();
		}
	});
	$(".newphone").keyup(function(){
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
				$(this).layoutWarning("请输入正确的手机号码");
				$(this).parent().find(".tipOk").remove();
			}
		}
	});
	$(".newphone").blur(function(){
		$(this).parent().find(".tip").remove();
	});
	/* 图片验证码验证   */
	$(".phoneCode > .code").focus(function(){
		if($(this).val() == ""){
			$(this).parent().layoutFocus("请输入您的验证码");
			$(this).parent().parent().find(".tipError").remove();
			$(this).parent().parent().find(".tipOk").remove();
		}
	});
	$(".phoneCode > .code").blur(function(){
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
		$(this).parent().find(".tip").remove();
	});
	/* 验证码提示层 手机验证码     */
	$(".codeBtn").click(function(){
		if($(this).parent().parent().find(".dynamicVerificationSpan").length > 0){
			return false;
		}else{
			$(this).parent().layoutCode("已发送，3分钟后可重新获取");
			$(this).parent().parent().find(".tipOk").remove();
			$(this).parent().parent().find(".tipError").remove();
		}
		setTimeout(function(){
			$(".codeBtn").parent().parent().find(".dynamicVerificationSpan").remove();
			$(".codeBtn").html("重新获取");
		},30000);
	});
	$(".codeGet").blur(function(){
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
	/* 重置密码js */
	$(".password").focus(function(){
		if(this.value == ""){
			$(this).layoutFocus("6~16位字符，可以使用字母、数字、字符组合");
			$(this).parent().find(".tipError").remove();
			$(this).parent().find(".tipOk").remove();
		}
	});
	$(".password").blur(function(){
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
		$(this).parent().find(".tip").remove();
	});
	$(".newPassword").focus(function(){
		if(this.value == ""){
			$(this).layoutFocus("6~16位字符，可以使用字母、数字、字符组合");
			$(this).parent().find(".tipError").remove();
			$(this).parent().find(".tipOk").remove();
		}
	});
	$(".newPassword").blur(function(){
		var str = this.value;
		var reg = new RegExp(/^[a-zA-Z0-9]{6,16}$/);
		$(this).parent().find(".tip").remove();
		if(reg.test(str)){
			$(this).layoutSuccess();
			$(this).parent().find(".tipError").remove();
		}else{
			$(this).layoutWarning("密码错误，请重新输入！");
			$(this).parent().find(".tipOk").remove();
		}
	});
	$(".okPassword").focus(function(){
		$(this).layoutFocus("6~16位字符，可以使用字母、数字、字符组合");
		$(this).parent().find(".tipError").remove();
		$(this).parent().find(".tipOk").remove();
	});
	$(".okPassword").blur(function(){
		$(this).parent().find(".tip").remove();
		if($(this).val() == $(".newPassword").val() && $(".newPassword").val() != ""){
			$(this).layoutSuccess();
		}else{
			$(this).layoutWarning("输入的密码不一致");
		}
	});
	/* 实名认证 身份证验证js */
	$(".personId").focus(function(){
		if($(this).val() == ""){
			$(this).layoutFocus("请输入您的身份证号");
			$(this).parent().find(".tipError").remove();
			$(this).parent().find(".tipOk").remove();
		}
	});
	$(".personId").keyup(function(){
		var str = this.value;
		var reg = new RegExp(/^(\d{15}$|^\d{18}$|^\d{17}(\d|X|x))$/); 
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
				$(this).layoutWarning("请输入正确的身份证号");
				$(this).parent().find(".tipOk").remove();
			}
		}
	});
	$(".personId").blur(function(){
		$(this).parent().find(".tip").remove();
	});
});


/* 胥福星     2016-04-06  密码框提示span模拟   */
$(function(){
	$(".hint1").click(function(){
		 $(".password").focus();
	});
	$(".hint2").click(function(){
		 $(".newPassword").focus();
	});
	$(".hint4").click(function(){
		 $(".okPassword").focus();
	});
	$(".password").focus(function(){
		$(this).parent().find(".hint3").hide();
	});
	$(".password").blur(function(){
		if($(this).val() == ""){
			$(this).parent().find(".hint3").show();
		}else{
			$(this).parent().find(".hint3").hide();
		}
	});
	$(".newPassword").focus(function(){
		$(this).parent().find(".hint3").hide();
	});
	$(".newPassword").blur(function(){
		if($(this).val() == ""){
			$(this).parent().find(".hint3").show();
		}else{
			$(this).parent().find(".hint3").hide();
		}
	});
	$(".okPassword").focus(function(){
		$(this).parent().find(".hint3").hide();
	});
	$(".okPassword").blur(function(){
		if($(this).val() == ""){
			$(this).parent().find(".hint3").show();
		}else{
			$(this).parent().find(".hint3").hide();
		}
	});
});