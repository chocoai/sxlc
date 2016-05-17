<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@page import="cn.sxlc.account.manager.model.AuditEntity"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Cache-Control" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<%
	AuditEntity auditEntity = (AuditEntity)request.getAttribute("transferAudit");
 %>
<title>网贷审核 - 乾多多</title>
<script type="text/javascript">
	window.onload=function(){document.form1.submit();}
</script>
</head>
<body>
	<form id="form1" name="form1" action="<%=auditEntity.getSubmitURL()%>" method="post">
		<input id="LoanNoList" name="LoanNoList" value="<%=auditEntity.getLoanNoList()%>" type="hidden" />
		<input id="PlatformMoneymoremore" name="PlatformMoneymoremore" value="<%=auditEntity.getPlatformMoneymoremore()%>" type="hidden" />
		<input id="AuditType" name="AuditType" value="<%=auditEntity.getAuditType()%>" type="hidden" />
		<input id="RandomTimeStamp" name="RandomTimeStamp" value="<%=auditEntity.getRandomTimeStamp()%>" type="hidden" />
		<input id="Remark1" name="Remark1" value="<%=auditEntity.getRemark1()%>" type="hidden" />
		<input id="Remark2" name="Remark2" value="<%=auditEntity.getRemark2()%>" type="hidden" />
		<input id="Remark3" name="Remark3" value="<%=auditEntity.getRemark3()%>" type="hidden" />
		<input id="ReturnURL" name="ReturnURL" value="<%=auditEntity.getReturnURL()%>" type="hidden" />
		<input id="NotifyURL" name="NotifyURL" value="<%=auditEntity.getNotifyURL()%>" type="hidden" />
		<input id="SignInfo" name="SignInfo" value="<%=auditEntity.getSignInfo()%>" type="hidden" />
	</form>
</body>
</html>
