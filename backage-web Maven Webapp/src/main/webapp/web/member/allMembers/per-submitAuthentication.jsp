<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<head>
	<!-- <link rel="stylesheet" href="plugs/prettyphoto/css/lrtk.css" type="text/css"> -->
	<!-- <link rel="stylesheet" href="plugs/prettyphoto/css/prettyPhoto.css" type="text/css"> -->
	
</head>


<div class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 主要内容 -->
				<!-- 地址导航 -->
			<jsp:include page="../../common/cm-addr.jsp"></jsp:include>
			<div class="nav-tabs-con active">
				<div class="data_display">
						
						<div class="panel-body">
							<div class="authen">
								<div>
									<div class="detailTitle">
										<span>实名认证</span><span>已认证</span><span>有效期：2016-10-10</span>
										<button class="viewDetail">查看详情</button>
									</div>
									
									<div class="w-content ishow detailAuthen">
										<div class="introduce">
											<span><samp>姓名：</samp>某某某</span>
											<span><samp>民族：</samp>汉</span>
											<span><samp>性别：</samp>男</span>
										</div>
										<div class="introduce">
											<span><samp>籍贯：</samp>四川成都</span>
											<span><samp>有效期：</samp>2016-10-10</span>
											<span><samp>身份证号：</samp>500221145702541540</span>
										</div>
										<div><samp>附件：</samp><img src="resoures/img/accessory.jpg" ><img src="resoures/img/accessory.jpg" ></div>
									</div>
								</div>
								<div>
									<div class="detailTitle">
										<span>现场认证</span><span>已认证</span><span>有效期：永久有效</span>
										<button class="viewDetail">查看详情</button>
									</div>
									
									<div class="w-content detailAuthen">
										<div><samp>附件：</samp><img src="resoures/img/accessory.jpg"><img src="resoures/img/accessory.jpg"></div>
									</div>
								</div>
								<div>
									<div class="detailTitle">
										<span>学历认证</span><span>已认证</span><span>有效期：永久有效</span>
										<button class="viewDetail">查看详情</button>
									</div>
									
									<div class="w-content detailAuthen">
										<div><samp>附件：</samp><img src="resoures/img/accessory.jpg"><img src="resoures/img/accessory.jpg"></div>
									</div>
								</div>
								<div>
									<div class="detailTitle">
										<span>银行流水认证</span><span>已认证</span><span>有效期：永久有效</span>
										<button class="viewDetail">查看详情</button>
									</div>
									
									<div class="w-content detailAuthen">
										<div class="introduce">
											<span><samp>查询日期：</samp>2016-10-10</span>
										</div>
										<div><samp>附件：</samp><img src="resoures/img/accessory.jpg"><img src="resoures/img/accessory.jpg"></div>
									</div>
								</div>
								<div>
									<div class="detailTitle">
										<span>征信认证</span><span>已认证</span><span>有效期：2016-12-10</span>
										<button class="viewDetail">查看详情</button>
									</div>
									
									<div class="w-content detailAuthen">
										<div class="introduce">
											<span><samp>有效期：</samp>2016-10-10</span>
										</div>
										<div><samp>附件：</samp><img src="resoures/img/accessory.jpg"><img src="resoures/img/accessory.jpg"></div>
									</div>
								</div>
								<div>
									<div class="detailTitle">
										<span>职称认证</span><span>已认证</span><span>有效期：2016-10-10</span>
										<button class="viewDetail">查看详情</button>
									</div>
									
									<div class="w-content detailAuthen">
										<div class="introduce">
											<span><samp>到期日：</samp>2016-10-10</span>
										</div>
										<div><samp>附件：</samp><img src="resoures/img/accessory.jpg"><img src="resoures/img/accessory.jpg"></div>
									</div>
								</div>
								<div>
									<div class="detailTitle">
										<span>住址认证</span><span>已认证</span><span>有效期：2016-12-10</span>
										<button class="viewDetail">查看详情</button>
									</div>
									
									<div class="w-content detailAuthen">
										<div class="introduce">
											<span><samp>有效期：</samp>2016-10-10</span>
										</div>
										<div><samp>附件：</samp><img src="resoures/img/accessory.jpg"><img src="resoures/img/accessory.jpg"></div>
									</div>
								</div>
								<div>
									<div class="detailTitle">
										<span>社保认证</span><span>已认证</span><span>有效期：2016-12-10</span>
										<button class="viewDetail">查看详情</button>
									</div>
									
									<div class="w-content detailAuthen">
										<div class="introduce">
											<span><samp>有效期：</samp>2016-10-10</span>
										</div>
										<div><samp>附件：</samp><img src="resoures/img/accessory.jpg"><img src="resoures/img/accessory.jpg"></div>
									</div>
								</div>
								<div>
									<div class="detailTitle">
										<span>车产认证</span><span>已认证</span><span>有效期：2016-12-10</span>
										<button class="viewDetail">查看详情</button>
									</div>
									
									<div class="w-content detailAuthen">
										<div class="introduce">
											<span><samp>车辆品牌：</samp>法拉利</span>
											<span><samp>型号：5212145485652222</samp>汉</span>
											<span><samp>车牌号：</samp>川A0000</span>
										</div>
										<div class="introduce">
											<span><samp>发票价格：</samp>269万</span>
											<span><samp>首次登记日期：</samp>2016-10-10</span>
										</div>
										<div><samp>附件：</samp><img src="resoures/img/accessory.jpg"><img src="resoures/img/accessory.jpg"></div>
									</div>
								</div>
								<div>
									<div class="detailTitle">
										<span>房产认证</span><span>已认证</span><span>有效期：2016-12-10</span>
										<button class="viewDetail">查看详情</button>
									</div>
									
									<div class="w-content detailAuthen">
										<div class="introduce">
											<span><samp>房产位置：</samp>成都郫县天河路</span>
											<span><samp>面积：</samp>120平米</span>
										</div>
										<div class="introduce">
											<span><samp>市场价值：</samp>269万</span>
											<span><samp>登记时间：</samp>2016-10-10</span>
										</div>
										<div><samp>附件：</samp><img src="resoures/img/accessory.jpg"><img src="resoures/img/accessory.jpg"></div>
									</div>
								</div>
								<div>
									<div class="detailTitle">
										<span>婚姻认证</span><span>已认证</span><span>有效期：2016-12-10</span>
										<button class="viewDetail">查看详情</button>
									</div>
									
									<div class="w-content detailAuthen">
										<div class="introduce">
											<span><samp>婚姻状况：</samp>已婚</span>
											<span><samp>登记日期：</samp>2016-05-01</span>
										</div>
										<div><samp>附件：</samp><img src="resoures/img/accessory.jpg"><img src="resoures/img/accessory.jpg"></div>
									</div>
								</div>
							</div>
						</div>
						
					</div>
				</div>
			
			</div>
		</div>

	
		<!-- 公用js -->
		<script type="text/javascript" src="js/member/verifiedMember.js"></script>
	
</div>

