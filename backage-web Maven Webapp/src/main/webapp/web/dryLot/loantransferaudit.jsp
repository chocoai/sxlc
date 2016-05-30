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
	AuditEntity member=(AuditEntity)request.getAttribute("transferAudit");
 %>
<title>网贷审核 - 乾多多</title>
<script type="text/javascript">
	window.onload=function(){document.form1.submit();}
</script>
</head>
<body>
	<form id="form1" name="form1" action="<%=member.getSubmitURL()%>" method="post">
		<input id="LoanNoList" name="LoanNoList" value="<%=member.getLoanNoList()%>" type="hidden" />
		<br/>
<!-- 		<input id="LoanNoListFail" name="LoanNoListFail" value="" type="hidden" /> -->
		<br/>
		<input id="PlatformMoneymoremore" name="PlatformMoneymoremore" value="<%=member.getPlatformMoneymoremore()%>" type="hidden" />
		<br/>
		<input id="AuditType" name="AuditType" value="<%=member.getAuditType()%>" type="hidden" />
		<br/>
		<input id="RandomTimeStamp" name="RandomTimeStamp" value="<%=member.getRandomTimeStamp()%>" type="hidden" />
		<br/>
		<input id="Remark1" name="Remark1" value="<%=member.getRemark1()%>" type="hidden" />
		<br/>
		<input id="Remark2" name="Remark2" value="<%=member.getRemark2()%>" type="hidden" />
		<br/>
		<input id="Remark3" name="Remark3" value="<%=member.getRemark3()%>" type="hidden" />
		<br/>
		<input id="ReturnURL" name="ReturnURL" value="<%=member.getReturnURL()%>" type="hidden" />
		<br/>
		<input id="NotifyURL" name="NotifyURL" value="<%=member.getNotifyURL()%>" type="hidden" />
		<br/>
		<input id="SignInfo" name="SignInfo" value="<%=member.getSignInfo()%>" type="hidden" />
	</form>
</body>
</html>
