/**
 * 会员管理
 * 会员借款列表
 */
$(function(){
	//单选
	$('#table_id tbody').on( 'click', 'tr', function () {
		var $this = $(this);
		var $checkBox = $this.find("input:checkbox");
		 if ( $(this).hasClass('selected') ) {
			 $checkBox.prop("checked",false);
				$(this).removeClass('selected');
			}
			else {
				$('tr.selected').removeClass('selected');
				$this.siblings().find("input:checkbox").prop("checked",false);
				$checkBox.prop("checked",true);
				$(this).addClass('selected');
			}
		
	} );
	/**
	 * 查询按钮
	 */
	$(".glyphicon-search").on("click",function(){
		$('#table_id').DataTable().ajax.reload();
	});
});

/**
 * 显示会员借款项目
 */
function showMemberBorrowList(memberId){
	$('#table_id').DataTable(
			{	autoWidth : false,
				scrollY : 500,
				serverSide:true,
				pagingType: "simple_numbers",//设置分页控件的模式  
				paging : true,//分页
				searching : true,
	/*			processing:true,
				displayStart:0,*/
				info : true,// 左下角信息
//					ordering: false,//排序
				lengthMenu:[10,25,50,100],
//					aaSorting : [ [ 16, "desc" ] ],// 默认第几个排序
				colReorder : false,
				scrollX : true,
				sScrollX : "100%",
				sScrollXInner : "100%",
				bScrollCollapse : true,  
				processing: true, //打开数据加载时的等待效果  
		        serverSide: true,//打开后台分页  
		        ajax: {  
		            "url": appPath+"/member/getBorrowProject.do",   
		            "dataSrc": "results",   
		            "data": function ( d ) {
		            	//result 为加密后参数
		            	var b_no = $("#b_no").val();//项目编号
		            	var startDate = $("#startDate").val();//放款时间
		            	var endDate = $("#endDate").val();//放款时间
		            	var b_name = $("#b_name").val();//借款名称
		            	var startDate1 = $("#startDate1").val();//结清时间
		            	var endDate1 = $("#endDate1").val();//结清时间
		            	var gua_name = $("#gua_name").val();//担保机构名称
		            	var startDate2 = $("#startDate2").val();//提交借款意向时间
		            	var endDate2= $("#endDate2").val();//提交借款意向时间
		            	var p_statu = $("#p_statu").val();//项目状态；
		            	var startDate3 = $("#startDate3").val();//审批通过时间
		            	var endDate3 = $("#endDate3").val();//审批通过时间
		            	var encrypt = new JSEncrypt();
		            	encrypt.setPublicKey(publicKey_common);
		            	//result 为加密后参数
		            	b_no = encrypt.encrypt(b_no);
		            	startDate = encrypt.encrypt(startDate);
		            	endDate = encrypt.encrypt(endDate);
		            	b_name = encrypt.encrypt(b_name);
		            	startDate1 = encrypt.encrypt(startDate1);
		            	endDate1 = encrypt.encrypt(endDate1);
		            	gua_name = encrypt.encrypt(gua_name);
		            	startDate2= encrypt.encrypt(startDate2);
		            	endDate2 = encrypt.encrypt(endDate2);
		            	p_statu = encrypt.encrypt(p_statu+"");
		            	startDate3 = encrypt.encrypt(startDate3);
		            	endDate3 = encrypt.encrypt(endDate3);
		            	d.memberId=memberId;
		            	d.b_no=b_no;
		            	d.startDate=startDate;
		            	d.endDate=endDate;
		            	d.b_name=b_name;
		            	d.startDate1=startDate1;
		            	d.endDate1=endDate1;
		            	d.gua_name=gua_name;
		            	d.startDate2=startDate2;
		            	d.endDate2=endDate2;
		            	d.p_statu=p_statu;
		            	d.startDate3=startDate3;
		            	d.endDate3=endDate3;
		            	
		            } 
		        },
		        columns: [  
		                  {title:'<input type="checkbox" class="table-checkbox"  value="1" />',
		                	  "mRender": function (data, type, full) {
		                		  sReturn = '<input type="checkbox" value="1" />';
		                		  return sReturn;
		                	  }
		                  },
		                  { title:"项目编号","data": "projectNo"},   
		                  { title:"项目名称","data": "resultBaseInfoentity.projectTitle" },  
		                  { title:"提交借款意向时间","data": "sRecordDate" },
		                  { title:"审批通过时间","data": "sReleaseDate"},   
		                  { title:"借款金额","data": "resultBaseInfoentity.amounts" },
		                  { title:"实际借款金额","data": "endamounts"},   
		                  { title:"担保机构名称","data": "guaranteeName" },  
		                  { title:"项目状态","mRender": function(data, type, full){
		                	  var reslut = "";
			                	  if(full.publishStatu==-3){
			                		  reslut="<font>待流标</font>";
			                	  }else if(full.publishStatu==-2){
			                		  reslut="<font>待第三方登记 </font>";
			                	  }else if(full.publishStatu==-1){
			                		  reslut="<font>登记中</font>";
			                	  }else if(full.publishStatu==0){
			                		  reslut="<font>投标中 </font>";
			                	  }else if(full.publishStatu==1){
			                		  reslut="<font>流标 </font>";
			                	  }else if(full.publishStatu==2){
			                		  reslut="<font>投标完成</font>";
			                	  }else if(full.publishStatu==3){
			                		  reslut="<font>还款中</font>";
			                	  }else if(full.publishStatu==4){
			                		  reslut="<font>结清</font>";
			                	  }else if(full.publishStatu==5){
			                		  reslut="<font>债务转让中</font>";
			                	  }
			                	 	return reslut;
		                  		}
		                  },
		                  { title:"放款时间","data": "sHoldDate" },
		                  { title:"结清时间","data": "sSettleDate"},   
		        ],
		        aoColumnDefs : [
		        				// {"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
		        				{
		        						"orderable" : false,
		        						"aTargets" : [0,1,2,3]
		        					/* aTargets : [ 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12,
		        							13, 14, 15 ] */
		        				} // 制定列不参与排序
		        				],
		        
		        rowCallback:function(row,data,index){//添加单击事件，改变行的样式      
		        },
		        oTableTools:{"sRowSelect":"multi"}
	});

}