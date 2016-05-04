$(function(){
//	2016-4-28 付晨早
	$(".personId").keyup(function(){
		if($(this).val().length>=18){
			console.log(1);
			var num = $(this).val().charAt(16);
			if (parseInt(num)%2 == 0){
				$(".gender").html("女")
			}else{
				$(".gender").html("男")
			}
		}
	});
	
	$("#shiMing1").Validform({
		tiptype:3,//提示信息类型
		btnSubmit:".btn1", 
		datatype:extdatatype,
		ajaxPost:true,
		beforeSubmit:function(){
			//缺：图片是否上传判断
			console.log($(".selectValue").attr("value"))
			var encrypt = new JSEncrypt();
			encrypt.setPublicKey(publickey);
			var url = "personalCenter/personalRealName.html";
			var userName = encrypt.encrypt($(".realName").val()+"");
			var nationId =  encrypt.encrypt($(".selectValue").attr("value")+"");
			var idCard = encrypt.encrypt($(".personId").val()+"");
			var homeTown = encrypt.encrypt($(".homeTown").val()+"");
			var endTime = encrypt.encrypt($(".dateSelect").val()+"");
			var annex = encrypt.encrypt("abcd.jpg,abcd1.jpg"+"");//暂时固定
			var data = {userName:userName,nationId:nationId,idCard:idCard,homeTown:homeTown,
					endTime:endTime,annex:annex};
			console.log(data);
			NetUtil.ajax(
					url,
					data,
					function(r){
						console.log(r)
						if (r.status == ""){
							
						}
						
					}
			)
			
			return false;
		}
	});
	
})