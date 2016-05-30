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
						var projectName = encrypt.encrypt($(".notspecial").val());
						var statu = encrypt.encrypt($("#statu").val());
						d.projectName = projectName;
						d.statu = statu;
					}  
				},
				columns: [  
				          {title:'',sWidth:"3%", 
				        	  "mRender": function (data, type, full) {
				        		  sReturn = '<input type="checkbox" class="tr-checkbox" value="1" />';
				        		  return sReturn;
				        	  }
				          },
				          { title:"id","data":"id"},  
				          { title:"类型名称","data": "projectName"},  
				          { title:"项目借款额度范围（元）","data": "singleMin", 
				        	  "mRender": function (data, type, full) {
				        		  return full.minAmounts+"~"+full.maxAmounts;
				        	  }
				          },  
				          { title:"最小投资金额（元）","data": "singleMin"},  
				          { title:"年化利率范围（%）","data": "singleMin", 
				        	  "mRender": function (data, type, full) {
				        		  return full.minRates+"~"+full.maxRates;
				        	  }
				          },  
				          { title:"项目期限范围（天）","data": "singleMin"},  
				          { title:"项目类型简介","data": "briefIntroduction", 
				        	  "mRender": function (data, type, full) {
				        		  	if(data==null){
				        		  		return "";
				        	  		}else if(data.length>8){//当内容长度大于8时隐藏详细信息
				        	    		return ' <a href="javascript:;" onclick="showText(this)" title="项目详情">'+data.substring(0,7)+'...</a>';
				        	    	}else {
				        	    		return data;
				        	    	} 
				        	  }
				          },  
				          { title:"展示图片","data": "picUrl", 
				        	  "mRender": function (data, type, full) {
				        		  return '<a href="javascript:void(0);" class="btn-det" onclick="viewPic(this,1)">查看</a>';
				        	  }
				          },  
				          { title:"产品展示小图标","data": "picIcon", 
				        	  "mRender": function (data, type, full) {
				        		  return '<a href="javascript:void(0);" class="btn-det" onclick="viewPic(this,2)">查看</a>';
				        	  }
				          },  
				          { title:"状态","data": "statu", 
				        	  "mRender": function (data, type, full) {
				        		  if(data==0){
				        			  return "<font color='red'>已禁用</font>";
				        		  }else if(data==1){
				        			  return "已启用";
				        		  }else{
				        			  return data;
				        		  }
				        	  }
				          }, 
				          { title:"操作","data": "statu", 
				        	  "mRender": function (data, type, full) {
				        		  if(data==0){
				        			  return "<a onclick=\"enableOrDisable(1,'"+full.id+"');\" href=\"javascript:void(0);\">启用</a>" ;
				        		  }else if(data==1){
				        			  return "<a onclick=\"enableOrDisable(0,'"+full.id+"');\" href=\"javascript:void(0);\">停用</a>";
				        		  }else{
				        			  return "";
				        		  }
				        	  }
				          }
				          ],
	          aoColumnDefs : [
	                          {"bVisible": false, "aTargets": [1]}, //控制列的隐藏显示
	                          {
	                        	  "orderable" : false,
	                        	  "aTargets" : [ 0, 1, 2, 3,4, 6, 7, 8, 9,10 ]
	                          } // 制定列不参与排序
	                          ],
	          pagingType: "simple_numbers",//设置分页控件的模式  
	          processing: true, //打开数据加载时的等待效果  
	          serverSide: true,//打开后台分页 
	          searching: false,
	          scrollCollapse: true,
	          scrollX : "100%",
	          scrollXInner : "100%",scrollY:500,
	          rowCallback:function(row,data){//添加单击事件，改变行的样式      
	          }
	
	});//表格初始化完毕
	 
	//表格单选效果(有复选框)
	 $('#table_id tbody').on( 'click', 'tr', function () {
		    var $this = $(this);
		    var $checkBox = $this.find("input:checkbox");
	        if ( $this.hasClass('selected') ) {
	        	 $checkBox.prop("checked",false);
	        	$this.removeClass('selected');
	        } else {
	        	$(".tr-checkbox").prop("checked",false);
	        	$checkBox.prop("checked",true);
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
	
});	


/**
 * 启用/停用功能
 * @param type 1：启用 0：停用
 * @param id 项目类型id
 * @returns
 */
function enableOrDisable(type,id){
	var title="";
	if(type==1){
		title ='确定启用？';
	}else if(type==0){
		title ='确定停用？';
	}
	layer.confirm(title, {
		btn: ['确定', '取消']
	}, function(index, layero){
	
	$.ajax( {  
		url:appPath+"/project/enableProType.do",
		data:{"statu":encrypt.encrypt(""+type),"id":encrypt.encrypt(id+"")},
		type:'post',  
		cache:false,  
		dataType:'json',  
		success:function(data) { 
			if(data==1){
				layer.alert("操作成功",{icon:1});
				var table = $('#table_id').DataTable();
				table.ajax.reload();
			}else if(data==0){
				layer.alert("操作失败",{icon:2});  
			}
		},  
		error : function() {  
			layer.alert("服务器异常",{icon:2});  
		}  
	});
	
	}, function(index){
  }); 
}




/**
 * 简介弹出框显示
 */
function showText(btn){
	var data = $('#table_id').DataTable().row($(btn).parents('tr')).data();
	layer.open({
	    type: 1,
	    area: ['400px', '300px'], //高宽
	    title: "简介",
	    content: data.briefIntroduction,//DOM或内容
	    btn:['关闭']
		  ,cancel: function(index){
		  	//取消的回调
		  }
	});
};

/**
 * 查看图片
 * @returns
 */
function viewPic(btn,type){
    var data = $('#table_id').DataTable().row($(btn).parents('tr')).data();
    var title = "";
    if(type==1){//展示图片
        	$("#picView").attr("src",$("#hostPath").val()+data.picUrl);
        	title="展示图片";
    }else if(type==2){//展示小图标
        	$("#picView").attr("src",$("#hostPath").val()+data.picIcon);
        	title="产品展示小图标";
    }
	layer.open({
	    type: 1,
	    area: ['400px', '300px'], //高宽
	    title: title,
//	    maxmin: true,
	    content: $(".pic-view"),//DOM或内容
	    btn:['关闭']
		  ,cancel: function(index){
		  	//取消的回调
		  }
	});

}

/**
 * 添加或修改按钮
 * @param type 操作类型：1 添加  2：修改
 */
function showDetail(type){
	if(type==1){
//		$(".right_col").load("project/toProTypeDetail");
		window.location.href=appPath+"/project/toProTypeDetail";
	}else if(type==2){
		var data = $('#table_id').DataTable().rows('.selected').data();
		if(data.length<1){
			layer.alert("请选择要修改的数据！",{icon:0});
			return;
		}
		var id = data[0].id;
//		$(".right_col").load("project/toProTypeDetail",{"id": encrypt.encrypt(id+"")});
		window.location.href=appPath+"/project/toProTypeDetail?content="+id;
	}
}

/********项目类型管理2016-4-25伍成然*********/
function loanProExam(){
	$(".right_col").load("web/project/pro-add/loan_pro_exam.jsp");
}