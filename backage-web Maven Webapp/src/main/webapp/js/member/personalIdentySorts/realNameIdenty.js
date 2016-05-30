/**
 * 会员管理  个人会员
 * 资料认证
 * 会员实名认证
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
 *  根据id 查询实名认证
 */
function reanlNameIdentyList(memberId){
	var hostPath = $("#hostPath").val();
	$.ajax( {  
		 url:appPath+"/memberidety/realNameIdenty.do",
			data:{
				content:memberId
			},
			type:'post',  
			cache:false,  
			dataType:'json',   
			success:function(data) { 
				if(data!=null){
					//console.log(JSON.stringify(data));
					$("#applyId").val(data.aid);
					$("#memberId").val(memberId);
					if(data.realName!=null && data.realName!=""){
						$("#realName").text(data.realName);
					}
					if(data.nationName!=null && data.nationName!=""){
						$("#nation").text(data.nationName);
					}
					if(data.sexId==0){
						$("#sex").text("男");
					}else{
						$("#sex").text("女");
					}
					if(data.homeTown!=null && data.homeTown!=""){
						$("#native").text(data.homeTown);
					}
					if(data.sEndDate!=null && data.sEndDate!=""){
						$("#sEndDate").val(data.sEndDate);
					}
					if(data.personalIDCard!="" && data.personalIDCard!=null){
						$("#idcard").text(data.personalIDCard);
					}
					var $img1 = $("#right_idcard");//身份证正面
					var $img2 = $("#left_idcard");//身份证饭面
					var profix = "";  //前缀
					if(data.positive!=null && data.positive !=""){
						$img1.attr("src",hostPath + data.positive);
					}
					if(data.reverse!=null && data.reverse !=""){
						$img2.attr("src",hostPath +data.reverse);
					}
					
				}
			},  
			error : function() {  
				layer.alert("服务器异常",{icon:2});  
			}  
		});
}

/**
 *  提交实名认证
 */
function submitIdentyList(){
	
	var memberId = $("#memberId").val();
	var attestId = $("#applyId").val();
	var statu = $("#statu").val();
	var sEndDate = $("#sEndDate").val();
	var encrypt = new JSEncrypt();
	encrypt.setPublicKey(publicKey_common);
	
	//result 为加密后参数
	memberId = encrypt.encrypt(memberId+"");
	attestId = encrypt.encrypt(attestId+"");
	statu = encrypt.encrypt(statu+"");
	sEndDate = encrypt.encrypt(sEndDate);
	$.ajax( {  
		 url:appPath+"/memberidety/submitRealName.do",
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
						window.location.href = appPath+"/web/member/realNameAuthen.jsp?content="+typeId; 
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