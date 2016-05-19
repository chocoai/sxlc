/** 红包赠送配置 **/
var encrypt = new JSEncrypt();
encrypt.setPublicKey(publicKey_common);

/* 查询首次开户充值 */
$(function () {
	$.ajax({
		type : 'post',
		url : appPath + "/red/first.do",
		success : function (msg) {
			$("#openAcount").val(msg.openAccountRPs);
			$("#firstRecharge").val(msg.firstRechargeRPs);
		}
	});
	
	$("#first").bind('click', function() {
		$("#conForm").submit();
	});
});
//首次
function firstOption() {
	var openAcount = $("#openAcount").val();
	var firstRecharge = $("#firstRecharge").val();
	openAcount = encrypt.encrypt((openAcount + ""));
	firstRecharge = encrypt.encrypt((firstRecharge + ""));
	$.ajax({
		type : 'post',
		url : appPath + "/red/firstOption.do",
		data : {
			openAcount : openAcount,
			firstRecharge : firstRecharge
		},
		success : function (msg) {
			if (msg == 1) {
				layer.alert("操作成功",{icon:1});
				setTimeout('location.reload()',2000);
			}else {
				layer.alert("操作失败",{icon:2});
			}
		}
	});
}
/*  添加SEO设置     */
function addEnv(){
	layer.open({
		type: 1,
		area: ['450px', '200px'], //高宽
		title: "添加红包配置",
		maxmin: true,
		content: $("#addEnv")//DOM或内容
	});
}

$(function() {
	$("#add").bind('click', function(){
		$("#addRedEForm").submit();
	});
});

function addRed() {
	var invsit = $("#invsit").val();
	var scale = $("#scale").val();
	invsit = encrypt.encrypt((invsit + ""));
	scale = encrypt.encrypt((scale + ""));
	$.ajax({
		type : 'post',
		url : appPath + "/red/addRed.do",
		data : {
			invsit : invsit,
			scale : scale
		},
		success : function (msg) {
			if (msg == 1) {
				layer.alert("操作成功",{icon:1});
				setTimeout('location.reload()',2000);
			}else {
				layer.alert("操作失败",{icon:2});
			}
		}
	});
}

/*  修改SEO设置     */
function alertEnv(){
	var rowdata = $('#applicationAudit').DataTable().rows('.selected').data();
	$("#minvsit").val(rowdata[0].investAmounts);
	$("#mscale").val(rowdata[0].rpRates);
	layer.open({
		type: 1,
		area: ['450px', '200px'], //高宽
		title: "修改红包配置",
		maxmin: true,
		content: $("#alertEnv")//DOM或内容
	});
}

$(function() {
	$("#mod").bind('click', function(){
		$("#alertRedEForm").submit();
	});
});

function modRed() {
	var rowdata = $('#applicationAudit').DataTable().rows('.selected').data();
	var invsit = $("#minvsit").val();
	var scale = $("#mscale").val();
	var lId = rowdata[0].firpID;
	invsit = encrypt.encrypt((invsit + ""));
	scale = encrypt.encrypt((scale + ""));
	lId = encrypt.encrypt((lId + ""));
	$.ajax({
		type : 'post',
		url : appPath + "/red/addRed.do",
		data : {
			invsit : invsit,
			scale : scale,
			lId : lId
		},
		success : function (msg) {
			if (msg == 1) {
				layer.alert("操作成功",{icon:1});
				setTimeout('location.reload()',2000);
			}else {
				layer.alert("操作失败",{icon:2});
			}
		}
	});
}


/* 红包个数增加  */
$(function(){
	var content = "<div class='redEContent'><span class='tt t1'></span><span class='col'><input datatype='acountM' class='moneyInput'>元<input datatype='nNum1' class='moneyInput'>个<a class='redDelete'>删除</a></span></div>";
	$(".redEAdd").on("click",function(){
		$(this).parent().parent().parent().append(content);
		$(".redDelete").on("click",function(){
			$(this).parent().parent().remove();
		});
	});
});

$(function(){
	validform5(".addBtn","addRedEForm",false,3);
	validform5(".alertBtn","alertRedEForm",false,3);
	validform5(".okBtn","conForm",false,3);
	$(".cancelBtn").bind("click",function(){
		layer.closeAll();
	});
	$("#conForm").Validform({
		tiptype:3,
		btnSubmit:".okBtn", 
		datatype:{"logName":logName,"acountM":acountM},
		ajaxPost:{
			
		    },
			success:function(data,obj){
	            
	        },
	        error:function(data,obj){
	            
	        }
	});
});
//表格初始化
$(function() {
	var appPath = getRootPath();//项目根路径
	$('#applicationAudit').DataTable(
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
            "url": appPath + "/red/redSendList.do",   
            "dataSrc": "results", 
            "data": function ( d ) {  
            } 
        },
        columns: [  
                  {title:'<input type="checkbox" class="table-checkbox"  value="1" />',
                	  "mRender": function (data, type, full) {
                		  sReturn = '<input type="checkbox" value="1" />';
                		  return sReturn;
                	  }
                  },
                  { title:"投资金额(元)","data": "investAmounts" }, 
                  { title:"红包比例(%)","data": "rpRates" }
        ],
        aoColumnDefs : [
        				{
        					sDefaultContent: '',
        					orderable : false,
        					aTargets: [ '_all' ]
        				}
        				],
        rowCallback:function(row,data){//添加单击事件，改变行的样式      
        }
});
 var table = $('#applicationAudit').DataTable();
//设置选中change颜色
 $('#applicationAudit tbody').on( 'click', 'tr', function () {
        $(this).toggleClass('selected');
  });
});


