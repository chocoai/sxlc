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
	<title>配置中心--财务配置</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link href="css/config.css" rel="stylesheet" />
</head>
<!-- 配置中心-------------------财务设置   债权转让手续费设置-->
<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="6" name="top_menu_index"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-config.jsp">
				<jsp:param value="config-0" name="config-index" />
			</jsp:include>
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
					 	
			 	<!-- 债权转让设置手续费设置 -->
			 	<div class="config">
			 		<fieldset>
			 			<legend>债权转让设置手续费设置</legend>
			 			<form class="form-horizontal" role="form" name="" action="" id="">
			 				<div class="form-group">
			 					<label for="holdDay" class="col3 i-fl control-label">债权持有时间大于：</label>
			 					<div class="i-fl">
			 						<input type="text"  class="form-control" id="holdDay" value="${creditorEntity.holdDay}" placeholder="债权持有时间大于">
			 					</div>
			 					<div class="i-fl">
									<span class="sign i-fl">天<i>*</i></span>
								</div>
								<div class="input-alert">
									<span></span>
								</div>
			 				</div>
			 				<div class="form-group">
			 					<label for="rangeDay" class="i-fl control-label col3">债权距到期时间大于：</label>
			 					<div class="i-fl">
			 						<input type="text"  class="form-control" value="${creditorEntity.rangeDay}" id="rangeDay" placeholder="债权距到期时间大于">
			 					</div>
			 					<div class="i-fl">
									<span class="sign i-fl">天<i>*</i></span>
								</div>
								<div class="input-alert">
									<span></span>
								</div>
			 				</div>
			 				<div class="form-group">
			 					<label for="interestDay" class="col3 i-fl control-label">债权日在还款日前：</label>
			 					<div class="i-fl">
			 						<input type="text"  class="form-control" value="${creditorEntity.interestDay}" id="interestDay" placeholder="债权日在还款日前">
			 					</div>
			 					<div class="i-fl">
									<span class="sign i-fl">天<i>*</i></span>
								</div>
								<div class="input-alert">
									<span></span>
								</div>
			 				</div>
			 				<div class="form-group">
			 					<label for="mngFee" class="i-fl control-label col3">债权转让手续费费率：</label>
			 					<div class="i-fl">
			 						<input type="text"  class="form-control" value="${creditorEntity.mngFee}" id="mngFee" placeholder="债权转让手续费费率">
			 					</div>
			 					<div class="i-fl">
									<span class="sign i-fl">%<i>*</i></span>
								</div>
								<div class="input-alert">
									<span></span>
								</div>
			 				</div>
			 				<div class="form-group">
			 					<input type="hidden" id="mngType" value="${creditorEntity.mngType}">
			 					<label for="lastname" class="i-fl control-label col3">债权转让手续费收取方向：</label>
			 					<div class="i-fl">
				 					<label class="checkbox-inline">
				 						<input type="radio" name="mngType" id="optionsRadios1" value="0"> 转让人
				 					</label>
				 					<label class="checkbox-inline">
				 						<input type="radio" name="mngType" id="optionsRadios2" value="1"> 购买人
				 					</label>
				 					<label class="checkbox-inline">
				 						<input type="radio" name="mngType" id="optionsRadios2" value="2" > 全部
				 					</label>
				 				</div>
			 				</div>
			 				<div class="form-group">
			 					<div class="offset-col3">
			 						<button type="button" id="saveBtn" onclick="submitBtn(0)" class="btn btn-default">保存</button>
			 					</div>
			 				</div>
			 			</form>		
			 		</fieldset>
			 		<fieldset>
			 			<legend>债权转让审核是否需要审核</legend>
			 			<form class="form-horizontal" role="form" name="" action="" id="">
			 				<div class="form-group">
			 					<input type="hidden" id="checkType" value="${creditorEntity.checkType}">
			 					<label for="lastname" class="i-fl control-label col3">债权转让审核是否需要审核：</label>
				 				<div class="i-fl">
				 					<label class="checkbox-inline">
				 						<input type="radio" name="checkType" id="optionsRadios1" value="1"> 是
				 					</label>
				 					<label class="checkbox-inline">
				 						<input type="radio" name="checkType" id="optionsRadios2" value="0" > 否
				 					</label>
				 				</div>
				 				<div class="radio-alert">
				 					<span></span>
				 				</div>
			 				</div>
			 				<div class="form-group">
			 					<div class="offset-col3">
			 						<button type="button" onclick="submitBtn(1)" class="btn btn-default">保存</button>
			 					</div>
			 				</div>
			 			</form>		
			 		</fieldset>
			 		<fieldset>
			 			<legend>债权转让放款是否需要手动放款</legend>
			 			<form class="form-horizontal" role="form" name="" action="" id="">
			 				<div class="form-group">
			 					<input type="hidden" id="loanType" value="${creditorEntity.loanType}">
			 					<label for="lastname" class="i-fl control-label col3">债权转让放款是否需要手动放款：</label>
			 					<div class="i-fl">
				 					<label class="checkbox-inline">
				 						<input type="radio" name="loanType" id="optionsRadios1" value="1"> 是
				 					</label>
				 					<label class="checkbox-inline">
				 						<input type="radio" name="loanType" id="optionsRadios2" value="0" > 否
				 					</label>
				 				</div>
				 				<div class="i-fl">
				 					<span class="radio-alert"></span>
				 				</div>
			 				</div>
			 				<div class="form-group">
			 					<div class="offset-col3">
			 						<button type="button" onclick="submitBtn(2)" class="btn btn-default">保存</button>
			 					</div>
			 				</div>
			 			</form>		
			 		</fieldset>
			 		<fieldset>
			 			<legend>债权转让利息生成方式</legend>
			 			<form class="form-horizontal" role="form" name="" action="" id="">
			 				<div class="form-group">
			 					<input type="hidden" id="interestType" value="${creditorEntity.interestType}">
			 					<label for="lastname" class="i-fl control-label col3">债权转让利息生成方式：</label>
				 				<div class="i-fl">
				 					<label class="checkbox-inline">
				 						<input type="radio" name="interestType" id="optionsRadios1" value="0"> 按期分配
				 					</label>
				 					<label class="checkbox-inline">
				 						<input type="radio" name="interestType" id="optionsRadios2" value="1" > 按实际转让时间分配
				 					</label>
				 				</div>
				 				<div class="i-fl">
				 					<span class="radio-alert"></span>
				 				</div>
			 				</div>
			 				<div class="form-group">
			 					<div class="offset-col3">
			 						<button type="button" onclick="submitBtn(3)" class="btn btn-default">保存</button>
			 					</div>
			 				</div>
			 			</form>		
			 		</fieldset>
			 	</div>
			 </div>
		</div>
	</div>
		
	<!-- 尾部 -->
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<!-- 私用js -->
	<script type="text/javascript">
			//加密设置
			var encrypt = new JSEncrypt();
			encrypt.setPublicKey(publicKey_common);
			
			//页面初始化
			$(function(){
				var mngType = $("#mngType").val();
				var checkType = $("#checkType").val();
				var loanType = $("#loanType").val();
				var interestType = $("#interestType").val();
				$("input[name='mngType'][value="+mngType+"]").attr('checked','true');
				$("input[name='checkType'][value="+checkType+"]").attr('checked','true');
				$("input[name='loanType'][value="+loanType+"]").attr('checked','true');
				$("input[name='interestType'][value="+interestType+"]").attr('checked','true');
				
				//天数有有效性检验
				$(".form-control").on("change",function(){
					var $this = $(this);
				    var reg = new RegExp("^[1-9][0-9]{0,2}$");  
					var value = $this.val();
				    if(!reg.test(value)){  
				    	$this.parent().nextAll(".input-alert").html("请输入3位数的正整数");
				    	$("#saveBtn").attr("disabled",true);
				    }else{
				    	$this.parent().nextAll(".input-alert").html("");
				    	$("#saveBtn").attr("disabled",false);
				    }
				});
				// 费率检验
				$("#mngFee").on("change",function(){
					var $this = $(this);
				    var reg = new RegExp("^(\\d|[1-9]\\d|100)$");  
					var value = $this.val();
				    if(!reg.test(value)){  
				    	$("#saveBtn").attr("disabled",true);
				    	$this.parent().nextAll(".input-alert").html("请输入0-100的整数");
				    }else{
				    	$this.parent().nextAll(".input-alert").html("");
				    	$("#saveBtn").attr("disabled",false);
				    }
				});
			});
	
			//保存按钮
			function submitBtn(type){
					var data;//参数对象
					if(type==0){
						var holdDay =$("#holdDay").val();
						var rangeDay =$("#rangeDay").val();
						var interestDay =$("#interestDay").val();
						var mngFee =$("#mngFee").val();
						var mngType =$("input[name='mngType']:checked").val();
						data = {"holdDay":encrypt.encrypt(holdDay),"rangeDay":encrypt.encrypt(rangeDay),
								"interestDay":encrypt.encrypt(interestDay),"mngFee":encrypt.encrypt(mngFee),
								"mngType":encrypt.encrypt(mngType),"type":encrypt.encrypt(""+type)};
					}else if(type==1){
						var checkType = $("input[name='checkType']:checked").val();
						data={"type":encrypt.encrypt(""+type),"checkType":encrypt.encrypt(checkType)};
					}else if(type==2){
						var loanType = $("input[name='loanType']:checked").val();
						data={"type":encrypt.encrypt(""+type),"loanType":encrypt.encrypt(loanType)};
					}else if(type==3){
						var interestType = $("input[name='interestType']:checked").val();
						data={"type":encrypt.encrypt(""+type),"interestType":encrypt.encrypt(interestType)};
					}
					
					$.ajax( {  
						url:appPath+"/config/addCreditor.do",
						data:data,
						type:'post',  
						cache:false,  
						dataType:'json',  
						success:function(data) { 
							if(data > 0){
								layer.alert("操作成功",{icon:1});
							}else if(data==0){
								layer.alert("操作失败",{icon:2});  
							}
						},  
						error : function() {  
							layer.alert("服务器异常",{icon:2});  
						}  
					});
			};
	
	</script>
	
	
</body>

</html>