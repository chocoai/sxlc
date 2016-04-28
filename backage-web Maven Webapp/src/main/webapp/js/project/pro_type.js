//加密设置
var encrypt = new JSEncrypt();
encrypt.setPublicKey(publicKey_common);
$(function(){
	//表格初始化
	$('#table_id').DataTable(
			{	
				ajax: {  
					"url": appPath+"/project/getProTypeData",   
					"dataSrc": "results", 
					"type": "POST",
					"data": function ( d ) {
						//加密
//						console.log($(".notspecial").val()+","+$("#statu").val());
						var projectName = encrypt.encrypt($(".notspecial").val());
						var statu = encrypt.encrypt($("#statu").val());
						d.projectName = projectName;
						d.statu = statu;
					}  
				},
				columns: [  
				          { title:"id","data":"id"},  
				          { title:"类型名称","data": "projectName"},  
				          { title:"项目借款额度范围（万元）","data": "singleMin", 
				        	  "mRender": function (data, type, full) {
				        		  return full.minAmount+"~"+full.maxAmount;
				        	  }
				          },  
				          { title:"最小投资金额（万元）","data": "singleMin"},  
				          { title:"年化利率范围（%）","data": "singleMin", 
				        	  "mRender": function (data, type, full) {
				        		  return full.minRate+"~"+full.maxRate;
				        	  }
				          },  
				          { title:"项目期限范围（天）","data": "singleMin"},  
				          { title:"状态","data": "statu", 
				        	  "mRender": function (data, type, full) {
				        		  if(data==0){
				        			  return "<font color='red'>已禁用</font>";
				        		  }else if(data==1){
				        			  return "已启用";
				        		  }
				        	  }
				          },  
				          { title:"项目类型简介","data": "briefIntroduction", 
				        	  "mRender": function (data, type, full) {
				        			  return ' <a href="javascript:;" class="introduce" title="项目详情">简介：信用贷sdf sdf sdf sdf sdf </a>';
				        	  }
				          },  
				          { title:"产品展示小图标","data": "picIcon"},  
				          { title:"操作","data": "", 
				        	  "mRender": function (data, type, full) {
				        		  if(full.statu==0){
				        			  return "<a onclick=\"enableOrDisable(1,'"+full.id+"');\" href=\"javascript:void(0);\">启用</a>" ;
				        		  }else if(full.statu==1){
				        			  return "<a onclick=\"enableOrDisable(0,'"+full.id+"');\" href=\"javascript:void(0);\">停用</a>";
				        		  }
				        	  }
				          }
				          ],
	          aoColumnDefs : [
	                          {"bVisible": false, "aTargets": [0]}, //控制列的隐藏显示
	                          {
	                        	  "orderable" : false,
	                        	  "aTargets" : [ 0, 1, 2, 3, 5, 6, 7, 8, 9 ]
	                          } // 制定列不参与排序
	                          ],
	          pagingType: "simple_numbers",//设置分页控件的模式  
	          processing: true, //打开数据加载时的等待效果  
	          serverSide: true,//打开后台分页  
	//          info:false,
	          rowCallback:function(row,data){//添加单击事件，改变行的样式      
	          }
	 
	});//表格初始化完毕
	 
	//表格单选效果
	 $('#table_id tbody').on( 'click', 'tr', function () {
		    var $this = $(this);
	        if ( $this.hasClass('selected') ) {
	        	$this.removeClass('selected');
	        }
	        else {
	        	$('#table_id tr.selected').removeClass('selected');
	        	$this.addClass('selected');
	        }
	  });
	
	 /**
	  * 查询按钮
	  */
	 $(".glyphicon-search").on("click",function(){
		$('#table_id').DataTable().ajax.reload();
	 });
	 
	
	//启用停用
	$(".btn-enable").on("click touchstart",function(){
		//获取选取对象
		
		layer.confirm('确定启用？', {
			btn: ['确定', '取消']
		}, function(index, layero){
			//按钮【按钮一】的回调
			
			//执行完关闭
			layer.close(index);
		}, function(index){
			//按钮【按钮二】的回调
		});
	});

	$(".btn-disable").on("click touchstart",function(){
		//获取选取对象
		
		layer.confirm('确定停用？', {
			btn: ['确定', '取消']
		}, function(index, layero){
			//按钮【按钮一】的回调
			
			//执行完关闭
			layer.close(index);
		}, function(index){
			//按钮【按钮二】的回调
		});
	});
});	
	



    /***********简介的显示和隐藏*************/
$(function(){    
    $(".introduce").each(function(index){
    	var intro=$(this).text();    //回去项目类型简介描述内容
    	if(intro.length>8){        //当内容长度大于8时隐藏详细信息，其中参数可以修改
    		$(this).text(intro.substring(0,2));
    		$(this).hover(function(e){
    			$(".all").show().html(intro);   //将类型简介赋值到隐藏div
    			var y = e.clientY-20;
    			var x = e.clientX -212;
    			$(".all").css({position:'absolute',top:y+"px",left:x+"px"});
    		},function(){
    			$(".all").hide();
    		});
    	}
    	else{
    		$(this).text(intro);
    	}
    });
});



/********项目类型管理2016-4-25伍成然*********/
function addProType(){
	$(".right_col").load("web/project/pro-add/add_type.jsp");
}
function modProType(){
	$(".right_col").load("web/project/pro-add/modify_type.jsp");
}
function loanProExam(){
	$(".right_col").load("web/project/pro-add/loan_pro_exam.jsp");
}