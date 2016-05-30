/** 修改银行卡 **/
/**
 * 查询银行信息
 */
var encrypt = new JSEncrypt();
encrypt.setPublicKey(publicKey_common);
$(function (){ 
	$.ajax({
		type : 'post',
		url : appPath + "/bankCard/queryBankInfo.do",
		success : function (msg) {
			var str = "<option>请选择</option>";
			$.each(msg, function (i, item) {
				str += "<option value=\""+item.bankID+"\">"+item.bankName+"</option>";
			});
			$("#mbank").html(str);
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
			$("#mprovince").html(str);
		}
	});
});

/**
 * 查询城市信息
 */

$("#mprovince").bind('change', function() {
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
			$("#mcity").html(str);
		}
	});
} );

$("#mod").bind('click', function() {
	$("#bankMod").submit();
});

/**
 * 修改操作
 * @returns
 */
function modBank() {
	var rowdata = $('#table_id').DataTable().rows('.selected').data();
	var bankCardId = encrypt.encrypt((rowdata[0].bankCardId + ""));
	var provinceId  = encrypt.encrypt(($("#mprovince").val() + ""));
	var cityId = encrypt.encrypt(($("#mcity").val() + ""));
	var branch = encrypt.encrypt(($("#mbranch").val() + ""));
	var cardNo = encrypt.encrypt(($("#mcardNo").val() + ""));
	var phone = encrypt.encrypt(($("#mphone").val() + ""));
	var memberType = encrypt.encrypt((1 + ""));
	var bank = encrypt.encrypt(($("#mbank").val() + ""));
	
	$.ajax({
		type : 'post',
		url : appPath + "/bankCard/update.do",
		data : {
			provinceId : provinceId,
			cityId : cityId,
			branch : branch,
			cardNo : cardNo,
			phone : phone,
			bankCardId : bankCardId,
			memberType : memberType,
			bank : bank
		},
		success : function (msg) {
			if (msg == 1) {
	  			layer.alert("操作成功!",{icon:1});
	  			var table = $('#table_id').DataTable();
				table.ajax.reload();
	  		}else {
	  			layer.alert("服务器异常!",{icon:2});
	  			setTimeout('location.reload()',2000);
	  		}
		}
	});
}
