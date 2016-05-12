/* 获取项目根目录全路径
 * @returns
 */
function getRootPath(){
        var curWwwPath=window.document.location.href;
        var pathName=window.document.location.pathname;
        var pos=curWwwPath.indexOf(pathName);
        var localhostPath=curWwwPath.substring(0,pos);
        var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
		if(/127.0.0.1|localhost/.test(localhostPath)){
			return(localhostPath+projectName);
		}else{
			return(localhostPath);
		}
}
function changeDefine(value){
	if (value == undefined){
		return "";
	}else{
		return value;
	}
}
$("#true_search").on("click",function(){
	$('#applicationAudit1').DataTable().ajax.reload();
});
//表格初始化
$(function() {
	var appPath = getRootPath();//项目根路径
	$('#applicationAudit1').DataTable(
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
            "url": "orderManager/loadList.do",   
            "dataSrc": "results", 
            "type": "POST",
            "data": function ( d ) {  
            	//请求的参数
            	
            	var exchangeStartTime = changeDefine($(".stime1").val());
            	var exchangeEndTime = changeDefine($(".stime2").val());
            	var deliveryStartTime = changeDefine($(".etime1").val());
            	var deliveryEndTime = changeDefine($(".etime2").val());
            	var userName = changeDefine($("#userId").val());
            	var memberName = changeDefine($("#userName").val());
            	var contactPhone = changeDefine($("#userPhone").val());
            	var goodId = changeDefine($("#proId").val());
            	var goodName = changeDefine($("#proName").val());
            	var status=3;
            		
	            	d.exchangeStartTime = encrypt.encrypt(exchangeStartTime + "");
	            	d.exchangeEndTime = encrypt.encrypt(exchangeEndTime + "");
	            	d.deliveryStartTime = encrypt.encrypt(deliveryStartTime + "");
	            	d.deliveryEndTime = encrypt.encrypt(deliveryEndTime + "");
            		d.userName = encrypt.encrypt(userName + "");
					d.memberName = encrypt.encrypt(memberName+"");
					d.contactPhone = encrypt.encrypt(contactPhone +"");
					d.goodId = encrypt.encrypt(goodId+"");
					d.goodName = encrypt.encrypt(goodName + "");
					d.status = encrypt.encrypt("3" + "");
            } 
        },
        columns: [  
                  { title:"兑换时间","data": "exchangeTime" },
                  { title:"发货时间","data": "deliveryTime" }, 
                  { title:"会员用户名","data": "logname" },
                  { title:"会员姓名","data": "personalName" },
                  { title:"联系电话","data": "personalPhone" },
                  { title:"商品编号","data": "commodityNO" },
                  { title:"商品名称","data": "commodityName" },
                  { title:"兑换数量","data": "quantity" },
                  { title:"应付积分","data": "needPoint" },
                  { title:"实际使用积分","data": "realPoint" },
                  { title:"收货时间","data": "receiveTime" }
                  ],
        "aaSorting" : [[0,1,7,8,9,10,"desc"]],//默认第几个排序
		"aoColumnDefs" : [
		{
			"orderable" : false,
			"aTargets" : [ 2,3,4,5,6]
		} // 制定列不参与排序
				],
        rowCallback:function(row,data){//添加单击事件，改变行的样式      
        }
});
 var table = $('#applicationAudit1').DataTable();
//设置选中change颜色
 $('#applicationAudit1 tbody').on( 'click', 'tr', function () {
        $(this).toggleClass('selected');
  });
});

