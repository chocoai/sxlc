function changeState(projectId,typeId,option){
	var encrypt = new JSEncrypt();
	encrypt.setPublicKey(publickey);
	
	var data = {};
	data.projectId = encrypt.encrypt(projectId+"");
	data.typeId = encrypt.encrypt(typeId+"");
	data.option = encrypt.encrypt(option+"");
	var url = "personalCenter/messageConfig.html";
	NetUtil.ajax(
			url,
			data,
			function(r){
				var data = JSON.parse(r);
				//console.log(data)
				if (data.status == "1"){
					layer.alert("修改成功",function(){
						window.location.reload();
					});
				}else if(data.status ！= "1"){
					layer.alert(data.message,function(){
						window.location.reload();
					});
				}
			}
	)
}

$(function(){
	$(".TB").addClass("down");
	$(".TB10").addClass("down2");
	/*点击切换背景图片部分开始 王延君 2016-04-02*/
	$(".messageAlertMCont label").bind("click",function(){
		if($(this).hasClass("labelUnSelect")){
			$(this).removeClass("labelUnSelect");
			$(this).addClass("labelSelect");
		}else{
			$(this).removeClass("labelSelect");
			$(this).addClass("labelUnSelect");
		}
	});
	/*点击切换背景图片部分结束*/
	
	
	/*2016-5-9 付晨早*/
	$(".shortMessage label").bind("click",function(){
		var typeId = "1";
		var flag = $(this).hasClass("labelUnSelect");
		if (flag){
			var statu = "0";
		}else{
			var statu = "1";
		}
		var projectId = $(this).parent().parent().attr("data-tId");
		changeState(projectId,typeId,statu);
	});
	$(".websiteMessage label").bind("click",function(){
		var typeId = "2";
		var flag = $(this).hasClass("labelUnSelect");
		if (flag){
			var statu = "0";
		}else{
			var statu = "1";
		}
		var projectId = $(this).parent().parent().attr("data-tId");
		changeState(projectId,typeId,statu);
	});
	$(".e-mail label").bind("click",function(){
		var typeId = "3";
		var flag = $(this).hasClass("labelUnSelect");
		if (flag){
			var statu = "0";
		}else{
			var statu = "1";
		}
		var projectId = $(this).parent().parent().attr("data-tId");
		changeState(projectId,typeId,statu);
		
	});
});