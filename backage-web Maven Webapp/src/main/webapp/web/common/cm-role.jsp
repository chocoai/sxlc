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
                        <a class="site_title">
                        	<i class="fa fa-list-ul"></i>
                        	<span>角色管理</span>
                        </a>
                    </div>
                
                    <!-- sidebar menu -->
                    <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
                        <div class="menu_section">
                            <ul class="nav side-menu">
                                <%-- <li data-tag="role-0"><a href="web/role/role-dept.jsp"><i class="fa fa-home"></i>部门管理</a></li>
                                <li data-tag="role-1"><a href="<%=basePath %>PostController/getDeptList.do"><i class="fa fa-edit"></i>职务管理</a></li>       
                                <li data-tag="role-2"><a href="<%=basePath %>role/emp.do"><i class="fa fa-edit"></i>员工管理</a> </li>
                                <li data-tag="role-3"><a href="web/role/role-adviser.jsp"><i class="fa fa-edit"></i>理财顾问管理</a> </li>
                                <li data-tag="role-4"><a href="<%=basePath %>getModuleAndOperation.do"><i class="fa fa-edit"></i>角色管理</a> </li>
                                <li data-tag="role-5"><a href="<%=basePath %>getRoleListToReq.do"><i class="fa fa-edit"></i>管理员管理</a> </li> --%>
                                <li data-id="101"><a href="web/role/role-dept.jsp"><i class="fa fa-home"></i>部门管理</a></li>
                                <li data-id="102"><a href="<%=basePath %>PostController/getDeptList.do"><i class="fa fa-edit"></i>职务管理</a></li>       
                                <li data-id="103"><a href="<%=basePath %>role/emp.do"><i class="fa fa-edit"></i>员工管理</a> </li>
                                <li data-id="104"><a href="web/role/role-adviser.jsp"><i class="fa fa-edit"></i>理财顾问管理</a> </li>
                                <li data-id="105"><a href="<%=basePath %>getModuleAndOperation.do"><i class="fa fa-edit"></i>角色管理</a> </li>
                                <li data-id="106"><a href="<%=basePath %>getRoleListToReq.do"><i class="fa fa-edit"></i>管理员管理</a> </li>
                            </ul>
                        </div>
                    </div>
                    <!-- /sidebar menu -->
                </div>
            </div>