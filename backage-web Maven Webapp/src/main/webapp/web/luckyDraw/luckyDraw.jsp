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
	<title>幸运抽奖-抽奖设置</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link rel="stylesheet" href="css/luckyDraw/luckyDraw.css" type="text/css">
	
	<link rel="stylesheet" href="plugs/webuploader/0.1.5/webuploader.css" />
	<link rel="stylesheet" href="css/upload.css" />
</head>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="11" name="_index_m1"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-luckyDraw.jsp">
				<jsp:param value="1101" name="_index_m2"/>
				<jsp:param value="" name="_index_m3"/>
			</jsp:include>
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				<div class="nav-tabs-con active">
					<div class="drawSet">
						<span><label>单次抽奖所需积分：</label><input id="integra" type="text" class="notspecial"></span>
						<span>
							<label>是否开启本期抽奖：</label>
							<select id="status">
								<option value="1">是</option>
								<option value="0">否</option>
							</select>
						</span>
						<span><label>开始结束时间范围：</label><input type="text" id="startDate" class="notspecial Wdate dateInput" onFocus="WdatePicker({maxDate: '#F{$dp.$D(\'endDate\')||\'2020-10-01\'}' })"/>-&nbsp;&nbsp;<input type="text" id="endDate" class="notspecial Wdate dateInput" onFocus="WdatePicker({minDate: '#F{$dp.$D(\'startDate\')}' ,maxDate:'2020-10-01' })"/></span>
						
						<span class="periodes">抽奖期数：<label id="period">2</label>期</span>
						<button id="set"  type ="button" class="obtn obtn-query glyphicon glyphicon-search">查询</button>
						<input id="lotteryID" type="hidden" value="" />
					</div>
					<div class="data_display">
						<div class="panel panel-success">
							<div class="panel-heading">
								<div class="action_item">
									<button class="obtn glyphicon glyphicon-pencil obtn-dept-mod">修改</button>
									<button class="obtn glyphicon glyphicon-plus obtn-dept-add" onclick="addLuckyDraw();">添加</button>
									<button class="obtn glyphicon glyphicon-trash obtn-dept-del">删除</button>
								</div>
							</div>
							
							<div class="panel-body">
								<table id="applicationAudit" class="display">
								</table>
							</div>
							
						</div>
					</div>
					<!-- 添加部分  -->
					<div class="" id="addluckyDraw">
						<form id="addluckyInfo" action="javascript:addDraw()" type="post">
							<table>
								<tr class="con-item">
									<td class="tt">奖品等级：</td>
									<td class="col">
										<select id="grade">
											<option value="1">第一级</option>
											<option value="2">第二级</option>
											<option value="3">第三级</option>
											<option value="4">第四级</option>
											<option value="5">第五级</option>
											<option value="6">第六级</option>
										</select>				
									</td>
								</tr>
								<tr class="con-item">
									<td class="tt">奖品类型：</td>
									<td class="col">
										<select id="prizeType">
											<option value="0">红包</option>
											<option value="1">代金卷</option>
											<option value="2">实物</option>
											<option value="3">积分</option>
										</select>	
									</td>
								</tr>
								<tr class="con-item">
									<td class="tt">奖品名称：</td>
									<td class="col"><input id="prizeName" ignore="ignore" datatype="roleNameb" class="moneyInput"></td>
								</tr>
								<tr class="con-item">
									<td class="tt">奖品价值：</td>
									<td class="col"><input id="prizeWorths" datatype="acountM" class="moneyInput">元</td>
								</tr>
								<tr class="con-item">
									<td class="tt">奖品数量：</td>
									<td class="col"><input id="prizeQuantity" datatype="nNum1" class="moneyInput"></td>
								</tr>
								<tr class="con-item">
									<td class="tt">中奖概率基数：</td>
									<td class="col"><input id="winningOdds" datatype="hundredNum" class="moneyInput"></td>
								</tr>
								<tr class="con-item">
									<td class="tt">奖品图片：</td>
									<td class="col">
										<!--dom结构部分-->
										<div id="uploader">
										    <!--用来存放item-->
										    <div id="filePicker">图片选择</div>
										</div>
									</td>
								</tr>
								<tr class="con-item">
									<td class="tt" valign="top">图片预览：</td>
									<td class="col" id="fileList"></td>
								</tr>
							</table>
							
							<div class="btnAdd">
								<button type="button" id="add" class="addBtn">添加</button>
								<a class="cancelBtn">取消</a>
							</div>
						</form>
					</div>
				</div>
			</div>
		
			<!-- 尾部 -->
			
		</div>
	</div>
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<script type="text/javascript" src="plugs/webuploader/0.1.5/webuploader.js"></script>
	<!-- 私用js -->
	<script type="text/javascript" src="js/luckyDraw/luckyDraw.js"></script>
	<script type="text/javascript">
		var publicKey_common = '<%=session.getAttribute("publicKey") %>';
	</script>
</body>

</html>