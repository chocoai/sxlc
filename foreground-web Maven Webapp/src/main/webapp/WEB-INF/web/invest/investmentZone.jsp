<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN">
<html>
<head>
    <title>投资专区</title>
    <jsp:include page="/web/common/top_meta.jsp"></jsp:include>
	<link rel="stylesheet" type="text/css" href="css/invest/investmentZone.css">
	<link rel="stylesheet" href="plugs/pager/pager_def.css" type="text/css">
</head>
<body>
    <jsp:include page="/web/common/top.jsp"></jsp:include>
   	<jsp:include page="/web/common/mainPageTop.jsp"></jsp:include>
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
			<li class="tab-li"><a href="debtCession.html">债权转让</a></li>
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
						<label class="active"><input type="radio" name="tag" value="全部">全部</label>
						<label><input type="radio" name="tag" value="预热中">预热中</label>
						<label><input type="radio" name="tag" value="投标中">投标中</label>
						<label><input type="radio" name="tag" value="投标完成">投标完成</label>
					</div>
					<div class="tags-list-reward tags-list">
						<div class="left-title">奖励:</div>
						<label class="active"><input type="radio" name="tag" value="全部">全部</label>
						<label><input type="radio" name="tag" value="加息">加息</label>
						<label><input type="radio" name="tag" value="返现">返现</label>
						<label><input type="radio" name="tag" value="无奖励">无奖励</label>
					</div>
					<div class="tags-list-type tags-list">
						<div class="left-title">借款类型:</div>
						<label class="active"><input type="radio" name="tag" value="全部">全部</label>
						<label><input type="radio" name="tag" value="担保贷">担保贷</label>
						<label><input type="radio" name="tag" value="抵押贷">抵押贷</label>
						<label><input type="radio" name="tag" value="信用贷">信用贷</label>
					</div>
					<div class="tags-list-rate tags-list">
						<div class="left-title">年化利率:</div>
						<label class="active"><input type="radio" name="tag" value="全部">全部</label>
						<label><input type="radio" name="tag" value="8%以下">8%以下</label>
						<label><input type="radio" name="tag" value="8%-12%">8%-12%</label>
						<label><input type="radio" name="tag" value="12%以上">12%以上</label>			
					</div>
				</div>
				<div class="fliter-right">
					<div class="tags-list-method tags-list">
						<div class="left-title">还款方式:</div>
						<label class="active"><input type="radio" name="tag" value="全部">全部</label>
						<label><input type="radio" name="tag" value="等额本金">等额本金</label>
						<label><input type="radio" name="tag" value="等额本息">等额本息</label>
						<label><input type="radio" name="tag" value="先息后本">先息后本</label>
						<label><input type="radio" name="tag" value="到期还本息">到期还本息</label>			
					</div>
					<div class="tags-list-day tags-list">
						<div class="left-title">投资期限(天):</div>
						<label class="active"><input type="radio" name="tag" value="全部">全部</label>
						<label><input type="radio" name="tag" value="1-15天">1-15天</label>
						<label><input type="radio" name="tag" value="16-30天">16-30天</label>
						<label><input type="radio" name="tag" value="31-45天">31-45天</label>	
						<label><input type="radio" name="tag" value="45天以上">45天以上</label>			
					</div>
					<div class="tags-list-month tags-list">
						<div class="left-title">投资期限(月):</div>
						<label class="active"><input type="radio" name="tag" value="全部">全部</label>
						<label><input type="radio" name="tag" value="1-3个月">1-3个月</label>
						<label><input type="radio" name="tag" value="4-6个月">4-6个月</label>
						<label><input type="radio" name="tag" value="7-9个月">7-9个月</label>
						<label><input type="radio" name="tag" value="10-12个月">10-12个月</label>
						<label><input type="radio" name="tag" value="12个月以上">12个月以上</label>				
					</div>
					<div class="tags-list-year tags-list">
						<div class="left-title">投资期限(年):</div>
						<label class="active"><input type="radio" name="tag" value="全部">全部</label>
						<label><input type="radio" name="tag" value="1年">1年</label>
						<label><input type="radio" name="tag" value="2年">2年</label>
						<label><input type="radio" name="tag" value="3年">3年</label>	
						<label><input type="radio" name="tag" value="3年以上">3年以上</label>			
					</div>
				</div>
			</div>
		</div><!--fliter-box  -->
		<!--项目列表  -->
		<ul class="invest-list">
		<% for(int j = 0; j<1;j++){ %>
			<li class="inv-li">
				<div class="inv-head clearfix">
					<div class="inv-head-left">
						<img src="resource/img/invest/dan.png">
						<a href="investmentDetail.html">化工企业研发资金借款</a>
						<span>【NO.20160306121】</span>
					</div>
					<div class="inv-head-right">
						<span>还款方式:</span>
						到期还本息
					</div>
				</div>
				<div class="inv-info">
					<div class="photo">
						<img src="resource/img/invest/wytz_07.jpg" class="img">
					</div>
					<div class="inv-rate">
						<h1>16.20<span>%</span></h1>
						<p>年化利率</p>
					</div>
					<div class="inv-item-amount">
						<h1 class="moneyFormat">5000</h1><span>元</span>
						<p>项目金额</P>
					</div>
					<div class="inv-time">
						<h1>6<span>个月</span></h1>
						<p>项目期限</p>
					</div>
					<div class="inv-available-amount">
						<h1 class="moneyFormat">5000</h1><span>元</span>
						<p>可投金额</p>
					</div>
					<div class="inv-time-count">
						<div class="start-time"><span>开标时间：</span>2016年3月2日15:00</div>
						<div class="investOpenT">							
							<span id="endTimeValue-d"></span>
						</div> 
					</div>
				</div>
			</li>
		<%} %>
		<% for(int j = 0; j<3;j++){ %>
			<li class="inv-li">
				<div class="inv-head clearfix">
					<div class="inv-head-left">
						<img src="resource/img/invest/dan.png"><!--担dan/抵di/信xin-->
						<a href="investmentDetail.html">化工企业研发资金借款</a>
						<span>【NO.20160306121】</span>
					</div>
					<div class="inv-head-right">
						<span>还款方式:</span><!--还款方式有:到期还本息，等额本金，等额本息，先息后本，到期还本息 -->
						到期还本息
					</div>
				</div>
				<div class="inv-info">
					<div class="photo">
						<img src="resource/img/invest/wytz_07.jpg" class="img">
					</div>
					<div class="inv-rate">
						<h1>16.20<span>%</span></h1>
						<p>年化利率</p>
					</div>
					<div class="inv-item-amount">
						<h1 class="moneyFormat">5000</h1><span>元</span>
						<p>项目金额</P>
					</div>
					<div class="inv-time">
						<h1>6<span>个月</span></h1>
						<p>项目期限</p>
					</div>
					<div class="inv-available-amount">
						<h1 class="moneyFormat">5000</h1><span>元</span>
						<p>可投金额</p>
					</div>
					<div class="inv-time-count">
						<div class="progress">
							<span class="progress_totle">60%</span>
							<div class="barbox"> 
								<div class="barline"></div> 
							</div>
						</div>
						<input type="button" class="inv-now" value="立即投资" onclick="window.location.href='investmentDetail.html'"> 
					</div>
				</div>
			</li>
		<%} %>
		<% for(int j = 0; j<1;j++){ %>
			<li class="inv-li">
				<div class="inv-head clearfix">
					<div class="inv-head-left">
						<img src="resource/img/invest/di.png">
						<a href="investmentDetail.html">化工企业研发资金借款</a>
						<span>【NO.20160306121】</span>
					</div>
					<div class="inv-head-right">
						<span>还款方式:</span><!--还款方式有:到期还本息，等额本金，等额本息，先息后本，到期还本息 -->
						到期还本息
					</div>
				</div>
				<div class="inv-info">
					<div class="photo">
						<img src="resource/img/invest/wytz_07.jpg" class="img">
					</div>
					<div class="inv-rate">
						<h1>16.20<span>%</span></h1>
						<p>年化利率</p>
					</div>
					<div class="inv-item-amount">
						<h1 class="moneyFormat">5000</h1><span>元</span>
						<p>项目金额</P>
					</div>
					<div class="inv-time">
						<h1>6<span>个月</span></h1>
						<p>项目期限</p>
					</div>
					<div class="inv-available-amount">
						<h1 class="moneyFormat">0</h1><span>元</span>
						<p>可投金额</p>
					</div>
					<div class="inv-time-count">
						<div class="pro-finish"></div>
						<div class="progress">
							<span class="progress_totle">100%</span>
							<div class="barbox"> 
								<div class="barline"></div> 
							</div>	
						</div>
						<input type="button" class="view-details" value="查看详情" onclick="window.location.href='investmentDetail.html'"> 
					</div>
				</div>
			</li>
		<%} %>
		<% for(int j = 0; j<1;j++){ %>
			<li class="inv-li">
				<div class="inv-head clearfix">
					<div class="inv-head-left">
						<img src="resource/img/invest/xin.png">
						<a href="investmentDetail.html">化工企业研发资金借款</a>
						<span>【NO.20160306121】</span>
					</div>
					<div class="inv-head-right">
						<span>还款方式:</span><!--还款方式有:到期还本息，等额本金，等额本息，先息后本，到期还本息 -->
						到期还本息
					</div>
				</div>
				<div class="inv-info">
					<div class="photo">
						<img src="resource/img/invest/wytz_07.jpg" class="img">
					</div>
					<div class="inv-rate">
						<h1>16.20<span>%</span></h1>
						<p>年化利率</p>
					</div>
					<div class="inv-item-amount">
						<h1 class="moneyFormat">5000</h1><span>元</span>
						<p>项目金额</P>
					</div>
					<div class="inv-time">
						<h1>6<span>个月</span></h1>
						<p>项目期限</p>
					</div>
					<div class="inv-available-amount">
						<h1 class="moneyFormat">0</h1><span>元</span>
						<p>可投金额</p>
					</div>
					<div class="inv-time-count">
						<div class="pro-repaying"></div>
						<div class="progress">
							<span class="progress_totle">100%</span>
							<div class="barbox"> 
								<div class="barline"></div> 
							</div>	
						</div>
						<input type="button" class="view-details" value="查看详情" onclick="window.location.href='investmentDetail.html'"> 
					</div>
				</div>
			</li>
		<%} %>
		</ul>
		<div id="pager"></div>	
    </div><!--main  -->
   	<jsp:include page="/web/common/bottom.jsp"></jsp:include>
   	<script type="text/javascript" charset="utf-8" src="plugs/pager/pager.js"></script>
   	<script type="text/javascript" src="js/common/countdown.js"></script>
	<script type="text/javascript" src="js/invest/investmentZone.js"></script>
</body>
</html>