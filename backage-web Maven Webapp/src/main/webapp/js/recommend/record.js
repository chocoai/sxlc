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
            "url": appPath + "/account/rechargeRecordList.do",   
            "dataSrc": "results", 
            "data": function ( d ) {  
            	var orderNumber = $("#orderNumber").val();
            	var batch = $("#batch").val();
            	var statu = $("#statu").val();
            	var startDate = $("#startDate").val();
            	var endDate = $("#endDate").val();
            	
            	if (orderNumber != null && orderNumber != "") {
            		var result1 = encrypt.encrypt((orderNumber + ""));
                }
            	if (batch != null && batch != "") {
            		var result2 = encrypt.encrypt((batch + ""));
                }
            	if (statu != null && statu != "") {
            		var result3 = encrypt.encrypt((statu + ""));
                }
            	if (startDate != null && startDate != "") {
            		var result4 = encrypt.encrypt((startDate + ""));
                }
            	if (endDate != null && endDate != "") {
            		var result5 = encrypt.encrypt((endDate + ""));
                }
            		var result = encrypt.encrypt((0 + ""));
            		var result6 = encrypt.encrypt((1 + ""));
                	d.orderNumber = result1;
                	d.batch = result2;
                	d.statu = result3;
                	d.startDate = result4;
                	d.endDate = result5;
                	d.dealType = result;
                	d.memberType = result6;
            } 
        },
        columns: [  
                  {title:'<input type="checkbox" class="table-checkbox"  value="1" />',
                	  "mRender": function (data, type, full) {
                		  sReturn = '<input type="checkbox" value="1" />';
                		  return sReturn;
                	  }
                  },
                  { title:"交易时间","data": "dealTime" }, 
                  { title:"平台交易编号","data": "orderNumber" },
                  { title:"第三方交易流水号","data": "loanNumber" },
                  { title:"交易金额","data": "amount" },
                  { title:"支付手续费","data": "feeAmount" },
                  { title:"状态","data": "statu", 
                	  "mRender": function (data, type, full) {
                		 if (data == 0) {
                			 return "<font color='red'>失败</font>";
                		 }else if (data == 1){
                			 return "成功";
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