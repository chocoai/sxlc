/** 保荐机构充值 **/
var encrypt = new JSEncrypt();
encrypt.setPublicKey(publicKey_common);

$(".commonbtn0").bind('click', function () {
	var remark = $("#remarks").val();
	remark = encrypt.encrypt((remark + ""));
	$("#remark").val(remark);
	$("#rechargeform").submit();
});


$(function () {
	
	$("#rechargeTypes").bind('change', function () {
		var rechargeType = $(this).val();
		var amount = $("#amounts").val();
		
		
		if (rechargeType == "") {
			$("#rechargeC").text(0);
			$("#realMoney").text(parseInt(amount) - 0);
		}else if (rechargeType == 2) {
			if (parseInt(amount) >= 1000) {
				$("#rechargeC").text((parseInt(amount) / 1000));
				$("#realMoney").text(parseInt(amount) - ((parseInt(amount) / 1000)));
			}else {
				$("#rechargeC").text(1);
				$("#realMoney").text(parseInt(amount) - 1);
			}
		}else {
			$("#rechargeC").text(20);
			$("#realMoney").text(parseInt(amount) - 20);
		}
		
		rechargeType = encrypt.encrypt((rechargeType + ""));
		amount = encrypt.encrypt((amount + ""));
		
		$("#rechargeType").val(rechargeType);
		$("#amount").val(amount);
		
	});
	
	$("#amounts").bind('mouseout', function () {
		var rechargeType = $("#rechargeTypes").val();
		var amount = $(this).val();
		
		if (rechargeType == "") {
			$("#rechargeC").text(0);
			$("#realMoney").text(parseInt(amount) - 0);
		}else if (rechargeType == 2) {
			if (parseInt(amount) >= 1000) {
				$("#rechargeC").text((parseInt(amount) / 1000));
				$("#realMoney").text(parseInt(amount) - ((parseInt(amount) / 1000)));
			}else {
				$("#rechargeC").text(1);
				$("#realMoney").text(parseInt(amount) - 1);
			}
		}else {
			$("#rechargeC").text(20);
			$("#realMoney").text(parseInt(amount) - 20);
		}
		
		rechargeType = encrypt.encrypt((rechargeType + ""));
		amount = encrypt.encrypt((amount + ""));
		$("#rechargeType").val(rechargeType);
		$("#amount").val(amount);
		
	});
});
