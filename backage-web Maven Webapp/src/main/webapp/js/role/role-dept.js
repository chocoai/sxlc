/*部门管理*/
/**
 * 获取项目根目录全路径
 * @returns
 */
function getRootPath(){
        var curWwwPath=window.document.location.href;
        var pathName=window.document.location.pathname;
        var pos=curWwwPath.indexOf(pathName);
        var localhostPath=curWwwPath.substring(0,pos);
        var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
		if(/127.0.0.1|localhost/.test(localhostPath)){
			return(localhostPath+projectName);
		}else{
			return(localhostPath);
		}
}
/**
 * 添加部门验证
 */
$(function () {
	validform5("layui-layer-btn0","saveDept",true,"3");
	$(".obtn-dept-add").on("click touchstart",function(){
		layer.open({
		    type: 1,
		    area: ['480px', '320px'], //高宽
		    title: "添加部门",
		    content: $(".dept-add"),//DOM或内容
		    btn:['确定', '取消']
			  ,yes: function(index, layero){ //或者使用btn1
			    //确定的回调
			    $("#saveDept").submit();
			    layer.close(index);
			  	
			  },cancel: function(index){//或者使用btn2（concel）
			  	//取消的回调
			  }
		});
	});
});
/**
 * 添加部门方法
 */
function addDept() {
	var appPath = getRootPath();//项目根路径
	var deptName = $("#sdeptName").val();
	var principalName = $("#sprincipalName").val();
	var principalPhone = $("#sprincipalPhone").val();
	var preDeptId = $("#spreDeptId").val();
	var deptRemark = $("#sdeptRemark").val();
	//加密操作
	var encrypt = new JSEncrypt();
    encrypt.setPublicKey(publicKey_common);
    var result1 = encrypt.encrypt((deptName));
    var result2 = encrypt.encrypt((principalName));
    var result3 = encrypt.encrypt((principalPhone));
    var result4 = encrypt.encrypt((preDeptId));
    var result5 = encrypt.encrypt((deptRemark));
	$.ajax( {  
		url:appPath+"/role/save.do",
		data : {
			deptName : result1, 
			principalName : result2, 
			principalPhone : result3,
			preDeptId : result4,
			deptRemark : result5
		},
		type:'post',  
		cache:false,  
		success:function(data) { 
			if (data == 1) {
				layer.alert("添加成功",{icon:1});  
				document.getElementById("saveDept").reset();
				setTimeout('location.reload()',2000);
			}else {
				layer.alert("服务器异常",{icon:2});
				document.getElementById("saveDept").reset();
			}
		}
		
	});
}
/**
 * 修改部门验证
 */
$(function () {
		$(".obtn-dept-mod").on("click touchstart",function(){
			var rowdata = $('#table_id').DataTable().rows('.selected').data();
			//属性赋值
			$("#dId").val(rowdata[0].id);
			$("#dName").val(rowdata[0].deptName);
			$("#dpName").val(rowdata[0].principalName);
			$("#dpPhone").val(rowdata[0].principalPhone);
			$("#dRemark").val(rowdata[0].deptRemark);
			$("#pdId").val(rowdata[0].preDeptId);
			//获得选取的对象
			validform5("layer-btn0","updateDept",true,"3");
			layer.open({
				type: 1,
				area: ['480px', '320px'], //高宽
				title: "修改部门",
				content: $(".dept-mod"),//DOM或内容
				btn:['确定', '取消']
			,yes: function(index, layero){ //或者使用btn1
				//确定的回调
				$("#updateDept").submit();
			},cancel: function(index){//或者使用btn2（concel）
				//取消的回调
			}
			});
		});
});
/**
 * 修改部门方法
 */
function updateDept() {
	var deptId = $("#dId").val();
	var deptName = $("#dName").val();
	var principalName = $("#dpName").val();
	var principalPhone = $("#dpPhone").val();
	var deptRemark = $("#dRemark").val();
	//加密操作
	var encrypt = new JSEncrypt();
    encrypt.setPublicKey(publicKey_common);
    var result1 = encrypt.encrypt((deptId));
    var result2 = encrypt.encrypt((deptName));
    var result3 = encrypt.encrypt((principalName));
    var result4 = encrypt.encrypt((principalPhone));
    var result5 = encrypt.encrypt((deptRemark));
	$.ajax( {  
		url:appPath+"/role/update.do",
		data : {
				deptId : result1,
				deptName : result2, 
				principalName : result3, 
				principalPhone : result4,
				deptRemark : result5
				
		},
		type:'post',  
		cache:false,  
		dataType:'json',  
		success:function(data) { 
			if (data == 0) {
				layer.alert("修改成功",{icon:1});  
				document.getElementById("updateDept").reset();
				setTimeout('location.reload()',2000);
			}else {
				layer.alert("服务器异常",{icon:2}); 
			}
		}
		
	});
}
/**
 * 删除部门
 */
$(function () {
	var appPath = getRootPath();//项目根路径
	//删除部门
	$(".obtn-dept-del").on("click touchstart",function(){
		//获得选取的对象
		
		layer.confirm('确定删除该部门？', {
		  btn: ['确定', '取消']
		}, function(index, layero){
		  //确定的回调
		  var rowdata = $('#table_id').DataTable().rows('.selected').data();
		  //加密操作
		  var encrypt = new JSEncrypt();
		  encrypt.setPublicKey(publicKey_common);
		  var result = encrypt.encrypt(rowdata[0].id + "");
		  $.ajax({
		  	type : 'post',
		  	url : appPath + "/role/delete.do",
		  	data : {deptId : result},
		  	success : function (msg) {
		  		if (msg == 0) {
		  			layer.alert("删除成功!",{icon:1});
		  			setTimeout('location.reload()',2000);
		  		}
		  	},
		  	error : function() {  
		           layer.alert("操作失败!",{icon:2});  
		    } 
		  });
			
			layer.close(index);
		}, function(index){
		  //按钮【按钮二】的回调
		});
	});
});
/**
 * 停用启用部门
 */
//启用部门
function openDept () {
	//获取选取对象
	layer.confirm('确定启用？', {
	  btn: ['确定', '取消']
	}, function(index, layero){
	  //确定回掉
	  var rowdata = $('#table_id').DataTable().rows('.selected').data();
	  //加密操作
	  var encrypt = new JSEncrypt();
	  encrypt.setPublicKey(publicKey_common);
	  var result = encrypt.encrypt(rowdata[0].id + "");
	  var result2 = encrypt.encrypt((rowdata[0].deptStatu + ""));
	  $.ajax({
	  	type : 'post',
	  	url : appPath + "/role/ofOrOpenDept.do",
	  	data : {
				deptId : result,
				deptStatu : result2 
		},
	  	success : function (msg) {
	  		layer.alert("操作成功!",{icon:1});
	  		setTimeout('location.reload()',2000);
	  	},
	  	error : function() {  
	           layer.alert("操作失败!",{icon:2});  
	    }
	  });
		
		//执行完关闭
	  	layer.close(index);
	}, function(index){
	  //按钮【按钮二】的回调
	});
}
//停用部门
function ofDept () {
	var appPath = getRootPath();//项目根路径
	//获取选取对象
	layer.confirm('确定停用？', {
	  btn: ['确定', '取消']
	}, function(index, layero){
	  //确定回掉
	  var rowdata = $('#table_id').DataTable().rows('.selected').data();
	  //加密操作
	  var encrypt = new JSEncrypt();
	  encrypt.setPublicKey(publicKey_common);
	  var result1 = encrypt.encrypt(rowdata[0].id + "");
	  var result2 = encrypt.encrypt((rowdata[0].deptStatu + ""));
	  $.ajax({
	  	type : 'post',
	  	url : appPath + "/role/ofOrOpenDept.do",
	  	data : {
				deptId : result1,
				deptStatu : result2 
		},
	  	success : function (msg) {
	  		layer.alert("操作成功!",{icon:1});
	  		setTimeout('location.reload()',2000);
	  	},
	  	error : function() {  
	          layer.alert("操作失败!",{icon:2});  
	    }
	  });
		
		//执行完关闭
	  	layer.close(index);
	}, function(index){
	  //按钮【按钮二】的回调
	});
}
/**
 * datatables
 */
$(function() {
	//单选
	$('#table_id tbody').on( 'click', 'tr', function () {
		var $this = $(this);
		var $checkBox = $this.find("input:checkbox");
		 if ( $(this).hasClass('selected') ) {
			 $checkBox.prop("checked",false);
				$(this).removeClass('selected');
			}
			else {
				$('tr.selected').removeClass('selected');
				$this.siblings().find("input:checkbox").prop("checked",false);
				$checkBox.prop("checked",true);
				$(this).addClass('selected');
			}
		
	} );
});

/**
 * 显示职务列表或者刷新
 */
var flag = true;
function showListOfDataTable(dePtId){
	$("#spreDeptId").val(dePtId);
	/*	$("#deptId").attr("value",dePtId);
	$("#deptId").val(dePtId);
	$("#deptId").get(0).value = dePtId;
	$("#deptId").prop("disabled",true);
*/	if(flag){
		showDept(dePtId);
	}else{
		$('#table_id').DataTable().ajax.reload();
	}
	flag = false;
}


/**
 * 显示列表
 */	
function showDept(dePtId){
	$('#table_id').DataTable(
		{
			autoWidth : false,
			scrollY : 500,
			serverSide:true,
			pagingType: "simple_numbers",//设置分页控件的模式  
			paging : true,//分页
			searching : true,
	/*			processing:true,
			displayStart:0,*/
			info : true,// 左下角信息
//			ordering: false,//排序
			lengthMenu:[10,25,50,100],
//			aaSorting : [ [ 16, "desc" ] ],// 默认第几个排序
			colReorder : false,
			scrollX : true,
			sScrollX : "100%",
			sScrollXInner : "100%",
			bScrollCollapse : true,  
			processing: true, //打开数据加载时的等待效果  
	        serverSide: true,//打开后台分页  
        ajax: {  
            "url": appPath + "/role/role-dept.do",   
            "dataSrc": "results", 
            "data": function ( d ) { 
            	var spreDeptId = dePtId;
                var deptNo = $("#deptNo").val();
                var deptName = $('#deptName').val(); 
                var principalName = $('#deptPerson').val(); 
                var principalPhone = $('#deptPhone').val();
                var encrypt = new JSEncrypt();
                encrypt.setPublicKey(publicKey_common);
                spreDeptId = encrypt.encrypt(spreDeptId+"");
                if (deptNo != null && deptNo != "") {
                	var result1 = encrypt.encrypt((deptNo));
                }
				if (deptName != null && deptName != "") {
					var result2 = encrypt.encrypt((deptName));
				}
				if (principalName != null && principalName != "") {
					var result3 = encrypt.encrypt((principalName));
				}
				if (principalPhone != null && principalPhone != "") {
					var result4 = encrypt.encrypt((principalPhone));
				}
                	d.deptNo = result1;
                	d.deptName = result2;
                	d.principalName = result3;
                	d.principalPhone = result4;
                	d.spreDeptId = spreDeptId;
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
                  { title:"部门id","data": "id" },
                  { title:"部门编号","data": "deptNo" },  
                  { title:"部门名称","data": "deptName" },  
                  { title:"备注","data": "deptRemark" },  
                  { title:"添加时间","data": "addDate" },  
                  { title:"部门负责人","data": "principalName" },
                  { title:"负责人电话","data": "principalPhone" },
                  { title:"上级部门编号","data": "preDeptId" },
                  { title:"部门等级","data": "deptLevel" },    
                  { title:"状态","data": "deptStatu", 
                	  "mRender": function (data, type, full) {
                		 if (full.deptStatu ==0) {
                			 return "<font color='red'>无效</font>";
                		 }else if (full.deptStatu ==1){
                			 return "有效";
                		 }
                	  } 
                  }, 
                  { title:"操作","data": "deptStatu",
                  	"mRender": function (data, type, full) {
                  		  if(full.deptStatu ==1){
                  			 return "<a onclick=\"ofDept();\" href=\"javascript:void(0);\">停用</a>";
                  		  }else{
                  			  return "<a onclick=\"openDept();\" href=\"javascript:void(0);\">启用</a>" ;
                  		  }
                	  } 
                  }
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
                            "visible":false  
                        }
        				],
        rowCallback:function(row,data){//添加单击事件，改变行的样式      
        }
});
	
	
}	
/**
 * 查询按钮
 */
$(".glyphicon-search").on("click",function(){
	$('#table_id').DataTable().ajax.reload();
	
});
