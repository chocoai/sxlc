/** 管理员管理 **/
//加密操作
var encrypt = new JSEncrypt();
encrypt.setPublicKey(publicKey_common);
//添加管理员
function manageAdmainAdd(){
	layer.open({
		type: 1,
		area: ['550px', '380px'], //高宽
		title: "添加管理员",
		maxmin: true,
		content: $("#manageAdmainAdd"),//DOM或内容
		/*btn:['确定', '取消']
	,yes: function(index, layero){ //或者使用btn1
		//确定的回调
		//判断执行不同方法
		
	},cancel: function(index){//或者使用btn2（concel）
		//取消的回调
	}*/
	});
}

$(function () {
	$("#add").bind('click', function () {
		$("#manageAdd").submit();
	});
	
	$("#mod").bind('click', function () {
		$("#manageMod").submit();
	});
});

function addMange() {
	var guId = $("#guId").val();
	var userName = $("#userName").val();
	var remark = $("#remark").val();
	var password = $("#pwd").val();
	$.ajax({
		type : 'post',
		url : appPath + "/guarant/saveAdmin.do",
		data : {
			userName : encrypt.encrypt("" + userName),
			password : encrypt.encrypt("" + password),
			guaranteeID : encrypt.encrypt("" + guId),
			remark : encrypt.encrypt("" + remark),
			stype : encrypt.encrypt("" + 1)
		},
		success : function (data) {
			if (data == 1) {
				layer.alert("添加成功!",{icon:1});
				setTimeout('location.reload()',2000);
			}else {
				layer.alert("添加失败!",{icon:2});  
			}
		}
	});
}

function modMange() {
	var rowdata = $('#admaintable').DataTable().rows('.selected').data();
	var guId = rowdata[0].adminID;
	var userName = $("#userName").val();
	var remark = $("#remark").val();
	var password = $("#pwd").val();
	$.ajax({
		type : 'post',
		url : appPath + "/guarant/saveAdmin.do",
		data : {
			userName : encrypt.encrypt("" + userName),
			password : encrypt.encrypt("" + password),
			guaranteeID : encrypt.encrypt("" + guId),
			remark : encrypt.encrypt("" + remark),
			stype : encrypt.encrypt("" + 1)
		},
		success : function (data) {
			if (data == 1) {
				layer.alert("添加成功!",{icon:1});
				setTimeout('location.reload()',2000);
			}else {
				layer.alert("添加失败!",{icon:2});  
			}
		}
	});
}
//修改管理员
function manageAdmainMod(){
	var rowdata = $('#admaintable').DataTable().rows('.selected').data();
	if (rowdata.length <= 0) {
		layer.alert("请选择要修改的管理员！",{icon:0});
		return;
	}else{
		$.ajax({
			type : 'post',
			url : appPath + "/guarant/queryAdmin.do",
			data : {
				guaranteeID : encrypt.encrypt("" + rowdata[0].guaranteeID)
			},
			success : function (msg) {
				$("#musername").val();
				$("#mpwd").val();
				$("#mrpwd").val();
				$("#remark").val();
			}
		});
	}
	layer.open({
		type: 1,
		area: ['550px', '430px'], //高宽
		title: "修改管理员",
		maxmin: true,
		content: $("#manageAdmainMod"),//DOM或内容
		/*btn:['确定', '取消']
	,yes: function(index, layero){ //或者使用btn1
		//确定的回调
		//判断执行不同方法
		
	},cancel: function(index){//或者使用btn2（concel）
		//取消的回调
	}*/
	});
}
//启用停用
function enableOrdisEnable(type){
	var rowdata = $('#admaintable').DataTable().rows('.selected').data();
	if (rowdata.length <= 0) {
		layer.alert("请选择要操作的管理员！",{icon:0});
		return;
	}else{
		layer.confirm('确定执行该操作？', {
			btn: ['确定', '取消']
		}, function(index, layero){
			//按钮【按钮一】的回调
			var status = "";
			if (type == 1) {
				status = 1;
			}else {
				status = 0;
			}
			$.ajax({
				type : 'post',
				url : appPath + "/guarant/ofOrOpenAdmin.do", 
				data : {
					adminID : encrypt.encrypt("" + rowdata[0].adminID), 
					status : encrypt.encrypt("" + status)
				},
				success : function (msg) {
					if (msg == 0) {
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
}
//表格初始化
$(function() {
	var appPath = getRootPath();//项目根路径
	var guId = $("#guId").val();
	$('#admaintable').DataTable(
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
            "url": appPath + "/guarant/adminlist.do",   
            "dataSrc": "results", 
            "data": function ( d ) {  
        		var result = encrypt.encrypt((guId + ""))
				d.guaranteeID = result;
            } 
        },
        columns: [  
                  {title:'<input type="checkbox" class="table-checkbox"  value="1" />',
                	  "mRender": function (data, type, full) {
                		  sReturn = '<input type="checkbox" value="1" />';
                		  return sReturn;
                	  }
                  },
                  { title:"管理员id","data": "adminID" },
                  { title:"管理员名称","data": "adminName" }, 
                  { title:"添加时间","data": "addTime" },
                  { title:"状态","data": "status", 
                	  "mRender": function (data, type, full) {
                		 if (data == 0) {
                			 return "<font color='red'>无效</font>";
                		 }else if (data == 1){
                			 return "有效";
                		 }
                	  } 
                  },  
                  { title:"操作","data": "statu",
                  	"mRender": function (data, type, full) {
                		  return "<a onclick=\"enableOrdisEnable(1);\" href=\"javascript:void(0);\">启用</a>" + "<a onclick=\"enableOrdisEnable(0);\" href=\"javascript:void(0);\">停用</a>";
                	  } 
                  }
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
 var table = $('#admaintable').DataTable();
//设置选中change颜色
 $('#admaintable tbody').on( 'click', 'tr', function () {
        $(this).toggleClass('selected');
  });
});