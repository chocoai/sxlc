//重置
function Reset() {
	$("#adminName").val("");
	$("#adminPwd").val("");
	$("#code").val("");
}

//登录
function login() {
	if (userNameval()){
		var code = $("#code").val();
		if (code!=null && code!=""){
			$.ajax({
				url : "checkAuthCode.do",
				data : {
					pAuthCode:code
				},
				type : "post",
				dataType:"text",
				error : function() {
					layer.alert("操作失败！",{icon:0});  
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
								layer.alert("操作失败！",{icon:0});  
								return;
							},
							success : function(data) {
								if (data == 0) {
									window.location.href = "web/index/index.jsp"; // web/common/homPage.jsp
								} else if (data == 1) {
									layer.alert("登录失败！",{icon:2}); 
									refreshImg('vCodeImg');//刷新验证码
									return false;
								}else if (data == -1) {
									layer.alert("用户名不存在！",{icon:2}); 
									refreshImg('vCodeImg');//刷新验证码
									return false;
								} else if (data == 2) {
									layer.alert("密码错误！",{icon:2}); 
									refreshImg('vCodeImg');//刷新验证码
									return false;
								} else if (data == 3) {
									layer.alert("用户名已失效！",{icon:2}); 
									refreshImg('vCodeImg');//刷新验证码
									return false;
								}
							}
						});
					} else if (data == 0) {
						layer.alert("验证码错误！",{icon:2});  
						refreshImg('vCodeImg');//刷新验证码
					}
				}
			});
		}else {
			layer.alert("请输入验证码！",{icon:0});  
		}
	}else {
		return false;
	}
}

/*//验证码
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
				layer.alert("操作失败！",{icon:0});  
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
		layer.alert("请输入验证码！",{icon:0});  
	}
}*/
//回车登录
var flag = true;
function keyLogin(e){
	var event = window.event || e;
	if (event.keyCode==13 && flag ==true){
		flag = false;
		setTimeout(login,100);
	}
}

function userNameval() {
	// 得到用户名
	var userName = $("#adminName").val();
	var userNames = /^[A-z\d]{5,16}$/;
	if (userName == "" || userName == null) {
		layer.alert("用户名不能为空！",{icon:0});  
		return false;
	}
	if (!userNames.exec(userName)) {
		layer.alert("请输入5-16位数字或字母组成的用户名！",{icon:0});  
		return false;
	}
	var userPwd = $("#adminPwd").val();
	if (userPwd == "" || userPwd == null) {
		layer.alert("密码不能为空！",{icon:0});  
		return false;
	}
	return true;
}

/**
 * 用户名验证
 * @returns {Boolean}
 */
function nameIdenty(){
	var userName = $("#adminName").val();
	var userNames = /^[A-z\d]{5,16}$/;
	if (userName == "" || userName == null) {
		layer.alert("用户名不能为空！",{icon:0});  
		return false;
	}
	if (!userNames.exec(userName)) {
		layer.alert("请输入5-16位数字或字母组成的用户名！",{icon:0});  
		return false;
	}
}
/**
 * 密码验证
 */
function pwdIdenty(){
	var userPwd = $("#adminPwd").val();
	var pwds =/^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$/;
	if (userPwd == "" || userPwd == null) {
		layer.alert("密码不能为空！",{icon:0});  
		return false;
	}
	if (!pwds.exec(userPwd)) {
		layer.alert("请输入6~16位的数字和字母的组合！",{icon:0});  
		return false;
	}
}
/**
 * 加载执行
 */
$(function(){
	$("#loginBtn").click(function(){
		login();
	});
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