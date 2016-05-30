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
	<title>项目发布</title>
	<!-- 公用meta -->
	<jsp:include page="../../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link rel="stylesheet" href="css/project/post_list.css" type="text/css"></link>
	<link rel="stylesheet" href="css/project/loan_pro_post.css" />
	<link rel="stylesheet" href="plugs/webuploader/0.1.5/webuploader.css" />
	<link rel="stylesheet" href="css/upload.css" />
</head>
<!-- 项目发布--------列表信息查询展示 -->
<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../../common/cm-top.jsp">
				<jsp:param value="3" name="_index_m1"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../../common/cm-project.jsp">
				<jsp:param value="304" name="_index_m2"/>
				<jsp:param value="" name="_index_m3"/>
			</jsp:include>
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../../common/cm-addr.jsp"></jsp:include>
				<div id="checkDetail">
					<div class="container add_type_contianer">
						<div class="container body addContainer">
							<div class="main_container">
								<div class="w-content ishow pic-add">
									<!-- 信息展示模块 -->
									<div class="infoDisplay">
										<fieldset>
											<legend>项目基本信息</legend>
											<input type="hidden" id="applyId" value="${proRecord.applyId}">
											<input type="hidden" id="Indexsnow" value="${Indexsnow}">
											<input type="hidden" id="pgType" value="${pgType}">
											<table>
												<tr class="col-md-4">
													<td class="tt"><label>借款项目名称：</label></td>
													<td class="con">${proRecord.projectBaseInfoentity.projectTitle}</td>
												</tr>	
												<tr class="col-md-4">
													<td class="tt"><label>借款金额：</label></td>
													<td class="con">${proRecord.projectBaseInfoentity.amounts}</td>
												</tr>
												<tr class="col-md-4">
													<td class="tt"><label>还款方式：</label></td>
													<td class="con">
														<c:if test="${proRecord.projectBaseInfoentity.repayWay == 0}">
															  等额本息
														</c:if>														
														<c:if test="${proRecord.projectBaseInfoentity.repayWay == 1}">
															  每月还息，到期还本
														</c:if>														
														<c:if test="${proRecord.projectBaseInfoentity.repayWay == 2}">
															  到期还息本
														</c:if>														
														<c:if test="${proRecord.projectBaseInfoentity.repayWay == 3}">
															  等额本金	
														</c:if>														
													</td>
												</tr>
												<tr class="col-md-4">
													<td class="tt"><label>借款期限：</label></td>
													<td class="con">
														<span>${proRecord.projectBaseInfoentity.deadline}</span>
														<c:if test="${proRecord.projectBaseInfoentity.deadlineType == 0}">
															 天
														</c:if>		
														<c:if test="${proRecord.projectBaseInfoentity.deadlineType == 1}">
															 月
														</c:if>		
														<c:if test="${proRecord.projectBaseInfoentity.deadlineType == 2}">
															 年
														</c:if>		
													</td>
												</tr>
												<tr class="col-md-4">
													<td class="tt"><label>最大投资比例：</label></td>
													<td class="con">${proRecord.investMaxs}<span>%</span>
													</td>
													
												</tr>
												<tr class="col-md-4">
													<td class="tt"><label>年化利率：</label></td>
													<td class="con">${proRecord.projectBaseInfoentity.yearRates}
													<span>%</span>
													</td>
												</tr>
												<tr class="col-md-4">
													<td class="tt"><label>起投金额：</label></td>
													<td class="con">${proRecord.minStarts}
														<span>元</span>
													</td>
												</tr>
												<tr class="col-md-4">
													<td class="tt"><label>加价幅度：</label></td>
													<td class="con">${proRecord.increaseRanges}
														<span>元</span>
													</td>
												</tr>
												<tr class="col-md-4">
													<td class="tt"><label>单人最大投资笔数：</label></td>
													<td class="con">${proRecord.investCountMax}<span>笔</span>
													</td>
												</tr>
												<tr class="col-md-4">
													<td class="tt"><label>还款保障：</label></td>
													<td class="con">${proRecord.repayGuarantee}</td>
												</tr>
												<tr class="col-md-4">
													<td class="tt"><label>借款用途：</label></td>
													<td class="con">${proRecord.projectBaseInfoentity.uses}</td>
												</tr>
												<tr class="col-md-4">
													<td class="tt"><label>还款来源：</label></td>
													<td class="con">${proRecord.projectBaseInfoentity.repaySource}</td>
												</tr>
												<tr class="col-md-4">
													<td class="tt"><label>项目描述：</label></td>
													<td class="con">${proRecord.projectBaseInfoentity.projectDescript}</td>
												</tr>
												<tr class="col-md-7 col-md-offset-5">	
													<td class="tt">
														<button class="btn btn-info btnMod">修改</button>
													</td>
												</tr>
											</table>
										</fieldset>
									</div><!-- 信息展示模块结束 -->
									<!-- 信息修改模块开始 -->
									<div class="infoMod" style="display:none">
										<fieldset>
										  <legend>项目基本信息修改</legend>
										   <form id="modInfo" action="javascript:nextSave();" method="post">	
											<table>
												<tr class="col-md-4">
													<td class="tt"><label>借款项目名称：</label></td>
													<td class="con">
														<input type="text" id="projectTitle" class="enterN-r"  value="${proRecord.projectBaseInfoentity.projectTitle}" datatype="enterNameR" maxlength="16">
													</td>
												</tr>	
												<tr class="col-md-4">
													<td class="tt"><label>借款金额：</label></td>
													<td class="con">
														<input type="text" id="amount" class="loanMoney numberReg" value="${proRecord.projectBaseInfoentity.amounts}" datatype="acountM" maxlength="13">
													</td>
												</tr>
												<tr class="col-md-4">
													<td class="tt"><label>还款方式：</label></td>
													<td class="con">
														<select id="repayWay" class="repayWay" selectValue="${proRecord.projectBaseInfoentity.repayWay}">
															<option value="3" >等额本金</option>
															<option value="0" >等额本息</option>
															<option value="1" >每月还息，到期还本</option>
															<option value="2" >到期还本息</option>
														</select>
													</td>
												</tr>
												<tr class="col-md-4">
													<td class="tt"><label>借款期限：</label></td>
													<td class="con">
													<input type="text" id="deadline" class="con-term numberReg" value="${proRecord.projectBaseInfoentity.deadline}" datatype="nNum0" maxlength="6">
													<select class="conT" id="deadlineType" selectValue="${proRecord.projectBaseInfoentity.deadlineType}">
														<option value="0">天</option>
														<option value="1">月</option> 
														<option value="2">年</option>
													</select>
													</td>
												</tr>
												<tr class="col-md-4">
													<td class="tt"><label>最大投资比例：</label></td>
													<td class="con">
													<input type="text" id="investMax" class="con-PP numberReg" value="${proRecord.investMaxs}" datatype="hundredNum" maxlength="8">
													<span>%</span>
													</td>
												</tr>
												<tr class="col-md-4">
													<td class="tt"><label>年化利率：</label></td>
													<td class="con">
														<input type="text"  id="yearRate" class="startTY numberReg" value="${proRecord.projectBaseInfoentity.yearRates}" datatype="hundredNum" maxlength="8">
														<span>%</span>
													</td>
												</tr>
												<tr class="col-md-4">
													<td class="tt"><label>起投金额：</label></td>
													<td class="con">
														<input type="text" id="minStart" class="startingIA numberReg" value="${proRecord.minStarts}" datatype="acountM" maxlength="13">
														<span>元</span>
													</td>
												</tr>
												<tr class="col-md-4">
													<td class="tt"><label>加价幅度：</label></td>
													<td class="con">
														<input type="text" id="increaseRange" class="conIncrease numberReg" value="${proRecord.increaseRanges}" datatype="acountM" maxlength="13">
														<span>元</span>
													</td>
												</tr>
												<tr class="col-md-4">
													<td class="tt"><label>单人最大投资笔数：</label></td>
													<td class="con">
														<input type="text" id="investCountMax" class="con-PP numberReg" value="${proRecord.investCountMax}" datatype="nNum0" maxlength="3">
														<span>笔</span>
													</td>
												</tr>
												<tr class="col-md-4">
													<td class="tt"><label>还款保障：</label></td>
													<td class="con">
														<textarea cols="20" rows="3" name="" id="RepayGuarantee"  maxlength="125">${proRecord.repayGuarantee}</textarea>
													</td>
												</tr>
												<tr class="col-md-4">
													<td class="tt"><label>借款用途：</label></td>
													<td class="con">
														<textarea cols="20" rows="3" name=""  id="uses" maxlength="125">${proRecord.projectBaseInfoentity.uses}</textarea>
													</td>
												</tr>
												<tr class="col-md-4">
													<td class="tt"><label>还款来源：</label></td>
													<td class="con">
														<textarea cols="20" rows="3" name=""  id="repaySource" maxlength="200">${proRecord.projectBaseInfoentity.repaySource}</textarea>
													</td>
												</tr>
												<tr class="col-md-4">
													<td class="tt"><label>项目描述：</label></td>
													<td class="con">
														<textarea cols="20" rows="3" name=""  id="projectDescript" maxlength="200">${proRecord.projectBaseInfoentity.projectDescript}</textarea>
													</td>
												</tr>
												<tr class="col-md-7 col-md-offset-5">
													<td class="tt">
														<button type="button" class="btn btn-success btnPreserve">保存</button>
														<button type="button" class="btn btn-default btnCancel">取消</button>
													</td>
												</tr>
											</table>
											</form>
										</fieldset>
									</div><!-- 信息修改模块结束 -->
									<!-- 认证展示模块 -->
									<c:if test="${memberInfo.memberType == 0}">
										<fieldset class="person" style="display:block"><!-- 个人信息 -->
											<legend>会员基本信息</legend>
											<div class="w-content ishow">
												<table>
													<tr class="col-md-3">
														<td class="tt"><label>会员编号：</label></td>
														<td class="con">${memberInfo.memberNo}</td>
													</tr>
													<tr class="col-md-3">
														<td class="tt"><label>会员用户名：</label></td>
														<td class="con">${memberInfo.logname}</td>
													</tr>
													<tr class="col-md-3">
														<td class="tt"><label>真实姓名：</label></td>
														<td class="con">${memberInfo.personalName}</td>
													</tr>
													<tr class="col-md-3">
														<td class="tt"><label>身份证号：</label></td>
														<td class="con">${memberInfo.personalIdCard}</td>
													</tr>
													<tr class="col-md-3">
														<td class="tt"><label>手机号码：</label></td>
														<td class="con">${memberInfo.personalPhone}</td>
													</tr>
													<tr class="col-md-3">
														<td class="tt"><label>最高学历：</label></td>
														<td class="con">${memberInfo.educationName}</td>
													</tr>
													<tr class="col-md-3">
														<td class="tt"><label>婚姻状况：</label></td>
														<td class="con">${memberInfo.maritalName}</td>
													</tr>
													<tr class="col-md-3">
														<td class="tt"><label>地区：</label></td>
														<td class="con">${memberInfo.provinceName}${memberInfo.cityName}</td>
													</tr>
													<tr class="col-md-3">
														<td class="tt"><label>月均收入：</label></td>
														<td class="con">${memberInfo.monthlyIncome}<span>元</span></td>
													</tr>
													<tr class="col-md-4">
														<td class="tt"><label>注册时间：</label></td>
														<td class="con">${memberInfo.regDate}</td>
													</tr>
												</table>
											</div>
										</fieldset>
									</c:if>	
									<c:if test="${memberInfo.memberType == 1}">
										<fieldset class="enterprise" style="display:block"><!-- 企业信息 -->
											<legend>会员基本信息</legend>
											<div class="w-content ishow">
												<table>
													<tr class="col-md-3">
														<td class="tt"><label>会员编号：</label></td>
														<td class="con">${memberInfo.memberNo}</td>
													</tr>
													<tr class="col-md-3">
														<td class="tt"><label>会员用户名：</label></td>
														<td class="con">${memberInfo.logname}</td>
													</tr>
													<tr class="col-md-3">
														<td class="tt"><label>企业名称：</label></td>
														<td class="con">${memberInfo.personalName}</td>
													</tr>
													<tr class="col-md-3">
														<td class="tt"><label>营业执照号：</label></td>
														<td class="con">${memberInfo.companyeBLN}</td>
													</tr>
													<tr class="col-md-3">
														<td class="tt"><label>联系人：</label></td>
														<td class="con">${memberInfo.contactName}</td>
													</tr>
													<tr class="col-md-3">
														<td class="tt"><label>联系人手机号：</label></td>
														<td class="con">${memberInfo.personalPhone}</td>
													</tr>
													<tr class="col-md-3">
														<td class="tt"><label>地区：</label></td>
														<td class="con">${memberInfo.provinceName}${memberInfo.cityName}</td>
													</tr>
													<tr class="col-md-3">
														<td class="tt"><label>注册时间：</label></td>
														<td class="con">${memberInfo.regDate}</td>
													</tr>
												</table>
											</div>
										</fieldset><!-- 认证展示模块结束 -->
									</c:if>	
									<c:if test="${memberInfo.memberType != 0 && memberInfo.memberType != 1}">
										<fieldset class="" style="display:block"><!-- 企业信息 -->
											<legend>会员基本信息</legend>
											<div class="w-content ishow">
												<table>
													<tr class="col-md-3">
														<td class="tt"><label>无法确定的会员类型</label></td>
													</tr>
												</table>
											</div>
										</fieldset>
									</c:if>
									
									
									<!-- 信用统计模块 -->
									<fieldset>
										<legend>借款信用统计</legend>
										<div class="w-content ishow">
											<table>
												<tr class="col-md-3">
													<td class="tt"><label>成功借款：</label></td>
													<td class="con">${credit.successLoan}<span>笔</span></td>
												</tr>
												<tr class="col-md-3">
													<td class="tt"><label>成功还款：</label></td>
													<td class="con">${credit.successReplay}<span>笔</span></td>
												</tr>
												<tr class="col-md-3">
													<td class="tt"><label>成功投资：</label></td>
													<td class="con">${credit.successInvest}<span>笔</span></td>
												</tr>
												<tr class="col-md-3">
													<td class="tt"><label>逾期还款：</label></td>
													<td class="con">${credit.overReplay}<span>笔</span></td>
												</tr>
												<tr class="col-md-3">
													<td class="tt"><label>严重逾期还款：</label></td>
													<td class="con">${credit.overlimitReplay}<span>笔</span></td>
												</tr>
												<tr class="col-md-3">
													<td class="tt"><label>逾期未还款：</label></td>
													<td class="con">${credit.overnotreplay}<span>笔</span></td>
												</tr>
												<tr class="col-md-3">
													<td class="tt"><label>提前还款：</label></td>
													<td class="con">${credit.successAdvance}<span>笔</span></td>
												</tr>
											</table>
										</div>
									</fieldset><!-- 信用统计模块结束 -->
									<!-- 投资统计模块 -->
									<fieldset>
										<legend>投资统计信息</legend>
										<div class="w-content ishow">
											<table>
												<tr class="col-md-3">
													<td class="tt"><label>成功投资笔数：</label></td>
													<td class="con">${invest.successInvest}<span>笔</span></td>
												</tr>
												<tr class="col-md-3">
													<td class="tt"><label>成功投资金额：</label></td>
													<td class="con">${invest.successInvestAmount}<span>元</span></td>
												</tr>
												<tr class="col-md-3">
													<td class="tt"><label>累计已收本金：</label></td>
													<td class="con">${invest.successRecvPrincipalTotal}<span>元</span></td>
												</tr>
												<tr class="col-md-3">
													<td class="tt"><label>累计已收收益：</label></td>
													<td class="con">${invest.incomeTotal}<span>元</span></td>
												</tr>
												<tr class="col-md-3">
													<td class="tt"><label>待收本金：</label></td>
													<td class="con">${invest.notSDRecvPrincipal}<span>元</span></td>
												</tr>
												<tr class="col-md-3">
													<td class="tt"><label>待收收益：</label></td>
													<td class="con">${invest.notSDRecvInterest}<span>元</span></td>
												</tr>
											</table>
										</div>
									</fieldset><!-- 投资统计模块结束 -->
									<!-- 认证展示模块 -->
									<input type="hidden" id="memberID" value="${memberInfo.memberID}"/>
									<fieldset class="personAuthentication">
										<c:if test="${memberInfo.memberType ==0 }">
											<legend>个人会员基本信息</legend>
										</c:if>
										<c:if test="${memberInfo.memberType ==1 }">
											<legend>企业会员基本信息</legend>
										</c:if>
										<c:if test="${memberInfo.memberType != 0 && memberInfo.memberType != 1}">
											<legend>无法确定的会员类型</legend>
										</c:if>
										<div class="w-content ishow">
											<table id="identy_types">
											</table>
										</div>
									</fieldset>
									<!-- 项目申请附件信息-->
									<div class="infoDisplay">
										<fieldset>
											<legend>项目申请附件信息</legend>
											<table>
												<tr>
													<c:forEach var="item" items="${attaches}"  varStatus="status">
														<td style="vertical-align:bottom;">
																<div>
																	<img style="max-height: 150px;max-width: 150px;" title="${item.attachTitle}" src="${hostPath}${item.attachUrl}">
																</div>
																<div style="height: 10px;">
																	<c:choose>
																		<c:when test="${item.attachInfoType == 1}">
																			借款方资料:${item.attachTitle}
																		</c:when>
																		<c:when test="${item.attachInfoType == 2}">
																			抵押资料:${item.attachTitle}
																		</c:when>
																		<c:when test="${item.attachInfoType == 3}">
																			现场调查资料:${item.attachTitle}
																		</c:when>
																		<c:otherwise>
																			其他	: ${item.attachTitle}
																		</c:otherwise>
																	</c:choose>
																</div>
														</td>
														<td style="height: 50px;"></td>
														<c:if test="${status.index !=0 && (status.index+1) %5 ==0}">
														  </tr>
														  <tr>
														</c:if>
													</c:forEach>
												</tr>
											</table>
										</fieldset>
									</div><!-- 项目申请附件信息结束 -->
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- tab切换 -->
				<ul class="nav nav-tabs">
					<li role="presentation" class="active"><a href="javascript:void(0);">历史审核记录</a></li>
					<li role="presentation"><a href="javascript:void(0);">历史审核附件</a></li>
					<li role="presentation"><a href="javascript:void(0);">附件删除记录</a></li>
				</ul>
				<!-- 第一页基本信息结束 -->
				<!-- 审核记录审核附件删除记录 -->
				<div class="nav-tabs-con active">
					<div class="data_display">
						<div class="panel panel-success">
							<div class="panel-body">
								<table id="table_history_record" class="display">
							    </table>
						    </div>
						</div>
					</div>
				</div>
				<div class="nav-tabs-con">
					<div class="data_display">	
						<div class="panel panel-success">
						    <div class="panel-body">
								<table id="table_history_enclosure" class="display">
							    </table>
						    </div>
						</div>
					</div>
				</div>
				<div class="nav-tabs-con">
					<div class="data_display">
						<div class="panel panel-success">
							<div class="panel-body">
								<table id="table_history_del" class="display">
						    	</table>
						    </div>
						</div>
					</div>
				</div>
				<!-- 审核记录审核附件删除记录结束 -->
				
				<c:if test="${pgType == 2}">
					<!--项目发布操作---开始  -->
					<fieldset class="uploadEnclosure postDiv">
						<legend>上传项目图片</legend>
						<table>
							<tr>
								<input type="hidden" id="ImageUrl">
								<td class="tt">上传项目形象图片：</td>
								<td class="con">
									<!--dom结构部分-->
									<div id="uploader">
									    <!--用来存放item-->
									    <div id="filePicker">图片选择</div>
									</div>
								</td>
							</tr>
							<tr>
								<td class="tt" valign="top"></td>
								<td class="con" id="fileList"></td>
							</tr>
							<tr>
								<input type="hidden" id="affix">
								<td class="tt" valign="top">项目前台显示图片名称：</td>
								<td class="con" >
									<input type="text" id="fileName">
								</td>
							</tr>
							<tr>
								<td class="tt"></td>
								<td class="con">
									<!--dom结构部分-->
									<div >
									    <!--用来存放item-->
									    <div id="filePicker1">图片选择</div>
									</div>
								</td>
							</tr>
							<tr>
								<td class="tt" valign="top"></td>
								<td class="con fileList" id="fileList1"></td>
							</tr>
							<tr>
								<td class="tt">选择项目起止时间:</td>
								<td class="con"><input type="text" id="startDate" class="dateInput Wdate" onFocus="WdatePicker({maxDate: '#F{$dp.$D(\'endDate\')||\'2020-10-01\'}' })" ><span class="line"></span><input type="text" id="endDate" class="dateInput Wdate"  onFocus="WdatePicker({minDate: '#F{$dp.$D(\'startDate\')}' ,maxDate:'2020-10-01' })" ></td>
							</tr>
						</table>
						<div class="preserveBtn">
							<button class="btn btn-success postBtn">发布</button>
							<button class="btn btn-default cancleAndReturn">取消</button>
						</div>
					</fieldset>
					<!--项目发布操作---结束  -->
				</c:if>
				<c:if test="${pgType == 1}">
					<!--项目审核操作---开始  -->
					<fieldset class="uploadEnclosure chkDiv">
						<legend>上传项目审核附件信息</legend>
						<table>
							<input type="hidden" id="affixChk">
							<tr class="col-lg-12 col-md-12">
								<td class="tt"><label>附件名称：</label></td>
								<td class="con"><input id="attachName" type="text" ></td>
							</tr>
							<tr>
								<td><span>&nbsp;&nbsp;</span></td>
							</tr>
							<tr class="col-lg-12 col-md-12">
								<td class="tt">上传附件：</td>
								<td class="con">
									<!--dom结构部分-->
									<div>
									    <!--用来存放item-->
									    <div id="filePicker2">图片选择</div>
									</div>
								</td>
							</tr>
							<tr class="col-lg-12 col-md-12">
								<td class="tt" valign="top"></td>
								<td class="con fileList" id="fileList2"></td>
							</tr>
						</table>
					</fieldset>
					<fieldset class="uploadEnclosure chkDiv">
						<table>
							<tr class="col-md-12">
								<td class="tt"><label>选择审核结果：</label></td>
								<td class="con">
									<select class="auditResult">
										<option value="1">同意</option>
										<option value="-1">驳回</option>
										<option value="2">通过需补齐资料</option>
									</select>
								</td>
							</tr>
							<tr>
								<td><span>&nbsp;</span></td>
							</tr>
							<tr class="col-md-12">
								<td class="tt"><label>填写审核意见：</label></td>
								<td class="con">
									<textarea id="CheckRemark" rows="5" cols="80"></textarea>
								</td>
							</tr>
							<tr class="col-lg-12 col-md-12 buttonS" align="right">
								<td class="ts">
									<button class="btn btn-success chkSubmitBtn">提交</button>
									<button class="btn btn-default cancleAndReturn">取消</button>
								</td>
							</tr>
						</table>		
					</fieldset>	
					<!--项目审核操作---结束  -->
				</c:if>
			</div>
		</div>
		<!-- 公用js -->
		<jsp:include page="../../common/cm-js.jsp"></jsp:include>
		<!-- 私用js -->
<!-- 		<script src="js/project/post_list.js"></script> -->
<!-- 		<script type="text/javascript" src="js/project/loan_pro_exam.js"></script> -->
		<script type="text/javascript" src="plugs/webuploader/0.1.5/webuploader.js"></script>
		<script type="text/javascript" src="js/project/loan_pro_post.js"></script>
		<script type="text/javascript" src="js/member/memberDetail.js"></script>
	</div>

</body>

</html>



