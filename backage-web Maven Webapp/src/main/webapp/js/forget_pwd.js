$(function(){
	$(".admRest>button").hover(function(){
		$(this).css("backgroundColor","#4195F2");
		$(this).css("color","#fff");
	},function(){
		$(this).css("backgroundColor","#B4B4B4");
	});
});
//jQuery.fn.changeRemarks = function(){//�����޳������ַ�
//	var remarks2 = $(this).val() ;
//	var cont = remarks2.length;
//	for(var c = 0;c < cont ; c++){
//		remarks2=remarks2.replace(/["'<>%;)(&+]/,"");
//	}
//	$(this).val(remarks2);
//};
$(".getYan input").click(function(){
	$(this).attr("disabled","true");
	$(this).siblings("span").css("display","inline-block");
	var sh;
	sh=setInterval(function(){
		
	},180000);
	clearInterval(sh);
	
});
//$(function(){
//	$("#forget_pass").Validform({
//		tiptype:3,
//		btnSubmit:"#Change-Btn", 
//		datatype:{"zPhone":zPhone,"Z6":Z6,"acountM":acountM,"regpass":regpass},
//		ajaxPost:{
//			
//		    },
//			success:function(data,obj){
//	            
//	        },
//	        error:function(data,obj){
//	            
//	        }
//		});
//});
$(function(){
	$("#Change-Btn").click(function(){
		forget();
	});
		keyforget();
});
//�س�
function keyforget(){
	if (event.keyCode==13){
		setTimeout(function(){
			forget();
		},100);
	}
}
//ajax
function forget(){
	if(userNameval()){
		
	}
}

//��֤
function userNameval(){
	//�ֻ��
	var userName = $("#adminName").val();
	var userNames =/^(13[0-9]|14[0-9]|15[0-9]|18[0-9])\d{8}$/;
	if (userName == "" || userName == null) {
		openwindow("手机号不能为空！");
		return false;
	}
	if (!userNames.exec(userName)) {
		openwindow("请输入11位正确的手机号！");
		return false;
	}
	//�ֻ���֤��
	var adminPwd = $("#adminPwd").val();
	var adminPwds =/^\d{6}$/;
	if (adminPwd == "" || adminPwd == null) {
		openwindow("手机验证码不能为空！");
		return false;
	}
	if (!adminPwds.exec(adminPwd)) {
		openwindow("手机验证码不对！");
		return false;
	}
	//ͼ����֤��
	var Yancode = $("#Yancode").val();
	var Yancodes =/^\d{4}$/;
	if (Yancode == "" || Yancode == null) {
		openwindow("图形验证码不能为空！");
		return false;
	}
	if (!Yancodes.exec(Yancode)) {
		openwindow("图形验证码不正确！");
		return false;
	}
	
	//������
	var Pwdcode = $("#Pwdcode").val();
	var Pwdcodes= /^[\@A-Za-z0-9\!\#\$\%\^\&\*\.\~]{6,22}$/;
	if (Pwdcode == "" || Pwdcode == null) {
		openwindow("密码不能为空！");
		return false;
	}
	if (!Pwdcodes.exec(Pwdcode)) {
		openwindow("请输入5-22位字母数字组成的密码！");
		return false;
	}
	//�ٴ�����
	var rePwdcode = $("#rePwdcode").val();
	if (rePwdcode == "" || rePwdcode == null) {
		openwindow("密码不能为空！");
		return false;
	}
	if (rePwdcode != Pwdcode) {
		openwindow("两次输入的密码不一样！");
		return false;
	}
	
	return true;
}
/**
 * ͼƬ��֤��
 * @param {ͼ����֤��id} img
 * ʹ�ý�������� var currentTimeMillis = "<%=System.currentTimeMillis()%>";
 * ���ã�refreshImg(objId);
 */
function refreshImg(img){
	$('#'+img).attr("src","authImage.do?tt="+Math.random(currentTimeMillis));
}
//
function Yanzheng(){
	$(".getYan").css("display","block");
}