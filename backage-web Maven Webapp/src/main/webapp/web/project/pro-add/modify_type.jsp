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
			<table style="width:100%;">
				<tr>
					<td class="tt"><label class="ineed">类型名称：</label></td>
					<td class="con" id="roleNamea"><input type="text" class="proKindName" datatype="roleNamea" maxlength="6"></td>
				</tr>
				<tr>
					<td class="tt"><label class="ineed">融资额度：</label></td>
					<td class="con" id="account">
					<input type="text" class="beginAccount" datatype="nNum0" maxlength="8">
					<span>——</span>
					<input type="text" class="endAccount"  datatype="nNum0"  maxlength="8">
					<span>元</span>
					</td>
				</tr>
				<tr>
					<td class="tt">年化利率：</td>
					<td class="con" id="theYear">
					<input type="text" class="startTheYear beginTime"  datatype="hundredNum"  maxlength="5">
					<span>——</span>
					<input type="text" class="endTheYear endTime" datatype="hundredNum"  maxlength="5">
					<span>%</span>
					</td>					
				</tr>
				<tr>
					<td class="tt">项目期限：</td>
					<td class="con" id="con-time">
						<input type="text" class="beginTime bgTime" datatype="nNum0" maxlength="4">
						<span>——</span>
						<input type="text" class="endTime edTime" datatype="nNum0" maxlength="4">
					</td>					
				</tr>
				<tr>
					<td class="tt">年:</td>
					<td class="con" id="con-timeY">
						<input type="text" class="beginTime bgTimeY" datatype="nNum0" maxlength="4">
						<span>——</span>
						<input type="text" class="endTime edTimeY" datatype="nNum0" maxlength="4">
					</td>					
				</tr>
				<tr>
					<td class="tt">月:</td>
					<td class="con" id="con-timeM">
						<input type="text" class="beginTime bgTimeM" datatype="nNum0" maxlength="4">
						<span>——</span>
						<input type="text" class="endTime edTimeM" datatype="nNum0" maxlength="4">
					</td>					
				</tr>
				<tr>
					<td class="tt">天:</td>
					<td class="con" id="con-timeD">
						<input type="text" class="beginTime bgTimeD" datatype="nNum0" maxlength="4">
						<span>——</span>
						<input type="text" class="endTime edTimeD" datatype="nNum0" maxlength="4">
					</td>					
				</tr>
				<tr>
					<td class="tt">是否要抵押：</td>
					<td class="con">
						<select class="assettype">
							<option>请选择</option>
							<option>是</option>
							<option>否</option>		
						</select>
					</td>
				</tr>
				<tr>
					<td class="tt">产品认证项：</td>
					<td class="con">
						<select class="identitySelection">
							<option>请选择</option>
							<option>全部</option>
							<option>个人</option>
							<option>企业</option>		
						</select>
					</td>
				</tr>
				<tr>
					<td></td>
					<td>
						<div class="con-whole">
							<div class="person" style="display:none">
								<p>个人认证：</p>
								<div class="con-next">
									<span><input type="checkbox">实名认证</span>
									<span><input type="checkbox">现场认证</span>
									<span><input type="checkbox">征信认证</span>
									<span><input type="checkbox">住址认证</span>
									<span><input type="checkbox">职称认证</span>
									<span><input type="checkbox">社保认证</span>
									<span><input type="checkbox">房产认证</span>
									<span><input type="checkbox">车产认证</span>
									<span><input type="checkbox">银行流水认证</span>
									<span><input type="checkbox">婚姻认证</span>
									<span><input type="checkbox">学历认证</span>
								</div>
							</div>
							<div class="enterprise" style="display:none">
								<p>企业认证：</p>
								<div class="con-next">
									<span><input type="checkbox">营业执照认证</span>
									<span><input type="checkbox">工商执照认证</span>
									<span><input type="checkbox">组织机构代码认证</span>
									<span><input type="checkbox">开户许可证认证</span>
									<span><input type="checkbox">企业银行流水认证</span>
									<span><input type="checkbox">实地考察认证</span>
									<span><input type="checkbox">税务登记认证</span>
									<span><input type="checkbox">批文认证</span>
									<span><input type="checkbox">财务资料认证</span>
									<span><input type="checkbox">监管单位认证</span>
									<span><input type="checkbox">房产认证</span>
									<span><input type="checkbox">车产认证</span>
									<span><input type="checkbox">担保考察认证</span>
									<span><input type="checkbox">法人身份证认证</span>	
								</div>						
							</div>	
						</div>		
					</td>
				</tr>
				<tr>
					<td class="tt">产品小图标：</td>
					<td class="con">
						<div id="logo">
						    <!--用来存放item-->
						    <div id="filePicker">选择图片</div>
						    <span class="rec-dimensions">建议尺寸：25*25</span>
						</div>
					</td>
				</tr>
				<tr>
					<td class="tt" valign="top">图片预览：</td>
					<td class="con" id="fileList"></td>
				</tr>
				<tr>
					<td class="tt">类型简介：</td>
					<td class="con"><textarea cols="20" rows="3" name="" maxlength="256"></textarea></td>
				</tr>
			
				<tr>
					<td class="tt">申请指南：</td>
					<td class="con">
						<script id="applyguide" type="text/plain" style="width:98%"></script>
					</td>
				</tr>
				<tr>
					<td class="tt">还款指南：</td>
					<td class="con">
						<script id="payguide" type="text/plain" style="width:98%"></script>
					</td>
				</tr>
				<tr>
					<td class="tt"></td>
					<td class="con">
						<button type="submit" class="btn btn-success">保存</button>
						<button type="submit" class="btn btn-default" onclick="window.location.href='web/project/pro_type.jsp';">返回</button>
					</td>
				</tr>
			</table>
			
		</div>
	</div>
</div>
<!-- 公用js -->
<script type="text/javascript" src="plugs/webuploader/0.1.5/webuploader.js"></script>
<script type="text/javascript" src="js/project/protype-upload.js"></script>
<!-- 私用js -->
<script type="text/javascript">
	var ag = UE.getEditor('applyguide');
	var pg = UE.getEditor('payguide');
	$(function(){
		$(".identitySelection").change(function(){
			var is=$(this).val();
			if(is=="全部"){
				$(".person").show();
				$(".enterprise").show();
			}else if(is=="个人"){
				$(".person").show();
				$(".enterprise").hide();
			}else if(is=="企业"){
				$(".person").hide();
				$(".enterprise").show();
			}else{
				$(".person").hide();
				$(".enterprise").hide();
			}
		});
	});
	$(function(){
		validform5("layui-layer-btn0","roleNamea",false,"3");
		validform5("layui-layer-btn0","account",false,"3");
		validform5("layui-layer-btn0","theYear",false,"3");
		validform5("layui-layer-btn0","con-time",false,"3");
		validform5("layui-layer-btn0","con-timeY",false,"3");
		validform5("layui-layer-btn0","con-timeM",false,"3");
		validform5("layui-layer-btn0","con-timeD",false,"3");
	});
	$(function(){
		/* 类型名称 */
		$(".proKindName").blur(function(){
			var rn = $(".proKindName").val();
			if(rn == " " || rn == ""){
				alert("错误");
			}
		});
	/* 项目融资范围 */
		$(".endAccount").blur(function(){
			var ba =$(".beginAccount").val();
			var ea =$(".endAccount").val();
			if(ea<=ba){
				alert("错误");
			}else{
			}
		});
		$(".beginAccount").blur(function(){
			var ba =$(".beginAccount").val();
			var ea =$(".endAccount").val();
			if(ea<=ba){
				alert("错误");
			}else{
			}
		});
		/* 年化利率范围 */
		$(".startTheYear").blur(function(){
			var sty =$(".startTheYear").val();
			var ety =$(".endTheYear").val();
			if(ety<=sty){
				alert("错误");
			}else{
			}
		});
		$(".endTheYear").blur(function(){
			var sty =$(".startTheYear").val();
			var ety =$(".endTheYear").val();
			if(ety<=sty){
				alert("错误");
			}else{
			}
		});
		
		/* 项目期限 */
		$(".bgTime").blur(function(){
			var be =$(".bgTime").val();
			var ee =$(".edTime").val();
			if(ee<=be){
				alert("错误");
			}else{
			}
		});
		
		$(".edTime").blur(function(){
			var be =$(".bgTime").val();
			var ee =$(".edTime").val();
			if(ee<=be){
				alert("错误");
			}else{
			}
		});
		/* 年 */
		$(".bgTimeY").blur(function(){
			var beY =$(".bgTimeY").val();
			var eeY =$(".edTimeY").val();
			if(eeY<=beY){
				alert("错误");
			}else{
			}
		});
		
		$(".edTimeY").blur(function(){
			var beY =$(".bgTimeY").val();
			var eeY =$(".edTimeY").val();
			if(eeY<=beY){
				alert("错误");
			}else{
			}
		});
		/* 月 */
		$(".bgTimeM").blur(function(){
			var beM =$(".bgTimeM").val();
			var eeM =$(".edTimeM").val();
			if(eeM<=beM){
				alert("错误");
			}else{
			}
		});
		
		$(".edTimeM").blur(function(){
			var beM =$(".bgTimeM").val();
			var eeM =$(".edTimeM").val();
			if(eeM<=beM){
				alert("错误");
			}else{
			}
		});
		/* 天*/
		$(".bgTimeD").blur(function(){
			var beD =$(".bgTimeD").val();
			var eeD =$(".edTimeD").val();
			if(eeD<=beD){
				alert("错误");
			}else{
			}
		});
		
		$(".edTimeD").blur(function(){
			var beD =$(".bgTimeD").val();
			var eeD =$(".edTimeD").val();
			if(eeD<=beD){
				alert("错误");
			}else{
			}
		});
		
	});
</script>

