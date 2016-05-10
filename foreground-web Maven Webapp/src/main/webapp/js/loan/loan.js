$(function(){
	
	$("#productMode").delegate(".borrowModeDiv","mousemove",function(){

		$(this).children(".borrowMode").addClass("borrowModeHover");
		$(this).children(".borrowMode").children(".borrowDetail").children(".more").css({
			"background":"#73c0f4",
			"color":"#ffffff"
		});
		$(this).children(".borrowMode").children(".flowTop").hide();
		$(this).children(".borrowMode").children(".flowTopHover").show();		
		
	});	
	
	$("#productMode").delegate(".borrowModeDiv","mouseout",function(){

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
	
	/**查询下拉借款类型**/
	qurySelectType();
	
	/**查询借款类型列表及介绍**/
	queryLoanList();
	
});

/**
 * 查询下拉借款类型
 * @returns
 */
function qurySelectType(){
	$.ajax({
		type:"POST",
		url:"borrow/selectProjectBaseInfoCombox.html",
		success:function(r){
			var data=JSON.parse(r);
			if(data.code == 200){
				var html = template('typeSelectList', data);
		        document.getElementById('typeSelect').innerHTML = html;	
		        inputSelect();
			}
		}
	});	
}
/**
 * 查询项目类型列表 for 详细图文介绍
 */
function queryLoanList(){
	$.ajax({
		type:"POST",
		url:"borrow/selectProjectBaseInfoList.html",
		success:function(r){
			var data=JSON.parse(r);
			if(data.code == 200){
				var html = template('loanList', data);
		        document.getElementById('productMode').innerHTML = html;	
		        
		        var id=$("#productMode .borrowModeDiv").eq(0).attr("id");
		        if(id!=null && id!=undefined){
		        	quryLoanDeatil(id);//调用第一个类型查询其详细信息
		        	quryAttestById(id);//调用第一个类型查询准备资料
		        }
			}
		}
	});		
}

/**
 * 根据id查看借款项目详情 
 * @param loanId
 * @returns
 */
function quryLoanDeatil(loanId){
	var encrypt = new JSEncrypt();
	encrypt.setPublicKey(publickey);
	loanId=encrypt.encrypt(loanId+"");	
	$.ajax({
		type:"POST",
		data:{id:loanId},
		url:"borrow/selectProjectBaseInfoById.html",
		success:function(r){
			var object=JSON.parse(r);
			if(object.code == 200){
				var data=object.data;
				if(data!=null){
					$(".guideTitle").text(data.projectName);//项目名
					$(".projectProfile").text(data.briefIntroduction);//j简介
					$(".projectMinAmount").text((Number(data.minAmount)/10000).toFixed(2));//额度范围下限
					$(".projectMaxAmount").text((Number(data.maxAmount)/10000).toFixed(2));//额度范围上线
					$(".minRate").text(Number(data.minRates).toFixed(4));//利率下限
					$(".maxRate").text(Number(data.maxRates).toFixed(4));//利率上限
					var applyMember=data.applyMember;
					var applyMemberText="";
					switch(applyMember){
						case 0: applyMemberText="无限制"; break;
						case 1: applyMemberText="个人会员"; break;
						case 2: applyMemberText="企业会员"; break;
					}	
					$(".memLimit").text(applyMemberText);//会员限制
					
					var tminDaytime=data.tminDaytime;
					var tmaxDaytime=data.tmaxDaytime;
					var mminDaytime=data.mminDaytime;
					var mmaxDaytime=data.mmaxDaytime;
					var yminDaytime=data.yminDaytime;
					var ymaxDaytime=data.ymaxDaytime;
					var textT=tminDaytime+"-"+tmaxDaytime+"天";
					var textM=mminDaytime+"-"+mmaxDaytime+"月";
					var textY=yminDaytime+"-"+ymaxDaytime+"年";
					var text=textT+"，"+textM+"，"+textY;
					$(".deadLineRange").html(""+text+"");
					
				}
			}else{
				
			}
		}
	});		
	
}

/**
 * 根据借款类型ID查询需要准备的资料列表
 * @param loanId
 * @returns
 */
function quryAttestById(loanId){
	var encrypt = new JSEncrypt();
	encrypt.setPublicKey(publickey);
	loanId=encrypt.encrypt(loanId+"");	
	$.ajax({
		type:"POST",
		data:{id:loanId},
		url:"borrow/selectMemberAttestByprojectType.html",
		success:function(r){
			var object=JSON.parse(r);
			if(object.code == 200){
				var data=object.data;
				var text="";
				for(var i=0;i<data.length;i++){
					if(i<data.length-1){
						text=text+"<span>"+data[i].attestTypeName+"</span>"+"+";
					}else{
						text=text+"<span>"+data[i].attestTypeName+"</span>";
					}
				}
				if(text!=null){
					$(".material").html(text);
				}
			}else{
				
			}
		}
	});		
}

/**
 * 查询借款类型信息
 * @param loanId
 * @returns
 */
function quryDeatail(loanId){
	quryLoanDeatil(loanId);//查询其详细信息
	quryAttestById(loanId);//查询准备资料	
	window.location.href="loan/loan.html#guide";
}


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
	$("#personInfo").Validform({
		tiptype:3,//提示信息类型
		btnSubmit:".submit", //#btn_sub是该表单下要绑定点击提交表单事件的按钮;如果form内含有submit按钮该参数可省略;
		datatype:extdatatype,//扩展验证类型
		ajaxPost:true,
		beforeSubmit:function(curform){
			var uses=$(".yongTu").val();//用途
			var repaySource=$(".laiYuan").val();//还款来源
			var amount=$(".loanSum").val();//借款金额
			var projectDescript=$(".miaoShu").val();//项目描述
			var deadlineType=$(".selectDateUnit").attr("value");//期限类型
			var deadline=$(".selectDate").val();//期限
			var repayWay=$(".repaymentMethod").attr("value");//还款方式
			var yearRate=$(".rate").val();//利率
			var projectID=$(".selectType").attr("value");//项目ID
			var encrypt = new JSEncrypt();
			encrypt.setPublicKey(publickey);
			
			uses=encrypt.encrypt(uses+"");
			repaySource=encrypt.encrypt(repaySource+"");
			amount=encrypt.encrypt(amount+"");
			projectDescript=encrypt.encrypt(projectDescript+"");
			deadlineType=encrypt.encrypt(deadlineType+"");
			deadline=encrypt.encrypt(deadline+"");
			repayWay=encrypt.encrypt(repayWay+"");
			yearRate=encrypt.encrypt(yearRate+"");
			projectID=encrypt.encrypt(projectID+"");
			
			var str_url="borrow/insertProjectPurposeFront.html";
			
			NetUtil.ajax(
					str_url,
					{uses:uses,repaySource:repaySource,amount:amount,projectDescript:projectDescript,deadlineType:deadlineType,deadline:deadline,repayWay:repayWay,yearRate:yearRate,projectID:projectID},
					function(r){
						var r = JSON.parse(r);
						if (r.code == 200){
							clickUp();
						}else{
							clickDown();
						}
					}
				)	
				
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

function closePlate(flag){
	layer.closeAll();
	if(flag==2){
		window.location.reload();
	}
}
