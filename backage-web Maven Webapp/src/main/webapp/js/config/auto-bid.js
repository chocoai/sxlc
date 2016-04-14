/** 自动投标返回百分比 **/
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
		url : appPath + "/auto/msg.do",
		success : function (msg) {
			if (msg.autoBackRate != 0) {
				$("#firstname").val(msg.autoBackRate);
			}
		}
		
	});
});

/** 修改自动投标返回百分比 **/
function updateAuto () {
	validform5("btn","auto",true,"3");
	var percent = $("#firstname").val();
		$.ajax({
			type : 'post',
			url : appPath + "/auto/update.do",
			data : "autoBackRate=" + percent,
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