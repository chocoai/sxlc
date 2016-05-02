<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
request.setCharacterEncoding("UTF-8");
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<jsp:include page="../../common/cm-addr.jsp"></jsp:include>
<div class="" id="checkDetail">
	<div class="container add_type_contianer">
		<div class="w-content ishow">
			<table>
				<tr>
					<td class="tt"><label>类型名称：</label></td>
					<td class="con" id="roleNamea"><input type="text" class="proKindName" value="${project.projectName}" datatype="roleNamea" maxlength="6"></td>
				</tr>
				<tr>
					<td class="tt"><label>融资额度：</label></td>
					<td class="con" id="account">
					<input type="text" class="beginAccount" datatype="nNum0" value="${project.minAmount}" maxlength="8">
					<span>——</span>
					<input type="text" class="endAccount"  datatype="nNum0" value="${project.maxAmount}" maxlength="8">
					<span>元</span>
					</td>
				</tr>
				<tr>
					<td class="tt">年化利率：</td>
					<td class="con" id="theYear">
					<input type="text" class="beginRate startTheYear" value="${project.minRate}" datatype="hundredNum" maxlength="5">
					<span>——</span>
					<input type="text"  class="endRate endTheYear" value="${project.maxRate}" datatype="hundredNum" maxlength="5">
					<span>%</span>
					</td>					
				</tr>
				<tr>
					<td class="tt">项目期限：</td>
					<td class="con" id="con-time">
						<input type="text" class="beginTime bgTime" value="${project.yminDaytime}" datatype="nNum0" maxlength="4">
						<span>——</span>
						<input type="text" class="endTime edTime" value="${project.ymaxDaytime}" datatype="nNum0" maxlength="4">
					</td>					
				</tr>
				<tr>
					<td class="tt">年:</td>
					<td class="con" id="con-timeY">
						<input type="text" class="beginTime bgTimeY" value="${project.yminDaytime}" datatype="nNum0" maxlength="4">
						<span>——</span>
						<input type="text" class="endTime edTimeY" value="${project.ymaxDaytime}" datatype="nNum0" maxlength="4">  
					</td>					
				</tr>
				<tr>
					<td class="tt">月:</td>
					<td class="con" id="con-timeM">
						<input type="text" class="beginTime bgTimeM" value="${project.mminDaytime}" datatype="nNum0" maxlength="4">
						<span>——</span>
						<input type="text" class="endTime edTimeM" value="${project.mmaxDaytime}" datatype="nNum0" maxlength="4">
					</td>					
				</tr>
				<tr>
					<td class="tt">天:</td>
					<td class="con" id="con-timeD">
						<input type="text" class="beginTime bgTimeD" value="${project.tminDaytime}" datatype="nNum0" maxlength="4">
						<span>——</span>
						<input type="text" class="endTime edTimeD" value="${project.tmaxDaytime}" datatype="nNum0" maxlength="4">
					</td>					
				</tr>
				<tr>
					<td class="tt">是否要抵押：</td>
					<td class="con">
						<select class="assettype" value="${project.isMortgage}">
							<option>请选择</option>
							<c:if test="${project.isMortgage == 1}">
								<option value="1" selected="selected">是</option>
								<option value="0" >否</option>
							</c:if>		
							<c:if test="${project.isMortgage == 0}">
								<option value="1" >是</option>
								<option value="0" selected="selected">否</option>
							</c:if>		
						</select>
					</td>
				</tr>
				<tr>
					<td class="tt">产品认证项：</td>
					<td class="con">
						<select class="identitySelection">
							<option>请选择</option>
							<option value="0">全部</option>
							<option value="1">个人</option>
							<option value="2">企业</option>		
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
									<c:forEach var="item" items="${person}">
										<span><input type="checkbox" value="${item.attestTypeID}">${item.attestTypeName}</span>
									</c:forEach>
								</div>
							</div>
							<div class="enterprise" style="display:none">
								<p>企业认证：</p>
								<div class="con-next">
									<c:forEach var="item" items="${enterprise}">
										<span><input type="checkbox" value="${item.attestTypeID}">${item.attestTypeName}</span>
									</c:forEach>
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
					<input type="hidden" id="hostPath" value="${hostPath}"/>
					<td class="tt" valign="top">图片预览：</td>
					<td class="con" id="fileList" picIcon="${item.picIcon}">
					</td>
				</tr>
				<tr>
					<td class="tt">类型简介：</td>
					<td class="con"><textarea cols="20" rows="3" name="" maxlength="256">${project.briefIntroduction}</textarea></td>
				</tr>
				
				<tr>
					<td class="tt">申请指南：</td>
					<td class="con">
						<script id="applyguide" type="text/plain" style="width:98%" contentG="${project.contentG}"></script>
					</td>
				</tr>
				<tr>
					<td class="tt">还款指南：</td>
					<td class="con">
						<script id="payguide" type="text/plain" style="width:98%" contentR="${project.contentR}"></script>
					</td>
				</tr>
				<tr>
					<td class="tt"></td>
					<td class="con">
						<button type="submit" class="btn btn-success">保存</button>
						<button type="submit" class="btn btn-default"  onclick="window.location.href='web/project/pro_type.jsp';">返回</button>
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
	var contentG = $("#applyguide").attr("contentG");
	var contentR = $("#payguide").attr("contentR");
	$(function(){
		//初始化图片预览
		var picIcon = $("#fileList").attr("picIcon");
		if(picIcon!=null && picIcon!= ""){
			$("#fileList").html('<img height="25" width="25" src="'+$("#hostPath").val()+picIcon+'">');
		}
		//初始化editor插件数据
		if(contentG !=null && contentG != ""){
			ag.addListener("ready", function () {
	        	ag.setContent(contentG);
		    });
		}
		if(contentR !=null && contentR != ""){
			pg.addListener("ready", function () {
	        	pg.setContent(contentR);
		    });
		}
		
		
		$(".identitySelection").change(function(){
			var is=$(this).val();
			if(is=="0"){
				$(".person").show();
				$(".enterprise").show();
			}else if(is=="1"){
				$(".person").show();
				$(".enterprise").hide();
			}else if(is=="2"){
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
			}
		});
		/* 年化利率范围 */
		$(".startTheYear").blur(function(){
			var sty =$(".startTheYear").val();
			var ety =$(".endTheYear").val();
			if(ety<=sty){
				alert("错误");
			}
		});
		$(".endTheYear").blur(function(){
			var sty =$(".startTheYear").val();
			var ety =$(".endTheYear").val();
			if(ety<=sty){
				alert("错误");
			}
		});
		
		/* 项目期限 */
		
		$(".bgTime").blur(function(){
			var be =$(".bgTime").val();
			var ee =$(".edTime").val();
			if(ee<=be){
				alert("错误");
			}
		});
		
		$(".edTime").blur(function(){
			var be =$(".bgTime").val();
			var ee =$(".edTime").val();
			if(ee<=be){
				alert("错误");
			}
		});
		/* 年 */
		$(".bgTimeY").blur(function(){
			var beY =$(".bgTimeY").val();
			var eeY =$(".edTimeY").val();
			if(eeY<=beY){
				alert("错误");
			}
		});
		
		$(".edTimeY").blur(function(){
			var beY =$(".bgTimeY").val();
			var eeY =$(".edTimeY").val();
			if(eeY<=beY){
				alert("错误");
			}
		});
		/* 月 */
		$(".bgTimeM").blur(function(){
			var beM =$(".bgTimeM").val();
			var eeM =$(".edTimeM").val();
			if(eeM<=beM){
				alert("错误");
			}
		});
		
		$(".edTimeM").blur(function(){
			var beM =$(".bgTimeM").val();
			var eeM =$(".edTimeM").val();
			if(eeM<=beM){
				alert("错误");
			}
		});
		/* 天*/
		$(".bgTimeD").blur(function(){
			var beD =$(".bgTimeD").val();
			var eeD =$(".edTimeD").val();
			if(eeD<=beD){
				alert("错误");
			}
		});
		
		$(".edTimeD").blur(function(){
			var beD =$(".bgTimeD").val();
			var eeD =$(".edTimeD").val();
			if(eeD<=beD){
				alert("错误");
			}
		});
		
	});
</script>

