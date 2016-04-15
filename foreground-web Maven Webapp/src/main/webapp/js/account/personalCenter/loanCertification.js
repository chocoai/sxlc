$(function(){
	$(".TB").addClass("down");
	$(".TB7").addClass("down2");
});
/*  个人认证和企业认证的样式切换代码      */
$(function(){
	$(".th span").each(function(){
		$(this).click(function(){
			var index = $(this).index();
			$(this).addClass("thClick").siblings().removeClass("thClick");
			$(this).parent().parent().children("ul").eq(index).show();
			$(this).parent().parent().children("ul").eq(index).siblings("ul").hide();
		});
	});
});
/*   end     */
/*  已认证、未认证等显示的链接页面不一的代码         */
$(function(){
	$(".tdSpan").each(function(){
		if($(this).html().match("已认证") || $(this).html().match("已审核") || $(this).html().match("已通过")){
			$(this).addClass("tdAuthen");
		}else if($(this).html().match("审核中")){
			$(this).addClass("tdReview");
		}else if($(this).html().match("未通过")){
			$(this).addClass("tdFile");
		}else if($(this).html().match("已过期")){
			$(this).addClass("tdOutOfDate");
		}else if($(this).html().match("未认证")){
			$(this).addClass("tdUnauth");
		}
		if($(this).html().match("已认证") || $(this).html().match("审核中")){
			$(this).parent().find(".linkCheck").show();
		}else if($(this).html().match("已过期") || $(this).html().match("未通过")){
			$(this).parent().find(".linkAlert").show();
		}else if($(this).html().match("未认证")){
			$(this).parent().find(".linkAuthen").show();
		}
	});
});
/*   end    */
/* 添加认证      */
$(function(){
	/*  end   */
	/*  认证收缩         */
	$(".addAuthen").click(function(){
		var content = $(".authen").clone();
		$(this).parent().parent().append(content);
	});
});
function scale(obj){
	if(!$(obj).hasClass("authenScaleClick")){
		$(obj).addClass("authenScaleClick").removeClass("authenScaleBtn");
		$(obj).parent().parent().find(".inputArea").hide();
	}else{
		$(obj).removeClass("authenScaleClick").addClass("authenScaleBtn");
		$(obj).parent().parent().find(".inputArea").show();
	}
}
/*    图片上传预览             */
/*      end      */
$(function(){
	/* 手机验证js代码     */
	$(".phoneBind").focus(function(){
		if(this.value == ""){
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
	$(".phoneBind").blur(function(){
		$(this).parent().find(".tip").remove();
	});
	/* 法人身份认证 身份证验证js */
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
