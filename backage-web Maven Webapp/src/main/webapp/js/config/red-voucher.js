/** 红包/代金卷到期提醒 **/
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
/** 查询到期天数 **/
$(function () {
	$.ajax({
		type : 'post',
		url : appPath + "/redV/msg.do",
		success : function (msg) {
			if (msg.endDateRemind != 0) {
				$("#days").val(msg.endDateRemind);
			}
		}
		
	});
});

/** 修改红包代金卷到期天数 **/
function addRedV () {
	validform5("btn","red",true,"5");
	var days = $("#days").val();
	//加密操作
	var encrypt = new JSEncrypt();
    encrypt.setPublicKey(publicKey_common);
    var result = encrypt.encrypt((days));
		$.ajax({
			type : 'post',
			url : appPath + "/redV/update.do",
			data : {endDateRemind : result},
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