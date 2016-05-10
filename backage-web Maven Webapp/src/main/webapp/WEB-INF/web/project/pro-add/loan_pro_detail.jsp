<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
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
<body>
	<div class="container add_type_contianer">
		<!-- 地址导航 -->
		<jsp:include page="../../common/cm-addr.jsp"></jsp:include>
	<!-- 信息不完整 -->
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
							<span class="moneyFormat">${proPurpose.amount}</span>元
						</td>
					</tr>
					<tr class="col-md-6">
						<td class="tt"><label>还款保障：</label></td>
						<td class="con">
							<span>${proRecord.repayGuarantee}</span>
						</td>
					</tr>
					<tr class="col-md-6">
						<td class="tt"><label>借款项目类型：</label></td>
						<td class="con">
							<span>${proRecord.projectTypeentity.projectName}</span>
						</td>
					</tr>
					<tr class="col-md-6">
						<td class="tt"><label>借款期限：</label></td>
						<td class="con">
							<span>${proPurpose.deadline}</span>
							<c:if test="${proPurpose.deadlineType == 0}">
								 天
							</c:if>		
							<c:if test="${proPurpose.deadlineType == 1}">
								 月
							</c:if>		
							<c:if test="${proPurpose.deadlineType == 2}">
								 年
							</c:if>	
							
						</td>
					</tr>
					<tr class="col-md-6">
						<td class="tt"><label>还款来源：</label></td>
						<td class="con">
							<span>${proPurpose.repaySource}</span>
						</td>
					</tr>
					<tr class="col-md-6">
						<td class="tt"><label>借款用途：</label></td>
						<td class="con">
							<span>${proPurpose.uses}</span>
						</td>
					</tr>
					<tr class="col-md-6">
						<td class="tt"><label>抵押物描述：</label></td>
						<td class="con">
							<span>${proRecord.guarantyDescribe}</span>
						</td>
					</tr>
					<!-- 自动投标 -->
					<tr class="col-md-12">
						<td class="tt"><label>自动投标：</label></td>
						<td class="con">
							投标开始后<span>${proPurpose.pAppAutoSetEntity.autoStart}</span>分钟开始执行自动投标，自动投标总金额占比<span>${proPurpose.pAppAutoSetEntity.autoInvestMax}</span>%
						</td>
					</tr><!-- 自动投标结束 -->
					<!-- 附件信息修改 -->
					<tr class="col-md-6">					
						<td class="tt"><label>申请附件类型：</label></td>
						<td class="con">							
							抵押信息
						</td>
					</tr>
					<tr class="col-md-6">
						<td class="tt"><label>附件标题：</label></td>
						<td class="con">
							附件标题
						</td>
					</tr>	
					<tr class="col-md-6">
						<td class="tt"><label>上传申请附件：</label></td>
						<td class="con">
							<div id="logo">
							    <!--用来存放item-->
							</div>
						</td>
					</tr><!-- 附件添加结束 -->							
					<tr class="col-md-6">
						<td class="tt">是否为加息标：</td>
						<td class="con">
							添加利息：<span>${proRecord.rateAddRates}</span>%
						</td>
					</tr>
					<tr class="col-md-6">
						<td class="tt">定向标：</td>
						<td class="con">
							<c:if test="${proRecord.isDirect == 1}">
								已开启
							</c:if>		
							<c:if test="${proRecord.isDirect == 0}">
								未开启
							</c:if>		
						</td>
					</tr>
					<tr class="col-md-6">
						<td class="tt">奖励标：</td>
						<td class="con">
							返现：本金*<span>${proRecord.rewardRates}</span>%
						</td>
					</tr>
					<tr class="col-md-12">
						<td class="tt">红包惊喜标：</td>
						<td class="con">
							投资达到<span>10000</span>元的前<span>10</span>个，平台代付<span>1000</span>元红包
						</td>
					</tr>	
					<tr class="col-md-6">
						<!-- 选择担保机构 -->
						<td class="tt">担保机构：</td>
						<td class="con">
							<span class="mechanism">${proRecord.guaranteeName}</span>
						</td>
					</tr>	
					<tr class="col-md-6">
						<td class="tt">资产管理方：</td>
						<td class="con">
							<span class="mechanism">${proRecord.managementName}</span>
							<span>30</span>%
						</td>
					</tr>	
					<tr class="col-md-6">
						<td class="tt">项目风险保证金：</td>
						<td class="con">
							<span>${proPurpose.projectAppMngFeeEntity.riskMarginFee}</span>
							<c:if test="${proPurpose.projectAppMngFeeEntity.riskMarginType == 0}">
								%
							</c:if>		
							<c:if test="${proPurpose.projectAppMngFeeEntity.riskMarginType == 1}">
								元
							</c:if>		
						</td>
					</tr>				
					<tr class="col-md-6">
						<td class="tt">收取借款管理费 ：</td>
						<td class="con">
							<span>600</span>元
						</td>
					</tr>				
					<tr class="col-md-6">
						<td class="tt"><label>允许投标人数 ：</label></td>
						<td class="con">
							<span>${proRecord.investCountMax}</span>人
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
</body>

</html>