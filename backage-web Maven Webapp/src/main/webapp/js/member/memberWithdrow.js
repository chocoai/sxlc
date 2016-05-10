/**
 * 会员管理
 * 会员下提现列表
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
});

/**
 * 显示会员提现列表
 */
function showMemberwithdrowList(memberId){
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
		            "url": appPath+"/member/getMemberWithdrow.do",   
		            "dataSrc": "results",   
		            "data": function ( d ) {
		            	//result 为加密后参数
		            	var startDate = $("#startDate").val();//
		            	var endDate = $("#startDate").val();//
		            	var startDate1 = $("#startDate1").val();//
		            	var endDate1 = $("#endDate1").val();//
		            	var threeNum = $("#threeNum").val();//
		            	var tradeNum= $("#tradeNum").val();//
		            	var encrypt = new JSEncrypt();
		            	encrypt.setPublicKey(publicKey_common);
		            	//result 为加密后参数
		            	startDate = encrypt.encrypt(startDate);
		            	endDate = encrypt.encrypt(endDate);
		            	startDate1 = encrypt.encrypt(startDate1);
		            	endDate1 = encrypt.encrypt(endDate1);
		            	threeNum = encrypt.encrypt(threeNum);
		            	tradeNum = encrypt.encrypt(tradeNum);
		            	
		            	d.startDate=startDate;
		            	d.endDate=endDate;
		            	d.startDate1=startDate1;
		            	d.endDate1=endDate1;
		            	d.threeNum=threeNum;
		            	d.tradeNum=tradeNum;
		            } 
		        },
		        columns: [  
		                  {title:'<input type="checkbox" class="table-checkbox"  value="1" />',
		                	  "mRender": function (data, type, full) {
		                		  sReturn = '<input type="checkbox" value="1" />';
		                		  return sReturn;
		                	  }
		                  },
		                  { title:"提现提交时间","data": "sRecordDate"},   
		                  { title:"提现金额(元)","data": "withdrawalMoneys" },  
		                  { title:"提现银行卡","data": "bankName" },
		                  { title:"第三方手续费(元)","data": "thirdMerBillno"},   
		                  { title:"实际到账金额(元)","data": "realMoneys" },
		                  { title:"提现状态","mRender":function(data, type, full){
		                	  var sReturn ="";
		                	  if(full.statu==1){
		                		  sReturn = "<font >成功</font>";
		                	  }else{
		                		  sReturn = "<font>失败</font>";
		                	  }
		                  		return sReturn;
		                  	}
		                  }, 
		                  { title:"到账时间","data": "sReceiveDate" },  
		                  { title:"平台交易流水号","data": "merBillno" },
		                  { title:"第三方交易流水号","data": "investRates" },
		                  { title:"备注","data": "remark" },
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