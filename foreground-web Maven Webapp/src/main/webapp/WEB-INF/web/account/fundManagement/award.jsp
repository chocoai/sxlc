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
    <title>赠送奖励</title>
    <jsp:include page="../../common/top_meta.jsp"></jsp:include>
    <script type="text/javascript">
    	var publickey = '<%=session.getAttribute("publicKey")%>';
    </script>
	<link rel="stylesheet" type="text/css" href="css/account/account.css">
	<link rel="stylesheet" type="text/css" href="css/account/fundManagement/award.css">
	<link rel="stylesheet" href="plugs/pager/pager_def.css" type="text/css">
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
   				<!-- 李丽梅 -->
   				<!-- 资金管理-奖励设置-我的红包 -->
   				<!-- 2016-3-31 -->
					<ul class="awardHead">
						<li class="awardHeadLi1  awardIng">我的红包</li>
						<li class="awardHeadLi2">我的电子劵</li>
					</ul>
					<div class="tabContent">
	   					<div class="awardContent contentActive">
		   					<div class="awardBackground">
		   						<div class="awardDivAll awardRed">
		   							<p>领取总额(元)</p>
		   							<b class="moneyFormat2" id="sRedPackageSum">0</b>
		   						</div>
		   						<div class="awardDivAll awardExpired">
		   							<p>已过期总额</p>
		   							<b class="moneyFormat2" id="sExpiredSum">0</b>
		   						</div>
		   						<div class="awardDivAll awardAlreadyUsed">
		   							<p>已使用总额(元)</p>
		   							<b class="moneyFormat2" id="sUseRedPackageSum">0</b>
		   						</div>
		   						<div class="awardDivAll awardCanUse">
		   							<p>可使用总额(元)</p>
		   							<span class="moneyFormat2" id="sCanUseRedPackageSum">0</span>
		   						</div>
		   						<div class="awardDiv" ><span class="awardUse btn" onselectstart="return false">去使用</span><em></em></div>
		   					</div>
		   					<div class="awardListInfo">
		   						<span>列表信息</span>
		   					</div>
		   					<div class="awardTableCuA">
		   						<ul id="redList_ul">
			   						<li class="awardTableHeadAb" id="redList_top">
		  								<div class="awardTableHead1">红包总金额</div>
		  								<div class="awardTableHead2">红包类别</div>
		  								<div class="awardTableHead3">获取时间</div>
		  								<div class="awardTableHead4">红包到期时间</div>
		  								<div class="awardTableHead5">红包使用时间</div>
		  								<div class="awardTableHead6">红包描述</div>
		  								<div class="awardTableHead7">状态</div>
			   						</li>
			   						<!-- 红包列表 -->
			   						<script id="redList" type="text/html">
									{{each results as info index }}
		   							<li class="awardTableRegister">
		   								<div class="awardTableHead1 moneyFormat"><span>100</span></div>
	   									<div class="awardTableHead2"><span>注册</span></div>
   										<div class="awardTabCuA3-1">
											<div class="contentA">
											 	2016-08-07
	   											14:12:00
											</div>
										</div>
   										<div class="awardTabCuA3-1">
											<div class="contentA">
											 	2016-08-07
	   											14:12:00
											</div>
										</div>
   										<div class="awardTableHead5a">
   											...
   										</div>
	   									<div class="awardTableHead6"><span>可用于投资使用</span></div>
	   									<div class="awardTableHead7 awardTableHead7a"><i class="awardTabelIstyle">未使用</i></div>
		   							</li>
		   							
		   							<li class="awardTableRegister">
	   									<div class="awardTableHead1 moneyFormat"><span>{{info.sgiftAmount}}</span></div>
	   									<div class="awardTableHead2"><span>{{info.giftType}}</span></div>
   										<div class="awardTabCuA3-1">
											<div class="contentA">
											 	{{info.receiveDate}}
											</div>
										</div>
   										<div class="awardTabCuA3-1">
											<div class="contentA">
											 	{{info.endDate}}
											</div>
										</div>
   										<div class="awardTableHead5a">
   											{{if info.statu=="0"}}
											...
											{{/if}}
   											{{if info.statu=="1"}}
											{{info.useDate}}
											{{/if}}
   											{{if info.statu=="2"}}
											...
											{{/if}}
   										</div>
	   									<div class="awardTableHead6"><span>{{info.remark}}</span></div>
	   									<div class="awardTableHead7 awardTableHead7a">
	   											{{if info.statu=="0"}}
	   											<i class="awardTabelIstyle">未使用</i>
	   											{{/if}}
	   											{{if info.statu=="1"}}
	   											<i>已使用</i>
	   											{{/if}}
	   											{{if info.statu=="2"}}
	   											<i class="awardTgq"></i>
	   											{{/if}}
	   									</div>
		   							</li>
		   							{{/each}}
									<li class="page"><div id="pager"></div></li>
   									</script>
   									
		   						</ul>
		   					</div>
	   					</div>
	   					
   				<!-- 李丽梅 -->
   				<!-- 资金管理-奖励设置-电子劵 -->
   				<!-- 2016-3-31 -->
   					
	   					<div class="awardContent">
	   						<div class="awardImage">
	   							<div class="awardEc awardL moneyFormat"><span >170</span></div>
	   							<div class="awardBc awardR"><p></p></div>
	   						</div>
	   						<ul class="awardBtn clearfix">
	   							<li class="awardBtnTab awardBtnIng getVoucher">代金劵获取</li>
	   							<li class="awardBtnTab useVoucher">使用记录</li>
	   						</ul>
	   						<div class="awardtabContent">
		   						<div class="awardContenta contentActivea">
			   						<div class="awardTable">
				   						<ul id="vouchersList_ul">
					   						<li class="awardTableHead" id="vouchersList_top">
				  								<div class="awardTableAll1">电子券类型</div>
				  								<div class="awardTableAll1">金额</div>
				  								<div class="awardTableAll1">记录类型</div>
				  								<div class="awardTableAll1">记录时间</div>
					   						</li>
					   						<!-- 已获取的代金劵列表模板 -->
					   						<script id="vouchersList" type="text/html">
											{{each results as info index }}
											<li class="awardTableHeadTwo">
				  								<div class="awardTableAll">代金劵</div>
				  								<div class="awardTableAll moneyFormat"><span>{{info.sGiftAmount}}</span></div>
				  								<div class="awardTableAll">{{info.giftType}}</div>
												<div class="awardTabCuA4-1">
													<div class="contentB">
													 	{{info.receiveDate}}
													</div>
												</div>
					   						</li>
											{{/each}}
											<li><div class="pagerCu" id="pager1"></div></li>
											</script>
				   						</ul>
				   					</div>
		   						</div>
		   						<div class="awardContenta">
			   						<div class="awardTable">
				   						<ul class="awardTableUl" id="useVouchersList_ul">
					   						<li class="awardTableHead" id="useVouchersList_top">
				  								<div class="awardTableAll1">使用时间</div>
				  								<div class="awardTableAll1">使用金额</div>
				  								<div class="awardTableAll1">使用状态</div>
				  								<div class="awardTableAll1">使用类型</div>
					   						</li>
					   						<!-- 已使用的代金劵模板 -->
					   						<script id="useVouchersList" type="text/html">
											{{each results as info index }}
											<li class="awardTableHeadTwo">
				  								<div class="awardTabCuA4-1">
													<div class="contentB">
													 	{{info.useDate}}
													</div>
												</div>
				  								<div class="awardTableAll moneyFormat"><span>10</span></div>
												{{if info.statu=="-1"}}
				  								<div class="awardTableAll">失败</div>
												{{/if}}
												{{if info.statu=="0"}}
				  								<div class="awardTableAll awardTableAllFont">处理中</div>
												{{/if}}
												{{if info.statu=="1"}}
				  								<div class="awardTableAll">成功</div>
												{{/if}}
												{{if info.statu=="0"}}
												<div class="awardTableAll">实际投资</div>
												{{/if}}
												{{if info.statu=="1"}}
												<div class="awardTableAll">临时投资</div>
												{{/if}}
					   						</li>
											{{/each}}
											<li><div class="pagerCu" id="pager2"></div></li>
											</script>
				   						</ul>
				   					</div>
		   						</div>
		   					</div>
	   					</div>
   					</div>
   					
   				</div>
   			</div>
   		</div>
   	</div>
   	<!-- 分页标签 -->
   	<script type="text/javascript" charset="utf-8" src="plugs/pager/pager.js"></script>
   	<jsp:include page="../../common/bottom.jsp"></jsp:include>
	<script type="text/javascript" src="js/account/account.js"></script>
	<script type="text/javascript" src="js/account/fundManagement/award.js"></script>
	<script type="text/javascript" src="js/common/template.js"></script>
</body>
</html>