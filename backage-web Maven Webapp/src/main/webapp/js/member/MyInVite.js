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
	$("#updateInvite").on("click",modifyInvite);//修改我的邀请人
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
		dataType:"json",
	  	success : function (data) {
	  		if(data!= null && data.length>0){
	  			if(data[0].realName!=null && data[0].realName!=""){
	  				$("#realName").text(data[0].realName);
	  			}else{
	  				$("#realName").text("无");
	  			}
	  			if(data[0].memberNo!=null && data[0].memberNo!=""){
	  				$("#memberNo").text(data[0].memberNo);
	  			}else{
	  				$("#memberNo").text("无");
	  			}
	  			if(data[0].phone!=null && data[0].phone!=""){
	  				$("#phone").text(data[0].phone);
	  			}else{
	  				$("#phone").text("无");
	  			}
	  		}
	  	},
	  	error : function() {  
	          layer.alert("操作失败!",{icon:2});  
	    }
 });
}

/**
 * 修改我的邀请人
 */
function modifyInvite(){
	var rowdata = $('#table_id').DataTable().rows('.selected').data();
	if(rowdata.length<1){
		layer.alert("请选择要处理的事务！",{icon:0});
		return;
	}
    var	inviteId=rowdata[0].memberId;
	alert(memberId);
    inviteId = encrypt.encrypt(inviteId+"");
    layer.confirm('确定拉黑该会员？', {
		btn:['确定', '取消']
	  ,yes: function(index, layero){ //或者使用btn1
		$.ajax( {  
			url:appPath+"/member/updateMyInvete.do",
			data:{
				inviteId:inviteId,
				memberId:memberId
				},
			type:'post',  
			cache:false,  
			dataType:'text',  
			success:function(data) { 
				 if(data==0){
					  layer.alert("修改成功。",{icon:1}); 
					  window.history.back();
				 }else{
					 layer.alert("修改失败!",{icon:1});  
				 }
			},  
			error : function() {  
				layer.alert("操作失败!",{icon:2});  
			} 
		}); 
	  },cancel: function(index){//或者使用btn2（concel）
		  	//取消的回调
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
















