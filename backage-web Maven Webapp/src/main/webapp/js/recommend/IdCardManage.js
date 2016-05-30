/*  银行卡管理部分      */
/**
 * 添加动态
 */
function bankManagementAdd(){
	//参数判断，自己写全
	//console.log(title+","+page+","+type);
	layer.open({
	    type: 1,
	    area: ['500px', '380px'], //高宽
	    title: "添加银行卡",
	    maxmin: true,
	    content: $(".pic-add")//DOM或内容
	});
	
	
}

/**
 * 查询银行信息
 */
$(function (){ 
	$.ajax({
		type : 'post',
		url : appPath + "/bankCard/queryBankInfo.do",
		success : function (msg) {
			var str = "";
			$.each(msg, function (i, item) {
				str += "<option value=\""+item.bankID+"\">"+item.bankName+"</option>";
			});
			$("#bank").html(str);
		}
	});
});

/**
 * 查询省份信息
 */

$(function (){ 
	$.ajax({
		type : 'post',
		url : appPath + "/bankCard/queryProvinceInfo.do",
		success : function (msg) {
			var str = "<option>请选择</option>";
			$.each(msg, function (i, item) {
				str += "<option value=\""+item.provinceId+"\">"+item.provinceName+"</option>";
			});
			$("#province").html(str);
		}
	});
});

/**
 * 查询城市信息
 */
$(function () {
	$("#province").bind('change', function() {
		var provinceId = $(this).val();
		var result = encrypt.encrypt((provinceId + ""))
		$.ajax({
			type : 'post',
			url : appPath + "/bankCard/queryCityInfo.do",
			data : {provinceId : result},
			success : function (msg) {
				var str = "<option>请选择</option>";
				$.each(msg, function (i, item) {
					str += "<option value=\""+item.cityId+"\">"+item.cityName+"</option>";
				});
				$("#city").html(str);
			}
		});
	} );
	
});

$(function () {
	validform5(".commonbtn0","bankAdd",false,"5");
	$("#add").bind('click', function () {
		$("#bankAdd").submit();
	});
});

/**
 * 添加操作
 * @returns
 */
function addBank() {
	var provinceId  = encrypt.encrypt(($("#province").val() + ""));
	var cityId = encrypt.encrypt(($("#city").val() + ""));
	var branch = encrypt.encrypt(($("#branch").val() + ""));
	var cardNo = encrypt.encrypt(($("#cardNo").val() + ""));
	var phone = encrypt.encrypt(($("#phone").val() + ""));
	var memberType = encrypt.encrypt(2 + "");
	
	$.ajax({
		type : 'post',
		url : appPath + "/bankCard/add.do",
		data : {
			provinceId : provinceId,
			cityId : cityId,
			branch : branch,
			cardNo : cardNo,
			phone : phone,
			memberType : memberType
		},
		success : function (msg) {
			if (msg == 1) {
	  			layer.alert("添加成功!",{icon:1});
	  			setTimeout('location.reload()',2000);
	  		}else if(msg == -2){
	  			layer.alert("该银行卡已存在!",{icon:2});
	  			setTimeout('location.reload()',2000);
	  		}else if(msg == -3){
	  			layer.alert("绑定银行卡已超过15张!",{icon:2});
	  			setTimeout('location.reload()',2000);
	  		}
		}
	});
}

function bankManagementMod(){
	var rowdata = $('#table_id').DataTable().rows('.selected').data();
	if (rowdata.length <= 0) {
		layer.alert("请选择要修改的银行卡！",{icon:0});
		return;
	}else {
		var bankCardId = encrypt.encrypt((rowdata[0].bankCardId + ""));
		$.ajax({
			type : 'post',
			url : appPath + "/bankCard/queryBank.do",
			data : {
				bankCardId : bankCardId
			},
			success : function (msg) {
				$("#mbranch").val(msg.branch);
				$("#mcardNo").val(msg.bankNo);
				$("#mcardNo2").val(msg.bankNo);
				$("#mphone").val(msg.bankPhone);
				$("#mprovince option").each(function (){  
				    if($(this).val() == msg.cardProvince){
				    	$(this).attr('selected','selected');
				    	$.ajax({
							type : 'post',
							url : appPath + "/bankCard/queryCityInfo.do",
							data : {provinceId : encrypt.encrypt(($(this).val() + ""))},
							success : function (msg) {
								var str = "";
								$.each(msg, function (i, item) {
									str += "<option value=\""+item.cityId+"\">"+item.cityName+"</option>";
								});
								$("#mcity").html(str);
							}
						});
				}});
			}
		});
		layer.open({
			type: 1,
			area: ['500px', '380px'], //高宽
			title: "修改银行卡",
			maxmin: true,
			content: $(".pic-mod"),//DOM或内容
		});
	}
	
	
}

/**
 * 删除银行卡
 */
$(function () {
	$(".obtn-dept-del").on("click touchstart",function(){
		//获得选取的对象
		var rowdata = $('#table_id').DataTable().rows('.selected').data();
		if (rowdata.length <= 0) {
			layer.alert("请选择要删除的银行卡！",{icon:0});
			return;
		}else {
			var bankCardId = encrypt.encrypt((rowdata[0].bankCardId + ""));
			layer.confirm('确定删除该银行卡？', {
			  btn: ['确定', '取消']
			,yes: function(index, layero){ //或者使用btn1
			    //确定的回调
			  	$.ajax({
			  		type : 'post',
			  		url : appPath + "/bankCard/del.do",
			  		data : {bankCardId : bankCardId},
			  		success : function (msg) {
			  			if (msg == 1) {
				  			layer.alert("删除成功!",{icon:1});
				  			setTimeout('location.reload()',2000);
				  		}else {
				  			layer.alert("服务器异常!",{icon:2});
				  			setTimeout('location.reload()',2000);
				  		}
			  		}
			  	});
			  	
			  },cancel: function(index){//或者使用btn2（concel）
			  	//取消的回调
			  }
			});
		}
		
	});
});


/*   验证           */
$(function(){
	$(".cardTypeOption").css({
		"width":"186px",
		"padding":"5px 8px",
		"border":"1px solid #ccc",
		"cursor":"pointer"
	});
	validform5(".commonbtn0","card_id",false,"5");
});