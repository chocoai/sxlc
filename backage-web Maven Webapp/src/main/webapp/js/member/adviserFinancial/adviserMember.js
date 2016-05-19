/**
 * 会员管理
 * 
 * 理财顾问会员
 * pr
 */


var STAFF_NUM = 0;  //记录点击添加次数

$(function(){
	//单选
	$('#table_id,#table_planer tbody').on( 'click', 'tr', function () {
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
	showMemberAdviserList();
	/**
	 * 查询按钮
	 */
	$(".glyphicon-search").on("click",function(){
		$('#table_id').DataTable().ajax.reload();
	});
	
	/**
	 * 查询按钮
	 */
	$(".glyphicon-search1").on("click",function(){
		$('#table_planer').DataTable().ajax.reload();
	});
		
	//==============理财顾问列表
	$(".examine").on("click touchstart",function(){
		var rowdata = $('#table_id').DataTable().rows('.selected').data();
		var staffId =0;
		if(rowdata.length<1){ //判断是否选择
			layer.alert("请选择要处理的事务！",{icon:0});  
			return;
		}
		if(rowdata[0].logName!=null){
			$("#memberLogName").text(rowdata[0].logName);
		}
		if(rowdata[0].personalName!=null){
			$("#memberName").text(rowdata[0].personalName);
		}
		
		var memberId= rowdata[0].memberID;
		if(STAFF_NUM ==0){
			showPlanerList();//显示理财师顾问列表
			STAFF_NUM++;
		}
		
		layer.open({
		    type: 1,
		    area: ['950px', '600px'], //高宽
		    title: "理财顾问",
		    content: $(".planer-poster"),//DOM或内容
		    btn:['确定', '取消']
			  ,yes: function(index, layero){ //或者使用btn1
				//获得选取的对象
					var rowdata = $('#table_planer').DataTable().rows('.selected').data();
					var staffId =0;
					if(rowdata.length<1){
						layer.alert("请选择要处理的事务！",{icon:0});  
						return;
					}
					var planerId = rowdata[0].fAID;
					var oldplanerId=0;
					var encrypt = new JSEncrypt();
			    	encrypt.setPublicKey(publicKey_common);
			    	//result 为加密后参数
			    	memberId = encrypt.encrypt(memberId+"");
			    	planerId = encrypt.encrypt(planerId+"");
			    	oldplanerId = encrypt.encrypt(oldplanerId+"");
				  $.ajax({
						url : appPath+"/adviserPlaner/savaPlannerAdvise.do",
							data:{
								planerId:planerId,
								memberId:memberId,
								oldplanerId:oldplanerId,
								content:1 //类型
							},
							type : "post",
							dataType:"text",
						error : function() {
							alert('操作失败！');
							return;
						},
						success : function(data) {
							//1：失败 ， 0：成功 ，-1：部门信息不存在，-2:职务名称已存在，-3：职务信息不存在、-4：职务信息已存在、-5：上级职务不属于同一部门
							if(data == 0){
								//执行完关闭
								layer.alert("分配成功",{icon:1});  
							  	layer.close(index);
							  	setTimeout('location.reload()',500);
							}else if(data == -1){
								layer.alert("添加失败， 该员工未注册前台会员！",{icon:0});  
							}
						 }
					});  
				  
			    //确定的回调
			  },cancel: function(index){//或者使用btn2（concel）
			  	//取消的回调
			  }
		});
	});
});

/**
 * 显示所有未分配理财顾问会员
 */
function showMemberAdviserList(){
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
		            "url": appPath+"/adviserPlaner/memberNoPlaner.do",   
		            "dataSrc": "results",   
		            "data": function ( d ) {
		            	var memberType = $("#memberType").val();
		            	var memberNo = $("#memberNo").val();//会员编号
		            	var logName =  $("#logName").val();//用户名
		            	var personalName =  $("#personalName").val();//会员姓名
		            	var startDate =  $("#startDate").val();//时间
		            	var endDate = $("#endDate").val();//时间
		            	var encrypt = new JSEncrypt();
		            	encrypt.setPublicKey(publicKey_common);
		            	
		            	//result 为加密后参数
		            	memberNo = encrypt.encrypt(memberNo);
		            	logName = encrypt.encrypt(logName);
		            	personalName = encrypt.encrypt(personalName);
		            	endDate = encrypt.encrypt(endDate);
		            	startDate = encrypt.encrypt(startDate);
		            	d.content =memberType;
		            	d.memberNo= memberNo;
		            	d.logName=logName;
		            	d.personalName=personalName;
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
		                  { title:"会员编号","data": "memberNo"},   
		                  { title:"用户名","data": "logName" },
		                  { title:Name,"data": "personalName" }, 
		                  { title:"注册时间","data": "sRegDate" },
		                  { title:"是否开通第三方账户","mRender": function(data, type, full){
		                  		var str="";
		                  		if(full.therStatu==0){
		                  			str="否";
		                  		}else{
		                  			str="是";
		                  		}
		                  		return str;
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

/**
 * 显示所有理财顾问
 */
function showPlanerList(){
	$('#table_planer').DataTable(
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
		            "url": appPath+"/adviserPlaner/PlanerList.do",   
		            "dataSrc": "results",   
		            "data": function ( d ) {
		            	var memberNo = $("#memberNop").val();//编号
		            	var realName =  $("#realName").val();//姓名
		            	var phone =  $("#phone").val();//会员
		            	var encrypt = new JSEncrypt();
		            	encrypt.setPublicKey(publicKey_common);
		            	//result 为加密后参数
		            	memberNo = encrypt.encrypt(memberNo);
		            	realName = encrypt.encrypt(realName);
		            	phone = encrypt.encrypt(phone);
		            	d.memberNo= memberNo;
		            	d.realName=realName;
		            	d.phone=phone;
		            } 
		        },
		        columns: [  
		                  {title:'<input type="checkbox" class="table-checkbox"  value="1" />',
		                	  "mRender": function (data, type, full) {
		                		  sReturn = '<input type="checkbox" value="1" />';
		                		  return sReturn;
		                	  }
		                  },
		                  { title:"姓名","data": "realName"},   
		                  { title:"编号","data": "serviceNo" },
		                  { title:"手机号","data": "servicePhone" }, 
		                  { title:"会员登录名","data": "logName" },
		                  { title:"成为理财师时间","data":"sRecordDate"},
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