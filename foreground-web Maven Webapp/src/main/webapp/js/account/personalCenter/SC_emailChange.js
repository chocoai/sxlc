$(function(){
	//发送邮箱验证码
	$(".codeBtn").on("click",function(){
		var entryEmail = $(".emailNew").val();
		if(entryEmail!="undefined"){
			var encrypt = new JSEncrypt();
			encrypt.setPublicKey(publickey);
			entryEmail = encrypt.encrypt(entryEmail+"");
			var str_Url = "personalCenter/sendBindEmailCheckCode.html";
			var json_Data = {email:entryEmail};
			NetUtil.ajax(
				str_Url, 
				json_Data, 
				function(r){
					console.log(r);
					var json = JSON.parse(r);
					if(json.status == 1){
						$(".codeBtn").html("已发送").addClass("disabled");
						setTimeout(function(){
							$(".codeBtn").html("重新发送").removeClass("disabled");
						},30000);
						
					}else{
						$(".codeBtn").html("发送失败");
					}
				}
			)
		}else{
			layer.alert("请输入邮箱")
		}
	});
	$(".codeImg").on("click",function(){
		$(".codeImg").attr("src","authImage.html?parma="+Math.random() * 10);
	});
	//修改邮箱
	$("#securityCheck1").Validform({
		tiptype:3,//提示信息类型
		btnSubmit:".email-btn", //#btn_sub是该表单下要绑定点击提交表单事件的按钮;如果form内含有submit按钮该参数可省略;
		//btnReset:"#btnreset1",
		datatype:extdatatype,//扩展验证类型
		//showAllError:true,//提交前验证显示所有错误
		ajaxPost:true,
		beforeSubmit:function(){
			var encrypt = new JSEncrypt();
			encrypt.setPublicKey(publickey);
//						旧邮箱
			var emailOriginal = $(".emailOriginal").val();
			emailOriginal = encrypt.encrypt(emailOriginal+"");
//			新邮箱
			var emailNew = $(".emailNew").val();
			emailNew = encrypt.encrypt(emailNew+"");
//						验证码
			var e_imgCode = $(".imgCode").val();
			e_imgCode = encrypt.encrypt(e_imgCode+"");
//						邮箱验证码
			var dynamicCode = $(".dynamicCode").val();
			dynamicCode = encrypt.encrypt(dynamicCode+"");
			
			var str_Url = "personalCenter/editBindEmail.html";
			NetUtil.ajax(
				str_Url,
				{oldEmail:emailOriginal,newEmail:emailNew,checkCode:e_imgCode,emailCode:dynamicCode},
				function(r){
					var r = JSON.parse(r);
					if (r.status == "1"){
						layer.alert("修改成功",function(){
							window.location = "personalCenter/securityCenter.html";
						})
					}else{
						layer.alert(r.message)
					}
				}
			)
			return false;
		}
	});
	
})