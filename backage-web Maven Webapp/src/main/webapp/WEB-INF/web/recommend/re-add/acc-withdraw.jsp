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
				<form id="" class="accwithdrawform" action="">
   					<div class="cashContent">
	  					<div class="cashContentCunt">
							<div class="cashDivDistance">
								<label class="cashLabel">联系人姓名：</label>
								<span class="cashAllFont">刘***</span>
							</div>
							<div class="cashDivDistance">
								<label class="cashLabel">联系人手机：</label>
								<span class="cashAllFont">135********</span>
							</div>
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
	  							<div class="amount"><input class="cashInput cashInput1 format cashFormat"  type="text" lang="请输入提现金额" maxlength="10"><span class="cashDistance">元</span></div>
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
								<input class="cashInput" type="text" placeholder="请输入备注内容" maxlength="25">
							</div>
	  						<div class="cmbtncontainer assetcontainer">
								<a class="commonbtn0">提现</a>
								<a href="web/recommend/account-center.jsp">取消</a>
							</div>
	  					</div>
   					</div>
				</form>
			</div>													
		</div>
	</div>
