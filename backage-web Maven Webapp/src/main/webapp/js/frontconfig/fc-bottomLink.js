//加密设置
var bootType = "";
var mbootType = "";
var encrypt = new JSEncrypt();
encrypt.setPublicKey(publicKey_common);


function openLink() {
	layer.confirm('确定启用？', {
		btn: ['确定', '取消']
	}, function(index, layero){
		//按钮【按钮一】的回调
		var rowdata = $('#bottomnavtable').DataTable().rows('.selected').data();
		var result1 = encrypt.encrypt((rowdata[0].id + ""));
		var result2 = encrypt.encrypt((rowdata[0].statu + ""));
		  $.ajax({
			  	type : 'post',
			  	url : appPath + "/bootLink/ofOrOpen.do",
			  	data : {
			  		bootId : result1, 
			  		statu : result2
				},
			  	success : function (msg) {
			  		if (msg == 1) {
			  			layer.alert("操作成功!",{icon:1});
			  			setTimeout('location.reload()',2000);
			  		}else {
			  			layer.alert("操作失败!",{icon:2});  
			  		}
			  	}
			});
		layer.close(index);
	}, function(index){
		//按钮【按钮二】的回调
	});
	
}

function ofLink() {
	layer.confirm('确定停用？', {
		btn: ['确定', '取消']
	}, function(index, layero){
		//按钮【按钮一】的回调
		var rowdata = $('#bottomnavtable').DataTable().rows('.selected').data();
		var result1 = encrypt.encrypt((rowdata[0].id + ""));
		var result2 = encrypt.encrypt((rowdata[0].statu + ""));
		  $.ajax({
			  	type : 'post',
			  	url : appPath + "/bootLink/ofOrOpen.do",
			  	data : {
			  		bootId : result1, 
			  		statu : result2
				},
			  	success : function (msg) {
			  		if (msg == 1) {
			  			layer.alert("操作成功!",{icon:1});
			  			setTimeout('location.reload()',2000);
			  		}else {
			  			layer.alert("操作失败!",{icon:2});  
			  		}
			  	}
			});
		layer.close(index);
	}, function(index){
		//按钮【按钮二】的回调
	});
	
}

/** 添加导航 **/ 
function addNavigation(){
	//查询导航类型
	$.ajax({
		type : 'post',
	  	url : appPath + "/bootLink/query4type.do",
	  	success : function (msg) {
	  		var str = "";
	  		$.each(msg, function (i,item) {
	  			str += "<input type=\"radio\" onclick=\"checkId(this)\" name=\"species\" value=\""+item.id+"\"/><label>"+item.name+"</label>";
	  		});
	  		$("#bootType").html(str);
	  	}
	});
	layer.open({
	    type: 1,
	    area: ['450px', '300px'], //高宽
	    title: "导航内容添加",
	    maxmin: true,
	    content: $("#bottomnav-add"),//DOM或内容
	    btn:['确定', '取消']
		  ,yes: function(index, layero){ //或者使用btn1
		    //确定的回调
		  	$("#saveBoot").submit();
		  	
		  },cancel: function(index){//或者使用btn2（concel）
		  	//取消的回调
		  }
	});
}
//添加方法
function addBoot () {
	var title = $("#stitle").val();
	var url = $("#surl").val();
	//加密操作
    encrypt.setPublicKey(publicKey_common);
    title = encrypt.encrypt(title);
    url = encrypt.encrypt(url);
    bootType = encrypt.encrypt(bootType + "")
	$.ajax({
		type : 'post',
		url : appPath + "/bootLink/save.do",
		data : {
			title : title,
			typeId : bootType,
			url : url
		},
		success : function(msg) {
			if (msg == 1) {
	  			layer.alert("操作成功!",{icon:1});
	  			setTimeout('location.reload()',2000);
	  		}else {
	  			layer.alert("操作失败!",{icon:2});  
	  		}
		}
	});
}

function checkId(u) {
	bootType = $(u).val();
}

function mcheckId(u) {
	mbootType = $(u).val();
}
//修改
function modNavigation(){
	var rowdata = $('#bottomnavtable').DataTable().rows('.selected').data();
	$("#mtitle").val(rowdata[0].title);
	$("#murl").val(rowdata[0].url);
	//查询导航类型
	$.ajax({
		type : 'post',
	  	url : appPath + "/bootLink/query4type.do",
	  	success : function (msg) {
	  		var str = "";
	  		$.each(msg, function (i,item) {
	  			if (item.name == rowdata[0].name) {
	  				str += "<input type=\"radio\" checked=\"checked\" onclick=\"mcheckId(this)\" name=\"species\" value=\""+item.id+"\"/><label>"+item.name+"</label>";
	  				mbootType = item.id;
	  			}else {
	  				str += "<input type=\"radio\" onclick=\"mcheckId(this)\" name=\"species\" value=\""+item.id+"\"/><label>"+item.name+"</label>";
	  			}
	  		});
	  		$("#mtype").html(str);
	  	}
	});
	layer.open({
		type: 1,
		area: ['450px', '300px'], //高宽
		title: "导航内容修改",
		maxmin: true,
		content: $("#bottomnav-mod"),//DOM或内容
		btn:['确定', '取消']
	,yes: function(index, layero){ //或者使用btn1
		//确定的回调
		$("#updateBoot").submit();
		
	},cancel: function(index){//或者使用btn2（concel）
		//取消的回调
	}
	});
}

function modBoot() {
	var title = $("#mtitle").val();
	var url = $("#murl").val();
	var rowdata = $('#bottomnavtable').DataTable().rows('.selected').data();
	//加密操作
    encrypt.setPublicKey(publicKey_common);
    title = encrypt.encrypt(title);
    url = encrypt.encrypt(url);
    var id = encrypt.encrypt(rowdata[0].id + "");
    var typeId = encrypt.encrypt(mbootType + "");
	$.ajax({
		type : 'post',
		url : appPath + "/bootLink/update.do",
		data : {
			title : title,
			typeId : typeId,
			url : url,
			bootId : id
		},
		success : function(msg) {
			if (msg == 1) {
	  			layer.alert("操作成功!",{icon:1});
	  			setTimeout('location.reload()',2000);
	  		}else {
	  			layer.alert("操作失败!",{icon:2});  
	  		}
		}
	});
}
/* 导航内容修改部分结束 */
/** 表格初始化 **/
$(function() {
	var appPath = getRootPath();//项目根路径
	$('#bottomnavtable').DataTable(
	{
		autoWidth : false,
		scrollY : 500,
		pagingType: "simple_numbers",//设置分页控件的模式  
		lengthMenu:[[5,10,25,50,-1],[5,10,25,50,"全部"]],
		colReorder : false,
		scrollX : true,
		sScrollX : "100%",
		sScrollXInner : "100%",
		bScrollCollapse : true,  
		processing: true, //打开数据加载时的等待效果  
        serverSide: true,//打开后台分页  
        ajax: {  
            "url": appPath + "/bootLink/list.do",   
            "dataSrc": "results", 
            "data": function ( d ) {
            	var title = "";
            	if (title != null && title != "") {
            		result = encrypt.encrypt(title);
            	}else {
            		result = encrypt.encrypt(title);
            	}
                d.title = result;
            } 
        },
        columns: [  
                  {title:'<input type="checkbox" class="table-checkbox"  value="1" />',
                	  "mRender": function (data, type, full) {
                		  sReturn = '<input type="checkbox" value="1" />';
                		  return sReturn;
                	  }
                  },
                  { title:"链接id","data": "id" },
                  { title:"添加时间","data": "createTime" },  
                  { title:"导航标题","data": "title" },  
                  { title:"导航所属种类","data": "name" }, 
                  { title:"导航标题链接","data": "url" }, 
                  { title:"状态","data": "statu", 
                	  "mRender": function (data, type, full) {
                		 if (data == 0) {
                			 return "<font color='red'>无效</font>";
                		 }else if (data == 1){
                			 return "有效";
                		 }
                	  } 
                  },  
                  { title:"最后一次操作管理员","data": "adminName" },
                  { title:"操作","data": "statu",
                  	"mRender": function (data, type, full) {
                		  return "<a onclick=\"openLink();\" href=\"javascript:void(0);\">启用</a>" + "<a onclick=\"ofLink();\" href=\"javascript:void(0);\">停用</a>";
                	  } 
                  }
        ],
        aoColumnDefs : [
        				{
        					sDefaultContent: '',
        					orderable : false,
        					aTargets: [ '_all' ]
        				}
//        				{  
//                            "aTargets":[1],  
//                            "visible":false  
//                        }
        				],
        rowCallback:function(row,data){//添加单击事件，改变行的样式      
        }
});
 var table = $('#bottomnavtable').DataTable();
//设置选中change颜色
 $('#bottomnavtable tbody').on( 'click', 'tr', function () {
        $(this).toggleClass('selected');
  });
});