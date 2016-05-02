/**
 * 会员管理
 * 会员下投资列表
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
 * 显示会员投资项目
 */
function showMemberInvestList(memberId){
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
		            "url": appPath+"/member/getInvestProject.do",   
		            "dataSrc": "results",   
		            "data": function ( d ) {
		            	//result 为加密后参数
		            	var p_no = $("#p_no").val();//项目编号
		            	var p_name= $("#p_name").val();//项目名称
		            	var startDate = $("#startDate").val();//放款时间
		            	var endDate = $("#endDate").val();//放款时间
		            	var startDate1 = $("#startDate1").val();//结清时间
		            	var endDate1 = $("#endDate1").val();//结清时间
		            	var encrypt = new JSEncrypt();
		            	encrypt.setPublicKey(publicKey_common);
		            	//result 为加密后参数
		            	p_no = encrypt.encrypt(p_no);
		            	startDate = encrypt.encrypt(startDate);
		            	endDate = encrypt.encrypt(endDate);
		            	p_name = encrypt.encrypt(p_name);
		            	startDate1 = encrypt.encrypt(startDate1);
		            	endDate1 = encrypt.encrypt(endDate1);
		            	d.memberId=memberId;
		            	d.p_no=p_no;
		            	d.p_name=p_name;
		            	d.startDate=startDate;
		            	d.endDate=endDate;
		            	d.startDate1=startDate1;
		            	d.endDate1=endDate1;
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
		                  { title:"项目名称","data": "projectTitle" },  
		                  { title:"投资时间","data": "sInvestDate" },
		                  { title:"投资总金额","data": "investAmounts"},   
		                  { title:"使用红包总金额","data": "investGiftAmounts" },
		                  { title:"使用代金券总额","data": "investVouchersAmounts"},   
		                  { title:"放款时间","data": "sHoldDate" },  
		                  { title:"投资总进度","data": "investRates" },
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