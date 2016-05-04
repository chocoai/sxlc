<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN">
<html>
<head>
	<base href="<%=basePath%>">
    <title>投资专区</title>
    <jsp:include page="../common/top_meta.jsp"></jsp:include> 	
	<link rel="stylesheet" type="text/css" href="css/invest/investmentZone.css">
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
			<a href="" class="dq">投资专区</a>
    	</div>
    	<!--tab区域  -->
    	<ul class="tab-head">
			<li class="tab-ing">投资专区</li>
			<li class="tab-li"><a href="invest/debtCession.html">债权转让</a></li>
		</ul>
		<!--轮播图区域  -->
		<div class="banner">
			<ul>
				<li>
					<img src="resource/img/invest/wytz_03.jpg">
				</li>
				<li>
					<img src="resource/img/invest/zqzr_03.jpg">
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
					    <input type="text" class="search show" id="wd">
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
						<label><input type="radio" name="projectStatu" value="5">预热中</label>
						<label><input type="radio" name="projectStatu" value="0">投标中</label>
						<label><input type="radio" name="projectStatu" value="2">投标完成</label>
						<label><input type="radio" name="projectStatu" value="1">流标</label>
						<label><input type="radio" name="projectStatu" value="3">还款中</label>
						<label><input type="radio" name="projectStatu" value="4">已结清</label>
					</div>
					<div class="tags-list-reward tags-list">
						<div class="left-title">奖励:</div>
						<label class="active"><input type="radio" name="reward" value="-1" checked>全部</label>
						<label><input type="radio" name="reward" value="1">加息</label>
						<label><input type="radio" name="reward" value="2">返现</label>
						<label><input type="radio" name="reward" value="3">无奖励</label>
					</div>
					<div class="tags-list-type tags-list">
						<div class="left-title">借款类型:</div>
						<label class="active"><input type="radio" name="loanType" value="-1" checked>全部</label>
						<c:forEach items="${projectBaseInfos }" var="pb">
							<label><input type="radio" name="loanType" value="${pb.id }">${pb.projectName }</label>
						</c:forEach>
					</div>
					<div class="tags-list-rate tags-list">
						<div class="left-title">年化利率:</div>
						<label class="active"><input type="radio" name="annualInterest" value="-1" checked>全部</label>
						<label><input type="radio" name="annualInterest" value="8">8%以下</label>
						<label><input type="radio" name="annualInterest" value="8,12">8%-12%</label>
						<label><input type="radio" name="annualInterest" value="12">12%以上</label>
					</div>
				</div>
				<div class="fliter-right">
					<div class="tags-list-method tags-list">
						<div class="left-title">还款方式:</div>
						<label class="active"><input type="radio" name="repayment" value="-1" checked>全部</label>
						<label><input type="radio" name="repayment" value="0">等额本息</label>
						<label><input type="radio" name="repayment" value="1">先息后本</label>
						<label><input type="radio" name="repayment" value="2">到期还本息</label>
						<label><input type="radio" name="repayment" value="3">等额本金</label>
					</div>
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
		</div>
		<!--fliter-box  -->
		<!--项目列表  -->
		<!-- 项目列表模板 -->
		<script id="investList" type="text/html">
		{{if infos.length>0}}
			{{each infos as data index}}
				<li class="inv-li">
					<div class="inv-head clearfix">
						<div class="inv-head-left">
							<img src={{data.picIcon}}>
							<a href="invest/investmentDetail/{{data.applyId}}.html">{{data.projectBaseInfoentity.projectTitle}}</a>
							<span>【{{data.projectNo}}】</span>
						</div>
						<div class="inv-head-right">
							<span>还款方式:</span>
							{{data.projectBaseInfoentity.replayWays}}
						</div>
					</div>
					<div class="inv-info">
						<div class="photo">
							<img src={{data.imageUrl}} class="img">
						</div>
						<div class="inv-rate">
							<h1>{{data.projectBaseInfoentity.yearRates}}<span>%</span></h1>
							<p>年化利率</p>
						</div>
						<div class="inv-item-amount">
							<h1 class="moneyFormat">{{$toFixed data.projectBaseInfoentity.amounts}}</h1><span>元</span>
							<p>项目金额</P>
						</div>
						<div class="inv-time">
							{{if data.projectBaseInfoentity.deadlineType == "0"}}
								<h1>{{data.projectBaseInfoentity.deadline}}<span>天</span></h1>
							{{/if}}
							{{if data.projectBaseInfoentity.deadlineType == "1"}}
								<h1>{{data.projectBaseInfoentity.deadline}}<span>个月</span></h1>
							{{/if}}
							{{if data.projectBaseInfoentity.deadlineType == "2"}}
								<h1>{{data.projectBaseInfoentity.deadline}}<span>年</span></h1>
							{{/if}}
							<p>项目期限</p>
						</div>
						<div class="inv-available-amount">
							<h1 class="moneyFormat">{{$toFixed data.availableaAmounts}}</h1><span>元</span>
							<p>可投金额</p>
						</div>
						<div class="inv-time-count">
							{{if data.investStatu == "0"}}
								<div class="progress">
									<span class="progress_totle">{{data.investRate}}%</span>
								<div class="barbox"> 
								<div class="barline"></div> 
								</div>
								</div>
								<input type="button" class="inv-now" value="立即投资" onclick="window.location.href='invest/investmentDetail/{{data.applyId}}.html'"> 
							{{/if}}
							{{if data.investStatu == "1"}}
								<div class="pro-fault"></div>
								<div class="progress">
								<span class="progress_totle">100%</span>
								<div class="barbox"> 
									<div class="barline"></div> 
								</div>	
								</div>
								<input type="button" class="view-details" value="查看详情" onclick="window.location.href='invest/investmentDetail/{{data.applyId}}.html'">
							{{/if}}
							{{if data.investStatu == "2"}}
								<div class="pro-all"></div>
								<div class="progress">
								<span class="progress_totle">100%</span>
								<div class="barbox"> 
									<div class="barline"></div> 
								</div>	
								</div>
								<input type="button" class="view-details" value="查看详情" onclick="window.location.href='invest/investmentDetail/{{data.applyId}}.html'">
							{{/if}}
							{{if data.investStatu == "3"}}
								<div class="pro-repaying"></div>
								<div class="progress">
								<span class="progress_totle">100%</span>
								<div class="barbox"> 
									<div class="barline"></div> 
								</div>	
								</div>
								<input type="button" class="view-details" value="查看详情" onclick="window.location.href='invest/investmentDetail/{{data.applyId}}.html'"> 
							{{/if}}
							{{if data.investStatu == "4"}}
								<div class="pro-finish"></div>
								<div class="progress">
								<span class="progress_totle">100%</span>
								<div class="barbox"> 
									<div class="barline"></div> 
								</div>	
								</div>
								<input type="button" class="view-details" value="查看详情" onclick="window.location.href='invest/investmentDetail/{{data.applyId}}.html'"> 
							{{/if}}
							{{if data.investStatu == "5"}}
								<div class="start-time"><span>开标时间：</span>{{$toDelete data.startDate}}</div>
								<div class="investOpenT">							
									<div class="J_CountDown time" data-config="{
											'startTime':'{{$toDelete data.getDate}}'',
    										'endTime':'{{$toDelete data.startDate}}'
										}"></div>
								</div> 

							{{/if}}
						</div>
					</div>
				</li>
			{{/each}}
		{{else}}
				没有更多数据
		{{/if}}
		</script>

		<ul class="invest-list" id="invest-list">

		</ul>
		<div id="pager"></div>	
    </div><!--main  -->
   	<jsp:include page="../common/bottom.jsp"></jsp:include>
   	<script type="text/javascript" charset="utf-8" src="plugs/pager/pager.js"></script>
   	<script type="text/javascript" src="js/common/countdown.js"></script>
	<script type="text/javascript" src="js/invest/investmentZone.js"></script>
</body>
</html>