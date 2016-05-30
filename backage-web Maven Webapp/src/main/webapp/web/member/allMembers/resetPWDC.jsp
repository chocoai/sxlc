<%@page import="product_p2p.kit.datatrans.IntegerAndString"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
			
	long memberId =IntegerAndString.StringToLong(request.getParameter("content"), 0);
%>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
	<base href="<%=basePath%>">
	<title>会员重置密码</title>
	<!-- 公用meta -->
	<jsp:include page="../../common/top-meta.jsp"></jsp:include>
	<!-- 公用css -->
    <jsp:include page="../../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link rel="stylesheet" href="css/member/member.css" type="text/css" >
	<link rel="stylesheet" href="plugs/layer-v2.2/layer/skin/layer.css" type="text/css"></link>
</head>

<body class="nav-md" style="min-width:350px;">
	<form id="resetpassword" action="javascript:submitPwd()">
	<div class="container body addContainer">
		<div class="main_container">
		
			<div class="w-content ishow">
					<table>
						<tr class="resetPwd">
							<td class="tt">新密码：</td> 
							<td class="con"><input name="password"  id="newpwd" type="password"  title="newpass" datatype="newpass" maxlength="16" ></td>
						</tr>
						<tr class="resetPwd">
							<td class="tt">确认密码：</td>
							<td class="con"><input type="password" id="snewpwd" datatype="newpass" maxlength="16" ></td>
						</tr>
					</table>
			</div>
			
		</div>
	</div>
	<div class="layui-layer-btn">
		<a class="layui-layer-btn0">确定</a>
		<a class="layui-layer-btn1">取消</a>
	</div>
	</form>

	<!--  公用的js   -->
	<script type="text/javascript" src="plugs/Validform/5.3.2/Validform.js"></script>
	<script type="text/javascript" src="js/valid.js"></script>
	<script type="text/javascript" src="plugs/layer-v2.2/layer/layer.js"></script>
	<script type="text/javascript" src="js/md5.js"></script>
	<!-- 私用js -->
	<script type="text/javascript" src="js/member/memberPwd.js"></script>
	<script type="text/javascript">
		validform5(".layui-layer-btn0","resetpassword",false,"5");
		$(".layui-layer-btn1").click(function(){
    		var index = parent.layer.getFrameIndex(window.name);
	    	parent.layer.close(index);
    	});
    	/* $(".layui-layer-btn0").click(function(){
    		$("#resetpassword").submit();
    	}); */
    	
    	var memberId = <%=memberId %>;
    	
	   function submitPwd(){
		var index = parent.layer.getFrameIndex(window.name);
		var pwd  = $("#newpwd").val();
		var pwd1  = $("#snewpwd").val();
		if(pwd!=pwd1){
			layer.alert("两次输入密码不一致",{icon:1});  
		}
		var newpwd =hex_md5(pwd); 
		$.ajax({
			  	type : 'get',
			  	url : "member/memberResetPwd.do",
			  	data : {
			  		content : memberId,
			  		start:newpwd
				},
				dataType:"text",
			  	success : function (data) {
			  		if(data ==0 ){
			  		    layer.alert("密码重置成功!",{icon:1});
			  			parent.layer.close(index);
			  		}else if(data ==1 ){
			  			layer.alert("会员不存在!",{icon:2});
			  			parent.layer.close(index);
			  		}else{
			  			layer.alert("密码重置失败!",{icon:2});
			  		}
			  	},
			  	error : function() {  
			          layer.alert("操作失败!",{icon:2});  
			    }
		 });
	}
	</script>
</body>

