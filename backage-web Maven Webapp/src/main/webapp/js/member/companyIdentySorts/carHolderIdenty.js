/**
 * 会员管理  企业会员
 * 资料认证
 * 车产认证
 * pr
 */

$(function(){
	if(btn=="1"){
		$(".back").eq(0).removeAttr("style");
	}else if(btn=="2"){
		$(".back").eq(1).removeAttr("style");
	}else if(btn=="3"){
		$(".back").eq(2).removeAttr("style");
	}
});


/**
 *  根据id 查询认证详情
 */
function IdentyDetails(identyId,typeId){
	$("#applyId").val(identyId);
	var hostPath = $("#hostPath").val();
	$.ajax( {  
		 url:appPath+"/companyidety/identyDetail.do",
			data:{
				content:identyId,
				start:typeId
			},
			type:'post',  
			cache:false,  
			dataType:'json',   
			success:function(data) { 
				//console.log(JSON.stringify(data));
				if(data!=null){
					$("#memberId").val(data.memberID);
					if(data.company!=null){//公司名称
						$("#company").text(data.company);
					}
					if(data.logname!=null){//登录名
						$("#logname").text(data.logname);
					}
					if(data.brand!=null){//车品牌
						$("#brand").text(data.brand);
					}
					if(data.model!=null){//车型号
						$("#model").text(data.model);	
					}
					if(data.licensePlate!=null){//车牌号
						$("#licensePlate").text(data.licensePlate);	
					}
					if(data.value!=null){//车价值
						$("#value").text(data.value);	
					}
					if(data.sEndDate!=null){//有效期
						$("#sEndDate").val(data.sEndDate);	
					}
					
					if(data.attachPath!=null && data.attachPath!=""){
						var arrPath = data.attachPath.split(",");
						var arrName = data.attachName.split(",");
						$.each(arrPath,function(i,list){
							if((i%3)==0){
								$("#addImg").append("<tr><td style='height:220px;width:270px'>"
			                    +"  		<div class='img-polaroid' style='width: 250px;height: 200px;' align='center'>"
			                    +"      	 	<div style='border:1px solid #cccccc; class='thumb' >"
			                 	+"	<a data-gallery='gallery-contract' target='blank' href='"+hostPath+arrPath[i]+"' class='document'>"
			                    +"         	  <img src='"+hostPath+arrPath[i]+"' style='width:250px;height: 150px; '>"
			                    +"    </a></div>"
			                    +"   			<p><a>"+arrName[i]+"</a>&nbsp;&nbsp;</p>"
			                    +"</div></td></tr>");
							}else{
								$("#addImg tr:last").append("<td style='height:220px;width:270px'>"
			                    +"  		<div class='img-polaroid' style='width: 250px;height: 200px;' align='center'>"
			                    +"      	 	<div style='border:1px solid #cccccc;class='thumb'>"
			                    +"	<a data-gallery='gallery-contract' target='blank' href='"+hostPath+arrPath[i]+"' class='document'>"
			                    +"         	  <img src='"+hostPath+arrPath[i]+"' style='width:250px;height: 150px; '>"
			                    +"       	 </a>	</div>"
			                    +"   			<p><a>"+arrName[i]+"</a>&nbsp;&nbsp;</p>"
			                    +"</div></td>");						
							}
						});

					}
				}
			},  
			error : function() {  
				layer.alert("服务器异常",{icon:2});  
			}  
		});
}

/**
 *  提交认证
 */
function submitIdentyList(){
	
	var memberID = $("#memberId").val();
	var attestId = $("#applyId").val();
	var statu = $("#statu").val();
	var sEndDate = $("#sEndDate").val();
	var encrypt = new JSEncrypt();
	encrypt.setPublicKey(publicKey_common);
	
	//result 为加密后参数
	memberID = encrypt.encrypt(memberID+"");
	attestId = encrypt.encrypt(attestId+"");
	statu = encrypt.encrypt(statu+"");
	sEndDate = encrypt.encrypt(sEndDate);
	$.ajax( {  
		 url:appPath+"/companyidety/submitDobusiness.do",
			data:{
				memberID:memberID,
				attestId:attestId,
				statu:statu,
				sEndDate:sEndDate
			},
			type:'post',  
			cache:false,  
			dataType:'json',   
			success:function(data) { 
				if(data!=null && data!=""){
					if(data == 1){
						layer.alert("审核成功。",{icon:1});  
						window.location.href = appPath+"/web/member/companyVitureAuthen.jsp?content="+typeId;
					}else if(data == 2){
						layer.alert("该认证项已审核。",{icon:0}); 
					}else {
						layer.alert("审核失败。",{icon:2}); 
					}
				}
			},  
			error : function() {  
				layer.alert("服务器异常",{icon:2});  
			}  
		});
}