<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>收益计算</title>
	<jsp:include page="../common/top_meta.jsp"></jsp:include>
	<script type="text/javascript" src="js/account/account.js"></script>
	<link rel="stylesheet" type="text/css" href="css/account/account.css">
	<link rel="stylesheet" type="text/css" href="css/invest/incomeCalculation.css">
  </head>
  <body>
    <jsp:include page="../common/top.jsp"></jsp:include>
   	<jsp:include page="../common/mainPageTop.jsp"></jsp:include>
	<div class="main" style="padding:56px 0">
		<div class="content">
			<div class="top-nav">
				<span class="blueLine"></span><span class="top-text">收益计算器</span>
			</div>
			<div>
				<form id="form1">
					<table class="tb1">
						<tr>
							<td>
								<img src="resource/img/invest/touzijine_icon.png" class="img1">
								<span>投资金额:</span>
								<div class="form-inputList">
									<span class="floText">元</span>
									<input class="amount" type="text" datatype="acountM" lang="请输入意向投资金额">
								</div>
							</td>
							<td>
								<img src="resource/img/invest/nianhualilv_icon.png" class="img1">
								<span>年化利率:</span>
								<div class="form-inputList">
									<span class="floText">%</span>
									<input class="yearRate" type="text" datatype="hundredNum" lang="请输入年化利率">
								</div>
							</td>
							<td>
								<img src="resource/img/invest/jiaxililv_icon.png" class="img1">
								<span>加息利率:</span>
								<div class="form-inputList">
									<span class="floText">%</span>
									<input class="moreRate" type="text"  datatype="hundredNum"  lang="请输入加息率">
								</div>
							</td>
						</tr>
						<tr>
							<td>
								<img src="resource/img/invest/touziqixian_icon.png" class="img1">
								<span>投资期限:</span>
								<div class="form-inputList">
									<div class="form-inputList">
										<input class="dateNum" type="text"  datatype="acountNum"  id="investArea" lang="请输入投资期限">
									</div> 
										<div class="selectArea" id="getInvestA">
											<input class="selectValue" value="0" >
											<input class="selectInput" type="text" lang="天" readOnly="true"/>
										    <ul class="select" style="width:58px" id="citySelect" onselectstart="return false">
										        <li class="selectOption" value="0">天<li>
										        <li class="selectOption" value="1">月<li>
										        <li class="selectOption" value="2">年<li>
										    </ul>
										
									 </div>
								</div>
							</td>
							<td colspan="2">
								<img src="resource/img/invest/huankuanfangshi_icon.png" class="img1">
								<span>还款方式:</span>
								<div class="form-inputList">
									<div class="selectArea" id="investX">
										<input class="selectValue" value="0" >
										<input class="selectInput proType" type="text" lang="等额本息" readOnly="true"/>
									    <ul class="select proType1" id="citySelect" onselectstart="return false">
									        <li class="selectOption" value="0">等额本息<li>
									        <li class="selectOption" value="1">先息后本<li>
									        <li class="selectOption" value="2">到期还本息<li>
									        <li class="selectOption" value="3">等额本金<li>
									    </ul>
									</div> 
									<span></span>
								</div>
							</td>
						</tr>
						<tr>
							<td colspan="3" style="text-align:center">
								<div>
									<img src="resource/img/invest/yuqishouyi_icon.png" class="img1">
									<label>预计收益 : <span class="expectedReturn orange moneyFormat">0.00</span>元</label>
									<label>加息收益 : <span class="moreReturn orange moneyFormat">0.00</span>元</label>
								</div>
							</td>
						</tr>
						<tr>
							<td colspan="3" style="text-align:center">
								<input type="button" class="calBtn" value="计算收益">
							</td>
						</tr>
					</table>
				</form>
			</div>
			<div class="line"></div>
			<div class="top-nav">
				<span class="blueLine"></span><span class="top-text">收益计划</span>
			</div>
			<div class="hei_340">
				<table class="tb2" cellspacing="0">
					<thead>
						<tr>
							<td>序号</td>
							<td>时间</td>
							<td>应收本金(元)</td>
							<td>应收利息(元)</td>
							<td>加息利息(元)</td>
							<td>月收本息(元)</td>
						</tr>
					</thead>
					<tbody id="list">
						<script id="all_list" type="text/html">
						{{each list as info index}}
							<tr>
								<td>{{index}}</td>
								<td>{{info.retrieveDateTime}}</td>
								<td class="moneyFormat">{{info.corpus}}</td>
								<td class="moneyFormat">{{(info.interest)*num}}</td>
								<td class="moneyFormat">{{(info.interest)*(1-num)}}</td>
								<td class="moneyFormat">{{info.endCorpusInterest}}</td>
							</tr>
		   				{{/each}}
   						</script>
					</tbody>
				</table>
				<div id="pager"></div>
			</div>
		</div>
	</div>
   	<jsp:include page="../common/bottom.jsp"></jsp:include>
  </body>
  	<script type="text/javascript" src="js/invest/incomeCalculation.js"></script>
</html>
