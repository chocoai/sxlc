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
	<title>配置中心</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link rel="stylesheet" href="css/config.css" />
	<script type="text/javascript">
		var on_off =false; //停用启用权限标记
		<%
			if(operations.size()>0){
				for(int j=0;j<operations.size();j++){
					if(operations.get(j).getOptID()==61203){
		%>
			   		on_off =true;
		<%
					}
				}
			}
		%>
	</script>
</head>
<!-- 配置中心--------会员信用等级配置-->
<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="6" name="_index_m1"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-config.jsp">
				<jsp:param value="612" name="_index_m2"/>
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
								if(operations.get(i).getOptID() == 61201){
					%>				
								<button class="obtn glyphicon glyphicon-plus obtn-loanitem-add" onclick="addOrModify(0)">添加</button>
					<%      
				      			}
				      			if(operations.get(i).getOptID() == 61202){
					%>				
								<button class="obtn glyphicon glyphicon-pencil obtn-loanitem-mod" onclick="addOrModify(1)">修改</button>
					<%      
				      			}
					  		 }
						 }
				     %>	
						</div> 
						</div>
						<div class="search">
						<div class="panel panel-success">
							<div class="panel-heading">
								<div class="i-fl search_title">条件查询</div>
								<div class="i-fr action_item">
									<ul class="list_item list-inline">
										<li><a class="state">展开&nbsp;<span
												class="glyphicon glyphicon-chevron-down"></span> </a></li>
									</ul>
								</div>
							</div>
							<div class="panel-body">
								<form id="" class="" action="">
									<span class="con-item"><span>认证项名称</span><input type="text" name="identyName" id="identyName" class="" placeholder="角色编码" /></span>
									<span class="con-item"><span>认证项状态</span>
									<select class="linkedoperation" name="iStatu" id="iStatu">
										<option value="-1">请选择</option>
										<option value="1">有效</option>
										<option value="0">无效</option>
									</select></span>
									<span class="con-item"><span>会员类型</span>
									<select class="linkedoperation" name="membertype1" id="membertype1">
										<option value="-1">请选择</option>
										<option value="0">个人会员</option>
										<option value="1">企业会员</option>
									</select>
									</span>
									<button class="obtn obtn-query glyphicon glyphicon-search" type="button" >查询</button>
								</form>
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
					<!-- 添加 个人借款认证项-->
					
					<div class="w-content loanitem-add">
					<form class="form-horizontal" role="form" type="post" action="javascript:AddOrUpdate()" id="dataForm">
						<table>
							<tr>
								<td class="tt"><label class="ineed">会员类型：</label></td>
								<td>
									<select class="linkedoperation" name="membertype" id="membertype">
										<option value="0">个人会员</option>
										<option value="1">企业会员</option>
									</select>
								</td>
							</tr>
							<tr>
								<td class="tt"><label class="ineed">认证项名称：</label></td>
								<td class="con" id="addname"><input type="text" class="" name="attestTypeName" id="attestTypeName" placeholder="" value="" datatype="rolename"/></td>
							</tr>
							<tr>
								<td class="tt"><label class="ineed">附件格式：</label></td>
								<td class="con">
									<input type="checkbox" class="attach" name="attach" value="0"/> 图片
									<input type="checkbox" class="attach" name="attach" value="1"/> 文件
									<input type="checkbox" class="attach" name="attach" value="2"/> 音频
									<input type="checkbox" class="attach" name="attach" value="3"/> 视频
								</td>
							</tr>
							<tr>
								<td class="tt"><label>默认最高信用分数：</label></td>
								<td class="con" id="addpercent"><input type="text" class="" name="creditScore" id="creditScore" placeholder="" value="" datatype="hundredNum"/></td>
							</tr>
						</table>
						</form>
					</div>
				</div>
			</div>
			<!-- 尾部 -->
			
		</div>
		<!-- 公用js -->
		<jsp:include page="../common/cm-js.jsp"></jsp:include>
		<script type="text/javascript" src="js/configCenter/loan-itemsConfig.js"></script>
		<!-- 私用js -->
	<!-- 	<script type="text/javascript">
		$(function(){
			/* 添加 */
			validform5("layui-layer-btn0","addpercent",false,"3");
			validform5("layui-layer-btn0","addname",false,"3");
			validform5("layui-layer-btn0","modname",false,"3");
			validform5("layui-layer-btn0","modpercent",false,"3");
			/* 添加 */
		});
			</script> -->
		</div>
	</div>
</body>

</html>