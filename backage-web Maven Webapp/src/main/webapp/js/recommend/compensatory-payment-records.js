/** 代偿回款记录 **/
var encrypt = new JSEncrypt();
encrypt.setPublicKey(publicKey_common);
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
            "url": appPath + "/compensatory/backRecordList.do",   
            "dataSrc": "results", 
            "data": function ( d ) {  
            	var projectNo = $("#projectNo").val();
            	var projectTitle = $("#projectTitle").val();
            	var logname = $("#logname").val();
            	var personalName = $("#personalName").val();
            	var startDate = $("#startDate").val();
            	var endDate = $("#endDate").val();
            	
            	if (projectNo != null && projectNo != "") {
            		var result1 = encrypt.encrypt((projectNo + ""));
                }
            	if (projectTitle != null && projectTitle != "") {
            		var result2 = encrypt.encrypt((projectTitle + ""));
                }
            	if (logname != null && logname != "") {
            		var result3 = encrypt.encrypt((logname + ""));
                }
            	if (personalName != null && personalName != "") {
            		var result4 = encrypt.encrypt((personalName + ""));
                }
            	if (startDate != null && startDate != "") {
            		var result8 = encrypt.encrypt((startDate + ""));
                }
            	if (endDate != null && endDate != "") {
            		var result9 = encrypt.encrypt((endDate + ""));
                }
                	d.projectNo = result1;
                	d.projectTitle = result2;
                	d.logname = result3;
                	d.personalName = result4;
                	d.startDate = result8;
                	d.endDate = result9;
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
                  { title:"产品类型","data": "projectName" },
                  { title:"项目名称","data": "projectTitle" },
                  { title:"代偿期数","data": "indexs" },
                  { title:"借款人姓名","data": "personalName" },
                  { title:"借款人用户名","data": "logname" },
                  { title:"借款人手机号","data": "personalPhone" },
                  { title:"担保机构名称","data": "guaranteeName" },
                  { title:"实际借款金额","data": "endAmounts" },
                  { title:"当期合约还款时间","data": "repayMaxTime" },
                  { title:"代偿时间","data": "compensatoryTime" },
                  { title:"代偿本金","data": "corpusEnc" },
                  { title:"代偿利息","data": "interestEnc" },
                  { title:"代偿逾期利息","data": "overdueInterestEnc" },
                  { title:"代偿逾期罚金","data": "overdueFeeEnc" },
                  { title:"代偿总金额","data": "amountEnc" },
                  { title:"是否回款","data": "statu", 
                	  "mRender": function (data, type, full) {
                		 if (data == 0) {
                			 return "<font color='red'>否</font>";
                		 }else if (data == 1){
                			 return "是";
                		 }
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