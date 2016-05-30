//加密设置
var encrypt = new JSEncrypt();
encrypt.setPublicKey(publicKey_common);
var ag = UE.getEditor('applyguide');
var pg = UE.getEditor('payguide');
var contentG = $("#applyguideValue").html();
var contentR = $("#payguideValue").html();
$(function(){
	//上传插件初始化
	UploadImg('filePicker',$("#fileList"),1,$("#picUrl"),120,120);
	UploadImg('filePicker1',$("#fileList1"),1,$("#picIcon"),100,100);
	
	validform5(".btn-success","dataForm",false,"5");
		
	//初始化图片预览
	var picIcon = $("#picIcon").val();
	if(picIcon!=null && picIcon!= ""){
		$("#fileList").html('<img style="max-height: 100px;max-width: 100px;" src="'+$("#hostPath").val()+picIcon+'">');
	}
	var picUrl = $("#picUrl").val();
	if(picUrl!=null && picUrl!= ""){
		$("#fileList1").html('<img style="max-height: 50px;max-width: 50px;" src="'+$("#hostPath").val()+picUrl+'">');
	}
	
	//初始化editor插件数据
	if(contentG !=null && contentG != ""){
		ag.addListener("ready", function () {
	    	ag.setContent(contentG);
	    });
	}
	if(contentR !=null && contentR != ""){
		pg.addListener("ready", function () {
	    	pg.setContent(contentR);
	    });
	}
	
	//展示产品认证项
	$(".identitySelection").change(function(){
		var is=$(this).val();
		if(is=="0"){
			$(".person").show();
			$(".enterprise").show();
		}else if(is=="1"){
			$(".person").show();
			$(".enterprise").hide();
		}else if(is=="2"){
			$(".person").hide();
			$(".enterprise").show();
		}else{
			$(".person").hide();
			$(".enterprise").hide();
		}
	});
	
	//初始化认证项
	var projectId = $("#projectId").val();
	if(projectId != null && projectId !="" ){
		$.ajax( {  
			url:appPath+"/project/getAuthentication.do",
			data:{"id":encrypt.encrypt(projectId)},
			type:'post',  
			cache:false,  
			dataType:'json',  
			success:function(data) {
				var flag1=0;//个人认证标识
				var flag2=0;//企业认证标识
				for(var i in data){
					var attestTypeID = data[i].attestTypeID;
					$("input[type='checkbox'][value="+attestTypeID+"]").attr('checked', true);
					if(data[i].memberType ==0 ){
						flag1 += 1;
					}else if(data[i].memberType ==1){
						flag2 += 1;
					}
				}
				if(flag1 > 0 && flag2==0 ){//个人认证
					$(".identitySelection").val("1");
					$(".identitySelection").change();
				}else if(flag2 > 0 && flag1==0){//企业认证
					$(".identitySelection").val("2");
					$(".identitySelection").change();
				}else if(flag1 >0 && flag2 >0){//全部
					$(".identitySelection").val("0");
					$(".identitySelection").change();
				}
			},  
			error : function() {  
				layer.alert("服务器异常",{icon:2});  
			}  
		});
	}
		
	//数据范围验证
	$(".beginNum").on("change",function(){
		var $this = $(this);
		var begin = $this.val();
		var end = $this.parent().find(".endNum").val();
		if(end!="" && begin !="" && Number(begin)>Number(end)){
			$this.parent().find(".errorMsg").html("*请输入正确的数据范围！");
			$this.addClass("Validform_error");
			setTimeout(function(){$this.parent().find(".Validform_checktip").removeClass("Validform_right");},50);
		}else{
			$this.parent().find(".errorMsg").html("");
		}
	});
	$(".endNum").on("change",function(){
		var $this = $(this);
		var end = $this.val();
		var begin = $this.parent().find(".beginNum").val();
		if(end!="" && begin !="" && Number(begin)>Number(end)){
			$this.parent().find(".errorMsg").html("*请输入正确的数据范围！");
			$this.addClass("Validform_error");
			setTimeout(function(){$this.parent().find(".Validform_checktip").removeClass("Validform_right");},50);
		}else{
			$this.parent().find(".errorMsg").html("");
		}
	});
	
	
	/**
	 * 返回按钮
	 */
	$(".goBack").on("click",function(){
		window.location.href=appPath+'/project/toProTypePg';
	});
	
});

/**
 * 保存
 */
function addOrModify(){
	//验证数据范围是否正确
	$(".beginNum").change();
	var flag = true;
	$(".errorMsg").each(function(){
		var text = $(this).html();
		if(text!=""){
			$(".Validform_error").focus();
			flag = false;
			return;
		}
	});
	if(!flag){
		return;
	}
	//获取修改数据
	var projectName = $(".proKindName").val();
	var minAmount = $(".minAmount").val();
	var maxAmount = $(".maxAmount").val();
	var minRate = $(".minRate").val();
	var maxRate = $(".maxRate").val();
	var minDaytimeY = $(".minDaytimeY").val();
	var maxDaytimeY = $(".maxDaytimeY").val();
	var minDaytimeM = $(".minDaytimeM").val();
	var maxDaytimeM = $(".maxDaytimeM").val();
	var minDaytimeD = $(".minDaytimeD").val();
	var maxDaytimeD = $(".maxDaytimeD").val();
	var dayFlag = false;//判断是否至少有一对合法期限数据
	var sinFlag = true;//判断是否是只填写了最小或最大期限
	$(".minDayTime").each(function(){
		var minDayTime = $(this).val();
		var maxDayTime = $(this).parent().find(".maxDayTime").val();
		if(minDayTime!="" && maxDayTime !=""){
			dayFlag = true;
		}else if(minDayTime != "" && maxDayTime == ""){
			sinFlag = false;
		}else if(maxDayTime != "" && minDayTime == ""){
			sinFlag = false;
		}
	});
	if(!sinFlag){
		layer.alert("不能只填写最小或最大期限",{icon:0});  
		return;
	}
	if(!dayFlag){
		layer.alert("请至少填写一种项目期限",{icon:0});  
		return;
	}
	var isMortgage = $(".assettype").val();
	var applyMember = $(".identitySelection").val();
	var Datum="";//借款所需认证项拼接
	$('input:checkbox:checked').each(function(){
	    var $this = $(this);
		var typeId= $this.attr("typeId"); 
	    var attestTypeID = $this.val();
		Datum += typeId+","+attestTypeID+";";
     });
	var picUrl= $("#picUrl").val();
	var picIcon= $("#picIcon").val();
	var briefIntroduction= $(".briefIntroduction").val();
	var contentg = ag.getContent();
	var contentr = pg.getContent();
	var projectId = $("#projectId").val();
	var data={};
	data.projectName = encrypt.encrypt(projectName);
	data.minAmount = encrypt.encrypt(minAmount);
	data.maxAmount = encrypt.encrypt(maxAmount);
	data.minRate = encrypt.encrypt(minRate);
	data.maxRate = encrypt.encrypt(maxRate);
	if(minDaytimeY != ""){
		data.minDaytimeY = encrypt.encrypt(minDaytimeY);
	}
	if(maxDaytimeY != ""){
		data.maxDaytimeY = encrypt.encrypt(maxDaytimeY);
	}
	if(minDaytimeM != ""){
		data.minDaytimeM = encrypt.encrypt(minDaytimeM);
	}
	if(maxDaytimeM != ""){
		data.maxDaytimeM = encrypt.encrypt(maxDaytimeM);
	}
	if(minDaytimeD != ""){
		data.minDaytimeD = encrypt.encrypt(minDaytimeD);
	}
	if(maxDaytimeD != ""){
		data.maxDaytimeD = encrypt.encrypt(maxDaytimeD);
	}
	if(isMortgage!=null && isMortgage != ""){
		data.isMortgage = encrypt.encrypt(isMortgage);
	}else{
		layer.alert("请选择是否需要抵押！",{icon:0});  
		return;
	}
	if(applyMember!=null && applyMember != ""){
		data.applyMember = encrypt.encrypt(applyMember);
	}else{
		layer.alert("请选择产品认证项！",{icon:0});  
		return;
	}
	if(Datum!=null && Datum != ""){
		data.Datum = encrypt.encrypt(Datum);
	}
	if(picIcon!=null && picIcon != ""){
		data.picIcon = encrypt.encrypt(picIcon);
	}else{
		layer.alert("请上传产品小图标！",{icon:0});  
		return;
	}
	if(picUrl!=null && picUrl != ""){
		data.picUrl = encrypt.encrypt(picUrl);
	}else{
		layer.alert("请上传展示图片！",{icon:0}); 
		return;
	}
	if(briefIntroduction!=null && briefIntroduction != ""){
		data.content = briefIntroduction;//百度编辑器内容不加密
	}
	if(contentg!=null && contentg != ""){
		data.start = contentg;//百度编辑器内容不加密
	}else{
		layer.alert("请填写申请指南！",{icon:0}); 
		return;
	}
	if(contentr!=null && contentr != ""){
		data.length = contentr;//百度编辑器内容不加密
	}else{
		layer.alert("请填写还款指南！",{icon:0}); 
		return;
	}
	if(projectId != "" && projectId != null){//修改
		data.type = encrypt.encrypt("2");
		data.lId = encrypt.encrypt(projectId);
	}else{//增加
		data.type = encrypt.encrypt("1");
	}
	
	$.ajax( {  
		url:appPath+"/project/addOrUpdateProType.do",
		data:data,
		type:'post',  
		cache:false,  
		dataType:'json',  
		success:function(data) { 
			if(data==1){
				layer.alert("操作成功",{icon:1});
				window.location.href=appPath+"/project/toProTypePg";
			}else if(data==0){
				layer.alert("操作失败",{icon:2});  
			}else if(data==-1){
				layer.alert("该名称的项目类型已存在!",{icon:2});  
			}
		},  
		error : function() {  
			layer.alert("服务器异常",{icon:2});  
		}  
	});
	
	
	
}



$(function(){
	
/* 项目融资范围 */
	$(".endAccount").blur(function(){
		var ba =$(".beginAccount").val();
		var ea =$(".endAccount").val();
		if(ea<=ba){
			layer.alert("数据范围错误！",{icon:0});  
		}else{
		}
	});
	$(".beginAccount").blur(function(){
		var ba =$(".beginAccount").val();
		var ea =$(".endAccount").val();
		if(ea<=ba){
			layer.alert("数据范围错误！",{icon:0});  
		}
	});
	/* 年化利率范围 */
	$(".startTheYear").blur(function(){
		var sty =$(".startTheYear").val();
		var ety =$(".endTheYear").val();
		if(ety<=sty){
			layer.alert("数据范围错误！",{icon:0});  
		}
	});
	$(".endTheYear").blur(function(){
		var sty =$(".startTheYear").val();
		var ety =$(".endTheYear").val();
		if(ety<=sty){
			layer.alert("数据范围错误！",{icon:0});  
		}
	});
	
	/* 项目期限 */
	
	$(".bgTime").blur(function(){
		var be =$(".bgTime").val();
		var ee =$(".edTime").val();
		if(ee<=be){
			layer.alert("数据范围错误！",{icon:0});  
		}
	});
	
	$(".edTime").blur(function(){
		var be =$(".bgTime").val();
		var ee =$(".edTime").val();
		if(ee<=be){
			layer.alert("数据范围错误！",{icon:0});  
		}
	});
	/* 年 */
	$(".bgTimeY").blur(function(){
		var beY =$(".bgTimeY").val();
		var eeY =$(".edTimeY").val();
		if(eeY<=beY){
			layer.alert("数据范围错误！",{icon:0});  
		}
	});
	
	$(".edTimeY").blur(function(){
		var beY =$(".bgTimeY").val();
		var eeY =$(".edTimeY").val();
		if(eeY<=beY){
			layer.alert("数据范围错误！",{icon:0});  
		}
	});
	/* 月 */
	$(".bgTimeM").blur(function(){
		var beM =$(".bgTimeM").val();
		var eeM =$(".edTimeM").val();
		if(eeM<=beM){
			layer.alert("数据范围错误！",{icon:0});  
		}
	});
	
	$(".edTimeM").blur(function(){
		var beM =$(".bgTimeM").val();
		var eeM =$(".edTimeM").val();
		if(eeM<=beM){
			layer.alert("数据范围错误！",{icon:0});  
		}
	});
	/* 天*/
	$(".bgTimeD").blur(function(){
		var beD =$(".bgTimeD").val();
		var eeD =$(".edTimeD").val();
		if(eeD<=beD){
			layer.alert("数据范围错误！",{icon:0});  
		}
	});
	
	$(".edTimeD").blur(function(){
		var beD =$(".bgTimeD").val();
		var eeD =$(".edTimeD").val();
		if(eeD<=beD){
			layer.alert("数据范围错误！",{icon:0});  
		}
	});
	
});
