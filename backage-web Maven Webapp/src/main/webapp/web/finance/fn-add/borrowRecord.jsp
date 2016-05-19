<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String content = request.getParameter("content");
%>
<jsp:include page="../../common/cm-addr.jsp"></jsp:include>
<div class="search">
	<div class="panel panel-success">
		<div class="panel-heading">
			<div class="i-fl search_title">条件查询</div>
			<div class="i-fr action_item">
				<ul class="list_item list-inline">
					<li>
						<a class="state">展开&nbsp;<span class="glyphicon glyphicon-chevron-down"></span></a>
					</li>
				</ul>
			</div>
		</div>
		<div class="panel-body">
			<form id="" class="" action="">
			<input id="memberID" type="hidden" value="<%=content %>" />
				<div>
					<span class="con-item">
						<span>借款名称</span><input id="projectTitle" type="text" class="" placeholder="" />
					</span>
					<span class="con-item">
						<span>会员名</span><input id="personalName" type="text" class="" placeholder="" />
					</span>
					<span class="con-item">
						<span>用户名</span><input id="logname" type="text" class="" placeholder="" />
					</span>
					<span class="con-item">
						<span>放款时间段</span><input type="text" id="startDate" class="dateInput Wdate notspecial" onFocus="WdatePicker({maxDate: '#F{$dp.$D(\'endDate\')||\'2020-10-01\'}' })" ><span class="line"></span><input type="text" id="endDate" class="dateInput Wdate"  onFocus="WdatePicker({minDate: '#F{$dp.$D(\'startDate\')}' ,maxDate:'2020-10-01' })" >
					</span>
					<button class="obtn obtn-query glyphicon glyphicon-search">查询</button>
				</div>
			</form>
		</div>
	</div>	
</div>
<div class="data_display">
	<div class="panel panel-success">
		<div class="panel-body">
			<table id="table_borrowRecordId" class="display">
			</table>
		</div>
	</div>
</div>
<!-- 公用js -->
<jsp:include page="../../common/cm-js.jsp"></jsp:include>
<!-- 私用js -->
<script type="text/javascript" src="js/finance/fn-cms-statistics.js"></script>
<script type="text/javascript" src="js/finance/commissingDetail.js"></script>
<script type="text/javascript">
$(".breadcrumb li.active").remove();
$(".breadcrumb").append("<li><a href='web/finance/fn-cms-statistics.jsp'>佣金发放</a></li><li class='active'>推荐借款提奖明细</li>");
</script>
<script type="text/javascript">
	var publicKey_common = '<%=session.getAttribute("publicKey") %>';
</script>	
