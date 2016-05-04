/* 添加担保机构管理员管理部分开始 */
//加密操作
var encrypt = new JSEncrypt();
encrypt.setPublicKey(publicKey_common);
/*
 添加担保机构管理员管理部分结束 

 修改担保机构管理员管理部分开始 

 修改担保机构管理员管理部分结束 

*//**
 * 启用
 */
function enableOrdisEnable(){
	
	layer.confirm('确定执行该操作？', {
		btn: ['确定', '取消']
	}, function(index, layero){
		//按钮【按钮一】的回调
		var rowdata = $('#table_id').DataTable().rows('.selected').data();
		$.ajax({
			type : 'post',
			url : appPath + "/guarant/ofOrOpen.do", 
			data : {
				guaranteeId : encrypt.encrypt("" + rowdata[0].guaranteeID), 
				recordStatus : encrypt.encrypt("" + rowdata[0].recordStatus)
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
/* 添加担保机构信息部分开始 */
function manageAdd(){
	$(".right_col").load("web/recommend/re-add/gua-manage-add.jsp");
}
/* 添加担保机构信息部分结束*/
/* 修改担保机构信息部分开始 */
function manageMod(){
	var rowdata = $('#table_id').DataTable().rows('.selected').data();
	$(".right_col").load("web/recommend/re-add/gua-manage-mod.jsp?content=" + rowdata[0].guaranteeID);
}
/* 修改担保机构信息部分结束*/
/* 查看担保机构信息部分开始 */
function checkDetail(){
	var rowdata = $('#table_id').DataTable().rows('.selected').data();
	$(".right_col").load("web/recommend/re-add/gua-checkDetail.jsp?content=" + rowdata[0].guaranteeID);
}
/* 查看担保机构信息部分结束*/
/* 代偿记录查询部分开始 */
function checkRecord(){
	var rowdata = $('#table_id').DataTable().rows('.selected').data();
	$(".right_col").load("web/recommend/re-add/checkRecord.jsp?content=" + rowdata[0].guaranteeID);
}
/* 代偿记录查询部分结束 */

/* 担保机构管理员管理部分开始 */
function manageAdmain(){
	var rowdata = $('#table_id').DataTable().rows('.selected').data();
	$(".right_col").load("web/recommend/re-add/guaranteeAdmainManage.jsp?content=" + rowdata[0].guaranteeID);
}
/* 担保机构管理员管理部分结束 */

/* 担保项目查询部分开始  */
function checkProject(){
	var rowdata = $('#table_id').DataTable().rows('.selected').data();
	$(".right_col").load("web/recommend/re-add/checkProject.jsp?content=" + rowdata[0].guaranteeID);
}
/* 担保项目查询部分结束  */

/* 代偿回款记录查询部分开始 */
function checkPayment(){
	var rowdata = $('#table_id').DataTable().rows('.selected').data();
	$(".right_col").load("web/recommend/re-add/checkPayment.jsp?content=" + rowdata[0].guaranteeID);
}
/* 代偿回款记录查询部分结束 */

//表格初始化
$(function() {
	var appPath = getRootPath();//项目根路径
	$('#table_id').DataTable(
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
            "url": appPath + "/guarant/list.do",   
            "dataSrc": "results", 
            "data": function ( d ) {  
            	var guaranteeNo = $("#gNo").val();
            	var guaranteeName = $("#gName").val();
            	var companyeBLN = $("#gNum").val();
            	var contactName = $("#gpName").val();
            	var contactPhone = $("#gPhone").val();
            	var recordStatus = $("#statu").val();
            	
            	if (guaranteeNo != null && guaranteeNo != "") {
            		var result1 = encrypt.encrypt((guaranteeNo + ""));
                }
				if (guaranteeName != null && guaranteeName != "") {
					var result2 = encrypt.encrypt((guaranteeName));
				}
				if (companyeBLN != null && companyeBLN != "") {
					var result3 = encrypt.encrypt((companyeBLN +""));
				}
				if (contactName != null && contactName != "") {
					var result4 = encrypt.encrypt((contactName));
				}
				if (contactPhone != null && contactPhone != "") {
					var result5 = encrypt.encrypt((contactPhone + ""));
				}
				if (recordStatus != null && recordStatus != "") {
					var result6 = encrypt.encrypt((recordStatus + ""));
				}
                	d.guaranteeNo = result1;
                	d.guaranteeName = result2;
                	d.companyeBLN = result3;
                	d.contactName = result4;
                	d.contactPhone = result5;
                	d.recordStatus = result6;
            } 
        },
        columns: [  
                  {title:'<input type="checkbox" class="table-checkbox"  value="1" />',
                	  "mRender": function (data, type, full) {
                		  sReturn = '<input type="checkbox" value="1" />';
                		  return sReturn;
                	  }
                  },
                  { title:"担保id","data": "guaranteeID" },
                  { title:"添加时间","data": "cddTime" }, 
                  { title:"编号","data": "guaranteeNo" },
                  { title:"担保机构名称","data": "guaranteeName" },
                  { title:"营业执照号","data": "companyeBLN" },
                  { title:"组织机构代码","data": "companyOC" },
                  { title:"税务登记号","data": "taxRegNo" },
                  { title:"注册资本","data": "companyCapital" },
                  { title:"注册地址","data": "companyAddress" },
                  { title:"法人姓名","data": "personalName" },
                  { title:"法人身份证号","data": "personalIdCard" },
                  { title:"法人手机号","data": "personalPhone" },
                  { title:"联系人姓名","data": "contactName" },  
                  { title:"联系人手机号","data": "contactPhone" },
                  { title:"状态","data": "recordStatus", 
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
                		  return "<a onclick=\"enableOrdisEnable();\" href=\"javascript:void(0);\">启用</a>" + "<a onclick=\"enableOrdisEnable();\" href=\"javascript:void(0);\">停用</a>";
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
 var table = $('#table_id').DataTable();
//设置选中change颜色
 $('#table_id tbody').on( 'click', 'tr', function () {
        $(this).toggleClass('selected');
  });
});

