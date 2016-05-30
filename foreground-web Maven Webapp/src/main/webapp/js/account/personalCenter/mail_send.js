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
			$(".selectLi").removeClass("selectClick");
			$(".selectLi").next().val("0");
		}else{
			$(this).next().val("1");
			$(this).addClass("selectAllClick");
			$(".selectLi").addClass("selectClick");
			$(".selectLi").next().val("1");
		}
	});
});
$(function(){
	
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

$(function(){
	var mail_send = {
			//读取收件箱列表
			loadSendLetterList:function(cpage,pageSize){
				var data = {};
				data.start=cpage;
				var encrypt = new JSEncrypt();
				encrypt.setPublicKey(publickey);
				
				data.Read_Statu =encrypt.encrypt(0+"");
				var url = "message/loadSendLetterList.html";
				
				NetUtil.ajax(
						url,
						data,
						function(r){
							$("#send_list_ul").children().remove();
							var data = JSON.parse(r);
							if (data.totalPage>0){
								var html = template("send_list",data);
								$("#send_list_ul").html(html);
								mail_send.bind();//绑定点击事件
								var totalPage = Math.ceil(data.recordsTotal/data.pageSize);
								var totalRecords = data.recordsTotal;
								var pageNo = data.pageNum;
								$("#pager1").html("");
								pager1.generPageHtml({
									pno : pageNo,
									//总页码
									total : totalPage,
									//总数据条数
									totalRecords : totalRecords,
									mode : 'click',//默认值是link，可选link或者click
									click : function(n) {
										mail_send.loadSendLetterList(n);
										this.selectPage(n);
										return false;
									}
								});
							}
						}
				);
			},
			bind:function(){
				var count = $(".selectLi").length;
				var flag = true;//false不全选  true 全选
				$(".selectLi").each(function(){
					$(this).click(function(){
						flag=true;
						if($(this).hasClass("selectClick")){//取消选中
							$(this).removeClass("selectClick");
							flag=false;
							$(this).next().val("0");
						}else{//选中
							$(this).addClass("selectClick");
							$(this).next().val("1");
							for(var i=0; i<count; i++){
								if(!$(".selectLi").eq(i).hasClass("selectClick")){
									flag=false;
									//return false;
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
			},
			//批量删除已收到的站内信
			deleteSendMail:function(letterIds){
				var data = {};
				var encrypt = new JSEncrypt();
				encrypt.setPublicKey(publickey);
				
				data.letterIds =encrypt.encrypt(letterIds+"");
				var url = "message/deleteSendStationLetter.html";
				NetUtil.ajax(
						url,
						data,
						function(r){
							var data = JSON.parse(r);
							if(data.statu>0){
								layer.alert("删除成功");
								mail_send.loadSendLetterList(1);
							}
						}
				);
			}
	};
	mail_send.loadSendLetterList(1);
	$(".delete").on("click",function(){
		var arr = [];
		$(".selectClick").each(function(i){
			arr[i] = $(this).attr("letterId");
		});
		if($(".selectClick").length>0){
			var letterIds = arr.join(",");
			mail_send.deleteSendMail(letterIds);
		}else{
			layer.alert("请选择需要操作的站内信");
		}
	});
});
