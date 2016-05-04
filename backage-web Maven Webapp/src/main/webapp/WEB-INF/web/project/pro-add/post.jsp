<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
	<base href="<%=basePath%>">
	<title>项目管理</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link href="css/project/myLayer.css" rel="stylesheet" />
</head>
<body>
	<div class="container add_type_contianer">
	  	<table>
			<tr class="col-md-6">
				<td class="tt"><label>借款项目名称：</label></td>
				<td class="con">
					<input type="text" class="" id="loan_proName" name="loan_proName">
				</td>
			</tr>
			<tr class="col-md-6">
				<td class="tt"><label>借款金额：</label></td>
				<td class="con">
					<input type="text" class="" name="loan_money" id="loan_money">
				</td>
			</tr>
			<tr class="col-md-6">
				<td class="tt"><label>还款方式：</label></td>
				<td class="con">
					<input type="text" class="" name="payway" id="payway">
				</td>
			</tr>
			<tr class="col-md-6">
				<td class="tt"><label>还款保障：</label></td>
				<td class="con">
					<input type="text" class="" name="pay_ensure" id="pay_ensure">
				</td>
			</tr>
			<tr class="col-md-6">
				<td class="tt"><label>借款用途：</label></td>
				<td class="con">
					<input type="text" class="" name="loan_purpose" id="loan_purpose">
				</td>
			</tr>
			<tr class="col-md-6">
				<td class="tt"><label>还款来源：</label></td>
				<td class="con">
					<input type="text" class="" name="pay_source" id="pay_source">
				</td>
			</tr>
			<tr class="col-md-6">
				<td class="tt"><label>借款期限：</label></td>
				<td class="con">
					<input type="text" class="" name="loan_time" id="loan_time">
				</td>
			</tr>
			<!-- 自动投标 -->
			<tr class="col-md-12">
				<td class="tt"><label>设置最大投资比例：</label></td>
				<td class="con">
					<input type="text" class="" id="loan_proType" name="loan_proType">
				</td>
			</tr><!-- 自动投标结束 -->
			<!-- 附件信息修改 -->
			<tr class="col-md-6">					
				<td class="tt"><label>年化利率：</label></td>
				<td class="con">							
					<input type="text" class="" name="loan_term" id="loan_term">
				</td>
			</tr>
			<tr class="col-md-6">
				<td class="tt"><label>起投金额：</label></td>
				<td class="con">
					<input type="text" class="" name="loan_source" id="loan_source">
				</td>
			</tr>	
			<tr class="col-md-6">
				<td class="tt"><label>加价幅度：</label></td>
				<td class="con">
					<input type="text" class="" id="loan_purpose" name="loan_purpose">
				</td>
			</tr><!-- 附件添加结束 -->							
			<tr class="col-md-6">
				<td class="tt">投资上限：</td>
				<td class="con">
					<input type="text" class="" id="loan_purpose" name="loan_purpose">
				</td>
			</tr>
			<tr class="col-md-6">
				<td class="tt">项目描述：</td>
				<td class="con">
					<input type="text" class="" id="loan_purpose" name="loan_purpose">
				</td>
			</tr>
			<tr class="col-md-6">
				<td class="tt">奖励标：</td>
				<td class="con">
					返现：本金*<span>20</span>%
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
					<span class="mechanism">某机构</span>
					<span>30</span>%
				</td>
			</tr>	
			<tr class="col-md-6">
				<td class="tt">资产管理方：</td>
				<td class="con">
					<span class="mechanism">某机构</span>
					<span>30</span>%
				</td>
			</tr>	
			<tr class="col-md-6">
				<td class="tt">项目风险保证金：</td>
				<td class="con">
					<span>1000</span>元
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
					<span>100</span>人
				</td>
			</tr>
		</table>
	</div>
    <!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<!-- 私用js -->
</body>

</html>