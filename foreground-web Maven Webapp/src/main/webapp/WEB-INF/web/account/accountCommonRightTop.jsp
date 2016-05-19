<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<div class="accountCommonRightTop">
	<label class="ACRT1"></label>
	<span class="ACRT2" onclick="window.location='personalCenter/stationMessage.html'"><span class="orange  messageNum">0</span>封未读信息</span>
	<span class="ACRT2" onclick="window.location='personalCenter/friendManagement.html'"><span class="orange applicationFriendNum">0</span>个好友申请&gt;</span>
	<label class="ACRT3"></label>
	<span class="ACRT4">上次登录时间：<span>${date }</span></span>
	<span class="ACRT4">IP：<span>${ip }</span></span>
	<span class="ACRT4">地点：<span>${city }</span></span>
</div>