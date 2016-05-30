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
	<title>前台界面配置——首页宣传图片管理</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link rel="stylesheet" href="plugs/webuploader/0.1.5/webuploader.css"/>
	<link rel="stylesheet" href="css/upload.css" />
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
				<jsp:param value="501" name="_index_m2"/>
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
										<span>添加时间</span><input type="text" id="startDate" class="dateInput Wdate" onFocus="WdatePicker({maxDate: '#F{$dp.$D(\'endDate\')||\'2020-10-01\'}' })" ><span class="line"></span><input type="text" id="endDate" class="dateInput Wdate"  onFocus="WdatePicker({minDate: '#F{$dp.$D(\'startDate\')}' ,maxDate:'2020-10-01' })" >
									</span>
									<span class="con-item">
										<span>图片标题</span><input type="text" id="bannerTitle" class=""/>
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
									<button class="obtn glyphicon glyphicon-plus obtn-pic-add" type="button" onclick="addOrUpdate(1)">添加</button>
									<button class="obtn glyphicon glyphicon-pencil obtn-pic-mod" type="button" onclick="addOrUpdate(2)">修改</button>
									<button class="obtn glyphicon glyphicon-trash obtn-pic-del" type="button" onclick="deleteBanner()">删除</button>
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
						<td class="tt">图片标题：</td>
						<td class="con"><input type="text" id="bannerTitlea" datatype="unNormal" maxlength="30" ></td>
					</tr>
					<tr>
						<td class="tt">图片链接：</td>
						<td class="con"><input type="text"  id="links" datatype="strRegex" maxlength="50" ></td>
					</tr>
					<tr>
						<td class="tt">图片选择：</td>
						<td class="con">
							<!--dom结构部分-->
							<div id="uploader">
							    <!--用来存放item-->
							    <div id="filePickers">选择图片</div>
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
				<img id="picView" src="" style="max-height: 280px;max-width: 480px;margin-left: 20px">
			</div>
		</div>
	</div>
	<!-- 尾部 -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<!-- 公用js -->
		<script type="text/javascript" src="plugs/webuploader/0.1.5/webuploader.js"></script>
		<script type="text/javascript" src="js/frontconfig/upload.js"></script>
	<!-- 私用js -->
		<script type="text/javascript" src="js/frontconfig/front-pcbanner.js"></script>
</body>

</html>