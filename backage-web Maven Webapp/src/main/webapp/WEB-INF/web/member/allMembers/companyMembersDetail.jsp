<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>


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
						<tbody>
							<%
								for (int i = 0; i <5; i++) {
							%>
							<tr>
								<td>2015-01-02</td>
								<td>2016-10-10</td>
								<td>购买</td>
								<td><span class="moneyFormat">20000</span><samp>元</samp></td>
							</tr>
							<%
								}
							%>
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
							<td class="tt"><label>会员编号：</label><span>会员编号</span></td>
							<td class="tt"><label>会员用户名：</label><span>会员用户名</span></td>
							<td class="tt"><label>企业名称：</label><span>真实姓名</span></td>
						</tr>
						<tr>
						<td class="tt"><label>营业执照号：</label><span>20221552255412554411</span></td>
							<td class="tt"><label>企业地址：</label><span>成都</span></td>
							<td class="tt"><label>法人代表：</label><span>汉</span></td>
						</tr>
						<tr>
							<td class="tt"><label>法定代表人身份证号：</label><span>500221119525542125</span></td>
							<td class="tt"><label>组织机构代码：</label><span>154154874851541</span></td>
							<td class="tt"><label>税务登记号：</label><span>18454845847</span></td>
						</tr>
						<tr>
							<td class="tt"><label>经营范围：</label><span>经营范围</span></td>
							<td class="tt"><label>经营场所：</label><span>经营场所</span></td>
							<td class="tt"><label>公司简介：</label><span>公司简介</span></td>
						</tr>
						<tr>
							<td class="tt"><label>注册资本：</label><span class="moneyFormat">1000000<samp>元</samp></span></td>
							<td class="tt"><label>注册资本来源：</label><span>注册资本来源</span></td>
							<td class="tt"><label>联系人：</label><span>某某某</span></td>
						</tr>
						<tr>
							<td class="tt"><label>联系人邮箱：</label><span>1545154@163.com</span></td>
							<td class="tt"><label>联系人手机号：</label><span>188834484584</span></td>
							<td class="tt"><label>联系人qq：</label><span>1548524825</span></td>
						</tr>
						<tr>
							<td class="tt"><label>地区：</label><span>成都郫县</span></td>
							<td class="tt"><label>注册时间：</label><span>2016-04-28</span></td>
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
							<td class="tt"><label>第三方数字帐户：</label><span>61648451154484511</span></td>
							<td class="tt"><label>第三方标识：</label><span>a154421544</span></td>
							<td class="tt"><label>帐户可用余额：</label><span class="moneyFormat">2000<samp>元</samp></span></td>
							<td class="tt"><label>帐户冻结金额：</label><span class="moneyFormat">1544<samp>元</samp></span></td>
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
						<tr>
							<td class="tt"><a>营业执照认证</a></td>
							<td class="tt"><a>工商执照认证</a></td>
							<td class="tt"><a>组织机构代码认证</a></td>
							<td class="tt"><a>开户许可证认证</a></td>
							<td class="tt"><a>企业银行流水认证</a></td>
						</tr>
						<tr>
							<td class="tt"><a>实地考察认证</a></td>
							<td class="tt"><a>税务登记认证</a></td>
							<td class="tt"><a>批文认证</a></td>
							<td class="tt"><a>财务资料认证</a></td>
							<td class="tt"><a>监管单位认证</a></td>
						</tr>
						<tr>
							<td class="tt"><a>房产认证</a></td>
							<td class="tt"><a>车产认证</a></td>
							<td class="tt"><a>担保考察认证</a></td>
							<td class="tt"><a>VIP认证</a></td>
							<td class="tt"><a>其它</a></td>
						</tr>
					</table>
				</div>
			</fieldset>
			<!-- 	  借款信用统计         --> 
			<fieldset class="creditRange">
				<legend>借款信用统计</legend>
				<div class="w-content ishow">
					<table>
						<tr>
							<td class="tt">成功借款<samp>N</samp>笔</td>
							<td class="tt">成功还款<samp>N</samp>笔</td>
							<td class="tt">成功投资<samp>N</samp>笔</td>
							<td class="tt">逾期还款<samp>N</samp>笔</td>
							<td class="tt">严重逾期还款<samp>N</samp>笔</td>
						</tr>
						<tr>
							<td class="tt">逾期未还<samp>N</samp>笔</td>
							<td class="tt">提前还款<samp>N</samp>笔</td>
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
							<td class="tt"><label>成功投资笔数：</label><span>2笔</span></td>
							<td class="tt"><label>成功投资金额：</label><span class="moneyFormat">5000<samp>元</samp></span></td>
							<td class="tt"><label>累计已收本金：</label><span class="moneyFormat">2000<samp>元</samp></span></td>
							<td class="tt"><label>累计已收收益：</label><span class="moneyFormat">1544<samp>元</samp></span></td>
						</tr>
						<tr>
							<td class="tt"><label>待收本金：</label><span class="moneyFormat">2000<samp>元</samp></span></td>
							<td class="tt"><label>待收收益：</label><span class="moneyFormat">1544<samp>元</samp></span></td>
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
	
</div>

