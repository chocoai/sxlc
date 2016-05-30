/**
 * 会员管理
 * 借款会员
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
	showMemberLoanList();
	/**
	 * 查询按钮
	 */
	$(".glyphicon-search").on("click",function(){
		$('#table_id').DataTable().ajax.reload();
	});
});

/**
 * 显示所有借款会员
 */
function showMemberLoanList(){
	var memberType = $("#memberType").val();
	var Name = "姓名";
	var Phone = "联系电话";
	if(memberType ==1){
		Name ="企业名称";
		Phone ="联系人电话";
	}
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
		            "url": appPath+"/member/getLoadMembers.do",   
		            "dataSrc": "results",   
		            "data": function ( d ) {
		            	memberType = $("#memberType").val();
		            	var member_Name = $("#member_Name").val();//会员姓名
		            	var user_Name =  $("#user_Name").val();//用户名
		            	var phone_Num =  $("#phone_Num").val();//电话
		            	var encrypt = new JSEncrypt();
		            	encrypt.setPublicKey(publicKey_common);
		            	
		            	//result 为加密后参数
		            	member_Name = encrypt.encrypt(member_Name);
		            	user_Name = encrypt.encrypt(user_Name);
		            	phone_Num = encrypt.encrypt(phone_Num);
		            	memberType = encrypt.encrypt(memberType+"");
		            	d.memberType = memberType;
		            	d.memberName=member_Name;
		            	d.userName=user_Name;
		            	d.phone=phone_Num;
		            } 
		        },
		     
		        columns: [  
		                  {title:'<input type="checkbox" class="table-checkbox"  value="1" />',
		                	  "mRender": function (data, type, full) {
		                		  sReturn = '<input type="checkbox" value="1" />';
		                		  return sReturn;
		                	  }
		                  },
		                 
		                  { title:"会员编号","data": "memberNo"},   
		                  { title:Name,"data": "personalName" },  
		                  { title:"用户名","data": "logname" },
		                  { title:Phone,"data": "personalPhone"},  
		                  { title:"所属地区","mRender": function(data, type, full){
		                  		var str="";
		                  		 if(full.provinceName!=null &&full.provinceName!=""){
		                  			str = full.provinceName;
		                  		 }
		                  		if(full.cityName!=null &&full.cityName!=""){
		                  			str += full.cityName;
		                  		 }
		                  		if(full.countyName!=null &&full.countyName!=""){
		                  			str += full.countyName;
		                  		 }
		                  		if(full.townName!=null &&full.townName!=""){
		                  			str += full.townName;
		                  		 }
		                  		return str;
		                     }
		                  },
		                  { title:"第三方账户","data": "thirdPartyAccount" },  
		                  { title:"账户余额(元)","data": "sUserBalance" },
		                  { title:"在借金额(元)","data": "sBorrow" },
		                  { title:"已结清金额(元)","data": "sSettled"}, 
		                  { title:"冻结金额(元)","data": "sFrozen"},
		                  { title:"逾期次数","data": "overdue" }, 
		                  { title:"充值总额(元)","data": "sRecharge" }, 
		                  { title:"充值手续费合计(平台/元)","data": "cjplatform" },
		                  { title:"充值手续费合计(会员/元)","data": "sCjplatform"},   
		                  { title:"借款总额(元)","data": "sLoan" },   
		                  { title:"累计借款管理费(元)","data": "sLoanManager"},   
		                  { title:"提现总额(元)","data": "sWithdrawals"},  
		                  { title:"提现手续费合计(平台/元)","data": "sTxplatform" },
		                  { title:"提现手续费合计(会员/元)","data": "sTxmember" },
		                  { title:"邀请码","data": "invitateCode" },
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