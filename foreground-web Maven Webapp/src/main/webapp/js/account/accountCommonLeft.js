$(function(){
	loadMemberInfo();
});
function loadMemberInfo(){
	$.ajax({
		url:"personalCenter/loadMemberInfo.html",
		type:"get",
		dataType:"json",
		success:function(message){
			var data = message.data;
			$(".left_name").html(data.logname);
			$(".integralLevelName").html(data.integralLevelName);
			$(".creditLevelName").html(data.creditLevelName);
			$(".integral_score").html(data.integral+"积分");
			if(data.thirdPartyAccount!=undefined && data.thirdPartyAccount!=""){
				$("#thirdStatu").attr("value","0");
				$(".mark5").attr("openThird","0");//已开通
				$(".mark5 img").attr("src","resource/img/account/common/wdzh_14.png");
				$(".thirdPartyAccount").html(data.thirdPartyAccount);
			}else{
				$("#thirdStatu").attr("value","1");
				$(".mark5").attr("openThird","1");//已开通
				$(".thirdPartyAccount").parent().remove();
			}
			$(".recordNum").html(data.recordNum);
			if(data.personalIdCard!=undefined&&data.personalIdCard!=""){
				$(".mark1 img").attr("src","resource/img/account/common/wdzh_6.png");
			}
			if(data.personalPhone!=undefined&&data.personalPhone!=""){
				$(".mark2 img").attr("src","resource/img/account/common/wdzh_8.png");
			}
			if(data.personalEmail!=undefined&&data.personalEmail!=""){
				$(".mark3 img").attr("src","resource/img/account/common/wdzh_10.png");
			}
		}
	});
}
