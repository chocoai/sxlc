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
	//验证
	$("#bankId").Validform({
		tiptype:3,//提示信息类型
		btnSubmit:".btn", //#btn_sub是该表单下要绑定点击提交表单事件的按钮;如果form内含有submit按钮该参数可省略;
		datatype:extdatatype,
		ajaxPost:{//使用ajax提交时
			url:"",
			datatype:"json",
			success:function(data,obj){
	        },
	        error:function(data,obj){
	            console.log(data.status);
	        }
		}
	});
	//debugger;
	$("#xiuGai_Kard").Validform({
		tiptype:3,//提示信息类型
		btnSubmit:".btn_tian", //#btn_sub是该表单下要绑定点击提交表单事件的按钮;如果form内含有submit按钮该参数可省略;
		datatype:extdatatype,//扩展验证类型
		ajaxPost:{//使用ajax提交时
			url:"",
			datatype:"json",
			success:function(data,obj){
	        },
	        error:function(data,obj){
	            console.log(data.status);
	        }
		}
	});
});
