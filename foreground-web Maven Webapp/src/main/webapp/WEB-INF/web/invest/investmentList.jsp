<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<div class="investmentList">
<!--伍成然2016-3-30  -->
<ul class="table grid-table2" id="investmentList">
   <li>
      <div>投标人</div>
      <div>投标金额</div>
      <div>投标时间</div>
      <div>投标方式</div>
      <div>投标来源</div>        
   </li>
</ul>
<script id="invest_List" type="text/html">
	{{each info as value index}}
		<li>
      		<div>{{value.logname}}</div>
      		<div><span class="moneyFormat">{{$toFixed value.investAmounts}}</span>元</div>
      		<div>{{$toDelete value.investDate}}</div>
			{{if value.isAuto=="1"}}
      			<div>自动</div>
			{{else}}
				<div>手动</div>
			{{/if}}
			
			{{if value.investType=="0"}}
					<div>PC端</div>
			{{else if value.investType=="1"}}
					<div class="invListPhone">移动端</div>
			{{else}}
					<div class="wechat">微信端</div>
			{{/if}}
   		</li>
	{{/each}}
</script>
<div class="inv-sum">借款总额：<span><label class="moneyFormat2" id="moneyFormat2">10000</label>元
</span>目前投标总额：<span><label class="moneyFormat3" id="moneyFormat3">8000</label>元</span>
剩余可投总额：<span><label class="moneyFormat4" id="moneyFormat4">2000</label>元</span></div>
</div>