<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
	<base href="<%=basePath%>">
	<title>添加招贤纳士信息</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
</head>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
		
			<div class="w-content ishow pic-add">
				<table>
					<tr>
						<td class="tt">招聘职位</td>
						<td class="con"><input type="text" class="" /></td>
					</tr>
					<tr>
						<td class="tt">工作地区</td>
						<td class="con">
							<select>
								<option>选择地区</option>
							</select>
						</td>
					</tr>
					<tr>
						<td class="tt">岗位职责</td>
						<td class="con portrait-box">
							选还是填，不清
						</td>
					</tr>
					<tr>
						<td class="tt">任职要求</td>
						<td class="con">
							选还是填，不清
						</td>
					</tr>
				</table>
			</div>
			
		</div>
	</div>
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	
	<script type="text/javascript" src="js/frontconfig/fc-invite.js"></script>
	<!-- 私用js -->
	<script type="text/javascript">
		
	</script>
</body>

</html>