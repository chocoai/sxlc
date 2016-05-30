<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script type="text/javascript">
	_index.m2 = '<%=request.getParameter("_index_m2")%>';
	_index.m3 = '<%=request.getParameter("_index_m3")%>';
	//console.log(_index.m2+";"+_index.m3);
</script>

            <div class="col-md-3 left_col">
                <div class="left_col scroll-view">
                	<div class="navbar nav_title">
                        <a href="javascript:;" class="site_title">
                        	<i class="fa fa-cog"></i>
                        	<span>积分商城</span>
                        </a>
                    </div>
                    <div class="clearfix"></div>
                
                    <!-- sidebar menu -->
                    <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
                        <div class="menu_section">
                            <ul class="nav side-menu">
                                <li data-id="701" id="admin" class="li_level_one">
                               		 <a  href="web/integralMall/integralMall.jsp"><i class="fa fa-edit"></i>商品分类管理</span></a>
                                 </li>
                                <li data-id="702" id="work"><a  href="web/integralMall/integralMall_good.jsp"><i class="fa fa-edit"></i>商品管理</a></li>       
                                <li data-id="703" id="employee"><a  href="web/integralMall/integralMall_ding.jsp"><i class="fa fa-edit"></i>订单管理</a> </li>
                                <li data-id="704" id="admin" class="li_level_one">
                                <a><i class="fa fa-edit"></i>历史订单<span class="fa fa-chevron-down"></span></a>
                                	<ul class="nav child_menu ul_level_one" style="display: none">
                                        <li data-id="7041" ><a  href="web/integralMall/integralMall_true.jsp">已完成订单</a></li>
                                        <li data-id="7042" ><a  href="web/integralMall/integralMall_false.jsp">失败订单</a></li>
                                    </ul>
                                 </li>
                            </ul>
                        </div>
                    </div>
                    <!-- /sidebar menu -->

                    <!-- /menu footer buttons -->
                    <!-- /menu footer buttons -->
                </div>
            </div>


		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		