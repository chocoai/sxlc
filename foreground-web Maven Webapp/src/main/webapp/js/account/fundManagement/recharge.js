$(function(){
	$(".TC").addClass("down");
	$(".TC1").addClass("down2");
});

jQuery.fn.changeRemarks = function(){//用来剔除特殊字符
	var remarks2 = $(this).val() ;
	remarks2=remarks2.replace(/["'<>%;)(&+]/,"");//暂时使用！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
	$(this).val(remarks2);
};
$(function(){
	/***********输入验证**************/
	var choosedOption = 1;//选择的充值方式
	$(".rechargeInputFocus").focus(function(){//起充值设定
		$(this).parent().layoutClean();
		var minMoney = 0;//最小起充值
		switch($(this).parent().parent().siblings().find(".rechargeMethod").prev().attr("value")){
			case "1":minMoney=2 ;$(this).parent().layoutFocus(minMoney+"元起充");break;
			case "2":minMoney=21;$(this).parent().layoutFocus(minMoney+"元起充");break;
			case "3":minMoney=2 ;$(this).parent().layoutFocus(minMoney+"元起充");break;
			case "4":minMoney=21;$(this).parent().layoutFocus(minMoney+"元起充");break;
		}
		$(".rechargeInputFocus").blur(function(){
			if(parseFloat((this.value + '').replace(/\,/g, '')) < parseFloat(minMoney)){
				this.value = parseFloat(minMoney).toFixed(2);
			}
		});
	});
	$(".rechargeInputFocus").blur(function(){
		$(this).parent().parent().find(".tip").remove();
	});
	$(".rechargeInput").keyup(function(){//备注的过滤
		$(this).changeRemarks();
	});
	/************提交数据部分***********/
	$(".rechargeBtn").click(function(){
//		清空所有弹窗
		$(".rechargeBtn").layoutCleanAll();
		/***********值的传入**********/
		var door = true;//门控制
		
		var choosedOption1 = choosedOption;//充值方式
		var moneyInput1 = $(".rechargeInputFocus").val();//充值金额
		var remarks1 = $(".rechargeRemarks").val();//备注
		/**********充值金额处理***********/
		if(moneyInput1 == $(".rechargeInputFocus").attr("lang")){
			$(".rechargeInputFocus").layoutWarning("请输入金额");
			door = false;
		}else{
			moneyInput1 = moneyInput1.replace(/,/g,"");
			moneyInput1 = parseFloat(moneyInput1).toFixed(2);
			if(isNaN(moneyInput1)){
				door = false;
				$(".cashFormat").layoutWarning("请输入正确格式的金额");
			}else{
				
			}
		}
		/**********备注信息处理***********/
		if(remarks1 == $(".rechargeRemarks").attr("lang")){
			remarks1 = "";
		}else{
			$(".rechargeRemarks").changeRemarks();
		}
		/**********Ajax传值***********/
		if(!door){
			return;
		}
		alert(choosedOption1 + moneyInput1 + remarks1);
		/**********Ajax传值结果的处理***********/
		if(true){//成功
			
		}else{//失败
			
		}
	});
});
