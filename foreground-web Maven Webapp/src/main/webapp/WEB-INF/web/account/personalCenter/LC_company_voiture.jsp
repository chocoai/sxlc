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
	<link rel="stylesheet" type="text/css" href="css/account/account.css">
	<link rel="stylesheet" type="text/css" href="css/account/personalCenter/loanCertification.css">
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
	   					<div class="cloneDiv">
		   					<div class="authen">
			   					<div class="authenScale">
			   						<p class="authenScaleBtn" onselectstart="return false" onclick="scale(this);">车产认证</p>
			   					</div>
	   							<form class="companyVoiture">
					   				<ul class="inputArea">
					   					<li class="inputList">
					   						<div class="mustLabel"><span><samp>*</samp>车辆品牌：</span></div>
					   						<input class="inputText" type="text" datatype="titleRemarks" lang="请输入车辆品牌" maxlength="40"/>
					   					</li>
					   					<li class="inputList">
					   						<div class="mustLabel"><span><samp>*</samp>型号：</span></div>
					   						<input class="inputText" type="text" datatype="*" lang="请输入车辆型号" maxlength="40"/>
					   					</li>
					   					<li class="inputList">
					   						<div class="mustLabel"><span><samp>*</samp>车牌号：</span></div>
					   						<input class="inputText" type="text" datatype="cartNumber" lang="请输入车牌号" maxlength="20"/>
					   					</li>
					   					<li class="inputList">
					   						<div class="mustLabel"><span><samp>*</samp>发票价格：</span></div>
					   						<input class="inputText format" type="text" datatype="amcountM" lang="请输入发票价格" maxlength="10"/>
					   						<span class="unitPrice">元</span>
					   					</li>
					   					<li class="inputList">
					   						<div class="mustLabel"><span><samp>*</samp>首次登记日期：</span></div>
					   						<input class="inputText dateSelect Wdate" onfocus="WdatePicker()" type="text" lang="请选择首次登记日期"/>
					   					</li>
					   					<li class="inputList">
						   					<div class="mustLabel"><span><samp>*</samp>附件：</span></div>
						   					<div class="previewPicture">
						   						<img class="previewImg" id="previewImg" src="resource/img/account/common/opacity.png">
						   						<input type="file"accept=".png,.jpg" class="previewInput" id="previewInput" onchange="preImg(this.id,'previewImg');" onblur="if(document.getElementById('previewImg').src=='null')document.getElementById('previewImg').src='resource/img/account/common/opacity.png'" >
						   					</div>
						   					<!-- <span class="hint">（请上传附件图片）</span> -->
						   				</li>
					   					<li class="inputList">
					   						<div class="btn saveSubmit">确认并保存</div>
					   					</li>
					   				</ul>
	   							</form>
			   				</div>
		   				</div>
	   				</div>
   				</div>
   				</div>
   			</div>
   		</div>
   	</div>
   	<jsp:include page="../../common/bottom.jsp"></jsp:include>
	<script type="text/javascript" src="${pageContext.request.contextPath}/plugs/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="js/account/account.js"></script>
	<script type="text/javascript" src="js/account/personalCenter/loanCertification.js"></script>
	<script>
		/* 验证     */
		$(function(){checkCAR();});
			function checkCAR(){
				$(".companyVoiture").each(function(){
					$(this).Validform({
						tiptype:3,//提示信息类型
						btnSubmit:".saveSubmit", //#btn_sub是该表单下要绑定点击提交表单事件的按钮;如果form内含有submit按钮该参数可省略;
						//btnReset:"#btnreset1",
						datatype:extdatatype,//扩展验证类型
						//showAllError:true,//提交前验证显示所有错误
						ajaxPost:{//使用ajax提交时
							url:"",
							datatype:"json",
							success:function(data,obj){
					            //data是返回的json数据;
					            //obj是当前表单的jquery对象;
					        },
					        error:function(data,obj){
					            //data是{ status:**, statusText:**, readyState:**, responseText:** };
					            //obj是当前表单的jquery对象;
					            console.log(data.status);
					        }
						}
					});
				});
			}
	</script>
</body>
</html>