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
	<title>积分商城</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link rel="stylesheet" href="css/promoted/promotedCom.css" type="text/css">
	<link rel="stylesheet" href="css/integraMall/integraMall.css" type="text/css">
	<link rel="stylesheet" href="plugs/webuploader/0.1.5/webuploader.css" />
	<link rel="stylesheet" href="css/upload.css" />
	<link rel="stylesheet" href="css/project/loan_pro_post.css" />
</head>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="7" name="_index_m1"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-integralMall.jsp">
				<jsp:param value="702" name="_index_m2"/>
				<jsp:param value="" name="_index_m3"/>
			</jsp:include>
			<!-- 主要内容 -->
				<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				<!-- 主体部分 -->
					<form id="good_add">
					<table id="table_id">
						<tr>
							<td class="tt">商品类型</td>
							<td class="con" id="">
							<select class="shi" id="getType">
								<option value="0">实物</option>
								<option value="1">电子礼券</option>
							</select></td>
							<td class="tt ttt">商品种类</td>
							<td class="con" id=""><select class="shi" id="getLei"></select>
							</td>
						</tr>
						<tr>
							<td class="tt">商品名称</td>
							<td class="con" id=""><input type="text" id="goodName"  datatype="enterAddress"/></td>
							<td class="tt ttt">所需积分</td>
							<td class="con" id=""><input type="text" id="point" datatype="acountM" /></td>
						</tr>
						<tr>
							<td class="tt">结束日期</td>
							<td class="con" id=""><input class="Wdate" id="endTime" datatype="time" onFocus="WdatePicker()" /></td>
							<td class="tt ttt">厂家</td>
							<td class="con" id=""><input type="text" id="manufactor" datatype="enterAddress" /></td>
						</tr>
						<tr>
						</tr>
						<tr>
							<td class="tt">规格型号</td>
							<td class="con" id=""><input type="text" id="specifications" datatype="enterAddress" /></td>
							<td class="tt ttt">总库存</td>
							<td class="con" id=""><input type="text" id="stock"  datatype="acountM" /></td>
						</tr>
						<tr>
							
						</tr>
						<tr>
							<td class="tt">是否为VIP</td>
							<td class="con" id=""><select class="shi" id="isVip"><option value="1">是</option><option value="0">否</option></select></td>
							<td class="tt ttt">是否为活动商品</td>
							<td class="con" id=""><select class="shi" id="isActivity"><option value="1">是</option><option value="0">否</option></select></td>
						</tr>
						<tr>
							<td class="tt">代金券面额</td>
							<td class="con" id=""><input type="text" id="denominationVouchers" datatype="acountM"  /></td>
							<td class="tt ttt">市场价</td>
							<td class="con"><input type="text" id="marketValue" datatype="acountM" /></td>
						</tr>
						<tr>
							<td class="tt">前台展示大图标</td>
							<td class="con" colspan="3">
							<input type="hidden" value="" id="urlBigImg">
							<!--dom结构部分-->
								<div id="uploader">
							    <!--用来存放item-->
							    	<div id="filePicker">选择图片</div>
							    	<span class="rec-dimensions">建议尺寸：361*333</span>
								</div>
							</td>
						</tr>
						<tr>
							<td class="tt" valign="top">图片预览</td>
							<td class="con" id="fileList" colspan="3"></td>
						</tr>
						<tr>
							<td class="tt">前台展示小图标</td>
							<td class="con" colspan="3">
							<input type="hidden" value="" id="urlSmallImg">
							<!--dom结构部分-->
								<div id="uploader1">
							    <!--用来存放item-->
							    	<div id="filePicker1">选择图片</div>
							    	<span class="rec-dimensions">建议尺寸：200*184</span>
								</div>
							</td>
						</tr>
						<tr>
							<td class="tt" valign="top">图片预览</td>
							<td class="con" id="fileList1" colspan="3"></td>
						</tr>
						<tr>
							<td class="tt">商品描述</td>
							<td class="con" id="" colspan="3">
								<script id="applyguide"  type="text/plain" style="height:160px;width:100%;"></script>
							</td>
						</tr>
						<tr>
							<td></td>
							<td colspan="3" class="btn"><button class="btn queding" type="button">确定</button>
														<button class="btn" type="button">取消</button>
							</td>
						</tr>
					</table>
				</form>
	
			
</div>
<!-- 尾部 -->
			
</div>
</div>
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>

	<script type="text/javascript" src="js/integralMall/integralMall_good.js"></script>
	<script type="text/javascript" src="plugs/webuploader/0.1.5/webuploader.js"></script>
	<script type="text/javascript" src="js/frontconfig/frontconfig.js"></script>
	<script type="text/javascript" src="js/config/upload.js"></script>
	<script type="text/javascript" src="plugs/ueditor/ueditor.config.js"></script>
	<script type="text/javascript" src="plugs/ueditor/ueditor.all.min.js"></script>
	<script type="text/javascript" src="plugs/ueditor/lang/zh-cn/zh-cn.js"></script>
	<script type="text/javascript" src="js/integralMall/good_xdd.js"></script>
	<script>
		ue =  UE.getEditor('applyguide');
	</script>
</body>

</html>