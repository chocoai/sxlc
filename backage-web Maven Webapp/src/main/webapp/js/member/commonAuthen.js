/* 公用同一个页面的资料认证的点击惦记切换事件         */
$(function(){
	$(".commonAuthen").click(function(){
		$(this).addClass("active").siblings(".commonAuthen").removeClass("active");
	});
});