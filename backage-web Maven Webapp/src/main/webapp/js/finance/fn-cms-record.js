/** 佣金发放记录 **/
$(function(){
	/********选择理财顾问/推荐达人*******/
	$(".search_title").html("条件查询&nbsp;推广类型：理财顾问");
	$(".choType").change(function(){
		$(".search_title").html("条件查询&nbsp;推广类型："+($(".choType").val() == 0?"理财顾问":"推荐达人"));
	});
});

var encrypt = new JSEncrypt();
encrypt.setPublicKey(publicKey_common);
//表格初始化
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
            "url": appPath + "/commissionRecord/record.do",   
            "dataSrc": "results", 
            "data": function ( d ) {  
            	var memberNo = $("#memberNo").val();
            	var personalName = $("#personalName").val();
            	var personalPhone = $("#personalPhone").val();
            	var startDate = $("#startDate").val();
            	var endDate = $("#endDate").val();
            	var tstartDate = $("#tstartDate").val();
            	var tendDate = $("#tendDate").val();
            	var types = $("#types").val();
            	
            	if (memberNo != null && memberNo != "") {
            		var result1 = encrypt.encrypt((memberNo + ""));
                }
            	if (personalName != null && personalName != "") {
            		var result2 = encrypt.encrypt((personalName + ""));
                }
            	if (personalPhone != null && personalPhone != "") {
            		var result3 = encrypt.encrypt((personalPhone + ""));
                }
            	if (startDate != null && startDate != "") {
            		var result4 = encrypt.encrypt((startDate + ""));
                }
            	if (endDate != null && endDate != "") {
            		var result5 = encrypt.encrypt((endDate + ""));
                }
            	if (tstartDate != null && tstartDate != "") {
            		var result6 = encrypt.encrypt((tstartDate + ""));
                }
            	if (tendDate != null && tendDate != "") {
            		var result7 = encrypt.encrypt((tendDate + ""));
                }
            		var result8 = encrypt.encrypt((types + ""));
                	d.memberNo = result1;
                	d.personalName = result2;
                	d.personalPhone = result3;
                	d.startDate = result4;
                	d.endDate = result5;
                	d.tstartDate = result6;
                	d.tendDate = result7;
                	d.types = result8;
            } 
        },
        columns: [  
                  {title:'<input type="checkbox" class="table-checkbox"  value="1" />',
                	  "mRender": function (data, type, full) {
                		  sReturn = '<input type="checkbox" value="1" />';
                		  return sReturn;
                	  }
                  },
                  { title:"姓名","data": "personalName" },
                  { title:"会员用户名","data": "logname" },
                  { title:"会员编号","data": "memberNo" },
                  { title:"联系电话","data": "personalPhone" },
                  { title:"身份证号","data": "personalIDCard" },
                  { title:"提奖时间段","data": "", 
                	  "mRender": function (data, type, full) {
                			 return full.startDate + "~" + full.endDate;
                	  } 
                  },
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
 var table = $('#table_id').DataTable();
//设置选中change颜色
 $('#table_id tbody').on( 'click', 'tr', function () {
        $(this).toggleClass('selected');
  });
});

/**
 * 查询按钮
 */
$(".glyphicon-search").on("click",function(){
	$('#table_id').DataTable().ajax.reload();
	
});
