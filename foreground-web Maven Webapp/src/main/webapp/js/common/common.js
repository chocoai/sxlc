
$(function(){
	/*layer层自定义样式加载伍成然2016-4-5*/
	layer.config({
	    extend: ['skin/myskin/style.css'], //加载您的扩展样式
	    skin: 'layer-ext-myskin'
	});
	$(".weibo").hover(function(){
		$(".weibo_scan").show();
	},function(){
		$(".weibo_scan").hide();
	});
	$(".wechat").hover(function(){
		$(".weichart_scan").show();
		$(".weichart_scan").css("margin-left","35px");
	},function(){
		$(".weichart_scan").hide();
	});
	$(".phone").hover(function(){
		$(".phone_scan").show();
		$(".phone_scan").css("margin-left","13px");
	},function(){
		$(".phone_scan").hide();
	});
	
	
	/*公共侧边*/
	$(".aside_effect .qq").hover(function(){
		$(this).removeClass("qq").addClass("zxkf");
	},function(){
		$(this).removeClass("zxkf").addClass("qq");	
	});
	$(".aside_effect .jsq").hover(function(){
		$(this).removeClass("jsq").addClass("syjs");
	},function(){
		$(this).removeClass("syjs").addClass("jsq");	
	});
	$(".aside_weichart>div>.side_weixin").hover(function(){
		$(this).removeClass("side_weixin").addClass("gfwx");
		$(".as_weichart_scan").show();
	},function(){
		$(this).removeClass("gfwx").addClass("side_weixin");
		$(".as_weichart_scan").hide();
	});
	$(".aside_effect .zc").hover(function(){
		$(this).removeClass("zc").addClass("ljdl");
	},function(){
		$(this).removeClass("ljdl").addClass("zc");	
	});
	$(".aside_effect .dl").hover(function(){
		$(this).removeClass("dl").addClass("zcyl");
	},function(){
		$(this).removeClass("zcyl").addClass("dl");	
	});
	$(".aside_effect .topImg").hover(function(){
		$(this).removeClass("topImg").addClass("back_top");
	},function(){
		$(this).removeClass("back_top").addClass("topImg");	
	});
	/*返回顶部效果*/
		$(".backTop").click( function(){
	         rt();
	     });
		
//		不能输入空格的input
		$("input").each(function(){
			$(this).on("keypress",function(event){
				if(event.keyCode == 32){
					return false
				}
			})
		})
		
});
function rt() {
    var d = document,
        dd = document.documentElement,
        db = document.body,
        top = dd.scrollTop || db.scrollTop,
        step = Math.floor(top / 20);
       (function() {
           top -= step;
           if (top > -step) {
               dd.scrollTop == 0 ? db.scrollTop = top: dd.scrollTop = top;
               setTimeout(arguments.callee, 20);
           }
       })();
}
/* 金额格式转换伍成然2016-4-11 */
jQuery.fn.format=function(num){
	return (parseFloat(num).toFixed(2) + '').replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
};
$(function(){
	$(".moneyFormat").each(function(){
		var s = $(this).text();
		var str = parseFloat(s);
		var n = $(this).format(str);
		$(this).text(n);
	});
});
/* 弹出提示框的js代码  */
jQuery.fn.layoutWarning = function(str){
	$(this).layoutClean();
	var s = str;
	var m = '<div class="tipError"><div class="pre"></div><div class="after">' + s + '</div></div>';
	this.parent().css('position','relative');
	this.parent().append(m);
	this.parent().find(".tipError").css("left",this.offset().left - this.parent().offset().left + this.innerWidth() + 5);
	this.parent().find(".tipError").css("top",this.offset().top - this.parent().offset().top - 2 );
};
jQuery.fn.layoutFocus = function(str){
	$(this).layoutClean();
	var s = str;
	var m = '<div class="tip"><div class="preTip"></div><div class="afterTip">' + s + '</div></div>';
	this.parent().css('position','relative');
	this.parent().append(m);
	this.parent().find(".tip").css("left",this.offset().left - this.parent().offset().left + this.innerWidth() + 5);
	this.parent().find(".tip").css("top",this.offset().top - this.parent().offset().top - 2 );
};
jQuery.fn.layoutSuccess = function(){
	$(this).layoutClean();
	var m = '<div class="tipOk"></div>';
	this.parent().css('position','relative');
	this.parent().append(m);
	this.parent().find(".tipOk").css("left",this.offset().left - this.parent().offset().left + this.innerWidth() + 5);
	this.parent().find(".tipOk").css("top",this.offset().top - this.parent().offset().top + 12 );
};
/* 获取动态验证码的弹出提示层js代码  */
jQuery.fn.layoutCode = function(str){
	$(this).layoutClean();
	var s = str;
	var m = '<span class="dynamicVerificationSpan">' + s + '</span>';
	this.parent().css('position','relative');
	this.parent().append(m);
	this.parent().find(".dynamicVerificationSpan").css("left",this.offset().left - this.parent().offset().left + this.innerWidth() + 10);
	this.parent().find(".dynamicVerificationSpan").css("top",this.offset().top - this.parent().offset().top );
};
jQuery.fn.layoutClean = function(){
	$(this).parent().find(".tipError").remove();
	$(this).parent().find(".tip").remove();
	$(this).parent().find(".tipOk").remove();
	$(this).parent().find(".dynamicVerificationSpan").remove();
}
jQuery.fn.layoutCleanAll = function(){
	$(".tipError").remove();
	$(".tip").remove();
	$(".tipOk").remove();
	$(".dynamicVerificationSpan").remove();
}
jQuery.fn.errorPrompt = function(str){
	var html = '<span class="arrow">'+
				'<em></em><span></span>'+
				'</span>'+
				'<span class="Validform_checktip">'+str+'</span>';
	this.next().removeClass("Validform_right").addClass("Validform_wrong").html(html);
	this.css("border","1px solid #f00");
}
jQuery.fn.rightPrompt = function(){
	this.next().removeClass("Validform_wrong").addClass("Validform_right").html("");
	this.css("border","1px solid #d2d2d2");
}