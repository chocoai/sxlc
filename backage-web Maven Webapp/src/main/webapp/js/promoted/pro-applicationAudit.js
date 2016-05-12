/** 推荐达人申请记录 **/
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
            "url": appPath + "/talent/applyChecked.do",   
            "dataSrc": "results", 
            "data": function ( d ) {  
            	var memberNo = $("#memberNo").val();
            	var logname = $("#logname").val();
            	var startDate = $("#startDate").val();
            	var endDate = $("#endDate").val();
            	var personalName = $("#personalName").val();
            	var checkStatu = $("#checkStatu").val();
            	var houseAddress = $("#houseAddress").val();
            	
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
            	if (checkStatu != null && checkStatu != "") {
            		var result6 = encrypt.encrypt((checkStatu + ""));
                }
            	if (houseAddress != null && houseAddress != "") {
            		var result7 = encrypt.encrypt((houseAddress + ""));
                }
            	d.memberNo = result1;
            	d.logname = result2;
            	d.startDate = result3;
            	d.endDate = result4;
            	d.personalName = result5;
            	d.checkStatu = result6;
            	d.houseAddress = result7;
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
                  { title:"会员类型","data": "memberType" },
                  { title:"姓名","data": "personalName" },
                  { title:"注册时间","data": "regDate" },
                  { title:"所在地","data": "houseAddress" },
                  { title:"手机号","data": "personalPhone" },
                  { title:"累计邀请人数","data": "totalInvite" },
                  { title:"状态","data": "checkStatu", 
                	  "mRender": function (data, type, full) {
                		  if (data == 0) {
                			  return "审核中";
                		  }else if (data == 1){
                			  return "通过";
                		  }else {
                			  return "打回";
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
 var table = $('#applicationAudit').DataTable();
//设置选中change颜色
 $('#applicationAudit tbody').on( 'click', 'tr', function () {
        $(this).toggleClass('selected');
  });
});
//审核弹出层2016-05-11伍成然
$(".obtn-exam").click(function(){
	layer.open({
        type: 1,
        title: '审核',
        maxmin: true,
        shadeClose: true, //点击遮罩关闭层
        area : ['400px' , '250px'],
        content: $(".layerExam"),//DOM或内容
	    btn:['确认', '取消']
    });
});