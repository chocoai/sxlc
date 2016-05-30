/**
 * 配置中心
 * 前台借款信息填写配置
 * pr
 */
	/**
	 * 初始化
	 */
	$(function(){
		showFrontConfig();
		//保存
	});
/**
 * 显示配置信息
 * @returns
 */	
function showFrontConfig(){
	$.ajax( {  
		url:appPath+"/front/getFront.do",
		data:{},
		type:'post',  
		cache:false,  
		dataType:'json',  
		success:function(data) { 
			if(data!=null&&data!=""){
				$.each(data,function(index,obj){
					$("input[name=optionsRadios]").each(function(){
						if($(this).val() == obj.optionType){
							$(this).attr("checked","checked");
						}
					});
				});
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
	var list ="";
	var flag = true;
	$("input[name=optionsRadios]").each(function(){
		if($(this).prop("checked")==true){
			var type=$(this).val();
			var value = 1;
			if(flag){
				list += type+","+value;
			}else{
				list +=";"+ type+","+value;
			}
			flag =false;
		}
	});
	var checkList = encrypt.encrypt((list));
	$(".layui-layer-btn0").addClass("disabled");
	$.ajax( {  
		url:appPath+"/front/saveFrontConfig.do",
		data:{
			checkList:checkList
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
	var imgRealURL ="http://cdsxlc.com:21000/";
	if(imgURL==null || imgURL==""){
		return 
	}else{
		imgRealURL+=imgURL;
	}
	var html = '<div  class="file-item thumbnail">' +
                '<img src="'+imgRealURL+'" style="width:200px;height:100px"/>' +
                '<div class="file-panel"><span class="cancel"></span></div>'+
            '</div>';
	fileListObj.append(html );
}