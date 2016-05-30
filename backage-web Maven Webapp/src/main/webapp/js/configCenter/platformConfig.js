/**
 * 配置中心
 * 平台配置
 * pr
 */
	/**
	 * 初始化
	 */
	$(function(){
		$(".filePicker").each(function(i,obj){
			 var filePicker ="filePicker"+(i+1);
			 var fileListObj = $(this).next("div");
			 var inputObj = $(this).prev("input");
			 UploadImg(filePicker,fileListObj,1,inputObj,220,110);
		});
		validform5('#btn','platform',false,5);
		showPlantConfig();
		//保存
	});
/**
 * 显示配置信息
 * @returns
 */	
function showPlantConfig(){
	$.ajax( {  
		url:appPath+"/platform/getPlatConfig.do",
		data:{},
		type:'post',  
		cache:false,  
		dataType:'json',  
		success:function(data) { 
			if(data!=null&&data!=""){
				$("#systemName").val(data.systemName);//平台名称
				
				//追加图片$("").append("<img src='+data.backgroundLogo+'/>");
				if(data.backgroundLogo!=null && data.backgroundLogo!=""){
					$("input[name=back_logo]").val(data.backgroundLogo);//平台后台logo	
				}
					appendImg(data.backgroundLogo, $("#fileList1"));
				if(data.forgroundLogo!=null && data.forgroundLogo!=""){
					$("#pro_logo").val(data.forgroundLogo);//平台前台logo	
				}
					appendImg(data.forgroundLogo, $("#fileList2"));
				$("#systemHotline").val(data.systemHotline);//平台客服热线设置
				
				var OfficeHours = data.systemOfficeHours;
				var timeList = new Array();
				if(OfficeHours!=null&&OfficeHours!=""){
					timeList = OfficeHours.split(" ");
				}
				$("#start").val(timeList[0]);////平台工作时间	
				$("#end").val(timeList[1]);////平台工作时间	
				$("#weiboName").val(data.weiboName);//微博名
				if(data.weiboQRCode!=null && data.weiboQRCode!=""){
					$("#weiboQRCode").val(data.weiboQRCode);//微波二维码
				}
					appendImg(data.weiboQRCode, $("#fileList3"));
				$("#qQGroupCode").val(data.qQGroupCode);//平台qq
				
				if(data.qQGroupQRCode!=null && data.qQGroupQRCode!=""){
					$("#qQGroupQRCode").val(data.qQGroupQRCode);//平台qq二维码
				}
					appendImg(data.qQGroupQRCode, $("#fileList4"));
				$("#weChatCode").val(data.weChatCode);//微信公众号
				if(data.weChatQRCode!=null && data.weChatQRCode!=""){
					$("#weChatQRCode").val(data.weChatQRCode);//平台微信二维码地址
				}
					appendImg(data.weChatQRCode, $("#fileList5"));
				if(data.switchStatu==1){
					$("#optionsRadios1").attr("checked",true);
				}else{
					$("#optionsRadios2").attr("checked",true);
				}
				$("#riskReserveFund").val(data.riskReserveFund);//前台显示平台风险准备金金额	
				$("#expectYearRate").val(data.expectYearRate);//平台前台显示预期年化设置	
				$("#integralAlias").val(data.integralAlias);//平台名称
				$("#welcomeTitle").val(data.welcomeTitle);//平台名称
			}
		},  
		error : function() {  
			layer.alert("服务器异常",{icon:2});  
		}  
	});
}


//保存
function submitPlatCofig(){
	
	var encrypt = new JSEncrypt();
	encrypt.setPublicKey(publicKey_common);
	//result 为加密后参数
	
	var systemName = $("#systemName").val();//平台名称
	var back_logo = $("input[name=back_logo]").val();//平台后台logo	
	var pro_logo = $("input[name=pro_logo]").val();//平台前台logo	
	var systemHotline = $("#systemHotline").val();//平台客服热线设置
	var start = $("#start").val();
	var end = $("#end").val();
	var OfficeHours = start +" "+end ;
	var systemOfficeHours = OfficeHours;////平台工作时间	
	var weiboName= $("#weiboName").val();//微博名
	var weiboQRCode= $("#weiboQRCode").val();//微波二维码
	var qQGroupCode= $("#qQGroupCode").val();//平台qq
	var qQGroupQRCode= $("#qQGroupQRCode").val();//平台qq二维码
	var weChatCode = $("#weChatCode").val();//微信公众号
	var weChatQRCode= $("#weChatQRCode").val();//平台微信二维码地址
	var switchStatu = $('input[name="openPlatform"]:checked').val();
	var riskReserveFund = $("#riskReserveFund").val();//前台显示平台风险准备金金额	
	var expectYearRate= $("#expectYearRate").val();//平台前台显示预期年化设置	
	var integralAlias = $("#integralAlias").val();//积分别名	
	var welcomeTitle = $("#welcomeTitle").val();//平台欢迎语设置
	
	systemName = encrypt.encrypt(systemName);
	back_logo = encrypt.encrypt(back_logo);
	pro_logo = encrypt.encrypt(pro_logo);
	systemHotline = encrypt.encrypt(systemHotline);
	systemOfficeHours = encrypt.encrypt(systemOfficeHours);
	weiboName = encrypt.encrypt(weiboName);
	weiboQRCode = encrypt.encrypt(weiboQRCode);
	qQGroupCode = encrypt.encrypt(qQGroupCode);
	qQGroupQRCode = encrypt.encrypt(qQGroupQRCode);
	
	weChatCode = encrypt.encrypt(weChatCode);
	weChatQRCode = encrypt.encrypt(weChatQRCode);
	
	switchStatu = encrypt.encrypt(switchStatu);
	riskReserveFund = encrypt.encrypt(riskReserveFund);
	expectYearRate = encrypt.encrypt(expectYearRate);
	integralAlias = encrypt.encrypt(integralAlias);
	welcomeTitle = encrypt.encrypt(welcomeTitle);
	$(".layui-layer-btn0").addClass("disabled");
	$.ajax( {  
		url:appPath+"/platform/savePlatConfig.do",
		data:{
			systemName:systemName,
			backgroundLogo:back_logo,
			forgroundLogo:pro_logo,
			systemHotline:systemHotline,
			systemOfficeHours:systemOfficeHours,
			weiboName:weiboName,
			weiboQRCode:weiboQRCode,
			qQGroupCode:qQGroupCode,
			qQGroupQRCode:qQGroupQRCode,
			weChatCode:weChatCode,
			weChatQRCode:weChatQRCode,
			switchStatu:switchStatu,
			riskReserveFund:riskReserveFund,
			expectYearRate:expectYearRate,
			integralAlias:integralAlias,
			welcomeTitle:welcomeTitle
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

/**
 * 追加图片
 * @param imgURL  		图片路劲
 * @param fileListObj	存放图片div 
 */
function appendImg(imgURL,fileListObj){
	var imgRealURL =$("#hostPath").val();
	if(imgURL==null || imgURL==""){
		return ;
	}else{
		imgRealURL+=imgURL;
	}
	var html = '<div  class="file-item thumbnail">' +
                '<img src="'+imgRealURL+'" style="width:220px;height:110px"/>' +
                '<div class="file-panel"><span class="cancel"></span></div>'+
            '</div>';
	fileListObj.append(html );
}