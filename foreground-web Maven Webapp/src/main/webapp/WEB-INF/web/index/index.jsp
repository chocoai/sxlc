<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="<%=basePath%>">
    <title>首页</title>
    <jsp:include page="../common/top_meta.jsp"></jsp:include>
	<link rel="stylesheet" type="text/css" href="css/index/index.css">
</head>
<body>
    <jsp:include page="../common/top.jsp"></jsp:include>
   	<jsp:include page="../common/mainPageTop.jsp"></jsp:include>
    <div class="banner">
		<ul>
			<li>
				<div class="bannerImg"><img src="resource/img/index/sliderIndex1.jpg"></div>
			</li>
			<li>
				<div class="bannerImg"><img src="resource/img/index/sliderIndex2.jpg"></div>
			</li>
			<li>
				<div class="bannerImg"><img src="resource/img/index/sliderIndex3.jpg"></div>
			</li>
		</ul>
		<div class="carousel_float">
						<div class="float_title">
							<span class="floatTSpan1">
							    <span>
								    <i><img src="resource/img/index/ptsj.png"></i>
									<i>平台数据</i>
							    </span>
							</span>
							<span class="floatTSpan2">
								<i>
									<em>9</em>万<em>8979</em>人
								</i>
								<i class="totalVip">累计会员</i>
						</span>
						</div>
						<div class="float_content">
							<div class="float_left">
								<img src="resource/img/index/ych.png">
							</div>
							<div class="float_right">
								<i><em>163</em>亿<em>5263</em>万<em>8379</em>元</i>
								<i class="floatCMoney">已撮合资金</i>
							</div>
						</div>
						<div class="float_content">
							<div class="float_left">
								<img src="resource/img/index/tzrzq.png">
							</div>
							<div class="float_right">
								<i><em>163</em>亿<em>5263</em>万<em>8379</em>元</i>
								<i class="floatCMoney">为投资人赚取</i>
							</div>
						</div>
						<div class="float_content">
							<div class="float_left">
								<img src="resource/img/index/ptfx.png">
							</div>
							<div class="float_right">
								<i><em>163</em>亿<em>5263</em>万<em>8379</em>元</i>
								<i class="floatCMoney">平台风险备付金</i>
							</div>
						</div>
					</div>
				</div>
				<!--王延君  2016.03.27 公告滚动部分开始 -->
				<div class="contFoot">
					<div class="contFootMain">
						<div class="contFootTitle">
							<div><img src="resource/img/index/gg.png"></div>
							<span>平台公告</span>
						</div>
						<div id="demo">
							<div class="scrollLeft">
								<div id="indemo" class="indemo">
									<span>恭喜会员9**7注册成功<em>2016-03-02 16:30</em></span>
									<span>恭喜会员6**8成功投资1000,00元<em>2016-03-02 16:35</em></span>
									<span>恭喜会员9**7注册成功<em>2016-03-02 16:30</em></span>
									<span>恭喜会员6**8成功投资1000,00元<em>2016-03-02 16:35</em></span>
									<span>恭喜会员9**7注册成功<em>2016-03-02 16:30</em></span>
									<span>恭喜会员6**8成功投资1000,00元<em>2016-03-02 16:35</em></span>
									<span>恭喜会员9**7注册成功<em>2016-03-02 16:30</em></span>
									<span>恭喜会员6**8成功投资1000,00元<em>2016-03-02 16:35</em></span>
									<span>恭喜会员9**7注册成功<em>2016-03-02 16:30</em></span>
									<span>恭喜会员6**8成功投资1000,00元<em>2016-03-02 16:35</em></span>
								</div>
								<div id="demo2" class="demo2"></div>
							</div>
						</div>
					</div>
				</div>
				<!-- 公告滚动部分结束 -->
				<!-- 平台特色开始部分 -->
				<div class="feature">
					<ul>
						<li>
							<div>
								<label class="featureImg safeImg"></label>
							</div>
							<div class="featureWord">
								<span class="featureTitle">安全可靠</span>
								<p>银行资金存管</p>
								<p>资金安全无忧</p>
							</div>
						</li>
						<li>
							<div>
								<label class="featureImg riskImg"></label>
							</div>
							<div class="featureWord">
								<span class="featureTitle">风险更小</span>
								<p>第三方总体担保</p>
								<p>加强抗风险能力</p>
							</div>
						</li>
						<li>
							<div>
								<label class="featureImg sampleImg"></label>
							</div>
							<div class="featureWord">
								<span class="featureTitle">简单快捷</span>
								<p>投资周期更短</p>
								<p>快速收回本息</p>
							</div>
						</li>
						<li>
							<div>
								<label class="featureImg operationImg"></label>
							</div>
							<div class="featureWord">
								<span class="featureTitle">运营优异</span>
								<p>成立4年，运营稳健</p>
								<p>贷款70%以上资产抵押</p>
							</div>
						</li>
					</ul>
				</div>
				<!-- 平台特色部分结束 -->
				<!-- 新手体验部分开始 -->
				<div class="newMember" id="newMember">
					<div class="newMemberImg" >
						<label></label>
					</div>
					<div class="newMemberDemo">
						<h5>新型节能环保塑木公司的短期融资</h5>
						<div class="newMemberRow clearfix">
							<div class="sumOfMoney">
								<p>金额</p>
								<p class="sumOfMoneyP"><label class="moneyFormat">7000</label><span>元</span></p>
							</div>
							<div class="verticalLine"></div>
							<div class="yearRate">
								<p>年化</p>
								<p class="sumOfMoneyP yearRateP">16.00<span>%</span></p>
							</div>
							<div class="verticalLine"></div>
							<div class="term">
								<p>期限</p>
								<p class="sumOfMoneyP">7<span>天</span></p>
							</div>
							<div class="verticalLine"></div>
							<div class="character">
								<h3>即投即获息</h3>
							</div>
							<div class="tryNow">
								<button class="taste" onclick="clickUp();">立即体验</button>
							</div>
						</div>
					</div>
				</div>
				<!-- 新手体验部分结束 -->
				<!-- 投资专区开始部分 -->
				<div class="invest" id="invest">
					<div class="investH">
						<span class="investHLeft">
							<label></label>
							投资专区
						</span>
						<span class="indexConHMore" onclick="window.location='invest/investmentZone.html'">更多<label></label></span>
					</div>
					<div class="row">
						<div class="rowContent">
							<div class="invest_content1 preInvest investContFirst"><!--通过 投资前preInvest,投资中inInvest,投资结束aftInvest 三个类名控制各自状态内容的显示与隐藏，默认下内容为显示，如需隐藏，只需将对应状态（preInvest,投资中inInvest,投资结束aftInvest三选一）结合其需隐藏的类名进行控制即可，如要隐藏投资前内容部分的奖励标，只需在css中写: .preInvest .reward{display:none;}即可-->

								<div class="ivestConH">
									<label class="ConHBackground di"></label>
									凯迪拉克RX350抵押借款
								</div>
								<div class="invest_top">
									<div class="invest_content">
										<div class="invest_money">
											<p class="investTitle">项目金额</p>
											<p class="investNum"><span>80.60</span>万</p>
										</div>
										<span class="reward">
									   	 	<img src="resource/img/index/jl.png">投资本金
											<b>0.01%</b>
									    </span>
									</div>
									<div class="investTime">
										<p class="investTitle investTimeT">项目期限</p>
										<p class="investTimeP"><span>45</span>天</p>
									</div>
								</div>
								<div class="investMiddle">
									<p class="investMiddleP1">年化<em>16.20<i>%</i></em></p>
									<span class="invest_span">+1.30%</span>
									<p class="investMiddleP2">
										<label></label> 还款方式：
										<em>先息后本</em>
									</p>
								</div>
								<div class="investOpen">
									<div class="progress_div">
										<div class="progressbar_1"> 
									        <div class="bar"></div> 
									    </div>
										<span class="progress_totle">20%</span>
									</div>
									<p class="openBidTime">开标时间：<em>2016年3月2日 15:00</em></p>
									 <span class="investOpenT" onclick="window.location='invest/investmentDetail.html'">
										<label class="clock clockBlue"></label>
										<span id="endTimeValue-d"></span>
									</span>
									<a class="investBtn" href="invest/investmentDetail.html">立即投资</a>
									<a class="detail" href="invest/investmentDetail.html">查看详情</a>
									<label class="money_ing"></label>
								</div>
							</div>
							<div class="invest_content1 inInvest investContMiddle"><!-- 投资前preInvest,投资中inInvest,投资结束aftInvest 三选一-->
								<div class="ivestConH">
									<label class="ConHBackground dan"></label>
									凯迪拉克RX350抵押借款
								</div>
								<div class="invest_top">
									<div class="invest_content">
										<div class="invest_money">
											<p class="investTitle">项目金额</p>
											<p class="investNum"><span class="moneyFormat">5000</span>元</p>
										</div>
										<span class="reward">
									   	 	<img src="resource/img/index/jl.png">投资本金
											<b>0.01%</b>
									    </span>
									</div>
									<div class="investTime">
										<p class="investTitle investTimeT">项目期限</p>
										<p class="investTimeP"><span>7</span>个月</p>
									</div>
								</div>
								<div class="investMiddle">
									<p class="investMiddleP1">年化<em>14.56<i>%</i></em></p>
									<span class="invest_span">+1.30%</span>
									<p class="investMiddleP2">
										<label></label>还款方式：
										<em>到期还本息</em>
									</p>
								</div>
								<div class="investOpen">
									<div class="progress_div">
										<div class="progressbar_1"> 
									        <div class="bar"></div> 
									    </div>
										<span class="progress_totle">60%</span>
									</div>
									<p class="openBidTime">开标时间：<em>2016年3月2日 15:00</em></p>
									 <span class="investOpenT" onclick="window.location='invest/investmentDetail.html'">
										<label class="clock clockBlue"></label>
										<span></span>
									</span>
									<a class="investBtn" href="invest/investmentDetail.html">立即投资</a>
									<a class="detail" href="invest/investmentDetail.html">查看详情</a>
									<label class="money_ing"></label>
								</div>
							</div>
							<div class="invest_content1 aftInvest investContLast"><!-- 投资前preInvest,投资中inInvest,投资结束aftInvest 三选一-->
								<div class="ivestConH">
									<label class="ConHBackground xin"></label>
									凯迪拉克RX350抵押借款
								</div>
								<div class="invest_top">
									<div class="invest_content">
										<div class="invest_money">
											<p class="investTitle">项目金额</p>
											<p class="investNum"><span>80.00</span>万</p>
										</div>
										<span class="reward">
									   	 	<img src="resource/img/index/jl.png">投资本金
											<b>0.01%</b>
									    </span>
									</div>
									<div class="investTime">
										<p class="investTitle investTimeT">项目期限</p>
										<p class="investTimeP"><span>2</span>年</p>
									</div>
								</div>
								<div class="investMiddle">
									<p class="investMiddleP1">年化<em>14.00<i>%</i></em></p>
									<span class="invest_span">+1.30%</span>
									<p class="investMiddleP2">
										<label></label>还款方式：
										<em>等额本金</em>
									</p>
								</div>
								<div class="investOpen">
									<div class="progress_div">
										<div class="progressbar_1"> 
									        <div class="bar"></div> 
									    </div>
										<span class="progress_totle">20%</span>
									</div>
									<p class="openBidTime">开标时间：<em>2016年3月2日 15:00</em></p>
									 <span class="investOpenT" onclick="window.location='invest/investmentDetail.html'">
										<label class="clock clockBlue"></label>
										<span></span>
									</span>
									<a class="investBtn" href="invest/investmentDetail.html">立即投资</a>
									<a class="detail" href="invest/investmentDetail.html">查看详情</a>
									<label class="money_ing"></label>
								</div>
							</div>
						</div>
					</div>
				</div>
					<!-- 投资专区部分结束 -->
					<!-- 债权转让部分开始 	 -->
				<div class="debt" id="debt">
					<div class="debtH" >
						<span class="debtHLeft">
							<label></label>
							债权转让
						</span>
						<span class="indexConHMore" onclick="window.location='invest/debtCession.html'">更多<label></label></span>
					</div>
					<div class="debtContent">
						<div>
							<ul>
								<li class="debtContentT">
									<div class="debtName">项目名称</div>
									<div class="debtYear debtYearT">预期年化</div>
									<div class="debtMoney">转让金额</div>
									<div class="debtDiscount">转让折扣</div>
									<div class="debtSurplus">剩余期限</div>
									<div class="debtprogress">认购进度</div>
									<div class="debtsetting">操作</div>
								</li>
								<%for(int i = 0;i<3;i++){ %>
								<li class="debtContentM">
									<div class="debtName" title="创业优选项目计划创业优选项目计划创业优选项目计划"><label class="xin"></label>创业优选项目计划
									</div>
									<div class="debtYear">12<span>%+1.30%</span></div>
									<div class="debtMoney"><span class="moneyFormat">30000</span><i>元</i></div>
									<div class="debtDiscount"><span>70</span><i>%</i></div>
									<div class="debtSurplus"><span>72</span><i>天</i></div>
									<div class="debtprogress">
										<span class="investOpen">
											<span class="progress_div">
												<span class="progressbar_1"> 
											        <span class="bar"></span> 
											    </span>
												<span class="progress_totle">60%</span>
											</span> 
										</span>
									</div>
									<div class="debtsetting"><a class="table_operate_buy" href="invest/debtDetail.html">立即购买</a></div>
								</li>
								<%} %>
								<%for(int i = 0;i<2;i++){ %>
								<li class="debtContentM">
									<div class="debtName"  title="创业优选项目计划创业优选项目计划创业优选项目计划"><label class="di"></label>创业优选项目计划
									</div>
									<div class="debtYear">10.60<span>%</span></div>
									<div class="debtMoney"><span class="moneyFormat">30000</span><i>元</i></div>
									<div class="debtDiscount"><span>70</span><i>%</i></div>
									<div class="debtSurplus"><span>72</span><i>天</i></div>
									<div class="debtprogress">
										<span class="investOpen">
											<span class="progress_div">
												<span class="progressbar_1"> 
											        <span class="bar"></span> 
											    </span>
												<span class="progress_totle">24%</span>
											</span> 
										</span>
									</div>
									<div class="debtsetting"><a class="table_operate_zhuan" href="invest/debtDetail.html">转让成功</a></div>
								</li>
								<%} %>
							</ul>
						</div>
					</div>
				</div>
				<!-- 债权转让部分结束 -->
				<!-- 广告banner部分开始 -->
				<div class="ad">
					<label></label>
				</div>
				<!-- 广告banner部分结束 -->
				<!-- 新闻公告理财榜开始 -->
				<div class="secBottom" id="secBottom">
					<div class="secBottomCon1 secBottomZero">
						<div class="secBottomH">
							<div>
								<span class="sec_b_title">新闻动态</span>
								<span class="indexConHMore" onclick="window.location='aboutUs/mediaCoverage.html'">更多<label></label></span>
							</div>
						</div>
						<div>
							<img class="newsImg" src="resource/img/index/meeting_07.jpg">
							<div class="artical_content">
								<div class="artical_main">
									<ul>
										<%for(int j = 0;j<2;j++){ %>
									<li class="clearfix">
										<a href="aboutUs/mediaCoverageDetail.html" target="_blank">
											<label class="noRuleCircle"></label>【环球新闻】合规与创新同合规与创新同合规与创新同</a>
										<span>2016-07-06</span>
									</li>
									<%} %>
									</ul>
								</div>
							</div>
						</div>
					</div>
					<div class="secBottomFirst secBottomCon1">
						<div>
							<span class="sec_b_title">网站公告</span>
							<span class="indexConHMore" onclick="window.location='aboutUs/webBoard.html'">更多<label></label></span>
						</div>
						<div class="artical_content webSite">
							<div class="artical_main">
								<ul>
								<%for(int j = 0;j<5;j++){ %>
									<li class="clearfix">
										<a href="aboutUs/webBoardDetail.html" target="_blank">
											<label class="noRuleCircle"></label>关于汇付天下暂停交通银行网银充关于汇付天下暂停交通银行网银充</a>
										<span>2016-07-06</span>
									</li>
									<%} %>
								</ul>
							</div>
						</div>
					</div>
					<div class="invest_list invest_list3 secBottomCon1">
						<div class="iLtHeader">
							<span class="sec_b_title">投资理财榜</span>
							<div class="ranking_list">
								<span>累计排行</span>
								<span>本月</span>
								<span class="rankingWeekly">本周</span>
							</div>
						</div>
						<%for(int i = 0;i<3;i++){ %>
						<div class="iLtContent">
							<ul>
								<li>
									<div class="rankingName">排名</div>
									<div class="userName">用户名</div>
									<div class="totalInvest">投资金额</div>
								</li>
								<li>
									<div class="rankingImg"><label class="theFirst"></label></div>
									<div>9**8</div>
									<div class="moneyFormat">1220000</div>
								</li>
								<li>
									<div class="rankingImg"><label class="theSecond"></label></div>
									<div>9**8</div>
									<div class="moneyFormat">1220000</div>
								</li>
								<li>
									<div class="rankingImg"><label class="theThird"></label></div>
									<div>9**8</div>
									<div class="moneyFormat">1220000</div>
								</li>
								<li>
									<div><span class="ranking_num">4</span></div>
									<div>2**6</div>
									<div class="moneyFormat">1120568</div>
								</li>
								<li>
									<div><span class="ranking_num">5</span></div>
									<div>2**6</div>
									<div class="moneyFormat">1120568</div>
								</li>
								<li>
									<div><span class="ranking_num">6</span></div>
									<div>2**6</div>
									<div class="moneyFormat">1120568</div>
								</li>
							</ul>
						</div>
						<%} %>
					</div>
				</div>
				<!-- 新闻公告理财榜结束 -->
				<!-- 合作伙伴部分开始 -->
				<div class="indexContFooter" id="indexContFooter">
					<div class="indexConH clearfix">
						<span class="sec_b_title">合作伙伴</span>
						<span class="indexConHMore" onclick="window.location='aboutUs/expertAdvisor.html'">更多<label></label></span>
					</div>
					<div class="partner">
						<div class="divMain-divWindow" id="divMain-divWindow">
							<div>
								<ul class="adv">
									<li>
										<label class="partner_03" onclick="window.location='index.html';"></label>
									</li>
									<li>
										<label class="partner_05" onclick="window.location='index.html';"></label>
									</li>
									<li>
										<label class="partner_07" onclick="window.location='index.html';"></label>
									</li>
									<li>
										<label class="partner_09" onclick="window.location='index.html';"></label>
									</li>
									<li>
										<label class="partner_11" onclick="window.location='index.html';"></label>
									</li>
									<li>
										<label class="partner_13" onclick="window.location='index.html';"></label>
									</li>
									<li>
										<label class="partner_03" onclick="window.location='index.html';"></label>
									</li>
									<li>
										<label class="partner_03" onclick="window.location='index.html';"></label>
									</li>
								</ul>
								<ul></ul>
							</div>
						</div>
						<label class="partL"></label>
						<label class="partR"></label>
					</div>
				</div>
				<!-- 合作伙伴部分结束 -->
				<!-- 左侧边部分开始 -->
				<div class="asideLeft" onselectstart="return false">
					<div class="asideLeftCont">
						<a class="asideLeftCircle asideNewer indexAfter" href="index.html#newMember">新手<br>体验</a>
						<label class="asideLeftLine"></label>
						<a class="asideLeftCircle asideInvest indexAfter" href="index.html#invest">投资<br>专区</a>
						<label class="asideLeftLine"></label>
						<a class="asideLeftCircle asideDebet indexAfter" href="index.html#debt">债权<br>转让</a>
						<label class="asideLeftLine"></label>
						<a class="asideLeftCircle asideNews indexAfter" href="index.html#secBottom">新闻<br>动态</a>
						<label class="asideLeftLine"></label>
						<a class="asideLeftCircle asidePaterner indexAfter" href="index.html#indexContFooter">合作<br>伙伴</a>	
					</div>
				</div>
				<!-- 左侧边部分结束 -->
	<jsp:include page="../common/bottom.jsp"></jsp:include>
	<jsp:include page="../common/aside.jsp"></jsp:include>
	<div class="applyTalent">
   		<div class="apply-top">
   		    <b>￥<span>2.00</span></b>
   		    <br>
   			<label>恭喜您获得<span>2.00</span>元的收益，</label>
   			<br>
   			<span>请到<a href="accountOverview/accountOverview.html">我的账户</a>查看！</span>
   		</div>
   		<div class="apply-bottom">
   			<input type="button" class="btn" value="确定" onclick="layer.closeAll();">
   		</div>
   	</div>
	<script type="text/javascript" src="js/common/countdown.js"></script>
	<script type="text/javascript" src="js/index/index.js"></script>
</body>
</html>