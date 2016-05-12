<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%
request.setCharacterEncoding("UTF-8");
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- 	贷后管理---------成交项目列表-----------还款详情 -->
<jsp:include page="../common/cm-addr.jsp"></jsp:include>
<div class="nav-tabs-con active">
	<div class="data_display">
		<div class="panel panel-success">
			<div class="panel-heading">
			</div>
			<div class="panel-body">
				<input type="hidden" id="applyId" value="#{applyId}">
				<table id="table_id" class="display">
				</table>
			</div>
		</div>
	</div>
</div>
<!-- 公用js -->
<jsp:include page="../common/cm-js.jsp"></jsp:include>
<!-- 私用js -->
<script type="text/javascript">
$(function(){
	//表格初始化
	$('#table_id').DataTable(
			{	
				ajax: {  
					"url": appPath+"/project/getDealListPayDetailData",   
					"dataSrc": "results", 
					"type": "POST",
					"data": function ( d ) {
						//加密
						var applyId = $("#applyId").val();
						d.applyId = encrypt.encrypt(applyId);
					}  
				},
				columns: [  
				          {title:'',sWidth:"3%", 
				        	  "mRender": function (data, type, full) {
				        		  sReturn = '<input type="checkbox" class="tr-checkbox" value="1" />';
				        		  return sReturn;
				        	  }
				          },
				          { title:"期数","data": "indexs"},  
				          { title:"计划还款日","data": "loanTime"},  
				          { title:"应还本金","data": "sLoanAmount"},  
				          { title:"应还利息","data": "sLoanAmount"},  
				          { title:"应还罚息","data": "sOverdueInterest"},  
				          { title:"应还小计","data": "sdReplayTotals"},  
				          { title:"实际还款日","data": "repayTime"},  
				          { title:"实还本金","data": "sPaidAmount"},  
				          { title:"实还利息","data": "sPaidInterest"},  
				          { title:"实还罚息","data": "paidSOverdueInterest"},  
				          { title:"未还本金","data": "notsPaidAmount"},  
				          { title:"未还利息","data": "notsPaidInterest"},  
				          { title:"未还罚息","data": "notpaidSOverdueInterest"}
				          ],
//  			  aaSorting :[[ 1, "desc"]],//默认第几个排序
	          aoColumnDefs : [
	                          {
	                        	  "orderable" : false,
	                        	  "aTargets" : [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]
	                          } // 制定列不参与排序
	                          ],
	          pagingType: "simple_numbers",//设置分页控件的模式  
	          processing: true, //打开数据加载时的等待效果  
	          serverSide: true,//打开后台分页  
	          scrollCollapse: true,
	          scrollX : "100%",
			  scrollXInner : "100%",
	          rowCallback:function(row,data){//添加单击事件，改变行的样式      
	          },
	});//表格初始化完毕
	 
	//表格单选效果(有复选框)
	 $('#table_id tbody').on( 'click', 'tr', function () {
		    var $this = $(this);
		    var $checkBox = $this.find("input:checkbox");
	        if ( $this.hasClass('selected') ) {
	        	 $checkBox.prop("checked",false);
	        	$this.removeClass('selected');
	        } else {
	        	$(".tr-checkbox").prop("checked",false);
	        	$checkBox.prop("checked",true);
	        	$('#table_id tr.selected').removeClass('selected');
	        	$this.addClass('selected');
	        }
	  });
	
	 /**
	  * 查询按钮
	  */
	 $(".glyphicon-search").on("click",function(){
		$('#table_id').DataTable().ajax.reload();
		
	 });
});
</script>
