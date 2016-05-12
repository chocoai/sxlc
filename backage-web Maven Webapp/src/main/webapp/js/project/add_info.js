/* 金额千分位控制 */
jQuery.fn.format=function(num){
	return (num.toFixed(2) + '').replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
};
/* 编辑框 */
var pi = UE.getEditor('payguide');
var guarantyDescribe = $("#guarantyDescribe").html();
$(function(){
	//初始化页面数据
	var rateAddRates = $(".rateAddRates").val();
	if(rateAddRates !=0 && rateAddRates != null ){
		$(".isAddRates").prop("checked",true);
	}
	var rewardRates = $(".rewardRates").val();
	if(rewardRates !=0 && rewardRates != null ){
		$(".isRewardRate").prop("checked",true);
	}
	var isDirect = $(".isDirect").val();
	if(isDirect==1){
		$(".isDirect").prop("checked",true);
	}
	//红包标
	var redListSize = $("#redListSize").val();
	if(redListSize!="" && redListSize != 0){
		$(".check_select2").prop("checked",true);
	}
	
	
	
	//初始化editor插件数据
	if(guarantyDescribe !=null && guarantyDescribe != ""){
		pi.addListener("ready", function () {
			pi.setContent(guarantyDescribe);
	    });
	}
	
	
	
	
	$(".moneyFormat").each(function(){
		var s = $(this).text();
		var str = parseFloat(s);
		var n = $(this).format(str);
		$(this).text(n);
	});
});

/* 验证 */
$(function(){
	validform5(".nextBtn","modInfo",false,"3");
	validform5(".btn-pre","next_field",false,"3");
});
/* 下一步跳转按钮 */
function nextSave(){
	var data={};//保存参数对象
	var projectTitle = $(".enterN-r").val();
	data.projectTitle=encrypt.encrypt(projectTitle);
	var amount = $(".loanMoney").val();
	data.amount=encrypt.encrypt(amount);
	var deadline = $(".con-term").val();
	data.deadline=encrypt.encrypt(deadline);
	var deadlineType = $(".conT").val();
	data.deadlineType=encrypt.encrypt(deadlineType);
	var investMax = $(".con-PP").val();
	data.investMax=encrypt.encrypt(investMax);
	var yearRate = $(".startTY").val();
	data.yearRate=encrypt.encrypt(yearRate);
	var minStart = $(".startingIA").val();
	data.minStart=encrypt.encrypt(minStart);
	var increaseRange = $(".conIncrease").val();
	data.increaseRange=encrypt.encrypt(increaseRange);
	var repayWay = $(".repayWay").val();
	data.repayWay=encrypt.encrypt(repayWay);
	var repayGuarantee = $(".repayGuarantee").val();
	data.repayGuarantee=encrypt.encrypt(repayGuarantee);
	var uses = $(".uses").val();
	data.uses=encrypt.encrypt(uses);
	var projectDescript = $(".projectDescript").val();
	data.projectDescript=encrypt.encrypt(projectDescript);
	var guarantyDescribe = pi.getContent();
	data.guarantyDescribe=encrypt.encrypt(guarantyDescribe);
	
	var ppid = $("#ppid").val();
	data.ppid=encrypt.encrypt(ppid);//意向借款id	
	var pbiid = $("#pbiid").val();
	data.pbiid=encrypt.encrypt(pbiid);//项目基础信息id
	
	data.cStatu=encrypt.encrypt("2");//cStatu:1:提交申请，2：保存草稿 
	data.styp=encrypt.encrypt("1");//styp:1：第一步只修改第一步的参数 2：第二步 只修改第二步的参数	
	$.ajax( {  
		url:appPath+"/project/handleProjectAppRecord",
		data:data,
		type:'post',  
		cache:false,  
		dataType:'json',  
		success:function(data) { 
			if(data==1){
//				layer.alert("信息保存成功",{icon:1});
				$(".modInfo").hide();
				$(".nextField").show();
			}else if(data==-2){
				layer.alert("借款标题已存在",{icon:2});  
			}
		},  
		error : function() {  
			layer.alert("服务器异常",{icon:2});
			//暂时写
//			$(".modInfo").hide();
//			$(".nextField").show();
			
		}  
	});
}

/**
 * 第二步保存按钮
 */
function saveLast(){
	var data={};//保存参数对象
	var autoStart = $(".autoStart").val();
	data.autoStart=encrypt.encrypt(autoStart);
	var auotInvestMax = $(".auotInvestMax").val();
	data.auotInvestMax=encrypt.encrypt(auotInvestMax);
	if($(".isAddRates").is(':checked')){//选中
		data.rateAddRate=$(".rateAddRates").val();
	}else{
		data.rateAddRate="0";
	}
	if($(".isDirect").is(':checked')){//选中
		data.isDirect="1";
		data.directPwd=$(".directPwd").val();
	}else{
		data.isDirect="0";
	}
	if($(".isRewardRate").is(':checked')){//选中
		data.rewardRate=$(".rewardRates").val();
	}else{
		data.rewardRate="0";
	}
	var guaranteeID = $(".guaranteeID").val();
	data.guaranteeID=encrypt.encrypt(guaranteeID);
	var assetManagerID = $(".assetManagerID").val();
	data.assetManagerID=encrypt.encrypt(assetManagerID);
	var riskMarginType = $(".riskMarginType").val();
	data.riskMarginType=encrypt.encrypt(riskMarginType);
	if($(".isRiskMargin").is(':checked')){//选中
		if($(".riskMarginType").val()==0){
			data.riskMarginRate = encrypt.encrypt($(".riskMarginValue").val());
		}else if($(".riskMarginType").val()==1){
			data.riskMarginFee = encrypt.encrypt($(".riskMarginValue").val());
		}
	}
	if($(".isMngFeeRate").is(':checked')){//选中
		var mngFeeRate = $(".mngFeeRate").val();
		data.mngFeeRate=encrypt.encrypt(mngFeeRate);
	}
	var investCountMax = $(".investCountMax").val();
	data.investCountMax=encrypt.encrypt(investCountMax);
	
	var ppid = $("#ppid").val();
	data.ppid=encrypt.encrypt(ppid);//意向借款id	
	var pbiid = $("#pbiid").val();
	data.pbiid=encrypt.encrypt(pbiid);//项目基础信息id
	
	data.cStatu=encrypt.encrypt("1");//cStatu:1:提交申请，2：保存草稿 
	data.styp=encrypt.encrypt("2");//styp:1：第一步只修改第一步的参数 2：第二步 只修改第二步的参数	
	$.ajax( {  
		url:appPath+"/project/handleProjectAppRecord",
		data:data,
		type:'post',  
		cache:false,  
		dataType:'json',  
		success:function(data) { 
			if(data==1){
				layer.alert("信息保存成功",{icon:1});
			}else if(data==-2){
				layer.alert("借款标题已存在",{icon:2});  
			}
		},  
		error : function() {  
			layer.alert("服务器异常",{icon:2});
		}  
	});
	
	
}


$(function(){
//	$(".nextBtn").click(function(){//不用这步，会自动触发提交？
//		$("#modInfo").submit();
//	});
	$(".beforeBtn").click(function(){
		$(".nextField").hide();
		$(".modInfo").show();
	});
	$(".appendixUpload").click(function(){
		$(".nextField").hide();
		$(".appendix").show();
	});
	$(".preBack").click(function(){
		$(".appendix").hide();
		$(".nextField").show();
	});
	$(".cancel").click(function(){
		$(".appendix").hide();
		$(".nextField").show();
	});
});
/* 添加红包惊喜标 */
$(function(){
	$(".addRed").click(function(){
		var rs = $(".red_add").html();
		$(".red_list:last-child").append("<li class='red_add'>" +rs + "</li>");
	});
	$(".reduceRed").click(function(){
		if($(".red_list li").length>1){
			$(".red_add:last-child").remove();
		}
	});
});
/* 控制输入为数字   
 * 伍成然
 * 2016-04-29*/
$(function(){
	$(".numberReg").each(function(){
		$(this).focus(function(){
			$(this).keyup(function(){
				if(this.value.length > 0){
					this.value = this.value.replace(/[^0-9]/g,'');
				}
			});
		});
		$(this).change(function(){
			this.value = this.value.replace(/[^0-9.]/g,'');
		});
	});
});

$(function(){
	/**
	 * 复选框选中事件
	 */
	$(".check_select").click(function(){
		var $input = $(this).parent().siblings().find("input");
		if($(this).is(':checked')){
			$input.attr("disabled",false);
			$input.attr("datatype",$input.attr("dataTyValue"));//增加验证类型
			
		}else{
			$input.attr("disabled",true);
			$input.removeAttr("datatype");//删除验证类型
		}
	});
	$(".check_select2").click(function(){
		if($(this).is(':checked')){
			$(this).parent().siblings().find("input").attr("disabled",false);
		}else{
			$(this).parent().siblings().find("input").attr("disabled",true);
		}
	});
});
/********选择担保机构********/
function select_mechanism(){
	var index = layer.open({
		title:"选择担保机构",
		type: 2,
		content: appPath+'/project/toSelectMechanismPg',
		area: ['1000px', '700px'],
		maxmin: true
	});
}
/*********选择资产管理方********/
function select_assetManagement(){
	var index = layer.open({
		title:"选择资产管理方",
		type: 2,
		content: appPath+'/project/toSelectAssetManagePg',
		area: ['1000px', '700px'],
		maxmin: true
	});
}
/*   查看提交认证信息模块             */
$(function(){
	$(".viewDetail").each(function(){
		$(this).click(function(){
			$(this).parent().next("div").slideToggle();
			$(this).parent().parent().siblings().find(".detailAuthen").hide();
		});
	});
});