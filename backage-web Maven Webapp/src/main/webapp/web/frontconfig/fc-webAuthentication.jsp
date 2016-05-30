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
	<title>前台界面配置-底部导航管理</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link rel="stylesheet" href="css/frontconfig/fc-webAuthentication.css"/>
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
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="5" name="_index_m1"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-frontconfig.jsp">
				<jsp:param value="516" name="_index_m2"/>
				<jsp:param value="" name="_index_m3"/>
			</jsp:include>
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				<div class="nav-tabs-con active">
					<div class="search">
						<div class="panel panel-success">
							<div class="panel-heading">
								<div class="i-fl search_title">条件查询</div>
								<div class="i-fr action_item">
									<ul class="list_item list-inline">
										<li>
											<a class="state">展开&nbsp;<span class="glyphicon glyphicon-chevron-down"></span> </a>
										</li>
									</ul>
								</div>
							</div>
							<div class="panel-body">
								<form id="" class="" action="">
									<span class="con-item">
										<span>网站认证资料标题</span><input type="text" id="titles" class=""/>
									</span>
									<span class="con-item">
										<span>状态</span>
										<select class="w3" id="statu">
											<option value="-1">请选择</option>
											<option value="1">已启用</option>
											<option value="0">已停用</option>
										</select>
									</span>
									<button class="obtn obtn-query glyphicon glyphicon-search">查询</button>
								</form>
							</div>
						</div>
					</div>
				<div class="data_display">
					<div class="panel panel-success">
						<div class="panel-heading">
							<div class="action_item">
								
								
							<%
						if(operations.size()>0){
							for(int i = 0;i < operations.size(); i++){
								
				      			if(operations.get(i).getOptID() == 51601){
					%>				
									<button class="obtn glyphicon glyphicon-plus obtn-pic-add" type="button" onclick="addOrUpdate(1)">添加</button>
					<%      
				      			}
				      			if(operations.get(i).getOptID() == 51602){
					%>				
									<button class="obtn glyphicon glyphicon-pencil obtn-pic-mod" type="button" onclick="addOrUpdate(2)">修改</button>
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
				</div>
			</div>
		</div>
	</div>
	</div>
	<div class="w-content pic-add">
		<form action="javascript:addOrModify()" id="dataForm" method="post">
			<table>
				<tr>
					<td><label>网站认证资料标题：</label></td>
					<td id="addauthentitle"><input type="text" value="" id="title" datatype="entername"/></td>
				</tr>
				<tr>
					<td><label>网站认证资料链接：</label></td>
					<td id="addauthenlink"><input type="text" value="" id="url" datatype="strRegex"/></td>
				</tr>
				<tr>
					<td class="tt"><label>网站认证资料图：</label></td>
					<td class="con">
						<!--dom结构部分-->
						<div id="uploader">
						    <!--用来存放item-->
						    <div id="filePickers">选择图片</div>
						     <span class="rec-dimensions">建议尺寸：98*37</span>
						     <input type="hidden" name="imgPath" id="imgPath" />
						     <input type="hidden" name="bannerId" id="bannerId" />
						    <input type="hidden" id="hostPath" value="${ImgProfix}"/>
						</div>
					</td>
				</tr>
				<tr>
					<td class="tt" valign="top"><label>图片预览：</label></td>
					<td class="con">
						<div id="fileList">
						</div>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<div class="w-content pic-view">
		<div class="w-content hideHtml">暂无图片</div>
		<img id="picView" src="" style="max-height: 280px;max-width: 480px;margin-left: 20px">
	</div>

	<!-- 尾部 -->
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<!-- 私用js -->
	<script type="text/javascript" src="plugs/webuploader/0.1.5/webuploader.js"></script>
	<script type="text/javascript" src="js/frontconfig/upload.js"></script>
	<script src="js/frontconfig/front-safeCentification.js"></script>
	
</body>

</html>