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
	<title>前台界面配置-合作伙伴</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link rel="stylesheet" href="plugs/webuploader/0.1.5/webuploader.css" />
	<link rel="stylesheet" href="css/upload.css" />
	<link rel="stylesheet" href="css/frontconfig/frontconfig.css" />
	<script type="text/javascript" src="plugs/ueditor/ueditor.config.js"></script>
	<script type="text/javascript" src="plugs/ueditor/ueditor.all.min.js"></script>
	<script type="text/javascript" src="plugs/ueditor/lang/zh-cn/zh-cn.js"></script>
</head>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="5" name="top_menu_index"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-frontconfig.jsp"></jsp:include>
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				
				<div class="data_display">
					<div class="panel panel-success">
						<div class="panel-heading">
							<div class="action_item">
								<button class="obtn glyphicon glyphicon-plus obtn-partner-add" onclick="addPartner('添加合作伙伴','web/common/picture/pic-add.jsp','2')" type="button">添加</button>
								<button class="obtn glyphicon glyphicon-pencil obtn-partner-mod" onclick="modPartner('修改合作伙伴','web/common/picture/pic-add.jsp','2')" type="button">修改</button>
								<button class="obtn" onclick="ableDisable()">停用/启用</button>
								<%-- <input type="hidden" id="hostPath" value="${hostPath}"/> --%>
							</div>
						</div>
						
						<div class="panel-body">
							<table id="partnerTb" class="display">
								<thead>
									<tr>
										<th class="table-checkbox"></th>
										<th>添加时间</th>
										<th>合作伙伴图片</th>
										<th>合作伙伴名称</th>
										<th>合作伙伴链接</th>
										<th>合作伙伴简介</th>
										<th>状态</th>
										<th>最近一次操作管理员</th>
									</tr>
								</thead>
								<tbody>
								<%for (int i=0;i<5;i++){ %>
									<tr>
										<td><input type="checkbox" /></td>
										<td>添加时间</td>
										<td>合作伙伴图片</td>
										<td>合作伙伴名称</td>
										<td>合作伙伴链接</td>
										<td>合作伙伴简介</td>
										<td>有效</td>
										<td>最近一次操作管理员</td>
									</tr>
									<%}%>
								</tbody>
							</table>
						</div>
						
					</div>
				</div>
				<!-- <div class="w-content report-det">
					详情
				</div>
				<div class="w-content pic-view">
								<div class="w-content hideHtml">暂无头像</div>
								<img id="picView" src="">
				</div> -->
				
				
			</div>
		</div>
	</div>
	<!-- 尾部 -->
	
	
	
	
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<!-- 私用js -->
	<script type="text/javascript">
		$('#partnerTb').DataTable({
			"aaSorting" : [ [ 1, "desc" ] ],//默认第几个排序
			"aoColumnDefs" : [
			//{"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
			{
				"orderable" : false,
				"aTargets" : [0,1,2,3,4,5,6,7]
			} // 制定列不参与排序
			],
		});
	</script>
	<script type="text/javascript" src="plugs/webuploader/0.1.5/webuploader.js"></script>
	<script type="text/javascript" src="js/valid.js"></script>
	<script type="text/javascript" src="js/frontconfig/fc-mediaReport.js"></script>
	<script type="text/javascript" src="js/exp-upload.js"></script>
	
</body>

</html>