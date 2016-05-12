/** 领取红包明细 **/
var encrypt = new JSEncrypt();
encrypt.setPublicKey(publicKey_common);

//表格初始化
$(function() {
	var appPath = getRootPath();//项目根路径
	$('#applicationAudit').DataTable(
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
            "url": appPath + "/red/getDetail.do",   
            "dataSrc": "results", 
            "data": function ( d ) {
            	var affairID = $("#affairID").val();
            	affairID = encrypt.encrypt((affairID + ""));
            	d.affairID = affairID;
            } 
        },
        columns: [  
                  {title:'<input type="checkbox" class="table-checkbox"  value="1" />',
                	  "mRender": function (data, type, full) {
                		  sReturn = '<input type="checkbox" value="1" />';
                		  return sReturn;
                	  }
                  },
                  { title:"领取时间","data": "receiveDate" }, 
                  { title:"会员用户名","data": "logname" },
                  { title:"领取红包面额(元)","data": "giftAmounts" },
                  { title:"使用状态","data": "statu", 
                	  "mRender": function (data, type, full) {
                		 if (data == 0) {
                			 return "未使用";
                		 }else if (data == 1){
                			 return "部分使用";
                		 }else {
                			 return "完全使用";
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
 var table = $('#applicationAudit').DataTable();
//设置选中change颜色
 $('#applicationAudit tbody').on( 'click', 'tr', function () {
        $(this).toggleClass('selected');
  });
});