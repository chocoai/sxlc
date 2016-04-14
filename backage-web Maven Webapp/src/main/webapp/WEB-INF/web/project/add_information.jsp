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
	<title>项目管理</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link rel="stylesheet" href="plugs/webuploader/0.1.5/webuploader.css" />
	<link rel="stylesheet" href="css/upload.css" />
	<link href="css/project/myLayer.css" rel="stylesheet" />
</head>
<body>
	<div class="container add_type_contianer">
		<div class="w-content">
			<table>
				<tr>
					<td class="tt"><label>借款金额：</label></td>
					<td class="con">
						<span></span>
					</td>
				</tr>
				<tr>
					<td class="tt"><label>还款保障：</label></td>
					<td class="con">
						<span></span>
					</td>
				</tr>
				<tr>
					<td class="tt"><label>借款项目类型：</label></td>
					<td class="con">
						<span></span>
					</td>
				</tr>
				<tr>
					<td class="tt"><label>借款期限：</label></td>
					<td class="con">
						<span></span>
					</td>
				</tr>
				<tr>
					<td class="tt"><label>还款来源：</label></td>
					<td class="con">
						<span></span>
					</td>
				</tr>
				<tr>
					<td class="tt"><label>借款用途：</label></td>
					<td class="con">
						<span></span>
					</td>
				</tr>
				<tr>
					<td class="tt"><label>抵押物描述：</label></td>
					<td class="con">
						<span></span>
					</td>
				</tr>
				<tr>
					<td class="tt"><label>抵押物描述：</label></td>
					<td class="con">
						<ul class="loanproduct">
							<li>
								<div>认证项目</div>
								<div>状态</div>
								<div>认证状态</div>
							</li>
							<li>
								<div>工作认证</div>
								<div>?</div>
								<div>?</div>
							</li>
							<li>
								<div>婚姻认证</div>
								<div>?</div>
								<div>?</div>
							</li>
							<li>
								<div>信用报告</div>
								<div>?</div>
								<div>?</div>
							</li>
						</ul>
					</td>
				</tr>
			</table>
		</div>
		<div class="w-content">
			<table>
				<tr>
					<td class="tt"><label class="ineed">借款项目名称：</label></td>
					<td class="con">
						<input type="text" class="" placeholder="借款项目名称" value="" />
					</td>
				</tr>
				<tr>
					<td class="tt"><label class="ineed">借款金额：</label></td>
					<td class="con">
						<input type="text" class="" placeholder="借款金额" value="" />
					</td>
				</tr>
				<tr>
					<td class="tt"><label>还款方式：</label></td>
					<td class="con">
						<input type="radio" name="payway" class="" value="1"/> 等额本金
						<input type="radio" name="payway" class="" value="2"/> 等额本息
						<input type="radio" name="payway" class="" value="3"/> 先息后本
						<input type="radio" name="payway" class="" value="4"/> 到期还本息
					</td>
				</tr>
				<tr>
					<td class="tt"><label class="ineed">还款保障：</label></td>
					<td class="con">
						<input type="text" class="" placeholder="还款保障" value="" />
					</td>
				</tr>
				<tr>
					<td class="tt"><label class="ineed">借款用途：</label></td>
					<td class="con">
						<input type="text" class="" placeholder="借款用途" value="" />
					</td>
				</tr>
				<tr>
					<td class="tt"><label class="ineed">还款来源：</label></td>
					<td class="con">
						<input type="text" class="" placeholder="还款来源" value="" />
					</td>
				</tr>
				<tr>
					<td class="tt"><label class="ineed">借款期限：</label></td>
					<td class="con">
						<input type="text" class="" placeholder="借款期限" value="" />
						<select>
							<option>时长</option>
							<option>天</option>
							<option>月</option>
						</select>
					</td>
				</tr>
				<tr>
					<td class="tt"><label class="ineed">设置最大投资比例：</label></td>
					<td class="con">
						<input type="text" class="" placeholder="设置最大投资比例" value="" />
					</td>
				</tr>
				<tr>
					<td class="tt"><label class="ineed">年化利率：</label></td>
					<td class="con">
						<input type="text" class="" placeholder="年化利率" value="" />
					</td>
				</tr>
				<tr>
					<td class="tt"><label class="ineed">起投金额：</label></td>
					<td class="con">
						<input type="text" class="" placeholder="起投金额" value="" />
					</td>
				</tr>
				<tr>
					<td class="tt"><label class="ineed">加价幅度：</label></td>
					<td class="con">
						<input type="text" class="" placeholder="加价幅度" value="" />
					</td>
				</tr>
				<tr>
					<td class="tt"><label>项目描述：</label></td>
					<td class="con">
						<script id="prointro" type="text/plain" style="height:260px;width:98%;"></script>
					</td>
				</tr>
				<tr class="protype">     <!-- 如果是抵押贷，此行才显示 -->
					<td class="tt"><label>抵押物信息：</label></td>
					<td class="con">
						<script id="pawnmsg" type="text/plain" style="height:260px;width:98%;"></script>
					</td>
				</tr>
				<tr>
					<td class="tt"><label>项目申请附件信息：</label></td>
					<td class="con">
						<div id="logo">
							<select class="doc">
								<option>附件类型</option>
								<option>借款方信息</option>
								<option>抵押信息</option>
								<option>现场调查信息</option>
								<option>其它</option>
							</select>
						    <!--用来存放item-->
						    <div id="filePicker">上传附件</div>
						    <span class="rec-dimensions">*可图片、文档、压缩包</span>
						</div>
					</td>
				</tr>
				<tr>
					<td class="tt"><label>附件标题：</label></td>
					<td class="con">
						<input type="text" class="" placeholder="附件标题" value="" />
					</td>
				</tr>
				<tr>
					<td class="tt"><label>自动投标设置：</label></td>
					<td class="con">
						<div class="autobid">
							<span>投标开始后</span>
							<input type="text" class="" placeholder="N分钟" value="" />
							<span>分钟开始执行自动投标，自动投标总金额占比</span>
							<input type="text" class="" placeholder="x%" value="" />
						</div>
					</td>
				</tr>
				<tr>
					<!-- 可选项信息不完整 -->
					<td class="tt"><label>可选择项：</label></td>
					<td class="con">
						<ul class="options">
							<li>
								<div>
									<input type="radio" name="addinterest" class="" value="是"/> 是
									<input type="radio" name="addinterest" class="" value="否"/> 否
								</div>
								<div class="set">
									<label>添加利息：</label>
									<input type="text" class="" placeholder="N%" value="" />
								</div>
							</li>
						</ul>
					</td>
				</tr>
				<tr>
					<td class="tt"><label></label></td>
					<td class="con">
						<button type="submit" class="btn btn-success">提交到借款申请</button>
						<button type="button" class="btn btn-success">保存</button>
					</td>
				</tr>
			</table>
		</div>
	</div>
    <!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<script type="text/javascript" src="plugs/webuploader/0.1.5/webuploader.js"></script>
	<script type="text/javascript" src="js/project/loanapply-upload.js"></script>
	<script type="text/javascript" src="plugs/ueditor/ueditor.config.js"></script>
	<script type="text/javascript" src="plugs/ueditor/ueditor.all.min.js"></script>
	<!-- 私用js -->
	<script type="text/javascript">
		var pi = UE.getEditor('prointro');
		var pm = UE.getEditor('pawnmsg');
	</script>
</body>

</html>