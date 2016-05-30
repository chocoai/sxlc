<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String content = request.getParameter("content");
%>

	<jsp:include page="../../common/cm-addr.jsp"></jsp:include>
	<!-- 修改资产管理方信息部分开始 -->
	<div class="w-content ishow" id="asset-mod">
		<form id="manageAdd" action="javascript:modManage()">
			<div class="manageAddtitle">
				<span>修改资产管理方信息</span>
			</div>
			<table>
				<input id="managementID" type="hidden" value="<%=content %>" />
				<tr>
					<td class="addmanagetd"><label class="ineed">资产管理方名称</label></td>
					<td class="addmanageinput"><input id="managementName" type="text" class="" placeholder="" datatype="entername" /></td>
					<td class="addmanagetd"><label class="ineed">营业执照号码</label></td>
					<td class="addmanageinput"><input id="companyeBLN" type="text" class="" placeholder="" datatype="businessNum" /></td>
				</tr>
				<tr>
					<td class="addmanagetd"><label class="ineed">组织机构代码</label></td>
					<td class="addmanageinput"><input id="companyOC" type="text" class="" placeholder="" datatype="orgcode" /></td>
					<td class="addmanagetd"><label class="ineed">税务登记号</label></td>
					<td class="addmanageinput"><input id="taxRegNo" type="text" class="" placeholder="" datatype="businessNum"/></td>
				</tr>
				<tr>
					<td class="addmanagetd"><label>经营场所</label></td>
					<td class="addmanageinput"><input id="establishments" type="text" class="" placeholder="" datatype="z2_20" ignore="ignore"/></td>
					<td class="addmanagetd"><label>注册资金</label></td>
					<td class="addmanageinput"><input id="companyCapital" type="text" class="" placeholder="" datatype="acountM" ignore="ignore"/></td>
				</tr>
				<tr>
					<td class="addmanagetd"><label class="ineed">法人姓名</label></td>
					<td class="addmanageinput"><input id="personalName" type="text" class="" placeholder="" datatype="enterperson"/></td>
					<td class="addmanagetd"><label class="ineed">法人手机号</label></td>
					<td class="addmanageinput"><input id="personalPhone" type="text" class="" placeholder="" datatype="zPhone"/></td>
				</tr>
				<tr>
					<td class="addmanagetd"><label class="ineed">法人身份证号</label></td>
					<td class="addmanageinput"><input id="personalIDCard" type="text" class="" placeholder="" datatype="IDCard"/></td>
					<td class="addmanagetd"><label>注册地址</label></td>
					<td class="addmanageinput"><input id="companyAddress" type="text" class="" placeholder="" datatype="enterAddress" ignore="ignore"/></td>
				</tr>
				<tr>
					<td class="addmanagetd"><label>注册资本来源</label></td>
					<td class="addmanageinput"><input id="companySource" type="text" class="" placeholder="" datatype="reMarks" ignore="ignore"/></td>
					<td class="addmanagetd"><label>经营范围</label></td>
					<td class="addmanageinput"><input id="companyBusiness" type="text" class="" placeholder="" datatype="reMarks" ignore="ignore"/></td>
				</tr>
				<tr>
					<td class="addmanagetd"><label>公司简介</label></td>
					<td class="addmanageinput"><input id="companyProfile" type="text" class="" placeholder="" datatype="rolemarkC" ignore="ignore"/></td>
					<td class="addmanagetd"><label>联系人姓名</label></td>
					<td class="addmanageinput"><input id="contactName" type="text" class="" placeholder="" datatype="realName" ignore="ignore"/></td>
				</tr>
				<tr>
					<td class="addmanagetd"><label>联系人手机号</label></td>
					<td class="addmanageinput"><input id="contactPhone" type="text" class="" placeholder="" datatype="zPhone" ignore="ignore"/></td>
					<td class="addmanagetd"><label>联系人邮箱</label></td>
					<td class="addmanageinput"><input id="contactEmail" type="text" class="" placeholder="" datatype="email" ignore="ignore"/></td>
				</tr>
			</table>
			<div class="cmbtncontainer containerbtndiv">
				<a class="commonbtn0">修改</a>
				<a href="web/recommend/asset-management.jsp">取消</a>
			</div>
		</form>
	</div>
	<!-- 修改资产管理方信息部分结束 -->		
	
	<!-- 私用js -->
	<script type="text/javascript" src="plugs/webuploader/0.1.5/webuploader.js"></script>
	<script type="text/javascript" src="js/recommend/re-guamanage.js"></script>
	<script type="text/javascript" src="js/recommend/assetmod.js"></script>
	<script type="text/javascript">
		$(function(){
			validform5(".commonbtn0","asset-mod",false,"5");
		});
	</script>
	<script type="text/javascript">
		var publicKey_common = '<%=session.getAttribute("publicKey") %>';
	</script>
			