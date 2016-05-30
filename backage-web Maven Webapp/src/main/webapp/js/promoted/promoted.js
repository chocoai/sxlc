/** cps推广 **/
var encrypt = new JSEncrypt();
encrypt.setPublicKey(publicKey_common);
$(function(){
	validform5(".alert","presentReturn",false,5);
});

$(function() {
	$.ajax({
		type : 'post',
		url : appPath + "/cps/queryCps.do",
		success : function (msg) {
			$("#backCash").val(msg.firstInvestSet);
		}
	});
});

$(function () {
	$("#modCps").bind('click', function () {
		$("#presentReturn").submit();
	});
});

function modCps() {
	var backCash = $("#backCash").val();
	backCash = encrypt.encrypt((backCash + ""));
	$.ajax({
		type : 'post',
		url : appPath + "/cps/modCps.do",
		data : {
			firstInvestSet : backCash
		},
		success : function(msg) {
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