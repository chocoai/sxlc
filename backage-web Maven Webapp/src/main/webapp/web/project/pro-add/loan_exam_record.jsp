<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="zh-CN">
<!-- 查看审批记录 -->
<head>
	<base href="<%=basePath%>">
	<title>项目管理-查看审批记录</title>
	<!-- 公用meta -->
	<jsp:include page="../../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->	
	<link rel="stylesheet" href="css/project/loan_exam_record.css" type="text/css">
</head>
<body>
	<div class="container add_type_contianer">
		<div class="panel-body">
			<input id="applyId" type="hidden" value="${applyId}"/>
			<table id="table_id" class="display">
			</table>
		</div>
	</div>
    <!-- 公用js -->
	<jsp:include page="../../common/cm-js.jsp"></jsp:include>
	<!-- 私用js -->
	<script type="text/javascript">
	//表格初始化
	$('#table_id').DataTable(
			{	
				ajax: {  
					"url": appPath+"/project/getProChkRecordData",   
					"dataSrc": "results", 
					"type": "POST",
					"data": function ( d ) {
						var applyId = $("#applyId").val();
						d.applyId=encrypt.encrypt(applyId);
					}  
				},
				columns: [
				          { title:"项目名称","data": "projectName"},  
				          { title:"审核管理员名称","data": "adminName"},  
				          { title:"审核点","data": "apName"},  
				          { title:"审核时间","data": "checkDate"},  
				          { title:"审核状态","data": "checkStatus"},  
				          { title:"审核意见","data": "checkRemark"}
				          ],
	          aoColumnDefs : [
	                          {
	                        	  "orderable" : false,
	                        	  "aTargets" : [ 0, 1, 2, 3, 4, 5]
	                          } // 制定列不参与排序
	                          ],
	          pagingType: "simple_numbers",//设置分页控件的模式  
	          processing: true, //打开数据加载时的等待效果  
	          serverSide: true,//打开后台分页  
	          searching: false,
// 	          info:false,
	          rowCallback:function(row,data){//添加单击事件，改变行的样式      
	          }
	});//表格初始化完毕
	 
	//表格单选效果
	 $('#table_id tbody').on( 'click', 'tr', function () {
		    var $this = $(this);
		    var $checkBox = $this.find("input:checkbox");
	        if ( $this.hasClass('selected') ) {
	        	 $checkBox.prop("checked",false);
	        	$this.removeClass('selected');
	        } else {
	        	$checkBox.prop("checked",true);
	        	$('#table_id tr.selected').removeClass('selected');
	        	$this.addClass('selected');
	        }
	  });
	
	</script>
</body>

</html>