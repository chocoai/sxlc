var encrypt = new JSEncrypt();
encrypt.setPublicKey(publicKey_common);
/*  添加SEO设置     */
function addSEO(){
	layer.open({
		type: 1,
		area: ['500px', '300px'], //高宽
		title: "添加SEO设置",
		maxmin: true,
		content: $("#addSEO")//DOM或内容
	});
}


/*  修改SEO设置     */
function alertSEO(){
	var rowdata = $('#applicationAudit').DataTable().rows('.selected').data();
	$("#seoTitle").val(rowdata[0].seoTitle);
	$("#seoDescription").val(rowdata[0].seoDescription);
	$("#seoKeyword").val(rowdata[0].seoKeyword);
	$("#seoTypeName").val(rowdata[0].seoTypeName);
	layer.open({
		type: 1,
		area: ['500px', '300px'], //高宽
		title: "修改SEO设置",
		maxmin: true,
		content: $("#alertSEO")//DOM或内容
	});
}

$(function () {
	$.ajax({
		type : 'post',
		url : appPath + "/seo/query4select.do",
		success : function(msg) {
			var str = "";
			$.each(msg, function(i, item) {
				str += "<option value=\""+item.seoTypeID+"\">"+item.seoTypeName+"</option>";
			});
			$("#seoTypeName").html(str);
		}
	});
});

$(function() {
	$("#insertSEO").bind('click', function () {
		$("#addSEOForm").submit();
	});
});

function addSEO () {
	var seoTitle = $("#seoTitle").val();
	var seoDescription = $("#seoDescription").val();
	var seoKeyword = $("#seoKeyword").val();
	var seoTypeName = $("#seoTypeName").val();
	seoTitle = encrypt.setPublicKey(seoTitle);
	seoDescription = encrypt.setPublicKey(seoDescription);
	seoKeyword = encrypt.setPublicKey(seoKeyword);
	seoTypeName = encrypt.setPublicKey(seoTypeName);
	$.ajax({
		type : 'post',
		url : appPath + "/seo/addSEO.do",
		data : {
			seoTitle : seoTitle,
			seoDescription : seoDescription,
			seoKeyword : seoKeyword,
			seoTypeName : seoTypeName
		},
		success : function(msg) {
			if (data == 1) {
				layer.alert("添加成功",{icon:1});  
				document.getElementById("addSEOForm").reset();
				setTimeout('location.reload()',2000);
			}else {
				layer.alert("服务器异常",{icon:2});
				document.getElementById("addSEOForm").reset();
			}
		}
	});
}

$(function() {
	$("#alterSEO").bind('click', function () {
		$("#alertSEOForm").submit();
	});
});

function modSEO () {
	var rowdata = $('#applicationAudit').DataTable().rows('.selected').data();
	var seoId = rowdata[0].SeoSetID;
	var seoTitle = $("#seoTitle").val();
	var seoDescription = $("#seoDescription").val();
	var seoKeyword = $("#seoKeyword").val();
	var seoTypeName = $("#seoTypeName").val();
	seoTitle = encrypt.setPublicKey(seoTitle);
	seoDescription = encrypt.setPublicKey(seoDescription);
	seoKeyword = encrypt.setPublicKey(seoKeyword);
	seoTypeName = encrypt.setPublicKey(seoTypeName);
	seoId = encrypt.setPublicKey(seoId);
	$.ajax({
		type : 'post',
		url : appPath + "/seo/addSEO.do",
		data : {
			seoTitle : seoTitle,
			seoDescription : seoDescription,
			seoKeyword : seoKeyword,
			seoTypeName : seoTypeName,
			seoId : seoId
		},
		success : function(msg) {
			if (data == 1) {
				layer.alert("修改成功",{icon:1});  
				document.getElementById("alertSEOForm").reset();
				setTimeout('location.reload()',2000);
			}else {
				layer.alert("服务器异常",{icon:2});
				document.getElementById("alertSEOForm").reset();
			}
		}
	});
}

$(function(){
	validform5(".addBtn","addSEOForm",false,3);
	validform5(".alertBtn","alertSEOForm",false,3);
	$(".cancelBtn").bind("click",function(){
		layer.closeAll();
	});
});

/**
 * 删除seo
 */
$(function () {
	$(".obtn-dept-del").on("click touchstart",function(){
		//获得选取的对象
		
		layer.confirm('确定删除？', {
		  btn: ['确定', '取消']
		}, function(index, layero){
		  //确定的回调
		  var rowdata = $('#applicationAudit').DataTable().rows('.selected').data();
		  //加密操作
		  var result = encrypt.encrypt(rowdata[0].SeoSetID + "");
		  $.ajax({
		  	type : 'post',
		  	url : appPath + "/seo/del.do",
		  	data : {SeoSetID : result},
		  	success : function (msg) {
		  		if (msg == 0) {
		  			layer.alert("删除成功!",{icon:1});
		  			setTimeout('location.reload()',2000);
		  		}
		  	},
		  	error : function() {  
		           layer.alert("操作失败!",{icon:2});  
		    } 
		  });
			
			layer.close(index);
		}, function(index){
		  //按钮【按钮二】的回调
		});
	});
});

$(function() {
	var appPath = getRootPath();//项目根路径
	$('#applicationAudit').DataTable(
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
            "url": appPath + "/seo/seoList.do",   
            "dataSrc": "results", 
            "data": function ( d ) {  
            } 
        },
        columns: [  
                  {title:'<input type="checkbox" class="table-checkbox"  value="1" />',
                	  "mRender": function (data, type, full) {
                		  sReturn = '<input type="checkbox" value="1" />';
                		  return sReturn;
                	  }
                  },
                  { title:"SeoSetID","data": "SeoSetID" },
                  { title:"title内容","data": "seoTitle" },
                  { title:"描述","data": "seoDescription" },
                  { title:"关键词","data": "seoKeyword" },
                  { title:"关联类型","data": "seoTypeName" },
                  { title:"操作时间","data": "optDate" },
                  { title:"最近一次操作管理员","data": "adminName" }
                  
                  
        ],
        aoColumnDefs : [
        				{
        					sDefaultContent: '',
        					orderable : false,
        					aTargets: [ '_all' ]
        				}
        				],
        rowCallback:function(row,data){//添加单击事件，改变行的样式      
        }
});
 var table = $('#applicationAudit').DataTable();
//设置选中change颜色
 $('#applicationAudit tbody').on( 'click', 'tr', function () {
        $(this).toggleClass('selected');
  });
});