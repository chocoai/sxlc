/** 友情链接 **/
//加密设置
var encrypt = new JSEncrypt();
encrypt.setPublicKey(publicKey_common);
/** 表格初始化 **/
$(function() {
	$('#fltable').DataTable(
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
            "url": appPath + "/link/list.do",   
            "dataSrc": "results", 
            "data": function ( d ) {  
                var level1 = $('#level1').val();  
                //添加额外的参数传给服务器  
                d.extra_search = level1;
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
                  { title:"友情链接id","data": "id" },
                  { title:"添加时间","data": "createTime" },
                  { title:"链接名称","data": "name" },  
                  { title:"链接地址","data": "url" },
                  { title:"最后一次操作管理员","data": "adminName" }  
                  
        ],
        aoColumnDefs : [
        				// {"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
        				{
        					sDefaultContent: '',
        					orderable : false,
        					aTargets: [ '_all' ]
        				}
        				],
        rowCallback:function(row,data){//添加单击事件，改变行的样式      
//        	if($.inArray(data.DT_RowId,selected)!==-1){
//        		$(row).addClass('selected'); 
//        	}
        }
});
 var table = $('#fltable').DataTable();
//设置选中change颜色
 $('#fltable tbody').on( 'click', 'tr', function () {
        $(this).toggleClass('selected');
  });
});

/* 友情链接添加部分开始 */
function addLink(){
	layer.open({
	    type: 1,
	    area: ['400px', '300px'], //高宽
	    title: "添加友情链接",
	    maxmin: true,
	    content: $("#friendlink-add"),//DOM或内容
	    btn:['确定', '取消']
		  ,yes: function(index, layero){ //或者使用btn1
		    //确定的回调
			var name = encrypt.encrypt($("#stitle").val());
			var url = encrypt.encrypt($("#surl").val());
			$.ajax({
				type : 'post',
				url :　appPath +　"/link/save.do",
				data : {
					name : name,
					url : url
				},
				success : function (msg) {
					if (msg == 1) {
						layer.alert("添加成功",{icon:1});  
						$("#stitle").reset();
						$("#surl").reset();
						setTimeout('location.reload()',2000);
					}else {
						layer.alert("服务器异常",{icon:2});
						$("#stitle").reset();
						$("#surl").reset();
					}
				}
			});
		  	
		  },cancel: function(index){//或者使用btn2（concel）
		  	//取消的回调
		  }
	});
}
/* 友情链接添加部分结束 */
/* 友情链接修改部分开始 */
function modLink(){
	var rowdata = $('#fltable').DataTable().rows('.selected').data();
	$("#mtitle").val(rowdata[0].name);
	$("#murl").val(rowdata[0].url);
	var friendLinkId = rowdata[0].id;
	layer.open({
		type: 1,
		area: ['400px', '300px'], //高宽
		title: "修改友情链接",
		maxmin: true,
		content: $("#friendlink-mod"),//DOM或内容
		btn:['确定', '取消']
	,yes: function(index, layero){ //或者使用btn1
		//确定的回调
		var name = encrypt.encrypt($("#mtitle").val());
		var url = encrypt.encrypt($("#murl").val());
		var id = encrypt.encrypt(friendLinkId + "");
		$.ajax({
			type : 'post',
			url :　appPath +　"/link/update.do",
			data : {
				name : name,
				url : url,
				friendLinkId : id
			},
			success : function (msg) {
				if (msg == 1) {
					layer.alert("操作成功",{icon:1});  
					$("#stitle").reset();
					$("#surl").reset();
					setTimeout('location.reload()',2000);
				}else {
					layer.alert("服务器异常",{icon:2});
					$("#stitle").reset();
					$("#surl").reset();
				}
			}
		});
	},cancel: function(index){//或者使用btn2（concel）
		//取消的回调
	}
	});
}
/* 友情链接修改部分结束 */
/* 删除部分开始 */ 
function delLink(){
	var rowdata = $('#fltable').DataTable().rows('.selected').data();
	layer.confirm('确定删除？', {
		  btn: ['确定', '取消'],
		  yes: function(index, layero){
			  var friendLinkId = encrypt.encrypt(rowdata[0].id + "");
			  $.ajax({
					type : 'post',
					url :　appPath +　"/link/delete.do",
					data : {
						friendLinkId : friendLinkId
					},
					success : function (msg) {
						if (msg == 1) {
							layer.alert("操作成功",{icon:1});  
							setTimeout('location.reload()',2000);
						}else {
							layer.alert("服务器异常",{icon:2});
						}
					}
				});
		  }
		});
}	
/* 删除部分结束*/ 