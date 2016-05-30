/*伍成然2016-3-24*/
$(function(){
	
	/*立即投资弹出层*/	
	/*标签选择*/	
	$(".label-select label").click(function(){
		$(this).parent().children().removeClass("active"); 
		$(this).addClass("active");
	});
	/*控制表格变色*/	
	jQuery.changeColor = function (ulid) {
		var liset = $(ulid).find("li");
		for (var i = 2; i < liset.length; i += 2) {
			liset.eq(i).css("background-color", "#f6f8fa");/*i控制从第几个变色*/	
		}
	};
	$.changeColor(".grid-table1");
	$.changeColor(".grid-table2");
	$.changeColor(".proli-table");
	
	//倒计时
	
	$('.J_CountDown').each(function () {
		var $this = $(this),
        data = $this.attr('data-config');
        $this.countDown(eval('(' + data + ')'));
	});
	
	
	/*进度条*/
	$(".progress").each(function(){
		$(this).find(".barline").css("width",$(this).find(".progress_totle").html());
	});
	
	/*radio样式切换效果*/	
	$(".select label").click(function(){
		$(this).parent().children().removeClass("active"); 
		$(this).addClass("active");
	});
});

/* 胥福星   2016-04-07   弹出提示层代码     */
jQuery.fn.layoutClick = function(str){
	var s = str;
	var m = '<div class="tipClick"><div class="contentTip">' + s + '<img class="imgTip" src="resource/img/invest/wytz_tip1.png"></div></div>';
	this.parent().css('position','relative');
	this.parent().append(m);
	this.parent().find(".tipClick").css("left",this.offset().left - this.parent().offset().left - this.innerWidth()/2+10);
	this.parent().find(".tipClick").css("top",this.offset().top - this.parent().offset().top + this.innerHeight() + 15 );
};



//2016-5-3 付晨早
	//只要日期，不要时间
	template.helper("$timeFixed",function(content){
		if (content == null){
			return null
		}
		var index = content.indexOf(" ");
		return content.substring(0,index)
	})
	//金额取小数点后2位
	template.helper("$toFixed",function(content){
		if (content == null){
			return null
		}
		return parseFloat(content).toFixed(2);
	})
	//去掉时间后的.0
	template.helper("$toDelete",function(content){
		if (content == null){
			return null
		}
		var index = content.indexOf(".");
		return content.substring(0,index)
	})

	//红包最多使用金额,初始化0
	var redMax = 0;
	
	var detail = {
			repaymentPlan:function(applyId){
				var url = "invest/repaymentPlan/"+applyId+".html";
				$.ajax({
					type:"GET",
					url:url,
					dataType:"json",
					success:function(r){
						var data = {json:r};
						var total = 0;
						for (var i=0;i<data.json.length;i++){
							total = total + parseFloat(data.json[i].sdPrincipalInterests)
						}
						$(".moneyFormat1").html(total);
						var html = template("repay_Plan",data);
						$("#repaymentPlanTop").siblings().remove();
						$("#repaymentPlan").append(html);	
					}
				})
			},
			investmentList:function(applyId){
				var url = "invest/investmentList/"+applyId+".html";
				$.ajax({
					type:"GET",
					url:url,
					dataType:"json",
					success:function(r){
						$("#moneyFormat2").html(parseFloat(r.availableAmount).toFixed(2));
						$("#moneyFormat3").html(parseFloat(r.investTotals).toFixed(2));
						$("#moneyFormat4").html(parseFloat(r.shenYuKeTou).toFixed(2));
						var data = r
						if (r.info.length>0){
							var html = template("invest_List",r);
							$("#investmentListTop").siblings().remove();
							$("#investmentList").append(html)	
						}
					}
				})
			},
			projectCourse:function(applyId){
				var url = "invest/projectCourse/"+applyId+".html";
				var data = {};
				$.ajax({
					type:"GET",
					url:url,
					dataType:"json",
					success:function(r){
						if (r!=null){
							data = r;
							$.ajax({
								type:"GET",
								url:"invest/projectCourseRepayment/"+applyId+".html",
								dataType:"json",
								success:function(r){
									if (r.toString()!=""){
										data.info = r;
										data.repayTime = r[0].repayMaxTime
									}
									var html = template("project_course",data);
									$("#projectCourse").html(html);
									
									//项目历程弹出层
									$(".pro-repay").mouseenter(function(){
										$(this).parent().children(".proLi").show();
										$(this).children("div").css("color","#72c0f3");
									});
									$(".pro-repay").mouseleave(function(){
										setTimeout(function(){		
											$(".proLi").hide();
										},1000);
										$(this).children("div").css("color","#605f5f");
									});
									$(".proLi").mouseenter(function(){
										setTimeout(function(){		
											$(".proLi").show();
										},1000);
									});
								}
							})
					
						}		
					}
				})
			},
			//贷后监管
			postLoanSupervision:function(applyId){
				var url = "invest/postLoanSupervision/"+applyId+".html";
				$.ajax({
					type:"GET",
					url:url,
					dataType:"json",
					success:function(r){
							if (r!=null){
								var data = {json:r};
								var html = template("postLoanList",data);
								$("#time-line").html(html);	
								$(".info-bottom-content").click(function(){
									$that = $(this);
									var n = $(this).attr("data-id");
									$.ajax({
										type:"GET",
										url:"invest/postLoanSupervisionDetail/"+n+".html",
										dataType:"json",
										success:function(r){
											if (r!=null){
												var html = "";
												for (var i=0;i<r.length;i++){
													html = "<img  class='text-img' src='"+imgProfix+r[i].attachUrl+ "'>";
												}
												html += "<h2>"+r[0].attachTitle+"</h2><p>"+r[0].projectAfterLoanInfoEntity.detail+"</p>";

												var $point = $that.parent().parent().prev();
												$point.find(".info-top-content").html(html);
												$point.show();
												$point.next().hide();
											}
											
										}
									});
								});
							}
						}
				})
			},
			//风控措施
			riskManagement:function(applyId){
				var url = "invest/riskManagement/"+applyId+".html";
				$.ajax({
					type:"GET",
					url:url,
					dataType:"json",
					success:function(r){
						$("#riskControl_detail").html(r.detail);
						if (r.info.length>0){
							var html = template("riskControl_list",r);
							$("#riskControl_photo").html(html);
						}
					}
				})
			},
			//投资获取账户
			getaccountInfo:function(applyId,num){
				var url = "invest/accountInfo/"+applyId+".html";
				var num = num;
			
				$.ajax({
					type:"GET",
					url:url,
					dataType:"json",
					success:function(r){
						if (num<=parseFloat(r.userBalances)&&num<=parseFloat(r.sSumAount)){
							var hei = 453 + Math.ceil(r.redPackList.length /3)*40;
							layer.open({
								title :'我要投资',//标题
								skin: 'layer-ext-myskin',//皮肤
						        type: 1,
						        area: ['490px', hei+"px"],//大小宽*高
						        shadeClose: true, //点击遮罩关闭
						        content: $('.red-packets')//内容，里边是包含内容的div的class
						    });
							var r = r;
							var encrypt = new JSEncrypt();
							encrypt.setPublicKey(publickey);
							var data = {};
							data.proId = encrypt.encrypt(applyId+"");
							data.amount =  encrypt.encrypt(num+"");
							var url = "invest/revenuePlan.html";
							var profit = NetUtil.ajax(
									url,
									data,
									function(profit){
										r.num = num;
										r.profit = profit;
										r.maxRedNum = parseFloat(r.num)*r.proportion;
										redMax = r.maxRedNum;
										
										var html = template("confirmInfo",r)
										
										$("#red-packets-top").html(html);
										
										detail.calculation();
										
										$(".input1").each(function(n){
											var n = n;
											$(this).mouseover(function(){
												if (r.redPackList[n].sEndDate == null){
													$(this).layoutClick("永久有效");
												}else{
													$(this).layoutClick("有效期至"+r.redPackList[n].sEndDate);
												}
											});
											$(this).mouseout(function(){
												$(this).parent().find(".tipClick").remove();
											});
											
											if (parseFloat($(this).text())>redMax){
												$(this).addClass("disabled");
											};
											
											if (parseFloat($(this).text())>$("#orangeNum").text()){
												$(this).addClass("disabled");
											}
										});
								
										
										$(".input1").on("click",function(e){
											var eve = e.srcElement||e.target;
											var inputVal = parseFloat($("#useVouchers").val())||0;
											if (eve.nodeName == "LABEL"){
												if ($(this).hasClass("active")){
													$(this).removeClass("active");
												}else{
													$(this).addClass("active");
												};
												detail.calculation();
												if (detail.getRedBags()>=redMax||(detail.getRedBags()+inputVal)>=$("#orangeNum").html()){		
													$(".input1").each(function(){
														if (!($(this).hasClass("active"))){
															$(this).addClass("disabled");
														};
													});
												}
											};
										});
										
										$("#useVouchers").on("keyup",function(){
											if ($(this).val()>r.sVouchers){
												layer.alert("代金券使用超出余额",function(index){
													layer.close(index);
													$("#useVouchers").val(r.sVouchers)
												})
											}
											var re = /^[0-9]*[1-9][0-9]*$/; //正整数
											var str = detail.getRedBags();
											var thisVal = $(this).val()||0;
											if (thisVal>num-str){
												layer.alert("超出本次投资总金额",function(index){
													layer.close(index);
													$("#useVouchers").val(num-str);
												});
											}
											if (re.test($(this).val())||$(this).val()==""||$(this).val()=="0"){
												detail.calculation();
											}else{
												layer.alert("请输入正整数");
											}
										});
									}
							)
						}else{
							layer.alert("余额不足或超过本次可投金额");
						}
					}
				})
			},
			//投资收益
			getInvestMoney:function(applyId,amount){
				var encrypt = new JSEncrypt();
				encrypt.setPublicKey(publickey);
				var data = {};
				data.proId = encrypt.encrypt(applyId+"");
				data.amount =  encrypt.encrypt(amount+"");
				var url = "invest/revenuePlan.html";
				NetUtil.ajax(
						url,
						data,
						function(r){
							$("#pageProfit").html(r);
						}
				)
			},
			//计算
			calculation:function(){
				$("#nowInvestNum").html($("#orangeNum").html());
				if($("#useVouchers").val()==""||$("#useVouchers").val()==undefined){
					$("#nowVoucher").html("0.00");
				}else{
					$("#nowVoucher").html(parseFloat($("#useVouchers").val()).toFixed(2));
				};
				var str = detail.getRedBags();
				if (str>=redMax){
					$("#nowBag").html(redMax);
				}else{
					$("#nowBag").html(str);
				}
				
				var useNum = parseFloat($("#nowInvestNum").html())-$("#nowVoucher").html()-$("#nowBag").html();
				if(useNum>=0){
					$("#nowAccountBalance").html(useNum.toFixed(2));
				}else{
					$("#nowAccountBalance").html("0.00");
				}
				
			},
			//已点击的红包金额
			getRedBags:function(){
				var str = 0;
				$(".input1").each(function(){
					if ($(this).hasClass("active")){
						str += parseFloat($(this).text());
					}
				});
				return str;
			}
	}
$(function(){
	var get_url = location.pathname;
	var get_index = parseFloat(get_url.lastIndexOf("/"))+1;
	var get_index1 = get_url.lastIndexOf(".");
	var applyId = get_url.substring(get_index, get_index1);
	var moneyControl;
	if (minStarts == "0" && increaseRanges == "0"){
		moneyControl = "起投金额和加价幅度无限制";
	}else if(minStarts != "0" && increaseRanges == "0"){
		moneyControl = minStarts+"元起投";
	}else if (minStarts == "0" && increaseRanges != "0"){
		moneyControl =  "起投金额无限制,加价幅度"+ increaseRanges;
	}else{
		moneyControl = minStarts+"元起投"+"加价幅度"+ increaseRanges;
	}
	$(".charge-input").val(moneyControl);
	
	$(".charge-input").bind("focus",function(){
		if ($(this).val()==moneyControl){
			$(this).val("");
			$(this).css("color","#000")
		}
	});
	$(".charge-input").bind("blur",function(){
		if ($(this).val()==""){
			$(this).val(moneyControl);
			$(this).css("color","#bfbfbf")
		}
	});
	/*标签的切换&顶部链接切换*/	
	$(".tab-head li").each(function(index){
		var liNode =$(this);
		var index = index;
		$(this).click(function(){
			$(".tab-content .c-content").removeClass("content-active");
			$(".page-link .current-page").removeClass("on");
			$(".tab-head .tab-li").removeClass("tab-ing");	
			$(".tab-content .c-content").eq(index).addClass("content-active");
			$(".page-link .current-page").eq(index).addClass("on");
			liNode.addClass("tab-ing");
			
			if (index == "1"){
				detail.riskManagement(applyId);
			}
			if (index == "2"){
				detail.repaymentPlan(applyId);
			}
			if (index == "3"){
				detail.investmentList(applyId);
			}
			if (index == "4"){
				detail.projectCourse(applyId);
			}
			if (index == "5"){
				detail.postLoanSupervision(applyId);
			}
		});
	});
	
	$("#inv-now").bind("click",function(){
		var num = $("#investMoney").val();
		if (num!= moneyControl){
			if (num >= parseFloat(minStarts) && (num-parseFloat(minStarts))%increaseRanges == 0){
				detail.getaccountInfo(applyId,num);
			}else if(num >= parseFloat(minStarts) && increaseRanges == 0){
				detail.getaccountInfo(applyId,num);
			}else if(num == parseFloat($(".inv-available span").text())&&num <= parseFloat($(".amount-available span").text())){
				detail.getaccountInfo(applyId,num);
			}else{
				layer.alert(moneyControl)
			}
		}else{
			layer.alert("请填写投资金额")
		}
	});
	
	
	
	$("#investMoney").on("keyup",function(){
		var num = $(this).val();
		if (num!= moneyControl && num >= parseFloat(minStarts) && (num-parseFloat(minStarts))%increaseRanges == 0 ){
			detail.getInvestMoney(applyId,num);
		}else if(num!= moneyControl && num >= parseFloat(minStarts) && increaseRanges == 0 ){
			detail.getInvestMoney(applyId,num);
		}
	});
	
	$("#confirmSubmit").click(function(){
		var encrypt = new JSEncrypt();
		encrypt.setPublicKey(publickey);
		var data = {};
		var sDirectPwd;
		if($("#codeContent").html()==undefined){
			
		}else{
			if ($("#directionalCode").val()){
				sDirectPwd = encrypt.encrypt($("#directionalCode").val()+"");
			}else{
				layer.alert("请填写定向标密码");
				return false;
			}
		}
		
		var slVouchers = encrypt.encrypt($("#nowVoucher").html());
		var lAmount = encrypt.encrypt($("#nowInvestNum").html());
		var arr = [];
		var arr1 = [];
		$(".input1").each(function(n){
			if ($(this).hasClass("active")){
				arr.push($(this).children().val());
				arr1.push($(this).attr("data-userNum"));
			}
		});
		var clickRed = detail.getRedBags();
		if (clickRed>redMax){
			var needNum = clickRed - redMax;
			arr1[arr.length-1] = arr1[arr.length-1] - needNum;
		}
		
		for (var i=0;i<arr.length;i++){
			arr[i] = arr[i]+","+arr1[i];
		}
		
		var redPacks = encrypt.encrypt(arr.join(";")+"");
		var projectId = encrypt.encrypt(applyId+"");
		
		$("input[name='slVouchers']").val(slVouchers);
		$("input[name='lAmount']").val(lAmount);
		$("input[name='redPacks']").val(redPacks);
		$("input[name='projectId']").val(projectId);
		
		var param = {slVouchers:slVouchers,lAmount:lAmount,redPacks:redPacks,projectId:projectId};
		
		
		if ($("input[name='sDirectPwd']").length>0){
			$("input[name='sDirectPwd']").val(sDirectPwd);
			param.sDirectPwd = sDirectPwd;
		}
		
		var obj = eval(param);
		var sign = NetUtil.createSign(obj);
		$("#sign").val(sign);
		
		$("#form1").submit();
	});
	
});

