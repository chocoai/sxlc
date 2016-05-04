/* 金额千分位控制 */
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
/* 编辑框 */
var pi = UE.getEditor('payguide');
/* 验证 */
$(function(){
	validform5(".nextBtn","modInfo",false,"3");
	validform5(".btn-pre","next_field",false,"3");
});
/* 下一步跳转 */
$(function(){
	$(".nextBtn").click(function(){
		$(".modInfo").hide();
		$(".nextField").show();
	});
	$(".beforeBtn").click(function(){
		$(".nextField").hide();
		$(".modInfo").show();
	});
	$(".appendixUpload").click(function(){
		$(".nextField").hide();
		$(".appendix").show();
	});
	$(".preBack").click(function(){
		$(".appendix").hide();
		$(".nextField").show();
	});
	$(".cancel").click(function(){
		$(".appendix").hide();
		$(".nextField").show();
	});
});
/* 添加红包惊喜标 */
$(function(){
	$(".addRed").click(function(){
		var rs = $(".red_add").html();
		$(".red_list:last-child").append("<li class='red_add'>" +rs + "</li>");
	});
	$(".reduceRed").click(function(){
		if($(".red_list li").length>1){
			$(".red_add:last-child").remove();
		}
	});
});
/* 控制输入为数字   
 * 伍成然
 * 2016-04-29*/
$(function(){
	$(".numberReg").each(function(){
		$(this).focus(function(){
			$(this).keyup(function(){
				if(this.value.length > 0){
					this.value = this.value.replace(/[^0-9]/g,'');
				}
			});
		});
		$(this).change(function(){
			this.value = this.value.replace(/[^0-9.]/g,'');
		});
	});
});
/* checkbox控制输入框不可输入
 * 伍成然
 * 2016-04-29 */
$(function(){
	$(".check_select").click(function(){
		if($('.check_select').is(':checked')){
			$(this).parent().siblings().find("input").attr("disabled",false);
		}else{
			$(this).parent().siblings().find("input").attr("disabled",true);
		}
	});
	$(".check_select2").click(function(){
		if($('.check_select2').is(':checked')){
			$(this).parent().siblings().find("input").attr("disabled",false);
		}else{
			$(this).parent().siblings().find("input").attr("disabled",true);
		}
	});
});
/********选择担保机构********/
function select_mechanism(){
	$(".right_col").load("web/project/pro-add/select_mechanism.jsp");
}
/*********选择资产管理方********/
function select_assetManagement(){
	$(".right_col").load("web/project/pro-add/select_assetManagement.jsp");
}
/*   查看提交认证信息模块             */
$(function(){
	$(".viewDetail").each(function(){
		$(this).click(function(){
			$(this).parent().next("div").slideToggle();
			$(this).parent().parent().siblings().find(".detailAuthen").hide();
		});
	});
});