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
	<title>全部会员</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<link rel="stylesheet" type="text/css" href="plugs/layer-v2.2/layer/skin/layer.css">
	<link href="plugs/Bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="plugs/Bootstrap/fonts/css/font-awesome.min.css" rel="stylesheet">
	<link href="plugs/datatables/1.10.0/jquery.dataTables.min.css" rel="stylesheet">
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link rel="stylesheet" type="text/css" href="css/membershipManagement.css">
	<link rel="stylesheet" type="text/css" href="css/conditionstyle.css">
	<script src="js/jquery-1.11.0.min.js"></script>
	
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
			<!-- 地址导航 -->
			<jsp:include page="../common/cm-addr.jsp"></jsp:include>
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<div class="search">
					<div class="panel panel-success boxRadius">
						<div class="panel-heading">
							<div class="i-fl search_title">类型查询</div>
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
							<div class="allMembersSelect">
								<form class="form-inline" name="search">
									<div class="form-group">
									    <label for="member_Name">会员姓名:</label>
									    <input type="text" class="form-control" id="member_Name" name="member_Name" placeholder="会员姓名">
									</div>
									<div class="form-group">
								    	<label for="state">用户名:</label>
								    	<input type="text" class="form-control" id="state" name="state" placeholder="用户名">
									</div>
									<div class="form-group">
								    	<label for="state">手机号:</label>
								    	<input type="text" class="form-control" id="state" name="state" placeholder="手机号">
									</div>
									<div class="form-group">
								    	<label for="state">是否开启自动投标:</label>
								    	<input type="text" class="form-control" id="state" name="state" placeholder="是否开启自动投标">
									</div>
									<div class="form-group">
								    	<label for="state">是否开启自动还款:</label>
								    	<input type="text" class="form-control" id="state" name="state" placeholder="是否开启自动还款">
									</div>
									<button type="button" class="btn btn-default search_btn">查询</button>
								</form>
							</div>
					  	</div>
					</div>
				</div> 
				<div class="data_display i-mt">
					<div class="panel panel-success boxRadius">
					  <div class="panel-heading">
					  	<div class="i-fl data_title">数据列表</div>
					  		<div class="i-fr allMengersDetails">
					  		<div class="allMembershipdetails">
								<ul>
									<li class="viewMembershipDetails">
										<a href="javascript:;">查看会员详情</a>
									</li>
									<li class="loanItemQueryCunt">
										<a href="javascript:;">借款项目查询</a>
									</li>
									<li class="nvestmentProjectInquiryCunt">
										<a href="javascript:;">投资项目查询</a>
									</li>
									<li class="transactionRecordCunt">
										<a href="javascript:;">交易记录</a>
									</li>
									<li class="bankCardInquiryCunt">
										<a href="javascript:;">银行卡查询</a>
									</li>
									<li class="inviteMembersCunt">
										<a href="javascript:;">查看邀请会员列表</a>
									</li>
									<li class="pullTheBlackCunt">
										<a href="javascript:;">拉黑</a>
									</li>
									<li class="memberPasswordResetCunt">
										<a href="javascript:;">会员密码重置</a>
									</li>
									<li class="modifyInviteMemberCunt">
										<a href="javascript:;">修改邀请会员</a>
									</li>
									<li class="sendMessageCunt">
										<a href="javascript:;">发送消息</a>
									</li>
								</ul>
						</div>
				  			<!-- <ul class="list_item list-inline allMenbersList">
								<li id="add_type">
									<span class="glyphicon glyphicon-plus"></span>
									<span>添加</span>
								</li>
								<li id="modify_type">
									<span class="glyphicon glyphicon-pencil"></span>
									<span>修改</span>
								</li>
								<li  id="modify_state">
									<span class="glyphicon glyphicon-ok-circle"></span>
									<span>状态</span>
								</li>
							</ul>  -->
						</div>
				</div>
					<div class="memberSelect panel-body tScroll">
						<table id="memberSelect" class="display table-hover memberselect_b" cellspacing="0" width="100%">
						      		<thead>
							<tr role="row">
								<th> </th>
								<th class="membershipEncoding" onclick="memberPersonalInformation()" rowspan="1" colspan="1">会员编码</th>
								<th class="sorting_asc" aria-controls="gridImport">姓名</th>
								<th class="sorting" tabindex="0" aria-controls="gridImport" rowspan="1" colspan="1" aria-label="用户名/登录名: 升序排列" style="width: 133px;">用户名</th>
								<!-- <th>用户名</th> -->
								<th>手机号码</th>
								<th>所属地区</th>
								<th>会员等级</th>
								<th>信用等级</th>
								<th>第三方账户</th>
								<th>可用账户余额</th>
								<th>冻结金额</th>
								<th>充值总额</th>
								<th>投资总额</th>
								<th>借款总额</th>
								<th>提现总额</th>
								<th>收益总额</th>
								<th>可用积分</th>
								<th>赠送红包总额</th>
								<th>使用红包总额</th>
								<th>已过期红包总额</th>
								<th>剩余可用红包总额</th>
								<th>是否开启自动投标</th>
								<th>是否开启自动还款</th>
								<th>操作</th>
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
								<td>13000000000</td>
								<td>四川省成都市郫县</td>
								<td>3星用户</td>
								<td>2级</td>
								<td>123456789123456789</td>
								<td>123456789123456789</td>
								<td>100.00</td>
								<td>50.00</td>
								<td>1000.00</td>
								<td>200.00</td>
								<td>100.00</td>
								<td>1000.00</td>
								<td>300.00</td>
								<td>20.00</td>
								<td>10.00</td>
								<td>1.00</td>
								<td>5.00</td>
								<td>true</td>
								<td>false</td>
								<td>
									<ul class="list_item list-inline">
										<li id="add_type">
											<span class="glyphicon glyphicon-plus"></span>
											<span>添加</span>
										</li>
										<li id="modify_type">
											<span class="glyphicon glyphicon-pencil"></span>
											<span>修改</span>
										</li>
										<li  id="modify_state">
											<span class="glyphicon glyphicon-ok-circle"></span>
											<span>状态</span>
										</li>
									</ul> 
								</td>
							</tr>
							<tr>
								<td class="table-checkbox sorting_disabled" rowspan="1" colspan="1">
									<input class="group_checkable" type = "checkbox" onclick="selectAll(this)">
								</td>
								<td>1</td>
								<td>张三</td>
								<td>KFSDLY00000001</td>
								<td>13000000000</td>
								<td>四川省成都市郫县</td>
								<td>3星用户</td>
								<td>2级</td>
								<td>123456789123456789</td>
								<td>123456789123456789</td>
								<td>100.00</td>
								<td>50.00</td>
								<td>1000.00</td>
								<td>200.00</td>
								<td>100.00</td>
								<td>1000.00</td>
								<td>300.00</td>
								<td>20.00</td>
								<td>10.00</td>
								<td>1.00</td>
								<td>5.00</td>
								<td>true</td>
								<td>false</td>
								<td>
									<ul class="list_item list-inline">
										<li id="add_type">
											<span class="glyphicon glyphicon-plus"></span>
											<span>添加</span>
										</li>
										<li id="modify_type">
											<span class="glyphicon glyphicon-pencil"></span>
											<span>修改</span>
										</li>
										<li  id="modify_state">
											<span class="glyphicon glyphicon-ok-circle"></span>
											<span>状态</span>
										</li>
									</ul> 
								</td>
							</tr>
						</tbody>
	                    </table>
					</div>
					</div>
				</div>
				<!-- 会员管理-个人会员-全部会员详情-->
<!-- 				<div class="allMembershipdetails">
					<ul>
						<li class="viewMembershipDetails">
							<a href="javascript:;">查看会员详情</a>
						</li>
						<li class="loanItemQueryCunt">
							<a href="javascript:;">借款项目查询</a>
						</li>
						<li class="nvestmentProjectInquiryCunt">
							<a href="javascript:;">投资项目查询</a>
						</li>
						<li class="transactionRecordCunt">
							<a href="javascript:;">交易记录</a>
						</li>
						<li class="bankCardInquiryCunt">
							<a href="javascript:;">银行卡查询</a>
						</li>
						<li class="inviteMembersCunt">
							<a href="javascript:;">查看邀请会员列表</a>
						</li>
						<li class="pullTheBlackCunt">
							<a href="javascript:;">拉黑</a>
						</li>
						<li class="memberPasswordResetCunt">
							<a href="javascript:;">会员密码重置</a>
						</li>
						<li class="modifyInviteMemberCunt">
							<a href="javascript:;">修改邀请会员</a>
						</li>
						<li class="sendMessageCunt">
							<a href="javascript:;">发送手机</a>
						</li>
					</ul>
				</div> -->
				<div class="tScroll">
					<table id="memberSelect"
					class="table table-striped table-bordered table-hover  memberselect_b" 
					cellpadding="0" cellspacing="0" border="0" class="display" width="100%">
				
					</table>
				</div>
			</div>
		
			<!-- 尾部 -->
			
		</div>
	</div>
		<!-- 查看会员详情 -->
	<div class="membershipDetails">
		<table id="membershipDetails" class="memberselect_b table table-hover " 
					cellpadding="0" cellspacing="0" border="0" width="100%"">
			<thead>
				<tr role="row">
					<th rowspan="1" colspan="1">会员编码</th>
					<th>会员编号</th>
					<th>会员用户名</th>
					<th>真实姓名</th>
					<th>身份证号</th>
					<th>籍贯</th>
					<th>民族</th>
					<th>户籍地址</th>
					<th>居住地址</th>
					<th>手机号码</th>
					<th>电子邮箱</th>
					<th>qq</th>
					<th>性别</th>
					<th>出生日期</th>
					<th>年龄</th>
					<th>最高学历</th>
					<th>婚姻状况</th>
					<th>月均收入</th>
					<th>地区</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>1</td>
					<td>张三</td>
					<td>张山</td>
					<td>123456789123456780</td>
					<td>四川</td>
					<td>汉族</td>
					<td>四川省成都市郫县</td>
					<td>四川省成都市郫县</td>
					<td>13512345678</td>
					<td>789456123@qq.com</td>
					<td>男</td>
					<td>1990.01.01</td>
					<td>26</td>
					<td>本科生</td>
					<td>未婚</td>
					<td>5000.00</td>
					<td>双流区</td>
					<td>5000.00</td>
					<td>双流区</td>
				</tr>
				<tr>
					<td>1</td>
					<td>李四</td>
					<td>李视</td>
					<td>123456789123456780</td>
					<td>四川</td>
					<td>汉族</td>
					<td>四川省成都市郫县</td>
					<td>四川省成都市郫县</td>
					<td>13512345678</td>
					<td>789456123@qq.com</td>
					<td>男</td>
					<td>1990.01.01</td>
					<td>26</td>
					<td>本科生</td>
					<td>未婚</td>
					<td>5000.00</td>
					<td>双流区</td>
					<td>5000.00</td>
					<td>双流区</td>
				</tr>
			</tbody>
		</table>
	</div>
	
	<!-- 借款项目查询 -->
	<div class="loanItemQuery">
			<table id="loanItemQuery" class="membershipDetails_a table table-hover " 
					cellpadding="0" cellspacing="0" border="0" width="100%"">
			<thead>
				<tr role="row">
					<th rowspan="1" colspan="1">项目编号</th>
					<th>项目名称</th>
					<th>提交借款意向时间</th>
					<th>审批通过时间</th>
					<th>借款金额</th>
					<th>实际借款金额</th>
					<th>担保机构名称</th>
					<th>项目状态</th>
					<th>放款时间</th>
					<th>结清时间</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>HY00000001</td>
					<td>项目名称</td>
					<td>2016-01-01</td>
					<td>2016-06-06</td>
					<td>&yen;1000.00</td>
					<td>50.00</td>
					<td>担保机构名称</td>
					<td>项目状态</td>
					<td>放款时间</td>
					<td>结清时间</td>
				</tr>
			</tbody>
		</table>
	</div>
	
		<!-- 投资项目查询 -->
	<div class="nvestmentProjectInquiry">
			<table id="nvestmentProjectInquiry" class="membershipDetails_a table table-hover " 
					cellpadding="0" cellspacing="0" border="0" width="100%"">
			<thead>
				<tr role="row">
					<th rowspan="1" colspan="1">项目编号</th>
					<th>项目名称</th>
					<th>投资时间</th>
					<th>投资总金额</th>
					<th>使用红包中金额</th>
					<th>使用代金券总额</th>
					<th>使用返现券总额</th>
					<th>放款时间</th>
					<th>投资总金额</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>HY00000002</td>
					<td>项目名称</td>
					<td>2016-01-01</td>
					<td>2016-06-06</td>
					<td>&yen;100.00</td>
					<td>&yen;50.00</td>
					<td>&yen;20.00</td>
					<td>2016-01-01</td>
					<td>&yen;10000.00</td>
				</tr>
			</tbody>
		</table>
	</div>
	
		<!-- 交易记录 -->
	<div class="transactionRecord">
			<table id="transactionRecord" class="memberselect_b table table-hover " 
					cellpadding="0" cellspacing="0" border="0" width="100%"">
			<thead>
				<tr role="row">
					<th rowspan="1" colspan="1">序号ID</th>
					<th>交易类型</th>
					<th>交易金额</th>
					<th>总金额</th>
					<th>冻结金额</th>
					<th>待收本金</th>
					<th>待收利息</th>
					<th>可用余额</th>
					<th>待还本金</th>
					<th>待还利息</th>
					<th>待还逾期利息</th>
					<th>待还逾期罚金</th>
					<th>交易对方</th>
					<th>交易时间</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>1</td>
					<td>交易类型</td>
					<td>&yen;100.00</td>
					<td>&yen;100.00</td>
					<td>&yen;100.00</td>
					<td>&yen;50.00</td>
					<td>&yen;20.00</td>
					<td>&yen;20.00</td>
					<td>&yen;10000.00</td>
					<td>&yen;100.00</td>
					<td>&yen;50.00</td>
					<td>&yen;20.00</td>
					<td>&yen;20.00</td>
					<td>&yen;10000.00</td>
				</tr>
			</tbody>
		</table>
	</div>
	
		<!-- 银行卡查询 -->
	<div class="bankCardInquiry">
			<table id="bankCardInquiry" class="membershipDetails_a table table-hover " 
					cellpadding="0" cellspacing="0" border="0" width="100%"">
			<thead>
				<tr role="row">
					<th rowspan="1" colspan="1">银行卡类型（借记卡）</th>
					<th>开户银行</th>
					<th>开户城市</th>
					<th>开户行支行</th>
					<th>银行卡卡号</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>中国银行</td>
					<td>成都市金牛区</td>
					<td>成都</td>
					<td>中国银行郫县</td>
					<td>123456789789456123</td>
				</tr>
			</tbody>
		</table>
	</div>
	
		<!-- 查看邀请会员列表 -->
	<div class="inviteMembers">
			<table id="inviteMembers" class="membershipDetails_a table table-hover " 
					cellpadding="0" cellspacing="0" border="0" width="100%"">
			<thead>
				<tr role="row">
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
	
		<!-- 拉黑 -->
	<div class="pullTheBlack">
			<table id="pullTheBlack" class="membershipDetails_a table table-hover " 
					cellpadding="0" cellspacing="0" border="0" width="100%"">
			<thead>
				<tr role="row">
					<th rowspan="1" colspan="1">姓名</th>
					<th>性别</th>
					<th>居住地</th>
					<th>年龄</th>
					<th>手机号</th>
					<th>拉黑时间</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>李四</td>
					<td>男</td>
					<td>红光镇</td>
					<td>30</td>
					<td>12345678912</td>
					<td>2015-06-06</td>
				</tr>
			</tbody>
		</table>
	</div>
	
	<!-- 会员密码重置 -->
	<div class="memberPasswordReset">
		<div id="memberPasswordReset"></div>
	</div>
	
	<!-- 修改邀请会员 -->
	<div class="modifyInviteMember">
		<div id="modifyInviteMember"></div>
	</div>
	
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
	
	<script type="text/javascript" src="plugs/layer-v2.2/layer/layer.js"></script>
	<!-- 私用js -->
	<script type="text/javascript" src="js/membershipManagement.js"></script>
</body>

</html>