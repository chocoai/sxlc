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
            "url": appPath + "/account/tradeRecord.do",   
            "dataSrc": "results", 
            "data": function ( d ) {  
            	var typeName = $("#typeName").val();
            	var startDate = $("#startDate").val();
            	var endDate = $("#endDate").val();
            	
            	if (typeName != null && typeName != "") {
            		var result1 = encrypt.encrypt((typeName + ""));
                }
            	if (startDate != null && startDate != "") {
            		var result2 = encrypt.encrypt((startDate + ""));
                }
            	if (endDate != null && endDate != "") {
            		var result3 = encrypt.encrypt((endDate + ""));
                }
                	d.typeName = result1;
                	d.startDate = result2;
                	d.endDate = result3;
            } 
        },
        columns: [  
                  {title:'<input type="checkbox" class="table-checkbox"  value="1" />',
                	  "mRender": function (data, type, full) {
                		  sReturn = '<input type="checkbox" value="1" />';
                		  return sReturn;
                	  }
                  },
                  { title:"交易时间","data": "recordDate" }, 
                  { title:"交易金额","data": "amount" },
                  { title:"交易类型","data": "typeName" },
                  { title:"摘要","data": "abstracts" }
                  
                  
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