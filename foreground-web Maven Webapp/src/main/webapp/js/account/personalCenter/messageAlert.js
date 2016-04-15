$(function(){
	$(".TB").addClass("down");
	$(".TB10").addClass("down2");
	/*点击切换背景图片部分开始 王延君 2016-04-02*/
	$(".messageAlertMCont label").click(function(){
		if($(this).hasClass("labelUnSelect")){
			$(this).removeClass("labelUnSelect");
			$(this).addClass("labelSelect");
		}else{
			$(this).removeClass("labelSelect");
			$(this).addClass("labelUnSelect");
		}
	});
	/*点击切换背景图片部分结束*/
});