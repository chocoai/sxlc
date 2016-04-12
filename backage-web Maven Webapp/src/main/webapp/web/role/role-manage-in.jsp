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
<title>角色管理-管理员管理</title>
<!-- 公用meta -->
<jsp:include page="../common/top-meta.jsp"></jsp:include>
<!-- 公用css -->
<jsp:include page="../common/cm-css.jsp"></jsp:include>
<link rel="stylesheet" href="css/role.css" />
<!-- 私用css -->
<script type="text/javascript" src="<%=basePath%>/plugs/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="js/md5.js"></script>
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
				<jsp:param value="role-4" name="role-index" />
			</jsp:include>
			<!-- 头部导航 -->

			<!-- 主要内容 -->
			<div class="right_col role-content">
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				
				<!-- tab切换 -->
				<ul class="nav nav-tabs">
					<li class="active"><a href="web/role/role-manage-in.jsp">内部管理员</a></li>
					<li><a href="web/role/role-manage-out.jsp">外部管理员</a></li>
				</ul>
				
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
								<span class="con-item"><span>管理员编码</span><input type="text" class="" placeholder="" /></span>
								<span class="con-item"><span>用户名称</span><input type="text" class="" placeholder="" /></span>
								
								<span class="con-item"><span>生成时间范围</span><input readonly="readonly"  id="start" name="start" class="Wdate" type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'end\')}'})"></span>
								
								<span class="con-item"><span>至 </span><input readonly="readonly"  id="end" name="end" class="Wdate" type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'start\')}'})"></span>
								
								<button class="obtn obtn-query glyphicon glyphicon-search">查询</button>
							</form>
						</div>
					</div>
				</div>
				
				<!-- 数据显示 -->
				<!-- 内部管理员 -->
				<div class="data_display">
					<div class="panel panel-success">
						<div class="panel-heading">
							<div class="action_item">
								<button class="obtn glyphicon glyphicon-plus obtn-manage-det" onclick="manageDet('管理员详细信息')">管理员详细信息</button>
								<button class="obtn glyphicon glyphicon-plus obtn-manage-add" onclick="manageAdd('添加内部管理员','0')">添加</button>
								<button class="obtn glyphicon glyphicon-pencil obtn-manage-mod" onclick="manageMod('修改内部管理员','0')">修改</button>
								<!-- <button class="obtn glyphicon glyphicon-trash obtn-manage-del" onclick="manageDel()">删除</button> -->
							</div>
						</div>
						<div class="panel-body">
							<table id="tb-manage-in" class="display">
								<thead>
									<tr>
									</tr>
								</thead>
								<tbody>
								</tbody>
							</table>
						</div>
						
					</div>
				</div>
				
				<!-- 详情 -->
				<div class="w-content" id="manage-det">
					<table>
						<tr>
							<td class="tt"><label>用户名:</label></td>
							<td class="con">
								<input type="text" class="" name="userName" value="" />
							</td>
							<td class="tt"><label>每日登录时间范围:</label></td>
							<td class="con">
								<input type="text" class="" name="timeLimit" value="" />
							</td>
						</tr>
						<tr>
							<td class="tt"><label>姓名:</label></td>
							<td class="con">
								<input type="text" class="" name="name" value="" />
							</td>
							<td class="tt"><label>性别:</label></td>
							<td class="con">
								<input type="text" class="" name ="sex" value="" />
							</td>
						</tr>
						<tr>
							<td class="tt"><label>身份证号:</label></td>
							<td class="con">
								<input type="text" class="" name="idcard" value="" />
							</td>
							<td class="tt"><label>出生日期:</label></td>
							<td class="con">
								<input type="text" class="" name="birth" value="" />
							</td>
						</tr>
						<tr>
							<td class="tt"><label>民族:</label></td>
							<td class="con">
								<input type="text" class="" name="nation" value="" />
							</td>
							<td class="tt"><label>职务:</label></td>
							<td class="con">
								<input type="text" class="" name="poster" value="" />
							</td>
						</tr>
						<tr>
							<td class="tt"><label>联系电话:</label></td>
							<td class="con">
								<input type="text" class="" name="phone" value="" />
							</td>
							<td class="tt"><label>QQ:</label></td>
							<td class="con">
								<input type="text" class="" name="qq" value="" />
							</td>
						</tr>
						<tr>
							<td class="tt"><label>Email:</label></td>
							<td class="con">
								<input type="text" class="" name="email" value="" />
							</td>
							<td class="tt"><label>户籍:</label></td>
							<td class="con">
								<input type="text" class="" name="home" value="" />
							</td>
						</tr>
						<tr>
							<td class="tt"><label>现居住地:</label></td>
							<td class="con">
								<input type="text" class="" name="address" value="" />
							</td>
							<td class="tt"><label>学历:</label></td>
							<td class="con">
								<input type="text" class="" name="education" value="" />
							</td>
						</tr>
						<tr>
							<td class="tt"><label>毕业时间:</label></td>
							<td class="con">
								<input type="text" class="" name="graduTime" value="" />
							</td>
							<td class="tt"><label>紧急联系人姓名:</label></td>
							<td class="con">
								<input type="text" class="" name="connect" value="" />
							</td>
						</tr>
						<tr>
							<td class="tt"><label>紧急联系人电话:</label></td>
							<td class="con">
								<input type="text" class="" name="cFhone" value="" />
							</td>
							<td class="tt"><label>所属部门:</label></td>
							<td class="con">
								<input type="text" class="" name="departMent" value="" />
							</td>
						</tr>
						<!-- <tr>
							<td class="tt"><label>所拥有权限:</label></td>
							<td class="con">
								<input type="text" class="" value="" />
							</td>
							<td class="tt"><label>上次登录时间:</label></td>
							<td class="con">
								<input type="text" class="" value="" />
							</td>
						</tr> -->
					</table>
				</div>
				
				<!-- 添加管理员 -->
				
				<div class="w-content" id="manage-add-staff">
					<table id="staffListTb" class="display">
						<thead>
							<tr>
							</tr>
						</thead>
						<tbody>
						</tbody>
					</table>
				</div>
				
				<div class="w-content" id="manage-addOrUpdate-admin" >
					<form id="form-admin"  method="post" action="javascript:sumitAdmin()">
						<table>
							<tr>
								<td class="tt"><label class="ineed">姓名:</label></td>
								<td class="con">
									<input type="hidden" class="" name="addOrUpdate" id="addOrUpdate" readonly="readonly"   value="" />
									<input type="hidden" class="" name="adminId" id="adminId" readonly="readonly"   value="" />
									<input type="hidden" class="" name="staffId" id="staffId" readonly="readonly"   value="" />
									<input type="text" class="" name="userName" id="userName" readonly="readonly"   value="" />
								</td>
								
							</tr>
							<tr>
								<td class="tt"><label class="ineed">管理员名称:</label></td>
								<td class="con">
									<input type="text" class="" name="adminName" id="adminName" datatype="logname" placeholder="登录名" />
								</td>
							</tr>
							<tr>
								<td class="tt"><label class="ineed">管理员角色:</label></td>
								<td class="con">
									<select name="adminRole" class="" id="adminRole" style="width:182px;height:30px">
										<option  value="-1">请选择</option>
										<c:forEach var="roles" items="${roleList}">
											<option  value="${roles.id}">${roles.roleName}</option>
										</c:forEach>
							          </select>
								</td>
							</tr>
							<tr>
								<td class="tt"><label>密码:</label></td>
								<td class="con"> 
									<input type="password" class="" name="adminPwd"  title="newpass" datatype="regpass" value="" />
								</td>
							</tr>
							<tr>
								<td class="tt"><label>再次输入密码:</label></td>
								<td class="con"> 
									<input type="password" class="" name="adminPwd1" datatype="repass" value="" />
								</td>
							</tr>
							<tr>
								<td class="tt"><label>备注:</label></td>
								<td class="con"> 
									<textarea style="width:182px;height: 70px;" id="adminRemark" name="adminRemark" ></textarea>
								</td>
							</tr>
					    </table>
					</form>
				</div>
				
				

			</div>
		</div>
	</div>
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<script type="text/javascript" src="js/valid.js"></script>
	<script type="text/javascript" src="js/role/role-manage.js"></script>
</body>

</html>