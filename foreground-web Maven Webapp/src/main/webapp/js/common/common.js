
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
	return (num.toFixed(2) + '').replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
};
$(function(){
	$(".moneyFormat").each(function(){
		var s = $(this).text();
		var str = parseFloat(s);
		var n = $(this).format(str);
		$(this).text(n);
	});
});
