/** 查看担保机构详情 **/
//加密操作
var encrypt = new JSEncrypt();
encrypt.setPublicKey(publicKey_common);
//担保机构信息页面加载赋值
$(function () {
	var guId = $("#guId").val();
	var result = encrypt.encrypt(guId + "");
	$.ajax({
		type : 'post',
		url : appPath + "/guarant/query4select.do",
		data : {guaranteeId : result},
		success : function (msg) {
			$("#guaranteeName").text(msg.guaranteeName);
			$("#companyeBLN").text(msg.companyeBLN);
			$("#companyOC").text(msg.companyOC);
			$("#taxRegNo").text(msg.taxRegNo);
			$("#establishments").text(msg.establishments);
			$("#companyCapital").text(msg.companyCapital);
			$("#personalName").text(msg.personalName);
			$("#personalPhone").text(msg.personalPhone);
			$("#personalIDCard").text(msg.personalIDCard);
			$("#companyAddress").text(msg.companyAddress);
			$("#companySource").text(msg.companySource);
			$("#companyBusiness").text(msg.companyBusiness);
			$("#companyProfile").text(msg.companyProfile);
			$("#contactName").text(msg.contactName);
			$("#contactPhone").text(msg.contactPhone);
			$("#contactEmail").text(msg.contactEmail);
			
		}
	});
});

//证件信息加载赋值
$(function () {
	var guId = $("#guId").val();
	var result = encrypt.encrypt(guId + "");
});