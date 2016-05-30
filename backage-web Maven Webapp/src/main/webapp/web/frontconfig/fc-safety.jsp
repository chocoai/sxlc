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
	<title>前台界面配置-首页安全</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<link rel="stylesheet" href="css/frontconfig/frontconfig.css" />
	<link rel="stylesheet" href="plugs/webuploader/0.1.5/webuploader.css" />
	<link rel="stylesheet" href="css/upload.css" />
	<!-- 私用css -->
	<link rel="stylesheet" href="css/frontconfig/fc-safety.css" type="text/css"/>
	<script type="text/javascript" src="plugs/ueditor/ueditor.config.js"></script>
	<script type="text/javascript" src="plugs/ueditor/ueditor.all.min.js"></script>
	<script type="text/javascript" src="plugs/ueditor/lang/zh-cn/zh-cn.js"></script>
	
	
	<script type="text/javascript">
		var on_off =false; //停用启用权限标记
		<%
			if(operations.size()>0){
				for(int j=0;j<operations.size();j++){
					if(operations.get(j).getOptID()==52102){
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
			<jsp:param value="521" name="_index_m2"/>
			<jsp:param value="" name="_index_m3"/>
		</jsp:include>
		<!-- 主要内容 -->
		<div class="right_col" role="main">	
			<!-- 地址导航 -->
			<jsp:include page="../common/cm-addr.jsp"></jsp:include>
			<div class="data_display">
				<div class="panel panel-success">
					<div class="panel-heading">
						<div class="action_item">

					<%
						if(operations.size()>0){
							for(int i = 0;i < operations.size(); i++){
								
				      			if(operations.get(i).getOptID() == 10601){
					%>				
									<button class="obtn glyphicon glyphicon-pencil obtn-safety-mod" type="button">编辑</button>
					<%      
				      			}
					  		 }
						 }
				     %>	

						</div>
					</div>
					<div class="panel-body">
						<table id="partnerTb" class="display">
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
	
	<!-- 弹出头像 -->
	 <div class="w-content picture">
			 <div class="w-content hideHtml">暂无头像</div>
			<img id="picView" src="">
	</div>
	<div class="w-content report-det">
		详情
	</div>
	<!-- 弹出层修改页 -->

	<div class="modify w-content" >
		<form method="post" action="javascript:modifySafe()" id="dataForm">
		<input type="hidden" name="lId" id="lId"/>
		<input type="hidden" id="hostPath" value="${ImgProfix}"/>
		<table>
			<tr>
				<td class="tt"><label>保障标题：</label></td>
				<td class="con">
					<input type="text" class="" datatype="unNormal" maxlength="25" id="title" name="title" placeholder="保障标题" value="" />
				</td>
			</tr>
			<tr>
				<td class="tt"><label>上传图片：</label></td>
				<td class="con">
					<input type="hidden" name="imgPath" id="imgPath"/>
					<div id="logo">
					    <!--用来存放item-->
					    <div id="filePicker">选择图片</div>
					    <span class="rec-dimensions">建议尺寸：25*25</span>
					</div>
				</td>
			</tr>
			<tr>
				<td class="tt" valign="top">图片预览：</td>
				<td class="con" id="fileList"></td>
				
			</tr>
			<tr>
				<td class="tt"><label>链接地址：</label></td>
				<td class="con">
					<input type="text"  datatype="strRegex" class="" name="imgUrl" id="imgUrl" placeholder="请输入保障链接地址" value="" />
				</td>
			</tr>
			<tr>
				<td class="tt"><label>保障内容：</label></td>
				<td class="con">
					<script id="applyguide"  type="text/plain" style="height:160px;width:98%;"></script>
				</td>
			</tr>
		</table>
		 </form>
		
	</div>


	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<script type="text/javascript" src="plugs/webuploader/0.1.5/webuploader.js"></script>
	<script type="text/javascript" src="js/exp-upload.js"></script>	
	<!-- 私用js -->

	<script type="text/javascript" src="js/frontconfig/fc-safe.js"></script>

</body>
</html>