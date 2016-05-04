/** 查看资产管理方信息 **/
var encrypt = new JSEncrypt();
encrypt.setPublicKey(publicKey_common);
//页面加载赋值
$(function () {
	var managementID = encrypt.encrypt($("#managementID").val() + "");
	$.ajax({
		type : 'post',
		url : appPath + "/asset/query4mod.do",
		data : {
			managementID : managementID
		},
		success : function (msg) {
			$("#managementName").text(msg.managementName);
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
	
	$.ajax({
		type : 'post',
		url : appPath + "/asset/query4Certificate.do",
		data : {
			managementID : managementID
		},
		success : function (msg) {
			var str = "";
			if (msg.length > 0) {
				$.each(msg, function (i, item) {
					str += "<div class=\"assetimg\">"+
								"<img src=\""+item.managementURL+"\"/>"+
							"</div>";
				});
				$("#certificateUrl").html(str);
			}
		}
	});
});