/**
 * 会员管理
 * 会员交易记录
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
 * 显示会员交易记录
 */
function showMemberTradingList(memberId){
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
		            "url": appPath+"/member/getTradingList.do",   
		            "dataSrc": "results",   
		            "data": function ( d ) {
		            	//result 为加密后参数
		            	var t_type = $("#t_type").val();//交易类型
		            	var startDate = $("#startDate").val();//交易时间
		            	var endDate = $("#endDate").val();//交易时间
		            	var encrypt = new JSEncrypt();
		            	encrypt.setPublicKey(publicKey_common);
		            	//result 为加密后参数
		            	t_type = encrypt.encrypt(t_type+"");
		            	startDate = encrypt.encrypt(startDate);
		            	endDate = encrypt.encrypt(endDate);
		            	d.memberId=memberId;
		            	d.t_type=t_type;
		            	d.startDate=startDate;
		            	d.endDate=endDate;
		            } 
		        },
		        columns: [  
		                  {title:'<input type="checkbox" class="table-checkbox"  value="1" />',
		                	  "mRender": function (data, type, full) {
		                		  sReturn = '<input type="checkbox" value="1" />';
		                		  return sReturn;
		                	  }
		                  },
		                  { title:"序号ID","data": "projectNo"},   
		                  { title:"交易类型","data": "projectTitle" },  
		                  { title:"交易金额","data": "sInvestDate" },
		                  { title:"总金额","data": "investAmounts"},   
		                  { title:"待收本金","data": "investGiftAmounts" },
		                  { title:"待收利息","data": "projectNo"},   
		                  { title:"可用金额","data": "projectTitle" },  
		                  { title:"待还本金","data": "sInvestDate" },
		                  { title:"待还利息","data": "investAmounts"},   
		                  { title:"待还逾期利息","data": "investGiftAmounts" },
		                  { title:"交易对方","data": "projectNo"},   
		                  { title:"交易时间","data": "projectTitle" },  
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