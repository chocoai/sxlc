//推荐借款明细表格初始化
var encrypt = new JSEncrypt();
encrypt.setPublicKey(publicKey_common);
$(function() {
	var appPath = getRootPath();//项目根路径
	$('#table_borrowRecordId').DataTable(
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
            "url": appPath + "/commission/loanDetailList.do",   
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
                  { title:"借款期限","data": "deadline" },
                  { title:"年化利率","data": "yearRate" },
                  { title:"会员名称","data": "personalName" },
                  { title:"用户名","data": "logname" },
                  { title:"放款时间","data": "holdDate" }
                  
                  
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
 var table = $('#table_borrowRecordId').DataTable();
//设置选中change颜色
 $('#table_borrowRecordId tbody').on( 'click', 'tr', function () {
        $(this).toggleClass('selected');
  });
});