$(function(){
	$(".TC").addClass("down");
	$(".TC1").addClass("down2");
});


/* 2016-04-06  胥福星       弹出层提示代码     */
$(function(){
	$(".rechargeMethod").val("个人网银");
	$(".rechargeMethod").css("color","#171717");
	$(".selectOptionAab").each(function(){
		$(this).click(function(){
			var s = $(".cashFormat").attr("lang");
			$(".cashFormat").val(s).css("color","#999");
		});
	});
	$(".rechargeInputFocus").focus(function(){
		if($(this).parent().parent().siblings().find(".rechargeMethod").val().match("个人网银")){
			$(this).parent().layoutFocus("2元起充");
			$(".cashFormat").blur(function(){
				if(parseFloat((this.value + '').replace(/\,/g, '')) < parseFloat(2.00)){
					this.value = parseFloat(2).toFixed(2);
				}
			});
		}else if($(this).parent().parent().siblings().find(".rechargeMethod").val().match("汇款充值")){
			$(this).parent().layoutFocus("21元起充");
			$(".cashFormat").blur(function(){
				if(parseFloat((this.value + '').replace(/\,/g, '')) < parseFloat(21.00)){
					this.value = parseFloat(21).toFixed(2);
				}
			});
		}else if($(this).parent().parent().siblings().find(".rechargeMethod").val().match("快捷支付")){
			$(this).parent().layoutFocus("2元起充");
			$(".cashFormat").blur(function(){
				if(parseFloat((this.value + '').replace(/\,/g, '')) < parseFloat(2.00)){
					this.value = parseFloat(2).toFixed(2);
				}
			});
		}else if($(this).parent().parent().siblings().find(".rechargeMethod").val().match("企业网银")){
			$(this).parent().layoutFocus("21元起充");
			$(".cashFormat").blur(function(){
				if(parseFloat((this.value + '').replace(/\,/g, '')) < parseFloat(21.00)){
					this.value = parseFloat(21).toFixed(2);
				}
			});
		}
	});
	$(".rechargeInputFocus").blur(function(){
		$(this).parent().parent().find(".tip").remove();
	});
});

