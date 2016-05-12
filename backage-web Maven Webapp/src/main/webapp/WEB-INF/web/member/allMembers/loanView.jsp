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


<div class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 主要内容 -->
				<!-- 地址导航 -->
			<jsp:include page="../../common/cm-addr.jsp"></jsp:include>
			<div class="nav-tabs-con active">
				<div class="search">
					<div class="panel panel-success">
						<div class="panel-heading">
							<div class="i-fl search_title">条件查询</div>
							<div class="i-fr action_item">
								<ul class="list_item list-inline">
									<li><a class="state">展开&nbsp;<span class="glyphicon glyphicon-chevron-down"></span> </a></li>
								</ul>
							</div>
						</div>
						<div class="panel-body">
							<form id="" class="alignment" action="">
								<div>
									<span class="con-item textRight2"><span>借款编号</span><input type="text" id="b_no" class="notspecial" ></span>
									<span class="con-item textRight2"><span>放款时间</span><input type="text" id="startDate" class="dateInput Wdate" onFocus="WdatePicker({maxDate: '#F{$dp.$D(\'endDate\')||\'2020-10-01\'}' })" ><span class="line"></span><input type="text" id="endDate" class="dateInput Wdate"  onFocus="WdatePicker({minDate: '#F{$dp.$D(\'startDate\')}' ,maxDate:'2020-10-01' })" ></span>
									<span class="con-item textRight"><span>借款编号</span><input type="text" class="notspecial" ></span>
									<span class="con-item textRight"><span class="projectStatus">项目状态</span><select class="stateSelect"><option>已结清</option><option>待还款</option></select></span>
									<span class="con-item textRight"><span>放款时间</span><input type="text" id="startDate" class="dateInput Wdate" onFocus="WdatePicker({maxDate: '#F{$dp.$D(\'endDate\')||\'2020-10-01\'}' })" ><span class="line"></span><input type="text" id="endDate" class="dateInput Wdate"  onFocus="WdatePicker({minDate: '#F{$dp.$D(\'startDate\')}' ,maxDate:'2020-10-01' })" ></span>
									<span class="con-item textRight"><span class="approval">审批通过时间</span><input type="text" id="startDate3" class="dateInput Wdate" onFocus="WdatePicker({maxDate: '#F{$dp.$D(\'endDate3\')||\'2020-10-01\'}' })" ><span class="line"></span><input type="text" id="endDate3" class="dateInput Wdate"  onFocus="WdatePicker({minDate: '#F{$dp.$D(\'startDate3\')}' ,maxDate:'2020-10-01' })" ></span>
								</div>
								<div>
									<span class="con-item textRight2"><span>借款名称</span><input type="text" id="b_name" class="notspecial" ></span>
									<span class="con-item textRight2"><span>结清时间</span><input type="text" id="startDate1" class="dateInput Wdate" onFocus="WdatePicker({maxDate: '#F{$dp.$D(\'endDate1\')||\'2020-10-01\'}' })" ><span class="line"></span><input type="text" id="endDate1" class="dateInput Wdate"  onFocus="WdatePicker({minDate: '#F{$dp.$D(\'startDate1\')}' ,maxDate:'2020-10-01' })" ></span>
								</div>
								<div>
									<span class="con-item textRight2"><span>担保机构名称</span><input type="text" class="notspecial" id="gua_name"></span>
									<span class="con-item textRight2"><span>提交借款意向时间</span><input type="text" id="startDate2" class="dateInput Wdate" onFocus="WdatePicker({maxDate: '#F{$dp.$D(\'endDate2\')||\'2020-10-01\'}' })" ><span class="line"></span><input type="text" id="endDate2" class="dateInput Wdate"  onFocus="WdatePicker({minDate: '#F{$dp.$D(\'startDate2\')}' ,maxDate:'2020-10-01' })" ></span>
								</div>
								<div>
									<span class="con-item textRight2"><span>项目状态</span>
									<select id="p_statu" class="stateSelect">
										<option value="">请选择</option>
										<option value="0">投标中</option>
										<option value="1">流标</option>
										<option value="2">投标完成</option>
										<option value="3">还款中</option>
										<option value="4">已结清</option>
										<option value="5">债务转让中</option>
									</select></span>
									<span class="con-item textRight2"><span>审批通过时间</span><input type="text" id="startDate3" class="dateInput Wdate" onFocus="WdatePicker({maxDate: '#F{$dp.$D(\'endDate3\')||\'2020-10-01\'}' })" ><span class="line"></span><input type="text" id="endDate3" class="dateInput Wdate"  onFocus="WdatePicker({minDate: '#F{$dp.$D(\'startDate3\')}' ,maxDate:'2020-10-01' })" ></span>
									<span class="con-item textRight"><span>借款名称</span><input type="text" class="notspecial" ></span>
									<span class="con-item textRight"><span>担保机构名称</span><input type="text" class="notspecial" ></span>
									<span class="con-item textRight"><span>结清时间</span><input type="text" id="startDate1" class="dateInput Wdate" onFocus="WdatePicker({maxDate: '#F{$dp.$D(\'endDate1\')||\'2020-10-01\'}' })" ><span class="line"></span><input type="text" id="endDate1" class="dateInput Wdate"  onFocus="WdatePicker({minDate: '#F{$dp.$D(\'startDate1\')}' ,maxDate:'2020-10-01' })" ></span>
									<span class="con-item textRight"><span>提交借款意向时间</span><input type="text" id="startDate2" class="dateInput Wdate" onFocus="WdatePicker({maxDate: '#F{$dp.$D(\'endDate2\')||\'2020-10-01\'}' })" ><span class="line"></span><input type="text" id="endDate2" class="dateInput Wdate"  onFocus="WdatePicker({minDate: '#F{$dp.$D(\'startDate2\')}' ,maxDate:'2020-10-01' })" ></span>
									<button class="obtn obtn-query glyphicon glyphicon-search inquiryBtn">查询</button>
								</div>
							</form>
					  	</div>
					 </div>
				</div> 
				<div class="data_display">
						
						<div class="panel-body">
							<table id="table_id" class="display">
								<thead>
								</thead>
								<tbody>
								</tbody>
							</table>
						</div>
						
					</div>
				</div>
			
			</div>
		</div>
	
		<!-- 公用js -->
	<jsp:include page="../../common/cm-js.jsp"></jsp:include>
	
	<!-- 私用js -->
	<script type="text/javascript" src="js/member/memberBorrow.js"></script>
	<script type="text/javascript">
		var memberId = <%=memberId %>;
		var encrypt = new JSEncrypt();
		encrypt.setPublicKey(publicKey_common);
		//result 为加密后参数
		memberId = encrypt.encrypt(memberId+"");
		showMemberBorrowList(memberId); //借款
	</script>
</div>

