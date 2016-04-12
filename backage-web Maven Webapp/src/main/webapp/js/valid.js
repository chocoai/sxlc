/**
 * @description validform公用校验方法
 * @author chenzhen
 * @version v1.0
 */

//验证规则
var isSpecial = /[`~!@#\$%\^&\*\(\)_\+<>\?:\"{},\.\/;'\[\\]]$/;//特殊字符
var notSpecial = /^[`~!@#\$%\^&\*\(\)_\+<>\?:\"{},\.\/;'\[\\]]$/;//特殊字符
var logName = /^([\u4e00-\u9fa5]||[a-zA-Z0-9]){1,10}$/;//登录名(用户名)，6~16位的数字、字母或汉字；
var enterNameReg = /^[\u4E00-\u9FA5A-Za-z0-9]{1,12}$/;//部门名称,1~12位的数字、字母或中文；
var enterPerson = /^[\u4E00-\u9FA5]{2,8}$/;//部门负责人,2~8位中文；
var remarks= /^((?![a-zA-Z]+$)||(?![a-z0-9]+$))[\u4E00-\u9FA5a-zA-Z0-9]{0,50}$/; //备注50位以内任意字符，不可为特殊字符
//var enterAddress = /^[\u4E00-\u9FA5A-Za-z0-9-\（\）\(\)]{4,30}$/;//企业地址,4~30位的数字、字母或汉字-；
var enterAddress = /^[\u4E00-\u9FA5A-Za-z0-9]{1,25}$/;//现居地址,1~25位的数字、字母或汉字；
var legal = /^[\u4E00-\u9FA5A-Za-z]{2,20}$/;//法人代表
var businessNum = /^[0-9]{15}$/;//营业执照号，15位数字
var logPass = /^((?![a-zA-Z]+$)||(?![a-z0-9]+$))[a-zA-Z0-9]{6,16}$/; //登录密码，密码由字母、数字、下划线至少两种组成，且以字母开头，长度为6~16位
var newPass = /^((?![a-zA-Z]+$)||(?![a-z0-9]+$))[a-zA-Z0-9]{6,16}$/; //新密码，密码由字母、数字、下划线至少两种组成，且以字母开头，长度为6~16位
//var zphone = /^(^13\d{9}$)|(^14)[5,7]\d{8}$|(^15[0,1,2,3,5,6,7,8,9]\d{8}$)|(^17)[6,7,8]\d{8}$|(^18\d{9}$)/; //最新手机号验证，目前手机验证支持中国大陆地区13*、14*、15*、17*、18*号段；不支持小灵通号码。
var zphone = /^1\d{10}$/; //手机号验证，只验证11位数字
var z6 = /^\d{6}$/; //手机验证码,6位数字
var idCard = /^\d{17}(\d|x|X){1}$/;//身份证号   18位基本身份证号验证，后台验证唯一
var nNum1 = /^[0-9]*[1-9][0-9]*$/;//1~无限大的整数
var z2_12 = /^[\u4E00-\u9FA5\uf900-\ufa2d]{2,12}$/;//真实姓名，2到12位中文字符组成
var z2_20 = /^[\u4E00-\u9FA5]{2,20}$/;//中文；2-20位
var z2_8 = /^[\u4E00-\u9FA5]{2,8}$/;//中文；2-20位
var ze4_30 = /^[0-9\u4E00-\u9FA5]{4,30}$/;//中文、英文；4-30位
var s1_400 = /^[0-9\u4E00-\u9FA5]{4,400}$/;
var zbank = /^[\u4E00-\u9FA5\uf900-\ufa2d]{4,50}$/;//开户支行
var zbankNum = /^\d{16,19}$/;//银行卡号,16-19位
var cartNumber =/^[\u4e00-\u9fa5]{1}[A-Z]{1}[A-Z_0-9]{5}$/;//车牌号：省（汉字）+市（A-Z）+组合（数字、字母）
var amcountM = /^[1-9]([0-9]{0,26})(\.[0-9]{1,2})?$/; //金额
var mail = /^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;//邮箱 
var QQ= /^\d{5,12}$/;  //QQ验证，可为空，5~12位数字
var roleName= /^[\u4E00-\u9FA5]{0,10}$/;  //角色名称，10字以下
var roleMark= /^[\u4E00-\u9FA5]{0,125}$/;  //角色描述 ，125字以下
//var orgcodefmt = /^([0-9A-Z]){8}-[0-9|X]$/;//组织机构代码格式
var logname = function(gets,obj,curform,datatype) {
				var name="chen";    //模拟已存在的用户名 
				console.log("chulai");
				if(!gets){
					return "用户名不可为空";
				}
				else if(!logName.test(gets)){  
				    return "请输入1~10位中文、英文或数字的任意组合";
				}
				else{
					return true;
				}
		};
var regpass = function(gets,obj,curform,datatype) {
				var pwd="123456";   //模拟用户密码
				if(!gets){
					return "密码不可为空";
					}
				else if(!logPass.test(gets)){  
				    return "请输入6~16位除特殊字符外的任意字符组合";  
					}
					else{
						return true;
					}
			};
var imgcode = function(gets,obj,curform,datatype) {
				var code="82sd4d";   //模拟图形验证码 
				if(!gets){
					return "验证码不可为空";
				}
				else if(gets!=code){  
				    return "随机验证码不匹配";  
				}
				else {
					return true;
				}
	//			时间验证
				/*else if(){
					alert("随机验证码失效，请重新获取");
				}*/
			};
var zPhone = function (gets,obj,curform,datatype) {
				//var phone = '12345678901';
				if(!gets){
					return "手机号不可为空";
				}
				else if(!zphone.test(gets)){  
				    return "请输入正确的手机号";  
				}
				/*else if(gets!=phone){  
				    return "该手机号不存在";  
				}*/
				else {
					return true;
				}
		};
var Z6 = function (gets,obj,curform,datatype) {
				var z = '123456';
				if(!gets){
					return "验证码不可为空";
				}
				else if(!z6.test(gets)){  
				    return "验证码格式错误";  
					}
				else if(gets!=z){  
				    return "验证码输入错误";  
				}
				else {
					return true;
				}
		};			
var newpass = function (gets,obj,curform,datatype) {
				if(!gets){
					return "新密码不可为空";
				}
				else if(!newPass.test(gets)){  
				    return "请输入6~16位除特殊字符外的任意字符组合";  
				}
				else {
					return true;
				}
		};		
var repass = function(gets,obj,curform,datatype) {
				var passValue = $("input[title='newpass']").val();
				if(!gets){
					return "密码不可为空";
				}
				else if(newpass && gets != passValue) {
					return "2次输入密码不一致";
				}else {
					return true;
				}
			};
var checkMemberPhone = function(gets,obj,curform,datatype) {//异步验证用户手机是否存在
						var sResult = false;
						$.ajax({
							url : "checkMemberPhone.action",
							type : "post",
							dataType : "text",
							data : {"param" : gets},//检验参数（通用）
							async:false,//默认true，异步；false，同步
							contentType:"application/x-www-form-urlencoded; charset=UTF-8",
							beforeSend :function(xmlHttp){
						 		xmlHttp.setRequestHeader("If-Modified-Since","0");
								xmlHttp.setRequestHeader("Cache-Control","no-cache");
							},
							error:function(){  
								alert("请求失败，请稍后再试");
							},
							success:function(data){
								if(data != null && data != "") {
									if(data == 0) {//
										sResult = true;
									}else if(data == 1) {//
										sResult = "手机号已存在";
									}
								}
							}
						});
						return sResult;
					};
var entername = function(gets,obj,curform,datatype) {
			if(!gets){
				return "部门不可为空";
			}
			else if(!enterNameReg.test(gets)) {
				return "请输入1~12位中文、数字或字母组合";
			}else {
				return true;
			}
		};
		
var enterperson = function(gets,obj,curform,datatype) {
	if(!gets){
		return "部门负责人不可为空";
	}
	else if(!enterPerson.test(gets)) {
		return "请输入2~8位中文";
	}else {
		return true;
	}
};
var reMarks = function(gets,obj,curform,datatype) {
	if(!remarks.test(gets)) {
		return "请输入50字以内除特殊字符以外的任意字符";
	}else {
		return true;
	}
};
var checkCmpName = function(gets,obj,curform,datatype) {//异步校验部门名称
						var sResult = false;
						$.ajax({
							url : "checkCmpName.action",
							type : "post",
							dataType : "text",
							data : {"param" : gets},//检验参数（通用）
							async:false,//默认true，异步；false，同步
							contentType:"application/x-www-form-urlencoded; charset=UTF-8",
							beforeSend :function(xmlHttp){
						 		xmlHttp.setRequestHeader("If-Modified-Since","0");
								xmlHttp.setRequestHeader("Cache-Control","no-cache");
							},
							error:function(){  
								alert("服务器异常");
							},
							success:function(data){
								if(data != null && data != "") {
									if(data == 0) {//
										sResult = true;
									}else if(data == 1) {//
										sResult = "部门名称已存在" ;
									}
								}
							}
						});
						return sResult;
					};
var checkJobName = function(gets,obj,curform,datatype) {//异步校验职务名称
						var sResult = false;
						$.ajax({
							url : "checkJobName.action",
							type : "post",
							dataType : "text",
							data : {"param" : gets},//检验参数（通用）
							async:false,//默认true，异步；false，同步
							contentType:"application/x-www-form-urlencoded; charset=UTF-8",
							beforeSend :function(xmlHttp){
						 		xmlHttp.setRequestHeader("If-Modified-Since","0");
								xmlHttp.setRequestHeader("Cache-Control","no-cache");
							},
							error:function(){  
								alert("服务器异常");
							},
							success:function(data){
								if(data != null && data != "") {
									if(data == 0) {//
										sResult = true;
									}else if(data == 1) {//
										sResult = "职务名称已存在" ;
									}
								}
							}
						});
						return sResult;
					};
var idcard = function(gets,obj,curform,datatype){
		if(!gets){
			return "身份证号不能为空" ;
		}else if (!idCard.test(gets)){
			return "请输入正确的身份证号" ;
		}else{
			return true;
		}
};
var checkIdcard = function(gets,obj,curform,datatype) {//异步校验身份证号是否存在
						var sResult = false;
						$.ajax({
							url : "checkIdcard.action",
							type : "post",
							dataType : "text",
							data : {"param" : gets},//检验参数（通用）
							async:false,//默认true，异步；false，同步
							contentType:"application/x-www-form-urlencoded; charset=UTF-8",
							beforeSend :function(xmlHttp){
						 		xmlHttp.setRequestHeader("If-Modified-Since","0");
								xmlHttp.setRequestHeader("Cache-Control","no-cache");
							},
							error:function(){  
								alert("服务器异常");
							},
							success:function(data){
								if(data != null && data != "") {
									if(data == 0) {//
										sResult = true;
									}else if(data == 1) {//
										sResult = "身份证号已经存在" ;
									}
								}
							}
						});
						return sResult;
					};
var email = function(gets,obj,curform,datatype) {
				if(!gets){
					return true;
				}
			 	else if(!mail.test(gets)) {
					return "输入的邮箱格式不正确";
				}else {
					return true;
				}
			};
var checkEmail = function(gets,obj,curform,datatype) {//异步验证会员邮箱是否存在
						var sResult = false;
						$.ajax({
							url : "checkEmail.action",
							type : "post",
							dataType : "text",
							data : {"param" : gets},//检验参数（通用）
							async:false,//默认true，异步；false，同步
							contentType:"application/x-www-form-urlencoded; charset=UTF-8",
							beforeSend :function(xmlHttp){
						 		xmlHttp.setRequestHeader("If-Modified-Since","0");
								xmlHttp.setRequestHeader("Cache-Control","no-cache");
							},
							error:function(){  
								alert("请求失败，请稍后再试");
							},
							success:function(data){
								if(data != null && data != "") {
									if(data == 0) {//
										sResult = true;
									}else if(data == 1) {//
										sResult = "邮箱已存在";
									}
								}
							}
						});
						return sResult;
					};
var enteraddr = function(gets,obj,curform,datatype) {
				if(!gets){
					return "地址不可为空";
				}
			 	else if(!enterAddress.test(gets)) {
					return "请输入1~25位中文、字母、数字";
				}else {
					return true;
				}
			};
var rolename = function(gets,obj,curform,datatype) {
	if(!roleName.test(gets)) {
		return "10字以下";
	}else {
		return true;
	}
};
var rolemark = function(gets,obj,curform,datatype) {
	if(!roleMark.test(gets)) {
		return "125字以内";
	}else {
		return true;
	}
};

/**======================2015122添加输入验证end========================**/						
				
/**
 * validform校验公用方法
 * @param {提交按钮} btn
 * @param {表单id} formId
 * @param {防止重复提交} postonce 	true、false
 * @param {提示信息类型} tipsType	1:2:3： 自定义固定位置fixedTips
 * @param {附加函数} fun			null、""、undefined、函数名（例如：test()）
 * 表单验证{p1:提交按钮、p2:表单id、p3:防止重复提交、p4:提示信息类型、p5:附加函数}
 * 调用： validform5(btn,formId,postonce,tipsType,fun);
 */
function validform5(btn,formId,postonce,tipsType) {
	console.log(btn);
	$("#"+formId).Validform({
		btnSubmit:btn,//提交按钮
		tiptype:tipsType,//提示信息类型
		postonce:postonce,//防止重复提交
		datatype:{
			"logname":logname,
			"regpass":regpass,
			"imgcode":imgcode,
			"zPhone":zPhone,
			"Z6":Z6 ,
			"newpass" : newpass,
			"repass" : repass,
			"checkMemberPhone" : checkMemberPhone,
			"entername" : entername ,
			"enterperson" : enterperson ,
			"reMarks" : reMarks,
			"checkCmpName" : checkCmpName,
			"job" : entername,
			"jobdiscribe" : reMarks ,
			"checkJobName" : checkJobName ,
			"userName" : enterperson ,
			"idcard" : idcard ,
			"checkIdcard" : checkIdcard,
			"email" : email,
			"checkEmail" : checkEmail,
			"qq" : QQ,
			"enteraddr" : enteraddr,
			"rolename" : rolename,
			"rolemark" : rolemark,
			"z2_8":z2_8,
			"enterAddress":enterAddress
		},
		beforeSubmit:function(curform){//提交借款申请时添加家庭成员和家庭成员信息拼接
				        //在验证成功后，表单提交前执行的函数，curform参数是当前表单对象。  
				        //这里明确return false的话表单将不会提交;
						/*if(fun != undefined && fun != null && fun != "") {
							//var isContinue = eval(fun);//执行附加函数,返回值true or false
							return eval(fun);
						}*/
						if(!(logname&&regpass)){
							return "用户名或密码错误";
						}
					/*	else if(){
							return "服务器连接异常";
						}
						else if(){
							return "页面已经失效（30分钟）";
						}
						else if(){
							return "随机验证码失效，请重新输入";
						}
						else{
							return "登录成功（跳转到后台首页）";
						}*/
						
				    }
	});
}
