/** 添加担保机构 **/
//加密操作
var encrypt = new JSEncrypt();
encrypt.setPublicKey(publicKey_common);
function addguarant() {
	var guaranteeName = encrypt.encrypt($("#guaName").val());
	var companyeBLN = encrypt.encrypt($("#driveNum").val() + "");
	var companyOC = encrypt.encrypt($("#orgNum").val() + "");
	var taxRegNo = encrypt.encrypt($("#taxNum").val()) + "";
	var establishments = encrypt.encrypt($("#local").val());
	var companyCapital = encrypt.encrypt($("#money").val() + "");
	var personalName = encrypt.encrypt($("#personName").val());
	var personalPhone = encrypt.encrypt($("#personPhone").val() + "");
	var personalIdCard = encrypt.encrypt($("#personIDcard").val() + "");
	var companyAddress = encrypt.encrypt($("#address").val());
	var companySource = encrypt.encrypt($("#resource").val());
	var companyBusiness = encrypt.encrypt($("#range").val());
	var companyProfile = encrypt.encrypt($("#intro").val());
	var contactName = encrypt.encrypt($("#contactName").val());
	var contactPhone = encrypt.encrypt($("#contactPhone").val() + "");
	var contactEmail = encrypt.encrypt($("#email").val());
	var types = encrypt.encrypt(0 + "");
	var content = encrypt.encrypt($("#pictureUrl").val());
	
	$.ajax({
		type : 'post',
		url : appPath + "/guarant/save.do",
		data : {
			guaranteeName : guaranteeName,
			companyeBLN : companyeBLN,
			companyOC : companyOC,
			taxRegNo : taxRegNo,
			establishments : establishments,
			companyCapital : companyCapital,
			personalName : personalName,
			personalPhone : personalPhone,
			personalIdCard : personalIdCard,
			companyAddress : companyAddress,
			companySource : companySource,
			companyBusiness : companyBusiness,
			companyProfile : companyProfile,
			contactName : contactName,
			contactPhone : contactPhone,
			contactEmail : contactEmail,
			types : types
			},
		success : function (data) {
			if (data == 0) {
				layer.alert("添加成功",{icon:1});  
				document.getElementById("manageAdd").reset();
				setTimeout('location.reload()',2000);
			}else if (data == -1) {
				layer.alert("担保机构名称存在",{icon:2});
			}else if (data == -2) {
				layer.alert("营业执照号已存在",{icon:2});
			}else {
				layer.alert("服务器异常",{icon:2});
			}
		}
	});
	
}

//触发表单提交
$(function () {
	$(".layui-layer-btn0").bind('click', function () {
		$("#manageAdd").submit();
	});
});

