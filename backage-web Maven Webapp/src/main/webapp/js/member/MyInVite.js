/**
 * 会员管理
 * 会员下邀请会员
 */
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
});

/**
 * 当下邀请人
 * @param memberId
 */
function  showMemberInviteMan(memberId){
	$.ajax({
	  	type : 'post',
	  	url : appPath+"/member/MyInviteMan.do",
	  	data : {
	  		memberId : memberId
		},
		dataType:"text",
	  	success : function (data) {
	  		if(data!= null && data.length>0){
	  			if(data[0].realName!=null){
	  				$("#realName").val(data[0].realName);
	  			}else{
	  				$("#realName").val("无");
	  			}
	  			if(data[0].memberNo!=null){
	  				$("#memberNo").val(data[0].memberNo);
	  			}else{
	  				$("#memberNo").val("无");
	  			}
	  			if(data[0].phone!=null){
	  				$("#phone").val(data[0].phone);
	  			}else{
	  				$("#phone").val("无");
	  			}
	  		}
	  	},
	  	error : function() {  
	          layer.alert("操作失败!",{icon:2});  
	    }
 });
}
/**
 * 显示 期望的邀请人
 */
function showExpectInviteList(memberId){
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
		        	"url": appPath+"/member/expectMyInviteMan.do",   
		            "dataSrc": "results",   
		            "data": function ( d ) {
		            	var memberNo = $("#memberNoT").val();
		            	var realName = $("#realNameT").val();
		            	var phone = $("#phoneT").val();
		            	var encrypt = new JSEncrypt();
		            	encrypt.setPublicKey(publicKey_common);
		            	//result 为加密后参数
		            	memberNo = encrypt.encrypt(memberNo);
		            	realName = encrypt.encrypt(realName);
		            	phone = encrypt.encrypt(phone);
		            	d.memberId=memberId;
		            	d.memberNo=memberNo;
		            	d.realName=realName;
		            	d.phone=phone;
		            } 
		        },
		        columns: [  
		                  {title:'<input type="checkbox" class="table-checkbox"  value="1" />',
		                	  "mRender": function (data, type, full) {
		                		  sReturn = '<input type="checkbox" value="1" />';
		                		  return sReturn;
		                	  }
		                  },
		                  { title:"会员编号","data":"memberNo"},   
		                  { title:"会员姓名","data":"realName" },
		                  { title:"会员电话","data":"phone"},
		                 
		        ],
		        aoColumnDefs : [
		        				// {"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
		        				{
		        						"orderable" : false,
		        						"aTargets" : [0,1,2]
		        					/* aTargets : [ 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12,
		        							13, 14, 15 ] */
		        				} // 制定列不参与排序
		        				],
		        
		        rowCallback:function(row,data,index){//添加单击事件，改变行的样式      
		        },
		        oTableTools:{"sRowSelect":"multi"}
	});

}
















