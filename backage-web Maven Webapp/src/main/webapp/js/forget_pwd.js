$(function(){
	
	$(".admRest>button").hover(function(){
		$(this).css("backgroundColor","#4195F2");
		$(this).css("color","#fff");
	},function(){
		$(this).css("backgroundColor","#B4B4B4");
	});
});
$(".getYan input").click(function(){
	$(this).attr("disabled","true");
	$(this).siblings("span").css("display","inline-block");
	var sh;
	sh=setInterval(function(){
		
	},180000);
	clearInterval(sh);
	
});


$(function(){
	$("#Change-Btn").click(function(){
		forget();
	});
});


/**
 * 修改密码
 */
function forget(){
	if(userNameval()){
		var adminPwd = $("#adminPwd").val();//手机验证码
		var rePwdcode = $("#rePwdcode").val(); //密码
		var adminId = $("#adminId").val();
		var newpwd = hex_md5(rePwdcode);
		$.ajax({
			url : appPath+"/IdentyMess.do",
			data : {
				identyCode:adminPwd,
				adminId:adminId,
				newpwd:newpwd
			},
			type : "post",
			dataType:"text",
			error : function() {
				layer.alert("操作失败",{icon:0});
				return;
			},
			success : function(data) {//  
				if (data =1) {//验证成功
					layer.alert("修改密码成功，请重新登录!",{icon:1});
					history.go(-1);
				} else if (data =  -1) {
					layer.alert("验证码不正确!",{icon:2});
				}  else if (data =  -2) {
					layer.alert("验证码已失效!",{icon:2});
				}else{
					layer.alert("修改失败!",{icon:2});
				}
			}
		});
	}
}


/**
 * 手机验证码发送之前
 * @returns {Boolean}
 */
function identyPhone(){
	var userName = $("#adminPhone").val();
	var userNames =/^(13[0-9]|14[0-9]|15[0-9]|18[0-9])\d{8}$/;
	if (userName == "" || userName == null) {
		layer.alert("手机号不能为空！",{icon:0});
		return false;
	}
	if (!userNames.exec(userName)) {
		layer.alert("请输入11位正确的手机号！",{icon:0});
		return false;
	}
	
	var Yancode = $("#Yancode").val();
	var Yancodes =/^[0-9]\d{0,3}$/;
	if (Yancode == "" || Yancode == null) {
		layer.alert("图形验证码不能为空！",{icon:0});
		return false;
	}
	if (!Yancodes.exec(Yancode)) {
		layer.alert("图形验证码不正确！",{icon:0});
		return false;
	}
	return true;
}
//验证
function userNameval(){
	var adminPwd = $("#adminPwd").val();
	var adminPwds =/^\d{6}$/;
	if (adminPwd == "" || adminPwd == null) {
		layer.alert("请输入手机号！",{icon:0});
		return false;
	}
	if (!adminPwds.exec(adminPwd)) {
		layer.alert("手机验证码不对！",{icon:0});
		return false;
	}
	var Pwdcode = $("#Pwdcode").val();
	var Pwdcodes= /^[\@A-Za-z0-9\!\#\$\%\^\&\*\.\~]{6,22}$/;
	if (Pwdcode == "" || Pwdcode == null) {
		layer.alert("密码不能为空！",{icon:0});
		return false;
	}
	if (!Pwdcodes.exec(Pwdcode)) {
		layer.alert("请输入5-22位字母数字组成的密码！",{icon:0});
		return false;
	}
	var rePwdcode = $("#rePwdcode").val();
	if (rePwdcode == "" || rePwdcode == null) {
		layer.alert("密码不能为空！",{icon:0});
		return false;
	}
	if (rePwdcode != Pwdcode) {
		layer.alert("两次输入的密码不一样！",{icon:0});
		return false;
	}
	
	return true;
}
/**
 * 刷新验证码
 * @param img
 */
function refreshImg(img){
	$('#'+img).attr("src","authImage.do?tt="+Math.random(currentTimeMillis));
}
//
function Yanzheng(){
	if(!identyPhone()){
		return;
	}
	var phone = $("#adminPhone").val();//电话号码
	if(phone=="" || phone==null ){
		layer.alert("请输入手机号。",{icon:0});
		return ;
	}
	var code = $("#Yancode").val();
	if(code == "" || code==null){
		layer.alert("请输入验证码。",{icon:0});
		return ;
	}else{
		$.ajax({
			url : appPath+"/checkAuthCode.do",
			data : {
				pAuthCode:code,
			},
			type : "post",
			dataType:"text",
			error : function() {
				layer.alert("操作失败",{icon:0});
				return;
			},
			success : function(data) {
				if (data == 1) {//验证成功
					$.ajax({
						url : appPath+"/sendIdentyMess.do",
						data : {
							adminPhone:phone,
						},
						type : "post",
						dataType:"text",
						error : function() {
							layer.alert("操作失败",{icon:0});
							return;
						},
						success : function(data) {//  -1 手机号不存在  -2 改手机对应用户不是管理员 -3 改手机对应员工不是管理员  
							if (data >0) {//验证成功
								time();
								document.getElementById("getYan").style.display="";
								$("#adminId").val(data);
							} else if (data <0) {
								layer.alert("该手机对应管理员不存在!",{icon:2});
							}
						}
					});
					
				} else if (data == 0) {
					layer.alert("验证码错误!",{icon:2});
				}
			}
		});
	}
}  

var wait=180;  
function time() { 
	$div= $("#yanzheng");
    if (wait == 0) {  
    	$div.text("alt",("重新发送验证码")); 
    	$div.css({
    		"background-color":"rgb(65,149,242)",
    		"color":"#fff"
    	});
        wait = 180;  
    } else {  
    	$div.text("重新发送(" + wait + ")");
    	$div.css({
    		"background-color":"#B1C1FE",
    		"color":"#666"
    	});
        wait--;  
        setTimeout(function() {  
            time() ; 
        },1000) ; 
    }  
}