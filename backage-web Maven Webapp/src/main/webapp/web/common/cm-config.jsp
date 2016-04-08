<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
			<!-- 左侧公共菜单	读取数据库 -->
            <div class="col-md-3 left_col">
                <div class="left_col scroll-view">
					
					<!-- 父级菜单 -->
                    <div class="navbar nav_title">
                        <a href="javascript:;" class="site_title">
                        	<i class="fa fa-cog"></i>
                        	<span>产品后台管理</span>
                        </a>
                    </div>
                    <div class="clearfix"></div>
					<!-- /父级菜单 -->

                    <!-- 左侧公共菜单 -->
                    <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
                        <div class="menu_section">
                            <ul class="nav side-menu">
                            	<li id="loan_manage" class="li_level_one">
                            		<a><i class="fa fa-edit"></i>财务设置<span class="fa fa-chevron-down"></span></a>
                            		<ul class="nav child_menu ul_level_one" style="display: none">
                            			<li><a href="web/config/config.jsp">提现手续费设置</a></li>
                            			<li><a href="web/config/charge-fee.jsp">充值手续费设置</a></li>
                            			<li><a href="web/config/cash-exam.jsp">提现审核</a></li>
                            			<li><a href="web/config/assignment-set.jsp">债权转让设置</a></li>
                            			<li><a href="web/config/late-allocation.jsp">逾期配置</a></li>
                            			<li><a href="web/config/integral-rule.jsp">积分规则设置</a></li>
                            			<li><a href="web/config/award-rule.jsp">提奖规则设置</a></li>
                            			<li><a href="web/config/imfee-day.jsp">投资管理费设置</a></li>
                            			<li><a href="web/config/auto-bid.jsp">自动投标奖励设置</a></li>
                            			<li><a href="web/config/red-voucher.jsp">红包、代金券提醒设置</a></li>
                            		</ul>
                            	</li>
                               	<li id="department"><a href="web/config/platform.jsp"><i class="fa fa-home"></i>平台设置</a></li>
                               	<li id="loan_manage" class="li_level_one">
                            		<a><i class="fa fa-edit"></i>短信设置<span class="fa fa-chevron-down"></span></a>
                            		<ul class="nav child_menu ul_level_one" style="display: none">
                            			<li><a href="web/config/msg-content.jsp">消息内容配置</a></li>
                            			<li><a href="web/config/msg-alert.jsp">消息提醒设置</a></li>
                            			<li><a href="web/config/msg-post.jsp">消息发送历史</a></li>
                            			<li><a href="web/config/msg-interface.jsp">消息接口配置</a></li>
                            		</ul>
                            	</li>
                               	<li id="admin" class="li_level_one"><a><i class="fa fa-edit"></i>托管平台设置</a></li>
                                <li id="work"><a><i class="fa fa-edit"></i>会员等级配置</a></li>       
                                <li id="employee"><a><i class="fa fa-edit"></i>会员信用等级配置</a></li>
                                <li id="work"><a><i class="fa fa-edit"></i>前台借款信息填写配置</a></li>
                                <li id="admin" class="li_level_one"><a><i class="fa fa-edit"></i>项目审批流程配置</a></li>
                                <li id="admin" class="li_level_one"><a><i class="fa fa-edit"></i>VIP配置</a></li>
                                <li id="work"><a><i class="fa fa-edit"></i>协议配置</a></li>       
                                <li id="employee"><a><i class="fa fa-edit"></i>账单催收</a> </li>
                               	<li id="admin" class="li_level_one"><a><i class="fa fa-edit"></i>借款认证项配置</a></li>
                            </ul>
                        </div>
                    </div>
                    <!-- /左侧公共菜单 -->

                    <!-- 尾部控制按钮 -->
                    <!-- /尾部控制按钮 -->
                    
                </div>
            </div>


		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		