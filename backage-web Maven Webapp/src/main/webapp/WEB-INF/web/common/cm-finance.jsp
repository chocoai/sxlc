<%-- <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
</script> --%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
                    <!-- sidebar menu -->
                    <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
                        <div class="menu_section">
                            <ul class="nav side-menu">
                                <li data-id="401"><a href="web/finance/fn-pro-lending.jsp"><i class="fa fa-home"></i>项目放款管理</a></li>
                                <li data-id="402"><a href="web/finance/fn-trans-lending.jsp"><i class="fa fa-edit"></i>债权转让放款</a></li>       
                                <li data-id="403"><a href="web/finance/fn-withdraw-verify.jsp"><i class="fa fa-edit"></i>提现审核</a> </li>
                                <li data-id="404"><a href="web/finance/fn-IdCardManage.jsp"><i class="fa fa-edit"></i>平台自有账户银行卡管理</a></li>
                                <li data-id="405"><a href="web/finance/fn-recharge.jsp"><i class="fa fa-edit"></i>平台自有账户充值</a></li>
                                <li data-id="406"><a href="web/finance/fn-withdraw.jsp"><i class="fa fa-edit"></i>平台自有账户提现</a></li>
                                <li data-id="407"><a href="web/finance/fn-transaction-record.jsp"><i class="fa fa-edit"></i>平台自有账户交易记录</a></li>
                                <li data-id="408"><a href="web/finance/fn-cms-statistics.jsp"><i class="fa fa-edit"></i>佣金发放</a></li>
                                <li data-id="409"><a href="web/finance/fn-cms-record.jsp"><i class="fa fa-edit"></i>佣金发放记录</a></li>
                                <li data-id="410"><a href="web/finance/fn-compensation.jsp"><i class="fa fa-edit"></i>逾期代偿</a> </li>
                                <li data-id="411"><a href="web/finance/fn-historyCompensatory.jsp"><i class="fa fa-edit"></i>代偿记录</a> </li>
                                <li data-id="412"><a href="web/finance/fn-compensatoryRecord.jsp"><i class="fa fa-edit"></i>代偿回款记录</a> </li>
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


		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		