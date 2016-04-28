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
		
		
		updateMemberMsgIsRead();
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
	});
	/*列表内容部分结束*/
	/*站内消息部分结束 王延君 2016-04-02*/
	loadMessage(0,1);
});
/**
 * 更新未读的消息为已读
 * TODO
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
/**
*未读消息
*/
function loadUnRead(){
	loadMessage(0);
}
/**
*已读消息
*/
function loadRead(){
	loadMessage(1);
}
function loadMessage(type,curr,length){
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
/**
 * 生成html标签，并绑定事件
 * @param type
 * @param s
 */
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

/**
 * 生成html字符串
 * @param obj
 * @param type
 * @param s
 */
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
}