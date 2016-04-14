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
	<title>前台界面配置-招贤纳士</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link rel="stylesheet" href="css/frontconfig/frontconfig.css" />
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
					
						<div class="w-content  pic-add">
						<form action="javascript:addMngTeam()" id="dataForm" method="post">
								<table>
									<tr>
										<td class="tt">招聘职位</td>
										<td class="con"><input type="text" class="" id="name"  datatype="z2_8" /></td>
										<td class="tt">工作地区</td>
										<td class="con"><input type="text" class=""  id="area"  datatype="z2_8"/></td>
									</tr>
									<tr>
										<td class="tt">岗位职责</td>
										<td class="con" colspan="3">
											<script id="duty" type="text/plain" style="height:300px;width:98%;"></script>
										</td>
									</tr>
									<tr>
										<td class="tt">任职要求</td>
										<td class="con" colspan="3">
											<script id="demand" type="text/plain" style="height:300px;width:98%;"></script>
										</td>
									</tr>
								</table>
								</form>
							</div>
					
						<div class="w-content  pic-mod">
						<form action="javascript:updateRecruitments()" id="dataFor" method="post">
							<table>
								<tr>
									<td class="tt">招聘职位</td>
									<td class="con"><input type="text" class=""  id="nam"  datatype="z2_8" /></td>
								</tr>
								<tr>
									<td class="tt">工作地区</td>
										<td class="con"><input type="text" class=""  id="are"  datatype="z2_8"/></td>
								</tr>
								<tr>
									<td class="tt">岗位职责</td>
									<td class="con" colspan="3">
											<script id="dutys" type="text/plain" style="height:300px;width:98%;"></script>
										</td>
								</tr>
								<tr>
									<td class="tt">任职要求</td>
								<td class="con" colspan="3">
											<script id="demands" type="text/plain" style="height:300px;width:98%;"></script>
										</td>
								</tr>
							</table>
							</form>
						</div>
					
					
						<div class="panel-heading">
							<div class="action_item">
								<button class="obtn glyphicon glyphicon-plus obtn-invite-add" onclick="inviteAdd()">添加</button>
								<button class="obtn glyphicon glyphicon-pencil obtn-invite-mod" onclick="inviteMod()">修改</button>
							</div>
						</div>
						
						<div class="panel-body">
							<table id="teamTb" class="display">
							</table>
						</div>
						
					</div>
				</div>
				
				
				
			</div>
		</div>
	</div>
	<!-- 尾部 -->
	
	
	
	
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<!-- 私用js -->
	<script type="text/javascript" src="js/frontconfig/fc-invite.js"></script>
	<script type="text/javascript" src="js/frontconfig/invite.js"></script>
	<script type="text/javascript" src="plugs/ueditor/ueditor.config.js"></script>
	<script type="text/javascript" src="plugs/ueditor/ueditor.all.min.js"></script>
	<script type="text/javascript" src="plugs/ueditor/lang/zh-cn/zh-cn.js"></script>
	<!-- 私用js -->
	<script type="text/javascript">
		$(function(){
			//编辑器实例化
			var ue1 = UE.getEditor('duty');
			var ue2 = UE.getEditor('demand');
		});
	</script>
		 <script type="text/javascript">
		$(function(){
			//编辑器实例化
			var ue4 = UE.getEditor('dutys');
			var ue5 = UE.getEditor('demands');
		}); 
	</script>
</body>

</html>