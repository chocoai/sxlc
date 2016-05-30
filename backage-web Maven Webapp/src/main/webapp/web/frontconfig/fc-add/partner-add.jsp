<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
	<!-- 地址导航 -->
	<jsp:include page="../../common/cm-addr.jsp"></jsp:include>
	<div class="container">
		<div class="w-content ishow">
			<!-- <div class="partneraddtitle">
				<span>添加合作伙伴</span>
			</div> -->
			<table class="partneraddtable" id="partneraddtable"">
				<tr>
					<td class="tt"><label>上传合作伙伴图片：</label></td>
					<td class="con">
					    <!--dom结构部分-->
						<div id="uploader">
						    <!--用来存放item-->
						    <div id="filePicker">选择图片</div>
						    <span class="rec-dimensions">建议尺寸：580*280</span>
						</div>
					</td>
				</tr>
				<tr>
					<td class="tt" valign="top"><label>图片预览：</label></td>
					<td class="con" id="fileList"></td>
				</tr>
				<tr>
					<td class="tt" valign="top"><label>合作伙伴名称：</label></td>
					<td class="con" id="partneraddname">
						<input type="text" id="" class="" placeholder="" value="" datatype="entername"/>
					</td>
				</tr>
				<tr>
					<td class="tt" valign="top"><label>合作伙伴链接：</label></td>
					<td class="con" id="partneraddlink">
						<input type="text" class="" placeholder="" value="" datatype="strRegex"/>
					</td>
				</tr>
				<tr>
					<td class="tt"><label>合作伙伴简介：</label></td>
					<td class="con">
						<script id="partnerintro" type="text/plain" style="height:165px;width:95%;"></script>
					</td>
				</tr>			
			</table>
			<div class="partneraddbtn">
				<button class="obtn obtn-query glyphicon">提交</button>
				<button class="obtn obtn-query glyphicon" onclick="goback();">取消</button>
			</div>
		</div>
	</div>
    <!-- 公用js -->
	<jsp:include page="../../common/cm-js.jsp"></jsp:include>
	<script type="text/javascript" src="plugs/webuploader/0.1.5/webuploader.js"></script>
	<script type="text/javascript" src="js/upload.js"></script>
	
	<!-- 私用js -->
	<script type="text/javascript" src="js/valid.js"></script>
	<script type="text/javascript">
		$(function(){
			validform5(".layui-layer-btn0","partneraddtable",false,"5");
		});
		/* $(function(){
			validform5(".layui-layer-btn0","partneraddlink",false,"5");
		}); */
		var ag = UE.getEditor('partnerintro');
	</script>
