
/**
 * 更新未读的消息为已读
 */
function updateMemberMsgIsRead(){
	
}

//获取项目根目录全路径
function getRootPath(){
        var curWwwPath=window.document.location.href;
        var pathName=window.document.location.pathname;
        var pos=curWwwPath.indexOf(pathName);
        var localhostPath=curWwwPath.substring(0,pos);
        var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
		if(/127.0.0.1|localhost/.test(localhostPath)){
			return(localhostPath+projectName);
		}else{
			return(localhostPath);
		}
}

$(function(){
	$(".TB").addClass("down");
	$(".TB9").addClass("down2");
	/*站内消息部分开始 王延君 2016-04-02*/
	/*列表内容部分开始*/
	$(".readUl").hide();
	$(".unRead").css("color","#45a7e6").siblings().css("color","#000");
	$(".unRead").css("border-bottom","2px solid #45a7e6").siblings().css("border-bottom","0");
	
	$(".stationMessageH>div").on("click",function(){
		var index=$(this).index();
		$(this).css("color","#45a7e6").siblings().css("color","#000");
		$(this).css("border-bottom","2px solid #45a7e6").siblings().css("border-bottom","0");
		$(".stationMessageM ul").eq(index).show().siblings("ul").hide();
	});
	
	var stationMessage = {
			loadUnReadMessage:function(cpage,pageSize){
				var data = {};
				data.start=cpage;
				var encrypt = new JSEncrypt();
				encrypt.setPublicKey(publickey);
				
				data.Read_Statu =encrypt.encrypt(0+"");
				var url = "message/loadStationMessageList.html";
				
				NetUtil.ajax(
						url,
						data,
						function(r){
							var data = JSON.parse(r);
							if (data.totalPage>0){
								console.log(data.results);
								var html = template("unRead_list",data);
								$("#unRead_list_top").siblings().remove();
								$("#unRead_list_ul").append(html);
								stationMessage.bind();
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
										stationMessage.loadUnReadMessage(n);
										this.selectPage(n);
										return false;
									}
								});
							}
						}
				);
			},
			loadReadMessage:function(cpage,pageSize){
				var data = {};
				data.start=cpage;
				var encrypt = new JSEncrypt();
				encrypt.setPublicKey(publickey);
				
				data.Read_Statu =encrypt.encrypt(1+"");
				var url = "message/loadStationMessageList.html";
				
				NetUtil.ajax(
						url,
						data,
						function(r){
							var data = JSON.parse(r);
							if (data.totalPage>0){
								console.log(data.results);
								var html = template("read_list",data);
								$("#read_list_top").siblings().remove();
								$("#read_list_ul").append(html);
								stationMessage.bind();
								var totalPage = Math.ceil(data.recordsTotal/data.pageSize);
								var totalRecords = data.recordsTotal;
								var pageNo = data.pageNum;
								$("#pager2").html("");
								pager2.generPageHtml({
									pno : pageNo,
									//总页码
									total : totalPage,
									//总数据条数
									totalRecords : totalRecords,
									mode : 'click',//默认值是link，可选link或者click
									click : function(n) {
										stationMessage.loadReadMessage(n);
										this.selectPage(n);
										return false;
									}
								});
							}
						}
				);
			},
			bind:function(){
				//站内信息 展开 收起事件
				$(".contentInfo").hide();
				$("li .contentMessage").each(function(){
					$(this).unbind("click");
					$(this).on("click",function(){
						if($(this).parent().find(".contentInfo").is(":hidden")){
							//展开
							$(this).find(".messageContent").css("color","#87412C");
							$(this).parent().find(".contentInfo").slideDown();
							$(this).parent().parent().siblings("li").each(function(){
								$(this).find(".contentInfo").slideUp();
							});
							if($(this).attr("readType")==0){
								//设为已读
								var date = $(this).find(".recordTime").html();
								stationMessage.updateMemberMsgIsRead(date);
								$(this).find(".state").html("已读");
							}
						}else{
							//收起
							$(this).parent().find(".contentInfo").slideUp();
					    }
					});
				});
			},
			updateMemberMsgIsRead:function(date){
				var data={};
				var encrypt = new JSEncrypt();
				encrypt.setPublicKey(publickey);
				if(date!=null&&date!=undefined){
					data.recordDate=encrypt.encrypt(date+"");
				}
				var url = "message/updateMemberMsgIsRead.html";
				
				NetUtil.ajax(
					url,
					data,
					function(r){
					}
				)
			}
	};
	stationMessage.loadUnReadMessage();
	/**
	*未读消息
	*/
	$("#unReadMessage").on("click",function(){
		stationMessage.loadUnReadMessage();
	});
	/**
	*已读消息
	*/
	$("#readMessage").on("click",function(){
		stationMessage.loadReadMessage();
	});
	
	$(".stationMessageH>div").on("click",function(){
		var index=$(this).index();
		$(this).css("color","#45a7e6").siblings().css("color","#000");
		$(this).css("border-bottom","2px solid #45a7e6").siblings().css("border-bottom","0");
		$(".stationMessageM ul").eq(index).show().siblings("ul").hide();
		
	});
	$(".contentInfo").hide();
	$("li .contentMessage").each(function(){
		$(this).on("click",function(){
			if($(this).parent().find(".contentInfo").is(":hidden")){
				$(this).find(".messageContent").css("color","#87412C");
				$(this).parent().find(".contentInfo").slideDown();
				$(this).parent().parent().siblings("li").each(function(){
					$(this).find(".contentInfo").slideUp();
				});
			}else{
				$(this).parent().find(".contentInfo").slideUp();
		    }
		});
		stationMessage.updateMemberMsgIsRead();
	});
	/*列表内容部分结束*/
	/*站内消息部分结束 王延君 2016-04-02*/
});

/*function loadMessage(type,curr,length){
	var appPath = getRootPath();//项目根路径
	
	$.ajax({
		url:"message/loadStationMessageList.html",
		data:{"Read_Statu":type,"start":1,"length":10},
		type:"get",
		dataType:"json",
		success:function(data){
			var s="";
			list = data.results;
			for(var i=0;i<list.length;i++){
				var obj = list[i];
				s = appendUL(obj,type,s);
				
			}
			creatHtml(type,s);
		},
		error:function(){
			var obj;
			var s="";
			obj = {"msgDetail":"123123","recordDate":"2016-04-24 10:13:22"};
			s = appendUL(obj,type,s);
			creatHtml(type,s);
		}
	});
}
*//**
 * 生成html标签，并绑定事件
 * @param type
 * @param s
 *//*
function creatHtml(type,s){
	$(".readList").remove();
	if(type==0){
		$("#pager1").before(s);
	}else{
		$("#pager2").before(s);
	}
	$(".stationMessageH>div").unbind("click");
	$(".stationMessageH>div").on("click",function(){
		var index=$(this).index();
		$(this).css("color","#45a7e6").siblings().css("color","#000");
		$(this).css("border-bottom","2px solid #45a7e6").siblings().css("border-bottom","0");
		$(".stationMessageM ul").eq(index).show().siblings("ul").hide();
	});
	$(".contentInfo").hide();
	$("li .contentMessage").each(function(){
		$(this).unbind("click");
		$(this).on("click",function(){
			if($(this).parent().find(".contentInfo").is(":hidden")){
				$(this).find(".messageContent").css("color","#87412C");
				$(this).parent().find(".contentInfo").slideDown();
				$(this).parent().parent().siblings("li").each(function(){
					$(this).find(".contentInfo").slideUp();
				});
			}else{
				$(this).parent().find(".contentInfo").slideUp();
		    }
		});
	});
}

*//**
 * 生成html字符串
 * @param obj
 * @param type
 * @param s
 *//*
function appendUL(obj,type,s){
	//var Record_Date = obj.recordDate;
	var title = (obj.msgDetail+"").substring(0,15);
	if(type==0){
		s=s+"<li class='readList'>"+
		"<div class='myInvestmentMCont' onselectstart='return false'>"+
			"<div class='contentMessage'>"+
				"<div class='messageContent'>"+
					"<label></label>"+title+
				"</div>"+
				"<div class='recordTime'>"+obj.recordDate+"</div>"+
				"<div class='state'>未读</div>"+
			"</div>"+
			"<div class='contentInfo' style='display:none'>"+
			"<label></label>"+
			"<div class='contentInfoM'>"+
					obj.msgDetail+
			"</div>"+
		"</div>"+
		"</div>"+
	"</li>";
	}else{
		s =s+ "<li class='readList'>"+
		"<div class='myInvestmentMCont' onselectstart='return false'>"+
			"<div class='contentMessage'>"+
				"<div class='messageContent'>"+
					title+
				"</div>"+
				"<div class='recordTime'>"+obj.recordDate+"</div>"+
				"<div class='state'>已读</div>"+
			"</div>"+
			"<div class='contentInfo'>"+
				"<label></label>"+
				"<div class='contentInfoM'>"+
					obj.msgDetail+
				"</div>"+
			"</div>"+
		"</div>"+
	"</li>";
	}
	return s;
}*/