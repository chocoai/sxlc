$(function(){
	$(".TE").addClass("down");
	$(".TE4").addClass("down2");	
	
	//同步获取自动还款状态,判断显示
	var thirdAuthInfo = $("#thirdAuthInfo").val();//三方状态
	var openStatu = $("#openStatu").val();//开启状态
	if(thirdAuthInfo == 1 && openStatu == 1) {
		$("#toClose").addClass("active");
		$("#toOpen").removeClass("active");
	}else if(thirdAuthInfo == 1 && openStatu == 0) {
		$("#toOpen").addClass("active");
		$("#toClose").removeClass("active");
	}else{
		$("#toOpen").addClass("active");
		$("#toClose").removeClass("active");
	}
	
	//异步设置自动还款开启和关闭
	$(".auto-repay-ctrl .btn").click(function(){
		if(thirdAuthInfo == "" || thirdAuthInfo == 0){//判断三方开户授权
		    layer.confirm('您还未进行第三方开户授权，立即前往？', {icon: 3, title:'提示'}, function(index){
				window.location.href = "loanManagement/openAutoPay.html";//前往授权
				layer.close(index);
			});
			return;
		}
		
		var autoStatus = $(this).attr("data-statu");
		var encrypt = new JSEncrypt();
		encrypt.setPublicKey(publickey);
		statu=encrypt.encrypt(autoStatus+"");
		$.ajax({
			url:"loanManagement/updateIsAutoPay.html",
			data:{
				"statu": statu		//修改状态
			},
			type:"get",
			dataType:"json",
			timeout:10000,
			success:function(data){
				////console.log(data);
				if(data){
					if(autoStatus == 0){
						$("#toOpen").addClass("active");
						$("#toClose").removeClass("active");
					}else if(autoStatus == 1){
						$("#toClose").addClass("active");
						$("#toOpen").removeClass("active");
					}	
					layer.alert(data.message,{icon:1});
				}
			},
			error:function(){
				layer.alert("请求异常，请稍后再试",{icon:2});
			}
		});
	});
});


//function
