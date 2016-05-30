/**
 * @description validform公用校验方法
 * @author chenzhen
 * @version v1.0
 */
//全站规则

//正则集合
var RE = {
	isSpecial:		/[`~!@#\$%\^&\*\(\)_\+<>\?:\"{},\.\/;'\[\\]]$/,//特殊字符
	notSpecial:		/^[`~!@#\$%\^&\*\(\)_\+<>\?:\"{},\.\/;'\[\\]]$/,//不含特殊字符
	//logName:		/^([\u4e00-\u9fa5]||[a-zA-Z0-9]){6,16}$/,//登录名(用户名)，6~16位的数字、字母或汉字
	logName:		/^([\u4e00-\u9fa5]||[a-zA-Z0-9]){1,10}$/,//后台登录名(用户名)，6~16位的数字、字母或汉字；
	//logName:		/^(?![0-9]+$)(?![a-zA-Z]+$)(?![\u4E00-\u9FA5]+$)[0-9A-Za-z\u4E00-\u9FA5]{6,16}$/,//登录名(用户名)，6~16位的数字、字母或汉字
	enterNameReg:	/^[\u4E00-\u9FA5A-Za-z0-9]{1,12}$/,//部门名称,1~12位的数字、字母或中文
	enterPerson:	/^[\u4E00-\u9FA5]{2,8}$/,//部门负责人,2~8位中文
	remarks:		/^((?![a-zA-Z]+$)||(?![a-z0-9]+$))[\u4E00-\u9FA5a-zA-Z0-9]{0,50}$/,//备注50位以内任意字符，不可为特殊字符
	enterAddress:	/^[\u4E00-\u9FA5A-Za-z0-9]{1,25}$/,//现居地址,1~25位的数字、字母或汉字；
	legal:			/^[\u4E00-\u9FA5A-Za-z]{2,20}$/,//法人代表
	businessNum:	/^[0-9]{15}$/,//营业执照号，15位数字
	//proPass:        /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$/,//前台登录密码由6-16位的数字和字母组成
	///^((?![a-zA-Z]+$)||(?![a-z0-9]+$))[a-zA-Z0-9]{6,16}$/, //登录密码，密码由字母、数字、下划线至少两种组成，且以字母开头，长度为6~16位
	logPass:		/^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$/, //登录密码，密码由字母、数字、下划线至少两种组成，且以字母开头，长度为6~16位
	newPass:		/^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$/, //新密码，密码由字母、数字、下划线至少两种组成，且以字母开头，长度为6~16位
	//zphone:			/^(^13\d{9}$)|(^14)[5,7]\d{8}$|(^15[0,1,2,3,5,6,7,8,9]\d{8}$)|(^17)[6,7,8]\d{8}$|(^18\d{9}$)/, //最新手机号验证，目前手机验证支持中国大陆地区13*、14*、15*、17*、18*号段；不支持小灵通号码。
	zphone:			/^1\d{10}$/, //手机号验证，只验证11位数字
	tellPhone:		/^(0[0-9]{2,3}\-)?([2-9][0-9]{6,7})+(\-[0-9]{1,4})?$|(^(13[0-9]|15[0|3|6|7|8|9]|18[8|9])\d{8}$)/,//电话
	z6: 			/^\d{6}$/, //手机验证码,6位数字
	idCard: 		/^\d{17}(\d|x|X){1}$/,//身份证号   18位基本身份证号验证,基本格式
	nNum1:			/^[0-9]*[1-9][0-9]*$/,//1~无限大的整数
	z2_8:			/^[\u4E00-\u9FA5]{2,8}$/,//中文；2-8位
	z2_12:			/^[\u4E00-\u9FA5\uf900-\ufa2d]{2,12}$/,//真实姓名，2到12位中文字符组成
	z2_20:			/^[\u4E00-\u9FA5]{2,20}$/,//中文2-20位
	ze4_30: 		/^[0-9\u4E00-\u9FA5]{4,30}$/,//中文、英文；4-30位
	s1_400:			/^[0-9\u4E00-\u9FA5]{4,400}$/,
	zbank:			/^[\u4E00-\u9FA5\uf900-\ufa2d]{4,50}$/,//开户支行
	zbankNum:		/^\d{16,19}$/,//银行卡号,16-19位
	cartNumber:		/^[\u4e00-\u9fa5]{1}[A-Z]{1}[A-Z_0-9]{5}$/,//车牌号：省（汉字）+市（A-Z）+组合（数字、字母）
	acountM:		/^[1-9]([0-9]{0,26})(\.[0-9]{1,4})?$/, //金额
	acountM0:		/^(([1-9]\d{0,9})|0)(\.\d{1,4})?$/, //金额
	mail:			/^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/,//邮箱//国际 //国内常用
	QQ:				/^\d{5,12}$/,  //QQ验证，可为空，5~12位数字
	roleName:		/^[\u4E00-\u9FA5]{0,10}$/,  //角色名称，1~10个中文
	agreementName:	/^[\u4E00-\u9FA5]{0,15}$/,  //0~15字
	roleMark:		/^[\u4E00-\u9FA5]{1,125}$/,//角色描述
	hundrednum:		/^(100|[1-9]?\d(\.[0-9]{1,4})?)$/,//百分数验证不包含%
	strRegex:		/^((https|http|ftp|rtsp|mms)?:\/\/)?(([0-9a-z_!~*'().&=+$%-]+: )?[0-9a-z_!~*'().&=+$%-]+@)?(([0-9]{1,3}\.){3}[0-9]{1,3}|([0-9a-z_!~*'()-]+\.)*([0-9a-z][0-9a-z-]{0,61})?[0-9a-z]\.[a-z]{2,6})(:[0-9]{1,4})?((\/?)|(\/[0-9a-z_!~*'().;?:@&=+$,%#-]+)+\/?)$/,
	unnormal:		/^[^ &',;=?$\\]+$/,//特定排除
	orgcodefmt:		/^([0-9A-Z]){8}-[0-9|X]$/,//组织机构代码格式
	dayRex:			/^[1-9][0-9]{0,2}$/,//天数：大于0的整数，最大3位数字
	port:			/^([1-9]|[1-9]\\d{1,3}|[1-6][0-5][0-5][0-3][0-5])$/,//端口：大于0的整数，最大6位数字
	server:			/^[^ &',;=?$\\]+$/,//SMTP服务器
	nnum0:			/^[0-9]*[0-9][0-9]*$/,//0~无限大的整数    [1-9]{1}\d{0,4}
	nnum1:			/^[0-9]*[1-9][0-9]*$/,//1~无限大的整数
	describe:		/^[\u4E00-\u9FA5]{0,200}$/,  //项目描述 ，200字以下
	describeC:		/^[\u4E00-\u9FA5]{0,125}$/,  //项目描述 ，125字以下
	roleNameA:		/^[\u4E00-\u9FA5]{0,6}$/,  //角色名称，6字以下
	enterNR:		/^[\u4E00-\u9FA5A-Za-z0-9]{1,16}$/,//项目名称,1~16位的数字、字母或中文；
	roleNameB:		/^[\u4E00-\u9FA5]{0,30}$/,  //附加标题，30字以下
	numberOf:		/^[0-9]{0,200}$/,//项目名称,200位的数字以下；
	
	imgCode:		/^-?[0-9]*$/,	//图形验证码，非负整数
	weixinCode:		/^[a-zA-Z\d_-]{5,19}$///目前微信号不支持设置为中文帐号，是以字母开头的帐号（可以使用6—20个字母、数字、下划线和减号，必须以字母开头。）
};

//错误提示信息，公用部分，特殊提示特殊处理
var ErrorTips = {
	nullmsg:"请输入内容！"
};


//验证判断带返回信息
//==============================================Demo Start===============================================
/**
 * 基本验证判断demo
 * @param {ValueString} gets	当前验证值		1000
 * @param {Object} obj			当前验证对象	input || 
 * @param {Object} curform		当前验证盒子/表单
 * @param {String || Function} datatype		提示信息类型	1||2||3||4||5||function 本项目全局使用5，特情况特殊处理
 */
var demo1 = function(gets, obj, curform, datatype) {
	//判断要返回	true：正确	false：错误	"错误信息":错误信息
	
	//可选取其他元素值
	
	if (!gets) {
		return "内容不可为空";
	}
	if (!RE.logName.test(gets)) {
		return "6~16位的数字、字母或汉字";
	}
	
	//验证通过返回true
	return true;
};


/**
 * 查询验证判断
 * @param {ValueString} gets	当前验证值		1000
 * @param {Object} obj			当前验证对象	input || 
 * @param {Object} curform		当前验证盒子/表单
 * @param {String || Function} datatype		提示信息类型	1||2||3||4||5||function 本项目全局使用5，特情况特殊处理
 * 此方法，需使用同步
 * 若需异步，直接在输入框上加URL，方法另见
 */
var demo2 = function(gets,obj,curform,datatype) {
	var sResult = false;
	$.ajax({
		url: "checkMemberEmailBind.action",//查询
		type: "post",
		dataType: "text",//
		data: {
			"param": gets
		}, //检验参数（通用）
		async: false, //默认true，异步；false，同步
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		beforeSend: function(xmlHttp) {
			xmlHttp.setRequestHeader("If-Modified-Since", "0");
			xmlHttp.setRequestHeader("Cache-Control", "no-cache");
		},
		error: function() {
			//提示信息
			alert("服务器忙，请稍后再试");
		},
		success: function(data) {
			if (data != null && data != "") {
				if (data == 0) {
					sResult = true;
				} else if (data == 1) {
					sResult = "邮箱已存在";
				}
			}
		}
	});
	return sResult;
};
//==============================================Demo End===============================================

//==============================================Case===============================================
var orgcode = function(gets, obj, curform, datatype) { //组织机构代码
	var ws = [3, 7, 9, 10, 5, 8, 4, 2];
	var str = '0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ';
	//var reg = /^([0-9A-Z]){8}-[0-9|X]$/;
	if (!RE.orgcodefmt.test(gets)) {
		return "组织机构代码格式：L1832212-3";
	}

	var sum = 0;
	for (var i = 0; i < 8; i++) {
		sum += str.indexOf(gets.charAt(i)) * ws[i];
	}
	var c9 = 11 - (sum % 11);
	if (c9 == 10) {
		c9 = 'X';
	} else if (c9 == 11) {
		c9 = '0';
	}

	if (c9 != gets.charAt(9)) {
		return "组织机构代码错误";
	}
};

var IDCard = function(gets, obj, curform, datatype) {//身份证
	var Wi = [7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2, 1]; // 加权因子;
	var ValideCode = [1, 0, 10, 9, 8, 7, 6, 5, 4, 3, 2]; // 身份证验证位值，10代表X;

	if (gets.length == 15) {
		return isValidityBrithBy15IdCard(gets);
	} else if (gets.length == 18) {
		var a_idCard = gets.split(""); // 得到身份证数组   
		if (isValidityBrithBy18IdCard(gets) && isTrueValidateCodeBy18IdCard(a_idCard)) {
			return true;
		}
		return false;
	}
	return false;

	function isTrueValidateCodeBy18IdCard(a_idCard) {
		var sum = 0; // 声明加权求和变量   
		if (a_idCard[17].toLowerCase() == 'x') {
			a_idCard[17] = 10; // 将最后位为x的验证码替换为10方便后续操作   
		}
		for (var i = 0; i < 17; i++) {
			sum += Wi[i] * a_idCard[i]; // 加权求和   
		}
		valCodePosition = sum % 11; // 得到验证码所位置   
		if (a_idCard[17] == ValideCode[valCodePosition]) {
			return true;
		}
		return false;
	}

	function isValidityBrithBy18IdCard(idCard18) {
		var year = idCard18.substring(6, 10);
		var month = idCard18.substring(10, 12);
		var day = idCard18.substring(12, 14);
		var temp_date = new Date(year, parseFloat(month) - 1, parseFloat(day));
		// 这里用getFullYear()获取年份，避免千年虫问题   
		if (temp_date.getFullYear() != parseFloat(year) || temp_date.getMonth() != parseFloat(month) - 1 || temp_date.getDate() != parseFloat(day)) {
			return false;
		}
		return true;
	}

	function isValidityBrithBy15IdCard(idCard15) {
		var year = idCard15.substring(6, 8);
		var month = idCard15.substring(8, 10);
		var day = idCard15.substring(10, 12);
		var temp_date = new Date(year, parseFloat(month) - 1, parseFloat(day));
		// 对于老身份证中的你年龄则不需考虑千年虫问题而使用getYear()方法   
		if (temp_date.getYear() != parseFloat(year) || temp_date.getMonth() != parseFloat(month) - 1 || temp_date.getDate() != parseFloat(day)) {
			return false;
		}
		return true;
	}
};


var logname = function(gets,obj,curform,datatype) {
				if(!gets){
					return "用户名不可为空";
				}
				if(!RE.logName.test(gets)){  
				    return "请输入1~10位中文、英文或数字的任意组合";
				}
				return true;
		};
		
var regpass = function(gets,obj,curform,datatype) {
				if(!gets){
					return "密码不可为空";
				}
				if(!RE.logPass.test(gets)){  
			    	return "请输入6~16位除特殊字符外的任意字符组合";  
				}
				return true;
			};
var imgcode = function(gets,obj,curform,datatype) {
				if(!gets){
					return "验证码不可为空";
				}
				if(!RE.imgCode.test(gets)){  
				    return "图形验证码错误，请重新输入";
				}
				return true;
			};
var img = function(gets,obj,curform,datatype) {
				var code="";
				if(!gets){
					return "图片不能为空";
				}
				if(gets!=code){  
				    return "请上传图片";  
				}
				return true;
};
var zPhone = function (gets,obj,curform,datatype) {
				if(!gets){
					return "手机号不可为空";
				}
				if(!RE.zphone.test(gets)){  
				    return "请输入正确的手机号";  
				}
				return true;
		};
var nNum0 = function (gets,obj,curform,datatype) {	
		if(!gets){
			return "请输入信息";
		}
		if(!RE.nnum0.test(gets)){  
		    return "请输入正确的范围";  
		}
		return true;
};

var nNum1 = function (gets,obj,curform,datatype) {	
	if(!gets){
		return "请输入信息";
	}
	if(!RE.nnum1.test(gets)){
	    return "请输入大于0的整数";  
	}
	return true;
};

var Z6 = function (gets,obj,curform,datatype) {
				if(!gets){
					return "验证码不可为空";
				}
				if(!RE.z6.test(gets)){  
			    	return "验证码不正确或已过期";  
				}
				return true;
		};
var newpass = function (gets,obj,curform,datatype) {
				if(!gets){
					return "新密码不可为空";
				}
				if(!RE.logPass.test(gets)){
				    return "请输入6~16位除特殊字符外的任意字符组合";  
				}
				return true;
		};
var repass = function(gets,obj,curform,datatype) {
				var passValue = $("input[title='newpass']").val();
				if(!gets){
					return "密码不可为空";
				}
				if(newpass && gets != passValue) {
					return "两次输入不一致";
				}
				return true;
			};
			
var enterNameR = function(gets,obj,curform,datatype) {
			if(!gets){
				return "部门不可为空";
			}
			if(!RE.enterNR.test(gets)) {
				return "请输入1~16位中文、数字或字母组合";
			}
			return true;
		};
		
var entername = function(gets,obj,curform,datatype) {
			if(!gets){
				return "部门不可为空";
			}
			if(!RE.enterNameReg.test(gets)) {
				return "请输入1~12位中文、数字或字母组合";
			}
			return true;
		};
		
		
var enterperson = function(gets,obj,curform,datatype) {
	if(!gets){
		return "部门负责人不可为空";
	}
	if(!RE.enterPerson.test(gets)) {
		return "请输入2~8位中文";
	}
	return true;
};
					
		
var reMarks = function(gets,obj,curform,datatype) {
	if(!gets){
		return "请输入内容";
	}
	if(!RE.remarks.test(gets)) {
		return "请输入50字以内除特殊字符以外的任意字符";
	}
	return true;
};


var email = function(gets,obj,curform,datatype) {
				if(!gets){
					return "请输入内容";
				}
			 	if(!RE.mail.test(gets)) {
					return "邮箱格式不正确";
				}
				return true;
			};

var enterAddress = function(gets,obj,curform,datatype) {
				if(!gets){
					return "请输入信息";
				}
			 	if(!RE.enterAddress.test(gets)) {
					return "请输入1~25位中文、字母、数字";
				}
				return true;
			};
var rolename = function(gets,obj,curform,datatype) {
	if(!gets){
		return "角色名称不能为空";
	}
	if(!RE.roleName.test(gets)) {
		return "1~10个中文";
	}
	return true;
};
var roleNameb = function(gets,obj,curform,datatype) {
	if(!gets){
		return "请输入信息";
	}
	if(!RE.roleNameB.test(gets)) {
		return "30字以下";
	}
	return true;
};
var rolemarkC = function(gets,obj,curform,datatype) {
	if(!gets){
		return "角色描述不能为空";
	}
	if(!RE.roleMark.test(gets)) {
		return "输入范围1-125个中文";
	}
	return true;
};

var time = function(gets,obj,curform,datatype) {
	if(!gets){
		return "请输入信息";
	}
	return true;
};

var unNormal = function(gets,obj,curform,datatype) {
	if(!gets){
		return "请输入名称";
	}
	if(!RE.unnormal.test(gets)) {
		return "格式不正确";
	}
	return true;
};

var hundredNum = function(gets,obj,curform,datatype) {
	if(!gets){
		return "请输入信息";
	}
	if(!RE.hundrednum.test(gets)) {
		return "0.0000~100.0000之间";
	}
	return true;
};

var qq = function(gets,obj,curform,datatype) {
	if(!gets){
		return "请输入信息";
	}
	if(!RE.QQ.test(gets)) {
		return "格式不正确";
	}
	return true;
};

var acountM = function(gets,obj,curform,datatype) {
	if(!gets){
		return "请输入信息";
	}
	if(!RE.acountM.test(gets)) {
		return "金额格式不正确";
	}
	return true;
};
var acountM0 = function(gets,obj,curform,datatype) {
	if(!gets){
		return "请输入信息";
	}
	if(!RE.acountM0.test(gets)) {
		return "金额格式不正确";
	}
	return true;
};
var tell = function(gets,obj,curform,datatype) {
	if(!gets){
		return "请输入信息";
	}
	if(!RE.tellPhone.test(gets)) {
		return "例如：021-40000000";
	}
	return true;
};

var bankNum = function(gets,obj,curform,datatype) {
	if(!gets){
		return "请输入信息";
	}
	if(!RE.zbankNum.test(gets)) {
		return "银行卡号不正确";
	}
	return true;
};

var days = function(gets,obj,curform,datatype){
	if(!gets){
		return "请输入信息";
	}
	if(!RE.dayRex.test(gets)){
	    return "请输入3位数内的正整数";
	}
		return true;
};
var describe = function(gets,obj,curform,datatype){
	if(!gets){
		return "请输入信息";
	}
	if(!RE.describe.test(gets)){
		return "请输入200字以下内容";
	}
	return true;
};

var describeC = function(gets,obj,curform,datatype) {
	if(!gets){
		return "请输入信息";
	}
	if(!RE.describeC.test(gets)) {
		return "请输入125字以下内容";
	}
	return true;
};

var proTypeName = function(gets,obj,curform,datatype){
	if(!gets){
		return "请输入信息";
	}
	if(!RE.roleNameA.test(gets)){
		return "请输入6字以内的中文";
	}
	return true;
};
var realName = function(gets,obj,curform,datatype){
	if(!gets){
		return "请输入信息";
	}
	if(!RE.z2_12.test(gets)){
		return "请输入2-12字以内的中文";
	}
	return true;
};

var z2_20 = function(gets,obj,curform,datatype){
	if(!gets){
		return "请输入信息";
	}
	if(!RE.z2_20.test(gets)){
		return "请输入2-20字以内的中文";
	}
	return true;
};

var businessNum = function(gets,obj,curform,datatype){
	if(!gets){
		return "请输入信息";
	}
	if(!RE.businessNum.test(gets)){
		return "请输入15位的正确营业执照号";
	}
	return true;
};

var strRegex = function(gets,obj,curform,datatype){
	if(!gets){
		return "请输入信息";
	}
	if(!RE.strRegex.test(gets)){
		return "请输入正确的链接";
	}
	return true;
};

var weixinCode = function(gets,obj,curform,datatype){
	if(!gets){
		return "请输入信息";
	}
	if(!RE.weixinCode.test(gets)){
		return "请输入正确的微信号";
	}
	return true;
};

var commonInByteCheck = function(gets,obj,curform,datatype){//公共输入字节校验 使用时验证对象添加maxByte="";  minByte="";(选)
							var maxNum = $(obj).attr("maxByte");//最大字节数
							var minNum = $(obj).attr("minByte");//最小字节数
							var len = getLength($(obj).val());//所有字符长度
							var r = parseInt(maxNum)-parseInt(len);//剩余可输入长度
							if(minNum != undefined) {//最小限制，根据所需
								if(len < minNum) {
									return "输入内容不能少于"+minNum+"字节";
								}
							}
							if(r < 0) {
								return "输入内容不能超过"+maxNum+"字节";
							}
							
							function getLength(str) {
							    var len = str.length;  
							    var reLen = 0;  
							    for (var i = 0; i < len; i++) {
							        if (str.charCodeAt(i) < 27 || str.charCodeAt(i) > 126) {//限制内容范围  
							            // 全角
							            reLen += 2;
							        } else {
							            reLen++;
							        }
							    }  
							    return reLen;
							}	
						};

var commonInLengthCheck = function(gets,obj,curform,datatype){//公共输入长度校验
							var maxNum = $(obj).attr("maxNum");//最大字数
							var minNum = $(obj).attr("minNum");//最小字数
							var len = $(obj).val().length;//所有字长度
							var r = parseInt(maxNum)-parseInt(len);//剩余可输入长度
							if(minNum != undefined) {//最小限制，根据所需
								if(len < minNum) {
									return "输入内容不能少于"+minNum+"字";
								}
							}
							if(r < 0) {
								return "输入内容不能超过"+maxNum+"字";
							}
							
						};

/**
 * 扩展验证规则	在这里添加验证类型
 */
var extdatatype = {
	"orgcode":orgcode,
	"IDCard":IDCard,
	"logname":logname,
	"regpass":regpass,
	"imgcode":imgcode,
	"img":img,
	"zPhone":zPhone,
	"nNum0":nNum0,
	"nNum1":nNum1,
	"Z6":Z6 ,
	"newpass":newpass,
	"repass":repass,
	"enterNameR":enterNameR,
	"entername" : entername,
	"enterperson" : enterperson,
	"reMarks":reMarks,
	"email":email,
	"enteraddr":enterAddress,
	"enterAddress":enterAddress,
	"rolename":rolename,
	"roleNameb":roleNameb,
	"rolemarkC":rolemarkC,
	"time":time,
	"unNormal":unNormal,
	"hundredNum":hundredNum,
	"qq":qq,
	"acountM":acountM,
	"tell":tell,
	"bankNum":bankNum,
	"days":days,
	"describe":describe,

	"strRegex":strRegex,
	"z2_8":RE.z2_8,
	"realName":realName,
	"proTypeName":proTypeName,
	"businessNum":businessNum,
	"z2_20":z2_20,
	"describeC":describeC,
	"weixinCode":weixinCode,
	"commonInByteCheck":commonInByteCheck,
	"commonInLengthCheck":commonInLengthCheck,
	
	"server":RE.server,
	"port":RE.port,
	"notSpecial":RE.notSpecial,
	"acountM0":acountM0

};


//==============================================Case===============================================

					
				
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
	postonce = postonce || false;
	$("#"+formId).Validform({
		btnSubmit:btn,//提交按钮
		tiptype:tipsType,//提示信息类型
		postonce:postonce,//防止重复提交
		datatype:{
			"orgcode":orgcode,
			"IDCard":IDCard,
			"logname":logname,
			"regpass":regpass,
			"imgcode":imgcode,
			"img":img,
			"zPhone":zPhone,
			"nNum0":nNum0,
			"nNum1":nNum1,
			"Z6":Z6 ,
			"newpass":newpass,
			"repass":repass,
			"enterNameR":enterNameR,
			"entername" : entername,
			"enterperson" : enterperson,
			"reMarks":reMarks,
			"email":email,
			"enteraddr":enterAddress,
			"enterAddress":enterAddress,
			"rolename":rolename,
			"roleNameb":roleNameb,
			"rolemarkC":rolemarkC,
			"time":time,
			"unNormal":unNormal,
			"hundredNum":hundredNum,
			"qq":qq,
			"acountM":acountM,
			"tell":tell,
			"bankNum":bankNum,
			"days":days,
			"describe":describe,
			
			"strRegex":strRegex,
			"realName":realName,
			"z2_8":RE.z2_8,
			"proTypeName":proTypeName,
			"businessNum":businessNum,
			"z2_20":z2_20,
			"describeC":describeC,
			"weixinCode":weixinCode,
			"commonInByteCheck":commonInByteCheck,
			"commonInLengthCheck":commonInLengthCheck,
			
			"server":RE.server,
			"port":RE.port,
			"notSpecial":RE.notSpecial,
			"acountM0":acountM0
		},
		beforeSubmit:function(curform){
				        //在验证成功后，表单提交前执行的函数，curform参数是当前表单对象。  
				        //这里明确return false的话表单将不会提交;
						
				    }
	});
}