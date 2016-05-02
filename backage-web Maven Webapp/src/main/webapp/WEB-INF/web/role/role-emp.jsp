<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<title>角色管理</title>
<!-- 公用meta -->
<jsp:include page="../common/top-meta.jsp"></jsp:include>
<!-- 公用css -->
<jsp:include page="../common/cm-css.jsp"></jsp:include>
<!-- 私用css -->
<link rel="stylesheet" href="css/role.css" />
<script type="text/javascript" src="<%=basePath%>/plugs/My97DatePicker/WdatePicker.js"></script>
</head>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="1" name="top_menu_index" />
				<jsp:param value="角色管理" name="loc1" />
			</jsp:include>
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-left-menu.jsp">
				<jsp:param value="role-2" name="role-index" />
			</jsp:include>
			<!-- 头部导航 -->

			<!-- 主要内容 -->
			<div class="right_col role-content">
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				<div class="search">
					<div class="panel panel-success">
						<div class="panel-heading">
							<div class="i-fl search_title">条件查询</div>
							<div class="i-fr action_item">
								<ul class="list_item list-inline">
									<li><a class="state">展开&nbsp;<span
											class="glyphicon glyphicon-chevron-down"></span> </a></li>
								</ul>
							</div>
						</div>
						<div class="panel-body">
							<form id="" class="" action="">
								<span class="con-item"><span>姓名</span><input type="text" class="" id="personalNameQuery" placeholder="姓名" /></span>
								<span class="con-item"><span>身份证号</span><input type="text" class="" id="personalIDCardQuery" placeholder="身份证号" /></span>
								<span class="con-item"><span>职务</span>
<!-- 									<input type="text" class="" id="postId" placeholder="职务" /> -->
									<input type="text" disabled="disabled" style="width:130px" name="" id="postIdQuery" class="postId" />
									<button class="btn btn-primary btn-xs deptSelect" type="button">选择</button>
								</span>
								&nbsp;&nbsp;&nbsp;
								<span class="con-item"><span>联系电话</span><input type="text" class="" id="personalPhoneQuery" placeholder="联系电话" /></span>
								<button class="obtn obtn-query glyphicon" id="queryBtn" type="button">查询</button>
							</form>
						</div>
					</div>
				</div>
				<div class="data_display">
					<div class="panel panel-success">
						<div class="panel-heading">
							<div class="action_item">
								<button class="obtn glyphicon glyphicon-plus obtn-emp-add" type="button">添加</button>
								<button class="obtn glyphicon glyphicon-pencil obtn-emp-mod" type="button">修改</button>
								<button class="obtn glyphicon glyphicon-trash obtn-emp-del" type="button">删除</button>
							</div>
						</div>
						<div class="panel-body">
							<table id="staffListTb" class="display">
							</table>
						</div>
						<div class="w-content emp-add">
							<form action="javascript:addStaff()" id="dataForm" method="post">
								<table>
									<tr>
										<td class="tt"><label class="ineed">姓名：</label></td>
										<td class="con">
											<input type="text" name="baseInfo.personalName" id="personalName" placeholder="" datatype="z2_8" errormsg="错误！"/>
										</td>
										<td class="tt"><label class="ineed">性别：</label></td>
										<td class="con">
											<input id="man" type="radio" checked="checked" name="baseInfo.sexId" value="0"/>男 &nbsp;&nbsp;&nbsp;
											<input id="man" type="radio"  name="baseInfo.sexId" value="1" />女
										</td>
									</tr>
									<tr>
										<td class="tt"><label class="ineed">身份证号：</label></td>
										<td class="con">
											<input type="text" name="baseInfo.personalIDCard" id="personalIDCard" class="idCard" datatype="idcard"/>
										</td>
										<td class="tt"><label class="">出生日期：</label></td>
										<td class="con">
											<input type="text" name="" id="birthday" disabled="disabled" class="" placeholder="" />
										</td>
									</tr>
									<tr>
										<td class="tt"><label class="">民族：</label></td>
										<td class="con">
											 <select name="baseInfo.nationId" class="" id="nationId">
												<c:forEach var="nation" items="${nations}">
													<option value="${nation.iId}">${nation.sName}</option>
												</c:forEach>
							                  </select>
										</td>
										<td class="tt"><label class="ineed">联系电话：</label></td>
										<td class="con">
											<input type="text" name="baseInfo.personalPhone" id="personalPhone" class="personalPhone" datatype="zPhone" placeholder="" />
										</td>
									</tr>
									<tr>
										<td class="tt"><label class="">QQ：</label></td>
										<td class="con">
											<input type="text" name="baseInfo.qq" id="qq" class="" datatype="qq" placeholder="" />
										</td>
										<td class="tt"><label class="">Email：</label></td>
										<td class="con">
											<input type="text" name="baseInfo.personalEmail" id="personalEmail" class="" datatype="email" placeholder="" />
										</td>
									</tr>
									<tr>
										<td class="tt"><label class="">户籍：</label></td>
										<td class="con">
											<input type="text" name="baseInfo.homeTown" id="homeTown" class="" placeholder="" />
										</td>
										<td class="tt"><label class="ineed">现居住地：</label></td>
										<td class="con">
											<input type="text" name="baseInfo.houseAddress" id="houseAddress" class="" datatype="enterAddress" placeholder="" />
										</td>
									</tr>
									<tr>
										<td class="tt"><label class="education">学历：</label></td>
										<td class="con">
											 <select name="baseInfo.education" class="" id="education">
												<c:forEach var="education" items="${educations}">
													<option value="${education.iId}">${education.sEducationName}</option>
												</c:forEach>
							                  </select>
										</td>
										<td class="tt"><label class="ineed">毕业时间：</label></td>
										<td class="con">
											<input type="text" name="graduatedDate" id="graduatedDate"  class="" onfocus="WdatePicker({isShowWeek:true})"  placeholder="" />
										</td>
									</tr>
									<tr>
										<td class="tt"><label class="ineed	">紧急联系人姓名：</label></td>
										<td class="con">
											<input type="text" name="emerName" id="emerName" class="" datatype="z2_8" placeholder="" />
										</td>
										<td class="tt"><label class="ineed">紧急联系人电话：</label></td>
										<td class="con">
											<input type="text" name="emerPhone" id="emerPhone" class="" datatype="zPhone" placeholder="" />
										</td>
									</tr>
									<tr>
										<td class="tt"><label class="">职务：</label></td>
										<td class="con">
											<input type="text" disabled="disabled" style="width:130px" name="" id="postName" class="postId" />
											<button class="btn btn-primary btn-xs deptSelect" type="button">选择</button>
							                  <input type="hidden" name="id" id="staffId"/>
							                  <input type="hidden" name="baseInfo.id" id="personalId"/>
										</td>
									</tr>
									
								</table>
								</form>
						</div>
						<div class="w-content dept-select">
							<div class="panel-body">
								部门名称：<input class="w4" />
								&nbsp;
								职务名称：<input class="w4" />
								&nbsp;
								<button class="obtn obtn-query" type="button">查询</button>
								<br>
							</div>
							<div class="panel-body">
								<table id="deptTbList" class="display">
								</table>
							</div>
						</div>
					</div>
				</div>

			</div>
			<!-- 公用js -->
			<jsp:include page="../common/cm-js.jsp"></jsp:include>
			<script type="text/javascript" src="js/role.js"></script>
			<!-- 私用js -->
			<script type="text/javascript" src="js/role/role-emp.js"></script>
		</div>
	</div>
</body>

</html>