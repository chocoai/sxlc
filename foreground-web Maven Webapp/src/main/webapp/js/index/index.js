$(function() {

	/* 平台特色部分开始 */
	$(".feature li div").mouseover(function(){
		$(this).find(".featureTitle").css("color","#72c0f3");
	});
	$(".feature li div").mouseout(function(){
		$(this).find(".featureTitle").css("color","#000");
	});
	/* 平台特色部分结束 */
	/* 投资理财榜部分开始 */
	$(".iLtContent").eq(1).hide();
	$(".iLtContent").eq(2).hide();
	$(".ranking_list span").click(function(){
		var index=$(this).index();
		//$(".iLtContent").eq(index).show().siblings(".iLtContent").hide();
	});
	$(".ranking_list .rankingWeekly").addClass("rlSpanHover").siblings().removeClass("rlSpanHover");
	$(".ranking_list span").click(function(){
		$(this).addClass("rlSpanHover").siblings().removeClass("rlSpanHover");
	});
	/* 投资理财榜部分结束 */
	/* 进度条获取值并显示 黄鑫 20160328 */
	$(".progress_div").each(function(){
		$(this).find(".bar").css("width",$(this).find(".progress_totle").html());
	});
	/* 进度条获取值并显示 黄鑫 20160328 */
	/* 投资专区部分开始 */
	$(".investOpenT").mouseover(function(){
		$(".clock").removeClass("clockBlue").addClass("clockWhite");
	});
	$(".investOpenT").mouseout(function(){
		$(".clock").removeClass("clockWhite").addClass("clockBlue");
	});
	$(".invest_content1").mouseover(function(){
		$(this).find(".investTime").css("padding-left","1px");
		$(this).find(".investTimeP").css("margin-left","16px");
		$(this).find(".investTimeT").css("margin-left","46px");
		$(this).find(".investMiddleP2>label").css("margin-left","1px");
		
	});
	$(".invest_content1").mouseout(function(){
		$(this).find(".investTime").css("padding-left","0px");
		$(this).find(".investTimeP").css("margin-left","15px");
		$(this).find(".investTimeT").css("margin-left","45px");
		$(this).find(".investMiddleP2>label").css("margin-left","0px");
	});
	/* 投资专区部分结束 */
	/* 合作伙伴部分开始 */
	var width;
	var dec;
	var num;
	dec=$(".divMain-divWindow ul").scrollLeft();
	$(".divMain-divWindow ul").eq(1).html($(".divMain-divWindow ul").eq(0).html());
	$(".partL").click(function(){
		width=$(".divMain-divWindow ul li").innerWidth() + 4;
		num=$(".divMain-divWindow ul li").length;
		if(dec <= 0 - num*width/2){
			return false;
		}else{
			dec -= width;
			console.log(dec);
			$(".divMain-divWindow ul").animate({
				left:dec
			},200);
		}
	});
	$(".partR").click(function(){
		width=$(".divMain-divWindow ul li").innerWidth() + 4;
		num=$(".divMain-divWindow ul li").length;
		if(dec==0){
			return false;
		}else{
			dec+=width;
			$(".divMain-divWindow ul").animate({
				left:dec
			},200);
		}
	});
	var timer = setInterval(function(){
		if(dec <= 0 - num*width/2){
			dec = 0;
		}else{
			$(".partL").click();
		}
	},3000);
	/* 合作伙伴部分结束 */
	/*左侧部分开始*/
	$(window).scroll(function() {
	//得到滚动条距离窗口顶部的距离
	var scrollet = $(window).scrollTop();
	//通过scrollet判断返回顶部按钮什么时候显示
	/*$(".asideNewer").click(function(){
		alert(1);
		scrollet=300;
	});*/
	if (scrollet >= 290 ) {
		$(".asideLeft").show();
	}else{
		$(".asideLeft").hide();
	}
	/*新手体验部分开始*/
	if (scrollet >= 450 && scrollet<=750) {
		$(".asideNewer").html("新手"+"<br>"+"体验");
		$(".asideNewer").removeClass("before").addClass("indexAfter");
	} else {
		$(".asideNewer").html("");
		$(".asideNewer").removeClass("indexAfter").addClass("before");
	}
	/*新手体验部分结束*/
	/*投资专区部分开始*/
	if (scrollet >= 751 && scrollet<=1050) {
		$(".asideInvest").html("投资"+"<br>"+"专区");
		$(".asideInvest").removeClass("before").addClass("indexAfter");
	} else {
		$(".asideInvest").html("");
		$(".asideInvest").removeClass("indexAfter").addClass("before");
	}
	/*投资专区部分结束*/
	/*债权转让部分开始*/
	if (scrollet >= 1051 && scrollet<=1700) {
		$(".asideDebet").html("债权"+"<br>"+"转让");
		$(".asideDebet").removeClass("before").addClass("indexAfter");
	} else {
		$(".asideDebet").html("");
		$(".asideDebet").removeClass("indexAfter").addClass("before");
	}
	/*债权转让部分结束*/
	/*新闻动态部分开始*/
	if (scrollet >= 1850 && scrollet<=2200) {
		$(".asideNews").html("新闻"+"<br>"+"动态");
		$(".asideNews").removeClass("before").addClass("indexAfter");
	} else {
		$(".asideNews").html("");
		$(".asideNews").removeClass("indexAfter").addClass("before");
	}
	/*新闻动态部分结束*/
	/*合作伙伴部分开始*/
	if (scrollet >= 2201 && scrollet<=2400) {
		$(".asidePaterner").html("合作"+"<br>"+"伙伴");
		$(".asidePaterner").removeClass("before").addClass("indexAfter");
	} else {
		$(".asidePaterner").html("");
		$(".asidePaterner").removeClass("indexAfter").addClass("before");
	}
	/*if (scrollet >= 2400) {
		$(".asideLeft").hide();
	}*/
	/*合作伙伴部分结束*/
	/*左侧部分结束*/
});
	
});
	/* 王延君 2016-03-27 公告滚动部分开始 */

broadcastScroll= function(){
			var send = 30;
			var data;
			var demo = document.getElementById("demo");
			var indemo = document.getElementById("indemo");
			var demo2 = document.getElementById("demo2");
			demo2.innerHTML = indemo.innerHTML;
			function scroll_left(){
				//判断是否滚动到最左端
				if(demo2.offsetWidth-demo.scrollLeft<=0){
					demo.scrollLeft-=indemo.offsetWidth;
				}else{
					demo.scrollLeft++;
				}
			}
			data = window.setInterval(scroll_left,send);
			demo.onmouseover=function(){
				window.clearInterval(data);
			};
			demo.onmouseout=function(){
				data = window.setInterval(scroll_left,send);
			};
		};
		/*公告滚动部分结束*/	

$(function(){
	
	ttCountDown();
});
/**
 * 倒计时
 */
function ttCountDown() {
	/*var startTimeValue = $.trim($("#startTimeValue").text());
	var endTimeValue = $.trim($("#endTimeValue").text());
    var cServerTt = $("#cServerTt").val();
    var	nowTime = $("#currentDate").val();*/
	var startTimeValue = $.trim("2015-05-10 17:00:00");
	var endTimeValue = $.trim("2016-05-10 17:00:00");
    var date = Date.parse(new Date());//实际操作中使用服务器时间
    var cServerTt = $.trim("2016-04-10 17:00:00");
    //var	nowTime = $("#currentDate").val();
    //开始倒计时
    /*if(startTimeValue != null && startTimeValue != '') {
	    $('#startTimeValue-d').countDown({
	        "startTime":startTimeValue,
	        //"endTime":endTimeValue,
	        "nowTime":cServerTt,
	        "startTips":'',
	        "endTips":''
	    });
    }*/
    //截止倒计时
    if(endTimeValue != null && endTimeValue != '') {
	    $('#endTimeValue-d').countDown({
	        //"startTime":startTimeValue,
	        "endTime":endTimeValue,
	        "nowTime":date,
	        "startTips":'',
	        "endTips":'',
	        /*"timeStamp": false*/
	    });
    }
}
/*倒计时结束*/


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


