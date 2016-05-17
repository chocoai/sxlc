$(function(){
//	2016-4-28 付晨早
	$(".personId").keyup(function(){
		if($(this).val().length>=18){
			//console.log(1);
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
			var encrypt = new JSEncrypt();
			encrypt.setPublicKey(publickey);
			var url = "personalCenter/personalRealName.html";
			//必填
			var data={};
			var data.userName = encrypt.encrypt($(".realName").val()+"");
			var data.idCard = encrypt.encrypt($(".personId").val()+"");
			//选填
			var nationId =  $(".selectValue").attr("value");
			if (nationId!= 0){
				data.nationId = encrypt.encrypt(nationId+"")
			}
			var homeTown =$(".homeTown").val();
			if (homeTown!="请输入籍贯"){
				data.homeTown = encrypt.encrypt(homeTown+"")
			}
			var endTime = (".dateSelect").val();
			if (endTime!=undefined&&endTime!="请选择有效期"&&endTime!=""){
				data.endTime = encrypt.encrypt(homeTown+"")
			}
			var img1 = $(".previewHide").eq(0).val();
			var img2 = $(".previewHide").eq(1).val();
			if (img1!=null&&img2!=null){
				data.annex = encrypt.encrypt(img1+","+img2+"")
			}
			NetUtil.ajax(
					url,
					data,
					function(r){
						console.log(r)
						var json = JSON.parse(r)
						if (json.status == 1){
							layer.alert("提交成功",function(index){
								layer.close(index);
								window.location = "personalCenter/loanCertification.html";
							})
						}else{
							layer.alert(json.message);
						}
					}
			)
			
			return false;
		}
	});
	showAuthRealName();
})
function showAuthRealName(){
	$.ajax({
		type:"GET",
		url:"personalCenter/showAuthRealName.html",
		async:true,
		success:function(r){
			var object=JSON.parse(r);
			if(object.status == 0){
				var data = object.data;
				dealRealName(data);
			}
		}
	})		
}
function dealRealName(data){
	if(data!=null && data!=""){
		var realName = data.realName;
		var personalIDCard = data.personalIDCard;
		var sexId =data.sexId;
		var sex ="";
		if(sexId=0){
			sex="女";
		}else{
			sex="男";
		}
		var homeTown = data.homeTown;
		var aationId = data.aationId;//民族Id
		var nationName = data.nationName;
		var endDate = data.endDate;
		var img1 = data.attachPrefix+data.positive;
		var img2 = data.attachPrefix+data.reverse;
		var statu = data.status;
		if(statu=="0" || statu=="3" || statu=="4"){
			$(".editType").val("0");
		}else{
			$(".editType").val("1");
		}
		$(".realName").val(realName);
		$(".personId").val(personalIDCard);
		$(".nationSelect .selectValue").val(aationId);
		$(".nationSelect .selectInput").val(nationName);
		$(".homeTown").val(homeTown);
		$(".gender").html(sex);
		$(".dateSelect ").val(endDate);
		$("#previewImg1").attr("src",img1);
		$("#previewImg2").attr("src",img2);
	}
}