<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

	<jsp:include page="../../common/cm-addr.jsp"></jsp:include>
	<!-- 添加担保机构信息部分开始 -->
	<div class="w-content ishow" id="manage-add">
		<form id="manageAdd" action="javascript:addguarant()">
			<div class="manageAddtitle">
				<span>添加担保机构信息</span>
			</div>
			<table>
				<tr>
					<td class="addmanagetd"><label class="ineed">担保机构名称</label></td>
					<td class="addmanageinput"><input id="guaName" type="text" class="" placeholder="" datatype="entername" /></td>
					<td class="addmanagetd"><label class="ineed">营业执照号码</label></td>
					<td class="addmanageinput"><input id="driveNum" type="text" class="" placeholder="532501100006302" datatype="businessNum" /></td>
				</tr>
				<tr>
					<td class="addmanagetd"><label class="ineed">组织机构代码</label></td>
					<td class="addmanageinput"><input id="orgNum" type="text" class="" placeholder="46650460-6" datatype="orgcode" /></td>
					<td class="addmanagetd"><label class="ineed">税务登记号</label></td>
					<td class="addmanageinput"><input id="taxNum" type="text" class="" placeholder="110108681211312" datatype="businessNum"/></td>
				</tr>
				<tr>
					<td class="addmanagetd"><label>经营场所</label></td>
					<td class="addmanageinput"><input id="local" type="text" class="" placeholder="" datatype="z2_20" ignore="ignore"/></td>
					<td class="addmanagetd"><label>注册资金(元)</label></td>
					<td class="addmanageinput"><input id="money" type="text" class="" placeholder="" datatype="acountM" ignore="ignore"/></td>
				</tr>
				<tr>
					<td class="addmanagetd"><label class="ineed">法人姓名</label></td>
					<td class="addmanageinput"><input id="personName" type="text" class="" placeholder="" datatype="enterperson" ignore="ignore"/></td>
					<td class="addmanagetd"><label class="ineed">法人手机号</label></td>
					<td class="addmanageinput"><input id="personPhone" type="text" class="" placeholder="" datatype="zPhone" ignore="ignore"/></td>
				</tr>
				<tr>
					<td class="addmanagetd"><label class="ineed">法人身份证号</label></td>
					<td class="addmanageinput"><input id="personIDcard" type="text" class="" placeholder="" datatype="IDCard" ignore="ignore"/></td>
					<td class="addmanagetd"><label>注册地址</label></td>
					<td class="addmanageinput"><input id="address" type="text" class="" placeholder="" datatype="enterAddress" ignore="ignore"/></td>
				</tr>
				<tr>
					<td class="addmanagetd"><label>注册资本来源</label></td>
					<td class="addmanageinput"><input id="resource" type="text" class="" placeholder="" datatype="reMarks" ignore="ignore"/></td>
					<td class="addmanagetd"><label>经营范围</label></td>
					<td class="addmanageinput"><input id="range" type="text" class="" placeholder="" datatype="reMarks" ignore="ignore"/></td>
				</tr>
				<tr>
					<td class="addmanagetd"><label>公司简介</label></td>
					<td class="addmanageinput"><input id="intro" type="text" class="" placeholder="" datatype="rolemarkC" ignore="ignore"/></td>
					<td class="addmanagetd"><label class="ineed">联系人姓名</label></td>
					<td class="addmanageinput"><input id="contactName" type="text" class="" placeholder="" datatype="realName"/></td>
				</tr>
				<tr>
					<td class="addmanagetd"><label class="ineed">联系人手机号</label></td>
					<td class="addmanageinput"><input id="contactPhone" type="text" class="" placeholder="" datatype="zPhone"/></td>
					<td class="addmanagetd"><label>联系人邮箱</label></td>
					<td class="addmanageinput"><input id="email" type="text" class="" placeholder="" datatype="email" ignore="ignore"/></td>
				</tr>
			</table>
			<div class="layui-layer-btn addproprocessbtn">
				<a class="layui-layer-btn0">添加</a>
				<a class="layui-layer-btn1" href="web/recommend/guarantee-manage.jsp">取消</a>
			</div>
			<div></div>
		</form>
	</div>
	<!-- 添加担保机构信息部分结束 -->		
	
	<!-- 私用js -->
	<script type="text/javascript" src="plugs/webuploader/0.1.5/webuploader.js"></script>
	<script type="text/javascript" src="js/recommend/re-guamanage.js"></script>
	<script type="text/javascript" src="js/recommend/gua-add.js"></script>
	<script type="text/javascript">
		$(function(){
			validform5("layui-layer-btn0","manageAdd",false,"5");
		});
	</script>
	<script type="text/javascript">
		var publicKey_common = '<%=session.getAttribute("publicKey") %>';
	</script>
			