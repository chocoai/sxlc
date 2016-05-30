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
					$("#mFee").val(msg[i].swithdrawal_Fee_Third);
					$("#mpFee").val(msg[i].swithdrawal_Fee_Pingtai);
				}else if (msg[i].payment_Member_Type == 1) {
					$("#ofee").val(msg[i].swithdrawal_Fee_Third);
					$("#opfee").val(msg[i].swithdrawal_Fee_Pingtai);
				}else {
					$("#pfee").val(msg[i].swithdrawal_Fee_Third);
					$("#ppfee").val(msg[i].swithdrawal_Fee_Pingtai);
				}
			}
		}
		
	});
});

/** 修改 提现返回百分比 **/
//会员
function mwithdralsfee () {
	//validform5("btn","auto",true,"5");
	var percent = $("#mFee").val();
	var ppercent = $("#mpFee").val();
	//加密操作
	var encrypt = new JSEncrypt();
    encrypt.setPublicKey(publicKey_common);
    var result1 = encrypt.encrypt((percent));
    var result2 = encrypt.encrypt((ppercent));
    var result3 = encrypt.encrypt((0 + ""));
		$.ajax({
			type : 'post',
			url : appPath + "/withdraw/update.do",
			data : {
						payment_Member_Type : result3, 
						withdrawal_Fee_Third : result1, 
						withdrawal_Fee_Pingtai : result2
					},
			success : function (msg) {
				if (msg > 0) {
					layer.alert("操作成功",{icon:1});
					setTimeout('location.reload()',1000);
				}else {
					layer.alert("操作失败",{icon:2});
				}
			}
			
		});
}

//机构
function owithdralsfee () {
	//validform5("btn","auto",true,"5");
	var percent = $("#ofee").val();
	var ppercent = $("#opfee").val();
	//加密操作
	var encrypt = new JSEncrypt();
    encrypt.setPublicKey(publicKey_common);
    var result1 = encrypt.encrypt((percent));
    var result2 = encrypt.encrypt((ppercent));
    var result3 = encrypt.encrypt((1 + ""));
		$.ajax({
			type : 'post',
			url : appPath + "/withdraw/update.do",
			data : {
				payment_Member_Type : result3, 
				withdrawal_Fee_Pingtai : result2, 
				withdrawal_Fee_Third : result1
			},
			success : function (msg) {
				if (msg > 0) {
					layer.alert("操作成功",{icon:1});
					setTimeout('location.reload()',1000);
				}else {
					layer.alert("操作失败",{icon:2});
				}
			}
			
		});
}

//平台
function pwithdralsfee () {
	//validform5("btn","auto",true,"5");
	var percent = $("#pfee").val();
	var ppercent = $("#ppfee").val();
	//加密操作
	var encrypt = new JSEncrypt();
    encrypt.setPublicKey(publicKey_common);
    var result1 = encrypt.encrypt((percent));
    var result2 = encrypt.encrypt((ppercent));
    var result3 = encrypt.encrypt((2 + ""));
		$.ajax({
			type : 'post',
			url : appPath + "/withdraw/update.do",
			data : {
						payment_Member_Type : result3, 
						withdrawal_Fee_Pingtai : result2, 
						withdrawal_Fee_Third : result1
					},
			success : function (msg) {
				if (msg > 0) {
					layer.alert("操作成功",{icon:1});
					setTimeout('location.reload()',1000);
				}else {
					layer.alert("操作失败",{icon:2});
				}
			}
			
		});
}

