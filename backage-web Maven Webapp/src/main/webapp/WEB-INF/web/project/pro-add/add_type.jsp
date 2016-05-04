<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
request.setCharacterEncoding("UTF-8");
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<jsp:include page="../../common/cm-addr.jsp"></jsp:include>
<div class="" id="checkDetail">
	<div class="container add_type_contianer">
		<div class="w-content ishow">
		   <form class="form-horizontal" role="form" name="" action="javascript:addOrModify()" id="dataForm">
			<table>
				<tr>
					<input type="hidden" id="projectId" value="${project.id}"/>
					<td class="tt"><label>类型名称：</label></td>
					<td class="con" id="roleNamea"><input type="text" class="proKindName" value="${project.projectName}" datatype="roleNamea" maxlength="6"></td>
				</tr>
				<tr>
					<td class="tt"><label>融资额度：</label></td>
					<td class="con">
					<input type="text" class="beginNum minAmount" datatype="nNum0" value="${project.minAmount}" maxlength="8">
					<span>——</span>
					<input type="text" class="endNum maxAmount" datatype="nNum0" value="${project.maxAmount}" maxlength="8">
					<span>元</span>
					<span class="errorMsg" style="color:red"></span>
					</td>
				</tr>
				<tr>
					<td class="tt">年化利率：</td>
					<td class="con">
					<input type="text" class="beginNum minRate" value="${project.minRates}" datatype="hundredNum" maxlength="5">
					<span>——</span>
					<input type="text"  class="endNum maxRate" value="${project.maxRates}" datatype="hundredNum" maxlength="5">
					<span>%</span>
					<span class="errorMsg" style="color:red"></span>
					</td>					
				</tr>
				<tr>
					<td class="tt">项目期限：</td>
					<td class="con">
						<input type="text" class="beginNum minDaytimeY" value="${project.yminDaytime}" datatype="nNum0" maxlength="4">
						<span>——</span>
						<input type="text" class="endNum maxDaytimeY" value="${project.ymaxDaytime}" datatype="nNum0" maxlength="4">
						<span>年</span>	
						<span id="errorMsg" style="color:red"></span>			
					</td>
				</tr>
				<tr>
					<td class="tt"></td>
					<td class="con">
						<input type="text" class="beginNum minDaytimeM" value="${project.mminDaytime}" datatype="nNum0" maxlength="4">
						<span>——</span>
						<input type="text" class="endNum maxDaytimeM" value="${project.mmaxDaytime}" datatype="nNum0" maxlength="4">
						<span>月</span>	
						<span class="errorMsg" style="color:red"></span>		
					</td>					
				</tr>
				<tr>
					<td class="tt"></td>
					<td class="con">
						<input type="text" class="beginNum minDaytimeD" value="${project.tminDaytime}" datatype="nNum0" maxlength="4">
						<span>——</span>
						<input type="text" class="endNum maxDaytimeD" value="${project.tmaxDaytime}" datatype="nNum0" maxlength="4">
						<span>天</span>		
						<span class="errorMsg" style="color:red"></span>
					</td>					
				</tr>
				<tr>
					<td class="tt">是否要抵押：</td>
					<td class="con">
						<select class="assettype" value="${project.isMortgage}">
							<option>请选择</option>
							<c:if test="${project.isMortgage == 1}">
								<option value="1" selected="selected">是</option>
								<option value="0" >否</option>
							</c:if>		
							<c:if test="${project.isMortgage == 0}">
								<option value="1" >是</option>
								<option value="0" selected="selected">否</option>
							</c:if>		
						</select>
					</td>
				</tr>
				<tr>
					<td class="tt">产品认证项：</td>
					<td class="con">
						<select class="identitySelection">
							<option>请选择</option>
							<option value="0">全部</option>
							<option value="1">个人</option>
							<option value="2">企业</option>		
						</select>
					</td>
				</tr>
				<tr>
					<td></td>
					<td>
						<div class="con-whole">
							<div class="person" style="display:none">
								<p>个人认证：</p>
								<div class="con-next">
									<c:forEach var="item" items="${person}">
										<span><input type="checkbox" typeId = "1" value="${item.attestTypeID}">${item.attestTypeName}</span>
									</c:forEach>
								</div>
							</div>
							<div class="enterprise" style="display:none">
								<p>企业认证：</p>
								<div class="con-next">
									<c:forEach var="item" items="${enterprise}">
										<span><input type="checkbox" typeId = "0" value="${item.attestTypeID}">${item.attestTypeName}</span>
									</c:forEach>
								</div>						
							</div>	
						</div>		
					</td>
				</tr>
				<tr>
					<td class="tt">展示图片：</td>
					<td class="con">
						<div >
						    <!--用来存放item-->
						    <div id="filePicker">选择图片</div>
						    <span class="rec-dimensions"></span>
						</div>
					</td>
				</tr>
				<tr>
					<input type="hidden" id="picUrl" value="${item.picUrl}" />
					<td class="tt" valign="top">图片预览：</td>
					<td class="con">
						<div class="filelist" id="fileList"></div>
					</td>
				</tr>
				<tr>
					<td class="tt">产品小图标：</td>
					<td class="con">
						<div >
						    <!--用来存放item-->
						    <div id="filePicker1">选择图片</div>
						    <span class="rec-dimensions">建议尺寸：25*25</span>
						</div>
					</td>
				</tr>
				<tr>
					<input type="hidden" id="picIcon" value="${item.picIcon}" />
					<input type="hidden" id="hostPath" value="${hostPath}"/>
					<td class="tt" valign="top">图片预览：</td>
					<td class="con">
						<div class="filelist" id="fileList1"></div>
					</td>
				</tr>
				<tr>
					<td class="tt">类型简介：</td>
					<td class="con"><textarea cols="20" rows="3" class="briefIntroduction" maxlength="256">${project.briefIntroduction}</textarea></td>
				</tr>
				
				<tr>
					<td class="tt">申请指南：</td>
					<td class="con">
						<script id="applyguide" type="text/plain" style="width:98%" contentG="${project.contentG}"></script>
					</td>
				</tr>
				<tr>
					<td class="tt">还款指南：</td>
					<td class="con">
						<script id="payguide" type="text/plain" style="width:98%" contentR="${project.contentR}"></script>
					</td>
				</tr>
				<tr>
					<td class="tt"></td>
					<td class="con">
						<button type="button" class="btn btn-success">保存</button>
						<button type="button" class="btn btn-default"  onclick="window.location.href='project/toProTypePg';">返回</button>
					</td>
				</tr>
			</table>
		   </form>
		</div>  
	</div>
</div>
<!-- 公用js -->
<script type="text/javascript" src="plugs/webuploader/0.1.5/webuploader.js"></script>
<script type="text/javascript" src="js/config/upload.js"></script>
<!-- <script type="text/javascript" src="js/project/protype-upload.js"></script> -->
<!-- 私用js -->
<script type="text/javascript" src="js/project/add_type.js"></script>

