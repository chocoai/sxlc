<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN">
<html>
<head>
	<base href="<%=basePath%>">
    <title>收支明细</title>
    <jsp:include page="../../common/top_meta.jsp"></jsp:include>
    <script type="text/javascript">
    	var publickey = '<%=session.getAttribute("publicKey")%>';
    </script>
	<link rel="stylesheet" type="text/css" href="css/account/account.css">
	<link rel="stylesheet" type="text/css" href="css/account/fundManagement/incomeExpenditure.css">
	<link rel="stylesheet" href="plugs/pager/pager_def.css" type="text/css">
</head>
<body> 
    <jsp:include page="../../common/top.jsp"></jsp:include>
   	<jsp:include page="../../common/mainPageTop.jsp"></jsp:include>
   	<div class="main">
   		<div class="clearfix">
		   	<jsp:include page="../../account/accountCommonLeft.jsp"></jsp:include>
   			<div class="accountRight">
			   	<jsp:include page="../../account/accountCommonRightTop.jsp"></jsp:include>
   				<div class="accountMain clearfix">
	   				<!-- 收支明细 -->
	   				<!-- 李丽梅 -->
	   				<!-- 2016-04-01 -->
	   				<ul class="iEDHead">
						<li class="iEDHeadTab iEDHeadIng allRecord">交易记录</li>
						<li class="iEDHeadTab  rechargeRecord">充值记录</li>
						<li class="iEDHeadTab withdrawRecord">提现记录</li>
					</ul>
   					<div class="iEDtabContent  ">
   						<div class="iEDContent iEDcontentActive ">
   							<div class="iEDTrecordType clearfix">
   								<div class="iEDTrecordTypeLeft">
	   								<label class="iEDTrecordTypeLeft">交易类型：</label>
	   								<div class="iEDTrecordTypeLeft clearfix">
	   									<input class="selectValue tradeTypeId" value="-1" >
	   									<input class="selectInput iEDInputA" type="text" lang="全部" readOnly="true"/>
									    <ul class="select iEDSelect" onselectstart="return false">
									    	<li class="selectOption" value="-1">全部</li>
									    	<li class="selectOption" value="0">其他</li>
									    	<li class="selectOption" value="1">充值</li>
									    	<li class="selectOption" value="2">提现成功</li>
									    	<li class="selectOption" value="3">冻结借款项目投标金额</li>
									    	<li class="selectOption" value="4">扣除借款项目投标金额</li>
									    	<li class="selectOption" value="5">冻结债权转让投标金额</li>
									    	<li class="selectOption" value="6">扣除债权转让投标金额</li>
									    	<li class="selectOption" value="7">借款项目放款</li>
									    	<li class="selectOption" value="8">债权转让放款</li>
									    	<li class="selectOption" value="9">借款人还款</li>
									    	<li class="selectOption" value="10">获得投资收益</li>
									    	<li class="selectOption" value="11">投资借款项目流标</li>
									    	<li class="selectOption" value="12">投资债权转让流标</li>
									    	<li class="selectOption" value="13">支付担保收益</li>
									    	<li class="selectOption" value="14">代偿还款</li>
									    	<li class="selectOption" value="15">积分兑换</li>
									    	<li class="selectOption" value="16">获取担保收益</li>
									    	<li class="selectOption" value="17">代偿回款</li>
									    	<li class="selectOption" value="18">提现登记</li>
									    	<li class="selectOption" value="19">提现打回</li>
									    	<li class="selectOption" value="20">支付借款管理费</li>
									    	<li class="selectOption" value="21">支付风险备付金</li>
									    	<li class="selectOption" value="23">代偿还款</li>
									    	<li class="selectOption" value="24">代偿回款</li>
									    	<li class="selectOption" value="25">支付项目认证费用</li>
									    </ul>
	   								</div>
   								</div>
   								<div class="iEDTrecordTypeLeft">
   									<label class="iEDleft">时间范围：</label>
   									<input id="startTime1" class="iEDInput iEDInputBack Wdate" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'endTime1\')}'})" type="text" lang="请选择">
   									<i></i>
   									<input id="endTime1" class="iEDInput iEDInputBack Wdate" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'startTime1\')}'})" type="text" lang="请选择">
   								</div>
   								<!-- <div class="iEDTrecordTypeLeft iEDDivCunt"> -->
	   								<div class="iEDTrecordTypeLeft iEDDiv "><em class="active " value="1">今天</em>
	   								<em value="7">最近一周</em>
	   								<em value="30">一个月</em>
	   								<em value="183">六个月</em>
   								</div>
   								<div class="iEDTrecordTypeLeftSpan iEDDiv2" id="allSearch"><span class="btn btnHeight" onselectstart="return false">搜索</span></div>
   							</div>
   							<div class="iEDTrecord">
   								<ul id="all_list_ul">
			   						<li class="awardTableHead" id="all_list_top">
		  								<div class="awardTableHead1 awardTableRegisterAllJu">序号ID</div>
		  								<div class="awardTableHead2">交易类型</div>
		  								<div class="awardTableHead3">交易金额<em class="btnUp"></em></div>
		  								<div class="awardTableHead4">总金额<em class="btnUp"></em></div>
		  								<div class="awardTableHead5">冻结金额<em class="btnUp"></em></div>
		  								<div class="awardTableHead6">待收本金<em class="btnUp"></em></div>
		  								<div class="awardTableHead7">待收利息<em class="btnUp"></em></div>
		  								<div class="awardTableHead8">可用余额<em class="btnUp"></em></div>
		  								<div class="awardTableHead9">待还本金<em class="btnUp"></em></div>
		  								<div class="awardTableHead10">待还利息<em class="btnUp"></em></div>
		  								<div class="awardTableHead11">待还逾期利息/罚金<em class="btnUp"></em></div>
		  								<div class="awardTableHead12">交易对方</div>
		  								<div class="awardTableHead13">交易时间</div>
			   						</li>
			   						<!-- 全部交易记录 -->
		   							<script id="all_list" type="text/html">
									{{each results as info index}}
		   							<li class="awardTableRegister">
		   								<div class="awardTabRegister">
		   									<div class="awardTableHead1 "><span>{{info.tradeID}}</span></div>
											{{if info.tradeType==null}}
		   									<div class="awardTableHead2 "><span>其他<span></div>
											{{/if}}		
											{{if info.tradeType!=null}}
		   									<div class="awardTableHead2 "><span>{{info.tradeType}}<span></div>
											{{/if}}		
		   									<div class="awardTableHead3a "><span class="moneyFormat">{{info.amounts}}</span></div>
		   									<div class="awardTableHead4 awardDistance "><span class="moneyFormat">{{info.totalAmounts}}</span></div>
		   									<div class="awardTableHead5a awardDistance "><span class="moneyFormat">{{info.frozenBalances}}</span></div>
		   									<div class="awardTableHead6 awardDistance "><span class="moneyFormat">{{info.willRecPrincipals}}</span></div>
		   									<div class="awardTableHead7 awardDistance "><span class="moneyFormat">{{info.willRecInterests}}</span></div>
		   									<div class="awardTableHead8 awardDistance "><span class="moneyFormat">{{info.userBalances}}</span></div>
		   									<div class="awardTableHead9 awardDistance "><span class="moneyFormat">{{info.willPayPrincipals}}</span></div>
		   									<div class="awardTableHead10 awardDistance "><span class="moneyFormat">{{info.willPayInterests}}</span></div>
		   									<div class="awardTableHead11 awardDistance "><span class="moneyFormat">{{info.willPayOverdueInterests}}</span>/<span class="moneyFormat">{{info.willPayOverdues}}</span></div> 
		   									<div class=" awardTableHead12-1">
												{{if info.tradeObjectType=="0"}}
												<span>平台</span>
												{{/if}}
												{{if info.tradeObjectType=="1"}}
												<span>会员</span>
												{{/if}}
												{{if info.tradeObjectType=="2"}}
												<span>担保机构</span>
												{{/if}}
											</div>
	   										<div class="awardTableHead13-1 "> 
		   										<div class="contentA">
													{{info.recordDate}}
												</div>
	   										</div>
		   								</div>
		   								<div class="iEDTrecordInfo">
		   									<div class="iEDTrecordInfoDiv">
		   										<span>序号：{{info.recordNo}}</span>
		   										<span>地区：{{info.provinceName}} {{info.cityName}}</span>
		   										<span>交易时间：{{info.recordDate}}</span>
		   									</div>
		   									<div class="iEDTrecordInfoDiv">
		   										<span>用户名：{{info.membername}}</span>
												<span>交易类型：{{info.tradeType}}</span>
		   									</div>
		   									<div class="iEDTrecordInfoDiv2">
		   										<p class="iEDTrecordInfoP1"><span>总金额：</span><i class="moneyFormat">{{info.totalAmounts}}</i> <span class="iEDTrecordInfofuha">=</span></p> 
		   										<p class="iEDTrecordInfoP2"><span>可用余额：<em class="moneyFormat">{{info.userBalances}}</em></span>
		   										<span class="iEDTrecordInfofuha">+</span><span>冻结金额：<em class="moneyFormat">{{info.statisticsFrozenAmounts}}</em></span><span>+</span><span >待收本金：<em class="moneyFormat">{{info.willRecPrincipals}}</em></span>
		   										<span class="iEDTrecordInfofuha">+</span><span>待收利息：<em  class="moneyFormat">{{info.willRecInterests}}</em></span><span class="iEDTrecordInfofuha">-</span><span>待还本金：<em class="moneyFormat">{{info.willPayPrincipals}}</em></span>
		   										<span class="iEDTrecordInfofuha">-</span><span>待还利息：<em  class="moneyFormat">{{info.willPayInterests}}</em></span><span class="iEDTrecordInfofuha">-</span><span>待还逾期利息：<em class="moneyFormat">{{info.willPayOverdueInterests}}</em></span>
		   										<span class="iEDTrecordInfofuha">-</span><span>待还逾期罚金：<em  class="moneyFormat">{{info.willPayOverdues}}</em></span></p>
		   									</div>
		   								</div>
		   							</li>
		   							{{/each}}
									<li class="page"><div id="pager"></div></li>
   									</script>
		   						</ul>
   							</div>
 							<!-- 分页标签 -->
 							<!-- 	<div class="pagerCu" id="pager"></div> -->
   						</div>
   						<div class="iEDContent">
   							<div class="iEDContentHead">
   								<div class="iEDContentHeadTop">
   									<span>●</span><span>充值总手续费：</span><b class="iEDContentHeadTopBa moneyFormat2" id="rechargeFee">0</b><span class="iEDContentHeadTopSpan3">元</span>
   								</div>
   								<div class="iEDContentHeadTop">
   									<span>●</span><span>实际到账总金额：</span><b class="iEDContentHeadTopBb moneyFormat2" id="rechargeMoney">0</b><span class="iEDContentHeadTopSpan3">元</span>
   								</div>
   								<div class="iEDContentHeadC">
   									<span>充值</span>
   								</div>
   							</div>
   							<div class="iEDTrecordType clearfix">
   								<div class="iEDTrecordTypeLeft">
   									<label class="iEDleft">第三方交易流水号:</label>
   									<input id="thirdMerBillno" class="iEDInput iEDInputB" type="text" lang="输入交易流水号">
   								</div>
   								
   								<div class="iEDTrecordTypeLeft iEDTrecordTypeLeftJ">
   									<label class="iEDleft">时间范围：</label>
   									<input id="startTime2" class="iEDInput iEDInputBack Wdate" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'endTime2\')}'})" type="text" lang="请选择">
   									<i></i>
   									<input id="endTime2" class="iEDInput iEDInputBack Wdate" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'startTime2\')}'})" type="text" lang="请选择">
   								</div>
   								<div class="iEDTrecordTypeLeft">
	   								<label class="iEDTrecordTypeLeft">状态：</label>
	   								<div class="iEDTrecordTypeLeft ">
	   									<input id="rechargeStatu" class="selectValue" value="-1" >
									  	<input class="selectInput iEDInputA" type="text" lang="全部" readOnly="true"/>
									    <ul class="select iEDSelecta" onselectstart="return false">
									   		<li class="selectOption" value="-1">全部</li>
									    	<li class="selectOption" value="1">成功</li>
									    	<li class="selectOption" value="0">失败</li>
									    </ul>
	   								</div>
   								</div>
   								<div class="iEDTrecordTypeLeft iEDDiv2" id="rechargeSearch"><span class="btn btnHeight" onselectstart="return false">搜索</span></div>
   							</div>
   							<div class="iEDTrecord">
   								<ul id="recharge_ul">
			   						<li class="awardTableHeada" id="recharge_top">
		  								<div class="awardTableCu1 ">充值金额<em class="btnUp"></em></div>
		  								<div class="awardTableCu2">充值时间<em class="btnUp"></em></div>
		  								<div class="awardTableCu3">充值手续费</div>
		  								<div class="awardTableCu4">充值方式</div>
		  								<div class="awardTableCu5">实际到账金额<em class="btnUp"></em></div>
		  								<div class="awardTableCu6">第三方交易流水号</div>
		  								<div class="awardTableCu7">状态</div>
			   						</li>
			   						<!-- 充值记录 -->
			   						<script id="recharge_list" type="text/html">
									{{each results as info index}}
		   							 <li class="awardTableRegister awardTableRegisterH clearfix">
		   								<div class="awardTableCu1"><span class="moneyFormat">{{info.withdrawalMoneys}}</span></div>
		   								<div class="awardTableCu2-1 ">  
	   										<div class="contentB">
												{{info.sReceiveDate}}
											</div>
	   									</div>
	   									<div class="awardTableCu3"><span class="moneyFormat">{{info.totalfee}}</span></div>
	   									<div class="awardTableCu4">
												<span>{{info.rechargeTypes}}</span>
										</div>
	   									<div class="awardTableCu5"><span class="moneyFormat">{{info.realMoneys}}</span></div>
	   									<div class="awardTableCu6-1"><div class="contentB awardTableAllSpan">{{info.thirdMerBillno}}</div></div>
	   									<div class="awardTableCu7">
											{{if info.statu=="0"}}
											<span>失败</span>
											{{/if}}
											{{if info.statu=="1"}}
											<span class="awardTableAllSpan">成功</span>
											{{/if}}
										</div>
		   							</li>
									{{/each}}
									<!-- 分页标签 -->
									<li class="page"><div id="pager1"></div></li>
   									</script>
		   						</ul>
   							</div>
   						</div>
   						<div class="iEDContent">
   							<div class="iEDContentHead">
   								<div class="iEDContentHeadTop">
   									<span>●</span><span>提现总手续费：</span><b id="withdrawalFee" class="iEDContentHeadTopBa moneyFormat2">0</b><span class="iEDContentHeadTopSpan3">元</span>
   								</div>
   								<div class="iEDContentHeadTop">
   									<span>●</span><span>实际到账总金额：</span><b id="withdrawalMoney" class="iEDContentHeadTopBb moneyFormat2">0</b><span class="iEDContentHeadTopSpan3">元</span>
   								</div>
   								<div class="iEDContentHeadC">
   									<span>充值</span>
   								</div>
   							</div>
   							<div class="iEDTrecordType clearfix">
   								<div class="iEDTrecordTypeLeft">
   									<label class="iEDleft">时间范围：</label>
   									<input id="startTime3" class="iEDInput iEDInputBack Wdate" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'endTime3\')}'})" type="text" lang="请选择">
   									<i></i>
   									<input id="endTime3" class="iEDInput iEDInputBack Wdate" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'startTime3\')}'})" type="text" lang="请选择">
   								</div>
   								<div id="withdrawalSearch" class="iEDTrecordTypeLeft iEDDiv2"><span class="btn btnHeight" onselectstart="return false">搜索</span></div>
   							</div>
   							<div class="iEDTrecord">
   								<ul id="withdraw_ul">
			   						<li class="awardTableHeada1" id="withdraw_top">
		  								<div class="awardTabCuA1 ">提现金额<em class="btnUp"></em></div>
		  								<div class="awardTabCuA2">提现时间<em class="btnUp"></em></div>
		  								<div class="awardTabCuA3">提现手续费</div>
		  								<div class="awardTabCuA4">提现银行</div>
		  								<div class="awardTabCuA5">到账时间</div>
		  								<div class="awardTabCuA6">实际到账金额<em class="btnUp"></em></div>
		  								<div class="awardTabCuA7">第三方交易流水号</div>
		  								<div class="awardTabCuA8">备注</div>
		  								<div class="awardTabCuA9">状态</div>
			   						</li>
			   						<!-- 提现记录 -->
			   						<script id="withdraw_list" type="text/html">
									{{each results as info index}}
		   							<li class="awardTableRegister awardTableRegisterH1">
	   									<div class="awardTabCuA1"><span class="moneyFormat">{{info.withdrawalMoney}}</span></div>
	   									<div class="awardTabCuA2-1">
											<div class="contentC">
											 	{{info.sRecordDate}}
											</div>
										</div>
	   								 	<div class="awardTabCuA3"><span class="moneyFormat">{{info.totalfees}}</span></div>
	   									<div class="awardTabCuA4"><span>{{info.bankName}}</span></div>
   										<div class="awardTabCuA2-1">
											<div class="contentC">
											 	{{info.sReceiveDate}}
											</div>
										</div>
	   									<div class="awardTabCuA6"><span class="moneyFormat">{{info.realMoneys}}</span></div>
	   									<div class="awardTabCuA7"><span>{{info.thirdTradeId}}</span></div> 
	   									<div class="awardTabCuA8"><span>{{info.remark}}</span></div>
	   									<div class="awardTabCuA9">
											{{if info.checkstatu=="0"}}
											<span class="awardTableAllSpan">待审核</span>
											{{/if}}
											{{if info.checkstatu=="1"}}
											<span class="awardTableAllSpan">提现成功</span>
											{{/if}}
										</div>
		   							</li>
		   							
									{{/each}}
									<!-- 分页标签 -->
									<li class="page"><div id="pager2"></div></li>
   									</script>
		   							
		   						</ul>
   							</div>
   						</div>
   					</div>
   				</div>
   			</div>
   		</div>
   	</div>
  	 <!-- 分页标签 -->
   <!--  <script type="text/javascript" charset="utf-8" src="plugs/pager/pager.js"></script> -->
   <script type="text/javascript" src="plugs/pager/pager.js"></script>
   	<jsp:include page="../../common/bottom.jsp"></jsp:include>
	<script type="text/javascript" src="js/account/account.js"></script>
	<script type="text/javascript" src="js/account/fundManagement/incomeExpenditure.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/plugs/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="js/common/template.js"></script>
</body>
</html>