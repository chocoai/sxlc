/** 修改资产管理方 **/
//加密操作
var encrypt = new JSEncrypt();
encrypt.setPublicKey(publicKey_common);
//页面加载赋值
$(function () {
	var managementID = $("#managementID").val();
	var result = encrypt.encrypt(managementID + "");
	$.ajax({
		type : 'post',
		url : appPath + "/asset/query4mod.do",
		data : {managementID : result},
		success : function (msg) {
			$("#managementName").val(msg.managementName);
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
$(function () {
	$(".commonbtn0").bind('click', function () {
		$("#manageAdd").submit();
	});
});

function modManage() {
	
	var managementID = $("#managementID").val();
	var managementName = $("#managementName").val();
	var companyeBLN = $("#companyeBLN").val();
	var companyOC = $("#companyOC").val();
	var taxRegNo = $("#taxRegNo").val();
	var establishments = $("#establishments").val();
	var companyCapital = $("#companyCapital").val();
	var personalName = $("#personalName").val();
	var personalPhone = $("#personalPhone").val();
	var personalIDCard = $("#personalIDCard").val();
	var companyAddress = $("#companyAddress").val();
	var companySource = $("#companySource").val();
	var companyBusiness = $("#companyBusiness").val();
	var companyProfile = $("#companyProfile").val();
	var contactPhone = $("#contactPhone").val();
	var contactName = $("#contactName").val();
	var contactEmail = $("#contactEmail").val();
	
	managementID = encrypt.encrypt(managementID + "");
	managementName = encrypt.encrypt(managementName + "");
	companyeBLN = encrypt.encrypt(companyeBLN + "");
	companyOC = encrypt.encrypt(companyOC + "");
	taxRegNo = encrypt.encrypt(taxRegNo + "");
	establishments = encrypt.encrypt(establishments + "");
	companyCapital = encrypt.encrypt(companyCapital + "");
	personalName = encrypt.encrypt(personalName + "");
	personalPhone = encrypt.encrypt(personalPhone + "");
	personalIDCard = encrypt.encrypt(personalIDCard + "");
	companyAddress = encrypt.encrypt(companyAddress + "");
	companySource = encrypt.encrypt(companySource + "");
	companyBusiness = encrypt.encrypt(companyBusiness + "");
	companyProfile = encrypt.encrypt(companyProfile + "");
	contactPhone = encrypt.encrypt(contactPhone + "");
	contactName = encrypt.encrypt(contactName + "");
	contactEmail = encrypt.encrypt(contactEmail + "");
	var types = encrypt.encrypt(0 + "");
	
	$.ajax({
		type : 'post',
		url :　appPath + "/asset/save.do",
		data : {
			managementName : managementName,
			companyeBLN : companyeBLN,
			companyOC : companyOC,
			taxRegNo : taxRegNo,
			establishments : establishments,
			companyCapital : companyCapital,
			personalName : personalName,
			personalPhone : personalPhone,
			personalIDCard : personalIDCard,
			companyAddress : companyAddress,
			companySource : companySource,
			companyBusiness : companyBusiness,
			companyProfile : companyProfile,
			contactName : contactName,
			contactPhone : contactPhone,
			contactEmail : contactEmail,
			managementID : managementID,
			types : types
			},
		success : function (data) {
			if (data == 1) {
				layer.alert("添加成功",{icon:1});  
				document.getElementById("manageAdd").reset();
				setTimeout('location.reload()',2000);
			}else {
				layer.alert("服务器异常",{icon:2});
				document.getElementById("manageAdd").reset();
			}
		}
	});
	
	
	
}