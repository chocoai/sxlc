<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String content = request.getParameter("content");
%>

	<jsp:include page="../../common/cm-addr.jsp"></jsp:include>
	<!-- 修改担保机构信息部分开始 -->
	<div class="w-content ishow" id="asset-mod">
		<form id="manageMod" action="javascript:modgua()">
			<div class="manageAddtitle">
				<span>修改担保机构信息</span>
			</div>
			<table>
				<tr>
					<td class="addmanagetd"><label class="ineed">担保机构名称</label></td>
					<td class="addmanageinput"><input id="guaranteeName" type="text" class="" placeholder="" datatype="entername" />
						<input id="guId" type="hidden" value="<%=content %>" />
					</td>
					<td class="addmanagetd"><label class="ineed">营业执照号码</label></td>
					<td class="addmanageinput"><input id="companyeBLN" type="text" class="" placeholder="" datatype="businessNum" /></td>
				</tr>
				<tr>
					<td class="addmanagetd"><label class="ineed">组织机构代码</label></td>
					<td class="addmanageinput"><input id="companyOC" type="text" class="" placeholder="" datatype="orgcodefmt" /></td>
					<td class="addmanagetd"><label class="ineed">税务登记号</label></td>
					<td class="addmanageinput"><input id="taxRegNo" type="text" class="" placeholder="" datatype="businessNum"/></td>
				</tr>
				<tr>
					<td class="addmanagetd"><label>经营场所</label></td>
					<td class="addmanageinput"><input id="establishments" type="text" class="" placeholder="" datatype="z2_20" ignore="ignore"/></td>
					<td class="addmanagetd"><label>注册资金</label></td>
					<td class="addmanageinput"><input id="companyCapital" type="text" class="" placeholder="" datatype="amcountM" ignore="ignore"/></td>
				</tr>
				<tr>
					<td class="addmanagetd"><label class="ineed">法人姓名</label></td>
					<td class="addmanageinput"><input id="personalName" type="text" class="" placeholder="" datatype="enterperson"/></td>
					<td class="addmanagetd"><label class="ineed">法人手机号</label></td>
					<td class="addmanageinput"><input id="personalPhone" type="text" class="" placeholder="" datatype="zPhone"/></td>
				</tr>
				<tr>
					<td class="addmanagetd"><label class="ineed">法人身份证号</label></td>
					<td class="addmanageinput"><input id="personalIDCard" type="text" class="" placeholder="" datatype="idcard"/></td>
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
					<td class="addmanageinput"><input id="contactName" type="text" class="" placeholder="" datatype="z2_12" ignore="ignore"/></td>
				</tr>
				<tr>
					<td class="addmanagetd"><label>联系人手机号</label></td>
					<td class="addmanageinput"><input id="contactPhone" type="text" class="" placeholder="" datatype="zPhone" ignore="ignore"/></td>
					<td class="addmanagetd"><label>联系人邮箱</label></td>
					<td class="addmanageinput"><input id="contactEmail" type="text" class="" placeholder="" datatype="email" ignore="ignore"/></td>
				</tr>
			</table>
			<div class="layui-layer-btn addproprocessbtn">
				<a class="layui-layer-btn0">修改</a>
				<a class="layui-layer-btn1" href="web/recommend/guarantee-manage.jsp">取消</a>
			</div>
		</form>
	</div>
	<!-- 修改担保机构信息部分结束 -->		
	
	<!-- 私用js -->
	<script type="text/javascript" src="plugs/webuploader/0.1.5/webuploader.js"></script>
	<script type="text/javascript" src="js/recommend/re-guamanage.js"></script>
	<script type="text/javascript" src="js/recommend/gua-mod.js"></script>
	<script type="text/javascript">
		$(function(){
			validform5(".layui-layer-btn0","asset-mod",false,"3");
		});
	</script>
	<script type="text/javascript">
		var publicKey_common = '<%=session.getAttribute("publicKey") %>';
	</script>
			