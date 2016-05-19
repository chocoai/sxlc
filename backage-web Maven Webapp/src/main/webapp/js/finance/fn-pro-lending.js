/** 项目放款 **/
var encrypt = new JSEncrypt();
encrypt.setPublicKey(publicKey_common);

/**
 * 放款
 */

$(function () {
	$("#loan").bind('click', function () {
		var rowdata = $('#table_pro_lending').DataTable().rows('.selected').data();
		if (rowdata.length <= 0) {
			layer.alert("请选择需要进行操作的项目！",{icon:0});
			return;
		}else {
			var projectId = rowdata[0].applyID;
			projectId = encrypt.encrypt(projectId + "");
			var stype = encrypt.encrypt(1 + "");
			var auditType = encrypt.encrypt(1 + "");
			$("#stype").val(stype);
			$("#auditType").val(auditType);
			$("#projectId").val(projectId);
			$("#form1").submit();
		}
	});
	
	$("#pass").bind('click', function () {
		var rowdata = $('#table_pro_lending').DataTable().rows('.selected').data();
		if (rowdata.length <= 0) {
			layer.alert("请选择需要进行操作的项目！",{icon:0});
			return;
		}else {
			var projectId = rowdata[0].applyID;
			projectId = encrypt.encrypt(projectId + "");
			var stype = encrypt.encrypt(1 + "");
			var auditType = encrypt.encrypt(2 + "");
			$("#stype").val(stype);
			$("#auditType").val(auditType);
			$("#projectId").val(projectId);
			$("#form1").submit();
		}
	});
});
//表格初始化
$(function() {
	$('#table_pro_lending').DataTable({
        ajax: {  
            "url": appPath + "/lending/lendingList.do",   
            "dataSrc": "results", 
            "data": function ( d ) {  
            	var projectNo = $("#projectNo").val();
            	var logname = $("#logname").val();
            	var memberName = $("#memberName").val();
            	var startDate = $("#startDate").val();
            	var endDate = $("#endDate").val();
            	var dealine = $("#dealine").val();
            	var deadlineType = $("#deadlineType").val();
            	var minAmount = $("#minAmount").val();
            	var maxAmount = $("#maxAmount").val();
            	var statu = $("#statu").val();
            	
            	if (projectNo != null && projectNo != "") {
            		projectNo = encrypt.encrypt((projectNo + ""));
                }
            	if (logname != null && logname != "") {
            		logname = encrypt.encrypt((logname + ""));
                }
            	if (memberName != null && memberName != "") {
            		memberName = encrypt.encrypt((memberName + ""));
                }
            	if (startDate != null && startDate != "") {
            		startDate = encrypt.encrypt((startDate + ""));
                }
            	if (endDate != null && endDate != "") {
            		endDate = encrypt.encrypt((endDate + ""));
                }
            	if (dealine != null && dealine != "") {
            		dealine = encrypt.encrypt((dealine + ""));
                }
            	if (deadlineType != null && deadlineType != "") {
            		deadlineType = encrypt.encrypt((deadlineType + ""));
                }
            	if (minAmount != null && minAmount != "") {
            		minAmount = encrypt.encrypt((minAmount + ""));
                }
            	if (maxAmount != null && maxAmount != "") {
            		maxAmount = encrypt.encrypt((maxAmount + ""));
                }
            	if (statu != null && statu != "") {
            		statu = encrypt.encrypt((statu + ""));
                }
                	d.projectNo = projectNo;
                	d.logname = logname;
                	d.memberName = memberName;
                	d.startDate = startDate;
                	d.endDate = endDate;
                	d.dealine = dealine;
                	d.deadlineType = deadlineType;
                	d.minAmount = minAmount;
                	d.maxAmount = maxAmount;
                	d.statu = statu;
                	
            } 
        },
        columns: [  
                  {title:'',sWidth:"3%", 
		        	  "mRender": function (data, type, full) {
		        		  sReturn = '<input type="checkbox" class="tr-checkbox" value="1" />';
		        		  return sReturn;
		        	  }
		          },
                  { title:"融资结束时间","data": "realEndDate" }, 
                  { title:"项目编号","data": "projectNo" },
                  { title:"产品类型","data": "projectName" },
                  { title:"项目名称","data": "projectTitle" },
                  { title:"借款人用户名","data": "logname" },
                  { title:"借款人姓名","data": "memberName" },
                  { title:"借款金额(元)","data": "amounts" },
                  { title:"实际借款金额(元)","data": "realAmounts" },
                  { title:"融资进度(%)","data": "investRates" },
                  { title:"平台直扣金额(元)","data": "platformDirects" },
                  { title:"项目保证金(元)","data": "riskMarginFees" },
                  { title:"借款管理费(元)","data": "mngFeeAmounts" },
                  { title:"实际放款金额(元)","data": "realLoanmoneys" },
                  { title:"放款时间","data": "holdDate" },
                  { title:"状态","data": "investStatu", 
                	  "mRender": function (data, type, full) {
                		 if (data == 2) {
                			 return "未放款";
                		 }else if (data == 1){
                			 return "已流标";
                		 }else if (data == 3) {
                			 return "已放款";
                		 }else{
                			 return "";
                		 }
                	  } 
                  }
                  
                  
        ],
	  aaSorting : [[ 7, "desc"],[ 8, "desc"],[ 14, "desc"]],//默认第几个排序
      aoColumnDefs : [
                      {
                    	  "orderable" : false,
                    	  "aTargets" : [ 0, 1, 2, 3, 4, 5, 6, 9, 10, 11, 12, 13, 15]
                      } // 制定列不参与排序
                      ],
      pagingType: "simple_numbers",//设置分页控件的模式  
      processing: true, //打开数据加载时的等待效果  
      serverSide: true,//打开后台分页  
      scrollCollapse: true,
      scrollX : "100%",
	  scrollXInner : "100%",
      rowCallback:function(row,data){//添加单击事件，改变行的样式      
      },
});
	//表格单选效果(有复选框)
	 $('#table_pro_lending tbody').on( 'click', 'tr', function () {
		    var $this = $(this);
		    var $checkBox = $this.find("input:checkbox");
	        if ( $this.hasClass('selected') ) {
	        	 $checkBox.prop("checked",false);
	        	$this.removeClass('selected');
	        } else {
	        	$(".tr-checkbox").prop("checked",false);
	        	$checkBox.prop("checked",true);
	        	$('#table_pro_lending tr.selected').removeClass('selected');
	        	$this.addClass('selected');
	        }
	  });
	
	 /**
	  * 查询按钮
	  */
	 $(".glyphicon-search").on("click",function(){
		$('#table_pro_lending').DataTable().ajax.reload();
		
	 });

	
});

