$(function(){
	//bindSlider();//绑定滚动
	getExpertAdvisor();
});

//function
//轮播
function bindSlider(){
	$(".choose3").attr("selected","selected");//Ĭ��ѡ����ʽ ���� 20160327
	/*点击切换部分开始 王延君 2016-03-30*/
	var width = 174;
	var dec;
	var num=$(".divMain-divWindow ul li").length;;
	dec=$(".divMain-divWindow ul").scrollLeft();
	$(".divMain-divWindow ul").css("width",width*num + "px");
	/*$(".divMain-divWindow ul").eq(1).html($(".divMain-divWindow ul").eq(0).html());*/
	$(".expertRightBtn").click(function(){
		//width=$(".divMain-divWindow ul li").innerWidth();
		//num=$(".divMain-divWindow ul li").length;
		if(dec <= 0 - num * width + 1050){
		}else{
			dec -= width;
			console.log(dec);
			$(".divMain-divWindow ul").animate({
				left:dec
			},200);
		}
		if($(".divMain-divWindow li.clicked").next().length > 0){
			$(".divMain-divWindow li.clicked").next().addClass("clicked").siblings().removeClass('clicked');
			publicInner($(".divMain-divWindow li.clicked"));
		}
	});
	$(".expertLeftBtn").click(function(){
		//width=$(".divMain-divWindow ul li").innerWidth();
		//num=$(".divMain-divWindow ul li").length;
		if(dec==0){
		}else{
			dec+=width;
			$(".divMain-divWindow ul").animate({
				left:dec
			},200);
		}
		
		if($(".divMain-divWindow li.clicked").prev().length > 0){
			$(".divMain-divWindow li.clicked").prev().addClass("clicked").siblings().removeClass('clicked');
			publicInner($(".divMain-divWindow li.clicked"));
		}
	});
	/*点击切换部分结束王延君 2016-03-30*/
	$(".divMain-divWindow ul li").first().addClass('clicked');
 /*点击部分begin 黄鑫 2016-03-30*/
	publicInner($(".divMain-divWindow ul li").first());
	$(".divMain-divWindow ul li").each(function(){
		$(this).click(function(){
			$(this).addClass('clicked');
			$(this).siblings().removeClass('clicked');
			publicInner(this);
		});
	});
}
/*点击部分end*/
/*数据传值部分begin*/
function publicInner(obj){
	$('.AdvisorContDetailL').find('img').attr('src',$(obj).find('img').attr('src'));
	$('.AdvisorContDetailR').find('.ContDetailRName').html($(obj).find('.expert').html());
	$('.AdvisorContDetailR').find('.ContDetailRPosition').html('<span></span>'+$(obj).find('.position').html());
	$('.AdvisorContDetailR').find('.AdvisorDetail').html($(obj).find('.dn').html());
}
/*数据传值部分end*/



/*  20160410  胥福星    */
$(function(){
	$(".aboutUsNav input").val($(".choose3").html());
});

//获取专家顾问信息
function getExpertAdvisor(){
	$.ajax({
    	url:"aboutUs/ExpertTeam.html",
    	type:"get",
    	timeout:10000,
    	dataType:"json",
    	success:function(data){
    		var rdb = {};
    		rdb.results = data;
    		if(data.length > 0){
    			var html = template("expertTeamList",rdb);//模板生成 
				$("#expertTeamUl").append(html);//页面赋值
				bindSlider();//绑定轮播展示
    		}else{
    		
    		}
    	},
    	error:function(XMLHttpRequest, textStatus, errorThrown){
        	layer.alert("请求异常，请稍后再试",{icon:2});
		}
    });
}