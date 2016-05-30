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
    <title>债权转让</title>
    <jsp:include page="../../common/top_meta.jsp"></jsp:include>
	<link rel="stylesheet" type="text/css" href="css/account/account.css">
	<link rel="stylesheet" type="text/css" href="css/account/investmentManagement/debtAttorn.css">
	<link rel="stylesheet" href="plugs/pager/pager_def.css" type="text/css">
</head>
<body> 
    <jsp:include page="../../common/top.jsp"></jsp:include>
   	<jsp:include page="../../common/mainPageTop.jsp"></jsp:include>
   	<script type="text/javascript">
    	var publickey = '<%=session.getAttribute("publicKey")%>';
    </script>
   	<script type="text/javascript" src="js/common/template.js"></script>
   	<div class="main">
   		<div class="clearfix">
		   	<jsp:include page="../../account/accountCommonLeft.jsp"></jsp:include>
   			<div class="accountRight">
			   	<jsp:include page="../../account/accountCommonRightTop.jsp"></jsp:include>
   				<div class="accountMain clearfix">
   				<!-- 在此处写入代码 -->
   				<!-- 主体部分开始 王延君 2016-04-01 -->
   				<div class="debtAttorn">
   					<div class="debtAttornH">
   						<div class="inTransfer ">转让中</div>
   						<div class="transferAble">可转出</div>
   						<div class="transferOuted">已转出</div>
   						<div class="transferIned">已转入</div>
   						<div class="Settled">已结清</div>
   					</div>
   					<div class="debtAttornM">
   						<ul class="inTransferUl" id="inTransferUl">
   							<li id="inTransTop">
   								<div class="debtAttornMTitle">
					   				<div class="productName">项目名称</div>
					   				<div class="transferAmount">转让金额</div>
					   				<div class="investNum">转让系数</div>
					   				<div class="transferCoefficient">转让价格<em class="iconDown"></em></div>
					   				<div class="latestTransferTime">最晚转让时间</div>
					   				<div class="InvestmentProgress">投资进度</div>
		   						</div>
   							</li>
   							
   							
   						</ul>
   						<script type="text/html" id="inTransferList">
							{{each infos as value index}}
   							<li>
   								<div class="productName divOutside">
		   							<div class="divIntside">
		   								<div>{{value.projectTitle}}</div>
		   							</div>
		   						</div>
		   						<div class="transferAmount divOutside">
		   							<div class="divIntside">
		   								<div class="moneyFormat">{{$toFixed value.transPrincipals}}</div>
		   							</div>
		   						</div>
		   						<div class="investNum divOutside">
		   							<div class="divIntside">
		   								<div>{{value.transDiscounts}}%</div>
		   							</div>
		   						</div>
		   						<div class="transferCoefficient divOutside">
		   							<div class="divIntside">
		   								<div class="moneyFormat">{{$toFixed value.transAmounts}}</div>
		   							</div>
		   						</div>
		   						<div class="latestTransferTime divOutside">
		   							<div class="divIntside">
		   								<div>{{$toDelete value.transMaxTime}}</div>
		   							</div>
		   						</div>
		   						<div class="InvestmentProgress divOutside">
		   							<div class="divIntside">
		   								<div>{{value.ctaInvestRates}}%</div>
		   							</div>
		   						</div>
   							</li>
   							{{/each}}
   							<li class="page"><div id="pager"></div></li>
   						</script>
   						<!-- 可转出 -->
   						<ul class="transferAbleUl" id="transferAbleUl">
   							<li id="topTransferAble">
   								<div class="debtAttornMTitle">
					   				<div class="productName">项目名称</div>
					   				<div class="annualInterestRate">年化利率</div>
					   				<div class="transferable">可转让金额</div>
					   				<div class="ResidualMaturity">剩余期限</div>
					   				<div class="nextRepaymentTime">下次还款时间</div>
					   				<div class="dueTime">到期时间</div>
					   				<div class="operations">操作</div>
		   						</div>
   							</li>
   						</ul>
   						<script id="transferAbleList" type="text/html">
   								{{each infos as value index}}
   								<li>
   								<div class="productName divOutside">
		   							<div class="divIntside">
		   								<div> {{value.projectTitle}}</div>
		   							</div>
		   						</div>
		   						<div class="annualInterestRate divOutside">
		   							<div class="divIntside">
		   								<div>{{value.sYearRate}}%</div>
		   							</div>
		   						</div>
		   						<div class="transferable divOutside">
		   							<div class="divIntside">
		   								<div class="moneyFormat">{{value.sMoney}}</div>
		   							</div>
		   						</div>
		   						<div class="ResidualMaturity divOutside">
		   							<div class="divIntside">
		   								<div>{{value.cou}} 期</div>
		   							</div>
		   						</div>
		   						<div class="nextRepaymentTime divOutside">
		   							<div class="divIntside">
		   								<div>{{$toDelete value.nextTime}}</div>
		   							</div>
		   						</div>
		   						<div class="dueTime divOutside">
		   							<div class="divIntside">
		   								<div>{{$toDelete value.overTime}}</div>
		   							</div>
		   						</div>
		   						<div class="operations divOutside">
		   							<div class="divIntside">
		   								<div><a class="attornBtn">转让</a></div>
		   								<div><a class="attornAgreement" href="#">债权转让协议</a></div>
		   							</div>
		   						</div>
   							</li>
   							{{/each}}
   							<li class="page"><div id="pager1"></div></li>
						</script>
   						
   						
   						<!-- 已转出 -->
   						<ul class="transferOutedUl" id="transferOutedUl">
   							<li id="topTransferOut">
   								<div class="debtAttornMTitle">
					   				<div class="productName">项目名称</div>
					   				<div class="annualInterestRate">年化利率</div>
					   				<div class="transferable">转让金额</div>
					   				<div class="ResidualMaturity">转让系数</div>
					   				<div class="transactionAmount">交易金额</div>
					   				<div class="transferTime">转让成交时间</div>
					   				<div class="investmentTime">投资成交时间</div>
					   				<div class="transferIncome">转让收益</div>
		   						</div>
   							</li>
   				
   						</ul>
   						<script type="text/html" id="transferOutedList">
   							{{each infos as value index}}
   							<li>
   								<div class="productName divOutside">
		   							<div class="divIntside">
		   								<div> {{value.projectTitle}}</div>
		   							</div>
		   						</div>
		   						<div class="annualInterestRate divOutside">
		   							<div class="divIntside">
		   								<div>{{value.sYearRate}}%</div>
		   							</div>
		   						</div>
		   						<div class="transferable divOutside">
		   							<div class="divIntside">
		   								<div class="moneyFormat">{{$toFixed value.transPrincipals}}</div>
		   							</div>
		   						</div>
		   						<div class="ResidualMaturity divOutside">
		   							<div class="divIntside">
		   								<div>{{value.transDiscounts}}%</div>
		   							</div>
		   						</div>
		   						<div class="transactionAmount divOutside">
		   							<div class="divIntside">
		   								<div class="moneyFormat">{{$toFixed value.transAmounts}}</div>
		   							</div>
		   						</div>
		   						<div class="transferTime divOutside">
		   							<div class="divIntside">
		   								<div>{{$toDelete value.dealDate}}</div>
		   							</div>
		   						</div>
		   						<div class="investmentTime divOutside">
		   							<div class="divIntside">
		   								<div>{{$toDelete value.holdDate}}</div>
		   							</div>
		   						</div>
		   						<div class="transferIncome divOutside">
		   							<div class="divIntside">
		   								<div class="moneyFormat">{{$toFixed value.interestAmounts}}</div>
		   							</div>
		   						</div>
   							</li>
   							{{/each}}
   							<li class="page">
								<div id="pager2"></div>
							</li>
   						</script>
   						<!-- 已转入 -->
   						<ul class="transferInedUl" id="transferInedUl">
   							<li id="topTransferIned">
   								<div class="debtAttornMTitle">
					   				<div class="productName">项目名称</div>
					   				<div class="annualInterestRate">年化利率</div>
					   				<div class="transferAmount">转让金额</div>
					   				<div class="investNum">转让系数</div>
					   				<div class="transactionAmount">交易金额</div>
					   				<div class="transferTime">转入时间</div>
					   				<div class="details">详情</div>
		   						</div>
   							</li>

   						</ul>
   						<script type="text/html" id="transferInedList">
							{{each infos as value}}
   							<li>
   								<div class="productName divOutside">
		   							<div class="divIntside">
		   								<div> {{value.projectTitle}}</div>
		   							</div>
		   						</div>
		   						<div class="annualInterestRate divOutside">
		   							<div class="divIntside">
		   								<div>{{value.sYearRate}}%</div>
		   							</div>
		   						</div>
		   						<div class="transferAmount divOutside">
		   							<div class="divIntside">
		   								<div class="moneyFormat">{{$toFixed value.transPrincipals}}</div>
		   							</div>
		   						</div>
		   						<div class="investNum divOutside">
		   							<div class="divIntside">
		   								<div>{{value.transDiscounts}}%</div>
		   							</div>
		   						</div>
		   						<div class="transactionAmount divOutside">
		   							<div class="divIntside">
		   								<div class="moneyFormat">{{$toFixed value.transAmounts}}</div>
		   							</div>
		   						</div>
		   						<div class="transferTime divOutside">
		   							<div class="divIntside">
		   								<div>{{$toDelete value.transTime}}</div>
		   							</div>
		   						</div>
		   						<div class="details divOutside">
		   							<div class="divIntside">
		   								<div><a class="profitList" href="investmentManagement/incomeList/{{value.investId}}/1.html?investId={{value.investId}}">收益列表</a></div>
		   							</div>
		   						</div>
   							</li>
   							{{/each}}
   							<li class="page"><div id="pager3"></div></li>
						</script>
						<!-- 已结清 -->
   						<ul class="SettledUl" id="SettledUl">
   							<li id="topSettledUl">
   								<div class="debtAttornMTitle">
					   				<div class="productName">项目名称</div>
					   				<div class="annualInterestRate">年化利率</div>
					   				<div class="transferable">转让金额</div>
					   				<div class="ResidualMaturity">转让系数</div>
					   				<div class="transactionAmount">交易金额</div>
					   				<div class="transferTime">转入时间</div>
					   				<div class="fullTime">结满时间</div>
					   				<div class="gainIncome">获取收益</div>
		   						</div>
   							</li>

   						</ul>
   						<script type="text/html" id="SettledList">
						{{each infos as value index}}
   							<li>
   								<div class="productName divOutside">
		   							<div class="divIntside">
		   								<div> {{value.projectTitle}}</div>
		   							</div>
		   						</div>
		   						<div class="annualInterestRate divOutside">
		   							<div class="divIntside">
		   								<div>{{value.sYearRate}}%</div>
		   							</div>
		   						</div>
		   						<div class="transferable divOutside">
		   							<div class="divIntside">
		   								<div class="moneyFormat">{{$toFixed value.transPrincipals}}</div>
		   							</div>
		   						</div>
		   						<div class="ResidualMaturity divOutside">
		   							<div class="divIntside">
		   								<div>{{value.transDiscounts}}%</div>
		   							</div>
		   						</div>
		   						<div class="transactionAmount divOutside">
		   							<div class="divIntside">
		   								<div class="moneyFormat">{{$toFixed value.transAmounts}}</div>
		   							</div>
		   						</div>
		   						<div class="transferTime divOutside">
		   							<div class="divIntside">
		   								<div>{{$toDelete value.transTime}}</div>
		   							</div>
		   						</div>
		   						<div class="fullTime divOutside">
		   							<div class="divIntside">
		   								<div>{{$toDelete value.dealDate}}</div>
		   							</div>
		   						</div>
		   						<div class="gainIncome divOutside">
		   							<div class="divIntside">
		   								<div class="moneyFormat">{{$toFixed value.interestAmounts}}</div>
		   							</div>
		   						</div>
   							</li>
   							{{/each}}
   							<li class="page"><div id="pager4"></div></li>
						</script>
   					</div>
   				</div>
   				<!-- 主体部分结束 王延君 2016-04-01 -->
   				</div>
   			</div>
   		</div>
   	</div>
   	<script type="text/javascript" charset="utf-8" src="plugs/pager/pager.js"></script>
   	<jsp:include page="../../common/bottom.jsp"></jsp:include>
   	<!--弹出层修改伍成然2016-4-6  -->
   	<div class="layerWindow" style="display:none">
   	<form id="form1">
		<div class="layerWindowM">
			
				<input type="hidden" value="" id="inputInvestId">	
				<div>可转让金额：<span class="moneyFormat" id="transferableMoney">10000</span>元</div>
				<div><label>转让金额：</label><input datatype="acountM" id="getTransNum" type="text" lang="请输入转让金额" maxlength="10">元</div>
				<div><label>转让折扣：</label><input class="numberReg" id="getSaleNum" datatype="acountM1" type="text" lang="请输入转让折扣(%)" maxlength="10">%</div>
				<div>
					<label>最晚转出时间：</label>
					<input type="text" class="select-time Wdate" id="maxTime" onfocus="WdatePicker({minDate: '%y-%M-%d' })"  lang="请选择最晚转出时间">
				</div>
			
		</div>
		<div class="layerWindowBtn">
			<div class="btn"  id="sureBtn">确定</div>
		</div>
		</form>
	</div>
	<script type="text/javascript" src="/foreground-web/plugs/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="js/account/account.js"></script>
	<script type="text/javascript" src="js/account/investmentManagement/debtAttorn.js"></script>
</body>
</html>