/** 投资管理返回百分比 **/
//获取项目根目录全路径
function getRootPath(){
        var curWwwPath=window.document.location.href;
        var pathName=window.document.location.pathname;
        var pos=curWwwPath.indexOf(pathName);
        var localhostPath=curWwwPath.substring(0,pos);
        var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
		if(/127.0.0.1|localhost/.test(localhostPath)){
			return(localhostPath+projectName);
		}else{
			return(localhostPath);
		}
}

/** 查询返回百分比 **/
$(function () {
	$.ajax({
		type : 'post',
		url : appPath + "/mange/msg.do",
		success : function (msg) {
			if (msg != 0) {
				$("#lastname").val(msg);
			}
		}
		
	});
});

/** 修改投资管理费百分比 **/
function updateMange () {
	validform5("btn","mange",true,"3");
	var percent = $("#lastname").val();
	//加密操作
	var encrypt = new JSEncrypt();
    encrypt.setPublicKey(publicKey_common);
    var result = encrypt.encrypt((percent));
		$.ajax({
			type : 'post',
			url : appPath + "/mange/update.do",
			data : {priceDatum : result},
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