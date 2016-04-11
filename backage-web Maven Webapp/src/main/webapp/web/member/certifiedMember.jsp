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
	<title>认证会员</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link rel="stylesheet" type="text/css" href="css/membershipManagement.css">
</head>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="2" name="top_menu_index"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-member.jsp"></jsp:include>
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				<!-- <ul class="nav nav-tabs">
					<li role="presentation" class="allMembers"><a href="javascript:;">全部会员</a></li>
					<li role="presentation" class="membersVipCu"><a href="javascript:;">VIP会员</a></li>
					<li role="presentation" class="registeredMemberCu"><a href="javascript:;">注册会员</a></li>
					<li role="presentation" class="active"><a href="javascript:;">认证会员</a></li>
					<li role="presentation" class="loanMemberCu"><a href="javascript:;">借款会员</a></li>
					<li role="presentation" class="investmentMemberCu"><a href="javascript:;">投资会员</a></li>
					<li role="presentation" class="compositeMemberCu"><a href="javascript:;">复合会员</a></li>
					<li role="presentation" class="memberBlackListCu"><a href="javascript:;">会员黑名单</a></li>
					<li role="presentation" class=""><a href="javascript:;">资料认证</a></li>
					<li role="presentation" class=""><a href="javascript:;">会员分配理财顾问</a></li>
					<li role="presentation" class=""><a href="javascript:;">理财顾问变更</a></li>
				</ul> -->
				<div class="search">
					<div class="panel panel-success boxRadius">
						<div class="panel-heading">
							<div class="i-fl search_title">条件查询</div>
							<div class="i-fr action_item">
								<ul class="list_item list-inline">
									<li>
										<span class="glyphicon glyphicon-search"></span>
										<span>查询</span>
									</li>
									<a class="state">
										<span class="glyphicon glyphicon-chevron-down"></span>
									</a>
								</ul>
							</div>
						</div>
						<div class="panel-body">
							<form class="" action="">
								<span class="con-item"><span>用户名</span><input type="text" class="" placeholder="用户名" /></span>
								<span class="con-item"><span>姓名</span><input type="text" class="" placeholder="姓名" /></span>
								<span class="con-item"><span>手机号</span><input type="text" class="" placeholder="手机号" /></span>
								<span class="con-item"><span>身份证号</span><input type="text" class="" placeholder="身份证号" /></span>
								<span class="con-item"><span>注册时间</span><input type="text" class="" placeholder="注册时间" /></span>
								<button class="obtn obtn-query glyphicon glyphicon-search">查询</button>
							</form>
					  	</div>
					</div>
				</div> 
				<div class="data_display i-mt">
					<div class="panel panel-success boxRadius">
					  <div class="panel-heading">
					  	<div class="action_item">
							<button class="obtn glyphicon glyphicon-plus">添加</button>
							<button class="obtn glyphicon glyphicon-pencil">修改</button>
							<button class="obtn glyphicon glyphicon-trash">删除</button>
							<button class="obtn glyphicon viewMembershipDetails">查看会员详情</button>
							<button class="obtn glyphicon inviteMembersCunt">查看邀请会员列表</button>
							 <!--<button class="obtn glyphicon checkAuthenticationInformationCu">查看提交认证信息</button> -->
							<button class="obtn glyphicon sendMessageCunt">发送消息</button>
						</div>
				</div>
					<div class=" panel-body tScroll">
						<table id="memberSelect" class="display table-hover memberselect_b">
						      		<thead>
							<tr>
								<th> </th>
								<th rowspan="1" colspan="1">会员编码</th>
								<th class="sorting_asc">姓名</th>
								<th class="sorting" tabindex="0"  rowspan="1" colspan="1"style="width: 133px;">用户名</th>
								<th>注册时间</th>
								<th>手机号码</th>
								<th>身份证号</th>
								<th>电子邮箱</th>
								<th>邀请码</th>
								<th>所属地区</th>
								<th>注册客户端</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class="table-checkbox sorting_disabled" rowspan="1" colspan="1">
									<input class="group_checkable" type = "checkbox" onclick="selectAll(this)">
								</td>
								<td>1</td>
								<td>张三</td>
								<td>KFSDLY00000001</td>
								<td>2016-01-01</td>
								<td>13200000000</td>
								<td>789456123789456123</td>
								<td>789456123@qq.com</td>
								<td>789456</td>
								<td>江苏</td>
								<td>200.00</td>
							</tr>
							<tr>
								<td class="table-checkbox sorting_disabled" rowspan="1" colspan="1">
									<input class="group_checkable" type = "checkbox" onclick="selectAll(this)">
								</td>
								<td>1</td>
								<td>张三</td>
								<td>KFSDLY00000001</td>
								<td>2016-01-01</td>
								<td>13200000000</td>
								<td>789456123789456123</td>
								<td>789456123@qq.com</td>
								<td>789456</td>
								<td>江苏</td>
								<td>200.00</td>
							</tr>
						</tbody>
	                    </table>
					</div>
					</div>
				</div>
			
			</div>
		
			<!-- 尾部 -->
			
		</div>
	</div>
		<!-- 查看会员详情 -->
	<div class="membershipDetails">
		<fieldset>
			<form>
				<table class="viewMembershipDetailsTable">
					<tr class="viewMembershipDetailsTr">
						<th>会员编号：</th>
						<td><input class="fieldsetInput" type="text" placeholder="会员编号"></td>
						<th class="viewMembershipDetailsTh">会员用户名：</th>
						<td><input class="fieldsetInput" type="text" placeholder="会员用户名"></td>
					</tr>
					<tr class="viewMembershipDetailsTr">
						<th>真实姓名：</th>
						<td><input class="fieldsetInput" type="text" placeholder="真实姓名"></td>
						<th class="viewMembershipDetailsTh memberDistance_d">身份证号：</th>
						<td><input class="fieldsetInput" type="text" placeholder="身份证号"></td>
					</tr>
					<tr class="viewMembershipDetailsTr">
						<th class="memberDistance">籍贯：</th>
						<td><input class="fieldsetInput" type="text" placeholder="籍贯"></td>
						<th class="viewMembershipDetailsTh memberDistance">民族：</th>
						<td><input class="fieldsetInput" type="text" placeholder="民族"></td>
					</tr>
					<tr class="viewMembershipDetailsTr">
						<th>户籍地址：</th>
						<td><input class="fieldsetInput" type="text" placeholder="户籍地址"></td>
						<th class="viewMembershipDetailsTh memberDistance_d">居住地址：</th>
						<td><input class="fieldsetInput" type="text" placeholder="居住地址"></td>
					</tr>
					<tr class="viewMembershipDetailsTr">
						<th>手机号码：</th>
						<td><input class="fieldsetInput" type="tel" placeholder="手机号码"></td>
						<th class="viewMembershipDetailsTh memberDistance_d">电子邮箱：</th>
						<td><input class="fieldsetInput" type="email" placeholder="电子邮箱"></td>
					</tr>
					<tr class="viewMembershipDetailsTr">
						<th class="memberDistance_a">qq:</th>
						<td><input class="fieldsetInput" type="tel" placeholder="qq"></td>
						<th class="viewMembershipDetailsTh memberDistance_e viewMembershipDetailsPo">性别:</th>
						<td class="viewMembershipDetailsTd">
							<input class="fieldsetInput"  type="radio" value="0" name="sex" >
							<label class="">男</label>
							<input class="fieldsetInput"  type="radio" value="1" name="sex">
							<label class="">女</label> 
						</td>
					</tr>
					<tr class="viewMembershipDetailsTr">
						<th>出生日期：</th>
						<td><input class="fieldsetInput" placeholder="出生日期"></td>
						<th class="viewMembershipDetailsTh memberDistance_c">年龄：</th>
						<td><input class="fieldsetInput" placeholder="年龄"></td>
					</tr>
					<tr class="viewMembershipDetailsTr">
						<th>最高学历：</th>
						<td><input class="fieldsetInput" placeholder="最高学历"></td>
						<th class="viewMembershipDetailsTh memberDistance_d">婚姻状况：</th>
						<td><input class="fieldsetInput" placeholder="婚姻状况"></td>
					</tr>
					<tr class="viewMembershipDetailsTr">
						<th>月均收入：</th>
						<td><input class="fieldsetInput" placeholder="月均收入"></td>
						<th class="viewMembershipDetailsTh memberDistance_c">地区：</th>
						<td><input class="fieldsetInput" placeholder="地区"></td>
					</tr>
				</table>
			</form>
		</fieldset>
	</div>
	
		<!-- 查看邀请会员列表 -->
	<div class="inviteMembers">
		<div class="panel-body">
			<form class="" action="">
				<span class="con-item"><span>借款编号</span><input type="text" class="" placeholder="借款编号" /></span>
				<span class="con-item"><span>会员用户名</span><input type="text" class="" placeholder="会员用户名" /></span>
				<span class="con-item"><span>会员名称</span><input type="text" class="" placeholder="会员名称" /></span>
				<span class="con-item"><span>手机号</span><input type="text" class="" placeholder="手机号" /></span>
				<span class="con-item"><span>注册时间</span><input type="text" class="" placeholder="注册时间" /></span>
				<span class="con-item"><span>开通第三方时间</span><input type="text" class="" placeholder="开通第三方时间" /></span>
				<button class="obtn obtn-query glyphicon glyphicon-search">查询</button>
			</form>
		</div>
		<table id="inviteMembers" class="membershipDetails_a table table-hover " >
			<thead>
				<tr>
					<th rowspan="1" colspan="1">会员编号</th>
					<th>会员用户名</th>
					<th>会员名称</th>
					<th>手机号</th>
					<th>注册时间</th>
					<th>开通第三方时间</th>
					<th>邀请总投资金额</th>
					<th>邀请总借款金额</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>HY000000025</td>
					<td>张三</td>
					<td>会员名称</td>
					<td>12345678912</td>
					<td>2015-01-01</td>
					<td>2015-01-01</td>
					<td>&yen;1000.00</td>
					<td>&yen;1000.00</td>
				</tr>
			</tbody>
		</table>
	</div>
	
		<!-- 查看提交认证信息-->
	<!-- <div class="checkAuthenticationInformation">
		<div id="sendMessage">
			<form class="form-inline" name="search">
				<label for="sendMessage_Phone">手机号：</label>
				<input type="text" placeholder="手机号">
				<label for="sendMessage_Phone">手机号：</label>
				<input type="text" placeholder="手机号">	
			</form>
		</div>
	</div> -->
	
	<!-- 发送消息-->
	<div class="sendMessage">
		<div id="sendMessage sendMessageDetailsCu">
			<form class="form-inline" name="search">
				<div class="sendMessage_Phone">
					<label for="sendMessagePhone">手机号：</label>
					<input type="text" placeholder="手机号" id="sendMessagePhone">
				</div>
				<div class="sendMessage_Email">
					<label for="sendMessageEmail">邮箱：</label>
					<input type="text" placeholder="邮箱" id="sendMessageEmail">
				</div>
				<div class="sendMessage_Letter">
					<label for="sendMessageMail">站内信:</label>
					<textarea placeholder="站内信" rows="10%" cols="40%" id="sendMessageMail"></textarea>
				</div>
				<div class="sendMessage_sendOut">
					<div class="button ">发送</div>
					<div class="button ">取消</div>
				</div>
			</form>
		</div>
	</div>
	
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	
	<!-- 私用js -->
	<script type="text/javascript" src="js/membershipManagement.js"></script>
</body>

</html>