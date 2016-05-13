<%@ page language="java" import="java.util.*,product_p2p.kit.Upload.FtpClientUtil" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String attachPrefix=FtpClientUtil.getFtpFilePath();		
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="<%=basePath%>">
    <title>首页</title>
    <jsp:include page="../common/top_meta.jsp"></jsp:include>
    <script type="text/javascript">
    	var publickey = '<%=session.getAttribute("publicKey")%>';
    	var attachPrefix="<%=attachPrefix%>";
    </script>    
	<link rel="stylesheet" type="text/css" href="css/index/index.css">
	<script type="text/javascript" src="js/common/template.js"></script>
</head>
<body>
    <jsp:include page="../common/top.jsp"></jsp:include>
   	<jsp:include page="../common/mainPageTop.jsp"></jsp:include>
   	<div class="banner_div">
    <div class="banner">
		<ul id="banner_ul">
			<script id="bannerList" type="text/html">
				{{each data as value index}}
				<li>
					<div class="bannerImg"><img src="<%=attachPrefix%>{{value.url}}"></div>
				</li>
				{{/each}}
			</script>
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
									<em class="countmember"></em>人
								</i>
								<i class="totalVip">累计会员</i>
						</span>
						</div>
						<div class="float_content">
							<div class="float_left">
								<img src="resource/img/index/ych.png">
							</div>
							<div class="float_right float_u">
								<i><em class="totalLoanAmounts">0</em>元</i>
								<i class="floatCMoney">已撮合资金</i>
							</div>
						</div>
						<div class="float_content">
							<div class="float_left">
								<img src="resource/img/index/tzrzq.png">
							</div>
							<div class="float_right float_u">
								<i><em class="incomeTotals">0</em>元</i>
								<i class="floatCMoney">为投资人赚取</i>
							</div>
						</div>
						<div class="float_content">
							<div class="float_left">
								<img src="resource/img/index/ptfx.png">
							</div>
							<div class="float_right float_u">
								<i><em class="riskReserveFunds">0</em>元</i>
								<i class="floatCMoney">平台风险备付金</i>
							</div>
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
									<script id="broadcastList" type="text/html">
          								{{each data as value index}}
										<span>{{value.content}}<em>{{value.recordDate}}</em></span>
										{{/each}}
									</script>
								</div>
								<div id="demo2" class="demo2"></div>
							</div>
						</div>
					</div>
				</div>
				<!-- 公告滚动部分结束 -->
				<!-- 平台特色开始部分 -->
				<div class="feature">
					<ul id="PlatformBooth">
					<script id="PlatformBoothList" type="text/html">
					   {{each data as value index}}
						<li>
							<div>
								<label class="featureImg safeImg" style="background:url(<%=attachPrefix%>{{value.sgPic}}) no-repeat" ></label>
							</div>
							<div class="featureWord">
								<span class="featureTitle">{{value.asTitle}}</span>
								{{#value.sgContent}}
							</div>
						</li>
						{{/each}}
					</script>
					</ul>
				</div>
				<!-- 平台特色部分结束 -->
				<!-- 新手体验部分开始 -->
				<div class="newMember" id="newMemberL">
					<script id="newMemberList" type="text/html">
						<div class="newMemberImg" >
							<label></label>
						</div>
						<div class="newMemberDemo">
							<h5>{{data.experienceName}}</h5>
							<div class="newMemberRow clearfix">
								<div class="sumOfMoney">
									<p>金额</p>
									<p class="sumOfMoneyP"><label class="moneyFormat">{{data.vouchersAmounts}}</label><span>元</span></p>
								</div>
								<div class="verticalLine"></div>
								<div class="yearRate">
									<p>年化</p>
									<p class="sumOfMoneyP yearRateP">{{data.yearRates}}<span>%</span></p>
								</div>
								<div class="verticalLine"></div>
								<div class="term">
									<p>期限</p>
									<p class="sumOfMoneyP">
										{{if data.deadlineType==0}}
											{{value.deadline}}<span>天</span>
										{{/if}}
										{{if data.deadlineType==1}}
											{{data.deadline}}<span>个月</span>
										{{/if}}
										{{if data.deadlineType==2}}
											{{data.deadline}}<span>年</span>
										{{/if}}
									</p>
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
					</script>
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
						<div class="rowContent" id="investL">
<!-- 							<div class="invest_content1 preInvest investContFirst">通过 投资前preInvest,投资中inInvest,投资结束aftInvest 三个类名控制各自状态内容的显示与隐藏，默认下内容为显示，如需隐藏，只需将对应状态（preInvest,投资中inInvest,投资结束aftInvest三选一）结合其需隐藏的类名进行控制即可，如要隐藏投资前内容部分的奖励标，只需在css中写: .preInvest .reward{display:none;}即可
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
							</div> -->
							<script id="investList" type="text/html">
								{{each data as value index}}
								<div class="invest_content1 inInvest  
									{{if index==0}}
									investContFirst
									{{/if}}
									{{if index==1}}
									investContMiddle
									{{/if}}
									{{if index==2}}
									investContLast
									{{/if}}
									"><!-- 投资前preInvest,投资中inInvest,投资结束aftInvest 三选一-->
									<div class="ivestConH">
										<label class="ConHBackground dan" style="background:url("<%=attachPrefix%>{{value.picIcon}}") no-repeat" ></label>
										{{value.projectBaseInfoentity.projectTitle}}
									</div>
									<div class="invest_top">
										<div class="invest_content">
											<div class="invest_money">
												<p class="investTitle">项目金额</p>
												<p class="investNum"><span class="moneyFormat">{{value.projectBaseInfoentity.amount/100}}</span>元</p>
											</div>
											{{if value.rewardRates>0}}
											<span class="reward">
										   	 	<img src="resource/img/index/jl.png">投资本金
												<b>{{value.rewardRates}}%</b>
										    </span>
											{{/if}}
										</div>
										<div class="investTime">
											<p class="investTitle investTimeT">项目期限</p>
											<p class="investTimeP">
											{{if value.projectBaseInfoentity.deadlineType==0}}
											<span>{{value.projectBaseInfoentity.deadline}}</span>天
											{{/if}}
											{{if value.projectBaseInfoentity.deadlineType==1}}
											<span>{{value.projectBaseInfoentity.deadline}}</span>个月
											{{/if}}
											{{if value.projectBaseInfoentity.deadlineType==2}}
											<span>{{value.projectBaseInfoentity.deadline}}</span>年
											{{/if}}
											</p>
										</div>
									</div>
									<div class="investMiddle">
										<p class="investMiddleP1">年化<em>{{value.projectBaseInfoentity.yearRates}}<i>%</i></em></p>
										{{if value.rateAddRates>0}}
										<span class="invest_span">+{{value.rateAddRates}}%</span>
										{{/if}}
										<p class="investMiddleP2">
											<label></label>还款方式：
											<em>
											{{if value.projectBaseInfoentity.repayWay==0}}
												等额本息
											{{/if}}
											{{if value.projectBaseInfoentity.repayWay==1}}
												每月还息，到期还本
											{{/if}}
											{{if value.projectBaseInfoentity.repayWay==2}}
												到期还息本
											{{/if}}
											{{if value.projectBaseInfoentity.repayWay==3}}
												等额本金
											{{/if}}
											</em>
										</p>
									</div>
									<div class="investOpen">
										<div class="progress_div investPro">
											<div class="progressbar_1 invest_progress_1"  > 
										        <div class="bar" style="width:{{value.investRates}}%"></div> 
										    </div>
											<span class="progress_totle">{{value.investRates}}%</span>
										</div>
										{{if value.investStatu==1}}
										<p class="openBidTime">开标时间：<em>2016年3月2日 15:00</em></p>
										 <span class="investOpenT" onclick="window.location='invest/investmentDetail.html'">
											<label class="clock clockBlue"></label>
											<span></span>
										</span>
										{{/if}}
										{{if value.investStatu==2}}
											<a class="investBtn" href="invest/investmentDetail.html">立即投资</a>
										{{/if}}
										{{if value.investStatu>2}}
										<a class="detail" href="invest/investmentDetail.html">查看详情</a>
										{{/if}}
										{{if value.investStatu==5}}
										<label class="money_over"></label>
										{{/if}}
										{{if value.investStatu==3}}
										<label class="money_ing"></label>
										{{/if}}
										{{if value.investStatu==4}}
										<label class="money_end"></label>
										{{/if}}
									</div>
								</div>
								{{/each}}
							</script>
<!-- 							<div class="invest_content1 aftInvest investContLast">投资前preInvest,投资中inInvest,投资结束aftInvest 三选一
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
							</div> -->
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
							<ul id="transfer">
								<script id="transferList" type="text/html">
									<li class="debtContentT">
										<div class="debtName">项目名称</div>
										<div class="debtYear debtYearT">预期年化</div>
										<div class="debtMoney">转让金额</div>
										<div class="debtDiscount">转让折扣</div>
										<div class="debtSurplus">剩余期限</div>
										<div class="debtprogress">认购进度</div>
										<div class="debtsetting">操作</div>
									</li>
									{{each data as value index}}
									<li class="debtContentM">
										<div class="debtName" title="{{value.projectTitle}}"><label class="xin" style="background:url("<%=attachPrefix%>{{value.picIcon}}") no-repeat" ></label>{{value.projectTitle}}
										</div>
										<div class="debtYear">{{value.expectYearrates}}<span>%
										{{if value.rateAddRates>0}}
										+{{value.rateAddRates}}%
										{{/if}}
										</span></div>
										<div class="debtMoney"><span class="moneyFormat">{{value.transPrincipals}}</span><i>元</i></div>
										<div class="debtDiscount"><span>{{value.transDiscounts}}</span><i>%</i></div>
										<div class="debtSurplus"><span>{{value.surplusTime}}</span>
										{{if value.surplusTimeType==0}}
										<i>天</i>
										{{/if}}
										{{if value.surplusTimeType==1}}
										<i>个月</i>
										{{/if}}
										{{if value.surplusTimeType==2}}
										<i>年</i>
										{{/if}}
										</div>
										<div class="debtprogress">
											<span class="investOpen">
												<span class="progress_div">
													<span class="progressbar_1"> 
												        <span class="bar" style="width:{{value.ctaInvestRates}}%"></span> 
												    </span>
													<span class="progress_totle">{{value.ctaInvestRates}}%</span>
												</span> 
											</span>
										</div>
										{{if value.transStatu==0}}
										<div class="debtsetting"><a class="table_operate_buy" href="invest/debtDetail.html">立即购买</a></div>
										{{/if}}
										{{if value.transStatu>0}}
										<div class="debtsetting"><a class="table_operate_zhuan" href="invest/debtDetail.html">转让成功</a></div>
										{{/if}}
									</li>
									{{/each}}
								</script>
<%-- 								<%for(int i = 0;i<2;i++){ %>
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
								<%} %> --%>
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
							<div class="artical_content artical_content_u ">
								<div class="artical_main">
									<ul id="mediaReports">
									<script id="mediaReportsList" type="text/html">	
									{{each data as value index}}
									<li class="clearfix indexMediaLi">
										<a href="aboutUs/mediaCoverageDetail.html" target="_blank">
											<label class="noRuleCircle"></label>{{value.title}}</a>
										<span>{{value.createTime}}</span>
									</li>
									{{/each}}
									</script>	
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
								<ul id="announcement">
								<script id="announcementList" type="text/html">
								{{each data as value index}}
									<li class="clearfix">
										<a href="{{value.id}}" target="_blank">
											<label class="noRuleCircle"></label>{{value.title}}</a>
										<span>{{value.createTime}}</span>
									</li>
								{{/each}}
								</script>
								</ul>
							</div>
						</div>
					</div>
					<div class="invest_list invest_list3 secBottomCon1">
						<div class="iLtHeader">
							<span class="sec_b_title">投资理财榜</span>
							<div class="ranking_list">
								<span class="rankingWeekly" id="0">累计排行</span>
								<span id="1">本月</span>
								<span id="2" >本周</span>
							</div>
						</div>
						<div class="iLtContent">
							<ul id="investRecord">
							   <script id="investRecordList" type="text/html">
								<li>
									<div class="rankingName">排名</div>
									<div class="userName">用户名</div>
									<div class="totalInvest">投资金额</div>
								</li>
								{{each data as value index}}
								<li>
									<div class="rankingImg">
										{{if index==0}}<label class="theFirst"></label>{{/if}}
										{{if index==1}}<label class="theSecond"></label>{{/if}}
										{{if index==2}}<label class="theThird"></label>{{/if}}
									</div>
									<div>{{value.logname.substring(0,2)+"****"+value.logname.substring(value.logname.length-1,value.logname.length)}}</div>
									<div class="moneyFormat">{{value.investAmount}}</div>
								</li>
								{{/each}}
							    </script>
							</ul>
						</div>
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
								<ul class="adv" id="partners">
									<script id="partnersList" type="text/html">
									{{each data as value index}}
									<li>
										<label class="partner_03" style="background:url(<%=attachPrefix%>{{value.logo}}) center no-repeat " onclick="window.location='{{value.url}}';"></label>
									</li>
									{{/each}}
									</script>
								</ul>
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
	<script type="text/javascript" src="js/index/index_data.js"></script>
</body>
</html>