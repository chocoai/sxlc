/**
 * 会员管理  个人会员
 * 资料认证
 * 会员认证详情 房产认证
 * pr
 */

$(function(){
	if(btn=="1"){
		$("#submit").removeAttr("style");
	}else{
		$("#back").removeAttr("style");
	}
});



/**
 *   查询认证详情
 * @param memberId 会员id
 * @param typeId   认证类型
 */
function IdentyDetails(memberId){
	var encrypt = new JSEncrypt();
	encrypt.setPublicKey(publicKey_common);
	memberId = encrypt.encrypt(memberId+"");
	$.ajax( {  
		 url:appPath+"/memberidety/houseIdenty.do",
			data:{
				rid:memberId,
			},
			type:'post',  
			cache:false,  
			dataType:'json',   
			success:function(data) { 
				if(data!=null){
					$("#memerId").val(memberId);
					$("#applyId").val(data.rid);
					if(data.logName!=null){
						$("#logName").text(data.logName);
					}
					if(data.realName!=null){
						$("#realName").text(data.realName);
					}
					if(data.homeAddress!=null){
						$("#homeAddress").text(data.homeAddress);
					}
					if(data.area!=null){
						$("#area").text(data.area);
					}
					if(data.value!=null){
						$("#property").text(data.value);
					}
					if(data.sEndDate!=null){
						$("#sEndDate").val(data.sEndDate);
					}
					
					if(data.attachPath!=null && data.attachPath!=""){
						var arrPath = data.attachPath.split(",");
						var arrName = data.attachName.split(",");
						$.each(data,function(i,list){
							if((i%2)==0){
								$("#addImg").append("<tr><td style='height:220px;width:270px'>"
			                    +"  		<div class='img-polaroid' style='width: 250px;height: 200px;' align='center'>"
			                    +"      	 	<div style='border:1px solid #cccccc; class='thumb' >"
			                 	+"	<a data-gallery='gallery-contract' target='blank' href='"+arrPath[i]+"' class='document'>"
			                    +"         	  <img src='"+arrPath[i]+"' style='width:250px;height: 150px; '>"
			                    +"    </a></div>"
			                    +"   			<p><a>"+arrName[i]+"</a>&nbsp;&nbsp;</p>"
			                    +"</div></td></tr>");
							}else{
								$("#addImg tr:last").append("<td style='height:220px;width:270px'>"
			                    +"  		<div class='img-polaroid' style='width: 250px;height: 200px;' align='center'>"
			                    +"      	 	<div style='border:1px solid #cccccc;class='thumb'>"
			                    +"	<a data-gallery='gallery-contract' target='blank' href='"+arrPath[i]+"' class='document'>"
			                    +"         	  <img src='"+arrPath[i]+"' style='width:250px;height: 150px; '>"
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
	
	var memberId = $("#memberId").val();
	var sEndDate = $("#sEndDate").val();
	var attestId = $("#applyId").val();
	var statu = $("#statu").val();
	var encrypt = new JSEncrypt();
	encrypt.setPublicKey(publicKey_common);
	
	//result 为加密后参数
	memberId = encrypt.encrypt(memberId+"");
	attestId = encrypt.encrypt(attestId+"");
	statu = encrypt.encrypt(statu+"");
	sEndDate = encrypt.encrypt(sEndDate+"");
	$.ajax( {  
		 url:appPath+"/memberidety/submitCommonIdty.do",
			data:{
				memberId:memberId,
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