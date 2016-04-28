$(function(){
	$(".TD").addClass("down");
	$(".TD3").addClass("down2");
	/*弹出层伍成然2016-4-6*/
	$('.allowBidBtn').on('click', function(){
		layer.open({
			title :'自动投标设置',//标题
			skin: 'layer-ext-myskin',//皮肤
	        type: 1,
	        area: ['583px', '768px'],//大小宽*高
	        shadeClose: true, //点击遮罩关闭
	        content: $('.autoBidSet')//内容，里边是包含内容的div的class
	    });
	});
	/*...项目期限单独绑定验证...*/
	$(".info label").click(function(){
		$(this).parent().children().removeClass("active"); 
		$(this).addClass("active");
	});
	$('.numberReg').focus(function(){
		$(this).parent().siblings().children('.numberReg').attr('disabled',true);
		$('.numberReg').blur(function(){
			var dangQ=$(this).val();
			if(dangQ == ''){
				$(this).parent().siblings().children('.numberReg').attr('disabled',false);
				$('.numberReg').focus(function(){
					$(this).parent().layoutWarning("请输入项目期限");
				});
			}
			else{
				$(this).parent().layoutClean();
			}
		});
	});	
	
	//验证
	$("#touBao").Validform({
		tiptype:3,//提示信息类型
		btnSubmit:".autoBtn", //#btn_sub是该表单下要绑定点击提交表单事件的按钮;如果form内含有submit按钮该参数可省略;
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





