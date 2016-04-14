<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

            <div class="col-md-3 left_col">
                <div class="left_col scroll-view">
                	<div class="navbar nav_title">
                        <a href="javascript:;" class="site_title">
                        	<i class="fa fa-cog"></i>
                        	<span>产品后台管理</span>
                        </a>
                    </div>
                    <div class="clearfix"></div>
                
                    <!-- sidebar menu -->
                    <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
                        <div class="menu_section">
                            <ul class="nav side-menu">
                                <li id="department" class="active"><a><i class="fa fa-home"></i>前台注册报表</a></li>
                                <li id="work"><a><i class="fa fa-edit"></i>前台会员登录报表</a></li>       
                                <li id="employee"><a><i class="fa fa-edit"></i>后台操作报表</a> </li>
                                <li id="role"><a><i class="fa fa-edit"></i>借款统计</a> </li>
                                <li id="department"><a><i class="fa fa-home"></i>投资统计</a></li>
                                <li id="work"><a><i class="fa fa-edit"></i>债权转让统计</a></li>       
                                <li id="employee"><a><i class="fa fa-edit"></i>充值统计表</a> </li>
                                <li id="role"><a><i class="fa fa-edit"></i>提现统计表</a> </li>
                                <li id="department"><a><i class="fa fa-home"></i>管理费统计</a></li>
                                <li id="work"><a><i class="fa fa-edit"></i>客户红包统计</a></li>       
                                <li id="employee"><a><i class="fa fa-edit"></i>会员数据统计分析表</a> </li>
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


		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		