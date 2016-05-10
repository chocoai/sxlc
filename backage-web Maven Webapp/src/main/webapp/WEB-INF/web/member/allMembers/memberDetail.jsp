<%@page import="product_p2p.kit.datatrans.IntegerAndString"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	long memberId =IntegerAndString.StringToLong(request.getParameter("content"), 0);
%>


<div class="nav-md">
	<!-- 地址导航 -->
	<jsp:include page="../../common/cm-addr.jsp"></jsp:include>
	<div class="container body addContainer">
		<div class="main_container">
		<!--      Vip获得途径           -->
			<fieldset class="vipRange">
				<legend>vip会员</legend>
				<div class="w-content ishow">
					<span class="vipDetail"><label>当前vip获得途径：</label>购买</span>
					<span class="vipDetail"><label>vip到期日：</label>2016-10-10</span>
					<table class="vipHistory">
						<thead>
							<tr>
								<th>vip开始时间</th>
								<th>vip结束时间</th>
								<th>vip获取途径</th>
								<th>花费金额(元)</th>
							</tr>
						</thead>
						<tbody id="vipRecord">
						</tbody>
					</table>
				</div>
			</fieldset>
			<!--     会员基本信息              -->
			<fieldset class="basicInformation">
				<legend>会员基本信息</legend>
				<div class="w-content ishow">
					<table>
						<tr>
							<td class="tt"><label>会员编号：</label><span id="memberNo"></span></td>
							<td class="tt"><label>会员用户名：</label><span id="memberName"></span></td>
							<td class="tt"><label>真实姓名：</label><span id="userName"></span></td>
						</tr>
						<tr>
						<td class="tt"><label>身份证号：</label><span id="memberIdCard"></span></td>
							<td class="tt"><label>籍贯：</label><span id="froms"></span></td>
							<td class="tt"><label>民族：</label><span id="nationName"></span></td>
						</tr>
						<tr>
							<td class="tt"><label>地区：</label><span id="area"></span></td>
							<td class="tt"><label>居住地址：</label><span id="residenceAddress"></span></td>
							<td class="tt"><label>手机号码：</label><span id="memberPhone"></span></td>
						</tr>
						<tr>
							<td class="tt"><label>电子邮箱：</label><span id="memberEmail"></span></td>
							<td class="tt"><label>qq：</label><span id="memberQQ"></span></td>
							<td class="tt"><label>性别：</label><span id="sexName"></span></td>
						</tr>
						<tr>
							<td class="tt"><label>出生日期：</label><span id="birthday"></span></td>
							<td class="tt"><label>年龄：</label><span id="age"></span></td>
							<td class="tt"><label>最高学历：</label><span id="educationName"></span></td>
						</tr>
						<tr>
							<td class="tt"><label>婚姻状况：</label><span id="marriageStatuName"></span></td>
							<td class="tt"><label>月均收入：</label><span id="sMonthlyIncome"></span></td>
							<td class="tt"><label>户籍地址：</label><span id="permanentAddress"></span></td>
						</tr>
					</table>
				</div>
			</fieldset>
			
		<!-- 	第三方帐户信息           --> 
			<fieldset class="thirdInformation">
				<legend>会员第三方帐户信息</legend>
				<div class="w-content ishow">
					<table>
						<tr>
							<td class="tt"><label>第三方数字帐户：</label><span id="thirdPartyAccount"></span></td>
							<td class="tt"><label>第三方标识：</label><span id="thirdPartyMark"></span></td>
							<td class="tt"><label>帐户可用余额：</label><span id="userBalance"></span></td>
							<td class="tt"><label>帐户冻结金额：</label><span id="frozen"></span></td>
						</tr>
					</table>
				</div>
				<div class="w-content notOpen">未开通</div>
				<!--   开通时在notOpen上面添加类ishow,未开通时在notOpen上面添加类ishow  -->
			</fieldset>
				
		<!-- 	会员认证资料           --> 
			<fieldset class="cerfiedRange">
				<legend>会员认证资料</legend>
				<div class="w-content ishow">
					<table>
						<tbody id="identy_types"></tbody>
					</table>
				</div>
			</fieldset>
			<!-- 	  借款信用统计         --> 
			<fieldset class="creditRange">
				<legend>借款信用统计</legend>
				<div class="w-content ishow">
					<table>
						<tr>
							<td class="tt">成功借款<samp id="loanCount"></samp>笔</td>
							<td class="tt">成功还款<samp id="repaymentCount"></samp>笔</td>
							<td class="tt">成功投资<samp id="investmentCount"></samp>笔</td>
							<td class="tt">逾期还款<samp id="overdueRepaymentCount"></samp>笔</td>
							<td class="tt">严重逾期还款<samp id="yZOverdueRepaymentCount"></samp>笔</td>
						</tr>
						<tr>
							<td class="tt">逾期未还<samp id="suc_b"></samp>笔</td>
							<td class="tt">提前还款<samp id="suc_b"></samp>笔</td>
						</tr>
					</table>
				</div>
			</fieldset>
			<!-- 	投资统计信息         --> 
			<fieldset class="investRange">
				<legend>投资统计信息</legend>
				<div class="w-content ishow">
					<table>
						<tr>
							<td class="tt"><label>成功投资笔数：</label><span id="investmentCount"></span></td>
							<td class="tt"><label>成功投资金额：</label><span class="moneyFormat" id="sInvestmentSum"></span><samp>元</samp></td>
							<td class="tt"><label>累计已收本金：</label><span class="moneyFormat" id="sRecvPrincipal"></span><samp>元</samp></td>
							<td class="tt"><label>累计已收利息：</label><span class="moneyFormat" id="sRecvInterest"></span><samp>元</samp></td>
						</tr>
						<tr>
							<td class="tt"><label>待收本金：</label><span class="moneyFormat" id="sExpectRecvPrincipal"></span><samp>元</samp></td>
							<td class="tt"><label>待收收益：</label><span class="moneyFormat" id="sIncomeReceived"></span><samp>元</samp></td>
						</tr>
					</table>
				</div>
			</fieldset>
		</div>
	</div>
	
	<!-- 公用js -->
	<jsp:include page="../../common/cm-js.jsp"></jsp:include>
	<!-- 私用js -->
	<script type="text/javascript" src="js/member/memberVipDetail.js"></script>
	<script type="text/javascript" src="js/member/memberDetail.js"></script>
	<script type="text/javascript">
		var memberId = <%=memberId %>;
		var encrypt = new JSEncrypt();
		encrypt.setPublicKey(publicKey_common);
		//result 为加密后参数
		memberId = encrypt.encrypt(memberId+"");
		showVipRecord(memberId); //会员vip记录
		showMemberDetail(memberId);//会员基本信息
		showMemberThirdInfo(memberId);//第三方信息
		showMemberIdentyInfo(memberId);//会员认证项基本信息
		showMemberBorrowStatic(memberId);//会员借款统计基本信息
		showMemberInvestStatic(memberId);//会员投资统计基本信息 */
		
	</script>
	
</div>

