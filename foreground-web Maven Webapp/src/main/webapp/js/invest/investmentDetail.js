/*伍成然2016-3-24*/
$(function(){
	/*标签的切换&顶部链接切换*/	
	$(".tab-head li").each(function(index){
		var liNode =$(this);
		$(this).click(function(){
			$(".tab-content .c-content").removeClass("content-active");
			$(".page-link .current-page").removeClass("on");
			$(".tab-head .tab-li").removeClass("tab-ing");	
			$(".tab-content .c-content").eq(index).addClass("content-active");
			$(".page-link .current-page").eq(index).addClass("on");
			liNode.addClass("tab-ing");
		});
	});
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
	
//	/*****登录状态到未登录状态*******/	
//	/******加入到ajax中*******/	
//	$(".login-now").click(function(){
//		$(".not-logined").css("display","none");
//		$(".logined").css("display","block");
//		$(".after-inv-li").css("display","none");
//	});
//	/*******未登录到还款中状态*********/
//	/****** 加入到ajax中 *******/	
//	$(".inv-now").click(function(){
//		$(".logined").css("display","none");
//		$(".repaying").css("display","block");
//		$(".after-inv-li").css("display","block");
//	});
	
    /*债后监管展开*/
//	$(".info-bottom-content").click(function(){
//		$(".info-top").hide();
//		$(".info-bottom").show();
//		$(this).parent().parent().hide();
//		$(this).parent().parent().parent().children(".info-top").show();
//	});
	/*进度条*/
	$(".progress").each(function(){
		$(this).find(".barline").css("width",$(this).find(".progress_totle").html());
	});
	/*弹出层*/
	$('.inv-now').on('click', function(){
		layer.open({
			title :'我要投资',//标题
			skin: 'layer-ext-myskin',//皮肤
	        type: 1,
	        area: ['486px', '440px'],//大小宽*高
	        shadeClose: true, //点击遮罩关闭
	        content: $('.red-packets')//内容，里边是包含内容的div的class
	    });
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
	this.parent().find(".tipClick").css("left",this.offset().left - this.parent().offset().left - this.innerWidth());
	this.parent().find(".tipClick").css("top",this.offset().top - this.parent().offset().top + this.innerHeight() + 15 );
};

/*  胥福星    2016-04-07  弹出提示层   */
$(function(){
	$(".input1").each(function(){
		$(this).mouseover(function(){
			$(this).layoutClick("有效期至：2015-06-10");
		});
		$(this).mouseout(function(){
			$(this).parent().find(".tipClick").remove();
		});
	});
});

//2016-5-3 付晨早
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
		return content.substring(0,index)
	})

	
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
							total = total + parseInt(data.json[i].sdPrincipalInterests)
						}
						$(".moneyFormat1").html(total);
						var html = template("repay_Plan",data);
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
						$("#moneyFormat2").html(parseInt(r.availableAmount).toFixed(2));
						$("#moneyFormat3").html(parseInt(r.investTotals).toFixed(2));
						$("#moneyFormat4").html(parseInt(r.shenYuKeTou).toFixed(2));
						var data = r
						if (r.info.length>0){
							var html = template("invest_List",r);
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
								url:"invest/repaymentPlan/"+applyId+".html",
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
//											console.log(r);
											if (r!=null){
												var html = "";
												for (var i=0;i<r.length;i++){
													html = "<img  class='text-img' src='"+r[i].attachUrl+ "'>";
												}
												html += "<h2>"+r[0].attachTitle+"</h2><p>"+r[0].projectAfterLoanInfoEntity.detail+"</p>";
//												$that.parent().hide();
//												console.log($that.parent(".info-bottom").prev());
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
						console.log(r);
						$("#riskControl_detail").html(r.detail);
						if (r.info.length>0){
							var html = template("riskControl_list",r);
							$("#riskControl_photo").html(html);
						}
					}
				})
			}
	}
$(function(){
	var get_url = location.pathname;
	var get_index = parseInt(get_url.lastIndexOf("/"))+1;
	var get_index1 = get_url.lastIndexOf(".");
	var applyId = get_url.substring(get_index, get_index1);
	detail.repaymentPlan(applyId);
	detail.investmentList(applyId);
	detail.projectCourse(applyId);
	detail.postLoanSupervision(applyId);
	detail.riskManagement(applyId);
});



/* 验证     */
$(function(){
	$("#notLoginBox").Validform({
		tiptype:3,//提示信息类型
		btnSubmit:".login-now", //#btn_sub是该表单下要绑定点击提交表单事件的按钮;如果form内含有submit按钮该参数可省略;
		//btnReset:"#btnreset1",
		datatype: extdatatype,//扩展验证类型
		//showAllError:true,//提交前验证显示所有错误
		ajaxPost:{//使用ajax提交时
			url:"http://182.150.178.88:8031/GEB_P2P_Foreqround/selectmemberProvince.action",
			datatype:"jsonp",
			success:function(data,obj){
	            //data是返回的json数据;
	            //obj是当前表单的jquery对象;
	        },
	        error:function(data,obj){
	            //data是{ status:**, statusText:**, readyState:**, responseText:** };
	            //obj是当前表单的jquery对象;
//	            console.log(data.status);
	        }
		}
	});
	$("#loginedBox").Validform({
		tiptype:3,//提示信息类型
		btnSubmit:".inv-now", //#btn_sub是该表单下要绑定点击提交表单事件的按钮;如果form内含有submit按钮该参数可省略;
		//btnReset:"#btnreset1",
		datatype: extdatatype,//扩展验证类型
		//showAllError:true,//提交前验证显示所有错误
		ajaxPost:{//使用ajax提交时
			url:"http://182.150.178.88:8031/GEB_P2P_Foreqround/selectmemberProvince.action",
			datatype:"jsonp",
			success:function(data,obj){
	            //data是返回的json数据;
	            //obj是当前表单的jquery对象;
	        },
	        error:function(data,obj){
	            //data是{ status:**, statusText:**, readyState:**, responseText:** };
	            //obj是当前表单的jquery对象;
//	            console.log(data.status);
	        }
		}
	});
	
	
	
});

