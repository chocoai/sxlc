<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String content = request.getParameter("content");
%>

			<jsp:include page="../../common/cm-addr.jsp"></jsp:include>
			<!-- 查看担保机构信息部分开始 -->
			<div class="" id="checkDetail">
				<fieldset>
					<legend>基本信息</legend>
					<div class="w-content ishow">
						<table class="checkdetailtable">
						<input id="guId" type="hidden" value="<%=content %>" />
							<tr>
								<td class="tt"><label>担保机构名称：</label><span id="guaranteeName"></span></td>
								<td class="tt"><label>营业执照号码：</label><span id="companyeBLN"></span></td>
								<td class="tt"><label>组织机构代码：</label><span id="companyOC"></span></td>
							</tr>
							<tr>
								<td class="tt"><label>税务登记号：</label><span id="taxRegNo"></span></td>
								<td class="tt"><label>经营场所：</label><span id="establishments"></span></td>
								<td class="tt"><label>注册资金：</label><span id="companyCapital" class="moneyFormat"></span>元</td>
							</tr>
							<tr>
								<td class="tt"><label>法人姓名：</label><span id="personalName"></span></td>
								<td class="tt"><label>法人手机号：</label><span id="personalPhone"></span></td>
								<td class="tt"><label>法人身份证号：</label><span id="personalIDCard"></span></td>
							</tr>
							<tr>
								<td class="tt"><label>注册地址：</label><span id="companyAddress"></span></td>
								<td class="tt"><label>注册资本来源：</label><span id="companySource"></span></td>
								<td class="tt"><label>经营范围：</label><span id="companyBusiness"></span></td>
							</tr>
							<tr>
								<td class="tt"><label>公司简介：</label><span id="companyProfile"></span></td>
								<td class="tt"><label>联系人姓名：</label><span id="contactName"></span></td>
								<td class="tt"><label>联系人手机号：</label><span id="contactPhone"></span></td>
							</tr>
							<tr>
								<td class="tt"><label>联系人邮箱：</label><span id="contactEmail"></span></td>
							</tr>
						</table>
					</div>
			</fieldset>
			<fieldset>
	 			<legend>设置的担保配置信息</legend>
	 			<form class="form-inline config-form guacheckform" role="form" name="" action="javascript:mwithdralsfee()" id="member">
	 				<div class="form-group">
	 					<span>担保借款金额范围：</span>
						<label class="moneyFormat">1000</label>元-<label class="moneyFormat">100000</label>元
	 				</div>
	 				<div class="form-group">
		 				<div class="producttype clearfix">
		 					<span class="configinfospan">担保产品类型：</span>
							<label>信用贷</label>
							<label>担保贷</label>
							<label>抵押贷</label>
						</div>
		 			</div>
	 			</form>
	 			<form class="form-inline config-form guacheckform" role="form" name="" action="javascript:mwithdralsfee()" id="member">		
		 			<div class="form-group">
	 					<span class="configinfospan">允许担保借款期限起止范围：</span>
 						<label>天标：</label><label>1天</label>-<label>20天</label>
 						<label>月标：</label><label>1月</label>-<label>20月</label>
 						<label>年标：</label><label>1年</label>-<label>2年</label>
		 			</div>
	 			</form>
	 			<form class="form-inline config-form guacheckform" role="form" name="" action="javascript:mwithdralsfee()" id="member">		
		 			<div class="form-group">
	 					<span class="configinfospan">担保代偿统计：</span>
 						<label>成功担保笔数：</label><label>680</label><samp>笔</samp>
 						<label>成功代偿笔数：</label><label>680</label><samp>笔</samp>
 						<label>代偿回款笔数：</label><label>680</label><samp>笔</samp>
		 			</div>
	 			</form>	
	 			<form class="form-inline config-form guacheckform" role="form" name="" action="javascript:mwithdralsfee()" id="member">		
		 			<div class="form-group">
 						<table class="checkaccounttable">
							<tr>
								<td><span class="configinfospan guaranteespan">担保证件管理：</span></td>
								<td class="tt" class="checkimg"><label>图片预览</td>
								<td class="con" id="fileList">
								</td>
							</tr>
							<tr>
								
							</tr>
						</table>
		 			</div>
	 			</form>	
			</fieldset>
			<fieldset>
	 			<legend>第三方账户信息</legend>
	 			<div class="">
		   			<table class="checkdetailtable">
						<tr>
							<td class="tt"><label>第三方账户号：</label><span>第三方账户号</span></td>
							<td class="tt"><label>当前余额：</label><span class="moneyFormat">30000</span>元</td>
							<td class="tt"><label>代偿总金额：</label><span class="moneyFormat">30000</span>元</td>
						</tr>
						<tr>
						<td class="tt"><label>代偿回款总金额：</label><span class="moneyFormat">30000</span>元</td>
							<td class="tt"><label>代偿未回款总金额：</label><span class="moneyFormat">30000</span>元</td>
							<td class="tt"><label>自动代偿是否开启：</label><span>是</span></td>
						</tr>
					</table>
					<div class="layui-layer-btn addproprocessbtn">
						<a class="layui-layer-btn0" href="web/recommend/guarantee-manage.jsp">返回</a>
					</div>
		   		</div>
			</fieldset>
	</div>
			
	<!-- 查看担保机构信息部分结束 -->	
	<!-- 私用js -->
	<script type="text/javascript" src="plugs/webuploader/0.1.5/webuploader.js"></script>
	<script type="text/javascript" src="js/recommend/re-guamanage.js"></script>
	<script type="text/javascript" src="js/recommend/gua-checkDetail.js"></script>
	<script>
	$(".moneyFormat").each(function(){
		var s = $(this).text();
		var str = parseFloat(s);
		var n = $(this).format(str);
		$(this).text(n);
	});
	</script>
	<script type="text/javascript">
		var publicKey_common = '<%=session.getAttribute("publicKey") %>';
	</script>

			