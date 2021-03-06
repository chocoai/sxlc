//加密设置
var encrypt = new JSEncrypt();
encrypt.setPublicKey(publicKey_common);

$(function() {
	//表格初始化
	$('#staffListTb').DataTable({
		ajax: {  
			"url": appPath+"/role/getAllStaff.do",   
			"dataSrc": "results",   
			"type": "POST",
			"data": function ( d ) {
				//加密
				var personalName = encrypt.encrypt($("#personalNameQuery").val());
				var personalPhone = encrypt.encrypt($("#personalPhoneQuery").val());
				var personalIDCard = encrypt.encrypt($("#personalIDCardQuery").val());
				var postId = $("#postIdQuery").prop("postId");
				if(typeof(postId)!="undefined" && postId!=''){
					 postId = encrypt.encrypt(postId+"");
				}
				d.personalName = personalName;
				d.personalPhone = personalPhone;
				d.personalIDCard = personalIDCard;
				d.postId = postId;
			}  
		},
		columns: [  
		          {title:'<input type="checkbox" class="table-checkbox"  value="1" />',
		        	  "mRender": function (data, type, full) {
		        		  sReturn = '<input type="checkbox" class="row-checkbox" value="1" />';
		        		  return sReturn;
		        	  }
		          },
		          { title:"pid","data": "baseInfo.id"},  
		          { title:"sid","data": "id"},  
		          { title:"姓名","data": "baseInfo.personalName"},  
		          { title:"性别","data": "baseInfo.sexId" , 
		        	  "mRender": function (data, type, full) {
		        		  if(data==0){
		        			  return "男";
		        		  }else if(data ==1){
		        			  return "女";
		        		  }else{
		        			  return "";
		        		  }
		        	  } 
		          },  
		          { title:"身份证号","data": "baseInfo.personalIDCard" },  
		          { title:"出生日期","data": "baseInfo.personalIDCard" , 
		        	  "mRender": function (data, type, full) {
		        		  return  getInfoByIdCard(data,1);
		        	  } 
		          },  
		          { title:"民族","data": "baseInfo.nationId", 
		        	  "mRender": function (data, type, full) {
		        		  $("#nationId").val(data);
		        		  return $("#nationId").find("option:selected").text();
		        	  } 
		          },  
		          { title:"职务","data": "postName"},  
		          { title:"联系电话","data": "baseInfo.personalPhone" },  
		          { title:"QQ","data": "baseInfo.qq" },  
		          { title:"Email","data": "baseInfo.personalEmail" },  
		          { title:"户籍","data": "baseInfo.homeTown" },  
		          { title:"现居住地","data": "baseInfo.houseAddress" },  
		          { title:"学历","data": "baseInfo.education" , 
		        	  "mRender": function (data, type, full) {
		        		  $("#education").val(data);
		        		  return $("#education").find("option:selected").text();
		        	  } 
		          },  
		          { title:"毕业时间","data": "baseInfo.graduatedDATE" , 
		        	  "mRender": function (data, type, full) {
		        		  return getDateByStr(data);

		        	  } 
		          },  
		          { title:"紧急联系人姓名","data": "emerName" },  
		          { title:"紧急联系人电话","data": "emerPhone" },  
		          { title:"入职时间","data": "startDate" , 
		        	  "mRender": function (data, type, full) {
		        		  var date = new Date(data);
		        		  return date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate();
		        	  } 
		          }

		          ],
		          pagingType: "simple_numbers",//设置分页控件的模式  
		          processing: true, //打开数据加载时的等待效果  
		          serverSide: true,//打开后台分页  
				  scrollY : 500,
				  scrollYInner : 500,
		          searching: false,
		          scrollCollapse: true,//表格高度自动调节
		          scrollX : "100%",//超出屏幕宽度显示水平滚动条
		          scrollXInner : "100%",scrollY:500,
//		          ordering:false,
//		          aaSorting : [ [ 5, "desc" ],[ 12, "desc" ],[ 14, "desc" ] ],//默认第几个排序
		          aoColumnDefs : [
		                          {"bVisible": false, "aTargets": [1,2]}, //控制列的隐藏显示
		                          {
		                        	  orderable : false,
		                        	  aTargets : [ 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12,
		                        	               13, 14, 15,16,17 ]
		                          } // 制定列不参与排序
		                          ],
		                          rowCallback:function(row,data){//添加单击事件，改变行的样式      
		                          }
	});//表格初始化完毕

	 //表格多选效果
	 $('#staffListTb tbody').on( 'click', 'tr', function () {
		 var $this = $(this);
		 var $checkBox = $this.find("input:checkbox");
		 if($this.hasClass('selected')){
			 $checkBox.prop("checked",false);
			 $(".table-checkbox").prop("checked",false);
		 }else{
			 $checkBox.prop("checked",true);
		 }
		 $this.toggleClass('selected');
	 });
	 
	 //全选效果
	 $(".table-checkbox").on('click',function(){
		var $this = $(".table-checkbox");
		 if($this.prop('checked')){
			 $(".row-checkbox").prop("checked",true);
			 $('#staffListTb tr').addClass("selected");
			 
		 }else{
			 $(".row-checkbox").prop("checked",false);
			 $('#staffListTb tr').removeClass("selected");
		 }
		 
	 });
	 
	 /**
	  * 查询按钮
	  */
	 $("#queryBtn").on("click",function(){
		$('#staffListTb').DataTable().ajax.reload();
		
	 });
	 
	 
	/**
	 * 添加按钮
	 */
	$(".obtn-emp-add").on("click touchstart",function(){
		document.getElementById("dataForm").reset();
		
		validform5(".layui-layer-btn0","dataForm",false,5);
		var errorMsg = $("#errorMsg").val();
		if(errorMsg !=null && errorMsg != ""){
			layer.alert("redis服务异常，查询字典失败！<br>"+errorMsg,{icon:0});
			return;
		}
		layer.open({
		    type: 1,
		    area: ['750px', '500px'], //高宽
		    title: "添加员工",
		    content: $(".emp-add"),//DOM或内容
		    btn:['确定', '取消']
			  ,yes: function(index, layero){ //或者使用btn1
				  $(".layui-layer-btn0").addClass("disabled");
				  $("#dataForm").submit();
			  },cancel: function(index){//或者使用btn2（concel）
			  	//取消的回调
				  $("#dataForm").find(".Validform_checktip").removeClass("Validform_right");
				  $("#dataForm").find(".Validform_checktip").removeClass("Validform_wrong");
				  $("#dataForm").find(".Validform_error").removeClass("Validform_error");
				  $("#dataForm").find(".Validform_checktip").html("");
				  
			  }
		});
	});
	
	/**
	 * 修改按钮 
	 */
	$(".obtn-emp-mod").on("click touchstart",function(){
		//获得选取的对象
		document.getElementById("dataForm").reset();
		
		validform5(".layui-layer-btn0","dataForm",true,5);
		var data = $('#staffListTb').DataTable().rows('.selected').data();
		if(data.length<1){
			layer.alert("请选择要修改的员工信息！",{icon:0});
			return;
		}
		if(data.length>1){
			layer.alert("不能选择多条数据进行修改！",{icon:0});
			return;
		}
		var errorMsg = $("#errorMsg").val();
		if(errorMsg !=null && errorMsg != ""){
			layer.alert("redis服务异常，查询字典失败！<br>"+errorMsg,{icon:0});
			return;
		}
		
		$(".emp-add #personalName").val(data[0].baseInfo.personalName);
		$(".emp-add #personalIDCard").val(data[0].baseInfo.personalIDCard);
		$(".emp-add #birthday").val(getInfoByIdCard(data[0].baseInfo.personalIDCard,1));
		$(".emp-add #nationId").val(data[0].baseInfo.nationId);
		$(".emp-add #personalPhone").val(data[0].baseInfo.personalPhone);
		$(".emp-add #qq").val(data[0].baseInfo.qq);
		$(".emp-add #personalEmail").val(data[0].baseInfo.personalEmail);
		$(".emp-add #homeTown").val(data[0].baseInfo.homeTown);
		$(".emp-add #houseAddress").val(data[0].baseInfo.houseAddress);
		$(".emp-add #education").val(data[0].baseInfo.education);
		$(".emp-add #graduatedDate").val( getDateByStr(data[0].baseInfo.graduatedDATE));
		$(".emp-add #emerName").val(data[0].emerName);
		$(".emp-add #emerPhone").val(data[0].emerPhone);
		$(".emp-add #postName").val(data[0].postName);
		$(".emp-add #staffId").val(data[0].id);
		$(".emp-add #personalId").val(data[0].baseInfo.id);
		$("#postName").prop("postId",data[0].postId);
		
		//之后
		layer.open({
		    type: 1,
		    area: ['700px', '420px'], //高宽
		    title: "修改员工",
		    content: $(".emp-add"),//DOM或内容
		    btn:['确定', '取消']
			  ,yes: function(index, layero){ //或者使用btn1
				  $(".layui-layer-btn0").addClass("disabled");
				  var param = getEncryptData(2);
				  if(param == -1){
					  layer.alert("请选择职务！",{icon:0});
					  return;
				  }
				  if(data == -2){
					  layer.alert("请选择毕业时间！",{icon:0});
					  return;
				  }
				  $.ajax( {  
					  url:appPath+"/role/addOrUpdateStaff.do",
					  data: param,  
					  type:'post',  
					  cache:false,  
					  dataType:'json',  
					  success:function(data) {  
						  if(data ==0){  
							  layer.alert("修改成功!",{icon:1});  
							  $(".layui-layer-btn1").click();
							  var table = $('#staffListTb').DataTable();
							  table.ajax.reload();
				         }else if(data==1){  
				        	 layer.alert("修改失败!",{icon:2});  
				         }else if(data==-1){
								layer.alert("身份证已存在",{icon:2});  
						 }    
						 $(".layui-layer-btn0").removeClass("disabled");
				      },  
				      error : function() {  
				           layer.alert("服务器异常!",{icon:2});  
				      }  
				 });
				  
			  },cancel: function(index){//或者使用btn2（concel）
			  	//取消的回调
			  }
		});
	});
	
	/**
	 * 删除按钮
	 */
	$(".obtn-emp-del").on("click touchstart",function(){
		document.getElementById("dataForm").reset();
		var data = $('#staffListTb').DataTable().rows('.selected').data();
		if(data.length<1){
			layer.alert("请选择要删除的员工！",{icon:0});
			return;
		}
		var ids = new Array();
		for(var i=0;i<data.length;i++){
			ids.push(data[i].id);
		}
		layer.confirm('确定删除选中员工？', {
		  btn: ['确定', '取消']
		}, function(index, layero){
			$.ajax( {  
				     url:appPath+"/role/delStaff.do",
				     data:{"ids":encrypt.encrypt(JSON.stringify(ids))},  
				     type:'post',  
				     cache:false,  
				     dataType:'json',  
				     success:function(data) {  
				         if(data ==0){  
				        	 layer.alert("删除成功!",{icon:1});
				        	 var table = $('#staffListTb').DataTable();
							 table.ajax.reload();
				         }else if(data ==1){  
				        	 layer.alert("删除失败!",{icon:2});  
				         }
				      },  
				      error : function() {  
				           layer.alert("服务器异常!",{icon:2});  
				      }  
				 });
			
			//执行完关闭
		  	layer.close(index);
		}, function(index){
		  //按钮【按钮二】的回调
		});
	});
	
	/**
	 * 根据身份证抓取出生日期
	 */
	$(".idCard").on("change",function(){
		var idCard = $(this).val();
		$("#birthday").val(getInfoByIdCard(idCard,1));
		$("#birthday").prop("disabled",true);
		
	});
	
	
	//选择职务按钮
	$(".deptSelect").on("click",function(){
		var $this = $(this);
		layer.open({
			type: 1,
			area: ['500px', '300px'], //高宽
			title: "职务列表",
			content: $(".dept-select"),//DOM或内容
			btn:['添加','关闭', '清空']
		,btn1: function(index, layero){ //或者使用btn1
			var data = $('#deptTbList').DataTable().rows('.selected').data();
			if(data.length<1){
				layer.alert("请选择职务！",{icon:0});
				return;
			}
			var postIds = "";//部门、职位拼接字符串
			var postNames = "";//展示职务名
			for(var i = 0;i<data.length;i++){
				var postId = data[i].id;
				var deptId = data[i].deptId;
				postIds += deptId+":"+postId+",";
				if(data[i].postName != ""){
					postNames += data[i].postName+",";
				}
			}
			postIds = postIds.substring(0, postIds.length-1);
			postNames = postNames.substring(0, postNames.length-1);
			$this.parent().find(".postId").prop("postId",postIds);
			$this.parent().find(".postId").val(postNames);
			layer.close(index);
		},btn2: function(index){//或者使用btn2（concel）
			
		},btn3:function(index){
			//清空
			$this.parent().find(".postId").prop("postId","");
			$this.parent().find(".postId").val("");
			layer.close(index);
		}
		});
	});
	
	  //职务查询按钮
	 $("#postQuery").on("click",function(){
		$('#deptTbList').DataTable().ajax.reload();
		
	 });
	
	//职务列表初始化
	$('#deptTbList').DataTable(
			{
		        ajax: {  
		        	"url": appPath+"/role/getPostAll.do",   
					"dataSrc": "results",   
					"type": "POST",
		            "data": function ( d ) {  
		            	var deptName = encrypt.encrypt($("#deptName").val());
						var postName = encrypt.encrypt($("#postNameQuery").val());
		            	d.deptName=deptName;
		            	d.postName=postName;
		            }  
		        },
		        columns: [  
		                  {title:'<input type="checkbox" class="table-checkbox1"  value="1" />',sWidth:"10%", 
		                	  "mRender": function (data, type, full) {
		                		  sReturn = '<input type="checkbox" class="tr-checkbox" value="1" />';
		                		  return sReturn;
		                	  }
		                  },
		                  { title:"部门","data": "deptName"},  
		                  { title:"职位","data": "postName"}  
		        ],
//		        pagingType: "simple_numbers",//设置分页控件的模式  
		        processing: true, //打开数据加载时的等待效果  
//		        serverSide: true,//打开后台分页  
		        searching: false,
		        info:false,
		        searching: false,//关闭搜索
		        paging:false,//关闭分页栏
		        aoColumnDefs : [
			                        {"bVisible": false, "aTargets": []}, //控制列的隐藏显示
			                        {
			                        	orderable : false,
			                        	aTargets : [ 0, 1, 2]
			                        } // 制定列不参与排序
		                        ],
                rowCallback:function(row,data){//添加单击事件，改变行的样式      
                }
	});
	
	
	 //表格多选效果
	 $('#deptTbList tbody').on( 'click', 'tr', function () {
		 var $this = $(this);
		 var $checkBox = $this.find("input:checkbox");
		 if($this.hasClass('selected')){
			 $checkBox.prop("checked",false);
			 $(".table-checkbox1").prop("checked",false);
		 }else{
			 $checkBox.prop("checked",true);
		 }
		 $this.toggleClass('selected');
	 });
	 
	 //全选效果
	 $(".table-checkbox1").on('click',function(){
		var $this = $(".table-checkbox1");
		 if($this.prop('checked')){
			 $(".tr-checkbox").prop("checked",true);
			 $('#deptTbList tr').addClass("selected");
			 
		 }else{
			 $(".tr-checkbox").prop("checked",false);
			 $('#deptTbList tr').removeClass("selected");
		 }
		 
	 });
	
});

	/**
	 * 根据身份证获取出生日期、性别、年龄信息
	 * @param idCard 身份证号码
	 * @param type 信息类型 1：出生日期 2：性别 3：年龄
	 * @returns
	 */
	function getInfoByIdCard(idCard,type){
		   if(type==1){
		       //获取出生日期
		       birth=idCard.substring(6, 10) + "-" + idCard.substring(10, 12) + "-" + idCard.substring(12, 14);
		       return birth;
		   }
		   if(type==2){
		       //获取性别
		       if (parseInt(idCard.substr(16, 1)) % 2 == 1) {
		           //男
		    	   return "0";
		       } else {
		           //女
		    	   return "1";
		       }
		   }
		   if(type==3){
		        //获取年龄
		        var myDate = new Date();
		        var month = myDate.getMonth() + 1;
		        var day = myDate.getDate();
		        var age = myDate.getFullYear() - idCard.substring(6, 10) - 1;
		        if (idCard.substring(10, 12) < month || idCard.substring(10, 12) == month && idCard.substring(12, 14) <= day) {
		            age++;
		        }
		        return age;
		 }
	}
	
	
	
	
/**
 * 转换毫秒值字符串为日期
 */
function getDateByStr(data){
	  var date = new Date(data);
      return date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate();
}
	
/**
 * 添加员工 
 */
function addStaff(){
		var data = getEncryptData(1);
		if(data == -1){
			 layer.alert("请选择职务！",{icon:0});
			return;
		}
		if(data == -2){
			layer.alert("请选择毕业时间！",{icon:0});
			return;
		}
		$.ajax( {  
			url:appPath+"/role/addOrUpdateStaff.do",
			data:data,
			type:'post',  
			cache:false,  
			dataType:'json',  
			success:function(data) { 
				if(data==0){
					layer.alert("添加成功",{icon:1});
					$(".layui-layer-btn1").click();
					 var table = $('#staffListTb').DataTable();
					 table.ajax.reload();
				}else if(data==1){
					layer.alert("服务器异常",{icon:2});  
				}else if(data==-1){
					layer.alert("身份证已存在",{icon:2});  
				}
				 $(".layui-layer-btn0").removeClass("disabled");
			},  
			error : function() {  
				layer.alert("服务器异常",{icon:2});  
			}  
		});
}

/**
 * 获取加密参数
 * @param type 操作类型 1：增加  2：修改
 */
function getEncryptData(type){
	var data={};
	var personalName = encrypt.encrypt($("#personalName").val());
	data.personalName=personalName;
	var personalIDCard = $("#personalIDCard").val();
	data.personalIDCard= encrypt.encrypt(personalIDCard);
	var sexId = getInfoByIdCard(personalIDCard,2);
	data.sexId= encrypt.encrypt(sexId+"");
	var nationId = encrypt.encrypt($("#nationId").val());
	data.nationId=nationId;
	var personalPhone = encrypt.encrypt($("#personalPhone").val());
	data.personalPhone=personalPhone;
	var qq = encrypt.encrypt($("#qq").val());
	data.qq=qq;
	var personalEmail = encrypt.encrypt($("#personalEmail").val());
	data.personalEmail=personalEmail;
	var homeTown = encrypt.encrypt($("#homeTown").val());
	data.homeTown=homeTown;
	var houseAddress = encrypt.encrypt($("#houseAddress").val());
	data.houseAddress=houseAddress;
	var education = encrypt.encrypt($("#education").val());
	data.education=education;
	var graduatedDate = $("#graduatedDate").val();
	if(graduatedDate == ""){
		return "-2";
	}
	data.graduatedDate= encrypt.encrypt(graduatedDate);
	var emerName = encrypt.encrypt($("#emerName").val());
	data.emerName=emerName;
	var emerPhone = encrypt.encrypt($("#emerPhone").val());
	data.emerPhone=emerPhone;
	var postId = $("#postName").prop("postId");
	if(typeof(postId)!="undefined" && postId!=''){
		 data.content= postId;
	}else{
		 return "-1";
	}
//	var deptId = $("#postName").prop("deptId");
//	if(typeof(deptId)!="undefined" && deptId!=''){
//		deptId = encrypt.encrypt(deptId+"");
//		data.deptId=deptId;
//	}else{
//		return "-1";
//	}
	data.type=encrypt.encrypt(""+type);
	var id = $("#staffId").val();
	data.id = encrypt.encrypt(id);
	return data;
}

