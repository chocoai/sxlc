<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
	<base href="<%=basePath%>">
	<title>项目发布</title>
	<!-- 公用meta -->
	<jsp:include page="../../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link rel="stylesheet" href="css/project/post_list.css" type="text/css"></link>
	<link rel="stylesheet" href="css/project/loan_pro_post.css" />
	<link rel="stylesheet" href="plugs/webuploader/0.1.5/webuploader.css" />
	<link rel="stylesheet" href="css/upload.css" />
</head>
<!-- 项目发布--------列表信息查询展示 -->
<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../../common/cm-top.jsp">
				<jsp:param value="3" name="_index_m1"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../../common/cm-project.jsp">
				<jsp:param value="304" name="_index_m2"/>
				<jsp:param value="" name="_index_m3"/>
			</jsp:include>
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../../common/cm-addr.jsp"></jsp:include>
				<div id="checkDetail">
					<div class="container add_type_contianer">
						<div class="container body addContainer">
							<div class="main_container">
								<div class="w-content ishow pic-add">
									<!-- 信息展示模块 -->
									<div class="infoDisplay">
										<fieldset>
											<legend>项目基本信息</legend>
											<table>
												<tr class="col-md-4">
													<td class="tt"><label>借款项目名称：</label></td>
													<td class="con">借款项目名称</td>
												</tr>	
												<tr class="col-md-4">
													<td class="tt"><label>借款金额：</label></td>
													<td class="con">借款金额</td>
												</tr>
												<tr class="col-md-4">
													<td class="tt"><label>还款方式：</label></td>
													<td class="con">还款方式</td>
												</tr>
												<tr class="col-md-4">
													<td class="tt"><label>还款保障：</label></td>
													<td class="con">还款保障</td>
												</tr>
												<tr class="col-md-4">
													<td class="tt"><label>借款用途：</label></td>
													<td class="con">借款用途</td>
												</tr>
												<tr class="col-md-4">
													<td class="tt"><label>还款来源：</label></td>
													<td class="con">还款来源</td>
												</tr>
												<tr class="col-md-4">
													<td class="tt"><label>借款期限：</label></td>
													<td class="con">借款期限</td>
												</tr>
												<tr class="col-md-4">
													<td class="tt"><label>最大投资比例：</label></td>
													<td class="con">设置最大投资比例</td>
												</tr>
												<tr class="col-md-4">
													<td class="tt"><label>年化利率：</label></td>
													<td class="con">年化利率</td>
												</tr>
												<tr class="col-md-4">
													<td class="tt"><label>起投金额：</label></td>
													<td class="con">起投金额</td>
												</tr>
												<tr class="col-md-4">
													<td class="tt"><label>加价幅度：</label></td>
													<td class="con">加价幅度</td>
												</tr>
												<tr class="col-md-4">
													<td class="tt"><label>投资上限：</label></td>
													<td class="con">投资上限</td>
												</tr>
												<tr class="col-md-4">
													<td class="tt"><label>项目描述：</label></td>
													<td class="con">项目描述</td>
												</tr>
												<tr class="col-md-7 col-md-offset-5">	
													<td class="tt">
														<button class="btn btn-info btnMod">修改</button>
													</td>
												</tr>
											</table>
										</fieldset>
									</div><!-- 信息展示模块结束 -->
									<!-- 信息修改模块开始 -->
									<div class="infoMod" style="display:none">
										<fieldset>
											<legend>项目基本信息修改</legend>
											<table>
												<tr class="col-md-4">
													<td class="tt"><label>借款项目名称：</label></td>
													<td class="con"><input type="text"></td>
												</tr>	
												<tr class="col-md-4">
													<td class="tt"><label>借款金额：</label></td>
													<td class="con"><input type="text"></td>
												</tr>
												<tr class="col-md-4">
													<td class="tt"><label>还款方式：</label></td>
													<td class="con"><input type="text"></td>
												</tr>
												<tr class="col-md-4">
													<td class="tt"><label>还款保障：</label></td>
													<td class="con"><input type="text"></td>
												</tr>
												<tr class="col-md-4">
													<td class="tt"><label>借款用途：</label></td>
													<td class="con"><input type="text"></td>
												</tr>
												<tr class="col-md-4">
													<td class="tt"><label>还款来源：</label></td>
													<td class="con"><input type="text"></td>
												</tr>
												<tr class="col-md-4">
													<td class="tt"><label>借款期限：</label></td>
													<td class="con"><input type="text"></td>
												</tr>
												<tr class="col-md-4">
													<td class="tt"><label>最大投资比例：</label></td>
													<td class="con"><input type="text"></td>
												</tr>
												<tr class="col-md-4">
													<td class="tt"><label>年化利率：</label></td>
													<td class="con"><input type="text"></td>
												</tr>
												<tr class="col-md-4">
													<td class="tt"><label>起投金额：</label></td>
													<td class="con"><input type="text"></td>
												</tr>
												<tr class="col-md-4">
													<td class="tt"><label>加价幅度：</label></td>
													<td class="con"><input type="text"></td>
												</tr>
												<tr class="col-md-4">
													<td class="tt"><label>投资上限：</label></td>
													<td class="con"><input type="text"></td>
												</tr>
												<tr class="col-md-4">
													<td class="tt"><label>项目描述：</label></td>
													<td class="con"><input type="text"></td>
												</tr>
												<tr class="col-md-7 col-md-offset-5">
													<td class="tt">
														<button class="btn btn-success btnPreserve">保存</button>
														<button class="btn btn-default btnCancel">取消</button>
													</td>
												</tr>
											</table>
										</fieldset>
									</div><!-- 信息修改模块结束 -->
									<!-- 认证展示模块 -->
									<fieldset class="person" style="display:block"><!-- 个人信息 -->
										<legend>会员基本信息</legend>
										<div class="w-content ishow">
											<table>
												<tr class="col-md-3">
													<td class="tt"><label>会员编号：</label></td>
													<td class="con">012304</td>
												</tr>
												<tr class="col-md-3">
													<td class="tt"><label>会员用户名：</label></td>
													<td class="con">会员用户名</td>
												</tr>
												<tr class="col-md-3">
													<td class="tt"><label>真实姓名：</label></td>
													<td class="con">真实姓名</td>
												</tr>
												<tr class="col-md-3">
													<td class="tt"><label>身份证号：</label></td>
													<td class="con">748590339285559401</td>
												</tr>
												<tr class="col-md-3">
													<td class="tt"><label>手机号码：</label></td>
													<td class="con">18454845847</td>
												</tr>
												<tr class="col-md-3">
													<td class="tt"><label>最高学历：</label></td>
													<td class="con">本科</td>
												</tr>
												<tr class="col-md-3">
													<td class="tt"><label>婚姻状况：</label></td>
													<td class="con">已婚</td>
												</tr>
												<tr class="col-md-3">
													<td class="tt"><label>地区：</label></td>
													<td class="con">北京</td>
												</tr>
												<tr class="col-md-3">
													<td class="tt"><label>月均收入：</label></td>
													<td class="con">10000<span>元</span></td>
												</tr>
												<tr class="col-md-3">
													<td class="tt"><label>注册时间：</label></td>
													<td class="con">2016-4-20</td>
												</tr>
											</table>
										</div>
									</fieldset>
									<fieldset class="enterprise" style="display:none"><!-- 企业信息 -->
										<legend>会员基本信息</legend>
										<div class="w-content ishow">
											<table>
												<tr class="col-md-3">
													<td class="tt"><label>会员编号：</label></td>
													<td class="con">0231322</td>
												</tr>
												<tr class="col-md-3">
													<td class="tt"><label>会员用户名：</label></td>
													<td class="con">会员用户名</td>
												</tr>
												<tr class="col-md-3">
													<td class="tt"><label>企业名称：</label></td>
													<td class="con">企业名称</td>
												</tr>
												<tr class="col-md-3">
													<td class="tt"><label>营业执照号：</label></td>
													<td class="con">0231322</td>
												</tr>
												<tr class="col-md-3">
													<td class="tt"><label>联系人：</label></td>
													<td class="con">哈哈</td>
												</tr>
												<tr class="col-md-3">
													<td class="tt"><label>联系人手机号：</label></td>
													<td class="con">18454845847</td>
												</tr>
												<tr class="col-md-3">
													<td class="tt"><label>地区：</label></td>
													<td class="con">北极</td>
												</tr>
												<tr class="col-md-3">
													<td class="tt"><label>注册时间：</label></td>
													<td class="con">2016-04-27</td>
												</tr>
											</table>
										</div>
									</fieldset><!-- 认证展示模块结束 -->
									<!-- 信用统计模块 -->
									<fieldset>
										<legend>借款信用统计</legend>
										<div class="w-content ishow">
											<table>
												<tr class="col-md-3">
													<td class="tt"><label>成功借款：</label></td>
													<td class="con">10<span>笔</span></td>
												</tr>
												<tr class="col-md-3">
													<td class="tt"><label>成功还款：</label></td>
													<td class="con">10<span>笔</span></td>
												</tr>
												<tr class="col-md-3">
													<td class="tt"><label>成功投资：</label></td>
													<td class="con">10<span>笔</span></td>
												</tr>
												<tr class="col-md-3">
													<td class="tt"><label>逾期还款：</label></td>
													<td class="con">10<span>笔</span></td>
												</tr>
												<tr class="col-md-3">
													<td class="tt"><label>严重逾期还款：</label></td>
													<td class="con">10<span>笔</span></td>
												</tr>
												<tr class="col-md-3">
													<td class="tt"><label>逾期未还款：</label></td>
													<td class="con">10<span>笔</span></td>
												</tr>
												<tr class="col-md-3">
													<td class="tt"><label>提前还款：</label></td>
													<td class="con">10<span>笔</span></td>
												</tr>
											</table>
										</div>
									</fieldset><!-- 信用统计模块结束 -->
									<!-- 投资统计模块 -->
									<fieldset>
										<legend>投资统计信息</legend>
										<div class="w-content ishow">
											<table>
												<tr class="col-md-3">
													<td class="tt"><label>成功投资笔数：</label></td>
													<td class="con">10<span>笔</span></td>
												</tr>
												<tr class="col-md-3">
													<td class="tt"><label>成功投资笔数：</label></td>
													<td class="con">100<span>元</span></td>
												</tr>
												<tr class="col-md-3">
													<td class="tt"><label>成功投资笔数：</label></td>
													<td class="con">100<span>元</span></td>
												</tr>
												<tr class="col-md-3">
													<td class="tt"><label>累计已收收益：</label></td>
													<td class="con">100<span>元</span></td>
												</tr>
												<tr class="col-md-3">
													<td class="tt"><label>待收本金：</label></td>
													<td class="con">100<span>元</span></td>
												</tr>
												<tr class="col-md-3">
													<td class="tt"><label>待收收益：</label></td>
													<td class="con">100<span>元</span></td>
												</tr>
											</table>
										</div>
									</fieldset><!-- 投资统计模块结束 -->
									<!-- 认证模块 -->
									<fieldset class="personAuthentication"><!-- 个人认证 -->
										<legend>借款会员认证信息</legend>
										<div class="w-content ishow">
											<table>
												<tr>
													<td class="tt"><a>实名认证</a></td>
													<td class="tt"><a>手机认证</a></td>
													<td class="tt"><a>征信认证</a></td>
													<td class="tt"><a>住址认证</a></td>
													<td class="tt"><a>婚姻认证</a></td>
													<td class="tt"><a>工作认证</a></td>
													<td class="tt"><a>学历认证</a></td>
													<td class="tt"><a>股权认证</a></td>
												</tr>
												<tr>
													<td class="tt"><a>职称认证</a></td>
													<td class="tt"><a>社保认证</a></td>
													<td class="tt"><a>房产认证</a></td>
													<td class="tt"><a>车产认证</a></td>
													<td class="tt"><a>银行流水认证</a></td>
													<td class="tt"><a>其它</a></td>
												</tr>
											</table>
										</div>
									</fieldset>
									<fieldset class="enterpriseAuthentication" style="display:none"><!-- 企业认证 -->
										<legend>借款会员认证信息</legend>
										<div class="w-content ishow">
											<table>
												<tr>
													<td class="ts"><a>营业执照认证</a></td>
													<td class="ts"><a>工商执照认证</a></td>
													<td class="ts"><a>组织机构代码认证</a></td>
													<td class="ts"><a>开户许可证认证</a></td>
													<td class="ts"><a>企业银行流水认证</a></td>
													<td class="ts"><a>实地考察认证</a></td>
													<td class="ts"><a>税务登记认证</a></td>
													<td class="ts"><a>批文认证认证</a></td>
												</tr>
												<tr>
													<td class="ts"><a>财务资料认证</a></td>
													<td class="ts"><a>监管单位认证</a></td>
													<td class="ts"><a>房产认证</a></td>
													<td class="ts"><a>车产认证</a></td>
													<td class="ts"><a>担保考察认证</a></td>
													<td class="ts"><a>法人身份认证</a></td>
													<td class="ts"><a>其它</a></td>
												</tr>
											</table>
										</div>
									</fieldset><!-- 项目申请附件信息-->
									<div class="infoDisplay">
										<fieldset>
											<legend>项目申请附件信息</legend>
											<table>
												<tr>
													<td class="applayImg"><div><img src="resources/img/business license.jpg"></div><span>附件图片</span></td>
													<td class="applayImg"><div><img src="resources/img/scale.jpg.bmp"></div><span>附件压缩包</span></td>
												</tr>
											</table>
										</fieldset>
									</div><!-- 项目申请附件信息结束 -->
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- tab切换 -->
				<ul class="nav nav-tabs">
					<li role="presentation" class="active"><a href="javascript:;">历史审核记录</a></li>
					<li role="presentation"><a href="javascript:;">历史审核附件</a></li>
					<li role="presentation"><a href="javascript:;">附件删除记录</a></li>
				</ul>
				<!-- 第一页基本信息结束 -->
				<!-- 审核记录审核附件删除记录 -->
				<div class="nav-tabs-con active">
					<div class="data_display">
						<div class="panel panel-success">
							<div class="panel-body">
								<table id="table_history_record" class="display">
									<thead>
										<tr>
											<th></th>
							                <th>审核管理员名称</th>
							                <th>审核点</th>
							                <th>审核时间</th>
							                <th>审核状态</th>
							                <th>审核意见</th>			                
							            </tr>
							        </thead>
							        <tbody>
							        <%for (int i = 0; i < 15; i++) {%>
							        	<tr>
							        		<td><input type="checkbox"></td>
							        		<td>管理员名称</td>
							                <td>审核点</td>
							                <td>2016-04-26</td>
							                <td>同意</td>
							                <td>意见</td>
							            </tr>
									<%}%>
							       	</tbody>
							    </table>
						    </div>
						</div>
					</div>
				</div>
				<div class="nav-tabs-con">
					<div class="data_display">	
						<div class="panel panel-success">
						    <div class="panel-body">
								<table id="table_history_enclosure" class="display">
									<thead>
										<tr>
											<th></th>
							                <th>附件名称</th>
							                <th>上传审核点</th>
							                <th>上传审核管理员名称</th>
							                <th>上传时间</th>
							                <th>备注</th>
							                <th>操作</th>			                
							            </tr>
							        </thead>
							        <tbody>
							        <%for (int i = 0; i < 15; i++) {%>
							        	<tr>
							        		<td><input type="checkbox"></td>
							        		<td>附件名称</td>
							                <td>上传审核点</td>
							                <td>管理员名称</td>
							                <td>2016-04-26</td>
							                <td>备注</td>
							                <td>
							                	<a href="javascript:;" class="btn-delete" onclick="del()">删除</a>
							                	<a href="javascript:;" class="btn-delete" onclick="down()">下载</a>
											</td>
							            </tr>
									<%}%>
							       	</tbody>
							    </table>
						    </div>
						</div>
					</div>
				</div>
				<div class="nav-tabs-con">
					<div class="data_display">
						<div class="panel panel-success">
							<div class="panel-body">
								<table id="table_history_del" class="display">
									<thead>
										<tr>
											<th></th>
							                <th>附件名称</th>
							                <th>上传审核点</th>
							                <th>操作删除管理员名称</th>
							                <th>删除时间</th>
							                <th>备注</th>
							            </tr>
							        </thead>
							        <tbody>
							        <%for (int i = 0; i < 15; i++) {%>
							        	<tr>
							        		<td><input type="checkbox"></td>
							        		<td>附件名称</td>
							                <td>上传审核点</td>
							                <td>管理员名称</td>
							                <td>2016-04-26</td>
							                <td>备注</td>
							            </tr>
									<%}%>
							       	</tbody>
						    	</table>
						    </div>
						</div>
					</div>
				</div>
				<!-- 审核记录审核附件删除记录结束 -->
				<fieldset class="uploadEnclosure">
					<legend>上传项目图片</legend>
					<table>
						<tr>
							<td class="tt">上传项目形象图片：</td>
							<td class="con">
								<!--dom结构部分-->
								<div id="uploader">
								    <!--用来存放item-->
								    <div id="filePicker">图片选择</div>
								</div>
							</td>
						</tr>
						<tr>
							<td class="tt" valign="top"></td>
							<td class="con" id="fileList"></td>
						</tr>
						<tr>
							<td class="tt">上传项目前台显示图片：</td>
							<td class="con">
								<!--dom结构部分-->
								<div >
								    <!--用来存放item-->
								    <div id="filePicker1">图片选择</div>
								</div>
							</td>
						</tr>
						<tr>
							<td class="tt" valign="top"></td>
							<td class="con fileList" id="fileList1"></td>
						</tr>
						<tr>
							<td class="tt">选择项目起止时间:</td>
							<td class="con"><input type="text" id="startDate" class="dateInput Wdate" onFocus="WdatePicker({maxDate: '#F{$dp.$D(\'endDate\')||\'2020-10-01\'}' })" ><span class="line"></span><input type="text" id="endDate" class="dateInput Wdate"  onFocus="WdatePicker({minDate: '#F{$dp.$D(\'startDate\')}' ,maxDate:'2020-10-01' })" ></td>
						</tr>
					</table>
					<div class="preserveBtn">
						<button class="btn btn-success btnPreserve">发布</button>
						<button class="btn btn-default btnCancel">取消</button>
					</div>
				</fieldset>
			</div>
		</div>
		<!-- 公用js -->
		<jsp:include page="../../common/cm-js.jsp"></jsp:include>
		<!-- 私用js -->
		<script src="js/project/post_list.js"></script>
		<script type="text/javascript" src="js/project/loan_pro_exam.js"></script>
		<script type="text/javascript" src="plugs/webuploader/0.1.5/webuploader.js"></script>
		<script type="text/javascript" src="js/project/loan_pro_post.js"></script>
	</div>

</body>

</html>



