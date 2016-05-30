<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN">
<html>
<head>
	<base href="<%=basePath%>">
    <title>房产认证</title>
    <jsp:include page="../../common/top_meta.jsp"></jsp:include>
    <script type="text/javascript">
    	var appPath="<%=path%>";
    	var publickey = '<%=session.getAttribute("publicKey")%>';
    </script>
	<link rel="stylesheet" type="text/css" href="css/account/account.css">
	<link rel="stylesheet" type="text/css" href="css/account/personalCenter/loanCertification.css">
	<link rel="stylesheet" type="text/css" href="plugs/webuploader/webuploader.css">
</head>
<body> 
    <jsp:include page="../../common/top.jsp"></jsp:include>
   	<jsp:include page="../../common/mainPageTop.jsp"></jsp:include>
   	<div class="main">
   		<div class="clearfix">
		   	<jsp:include page="../../account/accountCommonLeft.jsp"></jsp:include>
   			<div class="accountRight">
			   	<jsp:include page="../../account/accountCommonRightTop.jsp"></jsp:include>
   				<div class="accountMain clearfix">
   				<!-- 在此处写入代码 -->
   					<div class="authenHeader">
	   					<span>房产认证</span>
	   					<a class="back" href="javascript:history.back();">返回</a>
	   				</div>
   					<div class="authenContent">
	   					<div class="clearfix"><div class="addAuthen" onselectstart="return false">添加房产认证</div></div>
	   					
	   					<!-- 添加修改窗口 -->
	   					<div class="cloneDiv" style="display:none">
		   					<div class="authen">
		   						<form class="house" id="house">
		   							<input class="editType" type="hidden">
		   							<input class="cid" type="hidden">
					   				<ul class="inputArea">
					   					<li class="inputList">
					   						<div class="mustLabel"><span><samp>*</samp>房产位置：</span></div>
					   						<input class="inputText address" datatype="enteraddr" type="text" lang="请输入房产位置" maxlength="25"/>
					   					</li>
					   					<li class="inputList">
					   						<div class="mustLabel"><span><samp>*</samp>面积：</span></div>
					   						<input class="inputText area" datatype="acountNum1"  type="text" lang="请输入房产面积" maxlength="10"/>
					   						<span class="unitPrice">平方米</span>
					   					</li>
					   					<li class="inputList">
					   						<div class="mustLabel"><span><samp>*</samp>市场价值：</span></div>
					   						<input class="inputText value" datatype="acountM" type="text" lang="请输入房产市场价值" maxlength="10"/>
					   						<span class="unitPrice">元</span>
					   					</li>
					   					<li class="inputList">
					   						<div class="mustLabel"><span><samp>*</samp>登记时间：</span></div>
					   						<input class="inputText dateSelect Wdate " onfocus="WdatePicker({maxDate:'%y-%M-%d',readOnly:true})" type="text" />
					   					</li>
					   					<li class="inputList">
						   					<div class="mustLabel"><span><samp></samp>附件：</span></div>
						   					<div class="file" style="float: none;">
						   						<img class="previewImg previewPicture"  src="resource/img/account/common/opacity.png">
						   					</div>
						   					<div class="authPreviDiv_u"></div>
						   					<!-- <span class="hint">（请上传附件图片）</span> -->
						   				</li>
					   					<li class="inputList">
					   						<div class="btn saveSubmit holdBtn" id="${requestScope.type}" >确认并保存</div>
					   						<input type="hidden" value="0" class="editType" />
					   						<input type="hidden" value="0" class="cid" />
					   					</li>
					   				</ul>
				   				</form>
		   					</div>
	   					</div>
	   					<div class="cloneDiv_show" style="display:none">
		   					<div class="authen">
		   						<form class="house_show">
					   				<ul class="inputArea">
					   					<li class="inputList">
					   						<div class="mustLabel"><span><samp>*</samp>房产位置：</span></div>
					   						<input readonly="readonly" class="inputText address" datatype="enteraddr" type="text" lang="请输入房产位置" maxlength="25"/>
					   					</li>
					   					<li class="inputList">
					   						<div class="mustLabel"><span><samp>*</samp>面积：</span></div>
					   						<input readonly="readonly" class="inputText area" datatype="acountM"  type="text" lang="请输入房产面积" maxlength="10"/>
					   						<span class="unitPrice">平方米</span>
					   					</li>
					   					<li class="inputList">
					   						<div class="mustLabel"><span><samp>*</samp>市场价值：</span></div>
					   						<input readonly="readonly" class="inputText value" datatype="acountM" type="text" lang="请输入房产市场价值" maxlength="10"/>
					   						<span class="unitPrice">元</span>
					   					</li>
					   					<li class="inputList">
					   						<div class="mustLabel"><span><samp>*</samp>登记时间：</span></div>
					   						<input readonly="readonly" class="inputText dateSelect Wdate "  type="text" lang="请选择登记时间"/>
					   					</li>
					   					<li class="inputList">
						   					<div class="mustLabel"><span><samp></samp>附件：</span></div>
						   					<div class="authPreviDiv_u"></div>
						   					<!-- <span class="hint">（请上传附件图片）</span> -->
						   				</li>
					   				</ul>
				   				</form>
		   					</div>
	   					</div>
	   					<table id="vo_table" cellspacing="0" style="width:100%">
							<thead>
								<tr>
									<td>房产位置</td>
									<td>面积（平方米）</td>
									<td>市场价值（元）</td>
									<td>登记时间</td>
									<!-- <td>附件</td> -->
									<td>操作</td>
								</tr>
							</thead>
								<!-- 我的房产认证列表 -->
								<script id="house_list"  type="text/html">
								{{each data as info index}}
								<tr class="tr_{{info.rid}}">
									<td class="td_homeAddress">{{info.homeAddress}}</td>
									<td class="td_area">{{info.area}}</td>
									<td class="td_value">{{info.value}}</td>
									<td class="td_endDate">{{info.sEndDate}}</td>
									<td>
										<a href="javascript:showHouse({{info.rid}});" class="see">查看</a>
										<a href="javascript:modifyHouse({{info.rid}});" class="modify">修改</a>
									</td>
									<input class="td_cid" type="hidden" value="{{info.rid}}"/>
									<input class="td_attachPath" type="hidden" value="{{info.attachPath}}"/>
								</tr>
								{{/each }}
								</script>
							<tbody id="house_body">
								
							</tbody>
						</table>
						<input class="attachPrefix" type="hidden"/>
	   						
	   				</div>
   				</div>
   			</div>
   		</div>
   	</div>
   	<jsp:include page="../../common/bottom.jsp"></jsp:include>
	<script type="text/javascript" src="${pageContext.request.contextPath}/plugs/My97DatePicker/WdatePicker.js"></script>
  	<script type="text/javascript" src="plugs/webuploader/webuploader.js" ></script>
   	<script type="text/javascript" src="js/exp-upload.js" ></script>
	<script type="text/javascript" src="js/account/account.js"></script>
	<script type="text/javascript" src="js/account/personalCenter/addHome.js"></script>
<!-- 	<script type="text/javascript" src="js/account/personalCenter/loanCertification.js"></script>
	<script type="text/javascript" src="js/account/personalCenter/loanCertification_picText.js"></script> -->
	
</body>
</html>