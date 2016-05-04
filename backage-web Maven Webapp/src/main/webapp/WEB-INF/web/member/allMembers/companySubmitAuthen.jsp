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
										<span>营业执照认证</span><span>已认证</span><span>有效期：2016-10-10</span>
										<button class="viewDetail">查看详情</button>
									</div>
									
									<div class="w-content ishow detailAuthen">
										<div class="introduce">
											<span><samp>营业执照号码：</samp>1564641515845</span>
											<span><samp>注册地址：</samp>成都郫县</span>
											<span><samp>注册法人：</samp>某某</span>
											<span><samp>注册资金：</samp><label class="moneyFormat">100000</label>元</span>
										</div>
										<div class="introduce">
											<span><samp>经营范围：</samp>经营范围</span>
											<span><samp>公司类型：</samp>公司类型</span>
											<span><samp>注册时间：</samp>2016-01-02</span>
											<span><samp>有效期：</samp>永久</span>
										</div>
										<div><samp>附件：</samp><img src="resoures/img/accessory.jpg" ><img src="resoures/img/accessory.jpg" ></div>
									</div>
								</div>
								<div>
									<div class="detailTitle">
										<span>工商执照认证</span><span>已认证</span><span>有效期：永久有效</span>
										<button class="viewDetail">查看详情</button>
									</div>
									
									<div class="w-content detailAuthen">
										<div class="introduce">
											<span><samp>住所：</samp>成都青羊</span>
											<span><samp>法人代表姓名：</samp>某某某</span>
											<span><samp>注册资本：</samp><label class="moneyFormat">100000</label>元</span>
											<span><samp>公司类型：</samp>公司类型</span>
										</div>
										<div class="introduce">
											<span><samp>实收资本：</samp><label class="moneyFormat">100000</label>元</span>
											<span><samp>经营范围：</samp>经营范围</span>
											<span><samp>成立日期：</samp>2016-01-02</span>
											<span><samp>有效期：</samp>永久</span>
										</div>
										<div><samp>附件：</samp><img src="resoures/img/accessory.jpg"><img src="resoures/img/accessory.jpg"></div>
									</div>
								</div>
								<div>
									<div class="detailTitle">
										<span>组织机构代码认证</span><span>已认证</span><span>有效期：永久有效</span>
										<button class="viewDetail">查看详情</button>
									</div>
									
									<div class="w-content detailAuthen">
										<div class="introduce">
											<span><samp>组织机构代码：</samp>154512145645</span>
											<span><samp>颁发时间：</samp>2016-01-02</span>
										</div>
										<div class="introduce">
											<span><samp>有效期：</samp>永久</span>
										</div>
										<div><samp>附件：</samp><img src="resoures/img/accessory.jpg"><img src="resoures/img/accessory.jpg"></div>
									</div>
								</div>
								<div>
									<div class="detailTitle">
										<span>开户许可证认证</span><span>已认证</span><span>有效期：永久有效</span>
										<button class="viewDetail">查看详情</button>
									</div>
									
									<div class="w-content detailAuthen">
										<div class="introduce">
											<span><samp>开户许可证编号：</samp>154512145645</span>
											<span><samp>开户银行：</samp>中国银行</span>
										</div>
										<div class="introduce">
											<span><samp>银行帐号：</samp>62258487412255152121</span>
											<span><samp>有效期：</samp>永久</span>
										</div>
										<div><samp>附件：</samp><img src="resoures/img/accessory.jpg"><img src="resoures/img/accessory.jpg"></div>
									</div>
								</div>
								<div>
									<div class="detailTitle">
										<span>企业银行流水认证认证</span><span>已认证</span><span>有效期：2016-12-10</span>
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
										<span>实地考察认证</span><span>已认证</span><span>有效期：2016-10-10</span>
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
										<span>税务登记认证</span><span>已认证</span><span>有效期：2016-12-10</span>
										<button class="viewDetail">查看详情</button>
									</div>
									
									<div class="w-content detailAuthen">
										<div class="introduce">
											<span><samp>证件编号：</samp>154513454541</span>
										</div>
										<div class="introduce">
											<span><samp>颁发机关：</samp>颁发机关</span>
										</div>
										<div><samp>附件：</samp><img src="resoures/img/accessory.jpg"><img src="resoures/img/accessory.jpg"></div>
									</div>
								</div>
								<div>
									<div class="detailTitle">
										<span>批文认证</span><span>已认证</span><span>有效期：2016-12-10</span>
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
										</div>
										<div class="introduce">
											<span><samp>车牌号：</samp>川A0000</span>
											<span><samp>价值：</samp>269万</span>
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
										</div>
										<div><samp>附件：</samp><img src="resoures/img/accessory.jpg"><img src="resoures/img/accessory.jpg"></div>
									</div>
								</div>
								<div>
									<div class="detailTitle">
										<span>财务资料认证</span><span>已认证</span><span>有效期：2016-12-10</span>
										<button class="viewDetail">查看详情</button>
									</div>
									
									<div class="w-content detailAuthen">
										<div class="introduce">
											<span><samp>有效期：</samp>2016-05-01</span>
										</div>
										<div><samp>附件：</samp><img src="resoures/img/accessory.jpg"><img src="resoures/img/accessory.jpg"></div>
									</div>
								</div>
								<div>
									<div class="detailTitle">
										<span>监管单位认证</span><span>已认证</span><span>有效期：2016-12-10</span>
										<button class="viewDetail">查看详情</button>
									</div>
									
									<div class="w-content detailAuthen">
										<div class="introduce">
											<span><samp>有效期：</samp>2016-05-01</span>
										</div>
										<div><samp>附件：</samp><img src="resoures/img/accessory.jpg"><img src="resoures/img/accessory.jpg"></div>
									</div>
								</div>
								<div>
									<div class="detailTitle">
										<span>担保考察认证</span><span>已认证</span><span>有效期：2016-12-10</span>
										<button class="viewDetail">查看详情</button>
									</div>
									
									<div class="w-content detailAuthen">
										<div class="introduce">
											<span><samp>有效期：</samp>2016-05-01</span>
										</div>
										<div><samp>附件：</samp><img src="resoures/img/accessory.jpg"><img src="resoures/img/accessory.jpg"></div>
									</div>
								</div>
								<div>
									<div class="detailTitle">
										<span>法人身份证认证</span><span>已认证</span><span>有效期：2016-12-10</span>
										<button class="viewDetail">查看详情</button>
									</div>
									
									<div class="w-content detailAuthen">
										<div class="introduce">
											<span><samp>有效期：</samp>2016-05-01</span>
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
		<script type="text/javascript" src="js/common.js"></script>
		<script type="text/javascript" src="js/member/verifiedMember.js"></script>
	
</div>

