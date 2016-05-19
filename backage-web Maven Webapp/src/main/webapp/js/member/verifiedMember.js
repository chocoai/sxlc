
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
 * 会员提交认证项
 * @param memberId
 */
function selectAuditList(memberId){
	var encrypt = new JSEncrypt();
	encrypt.setPublicKey(publicKey_common);
	//result 为加密后参数
	var mid  = encrypt.encrypt(memberId+"");
	$.ajax( {  
		 url:appPath+"/member/getMemberIdenty.do",
			data:{
				memberId:mid
			},
			type:'post',  
			cache:false,  
			dataType:'json',   
			success:function(data) { 
				if(data!=null){
					
					if(data.length>0){
						var html ="";
						$.each(data,function(index,obj){
							var statu = "";
							if(obj.status==1){
								statu = "待审核";
							}else if(obj.status ==2){
								statu = "已认证";
							}else if(obj.status ==3){
								statu = "已打回";
							}
							var valid ="永久有效";
							if(obj.sEndDate !=null && obj.sEndDate!=""){
								valid = obj.sEndDate;
							}
							var recordDate ="";
							if(obj.recordDate!=null){
								recordDate = obj.sRecordDate;
							}
							html +="<ul class='detailTitle'>"
								+"<li >"+obj.attestName+"</li><li>"+statu+"</li>"
								+"<li >申请时间："+recordDate+"</li><li>有效期："+valid+"</li>"
								+"<li><button class='identy-detail' data-mtype="+obj.memberType+" data-rid="+obj.certificationId+" data-type="+obj.attestType+">查看详情</button></li>"
								+"</ul>";
						});
						$(".authen").append(html);
					}
					
					$(".identy-detail").on("click",function(){
						var rid = $(this).attr("data-rid");//认证id(车产房产认证一个会员有多条数据)
						var type = $(this).attr("data-type");//认证类型
						var memberType = $(this).attr("data-mtype");//会员类型
						var url =appPath+"/web/member/";
				/*********个人会员************/
						if(type == 1){//实名认证
						//draw 返回 上一级页面
							url +="nameAuthenResualt.jsp?start="+type+"&content="+memberId+"&draw=3";
						}else if(type ==2 || type ==3 || type==5 || type==6 || type== 9){//其他
							url +="per-comAuthenResualt.jsp?start="+type+"&content="+memberId+"&draw=3";
						}else if(type == 4){//住址认证
							url +="perAddressResualt.jsp?start="+type+"&content="+memberId+"&draw=3";
						}else if(type == 7){//房产
							url +="per-freeholdResualt.jsp?start="+type+"&content="+rid+"&draw=3";
						}else if(type == 8){//车产
							url +="per-carProductionResuslt.jsp?start="+type+"&content="+rid+"&draw=3";
						}else if(type == 10){//婚姻
							url +="per-marrigeResualt.jsp?start="+type+"&content="+memberId+"&draw=3";
						}else if(type == 11){//学历
							url +="per-titleResualt.jsp?start="+type+"&content="+memberId+"&draw=3";
						}
				/*********企业会员************/
						else if(type == 12){//营业执照认证
							url +="businessLicenseResualt.jsp?start="+type+"&content="+rid+"&draw=3";
						}else if(type == 13){//工商执照认证
							url +="businessLicenseCResualt.jsp?start="+type+"&content="+rid+"&draw=3";
						}else if(type == 14){//组织机构认证
							url +="organizationResualt.jsp?start="+type+"&content="+rid+"&draw=3";
						}else if(type == 15){//开户许可证
							url +="accountOpeningResualt.jsp?start="+type+"&content="+rid+"&draw=3";
						}else if(type ==16 || type == 17 || type == 19 || type == 20 || type == 21  ){//其他 
							url +="companyComResualt.jsp?start="+type+"&content="+rid+"&draw=3";
						}else if(type ==18 ){
							url +="taxRegistrationResualt.jsp?start="+type+"&content="+rid+"&draw=3";
						}else if(type == 22){//房产
							url +="companyFreeholdResualt.jsp?start="+type+"&content="+rid+"&draw=3";
						}else if(type == 23){//车产
							url +="companyVitureResualt.jsp?start="+type+"&content="+rid+"&draw=3";
						}else{
							if(memberType==0){
								url +="per-comAuthenResualt.jsp?start=26&content="+memberId+"&draw=3";//个人会员其他额外认证
							}else{
								url +="companyComResualt.jsp?start=26&content="+rid+"&draw=3";//企业会员其他额外认证
							}
						}
					  window.location.href = url ;
						
					});
				}
			},  
			error : function() {  
				layer.alert("服务器异常",{icon:2});  
			}  
		});
	
}

