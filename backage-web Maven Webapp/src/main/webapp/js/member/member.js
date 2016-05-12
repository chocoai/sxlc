/* 查看详情页面加载    */

function detailView(){
	var rowdata = $('#table_id').DataTable().rows('.selected').data();
	if(rowdata.length<1){
		layer.alert("请选择要处理的事务！",{icon:0});
		return;
	}
	var content=rowdata[0].memberId;
	$(".right_col").load("web/member/allMembers/memberDetail.jsp?content="+content);
}
/*  借款查询      */
function loanView(){
	var rowdata = $('#table_id').DataTable().rows('.selected').data();
	if(rowdata.length<1){
		layer.alert("请选择要处理的事务！",{icon:0});
		return;
	}
	var content=rowdata[0].memberId;
	$(".right_col").load("web/member/allMembers/loanView.jsp?content="+content);
}
/*   投资查询       */
function investView(){
	var rowdata = $('#table_id').DataTable().rows('.selected').data();
	if(rowdata.length<1){
		layer.alert("请选择要处理的事务！",{icon:0});
		return;
	}
	var content=rowdata[0].memberId;
	$(".right_col").load("web/member/allMembers/investView.jsp?content="+content);
} 
/*   交易记录       */
function transactionRecord(){
	var rowdata = $('#table_id').DataTable().rows('.selected').data();
	if(rowdata.length<1){
		layer.alert("请选择要处理的事务！",{icon:0});
		return;
	}
	var content=rowdata[0].memberId;
	var memberType = $("#memberType").val();
	$(".right_col").load("web/member/allMembers/transactionRecord.jsp?content="+content+"&start="+memberType);
}
/*   查看邀请会员列表          */
function inviteView(){
	var rowdata = $('#table_id').DataTable().rows('.selected').data();
	if(rowdata.length<1){
		layer.alert("请选择要处理的事务！",{icon:0});
		return;
	}
	var content = rowdata[0].memberId;
	$(".right_col").load("web/member/allMembers/inviteView.jsp?content="+content);
}
/*   银行卡查询          */
function cardView(){
	var rowdata = $('#table_id').DataTable().rows('.selected').data();
	if(rowdata.length<1){
		layer.alert("请选择要处理的事务！",{icon:0});
		return;
	}
	var content = rowdata[0].memberId;
	$(".right_col").load("web/member/allMembers/cardView.jsp?content="+content);
}
/*   重置密码纪录          */
function resetPWDRecord(){
	var rowdata = $('#table_id').DataTable().rows('.selected').data();
	if(rowdata.length<1){
		layer.alert("请选择要处理的事务！",{icon:0});
		return;
	}
	var content = rowdata[0].memberId;
	$(".right_col").load("web/member/allMembers/resetPWD.jsp?content="+content);
}
/*   修改邀请会员          */
function inviteVip(){
	var rowdata = $('#table_id').DataTable().rows('.selected').data();
	if(rowdata.length<1){
		layer.alert("请选择要处理的事务！",{icon:0});
		return;
	}
	var content = rowdata[0].memberId;
	$(".right_col").load("web/member/allMembers/inviteVIP-change.jsp?content="+content);
}

/*   发送     */
/*function messageSendPer(){
	var rowdata = $('#table_id').DataTable().rows('.selected').data();
	if(rowdata.length<1){
		layer.alert("请选择要处理的事务！",{icon:0});
		return;
	}
	var content = rowdata[0].memberId;
	$(".right_col").load("web/member/allMembers/per-messageSend.jsp?content="+content);
}
*/
/*   提现记录查询          */
function recordQuery(){
	var rowdata = $('#table_id').DataTable().rows('.selected').data();
	if(rowdata.length<1){
		layer.alert("请选择要处理的事务！",{icon:0});
		return;
	}
	var content = rowdata[0].memberId;
	var memberType = $("#memberType").val();
	$(".right_col").load("web/member/allMembers/member-recordQuery.jsp?content="+content+"&start="+memberType);
}
/*   充值记录查询          */
function rechargeRecord(){
	var rowdata = $('#table_id').DataTable().rows('.selected').data();
	if(rowdata.length<1){
		layer.alert("请选择要处理的事务！",{icon:0});
		return;
	}
	var content = rowdata[0].memberId;
	var memberType = $("#memberType").val();
	$(".right_col").load("web/member/allMembers/member-rechargeRecord.jsp?content="+content+"&start="+memberType);
}
/*   黑名单查询          */
function memeberBlackRecord(){
	var rowdata = $('#table_id').DataTable().rows('.selected').data();
	if(rowdata.length<1){
		layer.alert("请选择要处理的事务！",{icon:0});
		return;
	}
	var content = rowdata[0].memberId;
	$(".right_col").load("web/member/allMembers/memberBlackRecord.jsp?content="+content);
}
/*   查看提交认证信息          */
function perSubmitAuthentication(){
	$(".right_col").load("web/member/allMembers/per-submitAuthentication.jsp");
}
/*   债权转让记录         */
function bondTransforRecord(){
	var rowdata = $('#table_id').DataTable().rows('.selected').data();
	if(rowdata.length<1){
		layer.alert("请选择要处理的事务！",{icon:0});
		return;
	}
	var content = rowdata[0].memberId;
	$(".right_col").load("web/member/allMembers/bondTransforRecord.jsp?content="+content);
}
/*   分配理财顾问         */
function financialAdvisor(){
	$(".right_col").load("web/member/allMembers/per-financialAdvisor.jsp");
}
/*   变更理财顾问         */
function changeFinancialAdvisor(){
	$(".right_col").load("web/member/allMembers/per-changeFinancialAdvisor.jsp");
}
/*   查询历史理财顾问         */
function inquiryFinancialAdvisor(){
	var rowdata = $('#table_id').DataTable().rows('.selected').data();
	if(rowdata.length<1){
		layer.alert("请选择要处理的事务！",{icon:0});
		return;
	}
	var content = rowdata[0].memberID;
	$(".right_col").load("web/member/allMembers/per-inquiryFinancialAdvisor.jsp?content="+content);
}

/**
 * 拉黑会员
 */
$(function () {
	 appPath = getRootPath();//项目根路径
	//拉黑
	$(".defriend").on("click touchstart",function(){
		//获得选取的对象
		var rowdata = $('#table_id').DataTable().rows('.selected').data();
		if(rowdata.length<1){
			layer.alert("请选择要处理的事务！",{icon:0});
			return;
		}
		var remark = $("#cancelBlack").val();
		var memberId=rowdata[0].memberId;
		var encrypt = new JSEncrypt();
		encrypt.setPublicKey(publicKey_common);
		//result 为加密后参数
		memberId = encrypt.encrypt(memberId+"");
		layer.confirm('确定拉黑该会员？', {
			btn:['确定', '取消']
		  ,yes: function(index, layero){ //或者使用btn1
		    //确定的回调
		  	//判断执行不同方法
			  $.ajax({
				  	type : 'post',
				  	url : appPath + "/member/pullBlackMember.do",
				  	data : {
				  		memberId : memberId,
					},
					dataType:"text",
				  	success : function (data) {
				  		if(data ==0 ){
				  			layer.alert("拉黑成功!",{icon:1});
				  			layer.close(index);  
				  			setTimeout('location.reload()',500);
				  		}else{
				  			layer.alert("拉黑失败!",{icon:2});
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
	});
});


/* 取消拉黑会员*/
function cancelBlackList(){
	//获得选取的对象
	var rowdata = $('#table_id').DataTable().rows('.selected').data();
	if(rowdata.length<1){
		layer.alert("请选择要处理的事务！",{icon:0});
		return;
	}
	var memberId=rowdata[0].memberId;
	var encrypt = new JSEncrypt();
	encrypt.setPublicKey(publicKey_common);
	//result 为加密后参数
	memberId = encrypt.encrypt(memberId+"");
	layer.open({
		type: 1,
		area: ['400px', '200px'], //高宽
		title: "取消拉黑会员",
		maxmin: true,
		content: $("#cancelBlackList"),//DOM或内容
		btn:['确定', '取消']
		,yes: function(index, layero){ //或者使用btn1
		//确定的回调
		//判断执行不同方法
		var remark =$("#cancelBlack").val();
		  $.ajax({
			  	type : 'post',
			  	url : appPath + "/member/removeBlack.do",
			  	data : {
			  		memberId : memberId,
			  		content:remark
				},
				dataType:"text",
			  	success : function (data) {
			  		if(data ==0 ){
			  			layer.alert("取消拉黑成功!",{icon:1});
			  			layer.close(index);  
			  			setTimeout('location.reload()',500);
			  		}else{
			  			layer.alert("取消拉黑失败!",{icon:2});
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


/*  发送信息弹出框            */
/**
 * 发送信息弹出框
 */
function messageSendPer(title,page,type){
	//参数判断，自己写全
	//console.log(title+","+page+","+type);
	var rowdata = $('#table_id').DataTable().rows('.selected').data();
	if(rowdata.length<1){
		layer.alert("请选择要处理的事务！",{icon:0});
		return;
	}
	var content=rowdata[0].memberId;
	page= page+"?content="+content;
	if(title == "" || page == "" || type == "" ){
		console.log("参数异常,请检查参数");
		return;
	}
	layer.open({
	    type: 2,
	    area: ['600px', '400px'], //高宽
	    title: title,
	    maxmin: true,
	    content: page,//DOM或内容
	    btn:  ['发送','取消']
			,yes: function(index, layero){ //或者使用btn1
				//确定的回调
				//判断执行不同方法
				var body = layer.getChildFrame('body', index);
				var type = body.find(":radio:checked").val();
				
				var remark = body.find("textarea").val();
				var phone =body.find("span[id='memberPhone']").text();
				var email = body.find("span[id='memberEmail']").text();
				if(type == 1 && (phone==null || phone=="")){
					layer.alert("该会员无手机号，无法发送！",{icon:1});
					return ;
				}
				if(type == 2 && (email=="" ||  email==null)){
					layer.alert("该会员无邮箱，无法发送！",{icon:1});
					return ;
				}
				var encrypt = new JSEncrypt();
				encrypt.setPublicKey(publicKey_common);
				//result 为加密后参数
				type = encrypt.encrypt(type+"");
				phone = encrypt.encrypt(phone);
				email = encrypt.encrypt(email);
				memberId = encrypt.encrypt(content+"");
				memberType = encrypt.encrypt(memberType+"");
				remark = encrypt.encrypt(remark+"");
				
				  $.ajax({
					  	type : 'post',
					  	url : appPath + "/member/sendMessage.do",
					  	data : {
					  		memberId : memberId,
					  		memberType:memberType,
					  		type:type,
					  		phone:phone,
					  		email:email,
					  		remark:remark
						},
						dataType:"text",
					  	success : function (data) {
					  		if(data ==0 ){
					  			layer.alert("发送成功!",{icon:1});
					  			layer.close(index);  
					  			setTimeout('location.reload()',500);
					  		}else{
					  			layer.alert("发送失败!",{icon:2});
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
};


/* 黑名单受限设置*/
function prohibitedItem(){
	/**
	 * 先查询黑名单受限
	 */
	 $.ajax({
		  	type : 'post',
		  	url : appPath + "/blackstint/BlackLimitList.do",
		  	data : {
			},
			dataType:"json",
		  	success : function (data) {
		  		if(data.length>0){
		  			$.each(data,function(index,obj){
		  				 $(".checkList").each(function(){
		  					 if(obj.optType == $(this).val() ){
		  						$(this).prop("checked",true);
		  					 }
		  				 });
		  			});
		  			
		  		}
		  	},
		  	error : function() {  
		          layer.alert("操作失败!",{icon:2});  
		    }
		  });
	layer.open({
		type: 1,
		area: ['400px', '200px'], //高宽
		title: "黑名单受限设置",
		maxmin: true,
		content: $("#prohibitedItem"),//DOM或内容
		btn:['确定', '取消']
	,yes: function(index, layero){ //或者使用btn1
		//确定的回调
		//判断执行不同方法
		var  limit ="";
		$(".checkList").each(function(){
			if($(this).prop("checked")){
				limit+=$(this).val()+",";
			}
		});
		 $.ajax({
			  	type : 'post',
			  	url : appPath + "/blackstint/AddLimitList.do",
			  	data : {
			  		content : limit
				},
				dataType:"text",
			  	success : function (data) {
			  		if(data >0 ){
			  			layer.alert("保存成功!",{icon:1});
			  			layer.close(index);  
			  			setTimeout('location.reload()',500);
			  		}else{
			  			layer.alert("保存失败!",{icon:2});
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







