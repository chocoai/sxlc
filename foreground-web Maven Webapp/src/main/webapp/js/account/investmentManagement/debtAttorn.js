$(function(){
	$(".TD").addClass("down");
	$(".TD4").addClass("down2");
	/*切换显示部分开始 王延君 2016-04-01*/
	$(".inTransfer").css("color","#72c0f3");
	$(".inTransfer").css("border-bottom","2px solid #72c0f3");
	
	/*切换显示部分结束 王延君 2016-04-01*/
	/*分页部分结束*/
	
//	2016-5-6 付晨早
	//只要日期，不要时间
	template.helper("$timeFixed",function(content){
		var index = content.indexOf(" ");
		return content.substring(0,index)
	})
	//金额取小数点后2位
	template.helper("$toFixed",function(content){
		return parseInt(content).toFixed(2);
	})
	//去掉时间后的.0
	template.helper("$toDelete",function(content){
		var index = content.indexOf(".");
		if (index>=0){
			return content.substring(0,index)
		}
		
	})

	var debtAttorn = {
			//转让中
			recycling:function(cpage,pageSize){

				var data = {};
				var encrypt = new JSEncrypt();
				encrypt.setPublicKey(publickey);

				if (cpage!=undefined){
					data.cpage = encrypt.encrypt(cpage+"");
				};
				if (pageSize!=undefined){
					data.pageSize = encrypt.encrypt(pageSize+"");
				};
				var url = "investmentManagement/transferIn.html";

				NetUtil.ajax(
						url,
						data,
						function(r){
							var data = JSON.parse(r);
							if (data.tol>0){
								var html = template("inTransferList",data);
								$("inTransTop").siblings().remove();
								$("#inTransferUl").append(html);
								var totalPage = Math.ceil(data.tol/data.pageSize);
								var totalRecords = data.tol;
								var pageNo = data.cpage;
								$("#pager").html("");
								pager.generPageHtml({
								pno : pageNo,
								//总页码
								total : totalPage,
								//总数据条数
								totalRecords : totalRecords,
								mode : 'click',//默认值是link，可选link或者click
								click : function(n) {
									debtAttorn.recycling(n);
										this.selectPage(n);
										return false;
									}
								});
							}
						}
					)
			},
			//可转出
			settled:function(cpage,pageSize){
				var data = {};
				var encrypt = new JSEncrypt();
				encrypt.setPublicKey(publickey);
				
				
				if (cpage!=undefined){
					
					data.cpage = encrypt.encrypt(cpage+"");
				}
				if (pageSize!=undefined){
					data.pageSize = encrypt.encrypt(pageSize+"");
				}
				var url = "investmentManagement/canTurnOut.html";

				NetUtil.ajax(
						url,
						data,
						function(r){
							
							var data = JSON.parse(r);
							console.log(data)
							if (data.tol>0){
								var html = template("transferAbleList",data);
								$("#topTransferAble").siblings().remove();
								$("#transferAbleUl").append(html);
								var totalPage = Math.ceil(data.tol/data.pageSize);
								var totalRecords = data.tol;
								var pageNo = data.cpage;
								pager1.generPageHtml({
								pno : pageNo,
								//总页码
								total : totalPage,
								//总数据条数
								totalRecords : totalRecords,
								mode : 'click',//默认值是link，可选link或者click
								click : function(n) {
									debtAttorn.settled(n);
									this.selectPage(n);
									return false;
									}
								});
								$('.attornBtn').on('click', function(){
									layer.open({
										title :'转让',//标题
										skin: 'layer-ext-myskin',//皮肤
								        type: 1,
								        area: ['541px', '499px'],//大小宽*高
								        shadeClose: true, //点击遮罩关闭
								        content: $('.layerWindow')//内容，里边是包含内容的div的class
								    });
									console.log($(this).index());
									$("#transferableMoney").html(data.infos[$(this).index()].sMoney);
									$("#inputInvestId").val(data.infos[$(this).index()].investId);
									
								});
								
								
							};
							
							
							
						}
					)
			},
			//已转出
			bidding:function(cpage,pageSize){
				var data = {};
				var encrypt = new JSEncrypt();
				encrypt.setPublicKey(publickey);
				
				if (cpage!=undefined){
					data.cpage = encrypt.encrypt(cpage+"");
				};
				if (pageSize!=undefined){
					data.pageSize = encrypt.encrypt(pageSize+"");
				};
				var url = "investmentManagement/turnOut.html";
				NetUtil.ajax(
						url,
						data,
						function(r){
							var data = JSON.parse(r);
							console.log(data)
							if (data.tol>0){
								var html = template("transferOutedList",data);
								$("#topTransferOut").siblings().remove();
								$("#transferOutedUl").append(html);
								var totalPage = Math.ceil(data.tol/data.pageSize);
								var totalRecords = data.tol;
								var pageNo = data.cpage;
								pager2.generPageHtml({
								pno : pageNo,
								//总页码
								total : totalPage,
								//总数据条数
								totalRecords : totalRecords,
								mode : 'click',//默认值是link，可选link或者click
								click : function(n) {
									debtAttorn.bidding(n);
									this.selectPage(n);
									return false;
									}
								});
							}
						}
					)
			},
			//已转入
			bidders:function(cpage,pageSize){
				var data = {};
				var encrypt = new JSEncrypt();
				encrypt.setPublicKey(publickey);
				
				if (cpage!=undefined){
					data.cpage = encrypt.encrypt(cpage+"");
				};
				if (pageSize!=undefined){
					data.pageSize = encrypt.encrypt(pageSize+"");
				};
				var url = "investmentManagement/changeInto.html";
				NetUtil.ajax(
						url,
						data,
						function(r){
							var data = JSON.parse(r);
							console.log(data);
							if (data.tol>0){
								var html = template("transferInedList",data);
								$("#topTransferIned").siblings().remove();
								$("#transferInedUl").append(html);
								var totalPage = Math.ceil(data.tol/data.pageSize);
								var totalRecords = data.tol;
								var pageNo = data.cpage;
								pager3.generPageHtml({
								pno : pageNo,
								//总页码
								total : totalPage,
								//总数据条数
								totalRecords : totalRecords,
								mode : 'click',//默认值是link，可选link或者click
								click : function(n) {
									debtAttorn.bidding(n);
									this.bidders(n);
									return false;
									}
								});
							}
						}
					)
			},
			//已结清
			bid_success:function(cpage,pageSize){
				var data = {};
				var encrypt = new JSEncrypt();
				encrypt.setPublicKey(publickey);
				
				if (cpage!=undefined){
					data.cpage = encrypt.encrypt(cpage+"");
				};
				if (pageSize!=undefined){
					data.pageSize = encrypt.encrypt(pageSize+"");
				};
				var url = "investmentManagement/debtsSettled.html";
				NetUtil.ajax(
						url,
						data,
						function(r){
							var data = JSON.parse(r);
							console.log(data);
							if (data.tol>0){
								var html = template("SettledList",data);
								$("#topSettledUl").siblings().remove();
								$("#SettledUl").append(html);
								var totalPage = Math.ceil(data.tol/data.pageSize);
								var totalRecords = data.tol;
								var pageNo = data.cpage;
								pager4.generPageHtml({
								pno : pageNo,
								//总页码
								total : totalPage,
								//总数据条数
								totalRecords : totalRecords,
								mode : 'click',//默认值是link，可选link或者click
								click : function(n) {
									debtAttorn.bid_success(n);
									this.bidders(n);
									return false;
									}
								});
							}
						}
					)
			}
	}
	//初始化
	debtAttorn.recycling();
	$(".debtAttornH div").click(function(){
		var index=$(this).index();
		$(this).css("color","#72c0f3").siblings().css("color","#000");
		$(this).css("border-bottom","2px solid #72c0f3").siblings().css("border-bottom","none");
		$(".debtAttornM ul").eq(index).show().siblings("ul").hide();
		if(index == 0){
			debtAttorn.recycling();
		};
		if(index == 1){
			debtAttorn.settled();
		};
		if(index == 2){
			debtAttorn.bidding();
		};
		if(index == 3){
			debtAttorn.bidders();
		};
		if(index == 4){
			debtAttorn.bid_success();
		};
	});
	
	$("#getSaleNum").on("keyup",function(){
		var num = $("#getSaleNum").val()*$("#getTransNum").val()*0.01;
		console.log($("#getSaleNum").val()*$("#getTransNum").val()*0.01);
		$("#shouyi").html(num);
	});
	
	
	$("#sureBtn").on("click",function(){
		var data = {};
		var encrypt = new JSEncrypt();
		encrypt.setPublicKey(publickey);
		data.iId = encrypt.encrypt($("#inputInvestId").val()+"");
		data.discount = encrypt.encrypt($("#getSaleNum").val()+"");
		data.extras = encrypt.encrypt($("#getTransNum").val()+"");
		var url = "investmentManagement/turnOutDebts.html";
		console.log(data);
		NetUtil.ajax(
				url,
				data,
				function(r){
					var data = JSON.parse(r);
					console.log(data)
					if (data.status == 0){
						layer.alert("转让成功",function(){
							layer.close()
						})
					}
					if (data.status == -1){
						layer.alert("转让失败")
					}
					if (data.status == -2){
						layer.alert("转让金额大于可转让金额")
					}
				}
		)
		
	})
	
	
	
	
	
	
	
	
});
