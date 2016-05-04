/**
 * 会员管理
 * 会员黑名单
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
	showMemberBlackList();
	/**
	 * 查询按钮
	 */
	$(".glyphicon-search").on("click",function(){
		$('#table_id').DataTable().ajax.reload();
	});
});

/**
 * 显示所有会员黑名单
 */
function showMemberBlackList(){
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
		            "url": appPath+"/member/getBlackMembers.do",   
		            "dataSrc": "results",   
		            "data": function ( d ) {
		            	var member_Name = $("#member_Name").val();//会员姓名
		            	var user_Name =  $("#user_Name").val();//用户名
		            	var phone_Num =  $("#phone_Num").val();//电话
		            	var startDate =  $("#startDate").val();//时间
		            	var endDate = $("#endDate").val();//时间
		            	var encrypt = new JSEncrypt();
		            	encrypt.setPublicKey(publicKey_common);
		            	
		            	//result 为加密后参数
		            	member_Name = encrypt.encrypt(member_Name);
		            	user_Name = encrypt.encrypt(user_Name);
		            	phone_Num = encrypt.encrypt(phone_Num);
		            	endDate = encrypt.encrypt(endDate);
		            	startDate = encrypt.encrypt(startDate);
		            	d.memberName=member_Name;
		            	d.personalName=user_Name;
		            	d.personalPhone=phone_Num;
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
		                  { title:"会员编码","data": "memberNo"},   
		                  { title:"姓名","data": "personalName" },  
		                  { title:"用户名","data": "logname" },
		                  { title:"注册时间","data": "sRegDate" },
		                  { title:"手机号码","data": "personalPhone"},   
		                  { title:"身份证号","data": "personalIdCard"},   
		                  { title:"最后一次拉黑时间","data": "sLastBlack"}, 
		                  { title:"拉黑次数","data": "count" },
		                  { title:"电子邮箱","data": "personalEmail" },
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