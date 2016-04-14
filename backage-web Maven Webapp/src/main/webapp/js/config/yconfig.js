/** 提现手续费 **/
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
		url : appPath + "/withdraw/msg.do",
		success : function (msg) {
			for (var i = 0; i < msg.length; i ++) {
				if (msg[i].payment_Member_Type == 0) {
					$("#mFee").val(msg[i].withdrawal_Fee_Pingtai);
					$("#mpFee").val(msg[i].withdrawal_Fee_Third);
				}else if (msg[i].payment_Member_Type == 1) {
					$("#ofee").val(msg[i].withdrawal_Fee_Pingtai);
					$("#opfee").val(msg[i].withdrawal_Fee_Third);
				}else {
					$("#pfee").val(msg[i].withdrawal_Fee_Pingtai);
					$("#ppfee").val(msg[i].withdrawal_Fee_Third);
				}
			}
		}
		
	});
});

/** 修改 提现返回百分比 **/
//会员
function mwithdralsfee () {
	//validform5("btn","auto",true,"3");
	var percent = $("#mFee").val();
	var ppercent = $("#mpFee").val();
		$.ajax({
			type : 'post',
			url : appPath + "/withdraw/update.do",
			data : "payment_Member_Type=" + 0 +"&withdrawal_Fee_Pingtai=" + percent + "&withdrawal_Fee_Third=" + ppercent,
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

//机构
function owithdralsfee () {
	//validform5("btn","auto",true,"3");
	var percent = $("#ofee").val();
	var ppercent = $("#opfee").val();
		$.ajax({
			type : 'post',
			url : appPath + "/withdraw/update.do",
			data : "payment_Member_Type=" + 1 + "&withdrawal_Fee_Pingtai=" + percent + "&withdrawal_Fee_Third=" + ppercent,
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

//平台
function pwithdralsfee () {
	//validform5("btn","auto",true,"3");
	var percent = $("#pfee").val();
	var ppercent = $("#ppfee").val();
		$.ajax({
			type : 'post',
			url : appPath + "/withdraw/update.do",
			data : "payment_Member_Type=" + 2 + "&withdrawal_Fee_Pingtai=" + percent + "&withdrawal_Fee_Third=" + ppercent,
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

