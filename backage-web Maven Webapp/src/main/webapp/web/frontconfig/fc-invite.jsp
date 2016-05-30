<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@page import="cn.springmvc.model.Operation"%>
<%
request.setCharacterEncoding("UTF-8");
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	/* 登录人操作权限 */
	List<Operation> operations = null;
	if(session.getAttribute("operationList") != null){
		operations = (List<Operation>)session.getAttribute("operationList");

	}
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
	<script type="text/javascript">
		var on_off =false; //停用启用权限标记
		<%
			if(operations.size()>0){
				for(int j=0;j<operations.size();j++){
					if(operations.get(j).getOptID()==50803){
		%>
			   		on_off =true;
		<%
					}
				}
			}
		%>
	</script>
</head>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="5" name="_index_m1"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-frontconfig.jsp">
				<jsp:param value="508" name="_index_m2"/>
				<jsp:param value="" name="_index_m3"/>
			</jsp:include>
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
			
				<div class="data_display">
					<div class="panel panel-success">
						
						
						<div class="w-content report-det">
							详情
						</div>
						<div class="w-content  pic-add">
						<form  id="dataForm" method="post">
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
						<div class="panel-heading">
							<div class="action_item">
					<%
						if(operations.size()>0){
							for(int i = 0;i < operations.size(); i++){
								if(operations.get(i).getOptID() == 50801){
					%>				
								<button class="obtn glyphicon glyphicon-plus obtn-invite-add" onclick="addOrModify(0)">添加</button>
					<%      
				      			}
				      			if(operations.get(i).getOptID() == 50802){
					%>				
								<button class="obtn glyphicon glyphicon-pencil obtn-invite-mod" onclick="addOrModify(1)">修改</button>
					<%      
				      			}
					  		 }
						 }
				     %>	
							</div>
						</div>
						
						<div class="panel-body">
							<table id="teamTb" class="display">
								<thead></thead>
								<tbody></tbody>
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
	
	<script type="text/javascript" src="plugs/ueditor/ueditor.config.js"></script>
	<script type="text/javascript" src="plugs/ueditor/ueditor.all.min.js"></script>
	<script type="text/javascript" src="plugs/ueditor/lang/zh-cn/zh-cn.js"></script>
	<script type="text/javascript" src="js/frontconfig/invite.js"></script>
	<!-- 私用js -->
	<script type="text/javascript">
		$(function(){
			//编辑器实例化
			var ue1 = UE.getEditor('duty');
			var ue2 = UE.getEditor('demand');
		});
	</script>
</body>

</html>