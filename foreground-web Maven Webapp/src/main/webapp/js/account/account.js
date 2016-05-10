/* huangxin 20160329 This is used to select the left nav. */
$(function(){
	$(".level1Tip").each(function(){
		$(this).click(function(){
			tog($(this).parent());
		});
	});
});
function tog(obj){
	if($(obj).hasClass('down')){
		$(obj).find('ul').slideUp(500);
		var iID = setTimeout(function(){
			$(obj).removeClass('down');
		},500);
	}else{
		$(obj).find('ul').slideDown(500);
		$(obj).addClass('down');
	}
}
/*end */






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
			if(this.value != ""){
				this.value = parseFloat(this.value).toFixed(2);
				this.value = (this.value + '').replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
			}
		});
		$(this).change(function(){
			this.value = this.value.replace(/[^0-9.]/g,'');
		});
	});
});

/*  胥福星    2016-04-07  弹出提示层   */
jQuery.fn.layoutHover = function(str){
	$(this).layoutClean2();
	var s = str;
	var m = '<div class="tipUp"><div class="contentUp">' + s + '<div class="imgUp"></div></div></div>';
	this.parent().css('position','relative');
	this.parent().append(m);
	this.parent().find(".tipUp").css("left",this.offset().left - this.parent().offset().left - this.innerWidth() - 80);
	this.parent().find(".tipUp").css("bottom", this.innerHeight() + 15 );
};
jQuery.fn.layoutHover2 = function(str){
	$(this).layoutClean2();
	var s = str;
	var m = '<div class="tipDown"><div class="contentDown">' + s + '<div class="imgDown"></div></div></div>';
	this.parent().css('position','relative');
	this.parent().append(m);
	this.parent().find(".tipDown").css("left",this.offset().left - this.parent().offset().left - this.innerWidth() - 80);
	this.parent().find(".tipDown").css("top",this.offset().top - this.parent().offset().top + 30  );
};
jQuery.fn.layoutHover3 = function(str){
	$(this).layoutClean2();
	var s = str;
	var m = '<div class="tipLeft"><div class="contentLeft">' + s + '<div class="imgLeft"></div></div></div>';
	this.parent().css('position','relative');
	this.parent().append(m);
	this.parent().find(".tipLeft").css("left",this.offset().left - this.parent().offset().left + this.innerWidth() + 15);
	this.parent().find(".tipLeft").css("top",this.offset().top - this.parent().offset().top - this.innerHeight() );
};
jQuery.fn.layoutHover4 = function(str){
	$(this).layoutClean2();
	var s = str;
	var m = '<div class="tipLeft"><span class="tipLeftDiv"></span><div class="contentLeft">' + s + '<div class="imgLeft"></div></div></div>';
	this.parent().css('position','relative');
	this.parent().append(m);
	this.parent().find(".tipLeft").css("left",this.offset().left - this.parent().offset().left  - 10);
	this.parent().find(".tipLeft").css("top",this.offset().top - this.parent().offset().top);
};
/* 较小的弹出提示框   */
jQuery.fn.layoutHover5 = function(str){
	$(this).layoutClean2();
	var s = str;
	var m = '<div class="tipDown2"><div class="contentDown2">' + s + '<div class="imgDown"></div></div></div>';
	this.parent().css('position','relative');
	this.parent().append(m);
	this.parent().find(".tipDown2").css("left",this.offset().left - this.parent().offset().left - 15);
	this.parent().find(".tipDown2").css("top",this.offset().top - this.parent().offset().top + this.innerHeight() - 10 );
};

/* 清除所有的弹出提示框     */
jQuery.fn.layoutClean2 = function(){
	this.parent().find(".tipUp").remove();
	this.parent().find(".tipLeft").remove();
	this.parent().find(".tipDown").remove();
	this.parent().find(".tipDown2").remove();
};
$(function(){
	$(".whatever1").mouseover(function(){
		$(this).layoutHover("可以直接用于投资或取现的资金");
	});
	$(".whatever1").mouseout(function(){
		$(this).parent().find(".tipUp").remove();
	});
});
$(function(){
	$(".whatever2").mouseover(function(){
		$(this).layoutHover2("包括投资、取现和预约等过程中的冻结现金");
	});
	$(".whatever2").mouseout(function(){
		$(this).parent().find(".tipDown").remove();
	});
});
$(function(){
	$(".tipOrigin1").mouseover(function(){
		$(this).layoutHover3("可用余额+冻结金额+待收本金+待收收益" + '<samp class="samp">-待还总额</samp>');
	});
	$(".tipOrigin1").mouseout(function(){
		if($(this).parent().find(".tipLeft")){
			setTimeout(function(){
				$(".tipOrigin1").parent().find(".tipLeft").remove();
			},1000);
		}
	});
});
$(function(){
	$(".sign").mouseover(function(){
		$(".ALT3").find(".tipLeft").remove();
		$(this).layoutHover5("已签到" + '<span class="number">3</span>' +"次");
	});
	$(".sign").mouseout(function(){
		$(this).parent().find(".tipDown2").remove();
	});
});
$(function(){
	/* 当鼠标移动到mark1、mark2、mark3、mark4、mark5上时，出现提示窗口*/
	$(".ALT3 > .mark1").mouseenter(function(){
		$(this).layoutHover4("11111");
		//alert(1);		
		$(".tipLeftDiv").mouseenter(function(){
			$(".ALT3 > .mark1").layoutHover4("11111");
		});
	});
	$(".tipLeft").mouseleave(function(){
		alert(3);
		$(".tipLeft").remove();
			
		$(".ALT3 > .mark1").mouseleave(function(){
			$(this).parent().find(".tipLeft").remove();
			//alert(4);
		});
	});
	
	
	$(".ALT3 > .mark2").mouseover(function(){
		if($(this).parent().find(".tipLeft")){
			$(this).parent().find(".tipLeft").remove();
		}
		$(this).layoutHover4("2");
	});
	$(".ALT3 > .mark2").mouseout(function(){
		$(this).parent().find(".tipLeft").remove();
	});
	$(".ALT3 > .mark3").mouseover(function(){
		if($(this).parent().find(".tipLeft")){
			$(this).parent().find(".tipLeft").remove();
		}
		$(this).layoutHover4("3");
	});
	$(".ALT3 > .mark3").mouseout(function(){
		$(this).parent().find(".tipLeft").remove();
	});
	$(".ALT3 > .mark4").mouseover(function(){
		if($(this).parent().find(".tipLeft")){
			$(this).parent().find(".tipLeft").remove();
		}
		$(this).layoutHover4("4");
	});
	$(".ALT3 > .mark4").mouseout(function(){
		$(this).parent().find(".tipLeft").remove();
	});
	$(".ALT3 > .mark5").mouseover(function(){
		if($(this).parent().find(".tipLeft")){
			$(this).parent().find(".tipLeft").remove();
		}
		$(this).layoutHover4("未开通第三方" + '<a class="third">立即开通</a>');
	});
	$(".ALT3 > .mark5").mouseout(function(){
		$(this).parent().find(".tipLeft").remove();
	});
});


/*以下为封装内容*/
/* input标签的输入改变      */

function inputText(str){
	$(str+" :text").each(function(){
		$(this).val($(this).attr("lang"));
		$(this).css('color','#999');
		$(this).on("focus",function(){
			if($(this).hasClass("selectInput")){
				
			}else{
				$(this).css('color','#333');
				if($(this).val() == $(this).attr("lang")){
					$(this).val('');
				}
			}
		});
		$(this).on("blur",function(){
			if($(this).hasClass("selectInput")){
				
			}else if($(this).val() == ''){
				$(this).val($(this).attr("lang"));
				$(this).css('color','#999');
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
		$(this).on("click",function(){
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
			$(this).on("click",function(){
				$(this).parent().parent().find(".selectInput").val($(this).html());
				$(this).parent().parent().find(".selectValue").attr("value",$(this).attr("value"));
				$(this).parent().slideUp(200);
				$(this).parent().parent().find(".selectInput").css('color','#2f2f2f');
			});
		});
		$(this).on("blur",function(){
			var ob = $(this);
			setTimeout(function () {
				ob.next().slideUp(200);
		    }, 100);
		});
	});
}
$(function(){
	inputText("");
	inputSelect();
});
/*    图片预览js代码         胥福星             20160331   */
function getFileUrl(sourceId){
	var url; 
	if(navigator.userAgent.indexOf("Firefox")>0) { // Firefox 
		url = window.URL.createObjectURL(document.getElementById(sourceId).files.item(0)); 
	} else if(navigator.userAgent.indexOf("Chrome")>0) { // Chrome 
		url = window.URL.createObjectURL(document.getElementById(sourceId).files.item(0)); 
	} else {
		var file = document.getElementById(sourceId);
		file.select();
		file.blur();
        var url = document.selection.createRange().text;
	}
	return url; 
}
function preImg(sourceId, targetId) { 
	var url = getFileUrl(sourceId);
	if(url == null){
		return false;
	}
	var imgPre = document.getElementById(targetId); 
	var isIE = navigator.userAgent.match(/MSIE/)!= null;
	if(isIE) {
		imgPre.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod='scale',src=\"" + url + "\")";
		imgPre.src = 'data:image/gif;base64,R0lGODlhAQABAIAAAP///wAAACH5BAEAAAAALAAAAAABAAEAAAICRAEAOw==';
	} else{
		imgPre.src = url; 
	}
}
function addElement(sourceId){
	var str = sourceId.substring(14);
	var num = 0;
	if(str == ""){
		num = 0 ;
	}else{
		num = parseInt(str);
	}
	num++;
	if($("#"+sourceId).parent().next().length == 0){
		$("#"+sourceId).parent().parent().append('<div class="previewPicture">'
				+'<img class="previewImg" id="previewImg'+num+'" src="resource/img/account/common/opacity.png">'
					+'<input type="file"accept=".png,.jpg" class="previewInput" id="previewInput'+num+'" onchange="preImg(this.id,\'previewImg'+num+'\');" onblur="if(document.getElementById(\'previewImg'+num+'\').src==null)document.getElementById(\'previewImg'+num+'\').src=\'resource/img/account/common/opacity.png\'" >'
				+'</div>');
	}
	$(".mustLabel").css("display","block");
}
/*          end              */
/*签到成功弹出层伍成然2016-4-7*/
$(function(){
	$(".sign").click(function(){
		layer.open({
			title :false,//标题
			closeBtn:false,
	        type: 1,
	        area: ['447px', '353px'],//大小宽*高
	        shadeClose: true, //点击遮罩关闭
	        content: $('.sign-success')//内容，里边是包含内容的div的class
	    });
	});
});
/*签到成功弹出层结束伍成然2016-4-7*/

/* 判断是否为数字   */
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
			this.value = this.value.replace(/[^0-9.]/g,'');
		});
	});
});