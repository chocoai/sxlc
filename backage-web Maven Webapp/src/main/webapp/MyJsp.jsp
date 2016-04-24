<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<script src="js/jquery-1.11.0.js"></script>
<script src="js/md5.js"></script>
<script src="net_util.js"></script>
<script src="js/common.js"></script>
<script src="plugs/layer-v2.2/layer/layer.js"></script>
<script type="text/javascript" src="js/rsa/RSA.js"></script> 
<script type="text/javascript" src="js/rsa/Barrett.js"></script>
<script type="text/javascript" src="js/rsa/BigInt.js"></script>
<script type="text/javascript">
	var publicKey_common = '<%=session.getAttribute("publicKey") %>';
	//加密设置
	var encrypt = new JSEncrypt();
	encrypt.setPublicKey(publicKey_common);
$(function(){
	$(".testBtn").on("click",function(){
		  var data ={"mngName":"测试","startTime":null,"atartTima":"a"}; 
		  NetUtil.ajax(
				  
				  appPath+"/front/toTeamList.do",
				  data,
				  function(result){
			            if(result){
			            	alert("成功");
			            }
			  	  },
			  	  null,
			  	  function(){
			  		  alert("完成");
			  	  }
		 );
	});
  })
</script>
</head>

<body>
	<div>
		<form id="ffileField_ZR" action="" method="post"
			enctype="multipart/form-data" target="aa"
			style="margin: 0px;padding: 0px;">

			<input type='text' name='textfield2_ZR' id='textfield2_ZR'
				class='txt' style="width: 140px;" /> 
				
			<input type='button' class='testBtn' value='测试' /> 
				
		</form>
	</div>
</body>
</html>
