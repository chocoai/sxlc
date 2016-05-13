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
		<div class="w-content">
			<table>
				<tr>
					<td class="tt"><label>借款项目名称：</label></td>
					<td class="con">
						<span></span>
					</td>
				</tr>
				<tr>
					<td class="tt"><label>借款金额：</label></td>
					<td class="con">
						<span></span>
					</td>
				</tr>
				<tr>
					<td class="tt"><label>还款方式：</label></td>
					<td class="con">
						<span></span>
					</td>
				</tr>
				<tr>
					<td class="tt"><label>还款保障：</label></td>
					<td class="con">
						<span></span>
					</td>
				</tr>
				<tr>
					<td class="tt"><label>借款用途：</label></td>
					<td class="con">
						<span></span>
					</td>
				</tr>
				<tr>
					<td class="tt"><label>还款来源：</label></td>
					<td class="con">
						<span></span>
					</td>
				</tr>
				<tr>
					<td class="tt"><label>借款期限：</label></td>
					<td class="con">
						<span></span>
					</td>
				</tr>
				<tr>
					<td class="tt"><label>设置最大投资比例：</label></td>
					<td class="con">
						<span></span>
					</td>
				</tr>
				<tr>
					<td class="tt"><label>年化利率：</label></td>
					<td class="con">
						<span></span>
					</td>
				</tr>
				<tr>
					<td class="tt"><label>起投金额：</label></td>
					<td class="con">
						<span></span>
					</td>
				</tr>
				<tr>
					<td class="tt"><label>加价幅度：</label></td>
					<td class="con">
						<span></span>
					</td>
				</tr>
				<tr>
					<td class="tt"><label>投资上限：</label></td>
					<td class="con">
						<span></span>
					</td>
				</tr>
				<tr>
					<td class="tt"><label>项目描述：</label></td>
					<td class="con">
						<span></span>
					</td>
				</tr>
				<tr>
					<td class="tt"><label></label></td>
					<td class="con">
						<button type="submit" class="btn btn-success">确认提交</button>
					</td>
				</tr>
			</table>
		</div>
	</div>
    <!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<!-- 私用js -->
</body>

</html>