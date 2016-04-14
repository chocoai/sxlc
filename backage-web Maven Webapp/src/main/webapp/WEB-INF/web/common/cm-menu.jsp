<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

	<script type="text/javascript">
	//菜单控制
	$(function(){
		var num='<%=request.getParameter("li_index")%>';
		//alert(num);
		$(".menu_li").each(function(index) {
			var id = $(this).attr("id");
			if (num == id) {
				$(this).addClass("menu_selected").siblings("li").removeClass("menu_selected");
				$(this).children("a").css("color","#fff"); 
			}
		});
		
		//判断一级菜单索引 
		var indexNum = 0;
		if(num == 1 || num==2 || num==3 || num==4 || num==5 || num==6 || num==7 || num==8 || num==9 || num==10){
			indexNum = 0;
		}else if(num == 11 || num == 12 || num == 13) {
			indexNum = 1;
		}else if(num == 14 || num == 15 || num == 16 || num == 17 || num == 18) {
			indexNum = 2;
		}else if(num == 19 || num == 20 || num == 21 || num == 22) {
			indexNum = 3;
		}else if(num == 23 || num == 24) {
			indexNum = 4;
		}else if(num == 25 || num == 26) {
			indexNum = 5;
		}

		//一级菜单按索引展开显示
		$("#firstpane .menu_body:eq("+ indexNum +")").show();
		//一级菜单点击事件
		$("#firstpane h3.menu_head").click(function(){
			$(this).addClass("isopen").next("ul.menu_body").slideToggle(300).siblings("ul.menu_body").slideUp("slow");
			$(this).siblings().removeClass("isopen");
		});
		
	});
	</script>


		<!-- 个人中心 -->
		<div class="menu-box">
			<div class="menu_tree">
				<div id="firstpane" class="menu_list">
					<h3 class="menu_head isopen"><span>个人中心</span></h3>
					<ul style="display:none" class="menu_body">
						<li class="menu_li" id="1">
							<a href="per_basic.html">基本信息</a>
						</li>
						<li class="menu_li" id="2">
							<a href="per_safe.html">安全中心</a>
						</li>
						<li class="menu_li" id="3">
							<a href="per_bank.html">银行卡</a>
						</li>
					</ul>
				</div>
			</div>
		</div>