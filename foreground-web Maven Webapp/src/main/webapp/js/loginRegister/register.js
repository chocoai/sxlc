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

/* 手机动态验证码      */
$(function(){
	$(".get-tel-check").on("click",function(){
		$item = $(this);
		var phone = $(this).parent().parent().parent().find(".input-tel-num").val();
		var imgCode = $(this).parent().parent().parent().find(".img-check").val();
		if (imgCode == "请输入图形验证码"){
			layer.alert("请输入图形验证码");
			return false;
		}
		var data = {codePhone:phone,imgCheckCode:imgCode};
		var vsign = sendBef(data);
		$.ajax({
			url:"sendRegisterPhoneVarCode.html",
			type:"post",
			dataType:"json",
			data:{codePhone:phone,imgCheckCode:imgCode,sign:vsign},
			success:function(json){
				if(json.statu == 1){
					layer.alert("发送成功",function(index){
						layer.close(index);
						var setTime = 60 ; //60秒
						$item.addClass("disabled");
						var run = setInterval(function(){
							$item.val(setTime+"s");
							setTime--;
							if (setTime <= 0 ){
								clearInterval(run);
								$item.val("重新发送");
								$item.removeClass("disabled");
							}
						},1000);
					})
				}else{
					layer.alert(json.message,function(index){
						layer.close(index);
						$(".imgCode").attr("src","authImage.html?parma="+Math.random() * 10);
						$item.val("重新发送");
					})
				}
			}
		});
	});
});

/* 验证     */
$(function(){
	$(".persolName").blur(function(){
		var $that = $(this);
		if ($that.next().hasClass("Validform_right")){
			NetUtil.ajax(
					"checkName.html",
					{param:$(this).val()},
					function(r){
						var data = JSON.parse(r);
						if (data.status == "y"){
							$that.next().removeClass("Validform_wrong").addClass("Validform_right").html("")
						}else{
							$that.next().removeClass("Validform_right").addClass("Validform_wrong").html(data.info)
						}
					}
			)
		}
	})
	
	$(".persolPhone").blur(function(){
		var $that = $(this);
		if ($that.next().hasClass("Validform_right")){
			NetUtil.ajax(
					"checkPhone.html",
					{param:$(this).val()},
					function(r){
						var data = JSON.parse(r);
						if (data.status == "y"){
							$that.next().removeClass("Validform_wrong").addClass("Validform_right").html("")
						}else{
							$that.next().removeClass("Validform_right").addClass("Validform_wrong").html(data.info)
						}
					}
			)
		}
	})
	
	$(".yaoqing").blur(function(){
		var $that = $(this);
		if ($(this).val()!=""&&$(this).val()!="请输入邀请码"){
			NetUtil.ajax(
					"countInvitateCode.html",
					{param:$(this).val()},
					function(r){
//						console.log(r);
						var data = JSON.parse(r);
						if (data.status == "y"){
							$that.next().removeClass("Validform_wrong").addClass("Validform_right").html("")
						}else{
							$that.next().removeClass("Validform_right").addClass("Validform_wrong").html(data.info)
						}
					}
			)
		}
	})
	
	
	
	var data = {};
	var app = $("#testbox").Validform({
		tiptype:3,//提示信息类型
		btnSubmit:".ctntRegisterSub", 
		datatype:extdatatype,//扩展验证类型
		//showAllError:true,//提交前验证显示所有错误
		timeout:1000,
		ajaxPost:true, 
		beforeSubmit:function(curform){
			/*getData();
			app.config({
				ajaxpost:{
					url:"register.html",
					type:"post",
					datatype:"json",
					data:getData(),
					success:function(data,obj){
						if(data.statu == 0){
							alert("注册成功");
						}else{
							alert(json.message);
						}
					},
					error:function(data,obj){
						//console.log(data.status);
					}
				}
			});
			return true;
			*/
			
			if (!$("#checkRule1").hasClass("active")){
				layer.alert("请同意注册协议条款");
				return false
			}
			
			var userName = $(".content1 .input-user-name").val();
			var userPhone= $(".content1 .input-tel-num").val();
			var userpassword= $(".content1 .input-password").val();
			var ruserpassword = $(".content1 .input-password2").val();
			var inviteCode= $(".content1 .input-invite-code").val();
			var imgCheck = $(".content1 .img-check").val();
			var telCheck = $(".content1 .tel-check").val();
			var optionsRadios = $("input[name='optionsRadios']:checked").val();
			
			userpassword = hex_md5(userpassword);
			ruserpassword = hex_md5(ruserpassword);
			
			//加密
			var sendDate = {};
			sendDate.logname = userName;
			sendDate.memberPwd = userpassword;
			sendDate.confirmPassword = ruserpassword;
			if (inviteCode != "请输入邀请码"){
				sendDate.beinvitateCode = inviteCode;
			}
			sendDate.personalPhone = userPhone;
			sendDate.checkCoede = imgCheck;
			sendDate.phoneCheckCode = telCheck;
			sendDate.memberType = optionsRadios;
			
			var vsign = sendBef(sendDate);
			sendDate.sign = vsign;
			$.ajax({
				url:"register.html",
				type:"post",
				dataType:"json",
				data:sendDate,
				success:function(json){
					if(json.statu == 0){
						layer.alert("注册成功",function(){
							window.location.href="accountOverview/accountOverview.html";
						});
					}else{
						layer.alert(json.message,function(index){
							layer.close(index);
							$(".imgCode").attr("src","authImage.html?parma="+Math.random() * 10);
						});
						
					}
				}
			});
			return false;
	    }
	});
	
	
	function getData(){
		//var data = {};
		data.logname = $(".content1 .input-user-name").val();
		data.personalPhone= $(".content1 .input-tel-num").val();
		data.memberPwd = hex_md5("123123123123");
		data.confirmPassword = hex_md5("123123123123");
		data.beinvitateCode= $(".content1 .input-invite-code").val();
		data.checkCoede = $(".content1 .img-check").val();
		data.phoneCheckCode = $(".content1 .tel-check").val();
		data.memberType = $("input[name='optionsRadios']:checked").val();
		//return data;
	}
});



$(function(){
	var app2 = $("#companyCheck").Validform({
		tiptype:3,//提示信息类型
		btnSubmit:".companySubmit", 
		datatype:extdatatype,//扩展验证类型
		ajaxPost:true,
		beforeSubmit:function(){
			
			if (!$("#checkRule2").hasClass("active")){
				layer.alert("请同意注册协议条款")
				return false
			}
			
			var userName = $(".content2 .input-user-name").val();
			var userPhone= $(".content2 .input-tel-num").val();
			var userpassword= $(".content2 .input-password").val();
			var ruserpassword = $(".content2 .input-password2").val();
			var inviteCode= $(".content2 .input-invite-code").val();
			var imgCheck = $(".content2 .img-check").val();
			var telCheck = $(".content2 .tel-check").val();
			var optionsRadios = $("input[name='optionsRadios']:checked").val();
			
			userpassword = hex_md5(userpassword);
			ruserpassword = hex_md5(ruserpassword);
			
			//加密
			var sendDate = {};
			sendDate.logname = userName;
			sendDate.memberPwd = userpassword;
			sendDate.confirmPassword = ruserpassword;
			
			if (inviteCode != "请输入邀请码"){
				sendDate.beinvitateCode = inviteCode;
			}
			sendDate.personalPhone = userPhone;
			sendDate.checkCoede = imgCheck;
			sendDate.phoneCheckCode = telCheck;
			sendDate.memberType = optionsRadios;
			
			var vsign = sendBef(sendDate);
			sendDate.sign = vsign;
			$.ajax({
				url:"register.html",
				type:"post",
				dataType:"json",
				data:sendDate,
				success:function(json){
					if(json.statu == 0){
						layer.alert("注册成功",function(){
							window.location.href="accountOverview/accountOverview.html";
						});
					}else{
						layer.alert(json.message,function(index){
							layer.close(index)
							$(".imgCode").attr("src","authImage.html?parma="+Math.random() * 10);
						});
					}
				}
			});
			return false;
		}
	});
	
	
	$(".imgCode").on("click",function(){
		$(".imgCode").attr("src","authImage.html?parma="+Math.random() * 10);
	});
});

function sendBef(params){
	 if (params) {
        var code = "";
        var keys = [];
        for (var x in params) {
            keys.push(x);
        }
        keys.sort();
        for (var i = 0; i < keys.length; i++) {
            var key = keys[i];
            code += key;
            code += params[key];
        }
        console.log(code);
        var md5_value = hex_md5(code).toUpperCase();
        return md5_value;
    }
    return null;
}
