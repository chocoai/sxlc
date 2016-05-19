<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%
request.setCharacterEncoding("UTF-8");
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="zh-CN">
<!-- 借款申请管理——查看项目详情 -->
<head>
	<base href="<%=basePath%>">
	<title>项目详情</title>
	<!-- 公用meta -->
	<jsp:include page="../../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link rel="stylesheet" href="css/project/loan_pro_detail.css" type="text/css">
</head>
<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../../common/cm-top.jsp">
				<jsp:param value="3" name="_index_m1"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../../common/cm-project.jsp">
				<jsp:param value="302" name="_index_m2"/>
				<jsp:param value="" name="_index_m3"/>
			</jsp:include>
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../../common/cm-addr.jsp"></jsp:include>
			  	<div class="w-content ishow">
				<!-- 认证信息 -->
					<fieldset class="personAuthentication">
						<legend>借款会员认证信息——个人</legend>
						<div class="w-content ishow">
							<table>
								<tr>
									<td class="tt"><a>实名认证</a></td>
									<td class="tt"><a>手机认证</a></td>
									<td class="tt"><a>征信认证</a></td>
									<td class="tt"><a>住址认证</a></td>
									<td class="tt"><a>婚姻认证</a></td>
									<td class="tt"><a>工作认证</a></td>
									<td class="tt"><a>学历认证</a></td>
									<td class="tt"><a>股权认证</a></td>
								</tr>
								<tr>
									<td class="tt"><a>职称认证</a></td>
									<td class="tt"><a>社保认证</a></td>
									<td class="tt"><a>房产认证</a></td>
									<td class="tt"><a>车产认证</a></td>
									<td class="tt"><a>银行流水认证</a></td>
									<td class="tt"><a>其它</a></td>
								</tr>
							</table>
						</div>
					</fieldset>
					<fieldset class="enterproiseAuthentication" style="display:none">
						<legend>借款会员认证信息——企业</legend>
						<div class="w-content ishow">
							<table>
								<tr>
									<td class="ts"><a>营业执照认证</a></td>
									<td class="ts"><a>工商执照认证</a></td>
									<td class="ts"><a>组织机构代码认证</a></td>
									<td class="ts"><a>开户许可证认证</a></td>
									<td class="ts"><a>企业银行流水认证</a></td>
									<td class="ts"><a>实地考察认证</a></td>
									<td class="ts"><a>税务登记认证</a></td>
									<td class="ts"><a>批文认证认证</a></td>
								</tr>
								<tr>
									<td class="ts"><a>财务资料认证</a></td>
									<td class="ts"><a>监管单位认证</a></td>
									<td class="ts"><a>房产认证</a></td>
									<td class="ts"><a>车产认证</a></td>
									<td class="ts"><a>担保考察认证</a></td>
									<td class="ts"><a>法人身份认证</a></td>
									<td class="ts"><a>其它</a></td>
								</tr>
							</table>
						</div>
					</fieldset>
					<!-- 借款详细信息展示 -->
					<fieldset>
						<legend>借款详细信息</legend>
						<div class="w-content ishow">
						<table>
							<tr class="col-md-6">
								<td class="tt"><label>借款金额：</label></td>
								<td class="con">
									<span class="">${proDetail.amounts}</span>元
								</td>
							</tr>
							<tr class="col-md-6">
								<td class="tt"><label>还款保障：</label></td>
								<td class="con">
									<span>${proDetail.repayGuarantee}</span>
								</td>
							</tr>
							<tr class="col-md-6">
								<td class="tt"><label>借款项目类型：</label></td>
								<td class="con">
									<span>${proDetail.projectName}</span>
								</td>
							</tr>
							<tr class="col-md-6">
								<td class="tt"><label>借款期限：</label></td>
								<td class="con">
									<span>${proDetail.deadline}</span>
									<c:if test="${proDetail.deadlineType == 0}">
										 天
									</c:if>		
									<c:if test="${proDetail.deadlineType == 1}">
										 月
									</c:if>		
									<c:if test="${proDetail.deadlineType == 2}">
										 年
									</c:if>	
									
								</td>
							</tr>
							<tr class="col-md-6">
								<td class="tt"><label>还款来源：</label></td>
								<td class="con">
									<span>${proDetail.repaySource}</span>
								</td>
							</tr>
							<tr class="col-md-6">
								<td class="tt"><label>借款用途：</label></td>
								<td class="con">
									<span>${proDetail.uses}</span>
								</td>
							</tr>
							<tr class="col-md-6">
								<td class="tt"><label>抵押物描述：</label></td>
								<td class="con">
									<span>${proDetail.guarantyDescribe}</span>
								</td>
							</tr>
							<!-- 自动投标 -->
							<tr class="col-md-12">
								<td class="tt"><label>自动投标：</label></td>
								<td class="con">
									投标开始后<span>${proDetail.autoStart}</span>分钟开始执行自动投标，自动投标总金额占比<span>${proDetail.autoInvestMaxs}</span>%
								</td>
							</tr><!-- 自动投标结束 -->
							<!-- 附件信息修改 -->
							<div class="detailTitle">
								<c:forEach var="item" items="${attaches}">
									<tr class="col-md-6">					
										<td class="tt"><label>申请附件类型：</label></td>
										<td class="con">							
											<c:if test="${item.attachInfoType == 0}">
												 其他
											</c:if>
											<c:if test="${item.attachInfoType == 1}">
												 借款方资料
											</c:if>
											<c:if test="${item.attachInfoType == 2}">
												 抵押资料
											</c:if>
											<c:if test="${item.attachInfoType == 3}">
												 现场调查资料
											</c:if>
										</td>
									</tr>
									<tr class="col-md-6">
										<td class="tt"><label>附件标题：</label></td>
										<td class="con">
											${item.attachTitle}
										</td>
									</tr>	
									<tr class="col-md-6">
										<td class="tt"><label>申请附件：</label></td>
										<td class="con">
											<div id="logo">
											  <img src="${hostPath}${item.attachUrl}">
											</div>
										</td>
									</tr>
								</c:forEach>
							</div>
							
							<tr class="col-md-6">
								<td class="tt">加息标利息：</td>
								<td class="con">
									<span>${proDetail.rateAddRates}</span>%
								</td>
							</tr>
							<tr class="col-md-6">
								<td class="tt">定向标：</td>
								<td class="con">
									<c:if test="${proDetail.isDirect == 1}">
										已开启
									</c:if>		
									<c:if test="${proDetail.isDirect == 0}">
										未开启
									</c:if>		
								</td>
							</tr>
							<tr class="col-md-6">
								<td class="tt">奖励标：</td>
								<td class="con">
									返现：本金*<span>${proDetail.rewardRates}</span>%
								</td>
							</tr>
							<tr class="col-md-12">
								<td class="tt">红包惊喜标：</td>
								<c:if test="${fn:length(redPackage) > 0}">
									<c:forEach var="item" items="${redPackage}">
										<td class="con">
											投资达到<span>${item.investRedPackageMin}</span>
											元的前<span>${item.investNum}</span>
											个，平台代付<span>${item.redPackage}</span>元红包
										</td>
									</c:forEach>
								</c:if>		
							</tr>	
							<tr class="col-md-6">
								<!-- 选择担保机构 -->
								<td class="tt">担保机构：</td>
								<td class="con">
									<span class="mechanism">${proDetail.guaranteeName}</span>
								</td>
							</tr>	
							<tr class="col-md-6">
								<td class="tt">资产管理方：</td>
								<td class="con">
									<span class="mechanism">${proDetail.managementName}</span>
								</td>
							</tr>	
							<tr class="col-md-6">
								<td class="tt">项目风险保证金：</td>
								<td class="con">
									<span>${proDetail.riskMarginFees}</span>
									<c:if test="${proDetail.riskMarginType == 0}">
										%
									</c:if>		
									<c:if test="${proDetail.riskMarginType == 1}">
										元
									</c:if>		
								</td>
							</tr>				
							<tr class="col-md-6">
								<td class="tt">收取借款管理费 ：</td>
								<td class="con">
									<span>${proDetail.mngFeeAmounts}</span>元
								</td>
							</tr>				
							<tr class="col-md-6">
								<td class="tt"><label>允许投标人数 ：</label></td>
								<td class="con">
									<span>${proDetail.investCountMax}</span>人
								</td>
							</tr>
						</table>
						</div>
					</fieldset>
				</div>
			</div>
		    <!-- 公用js -->
			<jsp:include page="../../common/cm-js.jsp"></jsp:include>
			<!-- 私用js -->
		</div>
	</div>	
</body>
</html>