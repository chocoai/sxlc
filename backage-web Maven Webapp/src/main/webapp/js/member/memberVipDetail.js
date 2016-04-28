/*  对会员详情进行显示控制         */
$(function(){
	switch(_index.m3){
		case '20101':
			$(".vipRange").addClass("hide");
			break;
		case '20102':
			$(".thirdInformation,.cerfiedRange,.creditRange,.investRange").addClass("hide");
			break;
		case '20103':
			$(".vipRange,.thirdInformation,.cerfiedRange,.creditRange,.investRange").addClass("hide");
			break;
		case '20104':
			$(".vipRange,.creditRange,.investRange").addClass("hide");
			break;
		case '20105':
			$(".vipRange,.investRange").addClass("hide");
			break;
		case '20106':
			$(".vipRange,.cerfiedRange,.creditRange").addClass("hide");
			break;
		case '20107':
			$(".vipRange").addClass("hide");
			break;
		case '20108':
			$(".vipRange").addClass("hide");
			break;
	}
});





/*   查看提交认证信息模块             */
$(function(){
	$(".viewDetail").each(function(){
		$(this).click(function(){
			$(this).parent().next("div").slideToggle();
			$(this).parent().parent().siblings().find(".detailAuthen").hide();
		});
	});
});
