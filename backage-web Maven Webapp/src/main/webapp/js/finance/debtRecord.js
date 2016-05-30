//还本明细表格初始化
var encrypt = new JSEncrypt();
encrypt.setPublicKey(publicKey_common);
$(function() {
	var appPath = getRootPath();//项目根路径
	$('#table_debtRecordId').DataTable(
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
            "url": appPath + "/commission/repaymentList.do",   
            "dataSrc": "results", 
            "data": function ( d ) {  
            	var projectTitle = $("#projectTitle").val();
            	var personalName = $("#personalName").val();
            	var logname = $("#logname").val();
            	var startDate = $("#startDate").val();
            	var endDate = $("#endDate").val();
            	var memberID = $("#memberID").val();
            	var type = $("#type").val();
            	var stype = $("#stype").val();
            	
            	if (personalName != null && personalName != "") {
            		var result1 = encrypt.encrypt((personalName + ""));
                }
            	if (logname != null && logname != "") {
            		var result2 = encrypt.encrypt((logname + ""));
                }
            	if (startDate != null && startDate != "") {
            		var result3 = encrypt.encrypt((startDate + ""));
                }
            	if (endDate != null && endDate != "") {
            		var result4 = encrypt.encrypt((endDate + ""));
                }
            	if (projectTitle != null && projectTitle != "") {
            		var result7 = encrypt.encrypt((endDprojectTitleate + ""));
                }
            		var result5 = encrypt.encrypt((memberID + ""));
            		var result6 = encrypt.encrypt((type + ""));
                	d.personalName = result1;
                	d.logname = result2;
                	d.startDate = result3;
                	d.endDate = result4;
                	d.memberID = result5;
                	d.type = result6;
                	d.projectTitle = result7
                	d.stype = encrypt.encrypt(stype);
            } 
        },
        columns: [  
                  {title:'<input type="checkbox" class="table-checkbox"  value="1" />',
                	  "mRender": function (data, type, full) {
                		  sReturn = '<input type="checkbox" value="1" />';
                		  return sReturn;
                	  }
                  },
                  { title:"借款名称","data": "projectTitle" },
                  { title:"借款金额","data": "amounts" },
                  { title:"会员名","data": "personalName" },
                  { title:"用户名","data": "logname" },
                  { title:"本次还款本金","data": "repayPrincipals" },
                  { title:"本次还款利息","data": "repayInterests" },
                  { title:"还款时间","data": "repayTime" },
                  { title:"预期还款时间","data": "repayMaxTime" },
                  { title:"是否逾期","data": "isoverque", 
                	  "mRender": function (data, type, full) {
                		 if (data == 0) {
                			 return "<font color='red'>是</font>";
                		 }else if (data == 1){
                			 return "否";
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
 var table = $('#table_debtRecordId').DataTable();
//设置选中change颜色
 $('#table_debtRecordId tbody').on( 'click', 'tr', function () {
        $(this).toggleClass('selected');
  });
});

