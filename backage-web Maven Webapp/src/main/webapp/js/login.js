//重置
function Reset() {
	$("#adminName").val("");
	$("#adminPwd").val("");
}

//登录
function login() {
	if (userNameval()){
		var code = $("#code").val();
		if (code!=null && code!=""){
			$.ajax({
				url : "checkAuthCode.do",
				data : {
					pAuthCode:code,
				},
				type : "post",
				dataType:"text",
				error : function() {
					openwindow("操作失败！");
					return;
				},
				success : function(data) {
					if (data == 1) {
						var adminName=$("#adminName").val();
						var adminPwd=$("#adminPwd").val();
						adminPwd=hex_md5(adminPwd);
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
									window.location.href = "toIndex.do"; // web/common/homPage.jsp
								} else if (data == 1) {
									openwindow("登录失败！");
									refreshImg('vCodeImg');//刷新验证码
									return false;
								}else if (data == -1) {
									openwindow("用户名不存在！");
									refreshImg('vCodeImg');//刷新验证码
									return false;
								} else if (data == 2) {
									openwindow("密码错误！");
									refreshImg('vCodeImg');//刷新验证码
									return false;
								} else if (data == 3) {
									openwindow("用户名已失效！");
									refreshImg('vCodeImg');//刷新验证码
									return false;
								}
							}
						});
					} else if (data == 0) {
						alert("验证码错误！");
					}
				},
			});
		}else {
			alert("请输入验证码！");
		}
	}else {
		return false;
	}
}

//验证码
function codeIdenty(_index) {
	_index=0;
	var code = $("#code").val();
	if (code!=null && code!=""){
		$.ajax({
			url : "checkAuthCode.do",
			data : {
				pAuthCode:code,
			},
			type : "post",
			dataType:"text",
			error : function() {
				openwindow("操作失败！");
				return;
			},
			success : function(data) {
				if (data == 1) {
				} else if (data == 0) {
				}
			},
			complete:function(){
				_index=1;
			}
		});
	}else {
		alert("请输入验证码！");
	}
}
//回车登录
function keyLogin(){
	if (event.keyCode==13){
		setTimeout(function(){
			login();
		},100);
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

/**
 * 图片验证码
 * @param {图形验证码id} img
 * 使用界面需添加 var currentTimeMillis = "<%=System.currentTimeMillis()%>";
 * 调用：refreshImg(objId);
 */
function refreshImg(img){
	$('#'+img).attr("src","authImage.do?tt="+Math.random(currentTimeMillis));
}