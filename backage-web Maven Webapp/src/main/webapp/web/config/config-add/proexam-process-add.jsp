<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


	<!-- 主要内容 -->
	<div class="" role="main">
		<!-- 地址导航 -->
		<jsp:include page="../../common/cm-addr.jsp"></jsp:include>
			<!-- 添加审批点配置 -->
			<div class="w-content ishow proexam-point-add">
				<div class="search">
					<div class="panel panel-success">
						<div class="panel-heading">
							<div class="i-fl search_title">条件查询</div>
							<div class="i-fr action_item">
								<ul class="list_item list-inline">
									<li><a class="state">展开&nbsp;<span
											class="glyphicon glyphicon-chevron-down"></span> </a>
									</li>
								</ul>
							</div>
						</div>
						<div class="panel-body">
							<form id="" class="" action="">
								<span class="con-item">
									<span>活动点名称</span><input type="text" class="" id="auth" placeholder=""/>
								</span>
								<span class="">
									<button class="obtn obtn-query glyphicon glyphicon-search">查询</button>
								</span>
							</form>
						</div>
					</div>
				</div>
				<div class="panel-body">
					<table id="addproexamexam" class="display">
						<thead>
						</thead>
						<tbody>
						</tbody>
					</table>
					<div class="layui-layer-btn addproprocessbtn">
						<a class="layui-layer-btn0" onclick = "javascript:addProgress()">添加</a>
						<a class="layui-layer-btn1" href="<%=basePath %>web/config/proexam-process-add.jsp">取消</a>
					</div>
				</div>
			</div>							
		</div>
	<jsp:include page="../../common/cm-js.jsp"></jsp:include>
	<script type="text/javascript" src="js/config/proexam-process-add.js"></script>
