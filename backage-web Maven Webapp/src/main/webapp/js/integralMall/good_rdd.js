
	function GetQueryString(name)
		{
		     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
		     var r = window.location.search.substr(1).match(reg);
		     if(r!=null)return  unescape(r[2]); return null;
		}
	
$(function(){
	var goodId = GetQueryString("id");
	
	$('#table_id').DataTable(
			{
				autoWidth : false,
				scrollY : 500,
				pagingType: "simple_numbers",//设置分页控件的模式  
				lengthMenu:[[10,25,50,-1],[10,25,50,"全部"]],
				colReorder : false,
				scrollX : true,
				sScrollX : "100%",
				sScrollXInner : "100%",
				bScrollCollapse : true,  
				processing: true, //打开数据加载时的等待效果  
		        serverSide: true,//打开后台分页
		        ajax: {  
		            "url": "commodityManager/showPutK.do",   
		            "dataSrc": "results",
		            "type":"POST",
		            "data": function ( d ) {  
		                var good = goodId;
		                d.goodId = encrypt.encrypt(good+"");
		                
		            } 
		        },
		        columns: [  
		                  {title:'商品编号',data:"commodityID"},
		                  { title:"操作时间","data": "operationTime" },
		                  { title:"入库/出库","data": "operationDirection",
		                	  "mRender": function (data, type, full) {
				        		  if(data=="1"){
				        			  return "入库";
				        		  }else if(data=="-1"){
				        			  return "出库";
				        		  }
				        	  }
		                  },  
		                  { title:"入库/出库数量","data": "quantitys" },  
		                  { title:"操作管理员名称","data": "adminName",},  
		                  { title:"记录库存量","data": "totalQuantity"}
		        ],
		        aoColumnDefs : [
		        				{
		        					sDefaultContent: '',
		        					orderable : false,
		        					aTargets: [ 0,2,3,4,5 ]
		        				},
		        				{  
		                            "aTargets":[],  
		                            "visible":false  
		                        }
		        	],
			});
	
})