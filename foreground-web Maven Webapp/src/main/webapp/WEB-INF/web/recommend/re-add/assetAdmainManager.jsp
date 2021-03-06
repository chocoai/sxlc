<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String content = request.getParameter("content");
%>
			<!-- 地址导航 -->
				<jsp:include page="../../common/cm-addr.jsp"></jsp:include>
			<!-- 管理员管理部分开始 -->
			<div id="assetManageAdmain">
				<div class="data_display">
					<div class="panel panel-success">
						<div class="panel-heading">
							<div class="action_item">
								<button class="obtn glyphicon glyphicon-plus obtn-manage-add" onclick="manageAdmainAdd()">添加</button>
								<button class="obtn glyphicon glyphicon-pencil obtn-manage-mod" onclick="manageAdmainMod()">修改</button>
							</div>
						</div>
					</div>
				</div>
				<div class="panel-body assetadmincontent">
					<input id="managementID" type="hidden" value="<%=content %>" />
					<table id="assetadmaintable" class="display">
					</table>
				</div>
			</div>
			<!-- 管理员管理部分结束 --> 
			<!-- 管理员管理-添加管理员部分开始 -->
			<div class="w-content" id="manageAdmainAdd">
				<div class="fieldsetitem">
					<span>管理员：</span>
					<label>管理员</label>
				</div>
				<div class="fieldsetitem">
					<span>用户名：</span>
					<input type="text" class="username" placeholder="" readonly="readonly" datatype="logname"/>
				</div>
				<div class="fieldsetitem">
					<span>密码：</span>
					<input type="password" class="password" placeholder="" datatype="logPass"/>
				</div>
				<div class="fieldsetitem">
					<span>确认密码：</span>
					<input type="password" class="" placeholder="" datatype="logPass"/>
				</div>
				<div class="fieldsetitem">
					<span class="remark">备注：</span>
					<textarea rows="" cols="" class="ta-noresize"></textarea>
				</div>
			</div>
			<!-- 管理员管理-添加管理员部分结束 -->
			<!-- 管理员管理-修改管理员部分开始 -->
			<div class="w-content" id="manageAdmainMod">
				<div class="fieldsetitem">
					<span>管理员：</span>
					<label>管理员</label>
				</div>
				<div class="fieldsetitem">
					<span>用户名：</span>
					<input type="text" class="username" placeholder="" value="用户名" readonly="readonly"/>
				</div>
				<div class="fieldsetitem">
					<span>密码：</span>
					<input type="password" class="password" placeholder="" datatype="logPass"/>
				</div>
				<div class="fieldsetitem">
					<span>确认密码：</span>
					<input type="password" class="username" placeholder="" datatype="logPass"/>
				</div>
				<div class="fieldsetitem">
					<span class="remark">备注：</span>
					<textarea rows="" cols="" class="ta-noresize"></textarea>
				</div>
			</div>
			<!-- 管理员管理-修改管理员部分结束 -->	

<!-- 公用js -->
	<jsp:include page="../../common/cm-js.jsp"></jsp:include>
	
	<!-- 私用js -->
	<script type="text/javascript" src="../js/recommend/guarantee-manage.js"></script>
	<script type="text/javascript" src="js/recommend/assetAdmin.js"></script>
	<script type="text/javascript">
		var publicKey_common = '<%=session.getAttribute("publicKey") %>';
	</script>
	<script type="text/javascript">
		$(function(){
			validform5("layui-layer-btn0","manageAdmainAdd",false,"3");
			validform5("layui-layer-btn0","manageAdmainMod",false,"3");
		});
	</script>

			