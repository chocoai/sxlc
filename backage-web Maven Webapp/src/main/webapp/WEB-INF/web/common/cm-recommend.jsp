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
                        	<span><!-- 产品后台管理 --></span>
                        </a>
                    </div>
                
                    <!-- sidebar menu -->
                    <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
                        <div class="menu_section">
                            <ul class="nav side-menu">
                                <li id="admin" class="li_level_one active">
                                	<a href="web/recommend/guarantee-manage.jsp"><i class="fa fa-edit"></i>担保机构管理</a>
                                 </li>
                                <li id="admin" class="li_level_one">
                                	<a href="web/recommend/asset-management.jsp"><i class="fa fa-edit"></i>资产管理方管理</a>
                                 </li>
                                <li id="admin" class="li_level_one">
                                	<a href="web/recommend/account-center.jsp"><i class="fa fa-edit"></i>账户中心</a>
                                 </li>
                                <li id="admin" class="li_level_one">
                                	<a href="web/recommend/guarantee-record-query.jsp"><i class="fa fa-edit"></i>担保记录查询</a>
                                 </li>
                                <li id="admin" class="li_level_one">
                                	<a href="web/recommend/compensatory.jsp"><i class="fa fa-edit"></i>代偿</a>
                                 </li>
                                <li id="admin" class="li_level_one">
                                	<a href="web/recommend/historical-compensation-records.jsp"><i class="fa fa-edit"></i>历史代偿记录</a>
                                 </li>
                                <li id="admin" class="li_level_one">
                                	<a href="web/recommend/compensatory-payment-records.jsp"><i class="fa fa-edit"></i>代偿回款记录</a>
                                 </li>
                                <li id="admin" class="li_level_one">
                                	<a href="web/recommend/bank-card-management.jsp"><i class="fa fa-edit"></i>银行卡管理</a>
                                 </li>
                                <li id="admin" class="li_level_one">
                                	<a href="web/recommend/recharge-record.jsp"><i class="fa fa-edit"></i>充值记录</a>
                                 </li>
                                <li id="admin" class="li_level_one">
                                	<a href="web/recommend/present-record.jsp"><i class="fa fa-edit"></i>提现记录</a>
                                 </li>
                                <li id="admin" class="li_level_one">
                                	<a href="web/recommend/transaction-record.jsp"><i class="fa fa-edit"></i>交易记录</a>
                                 </li>
                            </ul>
                        </div>
                    </div>
                    <!-- /sidebar menu -->

                    <!-- /menu footer buttons -->
                    <!-- <div class="sidebar-footer hidden-small">
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
                    </div> -->
                    <!-- /menu footer buttons -->
                </div>
            </div>


		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		