<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
	<base href="<%=basePath%>">
	<title>项目管理</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link href="css/project/myLayer.css" rel="stylesheet" />
</head>
<body>
	<div class="container add_type_contianer">
	  	<table id="table_history_exam_record" class="display" cellspacing="0" width="100%">
	       <thead>
	           <tr>
	               <th>审核节点</th>
	               <th>审核管理员</th>
	               <th>审核结果</th>
	               <th>审核时间</th>
	               <th>审核意见</th>
	           </tr>
	       </thead>
	       <tbody>
	       		<tr>
	           		<td>节点</td>
	           		<td>无名子</td>
	           		<td>通过</td>
	           		<td>2016.01.02</td>
	           		<td>点击待会深刻的家人谁看见我客户的服务蝴蝶飞</td>
	           </tr>
	           <tr>
	           		<td>节点</td>
	           		<td>无名子</td>
	           		<td>通过</td>
	           		<td>2016.01.02</td>
	           		<td>点击待会深刻的家人谁看见我客户的服务蝴蝶飞</td>
	           </tr>
	           <tr>
	           		<td>节点</td>
	           		<td>无名子</td>
	           		<td>通过</td>
	           		<td>2016.01.02</td>
	           		<td>点击待会深刻的家人谁看见我客户的服务蝴蝶飞</td>
	           </tr>
	      </tbody>
	   </table>
	</div>
    <!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<!-- 私用js -->
	<script type="text/javascript">
				//默认禁用搜索和排序
				/* $.extend( $.fn.dataTable.defaults, {
				    searching: true,
				    ordering:  false
				} ); */
				// 这样初始化，排序将会打开
				$(function() {
					$('#table_history_exam_record').DataTable({
						"autoWidth" : false,
						//scrollY : 500,
						//paging : false,//分页
						//"searching" : false,
						"info" : false,//左下角信息
						//"ordering": false,//排序
						"aaSorting" : [], //默认第几个排序
						"aoColumnDefs" : [
						//{"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
						{
							"orderable" : false,
							"aTargets" : [ 0, 1, 2, 3, 4 ]
						} // 制定列不参与排序
						],
						colReorder : false,
						"sScrollX" : "100%",
						"sScrollXInner" : "100%",
						"bScrollCollapse" : true
					});
				});
		</script>
</body>

</html>