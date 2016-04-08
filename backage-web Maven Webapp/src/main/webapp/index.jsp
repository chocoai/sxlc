<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html lang="zh-CN">
  <head>
    <base href="<%=basePath%>">
	<title>后台首页</title>
	<script type="text/javascript">
     window.location.href="index/index_lg.jsp";
    </script>
  </head>
  
  <body>
     <!--  转向主页. <br> -->
  </body>
</html>
