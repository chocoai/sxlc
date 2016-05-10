<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	%>
		<!-- <script src="js/jquery-1.11.0.min.js"></script> -->
		<script src="plugs/Bootstrap/js/bootstrap.min.js"></script>
		<script src="plugs/datatables/1.10.0/jquery.dataTables.min.js"></script>
		<script src="plugs/layer-v2.2/layer/layer.js"></script>
		<script src="plugs/layer-v2.2/layer/extend/layer.ext.js"></script>
		<script src="plugs/Validform/5.3.2/js/Validform.min.js"></script>
		<script src="js/common.js"></script>
		<script src="js/valid.js"></script>
		<script src="js/custom.js"></script>
		<script src="js/debug.js"></script>
		<script type="text/javascript" src="js/rsa/RSA.js"></script> 
		<script type="text/javascript" src="js/rsa/Barrett.js"></script>
		<script type="text/javascript" src="js/rsa/BigInt.js"></script>
		<script type="text/javascript" src="<%=basePath%>/plugs/My97DatePicker/WdatePicker.js"></script>
		<script src="js/md5.js"></script>
		<script src="js/net_util.js"></script>
		
		
		<script type="text/javascript">
			window.onload = function(){
				//console.log("页面加载后执行");
				mathHeight();
			};
			//加密设置
			var publicKey_common = '<%=session.getAttribute("publicKey") %>';
			var encrypt = new JSEncrypt();
			encrypt.setPublicKey(publicKey_common);
		</script>
 		<script src="plugs/nicescroll/jquery.nicescroll.min.js"></script>
 		<script src="js/net_util.js"></script>
 		<script src="js/md5.js"></script>
 		
