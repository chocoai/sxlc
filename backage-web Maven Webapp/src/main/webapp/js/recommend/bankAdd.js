/** 添加银行卡 **/

var encrypt = new JSEncrypt();
encrypt.setPublicKey(publicKey_common);
/**
 * 查询银行信息
 */
$(function (){ 
	$.ajax({
		type : 'post',
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
		type : 'post',
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
$(function () {
	$("#province").bind('change', function() {
		var provinceId = $(this).val();
		var result = encrypt.encrypt((provinceId + ""))
		$.ajax({
			type : 'post',
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
	
});

