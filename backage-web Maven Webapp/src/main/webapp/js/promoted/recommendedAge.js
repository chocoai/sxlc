/** 推荐达人年限 **/
var encrypt = new JSEncrypt();
encrypt.setPublicKey(publicKey_common);

$(function(){
	validform5(".alert","recomAgeForm",false,5);
});

$(function () {
	$.ajax({
		type : 'post',
		url : appPath + "/talent/yearLimit.do",
		success : function (msg) {
			$("#limit").val(msg);
		}
	});
});

$(function () {
	$("#alter").bind('click', function () {
		$("#recomAgeForm").submit();
	});
});

function addOrmod() {
	var limit = $("#limit").val();
	limit = encrypt.encrypt((limit + ""));
	$.ajax({
		type : 'post',
		url : appPath + "/talent/addOrmod.do",
		data : {
			limit : limit
		},
		success : function (msg) {
			if (msg == 1) {
				layer.alert("操作成功",{icon:1});
				day = null;
				setTimeout('location.reload()',2000);
			}else {
				layer.alert("操作失败",{icon:2});
			}
		}
	});
}