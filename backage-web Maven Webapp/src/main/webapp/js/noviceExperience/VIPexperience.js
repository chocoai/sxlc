var encrypt = new JSEncrypt();
encrypt.setPublicKey(publicKey_common);
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
            "url": appPath + "/noviceExperience/vipRecord.do",   
            "dataSrc": "results", 
            "data": function ( d ) {  
            	var memberNo = $("#memberNo").val();
            	var logname = $("#logname").val();
            	var startDate = $("#startDate").val();
            	var endDate = $("#endDate").val();
            	var personalName = $("#personalName").val();
            	var prizeWorth = $("#prizeWorth").val();
            	var startDate1 = $("#startDate1").val();
            	var endDate1 = $("#endDate1").val();
            	
            	if (memberNo != null && memberNo != "") {
            		var result1 = encrypt.encrypt((memberNo + ""));
                }
            	if (logname != null && logname != "") {
            		var result2 = encrypt.encrypt((logname + ""));
                }
            	if (startDate != null && startDate != "") {
            		var result3 = encrypt.encrypt((startDate + ""));
                }
            	if (endDate != null && endDate != "") {
            		var result4 = encrypt.encrypt((endDate + ""));
                }
            	if (personalName != null && personalName != "") {
            		var result5 = encrypt.encrypt((personalName + ""));
                }
            	if (prizeWorth != null && prizeWorth != "") {
            		var result6 = encrypt.encrypt((prizeWorth + ""));
                }
            	if (startDate1 != null && startDate1 != "") {
            		var result7 = encrypt.encrypt((startDate1 + ""));
                }
            	if (endDate1 != null && endDate1 != "") {
            		var result8 = encrypt.encrypt((endDate1 + ""));
                }
            	d.memberNo = result1;
            	d.logname = result2;
            	d.startDate = result3;
            	d.endDate = result4;
            	d.personalName = result5;
            	d.prizeWorth = result6;
            	d.startDate1 = result7;
            	d.endDate1 = result7;
            } 
        },
        columns: [  
                  {title:'<input type="checkbox" class="table-checkbox"  value="1" />',
                	  "mRender": function (data, type, full) {
                		  sReturn = '<input type="checkbox" value="1" />';
                		  return sReturn;
                	  }
                  },
                  { title:"会员编号","data": "memberNo" }, 
                  { title:"会员用户名","data": "logname" },
                  { title:"会员名称","data": "personalName" },
                  { title:"开户时间","data": "regDate" },
                  { title:"投资体验标时间","data": "experienceDate" },
                  { title:"代金券面值(元","data": "vouchersAmounts" },
                  { title:"总收益金额(元)","data": "incomeAmounts" },
                  { title:"是否成功发放","data": "prizeWorth" }
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