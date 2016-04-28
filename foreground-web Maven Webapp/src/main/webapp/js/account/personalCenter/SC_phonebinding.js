	/* 验证     */
$(function(){
	/* 发送手机验证码 */
	$(".codeBtn").on("click",function(){
		var phone = $(".newphone").val();
		if(phone!="undefined"){
			var encrypt = new JSEncrypt();
			encrypt.setPublicKey(publickey);
			phone = encrypt.encrypt(phone+"");
			var str_Url = "personalCenter/sendEditBindPhoneCheckCode.html";
			var json_Data = {phone:phone};
			NetUtil.postRequest(
				str_Url, 
				json_Data, 
				null, 
				function(r){
					console.log(r);
					var json = JSON.parse(r);
					if(json.status == 1){
						$(".codeBtn").html("已发送");
						//差一个禁用标签
						setTimeout(function(){
							$(".codeBtn").html("重新发送");
						},3000);
						
					}else{
						$(".codeBtn").html("发送失败")
					}
				}
			)
		}else{
			layer.alert("请输入新手机号码");
		}
	});
	$(".codeImg").on("click",function(){
		$(".codeImg").attr("src","authImage.html?parma="+Math.random() * 10);
	});
	
	//修改手机号码
	$("#securityCheck1").Validform({
		tiptype:3,//提示信息类型
		btnSubmit:".qwertyu", //#btn_sub是该表单下要绑定点击提交表单事件的按钮;如果form内含有submit按钮该参数可省略;
		datatype:extdatatype,//扩展验证类型
		ajaxPost:true,
		beforeSubmit:function(){
			var encrypt = new JSEncrypt();
			encrypt.setPublicKey(publickey);
			
			var soldPhone = $(".phoneBind").val();
			soldPhone = encrypt.encrypt(soldPhone+"");
			
			var snewPhone = $(".newphone").val();
			snewPhone = encrypt.encrypt(snewPhone+"");
			
			var simgCheckCode = $(".imgCode").val();
			simgCheckCode = encrypt.encrypt(simgCheckCode+"");
			
			var sphoneCode = $(".codeGet").val();
			sphoneCode = encrypt.encrypt(sphoneCode+"");
			
			var str_Url = "personalCenter/editBindPhone.html";
			
			NetUtil.postRequest(
				str_Url,
				{oldPhone:soldPhone,newPhone:snewPhone,imgCheckCode:simgCheckCode,phoneCode:sphoneCode},
				null,
				function(r){
					var json = JSON.parse(r);
					console.log(json)
					if(json.status == "1"){
						layer.alert("修改成功",function(){
							window.location = "personalCenter/securityCenter.html";
						});
					}else if(json.status == "-2"){
						if(json.phoneCode){
							layer.alert(json.phoneCode);
						};
						if(json.chekcCode){
							layer.alert(json.chekcCode);
						};
					}else{
						layer.alert(json.message);
					}
				}
			)
			return false;
		},
	});
});