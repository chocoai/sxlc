/* 表格 */
$(function(){
	$('#table_inv_integral').DataTable({
		//scrollY:400,
		/*scrollX:true,*/
		"aaSorting" : [],//默认第几个排序
		"aoColumnDefs" : [
		//{"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
		{
			"orderable" : false,
			"aTargets" : [0,1,2,3,4]
		} // 制定列不参与排序
		],
		scrollCollapse: true,
		/*scrollX : "100%",*/
		scrollXInner : "100%",
	});
	$('#table_credit_integral').DataTable({
		//scrollY:400,
		/*scrollX:true,*/
		"aaSorting" : [],//默认第几个排序
		"aoColumnDefs" : [
		//{"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
		{
			"orderable" : false,
			"aTargets" : [0,1,2,3,4]
		} // 制定列不参与排序
		],
		scrollCollapse: true,
		/*scrollX : "100%",*/
		scrollXInner : "100%",
	});
	
	$('#table_recharge_integral').DataTable({
		//scrollY:400,
		/*scrollX:true,*/
		"aaSorting" : [],//默认第几个排序
		"aoColumnDefs" : [
		//{"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
		{
			"orderable" : false,
			"aTargets" : [0,1,2,3,4]
		} // 制定列不参与排序
		],
		scrollCollapse: true,
		/*scrollX : "100%",*/
		scrollXInner : "100%",
	});
	$('#table_loan_integral').DataTable({
		//scrollY:400,
		/*scrollX:true,*/
		"aaSorting" : [],//默认第几个排序
		"aoColumnDefs" : [
		//{"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
		{
			"orderable" : false,
			"aTargets" : [0,1,2,3,4]
		} // 制定列不参与排序
		],
		scrollCollapse: true,
		/*scrollX : "100%",*/
		scrollXInner : "100%",
	});

	//启用停用
	$(".btn-enable").on("click",function(){
		layer.alert("确认启用吗？",{
			icon:0,
			btn:['确定', '取消']
			,yes: function(index, layero){ //或者使用btn1
		    //确定的回调
		    },cancel: function(index){//或者使用btn2（concel）
		  	//取消的回调
		    }
		});
	});
	$(".btn-disable").on("click",function(){
		layer.alert("确认停用吗？",{
			icon:0,
			btn:['确定', '取消']
			,yes: function(index, layero){ //或者使用btn1
		    //确定的回调
		    },cancel: function(index){//或者使用btn2（concel）
		  	//取消的回调
		    }
		});
	});
	//删除
	$(".btn-inv-del").on("click",function(){
		layer.alert("确认删除吗？",{
			icon:0,
			btn:['确定', '取消']
			,yes: function(index, layero){ //或者使用btn1
		    //确定的回调
		    },cancel: function(index){//或者使用btn2（concel）
		  	//取消的回调
		    }
		});
	});
	/*********投资积分********/
	//添加
	$(".btn-inv-add").on("click",function(){
		layer.open({
		    type: 1,
		    area: ['400px', '200px'], //宽高
		    title: "添加",
		    content: $(".inv-integral-layer"),//DOM或内容
		    btn:['确定', '取消']
			,yes: function(index, layero){ //或者使用btn1
				//确定的回调
			},cancel: function(index){//或者使用btn2（concel）
				//取消的回调
			}
		});
	});
	//修改
	$(".btn-inv-mod").on("click",function(){
		layer.open({
		    type: 1,
		    area: ['400px', '200px'], //宽高
		    title: "添加",
		    content: $(".inv-integral-layer"),//DOM或内容
		    btn:['确定', '取消']
			,yes: function(index, layero){ //或者使用btn1
				//确定的回调
			},cancel: function(index){//或者使用btn2（concel）
				//取消的回调
			}
		});
	});
	/**********债权转让投资积分*********/
	//添加
	$(".btn-credit-add").on("click",function(){
		layer.open({
		    type: 1,
		    area: ['400px', '200px'], //宽高
		    title: "添加",
		    content: $(".credit-integral-layer"),//DOM或内容
		    btn:['确定', '取消']
			,yes: function(index, layero){ //或者使用btn1
				//确定的回调
			},cancel: function(index){//或者使用btn2（concel）
				//取消的回调
			}
		});
	});
	//修改
	$(".btn-credit-mod").on("click",function(){
		layer.open({
		    type: 1,
		    area: ['400px', '200px'], //宽高
		    title: "添加",
		    content: $(".credit-integral-layer"),//DOM或内容
		    btn:['确定', '取消']
			,yes: function(index, layero){ //或者使用btn1
				//确定的回调
			},cancel: function(index){//或者使用btn2（concel）
				//取消的回调
			}
		});
	});
	/***********充值积分**********/
	//添加
	$(".btn-recharge-add").on("click",function(){
		layer.open({
		    type: 1,
		    area: ['400px', '200px'], //宽高
		    title: "添加",
		    content: $(".recharge-integral-layer"),//DOM或内容
		    btn:['确定', '取消']
			,yes: function(index, layero){ //或者使用btn1
				//确定的回调
			},cancel: function(index){//或者使用btn2（concel）
				//取消的回调
			}
		});
	});
	//修改
	$(".btn-recharge-mod").on("click",function(){
		layer.open({
		    type: 1,
		    area: ['400px', '200px'], //宽高
		    title: "添加",
		    content: $(".recharge-integral-layer"),//DOM或内容
		    btn:['确定', '取消']
			,yes: function(index, layero){ //或者使用btn1
				//确定的回调
			},cancel: function(index){//或者使用btn2（concel）
				//取消的回调
			}
		});
	});
	/**********借款积分**********/
	//添加
	$(".btn-loan-add").on("click",function(){
		layer.open({
		    type: 1,
		    area: ['400px', '200px'], //宽高
		    title: "添加",
		    content: $(".loan-integral-layer"),//DOM或内容
		    btn:['确定', '取消']
			,yes: function(index, layero){ //或者使用btn1
				//确定的回调
			},cancel: function(index){//或者使用btn2（concel）
				//取消的回调
			}
		});
	});
	//修改
	$(".btn-loan-mod").on("click",function(){
		layer.open({
		    type: 1,
		    area: ['400px', '200px'], //宽高
		    title: "添加",
		    content: $(".loan-integral-layer"),//DOM或内容
		    btn:['确定', '取消']
			,yes: function(index, layero){ //或者使用btn1
				//确定的回调
			},cancel: function(index){//或者使用btn2（concel）
				//取消的回调
			}
		});
	});
});