/* 金额千分位控制 */
jQuery.fn.format=function(num){
	return (num.toFixed(2) + '').replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
};
/* 编辑框 */
var attachJson=[];//附件集合
var pi = UE.getEditor('payguide');
var guarantyDescribe = $("#guarantyDescribe").html();
$(function(){
	//初始化页面数据
	var memberID = $("#memberID").val();
	showMemberIdentyInfo(memberID);//展示会员认证
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
	
//	//起投金额改变
//	$(".startingIA").on("change",function(){
//		var loanMoney = $(".loanMoney").val();//借款金额
//		var investMax = $(".con-PP").val();//最大投资比例
//		var startMoney = $(this).val();//起投金额
//		if(Number(startMoney)>Number(loanMoney)){
//			layer.alert("起投金额不能大于借款金额！",{icon:0});  
//		}
//		var maxMoney = Number(loanMoney)*Number(investMax)/100;
//		if(Number(startMoney)> maxMoney){
//			layer.alert("起投金额不能大于最大投资金额！",{icon:0});  
//		}
//	});
//	
	//加价幅度改变
//	$(".conIncrease").on("change",function(){
//		var loanMoney = $(".loanMoney").val();
//		var conIncrease = $(this).val();
//		if(Number(conIncrease) >= Number(loanMoney)){
//			layer.alert("加价幅度必须小于借款金额！",{icon:0});  
//		}
//	});
	
	$(".chkInput").on("change",function(){
		var loanMoney = $(".loanMoney").val();//借款金额
		var investMax = $(".con-PP").val();//最大投资比例
		var startMoney = $(".startingIA").val();//起投金额
		var conIncrease = $(".conIncrease").val();//加价辐度
		var maxMoney = Number(loanMoney)*Number(investMax)/100;//最大投资金额
		if(startMoney!="" && loanMoney!="" && Number(startMoney)>Number(loanMoney)){
			layer.alert("起投金额不能大于借款金额！",{icon:0}); 
		}
		if(startMoney!="" && loanMoney!="" && investMax!="" && maxMoney !=0 &&  Number(startMoney)> maxMoney){
			layer.alert("起投金额不能大于最大投资金额(借款*最大投资比例)！",{icon:0});  
		}
		if(conIncrease!="" && loanMoney!="" && Number(conIncrease) >= Number(loanMoney)){
			layer.alert("加价幅度必须小于借款金额！",{icon:0});
		}
	});
	
	//项目风险保证金填写方式改变
    $(".riskMarginType").on("change",function(){
    	var value = $(this).val();
    	if(value == 0){//%
    		$(".riskMarginValue").attr("dataTyValue","hundredNum");
    		$(".riskMarginValue").val("");
    	}else{//元
    		$(".riskMarginValue").attr("dataTyValue","acountM");
    		$(".riskMarginValue").val("");
    	}
    });
    
    //担保费率填写方式改变
    $(".guaranteeType").on("change",function(){
    	var value = $(this).val();
    	if(value == 0){//%
    		$(".guaranteeValue").attr("datatype","hundredNum");
    		$(".guaranteeValue").val("");
    	}else{//元
    		$(".guaranteeValue").attr("datatype","acountM");
    		$(".guaranteeValue").val("");
    	}
    });
	
	
	//初始化editor插件数据
	if(guarantyDescribe !=null && guarantyDescribe != ""){
		pi.addListener("ready", function () {
			pi.setContent(guarantyDescribe);
	    });
	}
	
	/**
	 * 天标只能选到期还本息
	 */
	//初始化
	if($("#typeChange").val()==0){
		$(".repayWay").val(2);
		$(".repayWay").attr("disabled",true);
	}
	//天标改变事件
	$("#typeChange").on("change",function(){
		var type = $(this).val();
		if(type==0){
			$(".repayWay").val(2);
			$(".repayWay").attr("disabled",true);
		}else{
			$(".repayWay").attr("disabled",false);
		}
	});
	
	
	$(".moneyFormat").each(function(){
		var s = $(this).text();
		var str = parseFloat(s);
		var n = $(this).format(str);
		$(this).text(n);
	});
});

/* 验证 */
$(function(){
	validform5(".nextBtn","modInfo",false,"5");
	validform5(".btn-pre","next_field",false,"5");
});
/* 下一步跳转按钮 */
function nextSave(){
	var moneyA = Number($(".loanMoney").val());//借款金额
	var moneyB = Number($(".startingIA").val());//起投金额
	var moneyC = Number($(".conIncrease").val());//加价幅度
	var investMax = Number($(".con-PP").val());//最大投资比例
	if(moneyC >= moneyA){
		layer.alert("加价幅度必须小于借款金额！",{icon:0}); 
		$(".conIncrease").focus();
		return;
	}
	if((moneyB+moneyC)>moneyA){
		layer.alert("加价幅度与起投金额之和不能大于借款金额！",{icon:0}); 
		$(".conIncrease").focus();
		return;
	}
	if(moneyB > moneyA){
		layer.alert("起投金额不能大于借款金额！",{icon:0});  
		$(".startingIA").focus();
		return;
	}
	var maxMoney = moneyA*investMax/100;
	if(moneyB> maxMoney && maxMoney != 0){
		layer.alert("起投金额不能大于最大投资金额！",{icon:0}); 
		$(".startingIA").focus();
		return;
	}
	
	var data={};//保存参数对象
	var projectTitle = $(".enterN-r").val();
	if (projectTitle != null && projectTitle != "") {
		data.projectTitle=encrypt.encrypt(projectTitle);
	}
	var projectId = $("#projectId").val();
	if (projectId != null && projectId != "") {
		data.projectId=encrypt.encrypt(projectId);
	}
	var amount = $(".loanMoney").val();
	if (amount != null && amount != "") {
		data.amount=encrypt.encrypt(amount);
	}
	var deadline = $(".con-term").val();
	if (deadline != null && deadline != "") {
		data.deadline=encrypt.encrypt(deadline);
	}
	var deadlineType = $(".conT").val();
	if (deadlineType != null && deadlineType != "") {
		data.deadlineType=encrypt.encrypt(deadlineType);
	}
	var investMaxA= $(".con-PP").val();
	if (investMaxA != null && investMaxA != "") {
		data.investMax=encrypt.encrypt(investMaxA);
	}
	var yearRate = $(".startTY").val();
	if (yearRate != null && yearRate != "") {
		data.yearRate=encrypt.encrypt(yearRate);
	}
	var minStart = $(".startingIA").val();
	if (minStart != null && minStart != "") {
		data.minStart=encrypt.encrypt(minStart);
	}
	var increaseRange = $(".conIncrease").val();
	if (increaseRange != null && increaseRange != "") {
		data.increaseRange=encrypt.encrypt(increaseRange);
	}
	var repayWay = $(".repayWay").val();
	if (repayWay != null && repayWay != "") {
		data.repayWay=encrypt.encrypt(repayWay);
	}
	var repayGuarantee = $(".repayGuarantee").val();
	if (repayGuarantee != null && repayGuarantee != "") {
		data.repayGuarantee=encrypt.encrypt(repayGuarantee);
	}
	var repaySource = $(".repaySource").val();
	if (repaySource != null && repaySource != "") {
		data.repaySource=encrypt.encrypt(repaySource);
	}
	var uses = $(".uses").val();
	if (uses != null && uses != "") {
		data.uses=encrypt.encrypt(uses);
	}
	var projectDescript = $(".projectDescript").val();
	if (projectDescript != null && projectDescript != "") {
		data.projectDescript=encrypt.encrypt(projectDescript);
	}
	var guarantyDescribe = pi.getContent();
	if (guarantyDescribe != null && guarantyDescribe != "") {
		data.content=guarantyDescribe;
	}
	var ppid = $("#ppid").val();
	if (ppid != null && ppid != "") {
		data.ppid=encrypt.encrypt(ppid);//意向借款id	
	}
	var pbiid = $("#pbiid").val();
	if (pbiid != null && pbiid != "") {
		data.pbiid=encrypt.encrypt(pbiid);//项目基础信息id
	}
	data.cStatu=encrypt.encrypt("2");//cStatu:1:提交申请，2：保存草稿 
	data.styp=encrypt.encrypt("1");//styp:1：第一步只修改第一步的参数 2：第二步 只修改第二步的参数	
	//第二步假参数
	data.autoStart=encrypt.encrypt("0");
	data.isDirect=encrypt.encrypt("0");
	data.riskMarginType=encrypt.encrypt("0");
	data.guaranteeType=encrypt.encrypt("0");
	
	$.ajax( {  
		url:appPath+"/project/handleProjectAppRecord",
		data:data,
		type:'post',  
		cache:false,  
		dataType:'json',  
		success:function(data) { 
			if(data==1){
				layer.alert("提交申请成功",{icon:1});
			}else if(data==2){
				//第二步展示信息初始化
				layer.alert("信息保存成功",{icon:1});
				$("#amountStrS").html(amount);
				$("#repayGuaranteeS").html(repayGuarantee);
				if(deadlineType ==0){
					$("#deadlineS").html(deadline+" 天");
				}else if(deadlineType ==1){
					$("#deadlineS").html(deadline+" 月");
				}else if(deadlineType ==2){
					$("#deadlineS").html(deadline+" 年");
				}
				$("#useS").html(uses);
				$("#guarantyDescribeS").html(guarantyDescribe);
				$(".modInfo").hide();
				$(".nextField").show();
			}else if(data==-1){
				layer.alert("该意向借款已提交申请",{icon:2});  
			}else if(data==-2){
				layer.alert("借款标题已存在",{icon:2});  
			}else if(data == -100){
				layer.alert("登录失效，请登录后再操作！",{icon:2});  
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
	var amount = $(".loanMoney").val();
	var autoStart = $(".autoStart").val();
	if (autoStart != null && autoStart != "") {
		data.autoStart=encrypt.encrypt(autoStart);
	}
	var auotInvestMax = $(".auotInvestMax").val();
	if (auotInvestMax != null && auotInvestMax != "") {
		data.auotInvestMax=encrypt.encrypt(auotInvestMax);
	}
	if($(".isAddRates").is(':checked')){//选中
		data.rateAddRate=encrypt.encrypt($(".rateAddRates").val());
	}else{
		data.rateAddRate=encrypt.encrypt("0");
	}
	if($(".isDirect").is(':checked')){//选中
		data.isDirect=encrypt.encrypt("1");
		data.directPwd=encrypt.encrypt($(".directPwd").val());
	}else{
		data.isDirect=encrypt.encrypt("0");
	}
	if($(".isRewardRate").is(':checked')){//选中
		data.rewardRate=encrypt.encrypt($(".rewardRates").val());
	}else{
		data.rewardRate=encrypt.encrypt("0");
	}
	var guaranteeID = $(".guaranteeID").val();
	if (guaranteeID != null && guaranteeID != "") {
		data.guaranteeID=encrypt.encrypt(guaranteeID);
	}
	var assetManagerID = $(".assetManagerID").val();
	if (assetManagerID != null && assetManagerID != "") {
		data.assetManagerID=encrypt.encrypt(assetManagerID);
	}
	var riskMarginType = $(".riskMarginType").val();
	if (riskMarginType != null && riskMarginType != "") {
		data.riskMarginType=encrypt.encrypt(riskMarginType);
	}
	var riskMarginValue = $(".riskMarginValue").val();
	
	var maxRate = $("#riskRateMax").val();//最大风险保证金比例
	var maxMoney = Number(maxRate)*Number(amount);//最大风险保证金金额
	if($(".isRiskMargin").is(':checked')){//选中
		if($(".riskMarginType").val()==0){
			if(maxRate !=0 && Number(riskMarginValue) > Number(maxRate)){
				layer.alert("风险保证金已超过上限！",{icon:0});
				return;
			}
			data.riskMarginRate = encrypt.encrypt(riskMarginValue);
		}else if($(".riskMarginType").val()==1){
			if(maxMoney !=0 && Number(riskMarginValue) > Number(maxMoney)){
				layer.alert("风险保证金已超过上限！",{icon:0});
				return;
			}
			data.riskMarginFee = encrypt.encrypt(riskMarginValue);
		}
	}
	if($(".isMngFeeRate").is(':checked')){//选中
		var mngFeeRate = $(".mngFeeRate").val();
		data.mngFeeRate=encrypt.encrypt(mngFeeRate);
	}
	var investCountMax = $(".investCountMax").val();
	if (investCountMax != null && investCountMax != "") {
		data.investCountMax=encrypt.encrypt(investCountMax);
	}
//	var investMax = Number($(".con-PP").val());
//	var invsetPeople = Math.ceil(100/investMax);//最少投资人数
//	if(investMax * Number(investCountMax) <100){
//		layer.alert("投标人数不能小于"+invsetPeople+"人，否则该项目不能满标！",{icon:0});
//		return;
//	}
	var guaranteeType = $(".guaranteeType").val();
	data.guaranteeType=encrypt.encrypt(guaranteeType);
	var guaranteeValue = $(".guaranteeValue").val();
	if(guaranteeType ==0){
		data.guaranteeRate=encrypt.encrypt(guaranteeValue);
	}else if(guaranteeType ==1){
		data.guaranteeFee=encrypt.encrypt(guaranteeValue);
	}
	var ppid = $("#ppid").val();
	//红包惊喜标
	if($(".isRedPackage").is(':checked')){//选中
		var redPackageList=[];
		$(".red_add").each(function(){
			var obj = {};
			var $this = $(this);
			var investRedPackageMin = $this.find(".investRedPackageMin").val();
			var investNum = $this.find(".investNum").val();
			var redPackage = $this.find(".redPackage").val();
			obj.investRedPackageMin=investRedPackageMin;
			obj.investNum=investNum;
			obj.redPackage=redPackage;
			obj.purposeId=ppid;
			redPackageList.push(obj);
		});
		data.start = JSON.stringify(redPackageList);
	}
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
				window.location.href=appPath+"/project/toLoanApplyList";
			}else if(data==-2){
				layer.alert("借款标题已存在",{icon:2});  
			}else if(data == -10){
				layer.alert("保存红包惊喜标异常："+data.msg,{icon:2});  
			}else if(data == -100){
				layer.alert("登录失效，请登录后再操作！",{icon:2});  
			}else if(data == -8){
				layer.alert("项目风险保证金超出上限！",{icon:0});  
			}else if(data == -9){
				layer.alert("查询系统设置项目风险保证金上限异常！",{icon:0});  
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
	
	/**
	 * 保存附件按钮
	 */
	$(".preBack").click(function(){
		var data={};
		data.start = JSON.stringify(attachJson);
		if(attachJson.length == 0){
			layer.confirm('还没有上传附件，确定返回？', {
				  btn: ['确定', '取消']
				}, function(index, layero){
					layer.close(index);
					$(".appendix").hide();
					$(".nextField").show();	
				}, function(index){
					
				});
			return;
		}
		$.ajax( {  
			url:appPath+"/project/addAttachment",
			data:data,
			type:'post',  
			cache:false,  
			dataType:'json',  
			success:function(data) { 
				if(data>0){
					layer.alert("保存成功",{icon:1});
					$(".appendix").hide();
					$(".nextField").show();
				}else if(data == -10){
					layer.alert("保存红包惊喜标异常："+data.msg,{icon:2});  
				}else if(data == -100){
					layer.alert("登录失效，请登录后再操作！",{icon:2});  
				}
			},  
			error : function() {  
				layer.alert("服务器异常",{icon:2});
			}  
		});
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
			$input.removeAttr("ignore");//增加验证
		}else{
			$input.attr("disabled",true);
			$input.attr("ignore","ignore");//忽略验证
			$input.val("");
		}
	});
	//红包惊喜标
	$(".check_select2").click(function(){
		var $input = $(this).parent().siblings().find("input");
		if($(this).is(':checked')){
			$input.each(function(){
				$input.attr("disabled",false);
				$input.removeAttr("ignore");//增加验证
			});
		}else{
			$input.each(function(){
				$input.attr("disabled",true);
				$input.attr("ignore","ignore");//忽略验证
			});
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





/**
 *	项目审核附件
 */
$(function(){
	//上传初始化
	var uploader = WebUploader.create({
		auto: true,														//选完文件后，是否自动上传。
		swf: 'plugs/webuploader/0.1.5/Uploader.swf',					//swf文件路径
		server: appPath+'/UpdateBsnLicense',	//文件接收服务端。
		// 选择文件的按钮。可选。
		pick: '#filePicker',											//内部根据当前运行是创建，可能是input元素，也可能是flash.
		fileNumLimit: 100,												//个数限制
		//[可选] [默认值：undefined] 验证单个文件大小是否超出限制, 超出则不允许加入队列。
	    fileSingleSizeLimit: 5*1024*1024, //1M  
		accept: {														//只允许选择图片文件
			title: 'Images',
			extensions: 'gif,jpg,jpeg,bmp,png',
			mimeTypes: 'image/*'
		},
		resize: false													//不压缩image, 默认如果是jpeg，文件上传前会压缩一把再上传！
	});
	
	// 当有文件添加进来的时候
	uploader.on( 'fileQueued', function( file ) {
		var $li = $(
				'<div id="' + file.id + '" class="file-item thumbnail">' +
				'<img>' +
				'<div class="info">' + $(".add-title").val() + '</div>' +
				'</div>'
		),
		$del = $('<div class="file-panel"><span class="cancel">删除</span></div>'),
		$img = $li.find('img');
		
		
		// $list为容器jQuery实例
		$list = $("#fileList");
		$list.append( $li );
		$del.appendTo( $li );
		
		//预览时操作面板显隐
		$("#fileList .file-item").each(function(){
			$(this).mouseenter(function(){
				$(this).parent().find(".file-panel").animate({height:30},"fast");
			}).mouseleave(function(){
				$(this).parent().find(".file-panel").animate({height:0},"fast");
			});
		});
		
		//销毁
		$del.on('click', 'span', function() {
			removeFile(file);
		});
		
		// 负责view的销毁
		function removeFile(file) {
			var $li = $('#' + file.id);
			uploader.removeFile(file, true);
			$li.off().find('.file-panel').off().end().remove();
		}
		
		
		// 创建缩略图
		// 如果为非图片文件，可以不用调用此方法。
		// thumbnailWidth x thumbnailHeight 为 100 x 100
		// 优化retina, 在retina下这个值是2
		ratio = window.devicePixelRatio || 1,
		thumbnailWidth = 250 * ratio,
		thumbnailHeight = 150 * ratio,
		
		uploader.makeThumb( file, function( error, src ) {
			if ( error ) {
				$img.replaceWith('<div>不能预览</div>');
				return;
			}
			
			$img.attr( 'src', src );
		}, thumbnailWidth, thumbnailHeight );
	});
	
	// 文件上传过程中创建进度条实时显示。
	uploader.on( 'uploadProgress', function( file, percentage ) {
		var $li = $( '#'+file.id ),
		$percent = $li.find('.progress span');
		
		// 避免重复创建
		if ( !$percent.length ) {
			$percent = $('<p class="progress"><span></span></p>')
			.appendTo( $li )
			.find('span');
		}
		
		$percent.css( 'width', percentage * 100 + '%' );
	});
	
	uploader.on( 'beforeFileQueued', function( file ) {
		var fileName = $(".add-title").val();
		if(fileName !=null && fileName != ""){
			return true;
		}else{
			layer.alert("文件名不能为空",{icon:0});  
			return false;
		}
	});
	
	// 文件上传成功，给item添加成功class, 用样式标记上传成功。
	uploader.on( 'uploadSuccess', function( file,json ) {
		var result = json._raw;
		var uploadUrl=result.split(",")[1];
		var obj = {};
		var attachInfoType = $(".attachInfoType").val();
		var attachTitle = $(".add-title").val();
		var attachUrl = uploadUrl;
		obj.attachInfoType=attachInfoType;
		obj.attachTitle=attachTitle;
		obj.attachUrl=attachUrl;
		obj.purposeId=$("#ppid").val();
		attachJson.push(obj);
		$( '#'+file.id ).addClass('upload-state-done');
	});
	
	// 文件上传失败，显示上传出错。
	uploader.on( 'uploadError', function( file ) {
		var $li = $( '#'+file.id ),
		$error = $li.find('div.error');
		
		// 避免重复创建
		if ( !$error.length ) {
			$error = $('<div class="error"></div>').appendTo( $li );
		}
		
		$error.text('上传失败');
	});
	
	// 完成上传完了，成功或者失败，先删除进度条。
	uploader.on( 'uploadComplete', function( file ) {
		$( '#'+file.id ).find('.progress').remove();
	});
	
	
});