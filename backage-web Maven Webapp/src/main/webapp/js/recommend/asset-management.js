var encrypt = new JSEncrypt();
encrypt.setPublicKey(publicKey_common);

function enableOrdisEnable(type) {
	var rowdata = $('#assettable').DataTable().rows('.selected').data();
	var managementID = encrypt.encrypt(rowdata[0].managementID + "");
	var recordStatus = 0;
	if (type == 1) {
		recordStatus = encrypt.encrypt(1 + "");
	}else {
		recordStatus = encrypt.encrypt(0 + "");
	}
	layer.confirm('确定启用？', {
		btn: ['确定', '取消']
	}, function(index, layero){
		//按钮【按钮一】的回调
		$.ajax({
			type : 'post',
			url : appPath + "/asset/ofOrOpen.do",
			data : {
				managementID : managementID,
				recordStatus : recordStatus
			},
			success : function (msg) {
				if (msg == 0) {
					layer.alert("添加成功",{icon:1});  
					setTimeout('location.reload()',2000);
				}else {
					layer.alert("服务器异常",{icon:2});
				}
			}
		});
		//执行完关闭
		layer.close(index);
	}, function(index){
		//按钮【按钮二】的回调
	});
}

/* 添加部分开始 */
function assetAdd(){
	$(".right_col").load("web/recommend/re-add/assetadd.jsp");
}
/* 添加部分结束 */
/* 修改部分开始 */
function assetMod(){
	var rowdata = $('#assettable').DataTable().rows('.selected').data();
	if (rowdata.length <= 0) {
		layer.alert("请选择要查看的管理方！",{icon:0});
		return;
	}else{
		$(".right_col").load("web/recommend/re-add/assetmod.jsp?content=" + rowdata[0].managementID);
	}
}
/* 修改部分结束 */
/* 查看部分开始 */
function assetDetail(){
	var rowdata = $('#assettable').DataTable().rows('.selected').data();
	if (rowdata.length <= 0) {
		layer.alert("请选择要查看的管理方！",{icon:0});
		return;
	}else{
		$(".right_col").load("web/recommend/re-add/asset-checkDetail.jsp?content=" + rowdata[0].managementID);
	}
}
/* 查看部分结束 */
/*资产管理方管理员管理部分开始 */
function admainManager(){
	layer.open({
		type: 1,
		area: ['690px', '410px'], //高宽
		title: "查看资产管理方信息详情",
		maxmin: true,
		content: $("#assetmod"),//DOM或内容
		btn:['返回'],
		/*,yes: function(index, layero){ //或者使用btn1
		//确定的回调
		//判断执行不同方法
		
	},*/cancel: function(index){//或者使用btn2（concel）
		//取消的回调
	}
	});
}
/* 添加 */
function manageAdmainAdd(){
	layer.open({
		type: 1,
		area: ['550px', '430px'], //高宽
		title: "添加管理员管理",
		maxmin: true,
		content: $("#manageAdmainAdd"),//DOM或内容
		btn:['确定', '取消']
	,yes: function(index, layero){ //或者使用btn1
		//确定的回调
		//判断执行不同方法
		
	},cancel: function(index){//或者使用btn2（concel）
		//取消的回调
	}
	});
}
/* 添加 */
/* 修改 */
function manageAdmainMod(){
	layer.open({
		type: 1,
		area: ['550px', '430px'], //高宽
		title: "修改管理员管理",
		maxmin: true,
		content: $("#manageAdmainMod"),//DOM或内容
		btn:['确定', '取消']
	,yes: function(index, layero){ //或者使用btn1
		//确定的回调
		//判断执行不同方法
		
	},cancel: function(index){//或者使用btn2（concel）
		//取消的回调
	}
	});
}
/* 修改 */
/* 资产管理方管理员管理部分开始  */
function assetAdmainManager(){
	var rowdata = $('#assettable').DataTable().rows('.selected').data();
	$(".right_col").load("web/recommend/re-add/assetAdmainManager.jsp?content=" + rowdata[0].managementID);
}

//表格初始化
$(function() {
	var appPath = getRootPath();//项目根路径
	$('#assettable').DataTable(
	{
		autoWidth : false,
		scrollY : 500,
		pagingType: "simple_numbers",//设置分页控件的模式  
		lengthMenu:[[5,10,25,50,-1],[5,10,25,50,"全部"]],
		colReorder : false,
		scrollX : true,
		sScrollX : "100%",
		sScrollXInner : "100%",
		bScrollCollapse : true,  
		processing: true, //打开数据加载时的等待效果  
        serverSide: true,//打开后台分页  
        ajax: {  
            "url": appPath + "/asset/assetList.do",   
            "dataSrc": "results", 
            "data": function ( d ) {  
            	var managementNO = $("#managementNO").val();
            	var managementName = $("#managementName").val();
            	var companyeBLN = $("#companyeBLN").val();
            	var contactName = $("#contactName").val();
            	var contactPhone = $("#gPhone").val();
            	var recordStatus = $("#statu").val();
            	
            	if (managementNO != null && managementNO != "") {
            		var result1 = encrypt.encrypt((managementNO + ""));
                }
				if (managementName != null && managementName != "") {
					var result2 = encrypt.encrypt((managementName));
				}
				if (companyeBLN != null && companyeBLN != "") {
					var result3 = encrypt.encrypt((companyeBLN +""));
				}
				if (contactName != null && contactName != "") {
					var result4 = encrypt.encrypt((contactName));
				}
				if (contactPhone != null && contactPhone != "") {
					var result5 = encrypt.encrypt((contactPhone + ""));
				}
				if (recordStatus != null && recordStatus != "") {
					var result6 = encrypt.encrypt((recordStatus + ""));
				}
                	d.managementNO = result1;
                	d.managementName = result2;
                	d.companyeBLN = result3;
                	d.contactName = result4;
                	d.contactPhone = result5;
                	d.recordStatus = result6;
            } 
        },
        columns: [  
                  {title:'<input type="checkbox" class="table-checkbox"  value="1" />',
                	  "mRender": function (data, type, full) {
                		  sReturn = '<input type="checkbox" value="1" />';
                		  return sReturn;
                	  }
                  },
                  { title:"资产管理方ID","data": "managementID" },
                  { title:"添加时间","data": "addTime" }, 
                  { title:"编号","data": "managementNO" },
                  { title:"资产管理方名称","data": "managementName" },
                  { title:"营业执照号","data": "companyeBLN" },
                  { title:"组织机构代码","data": "companyOC" },
                  { title:"税务登记号","data": "taxRegNo" },
                  { title:"注册资本","data": "companyCapital" },
                  { title:"注册地址","data": "companyAddress" },
                  { title:"法人姓名","data": "personalName" },
                  { title:"法人身份证号","data": "personalIDCard" },
                  { title:"法人手机号","data": "personalPhone" },
                  { title:"联系人姓名","data": "contactName" },  
                  { title:"联系人手机号","data": "contactPhone" },
                  { title:"第三方支付账号","data": "thirdPartyAccount" },
                  { title:"状态","data": "recordStatus", 
                	  "mRender": function (data, type, full) {
                		 if (data == 0) {
                			 return "<font color='red'>无效</font>";
                		 }else if (data == 1){
                			 return "有效";
                		 }
                	  } 
                  },  
                  { title:"操作","data": "statu",
                  	"mRender": function (data, type, full) {
                		  return "<a onclick=\"enableOrdisEnable(1);\" href=\"javascript:void(0);\">启用</a>" + "<a onclick=\"enableOrdisEnable(0);\" href=\"javascript:void(0);\">停用</a>";
                	  } 
                  }
        ],
        aoColumnDefs : [
        				{
        					sDefaultContent: '',
        					orderable : false,
        					aTargets: [ '_all' ]
        				}
        				],
        rowCallback:function(row,data){//添加单击事件，改变行的样式      
        }
});
 var table = $('#assettable').DataTable();
//设置选中change颜色
 $('#assettable tbody').on( 'click', 'tr', function () {
        $(this).toggleClass('selected');
  });
});
