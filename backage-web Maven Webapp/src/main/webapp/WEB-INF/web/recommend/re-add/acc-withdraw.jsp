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
			<div class="panel panel-success">
				<div class="panel-heading">
					<div class="action_item">
						<button class="obtn glyphicon" onclick="acc-withdraw()">提现</button>
					</div>
				</div>
			</div>
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
									<li class="addBank cashBankLiSolid">
										<span>添加银行卡</span>
									</li>
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
	  						<div class="btn cashBtn" onselectstart="return false">
	  							<span class="con-item">
									<button class="obtn obtn-query glyphicon rechargebtn">提现</button>
								</span>
							</div>
	  					</div>
   					</div>
				</form>
			</div>													
		</div>
	</div>
