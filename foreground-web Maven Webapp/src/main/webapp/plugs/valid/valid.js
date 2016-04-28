/**
 * @description validform公用校验方法
 * @author chenzhen
 * @version v1.0
 */
//全站规则

//正则集合
var RE = {
	isSpecial:		/[`~!@#\$%\^&\*\(\)_\+<>\?:\"{},\.\/;'\[\\]]$/,//特殊字符
	notSpecial:		/^[`~!@#\$%\^&\*\(\)_\+<>\?:\"{},\.\/;'\[\\]]$/,//特殊字符
/*	logName:		/^([\u4e00-\u9fa5]||[a-zA-Z0-9]){6,16}$/,//登录名(用户名)，6~16位的数字、字母或汉字*/
	logName:		/^(?![0-9]+$)(?![a-zA-Z]+$)(?![\u4E00-\u9FA5]+$)[0-9A-Za-z\u4E00-\u9FA5]{6,16}$/,//登录名(用户名)，6~16位的数字、字母或汉字
	enterNameReg:	/^[\u4E00-\u9FA5A-Za-z0-9]{1,12}$/,//部门名称,1~12位的数字、字母或中文
	enterPerson:	/^[\u4E00-\u9FA5]{2,8}$/,//部门负责人,2~8位中文
	remarks:		/^((?![a-zA-Z]+$)||(?![a-z0-9]+$))[\u4E00-\u9FA5a-zA-Z0-9]{0,50}$/,//备注50位以内任意字符，不可为特殊字符
	legal:			/^[\u4E00-\u9FA5A-Za-z]{2,20}$/,//法人代表
	businessNum:	/^[0-9]{15}$/,//营业执照号，15位数字
/*	logPass:		/^[a-zA-Z]\w{5,19}$/, //登录密码，密码由字母、数字、下划线至少两种组成，且以字母开头，长度为6~20位*/
	logPass:        /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$/,//登录密码由6-16位的数字和字母组成
	z6: 			/^\d{6}$/, //手机验证码,6位数字
	imgCode:		/^-?[0-9]*$/,//图形验证码，非负整数
	idCard: 		/^\d{17}(\d|x|X){1}$/,//身份证号   18位基本身份证号验证,基本格式
	nNum1:			/^[0-9]*[1-9][0-9]*$/,//1~无限大的整数
	z2_20:			/^[\u4E00-\u9FA5]{2,20}$/,//中文2-20位
	ze4_30: 		/^[0-9\u4E00-\u9FA5]{4,30}$/,
	zbank:			/^[\u4E00-\u9FA5\uf900-\ufa2d]{4,50}$/,//开户支行
	zbankNum:		/^\d{16,19}$/,//银行卡号,16-19位
	cartNumber:		/^[\u4e00-\u9fa5]{1}[A-Z]{1}[A-Z_0-9]{5}$/,//车牌号：省（汉字）+市（A-Z）+组合（数字、字母）
	amcountM:		/^[1-9]([0-9]{0,26})(\.[0-9]{1,2})?$/, //金额
	//zphone:			/^(^13\d{9}$)|(^14)[5,7]\d{8}$|(^15[0,1,2,3,5,6,7,8,9]\d{8}$)|(^17)[6,7,8]\d{8}$|(^18\d{9}$)/, //最新手机号验证，目前手机验证支持中国大陆地区13*、14*、15*、17*、18*号段；不支持小灵通号码。
	zphone:			/^1\d{10}$/, //手机号验证，只验证11位数字
	tellPhone:		/^(0[0-9]{2,3}\-)?([2-9][0-9]{6,7})+(\-[0-9]{1,4})?$|(^(13[0-9]|15[0|3|6|7|8|9]|18[8|9])\d{8}$)/,//电话
	mail:			/^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/,//邮箱//国际 //国内常用
	QQ:				/^\d{5,12}$/,  //QQ验证，可为空，5~12位数字
	orgcodefmt:		/^([0-9A-Z]){8}-[0-9|X]$/,//组织机构代码格式
	enterAddress:	/^[\u4E00-\u9FA5A-Za-z0-9]{1,25}$/,
	roleName:		/^[\u4E00-\u9FA5]{0,10}$/,  //角色名称，1~10个中文
	roleMark:		/^[\u4E00-\u9FA5]{1,125}$/,//角色描述
	unnormal:		/^[^ &',;=?$\\]+$/,//特定排除
	hundrednum:		/^(100|[1-9]?\d(\.\d\d?)?)$/,//百分数验证不包含%
	amcountM:		/^[1-9]([0-9]{0,26})(\.[0-9]{1,2})?$/, //金额
	inviteCode:		/^[0-9]{12}$/,//邀请码验证
	titleRemarks:	/^((?![a-zA-Z]+$)||(?![a-z0-9]+$))[\u4E00-\u9FA5a-zA-Z0-9]{0,40}$/,//0-40个字，不含特殊字符
	accountOpen:	/^[JLZ][0-9]{13}$/, //开户许可证编号：J基本户、L临时户、Z专用户；后面四位是地区代码;再后面7位是顺序号;最后2位表示第几个版本：这个要解释一下，比如你新开基本户，那么最后2位就是01；对这个基本户变更一次，换发了新许可证，那么就顺延成02
};

//正则参考
/*var isSpecial = /[`~!@#\$%\^&\*\(\)_\+<>\?:\"{},\.\/;'\[\\]]$/;//特殊字符
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
var tellPhone=/^(0[0-9]{2,3}\-)?([2-9][0-9]{6,7})+(\-[0-9]{1,4})?$|(^(13[0-9]|15[0|3|6|7|8|9]|18[8|9])\d{8}$)/;
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
var hundrednum = /^(100|[1-9]?\d(\.\d\d?)?)$/ ; //百分数验证不包含%
//url 路径
var strRegex = "^((https|http|ftp|rtsp|mms)?://)"
	 + "?(([0-9a-z_!~*'().&=+$%-]+: )?[0-9a-z_!~*'().&=+$%-]+@)?" // ftp的user@
	 + "(([0-9]{1,3}\.){3}[0-9]{1,3}" // IP形式的URL- 199.194.52.184
	 + "|" // 允许IP和DOMAIN（域名）
	 + "([0-9a-z_!~*'()-]+\.)*" // 域名- www.
	 + "([0-9a-z][0-9a-z-]{0,61})?[0-9a-z]\." // 二级域名
	 + "[a-z]{2,6})" // first level domain- .com or .museum
	 + "(:[0-9]{1,4})?" // 端口- :80
	 + "((/?)|" // a slash isn't required if there is no file name
	 + "(/[0-9a-z_!~*'().;?:@&=+$,%#-]+)+/?)$";

var unnormal = /^[^ &',;=?$\\]+$/;
//var orgcodefmt = /^([0-9A-Z]){8}-[0-9|X]$/;//组织机构代码格式
var days = /^[0-9]*[1-9][0-9]{1,3}$/;//天数：大于0的整数，最大3位数字*/


//错误提示信息，公用部分，特殊提示特殊处理
var ErrorTips = {
	nullmsg:"请输入内容！"
}


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
	var value = obj.attr("lang");
	if (!gets || gets == value) {
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
				var value = obj.attr("lang");
				if(!gets || gets == value){
					return "用户名不可为空";
				}
				if(!RE.logName.test(gets)){  
				    return "请输入6~16位的数字、字母或汉字的两两组合";
				}
				return true;
		};
var zbank = function(gets,obj,curform,datatype) {
			var value = obj.attr("lang");
			if(!gets || gets == value){
				return "支行名字不可为空";
			}
			if(!RE.zbank.test(gets)){  
				return "请输入正确的支行名字";
			}
			return true;
		};
var zbankNum = function(gets,obj,curform,datatype) {
			var value = obj.attr("lang");
			if(!gets || gets == value){
				return "银行卡号不可为空";
			}
			if(!RE.zbankNum.test(gets)){  
				return "请输入正确格式的银行卡号";
			}
			return true;
		};
var z2_20 = function(gets,obj,curform,datatype) {
			var value = obj.attr("lang");
			if(!gets || gets == value){
				return "姓名不能为空";
			}
			if(!RE.z2_20.test(gets)){  
				return "请输入您的姓名";
			}
			return true;
		};	
var regpass = function(gets,obj,curform,datatype) {
				var value = obj.attr("lang");
				if(!gets || gets == value){
					return "密码不可为空";
				}
				if(!RE.logPass.test(gets)){  
			    	return "请输入6~16位的数字和字母";  
				}
				return true;
			};
var imgcode = function(gets,obj,curform,datatype) {
				var value = obj.attr("lang");
				if(!gets || gets == value){
					return "验证码不可为空";
				}
				if(!RE.imgCode.test(gets)){  
				    return "图形验证码错误，请重新输入";  
				}
				return true;
			};
var zPhone = function (gets,obj,curform,datatype) {
				var value = obj.attr("lang");
				if(!gets || gets == value){
					return "手机号不可为空";
				}
				if(!RE.zphone.test(gets)){  
				    return "11位手机号";  
				}
				return true;
		};
var Z6 = function (gets,obj,curform,datatype) {
				var value = obj.attr("lang");
				if(!gets || gets == value){
					return "验证码不可为空";
				}
				if(!RE.z6.test(gets)){  
			    	return "验证码不正确或已过期";  
				}
				return true;
		};			
var newpass = function (gets,obj,curform,datatype) {
				var value = obj.attr("lang");
				if(!gets || gets == value){
					return "新密码不可为空";
				}
				if(!RE.logPass.test(gets)){  
				    return "请输入6~16位的数字和字母";  
				}
				return true;
		};
var enterperson = function(gets,obj,curform,datatype) {
	if(gets == $(obj).attr("lang") || !gets){
		return "必填项，不可为空";
	}
	if(!RE.enterPerson.test(gets)) {
		return "请输入2~8位中文";
	}
	return true;
};
					
var entername = function(gets,obj,curform,datatype) {
			var value = obj.attr("lang");
			if(!gets || gets == value){
				return "部门不可为空";
			}
			if(!RE.enterNameReg.test(gets)) {
				return "请输入1~12位中文、数字或字母组合";
			}
			return true;
		};
		
var reMarks = function(gets,obj,curform,datatype) {
	var value = obj.attr("lang");
	if(!gets || gets == value){
		return "请输入内容"
	}
	if(!RE.remarks.test(gets)) {
		return "请输入50字以内除特殊字符以外的任意字符";
	}
	return true;
};


var titleRemarks = function(gets,obj,curform,datatype) {
	var value = obj.attr("lang");
	if(!gets || gets == value){
		return "请输入内容"
	}
	if(!RE.titleRemarks.test(gets)) {
		return "请输入40字以内除特殊字符以外的任意字符";
	}
	return true;
};

var email = function(gets,obj,curform,datatype) {
				var value = obj.attr("lang");
				if(!gets || gets == value){
					return "请输入内容";
				}
			 	if(!RE.mail.test(gets)) {
					return "邮箱格式不正确";
				}
				return true;
			};

var enteraddr = function(gets,obj,curform,datatype) {
				var value = obj.attr("lang");
				if(!gets || gets == value){
					return "地址不可为空";
				}
			 	if(!RE.enterAddress.test(gets)) {
					return "请输入1~25位中文、字母、数字";
				}
				return true;
			};
var rolename = function(gets,obj,curform,datatype) {
	var value = obj.attr("lang");
	if(!gets || gets == value){
		return "角色名称不能为空"
	}
	if(!RE.roleName.test(gets)) {
		return "1~10个中文";
	}
	return true;
};
var rolemark = function(gets,obj,curform,datatype) {
	var value = obj.attr("lang");
	if(!gets || gets == value){
		return "角色描述不能为空";
	}
	if(!RE.roleMark.test(gets)) {
		return "输入范围1-125个中文";
	}
	return true;
};

var unNormal = function(gets,obj,curform,datatype) {
	var value = obj.attr("lang");
	if(!gets || gets == value){
		return "请输入名称";
	}
	if(!RE.unnormal.test(gets)) {
		return "格式不正确";
	}
	return true;
};

var hundredNum = function(gets,obj,curform,datatype) {
	var value = obj.attr("lang");
	if(!gets || gets == value){
		return "请输入信息";
	}
	if(!RE.hundrednum.test(gets)) {
		return "0.00~100.00之间";
	}
	return true;
};

var qq = function(gets,obj,curform,datatype) {
	var value = obj.attr("lang");
	if(!gets || gets == value){
		return "请输入信息";
	}
	if(!RE.QQ.test(gets)) {
		return "格式不正确";
	}
	return true;
};

var acountM = function(gets,obj,curform,datatype) {
	var value = obj.attr("lang");
	if(!gets || gets == value){
		return "请输入信息";
	}
	if(!RE.amcountM.test(gets)) {
		return "金额格式不正确";
	}
	return true;
};
var tell = function(gets,obj,curform,datatype) {
	var value = obj.attr("lang");
	if(!gets || gets == value){
		return "请输入信息";
	}
	if(!RE.tellPhone.test(gets)) {
		return "例如：021-40000000";
	}
	return true;
};
var inviteCode = function (gets,obj,curform,datatype) {
	var value = obj.attr("lang");
	if(gets != "" && gets != "请输入邀请码" && !RE.inviteCode.test(gets)){  
	    return "邀请码为12位数字或是不存在";  
	}
	return true;
};
/***法人代表伍成然***/
var legal = function (gets,obj,curform,datatype) {
	var value = obj.attr("lang");
	if(!gets || gets == value){
		return "请输入注册法人";
	}
	if(!RE.legal.test(gets)){  
	    return "格式不正确";  
	}
	return true;
};
/***开户许可证编号伍成然***/
var accountOpen = function (gets,obj,curform,datatype) {
	var value = obj.attr("lang");
	if(!gets || gets == value){
		return "请输入开户许可证编号";
	}
	if(!RE.accountOpen.test(gets)){  
	    return "格式不正确";  
	}
	return true;
};
/*******车牌号伍成然***********/
var cartNumber = function (gets,obj,curform,datatype) {
	var value = obj.attr("lang");
	if(!gets || gets == value){
		return "请输入车牌号";
	}
	if(!RE.cartNumber.test(gets)){  
	    return "格式不正确";  
	}
	return true;
};


/**
 * 扩展验证规则
 */
var extdatatype = {
	"logname":logname,
	"regpass":regpass,
	"imgcode":imgcode,
	"zPhone":zPhone,
	"Z6":Z6 ,
	"enterperson" : enterperson ,
	"entername" : entername ,
	"reMarks":reMarks,
	"email":email,
	"enteraddr":enteraddr,
	"rolename":rolename,
	"rolemark":rolemark,
	"unNormal":unNormal,
	"hundredNum":hundredNum,
	"qq":qq,
	"acountM":acountM,
	"tell":tell,
	"newpass" : newpass,
	"IDCard":IDCard,
	"orgcode":orgcode,
	"zbank":zbank,
	"zbankNum":zbankNum,
	"inviteCode":inviteCode,
	"titleRemarks":titleRemarks,
	"z2_20":z2_20,
	"legal":legal,
	"accountOpen":accountOpen,
	"cartNumber":cartNumber
}


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
			"logname":logname,
			"regpass":regpass,
			"imgcode":imgcode,
			"zPhone":zPhone,
			"Z6":Z6 ,
			"enterperson" : enterperson ,
			"entername" : entername ,
			"reMarks":reMarks,
			"email":email,
			"enteraddr":enteraddr,
			"rolename":rolename,
			"rolemark":rolemark,
			"unNormal":unNormal,
			"hundredNum":hundredNum,
			"qq":qq,
			"acountM":acountM,
			"tell":tell,
			"newpass" : newpass,
			"IDCard":IDCard,
			"orgcode":orgcode,
			"zbank":zbank,
			"zbankNum":zbankNum,
			"zphone":zphone,
			"z2_20":z2_20,
			"titleRemarks":titleRemarks,
			"inviteCode":inviteCode,
		},
		beforeSubmit:function(curform){//提交借款申请时添加家庭成员和家庭成员信息拼接
				        //在验证成功后，表单提交前执行的函数，curform参数是当前表单对象。  
				        //这里明确return false的话表单将不会提交;
						
				    }
	});
}