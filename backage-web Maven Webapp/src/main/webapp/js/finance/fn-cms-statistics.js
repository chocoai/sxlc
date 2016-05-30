var encrypt = new JSEncrypt();
encrypt.setPublicKey(publicKey_common);
$(function(){
	/********选择理财顾问/推荐达人*******/
	$(".search_title").html("条件查询&nbsp;推广类型：理财顾问");
	$(".choType").change(function(){
		$(".search_title").html("条件查询&nbsp;推广类型："+($(".choType").val() == 0?"理财顾问":"推荐达人"));
	});
});

/* 页面load */
/* 推荐借款提奖记录 */
function borrowRecord(){
	var rowdata = $('#table_id').DataTable().rows('.selected').data();
	var types = $("#types").val();
	if (rowdata.length <= 0) {
		layer.alert("请选择需要操作的记录！", {icon : 0});
	}
	$(".right_col").load("web/finance/fn-add/borrowRecord.jsp?content=" + rowdata[0].memberID + "&pAuthCode=" + types);
}
/* 推荐投资提奖记录 */
function invRecord(){
	var rowdata = $('#table_id').DataTable().rows('.selected').data();
	var types = $("#types").val();
	if (rowdata.length <= 0) {
		layer.alert("请选择需要操作的记录！", {icon : 0});
	}
	$(".right_col").load("web/finance/fn-add/invRecord.jsp?content=" + rowdata[0].memberID + "&pAuthCode=" + types);
}
/* 推荐购买VIP提奖记录 */
function vipRecord(){
	var rowdata = $('#table_id').DataTable().rows('.selected').data();
	var types = $("#types").val();
	if (rowdata.length <= 0) {
		layer.alert("请选择需要操作的记录！", {icon : 0});
	}
	$(".right_col").load("web/finance/fn-add/vipRecord.jsp?content=" + rowdata[0].memberID + "&pAuthCode=" + types);
}
/* 推荐还本提奖记录 */
function debtRecord(){
	var rowdata = $('#table_id').DataTable().rows('.selected').data();
	var types = $("#types").val();
	if (rowdata.length <= 0) {
		layer.alert("请选择需要操作的记录！", {icon : 0});
	}
	$(".right_col").load("web/finance/fn-add/debtRecord.jsp?content=" + rowdata[0].memberID + "&pAuthCode=" + types);
}

/* 取消确定返回 */
$(function(){
	$(".buttonSet2 .obtn").click(function(){
		window.location.href="web/finance/fn-cms-statistics.jsp";
	});
});
function sendCms(){//发放佣金的部分
	var rowdata = $('#table_id').DataTable().rows('.selected').data();
	if (rowdata.length <= 0) {
		layer.alert("请选择需要操作的记录！", {icon : 0});
		return;
	}
	$("#borrowAward").val(rowdata[0].borrowAward);
	$("#investAward").val(rowdata[0].investAward);
	$("#vipAward").val(rowdata[0].vipAward);
	$("#repayAward").val(rowdata[0].repayAward);
	$("#allmonay").val(rowdata[0].allmonay);
	var types = $("#types").val();
	$("#type").val(types);
	$("#endTime").val($("#endDate").val());
	$("#startTime").val($("#startDate").val());
	var memberId = rowdata[0].memberID;
	$("#mId").val(memberId);
	layer.open({
		title:"发放佣金",
		  type: 1,
		  area:['600px', '300px'],
		  skin: 'layui-layer-demo', //样式类名
		  closeBtn: 0, //不显示关闭按钮
		  shift: 2,
		  shadeClose: true, //开启遮罩关闭
		  content: $("#sendCms")
		});
	$(".commonbtn0").click(function(){//确定按钮
		//此处完成数据操作
		$("#rechargeform").submit();
		
	});
	$(".commonbtn1").click(function(){//取消按钮
		//此处完成数据操作
		layer.closeAll();
	});
	validform5(".commonbtn0","rechargeform",false,"5");
}

function setAlert(){//设置提醒的部分
	layer.open({
		title:"提醒设置",
		type: 1,
		skin: 'layui-layer-demo', //样式类名
		closeBtn: 0, //不显示关闭按钮
		shift: 2,
		shadeClose: true, //开启遮罩关闭
		content: $("#setAlert")
	});
	$(".commonbtn0").click(function(){//确定按钮
		//此处完成数据操作
		layer.closeAll();
	});
	$(".commonbtn1").click(function(){//取消按钮
		//此处完成数据操作
		layer.closeAll();
	});
}


//佣金统计表格初始化
$(function() {
	var appPath = getRootPath();//项目根路径
	$('#table_id').DataTable(
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
            "url": appPath + "/commission/commissionList.do",   
            "dataSrc": "results", 
            "data": function ( d ) {  
            	var projectTitle = $("#projectTitle").val();
            	var personalName = $("#personalName").val();
            	var logname = $("#logname").val();
            	var startDate = $("#startDate").val();
            	var endDate = $("#endDate").val();
            	var payStatu = $("#payStatu").val();
            	var stype = $("#types").val();
            	
            	if (projectTitle != null && projectTitle != "") {
            		var result1 = encrypt.encrypt((projectTitle + ""));
                }
            	if (personalName != null && personalName != "") {
            		var result2 = encrypt.encrypt((personalName + ""));
                }
            	if (logname != null && logname != "") {
            		var result3 = encrypt.encrypt((logname + ""));
                }
            	if (startDate != null && startDate != "") {
            		var result4 = encrypt.encrypt((startDate + ""));
                }
            	if (endDate != null && endDate != "") {
            		var result5 = encrypt.encrypt((endDate + ""));
                }
            		var result6 = encrypt.encrypt((payStatu + ""));
                	d.memberNo = result1;
                	d.personalName = result2;
                	d.personalPhone = result3;
                	d.startDate = result4;
                	d.endDate = result5;
                	d.payStatu = result6;
                	d.stype = encrypt.encrypt(stype + "");
            } 
        },
        columns: [  
                  {title:'<input type="checkbox" class="table-checkbox"  value="1" />',
                	  "mRender": function (data, type, full) {
                		  sReturn = '<input type="checkbox" value="1" />';
                		  return sReturn;
                	  }
                  },
                  { title:"会员ID","data": "memberID" },
                  { title:"姓名","data": "personalName" },
                  { title:"会员用户名","data": "logname" },
                  { title:"会员编号","data": "memberNo" },
                  { title:"联系电话","data": "personalPhone" },
                  { title:"身份证号","data": "personalIDCard" },
                  { title:"推荐借款提奖","data": "borrowAward" },
                  { title:"推荐投资提奖","data": "investAward" },
                  { title:"推荐购买vip提奖","data": "vipAwards" },
                  { title:"推荐还本提奖","data": "repayAward" },
                  { title:"推荐提奖总额","data": "awardAmount" },
                  { title:"实际发放金额","data": "realAmount" },
                  { title:"佣金发放时间","data": "payDate" }
                  
                  
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
	$('#table_id').DataTable().ajax.reload();
	
});

$(function() {
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

