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
		alert(phone);
		$.ajax({
			url:"sendRegisterPhoneVarCode.html",
			type:"post",
			dataType:"json",
			data:{codePhone:phone},
			success:function(json){
				if(json.statu == 1){
					$item.val("已发送");
				}else{
					$item.val("发送失败");
				}
			}
		});
	});
	setTimeout(function(){
		$(".get-tel-check").val("重新获取")
	},30000);
});

	
	
function checkPersonalName(memberName){
	if(memberName == undefined || memberName == null || memberName == ""){
		return false;
	}
	$.ajax({
		url:"checkName.html",
		type:"post",
		data:{userName:memberName},
		success:function(json){
			return json;
		}
	});
}

function checkPersonalPhone(phone){
	if(phone == undefined || phone == null || phone == ""){
		return false;
	}
	$.ajax({
		url:"checkPhone.html",
		type:"post",
		data:{phone:phone},
		success:function(json){
			return json;
		}
	});
}

function checkCountInvitateCode(sinvitateCode){
	if(invitateCode == undefined || invitateCode == null || invitateCode == ""){
		return false;
	}
	$.ajax({
		url:"countInvitateCode.html",
		type:"post",
		data:{invitateCode:sinvitateCode},
		success:function(json){
			return json;
		}
	});
}


/* 验证     */
$(function(){
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
						console.log(data.status);
					}
				}
			});
			return true;
			*/
			
			
			
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
			sendDate.beinvitateCode = inviteCode;
			sendDate.personalPhone = userPhone;
			sendDate.checkCoede = imgCheck;
			sendDate.phoneCheckCode = telCheck;
			sendDate.memberType = optionsRadios;
			
			
			var vsign = sendBef(sendDate);
			$.ajax({
				url:"register.html",
				type:"post",
				dataType:"json",
				data:{sign:vsign,logname:userName,memberPwd:userpassword,confirmPassword:ruserpassword,beinvitateCode:inviteCode,personalPhone:userPhone,checkCoede:imgCheck,phoneCheckCode:telCheck,memberType:optionsRadios},
				success:function(json){
					if(json.statu == 0){
						alert("注册成功");
					}else{
						alert(json.message);
					}
				}
			});
			return false;
	    }
	});
	
	app.addRule([{
        ele: ".input-user-name",
        //datatype: "logname",
        nullmsg: "请输入用户名！",
        ajaxurl: "checkName.html",
        errormsg: "用户名由 6-18位的字母下划线和数字组成！至少6个字符,最多18个字符！"
    },{
        ele: ".input-tel-num",
        //datatype: "logname",
        //nullmsg: "请输入用户名！",
        ajaxurl: "checkPhone.html",
        //errormsg: "用户名由 6-18位的字母下划线和数字组成！至少6个字符,最多18个字符！"
    }]);
	
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
			sendDate.beinvitateCode = inviteCode;
			sendDate.personalPhone = userPhone;
			sendDate.checkCoede = imgCheck;
			sendDate.phoneCheckCode = telCheck;
			sendDate.memberType = optionsRadios;
			
			
			var vsign = sendBef(sendDate);
			console.log(vsign);
			$.ajax({
				url:"register.html",
				type:"post",
				dataType:"json",
				data:{sign:vsign,logname:userName,memberPwd:userpassword,confirmPassword:ruserpassword,beinvitateCode:inviteCode,personalPhone:userPhone,checkCoede:imgCheck,phoneCheckCode:telCheck,memberType:optionsRadios},
				success:function(json){
					if(json.statu == 0){
						alert("注册成功");
					}else{
						alert(json.message);
					}
				}
			});
			return false;
		}
	});
	
	
	app2.addRule([{
        ele: ".input-user-name",
        //datatype: "logname",
        nullmsg: "请输入用户名！",
        ajaxurl: "checkName.html",
        errormsg: "用户名由 6-18位的字母下划线和数字组成！至少6个字符,最多18个字符！"
    },{
        ele: ".input-tel-num",
        //datatype: "logname",
        //nullmsg: "请输入用户名！",
        ajaxurl: "checkPhone.html",
        //errormsg: "用户名由 6-18位的字母下划线和数字组成！至少6个字符,最多18个字符！"
    }]);
	
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
        var md5_value = hex_md5(code).toUpperCase();
        console.log("string to sign:" + code);
        return md5_value;
    }
    return null;
}
