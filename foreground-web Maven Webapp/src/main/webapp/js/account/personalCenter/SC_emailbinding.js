		/* 验证     */
$(function(){
	//验证邮箱是否存在
	$(".entryEmail").on("blur",function(){
		var $this = $(this);
		if ($(this).next().hasClass("Validform_right")){
			var url = "personalCenter/checkEmail.html";
			var encrypt = new JSEncrypt();
			encrypt.setPublicKey(publickey);
			var email = encrypt.encrypt($(this).val()+"");
			NetUtil.ajax(
					url,
					{email:email},
					function(r){
						var data = JSON.parse(r);
						if (data.status == "1"){
							$(".codeBtn").removeClass("disabled");
						}else{
//							layer.alert(data.message,function(index){
//								layer.close(index);
//								$(".codeBtn").addClass("disabled");
//							});
							$this.errorPrompt(data.message);
							$(".codeBtn").addClass("disabled");
							
						}
					}
			)
		}
	})
	
	
	
	
	//发送邮箱验证
	$(".codeBtn").on("click",function(){
		var entryEmail = $(".entryEmail").val();
		var imgCode = $(".imgCode").val();
		if (imgCode == "请输入验证码"){
			layer.alert("请输入验证码");
			return false;
		}
		var $item = $(this);
		if(entryEmail!="请输入您的邮箱号"){
			var encrypt = new JSEncrypt();
			encrypt.setPublicKey(publickey);
			entryEmail = encrypt.encrypt(entryEmail+"");
			var str_Url = "personalCenter/sendBindEmailCheckCode.html";
			var json_Data = {email:entryEmail,imgCheckCode:encrypt.encrypt(imgCode+"")};
			$(".codeBtn").html("发送中").addClass("disabled");
			NetUtil.ajax(
				str_Url, 
				json_Data, 
				function(r){
					var json = JSON.parse(r);
					if(json.status == 1){
						layer.alert("发送成功",function(index){
							layer.close(index);
							var setTime = 60 ; //60秒
							var run = setInterval(function(){
								$item.html(setTime+"s");
								setTime--;
								if (setTime < 0 ){
									clearInterval(run);
									$item.html("重新发送");
									$item.removeClass("disabled");
								}
							},1000);
						})
					}else{
						layer.alert(json.message,function(index){
							layer.close(index);
							$(".codeBtn").html("重新发送").removeClass("disabled");
							$(".codeImg").attr("src","authImage.html?parma="+Math.random() * 10);
						})
						
					}
				}
			)
		}else{
			layer.alert("请输入您的邮箱号")
		}
	});
	$(".codeImg").on("click",function(){
		$(".codeImg").attr("src","authImage.html?parma="+Math.random() * 10);
	});
	
	$("#securityCheck1").Validform({
		tiptype:5,//提示信息类型
		btnSubmit:".email-btn", //#btn_sub是该表单下要绑定点击提交表单事件的按钮;如果form内含有submit按钮该参数可省略;
		//btnReset:"#btnreset1",
		datatype:extdatatype,//扩展验证类型
		//showAllError:true,//提交前验证显示所有错误
		ajaxPost:true,
		beforeCheck:function(){
			if ($(".Validform_wrong").size()>0){
				return false
			}else{
				return true
			}
		},
		beforeSubmit:function(){
			var encrypt = new JSEncrypt();
			encrypt.setPublicKey(publickey);
//						邮箱
			var entryEmail = $(".entryEmail").val();
			entryEmail = encrypt.encrypt(entryEmail+"");
//						验证码
			var e_imgCode = $(".imgCode").val();
			e_imgCode = encrypt.encrypt(e_imgCode+"");
//						邮箱验证码
			var dynamicCode = $(".dynamicCode").val();
			dynamicCode = encrypt.encrypt(dynamicCode+"");

			var str_Url = "personalCenter/bindEmail.html";
			$(".email-btn").html("绑定中").addClass("disabled");
			NetUtil.ajax(
				str_Url,
				{email:entryEmail,checkCode:e_imgCode,emailCheckCode:dynamicCode},
				function(r){
					//console.log(r)
					var r = JSON.parse(r);
					if (r.status == "1"){
						layer.alert("绑定成功",function(index){
							layer.close(index);
							window.location = "personalCenter/securityCenter.html";
						})
					}else{
						layer.alert(r.message);
						$(".email-btn").html("立即绑定").removeClass("disabled");
						$(".codeImg").attr("src","authImage.html?parma="+Math.random() * 10);
					}
				}
			)
			
			return false;
		}
	});
});