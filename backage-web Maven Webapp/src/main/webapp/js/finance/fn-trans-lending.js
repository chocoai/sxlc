/** 债券转让放款 **/
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
			var stype = encrypt.encrypt(2 + "");
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
			var stype = encrypt.encrypt(2 + "");
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
	var appPath = getRootPath();//项目根路径
	$('#table_pro_lending').DataTable(
	{
        ajax: {  
            "url": appPath + "/lending/translendingList.do",   
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
                  { title:"项目名称","data": "projectName" }, 
                  { title:"借款会员","data": "loanMemberName" },
                  { title:"转让会员","data": "transferMemberName" },
                  { title:"转让价格(元)","data": "mounts" },
                  { title:"转让金额(元)","data": "transferMounts" },
                  { title:"转让折扣（%）","data": "transferzks" },
                  { title:"融资进度（%）","data": "investSe" },
                  { title:"投标结束时间","data": "invEndtime" },
                  { title:"项目状态","data": "statusName"},
                  { title:"放款时间","data": "fangkuanTime" },
                  { title:"流标时间","data": "fangkuanTime" }
                  
                  
        ],
		  aaSorting : [[ 8, "desc"],[ 10, "desc"],[ 11, "desc"]],//默认第几个排序
	      aoColumnDefs : [
	                      {
	                    	  "orderable" : false,
	                    	  "aTargets" : [ 0, 1, 2, 3, 4, 5, 6, 7, 9]
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

