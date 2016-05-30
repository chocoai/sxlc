/** 红包活动管理 **/
var encrypt = new JSEncrypt();
encrypt.setPublicKey(publicKey_common);
/*  添加SEO设置     */
function addRedE(){
	layer.open({
		type: 1,
		area: ['600px', '300px'], //高宽
		title: "添加红包",
		maxmin: true,
		content: $("#addRedE")//DOM或内容
	});
}


/*  修改SEO设置     */
function alertRedE(){
	var rowdata = $('#applicationAudit').DataTable().rows('.selected').data();
	if (rowdata.length <= 0) {
		layer.alert("请选择需要操作的记录！", {icon : 0});
		return;
	}
	var affairID = rowdata[0].affairID;
	affairID = encrypt.encrypt(affairID + "");
	$.ajax({
		type : 'post',
		url : appPath + "/red/query4mod.do",
		data : {
			affairID : affairID
		},
		success : function (msg) {
			
			if (msg != null) {
				$("#mstartDate").val(msg.startDate);
				$("#mendDate").val(msg.endDate);
				$("#maffairName").val(msg.affairName);
				$("#muserendDate").val(msg.userendDate);
				var list = msg.redpacketsDetail;
				for (var i = 0; i < list.length; i++) {
					$("#RMC"+i+"").attr("class", "redEContent isActive2");
					$("#RMC"+i+"").find("input.money").val(list[i].giftAmount);
					$("#RMC"+i+"").find("input.num").val(list[i].quantity);
					$("#RMC"+i+"").find("input.detail").val(list[i].rpDetailID);
				}
			}
		}
	});
	
	
	
	layer.open({
		type: 1,
		area: ['600px', '300px'], //高宽
		title: "修改红包",
		maxmin: true,
		content: $("#alertRedE")//DOM或内容
	});
}

/** 添加红包记录 **/
$(function () {
	$("#addRecord").bind('click', function () {
		$("#addRedEForm").submit();
	});
});

function addRecord() {
	var startDate = encrypt.encrypt($("#startDate").val() + "");
	var endDate = encrypt.encrypt($("#endDate").val() + "");
	var affairName = encrypt.encrypt($("#affairName").val() + "");
	var userendDate = encrypt.encrypt($("#userendDate").val() + "");
	var giftAmount = "";
	var quantity = "";
	
	$("#redMany .isActive").each(function () {
		if($(this).next().length == 0){
			var money = $(this).find(".money").val();
			var num = $(this).find(".num").val();
			giftAmount += money;
			quantity += num;
			return;
		}
		if($(this).find(".money").val() != "" && $(this).find(".num").val() != ""){
			var money = $(this).find(".money").val();
			var num = $(this).find(".num").val();
			giftAmount += money + ",";
			quantity += num + ",";
		}
	});
	
	giftAmount = encrypt.encrypt(giftAmount + "");
	quantity = encrypt.encrypt(quantity + "");
	$.ajax({
		type : 'post',
		url : appPath + "/red/addRedRecord.do",
		data : {
			startDate : startDate,
			endDate : endDate,
			affairName : affairName,
			userendDate : userendDate,
			giftAmount : giftAmount,
			quantity : quantity
		},
		success : function (msg) {
			if (msg == 1) {
				layer.alert("操作成功",{icon:1});
				day = null;
				setTimeout('location.reload()',2000);
			}else {
				layer.alert("操作失败",{icon:2});
			}
		}
	});
	
}

/**
 * 发布红包
 */
$(function () {
	$("#fb").bind('click', function () {
		var rowdata = $('#applicationAudit').DataTable().rows('.selected').data();
		if (rowdata.length <= 0) {
			layer.alert("请选择需要操作的记录！", {icon : 0});
			return;
		}
		var affairID = rowdata[0].affairID;
		$.ajax({
			type : 'post',
			url : appPath + "/red/publish.do",
			data : {
				affairID : encrypt.encrypt(affairID + "")
			},
			success : function (msg) {
				if (msg == 1) {
					layer.alert("操作成功",{icon:1});
					setTimeout('location.reload()',2000);
				}else {
					layer.alert("操作失败",{icon:2});
				}
			}
		});
	});
});


$(function(){
	/* 红包个数增加  */
	$("#addRedE .redEAdd").on("click",function(){
		console.log($("#addRedE .isActive:last").attr("id"));
		if($("#addRedE .isActive:last").next().length > 0){
			$("#addRedE .isActive:last").next().removeClass("notActive").addClass("isActive");
		}else{
			layer.alert("添加次数限制为20次，请刷新页面重新添加！");
		}
	});
	/* 红包删除  */
	$("#addRedE .redDelete").on("click",function(){
		$(this).parent().parent().removeClass("isActive").addClass("notActive");
		$(this).parent().parent().find("input").each(function(){
			$(this).val("");
		});
	});
	/* 红包清理  */
	$("#addRedE .addBtn").on("click",function(){
		$("#addRedE .notActive").remove();
	});
	/* 红包个数增加  */
	$("#alertRedE .redEAdd").on("click",function(){
		console.log($("#alertRedE .isActive2:last").attr("id"));
		if($("#alertRedE .isActive2:last").next().length > 0){
			$("#alertRedE .isActive2:last").next().removeClass("notActive2").addClass("isActive2");
		}else{
			layer.alert("添加次数限制为20次，请刷新页面重新添加！");
		}
	});
	/* 红包删除  */
	$("#alertRedE .redDelete").on("click",function(){
		$(this).parent().parent().removeClass("isActive2").addClass("notActive2");
		$(this).parent().parent().find("input").each(function(){
			$(this).val("");
		});
	});
	/* 红包清理  */
	$("#alertRedE .addBtn").on("click",function(){
		$("#alertRedE .notActive2").remove();
	});
});

$(function(){
	validform5("#addRecord","addRedEForm",false,5);
	validform5("#modRed","alertRedEForm",false,5);
	$(".cancelBtn").bind("click",function(){
		layer.closeAll();
	});
});
/**
 * 修改红包记录
 */

$(function () {
	$("#modRed").bind('click', function() {
		$("#alertRedEForm").submit();
	});
});

function modRed () {
	var rowdata = $('#applicationAudit').DataTable().rows('.selected').data();
	var affairID = rowdata[0].affairID;
	affairID = encrypt.encrypt(affairID + "");
	var startDate = encrypt.encrypt($("#mstartDate").val() + "");
	var endDate = encrypt.encrypt($("#mendDate").val() + "");
	var affairName = encrypt.encrypt($("#maffairName").val() + "");
	var userendDate = encrypt.encrypt($("#muserendDate").val() + "");
	var giftAmount = "";
	var quantity = "";
	var detailId = "";
	$("#redChange .isActive2").each(function () {
		if($(this).next().length == 0){
			var money = $(this).find(".money").val();
			var num = $(this).find(".num").val();
			var detail = $(this).find(".detail").val();
			giftAmount += money;
			quantity += num;
			detailId += detail;
			return;
		}
		if($(this).find(".money").val() != "" && $(this).find(".num").val() != ""){
			var money = $(this).find(".money").val();
			var num = $(this).find(".num").val();
			var detail = $(this).find(".detail").val();
			giftAmount += money + ",";
			quantity += num + ",";
			detailId += detail + ",";
		}
	});

	giftAmount = encrypt.encrypt(giftAmount + "");
	quantity = encrypt.encrypt(quantity + "");
	detailId = encrypt.encrypt(detailId + "");
	$.ajax({
		type : 'post',
		url : appPath + "/red/modRedRecord.do",
		data : {
			startDate : startDate,
			endDate : endDate,
			affairName : affairName,
			userendDate : userendDate,
			giftAmount : giftAmount,
			quantity : quantity,
			affairID : affairID,
			detailId : detailId
		},
		success : function (msg) {
			if (msg == 1) {
				layer.alert("操作成功",{icon:1});
				setTimeout('location.reload()',2000);
			}else {
				layer.alert("操作失败",{icon:2});
			}
		}
	});
}
//表格初始化
$(function() {
	var appPath = getRootPath();//项目根路径
	$('#applicationAudit').DataTable(
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
            "url": appPath + "/red/redRecordList.do",   
            "dataSrc": "results", 
            "data": function ( d ) {
            	var startDate1 = $("#startDate1").val();
            	var startDate2 = $("#startDate2").val();
            	var startDate3 = $("#startDate3").val();
            	var endDate1 = $("#endDate1").val();
            	var endDate2 = $("#endDate2").val();
            	var endDate3 = $("#endDate3").val();
            	var statu = $("#statu").val();
            	if (startDate1 != null && startDate1 != "") {
            		var result1 = encrypt.encrypt((startDate1 + ""));
                }
            	if (endDate1 != null && endDate1 != "") {
            		var result2 = encrypt.encrypt((endDate1 + ""));
                }
            	if (startDate2 != null && startDate2 != "") {
            		var result3 = encrypt.encrypt((startDate2 + ""));
                }
            	if (endDate2 != null && endDate2 != "") {
            		var result4 = encrypt.encrypt((endDate2 + ""));
                }
            	if (startDate3 != null && startDate3 != "") {
            		var result5 = encrypt.encrypt((startDate3 + ""));
                }
            	if (endDate3 != null && endDate3 != "") {
            		var result6 = encrypt.encrypt((endDate3 + ""));
                }
            	if (statu != null && statu != "") {
            		var result7 = encrypt.encrypt((statu + ""));
                }
            	d.startDate1 = result1;
            	d.endDate1 = result2;
            	d.startDate2 = result3;
            	d.endDate2 = result4;
            	d.startDate3 = result5;
            	d.endDate3 = result6;
            	d.statu = result7;
            } 
        },
        columns: [  
                  {title:'<input type="checkbox" class="table-checkbox"  value="1" />',
                	  "mRender": function (data, type, full) {
                		  sReturn = '<input type="checkbox" value="1" />';
                		  return sReturn;
                	  }
                  },
                  { title:"id","data": "affairID" },
                  { title:"活动添加时间","data": "createTime" }, 
                  { title:"活动开始时间","data": "startDate" },
                  { title:"活动结束时间","data": "endDate" },
                  { title:"活动名称","data": "affairName" },
                  { title:"活动红包总个数","data": "quantity" },
                  { title:"活动红包总金额（元）","data": "affairAccounts" },
                  { title:"已领取活动红包总金额","data": "receiveAffairs" },
                  { title:"剩余活动红包总金额（元）","data": "remainingAffairs" },
                  { title:"状态","data": "statu", 
                	  "mRender": function (data, type, full) {
                		 if (data == 0) {
                			 return "未发布";
                		 }else if (data == 1){
                			 return "已发布";
                		 }else {
                			 return "已结束";
                		 }
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
});

/**
 * 查询按钮
 */
$(".glyphicon-search").on("click",function(){
	$('#applicationAudit').DataTable().ajax.reload();
	
});


$(function() {
	//单选
	$('#applicationAudit tbody').on( 'click', 'tr', function () {
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
