$(function(){
	$(".TB").addClass("down");
	$(".TB2").addClass("down2");
});
/* 安全中心页面js代码  */
$(function(){
	$(".tdSpan").each(function(){
		if($(this).html().match("已验证") || $(this).html().match("已绑定") || $(this).html().match("已开通") || $(this).html().match("已设置") || $(this).html().match("已选择")){
			$(this).addClass("tdAuthen");
		}else if($(this).html().match("未验证") || $(this).html().match("未开通")  || $(this).html().match("未绑定")  || $(this).html().match("未设置")  || $(this).html().match("未选择")){
			$(this).addClass("tdUnauth");
		}
		if($(".certification").html().match("已验证") && $(".account").html().match("未开通")){
			$(this).parent().find(".certificationSpan").show();
			$(this).parent().find(".accountSpan").show();
		}else if($(".certification").html().match("未验证")){
			$(this).parent().find(".linkUnauthen").show();
			$(this).parent().find(".accountSpan").hide();
		}
		if($(this).html().match("已设置")){
			$(this).parent().find(".linkUnset").hide();
		}else{
			$(this).parent().find(".linkUnset").show();
		}
		if($(this).html().match("已绑定")){
			$(this).parent().find(".linkAlert").show();
		}else{
			$(this).parent().find(".unbound").show();
		}
		if($(this).html().match("已选择") || $(this).html().match("--")){
			$(this).parent().find(".linkAlert").show();
		}
	});
});
/* 胥福星     2016-04-06  密码框提示span模拟   */
$(function(){
	$(".hint1").click(function(){
		 $(".password").focus();
	});
	$(".hint2").click(function(){
		 $(".newPassword").focus();
	});
	$(".hint4").click(function(){
		 $(".okPassword").focus();
	});
	$(".password").focus(function(){
		$(this).parent().find(".hint3").hide();
	});
	$(".password").blur(function(){
		if($(this).val() == ""){
			$(this).parent().find(".hint3").show();
		}else{
			$(this).parent().find(".hint3").hide();
		}
	});
	$(".newPassword").focus(function(){
		$(this).parent().find(".hint3").hide();
	});
	$(".newPassword").blur(function(){
		if($(this).val() == ""){
			$(this).parent().find(".hint3").show();
		}else{
			$(this).parent().find(".hint3").hide();
		}
	});
	$(".okPassword").focus(function(){
		$(this).parent().find(".hint3").hide();
	});
	$(".okPassword").blur(function(){
		if($(this).val() == ""){
			$(this).parent().find(".hint3").show();
		}else{
			$(this).parent().find(".hint3").hide();
		}
	});
});
/* 单选框点击事件     */
$(function(){
	$(".radio").click(function(){
		$(this).addClass("checked").siblings(".radio").removeClass("checked");
	});
	$("#contetnList").focus(function(){
		$(this).tip1("请输入邮箱");
	});
});

$(function(){
	/* 弹出层  */
	$(".changeValidate").click(function(){
		layer.open({
			title :'选择登录验证方式',//标题
			skin: 'layer-ext-myskin',//皮肤
	        type: 1,
	        area: ['488px', '354px'],//大小宽*高
	        shadeClose: true, //点击遮罩关闭
	        content: $('.validateMethod')//内容，里边是包含内容的div的class
	    });
	});
	/*弹出层中单选框切换伍成然2016-4-6*/
	$(".radioclass2").click(function(){
		$(".radio-select2").addClass("on");
		$(".radio-select1").removeClass("on");
	});
	$(".radioclass1").click(function(){
		$(".radio-select1").addClass("on");
		$(".radio-select2").removeClass("on");
	});
	
});
/* 邮箱绑定弹出提示层 */

/******ajax获取验证状态*******/
/*$.ajax({
    type: "post",
    dataType: "html",
    url: '*.html',
    data: html,
    success: function (data) {
        if (data != "") {         
            $("#RN").html(data);
        }else{
        	$("#RN").html('--');
        }
    }
});*/


$(function(){
	var app1 = $("#securityCheck").Validform({
		tiptype:3,//提示信息类型
		btnSubmit:"#submitRN", 
		datatype:extdatatype,//扩展验证类型
		ajaxPost:true,
		beforeSubmit:function(){
			var RN = $("#inputRN").val();
			var ID = $("inputID").val();
			
			var sendData = {};
			sendData.logname = userName;
			sendData.logname = userName;
			
			var vsign = sendBef(sendData);
			console.log(vsign);
			$.ajax({
				url:"SC_realNameAuthentication_c.html",
				type:"post",
				dataType:"json",
				data:{},
				success:function(json){
					if(json.statu == 0){
						alert("提交成功");
					}else{
						alert(json.message);
					}
				}
			});
			return false;
		}
	});
});










