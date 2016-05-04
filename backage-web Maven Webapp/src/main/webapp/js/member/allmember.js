/**
 * 会员管理
 * 全部会员
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
	showMemberList();
	/**
	 * 查询按钮
	 */
	$(".glyphicon-search").on("click",function(){
		$('#table_id').DataTable().ajax.reload();
	});
});
/**
 * 显示所有会员
 */
function showMemberList(){
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
		            "url": appPath+"/member/getAllMembers.do",   
		            "dataSrc": "results",   
		            "data": function ( d ) {
		            	var member_Name = $("#member_Name").val();//会员姓名
		            	var user_Name =  $("#user_Name").val();//用户名
		            	var phone_Num =  $("#phone_Num").val();//电话
		            	var auto_tou =  $("#auto_tou").val();//是否自动通标
		            	var auto_return = $("#auto_return").val();//是否自动还款
		            	var encrypt = new JSEncrypt();
		            	encrypt.setPublicKey(publicKey_common);
		            	
		            	//result 为加密后参数
		            	member_Name = encrypt.encrypt(member_Name);
		            	user_Name = encrypt.encrypt(user_Name);
		            	phone_Num = encrypt.encrypt(phone_Num);
		            	auto_tou = encrypt.encrypt(auto_tou+"");
		            	auto_return = encrypt.encrypt(auto_return+"");
		            	d.memberName=user_Name;
		            	d.personalName=member_Name;
		            	d.personalPhone=phone_Num;
		            	d.automaticBidding=auto_tou;
		            	d.automaticRepayment=auto_return;
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
		                  { title:"用户名","data": "memberName" },
		                  { title:"手机号码","data": "personalPhone"},   
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
		                  { title:"会员等级","data": "grade" },
		                  { title:"信用等级","data": "creditRating"},   
		                  { title:"第三方账户","data": "thirdPartyAccount" },  
		                  { title:"账户可用余额","data": "sUserBalance" },
		                  { title:"账户冻结金额","data": "sFrozen" },
		                  { title:"充值总额","data": "sRecharge"},   
		                  { title:"投资总额","data": "sInvestment" }, 
		                  { title:"借款总额","data": "sLoan" },
		                  { title:"提现总额","data": "sWithdrawals"},   
		                  { title:"收益总额","data": "sProfit" },  
/*		                  { title:"可用积分","data": "sAddDate" },
		                  { title:"赠送红包总额","data": "sAddDate" },
		                  { title:"使用红包总额","data": "roleNo"},   
		                  { title:"已过期红包总额","data": "roleName" },  
*/		                  { title:"当前积分","data": "sIntegral" },
		                  
		                  { title:"是否开启自动投标","mRender": function(data, type, full){
		                	  if(full.automaticBidding==1){
		                		  return "<font >是</font>";
		                	  }else{
		                		  return "<font >否</font>";
		                	  }
		                  }
		                 },
		                 { title:"是否开启自动还款","mRender": function(data, type, full){
		                	  if(full.automaticRepayment==1){
		                		  return "<font >是</font>";
		                	  }else{
		                		  return "<font >否</font>";
		                	  }
		                  }
		                 },
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