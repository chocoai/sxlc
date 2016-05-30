//加密设置
var encrypt = new JSEncrypt();
encrypt.setPublicKey(publicKey_common);

$(function(){
	//标签页切换
	$(".changePg").on("click",function(){
			var type = $(this).attr("changeType");
			changePg(type);
	});
	
	//页面初始化,默认为手机短信标签页
	$(".optionDiv").each(function () {
		var $this = $(this);
		var iSSmsSend = $this.attr("iSSmsSend");
		$this.find("input[type='radio'][value="+iSSmsSend+"]").attr('checked','true');
	});
	
});

/**
 * 标签页切换
 */
function changePg(type){
	if(type==1){
		$("#title").html("手机短信");
		$("#title").attr("submitType",1);
		//循环赋值
		$(".optionDiv").each(function () {
			var $this = $(this);
			var iSSmsSend = $this.attr("iSSmsSend");
			$this.find("input[type='radio'][value="+iSSmsSend+"]").prop('checked','true');
		});
	}else if(type==2){
		$("#title").html("站内消息");
		$("#title").attr("submitType",2);
		//循环赋值
		$(".optionDiv").each(function () {
			var $this = $(this);
			var iSLetterSend = $this.attr("iSLetterSend");
			$this.find("input[type='radio'][value="+iSLetterSend+"]").prop('checked','true');
		});
		
	}else if(type==3){
		$("#title").html("邮件");
		$("#title").attr("submitType",3);
		//循环赋值
		$(".optionDiv").each(function () {
			var $this = $(this);
			var iSEmailSend = $this.attr("iSEmailSend");
			$this.find("input[type='radio'][value="+iSEmailSend+"]").prop('checked','true');
		});
	}
};

/**
 * 提交按钮
 */
function saveData(){
	var data={};
	var type = $("#title").attr("submitType");
	data.type= encrypt.encrypt(type);
	var ids="";
	$(".optionDiv").each(function () {
		var $this = $(this);
		var id = $this.attr("typeID");
		var statu = $this.find("input[type='radio']:checked").val();
		if(statu ==1 ){
			ids +=id+",";
		}
	});
	data.content = ids.substring(0, ids.length-1);
	
	$.ajax( {  
		url:appPath+"/config/updateMsgSet.do",
		data:data,
		type:'post',  
		cache:false,  
		dataType:'json',  
		success:function(data) { 
			if(data==-2){
				layer.alert("用户未登录",{icon:2}); 
			}else{
				layer.alert("操作成功",{icon:1}); 
			}
		},  
		error : function() {  
			layer.alert("服务器异常",{icon:2}); 
		}  
	});
	
}

