<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


	<!-- 主要内容 -->
	<div class="" role="main">
		<!-- 地址导航 -->
		<jsp:include page="../../common/cm-addr.jsp"></jsp:include>
		<div class="data_display">
			<div class="withdraw col-lg-12">
			<fieldset class="withdrawfd">
				<legend>提现</legend>
				<form id="accwithdrawform" class="accwithdrawform" action="">
	   					<div class="cashContent">
		  					<div class="cashContentCunt">
								<div class="cashBank clearfix">
									<label class="cashLabel i-fl">提现至银行卡：</label>
									<ul class="clearfix">
									<%for(int i = 0;i<9;i++){ %>
										<li class="">
											<input type="radio" name="cashBankLi" id="cashBankLi<%=i %>" class="cashInputRadio">
											<label for="cashBankLi<%=i %>" onselectstart="return false" class="cashBankLiOne">
												<span>中国银行(523)</span>
											</label>
										</li>
									<%} %>
									</ul>
								</div>
								<div class="cashDivDistance cashClear">
									<label class="cashLabel">可提现金额：</label>
		  							<span class="cashSpan cashAllFont moneyFormat">100000000</span>
		  							<span>元</span>
								</div>
								<div class="cashDivDistance">
									<label class="cashLabel">提现金额：</label>
		  							<div class="amount"><input class="cashInput cashInput1 format cashFormat"  type="text" datatype="acountM"><span class="cashDistance">元</span></div>
								</div>
								<div class="cashDivDistance">
									<label class="cashLabel ">手续费：</label>
									<span class="cashAllFont cashAllFont moneyFormat">0</span>
		  							<span>元</span>
								</div>
								<div class="cashDivDistance cashFontStyle">
									<label class="cashLabel">实际到账金额：</label>
									<span class="cashAllFont moneyFormat">100000000</span>
		  							<span >元</span>
								</div>
								<div class="cashDivDistance">
									<label class="cashLabel">备注：</label>
									<!-- <input class="cashInput" type="text" maxlength="25"> -->
									<textarea rows="2" cols="" class="ta-noresize accwithdrawta"></textarea>
								</div>
		  						<div class="cmbtncontainer accwidthdeawcon">
									<a class="commonbtn0">提现</a>
									<a href="web/recommend/account-center.jsp">取消</a>
								</div>
		  					</div>
	   					</div>
					</form>
				</fieldset>
				
			</div>													
		</div>
	</div>
<!-- 私用js -->
<script type="text/javascript">
	$(function(){
			validform5(".commonbtn0","accwithdrawform",false,"3");
		});
	$(".moneyFormat").each(function(){
			var s = $(this).text();
			var str = parseFloat(s);
			var n = $(this).format(str);
			$(this).text(n);
		});
</script>