<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script src="plugs/dist/echarts.js"></script>
<script type="text/javascript">
		/* var shuju = 200; */
    	// 路径配置
        require.config({
            paths: {
                echarts: '<%=basePath%>/plugs/dist'
            }
        });
        
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
                var myChart1 = ec.init(document.getElementById('chartBox1'),theme);
                 var myChart4 = ec.init(document.getElementById('chartBox4'),theme);
                 var myChart2 = ec.init(document.getElementById('chartBox2'),theme);

                var option1 = {
					    
					    series: [
					        {
					            name:'访问来源',
					            type:'pie',
					            radius: ['90%', '100%'],
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
					            data:[
					                {value:20,itemStyle:{normal:{color:'#60b0ef'}}},
					                {value:20,itemStyle:{normal:{color:'#f4653b'}}},
					                {value:20,itemStyle:{normal:{color:'#8ac55b'}}},
					                {value:20,itemStyle:{normal:{color:'#c8c8c8'}}},
					                {value:20,itemStyle:{normal:{color:'#ffb43f'}}}
					            ]
					         }
					     ],
					    media: [ // 这里定义了 media query 的逐条规则。
					        {
					            query: {
					            	minWidth: 500,
								    maxHeight: 200,
								    minAspectRatio: 1
								},   // 这里写规则。
					            option: {       // 这里写此规则满足下的option。	
						            series: [                   // 两个饼图左右布局。
						                {
						                    radius: [20, '100%'],
						                    center: ['100%', '60%']
						                }
						            ]
					            }
					        }
					    ]
					
                };

   
                 var option4 = {
 					    tooltip: {
 					        trigger: 'axis'
 					    },
 					    grid:{
 					    	x:50,
 					    	y:20,
 					    	x2:20,
 					    	y2:40,
 					    },
 					    toolbox: {
					        show: true,
 					        feature: {
 					            dataZoom: {},
 					            dataView: {readOnly: false},
 					            magicType: {type: ['line', 'bar']},
					            restore: {},
					            saveAsImage: {}
					        }
					    },
					    xAxis:  {
 					        type: 'category',
 					        axisLine:{lineStyle:{
 					            			color:'#dedede',
					            			width:1,
 					            		}},
 					        axisLabel:{
 					        	textStyle:{color:'#787878'},
 					        },
					        boundaryGap: false,
					        data: ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月']
					    },
					    yAxis: {
					        type: 'value',
					        axisLine:{lineStyle:{
 					            			color:'#dedede',
					            			width:1,
 					            		}},
 					        axisLabel: {
 					            formatter: '{value}元',
 					        	textStyle:{color:'#787878'},
 					        },
				  		},
 					    series: [   
 					        {
					          	name:'投资UV',
				            	type:'line',
					            data:[5, 8, 7, 16, 55],
 					            itemStyle:{
					            	normal:{
 					            		lineStyle:{
 					            			color:'#30adff',
					            			width:1,
 					            		}
 					            	},
					            },
					        },					        					        
					    ]
					}; 
                    var option2 = {
 					    tooltip: {
 					        trigger: 'axis'
 					    },
 					    grid:{
 					    	x:50,
 					    	y:20,
 					    	x2:20,
 					    	y2:40,
 					    },
 					    toolbox: {
					        show: true,
 					        feature: {
 					            dataZoom: {},
 					            dataView: {readOnly: false},
 					            magicType: {type: ['line', 'bar']},
					            restore: {},
					            saveAsImage: {}
					        }
					    },
					    xAxis:  {
 					        type: 'category',
 					        axisLine:{lineStyle:{
 					            			color:'#dedede',
					            			width:1,
 					            		}},
 					        axisLabel:{
 					        	textStyle:{color:'#787878'},
 					        },
					        boundaryGap: false,
					        data: ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月']
					    },
					    yAxis: {
					        type: 'value',
					        axisLine:{lineStyle:{
 					            			color:'#dedede',
					            			width:1,
 					            		}},
 					        axisLabel: {
 					            formatter: '{value}元',
 					        	textStyle:{color:'#787878'},
 					        },
				  		},
 					    series: [   
 					        {
					          	name:'投资UV',
				            	type:'line',
					            data:[5, 8, 7, 16, 55],
 					            itemStyle:{
					            	normal:{
 					            		lineStyle:{
 					            			color:'#30adff',
					            			width:1,
 					            		}
 					            	},
					            },
					        },					        					        
					    ]
					};                                        
             //   为echarts对象加载数据 
  				myChart1.setOption(option1);
              	myChart4.setOption(option4);
              	myChart2.setOption(option2);
                
            }
        );
</script>