<%@page import="cn.springmvc.model.Operation"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
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
	<title>前台界面配置-首页弹出公告</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link rel="stylesheet" href="plugs/webuploader/0.1.5/webuploader.css" />
	<link rel="stylesheet" href="css/upload.css" />
	<script type="text/javascript">
		var on_off =false; //停用启用权限标记
		<%
			if(operations.size()>0){
				for(int j=0;j<operations.size();j++){
					if(operations.get(j).getOptID()==51603){
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
		<!-- 头部 -->
		<jsp:include page="../common/cm-top.jsp">
			<jsp:param value="5" name="_index_m1"/>
		</jsp:include>		
		<!-- 左侧菜单 -->
		<jsp:include page="../common/cm-frontconfig.jsp">
			<jsp:param value="518" name="_index_m2"/>
			<jsp:param value="" name="_index_m3"/>
		</jsp:include>
		<!-- 主要内容 -->
		<div class="right_col" role="main">	
			<!-- 地址导航 -->
			<jsp:include page="../common/cm-addr.jsp"></jsp:include>
			<div class="data_display">
				<div class="panel panel-success">
					<div class="panel-heading">
						<div class="panel-heading">
							<div class="action_item">
							<%
						if(operations.size()>0){
							for(int i = 0;i < operations.size(); i++){
								
				      			if(operations.get(i).getOptID() == 51801){
					%>				
									<button class="obtn glyphicon glyphicon-plus obtn-pic-add" type="button" onclick="addOrUpdate(1)">添加</button>
					<%      
				      			}
				      			if(operations.get(i).getOptID() == 51802){
					%>				
									<button class="obtn glyphicon glyphicon-pencil obtn-pic-mod" type="button" onclick="addOrUpdate(2)">修改</button>
					<%      
				      			}
					  		 }
						 }
				     %>	
							</div>
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
			</div>
		</div>
	</div>
		<div class="w-content pic-add">
		<form action="javascript:addOrModify()" id="dataForm" method="post">
			<table>
					<tr>
						<td class="tt"><label style="width:107px;">公告链接：</label></td>
						<td class="con" id="fullAdLink1">
							<input type="text" id="url" class="" datatype="strRegex">
						</td>
					</tr>
					<tr>
						<td class="tt"><label>公告弹出开始时间：</label></td>
						<td class="con">
							<input type="text" id="startDate" class="dateInput Wdate"  datatype="unNormal" onFocus="WdatePicker({maxDate: '#F{$dp.$D(\'endDate\')||\'2020-10-01\'}' })" >
						</td>
					</tr>
					<tr>
						<td class="tt"><label>公告弹出结束时间：</label></td>
						<td class="con">
							<input type="text" id="endDate" class="dateInput Wdate"   datatype="unNormal" onFocus="WdatePicker({minDate: '#F{$dp.$D(\'startDate\')}' ,maxDate:'2020-10-01' })" >
						</td>
					</tr>
					<tr>
						<td class="tt"><label>上传图片：</label></td>
						<td class="con">
							<div id="uploader">
						    <!--用来存放item-->
						    <div id="filePicker">选择图片</div>
						     <span class="rec-dimensions">建议尺寸：580*280</span>
						     <input type="hidden" name="imgPath" id="imgPath" />
						     <input type="hidden" name="bannerId" id="bannerId" />
						    <input type="hidden" id="hostPath" value="${ImgProfix}"/>
						</div>
						</td>
					</tr>
					<tr>
						<td class="tt" valign="top">图片预览：</td>
						<td class="con" id="fileList"></td>
					</tr>																
				</table>
		</form>
	</div>
	<div class="w-content pic-view">
		<div class="w-content hideHtml">暂无图片</div>
		<img id="picView" src="">
	</div>
	
	<!-- 弹出层添加页 -->
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<!-- 私用js -->
	<script type="text/javascript" src="plugs/webuploader/0.1.5/webuploader.js"></script>
	<script type="text/javascript" src="js/exp-upload.js"></script>
	<script type="text/javascript" src="js/frontconfig/frontfulladd.js"></script>
</body>
</html>