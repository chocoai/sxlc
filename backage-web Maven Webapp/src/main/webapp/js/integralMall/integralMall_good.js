


//入库
function bankManagementKdd(title){
	var data = $("#teamTb").DataTable().rows('.selected').data();
	if(data.length<1){
		layer.alert("请选择要入库的商品！",{icon:0});
		return;
	}
	$("#intoKu").val("");
	var commodityID = encrypt.encrypt(data[0].commodityID+"");
	
	layer.open({
	    type: 1,
	    area: ['500px', '160px'], 
	    title: title,
	    maxmin: true,
	    content: $("#into"),
	    btn:['确定', '取消']
		  ,yes: function(index, layero){ 
			  var url = "commodityManager/putk.do";
			  var data = {goodId:commodityID};
			  data.addNumber = encrypt.encrypt($("#intoKu").val()+"");			  
		  	 NetUtil.ajax(
		  			 url,
		  			 data,
		  			 function(data){
		  				 
		  				if (data.status=="1"){
							layer.alert("入库成功",function(index){
								layer.closeAll();
								$('#teamTb').DataTable().ajax.reload();
							})
						}else if(data.status=="0"){
							layer.alert("入库失败",function(index){
								layer.close(index);
							})
						}
		  			 }
		  	 )
		  },cancel: function(index){
			  
		  }
	});
}
//设置Vip折扣
function bankManagementVdd(title){
	var data = $("#teamTb").DataTable().rows('.selected').data();
	if(data.length<1){
		layer.alert("请选择要设置VIP折扣的商品！",{icon:0});
		return;
	}
	$("#vipSale").val("");
	var commodityID = encrypt.encrypt(data[0].commodityID+"");
	layer.open({
	    type: 1,
	    area: ['500px', '150px'], 
	    title: title,
	    maxmin: true,
	    content: $("#intoVip"),
	    btn:['确定', '取消']
		  ,yes: function(index, layero){ 
			  var url = "commodityManager/confvipzk.do";
			  var data = {goodId:commodityID};
			  data.discount = encrypt.encrypt($("#vipSale").val()+"");
		  	 NetUtil.ajax(
		  			 url,
		  			 data,
		  			 function(data){
		  				 
		  				if (data.status=="1"){
							layer.alert("设置VIP折扣成功",function(index){
								layer.closeAll();
								$('#teamTb').DataTable().ajax.reload();
							})
						}else if(data.status=="0"){
							layer.alert("设置VIP折扣失败",function(index){
								layer.close(index);
							})
						}
		  			 }
		  	 )
		  },cancel: function(index){
			  
		  }
	});
}



//2016-5-10 付晨早
function takeOnOrOff(type,orderId){

	if (type == "0"){
		layer.confirm('确定下架该商品？', {
			  btn: ['确定', '取消'],
			  yes:function(){
				  var url = "commodityManager/offShelf.do";
				  var data = {commodityId:encrypt.encrypt(orderId+"")}
				  NetUtil.ajax(
						  url,
						  data,
						  function(){
							  if (data.status=="1"){
									layer.alert("下架成功",function(index){
										layer.close(index);
										$('#table_id').DataTable().ajax.reload();
									})
								}else if(data.status=="0"){
									layer.alert("下架失败",function(index){
										layer.close(index);
									})
								}
						  }
				  )
			  }
			});
	}else if(type == "1"){
		layer.confirm('确定上架该商品？', {
			  btn: ['确定', '取消'],
			  yes:function(){
				  var url = "commodityManager/shelves.do";
				  var data = {commodityId:encrypt.encrypt(orderId+"")}
				  NetUtil.ajax(
						  url,
						  data,
						  function(data){
							  if (data.status=="1"){
									layer.alert("上架成功",function(index){
										layer.close(index);
										$('#teamTb').DataTable().ajax.reload();
									})
								}else if(data.status=="0"){
									layer.alert("上架失败",function(index){
										layer.close(index);
									})
								}
						  }
				  )
			  }
			});
	}
}


function changeDefine(value){
	if (value == undefined){
		return ""
	}else{
		return value
	}
}

$(function(){
	$("#teamTb").DataTable(
			{
				ajax:{
					"url": appPath+"/commodityManager/loadList.do",   
					"dataSrc": "results", 
					"type": "POST",
					"data": function ( d ) {  
						var pName = changeDefine($("#productName").val());
						var pNumber = changeDefine($("#productNum").val());
						var upId = $("#upType").val();
						var status = $("#upOption").val();
						d.pName = encrypt.encrypt(pName+"");
						d.pNumber = encrypt.encrypt(pNumber+"");
						d.upId = encrypt.encrypt(upId+"");
						d.status = encrypt.encrypt(status+"");
					}
				},
				columns:
					[
						{	
							title:"",sWidth:"3%", 
							  "mRender": function (data, type, full) {
								  sReturn = '<input type="checkbox" class="tr-checkbox" value="1" />';
								  return sReturn;
							  }
						},
						{
							title:"添加时间",
							"data":"addTime"
						},
						{
							title:"商品编号",
							"data":"commodityNO"
						},
						{
							title:"商品名称",
							"data":"commodityName"
						},
						{
							title:"商品类别",
							"data":"commodityTypename"
						},
						{
							title:"商品种类",
							"data":"commodityClassify"
						},
						{
							title:"商品单价",
							"data":"needPoint"
						},
						{
							title:"是否为VIP共享",
							"data":"isVIPExclusive",
							"mRender": function (data, type, full) {
								if(data==0){
				        			  return "否";
				        		  }else if(data==1){
				        			  return "是";
				        		  }
							}
						},
						{
							title:"操作",
							"data":"commodityStatu",
							"mRender": function (data, type, full) {
								if(data=="1"){
				        			  return "<a onclick=\"takeOnOrOff(0,'"+full.commodityID+"');\" href=\"javascript:void(0);\">下架</a>" ;
				        		  }else if(data == "0"||data == "2"){
				        			  return "<a onclick=\"takeOnOrOff(1,'"+full.commodityID+"');\" href=\"javascript:void(0);\">上架</a>";
				        		  }
							}
						},
						{
							title:"状态",
							"data":"commodityStatus"
						},
						{
							title:"VIP折扣",
							"data":"vipDiscounts"
						},
						{
							title:"是否为活动商品",
							"data":"isActive",
							 "mRender": function (data, type, full) {
				        		  if(data=="1"){
				        			  return "是";
				        		  }else if(data==1){
				        			  return "否";
				        		  }else{
				        			  return "";
				        		  }
				        	  }
						},
						{
							title:"已兑换",
							"data":"sumQuantity"
						},
						{
							title:"待发货",
							"data":"backorder"
						},
					 ],
		          aoColumnDefs : [
		                          {
		                        	  "orderable" : false,
		                        	  "aTargets" : [0,2,3,4,5,6,7,8,9,10,11,12,13]
		                          } // 制定列不参与排序
	                          ],
					pagingType: "simple_numbers",//设置分页控件的模式  
					processing: true, //打开数据加载时的等待效果  
					serverSide: true,//打开后台分页  
					scrollCollapse: true,
					scrollX : "100%",
					scrollXInner : "100%",
			}
	);
	
	
	//表格单选效果(有复选框)
	 $('#teamTb tbody').on( 'click', 'tr', function () {
		    var $this = $(this);
		    var $checkBox = $this.find("input:checkbox");
	        if ( $this.hasClass('selected') ) {
	        	 $checkBox.prop("checked",false);
	        	$this.removeClass('selected');
	        } else {
	        	$(".tr-checkbox").prop("checked",false);
	        	$checkBox.prop("checked",true);
	        	$('#teamTb tr.selected').removeClass('selected');
	        	$this.addClass('selected');
	        }
	  });
	 
	 $(".glyphicon-search").on("click",function(){
			$('#teamTb').DataTable().ajax.reload();
			
		});
	 
	 //修改
	 $("#upProdu").on("click",function(){
		 var data = $("#teamTb").DataTable().rows('.selected').data();
			if(data.length<1){
				layer.alert("请选择要修改的商品！",{icon:0});
				return;
			}
		window.location='web/integralMall/good_xdd.jsp?id='+data[0].commodityID;
	 })
	 
	 //推荐商品到首页
	 
	 $("#recPro").click(function(){
		var data = $("#teamTb").DataTable().rows('.selected').data();
		if(data.length<1){
			layer.alert("请选择要推荐的商品！",{icon:0});
			return;
		}
		var commodityID = encrypt.encrypt(data[0].commodityID+"");
		 layer.confirm('确定推荐该商品到商城首页？', {
			  btn: ['确定', '取消'],
			  s:function(){
				  var url = "commodityManager/configGood.do";
				  var data = {goodId:commodityID}
				  NetUtil.ajax(
						  url,	
						  data,
						  function(data){
							  if (data.status=="1"){
									layer.alert("操作成功",function(index){
										layer.close(index);
										$('#teamTb').DataTable().ajax.reload();
									})
								}else if(data.status=="0"){
									layer.alert("操作失败",function(index){
										layer.close(index);
									})
								}
						  }
				  )
			  }
			});
	 })
	 
	 //查看入库记录
	 $("#lookIntoKu").on("click",function(){
			var data = $("#teamTb").DataTable().rows('.selected').data();
			if(data.length<1){
				layer.alert("请选择要查看的商品！",{icon:0});
				return;
			}
			var commodityID = data[0].commodityID;
			window.location='web/integralMall/good_rdd.jsp?id='+commodityID;
			
	 })
});








//发货
$(function () {
	var appPath = getRootPath();//项目根路径
	$(".fahuo").on("click touchstart",function(){
		
		layer.confirm('确认发货吗？', {
		  btn: ['确定', '取消']
		});
	});
});
//撤销订单
$(function () {
	var appPath = getRootPath();//项目根路径
	$(".chexiao").on("click touchstart",function(){
		
		layer.confirm('确定撤销订单？', {
		  btn: ['确定', '取消']
		});
	});
});
