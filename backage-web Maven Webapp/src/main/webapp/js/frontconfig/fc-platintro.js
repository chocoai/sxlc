/** 平台简介 **/
var encrypt = new JSEncrypt();
encrypt.setPublicKey(publicKey_common);
var ue = UE.getEditor('applyguide');
$(function () {
	$.ajax({
		type : 'post',
		url : appPath + "/platform/query.do",
		success : function (msg) {
			ue.addListener("ready", function () {
	        	ue.setContent(msg.content);
		    });
		}
		
	});
});

$(function () {
	$("#save").bind('click', function () {
		var content = ue.getContent();
		var result1 = encrypt.encrypt(content);
		$.ajax({
			type : 'post',
			url : appPath + "/platform/save.do",
			data : {content : result1},
			success : function (msg) {
				if (msg == 1) {
		  			layer.alert("操作成功!",{icon:1});
		  			setTimeout('location.reload()',2000);
		  		}else {
		  			layer.alert("操作失败!",{icon:2});  
		  		}
			}
		});
	});
});