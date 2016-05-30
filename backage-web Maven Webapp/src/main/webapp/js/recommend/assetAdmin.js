/** 资产管理管理员 **/
//加密操作
var encrypt = new JSEncrypt();
encrypt.setPublicKey(publicKey_common);

$(function () {
	$("#add").bind('click', function () {
		$("#addMange").submit();
	});

	$("#mod").bind('click', function () {
		$("#modMange").submit();
	});
});

function mangeAdd() {
	$.ajax({
		type : 'post',
		url : appPath + "/guarant/saveAdmin.do",
		data : {
			guaranteeID : encrypt.encrypt($("#managementID").val() + ""),
			userName : encrypt.encrypt($("#username").val() + ""),
			password : encrypt.encrypt($("#pwd").val() + ""),
			remark : encrypt.encrypt($("#remark").val() + ""),
			stype : encrypt.encrypt(2 + "")
		},
		success : function (msg) {
			if (msg == 1) {
				document.getElementById("addMange").reset();
				var table = $('#assetadmaintable').DataTable();
				table.ajax.reload();
				layer.closeAll();
				layer.alert("添加成功",{icon:1}); 
			}else {
				layer.alert("服务器异常",{icon:2});
			}
		}
	});
}

function modMange() {
	var rowdata = $('#assetadmaintable').DataTable().rows('.selected').data();
	$.ajax({
		type : 'post',
		url : appPath + "/guarant/update.do",
		data : {
			adminID : encrypt.encrypt(rowdata[0].adminID + ""),
			userName : encrypt.encrypt($("#musername").val() + ""),
			password : encrypt.encrypt($("#mpwd").val() + ""),
			remark : encrypt.encrypt($("#mremark").val() + "")
		},
		success : function (msg) {
			if (msg == 1) {
				layer.alert("添加成功",{icon:1});  
				setTimeout('location.reload()',2000);
			}else {
				layer.alert("服务器异常",{icon:2});
			}
		}
	});
}
/**
 * 修改管理员
 */
function manageAdmainMod(){
	var rowdata = $('#assetadmaintable').DataTable().rows('.selected').data();
	if (rowdata.length <= 0) {
		layer.alert("请选择要查看的管理方！",{icon:0});
		return;
	}else{
		$.ajax({
			type : 'post',
			url : appPath + "/guarant/queryAdmin.do",
			data : {
				adminID : encrypt.encrypt(rowdata[0].adminID + "")
			},
			success : function (msg) {
				$("#musername").val(msg.adminName);
				$("#mpwd").val(msg.adminPwd);
				$("#mrpwd").val(msg.adminPwd);
				$("#mremark").val(msg.adminRemark);
			}
		});
		layer.open({
			type: 1,
			area: ['550px', '430px'], //高宽
			title: "修改管理员管理",
			maxmin: true,
			content: $("#manageAdmainMod")
		});
	}
}

/**
 * 启用停用
 */
function enableOrdisEnable(type) {
	var rowdata = $('#assetadmaintable').DataTable().rows('.selected').data();
	if (rowdata.length <= 0) {
		layer.alert("请选择要操作的管理员！",{icon:0});
		return;
	}else {
		
		var adminID = encrypt.encrypt(rowdata[0].adminID + "");
		var recordStatus = 0;
		if (type == 1) {
			recordStatus = encrypt.encrypt(1 + "");
		}else {
			recordStatus = encrypt.encrypt(0 + "");
		}
		layer.confirm('确定启用？', {
			btn: ['确定', '取消']
		}, function(index, layero){
			//按钮【按钮一】的回调
			$.ajax({
				type : 'post',
				url : appPath + "/guarant/ofOrOpenAdmin.do",
				data : {
					adminID : adminID,
					status : recordStatus
				},
				success : function (msg) {
					if (msg == 0) {
						layer.alert("操作成功",{icon:1});  
						setTimeout('location.reload()',2000);
					}else {
						layer.alert("服务器异常",{icon:2});
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
	$('#assetadmaintable').DataTable(
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
            "url": appPath + "/asset/queryAdmin.do",   
            "dataSrc": "results", 
            "data": function ( d ) {
            	var managementID = $("#managementID").val();
            	d.managementID = encrypt.encrypt(managementID + "");
            } 
        },
        columns: [  
                  {title:'<input type="checkbox" class="table-checkbox"  value="1" />',
                	  "mRender": function (data, type, full) {
                		  sReturn = '<input type="checkbox" value="1" />';
                		  return sReturn;
                	  }
                  },
                  { title:"管理员ID","data": "adminID" },
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
 var table = $('#assetadmaintable').DataTable();
//设置选中change颜色
 $('#assetadmaintable tbody').on( 'click', 'tr', function () {
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
		
	} );
});