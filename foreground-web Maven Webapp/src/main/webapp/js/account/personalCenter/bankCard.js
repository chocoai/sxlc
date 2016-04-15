$(function(){
	$(".TB").addClass("down");
	$(".TB3").addClass("down2");
	/*伍成然弹出层2016-4-6*/
	$(".add-bank-card").click(function(){
		layer.open({
			title :'添加银行卡',//标题
			skin: 'layer-ext-myskin',//皮肤
	        type: 1,
	        area: ['623px', '677px'],//大小宽*高
	        shadeClose: true, //点击遮罩关闭
	        content: $('.addBankCard')//内容，里边是包含内容的div的class
	    });
	});
	$(".change").click(function(){
		layer.open({
			title :'修改银行卡',//标题
			skin: 'layer-ext-myskin',//皮肤
	        type: 1,
	        area: ['623px', '632px'],//大小宽*高
	        shadeClose: true, //点击遮罩关闭
	        content: $('.changeBankCard')//内容，里边是包含内容的div的class
	    });
	});
	/*删除银行卡逻辑待改*/
	$(".delete").click(function(){
		$(this).parent().parent().css("display","none");
	});
});



/* 银行卡号确认    */
$(function(){
	$(".cardId2").blur(function(){
		if(this.value != $(".cardId1").val()){
			$(this).layoutWarning("银行卡号不一致");
		}else{
			$(this).parent().find(".tipError").remove();
		}
	});
});

/* 手机验证    */
$(".phoneBind").keyup(function(){
	var str = this.value;
	var reg = new RegExp("^[0-9]{11}$");
	$(this).parent().find(".tip").remove();
	if(!reg.test(str)){
		if($(this).parent().find(".tipError").length > 0){
			return false;
		}else{
			$(this).layoutWarning("11位数字");
		}
	}else{
		$(this).parent().find(".tipError").remove();
	}
});