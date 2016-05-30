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
    <title>车产认证</title>
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
	   					<span>车产认证</span>
	   					<a class="back" href="javascript:history.back();">返回</a>
	   				</div>
	   				<div class="authenContent">
	   					<div class="clearfix"><div class="addAuthen" onselectstart="return false">添加车产认证</div></div>
	   					
						<!-- 只读窗口 -->
						<div class="cloneDiv_show" style="display:none">
		   					<div class="authen">
	   							<form class="car_show" id="car_show">
					   				<ul class="inputArea">
					   					<li class="inputList">
					   						<div class="mustLabel"><span><samp>*</samp>车辆品牌：</span></div>
					   						<input readonly="readonly" class="inputText brand " type="text" datatype="titleRemarks" lang="请输入车辆品牌" maxlength="40"/>
					   					</li>
					   					<li class="inputList">
					   						<div class="mustLabel"><span><samp>*</samp>型号：</span></div>
					   						<input readonly="readonly" class="inputText model" type="text" datatype="*" lang="请输入车辆型号" maxlength="40"/>
					   					</li>
					   					<li class="inputList">
					   						<div class="mustLabel"><span><samp>*</samp>车牌号：</span></div>
					   						<input readonly="readonly" class="inputText licensePlate " type="text" datatype="cartNumber" lang="请输入车牌号" maxlength="20"/>
					   					</li>
					   					<li class="inputList">
					   						<div class="mustLabel"><span><samp>*</samp>发票价格：</span></div>
					   						<input readonly="readonly" class="inputText value" type="text" datatype="acountM" lang="请输入发票价格" maxlength="10"/>
					   						<span class="unitPrice">元</span>
					   					</li>
					   					<li class="inputList">
					   						<div class="mustLabel"><span><samp>*</samp>首次登记日期：</span></div>
					   						<input readonly="readonly" class="inputText dateSelect Wdate" type="text" lang="请选择首次登记日期"/>
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
									<td>车辆品牌</td>
									<td>型号</td>
									<td>车牌号</td>
									<td>发票价格</td>
									<td>首次登记日期</td>
									<!-- <td>附件</td> -->
									<td>操作</td>
								</tr>
							</thead>
							
								<!-- 我的车产认证列表 -->
								<script id="car_list"  type="text/html">
								{{each data as info index}}
								<tr class="tr_{{info.rid}}">
									<td class="td_brand">{{info.brand}}</td>
									<td class="td_model">{{info.model}}</td>
									<td class="td_licensePlate">{{info.licensePlate}}</td>
									<td class="td_value">{{info.value}}</td>
									<td class="td_endDate">{{info.sEndDate}}</td>
									<td>
										<a href="javascript:showCar({{info.rid}});" class="see">查看</a>
									</td>
									<input class="td_cid" type="hidden" value="{{info.rid}}"/>
									<input class="td_attachPath" type="hidden" value="{{info.attachPath}}"/>
								</tr>
								{{/each }}
								</script>
							<tbody id="car_body">
							
							</tbody>
						</table>
						<input class="attachPrefix" type="hidden"/>
	   				</div>
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
	<script type="text/javascript" src="js/account/personalCenter/addMore.js"></script>
<!-- 	<script type="text/javascript" src="js/account/personalCenter/loanCertification.js"></script> -->
<!--	<script type="text/javascript" src="js/account/personalCenter/loanCertification_picText.js"></script>  -->	
</body>
</html>