/** 最新动态 **/

/** 添加最新动态 **/
//验证
$(function () {
	//验证
	validform5("layui-layer-btn0","saveNews",false,"5");
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
	//加密操作
	var encrypt = new JSEncrypt();
    encrypt.setPublicKey(publicKey_common);
    var result1 = encrypt.encrypt((content));
    var result2 = encrypt.encrypt((title));
    $(".layui-layer-btn0").addClass("disabled");
	$.ajax( {  
		url:appPath+"/news/save.do",
		data : {
			content : content, 
			title : result2 
		},
		type:'post',  
		cache:false,  
		success:function(data) { 
			if (data == 1) {
				layer.alert("添加成功",{icon:1});  
				document.getElementById("saveNews").reset();
				$(".layui-layer-btn1").click();
				var table = $('#table_id').DataTable();
				table.ajax.reload();
			}else {
				layer.alert("添加失败",{icon:2});
				document.getElementById("saveNews").reset();
			}
			$(".layui-layer-btn0").removeClass("disabled");
		},
		error : function() {  
			layer.alert("服务器异常",{icon:2});  
		}  
	});
}
/** 修改最新动态 **/
//验证
$(function () {
	//验证
	validform5("layui-layer-btn0","updateNews",false,"3");
	$(".obtn-hotNews-mod").on("click",function(){
		var ue2 = UE.getEditor('meditor');
		var rowdata = $('#table_id').DataTable().rows('.selected').data();
		$("#mtitle").val(rowdata[0].title);
		//加密操作
		var encrypt = new JSEncrypt();
	    encrypt.setPublicKey(publicKey_common);
	    var result1 = encrypt.encrypt((rowdata[0].id + ""));
		$.ajax({
			type : 'post',
			url : appPath + "/news/query4update.do",
			data : {newsId : result1},
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
	var ue2 = UE.getEditor('meditor');
	//获取ueditor内容
	var rowdata = $('#table_id').DataTable().rows('.selected').data();
	var title = $("#mtitle").val();
	var content = ue2.getContent();
	//加密操作
	var encrypt = new JSEncrypt();
    encrypt.setPublicKey(publicKey_common);
    var result1 = encrypt.encrypt((rowdata[0].id)+"");

    var result2 = encrypt.encrypt((title));
    $(".layui-layer-btn0").addClass("disabled");
	$.ajax( {  
		url:appPath+"/news/update.do",
		data : {
			newsId : result1,
			title : result2,
			content : content
		},
		type:'post',  
		cache:false,  
		success:function(data) { 
			if (data == 1) {
				layer.alert("修改成功",{icon:1});  
				document.getElementById("updateNews").reset();
				$(".layui-layer-btn1").click();
				var table = $('#table_id').DataTable();
				table.ajax.reload();
			}else {
				layer.alert("修改失败！",{icon:2});
				document.getElementById("updateNews").reset();
			}
			$(".layui-layer-btn0").removeClass("disabled");
		},
		error : function() {  
			layer.alert("服务器异常",{icon:2});  
		}  
		
	});
}
//启用停用
function ofNews (id,statu) {
	//获取选取对象
	var mess ="确认启用？";
	if(statu == 0){
		var mess ="确认停用？";
	}
	layer.confirm(mess, {
	  btn: ['确定', '取消']
	}, function(index, layero){
	  //确定回掉
	//加密操作
	  var encrypt = new JSEncrypt();
	  var status =statu;
	  encrypt.setPublicKey(publicKey_common);
	  var result1 = encrypt.encrypt(id + "");
	  var result2 = encrypt.encrypt(statu + "");
	  $.ajax({
	  	type : 'post',
	  	url : appPath + "/news/ofOrOpenNews.do",
	  	data : {
			newsId : result1,
			statu : result2
		},
	  	success : function (msg) {
		  	if(status ==1){
		  		if (msg == 1) {
		  			layer.alert("启用成功!",{icon:1});
		  			var table = $('#table_id').DataTable();
					table.ajax.reload();
		  		}else {
		  			layer.alert("启用失败!",{icon:2});
		  		}
		  	}else{
		  		if (msg == 1) {
		  			layer.alert("停用成功!",{icon:1});
		  			var table = $('#table_id').DataTable();
					table.ajax.reload();
		  		}else {
		  			layer.alert("停用失败!",{icon:2});
		  		}
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
            "type":"post",
            "data": function ( d ) {  
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
                  { title:"添加时间","mRender": function (data, type, full) {
                	  var sReturn ="";
                	  if(full.createTime!=null && full.createTime!=""){
                		  var a = full.createTime;
                		  sReturn = a.substring(0,a.length-2);
                	  }
                	  	  return sReturn;
	              	  }
	               },  
                  { title:"标题","data": "title" },  
                  { title:"内容","mRender": function (data, type, full) {
                 		 return "<a onclick=\"openImg(this);\" href=\"javascript:void(0);\">查看详情</a>";
                 	  }
                  },  
                  { title:"最后一次管理员操作","data": "adminName" },
                  { title:"状态","data": "statu", 
                	  "mRender": function (data, type, full) {
                		 if (full.statu==0) {
                			 return "<font color='red'>无效</font>";
                		 }else {
                			 return "有效";
                		 }
                	  } 
                  },  
                  { title:"操作","data": "deptStatu",
                  	"mRender": function (data, type, full) {
                  		 if(full.statu==0){
                  			return "<a onclick=\"ofNews("+full.id+",1);\" href=\"javascript:void(0);\">启用</a>";
                  		 }else{
                  			return "<a onclick=\"ofNews("+full.id+",0);\" href=\"javascript:void(0);\">停用</a>";
                  		 }
                	  } 
                  }
        ],
        aoColumnDefs : [
        				// {"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
        				{
        					sDefaultContent: '',
        					orderable : false,
        					aTargets: [ '_all' ]
        				},
        				{  
                            "aTargets":[1],  
                            "visible":false  
                        }
        				],
        rowCallback:function(row,data){//添加单击事件，改变行的样式      
//        	if($.inArray(data.DT_RowId,selected)!==-1){
//        		$(row).addClass('selected'); 
//        	}
        }
	});
	 $('#table_id tbody').on( 'click', 'tr', function () {
		 var $this = $(this);
			var $checkBox = $this.find("input:checkbox");
			 if ( $(this).hasClass('selected') ) {
				 $checkBox.prop("checked",false);
					$(this).removeClass('selected');
				}
				else {
					$('tr.selected').removeClass('selected');
					$this.siblings().find("input:checkbox").prop("checked",false);
					$checkBox.prop("checked",true);
					$(this).addClass('selected');
				}
			
	  });
});