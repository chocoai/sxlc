$(function(){
//	鼠标移动到查看详情div上时出现边框 和a标签背景颜色改变
	$(".borrowModeDiv").hover(function(){
		$(this).children(".borrowMode").addClass("borrowModeHover");
		$(this).children(".borrowMode").children(".borrowDetail").children(".more").css({
			"background":"#73c0f4",
			"color":"#ffffff"
		});
		$(this).children(".borrowMode").children(".flowTop").hide();
		$(this).children(".borrowMode").children(".flowTopHover").show();
	},function(){
		$(this).children(".borrowMode").removeClass("borrowModeHover");
		$(this).children(".borrowMode").children(".borrowDetail").children(".more").css({
			"background":"none",
			"color":"#73c0f4"
		});
		$(this).children(".borrowMode").children(".flowTop").show();
		$(this).children(".borrowMode").children(".flowTopHover").hide();
	});
	$(".input").keydown(function(){
		$(this).next().hide();
	});
});
jQuery.fn.changeRemarks = function(){//用来剔除特殊字符
	var remarks2 = $(this).val() ;
	var cont = remarks2.length;
	for(var c = 0;c < cont ; c++){
		remarks2=remarks2.replace(/["'<>%;)(&+]/,"");//暂时使用！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
	}
	$(this).val(remarks2);
};

/*   胥福星     2016-04-11   input中对输入金额的显示样式的控制     */
$(function(){
	$(".format").each(function(){
		$(this).focus(function(){
			this.value = (this.value + '').replace(/\,/g, '');
			$(this).keyup(function(){
				if(this.value.length > 0){
					this.value = this.value.replace(/[^0-9.]/g,'');
				}
			});
		});
		$(this).blur(function(){
			if(this.value < 300000 && this.value != ""){
				this.value = parseFloat(this.value).toFixed(2);
				this.value = (this.value + '').replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
			}else if(parseFloat(this.value) > 300000.00){
				this.value = parseFloat(300000).toFixed(2);
				this.value = (this.value + '').replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
			}
		});
		$(this).change(function(){
			this.value = this.value.replace(/[^0-9.]/g,'');
		});
	});
});
/* 年化利率的输入验证   */
$(function(){
	$(".rate").each(function(){
		$(this).focus(function(){
			$(this).keyup(function(){
				if(this.value.length > 0){
					this.value = this.value.replace(/[^0-9.]/g,'');
				}
			});
		});
		$(this).blur(function(){
			if(this.value != ""){
				if(parseFloat(this.value) <= 18.00 && parseFloat(this.value) >= 10.00){
					this.value = parseFloat(this.value).toFixed(2);
				}else if(parseFloat(this.value) < 10){
					this.value = parseFloat(10).toFixed(2);
				}else if(parseFloat(this.value) > 18){
					this.value = parseFloat(18).toFixed(2);
				}
			}
		});
		$(this).change(function(){
			this.value = this.value.replace(/[^0-9.]/g,'');
		});
	});
});
$(function(){
	$(".numberReg").each(function(){
		$(this).focus(function(){
			$(this).keyup(function(){
				if(this.value.length > 0){
					this.value = this.value.replace(/[^0-9]/g,'');
				}
			});
		});
		$(this).change(function(){
			this.value = this.value.replace(/[^0-9]/g,'');
		});
	});
});
/* input标签的输入改变      */
$(function(){
	inputText();
	inputSelect();
});
function inputText(){
	$(":text").each(function(){
		$(this).val($(this).attr("lang"));
		$(this).css('color','#999');
		$(this).focus(function(){
			if($(this).hasClass("selectInput")){
				
			}else{
				$(this).css({
					'color':'#2f2f2f',
					'font-weight':'bold'
					});
				if($(this).val() == $(this).attr("lang")){
					$(this).val('');
				}
			}
		}).blur(function(){
			if($(this).hasClass("selectInput")){
				
			}else if($(this).val() == ''){
				$(this).val($(this).attr("lang"));
				$(this).css({
					'color':'#999',
					'font-weight':'normal'
					});
			}
		});
	});	
	$(".input").each(function(){
		$(this).val($(this).attr("lang"));
		$(this).css({
			'color':'#999',
			'font-weight':'normal'
			});
		$(this).focus(function(){
			if($(this).hasClass("selectInput")){
				
			}else{
				$(this).css({
					'color':'#2f2f2f',
					'font-weight':'bold'
					});
				if($(this).val() == $(this).attr("lang")){
					$(this).val('');
				}
			}
		}).blur(function(){
			if($(this).hasClass("selectInput")){
				
			}else if($(this).val() == ''){
				$(this).val($(this).attr("lang"));
				$(this).css({
					'color':'#999',
					'font-weight':'normal'
					});
			}
		});
	});	
}
/* select选项框模拟jquery代码  */
function inputSelect(){
	$(".selectInput").each(function(){
		var cc = $(this).parent().find(".selectValue").attr("value");
		$(this).click(function(){
			if($(this).next(".select").is(":hidden")){
				$(this).next(".select").slideDown(200);
			}else{
				$(this).next(".select").slideUp(200);
			}
		});
		$(this).next().find(".selectOption").each(function(){
			if($(this).attr("value") == cc){
				$(this).parent().parent().find(".selectInput").val($(this).html());
			}
			$(this).click(function(){
				$(this).parent().parent().find(".selectInput").val($(this).html());
				$(this).parent().parent().find(".selectValue").attr("value",$(this).attr("value"));
				$(this).parent().slideUp(200);
				$(this).parent().parent().find(".selectInput").css({
					'color':'#2f2f2f',
					'font-weight':"bold"
					});
			});
		});
		$(this).blur(function(){
			var ob = $(this);
			setTimeout(function () {
				ob.next().slideUp(200);
		    }, 100);
		});
	});
}
/* 点击查看详情时指南标题改变   胥福星      20160412    */
$(function(){
	$(".credit").click(function(){
		$(".guideTitle").html("信用贷");
	});
	$(".assure").click(function(){
		$(".guideTitle").html("担保贷");
	});
	$(".guaranty").click(function(){
		$(".guideTitle").html("抵押贷");
	});
	$("#personInfo").Validform({
		tiptype:3,//提示信息类型
		btnSubmit:".submit", //#btn_sub是该表单下要绑定点击提交表单事件的按钮;如果form内含有submit按钮该参数可省略;
		datatype:extdatatype,//扩展验证类型
		ajaxPost:{//使用ajax提交时
			url:"http://182.150.178.88:8031/GEB_P2P_Foreqround/selectmemberProvince.action",
			datatype:"jsonp",
			success:function(data,obj){
	        },
	        error:function(data,obj){
	            console.log(data.status);
	        }
		}
	});
});

function clickUp(){
	layer.open({
		title :' ',//标题
		skin: 'layer-ext-myskin',//皮肤
		type: 1,
		area: ['540px', '373px'],//大小宽*高
		shadeClose: true, //点击遮罩关闭
		content: $('.applyTalent')//内容，里边是包含内容的div的class
	});
	$('.layui-layer-title').css("border-bottom","none");
}
function clickDown(){
	layer.open({
		title :' ',//标题
		skin: 'layer-ext-myskin',//皮肤
		type: 1,
		area: ['540px', '373px'],//大小宽*高
		shadeClose: true, //点击遮罩关闭
		content: $('.applyTalent2')//内容，里边是包含内容的div的class
	});
	$('.layui-layer-title').css("border-bottom","none");
}
