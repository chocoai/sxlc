
/***********验证***********/
$(function(){
	loadUserBalance();
	$(".transferBtn1").on("click",function(){
		var amount = $("#amount").val();
		var remark = $("#remark").val();
		var imgCode = $("#imgCode").val();
		var code = $("#code").val();
		var friendId = $("#friendId").val();
		
		var data = {};
		var encrypt = new JSEncrypt();
		encrypt.setPublicKey(publickey);
		
		data.friendId 	= encrypt.encrypt(friendId);
		data.amount 	= encrypt.encrypt(amount);
		data.remark 		= encrypt.encrypt(remark);
		data.imgCode 	= encrypt.encrypt(imgCode);
		data.code     	= encrypt.encrypt(code); 
		
		//把加密后的值放入form表单中的隐藏域
		$("input[name='friendId']").val(data.friendId);
		$("input[name='amount']").val(data.amount);
		$("input[name='remark']").val(data.remark);
		$("input[name='imgCode']").val(data.imgCode);
		$("input[name='code']").val(data.code);
		
		$("#transfer").submit();
	});
	
	/*$("#transfer").Validform({
		tiptype:3,//提示信息类型
		btnSubmit:".btn", 
		datatype:extdatatype,
		beforeSubmit:function(){
			var amount = $("#amount").val();
			var remark = $("#remark").val();
			var imgCode = $("#imgCode").val();
			var code = $("#code").val();
			var friendId = $("#friendId").val();
			
			var data = {};
			var encrypt = new JSEncrypt();
			encrypt.setPublicKey(publickey);
			
			data.friendId 	= encrypt.encrypt(friendId);
			data.amount 	= encrypt.encrypt(amount);
			data.remark 		= encrypt.encrypt(remark);
			data.imgCode 	= encrypt.encrypt(imgCode);
			data.code     	= encrypt.encrypt(code); 
			
			//把加密后的值放入form表单中的隐藏域
			$("input[name='friendId']").val(data.friendId);
			$("input[name='amount']").val(data.amount);
			$("input[name='remark']").val(data.remark);
			$("input[name='imgCode']").val(data.imgCode);
			$("input[name='code']").val(data.code);
			
			return true;
		}
	});*/
	$(".codeBtn").on("click",function(){
		//var phone = $("#phone").val();
		var imgCode = $(".imgCode").val();
		var data = {};
		var encrypt = new JSEncrypt();
		encrypt.setPublicKey(publickey);
		
		//data.phone = encrypt.encrypt(phone);
		data.imgCode = encrypt.encrypt(imgCode);
		var url = "friendTransfer/sendFriendTransferPhoneVarCode.html";
		
		
		NetUtil.ajax(
			url,data,function(r){
				var data = JSON.parse(r);
				if(data.statu<0){
					$(".codeImg").attr("src","authImage.html?type=3&parma="+Math.random() * 10);
					layer.alert(data.message);
				}else if(data.statu=1){
					layer.alert(data.message);
					settime($(".codeBtn"));//倒计时
				}else{
					settime($(".codeBtn"));//倒计时
				}
			}
		);
	});
});
//短信发送间隔倒计时
function settime(val) {
	var countdown = 180;
	val.addClass("disabled");
	var run = setInterval(function(){
		
		val.html(countdown+"s");
		countdown--;
		if (countdown<=0){
			clearInterval(run);
			val.html("重新发送");
			val.removeClass("disabled");
		}
	},1000);
}

/*   好友管理--转账  胥福星   20160520  */
$(".codeImg").on("click",function(){
	$(".codeImg").attr("src","authImage.html?type=3&parma="+Math.random() * 10);
});
/*************获取可用余额（可转账金额）*******************************/
function loadUserBalance(){
	$.ajax({
		url:"friendTransfer/loadUserBalance.html",
		type:"post",
		dataType:"json",
		async:false,
		success:function(msg){
			if(msg.data==null){
				layer.alert("你还没有开通第三方账户，现在去开通",function(){
					window.location.href="personalCenter/securityCenter.html";
				});
			}else{
				$("#userBalance").html(msg.data.userBalances);
				//格式化金额
				$(".moneyFormat").each(function(){
					var s = $(this).text();
					var str = parseFloat(s);
					var n = $(this).format(str);
					$(this).text(n);
				});
				loadPhone();
			}
		},
		error:function(){
			layer.alert("网络链接失败请重试",function(){
				loadUserBalance();
			});
		}
	});
}
//获取当前登录人的手机号
function loadPhone(){
	$.ajax({
		url:"friendTransfer/loadPhone.html",
		type:"post",
		dataType:"json",
		async:false,
		success:function(msg){
			if(msg.data==null){
				layer.alert("你还没有开通第三方账户，现在去开通",function(){
					window.location.href="personalCenter/securityCenter.html";
				});
			}else{
				$("#phone").val(msg.data);
			}
		},
		error:function(){
			layer.alert("网络链接失败请重试",function(){
				loadUserBalance();
			});
		}
	});
}