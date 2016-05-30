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
				<form id="accwithdrawform" class="accwithdrawform" action="compensatory/present.do" type="post">
	   					<div class="cashContent">
		  					<div class="cashContentCunt">
								<div class="cashBank clearfix">
									<label class="cashLabel i-fl">提现至银行卡：</label>
									<ul id="cardList" class="clearfix">
										
									</ul>
									<input id="bankCardId" name="bankCardId" type="hidden"  />
								</div>
								<div class="cashDivDistance cashClear">
									<label class="cashLabel">可提现金额：</label>
		  							<span id="money" class="cashSpan cashAllFont moneyFormat">0</span>
		  							<span>元</span>
								</div>
								<div class="cashDivDistance">
									<label class="cashLabel">提现金额：</label>
		  							<div class="amount"><input id="realMoney" name="amounts" class="cashInput cashInput1 format cashFormat"  type="text" datatype="acountM"><span class="cashDistance">元</span></div>
		  							<input id="realMoneys" type="hidden" name="amount" />
								</div>
								<div class="cashDivDistance">
									<label class="cashLabel ">手续费：</label>
									<input id="costs" type="hidden"  />
									<span id="cost" class="cashAllFont cashAllFont moneyFormat">0</span>
		  							<span>元</span>
								</div>
								<div class="cashDivDistance cashFontStyle">
									<label class="cashLabel">实际到账金额：</label>
									<span id="realGetMoney" class="cashAllFont moneyFormat">0</span>
		  							<span >元</span>
								</div>
								<div class="cashDivDistance">
									<label class="cashLabel">备注：</label>
									<!-- <input class="cashInput" type="text" maxlength="25"> -->
									<textarea id="remark" rows="2" cols="" class="ta-noresize accwithdrawta"></textarea>
									<input id="remarks" name="remark" type="hidden"  />
								</div>
		  						<div class="cmbtncontainer accwidthdeawcon">
									<a id="present" class="commonbtn0">提现</a>
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
<script type="text/javascript" src="js/recommend/acc-withdraw.js"></script>
<script type="text/javascript">
	$(function(){
			validform5(".commonbtn0","accwithdrawform",false,"5");
		});
	$(".moneyFormat").each(function(){
			var s = $(this).text();
			var str = parseFloat(s);
			var n = $(this).format(str);
			$(this).text(n);
		});
	
</script>