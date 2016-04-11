<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
	<base href="<%=basePath%>">
	<title>前台界面配置</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link rel="stylesheet" href="css/frontconfig/frontconfig.css" />
	<link rel="stylesheet" href="plugs/webuploader/0.1.5/webuploader.css" />
	<link rel="stylesheet" href="css/upload.css" />
</head>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="5" name="top_menu_index"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-frontconfig.jsp"></jsp:include>
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				<!-- tab切换 -->
				<ul class="nav nav-tabs">
					<li class="active"><a href="javascript:;">首页轮播图</a></li>
					<li><a href="javascript:;">登录界面展示图片</a></li>
					<li><a href="javascript:;">借款界面展示图片</a></li>
					<li><a href="javascript:;">注册界面展示图片</a></li>
					<li><a href="javascript:;">论坛轮播图</a></li>
				</ul>
				
				<div class="nav-tabs-con active">
					<div class="search">
						<div class="panel panel-success">
							<div class="panel-heading">
								<div class="i-fl search_title">条件查询</div>
								<div class="i-fr action_item">
									<ul class="list_item list-inline">
										<li><a class="state">展开&nbsp;<span
												class="glyphicon glyphicon-chevron-down"></span> </a>
										</li>
									</ul>
								</div>
							</div>
							<div class="panel-body">
								<form id="" class="" action="">
									<span class="con-item">
										<span>添加时间</span><input type="text" class="" placeholder="" />
									</span>
									<span class="con-item">
										<span>图片标题</span><input type="text" class="" placeholder="" />
									</span>
									<span class="con-item">
										<span>状态</span><input type="text" class="" placeholder="" />
									</span>
									<button class="obtn obtn-query glyphicon glyphicon-search">查询</button>
								</form>
							</div>
						</div>
					</div>
					<div class="w-content pic-add">
						<form id="savePartner" action="javascript:addPartner()" method="post" >
							<table>
								<tr>
									<td class="tt">图片标题</td>
									<td class="con"><input type="text" class="" /></td>
								</tr>
								<tr>
									<td class="tt">图片链接</td>
									<td class="con"><input type="text" class="w500" /></td>
								</tr>
								<tr>
									<td class="tt">图片选择</td>
									<td class="con">
										<!--dom结构部分-->
										<div id="uploader">
										    <!--用来存放item-->
										    <div id="filePicker">选择图片</div>
										    <span class="rec-dimensions">建议尺寸：580*280</span>
										</div>
									</td>
								</tr>
								<tr>
									<td class="tt" valign="top">图片预览</td>
									<td class="con" id="fileList">
										
									</td>
								</tr>
							</table>
						</form>
					</div>
				
					<div class="data_display">
						<div class="panel panel-success">
							<div class="panel-heading">
								<div class="action_item">
									<button class="obtn glyphicon glyphicon-plus obtn-pic-add">添加</button>
									<button class="obtn glyphicon glyphicon-pencil obtn-pic-mod" onclick="picMod('修改首页轮播图','web/common/picture/pic-add.jsp','1','id')">修改</button>
								</div>
							</div>
							
							<div class="panel-body">
								<table id="table_id" class="display">
									
								</table>
							</div>
							
						</div>
					</div>
				</div>
				<div class="nav-tabs-con">
					2
				</div>
				<div class="nav-tabs-con">3</div>
				
				
				
			</div>
		</div>
	</div>
	<!-- 尾部 -->
	
	
	
	
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<script type="text/javascript" src="plugs/webuploader/0.1.5/webuploader.js"></script>
	<script type="text/javascript" src="plugs/ueditor/ueditor.config.js"></script>
	<script type="text/javascript" src="plugs/ueditor/ueditor.all.min.js"></script>
	<script type="text/javascript" src="plugs/ueditor/lang/zh-cn/zh-cn.js"></script>
	<script type="text/javascript" src="js/frontconfig/frontconfig.js"></script>
	<script type="text/javascript" src="js/upload.js"></script>
	<!-- 私用js -->
	<script type="text/javascript">
		/* $('#table_id').DataTable({
			"aaSorting" : [ [ 1, "desc" ] ],//默认第几个排序
			"aoColumnDefs" : [
			//{"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
			{
				"orderable" : false,
				"aTargets" : [0,2,3,4,5,6,7]
			} // 制定列不参与排序
			],
		}); */
		/**网站公告**/

		//获取项目根目录全路径
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
		$(function() {
			var appPath = getRootPath();//项目根路径
			$('#table_id').DataTable(
			{
				autoWidth : false,
				scrollY : 500,
				pagingType: "simple_numbers",//设置分页控件的模式  
				// paging : false,//分页
		//		searching : false,
		//		info : false,// 左下角信息
		//		ordering: false,//排序
				lengthMenu:[[5,10,25,50,-1],[5,10,25,50,"全部"]],
		//		aaSorting : [ [ 16, "desc" ] ],// 默认第几个排序
				colReorder : false,
				scrollX : true,
				sScrollX : "100%",
				sScrollXInner : "100%",
				bScrollCollapse : true,  
				processing: true, //打开数据加载时的等待效果  
		        serverSide: true,//打开后台分页  
		        ajax: {  
		            "url": appPath + "/coop/list.do",   
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
		                  { title:"最新动态id","data": "id" },
		                  { title:"添加时间","data": "createTime" },
		                  { title:"标题","data": "title" },  
		                  { title:"内容","data": "content" },  
		                  { title:"状态","data": "statu", 
		                	  "mRender": function (data, type, full) {
		                		 if (data == 0) {
		                			 return "<font color='red'>无效</font>";
		                		 }else if (data == 1){
		                			 return "有效";
		                		 }
		                	  } 
		                  },  
		                  { title:"最后一次管理员操作","data": "adminName" },  
		                  { title:"操作","data": "deptStatu",
		                  	"mRender": function (data, type, full) {
		                		  return "<a onclick=\"openNews();\" href=\"javascript:void(0);\">启用</a>" + "<a onclick=\"ofNews();\" href=\"javascript:void(0);\">停用</a>";
		                	  } 
		                  }
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
		 var table = $('#table_id').DataTable();
		//设置选中change颜色
		 $('#table_id tbody').on( 'click', 'tr', function () {
		        $(this).toggleClass('selected');
		  });
		});
		/** 添加最新动态 **/
		//验证
		$(function () {
			var appPath = getRootPath();//项目根路径
			//验证
			validform5("layui-layer-btn0","savePartner",true,"3");
			$(".obtn-pic-add").on("click touchstart",function(){
				//初始化
				var ue1 = UE.getEditor('fileList');
				layer.open({
				    type: 1,
				    area: ['1100px', '600px'], //高宽
				    title: "添加合作伙伴",
				    content: $(".pic-add"),//DOM或内容
				    btn:['确定', '取消']
					  ,yes: function(index, layero){ //或者使用btn1
					    //确定的回调
					  	$("#savePartner").submit();
					  	
					  },cancel: function(index){//或者使用btn2（concel）
					  	//取消的回调
					  }
				});
			});
			
		}); 
		//添加方法
		function addPartner() {
			var appPath = getRootPath();//项目根路径
			//获取ueditor内容
			var ue1 = UE.getEditor('editor');
			var content = ue1.getContent();
			
			var title = $("#title").val();
			$.ajax( {  
				url:appPath+"/coop/save.do",
				data:"title=" + title + "&content=" + content,
				type:'post',  
				cache:false,  
				success:function(data) { 
					if (data == 1) {
						layer.alert("添加成功",{icon:1});  
						document.getElementById("savePartner").reset();
						setTimeout('location.reload()',2000);
					}else {
						layer.alert("服务器异常",{icon:2});
						document.getElementById("savePartner").reset();
					}
				}
				
			});
		}
	</script>
	<script type="text/javascript" src="js/frontconfig/frontconfig.js"></script>
</body>

</html>