<%@ page language="java" import="java.util.*,product_p2p.kit.Upload.FtpClientUtil" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String attachPrefix=FtpClientUtil.getFtpFilePath();		
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN">
<html>
<head>
	<base href="<%=basePath%>">
    <title>好友管理</title>
    <jsp:include page="../../common/top_meta.jsp"></jsp:include>
    <script type="text/javascript">
    	var baseUrl = '<%=basePath%>';
    	var publickey = '<%=session.getAttribute("publicKey")%>';
    </script>
	<link rel="stylesheet" type="text/css" href="css/account/account.css">
	<link rel="stylesheet" href="plugs/pager/pager_def.css" type="text/css">
	<link rel="stylesheet" type="text/css" href="css/account/personalCenter/friendManagement.css">
	<script type="text/javascript" src="http://img3.job1001.com/js/ZeroClipboard/jquery.zclip.min.js"></script> 
	<script type="text/javascript" src="js/common/template.js"></script>	
</head>
<body> 
    <jsp:include page="../../common/top.jsp"></jsp:include>
   	<jsp:include page="../../common/mainPageTop.jsp"></jsp:include>
   	<div class="main">
   		<div class="clearfix">
		   	<jsp:include page="../../account/accountCommonLeft.jsp"></jsp:include>
   			<div class="accountRight">
			   	<jsp:include page="../../account/accountCommonRightTop.jsp"></jsp:include>
   				<div class="accountMain clearfix">
   				<!-- 在此处写入代码 -->
   				<!--伍成然2016-4-1  -->
	   				<ul class="tab-head">
						<li class="tab-li tab-ing friend-invite">好友邀请</li>
						<li class="tab-li my-friends">我的好友</li>
					</ul>
					<div class="tab-content">
						<div class="c-content content-active">
							<div class="share-box">
								<div class="copy-share">
									<img src="resource/img/account/personalCenter/grzx_9.png">
									<div class="text">
									四象金融，国资互联网金融在线投资理财平台，50元起投，享受10%-15%的稳定安全高额的年化收益；<br>
									<span>会员邀请码：</span><span class="code">15626589563</span><br>
									<span>网址：</span><span id="su" class="url">www.xhx-qjd.com/registerAfter_15926589663.html</span>
									<input id="dn" class="dn" value="www.xhx-qjd.com/registerAfter_15926589663.html">
									<div id="cu" class="copy">复制链接</div>								 
									</div>
								</div>
								<div class="share-method">
									<div class="share-remind">分享有礼</div>
									<div class="QQ"></div>
									<div class="WeChat"></div>
									<div class="Qzone"></div>
									<div class="Weibo"></div>
									<div class="Tencent"></div>
								</div>
							</div>
							<div class="list-name">列表信息</div>
							<ul class="my-integral-table" id="friend">
			   					<script id="friendList" type="text/html">
			   						<li>
			   						<div class="contentOut1">
										<div class="content1">
											用户名
										</div>
									</div>
									<div class="contentOut1">
										<div class="content1">
											手机号
										</div>
									</div>
									<div class="contentOut1">
										<div class="content1">
											注册时间
										</div>
									</div>
									<div class="contentOut1">
										<div class="content1">
											开通第三方时间
										</div>
									</div>
			   						</li>
									{{each results as value index}}
				   					<li>
				   						<div class="contentOut1">
											<div class="content1">
												{{value.logname}}
											</div>
										</div>
										<div class="contentOut1">
											<div class="content1">
												{{value.baseInfo.personalPhone.substring(0,3)+"****"+value.baseInfo.personalPhone.substring(value.baseInfo.personalPhone.length-4,value.baseInfo.personalPhone.length)}}
											</div>
										</div>
										<div class="contentOut1">
											<div class="content1">
												{{value.sRegDate}}
											</div>
										</div>
										<div class="contentOut1">
											<div class="content1">
												{{value.sRcordDate}}
											</div>
										</div>					
				   					</li>
									{{/each}}
				   				</script>
		   					</ul>
		   					<div id="pager"></div>
						</div>
						<div class="c-content">
							<div class="friend-deal">
								<input type="button" class="unprocessed" value="未处理申请">
								<input type="button" class="add-friends" value="添加好友">
							</div>
							<div class="input-group">
								<span>查询好友:</span>
								<input type="text" lang="输入好友用户名/姓名/手机号" class="serch-input" maxlength="20">
								<input type="button" value="查询" class="search-btn btn">	
							</div>										
							<ul class="my-integral-table" id="frindLine" >
							<script id="frindLineList" type="text/html">
			   					<li>
			   						<div class="contentOut2">
										<div class="content1">
											用户名
										</div>
									</div>
									<div class="contentOut3">
										<div class="content1">
											成为好友时间
										</div>
									</div>
									<div class="contentOut2">
										<div class="content1">
											操作
										</div>
									</div>												
			   					</li>
			   					{{each results as value index}}
			   					<li>
			   						<div class="contentOut2">
										<div class="content1">
											{{value.userName}}
										</div>
									</div>
									<div class="contentOut3">
										<div class="content1">
											{{value.addTime}}
										</div>
									</div>
									<div class="contentOut2">
										<div class="content1">
											<div class="transferDiv " onclick="friendTransfer('{{value.friendId}}','{{value.userName}}');">
												<div class="transferBtn">转账</div>
												<input type="hidden" class="friendId" value="{{value.id}}">
												<input type="hidden" class="friendName" value="{{value.userName}}">
											</div>
											<div class="delete-deal">删除</div>
										</div>
									</div>																				
			   					</li>
								{{/each}}
			   					</script>
		   					</ul> 
		   					<div id="pager1"></div>
						</div>
					</div>   				
   				</div>
   			</div>
   		</div>
   	</div>
   	<jsp:include page="../../common/bottom.jsp"></jsp:include>
   	<!-- 弹出层 -->
   	<div class="undeal">
   		<ul class="undeal-info" id="undeal" >
   			<script id="undealList" type="text/html">
			<li>
				<div class="contentOut5">
					<div class="content1">
						用户名
					</div>
				</div>
				<div class="contentOut5">
					<div class="content1">
						申请时间
					</div>
				</div>
				<div class="contentOut5">
					<div class="content1">
						操作
					</div>
				</div>				
			</li>
			{{each results as value index}}
			{{if value.type==1}}
			<li>
				<div class="contentOut5">
					<div class="content1">
						{{value.userName}}
					</div>
				</div>
				<div class="contentOut5">
					<div class="content1">
						{{value.addTime}}
					</div>
				</div>
				<div class="contentOut5">
					<div class="content1">
						等待对方确认...
					</div>
				</div>				
			</li>
			{{/if}}
			{{if value.type==0}}
			<li>
				<div class="contentOut5">
					<div class="content1">
						{{value.userName}}
					</div>
				</div>
				<div class="contentOut5">
					<div class="content1">
						{{value.addTime}}
					</div>
				</div>
				<div class="contentOut5">
					<div class="content1">
						<div class="agree" id="{{value.friendId}}" >同意加为好友</div>
					</div>
				</div>				
			</li>
			{{/if}}
			{{/each}}
			</script>
		</ul>
		<div class="pageTab">
			<div class="pageBefore"></div>
			<div class="pageAfter1"></div>
		</div>	
   	</div>
   	<div class="addFriends">
   		<div class="input-group1">
   			<input type="text" class="inputFriend" value="用户名/姓名/手机号" maxlength="20"
			onFocus="if(value==defaultValue){value='';this.style.color='#000';}" 
			onBlur="if(!value){value=defaultValue;this.style.color='#bfbfbf';}" 
			style="color:#bfbfbf">
			<div class="search">查找</div>
   		</div>
   		<ul id="strange">
   		<script id="strangeList" type="text/html">	
			{{each results as value index}}
   			<li>
   				<div class="contentOut6">
   				<div class="content2">
   					<div class="photo">
						{{if value.path==null}}
   							<img src="resource/img/account/personalCenter/touxiang.png">
						{{/if}}
						{{if value.path!=null}}
   							<img src="<%=attachPrefix%>{{value.path}}">
						{{/if}}
   					</div>
   				</div>			
   				</div>
   				<div class="contentOut7">
	   				<div class="content3 info">
	   					{{value.logname}}<br>
	   					{{value.personalPhone}}
	   				</div>
   				</div>
   				<div class="contentOut8">
   					<div class="content2">
	   					<div class="add" id="{{value.memberId}}" >
	   						加为好友
	   					</div>
   					</div>
   				</div>
   			</li>
			{{/each}}
		</script>	
   		</ul>
   	</div>
	<script type="text/javascript" src="js/account/account.js"></script>
	<script type="text/javascript" charset="utf-8" src="plugs/pager/pager.js"></script>
	<script type="text/javascript" src="js/account/personalCenter/friendManagement.js"></script>
	<script type="text/javascript" src="js/account/personalCenter/friendManagement_data.js"></script>
</body>
</html>