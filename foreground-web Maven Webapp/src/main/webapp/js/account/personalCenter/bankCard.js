$(function(){
	$(".TB").addClass("down");
	$(".TB3").addClass("down2");
	quryBankList();//查询用户银行列表
	//付晨早 2016.4.29 添加银行卡 10:30am
	var addBankCard = {
		//查询银行列表
		getBankName:function(){
			$.ajax({
				type:"GET",
				url:"bankCardMng/selectBankInfo.html",
				success:function(r){
					if(JSON.parse(r).code == 200){
						var data = JSON.parse(r);
						var html = template('bankName', data);
				        document.getElementById('addCard_selectBank').innerHTML = html;
				        $("#addCard_selectBank .selectOption").on("click",function(){
							$(this).parent().parent().find(".selectInput").val($(this).html());
							$(this).parent().parent().find(".selectValue").attr("value",$(this).attr("value"));
							$(this).parent().slideUp(200);
							$(this).parent().parent().find(".selectInput").css('color','#2f2f2f');
						});
					}
				}
			})
		},
		//查询省份信息
		getProvince:function(){
			$.ajax({
				type:"GET",
				url:"bankCardMng/selectProvinceDictionary.html",
				success:function(r){
					if(JSON.parse(r).code == 200){
						var data = JSON.parse(r);
						var html = template('provinceName', data);
					        document.getElementById('provinceSelect').innerHTML = html;
					        $("#provinceSelect .selectOption").on("click",function(){
								$(this).parent().parent().find(".selectInput").val($(this).html());
								$(this).parent().parent().find(".selectValue").attr("value",$(this).attr("value"));
								$(this).parent().slideUp(200);
								$(this).parent().parent().find(".selectInput").css('color','#2f2f2f');
								addBankCard.getCity($(this).attr("value"));
							});
					}
				}
			})
		},
		//根据省份查询市
		getCity:function(provinceId){
			var encrypt = new JSEncrypt();
			encrypt.setPublicKey(publickey);
			var provinceId = encrypt.encrypt(provinceId+"");
			var url = "bankCardMng/selectCityDictionary.html";
			var data = {provinceId:provinceId};
			NetUtil.ajax(
					url,
					{provinceId:provinceId},
					function(r){
						var data = JSON.parse(r);
						var html = template("cityName",data);
						document.getElementById("citySelect").innerHTML = html;
						 $("#citySelect .selectOption").on("click",function(){
								$(this).parent().parent().find(".selectInput").val($(this).html());
								$(this).parent().parent().find(".selectValue").attr("value",$(this).attr("value"));
								$(this).parent().slideUp(200);
								$(this).parent().parent().find(".selectInput").css('color','#2f2f2f');
						});
					}
				)
		}
	}
	
	
	
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
//		初始化
		addBankCard.getBankName();
		addBankCard.getProvince();

	});
	
	$("#bankListSelect").delegate(".change","click",function(){
		layer.open({
			title :'修改银行卡',//标题
			skin: 'layer-ext-myskin',//皮肤
	        type: 1,
	        area: ['623px', '632px'],//大小宽*高
	        shadeClose: true, //点击遮罩关闭
	        content: $('.changeBankCard')//内容，里边是包含内容的div的class
	    });
		$.ajax({
			type:"POST",
			async:false,//同步请求
			url:"bankCardMng/deleteMemberBankCard.html",
			data:{receiveCard:bId},
			success:function(r){
				var object=JSON.parse(r);
				if(object.code == 404){
					layer.alert(object.message);
				}else　if(object.code == 200){
					flag=true;
				}
			}
		});		
		
	});	
	
	/*删除银行卡逻辑待改*/
	$("#bankListSelect").delegate(".delete","click",function(){
		var id=$(this).attr("id");
		layer.confirm('确定删除吗?', {icon: 3, title:'提示'}, function(index){
			var flag=delBankId(id);
			if(flag){
				window.location.reload();
			}
		});
	});
	//验证
	$("#bankId").Validform({
		tiptype:3,//提示信息类型
		//btnSubmit:".btn", //#btn_sub是该表单下要绑定点击提交表单事件的按钮;如果form内含有submit按钮该参数可省略;
		datatype:extdatatype,
		ajaxPost:true,
		beforeSubmit:function(curform){
			var passID_card=$("#passID_card").val();//银行卡号
			var zbank=$("#zbank").val();//支行
			var zPhone=$("#zPhone").val();//绑定手机号
			var bankId=$("#addCard_bankValue").attr("value");//银行编号
			var provinceId=$(".provinceId").attr("value");//银行卡省份ID
			var cardCity=$(".cityId").attr("value");//银行卡城市ID
			var branchAddress="n";
			cardCity="12";
			var encrypt = new JSEncrypt();
			encrypt.setPublicKey(publickey);
			
			passID_card=encrypt.encrypt(passID_card+"");
			zbank=encrypt.encrypt(zbank+"");
			zPhone=encrypt.encrypt(zPhone+"");
			bankId=encrypt.encrypt(bankId+"");
			provinceId=encrypt.encrypt(provinceId+"");
			cardCity=encrypt.encrypt(cardCity+"");
			branchAddress=encrypt.encrypt(branchAddress+"");
			var str_url="bankCardMng/insertMemberBackCard.html";
			NetUtil.ajax(
					str_url,
					{bankNo:passID_card,branch:zbank,bankPhone:zPhone,bankId:bankId,cardProvince:provinceId,cardCity:cardCity,branchAddress:branchAddress},
					function(r){
						var r = JSON.parse(r);
						if (r.code == 200){
							layer.alert("添加成功",function(){
								window.location.reload();
							})
						}else{
							layer.alert(r.message)
						}
					}
				)	
				
				return false;
		}
	});
	////debugger;
	//$("#xiuGai_Kard").Validform({
	//	tiptype:3,//提示信息类型
	//	btnSubmit:".btn_tian", //#btn_sub是该表单下要绑定点击提交表单事件的按钮;如果form内含有submit按钮该参数可省略;
	//	datatype:extdatatype,//扩展验证类型
	//	ajaxPost:{//使用ajax提交时
	//		url:"",
	//		datatype:"json",
	//		success:function(data,obj){
	//        },
	//        error:function(data,obj){
	//            console.log(data.status);
	//        }
	//	}
	//});
});

/**查询用户绑卡列表***/
function quryBankList(){
	$.ajax({
		type:"POST",
		url:"bankCardMng/selectMemberBankCardList.html",
		success:function(r){
			if(JSON.parse(r).code == 200){
				var data = JSON.parse(r);
				var html = template('bankList', data);
			        document.getElementById('bankListSelect').innerHTML = html;
			}
		}
	})	
}

/***删除银行卡***/
function delBankId(bId){
	var encrypt = new JSEncrypt();
	encrypt.setPublicKey(publickey);
	bId=encrypt.encrypt(bId+"");
	var flag=false;
	$.ajax({
		type:"POST",
		async:false,//同步请求
		url:"bankCardMng/deleteMemberBankCard.html",
		data:{receiveCard:bId},
		success:function(r){
			var object=JSON.parse(r);
			if(object.code == 404){
				layer.alert(object.message);
			}else　if(object.code == 200){
				flag=true;
			}
		}
	});
	
	return flag;
}
