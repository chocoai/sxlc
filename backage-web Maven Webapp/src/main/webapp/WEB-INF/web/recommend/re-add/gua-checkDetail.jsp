<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

			<jsp:include page="../../common/cm-addr.jsp"></jsp:include>
			<!-- 查看担保机构信息部分开始 -->
			<div class="" id="checkDetail">
				<form action="">
					<table>
						<tr>
							<td><span>担保机构名称：</span></td>
							<td><label>担保机构名称</label></td>
							<td><span>营业执照号码：</span></td>
							<td><label>营业执照号码</label></td>
						</tr>
						<tr>
							<td><span>组织机构代码：</span></td>
							<td><label>组织机构代码</label></td>
							<td><span>税务登记号：</span></td>
							<td><label>税务登记号</label></td>
						</tr>
						<tr>
							<td><span>经营场所：</span></td>
							<td><label>经营场所</label></td>
							<td><span>注册资金：</span></td>
							<td><label>注册资金</label></td>
						</tr>
						<tr>
							<td><span>法人姓名：</span></td>
							<td><label>法人姓名</label></td>
							<td><span>法人手机号：</span></td>
							<td><label>法人手机号</label></td>
						</tr>
						<tr>
							<td><span>法人身份证号：</span></td>
							<td><label>法人身份证号</label></td>
							<td><span>注册地址：</span></td>
							<td><label>注册地址</label></td>
						</tr>
						<tr>
							<td><span>注册资本来源：</span></td>
							<td><label>注册资本来源</label></td>
							<td><span>经营范围：</span></td>
							<td><label>经营范围</label></td>
						</tr>
						<tr>
							<td><span>公司简介：</span></td>
							<td><label>公司简介</label></td>
							<td><span>联系人姓名：</span></td>
							<td><label>联系人姓名</label></td>
						</tr>
						<tr>
							<td><span>联系人手机号：</span></td>
							<td><label>联系人手机号</label></td>
							<td><span>联系人邮箱：</span></td>
							<td><label>联系人邮箱</label></td>
						</tr>
						<tr>
							<td><span>绑定的后台管理员：</span></td>
							<td><label>绑定的后台管理员</label></td>
						</tr>
					</table>
					<div class="setting">
						<fieldset>
				 			<legend>设置的担保配置信息</legend>
					 			<form class="form-horizontal config-form" role="form" name="" action="javascript:mwithdralsfee()" id="member">
					 				<div class="fieldsetcontent">
				 					<span>担保借款金额范围：</span>
									<label>1000元</label>-<label>100,000,000.00元</label>
				 				</div>		
					 			<div class="fieldsetcontent">
				 					<span>允许担保借款期限起止范围：</span>
				 					<div class="startstoprange">
				 						<label>天标：</label><label>1天</label>-<label>20天</label>
				 					</div>
				 					<div class="startstoprange">
				 						<label>月标：</label><label>1月</label>-<label>20月</label>
				 					</div>
				 					<div class="startstoprange">
				 						<label>年标：</label><label>1年</label>-<label>2年</label>
				 					</div>
					 			</div>
					 			<div class="fieldsetcontent">
				 					<span>担保代偿统计：</span>
				 					<div class="startstoprange">
				 						<label>成功担保笔数：</label><label>680</label><samp>笔</samp>
				 					</div>
				 					<div class="startstoprange">
				 						<label>成功代偿笔数：</label><label>680</label><samp>笔</samp>
				 					</div>
				 					<div class="startstoprange">
				 						<label>代偿回款笔数：</label><label>680</label><samp>笔</samp>
				 					</div>
					 			</div>
					 			<div class="form-group">
					 				<div class="producttype clearfix">
					 					<span>担保产品类型：</span>
										<label>信用贷</label>
										<label>担保贷</label>
										<label>抵押贷</label>
									</div>
					 			</div>
					 			</form>	
			 			</fieldset>
					</div>
					<div class="credentials">
						<fieldset>
				 			<legend>上传的担保证件</legend>
				 			<div class="credentialsimg">img<img src=""/></div>
				 			<div class="credentialsimg">img<img src=""/></div>
				 			<div class="credentialsimg">img<img src=""/></div>
				 			<div class="credentialsimg">img<img src=""/></div>
			 			</fieldset>
					</div>
					<div class="accountinfo">
						<fieldset>
				 			<legend>第三方账户信息</legend>
				 			<div class="">
				   				<table>
					   				<tr>
					   					<td><div class="accountinfotd">第三方账户号：</div></td>
					   					<td><div class="con">第三方账户号</div></td>
					   					<td><div class="accountinfotd">当前余额：</div></td>
					   					<td><div class="con">3万元</div></td>
					   				</tr>
					   				<tr>
					   					<td><div class="accountinfotd">代偿总金额：</div></td>
					   					<td><div class="con">10万元</div></td>
					   					<td><div class="accountinfotd">代偿回款总金额：</div></td>
					   					<td><div class="con">10万元</div></td>
					   				</tr>
					   				<tr>
					   					<td><div class="accountinfotd">代偿未回款总金额：</div></td>
					   					<td><div class="con">1000元</div></td>
					   					<td><div class="accountinfotd">担保费收取总金额：</div></td>
					   					<td><div class="con">2万元</div></td>
					   				</tr>
					   				<tr>
					   					<td><div class="accountinfotd">自动代偿是否开启：</div></td>
					   					<td><div class="con">是</div></td>
					   				</tr>
					   			</table>
					   		</div>
			 			</fieldset>
					</div>
				</form>
			</div>
			<!-- 查看担保机构信息部分结束 -->	
	
	<!-- 私用js -->
	<script type="text/javascript" src="../js/recommend/guarantee-manage.js"></script>
	

			