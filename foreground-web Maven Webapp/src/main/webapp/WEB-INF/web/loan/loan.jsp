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
    <title>我要借款</title>
    <jsp:include page="../common/top_meta.jsp"></jsp:include>
    <script type="text/javascript">
    	var publickey = '<%=session.getAttribute("publicKey")%>';
    </script>    
	<link rel="stylesheet" type="text/css" href="css/loan/loan.css">
</head>
<body>
    <jsp:include page="../common/top.jsp"></jsp:include>
   	<jsp:include page="../common/mainPageTop.jsp"></jsp:include>
   	<script type="text/javascript" src="js/common/template.js"></script>
    <!-- 在这里加入页面内容 -->
    <!-- 我要借款静态界面     胥福星     2016-03-27 -->
    <div class="nowPosition">
    	<div class="nowPositionContent">您当前位置 > <a href="index.html">首页</a> > <span>我要借款</span></div>
    </div>
    <div class="mainLoan">
    	<div class="borrow">
    	<!-- 当完成一个步骤时，移除.processStep*类，加.processStep*Success类  -->
		   	<div class="process">
		   		<div class="processStep processStep1"></div>
		   		<p><span class="processSpan">注册实名认证</span></p>
		    </div>
		    <div class="arrow"></div>
		    <div class="process">
		    	<div class="processStep processStep2"></div>
		   		<p><span class="processSpan">开户授权</span></p>
		   	</div>
		    <div class="arrow"></div>
		    <div class="process">
		    	<div class="processStep processStep3"></div>
		   		<p><span class="processSpan">提交默认信息</span></p>
		   	</div>
		    <div class="arrow"></div>
		    <div class="process">
		    	<div class="processStep processStep4"></div>
		   		<p><span class="processSpan">客服联系补全借款默认资料</span></p>
		   	</div>
		    <div class="arrow"></div>
		    <div class="process">
		    	<div class="processStep processStep5"></div>
		   		<p><span class="processSpan">审核通过</span></p>
		   	</div>
		    <div class="arrow"></div>
		    <div class="process">
		    	<div class="processStep processStep6"></div>
		   		<p><span class="processSpan">确认发布筹集借款</span></p>
		   	</div>
		    <div class="arrow"></div>
		    <div class="process">
		    	<div class="processStep processStep7"></div>
		   		<p><span class="processSpan">成功放款</span></p>
		   	</div>
    	</div>
    	<div class="loan">
    		<div class="quickLoan"><span>快速借款</span></div>
    		<div class="prompt"><span>温馨提示：</span>请仔细填写您的真实信息，以便我们及时与你取得联系。</div>
    		<input id="minAmount" value="0" type="hidden"/>
    		<input id="maxAmount" value="0" type="hidden"/>
    		<form class="personInfo" id="personInfo">
    			<div class="inputArea">
	    			<label class="modeSelectL">借款类型</label>
	    			<div class="selectArea selectArea1">
					    <input class="selectValue selectType" value="1" >
					    <input class="selectInput selectInput1" type="text" lang="请选择借款类型" readOnly="true"/>
					    <ul class="select" id="typeSelect" onselectstart="return false">
					        <script id="typeSelectList" type="text/html">
					        {{each data as value index}}
					        	<li class="selectOption selectLi" id="li_{{value.id}}"  value="{{value.id}}" minAmount="{{value.minAmounts}}" maxAmount="{{value.maxAmounts}}"
									tminDaytime="{{value.tminDaytime}}" tmaxDaytime="{{value.tmaxDaytime}}" 
									mminDaytime="{{value.mminDaytime}}" mmaxDaytime="{{value.mmaxDaytime}}"
									yminDaytime="{{value.yminDaytime}}" ymaxDaytime="{{value.ymaxDaytime}}"
									minRates="{{value.minRates}}" maxRates="{{value.maxRates}}" 
									>{{value.projectName}}</li>
					        {{/each}}
							</script>
					    </ul>
					</div>
    			</div>
    			<div class="inputArea">
	    			<label>借款金额</label>
	    			<input class="loanSum" datatype="acountM" type="text" lang="请输入借款金额" maxlength="15"/>
	    			<samp>元</samp>
    			</div>
    			<div class="inputArea">
	    			<label class="modeSelectL">借款期限</label>
	    			<div class="dateSelectDiv">
	    				<input type="text" class="selectDate numberReg" datatype="acountM" lang="请输入借款期限" maxlength="2"/>
	    				<div class="selectArea selectArea2">
		    				<input class="selectValue selectDateUnit" value="1" >
						    <input class="selectInput selectInput1" type="text" lang="月" readOnly="true"/>
						    <ul class="select" onselectstart="return false">
						        <li class="selectOption" value="1">月</li>
						        <li class="selectOption" value="2">天</li>
						        <li class="selectOption" value="3">年</li>
						    </ul>
					    </div>
					</div>
    			</div>
    			<div class="inputArea">
		    		<label>年化利率</label>
		    		<input type="text" class="rate" datatype="acountM" lang="请输入年化利率" maxlength="10"/>
		    		<samp>%</samp>
    			</div>
    			<div class="inputArea">
	    			<label class="modeSelectL">还款方式</label>
	    			<div class="selectArea selectArea1">
	    				<input class="selectValue repaymentMethod" value="0" >
					    <input class="selectInput selectInput1" type="text" lang="等额本息" readOnly="true"/>
					    <ul class="select" onselectstart="return false">
					        <li class="selectOption" value="0">等额本息</li>
					        <li class="selectOption" value="1">先息后本</li>
					        <li class="selectOption" value="2">到期还本付息</li>
					        <li class="selectOption" value="3">等额本金</li>
					    </ul>
					</div>
    			</div>
    			<div class="inputArea">
	    			<label>借款用途</label>
	    			<input class="yongTu" ignore="ignore" type="text" lang="请输入借款用途" maxlength="20"/>
    			</div>
    			<div class="inputArea">
	    			<label>还款来源</label>
	    			<input class="laiYuan" ignore="ignore" type="text" lang="请输入还款来源" maxlength="20"/>
    			</div>
    			<div class="inputArea">
	    			<label>借款描述</label>
	    			<textarea class="input miaoShu" ignore="ignore" lang="请输入借款描述"></textarea>
    			</div>
    			<div>
    				<div class="submit">提交申请</div>
    				<!-- 成功使用clickUp();    失败则使用 clickDown()  -->
    			</div>
    		</form>
    	</div>
    	<div id="productMode" class="loan loan1">
    		<script id="loanList" type="text/html">
			{{each data as value index}}
    		<div class="borrowModeDiv borrowMode1" id="{{value.id}}" >
	    		<div class="borrowMode">
	    			<img src="resource/img/loan/mode2.png" />
	    			<div class="borrowDetail">
	    				<p>{{value.briefIntroduction}}</p>
	    				<a class="more assure" href="javascript:quryDeatail({{value.id}})">查看详情</a>
	    			</div>
	    			<div class="flowTop">
	    				<img src="resource/img/loan/dbd.png" />
	    			</div>
	    			<div class="flowTopHover">
	    				<p>
	    					<span class="span">金额范围：</span>
	    					<span class="priceRange">{{value.minAmount/10000}}-{{value.maxAmount/10000}}万</span>
	    				</p>
	    				<p>
	    					<span class="span">利率范围：</span>
	    					<span>{{value.minRates}}%-{{value.maxRates}}%</span>
	    				</p>
	    				<p>
	    					<span class="span">期限范围：</span>
	    					<span>
							{{value.mminDaytime}}-{{value.mmaxDaytime}}个月,
							{{value.yminDaytime}}-{{value.ymaxDaytime}}年,
							{{value.tminDaytime}}-{{value.tmaxDaytime}}天
							</span>
	    				</p>
	    				<p>
	    					<span class="span">会员限制：</span>
	    					<span>{{if value.applyMember==0}}无限制 {{/if}}
								  {{if value.applyMember==1}}个人会员 {{/if}}
								  {{if value.applyMember==2}}企业会员 {{/if}} 
							</span>
	    				</p>
	    			</div>
	    		</div>
    		</div>	
			{{/each}}				
			</script>
    	</div>
    	<div class="loan" id="guide">
    		<div class="quickLoan">
    			<span class="guideTitle"></span>
    			<a class="back" href="loan/loan.html#productMode">返回类型选择</a>
    		</div>
    		<div class="guideList">
	    		<div class="guideLi">
	    			<span>项目简介</span>
	    			<p class="guideP projectProfile"></p>
	    		</div>
	    		<div class="guideLi">
	    			<span>项目描述</span>
	    			<ul class="guideP">
	    				<li><span>额度范围：</span><samp><font class="projectMinAmount"></font>-<font class="projectMaxAmount"></font>万</samp></li>
	    				<li><span>期限范围：</span> <font class="deadLineRange"></font> </li>
	    				<li><span>利率范围：</span><font class="minRate"></font>%-<font class="maxRate"></font>%</li>
	    				<li><span>会员限制：</span><font class="memLimit"></font> </li>
	    			</ul>
	    		</div>
	    		<div class="guideLi">
	    			<span>准备资料</span>
	    			<p class="material"></p>
	    		</div>
	    		<div class="guideLi">
	    		    <span>申请指南</span>
				    <div class="borrow guideDiv">
						<div class="process guide">
							<div class="guideStep guideStep1"></div>
						    <p><span class="processSpan">注册帐户</span></p>
						</div>
						<div class="arrow2"></div>
				    	<div class="process guide">
				    		<div class="guideStep guideStep2"></div>
					   		<p><span class="processSpan">实名认证</span></p>
					    </div>
					    <div class="arrow2"></div>
					   	<div class="process guide">
					   		<div class="guideStep guideStep3"></div>
					   		<p><span class="processSpan">我的帐户</span></p>
					    </div>
					    <div class="arrow2"></div>
					   	<div class="process guide">
					   		<div class="guideStep guideStep4"></div>
					   		<p><span class="processSpan">借款管理</span></p>
					    </div>
					    <div class="arrow2"></div>
					   	<div class="process guide">
					   		<div class="guideStep guideStep5"></div>
					   		<p><span class="processSpan">我要借款</span></p>
					    </div>
					    <div class="arrow2"></div>
					   	<div class="process guide">
					   		<div class="guideStep guideStep6"></div>
					   		<p><span class="processSpan">填写借款信息</span></p>
					    </div>
					    <div class="arrow2"></div>
					   	<div class="process guide">
					   		<div class="guideStep guideStep7"></div>
					   		<p><span class="processSpan">平台审核</span></p>
					    </div>
					    <div class="arrow2"></div>
					   	<div class="process guide">
					   		<div class="guideStep guideStep8"></div>
					    	<p><span class="processSpan">筹集借款</span></p>
					    </div>
					    <div class="arrow2"></div>
					    <div class="process guide">
					    	<div class="guideStep guideStep9"></div>
					    	<p><span class="processSpan">获得借款</span></p>
					    </div>
		    		</div>
	    		</div>
	    		<div class="guideLi">
	    		    <span>还款指南</span>
					<div class="borrow guideDiv">
						<div class="process guide">
							<div class="backGuideStep backGuideStep1"></div>
						    <p><span class="processSpan processSpan2">我的帐户</span></p>
						</div>
						<div class="arrow2"></div>
						<div class="process guide">
							<div class="backGuideStep backGuideStep2"></div>
					    	<p><span class="processSpan processSpan2">借款管理</span></p>
					    </div>
					    <div class="arrow2"></div>
					    <div class="process guide">
					    	<div class="backGuideStep backGuideStep3"></div>
					    	<p><span class="processSpan processSpan2">还款管理</span></p>
					    </div>
					    <div class="arrow2"></div>
					    <div class="process guide">
					    	<div class="backGuideStep backGuideStep4"></div>
					    	<p><span class="processSpan processSpan2">还款中的借款</span></p>
					    </div>
					    <div class="arrow2"></div>
					    <div class="process guide">
					    	<div class="backGuideStep backGuideStep5"></div>
					    	<p><span class="processSpan processSpan2">还款</span></p>
					    </div>
			    	</div>
	    		</div>
	    		<div class="applyDiv"><a href="loan/loan.html#personInfo" class="apply">立即申请</a></div>
    		</div>
    	</div>
    </div>
    <div class="applyTalent">
   		<div class="apply-top">
   			<label>您的申请已经成功提交！</label>
   			<br>
   			<span>我们将很快进行审核！</span>
   		</div>
   		<div class="apply-bottom">
   			<input type="button" class="btn" value="确定" onclick="closePlate(2)">
   		</div>
   	</div>
    <div class="applyTalent2">
   		<div class="apply-top">
   			<label>抱歉，提交失败！</label>
   			<br>
   			<span>请重新检查您的借款申请！</span>
   		</div>
   		<div class="apply-bottom">
   			<input type="button" class="btn" value="确定" onclick="closePlate(1)">
   		</div>
   	</div>
   	<jsp:include page="../common/bottom.jsp"></jsp:include>
	<script type="text/javascript" src="js/loan/loan.js"></script>
	<script type="text/javascript" src="js/common/valid.js"></script>
</body>
</html>