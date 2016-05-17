//2016-4-29 付晨早  9：50am
	

	$(function(){
		//图形验证码切换
		$(".codeImg").on("click",function(){
			$(".codeImg").attr("src","authImage.html?parma="+Math.random() * 10);
		});
		
		var encrypt = new JSEncrypt();
		encrypt.setPublicKey(publickey);
		var addSecret = function(str){
			return encrypt.encrypt(str+"");
		}
		
		
		$("#securityCheck1").Validform({
			tiptype:3,//提示信息类型
			btnSubmit:".phoneSubmit", //#btn_sub是该表单下要绑定点击提交表单事件的按钮;如果form内含有submit按钮该参数可省略;
			//btnReset:"#btnreset1",
			datatype:extdatatype,//扩展验证类型
			//showAllError:true,//提交前验证显示所有错误
			ajaxPost:true,
			beforeSubmit:function(){
				var encrypt = new JSEncrypt();
				encrypt.setPublicKey(publickey);
				var oldPassword = hex_md5($(".password").val());
				var newPassword = hex_md5($(".newPassword").val());
				var confirmPwd = hex_md5($(".okPassword").val());
				var imgCheckCode = $(".imgCode").val();
				//console.log([oldPassword,newPassword,confirmPwd,imgCheckCode]);
				var str_Url = "personalCenter/resetPassword.html";
				var data = {oldPassword:addSecret(oldPassword),newPassword:addSecret(newPassword),
						confirmPwd:addSecret(confirmPwd),imgCheckCode:addSecret(imgCheckCode)};
				NetUtil.ajax(
						str_Url,
						data,
						function(r){
							var json = JSON.parse(r);
							if(json.status == "1"){
								layer.alert(json.message,function(){
									window.location = "personalCenter/securityCenter.html";
								});
							}else{
								layer.alert(json.message,function(index){
									layer.close(index);
									$(".codeImg").attr("src","authImage.html?parma="+Math.random() * 10);
								});
							}
							
						}
				);
				
				return false
			}
		});
	});