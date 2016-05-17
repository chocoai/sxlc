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
	//第二步假参数
	data.autoStart=encrypt.encrypt("0");
	data.auotInvestMax=encrypt.encrypt("0");
	data.rateAddRate=encrypt.encrypt("0");
	data.isDirect=encrypt.encrypt("0");
	data.rewardRate=encrypt.encrypt("0");
//	data.guaranteeID=encrypt.encrypt(guaranteeID);
//	data.assetManagerID=encrypt.encrypt(assetManagerID);
	data.riskMarginType=encrypt.encrypt("0");
	data.riskMarginRate = encrypt.encrypt("0");
	data.mngFeeRate=encrypt.encrypt("0");
	data.investCountMax=encrypt.encrypt("0");
	data.guaranteeRate=encrypt.encrypt("0");
	data.mngFeeRateIncreace=encrypt.encrypt("0");
	data.mngFeeAmount=encrypt.encrypt("0");
	data.rewardIcon=encrypt.encrypt("");
	
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
				layer.alert("信息保存成功",{icon:1});
				$(".modInfo").hide();
				$(".nextField").show();
			}else if(data==-1){
				layer.alert("该意向借款已提交申请",{icon:2});  
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
	
	//未处理
//	var guaranteeRate = $(".guaranteeRate").val();
//	data.guaranteeRate=encrypt.encrypt(guaranteeRate);
	data.guaranteeRate=encrypt.encrypt("0");
	data.mngFeeRateIncreace=encrypt.encrypt("0");
	data.mngFeeAmount=encrypt.encrypt("0");
	data.rewardIcon=encrypt.encrypt("");
	
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
	
	/**
	 * 保存附件按钮
	 */
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
		fileNumLimit: 10,												//个数限制
		//[可选] [默认值：undefined] 验证单个文件大小是否超出限制, 超出则不允许加入队列。
		fileSingleSizeLimit: 1024*512,
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
		var fileName= $("#attachName").val();
		var newValue = fileName+","+uploadUrl;
		var oldValue = $("#affixChk").val();
		if(oldValue !=null && oldValue != ""){
			$("#affixChk").val(oldValue+";"+newValue);
		}else{
			$("#affixChk").val(newValue);
		}
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