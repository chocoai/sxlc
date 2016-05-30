$(function(){
	if($(".online").length>0){
		loadUntreatedMessage();
	}
});

/*********************读取未读站内信，站内消息，待处理好友申请数*******************************/
function loadUntreatedMessage(){
	$.ajax({
		url:"personalCenter/loadUntreatedMessage.html",
		type:"get",
		dataType:"json",
		success:function(data){
			//console.log(data);
			$(".messageNum").html(data.stationMessageNum+data.letterNum);
			if(data.stationMessageNum>0){
				$(".messageNum").on("click",function(){
					window.location.href="personalCenter/stationMessage.html";
				});
			}else{
				$(".messageNum").on("click",function(){
					window.location.href="personalCenter/mail.html";
				});
			}
			$(".applicationFriendNum").html(data.applicationFriendNum);
		}
	});
}