$(function(){
	$(".TA").addClass("down");
	/*账户总资产部分开始*/
	/*label背景切换部分开始*/
	$(".accountOverviewM label").mouseover(function(){
		$(this).removeClass("tipOrigin").addClass("tipChange");
	});
	$(".accountOverviewM label").mouseout(function(){
		$(this).addClass("tipOrigin").removeClass("tipChange");
	});
	/*label背景切换部分结束*/
	$(".planMSecond").hide();
	$(".planHCont>div").each(function(i){
		$(this).click(function(){
			$(this).addClass("active").siblings("div").removeClass("active");
			$(".planM").eq(i).show().siblings(".planM").hide();
			if($(this).is(".payment")){
				getInvestIncome(2016);
			}else if($(this).is(".repayment")){
				getLoanRepay(2016);
			}
		});
		$(".more").click(function(){
			if($(".payment").hasClass("active")){
				window.location = "myInvestment.html";
			}else if($(".repayment").hasClass("active")){
				window.location = "repayPlan.html";
			}
		});
	});
	/*账户总资产部分结束*/
	/* 资金动态开始  */
	var count = 0;
	$(".capitalDynamicsM li").each(function(){
		$(this).find(".DynamicsMLBottom").css("height",$(this).find(".capitalDynamicsMR").height()+40);
		$(this).find(".triangleTip").addClass((count % 2 == 0 )?"triangleHyacinth":"triangleBlue");
		count++;
	});
	/* 资金动态结束  */
	selectMyAccountHome();
	getInvestIncome(2016);
	getRepayRecord(2016);
});
function selectMyAccountHome(){
	$.ajax({
		url:"accountOverview/selectMyAccountHome.html",
		type:"get",
		dataType:"json",
		success:function(message){
			if(message.code==200){
				data = message.data;
				$(".totalAmount").html(data.totalAmount);
				$(".totalRecharge span").html(data.chargemoney);
				$(".totalWithdrawals span").html(data.withdrawalMoney);
				
				$(".userBalances").html(data.userBalances);
				$(".frozen").html(data.frozen);
				$(".willRecPrincipal").html(data.willRecPrincipal);
				$(".willRecInterest").html(data.willRecInterest);
				$(".repayAmount").html(data.repayAmount);
				//加载饼状图
				if(data.totalAmount==0){
					loadMyaccount(1, 1, 1, 1, 1);
				}else{
					loadMyaccount(data.userBalances,data.frozen,data.willRecPrincipal,data.willRecInterest,data.repayAmount);
				}
				$(".giftUserBalances").html(data.giftUserBalances);
				$(".giftAmount").html(data.giftAmount);
				$(".integralResidue").html(data.integralResidue+"<a class=\"integralResidue_a \" href=\"integralMall/mallIndex.html\">兑换</a>");
				$(".friends").html(data.friends);
				
				$(".investAmountValid").html(data.investAmountValid);
				$(".realAmount").html(data.realAmount);
				$(".backAmount").html(data.backAmount);
				$(".investVouchersAmount").html(data.investVouchersAmount);
				$(".investGiftAmount").html(data.investGiftAmount);
				$(".amount").html(data.amount);
				$(".willRepayPrincipal").html(data.willRepayPrincipal);
				$(".willRepayInterest").html(data.willRepayInterest);
				$(".overdue").html(data.overdue);
				$(".lastDate").html(data.lastDate);
			}else{
				layer.alert(message.message);
			}
			$(".moneyFormat").each(function(){
				var s = $(this).text();
				var str = parseFloat(s);
				var n = $(this).format(str);
				$(this).text(n);
			});
		},
		error:function(){
			layer.alert("网络错误，无法获取数据");
		}
	})
}
function loadMyaccount(d1,d2,d3,d4,d5){
	// 使用
	require([ 'echarts', 'echarts/theme/roma', 'echarts/chart/pie', // 使用柱状图就加载bar模块，按需加载
	'echarts/chart/line' ], function(ec, theme) {
		// 基于准备好的dom，初始化echarts图表
		//环形
		var myChart1 = ec.init(document.getElementById('chartBox1'), theme);
		var option1 = {
			series : [ {
				name : '访问来源',
				type : 'pie',
				radius : [ '90%', '100%' ],
				itemStyle : {
					normal : {
						label : {
							show : false
						},
						labelLine : {
							show : false
						}
					},
					emphasis : {
						label : {
							show : true,
							position : 'center',
							textStyle : {
								fontSize : '30',
								fontWeight : 'bold'
							}
						}
					}
				},
				data : [ {
					value : d1,
					itemStyle : {
						normal : {
							color : '#60b0ef'
						}
					}
				}, {
					value : d2,
					itemStyle : {
						normal : {
							color : '#f4653b'
						}
					}
				}, {
					value : d3,
					itemStyle : {
						normal : {
							color : '#8ac55b'
						}
					}
				}, {
					value :d4,
					itemStyle : {
						normal : {
							color : '#c8c8c8'
						}
					}
				}, {
					value : d5,
					itemStyle : {
						normal : {
							color : '#ffb43f'
						}
					}
				} ]
			} ],
			media : [ // 这里定义了 media query 的逐条规则。
			{
				query : {
					minWidth : 500,
					maxHeight : 200,
					minAspectRatio : 1
				}, // 这里写规则。
				option : { // 这里写此规则满足下的option。	
					series : [ // 两个饼图左右布局。
					{
						radius : [ 20, '100%' ],
						center : [ '100%', '60%' ]
					} ]
				}
			} ]
		};
		//   为echarts对象加载数据 
		myChart1.setOption(option1);
	});
}

/**
*查询回款计划，并生成图表
*/
function getInvestIncome(year){
	var encrypt = new JSEncrypt();
	encrypt.setPublicKey(publickey);
	year=encrypt.encrypt(year+"");
	$.ajax({
		url:"accountOverview/getInvestIncome.html",
		type:"get",
		data:{"year":year},
		dataType:"json",
		success:function(message){
			if(message.code==200){
				list=message.data;
				loadInvertIncomeList(list);
			}else{
				layer.alert(message.message);
			}
		},
		error:function(){
			layer.alert("网络错误，无法获取数据");
		}
	});
}
function loadInvertIncomeList(list){
	var data = new Array();;
	for(var i=0;i<list.length;i++){
		data[i]=list[i].sdRecvAmounts;
		//去除多余的小数
		if(data[i].split(".")[1].length>3){
			data[i] = data[i].split(".")[0]+"."+data[i].split(".")[1].substring(0,2);
		}
	}
	// 使用
    require(
        [
            'echarts',
            'echarts/theme/roma',
            'echarts/chart/pie', // 使用柱状图就加载bar模块，按需加载
            'echarts/chart/line'
        ],
	 function (ec,theme) {
    // 基于准备好的dom，初始化echarts图表
    //环形
     var myChart4 = ec.init(document.getElementById('chartBox4'),theme);
     var option4 = {
		    tooltip : {
		        trigger: 'axis'
		    },
		    grid:{
			    	x:50,
			    	y:20,
			    	x2:20,
			    	y2:40
			    },
		    toolbox: {
		        show : true,
		        feature : {
		             dataZoom: {},
			            dataView: {readOnly: false},
			            magicType: {type: ['line', 'bar']},
		            restore: {},
		            saveAsImage: {}
		        }
		    },
		    calculable : true,
		    xAxis:  {
			        type: 'category',
			        axisLine:{lineStyle:{
			            			color:'#dedede',
		            			width:1
			            		}},
			        axisLabel:{
			        	textStyle:{color:'#787878'}
			        },
		        boundaryGap: false,
		        data: ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月']
		    },
		    yAxis: {
		        type: 'value',
		        axisLine:{lineStyle:{
			            			color:'#dedede',
		            			width:1
			            		}},
			        axisLabel: {
			            formatter: '{value}元',
			        	textStyle:{color:'#787878'}
			        }
	  		},
		    series : [
		        {
		            name:'回款',
		            type:'line',
		            symbol:'emptyCircle',
		            itemStyle: {
		                normal: {
		                    lineStyle: {            // 系列级个性化折线样式，横向渐变描边
		                        width: 1,
		                        color:'#30adff',
		                        shadowColor : 'rgba(0,0,0,0.5)',
		                        shadowBlur: 10,
		                        shadowOffsetX: 8,
		                        shadowOffsetY: 8
		                    }
		                },
		                emphasis : {
		                    label : {show: true}
		                }
		            },
		            data:data
		        }
		    ]
		};
  //   为echarts对象加载数据 
		myChart4.setOption(option4);
     });
}
/**
*查询还款计划，并生成图表
*/
function getLoanRepay(year){
	var encrypt = new JSEncrypt();
	encrypt.setPublicKey(publickey);
	year=encrypt.encrypt(year+"");
	$.ajax({
		url:"accountOverview/getLoanRepay.html",
		type:"get",
		data:{"year":year},
		dataType:"json",
		success:function(message){
			if(message.code==200){
				list=message.data;
				loadLoanRepayList(list);
			}else{
				layer.alert(message.message);
			}
			
		},
		error:function(){
			layer.alert("网络错误，无法获取数据");
		}
	});
}

function loadLoanRepayList(list){
	var data = new Array();;
	for(var i=0;i<list.length;i++){
		data[i]=list[i].sdRecvAmounts;
		//去除多余的小数
		if(data[i].split(".")[1].length>3){
			data[i] = data[i].split(".")[0]+"."+data[i].split(".")[1].substring(0,2);
		}
	}
	// 使用
    require(
        [
            'echarts',
            'echarts/theme/roma',
            'echarts/chart/pie', // 使用柱状图就加载bar模块，按需加载
            'echarts/chart/line'
        ],
	 function (ec,theme) {
    // 基于准备好的dom，初始化echarts图表
    //环形
     var myChart2 = ec.init(document.getElementById('chartBox2'),theme);
     var option2 = {
		    tooltip : {
		        trigger: 'axis'
		    },
		    grid:{
			    	x:50,
			    	y:20,
			    	x2:20,
			    	y2:40
			    },
		    toolbox: {
		        show : true,
		        feature : {
		             dataZoom: {},
			            dataView: {readOnly: false},
			            magicType: {type: ['line', 'bar']},
		            restore: {},
		            saveAsImage: {}
		        }
		    },
		    calculable : true,
		    xAxis:  {
			        type: 'category',
			        axisLine:{lineStyle:{
			            			color:'#dedede',
		            			width:1
			            		}},
			        axisLabel:{
			        	textStyle:{color:'#787878'}
			        },
		        boundaryGap: false,
		        data: ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月']
		    },
		    yAxis: {
		        type: 'value',
		        axisLine:{lineStyle:{
			            			color:'#dedede',
		            			width:1
			            		}},
			        axisLabel: {
			            formatter: '{value}元',
			        	textStyle:{color:'#787878'}
			        }
	  		},
		    series : [
		        {
		            name:'还款',
		            type:'line',
		            symbol:'emptyCircle',
		            itemStyle: {
		                normal: {
		                    lineStyle: {            // 系列级个性化折线样式，横向渐变描边
		                        width: 1,
		                        color:'#30adff',
		                        shadowColor : 'rgba(0,0,0,0.5)',
		                        shadowBlur: 10,
		                        shadowOffsetX: 8,
		                        shadowOffsetY: 8
		                    }
		                },
		                emphasis : {
		                    label : {show: true}
		                }
		            },
		            data:data
		        }
		    ]
		};
  //   为echarts对象加载数据 
		myChart2.setOption(option2);
     });
}

function getRepayRecord(){
	$.ajax({
		url:"accountOverview/getRepayRecord.html",
		type:"get",
		dataType:"json",
		success:function(message){
			if(message.code==200){
				list=message.data;
				loadRepayRecordList(list);
			}else{
				layer.alert(message.message);
			}
			
		},
		error:function(){
			layer.alert("网络错误，无法获取数据");
		}
	});
}

function loadRepayRecordList(list){
	var data;
	var s="";
	$(".repayRecordList").remove();
	if(list.length==0){
		s="<li class='clearfix repayRecordList'>暂无数据</li>";
		$(".footli").before(s);
		$(".footli").remove();
		return;
	}
	for(var i=0;i<list.length;i++){
		data=list[i];
		if(data.abstracts==undefined){
			data.abstracts="";
		}
		s=s+"<li class='clearfix repayRecordList'>"
				+"<div class='capitalDynamicsML'>"
					+"<div class='DynamicsMLTop'>"+data.month+"<label class='circle grey'></label></div>"
					+"<div class='DynamicsMLBottom'>"+data.day+"</div>"
				+"</div>"
				+"<div class='capitalDynamicsMR'>"
					+"<label class='triangleTip'></label>"
					+"<div>"+data.abstracts+"</div>"
				+"</div>"
			+"</li>";
	}
	$(".footli").before(s);
}