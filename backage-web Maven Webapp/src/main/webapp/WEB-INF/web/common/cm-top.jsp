<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

	var _index = {
		m1:-1,
		m2:-1,
		m3:-1,
		m4:-1
	};
	
	$(function() {
		//菜单控制,全局1级
		_index.m1 = '<%=request.getParameter("_index_m1")%>';
		//console.log(_index.m1);
	});
</script>
<!-- 顶部一级菜单 -->
<div class="top_navigation">
	<div class="pro-logo">
		XX后台管理系统
		<!-- <img alt="产品LOGO" src="resoures/img/sxlclogo_icon.png"> -->
	</div>
	<div class="top_menu">
		<ul class="ul-list">
			<li data-m1="0" class="f-tab">
				<a href="web/index/index.jsp">
					<p><i class="fa fa-home"></i></p>
					<p>首页</p>
				</a>
			</li>
			<li data-m1="1" class="f-tab">
				<a href="web/role/role-dept.jsp">
					<p><i class="fa fa-sitemap"></i></p>
					<!-- <p><i class="fa fa-shield"></i></p> -->
					<p>角色管理</p>
				</a>
			</li>
			<li data-m1="2" class="f-tab">
				<a href="web/member/member.jsp">
					<p><i class="fa fa-users"></i></p>
					<p>会员管理</p>
				</a>
			</li>
			<li data-m1="3" class="f-tab">
				<a href="web/project/pro_type.jsp">
					<p><i class="fa fa-file-archive-o"></i></p>
					<p>项目管理</p>
				</a>
			</li>
			<li data-m1="4" class="f-tab">
				<a href="web/finance/finance.jsp">
					<p><i class="fa fa-dollar"></i></p>
					<p>财务管理</p>
				</a>
			</li>
			<li data-m1="5" class="f-tab">
				<a href="web/frontconfig/frontconfig.jsp">
					<p><i class="fa fa-windows"></i></p>
					<p>前台界面配置</p>
				</a>
			</li>
			<li data-m1="6" class="f-tab">
				<a href="web/config/config.jsp">
					<p><i class="fa fa-gears"></i></p>
					<p>配置中心</p>
				</a>
			</li>
			<li data-m1="7" class="f-tab">
				<a href="web/integralMall/integralMall.jsp">
					<p><i class="fa fa-shopping-cart"></i></p>
					<p>积分商城</p>
				</a>
			</li>
			<li data-m1="8" class="f-tab">
				<a href="web/statistics/statistics.jsp">
					<p><i class="fa fa-pie-chart"></i></p>
					<p>统计中心</p>
				</a>
			</li>
			<li data-m1="9" class="f-tab">
				<a href="web/recommend/guarantee-manage.jsp">
					<p><i class="fa fa-star"></i></p>
					<p>保荐机构管理</p>
				</a>
			</li>
			<li data-m1="10" class="f-tab">
				<a href="web/promoted/promoted.jsp">
					<p><i class="fa fa-share-alt"></i></p>
					<p>平台推广管理</p>
				</a>
			</li>

			<!-- 测试信息 -->
			<li class="f-tab">
				<a href="web/test/test.jsp">
					<p><i class="fa fa-share-alt"></i></p>
					<p>测试</p>
				</a>
			</li>
		</ul>
	</div>
</div>



