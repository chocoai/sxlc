/* 获取项目根目录全路径
 * @returns
 */
function getRootPath(){
        var curWwwPath=window.document.location.href;
        var pathName=window.document.location.pathname;
        var pos=curWwwPath.indexOf(pathName);
        var localhostPath=curWwwPath.substring(0,pos);
        var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
		if(/127.0.0.1|localhost/.test(localhostPath)){
			return(localhostPath+projectName);
		}else{
			return(localhostPath);
		}
}
//判断
function changeDefine(value){
	if (value == undefined){
		return "";
	}else{
		return value;
	}
}
//弹出框
function enableOrDisable(statu,orderId){
	if (statu == "1"){
//		var str = "确定发货？";
		layer.open({
		    type: 1,
		    area: ['500px', '250px'], 
		    title: "填写发货信息",
		    maxmin: true,
		    content: $("#into_dd"),
		    btn:['确定', '取消']
			  ,yes: function(){
				var into_dd11=$("#into_dd1").val();
				var into_dd22=$("#into_dd2").val();
				var into_dd33=$("#into_dd3").val();
				if (into_dd11==undefined||into_dd11==""){
					  layer.alert("请填写物流公司名称",function(index){
						  layer.close(index);
					  });
					  return
				  }
				if (into_dd22==undefined||into_dd22==""){
					  layer.alert("请填写物流单号",function(index){
						  layer.close(index);
					  });
					  return
				  }
				if (into_dd33==undefined||into_dd33==""){
					  layer.alert("请填写通知信息内容",function(index){
						  layer.close(index);
					  });
					  return
				  }
				into_D1 = encrypt.encrypt( changeDefine(into_dd11) + "");
				into_D2 = encrypt.encrypt( changeDefine(into_dd22) + "");
				into_D3 = encrypt.encrypt( changeDefine(into_dd33) + "");
				var url = "orderManager/delivery.do";
				var data= {"orderId":orderId,"logisticsCompany":into_D1,"logisticsNO":into_D2,"InformationIN":into_D3};
				alert(orderId)
				NetUtil.ajax(
						url,
						data,
						function(data){
							alert(data.status)
							if (data.status=="1"){
								layer.alert(data.message,function(index){
									layer.closeAll();
									$('#applicationAudit').DataTable().ajax.reload();
								});
							}else if(data.status=="0"){
								layer.alert(data.message,function(index){
									layer.closeAll();
								})
							}else if(data.status=="-1"){
								layer.alert(data.message,function(index){
									layer.closeAll();
								})
							}
						}
				);
			},no:function(index){
				layer.close(index);
			}
		})
	}else if(statu == "0"){
		var str = "确定撤销订单？";
		layer.confirm(str, {
			  btn: ['确定', '取消']
			},function(){
				var url = "orderManager/revokeOrder.do";
				var data= {"orderId":orderId,"revocationReason":revocationReason};
				NetUtil.ajax(
						url,
						data,
						function(r){
							var data = JSON.parse(r);
							if (data.status=="-1"){
								layer.alert(data.message,function(index){
									layer.close(index);
									$('#applicationAudit').DataTable().ajax.reload();
								});
							}else{
									layer.close(index);
							}
						}
				);
			},function(index){
				layer.close(index);
			});
	}
}

$(".glyphicon-search").on("click",function(){
	$('#applicationAudit').DataTable().ajax.reload();
});
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
            "url": "orderManager/loadList.do",   
            "dataSrc": "results", 
            "type": "POST",
            "data": function ( d ) {  
            	//请求的参数
            	
            	var exchangeStartTime = changeDefine($(".stime1").val());
            	var exchangeEndTime = changeDefine($(".stime2").val());
            	var deliveryStartTime = changeDefine($(".etime1").val());
            	var deliveryEndTime = changeDefine($(".etime2").val());
            	var userName = changeDefine($("#userId").val());
            	var memberName = changeDefine($("#userName").val());
            	var contactPhone = changeDefine($("#userPhone").val());
            	var goodId = changeDefine($("#proId").val());
            	var goodName = changeDefine($("#proName").val());
            	var status = $("#proSelect").val();
            		
	            	d.exchangeStartTime = encrypt.encrypt(exchangeStartTime + "");
	            	d.exchangeEndTime = encrypt.encrypt(exchangeEndTime + "");
	            	d.deliveryStartTime = encrypt.encrypt(deliveryStartTime + "");
	            	d.deliveryEndTime = encrypt.encrypt(deliveryEndTime + "");
            		d.userName = encrypt.encrypt(userName + "");
					d.memberName = encrypt.encrypt(memberName+"");
					d.contactPhone = encrypt.encrypt(contactPhone +"");
					d.goodId = encrypt.encrypt(goodId+"");
					d.goodName = encrypt.encrypt(goodName + "");
					d.status = encrypt.encrypt(status + "");
            } 
        },
        columns: [  
                  { title:"兑换时间","data": "exchangeTime" },
                  { title:"发货时间","data": "deliveryTime" }, 
                  { title:"会员用户名","data": "logname" },
                  { title:"会员姓名","data": "personalName" },
                  { title:"联系电话","data": "personalPhone" },
                  { title:"商品编号","data": "commodityNO" },
                  { title:"商品名称","data": "commodityName" },
                  { title:"兑换数量","data": "quantity" },
                  { title:"应付积分","data": "needPoint" },
                  { title:"实际使用积分","data": "realPoint" },
                  { title:"状态","data": "orderType",
                	  "mRender": function (data, type, full) {
		        		  if(data==1){
		        			  return "<font color='red'>订单失败</font>";
		        		  }else if(data==0){
		        			  return "已下单";
		        		  }else if(data==2){
		        			  return "<font color='blue'>已发货</font>";
		        		  }else if(data==3){
		        			  return "已完成";
		        		  }
		        	  }
                  },
                  { title:"操作","data": "orderType",
                	  "mRender": function (data, type, full) {
                		  if(data==0){
		        			  return "<a onclick=\"enableOrDisable(1,'"+full.orderID+"');\" href=\"javascript:void(0);\">发货</a>" ;
		        		  }else if(data==1){
		        			  return "<a onclick=\"enableOrDisable(0,'"+full.orderID+"');\" href=\"javascript:void(0);\">撤销订单</a>";
		        		  }else{
		        			  return "";
		        		  }
		        	  }
                  }
                  ],
        "aaSorting" : [[0,1,9,10,"desc"]],//默认第几个排序
		"aoColumnDefs" : [
		{
			"orderable" : false,
			"aTargets" : [ 2,3,4,5,6,7,8,11]
		} // 制定列不参与排序
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
