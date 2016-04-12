/** 最新动态 **/

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
/** 添加最新动态 **/
//验证
$(function () {
	var appPath = getRootPath();//项目根路径
	//验证
	validform5("layui-layer-btn0","saveNews",true,"3");
	$(".obtn-hotNews-add").on("click touchstart",function(){
		//初始化
		var ue1 = UE.getEditor('editor');
		layer.open({
		    type: 1,
		    area: ['1100px', '600px'], //高宽
		    title: "添加最新动态",
		    content: $(".pic-add"),//DOM或内容
		    btn:['确定', '取消']
			  ,yes: function(index, layero){ //或者使用btn1
			    //确定的回调
			  	$("#saveNews").submit();
			  	
			  },cancel: function(index){//或者使用btn2（concel）
			  	//取消的回调
			  }
		});
	});
	
}); 
//添加方法
function addNews() {
	var appPath = getRootPath();//项目根路径
	//获取ueditor内容
	var ue1 = UE.getEditor('editor');
	var content = ue1.getContent();
	
	var title = $("#title").val();
	$.ajax( {  
		url:appPath+"/news/save.do",
		data:"title=" + title + "&content=" + content,
		type:'post',  
		cache:false,  
		success:function(data) { 
			if (data == 1) {
				layer.alert("添加成功",{icon:1});  
				document.getElementById("saveNews").reset();
				setTimeout('location.reload()',2000);
			}else {
				layer.alert("服务器异常",{icon:2});
				document.getElementById("saveNews").reset();
			}
		}
		
	});
}
/** 修改最新动态 **/
//验证
$(function () {
	var appPath = getRootPath();//项目根路径
	//验证
	validform5("layui-layer-btn0","updateNews",true,"3");
	$(".obtn-hotNews-mod").on("click",function(){
		var ue2 = UE.getEditor('meditor');
		var rowdata = $('#table_id').DataTable().rows('.selected').data();
		$("#mtitle").val(rowdata[0].title);
		$.ajax({
			type : 'post',
			url : appPath + "/news/query4update.do",
			data : "newsId=" + rowdata[0].id,
			success : function (msg) {
				ue2.addListener("ready", function () {
	        	// editor准备好之后才可以使用
	        	ue2.setContent(msg.content);
		 
		        });
			}
		}); 
		
		layer.open({
		    type: 1,
		    area: ['1100px', '600px'], //高宽
		    title: "修改网站公告",
		    content: $(".pic-mod"),//DOM或内容
		    btn:['确定', '取消']
			  ,yes: function(index, layero){ //或者使用btn1
			    //确定的回调
			  	$("#updateNews").submit();
			  	
			  },cancel: function(index){//或者使用btn2（concel）
			  	//取消的回调
			  }
		});
		
		
	});
});

//修改方法
function modNews () {
	var appPath = getRootPath();//项目根路径
	var ue2 = UE.getEditor('meditor');
	//获取ueditor内容
	var rowdata = $('#table_id').DataTable().rows('.selected').data();
	var title = $("#mtitle").val();
	var content = ue2.getContent();
	$.ajax( {  
		url:appPath+"/news/update.do",
		data:"title=" + title + "&content=" + content + "&newsId=" + rowdata[0].id,
		type:'post',  
		cache:false,  
		success:function(data) { 
			if (data == 1) {
				layer.alert("修改成功",{icon:1});  
				document.getElementById("updateNews").reset();
				setTimeout('location.reload()',2000);
			}else {
				layer.alert("服务器异常",{icon:2});
				document.getElementById("updateNews").reset();
			}
		}
		
	});
}
/** 启用/停用动态 **/
//启用
function openNews () {
	var appPath = getRootPath();//项目根路径
	//获取选取对象
	layer.confirm('确定启用？', {
	  btn: ['确定', '取消']
	}, function(index, layero){
	  //确定回掉
	  var rowdata = $('#table_id').DataTable().rows('.selected').data();
	  $.ajax({
	  	type : 'post',
	  	url : appPath + "/news/ofOrOpenNews.do",
	  	data : "newsId=" + rowdata[0].id + "&statu=" + rowdata[0].statu,
	  	success : function (msg) {
	  		if (msg == 1) {
	  			layer.alert("操作成功!",{icon:1});
	  			setTimeout('location.reload()',2000);
	  		}else {
	  			layer.alert("操作失败!",{icon:2});
	  		}
	  	}
	  });
		
		//执行完关闭
	  	layer.close(index);
	}, function(index){
	  //按钮【按钮二】的回调
	});
}
//停用
function ofNews () {
	var appPath = getRootPath();//项目根路径
	//获取选取对象
	layer.confirm('确定停用？', {
	  btn: ['确定', '取消']
	}, function(index, layero){
	  //确定回掉
	  var rowdata = $('#table_id').DataTable().rows('.selected').data();
	  $.ajax({
	  	type : 'post',
	  	url : appPath + "/news/ofOrOpenNews.do",
	  	data : "newsId=" + rowdata[0].id + "&statu=" + rowdata[0].statu,
	  	success : function (msg) {
	  		if (msg == 1) {
	  			layer.alert("操作成功!",{icon:1});
	  			setTimeout('location.reload()',2000);
	  		}else {
	  			layer.alert("操作失败!",{icon:2});
	  		}
	  	}
	  });
		
		//执行完关闭
	  	layer.close(index);
	}, function(index){
	  //按钮【按钮二】的回调
	});
}

/**
 * 查看详情
 */
function openImg(btn){
	$(".report-det").html("");//清空数据
	var data = $('#table_id').DataTable().row($(btn).parents('tr')).data();
	$(".report-det").html(data.content);
	
	layer.open({
	    type: 1,
	    area: ['800px', '600px'], //高宽
	    title: "查看详情",
	    maxmin: true,
	    content: $(".report-det"),//DOM或内容
	    btn:['关闭']
		  ,cancel: function(index){//或者使用btn2（concel）
		  }
	});

}
$(function() {
	var appPath = getRootPath();//项目根路径
	$('#table_id').DataTable(
	{
		autoWidth : false,
		scrollY : 500,
		pagingType: "simple_numbers",//设置分页控件的模式  
		// paging : false,//分页
//		searching : false,
//		info : false,// 左下角信息
//		ordering: false,//排序
		lengthMenu:[[5,10,25,50,-1],[5,10,25,50,"全部"]],
//		aaSorting : [ [ 16, "desc" ] ],// 默认第几个排序
		colReorder : false,
		scrollX : true,
		sScrollX : "100%",
		sScrollXInner : "100%",
		bScrollCollapse : true,  
		processing: true, //打开数据加载时的等待效果  
        serverSide: true,//打开后台分页  
        ajax: {  
            "url": appPath + "/news/list.do",   
            "dataSrc": "results", 
            "data": function ( d ) {  
                var level1 = $('#level1').val();  
                //添加额外的参数传给服务器  
                d.extra_search = level1;
            } 
        },
        columns: [  
                  {title:'<input type="checkbox" class="table-checkbox"  value="1" />',
                	  "mRender": function (data, type, full) {
                		  sReturn = '<input type="checkbox" value="1" />';
                		  return sReturn;
                	  }
//                	  "sClass": "table-checkbox"
                  },
                  { title:"最新动态id","data": "id" },
                  { title:"添加时间","data": "createTime" },
                  { title:"标题","data": "title" },  
                  { title:"内容","data": "content",
                	  "mRender": function (data, type, full) {
                 		 return "<a onclick=\"openImg(this);\" href=\"javascript:void(0);\">查看详情</a>";
                 	  }
                  },  
                  { title:"状态","data": "statu", 
                	  "mRender": function (data, type, full) {
                		 if (data == 0) {
                			 return "<font color='red'>无效</font>";
                		 }else if (data == 1){
                			 return "有效";
                		 }
                	  } 
                  },  
                  { title:"最后一次管理员操作","data": "adminName" },  
                  { title:"操作","data": "deptStatu",
                  	"mRender": function (data, type, full) {
                		  return "<a onclick=\"openNews();\" href=\"javascript:void(0);\">启用</a>" + "<a onclick=\"ofNews();\" href=\"javascript:void(0);\">停用</a>";
                	  } 
                  }
        ],
        aoColumnDefs : [
        				// {"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
        				{
        					sDefaultContent: '',
        					orderable : false,
        					aTargets: [ '_all' ]
        				}
        				],
        rowCallback:function(row,data){//添加单击事件，改变行的样式      
//        	if($.inArray(data.DT_RowId,selected)!==-1){
//        		$(row).addClass('selected'); 
//        	}
        }
});
 var table = $('#table_id').DataTable();
//设置选中change颜色
 $('#table_id tbody').on( 'click', 'tr', function () {
        $(this).toggleClass('selected');
  });
});