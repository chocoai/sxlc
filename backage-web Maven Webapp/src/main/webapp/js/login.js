//重置
function Reset() {
	$("#adminName").val("");
	$("#adminPwd").val("");
}

//登录
function login() {
	if (userNameval()){
		var adminName=$("#adminName").val();
		var adminPwd=$("#adminPwd").val();
		adminPwd=hex_md5(adminPwd);
		/*var sMac = GetMacAddress();*/
		$.ajax({
			url : "adminLogin.do",
			data : {
				adminName:adminName,
				adminPwd:adminPwd
			},
			type : "post",
			dataType:"text",
			error : function() {
				openwindow("操作失败！");
				return;
			},
			success : function(data) {
				if (data == 0) {
					window.location.href = "web/index/index.jsp"; // web/common/homPage.jsp
				} else if (data == 1) {
					openwindow("登录失败！");
					return false;
				}else if (data == -1) {
					openwindow("用户名不存在！");
					return false;
				} else if (data == 2) {
					openwindow("密码错误！");
					return false;
				} else if (data == 3) {
					openwindow("用户名已失效！");
					return false;
				}
			}
		});
		//window.location.href = "web/common/homPage.jsp";

	}else {
		return false;
	}
}


//回车登录
function keyLogin(){
	if (event.keyCode==13){
		setTimeout(login,100);
	}
}

function userNameval() {
	// 得到用户名
	var userName = $("#adminName").val();
	var userNames = /^[A-z\d]{5,16}$/;
	if (userName == "" || userName == null) {
		openwindow("用户名不能为空！");
		return false;
	}
	if (!userNames.exec(userName)) {
		openwindow("请输入5-16位数字或字母组成的用户名！");
		return false;
	}
	var userPwd = $("#adminPwd").val();
	if (userPwd == "" || userPwd == null) {
		openwindow("密码不能为空！");
		return false;
	}
	return true;
}

function openwindow(mess){
	alert(mess);
}
/**
 * 加载执行
 */
$(function(){
	$("#loginBtn").click(function(){
		login();
	});
	keyLogin();
});