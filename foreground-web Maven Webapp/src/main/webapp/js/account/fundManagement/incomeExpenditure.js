$(function(){
	$(".TC").addClass("down");
	$(".TC3").addClass("down2");
});


$(function(){
	/*李丽梅*/
	/*2016-4-1*/
	/*收支明细-充值记录、提现记录、交易记录-tab切换*/
	$(".iEDHead li").each(function(index){
		var liNode =$(this);
		$(this).click(function(){
			$(".iEDtabContent .iEDContent").removeClass("iEDcontentActive");
			$(".iEDHead li").removeClass("iEDHeadIng");
			$(".iEDtabContent .iEDContent").eq(index).addClass("iEDcontentActive");
			liNode.addClass("iEDHeadIng");
		});
	});
});


/*李丽梅*/
/*2016-4-1*/
/*收支明细-交易记录-切换*/
$(function(){
	$(".awardTabRegister").each(function(){
		$(this).click(function(){
			if($(this).parent().find(".iEDTrecordInfo").is(":hidden")){
				$(this).parent().find(".iEDTrecordInfo").show();
				$(this).parent().siblings().find(".iEDTrecordInfo").hide();
			}else{
				$(this).parent().find(".iEDTrecordInfo").hide();
				
			}
			if($(this).hasClass("awardTabDow")){
				$(this).removeClass("awardTabDow");
			}else{
				$(this).addClass("awardTabDow");
				$(this).parent().siblings().find(".awardTabRegister").removeClass("awardTabDow");
			}
		});
	});
});


/*日期选择控件（比如今天,一周时间 ,6个月选项）*/
/*李丽梅*/
/*2016-4-8*/

$(function(){
	$(".iEDDiv em").on("click",function(){
		if($(this).hasClass("active")){
			$(this).removeClass("active");
		}else{
			$(this).addClass("active").siblings(".iEDDiv em").removeClass("active");
		}
	});
});
/*点击  充值  跳转到  我要充值*/
/*李丽梅*/
/*2016-4-12*/
$(function(){
	$(".iEDContentHeadC").click(function(){
		window.location.href="recharge.html";
	});
});
