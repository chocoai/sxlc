$(function(){
	//编辑器实例化
	var ue1 = UE.getEditor('resiverText',{
		maximumWords:2000
	});
	$("#sendMail").Validform({
		tiptype:3,//提示信息类型
		btnSubmit:".sentSubmit", //#btn_sub是该表单下要绑定点击提交表单事件的按钮;如果form内含有submit按钮该参数可省略;
		//btnReset:"#btnreset1",
		datatype:extdatatype,//扩展验证类型
		//showAllError:true,//提交前验证显示所有错误
		ajaxPost:true,
		beforeSubmit:function(curform){
			var data={};
			//创建加密对象
			var encrypt = new JSEncrypt();
			encrypt.setPublicKey(publickey);
			
			var recName = $("#recName").val();
			var title = $(".resiverTitle").val();
			var content = ue1.getContent();
			var imgCode = $("#imgCode").val();
			
			data.recName = encrypt.encrypt(recName+"");
			data.title = encrypt.encrypt(title+"");
			data.content = content;
			data.imgCode = encrypt.encrypt(imgCode+"");
			var url = "message/addStationLetter.html";
			
			NetUtil.ajax(
				url,
				data,
				function(r){
					var message = JSON.parse(r);
					$(".codeImg").attr("src","authImage.html?type=2&parma="+Math.random() * 10);
					if(message.statu==-1){
						layer.alert(message.message);
					}else{
						layer.alert(message.message,function(){
							history.back();
						});
					}
				}
			);
			return false;
		}
	});
	$(".codeImg").on("click",function(){
		$(this).attr("src","authImage.html?type=2&parma="+Math.random() * 10);
	})
});