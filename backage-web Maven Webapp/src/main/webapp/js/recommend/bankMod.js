/** 修改银行卡 **/
/**
 * 查询银行信息
 */
var encrypt = new JSEncrypt();
encrypt.setPublicKey(publicKey_common);
$(function (){ 
	$.ajax({
		type :　'post',
		url : appPath + "/bankCard/queryBankInfo.do",
		success : function (msg) {
			var str = "";
			$.each(msg, function (i, item) {
				str += "<option value=\""+item.bankID+"\">"+item.bankName+"</option>";
			});
			$("#bank").html(str);
		}
	});
});

/**
 * 查询省份信息
 */

$(function (){ 
	$.ajax({
		type :　'post',
		url : appPath + "/bankCard/queryProvinceInfo.do",
		success : function (msg) {
			var str = "<option>请选择</option>";
			$.each(msg, function (i, item) {
				str += "<option value=\""+item.provinceId+"\">"+item.provinceName+"</option>";
			});
			$("#province").html(str);
		}
	});
});

/**
 * 查询城市信息
 */

$("#province").bind('change', function() {
	var provinceId = $(this).val();
	var result = encrypt.encrypt((provinceId + ""))
	$.ajax({
		type :　'post',
		url : appPath + "/bankCard/queryCityInfo.do",
		data : {provinceId : result},
		success : function (msg) {
			var str = "<option>请选择</option>";
			$.each(msg, function (i, item) {
				str += "<option value=\""+item.cityId+"\">"+item.cityName+"</option>";
			});
			$("#city").html(str);
		}
	});
} );

$(".commonbtn0").bind('click', function() {
	$("#bankAdd").submit();
});

/**
 * 修改操作
 * @returns
 */
function modBank() {
	
	/*var rowdata = $('#table_id').DataTable().rows('.selected').data();*/
	var bankCardId = encrypt.encrypt((1 + ""));
	var bankName = encrypt.encrypt(($("#bank").val() + ""));
	var provinceId  = encrypt.encrypt(($("#province").val() + ""));
	var cityId = encrypt.encrypt(($("#city").val() + ""));
	var branch = encrypt.encrypt(($("#branch").val() + ""));
	var cardNo = encrypt.encrypt(($("#cardNo").val() + ""));
	var cardNo2 = encrypt.encrypt(($("#cardNo2").val() + ""));
	var phone = encrypt.encrypt(($("#phone").val() + ""));
	
	$.ajax({
		type : 'post',
		url : appPath + "",
		data : {
			provinceId : provinceId,
			cityId : cityId,
			branch : branch,
			cardNo : cardNo,
			phone : phone,
			bankCardId : bankCardId
		},
		success : function (msg) {
			
		}
	});
}
