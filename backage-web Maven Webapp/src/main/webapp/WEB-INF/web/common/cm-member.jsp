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
                        	<span>产品后台管理</span>
                        </a>
                    </div>
                    <div class="clearfix"></div>
                
                    <!-- sidebar menu -->
                    <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
                        <div class="menu_section">
                            <ul class="nav side-menu">
                                 <li data-id="201" id="admin" class="li_level_one">
                                	<a><i class="fa fa-edit"></i>个人会员<span cla
                                	ss="fa fa-chevron-down"></span></a>
                                	<ul class="nav child_menu ul_level_one" style="display: none">
                                        <li data-id="20101"><a href="web/member/member.jsp">全部会员</a></li>
                                        <li data-id="20102"><a href="web/member/membersVip.jsp">VIP会员</a></li>
                                        <li data-id="20103"><a href="web/member/registeredMember.jsp">注册会员</a></li>
                                        <li data-id="20104"><a href="web/member/verifiedMember.jsp">认证会员</a></li>
                                        <li data-id="20105"><a href="web/member/loanMember.jsp">借款会员</a></li>
                                        <li data-id="20106"><a href="web/member/investmentMember.jsp">投资会员</a></li>
                                        <li data-id="20107"><a href="web/member/compositeMember.jsp">复合会员</a></li>
                                        <li data-id="20108"><a href="web/member/memberBlackList.jsp">会员黑名单</a></li>
                                        <li data-id="20109"><a href="web/member/realNameAuthen.jsp?content=1">资料认证</a></li>
                                        <li data-id="20110"><a href="web/member/memberFinancialAdvisor.jsp">会员分配理财顾问</a></li>
                                        <li data-id="20111"><a href="web/member/changeOfFinancialAdvisor.jsp">理财顾问变更</a></li>
                                    </ul>
                                 </li> 
                                 <li data-id="202" id="admin" class="li_level_one">
                               		<a><i class="fa fa-edit"></i>企业会员<span class="fa fa-chevron-down"></span></a>
                                	<ul class="nav child_menu ul_level_one" style="display: none">
                                        <li data-id="20201"><a href="web/member/companyMembers.jsp">全部会员</a></li>
                                        <li data-id="20202"><a href="web/member/companyMemberVip.jsp">VIP会员</a></li>
                                        <li data-id="20203"><a href="web/member/comanyRegistedMember.jsp">注册会员</a></li>
                                        <li data-id="20204"><a href="web/member/companyVerifiedMember.jsp">认证会员</a></li>
                                        <li data-id="20205"><a href="web/member/companyLoanMember.jsp">借款会员</a></li>
                                        <li data-id="20206"><a href="web/member/companyInvestMember.jsp">投资会员</a></li>
                                        <li data-id="20207"><a href="web/member/companyCompositeMember.jsp">复合会员</a></li>
                                        <li data-id="20208"><a href="web/member/companyMemberBlackList.jsp">会员黑名单</a></li>
                                        <li data-id="20209"><a href="web/member/businessLicenseAuthen.jsp?content=12">资料认证</a></li>
                                        <li data-id="20210"><a href="web/member/companyFinancialAdvisor.jsp">会员分配理财顾问</a></li>
                                        <li data-id="20211"><a href="web/member/companyChangeFinAdvisor.jsp">理财顾问变更</a></li>
                                    </ul>
                                 </li>
                                <li data-id="203" id="admin" class="li_level_one" >
                                <a href="web/member/user_fanKui.jsp" ><i class="fa fa-edit"></i>客户意见反馈<span class="fa fa-edit"></span></a></li>
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


		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		