$(function () {
	$.ajax({
		type : 'post',
		url : appPath + "/financeCompensatory/query4type.do",
		success : function (msg) {
			var str = "";
			$.each(msg, function (i, item){
				str += "<option value=\""+item.id+"\">"+item.projectName+"</option>";
			})
			$("#projectName").html(str);
		}
	});
});
/**
 * 平台代偿表格初始化
 */
var encrypt = new JSEncrypt();
encrypt.setPublicKey(publicKey_common);
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
            "url": appPath + "/financeCompensatory/CompensatoryList.do",   
            "dataSrc": "results", 
            "data": function ( d ) {  
            	var projectNo = $("#projectNo").val();
            	var projectName = $("#projectName").val();
            	var projectTitle = $("#projectTitle").val();
            	var logname = $("#logname").val();
            	var personalName = $("#personalName").val();
            	var personalPhone = $("#personalPhone").val();
            	var startDate = $("#startDate").val();
            	var endDate = $("#endDate").val();
            	
            	if (projectNo != null && projectNo != "") {
            		var result1 = encrypt.encrypt((projectNo + ""));
                }
            	if (projectName != null && projectName != "") {
            		var result2 = encrypt.encrypt((projectName + ""));
                }
            	if (projectTitle != null && projectTitle != "") {
            		var result3 = encrypt.encrypt((projectTitle + ""));
                }
            	if (logname != null && logname != "") {
            		var result4 = encrypt.encrypt((logname + ""));
                }
            	if (personalName != null && personalName != "") {
            		var result5 = encrypt.encrypt((personalName + ""));
                }
            	if (personalPhone != null && personalPhone != "") {
            		var result6 = encrypt.encrypt((personalPhone + ""));
                }
            	if (startDate != null && startDate != "") {
            		var result7 = encrypt.encrypt((startDate + ""));
                }
            	if (endDate != null && endDate != "") {
            		var result8 = encrypt.encrypt((endDate + ""));
                }
            	d.projectNo = result1;
            	d.projectName = result2;
            	d.projectTitle = result3;
            	d.logname = result4;
            	d.personalName = result5;
            	d.personalPhone = result6;
            	d.startDate = result7;
            	d.endDate = result8;
            } 
        },
        columns: [  
                  {title:'<input type="checkbox" class="table-checkbox"  value="1" />',
                	  "mRender": function (data, type, full) {
                		  sReturn = '<input type="checkbox" value="1" />';
                		  return sReturn;
                	  }
//                	  "sClass": "table-checkbox"
                  },
                  { title:"项目申请记录id","data": "applyId" },
                  { title:"项目编号","data": "projectNo" },
                  { title:"产品类型","data": "projectName" },  
                  { title:"项目名称","data": "projectTitle" },  
                  { title:"期数","data": "indexs" },  
                  { title:"借款人姓名","data": "personalName" },  
                  { title:"借款人用户名","data": "logname" },
                  { title:"借款人手机号","data": "personalPhone" },
                  { title:"担保机构名称","data": "guaranteeName" },
                  { title:"实际借款金额","data": "realAmount" },
                  { title:"当期合约还款时间","data": "repayMaxTime" },
                  { title:"应还本金","data": "sDRepayPrincipal" },
                  { title:"应还利息","data": "sDRepayInterest" },
                  { title:"应还逾期利息","data": "repayOverdueInterest" },
                  { title:"应还逾期罚金","data": "repayOverdue" },
                  { title:"应还代偿金额","data": "allmoney" },
                  { title:"应代方式","data": "isCompensatory" },
                  { title:"是否回款","data": "isCompensatory" }
                  
        ],
        aoColumnDefs : [
        				// {"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
        				{
        					sDefaultContent: '',
        					orderable : false,
        					aTargets: [ '_all' ]
        				},
        				{  
                            "aTargets":[1],  
                            "visible":true  
                        }
        				],
        rowCallback:function(row,data){//添加单击事件，改变行的样式      
//        	if($.inArray(data.DT_RowId,selected)!==-1){
//        		$(row).addClass('selected'); 
//        	}
        }
});
 var table = $('#table_id').DataTable();
//设置选中change颜色
 $('#table_id tbody').on( 'click', 'tr', function () {
        $(this).toggleClass('selected');
  });
});

/**
 * 查询按钮
 */
$(".glyphicon-search").on("click",function(){
	$('#table_id').DataTable().ajax.reload();
	
});