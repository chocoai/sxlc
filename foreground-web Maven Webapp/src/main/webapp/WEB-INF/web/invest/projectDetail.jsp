<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="projectDetail">
<!--伍成然2016-3-30  -->
<div class="basic-info">
	<div class="left-head">基本信息</div>
	<div class="info-list clearfix">
		<div class="info-label">
			<div class="left-title">用户名：</div>
			<label>${projectMemberInfo.personalName }</label>
		</div>
		<div class="info-label">
			<div class="left-title">性别：</div>
			<label>男</label>
		</div>
		<div class="info-label">
			<div class="left-title">手机号：</div>
			<label>${projectMemberInfo.personalPhone }</label>
		</div>
		<div class="info-label">
			<div class="left-title">年龄：</div>
			<label>26</label>
		</div>
		<div class="info-label">
			<div class="left-title">学历：</div>
			<label>${educationName  }</label>
		</div>
		<div class="info-label">
			<div class="left-title">婚姻：</div>
			<label>${maritalName  }</label>
		</div>
		<div class="info-label">
			<div class="left-title">月收入：</div>
			<label>${monthlyIncome  }以上</label>
		</div>
		<div class="info-label">
			<div class="left-title">公司规模：</div>
			<label>${companySize }人</label>
		</div>
		<div class="info-label">
			<div class="left-title">公司行业：</div>
			<label>${companyIndustry }</label>
		</div>
		<div class="info-label">
			<div class="left-title">职位：</div>
			<label>${position }</label>
		</div>
		<div class="info-label">
			<div class="left-title">工作时间：</div>
			<label>${workYear }以上</label>
		</div>
		<div class="info-label">
			<div class="left-title">所在地区：</div>
			<label>${provinceName }${cityName }</label>
		</div>
	</div>		
</div>
<!--统计信息表格  -->
<div class="statistics-info">
	<div class="left-head">统计信息</div>
	<div class="info-list clearfix">
		<div class="info-label">
			<div class="left-title">成功借款：</div>
			<label>${creditStatisticsEntity.successLoan }笔</label>
		</div>
		<div class="info-label">
			<div class="left-title">成功还款：</div>
			<label>${creditStatisticsEntity.successReplay }笔</label>
		</div>
		<div class="info-label">
			<div class="left-title">成功投资：</div>
			<label>${creditStatisticsEntity.successInvest }笔</label>
		</div>
		<div class="info-label">
			<div class="left-title">提前还款：</div>
			<label>${creditStatisticsEntity.successAdvance }笔</label>
		</div>
		<div class="info-label">
			<div class="left-title">逾期还款：</div>
			<label>${creditStatisticsEntity.overReplay }笔</label>
		</div>
		<div class="info-label">
			<div class="left-title">严重逾期还款：</div>
			<label>${creditStatisticsEntity.overlimitReplay }笔</label>
		</div>
		<div class="info-label">
			<div class="left-title">逾期未还款：</div>
			<label>${creditStatisticsEntity.overnotreplay }笔</label>
		</div>
	</div>		
</div>
<!--认证信息表格  -->
<div class="identification-info">
<div class="left-head">认证信息</div>
	<ul class="blue-table clearfix">
	   <c:forEach items="${borrowingList }" var="bti">
	   	 <li>
	   	  <div>${bit.attestTypeName }</div>
	      <div>${bit.statusName }</div>
	      <div>${bit.endTime }</div>
	   </li>   
	   </c:forEach>
	</ul>
</div>
</div>