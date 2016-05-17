//兑换商品详情
$(function(){
	var count=0;
	$(".addressUl li").mouseover(function(){
		$(this).addClass("addressUlHover");
		$(this).find("a").show();
		$(this).find(".addressColor").css("color","#4c4c4c");
	});
	$(".addressUl li span").click(function(){
		if(!$($(this).parent().next()).is(':hidden')){
			$(this).parent().next().hide();
		}
	});
	$(".addressUl li").mouseout(function(){
		$(this).removeClass("addressUlHover");
		$(this).find("a").hide();
		$(this).parent().find(".addressColor").css("color","#000");
	});
	$(".btn a").mouseover(function(){
		$(this).addClass("saveBtnHover").siblings().removeClass("saveBtnHover");
	});
	$(".addAddress").click(function(){
		if($(this).parent().next().is(":hidden")){
			$(this).parent().next().show();
		}else{
			$(this).parent().next().hide();
		}
		$(this).siblings("ul").children("li").next().hide();
	});
	
	//已有地址修改
	$(".alertAddress").click(function(){
		$(this).parent().next().show();
		$(this).parent().siblings("li").next().hide();
		$(this).parent().parent().siblings(".addAddress").parent().next().hide();
	});
});

/* input标签的输入改变      */
$(function(){
	inputText();
	inputSelect();
});
function inputText(){
	$(":text").each(function(){
		if($(this).val() == ""){
			$(this).val($(this).attr("lang"));
			$(this).css('color','#818181');
		}
		$(this).focus(function(){
			if($(this).hasClass("selectInput")){
				
			}else{
				$(this).css('color','#000');
				if($(this).val() == $(this).attr("lang")){
					$(this).val('');
				}
			}
		}).blur(function(){
			if($(this).hasClass("selectInput")){
				
			}else if($(this).val() == ''){
				$(this).val($(this).attr("lang"));
				$(this).css('color','#818181');
			}
		});
	});	
	$(".input").each(function(){
		if($(this).val() == ""){
			$(this).val($(this).attr("lang"));
			$(this).css('color','#818181');
		}
		$(this).focus(function(){
			if($(this).hasClass("selectInput")){
				
			}else{
				$(this).css('color','#000');
				if($(this).val() == $(this).attr("lang")){
					$(this).val('');
				}
			}
		}).blur(function(){
			if($(this).hasClass("selectInput")){
				
			}else if($(this).val() == ''){
				$(this).val($(this).attr("lang"));
				$(this).css('color','#818181');
			}
		});
	});	
}

/* select选项框模拟jquery代码  */
function inputSelect(){
	$(".selectInput").each(function(){
		var cc = $(this).parent().find(".selectValue").attr("value");
		if(cc != 0){
			$(this).css("color","#000");
		}
		$(this).click(function(){
			if($(this).next(".select1").is(":hidden")){
				$(this).next(".select1").slideDown(200);
			}else{
				$(this).next(".select1").slideUp(200);
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
				$(this).parent().parent().find(".selectInput").css('color','#2f2f2f');
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



/* 判断是否为数字   */
$(function(){
	$(".numberReg").each(function(){
		$(this).focus(function(){
			$(this).keyup(function(){
				if(this.value.length > 0){
					this.value = this.value.replace(/[^0-9.]/g,'');
				}
			});
		});
	});
	$("#zeng_shouHuo").Validform({
		tiptype:3,//提示信息类型
		btnSubmit:".saveBtn", //#btn_sub是该表单下要绑定点击提交表单事件的按钮;如果form内含有submit按钮该参数可省略;
		datatype:extdatatype,//扩展验证类型
		ajaxPost:{//使用ajax提交时
			url:"",
			datatype:"json",
			success:function(data,obj){
	        },
	        error:function(data,obj){
	            //console.log(data.status);
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



//20160513数据交互  chenzhen
//exchangeDetail根据id获取兑换详情，计算总积分
function getExchangeInfo(){
	var temp = window.location.href;
	var goodsId = temp.split("_")[1].split(".html")[0];
	var count = temp.split("count=")[1] || 1;
	$(".exchangeNum").text(count);//兑换数量赋值
	if(goodsId == null || isNaN(goodsId)){
		return;
	}
	
	var singlePoint = $("#singlePoint").val();//单个积分
	var exchangePoint = singlePoint*count || 0;//总积分计算
	$(".exchangePoint").text(exchangePoint);//总积分赋值
	
	/*$.ajax({
		url:"integralMall/commodityInfo_"+goodsId+".html",
		type:"get",
		dataType:"json",
		timeout:10000,
		success:function(data){
			console.log(data);
			if(data){
				$("#commoditySmallIcon").attr("src",data.commoditySmallIcon);
				$("#commodityName").text(data.commodityName);//商品名称赋值
				var exchangePoint = data.needPoint*count || 0;//总积分计算
				$(".exchangePoint").text(exchangePoint);//总积分赋值
			}
		},
		error:function(){
			layer.alert("请求异常，请稍后再试",{icon:2});
		}
	});*/
	
	
}

//地址操作对象
var Addr = {
	//
	getAddr:function(){
		
	},
	
	//新增地址
	add : function(){
		console.log("add");
	},
	//修改地址
	mod: function(){
		console.log("mod");
		
	},
	//设置默认地址
	setDef: function(){
		console.log("set");
		
	},
	//选中地址
	check: function(){
		console.log("check");
	}
};

//添加收件地址
$("#addrAdd").on("click",function(){
	Addr.add();
});