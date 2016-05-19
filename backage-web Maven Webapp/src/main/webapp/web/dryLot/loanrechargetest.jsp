<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@page import="cn.sxlc.account.manager.model.RechargeEntity"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Cache-Control" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<%
	RechargeEntity member=(RechargeEntity)request.getAttribute("rechargeEntity");
 %>
<title>网贷充值 - 双乾</title>
<script type="text/javascript">
	window.onload=function(){document.form2.submit();}
</script>
</head>
<body>
	<form id="form2" name="form2" action="<%=member.getSubmitURL()%>" method="post">
		<input id="RechargeMoneymoremore" name="RechargeMoneymoremore" value="<%=member.getRechargeMoneymoremore()%>" type="hidden" />
		<br/>
		<input id="PlatformMoneymoremore" name="PlatformMoneymoremore" value="<%=member.getPlatformMoneymoremore()%>" type="hidden" />
		<br/>
		<input id="OrderNo" name="OrderNo" value="<%=member.getOrderNo()%>" type="hidden" />
		<br/>
		<input id="Amount" name="Amount" value="<%=member.getAmount()%>" type="hidden" />
		<br/>
		<input id="RechargeType" name="RechargeType" value="<%=member.getRechargeType()%>" type="hidden" />
		<br/>
		<input id="FeeType" name="FeeType" value="<%=member.getFeeType()%>" type="hidden" />
		<br/>
		<input id="CardNo" name="CardNo" value="<%=member.getCardNo()%>" type="hidden" />
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
