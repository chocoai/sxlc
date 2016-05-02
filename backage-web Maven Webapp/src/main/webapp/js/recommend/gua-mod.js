/** 修改担保机构 **/
//加密操作
var encrypt = new JSEncrypt();
encrypt.setPublicKey(publicKey_common);
//页面加载赋值
$(function () {
	var guId = $("#guId").val();
	var result = encrypt.encrypt(guId + "");
	$.ajax({
		type : 'post',
		url : appPath + "/guarant/query4select.do",
		data : {guaranteeId : result},
		success : function (msg) {
			$("#guaranteeName").val(msg.guaranteeName);
			$("#companyeBLN").val(msg.companyeBLN);
			$("#companyOC").val(msg.companyOC);
			$("#taxRegNo").val(msg.taxRegNo);
			$("#establishments").val(msg.establishments);
			$("#companyCapital").val(msg.companyCapital);
			$("#personalName").val(msg.personalName);
			$("#personalPhone").val(msg.personalPhone);
			$("#personalIDCard").val(msg.personalIDCard);
			$("#companyAddress").val(msg.companyAddress);
			$("#companySource").val(msg.companySource);
			$("#companyBusiness").val(msg.companyBusiness);
			$("#companyProfile").val(msg.companyProfile);
			$("#contactName").val(msg.contactName);
			$("#contactPhone").val(msg.contactPhone);
			$("#contactEmail").val(msg.contactEmail);
			
		}
	});
});
//触发验证
$(function () {
	$(".layui-layer-btn0").bind('click', function () {
		$("#manageMod").submit();
	});
});
//修改担保机构
function modgua () {
	var guaranteeName = encrypt.encrypt($("#guaranteeName").val());
	var companyeBLN = encrypt.encrypt($("#companyeBLN").val() + "");
	var companyOC = encrypt.encrypt($("#companyOC").val() + "");
	var taxRegNo = encrypt.encrypt($("#taxRegNo").val() + "");
	var establishments = encrypt.encrypt($("#establishments").val());
	var companyCapital = encrypt.encrypt($("#companyCapital").val());
	var personalName = encrypt.encrypt($("#personalName").val());
	var personalPhone = encrypt.encrypt($("#personalPhone").val() + "");
	var personalIDCard = encrypt.encrypt($("#personalIDCard").val() + "");
	var companyAddress = encrypt.encrypt($("#companyAddress").val());
	var companySource = encrypt.encrypt($("#companySource").val());
	var companyBusiness = encrypt.encrypt($("#companyBusiness").val());
	var companyProfile = encrypt.encrypt($("#companyProfile").val());
	var contactName = encrypt.encrypt($("#contactName").val());
	var contactPhone = encrypt.encrypt($("#contactPhone").val() + "");
	var contactEmail = encrypt.encrypt($("#contactEmail").val());
	var types = encrypt.encrypt(1 + "");
	var guaranteeId = encrypt.encrypt(guId + "");
	
	$.ajax({
		type : 'post',
		url :　appPath + "/guarant/save.do",
		data : {
			guaranteeName : guaranteeName,
			companyeBLN : companyeBLN,
			companyOC : companyOC,
			taxRegNo : taxRegNo,
			establishments : establishments,
			companyCapital : companyCapital,
			personalName : personalName,
			personalPhone : personalPhone,
			personalIdCard : personalIDCard,
			companyAddress : companyAddress,
			companySource : companySource,
			companyBusiness : companyBusiness,
			companyProfile : companyProfile,
			contactName : contactName,
			contactPhone : contactPhone,
			contactEmail : contactEmail,
			types : types,
			guaranteeId : guaranteeId
			},
		success : function (data) {
			if (data == 0) {
				layer.alert("添加成功",{icon:1});  
				document.getElementById("manageMod").reset();
				setTimeout('location.reload()',2000);
			}else {
				layer.alert("服务器异常",{icon:2});
				document.getElementById("manageMod").reset();
			}
		}
	});
	
}