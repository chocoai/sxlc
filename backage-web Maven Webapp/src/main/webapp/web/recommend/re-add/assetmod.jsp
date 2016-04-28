<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

	<jsp:include page="../../common/cm-addr.jsp"></jsp:include>
	<!-- 修改资产管理方信息部分开始 -->
	<div class="w-content ishow" id="asset-mod">
		<form id="manageAdd" action="">
			<div class="manageAddtitle">
				<span>修改资产管理方信息</span>
			</div>
			<table>
				<tr>
					<td class="addmanagetd"><label class="ineed">资产管理方名称</label></td>
					<td class="addmanageinput"><input type="text" class="" placeholder="" datatype="entername" /></td>
					<td class="addmanagetd"><label class="ineed">营业执照号码</label></td>
					<td class="addmanageinput"><input type="text" class="" placeholder="" datatype="businessNum" /></td>
				</tr>
				<tr>
					<td class="addmanagetd"><label class="ineed">组织机构代码</label></td>
					<td class="addmanageinput"><input type="text" class="" placeholder="" datatype="orgcodefmt" /></td>
					<td class="addmanagetd"><label class="ineed">税务登记号</label></td>
					<td class="addmanageinput"><input type="text" class="" placeholder="" datatype="businessNum"/></td>
				</tr>
				<tr>
					<td class="addmanagetd"><label>经营场所</label></td>
					<td class="addmanageinput"><input type="text" class="" placeholder="" datatype="z2_20" ignore="ignore"/></td>
					<td class="addmanagetd"><label>注册资金</label></td>
					<td class="addmanageinput"><input type="text" class="" placeholder="" datatype="amcountM" ignore="ignore"/></td>
				</tr>
				<tr>
					<td class="addmanagetd"><label class="ineed">法人姓名</label></td>
					<td class="addmanageinput"><input type="text" class="" placeholder="" datatype="enterperson"/></td>
					<td class="addmanagetd"><label class="ineed">法人手机号</label></td>
					<td class="addmanageinput"><input type="text" class="" placeholder="" datatype="zPhone"/></td>
				</tr>
				<tr>
					<td class="addmanagetd"><label class="ineed">法人身份证号</label></td>
					<td class="addmanageinput"><input type="text" class="" placeholder="" datatype="idcard"/></td>
					<td class="addmanagetd"><label>注册地址</label></td>
					<td class="addmanageinput"><input type="text" class="" placeholder="" datatype="enterAddress" ignore="ignore"/></td>
				</tr>
				<tr>
					<td class="addmanagetd"><label>注册资本来源</label></td>
					<td class="addmanageinput"><input type="text" class="" placeholder="" datatype="reMarks" ignore="ignore"/></td>
					<td class="addmanagetd"><label>经营范围</label></td>
					<td class="addmanageinput"><input type="text" class="" placeholder="" datatype="reMarks" ignore="ignore"/></td>
				</tr>
				<tr>
					<td class="addmanagetd"><label>公司简介</label></td>
					<td class="addmanageinput"><input type="text" class="" placeholder="" datatype="rolemark" ignore="ignore"/></td>
					<td class="addmanagetd"><label>联系人姓名</label></td>
					<td class="addmanageinput"><input type="text" class="" placeholder="" datatype="z2_12" ignore="ignore"/></td>
				</tr>
				<tr>
					<td class="addmanagetd"><label>联系人手机号</label></td>
					<td class="addmanageinput"><input type="text" class="" placeholder="" datatype="zPhone" ignore="ignore"/></td>
					<td class="addmanagetd"><label>联系人邮箱</label></td>
					<td class="addmanageinput"><input type="text" class="" placeholder="" datatype="email" ignore="ignore"/></td>
				</tr>
				<tr>
					<td class="addmanagetd"><label>资产管理方证件类型</label></td>
					<td class="addmanageinput">
						<select class="assettype">
							<option>请选择</option>
							<option>营业执照</option>
							<option>资质认证</option>
							<option>税务登记证</option>
							<option>组织机构代码证</option>
							<option>其它</option>
						</select>
					</td>
				</tr>
				<tr>
					<td class="tt">图片选择</td>
					<td class="con">
						<!--dom结构部分-->
						<div id="uploader">
						    <!--用来存放item-->
						    <div id="filePicker">选择图片</div>
						    <span class="rec-dimensions">建议尺寸：580*280</span>
						</div>
					</td>
				</tr>
				<tr>
					<td class="tt" valign="top">图片预览</td>
					<td class="con" id="fileList" colspan="3"></td>
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
	<script type="text/javascript">
		$(function(){
			validform5(".commonbtn0","asset-mod",false,"3");
		});
	</script>
			