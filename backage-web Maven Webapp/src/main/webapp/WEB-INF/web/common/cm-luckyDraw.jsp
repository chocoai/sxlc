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
			</script>
            <div class="col-md-3 left_col">
                <div class="left_col scroll-view">
                	<div class="navbar nav_title">
                        <a href="javascript:;" class="site_title">
                        	<i class="fa fa-cog"></i>
                        	<span>幸运抽奖</span>
                        </a>
                    </div>
                    <div class="clearfix"></div>
                
                    <!-- sidebar menu -->
                    <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
                        <div class="menu_section">
                            <ul class="nav side-menu">
                                <li data-id="1101"><a href="web/luckyDraw/luckyDraw.jsp"><i class="fa fa-home"></i>抽奖设置</a></li>
                                <li data-id="1102"><a href="web/luckyDraw/winningRecord.jsp"><i class="fa fa-edit"></i>历史中奖纪录</a></li>
                            </ul>
                        </div>
                    </div>
                    <!-- /sidebar menu -->

                    <!-- /menu footer buttons -->
                    <div class="sidebar-footer hidden-small">
                        <a data-toggle="tooltip" data-placement="top" title="Settings">
                            <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
                        </a>
                        <a data-toggle="tooltip" data-placement="top" title="FullScreen">
                            <span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>
                        </a>
                        <a data-toggle="tooltip" data-placement="top" title="Lock">
                            <span class="glyphicon glyphicon-eye-close" aria-hidden="true"></span>
                        </a>
                        <a data-toggle="tooltip" data-placement="top" title="Logout">
                            <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
                        </a>
                    </div>
                    <!-- /menu footer buttons -->
                </div>
            </div>


		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		