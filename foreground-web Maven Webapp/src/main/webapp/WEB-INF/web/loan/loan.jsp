<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN">
<html>
<head>
    <title>我要借款</title>
    <jsp:include page="/web/common/top_meta.jsp"></jsp:include>
	<link rel="stylesheet" type="text/css" href="css/loan/loan.css">
</head>
<body>
    <jsp:include page="/web/common/top.jsp"></jsp:include>
   	<jsp:include page="/web/common/mainPageTop.jsp"></jsp:include>
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
    		<form class="personInfo" id="personInfo">
    			<div class="inputArea">
	    			<label class="modeSelectL">借款类型</label>
	    			<div class="selectArea selectArea1">
					    <input class="selectValue" value="1" >
					    <input class="selectInput selectInput1" type="text" lang="请选择借款类型" readOnly="true"/>
					    <ul class="select" onselectstart="return false">
					        <li class="selectOption" value="1">担保贷</li>
					        <li class="selectOption" value="2">信用贷</li>
					        <li class="selectOption" value="3">抵押贷</li>
					    </ul>
					</div>
    			</div>
    			<div class="inputArea">
	    			<label>借款金额</label>
	    			<input class="format loanSum" type="text" lang="请输入借款金额" maxlength="10"/>
	    			<samp>元</samp>
    			</div>
    			<div class="inputArea">
	    			<label class="modeSelectL">借款期限</label>
	    			<input type="text" class="selectDate numberReg" lang="请输入借款期限" maxlength="2"/>
	    			<div class="selectArea selectArea2">
	    				<input class="selectValue" value="1" >
					    <input class="selectInput selectInput1" type="text" lang="月" readOnly="true"/>
					    <ul class="select" onselectstart="return false">
					        <li class="selectOption" value="1">月</li>
					        <li class="selectOption" value="2">天</li>
					        <li class="selectOption" value="3">年</li>
					    </ul>
					</div>
    			</div>
    			<div class="inputArea">
		    		<label>年化利率</label>
		    		<input type="text" class="rate" lang="请输入年化利率" maxlength="10"/>
		    		<samp>%</samp>
    			</div>
    			<div class="inputArea">
	    			<label class="modeSelectL">还款方式</label>
	    			<div class="selectArea selectArea1">
	    				<input class="selectValue" value="1" >
					    <input class="selectInput selectInput1" type="text" lang="等额本金" readOnly="true"/>
					    <ul class="select" onselectstart="return false">
					        <li class="selectOption" value="1">等额本金</li>
					        <li class="selectOption" value="2">等额本息</li>
					        <li class="selectOption" value="3">先息后本</li>
					        <li class="selectOption" value="4">到期还本付息</li>
					    </ul>
					</div>
    			</div>
    			<div class="inputArea">
	    			<label>借款用途</label>
	    			<input type="text" lang="请输入借款用途" maxlength="20"/>
    			</div>
    			<div class="inputArea">
	    			<label>还款来源</label>
	    			<input type="text" lang="请输入还款来源" maxlength="20"/>
    			</div>
    			<div class="inputArea">
	    			<label>借款描述</label>
	    			<textarea class="input" lang="请输入借款描述"></textarea>
    			</div>
    			<div>
    				<div class="submit">提交申请</div>
    			</div>
    		</form>
    	</div>
    	<div id="productMode" class="loan loan1">
    		<div class="borrowModeDiv">
	    		<div class="borrowMode">
	    			<img src="resource/img/loan/mode1.png" />
	    			<div class="borrowDetail">
	    				<p>信用贷款是为政府公务员、事业单位员工、个体户主、企业高管、白领阶层等量身定制的一款借款产品。帮助满足个人消费需求，提高生活品质。</p>
	    				<a class="more credit" href="#guide">查看详情</a>
	    			</div>
	    			<div class="flowTop">
	    				<img src="resource/img/loan/xyd.png" />
	    			</div>
	    			<div class="flowTopHover">
	    				<p>
	    					<span class="span">金额范围：</span>
	    					<span class="priceRange">0-30万</span>
	    				</p>
	    				<p>
	    					<span class="span">利率范围：</span>
	    					<span>10.00%-18.00%</span>
	    				</p>
	    				<p>
	    					<span class="span">期限范围：</span>
	    					<span>1-12个月</span>
	    				</p>
	    				<p>
	    					<span class="span">会员限制：</span>
	    					<span>个人会员、企业会员</span>
	    				</p>
	    			</div>
	    		</div>
    		</div>
    		<div class="borrowModeDiv borrowMode1">
	    		<div class="borrowMode">
	    			<img src="resource/img/loan/mode2.png" />
	    			<div class="borrowDetail">
	    				<p>担保贷是为小微企业、个人等打造的一款借款产品。帮助资金周转等燃眉之急。</p>
	    				<a class="more assure" href="#guide">查看详情</a>
	    			</div>
	    			<div class="flowTop">
	    				<img src="resource/img/loan/dbd.png" />
	    			</div>
	    			<div class="flowTopHover">
	    				<p>
	    					<span class="span">金额范围：</span>
	    					<span class="priceRange">0-30万</span>
	    				</p>
	    				<p>
	    					<span class="span">利率范围：</span>
	    					<span>10.00%-18.00%</span>
	    				</p>
	    				<p>
	    					<span class="span">期限范围：</span>
	    					<span>1-12个月</span>
	    				</p>
	    				<p>
	    					<span class="span">会员限制：</span>
	    					<span>个人会员、企业会员</span>
	    				</p>
	    			</div>
	    		</div>
    		</div>
    		<div class="borrowModeDiv borrowMode1">
	    		<div class="borrowMode">
	    			<img src="resource/img/loan/mode3.png" />
	    			<div class="borrowDetail">
	    				<p>信用贷款是为政府公务员、事业单位员工、个体户主、企业高管、白领阶层等量身定制的一款借款产品。帮助满足个人消费需求，提高生活品质。</p>
	    				<a class="more guaranty" href="#guide">查看详情</a>
	    			</div>
	    			<div class="flowTop">
	    				<img src="resource/img/loan/dyd.png" />
	    			</div>
	    			<div class="flowTopHover">
	    				<p>
	    					<span class="span">金额范围：</span>
	    					<span class="priceRange">0-30万</span>
	    				</p>
	    				<p>
	    					<span class="span">利率范围：</span>
	    					<span>10.00%-18.00%</span>
	    				</p>
	    				<p>
	    					<span class="span">期限范围：</span>
	    					<span>1-12个月</span>
	    				</p>
	    				<p>
	    					<span class="span">会员限制：</span>
	    					<span>个人会员、企业会员</span>
	    				</p>
	    			</div>
	    		</div>
    		</div>
    	</div>
    	<div class="loan" id="guide">
    		<div class="quickLoan">
    			<span class="guideTitle">信用贷</span>
    			<a class="back" href="#productMode">返回类型选择</a>
    		</div>
    		<div class="guideList">
	    		<div class="guideLi">
	    			<span>项目简介</span>
	    			<p class="guideP">信用贷是为政府公务员、事业单位员工、个体户主、企业高管、白领阶层等量身定制的一款借款产品。帮助满足个人消费需求，提高生活品质。</p>
	    		</div>
	    		<div class="guideLi">
	    			<span>项目描述</span>
	    			<ul class="guideP">
	    				<li><span>额度范围：</span><samp>0-30万</samp></li>
	    				<li><span>期限范围：</span>1-12个月</li>
	    				<li><span>利率范围：</span>10.00%-18.00%</li>
	    				<li><span>会员限制：</span>个人会员</li>
	    			</ul>
	    		</div>
	    		<div class="guideLi">
	    			<span>准备资料</span>
	    			<p class="material"><span>身份证认证</span>+<span>征信认证</span>+<span>户籍认证</span>+<span>住址认证</span>+<span>婚姻认证</span>+<span>银行流水认证</span>+<span>户籍认证</span>+<span>住址认证</span>+<span>婚姻认证</span>+<span>银行流水认证</span></p>
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
	    		<div class="applyDiv"><a href="#personInfo" class="apply">立即申请</a></div>
    		</div>
    	</div>
    </div>
   	<jsp:include page="/web/common/bottom.jsp"></jsp:include>
	<script type="text/javascript" src="js/loan/loan.js"></script>
</body>
</html>