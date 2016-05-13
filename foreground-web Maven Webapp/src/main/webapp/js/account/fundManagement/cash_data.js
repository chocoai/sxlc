$(function(){
	
	quryWithdrawData();
	withdraw();
});

/**
 * 查询提现信息
 */
function quryWithdrawData(){
	$.ajax({
		url:"loanWithdraw/loadWithdrawData.html",
		success:function(r){
			var object=JSON.parse(r);
			if(object.code==200){
				//银行卡
				var html = template('withdrawBankList',object);
		        document.getElementById('withdrawBank').innerHTML = html;	
		        //余额
		        var userBalance=object.userBalance;
		        $(".userBalance").text(userBalance);
			}
		}
	});
}

function withdraw(){
	
	$("#tiXian").Validform({
		tiptype:3,//提示信息类型
		datatype:extdatatype,//扩展验证类型
		callback:function(curform){
			var cashInput2=$('.cashInput1').val();//提现金额
			var remark=$(".beiZhu").val();//备注
			var code=$(".cashCodeGet").val();//验证码
			var id=$("input[name='cashBankLi']:checked").val();
			var phone=$("input[name='phone']").val();
			
			var encrypt = new JSEncrypt();
			encrypt.setPublicKey(publickey);
			
			cashInput2=encrypt.encrypt(cashInput2+"");
			remark=encrypt.encrypt(remark+"");
			code=encrypt.encrypt(code+"");
			id=encrypt.encrypt(id+"");
			phone=encrypt.encrypt(phone+"");
			
			
			$("input[name='amount']").val(cashInput2);
			$("input[name='remark']").val(remark);
			$("input[name='bankCardId']").val(id);
			$("input[name='phone']").val(phone);
			$("input[name='code']").val(code);
			
			var parm={"amount":cashInput2,"remark":remark,"bankCardId":id,"phone":phone,"code":code};
			var obj=eval(parm);
			var sign=NetUtil.createSign(obj);			
			$("input[name='sign']").val(sign);
			
			$("#tiXian").submit();
			
			return false;
		}
	});	
	
}

function getPhoneCode(){
	var flag=false;
	$.ajax({
		url:"loanWithdraw/sendWithdrawPhoneVarCode.html",
		async:false,
		success:function(r){
			var object=JSON.parse(r);
			if(object.statu==1){
				flag=true;
			}
		}
	});	
	
	return flag;
}