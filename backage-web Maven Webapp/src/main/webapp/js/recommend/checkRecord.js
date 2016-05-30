/** 查询代偿记录 **/
//加密操作
var encrypt = new JSEncrypt();
encrypt.setPublicKey(publicKey_common);
//表格初始化
$(function() {
	var appPath = getRootPath();//项目根路径
	$('#checkrecordtable').DataTable(
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
            "url": appPath + "/guarant/compensatoryrecord.do",   
            "dataSrc": "results", 
            "data": function ( d ) {  
            	var guaranteeID = $("#guId").val();
            	var projectNo = $("#projectNo").val();
            	var projectTitle = $("#projectTitle").val();
            	var personalName = $("#personalName").val();
            	var logname = $("#logname").val();
            	var personalPhone = $("#personalPhone").val();
            	var guaranteeName = $("#guaranteeName").val();
            	var startDate = $("#startDate").val();
            	var endDate = $("#endDate").val();
            	var startDate2 = $("#startDate2").val();
            	var endDate2 = $("#endDate2").val();
            	var status = $("#status").val();
            	
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
            	if (personalPhone != null && personalPhone != "") {
            		var result5 = encrypt.encrypt((personalPhone + ""));
                }
				if (startDate != null && startDate != "") {
					var result6 = encrypt.encrypt((startDate));
				}
				if (endDate != null && endDate != "") {
					var result7 = encrypt.encrypt((endDate));
				}
				if (startDate2 != null && startDate2 != "") {
					var result8 = encrypt.encrypt((startDate2));
				}
				if (endDate2 != null && endDate2 != "") {
					var result9 = encrypt.encrypt((endDate2));
				}
				if (guaranteeName != null && guaranteeName != "") {
					var result10 = encrypt.encrypt((guaranteeName +""));
				}
				if (status != null && status!= "") {
					var result11 = encrypt.encrypt((status));
				}
                	d.projectNo = result1;
                	d.projectTitle = result2;
                	d.personalName = result3;
                	d.logname = result4;
                	d.personalPhone = result5;
                	d.guaranteeName = result6;
                	d.startDate = result7;
                	d.endDate = result8;
                	d.startDate2 = result9;
                	d.endDate2 = result10;
                	d.status = result11;
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
                  { title:"产品类型","data": "projectName" },
                  { title:"项目名称","data": "projectTitle" },
                  { title:"代偿期数","data": "indexs" },
                  { title:"借款人姓名","data": "personalName" },
                  { title:"借款人用户名","data": "logname" },
                  { title:"借款人手机号","data": "personalPhone" },
                  { title:"担保机构名称","data": "guaranteeName" },
                  { title:"实际借款金额","data": "endAmount" },
                  { title:"当期合约还款时间","data": "repayMaxTime" },
                  { title:"代偿时间","data": "compensatoryTime" },
                  { title:"代偿本金","data": "corpusEnc" },
                  { title:"代偿利息","data": "interestEncs" },
                  { title:"代偿逾期利息","data": "overdueInterestEncs" },
                  { title:"代偿逾期罚金","data": "overdueFeeEncs" },
                  { title:"代偿总金额","data": "amountEncs" },
                  { title:"是否回款","data": "statu" }
                  
                  
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
 var table = $('#checkrecordtable').DataTable();
//设置选中change颜色
 $('#checkrecordtable tbody').on( 'click', 'tr', function () {
		var $this = $(this);
		var $checkBox = $this.find("input:checkbox");
		 if ( $(this).hasClass('selected') ) {
			 $checkBox.prop("checked",false);
				$(this).removeClass('selected');
			}
			else {
				$('tr.selected').removeClass('selected');
				$this.siblings().find("input:checkbox").prop("checked",false);
				$checkBox.prop("checked",true);
				$(this).addClass('selected');
			}
		
	} );
});

/**
 * 查询按钮
 */
$(".glyphicon-search").on("click",function(){
	$('#checkrecordtable').DataTable().ajax.reload();
	
});