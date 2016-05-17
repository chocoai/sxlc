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

<head>
	<base href="<%=basePath%>">
	<title>项目管理——借款申请管理</title>
	<!-- 公用meta -->
	<jsp:include page="../../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link rel="stylesheet" href="plugs/webuploader/0.1.5/webuploader.css" >
	<link rel="stylesheet" href="css/upload.css" >
	<link rel="stylesheet" href="css/project/loan_intention.css" type="text/css">
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
				<div class="" id="checkDetail">
					<div class="container add_type_contianer">
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
							<fieldset class="infoDisplay">
								<legend>借款详细信息</legend>
								<input type="hidden" id="ppid" value="${proPurpose.id}" >
								<input type="hidden" id="pbiid" value="${proRecord.projectBaseInfoentity.id}" >
								<table>
									<tr class="col-md-6">
										<td class="tt"><label>借款金额：</label></td>
										<td class="con">
											<span>${proPurpose.amount}</span>元
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
								</table>
							</fieldset>
							<!-- 借款详细信息修改 -->
							<fieldset class="modInfo">
							<form id="modInfo" action="javascript:nextSave();" method="post">		
							<table>
								<tr class="col-md-6">
									<td class="tt"><label>借款项目名称：</label></td>
									<td class="con">
										<input type="text" class="enterN-r"  value="${proRecord.projectBaseInfoentity.projectTitle}" datatype="enterNameR" maxlength="16">
									</td>
								</tr>
								<tr class="col-md-6">
									<td class="tt"><label>借款金额：</label></td>
									<td class="con">
										<input type="text" class="loanMoney numberReg" value="${proPurpose.amount}" datatype="amcountM" maxlength="8">
									</td>
								</tr>				
								<tr class="col-md-6">
									<td class="tt"><label>借款期限：</label></td>
									<td class="con">
										<input type="text" class="con-term numberReg" value="${proPurpose.deadline}" datatype="nNum0" maxlength="6">
										<select class="conT" value="${proPurpose.deadlineType}">
											<option value="0">天</option>
											<option value="1">月</option> 
											<option value="2">年</option>
										</select>
									</td>
								</tr>
								<tr class="col-md-6">
									<td class="tt ttMax"><label>最大投资比例：</label></td>
									<td class="con">
										<input type="text" class="con-PP numberReg" value="${proRecord.investMax}" datatype="hundredNum" maxlength="3">
										<span>%</span>
									</td>
								</tr>
								<tr class="col-md-6">
									<td class="tt"><label>年化利率：</label></td>
									<td class="con">
										<input type="text" class="startTY numberReg" value="${proPurpose.yearRate}" datatype="hundredNum" maxlength="3">
										<span>%</span>
									</td>
								</tr>
								<tr class="col-md-6">
									<td class="tt"><label>起投金额：</label></td>
									<td class="con">
										<input type="text" class="startingIA numberReg" value="${proRecord.minStart}" datatype="amcountM" maxlength="8">
										<span>元</span>
									</td>
								</tr>
								<tr class="col-md-6">
									<td class="tt"><label>加价幅度：</label></td>
									<td class="con">
										<input type="text" class="conIncrease numberReg" value="${proRecord.increaseRange}" datatype="amcountM" maxlength="8">
										<span>元</span>
									</td>
								</tr>
								<tr class="col-md-12">
									<td class="tt"><label>还款方式：</label></td>
									<td class="con">
										<select class="repayWay" value="${proPurpose.repayWay}">
											<option value="3" >等额本金</option>
											<option value="0" >等额本息</option>
											<option value="1" >先息后本</option>
											<option value="2" >到期还本息</option>
										</select>
									</td>
								</tr>
								<tr class="col-md-12">
									<td class="tt"><label>还款保障：</label></td>
									<td class="con" id="Repayment-g">
										<textarea cols="20" rows="3" name="" class="repayGuarantee"  maxlength="125">${proRecord.repayGuarantee}</textarea>
									</td>
								</tr>
								<tr class="col-md-12">
									<td class="tt"><label>借款用途：</label></td>
									<td class="con" id="usage-loan">
										<textarea cols="20" rows="3" name="" class="uses" maxlength="125">${proPurpose.uses}</textarea>
									</td>
								</tr>
								<tr class="col-md-12">
									<td class="tt"><label>项目描述：</label></td>
									<td class="con" id="con-Increase">
										<textarea cols="20" rows="3" name=""  class="projectDescript" maxlength="200">${proRecord.projectTypeentity.projectDescript}</textarea>
									</td>
								</tr>
								<tr class="col-md-12">
									<td class="tt dyInfo"><label>抵押物描述：</label></td>
									<td class="con">
										<div style="display: none" id="guarantyDescribe">
											${proRecord.guarantyDescribe}
										</div>
										<script id="payguide" type="text/plain" style="width:100%"></script>
									</td>
								</tr>
								<tr class="col-md-8 col-md-offset-4">
									<td class="tt"></td>
									<td class="con">
										<button type="button" class="btn btn-success nextBtn">下一步</button>
										<button type="submit" class="btn btn-default"  onclick="window.location.href='web/project/loan_intention_1.jsp';">返回</button>
									</td>
								</tr>
								</table>
								</form>
								</fieldset>
								<!-- 下一步部分 -->
								<fieldset class="nextField" style="display:none">
									<form id="next_field" action="javascript:saveLast();" >
									<table>
									<!-- 自动投标 -->
									<tr class="col-md-12">
										<td class="tt auto_bid"><label>自动投标：</label></td>
										<td class="con">
											<span>投标开始后</span>
											<input type="text" class="autoBid numberReg autoStart" value="${proPurpose.pAppAutoSetEntity.autoStart}" maxlength="6">
											<span>分钟开始执行自动投标，自动投标总金额占比</span>
											<input type="text" class="autoBid numberReg auotInvestMax" value="${proPurpose.pAppAutoSetEntity.autoInvestMax}" maxlength="3">
											<span>%</span>
										</td>
									</tr><!-- 自动投标结束 -->
									<tr class="col-md-12">
										<td class="tt"><input type="checkbox" class="check_select isAddRates">是否为加息标：</td>
										<td class="con con-width">
											<span>添加利息：</span>
											<input type="text" value="${proRecord.rateAddRates}" class="select_able numberReg rateAddRates" dataTyValue="hundredNum" disabled='disabled' maxlength="6">
											<span>%</span>
										</td>
									</tr>
									<tr class="col-md-12">
										<td class="tt"><input type="checkbox" class="check_select isDirect" value="${proRecord.isDirect}">是否为定向标：</td>
										<td class="con con-width">
											<span>投资密码：</span>
											<input type="password" class="select_able directPwd" value="${proRecord.directPwd}" disabled='disabled' dataTyValue="newpass" maxlength="16">
										</td>
									</tr>
									<tr class="col-md-12">
										<td class="tt"><input type="checkbox" class="check_select isRewardRate">是否为奖励标：</td>
										<td class="con con-width">
											<span>填写返现：</span>
											<input type="text" value="${proRecord.rewardRates}" class="select_able numberReg rewardRates" disabled='disabled' dataTyValue="hundredNum" maxlength="6">
											<span>%*本金</span>
										</td>
									</tr>
									<tr class="col-md-12 red_surprise">
										<td class="tt red_packets"><input type="checkbox" class="check_select2">是否为红包惊喜标：</td>
										<td class="con con-money">
											<span class="addRed glyphicon glyphicon-plus"></span>
											<span class="reduceRed glyphicon glyphicon-minus"></span>
											<input type="hidden" id="redListSize" value="${fn:length(proPurpose.pEntities2)}">
											<ul class="red_list">
												<li class="red_add" >
													<c:if test="${fn:length(proPurpose.pEntities2) > 0}">
														<c:forEach var="item" items="${proPurpose.pEntities2}">
															<span>投资达到</span>
															<input class="redPack numberReg" value="${item.investRedPackageMin}" disabled='disabled' maxlength="8">
															<span>元的前</span>
															<input class="redPack numberReg" value="${item.investNum}" disabled='disabled' maxlength="8">
															<span>个，平台代付</span>
															<input class="redPack numberReg" value="${item.redPackage}" disabled='disabled' maxlength="8">
															<span>元红包</span>
														</c:forEach>
													</c:if>		
													<c:if test="${fn:length(proPurpose.pEntities2) == 0}">
															<span>投资达到</span>
															<input class="redPack numberReg"  disabled='disabled' maxlength="8">
															<span>元的前</span>
															<input class="redPack numberReg"  disabled='disabled' maxlength="8">
															<span>个，平台代付</span>
															<input class="redPack numberReg"  disabled='disabled' maxlength="8">
															<span>元红包</span>
													</c:if>		
												</li>
											</ul>
										</td>
									</tr>	
									<tr class="col-md-12">
										<!-- 选择担保机构 -->
										<td class="con con-width">
											<button type="button" class="add_mechanism" onclick="select_mechanism()">选择担保机构</button>
											<span class="mechanism"></span>
											<input type="hidden" class="guaranteeID">
											<input type="text" class="select_input2 select_able numberReg guaranteeName" disabled='disabled' maxlength="8">
										</td>
									</tr>	
									<tr class="col-md-12">
										<td class="con con-width">
											<button type="button" class="add_assetManagement" onclick="select_assetManagement()">选择资产管理方</button>
											<span class="assetManagement"></span>
											<input type="hidden" class="assetManagerID">
											<input type="text" class="select_input2 select_able numberReg managementName" disabled='disabled' maxlength="8">
										</td>
									</tr>	
									<tr class="col-md-12">
										<td class="tt"><input type="checkbox" class="check_select isRiskMargin">项目风险保证金：</td>
										<td class="con con-width" id="conProM">
											<c:if test="${proPurpose.projectAppMngFeeEntity.riskMarginType == 0}">
												<input type="text" value="${proPurpose.projectAppMngFeeEntity.riskMarginRate}" class="select_able numberReg riskMarginValue" disabled='disabled' maxlength="8">
											</c:if>
											<c:if test="${proPurpose.projectAppMngFeeEntity.riskMarginType == 1}">
												<input type="text" value="${proPurpose.projectAppMngFeeEntity.riskMarginFee}" class="select_able numberReg riskMarginValue" disabled='disabled' maxlength="8">
											</c:if>
											<c:if test="${proPurpose.projectAppMngFeeEntity.riskMarginType != 0 && proPurpose.projectAppMngFeeEntity.riskMarginType != 1}">
												<input type="text" value="${proPurpose.projectAppMngFeeEntity.riskMarginFee}" class="select_able numberReg riskMarginValue" disabled='disabled' maxlength="8">
											</c:if>
											<select class="unit_select riskMarginType" vlaue="${proPurpose.projectAppMngFeeEntity.riskMarginType}">
												<option value="0">%</option>
												<option value="1">元</option>
											</select>
										</td>
									</tr>				
									<tr class="col-md-12">
										<td class="tt"><input type="checkbox" class="check_select isMngFeeRate">收取借款管理费 ：</td>
										<td class="con con-width" id="conSQJKF">
											<input type="text" class="select_able mngFeeRate" value="${proPurpose.projectAppMngFeeEntity.mngFeeRate}" disabled='disabled' maxlength="6"><span>%</span>
										</td>
									</tr>				
									<tr class="col-md-12">
										<td class="tt"><label>允许投标人数 ：</label></td>
										<td class="con con-width" id="numberOF">
											<input type="text" class="select_able numberReg investCountMax" value="${proRecord.investCountMax}" datatype="nNum0" maxlength="8"><span>人</span>
										</td>
									</tr>
									<tr class="col-md-8 col-md-offset-4">
										<td class="tt"></td>
										<td class="con">
											<button type="button" class="btn btn-success appendixUpload">上传申请附件</button>
											<button type="button" class="btn btn-success btn-pre">保存</button>
											<button type="button" class="btn btn-default beforeBtn">返回</button>
										</td>
									</tr>
								</table>
								</form>
							</fieldset>
							<fieldset class="appendix" style="display:none">
							<!-- 附件信息展示 -->
							<ul class="authen">
								<li>
									<div class="detailTitle">
										<c:forEach var="item" items="${proPurpose.pEntities}">
											<span>
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
											</span>
											<span>${item.attachTitle}</span>
											<button class="viewDetail">查看详情</button>
										</c:forEach>
									</div>
									<div class="w-content detailAuthen">
										<div><samp>附件：</samp>
											<c:forEach var="item" items="${proPurpose.pEntities}">
												<img src="${hostPath}${item.attachUrl}">
											</c:forEach>
									 </div>
									</div>
								</li>
							</ul>
							<!-- 附件信息修改 -->
								<table>
									<tr class="col-md-12">					
										<td class="tt"><label>申请附件类型：</label></td>
										<td class="con">
											<select class="doc">
												<option value="">==选择==</option>
												<option value="1">借款方信息</option>
												<option value="2">抵押信息</option>
												<option value="3">现场调查信息</option>
												<option value="0">其它</option>
											</select>
										</td>
									</tr>
									<tr class="col-md-12">
										<td class="tt"><label>附件标题：</label></td>
										<td class="con conAddTitle" id="addTitle">
											<input type="text" class="add-title" datatype="roleNameb" value="" >
										</td>
									</tr>	
									<tr class="col-md-12">
										<td class="tt"><label>上传申请附件：</label></td>
										<td class="con">
											<div id="logo">
											    <!--用来存放item-->
											    <div id="filePicker">上传附件</div>
											    <span class="rec-dimensions">*可图片、文档、压缩包</span>
											</div>
										</td>
									</tr>
									<tr class="col-md-12">
										<td class="tt" valign="top"></td>
										<td class="con" id="fileList"></td>
									</tr>
									<!-- 附件添加结束 -->
									<tr class="col-md-8 col-md-offset-4">
										<td class="tt"></td>
										<td class="con">
											<button type="button" class="btn btn-success preBack">保存并返回</button>
											<button type="button" class="btn btn-default cancel">取消</button>
										</td>
									</tr>
								</table>
							</fieldset>		
						</div>
					</div>
				</div>
				<!-- 公用js -->
				<jsp:include page="../../common/cm-js.jsp"></jsp:include>
				<!-- 私用js -->
				<script type="text/javascript" src="plugs/ueditor/ueditor.config.js"></script>
				<script type="text/javascript" src="plugs/ueditor/ueditor.all.min.js"></script>
				<script type="text/javascript" src="plugs/webuploader/0.1.5/webuploader.js"></script>
				<script type="text/javascript" src="js/project/loanapply-upload.js"></script>
				<script type="text/javascript" src="js/project/add_info.js"></script>
			</div>
		</div>
	</div>
</body>
</html>				