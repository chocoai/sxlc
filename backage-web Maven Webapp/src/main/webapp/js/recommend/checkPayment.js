/** 查询代偿回款记录 **/
//加密操作
var encrypt = new JSEncrypt();
encrypt.setPublicKey(publicKey_common);
//表格初始化
$(function() {
	var appPath = getRootPath();//项目根路径
	$('#checkpaymenttable').DataTable(
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
            "url": appPath + "/guarant/receivablerecords.do",   
            "dataSrc": "results", 
            "data": function ( d ) {  
            	var guaranteeID = $("#guId").val();
            	var projectNo = $("#projectNo").val();
            	var projectTitle = $("#projectTitle").val();
            	var personalName = $("#personalName").val();
            	var logname = $("#logname").val();
            	var guaranteeName = $("#guaranteeName").val();
            	var startDate = $("#startDate").val();
            	var endDate = $("#endDate").val();
            	
            	var result = encrypt.encrypt((guaranteeID + ""))
            	
            	if (projectNo != null && projectNo != "") {
            		var result1 = encrypt.encrypt((projectNo + ""));
                }
            	if (projectTitle != null && projectTitle != "") {
            		var result2 = encrypt.encrypt((projectTitle + ""));
                }
            	if (personalName != null && personalName != "") {
            		var result3 = encrypt.encrypt((personalName + ""));
                }
            	if (logname != null && logname != "") {
            		var result4 = encrypt.encrypt((logname + ""));
                }
				if (startDate != null && startDate != "") {
					var result5 = encrypt.encrypt((startDate));
				}
				if (endDate != null && endDate != "") {
					var result6 = encrypt.encrypt((endDate));
				}
				if (guaranteeName != null && guaranteeName != "") {
					var result7 = encrypt.encrypt((guaranteeName +""));
				}
                	d.projectNo = result1;
                	d.projectTitle = result2;
                	d.personalName = result3;
                	d.logname = result4;
                	d.guaranteeName = result6;
                	d.startDate = result5;
                	d.endDate = result6;
                	d.guaranteeName = result7;
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
                  { title:"项目编号","data": "projectNo" }, 
                  { title:"项目名称","data": "projectTitle" },
                  { title:"回款项目期数","data": "indexs" },
                  { title:"借款人用户名","data": "logname" },
                  { title:"借款人姓名","data": "personalName" },
                  { title:"担保机构名称","data": "guaranteeName" },
                  { title:"回款金额","data": "endAmount" },
                  { title:"回款时间","data": "repayMaxTime" }
                  
                  
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
 var table = $('#checkpaymenttable').DataTable();
//设置选中change颜色
 $('#checkpaymenttable tbody').on( 'click', 'tr', function () {
        $(this).toggleClass('selected');
  });
});

/**
 * 查询按钮
 */
$(".glyphicon-search").on("click",function(){
	$('#checkpaymenttable').DataTable().ajax.reload();
	
});