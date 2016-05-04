/** 查询担保项目 **/
//加密操作
var encrypt = new JSEncrypt();
encrypt.setPublicKey(publicKey_common);
//表格初始化
$(function() {
	var appPath = getRootPath();//项目根路径
	$('#checkProjectTable').DataTable(
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
            "url": appPath + "/guarant/projectList.do",   
            "dataSrc": "results", 
            "data": function ( d ) {  
            	var guaranteeID = $("#guId").val();
            	var projectNo = $("#projectNo").val();
            	var startDate = $("#startDate").val();
            	var endDate = $("#endDate").val();
            	var startDate1 = $("#startDate1").val();
            	var endDate1 = $("#endDate1").val();
            	var guaranteeName = $("#guaName").val();
            	var isCompensatory = $("#isOrNo").val();
            	
            	var result = encrypt.encrypt((guaranteeID + ""))
            	
            	if (projectNo != null && projectNo != "") {
            		var result1 = encrypt.encrypt((projectNo + ""));
                }
				if (startDate != null && startDate != "") {
					var result2 = encrypt.encrypt((startDate));
				}
				if (endDate != null && endDate != "") {
					var result3 = encrypt.encrypt((endDate));
				}
				if (startDate1 != null && startDate1 != "") {
					var result4 = encrypt.encrypt((startDate1));
				}
				if (endDate1 != null && endDate1 != "") {
					var result5 = encrypt.encrypt((endDate1));
				}
				if (guaranteeName != null && guaranteeName != "") {
					var result6 = encrypt.encrypt((guaranteeName +""));
				}
				if (isCompensatory != null && isCompensatory != "") {
					var result7 = encrypt.encrypt((isCompensatory));
				}
                	d.projectNo = result1;
                	d.startDate = result2;
                	d.endDate = result3;
                	d.startDate1 = result4;
                	d.endDate1 = result5;
                	d.guaranteeName = result6;
                	d.isCompensatory = result7;
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
                  { title:"借款金额","data": "amount" },
                  { title:"项目保证金","data": "riskMarginFee" },
                  { title:"担保机构名称","data": "guaranteeName" },
                  { title:"担保登记时间","data": "recordDate" },
                  { title:"是否代偿","data": "isCompensatory" },
                  { title:"代偿金额","data": "amountEnc" },
                  { title:"最近代偿时间","data": "compensatoryTime" },
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
 var table = $('#checkProjectTable').DataTable();
//设置选中change颜色
 $('#checkProjectTable tbody').on( 'click', 'tr', function () {
        $(this).toggleClass('selected');
  });
});