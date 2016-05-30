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
	<title>前台界面配置-专家顾问</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link rel="stylesheet" href="css/frontconfig/frontconfig.css" />
	<link rel="stylesheet" href="css/upload.css" />
	<link rel="stylesheet" href="plugs/webuploader/0.1.5/webuploader.css" />
	<script type="text/javascript">
		var on_off =false; //停用启用权限标记
		<%
			if(operations.size()>0){
				for(int j=0;j<operations.size();j++){
					if(operations.get(j).getOptID()==50503){
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
				<jsp:param value="505" name="_index_m2"/>
				<jsp:param value="" name="_index_m3"/>
			</jsp:include>
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				<div class="data_display">
					<div class="panel panel-success">
					
					<div class="w-content pic-add">
							<form action="javascript:addOrUpdate()" id="dataForm" method="post">
								<table>
									<tr>
										<td class="tt">姓名</td>
										<td class="con"><input type="text" name="mngName" id="mngName" class="" datatype="z2_8" /></td>
									</tr>
									<tr>
										<td class="tt">职务</td>
										<td class="con"><input type="text" name="mngPost" id="mngPost" class="" /></td>
									</tr>
									<tr>
										<td class="tt">头像</td>
										<td class="con portrait-box">
											<!--dom结构部分-->
											<div id="uploader">
											    <!--用来存放item-->
											    <div class="fileList" id="fileList"></div>
											    <div id="filePicker">选择头像</div>
											    <span class="rec-dimensions">建议尺寸：100*100</span>
											    <img id="portrait" src="">
											     <input type="hidden" name="portraitUrl" id="portraitUrl" />
											</div>
										</td>
									</tr>
									<tr>
										<td class="tt" valign="top">简介</td>
										<td class="con">
											<textarea rows="6" cols="" name="profile" id="profile" class="ta-noresize w500" placeholder="简介"></textarea>
										</td>
									</tr>
								</table>
								</form>
							</div>
						<!-- 弹出头像 -->
						 <div class="w-content picture">
								 <div class="w-content hideHtml">暂无头像</div>
								<img id="picView" src="">
						</div>
						<div class="w-content report-det">
							详情
						</div>
						
						<div class="panel-heading">
							<div class="action_item">
				<%
					if(operations.size()>0){
						for(int i = 0;i < operations.size(); i++){
							
			      			if(operations.get(i).getOptID() == 50501){
				%>				
								<button class="obtn glyphicon glyphicon-plus obtn-experts-add" onclick="addOrModify(0)">添加</button>
				<%      
			      			}
			      				
			      			if(operations.get(i).getOptID() == 50502){
				%>				
								<button class="obtn glyphicon glyphicon-pencil obtn-experts-mod" onclick="addOrModify(1)">修改</button>
				<%     
			      			}
				  		 }
					 }
			     %>	
				
							</div>
						</div>
						
						<div class="panel-body">
							<table id="teamTb" class="display">
								<thead>
								</thead>
								<tbody>
								</tbody>
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
	<script type="text/javascript" src="plugs/webuploader/0.1.5/webuploader.js"></script>
	<script type="text/javascript" src="js/exp-upload.js"></script>	
	<script type="text/javascript" src="js/frontconfig/cf-exper.js"></script>

</body>

</html>