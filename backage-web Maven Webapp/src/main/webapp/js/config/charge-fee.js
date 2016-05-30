/** 充值手续费 **/
/** 全局变量 **/
var mtype = null;
var otype = null;
var ptype = null;
var mpay = null;
var opay = null;
var ppay = null;

$(function () {
	$("#memberMod").bind('click', function () {
		$("#member").submit();
	});
});

/** 修改 充值手续费 **/
//会员
function mchargefee () {
	$.ajax({
		type : 'post',
		url : appPath + "/withdraw/update4charge.do",
		data : {paymentMemberType : mpay, feePaymentMethod : mtype},
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

$(function () {
	$("#orgMod").bind('click', function () {
		$("#orgnization").submit();
	});
});

//机构
function ochargefee () {
	//validform5("btn","auto",true,"5");
	$.ajax({
		type : 'post',
		url : appPath + "/withdraw/update4charge.do",
		data : {paymentMemberType : opay, feePaymentMethod : otype},
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

$(function () {
	$("#platMod").bind('click', function () {
		$("#station").submit();
	});
});

//平台
function pchargefee () {
	//validform5("btn","auto",true,"5");
	$.ajax({
		type : 'post',
		url : appPath + "/withdraw/update4charge.do",
		data : {paymentMemberType : ppay, feePaymentMethod : ptype},
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
$(function () {
	
	$.ajax({
		type : 'post',
		url : appPath + "/withdraw/feeList.do",
		success : function (msg) {
			if (msg.length > 0) {
				$.each(msg, function (i, item) {
					if (item.paymentMemberType == 0) {
						$("#mdiv input[type='radio']").each(function(index){
							if ($(this).val() == item.feePaymentMethod) {
								$(this).attr("checked","checked");
							}
						});
					}else if (item.paymentMemberType == 1) {
						$("#odiv input[type='radio']").each(function(index){
							if ($(this).val() == item.feePaymentMethod) {
								$(this).attr("checked","checked");
							}
						});
					}else if (item.paymentMemberType == 2) {
						$("#sdiv input[type='radio']").each(function(index){
							if ($(this).val() == item.feePaymentMethod) {
								$(this).attr("checked","checked");
							}
						});
					}
				});
			}
		}
	});
	
	$("#mdiv input[type='radio']").each(function(index){
		$(this).on('click',function(){
			$(this).attr("checked",true).parent(".checkbox-inline").siblings().children("input[type='radio']").attr("checked",false);
			if($(this).attr("checked")){
				mtype = $(this).val();
				//加密操作
				var encrypt = new JSEncrypt();
			    encrypt.setPublicKey(publicKey_common);
			    mtype = encrypt.encrypt((mtype));
			    mpay = encrypt.encrypt((0 + ""));
			}
		});
	});
	
		$("#odiv input[type='radio']").each(function(index){
			$(this).on('click',function(){
				$(this).attr("checked",true).parent(".checkbox-inline").siblings().children("input[type='radio']").attr("checked",false);
				if($(this).attr("checked")){
					otype = $(this).val();
					//加密操作
					var encrypt = new JSEncrypt();
				    encrypt.setPublicKey(publicKey_common);
				    otype = encrypt.encrypt((otype));
				    opay = encrypt.encrypt((1 + ""));
				}
			});
		});
	
		$("#sdiv input[type='radio']").each(function(index){
			$(this).on('click',function(){
				$(this).attr("checked",true).parent(".checkbox-inline").siblings().children("input[type='radio']").attr("checked",false);
				if($(this).attr("checked")){
					ptype = $(this).val();
					//加密操作
					var encrypt = new JSEncrypt();
				    encrypt.setPublicKey(publicKey_common);
				    ptype = encrypt.encrypt((ptype));
				    ppay = encrypt.encrypt((2 + ""));
				}
			});
		});
});
