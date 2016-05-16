var encrypt = new JSEncrypt();
encrypt.setPublicKey(publicKey_common);

$(function () {
	$.ajax({
		type : 'post',
		url : appPath + "/lottery/selectperiod.do",
		success : function (msg) {
			var str = "";
			$.each(msg, function(i, item) {
				str += "<option value=\""+item.period+"\">"+item.period+"</option>";
			});
			$("#period").html(str);
		}
	});
	
	$.ajax({
		type : 'post',
		url : appPath + "/lottery/selectGrade.do",
		success : function (msg) {
			var str = "";
			$.each(msg, function(i, item) {
				str += "<option value=\""+item.grade+"\">"+item.grade+"</option>";
			});
			$("#grade").html(str);
		}
	});
	
	$.ajax({
		type : 'post',
		url : appPath + "/lottery/selectPrizeTypes.do",
		success : function (msg) {
			var str = "";
			$.each(msg, function(i, item) {
				str += "<option value=\""+item.prizeType+"\">"+item.prizeType+"</option>";
			});
			$("#prizeType").html(str);
		}
	});
});
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
            "url": appPath + "/lottery/winningRecordList.do",   
            "dataSrc": "results", 
            "data": function ( d ) {
            	var prizeName = $("#prizeName").val();
            	var memberNo = $("#memberNo").val();
            	var logname = $("#logname").val();
            	var personalPhone = $("#personalPhone").val();
            	var startDate = $("#startDate").val();
            	var endDate = $("#endDate").val();
            	var startDate1 = $("#startDate1").val();
            	var endDate1 = $("#endDate1").val();
            	var period = $("#period").val();
            	var grade = $("#grade").val();
            	var prizeType = $("#prizeType").val();
            	if (prizeName != null && prizeName != "") {
            		var result1 = encrypt.encrypt((prizeName + ""));
                }
            	if (memberNo != null && memberNo != "") {
            		var result2 = encrypt.encrypt((memberNo + ""));
                }
            	if (logname != null && logname != "") {
            		var result3 = encrypt.encrypt((logname + ""));
                }
            	if (personalPhone != null && personalPhone != "") {
            		var result4 = encrypt.encrypt((personalPhone + ""));
                }
            	if (startDate != null && startDate != "") {
            		var result5 = encrypt.encrypt((startDate + ""));
                }
            	if (endDate != null && endDate != "") {
            		var result6 = encrypt.encrypt((endDate + ""));
                }
            	if (startDate1 != null && startDate1 != "") {
            		var result7 = encrypt.encrypt((startDate1 + ""));
                }
            	if (endDate1 != null && endDate1 != "") {
            		var result8 = encrypt.encrypt((endDate1 + ""));
                }
            	if (period != null && period != "") {
            		var result9 = encrypt.encrypt((period + ""));
                }
            	if (grade != null && grade != "") {
            		var result10 = encrypt.encrypt((grade + ""));
                }
            	if (prizeType != null && prizeType != "") {
            		var result11 = encrypt.encrypt((prizeType + ""));
                }
            	d.prizeName = result1;
            	d.memberNo = result2;
            	d.logname = result3;
            	d.personalPhone = result4;
            	d.startDate = result5;
            	d.endDate = result6;
            	d.startDate1 = result7;
            	d.endDate1 = result8;
            	d.period = result9;
            	d.grade = result10;
            	d.prizeType = result11;
            } 
        },
        columns: [  
                  {title:'<input type="checkbox" class="table-checkbox"  value="1" />',
                	  "mRender": function (data, type, full) {
                		  sReturn = '<input type="checkbox" value="1" />';
                		  return sReturn;
                	  }
                  },
                  { title:"抽奖期数","data": "period" }, 
                  { title:"抽奖活动开始时间","data": "startDate" },
                  { title:"消耗积分","data": "integra" },
                  { title:"获奖等级","data": "grade" },
                  { title:"奖品类型","data": "prizeType" },
                  { title:"奖品名称","data": "prizeName" },
                  { title:"奖品价值（元）","data": "prizeWorth" },
                  { title:"中奖时间","data": "lotteryTime" },
                  { title:"中奖会员编号","data": "memberNo" },
                  { title:"中奖会员用户名","data": "logname" },
                  { title:"中奖会员手机号","data": "personalPhone" }
                  
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
 var table = $('#applicationAudit').DataTable();
//设置选中change颜色
 $('#applicationAudit tbody').on( 'click', 'tr', function () {
        $(this).toggleClass('selected');
  });
});

/**
 * 查询按钮
 */
$(".glyphicon-search").on("click",function(){
	$('#applicationAudit').DataTable().ajax.reload();
	
});