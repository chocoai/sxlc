//加密设置
var type = 0;
var encrypt = new JSEncrypt();
encrypt.setPublicKey(publicKey_common);
/* 账户中心充值部分开始 */
/*function accRecharge(){
	$(".right_col").load("web/recommend/re-add/acc-recharge.jsp");
}*/
function accRecharge(title,page,type){
	layer.open({
		type: 2,
		area: ['500px', '350px'], //高宽
		title:title,
		/*maxmin: true,*/
		content:page,//DOM或内容
	});
}
/* 账户中心充值部分结束 */
/* 账户中心提现部分开始 */
function accWithdraw(){
	$(".right_col").load("web/recommend/re-add/acc-withdraw.jsp");
}
/* 账户中心提现部分结束 */

/**
 * 添加担保借款金额范围
 */
$(function () {
	$("#add").bind('click', function () {
		$("#loanamountform").submit();
	});
});

function addRange() {
	var minAmount = encrypt.encrypt($("#minAmount").val());
	var maxAmount = encrypt.encrypt($("#maxAmount").val());
	if (type == 0) {
		$.ajax({
			type : 'post',
			url : appPath + "/guarant/addrange.do",
			data : {
				minAmount : minAmount,
				maxAmount : maxAmount
			},
			success : function (msg) {
				if(msg == 1){  
					layer.alert("添加成功!",{icon:1});
					setTimeout('location.reload()',2000);
				}else {  
					layer.alert("添加失败!",{icon:2});  
				}
			}
		});
	}else {
		$.ajax({
			type : 'post',
			url : appPath + "/guarant/updaterange.do",
			data : {
				minAmount : minAmount,
				maxAmount : maxAmount
			},
			success : function (msg) {
				if(msg == 1){  
					layer.alert("修改成功!",{icon:1});
					setTimeout('location.reload()',2000);
				}else {  
					layer.alert("修改失败!",{icon:2});  
				}
			}
		});
	}
}
/* 查看担保费收取记录部分开始 */
function accCheckRecords(){
	$(".right_col").load("web/recommend/re-add/acc-checkrecords.jsp");
}
/* 查看担保费收取记录部分结束 */
/* 担保借款金额范围开始 */
function loanAmount(){
	$.ajax({
		type : 'post',
		url : appPath + "/guarant/range.do",
		success : function(msg) {
			if (msg.length > 0) {
				type = 1;
				$("#minAmount").val(msg[0].minAmount);
				$("#maxAmount").val(msg[0].maxAmount);
			}
		}
	});
	layer.open({
		type: 1,
		area: ['455px', '230px'], //高宽
		title: "担保借款金额范围",
		maxmin: true,
		content: $("#loanamount"),//DOM或内容
	});
}
/* 担保借款金额范围结束 */

/* 担保产品类型开始 */
function productType(){
	$.ajax({
		type : 'post',
		url : appPath + "/guarant/queryselect.do",
		success : function (msg) {
			var str = "";
			$.each(msg, function(i, item) {
				str += "<span class=\"producttypechk\">"+
							"<input type=\"checkbox\" class=\"guatype\" name=\"optionsRadios\" value=\""+item.id+"\">"+ 
			 				"<label class=\"checkbox-inline\">"+item.projectName+"</label>"+
						"</span>";
			});
			$("#guType").html(str);
		}
	});
	layer.open({
		type: 1,
		area: ['400px', '300px'], //高宽
		title: "担保产品类型",
		maxmin: true,
		content: $("#producttype"),//DOM或内容
		btn:['确定','返回'],
		yes: function(index, layero){ //或者使用btn1
			var ids = "";
			$("#guType .guatype").each(function () {
				if($(this).is(':checked')) {
					ids += $(this).val() + ",";
				}
			});
			
			$.ajax({
				type : 'post',
				url : appPath + "/guarant/setType.do",
				data : {
					content : ids
				},
				success : function (msg) {
					if(msg == 1){  
						layer.alert("设置成功!",{icon:1});
						setTimeout('location.reload()',2000);
					}else {  
						layer.alert("设置失败!",{icon:2});  
					}
				}
			});
		
	},cancel: function(index){//或者使用btn2（concel）
		//取消的回调
	}
	});
}
/* 担保产品类型结束 */

/* 担保证件管理部分开始 */
function documentManagement(){
	$(".right_col").load("web/recommend/re-add/acc-documentManagement.jsp");
}
/* 担保证件管理部分结束 */

/* 允许担保借款期限起止范围开始 */
function termRange(){
	$.ajax({
		type : 'post',
		url : appPath + "/guarant/rangeLimit.do",
		success : function(msg) {
			if (msg.length > 0) {
				$.each(msg, function (i, item) {
					if (item.deadlineType == 0) {
						$("#daystartDate").val(item.minDeadline);
						$("#dayendDate").val(item.maxDeadline);
					}else if (item.deadlineType == 1) {
						$("#monthstartDate").val(item.minDeadline);
						$("#monthendDate").val(item.maxDeadline);
					}else if (item.deadlineType == 2) {
						$("#yearstartDate").val(item.minDeadline);
						$("#yearendDate").val(item.maxDeadline);
					}
				});
			}
		}
	});
	layer.open({
		type: 1,
		area: ['540px', '260px'], //高宽
		title: "允许担保借款期限起止范围",
		maxmin: true,
		content: $("#termrange"),//DOM或内容
	});
}
/* 允许担保借款期限起止范围*/
$(function () {
	$("#add").bind('click', function () {
		$("#termRangeform").submit();
	});
});

function add() {
	var daystartDate = encrypt.encrypt($("#daystartDate").val());
	var dayendDate = encrypt.encrypt($("#dayendDate").val());
	var monthstartDate = encrypt.encrypt($("#monthstartDate").val());
	var monthendDate = encrypt.encrypt($("#monthendDate").val());
	var yearstartDate = encrypt.encrypt($("#yearstartDate").val());
	var yearendDate = encrypt.encrypt($("#yearendDate").val());
	$.ajax({
		type : 'post',
		url : appPath + "/guarant/addStartAndEnd.do",
		data : {
			daystartDate : daystartDate,
			dayendDate : dayendDate,
			monthstartDate : monthstartDate,
			monthendDate : monthendDate,
			yearstartDate : yearstartDate,
			yearendDate : yearendDate
			
		},
		success : function (msg) {
			if(msg == 1){  
				layer.alert("设置成功!",{icon:1});
				setTimeout('location.reload()',2000);
			}else {  
				layer.alert("设置失败!",{icon:2});  
			}
		}
	});
}
/**
 * 开启/关闭自动代偿
 */
function accOnOff(){
	layer.confirm('is not?', {title:'提示'}, function(index){
		$("#openOrOff").submit();
		layer.close(index);
	});
}
function openAcount() {
	$("#openForm").submit();
}

$(function () {
	$.ajax({
		type : 'post',
		url : appPath + "/guarant/query4select.do",
		success : function(msg) {
			if (msg.memberThirdAuthInfoEntity != null) {
				$("#thirdPartyAccount").val(msg.memberThirdAuthInfoEntity.memberThirdInfoEntity.thirdPartyAccount);
				$("#userBalances").val(msg.memberThirdAuthInfoEntity.memberThirdInfoEntity.userBalances);
				$("#totalCompensationAmount").val(msg.memberThirdAuthInfoEntity.memberThirdInfoEntity.totalCompensationAmount);
				$("#allCompensatoryPayment").val(msg.memberThirdAuthInfoEntity.memberThirdInfoEntity.allCompensatoryPayment);
				$("#noCompensatoryPayment").val(msg.memberThirdAuthInfoEntity.memberThirdInfoEntity.noCompensatoryPayment);
			}
		}
	});
});