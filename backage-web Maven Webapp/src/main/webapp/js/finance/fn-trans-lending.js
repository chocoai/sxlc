/** 债券转让放款 **/
/** 项目放款 **/
var encrypt = new JSEncrypt();
encrypt.setPublicKey(publicKey_common);


$(function () {
	/**
	 * 放款
	 */
	$("#loan").bind('click', function () {
		var rowdata = $('#table_pro_lending').DataTable().rows('.selected').data();
		if (rowdata.length <= 0) {
			layer.alert("请选择需要进行操作的项目！",{icon:0});
			return;
		}else {
			var projectId = rowdata[0].tranId;
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
			var projectId = rowdata[0].tranId;
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
            "url": appPath + "/finance/translendingList.do",   
            "dataSrc": "results", 
            "data": function ( d ) {  
            	var projectName = $(".projectName").val();
            	var loanMemberName = $(".loanMemberName").val();
            	var transferMemberName = $(".transferMemberName").val();
            	var startfangkuanTime = $("#loanStartDate").val();
            	var endfangkuanTime = $("#loanEndDate").val();
            	var status = $(".status").val();
            	
            	if (projectName != null && projectName != "") {
            		projectName = encrypt.encrypt((projectName + ""));
                }
            	if (loanMemberName != null && loanMemberName != "") {
            		loanMemberName = encrypt.encrypt((loanMemberName + ""));
                }
            	if (transferMemberName != null && transferMemberName != "") {
            		transferMemberName = encrypt.encrypt((transferMemberName + ""));
                }
            	if (startfangkuanTime != null && startfangkuanTime != "") {
            		startfangkuanTime = encrypt.encrypt((startfangkuanTime + ""));
                }
            	if (endfangkuanTime != null && endfangkuanTime != "") {
            		endfangkuanTime = encrypt.encrypt((endfangkuanTime + ""));
                }
            	if (status != null && status != "") {
            		status = encrypt.encrypt((status + ""));
                }
                	d.projectName = projectName;
                	d.loanMemberName = loanMemberName;
                	d.transferMemberName = transferMemberName;
                	d.startfangkuanTime = startfangkuanTime;
                	d.endfangkuanTime = endfangkuanTime;
                	d.status = status;
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
                  { title:"融资进度（%）","data": "investSes" },
                  { title:"项目状态","data": "status", 
                	  "mRender": function (data, type, full) {
                 		 if (data == -1 || data==0 || data==2) {
                 			 return "待放款";
                 		 }else if (data == 1){
                 			 return "已流标";
                 		 }else if (data == 3 || data == 4) {
                 			 return "已完成";
                 		 }else{
                 			 return "";
                 		 }
                 	  } 
                   },
                  { title:"放款时间","data": "fangkuanTime" },
                  { title:"流标时间","data": "fangkuanTime" }
                  
                  
        ],
		  aaSorting : [[ 9, "desc"],[ 10, "desc"]],//默认第几个排序
	      aoColumnDefs : [
	                      {
	                    	  "orderable" : false,
	                    	  "aTargets" : [ 0, 1, 2, 3, 4, 5, 6, 7]
	                      } // 制定列不参与排序
	                      ],
	      pagingType: "simple_numbers",//设置分页控件的模式  
	      processing: true, //打开数据加载时的等待效果  
	      serverSide: true,//打开后台分页  
	      scrollCollapse: true,
	      searching: false,
	      scrollX : "100%",
	      scrollXInner : "100%",scrollY:500,
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

