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
                                <a><i class="fa fa-edit"></i>担保机构管理</a>
                                	<!-- <ul class="nav child_menu ul_level_one" style="display: none">
                                        <li><a>列表展示担保机构信息</a></li>
                                        <li><a>添加担保机构信息</a></li>
                                        <li><a>修改担保机构信息</a></li>
                                        <li><a>查看担保机构详情</a></li>
                                        <li><a>担保机构管理员管理</a></li>
                                        <li><a>启用停用</a></li>
                                        <li><a>担保项目查询</a></li>
                                        <li><a>代偿记录查询</a></li>
                                        <li><a>代偿回款记录查询</a></li>
                                    </ul> -->
                                 </li>
                                <li id="admin" class="li_level_one">
                                <a><i class="fa fa-edit"></i>资产管理方管理</a>
                                	<!-- <ul class="nav child_menu ul_level_one" style="display: none">
                                        <li><a>设置担保配置</a></li>
                                        <li><a>担保机构担保项目</a></li>
                                        <li><a>代偿管理</a></li>
                                        <li><a>历史代偿记录</a></li>
                                        <li><a>代偿回款记录</a></li>
                                        <li><a>第三方账户信息管理</a></li>
                                    </ul> -->
                                 </li>
                                <li id="admin" class="li_level_one">
                                <a><i class="fa fa-edit"></i>账户中心</a>
                                	<!-- <ul class="nav child_menu ul_level_one" style="display: none">
                                        <li><a>类表展示资产管理方信息</a></li>
                                        <li><a>添加资产管理方信息</a></li>
                                        <li><a>修改资产管理方信息</a></li>
                                        <li><a>查看资产管理方详情</a></li>
                                        <li><a>资产管理方管理员管理</a></li>
                                    </ul> -->
                                 </li>
                                <li id="admin" class="li_level_one">
                                <a><i class="fa fa-edit"></i>代偿</a>
                                 </li>
                                <li id="admin" class="li_level_one">
                                <a><i class="fa fa-edit"></i>历史代偿记录</a>
                                 </li>
                                <li id="admin" class="li_level_one">
                                <a><i class="fa fa-edit"></i>代偿回款记录</a>
                                 </li>
                                <li id="admin" class="li_level_one">
                                <a><i class="fa fa-edit"></i>银行卡管理</a>
                                 </li>
                                <li id="admin" class="li_level_one">
                                <a><i class="fa fa-edit"></i>充值记录</a>
                                 </li>
                                <li id="admin" class="li_level_one">
                                <a><i class="fa fa-edit"></i>提现记录</a>
                                 </li>
                                <li id="admin" class="li_level_one">
                                <a><i class="fa fa-edit"></i>交易记录</a>
                                 </li>
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


		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		