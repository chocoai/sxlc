<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
	<base href="<%=basePath%>">
	<title>积分商城</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link rel="stylesheet" href="css/promoted/promotedCom.css" type="text/css">
</head>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="7" name="_index_m1"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-integralMall.jsp">
				<jsp:param value="702" name="_index_m2"/>
				<jsp:param value="" name="_index_m3"/>
			</jsp:include>
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				<!-- 主体部分 -->
				<div class="nav-tabs-con active">
					<div class="search">
						<div class="panel panel-success">
							<div class="panel-heading">
								<div class="i-fl search_title">条件查询</div>
								<div class="i-fr action_item">
									<ul class="list_item list-inline">
										<li><a class="state">展开&nbsp;<span class="glyphicon glyphicon-chevron-down"></span> </a></li>
									</ul>
								</div>
							</div>
							<div class="panel-body">
								<form>
									<div>
										<span class="con-item"><span>商品名称</span><input type="text" class="notspecial" id="productName"/></span>
										<span class="con-item"><span>商品编码</span><input type="text" class="notspecial" id="productNum"/></span>
									</div>
									<div>
										<span class="con-item">
										<span>商品种类</span>
											<select id="upType">
												<option value="-1">全部</option>
												<option value="0">实物</option>
												<option value="1">电子礼券</option>
											</select>
										</span>
										<span class="con-item">
										<span>状态</span>
											<select id="upOption">
												<option value="-1">全部</option>
												<option value="0">待上架</option>
												<option value="1">兑换中</option>
												<option value="2">已下架</option>
											</select>
										</span>
										<input class="obtn obtn-query glyphicon glyphicon-search" value="查询" type="button">
									</div>
								</form>
						  	</div>
						 </div>
					</div> 
					<div class="data_display">
						<div class="panel panel-success">
							<div class="panel-heading">
								<div class="action_item">
									<button class="obtn glyphicon glyphicon-plus obtn-export" onclick="window.location='web/integralMall/good_add.jsp'">添加商品</button>
									<button class="obtn glyphicon glyphicon-plus obtn-export" id="upProdu">修改商品</button>
									<button class="obtn glyphicon glyphicon-plus obtn-export3" id="recPro">推荐到商城首页</button>
									<button class="obtn glyphicon glyphicon-plus obtn-export" id="lookIntoKu">查看入库记录</button>
									<button class="obtn glyphicon glyphicon-plus obtn-export" onclick="bankManagementKdd('入库')">入库</button>
									<button class="obtn glyphicon glyphicon-plus obtn-export" onclick="bankManagementVdd('设置VIP折扣')">设置VIP折扣</button>
								</div>
							</div>
							
							<div class="panel-body">

								<table id="teamTb" class="display">
									
								</table>
							</div>
							
							<div class="w-content ishow pic-add" id="into" style="display:none">
								<table>
									<tr>
										<td class="tt">入库数量</td>
										<td class="con"><input  id="intoKu" type="text" value=""/></td>
									</tr>
								</table>
							</div>
							
							<div class="w-content ishow pic-add" id="intoVip"  style="display:none">
								<table id="card_id">
									<tr>
										<td class="tt">折扣</td>
										<td class="con" id=""><input id="vipSale" type="text" value=""/></td>
									</tr>
								</table>
							</div>
							
							
						</div>
					</div>
				</div>				
			</div>
		
			<!-- 尾部 -->
			
		</div>
	</div>
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<script type="text/javascript" src="js/integralMall/integralMall_good.js"></script>
</body>

</html>