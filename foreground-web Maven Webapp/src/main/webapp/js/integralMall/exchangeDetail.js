var checkPass = false;//校验标识
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
	
	//添加
	$(".addAddress").on("click",function(){
		if($(this).parent().next().is(":hidden")){
			$(this).parent().next().show();
		}else{
			$(this).parent().next().hide();
		}
		$(this).siblings("ul").children("li").next().hide();
	});
	
	//已有地址修改
	$(".alertAddress").on("click",function(){
		var addrDet = $(this).parent().next("div.addressWhite");
		var provId = addrDet.find(".m-prov").val() || 0;
		var cityId = addrDet.find(".m-city").val() || 0;
		bindCity(provId);
		bindCounty(cityId);
		
		$(this).parent().next().show();
		$(this).parent().siblings("li").next().hide();
		$(this).parent().parent().siblings(".addAddress").parent().next().hide();
	});
	
	//获取省
	bindPro();
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
	
	$("#add-form").Validform({
		tiptype:3,//提示信息类型
		btnSubmit:".saveBtn", //#btn_sub是该表单下要绑定点击提交表单事件的按钮;如果form内含有submit按钮该参数可省略;
		datatype:extdatatype,//扩展验证类型
		beforeSubmit:function(curform){
			Addr.add();//添加
			return false;
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
		//debugger;
		var contactName = $("#receiver").val();			//姓名
		var provinceId = $("#addr-prov").val();			//省
		var cityId = $("#addr-city").val();				//市
		var countyId = $("#addr-county").val();			//县
		var detailedAddress = $("#addr-det").val();		//详细地址
		var contactPhone = $("#receiver-phone").val();	//手机
		var deliveryChoice = $("#receiver-time").val(); //送货时间
		var isDefaultAddress = $("#isDefaultAddress").val();//设为默认
		
		var data = {};//数据
		var encrypt = new JSEncrypt();//加密
		encrypt.setPublicKey(publicKey);
		
		if (contactName!=undefined){//处理
			data.contactName = encrypt.encrypt(contactName+"");
		};
		if (provinceId!=undefined){//处理
			data.provinceId = encrypt.encrypt(provinceId+"");
		};
		if (cityId!=undefined){//处理
			data.cityId = encrypt.encrypt(cityId+"");
		};
		if (countyId!=undefined){//处理
			data.countyId = encrypt.encrypt(countyId+"");
		};
		if (detailedAddress!=undefined){//处理
			data.detailedAddress = encrypt.encrypt(detailedAddress+"");
		};
		if (contactPhone!=undefined){//处理
			data.contactPhone = encrypt.encrypt(contactPhone+"");
		};
		if (deliveryChoice!=undefined){//处理
			data.deliveryChoice = encrypt.encrypt(deliveryChoice+"");
		};
		if (isDefaultAddress!=undefined){//处理
			data.isDefaultAddress = encrypt.encrypt(isDefaultAddress+"");
		};
		
		var url = "integralMall/saveShippingAddress.html";
		
		NetUtil.ajax(
			url,
			data,
			function(r){ 
			    var data = JSON.parse(r);
			    var icon = null;
			    if(data){
				    if(data.result == 1){
				    	icon = 1;
				    }else if(data.result == -1){
				    	icon = 0;
				    }else{
				    	icon = 2;
				    }
			    	layer.alert(data.message,{icon:icon});
			    	window.location.href = window.location.href;
			    }
			 	
			}
		);
		
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
/*$("#addrAdd").on("click",function(){
	Addr.add();
});*/

//获取省
function bindPro(){
	$(".province li,.city li,.county li").remove();
	$.ajax({
		url:"personalCenter/provinceList.html",
		dataType:"json",
		type:"post",
		success:function(json){
			//console.log(json);
			for (var int = 0; int < json.length; int++) {
				$(".province").append("<li class=\"selectOption\" value=\""+json[int].pId+"\">"+json[int].pName+"</li>");
			}
			$(".province .selectOption").on("click",function(){
				$(this).parent().parent().find(".selectInput").val($(this).html());
				$(this).parent().parent().find(".selectValue").attr("value",$(this).attr("value"));
				$(this).parent().slideUp(200);
				$(this).parent().parent().find(".selectInput").css('color','#2f2f2f');
				$(".county li").remove();
				bindCity($(this).attr("value"));
			});
		}
	});
}

//获取市
function bindCity(pid){
	$(".city li,.county li").remove();
	$("#addr-city,#addr-county").attr("value","0").next(".selectInput").val("请选择");
	var encrypt = new JSEncrypt();
	encrypt.setPublicKey(publicKey);
	var spid = encrypt.encrypt(pid);
	$.ajax({
		url:"personalCenter/citys.html",
		dataType:"json",
		type:"post",
		data:{proId:spid},
		success:function(json){
			//console.log(json);
			for (var int = 0; int < json.length; int++) {
				$(".city").append("<li class=\"selectOption\" value=\""+json[int].cId+"\">"+json[int].cName+"</li>");
			}
			$(".city .selectOption").on("click",function(){
				$(this).parent().parent().find(".selectInput").val($(this).html());
				$(this).parent().parent().find(".selectValue").attr("value",$(this).attr("value"));
				$(this).parent().slideUp(200);
				$(this).parent().parent().find(".selectInput").css('color','#2f2f2f');
				$(".county li").remove();
				bindCounty($(this).attr("value"));
			});
		}
	});
}

//获取区县
function bindCounty(cid){
	$(".county li").remove();
	$("#addr-county").attr("value","0").next(".selectInput").val("请选择");
	var encrypt = new JSEncrypt();
	encrypt.setPublicKey(publicKey);
	var scid = encrypt.encrypt(cid);
	$.ajax({
		url:"personalCenter/countys.html",
		dataType:"json",
		type:"post",
		data:{cid:scid},
		success:function(json){
			console.log(json);
			for (var int = 0; int < json.length; int++) {
				$(".county").append("<li class=\"selectOption\" value=\""+json[int].xId+"\">"+json[int].xName+"</li>");
			}
			$(".county .selectOption").on("click",function(){
				$(this).parent().parent().find(".selectInput").val($(this).html());
				$(this).parent().parent().find(".selectValue").attr("value",$(this).attr("value"));
				$(this).parent().slideUp(200);
				$(this).parent().parent().find(".selectInput").css('color','#2f2f2f');
			});
		}
	});
}