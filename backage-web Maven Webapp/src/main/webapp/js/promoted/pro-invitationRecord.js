/** 推荐达人邀请记录 **/

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
            "url": appPath + "/talent/recordList.do",   
            "dataSrc": "results", 
            "data": function ( d ) {  
            } 
        },
        columns: [  
                  {title:'<input type="checkbox" class="table-checkbox"  value="1" />',
                	  "mRender": function (data, type, full) {
                		  sReturn = '<input type="checkbox" value="1" />';
                		  return sReturn;
                	  }
                  },
                  { title:"序号","data": "memberID" },
                  { title:"会员编号","data": "memberNo" }, 
                  { title:"会员用户名","data": "logname" },
                  { title:"姓名","data": "personalName" },
                  { title:"所在地","data": "houseAddress" },
                  { title:"手机号","data": "personalPhone" },
                  { title:"是否开通第三方","data": "iSThird", 
                	  "mRender": function (data, type, full) {
                		  if (data == 0) {
                			  return "否";
                		  }else if (data == 1){
                			  return "是";
                		  }
                	  } 
                  },  
                  { title:"注册时间","data": "regDate" },
                  { title:"累计成功投资","data": "investAmounts" },
                  { title:"累计成功借款","data": "repayAmounts" },
                  { title:"推荐达人编号","data": "imNo" },
                  { title:"推荐达人","data": "inviteLogname" }
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
