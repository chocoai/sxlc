/** 充值手续费 **/
/** 全局变量 **/
var mtype = null;
var otype = null;
var ptype = null;
//获取项目根目录全路径
function getRootPath(){
        var curWwwPath=window.document.location.href;
        var pathName=window.document.location.pathname;
        var pos=curWwwPath.indexOf(pathName);
        var localhostPath=curWwwPath.substring(0,pos);
        var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
		if(/127.0.0.1|localhost/.test(localhostPath)){
			return(localhostPath+projectName);
		}else{
			return(localhostPath);
		}
}

/** 修改 充值手续费 **/
//会员
function mchargefee () {
	//validform5("btn","auto",true,"3");
	$.ajax({
		type : 'post',
		url : appPath + "/withdraw/update4charge.do",
		data : "paymentMemberType=" + 0 +"&feePaymentMethod=" + mtype,
		success : function (msg) {
			if (msg == 1) {
				layer.alert("操作成功",{icon:1});
				day = null;
				setTimeout('location.reload()',2000);
			}else {
				layer.alert("操作失败",{icon:2});
			}
		}
		
	});
}

//机构
function ochargefee () {
	//validform5("btn","auto",true,"3");
	$.ajax({
		type : 'post',
		url : appPath + "/withdraw/update4charge.do",
		data : "paymentMemberType=" + 1 +"&feePaymentMethod=" + otype,
		success : function (msg) {
			if (msg == 1) {
				layer.alert("操作成功",{icon:1});
				day = null;
				setTimeout('location.reload()',2000);
			}else {
				layer.alert("操作失败",{icon:2});
			}
		}
		
	});
}

//平台
function pchargefee () {
	//validform5("btn","auto",true,"3");
	$.ajax({
		type : 'post',
		url : appPath + "/withdraw/update4charge.do",
		data : "paymentMemberType=" + 2 +"&feePaymentMethod=" + ptype,
		success : function (msg) {
			if (msg == 1) {
				layer.alert("操作成功",{icon:1});
				day = null;
				setTimeout('location.reload()',2000);
			}else {
				layer.alert("操作失败",{icon:2});
			}
		}
		
	});
}
$(function () {
	$("#mdiv input[type='radio']").each(function(index){
		$(this).on('click',function(){
			$(this).attr("checked",true).parent(".checkbox-inline").siblings().children("input[type='radio']").attr("checked",false);
			if($(this).attr("checked")){
				mtype = $(this).val();
			}
		});
	});
	
	$(function () {
		$("#odiv input[type='radio']").each(function(index){
			$(this).on('click',function(){
				$(this).attr("checked",true).parent(".checkbox-inline").siblings().children("input[type='radio']").attr("checked",false);
				if($(this).attr("checked")){
					otype = $(this).val();
				}
			});
		});
	});
	
	$(function () {
		$("#sdiv input[type='radio']").each(function(index){
			$(this).on('click',function(){
				$(this).attr("checked",true).parent(".checkbox-inline").siblings().children("input[type='radio']").attr("checked",false);
				if($(this).attr("checked")){
					ptype = $(this).val();
				}
			});
		});
	});
});
