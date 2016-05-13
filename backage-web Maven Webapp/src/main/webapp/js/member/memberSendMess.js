/**
 * 会员管理
 * 发送信息
 */

/**
 * 会员基本信息 手机号和邮箱
 */
function  showMemberDetail(memberId){
	var  url= appPath+"/member/getMemDetail.do";
	$.ajax( {  
		 url:url,
			data:{
				memberId:memberId
			},
			type:'post', 
			cache:false,  
			dataType:'json',   
			success:function(data) { 
				if(data!=null){
					if(data.memberPhone!=null){
						$("#memberPhone").text(data.memberPhone);
					}
					if(data.memberEmail!=null){
						$("#memberEmail").text(data.memberEmail);
					}
				}
			},  
			error : function() {  
				layer.alert("服务器异常",{icon:2});  
			}  
		});
	
}
