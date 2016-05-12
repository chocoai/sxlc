/**
 * 会员管理
 * 会员黑名单
 * 黑名单历史记录
 * pr
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
 * 显示所有会员黑名单历史记录
 */
function showMemberBlackRecord(memberId){
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
		            "url": appPath+"/member/blackRemoveList.do",   
		            "dataSrc": "results",   
		            "data": function ( d ) {
		            	d.memberId=memberId;
		            } 
		        },
		        columns: [  
		                  {title:'<input type="checkbox" class="table-checkbox"  value="1" />',
		                	  "mRender": function (data, type, full) {
		                		  sReturn = '<input type="checkbox" value="1" />';
		                		  return sReturn;
		                	  }
		                  },
		                  { title:"拉黑时间","data": "sRecordDate"},   
		                  { title:"拉黑操作管理员","data": "adminName" },  
		                  { title:"取消拉黑时间","data": "sRemoveDate" },
		                  { title:"取消拉黑操作管路员","data": "removeAdmin" },
		                  { title:"取消拉黑原因","data": "remark" },
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