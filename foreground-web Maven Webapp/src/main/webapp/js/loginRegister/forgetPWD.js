/*伍成然2016-3-27*/

$(function(){
	
	function settime(val) {
		var countdown = 180;
		val.addClass("disabled");
		var run = setInterval(function(){
			
			val.val(countdown+"s");
			countdown--;
			if (countdown<=0){
				clearInterval(run);
				val.val("重新发送");
				val.removeClass("disabled");
			}
		},1000)
//		if (countdown == 0) {
//			val.removeAttribute("disabled");
//			val.value = "获取验证码";
//			isExit==false;
//			countdown = 180;
//		} else {
//			val.setAttribute("disabled", true);
//			val.value = "重新发送(" + countdown + ")";
//			countdown--;
//		}
//		setTimeout(function() {
//			settime(val)
//		}, 1000)
	}
	/*跳转流程*/
	/*$(".next-btn").on("click",function(){
		$(".input-group1").removeClass("on");
		$(".input-group2").addClass("on");
		layer.closeAll('tips'); //关闭所有的tips层
	});
	$(".submit-btn").on("click",function(){
		$(".input-group2").removeClass("on");
		$(".info").addClass("on");
						
	});*/
	$(".forgetPWDCode img").on("click",function(){
		$(".forgetPWDCode img").attr("src","authImage.html?type=1&parma="+Math.random() * 10);
	});
	$(".imgCode img").on("click",function(){
		$(".forgetPWDCode img").attr("src","authImage.html?type=1&parma="+Math.random() * 10);
	});
	$("#sendForgetPWDPhoneVarCode").on("click",function(){
		$item = $(this);
		var logName=$(this).parent().parent().parent().find(".input-user-name").val();
		var phone = $(this).parent().parent().parent().find(".input-tel-num").val();
		var imgCode = $(this).parent().parent().parent().find(".img-check").val();
		$.ajax({
			url:"sendForgetPWDPhoneVarCode.html",
			type:"post",
			dataType:"json",
			data:{"loginName":logName,"phone":phone,"imgCode":imgCode},
			success:function(json){
				if(json.statu == 1){
					settime($item);
				}else if(json.statu == 2){
					$(this).parent().parent().parent().find(".img-check").val("");
					$(".forgetPWDCode img").attr("src","authImage.html?type=1&parma="+Math.random() * 10);
					layer.alert("请输入有效的手机号");
					$item.val("发送失败");
				}else if(json.statu == 3){
					$(this).parent().parent().parent().find(".img-check").val("");
					$(".forgetPWDCode img").attr("src","authImage.html?type=1&parma="+Math.random() * 10);
					layer.alert("请输入图片验证码");
					$item.val("发送失败");
				}else if(json.statu == 4){
					$(this).parent().parent().parent().find(".img-check").val("");
					$(".forgetPWDCode img").attr("src","authImage.html?type=1&parma="+Math.random() * 10);
					layer.alert("图片验证码错误");
					$item.val("发送失败");
				}else if(json.statu == 0){
					$(this).parent().parent().parent().find(".img-check").val("");
					$(".forgetPWDCode img").attr("src","authImage.html?type=1&parma="+Math.random() * 10);
					layer.alert("您的用户名或手机号错误");
					$item.val("发送失败");
				}else{
					$item.val("发送失败");
				}
			},
			error:function(){
				layer.alert("网络错误，请稍后重试");
			}
		});
	});
	setTimeout(function(){
		$(".get-tel-check").val("重新获取")
	},30000);
});





var isExit = false;

/* 验证     */
$(function(){
	$("#forgetPWDbox").Validform({
		tiptype:3,//提示信息类型
		btnSubmit:".next-btn", //#btn_sub是该表单下要绑定点击提交表单事件的按钮;如果form内含有submit按钮该参数可省略;
		//btnReset:"#btnreset1",
		datatype:extdatatype,//扩展验证类型
		ajaxPost:true,
		beforeSubmit:function(){
			if(isExit){
				return false;
			}
			isExit = true;
			var logName=$("#forgetPWDbox .input-user-name").val();
			var phone = $("#forgetPWDbox .input-tel-num").val();
			var imgCode = $("#forgetPWDbox .img-check").val();
			var code = $("#forgetPWDbox .tel-check").val();
			$.ajax({
				url:"checkForgetPWD.html",
				data:{"loginName":logName,"phone":phone,"imgCode":imgCode,"code":code},
				dataType:"json",
				type:"post",
				async:false,
				success:function(message){
					if(message.statu==1){
						$("#setNewPWD_form .imgCode img").attr("src","authImage.html?type=1&parma="+Math.random() * 10);
						$(".forgetPWD-box").hide();
						$(".input-group2").show();
					}else if(message.statu==-1){
						layer.alert(message.message);
					}
					return false;
				},
				error:function(){
					layer.alert("网络错误");
					return false;
				}
			});
			return false;
		}
	});
});




$(function(){
	$("#setNewPWD_form").Validform({
		tiptype:3,//提示信息类型
		btnSubmit:".submit-btn", //#btn_sub是该表单下要绑定点击提交表单事件的按钮;如果form内含有submit按钮该参数可省略;
		datatype:extdatatype,//扩展验证类型
		ajaxPost:true,
		beforeSubmit:function(){
			var phone = $("#forgetPWDbox .input-tel-num").val();
			var logName=$("#forgetPWDbox .input-user-name").val();
			
			var newPWD="";
			var newPassWord1 = $(".password-new").val();
			var newPassWord2 = $(".password-new2").val();
			if(newPassWord1==newPassWord2){
				newPWD = hex_md5(newPassWord1);
			}else{
				return false;
			}
			
			var imgCode = $("#setNewPWD_form .img-check").val();
			$.ajax({
				url:"setNewPassWord.html",
				data:{"loginName":logName,"phone":phone,"imgCode":imgCode,"newPassWord":newPWD},
				dataType:"json",
				type:"post",
				success:function(message){
					if(message.statu==1){
						window.location.href="forgetPWDSuccess.html";
					}else if(message.statu==-1){
						$("#setNewPWD_form .imgCode img").attr("src","authImage.html?type=1&parma="+Math.random() * 10);
						layer.alert(message.message);
					}
					return false;
				},
				error:function(){
					layer.alert("网络错误");
					return false;
				}
			})
			return false;
		}
	});
});
