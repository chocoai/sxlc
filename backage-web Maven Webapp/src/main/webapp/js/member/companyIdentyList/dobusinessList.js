/*  状态切换       */
$(function(){
	
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
	$(".auditState").each(function(){
		if($(this).val()==1){
			$(".buttonCombination button:last-child").hide();
			$(".buttonCombination button:first-child").show();
		}
	});
	$(".auditState").change(function(){
		if($(this).val()==1){
			$(".buttonCombination button:first-child").show();
			$(".buttonCombination button:last-child").hide();
		}if($(this).val()!=1){
			$(".buttonCombination button:first-child").hide();
			$(".buttonCombination button:last-child").show();
		}
	});
});

/**
 * 查询按钮
 */
$(".glyphicon-search").on("click",function(){
	$('#table_id').DataTable().ajax.reload();
	
});

/**
 * 跳转到审核或者查看详情页面
 * @param btn  区分页面
 * @param url  路径
 */
function jump(typeId,btn,url){
	/*window.localStorage.setItem("a",JSON.stringify(obj));*/
	var rowdata = $('#table_id').DataTable().rows('.selected').data();
	if(rowdata.length<1){
		layer.alert("请选择要处理的事务！",{icon:0});
		return;
	}
	content = rowdata[0].certificationID;
	location.href = url + '?start='+typeId+'&content='+content+'&draw='+btn;
 
}

/**
 * 根据认证类型查询所有需要认证的会员
 */
function IdentyList(attestTypeId){
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
		            "url": appPath+"/companyidety/getCompanyIdentyList.do",   
		            "dataSrc": "results",   
		            "data": function ( d ) {
		            	var logName = $("#logName").val();//会员姓名
		            	var companyName = $("#companyName").val();//用户名
		                var statu = $("#statu").val();
		            	var encrypt = new JSEncrypt();
		            	encrypt.setPublicKey(publicKey_common);
		            	
		            	//result 为加密后参数
		            	logName = encrypt.encrypt(logName);
		            	companyName = encrypt.encrypt(companyName);
		            	attestTypeID = encrypt.encrypt(attestTypeId+"");
		            	statu = encrypt.encrypt(statu+"");
		            	d.logName=logName;
		            	d.companyName=companyName;
		            	d.attestTypeID=attestTypeID;
		            	d.statu=statu;
		            } 
		        },
		        columns: [  
		                  {title:'<input type="checkbox" class="table-checkbox"  value="1" />',
		                	  "mRender": function (data, type, full) {
		                		  sReturn = '<input type="checkbox" value="1" />';
		                		  return sReturn;
		                	  }
		                  },
		                  { title:"会员登录名","data": "logname"},   
		                  { title:"企业名称","data": "company" },  
		                  { title:"营业执照号码","data": "firmBLN"},   
		                  { title:"注册地址","data": "firmAddress" },  
		                  { title:"注册法人","data": "firmLegal" },
		                  { title:"注册资金(元)","data": "regCapital" },
		                  { title:"经营范围","data": "regBusiness" },
		                  { title:"公司类型","data": "firmType" },
		                  { title:"申请时间","data": "sRecordDate" },
		                  { title:"有效期","data": "sEndDate" },
		        ],
		        aoColumnDefs : [
		                      // {"bVisible": false, "aTargets":arr}, //控制列的隐藏显示
		        				
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