//加密设置
var encrypt = new JSEncrypt();
encrypt.setPublicKey(publicKey_common);
var ag = UE.getEditor('applyguide');
var pg = UE.getEditor('payguide');
var contentG = $("#applyguideValue").html();
var contentR = $("#payguideValue").html();
$(function(){
	//上传插件初始化
	UploadImg('filePicker',$("#fileList"),1,$("#picUrl"),100,110);
	UploadImg('filePicker1',$("#fileList1"),1,$("#picIcon"),100,100);
	
	validform5(".btn-success","dataForm",false,"3");
		
	//初始化图片预览
	var picIcon = $("#picIcon").val();
	if(picIcon!=null && picIcon!= ""){
		$("#fileList").html('<img height="100" width="100" src="'+$("#hostPath").val()+picIcon+'">');
	}
	var picUrl = $("#picUrl").val();
	if(picUrl!=null && picUrl!= ""){
		$("#fileList1").html('<img height="50" width="50" src="'+$("#hostPath").val()+picUrl+'">');
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
		if(Number(begin)>Number(end)){
			$this.parent().find(".errorMsg").html("*请输入正确的数据范围！");
			$this.parent().find(".Validform_checktip").removeClass("Validform_right");
		}else{
			$this.parent().find(".errorMsg").html("");
		}
	});
	$(".endNum").on("change",function(){
		var $this = $(this);
		var end = $this.val();
		var begin = $this.parent().find(".beginNum").val();
		if(Number(begin)>Number(end)){
			$this.parent().find(".errorMsg").html("*请输入正确的数据范围！");
			$this.parent().find(".Validform_checktip").removeClass("Validform_right");
		}else{
			$this.parent().find(".errorMsg").html("");
		}
	});
	
});

/**
 * 保存
 */
function addOrModify(){
	debugger;
	//验证数据范围是否正确
	$(".beginNum").change();
	$(".errorMsg").each(function(){
		var text = $(this).html();
		if(text!=""){
			return;
		}
	});
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
	data.minDaytimeY = encrypt.encrypt(minDaytimeY);
	data.maxDaytimeY = encrypt.encrypt(maxDaytimeY);
	data.minDaytimeM = encrypt.encrypt(minDaytimeM);
	data.maxDaytimeM = encrypt.encrypt(maxDaytimeM);
	data.minDaytimeD = encrypt.encrypt(minDaytimeD);
	data.maxDaytimeD = encrypt.encrypt(maxDaytimeD);
	data.isMortgage = encrypt.encrypt(isMortgage);
	data.applyMember = encrypt.encrypt(applyMember);
	data.Datum = encrypt.encrypt(Datum);
	data.picIcon = encrypt.encrypt(picIcon);
	data.picUrl = encrypt.encrypt(picUrl);
	data.briefIntroduction = encrypt.encrypt(briefIntroduction);
	data.contentg = encrypt.encrypt(contentg);
	data.contentr = encrypt.encrypt(contentr);
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
	
/* 类型名称 */
$(".proKindName").blur(function(){
	var rn = $(".proKindName").val();
	if(rn == " " || rn == ""){
		alert("错误");
	}
});
/* 项目融资范围 */
	$(".endAccount").blur(function(){
		var ba =$(".beginAccount").val();
		var ea =$(".endAccount").val();
		if(ea<=ba){
			alert("错误");
		}else{
		}
	});
	$(".beginAccount").blur(function(){
		var ba =$(".beginAccount").val();
		var ea =$(".endAccount").val();
		if(ea<=ba){
			alert("错误");
		}
	});
	/* 年化利率范围 */
	$(".startTheYear").blur(function(){
		var sty =$(".startTheYear").val();
		var ety =$(".endTheYear").val();
		if(ety<=sty){
			alert("错误");
		}
	});
	$(".endTheYear").blur(function(){
		var sty =$(".startTheYear").val();
		var ety =$(".endTheYear").val();
		if(ety<=sty){
			alert("错误");
		}
	});
	
	/* 项目期限 */
	
	$(".bgTime").blur(function(){
		var be =$(".bgTime").val();
		var ee =$(".edTime").val();
		if(ee<=be){
			alert("错误");
		}
	});
	
	$(".edTime").blur(function(){
		var be =$(".bgTime").val();
		var ee =$(".edTime").val();
		if(ee<=be){
			alert("错误");
		}
	});
	/* 年 */
	$(".bgTimeY").blur(function(){
		var beY =$(".bgTimeY").val();
		var eeY =$(".edTimeY").val();
		if(eeY<=beY){
			alert("错误");
		}
	});
	
	$(".edTimeY").blur(function(){
		var beY =$(".bgTimeY").val();
		var eeY =$(".edTimeY").val();
		if(eeY<=beY){
			alert("错误");
		}
	});
	/* 月 */
	$(".bgTimeM").blur(function(){
		var beM =$(".bgTimeM").val();
		var eeM =$(".edTimeM").val();
		if(eeM<=beM){
			alert("错误");
		}
	});
	
	$(".edTimeM").blur(function(){
		var beM =$(".bgTimeM").val();
		var eeM =$(".edTimeM").val();
		if(eeM<=beM){
			alert("错误");
		}
	});
	/* 天*/
	$(".bgTimeD").blur(function(){
		var beD =$(".bgTimeD").val();
		var eeD =$(".edTimeD").val();
		if(eeD<=beD){
			alert("错误");
		}
	});
	
	$(".edTimeD").blur(function(){
		var beD =$(".bgTimeD").val();
		var eeD =$(".edTimeD").val();
		if(eeD<=beD){
			alert("错误");
		}
	});
	
});
