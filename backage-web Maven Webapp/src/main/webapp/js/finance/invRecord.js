//推荐借款明细表格初始化
var encrypt = new JSEncrypt();
encrypt.setPublicKey(publicKey_common);
$(function() {
	var appPath = getRootPath();//项目根路径
	$('#table_invRecordId').DataTable(
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
            "url": appPath + "/commission/investList.do",   
            "dataSrc": "results", 
            "data": function ( d ) {  
            	var projectTitle = $("#projectTitle").val();
            	var personalName = $("#personalName").val();
            	var logname = $("#logname").val();
            	var startDate = $("#startDate").val();
            	var endDate = $("#endDate").val();
            	var memberID = $("#memberID").val();
            	var stype = $("#stype").val();
            	
            	if (projectTitle != null && projectTitle != "") {
            		var result1 = encrypt.encrypt((projectTitle + ""));
                }
            	if (personalName != null && personalName != "") {
            		var result2 = encrypt.encrypt((personalName + ""));
                }
            	if (logname != null && logname != "") {
            		var result3 = encrypt.encrypt((logname + ""));
                }
            	if (startDate != null && startDate != "") {
            		var result4 = encrypt.encrypt((startDate + ""));
                }
            	if (endDate != null && endDate != "") {
            		var result5 = encrypt.encrypt((endDate + ""));
                }
            		var result6 = encrypt.encrypt((memberID + ""));
                	d.projectTitle = result1;
                	d.personalName = result2;
                	d.logname = result3;
                	d.startDate = result4;
                	d.endDate = result5;
                	d.memberID = result6;
                	d.stype = encrypt.encrypt(stype + "");
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
                  { title:"投资金额","data": "investAmountValids" },
                  { title:"会员名","data": "personalName" },
                  { title:"用户名","data": "logname" },
                  { title:"预期本金","data": "sdRecvPrincipals" },
                  { title:"预期收益","data": "sdRecvInterests" },
                  { title:"投资成功实间","data": "holdDate" }
                  
                  
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
 var table = $('#table_invRecordId').DataTable();
//设置选中change颜色
 $('#table_invRecordId tbody').on( 'click', 'tr', function () {
        $(this).toggleClass('selected');
  });
});

