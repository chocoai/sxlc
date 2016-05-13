/*伍成然2016-3-27*/
$(function(){
	/*企业个人单选框切换*/
	$(".radioclass2").click(function(){
		$(this).parent().addClass("on");
		$(this).parent().parent().siblings().find(".radio-select1").removeClass("on");
		$(this).attr("checked","checked");
		$(".radioclass1").attr("checked",false);
	});
	$(".radioclass1").click(function(){
		$(this).parent().addClass("on");
		$(this).parent().parent().siblings().find(".radio-select2").removeClass("on");
		$(this).attr("checked","checked");
		$(".radioclass2").attr("checked",false);
	});
	/*$(".radioclass1").click(function(){
		$(".radio-select1").addClass("on");
		$(".radio-select2").removeClass("on");
	});*/
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
});	
/*弹出层:提示输入手机号&提示密码*/	
$(function(){
	
	var cookie = getCookie("rememberMeInfo");
	if(cookie == null || cookie == undefined || cookie == ""){}else{
		var array = cookie.split("-");
		$(".content1 .input-user-name").val(array[0])
		if(array[1] == 0){
			$("input[class='radioclass1']").click();
		}else{
			$("input[class='radioclass2']").click();
		}
		$("input[name='rememberMe']").attr("checked",true);
		$("div[class='checkBox']").addClass("active");
	}
});



/* 胥福星     */
/* 20160417   */
/* 提交验证       */
var isExit = false;
$(".content1 .login-btn").on("click",function(){
/*	if(isExit){
		return false;
	}else{
		isExit = true;
	}
	
	var userName = $(".content1 .input-user-name").val();
	var userpassword= $(".content1 .input-password").val();
	var imgCheck = $(".content1 .img-check").val();
	var imemberType = $("input[name='radio']:checked").val();
	var irememberMe = 0;
	if($("input[name='rememberMe']").is(":checked")){
		irememberMe = 1;
	}
	
	var doorCtrl = true;
	
	var reg1 = new RegExp("(?!^(\\d+|[a-zA-Z]+|[\u4e00-\u9fa5]+)$)^[\\w\u4e00-\u9fa5]{6,16}$");
	if(!reg1.test(userName)){
			var reg = new RegExp(/^[0-9]{11}$/);
			if(!reg.test(userName)){
				doorCtrl = false;
				$(".content1 .input-user-name").css("border-color","red");
				if($(".content1 .input-user-name").parent().find(".tipError").length > 0){
				}else{
					$(".content1 .input-user-name").layoutWarning("请输入数字或名字");
					$(".content1 .input-user-name").parent().find(".tipOk").remove();
				}
			}else{
				if($(".content1 .input-user-name").parent().find(".tipOk").length > 0){
				}else{
					$(".content1 .input-user-name").layoutSuccess();
					$(".content1 .input-user-name").parent().find(".tipError").remove();
					$(".content1 .input-user-name").css("border-color","#ddd");
				}
			}
	}else{
		$(".content1 .input-user-name").css("border-color","#ddd");
		$(".content1 .input-user-name").parent().find(".tipError").remove();
		$(".content1 .input-user-name").layoutSuccess();
	}
	var reg2 = new RegExp(/^[a-zA-Z0-9]{6,16}$/);
	if(!reg2.test(userpassword)){
		doorCtrl = false;
		$(".content1 .input-password").layoutWarning("密码输入格式错误，请重新输入！");
		$(".content1 .input-password").parent().find(".tipOk").remove();
		$(".content1 .input-password").css("border-color","red");
	}else{
		$(".content1 .input-password").css("border-color","#ddd");
		$(".content1 .input-password").parent().find(".tipError").remove();
		$(".content1 .input-password").layoutSuccess();
	}

	var reg3 = new RegExp("^-?[0-9]*$");
	if(!reg3.test(imgCheck)){
		doorCtrl = false;
		$(".content1 .img-check").css("border-color","red");
		$(".content1 .img-check").parent().layoutWarning("验证码错误");
		$(".content1 .img-check").parent().parent().find(".tipOk").remove();
	}else{
		$(".content1 .img-check").css("border-color","#ddd");
		$(".content1 .img-check").parent().parent().find(".tipError").remove();
		$(".content1 .img-check").parent().layoutSuccess();
	}
	
	if(!doorCtrl){
		isExit = false;
		return false;
	}
	userpassword = hex_md5(userpassword);
	$.ajax({
		url:"login.html",
		type:"post",
		dataType:"json",
		data:{memberType:imemberType,memberName:userName,password:userpassword,checkCode:imgCheck,rememberMe:irememberMe},
		success:function(json){
			isExit = false;
			if(json.statu == 1){
				layer.open({
					content:json.message,
				});
			}else if(json.statu == -3){
				layer.open({
					content:json.message,
				});
			}else{
				if(json.memberName != ""){
					$(".content1 .input-user-name").css("border-color","red");
					if($(".content1 .input-user-name").parent().find(".tipError").length > 0){
					}else{
						$(".content1 .input-user-name").layoutWarning(json.memberName);
						$(".content1 .input-user-name").parent().find(".tipOk").remove();
					}
				}
				if(json.password != ""){
					$(".content1 .input-password").layoutWarning(json.password);
					$(".content1 .input-password").parent().find(".tipOk").remove();
					$(".content1 .input-password").css("border-color","red");
				}
				
				if(json.checkCode != ""){
					$(".content1 .img-check").css("border-color","red");
					$(".content1 .img-check").parent().layoutWarning(json.checkCode);
					$(".content1 .img-check").parent().parent().find(".tipOk").remove();
				}
			}
		}
	});
	*/
	
	
	
	
});

function getCookie(name){
　　var arr = document.cookie.match(new RegExp("(^| )"+name+"=([^;]*)(;|$)"));
　　if(arr != null){
	return unescape(arr[2]);
　　}　　　　
　　return null;
}


var isExit = false;
/* 验证     */
$(function(){
	$("#loginCheck").Validform({
		tiptype:3,//提示信息类型
		btnSubmit:".login-btn", 
		datatype:extdatatype,//扩展验证类型
		ajaxPost:true,
		beforeSubmit:function(){
			if(isExit){
				return false;
			}
			isExit = true;
			var userName = $(".content1 .input-user-name").val();
			var userpassword= $(".content1 .input-password").val();
			var imgCheck = $(".content1 .img-check").val();
			var imemberType = $("input[name='radio']:checked").val();
			var irememberMe = 0;
			if($("input[name='rememberMe']").is(":checked")){
				irememberMe = 1;
			}
			userpassword = hex_md5(userpassword);
			$.ajax({
				url:"login.html",
				type:"post",
				dataType:"json",
				data:{memberType:imemberType,memberName:userName,password:userpassword,checkCode:imgCheck,rememberMe:irememberMe},
				success:function(json){
					isExit = false;
					//console.log(json);
					if(json.statu == 1){
						window.location.href="accountOverview/accountOverview.html";
					}else if(json.statu == -3){
						$(".input-password").next().next().removeClass("Validform_right").addClass("Validform_wrong")
						.html(json.message)
						$(".codeDiv img").attr("src","authImage.html?parma="+Math.random() * 10);
					}else{
						layer.alert(json.message);
						$(".input-password").next().next().removeClass("Validform_right").addClass("Validform_wrong")
						.html(json.checkCode)
						$(".codeDiv img").attr("src","authImage.html?parma="+Math.random() * 10);
					}
				}
			});
			return false;
		}
	});
	
	$(".codeDiv img").on("click",function(){
		$(".codeDiv img").attr("src","authImage.html?parma="+Math.random() * 10);
	});
});