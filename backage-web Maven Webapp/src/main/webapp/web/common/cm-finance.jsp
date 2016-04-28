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
                                <li id="department" class="active"><a><i class="fa fa-home"></i>项目放款管理</a></li>
                                <li id="work"><a><i class="fa fa-edit"></i>债权转让放款管理</a></li>       
                                <li id="employee"><a><i class="fa fa-edit"></i>体现审核</a> </li>
                                <li id="admin" class="li_level_one">
                                <a><i class="fa fa-edit"></i>平台自有账户管理<span class="fa fa-chevron-down"></span></a>
                                	<ul class="nav child_menu ul_level_one" style="display: none">
                                        <li><a>账户充值</a></li>
                                        <li><a>账户体现</a></li>
                                        <li><a>平台账户交易记录</a></li>
                                    </ul>
                                 </li>
                                <li id="admin" class="li_level_one">
                                <a><i class="fa fa-edit"></i>佣金发放<span class="fa fa-chevron-down"></span></a>
                                	<ul class="nav child_menu ul_level_one" style="display: none">
                                        <li><a>佣金统计</a></li>
                                        <li><a>推荐借款明细</a></li>
                                        <li><a>推荐投资明细</a></li>
                                        <li><a>推荐还本明细</a></li>
                                        <li><a>推荐VIP购买明细</a></li>
                                        <li><a>佣金发放记录</a></li>
                                    </ul>
                                 </li>
                                <li id="role"><a><i class="fa fa-edit"></i>代偿管理</a> </li>
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


		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		