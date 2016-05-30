<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
			<script type="text/javascript">
				_index.m2 = '<%=request.getParameter("_index_m2")%>';
				_index.m3 = '<%=request.getParameter("_index_m3")%>';
				//console.log(_index.m2+";"+_index.m3);
			</script>
			<!-- 左侧公共菜单	读取数据库 -->
            <div class="col-md-3 left_col">
                <div class="left_col scroll-view">
					
					<!-- 父级菜单 -->
                    <div class="navbar nav_title">
                        <a href="javascript:;" class="site_title">
                        	<i class="fa fa-cog"></i>
                        	<span>配置中心</span>
                        </a>
                    </div>
					<!-- /父级菜单 -->

                    <!-- 左侧公共菜单 -->
                    <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
                        <div class="menu_section">
                            <ul class="nav side-menu">
                            	<li data-id="601" id="loan_manage" class="li_level_one">
                            		<a><i class="fa fa-edit"></i>财务设置<span class="fa fa-chevron-down"></span></a>
                            		<ul class="nav child_menu ul_level_one" style="display: none">
                            			<li data-id="60101"><a href="web/config/config.jsp">提现手续费设置</a></li>
                            			<li data-id="60102"><a href="web/config/charge-fee.jsp">充值手续费设置</a></li>
                            			<li data-id="60103"><a href="config/toCashExamPg.do">提现审核</a></li>
                            			<li data-id="60104"><a href="config/toAssignmentPage.do">债权转让设置</a></li>
                            			<li data-id="60105"><a href="config/toOverdueLimit.do">逾期配置</a></li>
                            			<li data-id="60106"><a href="config/toRectalSetList">推荐达人提奖设置</a></li>
                            			<li data-id="60107"><a href="config/toFinadvSetting.do">理财顾问提奖设置</a></li>
                            			<li data-id="60108"><a href="web/config/invest-fee.jsp">投资管理费设置</a></li>
                            			<li data-id="60109"><a href="web/config/auto-bid.jsp">自动投标奖励设置</a></li>
                            			<li data-id="60110"><a href="web/config/red-voucher.jsp">红包、代金券提醒设置</a></li>
                            		</ul>
                            	</li>
                               	<li data-id="602" id="department"><a href="web/config/platform.jsp"><i class="fa fa-home"></i>平台设置</a></li>
                               	<li data-id="603" id="loan_manage" class="li_level_one">
                            		<a><i class="fa fa-edit"></i>短信设置<span class="fa fa-chevron-down"></span></a>
                            		<ul class="nav child_menu ul_level_one" style="display: none">
                            			<li data-id="60301"><a href="config/toMsgContentSet">消息内容配置</a></li>
                            			<li data-id="60302"><a href="config/toMsgAlertPg">消息提醒设置</a></li>
                            			<li data-id="60303"><a href="web/config/msg-post.jsp">消息发送历史</a></li>
                            			<li data-id="60304"><a href="config/toMsgInterface">消息接口配置</a></li>

                            		</ul>
                            	</li>
                               	<li data-id="604"><a href="web/config/test-interface.jsp"><i class="fa fa-edit"></i>托管平台设置</a></li>
                                <li data-id="605"><a href="config/toMemberGradeList.do"><i class="fa fa-edit"></i>会员等级配置</a></li>       
                                <li data-id="606"><a href="config/toMemberCreditList.do"><i class="fa fa-edit"></i>会员信用等级配置</a></li>
                                <li data-id="607"><a href="web/config/frontloan-msg.jsp"><i class="fa fa-edit"></i>前台借款信息填写配置</a></li>
                                <li data-id="608"><a href="web/config/proexam-point.jsp"><i class="fa fa-edit"></i>项目审批流程配置</a></li>
                                <li data-id="609"><a href="web/config/vipset.jsp"><i class="fa fa-edit"></i>VIP配置</a></li>
                                <li data-id="610"><a href="web/config/agreement.jsp"><i class="fa fa-edit"></i>协议配置</a></li>       
                                <li data-id="611"><a href="web/config/bill-collection.jsp"><i class="fa fa-edit"></i>账单催收</a> </li>
                               	<li data-id="612"><a href="web/config/loan-items.jsp"><i class="fa fa-edit"></i>借款认证项配置</a></li>
                               	<li data-id="613" id="" class="li_level_one">
                            		<a><i class="fa fa-edit"></i>积分规则设置<span class="fa fa-chevron-down"></span></a>
                            		<ul class="nav child_menu ul_level_one" style="display: none">
                            			<li data-id="61301"><a href="web/config/integral-rule.jsp">会员积分规则设置</a></li>
                            			<li data-id="61302"><a href="web/config/talent-integral-rule.jsp">推荐达人积分规则设置</a></li>
                            			<li data-id="61303"><a href="web/config/advisor-integral-rule.jsp">理财顾问积分规则设置</a></li>
                            		</ul>
                            	</li>
                            </ul>
                        </div>
                    </div>
                    <!-- /左侧公共菜单 -->

                    <!-- 尾部控制按钮 -->
                    <!-- /尾部控制按钮 -->
                    
                </div>
            </div>


		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		