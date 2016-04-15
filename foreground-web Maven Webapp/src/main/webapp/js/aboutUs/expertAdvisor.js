$(function(){
	$(".choose3").attr("selected","selected");//Ĭ��ѡ����ʽ ���� 20160327
	/*点击切换部分开始 王延君 2016-03-30*/
	var width;
	var dec;
	var num;
	dec=$(".divMain-divWindow ul").scrollLeft();
	/*$(".divMain-divWindow ul").eq(1).html($(".divMain-divWindow ul").eq(0).html());*/
	$(".expertLeftBtn").click(function(){
		width=$(".divMain-divWindow ul li").innerWidth();
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
	$(".expertRightBtn").click(function(){
		width=$(".divMain-divWindow ul li").innerWidth();
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
	/*点击切换部分结束王延君 2016-03-30*/
});
 /*点击部分begin 黄鑫 2016-03-30*/
$(function(){
	publicInner($(".divMain-divWindow ul li").first());
	$(".divMain-divWindow ul li").each(function(){
		$(this).click(function(){
			$(this).addClass('clicked');
			$(this).siblings().removeClass('clicked');
			publicInner(this);
		});
	});
});
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