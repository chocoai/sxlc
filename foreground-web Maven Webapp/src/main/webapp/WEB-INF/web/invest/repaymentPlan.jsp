<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<div class="repaymentPlan">
<!--伍成然2016-3-30  -->
<ul class="table grid-table1" id="repaymentPlan">
   <li id="repaymentPlanTop">
      <div>合约还款日期</div>
      <div>应还本金</div>
      <div>应还利息</div>
      <div>应还本息</div>
      <div>还款状态</div>        
   </li>
</ul>
<script id="repay_Plan" type="text/html">
	{{each json as json index}}
		<li>
		 <div>{{$timeFixed json.repayMaxTime}}</div>
		 <div><span class="moneyFormat">{{$toFixed json.sDRepayPrincipals}}</span>元</div>
	     <div><span class="moneyFormat">{{$toFixed json.sDRepayInterests}}</span>元</div>
	     <div><span class="moneyFormat">{{$toFixed json.sdPrincipalInterests}}</span>元</div>
	     <div>{{json.loanStatu}}</div>
		<li>
	{{/each}}
</script>
<div class="repay-sum">一共需还本息：<span><label class="moneyFormat1">88888</label>元</span></div>
</div>