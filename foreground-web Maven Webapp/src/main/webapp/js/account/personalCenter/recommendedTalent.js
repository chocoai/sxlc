$(function(){
	$(".TB").addClass("down");
	$(".TB11").addClass("down2");
	/*日期选择部分开始 王延君 2016-04-05*/
	$(".chooseTime>span").click(function(){
		$(this).css("color","#72c0f3").siblings("span").css("color","#444444");
	});
	/*日期选择部分结束 王延君 2016-04-05*/
	/*选项卡切换部分开始*/
	$(".recommendedTalentMain1 .ContHeader .awardStatistics").css("border-top","1px solid #72c0f3").css("border-bottom","2px solid #fff");
	$(".recommendedTalentMain2 .ContHeader .historyCashBack").css("border-top","1px solid #72c0f3").css("border-bottom","2px solid #fff");
	$(".recommendedTalentMain3 .ContHeader .inviteRecord").css("border-top","1px solid #72c0f3").css("border-bottom","2px solid #fff");
	$(".recommendedTalentMain4 .ContHeader .LoanDetails").css("border-top","1px solid #72c0f3").css("border-bottom","2px solid #fff");
	$(".recommendedTalentMain5 .ContHeader .investDetails").css("border-top","1px solid #72c0f3").css("border-bottom","2px solid #fff");
	$(".recommendedTalentMain6 .ContHeader .historyPrincipalBack").css("border-top","1px solid #72c0f3").css("border-bottom","2px solid #fff");
	$(".recommendedTalentMain7 .ContHeader .purchaseDetails").css("border-top","1px solid #72c0f3").css("border-bottom","2px solid #fff");
	$(".ContHeader div").each(function(){
		$(this).click(function(){
			var index=$(this).index();
			$(".recommendedTalentMain").eq(index).show().siblings(".recommendedTalentMain").hide();
		});
	});
	/*选项卡切换部分结束*/
	/*em背景切换开始*/
	$(".ContListTitle div em").on("click",function(){
		if($(this).hasClass("iconDown")){
			$(this).removeClass("iconDown").addClass("iconUp");
		}else{
			$(this).removeClass("iconUp").addClass("iconDown");
		}
	});
	/*em背景切换结束*/
	//
	$(".apply").click(function(){
		layer.open({
			title :' ',//标题
			skin: 'layer-ext-myskin',//皮肤
	        type: 1,
	        area: ['540px', '373px'],//大小宽*高
	        shadeClose: true, //点击遮罩关闭
	        content: $('.applyTalent')//内容，里边是包含内容的div的class
	    });
		$('.layui-layer-title').css("border-bottom","none");
	});
});