<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN">
<html>
<head>
	<base href="<%=basePath%>">
    <title>债权转让</title>
    <jsp:include page="../common/top_meta.jsp"></jsp:include>
	<link rel="stylesheet" type="text/css" href="css/invest/debtCession.css">
	<link rel="stylesheet" href="plugs/pager/pager_def.css" type="text/css">
</head>
<body>
    <jsp:include page="../common/top.jsp"></jsp:include>
   	<jsp:include page="../common/mainPageTop.jsp"></jsp:include>
   	<script type="text/javascript" src="js/common/template.js"></script>
    <!-- 此处加入代码 -->
    <!--伍成然2016-3-28-->
    <div class="main">
    	<!--链接区域  -->
    	<div class="link-area">
    		您当前的位置&gt;
			<a href="index.html">首页</a>&gt;
			<a href="">债权转让</a>
    	</div>
    	<!--tab区域  -->
    	<ul class="tab-head">
			<li class="tab-li"><a href="invest/investmentZone.html">投资专区</a></li>
			<li class="tab-ing">债权转让</li>
		</ul>
		<!--轮播图区域  -->
		<div class="banner">
			<ul>
				<li>
					<img src="resource/img/invest/zqzr_03.jpg">
				</li>
				<li>
					<img src="resource/img/invest/wytz_03.jpg">
				</li>
				<li>
					<img src="resource/img/index/sliderIndex3.jpg">
				</li>
			</ul>
		</div>
		<!--筛选区域  -->
		<div class="fliter-box">
			<!--筛选头部  -->
			<div class="fliter-head">
				<div class="fliter-title">筛选投资项目</div>
				<div class="fliter-search">
					<div class="input-group">
					    <input type="text" class="search show">
					    <span class="input-group-btn">
					        <input class="btn search-btn" type="button" value="搜索">
					    </span>			    
					</div><!-- /input-group -->	
				</div>
			</div>	
			<!--筛选主部 -->
			<div class="fliter-tags clearfix">
				<div class="fliter-left"><!--筛选部分，active为选中 -->
					<div class="tags-list-state tags-list">
						<div class="left-title">项目状态:</div>
						<label class="active"><input type="radio" name="projectStatu" value="-1" checked>全部</label>
						<label><input type="radio" name="projectStatu" value="0">投标中</label>
						<label><input type="radio" name="projectStatu" value="1">流标</label>
						<label><input type="radio" name="projectStatu" value="2">投标完成</label>
						<label><input type="radio" name="projectStatu" value="3">还款中</label>
						<label><input type="radio" name="projectStatu" value="4">已结清</label>
					</div>
					<div class="tags-list-type tags-list">
						<div class="left-title">借款类型:</div>
						<label class="active"><input type="radio" name="loanType" value="-1" checked>全部</label>
						<c:forEach items="${projectBaseInfos }" var="pbi">
							<label><input type="radio" name="loanType" value="${pbi.id }">${pbi.projectName }</label>
						</c:forEach>
					</div>
					<div class="tags-list-rate tags-list">
						<div class="left-title">年化利率:</div>
						<label class="active"><input type="radio" name="annualInterest" value="-1" checked>全部</label>
						<label><input type="radio" name="annualInterest" value="8">8%以下</label>
						<label><input type="radio" name="annualInterest" value="8,12">8%-12%</label>
						<label><input type="radio" name="annualInterest" value="12">12%以上</label>			
					</div>
					<div class="tags-list-method tags-list">
						<div class="left-title">还款方式:</div>
						<label class="active"><input type="radio" name="repayment" value="-1" checked>全部</label>
						<label><input type="radio" name="repayment" value="0">等额本息</label>
						<label><input type="radio" name="repayment" value="1">先息后本</label>
						<label><input type="radio" name="repayment" value="2">到期还本息</label>
						<label><input type="radio" name="repayment" value="3">等额本金</label>			
					</div>
				</div>
				<div class="fliter-right">	
					<div class="tags-list-day tags-list">
						<div class="left-title">投资期限(天):</div>
						<label class="active"><input type="radio" name="investDay" value="-1" checked>全部</label>
						<label><input type="radio" name="investDay" value="1,15">1-15天</label>
						<label><input type="radio" name="investDay" value="16,30">16-30天</label>
						<label><input type="radio" name="investDay" value="31,45">31-45天</label>
						<label><input type="radio" name="investDay" value="45,-1">45天以上</label>
					</div>
					<div class="tags-list-month tags-list">
						<div class="left-title">投资期限(月):</div>
						<label class="active"><input type="radio" name="investMonth" value="-1" checked>全部</label>
						<label><input type="radio" name="investMonth" value="1,3">1-3个月</label>
						<label><input type="radio" name="investMonth" value="4,6">4-6个月</label>
						<label><input type="radio" name="investMonth" value="7,9">7-9个月</label>
						<label><input type="radio" name="investMonth" value="10,12">10-12个月</label>
						<label><input type="radio" name="investMonth" value="12,-1">12个月以上</label>				
					</div>
					<div class="tags-list-year tags-list">
						<div class="left-title">投资期限(年):</div>
						<label class="active"><input type="radio" name="investYear" value="-1" checked>全部</label>
						<label><input type="radio" name="investYear" value="1,1">1年</label>
						<label><input type="radio" name="investYear" value="2,2">2年</label>
						<label><input type="radio" name="investYear" value="3,3">3年</label>
						<label><input type="radio" name="investYear" value="3,-1">3年以上</label>	
					</div>
				</div>
			</div>
		</div><!--fliter-box  -->
		<!--项目列表  -->
		<ul class="invest-list" id="debtList">
		</ul>
		<script id="debt_list" type="text/html">
		{{each infos as value index}}
			<li class="inv-li">
				<div class="inv-head clearfix">
					<div class="inv-head-left">
						<img src="{{value.picIcon}}"><!--担dan/抵di/信xin-->
						<a href="invest/debtDetail/{{value.ctaId}}.html">{{value.projectTitle}}</a>
						<span>【{{value.projectNo}}】</span>
					</div>
				</div>
				<div class="inv-info">
					<div class="inv-rate">
						<h1>{{value.expectYearrates}}<span>%</span>
							{{if value.rateAddRate>0}}
								<span class="increase">+{{value.rateAddRate}}%</span>
							{{/if}}
						</h1>
						<p>预期年化利率</p>
					</div>
					<div class="inv-item-amount">
						<h1 class="moneyFormat">{{$toFixed value.transPrincipals}}</h1><span>元</span>
						<p>转让金额</P>
					</div>
					<div class="inv-time">
						{{if value.surplusTimeType==0}}
						<h1>{{value.surplusTime}}<span>天</span></h1><!--时间有年、月、天 -->
						{{/if}}
						{{if value.surplusTimeType==1}}
						<h1>{{value.surplusTime}}<span>个月</span>{{value.surplusTimeSub}}<span>天</span></h1><!--时间有年、月、天 -->
						{{/if}}
						{{if value.surplusTimeType==2}}
						<h1>{{value.surplusTime}}<span>年</span>{{value.surplusTimeSub}}<span>个月</span></h1><!--时间有年、月、天 -->
						{{/if}}
						<p>剩余期限</p>
					</div>
					<div class="inv-discount">
						<h1>{{$toFixed value.transDiscounts}}<span>%</span></h1>
						<p>转让折扣</p>
					</div>
					<div class="progress">
						<div class="barbox"> 
							<div class="barline" style="width: 60%;"></div> 
						</div>
						<span class="progress_totle">{{value.ctaInvestRate}}%</span>
					</div>
					<div class="inv-time-count">
						<div class="repay-method">还款方式:<span>{{value.repalyways}}</span></div>
						{{if value.transStatu == 0}}
							<input type="button" class="buy-now" value="立即购买" onclick="window.location.href='invest/debtDetail/{{value.ctaId}}.html'"> 
						{{/if}}
						{{if value.transStatu != 0}}
							<input type="button" class="buy-now" value="查看详情" onclick="window.location.href='invest/debtDetail/{{value.ctaId}}.html'"> 
						{{/if}}
					</div>
				</div>
			</li>
		{{/each}}
		</script>
		<div id="pager"></div>		
    </div><!--main  -->
   	<jsp:include page="../common/bottom.jsp"></jsp:include>
   	<script type="text/javascript" charset="utf-8" src="plugs/pager/pager.js"></script>
	<script type="text/javascript" src="js/invest/debtCession.js"></script>
</body>
</html>