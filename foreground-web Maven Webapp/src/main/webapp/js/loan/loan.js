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
			if(this.value < 300000){
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
					this.value = this.value.replace(/[^0-9.]/g,'');
				}
			});
		});
		$(this).change(function(){
			this.value = this.value.replace(/[^0-9.]/g,'');
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

/* 胥福星    2016-04-06   弹出提示框的js代码  */
jQuery.fn.layoutWarning = function(str){
	var s = str;
	var m = '<div class="tipError"><div class="pre"></div><div class="after">' + s + '</div></div>';
	this.parent().css('position','relative');
	this.parent().append(m);
	this.parent().find(".tipError").css("left",this.offset().left - this.parent().offset().left + this.innerWidth() + 5);
	this.parent().find(".tipError").css("top",this.offset().top - this.parent().offset().top - 2 );
};
jQuery.fn.layoutFocus = function(str){
	var s = str;
	var m = '<div class="tip"><div class="preTip"></div><div class="afterTip">' + s + '</div></div>';
	this.parent().css('position','relative');
	this.parent().append(m);
	this.parent().find(".tip").css("left",this.offset().left - this.parent().offset().left + this.innerWidth() + 5);
	this.parent().find(".tip").css("top",this.offset().top - this.parent().offset().top - 2 );
};
jQuery.fn.layoutSuccess = function(){
	var m = '<div class="tipOk"></div>';
	this.parent().css('position','relative');
	this.parent().append(m);
	this.parent().find(".tipOk").css("left",this.offset().left - this.parent().offset().left + this.innerWidth() + 5);
	this.parent().find(".tipOk").css("top",this.offset().top - this.parent().offset().top + 12 );
};
$(function(){
	$(".rate").focus(function(){
		$(this).layoutFocus("年化利率为10.00%-18.00%");
	});
	$(".rate").blur(function(){
		$(this).parent().find(".tip").remove();
	});
});

/* 输入金额提示框   */
$(function(){
	$(".loanSum").focus(function(){
		if(this.value == ""){
			$(this).layoutFocus("额度范围：0-30万");
		}
	});
	$(".loanSum").blur(function(){
		$(this).parent().find(".tip").remove();
	});
});

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
});