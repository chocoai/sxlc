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
		//选中状态时input的value值为1，相反为0
		if($(this).hasClass("selectAllClick")){
			$(this).next().val("0");
			$(this).removeClass("selectAllClick");
			$(".selectLi").removeClass("selectAllClick");
			$(".selectLi").next().val("0");
		}else{
			$(this).next().val("1");
			$(this).addClass("selectAllClick");
			$(".selectLi").addClass("selectAllClick");
			$(".selectLi").next().val("1");
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
				$(this).next().val("0");
			}else{
				$(this).addClass("selectAllClick");
				$(this).next().val("1");
				for(var i=0; i<count; i++){
					if(!$(".selectLi").eq(i).hasClass("selectAllClick")){
						flag=true;
						return false;
					}
				}
			}
			if(!flag){
				$(".selectAll").removeClass("selectAllClick");
				$(".selectAll").next().val("0");
			}else{
				$(".selectAll").addClass("selectAllClick");
				$(".selectAll").next().val("1");
			}
		});
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


/* 验证     */
$(function(){
	$("#receiveDetail").Validform({
		tiptype:3,//提示信息类型
		btnSubmit:".sentSubmit", //#btn_sub是该表单下要绑定点击提交表单事件的按钮;如果form内含有submit按钮该参数可省略;
		//btnReset:"#btnreset1",
		datatype:extdatatype,//扩展验证类型
		//showAllError:true,//提交前验证显示所有错误
		ajaxPost:{//使用ajax提交时
			url:"http://182.150.178.88:8031/GEB_P2P_Foreqround/selectmemberProvince.action",
			datatype:"jsonp",
			success:function(data,obj){
	            //data是返回的json数据;
	            //obj是当前表单的jquery对象;
	        },
	        error:function(data,obj){
	            //data是{ status:**, statusText:**, readyState:**, responseText:** };
	            //obj是当前表单的jquery对象;
	            //console.log(data.status);
	        }
		}
	});
});