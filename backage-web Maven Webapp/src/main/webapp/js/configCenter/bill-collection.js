/**
 * 配置中心
 * 账单催收
 * pr
 */
	/**
	 * 初始化
	 */
	$(function(){
		validform5(".btn-default","dataForm",false,"5");
		showBillCollectionConfig();
		//保存
	});
/**
 * 显示配置信息
 * @returns
 */	
function showBillCollectionConfig(){
	$.ajax( {  
		url:appPath+"/loanEerge/getLoanEerge.do",
		data:{},
		type:'post',  
		cache:false,  
		dataType:'json',  
		success:function(data) { 
			if(data!=null){
				$("#overdue_day").val(data.billDays);
				$("#content").val(data.billContent);
			}
		},  
		error : function() {  
			layer.alert("服务器异常",{icon:2});  
		}  
	});
}

//保存
function submitBillCofig(){
	var billDays = $("#overdue_day").val();
	var billContent = $("#content").val();
	var encrypt = new JSEncrypt();
	encrypt.setPublicKey(publicKey_common);
	//result 为加密后参数
	var billDays = encrypt.encrypt(billDays);
	$(".layui-layer-btn0").addClass("disabled");
	$.ajax( {  
		url:appPath+"/loanEerge/saveLoanEerge.do",
		data:{
			billday:billDays,
			content:billContent
		},
		type:'post',  
		cache:false,  
		dataType:'text',  
		success:function(data) { 
			if(data==1){
				layer.alert("保存成功",{icon:1});
			}else {
				layer.alert("保存失败！",{icon:2});  
			}
			$(".layui-layer-btn0").removeClass("disabled");
		},  
		error : function() {  
			layer.alert("服务器异常",{icon:2});  
		}  
	});
}
