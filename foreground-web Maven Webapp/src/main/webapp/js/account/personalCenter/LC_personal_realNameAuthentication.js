$(function(){
//	2016-4-28 付晨早
	$(".personId").keyup(function(){
		if($(this).val().length>=18){
			//console.log(1);
			var num = $(this).val().charAt(16);
			if (parseInt(num)%2 == 0){
				$(".gender").html("女");
			}else{
				$(".gender").html("男");
			}
		}
	});
	
	$("#shiMing1").Validform({
		tiptype:3,//提示信息类型
		btnSubmit:".btn1", 
		datatype:extdatatype,
		ajaxPost:true,
		beforeSubmit:function(){
			$(".btn1").attr("disabled","true");
			var encrypt = new JSEncrypt();
			encrypt.setPublicKey(publickey);
			var url = "personalCenter/personalRealName.html";
			//必填
			var data={};
			var editType  = $(".editType").val();
			data.editType = encrypt.encrypt(editType+"");
			var userName=$(".realName").val();
			data.userName=encrypt.encrypt(userName+"");
			var idCard = $(".personId").val();
			data.idCard=encrypt.encrypt(idCard+"");
			//选填
			var nationId =  $(".selectValue").attr("value");
			if (nationId!= 0){
				data.nationId = encrypt.encrypt(nationId+"");
			}
			var homeTown =$(".homeTown").val();
			if (homeTown!="请输入籍贯"){
				data.homeTown = encrypt.encrypt(homeTown+"");
			}
			var endTime = $(".dateSelect").val();
			if (endTime!=undefined&&endTime!="请选择有效期"&&endTime!=""){
				data.endTime = encrypt.encrypt(endTime+"");
			}
			var img1 = $(".previewHide").eq(0).val();
			var img2 = $(".previewHide").eq(1).val();
			if (img1!=null&&img2!=null){
				data.annex = img1+","+img2;
			}
			NetUtil.ajax(
					url,
					data,
					function(r){
						$(".btn1").attr("disabled","false");
						//console.log(r)
						var json = JSON.parse(r)
						if (json.status == 0){
							layer.alert("提交成功",function(index){
								layer.close(index);
								var url  = document.referrer;
								referURL(url);
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
	});		
}
function referURL(url){
	var isIe=(document.all)?true:false;
	if(isIe) {
		var linka = document.createElement("a");
		linka.href=url;
		document.body.appendChild(linka);
		linka.click();
	}else {
		window.location = url;
	}
}
function dealRealName(data){
	if(data!=null && data!=""){
		var realName = data.realName;
		var personalIDCard = data.personalIDCard;
		var sexId =data.sexId;
		var sex ="";
		if(sexId==0){
			sex="男";
		}else{
			sex="女";
		}
		var homeTown = data.homeTown;
		var aationId = data.aationId;//民族Id
		var nationName = data.nationName;
		var endDate = data.sEndDate;
		if(data.positive!=undefined){
			var img1 = data.attachPrefix+data.positive;
			$("#previewImg1").attr("src",img1);
		}
		if(data.reverse!=undefined){
			var img2 = data.attachPrefix+data.reverse;
			$("#previewImg2").attr("src",img2);
		}
		var statu = data.status;
		if(statu=="0" || statu=="3" || statu=="4"){
			$(".editType").val("0");
		}else{
			$(".editType").val("1");
		}
		if(realName!=""){
			$(".realName").val(realName);
		}
		if(personalIDCard!=""){
			$(".personId").val(personalIDCard);
		}
		if(aationId!=""){
			$(".nationSelect .selectValue").attr("value",aationId);
			$(".nationSelect .selectInput").val(nationName);
		}
		if(homeTown!=""){
			$(".homeTown").val(homeTown);
		}
		if(sex!=""){
			$(".gender").html(sex);
		}
		if(endDate!=""){
			$(".dateSelect ").val(endDate);
		}
	}
}

