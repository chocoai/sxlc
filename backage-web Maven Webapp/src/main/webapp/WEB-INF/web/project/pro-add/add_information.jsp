<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<jsp:include page="../../common/cm-addr.jsp"></jsp:include>
<div class="" id="checkDetail">
	<div class="container add_type_contianer">
		<div class="w-content ishow">
		<!-- 认证信息 -->
			<fieldset class="personAuthentication">
				<legend>借款会员认证信息——个人</legend>
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
			<fieldset class="enterproiseAuthentication" style="display:none">
				<legend>借款会员认证信息——企业</legend>
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
			</fieldset>
			<!-- 借款详细信息展示 -->
			<fieldset class="infoDisplay">
				<legend>借款详细信息</legend>
				<table>
					<tr class="col-md-6">
						<td class="tt"><label>借款金额：</label></td>
						<td class="con">
							<span class="moneyFormat">200000</span>元
						</td>
					</tr>
					<tr class="col-md-6">
						<td class="tt"><label>还款保障：</label></td>
						<td class="con">
							<span>还款保障</span>
						</td>
					</tr>
					<tr class="col-md-6">
						<td class="tt"><label>借款项目类型：</label></td>
						<td class="con">
							<span>借款项目类型</span>
						</td>
					</tr>
					<tr class="col-md-6">
						<td class="tt"><label>借款期限：</label></td>
						<td class="con">
							<span>借款期限</span>
						</td>
					</tr>
					<tr class="col-md-6">
						<td class="tt"><label>还款来源：</label></td>
						<td class="con">
							<span>还款来源</span>
						</td>
					</tr>
					<tr class="col-md-6">
						<td class="tt"><label>借款用途：</label></td>
						<td class="con">
							<span>借款用途</span>
						</td>
					</tr>
					<tr class="col-md-6">
						<td class="tt"><label>抵押物描述：</label></td>
						<td class="con">
							<span>抵押物描述</span>
						</td>
					</tr>
				</table>
			</fieldset>
			<!-- 借款详细信息修改 -->
			<fieldset class="modInfo">
			<form id="modInfo">		
			<table>
				<tr class="col-md-6">
					<td class="tt"><label>借款项目名称：</label></td>
					<td class="con">
						<input type="text" class="enterN-r " datatype="enterNameR" maxlength="16">
					</td>
				</tr>
				<tr class="col-md-6">
					<td class="tt"><label>借款金额：</label></td>
					<td class="con">
						<input type="text" class="loanMoney numberReg" datatype="amcountM" maxlength="8">
					</td>
				</tr>				
				<tr class="col-md-6">
					<td class="tt"><label>借款期限：</label></td>
					<td class="con">
						<input type="text" class="con-term numberReg" datatype="nNum0" maxlength="6">
						<select class="conT">
							<option>天</option>
							<option>月</option> 
							<option>年</option>
						</select>
					</td>
				</tr>
				<tr class="col-md-6">
					<td class="tt ttMax"><label>最大投资比例：</label></td>
					<td class="con">
						<input type="text" class="con-PP numberReg" datatype="hundredNum" maxlength="3">
						<span>%</span>
					</td>
				</tr>
				<tr class="col-md-6">
					<td class="tt"><label>年化利率：</label></td>
					<td class="con">
						<input type="text" class="startTY numberReg" datatype="hundredNum" maxlength="3">
						<span>%</span>
					</td>
				</tr>
				<tr class="col-md-6">
					<td class="tt"><label>起投金额：</label></td>
					<td class="con">
						<input type="text" class="startingIA numberReg" datatype="amcountM" maxlength="8">
						<span>元</span>
					</td>
				</tr>
				<tr class="col-md-6">
					<td class="tt"><label>加价幅度：</label></td>
					<td class="con">
						<input type="text" class="conIncrease numberReg" datatype="amcountM" maxlength="8">
						<span>元</span>
					</td>
				</tr>
				<tr class="col-md-12">
					<td class="tt"><label>还款方式：</label></td>
					<td class="con">
						<select>
							<option>等额本金</option>
							<option>等额本息</option>
							<option>先息后本</option>
							<option>到期还本息</option>
						</select>
					</td>
				</tr>
				<tr class="col-md-12">
					<td class="tt"><label>还款保障：</label></td>
					<td class="con" id="Repayment-g">
						<textarea cols="20" rows="3" name="" maxlength="125"></textarea>
					</td>
				</tr>
				<tr class="col-md-12">
					<td class="tt"><label>借款用途：</label></td>
					<td class="con" id="usage-loan">
						<textarea cols="20" rows="3" name="" maxlength="125"></textarea>
					</td>
				</tr>
				<tr class="col-md-12">
					<td class="tt"><label>项目描述：</label></td>
					<td class="con" id="con-Increase">
						<textarea cols="20" rows="3" name="" maxlength="200"></textarea>
					</td>
				</tr>
				<tr class="col-md-12">
					<td class="tt dyInfo"><label>抵押物描述：</label></td>
					<td class="con">
						<script id="payguide" type="text/plain" style="width:100%"></script>
					</td>
				</tr>
				<tr class="col-md-8 col-md-offset-4">
					<td class="tt"></td>
					<td class="con">
						<button type="submit" class="btn btn-success nextBtn">下一步</button>
						<button type="submit" class="btn btn-default"  onclick="window.location.href='web/project/loan_intention_1.jsp';">返回</button>
					</td>
				</tr>
				</table>
				</form>
				</fieldset>
				<!-- 下一步部分 -->
				<fieldset class="nextField" style="display:none">
					<form id="next_field">
					<table>
					<!-- 自动投标 -->
					<tr class="col-md-12">
						<td class="tt auto_bid"><label>自动投标：</label></td>
						<td class="con">
							<span>投标开始后</span>
							<input type="text" class="autoBid numberReg" maxlength="6">
							<span>分钟开始执行自动投标，自动投标总金额占比</span>
							<input type="text" class="autoBid numberReg" maxlength="3">
							<span>%</span>
						</td>
					</tr><!-- 自动投标结束 -->
					<tr class="col-md-12">
						<td class="tt"><input type="checkbox" class="check_select">是否为加息标：</td>
						<td class="con con-width">
							<span>添加利息：</span>
							<input type="text" class="select_able numberReg" datatype="hundredNum" disabled='disabled' datatype="nNum0" maxlength="6">
							<span>%</span>
						</td>
					</tr>
					<tr class="col-md-12">
						<td class="tt"><input type="checkbox" class="check_select">是否为定向标：</td>
						<td class="con con-width">
							<span>投资密码：</span>
							<input type="password" class="select_able" disabled='disabled' datatype="newpass" maxlength="16">
						</td>
					</tr>
					<tr class="col-md-12">
						<td class="tt"><input type="checkbox" class="check_select">是否为奖励标：</td>
						<td class="con con-width">
							<span>返现：本金*</span>
							<input type="text" class="select_able numberReg" disabled='disabled' datatype="hundredNum" maxlength="6">
							<span>%</span>
						</td>
					</tr>
					<tr class="col-md-12 red_surprise">
						<td class="tt red_packets"><input type="checkbox" class="check_select2">是否为红包惊喜标：</td>
						<td class="con con-money">
							<span class="addRed">+</span>
							<span class="reduceRed">—</span>
							<ul class="red_list">
								<li class="red_add">
									<span>投资达到</span>
									<input class="redPack numberReg" disabled='disabled' maxlength="8">
									<span>元的前</span>
									<input class="redPack numberReg" disabled='disabled' maxlength="8">
									<span>个，平台代付</span>
									<input class="redPack numberReg" disabled='disabled' maxlength="8">
									<span>元红包</span>
								</li>
							</ul>
						</td>
					</tr>	
					<tr class="col-md-12">
						<!-- 选择担保机构 -->
						<td class="tt"><input type="checkbox" class="check_select">担保机构：</td>
						<td class="con con-width">
							<button class="add_mechanism">选择担保机构</button>
							<span class="mechanism"></span>
							<input type="text" class="select_able numberReg" disabled='disabled' maxlength="8">
							<select class="unit_select">
								<option>%</option>
								<option>元</option>
							</select>
						</td>
					</tr>	
					<tr class="col-md-12">
						<td class="tt"><input type="checkbox" class="check_select">资产管理方：</td>
						<td class="con con-width">
							<button class="add_assetManagement">选择资产管理方</button>
							<span class="assetManagement"></span>
							<input type="text" class="select_able numberReg" disabled='disabled' maxlength="8">
							<span>%</span>
						</td>
					</tr>	
					<tr class="col-md-12">
						<td class="tt"><input type="checkbox" class="check_select">项目风险保证金：</td>
						<td class="con con-width" id="conProM">
							<input type="text" class="select_able numberReg" disabled='disabled' maxlength="8">
							<select class="unit_select">
								<option>%</option>
								<option>元</option>
							</select>
						</td>
					</tr>				
					<tr class="col-md-12">
						<td class="tt"><input type="checkbox" class="check_select">收取借款管理费 ：</td>
						<td class="con con-width" id="conSQJKF">
							<input type="text" class="select_able" disabled='disabled' maxlength="6"><span>%</span>
						</td>
					</tr>				
					<tr class="col-md-12">
						<td class="tt"><label>允许投标人数 ：</label></td>
						<td class="con con-width" id="numberOF">
							<input type="text" class="select_able numberReg" datatype="nNum0" maxlength="8"><span>人</span>
						</td>
					</tr>
					<tr class="col-md-8 col-md-offset-4">
						<td class="tt"></td>
						<td class="con">
							<button type="submit" class="btn btn-success appendixUpload">上传申请附件</button>
							<button type="submit" class="btn btn-success btn-pre">保存</button>
							<button type="submit" class="btn btn-default beforeBtn">返回</button>
						</td>
					</tr>
				</table>
				</form>
			</fieldset>
			<fieldset class="appendix" style="display:none">
			<!-- 附件信息修改 -->
				<table>
					<tr class="col-md-12">					
						<td class="tt"><label>申请附件类型：</label></td>
						<td class="con">
							<select class="doc">
								<option>附件类型</option>
								<option>借款方信息</option>
								<option>抵押信息</option>
								<option>现场调查信息</option>
								<option>其它</option>
							</select>
						</td>
					</tr>
					<tr class="col-md-12">
						<td class="tt"><label>附件标题：</label></td>
						<td class="con conAddTitle" id="addTitle">
							<input type="text" class=" add-title" datatype="roleNameb" value="" >
						</td>
					</tr>	
					<tr class="col-md-12">
						<td class="tt"><label>上传申请附件：</label></td>
						<td class="con">
							<div id="logo">
							    <!--用来存放item-->
							    <div id="filePicker">上传附件</div>
							    <span class="rec-dimensions">*可图片、文档、压缩包</span>
							</div>
						</td>
					</tr><!-- 附件添加结束 -->
					<tr class="col-md-8 col-md-offset-4">
						<td class="tt"></td>
						<td class="con">
							<button type="submit" class="btn btn-success preBack">保存并返回</button>
							<button type="submit" class="btn btn-default cancel">取消</button>
						</td>
					</tr>
				</table>
			</fieldset>		
		</div>
	</div>
</div>
<!-- 担保机构选择弹出层伍成然 -->
<div class="select_mechanism" style="display:none">
	<input type="radio" name="mechanism" value="1">机构1
	<input type="radio" name="mechanism" value="2">机构2
	<input type="radio" name="mechanism" value="3">机构3
	<input type="radio" name="mechanism" value="4">机构4
	<input type="radio" name="mechanism" value="5">机构5
	<input type="radio" name="mechanism" value="6">机构6
	<input type="radio" name="mechanism" value="7">机构7
</div>
<!-- 资产管理方选择弹出层伍成然 -->
<div class="select_assetManagement" style="display:none">
	<input type="radio" name="assetManagement" value="1">资产管理方1
	<input type="radio" name="assetManagement" value="2">资产管理方2
	<input type="radio" name="assetManagement" value="3">资产管理方3
	<input type="radio" name="assetManagement" value="4">资产管理方4
	<input type="radio" name="assetManagement" value="5">资产管理方5
	<input type="radio" name="assetManagement" value="6">资产管理方6
	<input type="radio" name="assetManagement" value="7">资产管理方7
</div>
<!-- 公用js -->
<script type="text/javascript" src="plugs/webuploader/0.1.5/webuploader.js"></script>
<script type="text/javascript" src="js/project/loanapply-upload.js"></script>
<!-- 私用js -->
<script type="text/javascript" src="js/project/add_info.js"></script>