
/**
 * 企业\个人通用认证---->附件+有效期  @author LHL
 */

$(function(){
	insertCertification();
	quryCertification();
});

/**
 * 添加\修改认证资料
 */
function insertCertification(){
	
	$(".btn_u").click(function(){
		var type=$(this).attr("id");//认证类型
		var editType=$(".editType").val();//0-新增  1-修改 
		var endTime=$(".dateSelect").val();
		if(endTime=="请选择有效期"){
			endTime="";
		}
		var authPrev=$(".authPreviDiv_u .authPreviDiv");
		var url=[];//附件路径数组
		if(authPrev.length==0){
			layer.alert("请上传认证附件");
			return;
		}
		//循环图片地址
		var path;
		authPrev.each(function(){
			path=$(this).find(".previewHide").val();
			url.push(path);
		});
		//附件","分开
		var annex=url.join(",");
		var encrypt = new JSEncrypt();
		encrypt.setPublicKey(publickey);
		type=encrypt.encrypt(type+"");
		editType=encrypt.encrypt(editType+"");
		endTime=encrypt.encrypt(endTime+"");
		var str_url="personalCenter/currencyAuth.html";
		NetUtil.ajax(
				str_url,
				{editType:editType,type:type,endTime:endTime,annex:annex},
				function(r){
					//console.log(r);
					var r = JSON.parse(r);
					if (r.status == 0){
						layer.alert("操作成功",function(){
							window.location.href="personalCenter/loanCertification.html";
						})
					}else{
						layer.alert(r.message)
					}
				}
			)		
		
	});
}

/**
 * 查询认证资料附件
 */
function quryCertification(){
	var type=$(".btn_u").attr("id");
	var encrypt = new JSEncrypt();
	encrypt.setPublicKey(publickey);
	type=encrypt.encrypt(type+"");
	var str_url="personalCenter/loadCurrencyAuth.html";
	NetUtil.ajax(
			str_url,
			{type:type},
			function(r){
				var r = JSON.parse(r);
				if (r.status == 0){
					var data=r.data;
					//console.log(data);
					if(data!=null && data!=""){
						var statu = data.status;
						if(statu=="0" || statu=="3" || statu=="4"){
							$(".editType").val("0");
						}else{
							$(".editType").val("1");
						}
						console.log(r)
						var attachPrefix=data.attachPrefix;
						var attachPath=data.attachPath;
						if(attachPath!=null && attachPath!=""){
							var attach=attachPath.split(",");
							for(var i=0;i<attach.length;i++){
								var url=attachPrefix+attach[i];
								var text="<div class='authPreviDiv'>"+
				   				"<img class='previewImg'   src='"+url+"'>"+
				   				"<input type='hidden' class='previewHide' value='"+attach[i]+"' />"+
				   				"</div>";
								$(".authPreviDiv_u").append(text);							
							}
						}
						
						var endTime=data.sEndDate;
						if(endTime!=null && endTime!=""){
							$(".dateSelect").val(endTime);
						}
						
					}
				}
			}
		)	
}