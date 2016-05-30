/**
 * 提现操作
 */
var encrypt = new JSEncrypt();
encrypt.setPublicKey(publicKey_common);

$(function () {
	var start = 0;
	var length = 50;
	$.ajax({
		type : 'post',
		url : appPath + "/bankCard/bankCardList.do",
		data : {
			start : start,
			length : length,
			memberType : encrypt.encrypt(1 + "")
		},
		success : function (msg) {
			var str = "";
			$.each(msg.results, function (i, item) {
				str += "<li class=\"\">"+
								"<input type=\"radio\" name=\"cashBankLi\"   id=\"cashBankLi"+i+"\" class=\"cashInputRadio\">"+
							"<label for=\"cashBankLi"+i+"\"  onselectstart=\"return false\" class=\"cashBankLiOne\">"+
								"<span class=\"name\">("+item.bankName+")</span><span class=\"no\">"+item.bankNo+"</span>"+
							"</label>"+
						"</li>";
			});
			$("#cardList").html(str);
			
		}
	});
	
	$.ajax({
		type : 'post',
		url : appPath + "/compensatory/queryThird.do",
		success : function (msg) {
			if (msg != null) {
				$("#money").val(msg.memberThirdInfoEntity.userBalances);
			}
		}
	});
	
	$.ajax({
		type : 'post',
		url : appPath + "/withdraw/msg.do",
		success : function (msg) {
			for (var i = 0; i < msg.length; i ++) {
				if (msg[i].payment_Member_Type == 0) {
					$("#costs").val(Number(msg[i].swithdrawal_Fee_Pingtai));
				}else if (msg[i].payment_Member_Type == 1) {
					$("#costs").val(Number(msg[i].swithdrawal_Fee_Pingtai));
				}else {
					$("#costs").val(Number(msg[i].swithdrawal_Fee_Pingtai));
				}
			}
		}
	});
});

$(function () {
	$("#realMoney").bind("mouseout", function () {
		if ($(this).val() == 0) {
			$("#cost").text(0);
			$("#realGetMoney").text($(this).val());
		}else {
			var cost = Number($(this).val()) * Number($("#costs").val()) / 100;
			$("#cost").text(cost);
			$("#realGetMoney").text(Number($(this).val()) - cost);
		}
	});
	$("#present").bind('click', function () {
		var bankCardNo = Number($("input[name='cashBankLi']:checked").next().find("span.no").html());
		if (bankCardNo != null && bankCardNo != "") {
			$("#bankCardId").val(encrypt.encrypt(Number($("input[name='cashBankLi']:checked").next().find("span.no").html()) + ""));
			$("#remarks").val(encrypt.encrypt($("#remark").val()));
			$("#realMoneys").val(encrypt.encrypt($("#realMoney").val));
			$("#accwithdrawform").submit();
		}else {
			layer.alert("叫前端写个选中银行卡提示！", {icon : 0});
		}
	});
});

