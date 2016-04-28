<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

			<jsp:include page="../../common/cm-addr.jsp"></jsp:include>
			<!-- 查看资产管理方部分开始 -->
			<div class="" id="checkDetail">
				<div class="w-content ishow">
					<fieldset>
						<legend>查看资产管理方信息</legend>
						<table class="checkdetailtable">
							<tr>
								<td class="tt"><label>资产管理方名称：</label><span>资产管理方名称</span></td>
								<td class="tt"><label>营业执照号码：</label><span>营业执照号码</span></td>
								<td class="tt"><label>组织机构代码：</label><span>组织机构代码</span></td>
							</tr>
							<tr>
								<td class="tt"><label>税务登记号：</label><span>税务登记号</span></td>
								<td class="tt"><label>经营场所：</label><span>经营场所</span></td>
								<td class="tt"><label>注册资金：</label><span class="moneyFormat">100000</span>元</td>
							</tr>
							<tr>
								<td class="tt"><label>法人姓名：</label><span>法人姓名</span></td>
								<td class="tt"><label>法人手机号：</label><span>法人手机号</span></td>
								<td class="tt"><label>法人身份证号：</label><span>法人身份证号</span></td>
							</tr>
							<tr>
								<td class="tt"><label>注册地址：</label><span>注册地址</span></td>
								<td class="tt"><label>注册资本来源：</label><span>注册资本来源</span></td>
								<td class="tt"><label>经营范围：</label><span>经营范围</span></td>
							</tr>
							<tr>
								<td class="tt"><label>公司简介：</label><span>公司简介</span></td>
								<td class="tt"><label>联系人姓名：</label><span>联系人姓名</span></td>
								<td class="tt"><label>联系人手机号：</label><span>联系人手机号</span></td>
							</tr>
							<tr>
								<td class="tt"><label>联系人邮箱：</label><span>联系人邮箱</span></td>
							</tr>
							<tr>
								<td>
									<label>上传的资产管理方证件：</label>
								</td>
							</tr>
							<tr>
								<td>
									<div class="assetimg">
										<img src="resources/img/Tax registration certificate.jpg"/>
									</div>
								</td>
								<td>
									<div class="assetimg">
										<img src="resources/img/Tax registration certificate.jpg"/>
									</div>
								</td>
								<td>
									<div class="assetimg">
										<img src="resources/img/Tax registration certificate.jpg"/>
									</div>
								</td>
							</tr>
							<tr>
								<td>
									<div class="assetimg">
										<img src="resources/img/Tax registration certificate.jpg"/>
									</div>
								</td>
								<td>
									<div class="assetimg">
										<img src="resources/img/Tax registration certificate.jpg"/>
									</div>
								</td>
								<td>
									<div class="assetimg">
										<img src="resources/img/Tax registration certificate.jpg"/>
									</div>
								</td>
							</tr>
						</table>
						<div class="layui-layer-btn addproprocessbtn">
							<a class="layui-layer-btn0" href="web/recommend/asset-management.jsp">返回</a>
						</div>
					</fieldset>
				</div>
			</div>
			
	<!-- 查看资产管理方信息部分结束 -->	
	<!-- 私用js -->
	<script type="text/javascript" src="plugs/webuploader/0.1.5/webuploader.js"></script>
	<script type="text/javascript" src="js/recommend/re-guamanage.js"></script>
	<script>
	$(".moneyFormat").each(function(){
		var s = $(this).text();
		var str = parseFloat(s);
		var n = $(this).format(str);
		$(this).text(n);
	});
	</script>

			