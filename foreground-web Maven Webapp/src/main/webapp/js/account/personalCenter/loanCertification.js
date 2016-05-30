$(function(){
	$(".TB").addClass("down");
	$(".TB7").addClass("down2");
});
/*  个人认证和企业认证的样式切换代码      */
$(function(){
	$(".th span").each(function(){
		$(this).click(function(){
			var index = $(this).index();
			$(this).addClass("thClick").siblings().removeClass("thClick");
			$(this).parent().parent().children("ul").eq(index).show();
			$(this).parent().parent().children("ul").eq(index).siblings("ul").hide();
		});
	});
});
/*   end     */

/*      婚姻认证的切换             */
$(function(){
	$(".radioLabel").each(function(){
		$(this).click(function(){
			$(this).addClass("checked").siblings(".radioLabel").removeClass("checked");
			$(this).prev().attr("checked",true);
			$(this).siblings(".radioLabel").prev().attr("checked",false);
		});
	});
});
/*         end           */
/*  已认证、未认证等显示的链接页面不一的代码         */
$(function(){
	$(".tdSpan").each(function(){
		if($(this).html().match("已认证") || $(this).html().match("已审核") || $(this).html().match("已通过")){
			$(this).addClass("tdAuthen");
		}else if($(this).html().match("审核中")){
			$(this).addClass("tdReview");
		}else if($(this).html().match("未通过")){
			$(this).addClass("tdFile");
		}else if($(this).html().match("已过期")){
			$(this).addClass("tdOutOfDate");
		}else if($(this).html().match("未认证")){
			$(this).addClass("tdUnauth");
		}
		if($(this).html().match("已认证") || $(this).html().match("已过期") || $(this).html().match("未通过")||$(this).html().match("已打回")){
			$(this).parent().find(".linkCheck").show();
		}else if($(this).html().match("审核中")){
			$(this).parent().find(".linkAlert").show();
		}else if($(this).html().match("未认证")){
			$(this).parent().find(".linkAuthen").show();
		}
	});
	
});
/*   end    */
/* 添加认证      */
$(function(){
	var content = $(".addAuthen").parent().next().html();
	var index = $(".cloneDiv").size();
	var cloneId = "clone"+index;
	var oldIndex = "file"+(index-1);
	var newIndex = "file"+index;
	content = "<div class='cloneDiv' "+"id='"+cloneId+"'>" + content + "</div>";
	$(".addAuthen").on("click",function(){
		$(this).parent().parent().append(content);
		inputText(".cloneDiv:last");
		checkCAR();
		$("#"+cloneId).find(".file").removeClass(oldIndex).addClass(newIndex);
		expMoreUpload("."+newIndex);
	});
});

function scale(obj){
	if(!$(obj).hasClass("authenScaleClick")){
		$(obj).addClass("authenScaleClick").removeClass("authenScaleBtn");
		$(obj).parent().parent().find(".inputArea").hide();
	}else{
		$(obj).removeClass("authenScaleClick").addClass("authenScaleBtn");
		$(obj).parent().parent().find(".inputArea").show();
	}
}




