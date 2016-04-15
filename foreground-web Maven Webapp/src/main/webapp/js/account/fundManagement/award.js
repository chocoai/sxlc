$(function(){
	$(".TC").addClass("down");
	$(".TC4").addClass("down2");
});
/*李丽梅*/
/*资金管理-我的红包*/
/*2016-3-31*/
/*我的红包、我的电子劵方法*/
$(function(){
	/*李丽梅*/
	/*我的红包、电子劵*/
	$(".awardHead li").each(function(index){
		var liNode =$(this);
		$(this).click(function(){
			$(".tabContent .awardContent").removeClass("contentActive");
			$(".awardHead li").removeClass("awardIng");
			$(".tabContent .awardContent").eq(index).addClass("contentActive");
			liNode.addClass("awardIng");
		});
	});
	
	/*李丽梅*/
	/*代金劵获取、记录修改*/
	$(".awardBtn li").each(function(index){
		var liNode =$(this);
		$(this).click(function(){
			$(".awardtabContent .awardContenta").removeClass("contentActivea");
			$(".awardBtn li").removeClass("awardBtnIng");
			$(".awardtabContent .awardContenta").eq(index).addClass("contentActivea");
			liNode.addClass("awardBtnIng");
		});
	});
});
