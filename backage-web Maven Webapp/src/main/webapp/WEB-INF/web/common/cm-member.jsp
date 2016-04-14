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
                                 <li id="admin" class="li_level_one active">
                                <a><i class="fa fa-edit"></i>个人会员<span class="fa fa-chevron-down"></span></a>
                                	<ul class="nav child_menu ul_level_one" style="display: none">
                                        <li class="allMembersCu active"><a>全部会员</a></li>
                                        <li class="membersVipCu"><a>VIP会员</a></li>
                                        <li class="registeredMemberCu"><a>注册会员</a></li>
                                        <li class="authenticationInformation "><a>认证会员</a></li>
                                        <li class="loanMemberCu"><a>借款会员</a></li>
                                        <li class="investmentMemberCu"><a>投资会员</a></li>
                                        <li class="compositeMemberCu"><a>复合会员</a></li>
                                        <li class="memberBlackListCu"><a>会员黑名单</a></li>
                                        <li class="dataAuthenticationCu"><a>资料认证</a></li>
                                        <li class="memberFinancialAdvisorCu"><a>会员分配理财顾问</a></li>
                                        <li class="changeOfFinancialAdvisorCu"><a>理财顾问变更</a></li>
                                    </ul>
                                 </li> 
                                 <li id="admin" class="li_level_one">
                                <a><i class="fa fa-edit"></i>企业会员<span class="fa fa-chevron-down"></span></a>
                                	<ul class="nav child_menu ul_level_one" style="display: none">
                                        <li><a>全部会员</a></li>
                                        <li><a>VIP会员</a></li>
                                        <li><a>注册会员</a></li>
                                        <li><a>认证会员</a></li>
                                        <li><a>借款会员</a></li>
                                        <li><a>投资会员</a></li>
                                        <li><a>复合会员</a></li>
                                        <li><a>会员黑名单</a></li>
                                        <li><a>资料认证</a></li>
                                        <li><a>会员分配理财顾问</a></li>
                                        <li><a>理财顾问变更</a></li>
                                    </ul>
                                 </li>
                                <li id="admin" class="li_level_one">
                                <a><i class="fa fa-edit"></i>客户意见反馈<span class="fa fa-edit"></span></a></li>
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


		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		