
$(function(){
	/*验证*/
	validform5("layui-layer-btn0","saveNotice",true,"3");
	//分配理财顾问
	$('#pro_allocation').on('click', function(){
		layer.open({
			  type: 1,
			  title:'理财顾问分配',
			  //skin: 'layui-layer-rim', //加上边框
			  area: ['320px', '200px'], //宽高
			  content: '<div class="allocation">'+
						  '<div class="form-group">'+
								'<label>请选择理财顾问：</label>'+
								'<select>'+
									'<option>顾问1</option>'+
									'<option>顾问2</option>'+
									'<option>顾问3</option>'+
									'<option>顾问4</option>'+
								'</select>'+
							'</div>'+
							'<div class="form-group">'+
								'<button type="submit" class="btn btn-success select">提交</button>'+
							'</div>'+
						'</div>'
			});
	});
	
	
	//补充资料弹出层
	$('#add_information').on('click', function(){
	    layer.open({
	        type: 2,
	        title: '补充资料',
	        maxmin: true,
	        shadeClose: true, //点击遮罩关闭层
	        area : ['980px' , '620px'],
	        content: 'web/project/add_information.jsp'
	    });
	});
	//添加到借款申请
	//$('#add_loan_apply').on('click', function(){});
	
	
	
	//借款会员拉黑
	$("#loan_member_black").on("click",function(){
		prompt("请输入拉黑原因？");
	});
	
	//查看审批记录
	$('#loan_exam_record').on('click', function(){
	    layer.open({
	        type: 2,
	        title: '查看审批记录',
	        maxmin: true,
	        shadeClose: true, //点击遮罩关闭层
	        area : ['800px' , '520px'],
	        content: 'web/project/loan_exam_record.jsp'
	    });
	});
	
	
	
	//查看借款项目详情
	$('#loan_detail').on('click', function(){
	    layer.open({
	        type: 2,
	        title: '借款项目详情',
	        maxmin: true,
	        shadeClose: true, //点击遮罩关闭层
	        area : ['620px' , '500px'],
	        content: 'web/project/loan_pro_detail.jsp'
	    });
	});
	
	//拒绝借款
	$('#refuse_payment').on('click', function(){
		layer.confirm('确定拒绝借款？', {
			  btn: ['确定','取消'] //按钮
			}, function(){
			  layer.msg('已拒绝', {icon: 1});
			});
	});
});
