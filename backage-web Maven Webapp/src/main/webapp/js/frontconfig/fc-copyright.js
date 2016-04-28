/** 版权信息 **/
//加密操作
var encrypt = new JSEncrypt();
encrypt.setPublicKey(publicKey_common);
$(function () {
	$.ajax({
		type : 'post',
		url : appPath + "/copyright/query.do",
		success : function (msg) {
			if (msg != null && msg != "") {
				$("#copyright").val(msg);
			}
		}
		
	});
});

$(function () {
	$("#save").bind('click', function () {
		var content = $("#copyright").val();
		alert(content);
		var result = encrypt.encrypt((content));
		alert(result);
		$.ajax({
			type : 'post',
			url : appPath + "/copyright/save.do",
			data : {result : result},
			success : function (msg) {
				if (msg == 1) {
					layer.alert("操作成功",{icon:1}); 
					setTimeout('location.reload()',2000);
				}else {
					layer.alert("服务器异常",{icon:2});
				}
			}
		});
	});
});