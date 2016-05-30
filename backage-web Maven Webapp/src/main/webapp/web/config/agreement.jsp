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
	<title>配置中心-协议配置</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link rel="stylesheet" href="css/config.css" />
	<script type="text/javascript" src="plugs/ueditor/ueditor.config.js"></script>
	<script type="text/javascript" src="plugs/ueditor/ueditor.all.min.js"></script>
	<script type="text/javascript" src="plugs/ueditor/lang/zh-cn/zh-cn.js"></script>
	<script type="text/javascript">
		var on_off =false; //停用启用权限标记
		<%
			if(operations.size()>0){
				for(int j=0;j<operations.size();j++){
					if(operations.get(j).getOptID()==61003){
		%>
			   		on_off =true;
		<%
					}
				}
			}
		%>
	</script>
</head>
<!-- 配置中心--------协议配置-->
<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="6" name="_index_m1"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-config.jsp">
				<jsp:param value="610" name="_index_m2"/>
				<jsp:param value="" name="_index_m3"/>
			</jsp:include>
			
			<!-- 主要内容 -->
			<div class="right_col role-content" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				
				<div class="nav-tabs-con active">
					<div class="data_display">
						<div class="panel panel-success">
						  <div class="panel-heading">
					  		<div class="action_item">
					<%
						if(operations.size()>0){
							for(int i = 0;i < operations.size(); i++){
								if(operations.get(i).getOptID() == 61001){
					%>				
								<button class="obtn glyphicon glyphicon-plus obtn-agreement-add" onclick="addOrModify(0)">添加</button>
					<%      
				      			}
				      			if(operations.get(i).getOptID() == 61002){
					%>				
								<button class="obtn glyphicon glyphicon-pencil obtn-agreement-mod" onclick="addOrModify(1)">修改</button>
					<%      
				      			}
					  		 }
						 }
				     %>	
							</div> 
						</div>
						<div class="panel-body">
							<table id="table_id" class="display">
								<thead>

								</thead>
								<tbody>
	
								</tbody>
							</table>
						</div>
					</div>
					<!-- 添加协议配置-->
					<div class="w-content agreement-add">
					<form action="javascript:addOrUpdate()" id="dataForm" method="post">
						<table>
							<tr>
								<td class="tt"><label>协议名称：</label></td>
								<td class="con">
									<select class="linkedoperation" name="select_type" id="select_type">
										<option value="-1">请选择</option>
										<option value="0">注册协议</option>
										<option value="1">投资协议</option>
										<option value="2">借款协议</option>
										<option value="3">债权转让协议</option>
										<option value="4">债权转让投资协议</option>
									</select>
								</td>
							</tr>
							<tr>
								<td class="tt"><label class="ineed">协议编辑：</label></td>
								<td class="con">
									<script id="agreementadd" type="text/plain" style="height:260px;width:98%;"></script>
								</td>
							</tr>
						</table>
						</form>
					</div>
					<div class="w-content report-det">
						详情
					</div>
				</div>
			</div>
			<!-- 尾部 -->
			
		</div>
		<!-- 公用js -->
		<jsp:include page="../common/cm-js.jsp"></jsp:include>
		<!-- 私用js -->
		<script type="text/javascript" src="js/configCenter/agreeConfig.js"></script>
		</div>
	</div>
</body>

</html>