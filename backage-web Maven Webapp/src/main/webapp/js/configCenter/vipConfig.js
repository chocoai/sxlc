/**
 * 配置中心
 * vip配置
 * pr
 */
	/**
	 * 初始化
	 */
	$(function(){
		validform5("layui-layer-btn0","vipForm",false,"5");
		validform5("layui-layer-btn0","dataForm",false,"5");
		showVipConfig();
		//保存
	});
/**
 * 显示配置信息
 * @returns
 */	
function showVipConfig(){
	
	$.ajax( {  
		url:appPath+"/vip/getVipConfig.do",
		data:{},
		type:'post',  
		cache:false,  
		dataType:'json',  
		success:function(data) { 
			if(data!=null&&data!=""){
				//console.log(JSON.stringify(data));
				$("#vip_Attest").val(data.vipAttests);//VIP购买年金额
				$("#invest_total").val(data.vipInvests);//上个VIP截止日起累计有效投资
				$("#invest_Fee").val(data.investMngRates);//收取投资管理费
				$("#borrow_Fee").val(data.borrowMngRates);//收取借款管理费
			}
		},  
		error : function() {  
			layer.alert("服务器异常",{icon:2});  
		}  
	});
}

$(function () {
	$(".layui-layer-btn0").bind('click', function() {
		$("#vipForm").submit();
	});
});

//保存
function submitVipCofig(){
	var encrypt = new JSEncrypt();
	encrypt.setPublicKey(publicKey_common);
	//result 为加密后参数
	
	var vip_Attest = $("#vip_Attest").val();//VIP购买年金额
	var invest_total = $("#invest_total").val();//上个VIP截止日起累计有效投资
	var invest_Fee = $("#invest_Fee").val();//收取投资管理费
	var borrow_Fee = $("#borrow_Fee").val();//收取借款管理费
	vip_Attest = encrypt.encrypt(vip_Attest+"");
	invest_total = encrypt.encrypt(invest_total+"");
	invest_Fee = encrypt.encrypt(invest_Fee+"");
	borrow_Fee = encrypt.encrypt(borrow_Fee+"");
	$(".layui-layer-btn0").addClass("disabled");
	$.ajax( {  
		url:appPath+"/vip/saveVipConfig.do",
		data:{
			vip_Attest:vip_Attest,
			invest_total:invest_total,
			invest_Fee:invest_Fee,
			borrow_Fee:borrow_Fee
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

