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
                        <a class="site_title">
                        	<i class="fa fa-cog"></i>
                        	<span>产品后台管理</span>
                        </a>
                    </div>
                    <!-- sidebar menu -->
                    <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
                        <div class="menu_section">
                            <ul class="nav side-menu">
                                <li id="pro_type" class="active"><a href="web/project/pro_type.jsp"><i class="fa fa-home"></i>项目类型管理</a></li>
                                <li id="loan_apply_manage"><a href="web/project/loan_intention_1.jsp"><i class="fa fa-edit"></i>借款申请管理</a></li>
                                <li id="loan_exam"><a href="web/project/loan_exam.jsp"><i class="fa fa-edit"></i>借款审核</a></li>       
                                <li id="pro_post"><a href="web/project/post_list.jsp"><i class="fa fa-edit"></i>项目发布</a> </li>
                                <li id="loan_manage" class="li_level_one">
                                	<a><i class="fa fa-edit"></i>借款管理<span class="fa fa-chevron-down"></span></a>
                                	<ul class="nav child_menu ul_level_one" style="display: none">
                                        <li><a href="web/project/apply_failed.jsp">申请失败项目管理</a></li>
                                        <li><a href="web/project/examing.jsp">审核中项目管理</a></li>
                                        <li><a href="web/project/not_released.jsp">未发布项目管理</a></li>
                                        <li><a href="web/project/investing.jsp">投资中项目管理</a></li>
                                        <li><a href="web/project/tobe_lending.jsp">待放款项目管理</a></li>
                                        <li><a href="web/project/have_bids.jsp">已流标项目管理</a></li>
                                        <li><a href="web/project/repayment.jsp">还款中项目管理</a></li>
                                        <li><a href="web/project/settled.jsp">已结清项目管理</a></li>
                                    </ul>
                                 </li>
                                <li id="after_loan_manage" class="li_level_one">
                                	<a><i class="fa fa-edit"></i>贷后管理<span class="fa fa-chevron-down"></span></a>
                                	<ul class="nav child_menu ul_level_one" style="display: none">
                                        <li><a href="web/project/deal_pro_list.jsp">成交项目管理</a></li>
                                        <li><a href="web/project/soon_pay_count.jsp">即将还款统计</a></li>
                                        <li><a href="web/project/late_pay_count.jsp">逾期还款统计</a></li>
                                        <li><a href="web/project/soon_due_bill.jsp">即将到期借款催收</a></li>
                                        <li><a href="web/project/overdue_collection.jsp">逾期借款催收</a></li>
                                        <li><a href="web/project/collection_has_bill.jsp">催收已还账单</a></li>
                                    </ul>
                                 </li>
                                <li id="credit_transfer_exam"><a href="web/project/credit_assignment_exam.jsp"><i class="fa fa-edit"></i>债权转让审核</a></li>
                                <li id="credit_transfer_late"><a href="web/project/credit_assignment_late.jsp"><i class="fa fa-home"></i>债权转让延期</a></li>
                            </ul>
                        </div>
                    </div>
                    <!-- /sidebar menu -->

                    <!-- /menu footer buttons -->
                    <!-- /menu footer buttons -->
                </div>
            </div>
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		