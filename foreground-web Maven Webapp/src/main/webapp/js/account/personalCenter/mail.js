$(function(){
	$(".TB").addClass("down");
	$(".TB8").addClass("down2");
});
/*  收件箱和发件箱的样式切换代码      */
$(function(){
	$(".th span").each(function(){
		$(this).click(function(){
			var index = $(this).index();
			$(this).addClass("thClick").siblings().removeClass("thClick");
			$(this).parent().parent().children("ul").eq(index).show();
			$(this).parent().parent().children("ul").eq(index).siblings("ul").hide();
			if(index != 0){
				$(this).parent().parent().find(".inbox").hide();
				$(this).parent().parent().find(".senderbox").show();
			}else{
				$(this).parent().parent().find(".inbox").show();
				$(this).parent().parent().find(".senderbox").hide();
			}
		});
	});
});
/* 点击复选框的js代码   */
$(function(){
	$(".selectAll").click(function(){
		if($(this).hasClass("selectAllClick")){
			$(this).removeClass("selectAllClick");
			$(".selectLi").removeClass("selectAllClick");
		}else{
			$(this).addClass("selectAllClick");
			$(".selectLi").addClass("selectAllClick");
		}
	});
});
$(function(){
	var count = $(".selectLi").length;
	var flag = false;
	$(".selectLi").each(function(){
		$(this).click(function(){
			if($(this).hasClass("selectAllClick")){
				$(this).removeClass("selectAllClick");
				flag=false;
			}else{
				$(this).addClass("selectAllClick");
				for(var i=0; i<count; i++){
					if(!$(".selectLi").eq(i).hasClass("selectAllClick")){
						flag=true;
						return false;
					}
				}
			}
			if(!flag){
				$(".selectAll").removeClass("selectAllClick");
			}else{
				$(".selectAll").addClass("selectAllClick");
			}
		});
	});
	$(".read").click(function(){
		if($(".messageBtn").children(".selectLi").has("selectAllClick")){
		}
	});
});
/* 标记为已读和未读的点击事件   */
$(function(){
	var count = $(".selectLi").length;
	$(".unRead").click(function(){
		for(var i=0 ; i<count ;i++){
			if($(".selectLi").eq(i).hasClass("selectAllClick")){
				$(".selectImg").eq(i).addClass("selectImgClick");
			}
		}
		$(this).parent().siblings("input").val("标记为");
	});
	$(".read").click(function(){
		for(var i=0 ; i<count ;i++){
			if($(".selectLi").eq(i).hasClass("selectAllClick")){
				$(".selectImg").eq(i).removeClass("selectImgClick");
			}
		}
		$(this).parent().siblings("input").val("标记为");
	});
});
/* 收件箱详细信息js  */
$(function(){
	$(".replayBtn").click(function(){
		$(this).parent().parent().find(".replayDetail").show();
	});
});


/*  写信息的图片验证     */
$(".phoneCode > .code").focus(function(){
	if($(this).val() == ""){
		$(this).parent().layoutFocus("请输入您的验证码");
		$(this).parent().parent().find(".tipError").remove();
		$(this).parent().parent().find(".tipOk").remove();
	}
});
$(".phoneCode > .code").blur(function(){
	var str = this.value;
	var reg = new RegExp("^[a-zA-Z0-9]{4}$");
	$(this).parent().parent().find(".tip").remove();
	if(reg.test(str)){
		$(this).parent().layoutSuccess();
		$(this).parent().parent().find(".tipError").remove();
	}else{
		$(this).parent().layoutWarning("验证码错误");
		$(this).parent().parent().find(".tipOk").remove();
	}
	$(this).parent().find(".tip").remove();
});