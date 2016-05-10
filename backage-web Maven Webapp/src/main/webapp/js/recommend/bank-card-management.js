/*  银行卡管理部分      */
/**
 * 添加动态
 */
var encrypt = new JSEncrypt();
encrypt.setPublicKey(publicKey_common);
function bankManagementAdd(title,page,type){
	//参数判断，自己写全
	//console.log(title+","+page+","+type);
	if(title == "" || page == "" || type == "" ){
		console.log("参数异常,请检查参数");
		return;
	}
	layer.open({
	    type: 2,
	    area: ['500px', '380px'], //高宽
	    title: title,
	    maxmin: true,
	    content: page,//DOM或内容
//	    btn:['确定', '取消']
//		  ,yes: function(index, layero){ //或者使用btn1
//		    //确定的回调
//		  	//判断执行不同方法
//		  	
//		  },cancel: function(index){//或者使用btn2（concel）
//		  	//取消的回调
//		  }
	});
	
	
}


function bankManagementMod(title,page,type,id){
	//参数判断，自己写全
	//console.log(title+","+page+","+type);
	if(title == "" || page == "" || type == "" || id == "" ){
		console.log("参数异常,请检查参数");
		return;
	}
	/*var rowdata = $('#table_id').DataTable().rows('.selected').data();
	var bankCardId = encrypt.encrypt((rowdata[0].bankCardId + ""));*/
		layer.open({
		    type: 1,
		    area: ['500px', '380px'], //高宽
		    title: "修改银行卡",
		    maxmin: true,
		    content: $(".pic-mod"),//DOM或内容
		   /* btn:['确定', '取消']
			  ,yes: function(index, layero){ //或者使用btn1
			    //确定的回调
			  	//判断执行不同方法
			  	
			  },cancel: function(index){//或者使用btn2（concel）
			  	//取消的回调
			  }*/
		});
	
	
}

/**
 * 删除银行卡
 */
$(function () {
	//删除部门
	$(".obtn-dept-del").on("click touchstart",function(){
		//获得选取的对象
		var rowdata = $('#table_id').DataTable().rows('.selected').data();
		var bankCardId = encrypt.encrypt((rowdata[0].bankCardId + ""));
		layer.confirm('确定删除该银行卡？', {
		  btn: ['确定', '取消']
		,yes: function(index, layero){ //或者使用btn1
		    //确定的回调
		  	$.ajax({
		  		type : 'post',
		  		url : appPath + "/bankCard/del.do",
		  		data : {bankCardId : bankCardId},
		  		success : function (msg) {
		  			if (msg == 0) {
			  			layer.alert("删除成功!",{icon:1});
			  			setTimeout('location.reload()',2000);
			  		}else {
			  			layer.alert("服务器异常!",{icon:2});
			  			setTimeout('location.reload()',2000);
			  		}
		  		}
		  	});
		  	
		  },cancel: function(index){//或者使用btn2（concel）
		  	//取消的回调
		  }
		});
	});
});


/*   验证           */
$(function(){
	$(".cardTypeOption").css({
		"width":"186px",
		"padding":"5px 8px",
		"border":"1px solid #ccc",
		"cursor":"pointer"
	});
	validform5(".commonbtn0","bankAdd",false,"3");
});


/**
 * 表格初始化
 */
$(function() {
	var appPath = getRootPath();//项目根路径
	$('#table_id').DataTable(
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
            "url": appPath + "/bankCard/bankCardList.do",   
            "dataSrc": "results", 
            "data": function ( d ) {
            	var result = encrypt.encrypt((1 + ""))
            	d.memberType = result;
            } 
        },
        columns: [  
                  {title:'<input type="checkbox" class="table-checkbox"  value="1" />',
                	  "mRender": function (data, type, full) {
                		  sReturn = '<input type="checkbox" value="1" />';
                		  return sReturn;
                	  }
//                	  "sClass": "table-checkbox"
                  },
                  { title:"银行卡id","data": "bankCardId" },
                  { title:"银行卡类型","data": "carType" },  
                  { title:"开户银行","data": "bankName" },  
                  { title:"开户行城市","data": "bankCity" },  
                  { title:"开户行支行","data": "bankBranch" },  
                  { title:"银行卡卡号","data": "bankNo" }
                  
        ],
        aoColumnDefs : [
        				// {"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
        				{
        					sDefaultContent: '',
        					orderable : false,
        					aTargets: [ '_all' ]
        				},
        				{  
                            "aTargets":[1],  
                            "visible":true  
                        }
        				],
        rowCallback:function(row,data){//添加单击事件，改变行的样式      
//        	if($.inArray(data.DT_RowId,selected)!==-1){
//        		$(row).addClass('selected'); 
//        	}
        }
});
 var table = $('#table_id').DataTable();
//设置选中change颜色
 $('#table_id tbody').on( 'click', 'tr', function () {
        $(this).toggleClass('selected');
  });
});

/**
 * 查询按钮
 */
$(".glyphicon-search").on("click",function(){
	$('#table_id').DataTable().ajax.reload();
	
});