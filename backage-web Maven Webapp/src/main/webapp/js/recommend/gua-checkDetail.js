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
			console.log(msg.compensationStatisticsEntity);
			$("#guaranteeName").text(msg.guaranteeInfoEntity.guaranteeName);
			$("#companyeBLN").text(msg.guaranteeInfoEntity.companyeBLN);
			$("#companyOC").text(msg.guaranteeInfoEntity.companyOC);
			$("#taxRegNo").text(msg.guaranteeInfoEntity.taxRegNo);
			$("#establishments").text(msg.guaranteeInfoEntity.establishments);
			$("#companyCapital").text(msg.guaranteeInfoEntity.companyCapital);
			$("#personalName").text(msg.guaranteeInfoEntity.personalName);
			$("#personalPhone").text(msg.guaranteeInfoEntity.personalPhone);
			$("#personalIDCard").text(msg.guaranteeInfoEntity.personalIDCard);
			$("#companyAddress").text(msg.guaranteeInfoEntity.companyAddress);
			$("#companySource").text(msg.guaranteeInfoEntity.companySource);
			$("#companyBusiness").text(msg.guaranteeInfoEntity.companyBusiness);
			$("#companyProfile").text(msg.guaranteeInfoEntity.companyProfile);
			$("#contactName").text(msg.guaranteeInfoEntity.contactName);
			$("#contactPhone").text(msg.guaranteeInfoEntity.contactPhone);
			$("#contactEmail").text(msg.guaranteeInfoEntity.contactEmail);
			if (msg.lBorrowingEntities.length >0) {
				$("#moneyMin").text(msg.lBorrowingEntities[0].minAmount);
				$("#moneyMax").text(msg.lBorrowingEntities[0].maxAmount);
			};
			if (msg.lGuaranteeRelationalEntities.length > 0) {
				$("#jtype").text(msg.lGuaranteeRelationalEntities[0].projectName);
			}
			if (msg.lGuaranteePeriodEntities.length > 0) {
				$("#min").text(msg.lGuaranteePeriodEntities[0].minDeadline);
				$("#max").text(msg.lGuaranteePeriodEntities[0].maxDeadline);
				$("#btype").text(msg.lGuaranteePeriodEntities[0].deadlineType);
			}
			if (msg.compensationStatisticsEntity != null) {
				$("#sgn").text(msg.compensationStatisticsEntity.numberOfSuccessful);
				$("#sjn").text(msg.compensationStatisticsEntity.successfulCompensation);
				$("#sbn").text(msg.compensationStatisticsEntity.compensatoryPaymentNumber);
			}
			if (msg.lCertificateEntities.length > 0) {
				$.each(msg.lCertificateEntities, function (i, item) {
					$("#fileList").html("<img src=\""+item.guaranteeURL+"\" />");
				});
				
			}
			
			if (msg.memberThirdAuthInfoEntity !=null) {
				$("#tirdnum").text(msg.memberThirdAuthInfoEntity.memberThirdInfoEntity.thirdPartyAccount);
				$("#currentMoney").text(msg.memberThirdAuthInfoEntity.memberThirdInfoEntity.userBalances);
				if (msg.memberThirdAuthInfoEntity.openAutoPay ==0) {
					$("#isOrno").text("否");
				}else {
					$("#isOrno").text("是");
				}
			}
			
			if (msg.compensationStatisticsEntity != null) {
				$("#sumMoney").text(msg.compensationStatisticsEntity.totalCompensationAmount);
				$("#backMoney").text(msg.compensationStatisticsEntity.allCompensatoryPayment);
				$("#nobackMoney").text(msg.compensationStatisticsEntity.noCompensatoryPayment);
			}
			
		}
	});
});
