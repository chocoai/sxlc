	/* 验证     */
$(function(){
	var encrypt = new JSEncrypt();
	encrypt.setPublicKey(publickey);
	
	
	//逐项验证。。。。1.输入旧手机
	$(".phoneBind").on("blur",function(){
		var $this = $(this);
		if ($(this).next().hasClass("Validform_right")){
			var url = "personalCenter/checkOldPhone.html";
			var phone = encrypt.encrypt($(this).val()+"");
			NetUtil.ajax(
					url,
					{phone:phone},
					function(r){
						var data = JSON.parse(r);
						if (data.status == "1"){
							$(".newphone").removeProp("disabled");
						}else{
//							layer.alert(data.message,function(index){
//								layer.close(index);
//								
//							});
							$(".newphone").prop("disabled",true);
							$(".codeBtn").addClass("disabled");
							$this.errorPrompt(data.message);
						}
					}
			)
		}
	})
	//新手机是否存在
	
	$(".newphone").on("blur",function(){
		var $this = $(this);
		if ($(this).next().hasClass("Validform_right")){
			var url = "personalCenter/checkPhone.html";
			var phone = encrypt.encrypt($(this).val()+"");
			NetUtil.ajax(
					url,
					{phone:phone},
					function(r){
						var data = JSON.parse(r);
						if (data.status == "y"){
							$(".codeBtn").removeClass("disabled");
						}else{
//							layer.alert(data.info,function(index){
//								layer.close(index);
//								
//							});
							$this.errorPrompt(data.info);
							$(".codeBtn").addClass("disabled")
						}
					})
			}
	})
	
	
	
	
	/* 发送手机验证码 */
	$(".codeBtn").on("click",function(){
		var phone = $(".newphone").val();
		var imgCode = $(".imgCode").val();
		if (imgCode == "请输入验证码"){
			layer.alert("请输入验证码");
			return false;
		}
		var $item = $(this);
		if(phone!="请输入您的新手机号"){
			var encrypt = new JSEncrypt();
			encrypt.setPublicKey(publickey);
			phone = encrypt.encrypt(phone+"");
			var str_Url = "personalCenter/sendEditBindPhoneCheckCode.html";
			var json_Data = {phone:phone,imgCheckCode:encrypt.encrypt(imgCode+"")};
			$item.addClass("disabled").html("发送中");
			NetUtil.ajax(
				str_Url, 
				json_Data, 
				function(r){
					var json = JSON.parse(r);
					if(json.status == 1){
						layer.alert("发送成功",function(index){
							layer.close(index);
							var setTime = 60 ; //60秒
							$item.addClass("disabled");
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
							$(".codeBtn").html("重新发送");
							$item.removeClass("disabled");
							$(".codeImg").attr("src","authImage.html?parma="+Math.random() * 10);
						})
					}
				}
			)
		}else{
			layer.alert("请输入您的新手机号");
		}
	});
	
	$(".codeImg").on("click",function(){
		$(".codeImg").attr("src","authImage.html?parma="+Math.random() * 10);
	});
	
	//修改手机号码
	$("#securityCheck1").Validform({
		tiptype:5,//提示信息类型
		btnSubmit:".qwertyu", //#btn_sub是该表单下要绑定点击提交表单事件的按钮;如果form内含有submit按钮该参数可省略;
		datatype:extdatatype,//扩展验证类型
		ajaxPost:true,
		beforeCheck:function(){
			if ($(".Validform_wrong").size()>0){
				return false
			}else{
				return true
			}
		},
		beforeSubmit:function(){
			
			
			var soldPhone = $(".phoneBind").val();
			soldPhone = encrypt.encrypt(soldPhone+"");
			
			var snewPhone = $(".newphone").val();
			snewPhone = encrypt.encrypt(snewPhone+"");
			
			var simgCheckCode = $(".imgCode").val();
			simgCheckCode = encrypt.encrypt(simgCheckCode+"");
			
			var sphoneCode = $(".codeGet").val();
			sphoneCode = encrypt.encrypt(sphoneCode+"");
			
			var str_Url = "personalCenter/editBindPhone.html";
			$(".qwertyu").html("修改中").addClass("disabled");
			NetUtil.ajax(
				str_Url,
				{oldPhone:soldPhone,newPhone:snewPhone,imgCheckCode:simgCheckCode,phoneCode:sphoneCode},
				function(r){
					var json = JSON.parse(r);
					if(json.status == "1"){
						layer.alert("修改成功",function(){
							window.location = "personalCenter/securityCenter.html";
						});
					}else {
						layer.alert(json.message);
						$(".qwertyu").html("确定").removeClass("disabled");
						$(".codeImg").attr("src","authImage.html?parma="+Math.random() * 10);
					}
				}
			)
			return false;
		},
	});
});