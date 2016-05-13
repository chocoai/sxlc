$(function(){
	$(".TE").addClass("down");
	$(".TE1").addClass("down2");
	/*弹出层*/	
	/*待确认——查看详情*/
	/*$('.viewDetails').on('click', function(){
		layer.open({
			title :'项目基本信息',//标题
			skin: 'layer-ext-myskin',//皮肤
	        type: 1,
	        area: ['440px', '580px'],//大小宽*高
	        shadeClose: true, //点击遮罩关闭
	        content: $('.view-details')//内容，里边是包含内容的div的class
	    });
	});*/
	/*待确认——发布待确认，提交审核待确认*/
	/*$('.toConfirm').on('click', function(){
		layer.open({
			title :'项目基本信息',//标题
			skin: 'layer-ext-myskin',//皮肤
	        type: 1,
	        area: ['440px', '620px'],//大小宽*高
	        shadeClose: true, //点击遮罩关闭
	        content: $('.to-confirm')//内容，里边是包含内容的div的class
	    });
	});*/
	/*借款记录-融资中-投资记录*/
	/*$('.invRecord').on('click', function(){
		layer.open({
			title :'查看投资记录',//标题
			skin: 'layer-ext-myskin',//皮肤
	        type: 1,
	        area: ['645px', '470px'],//大小宽*高
	        shadeClose: true, //点击遮罩关闭
	        content: $('.inv-record')//内容，里边是包含内容的div的class
	    });
	});*/
	/*借款记录-融资中-投资记录*/
	/*$('.repay').on('click', function(){
		layer.open({
			title :'还款',//标题
			skin: 'layer-ext-myskin',//皮肤
	        type: 1,
	        area: ['525px', '670px'],//大小宽*高
	        shadeClose: true, //点击遮罩关闭
	        content: $('.repay-content')//内容，里边是包含内容的div的class
	    });
	});*/
	/*提前还款*/
	/*$('.early-repay').on('click', function(){
		layer.open({
			title :'提前还款',//标题
			skin: 'layer-ext-myskin',//皮肤
	        type: 1,
	        area: ['540px', '500px'],//大小宽*高
	        shadeClose: true, //点击遮罩关闭
	        content: $('.early-repay-content')//内容，里边是包含内容的div的class
	    });
	});*/
});


//function
//我的账户-借款管理-我的借款：融资中、融资结束、还款中、已流标、已结清
//我的账户-借款管理-我的借款：融资中

var noData = '<li class="data-item noData"><div>暂无数据！</div></li>';

function getFinancing(curr,length){
	$.ajax({
		url:"loanManagement/financing.html",
		data:{
			"start": curr || 1,		//当前页
			"length":length || 1	//每页条数为预留数据，后台有默认值
		},
		type:"get",
		dataType:"json",
		timeout:10000,
		success:function(data){
			//console.log(data);
			if(data.results.length > 0){
				$(".my-loan-table .data-item").remove();
				creatFinancing(data);
				/*creatFinancing(data);//拼接数据
				laypage({//分页
				    cont: $("#pager-financing"),//容器。值支持id名、原生dom对象，jquery对象。【如该容器为】：<div id="page1"></div>
				    curr:data.pageNum,//初始化当前页			连续分页必须参数
				    pages: data.totalPage,//通过后台拿到的总页数	连续分页必须参数
					first: false,
				    last: false,
				    prev: "&lt;",
				    next: "&gt;",
				    skip: true, //是否开启跳页
				    skin: '#72c0f3',
				    groups: 5, //连续显示分页数
				    jump: function(obj,first){
				    	if(!first){ //点击跳页触发函数自身，并传递当前页：obj.curr
		                    getFinancing(obj.curr);
		                }
				    }
				});*/
				
				pager.generPageHtml({
					pno: data.pageNum,					//当前页
					total: data.totalPage,				//总页码
					totalRecords: data.recordsTotal,	//总数据条数
					mode: 'click', //默认值是link，可选link或者click
					click: function(n) {
						getFinancing(n,length);
						this.selectPage(n);
						return false;
					}
				});
			}else{
				$(".my-loan-table").append(noData);
			}
		},
		error:function(){
			layer.alert("请求异常，请稍后再试",{icon:2});
		}
	});
}

//拼接代码-融资中
function creatFinancing(data){
	var _html = "";
	if(data.results.length != 0){
		//$(".my-loan-table .data-item").remove();
		for(var i=0;i<data.results.length;i++){
			_html+='<li class="data-item">'+
					'<div class="contentOut3">'+
						'<div class="c-content" title="'+data.results[i].projectNo+'">'+data.results[i].projectNo+'</div>'+
					'</div>'+
					'<div class="contentOut3">'+
						'<div class="c-content" title="'+data.results[i].projectName+'">'+data.results[i].projectName+'</div>'+
					'</div>'+
					'<div class="contentOut3">'+
						'<div class="c-content" title="'+data.results[i].projectTypeName+'">'+data.results[i].projectTypeName+'</div>'+
					'</div>'+
					'<div class="contentOut3">'+
						'<div class="c-content">'+data.results[i].deadline;
						if(data.results[i].projectType != ""){
							if(data.results[i].projectType == 0){//天标
								_html+="天";
							}else if(data.results[i].projectType == 1){//月标
								_html+="个月";
							}else if(data.results[i].projectType == 2){//年标
								_html+="年";
							}
						}
					_html+='</div>'+
					'</div>'+
					'<div class="contentOut3">'+
						'<div class="c-content" title="'+data.results[i].sAmount+'">'+data.results[i].sAmount+'</div>'+
					'</div>'+
					'<div class="contentOut4">'+
						'<div class="c-content" title="'+data.results[i].sYearRate+'%">'+data.results[i].sYearRate+'%</div>'+
					'</div>'+
					'<div class="contentOut4">'+
						'<div class="c-content" title="'+data.results[i].releaseTime+'">'+data.results[i].releaseTime+'</div>'+
					'</div>'+
					'<div class="contentOut4">'+
						'<div class="c-content">'+data.results[i].startTime+'<br>--<br>'+data.results[i].endTime+'</div>'+
					'</div>'+
					'<div class="contentOut4">'+
						'<div class="c-content" title="'+data.results[i].sInvestRate+'">'+data.results[i].sInvestRate+'<br><span class="invRecord" data-loanId="'+data.results[i].loanId+'">投资记录</span></div>'+
					'</div>'+
				'</li>';
		}
	}else{
		_html+='<li class="data-item noData"><div>暂无数据！</div></li>';
	}
	//赋值
	$(".my-loan-table").append(_html);
	//绑定查看投资记录详情
	getInvestRecord();
}

//我的账户-借款管理-我的借款：融资结束
function getFinanced(curr,length){
	$.ajax({
		url:"loanManagement/financed.html",
		data:{
			"start": curr || 1,		//当前页
			"length":length || 1	//每页条数为预留数据，后台有默认值
		},
		type:"get",
		dataType:"json",
		timeout:10000,
		success:function(data){
			$(".my-loan-table .data-item").remove();
			if(data.results.length > 0){
				creatFinanced(data);//拼接数据
				/*creatFinanced(data);//拼接数据
				laypage({//分页
				    cont: $("#pager-financed"),//容器。值支持id名、原生dom对象，jquery对象。【如该容器为】：<div id="page1"></div>
				    curr:data.pageNum,//初始化当前页			连续分页必须参数
				    pages: data.totalPage,//通过后台拿到的总页数	连续分页必须参数
					first: false,
				    last: false,
				    prev: "&lt;",
				    next: "&gt;",
				    skip: true, //是否开启跳页
				    skin: '#72c0f3',
				    groups: 5, //连续显示分页数
				    jump: function(obj,first){
				    	if(!first){ //点击跳页触发函数自身，并传递当前页：obj.curr
		                    getFinanced(obj.curr);
		                }
				    }
				});*/
				
				pager.generPageHtml({
					pno: data.pageNum,					//当前页
					total: data.totalPage,				//总页码
					totalRecords: data.recordsTotal,	//总数据条数
					mode: 'click', //默认值是link，可选link或者click
					click: function(n) {
						getFinanced(n,length);
						this.selectPage(n);
						return false;
					}
				});
			}else{
				$(".my-loan-table").append(noData);
			}
		},
		error:function(){
			layer.alert("请求异常，请稍后再试",{icon:2});
		}
	});
}

//拼接代码-融资结束
function creatFinanced(data){
	var _html = "";
	if(data.results.length != 0){
		//$(".my-loan-table .data-item").remove();
		for(var i=0;i<data.results.length;i++){
			_html+='<li class="data-item">'+
					'<div class="contentOut3 w79">'+
						'<div class="c-content" title="'+data.results[i].projectNo+'">'+data.results[i].projectNo+'</div>'+
					'</div>'+
					'<div class="contentOut3 w79">'+
						'<div class="c-content" title="'+data.results[i].projectName+'">'+data.results[i].projectName+'</div>'+
					'</div>'+
					'<div class="contentOut3 w79">'+
						'<div class="c-content" title="'+data.results[i].projectTypeName+'">'+data.results[i].projectTypeName+'</div>'+
					'</div>'+
					'<div class="contentOut3 w79">'+
						'<div class="c-content">'+data.results[i].deadline;
						if(data.results[i].projectType != ""){
							if(data.results[i].projectType == 0){//天标
								_html+="天";
							}else if(data.results[i].projectType == 1){//月标
								_html+="个月";
							}else if(data.results[i].projectType == 2){//年标
								_html+="年";
							}
						}
					_html+='</div>'+
					'</div>'+
					'<div class="contentOut3 w79">'+
						'<div class="c-content" title="'+data.results[i].sAmount+'">'+data.results[i].sAmount+'</div>'+
					'</div>'+
					'<div class="contentOut4 w88">'+
						'<div class="c-content" title="'+data.results[i].sYearRate+'%">'+data.results[i].sYearRate+'%</div>'+
					'</div>'+
					'<div class="contentOut4">'+
						'<div class="c-content" title="'+data.results[i].releaseTime+'">'+data.results[i].releaseTime+'</div>'+
					'</div>'+
					'<div class="contentOut4">'+
						'<div class="c-content">'+data.results[i].startTime+'<br>--<br>'+data.results[i].endTime+'</div>'+
					'</div>'+
					'<div class="contentOut4 w88">'+
						'<div class="c-content" title="'+data.results[i].sInvestRate+'">'+data.results[i].sInvestRate+'<br><span class="invRecord" data-loanId="'+data.results[i].loanId+'">投资记录</span></div>'+
					'</div>'+
					'<div class="contentOut4 w88">'+
						'<div class="c-content" title="'+data.results[i].realEndDate+'">'+data.results[i].realEndDate+'</div>'+
					'</div>'+
				'</li>';
		}
	}else{
		_html+='<li class="data-item noData"><div>暂无数据！</div></li>';
	}
	//赋值
	$(".my-loan-table").append(_html);
	//绑定查看投资记录详情
	getInvestRecord();
}


//我的账户-借款管理-我的借款：还款中
function getRepay(curr,length){
	$.ajax({
		url:"loanManagement/RepaymentIn.html",
		data:{
			"start": curr || 1,		//当前页
			"length":length || 1	//每页条数为预留数据，后台有默认值
		},
		type:"get",
		dataType:"json",
		timeout:10000,
		success:function(data){
			$(".my-loan-table .data-item").remove();
			if(data.results.length > 0){
				creatRepay(data);//拼接数据
				/*creatRepay(data);//拼接数据
				laypage({//分页
				    cont: $("#pager"),//容器。值支持id名、原生dom对象，jquery对象。【如该容器为】：<div id="page1"></div>
				    curr:data.pageNum,//初始化当前页			连续分页必须参数
				    pages: data.totalPage,//通过后台拿到的总页数	连续分页必须参数
					first: false,
				    last: false,
				    prev: "&lt;",
				    next: "&gt;",
				    skip: true, //是否开启跳页
				    skin: '#72c0f3',
				    groups: 5, //连续显示分页数
				    jump: function(obj,first){
				    	if(!first){ //点击跳页触发函数自身，并传递当前页：obj.curr
		                    getRepay(obj.curr);
		                }
				    }
				});*/
				
				pager.generPageHtml({
					pno: data.pageNum,					//当前页
					total: data.totalPage,				//总页码
					totalRecords: data.recordsTotal,	//总数据条数
					mode: 'click', //默认值是link，可选link或者click
					click: function(n) {
						getRepay(n,length);
						this.selectPage(n);
						return false;
					}
				});
			}else{
				$(".my-loan-table").append(noData);
			}
		},
		error:function(){
			layer.alert("请求异常，请稍后再试",{icon:2});
		}
	});
}

//拼接代码-还款中
function creatRepay(data){
	var _html = "";
	if(data.results.length != 0){
		//$(".my-loan-table .data-item").remove();
		for(var i=0;i<data.results.length;i++){
			_html+='<li class="data-item">'+
					'<div class="contentOut1 w70">'+
						'<div class="c-content" title="'+data.results[i].projectNo+'">'+data.results[i].projectNo+'</div>'+
					'</div>'+
					'<div class="contentOut1 w70">'+
						'<div class="c-content" title="'+data.results[i].projectName+'">'+data.results[i].projectName+'</div>'+
					'</div>'+
					'<div class="contentOut1 w70">'+
						'<div class="c-content" title="'+data.results[i].sAmount+'">'+data.results[i].sAmount+'</div>'+
					'</div>'+
					'<div class="contentOut2 w79">'+
						'<div class="c-content" title="'+data.results[i].sSjAmount+'">'+data.results[i].sSjAmount+'</div>'+
					'</div>'+
					'<div class="contentOut1 w70">'+
						'<div class="c-content" title="'+data.results[i].sYearRate+'">'+data.results[i].sYearRate+'%</div>'+
					'</div>'+
					'<div class="contentOut1 w70">'+
						'<div class="c-content">'+data.results[i].endTime+'</div>'+
					'</div>'+
					'<div class="contentOut1 w70">'+
						'<div class="c-content">'+data.results[i].startTime+'</div>'+
					'</div>'+
					'<div class="contentOut3 w88">'+
						'<div class="c-content">'+data.results[i].sReturnedRrincipal+'/'+data.results[i].sInterestPaid+'</div>'+
					'</div>'+
					'<div class="contentOut4 w110">'+
						'<div class="c-content">'+data.results[i].releaseTime+'</div>'+
					'</div>'+
					'<div class="contentOut4 w110">'+
						'<div class="c-content">'+data.results[i].sNextTeturnedRrincipal+'/'+data.results[i].sNextInterestPaid+'</div>'+
					'</div>'+
					'<div class="contentOut1 w70">'+
						'<div class="c-content">'+
							'<a href="loanManagement/repayPlan.html?projectId='+data.results[i].projectId+'">还款计划</a><br>'+
							'<a href="" class="loan-agreement">借款协议</a><!--跳转未知  -->'+
						'</div>'+
					'</div>'+
				'</li>';
		}
	}else{
		_html+='<li class="data-item noData"><div>暂无数据！</div></li>';
	}
	//赋值
	$(".my-loan-table").append(_html);
}


//我的账户-借款管理-我的借款：已流标
function getFailure(curr,length){
	$.ajax({
		url:"loanManagement/flowLabelS.html",
		data:{
			"start": curr || 1,		//当前页
			"length":length || 1	//每页条数为预留数据，后台有默认值
		},
		type:"get",
		dataType:"json",
		timeout:10000,
		success:function(data){
			//console.log(data);
			$(".my-loan-table .data-item").remove();
			if(data.results.length > 0){
				creatFailure(data);//拼接数据
				/*laypage({//分页
				    cont: $("#pager"),//容器。值支持id名、原生dom对象，jquery对象。【如该容器为】：<div id="page1"></div>
				    curr:data.pageNum,//初始化当前页			连续分页必须参数
				    pages: data.totalPage,//通过后台拿到的总页数	连续分页必须参数
					first: false,
				    last: false,
				    prev: "&lt;",
				    next: "&gt;",
				    skip: true, //是否开启跳页
				    skin: '#72c0f3',
				    groups: 5, //连续显示分页数
				    jump: function(obj,first){
				    	if(!first){ //点击跳页触发函数自身，并传递当前页：obj.curr
		                    getFailure(obj.curr);
		                }
				    }
				});*/
				pager.generPageHtml({
					pno: data.pageNum,					//当前页
					total: data.totalPage,				//总页码
					totalRecords: data.recordsTotal,	//总数据条数
					mode: 'click', //默认值是link，可选link或者click
					click: function(n) {
						getFailure(n,length);
						this.selectPage(n);
						return false;
					}
				});
				
			}else{
				$(".my-loan-table").append(noData);
			}
		},
		error:function(){
			layer.alert("请求异常，请稍后再试",{icon:2});
		}
	});
}

//拼接代码-已流标
function creatFailure(data){
	var _html = "";
	if(data.results.length != 0){
		//$(".my-loan-table .data-item").remove();
		for(var i=0;i<data.results.length;i++){
			_html+='<li class="data-item">'+
					'<div class="contentOut1">'+
						'<div class="c-content" title="'+data.results[i].projectNo+'">'+data.results[i].projectNo+'XMBH-00000001</div>'+
					'</div>'+
					'<div class="contentOut1">'+
						'<div class="c-content" title="'+data.results[i].projectName+'">'+data.results[i].projectName+'借款信用贷<br>买房急需钱</div>'+
					'</div>'+
					'<div class="contentOut1">'+
						'<div class="c-content" title="'+data.results[i].projectTypeName+'">'+data.results[i].projectTypeName+'</div>'+
					'</div>'+
					'<div class="contentOut2">'+
						'<div class="c-content">'+data.results[i].deadline+'</div>'+
					'</div>'+
					'<div class="contentOut1">'+
						'<div class="c-content" title="'+data.results[i].sAmount+'">'+data.results[i].sAmount+'</div>'+
					'</div>'+
					'<div class="contentOut4">'+
						'<div class="c-content" title="'+data.results[i].sMinAmount+'">'+data.results[i].sMinAmount+'</div>'+
					'</div>'+
					'<div class="contentOut1">'+
						'<div class="c-content" title="'+data.results[i].sYearRate+'">'+data.results[i].sYearRate+'</div>'+
					'</div>'+
					'<div class="contentOut3">'+
						'<div class="c-content" title="'+data.results[i].releaseTime+'">'+data.results[i].releaseTime+'</div>'+
					'</div>'+
					'<div class="contentOut3">'+
						'<div class="c-content">'+data.results[i].startTime+'/'+data.results[i].endTime+'</div>'+
					'</div>'+
					'<div class="contentOut3">'+
						'<div class="c-content">'+data.results[i].sInvestRate+'%<br>'+
							'<span class="invRecord" data-loanId="'+data.results[i].loanId+'">投资记录</span>'+					
						'</div>'+
					'</div>'+
					'<div class="contentOut1">'+
						'<div class="c-content" title="'+data.results[i].holdDate+'">'+data.results[i].holdDate+'</div>'+
					'</div>'+
				'</li>';
		}
	}else{
		_html+='<li class="data-item noData"><div>暂无数据！</div></li>';
	}
	//赋值
	$(".my-loan-table").append(_html);
	//绑定查看投资记录详情
	getInvestRecord();
}


//我的账户-借款管理-我的借款：已结清
function getClearing(curr,length){
	$.ajax({
		url:"loanManagement/cleared.html",
		data:{
			"start": curr || 1,		//当前页
			"length":length || 1	//每页条数为预留数据，后台有默认值
		},
		type:"get",
		dataType:"json",
		timeout:10000,
		success:function(data){
			//console.log(data);
			$(".my-loan-table .data-item").remove();
			if(data.results.length > 0){
				creatClearing(data);//拼接数据
				/*laypage({//分页
				    cont: $("#pager"),//容器。值支持id名、原生dom对象，jquery对象。【如该容器为】：<div id="page1"></div>
				    curr:data.pageNum,//初始化当前页			连续分页必须参数
				    pages: data.totalPage,//通过后台拿到的总页数	连续分页必须参数
					first: false,
				    last: false,
				    prev: "&lt;",
				    next: "&gt;",
				    skip: true, //是否开启跳页
				    skin: '#72c0f3',
				    groups: 5, //连续显示分页数
				    jump: function(obj,first){
				    	if(!first){ //点击跳页触发函数自身，并传递当前页：obj.curr
		                    getClearing(obj.curr);
		                }
				    }
				});*/
				
				pager.generPageHtml({
					pno: data.pageNum,					//当前页
					total: data.totalPage,				//总页码
					totalRecords: data.recordsTotal,	//总数据条数
					mode: 'click', //默认值是link，可选link或者click
					click: function(n) {
						getFailure(n,length);
						this.selectPage(n);
						return false;
					}
				});
			}else{
				$(".my-loan-table").append(noData);
			}
		},
		error:function(){
			layer.alert("请求异常，请稍后再试",{icon:2});
		}
	});
}

//拼接代码-已结清
function creatClearing(data){
	var _html = "";
	if(data.results.length != 0){
		//$(".my-loan-table .data-item").remove();
		for(var i=0;i<data.results.length;i++){
			_html+='<li class="data-item">'+
					'<div class="contentOut0">'+
						'<div class="c-content" title="'+data.results[i].projectNo+'">'+data.results[i].projectNo+'</div>'+
					'</div>'+
					'<div class="contentOut0">'+
						'<div class="c-content" title="'+data.results[i].projectName+'">'+data.results[i].projectName+'</div>'+
					'</div>'+
					'<div class="contentOut0">'+
						'<div class="c-content" title="'+data.results[i].sAmount+'">'+data.results[i].sAmount+'</div>'+
					'</div>'+
					'<div class="contentOut2">'+
						'<div class="c-content" title="'+data.results[i].sSjinAmount+'">'+data.results[i].sSjinAmount+'</div>'+
					'</div>'+
					'<div class="contentOut0">'+
						'<div class="c-content" title="'+data.results[i].sYearRate+'">'+data.results[i].sYearRate+'</div>'+
					'</div>'+
					'<div class="contentOut2">'+
						'<div class="c-content" title="'+data.results[i].holdDate+'">'+data.results[i].holdDate+'</div>'+
					'</div>'+
					'<div class="contentOut2">'+
						'<div class="c-content" title="'+data.results[i].settleDate+'">'+data.results[i].settleDate+'</div>'+
					'</div>'+
					'<div class="contentOut3">'+
						'<div class="c-content">'+data.results[i].sRepayPrincipal+'/'+data.results[i].sRepayInterest+'</div>'+
					'</div>'+
					'<div class="contentOut3">'+
						'<div class="c-content">'+data.results[i].sRepayOverdueInterest+'/'+data.results[i].sRepayOverdue+'</div>'+
					'</div>'+
					'<div class="contentOut3">'+
						'<div class="c-content" title="'+data.results[i].sRepayPenalty+'">'+data.results[i].sRepayPenalty+'</div>'+
					'</div>'+
					'<div class="contentOut0">'+
						'<div class="c-content">';
						if(data.results[i].statu > 0){
							_html+='提前还款';
						}else if(data.results[i].statu <= 0 && data.results[i].sOverStatu >0){
							_html+='存在逾期还款';
						}else if(data.results[i].statu <= 0 && data.results[i].sOverStatu <=0){
							_html+='正常结清';
						}
					_html+='</div>'+
					'</div>'+
					'<div class="contentOut0">'+
						'<div class="c-content">'+
							'<a href="loanManagement/repayRecord.html?projectId='+data.results[i].loanId+'">还款记录</a><br>'+
							'<a href="" class="loan-agreement">借款协议</a><!--跳转未知  -->'+
						'</div>'+
					'</div>'+
				'</li>';
		}
	}else{
		_html+='<li class="data-item noData"><div>暂无数据！</div></li>';
	}
	//赋值
	$(".my-loan-table").append(_html);
	//绑定查看还款记录详情
	
}


//!!!!!!!!!!公用:融资中、融资结束、已流标!!!!!!!!!!!!
//我的账户-借款管理-我的借款：投资记录
function getInvestRecord(curr,length){
	$('.invRecord').on('click', function(){
		//项目申请id
		var loanId = $(this).attr("data-loanId");
		if(loanId ==null || loanId == ""){
			//console.log("参数异常");
			return;
		}
		var data = {};
		data.applyId = loanId;
		data.start = curr || 1;
		data.length = length || 1;
		
    	var url1 = "loanManagement/investRecord.html";
    	$.ajax({
			url:url1,
			type:"get",
			data:data,
			dataType:"json",
			timeout:10000,
			success:function(data){
				//console.log(data);
				$("#investRecordTop").siblings().remove();
				if(data.results.length > 0){
					var html = template("investRecordList", data);
					$("#investRecordUl").append(html);
					pager1.generPageHtml({
						pno: data.pageNum,					//当前页
						total: data.totalPage,				//总页码
						totalRecords: data.recordsTotal,	//总数据条数
						mode: 'click', //默认值是link，可选link或者click
						click: function(n) {
							getInvestRecord(n,length);
							this.selectPage(n);
							return false;
						}
					});
					
				}else{
					$("#investRecordUl").append(noData);
				}
			},
			error:function(){
				layer.alert("请求异常，请稍后再试",{icon:2});
			}
		});
		
		layer.open({
			title :'查看投资记录',//标题
			skin: 'layer-ext-myskin',//皮肤
	        type: 1,
	        area: ['645px', '470px'],//大小宽*高
	        shadeClose: true, //点击遮罩关闭
	        content: $('.inv-record')//内容，里边是包含内容的div的class
	    });
	});
}


//我的账户-借款管理-我的借款:借款申请记录
function getApplyRecord(curr,length){
	$.ajax({
		url:"loanManagement/loanApplyRecord.html",
		data:{
			"start": curr || 1,		//当前页
			"length":length || 1	//每页条数为预留数据，后台有默认值
		},
		type:"get",
		dataType:"json",
		timeout:10000,
		success:function(data){
			//console.log(data);
			$(".my-loan-table .data-item").remove();
			if(data.results.length > 0){
				creatApplyRecord(data);
				/*creatApplyRecord(data);//拼接数据
				laypage({//分页
				    cont: $("#pager"),//容器。值支持id名、原生dom对象，jquery对象。【如该容器为】：<div id="page1"></div>
				    curr:data.pageNum,//初始化当前页			连续分页必须参数
				    pages: data.totalPage,//通过后台拿到的总页数	连续分页必须参数
					first: false,
				    last: false,
				    prev: "&lt;",
				    next: "&gt;",
				    skip: true, //是否开启跳页
				    skin: '#72c0f3',
				    groups: 5, //连续显示分页数
				    jump: function(obj,first){
				    	if(!first){ //点击跳页触发函数自身，并传递当前页：obj.curr
		                    getApplyRecord(obj.curr);
		                }
				    }
				});*/
				
				pager.generPageHtml({
					pno: data.pageNum,			//当前页
					total: data.totalPage,		//总页码
					totalRecords: data.recordsTotal,//总数据条数
					mode: 'click', //默认值是link，可选link或者click
					click: function(n) {
						getApplyRecord(n,length);
						this.selectPage(n);
						return false;
					}
				});
				
			}else{
				$(".my-loan-table").append(noData);
			}
		},
		error:function(){
			layer.alert("请求异常，请稍后再试",{icon:2});
		}
	});
}

//拼接代码-申请记录
function creatApplyRecord(data){
	var _html = "";
	if(data.results.length != 0){
		//$(".my-loan-table .data-item").remove();
		for(var i=0;i<data.results.length;i++){
			_html+='<li class="data-item">'+
					'<div class="contentOut4">'+
						'<div class="c-content" title="'+data.results[i].projectNo+'">'+data.results[i].projectNo+'</div>'+
					'</div>'+
					'<div class="contentOut4">'+
						'<div class="c-content" title="'+data.results[i].projectName+'">'+data.results[i].projectName+'</div>'+
					'</div>'+
					'<div class="contentOut4">'+
						'<div class="c-content" title="'+data.results[i].projectTypeName+'">'+data.results[i].projectTypeName+'</div>'+
					'</div>'+
					'<div class="contentOut4">'+
						'<div class="c-content">'+data.results[i].deadline;
						if(data.results[i].projectType != ""){
							if(data.results[i].projectType == 0){//天标
								_html+="天";
							}else if(data.results[i].projectType == 1){//月标
								_html+="个月";
							}else if(data.results[i].projectType == 2){//年标
								_html+="年";
							}
						}
					_html+='</div>'+
					'</div>'+
					'<div class="contentOut4">'+
						'<div class="c-content" title="'+data.results[i].sAmount+'">'+data.results[i].sAmount+'</div>'+
					'</div>'+
					'<div class="contentOut4">'+
						'<div class="c-content" title="'+data.results[i].sMinAmount+'">'+data.results[i].sMinAmount+'</div>'+
					'</div>'+
					'<div class="contentOut4">'+
						'<div class="c-content" title="'+data.results[i].sYearRate+'">'+data.results[i].sYearRate+'%</div>'+
					'</div>'+
					'<div class="contentOut4">'+
						'<div class="c-content checking" title="'+data.results[i].statuName+'">'+data.results[i].statuName+'<!--审核中(单独样式)，已拒绝，审核未通过，未发布，已发布  --></div>'+
					'</div>'+
				'</li>';
		}
	}else{
		_html+='<li class="data-item noData"><div>暂无数据！</div></li>';
	}
	//赋值
	$(".my-loan-table").append(_html);
}

//我的账户-借款管理-我的借款:待确认借款申请
function getApply(curr,length){
	$.ajax({
		url:"loanManagement/TBCapply.html",
		data:{
			"start": curr || 1,		//当前页
			"length":length || 1	//每页条数为预留数据，后台有默认值
		},
		type:"get",
		dataType:"json",
		timeout:10000,
		success:function(data){
			//console.log(data);
			if(data.results.length > 0){
				creatApply(data);
				/*creatApply(data);//拼接数据
				laypage({//分页
				    cont: $("#pager"),//容器。值支持id名、原生dom对象，jquery对象。【如该容器为】：<div id="page1"></div>
				    curr:data.pageNum,//初始化当前页			连续分页必须参数
				    pages: data.totalPage,//通过后台拿到的总页数	连续分页必须参数
					first: false,
				    last: false,
				    prev: "&lt;",
				    next: "&gt;",
				    skip: true, //是否开启跳页
				    skin: '#72c0f3',
				    groups: 5, //连续显示分页数
				    jump: function(obj,first){
				    	if(!first){ //点击跳页触发函数自身，并传递当前页：obj.curr
		                    getApply(obj.curr);
		                }
				    }
				});*/
				
				pager.generPageHtml({
					pno: data.pageNum,			//当前页
					total: data.totalPage,		//总页码
					totalRecords: data.recordsTotal,//总数据条数
					mode: 'click', //默认值是link，可选link或者click
					click: function(n) {
						getApply(n,length);
						this.selectPage(n);
						return false;
					}
				});
			}else{
				$(".my-loan-table").append(noData);				
			}
		},
		error:function(){
			layer.alert("请求异常，请稍后再试",{icon:2});
		}
	});
}

//拼接代码-待确认借款申请
function creatApply(data){
	var _html = "";
	if(data.results.length != 0){
		$(".my-loan-table .data-item").remove();
		for(var i=0;i<data.results.length;i++){
			_html+='<li class="data-item">'+
					'<div class="contentOut4">'+
						'<div class="c-content" title="'+data.results[i].projectId+'">'+data.results[i].projectId+'</div>'+
					'</div>'+
					'<div class="contentOut4">'+
						'<div class="c-content" title="'+data.results[i].projectName+'">'+data.results[i].projectName+'</div>'+
					'</div>'+
					'<div class="contentOut4">'+
						'<div class="c-content" title="'+data.results[i].projectTypeName+'">'+data.results[i].projectTypeName+'</div>'+
					'</div>'+
					'<div class="contentOut4">'+
						'<div class="c-content" title="'+data.results[i].termOfLoan+'">'+data.results[i].termOfLoan;
						if(data.results[i].termOfLoanType != ""){
							if(data.results[i].termOfLoanType == 0){//天标
								_html+="天";
							}else if(data.results[i].termOfLoanType == 1){//月标
								_html+="个月";
							}else if(data.results[i].termOfLoanType == 2){//年标
								_html+="年";
							}
						}
					_html+='</div>'+
					'</div>'+
					'<div class="contentOut4">'+
						'<div class="c-content" title="'+data.results[i].sLoanAount+'">'+data.results[i].sLoanAount+'</div>'+
					'</div>'+
					'<div class="contentOut4">'+
						'<div class="c-content" title="'+data.results[i].sMinLoanAonnt+'">'+data.results[i].sMinLoanAonnt+'</div>'+
					'</div>'+
					'<div class="contentOut4">'+
						'<div class="c-content" title="';
							if(data.results[i].sInterestRates != null){
								_html+=data.results[i].sInterestRates+'%">'+data.results[i].sInterestRates+'%</div>';
							}else{
								_html+='"></div>';
							}
					_html+='</div>'+
					'<div class="contentOut4">'+
						'<div class="c-content toConfirm" data-projectId="'+data.results[i].projectId+'">'+data.results[i].statusName+'</div>'+
					'</div>'+
				'</li>';
				
				//状态  toConfirm submitToConfirm:提交审核待确认;toConfirm publishToConfirm:发布待确认;viewDetails:查看详情
				
		}
	}else{
		_html+='<li class="data-item noData"><div>暂无数据！</div></li>';
	}
	//赋值
	$(".my-loan-table").append(_html);
	//绑定详情事件
	getTBCDet();
	toTBCConfirm();
}

//获取待确认借款申请详情
function getTBCDet(){
	$(".c-content.viewDetails").click(function(){
		var projectId = $(this).attr("data-projectId");
		//console.log(projectId);
		/*if(projectId ==null || projectId == ""){
			return;
		}*/
		//console.log("差查询");
    	/*var url1 = "loanManagement/AdvcancePost_"+applyId+".html";
    	$.ajax({
			url:url1,
			type:"get",
			dataType:"json",
			timeout:10000,
			success:function(data){
				////console.log(data);
			},
			error:function(){
				layer.alert("请求异常，请稍后再试",{icon:2});
			}
		});*/
		
		
		layer.open({
			title :'项目基本信息',//标题
			skin: 'layer-ext-myskin',//皮肤
	        type: 1,
	        area: ['440px', '580px'],//大小宽*高
	        shadeClose: true, //点击遮罩关闭
	        content: $('.view-details')//内容，里边是包含内容的div的class
	    });
	});
}

//待确认借款申请-确认操作
function toTBCConfirm(){
	$(".c-content.toConfirm").click(function(){
		//
		//console.log("差查询");
		layer.open({
			title :'项目基本信息',//标题
			skin: 'layer-ext-myskin',//皮肤
	        type: 1,
	        area: ['440px', '620px'],//大小宽*高
	        shadeClose: true, //点击遮罩关闭
	        content: $('.to-confirm')//内容，里边是包含内容的div的class
	    });
	    
	    //console.log("差执行");
	    
	});
}


//获取已结清的借款-还款记录
function getRepayRecord(curr,length){
	var temp = window.location.href;
	projectId = temp.split("projectId=")[1];
	////console.log(projectId);
	/*if(projectId == null || isNaN(projectId)){
		//console.log("参数异常");
		return;
	}*/
	
	var data = {};
	data.applyId = projectId;
	data.start = curr || 1;//当前页
	data.length = length || 1;//每页条数为预留数据，后台有默认值
	
	$.ajax({
		url:"loanManagement/loanRepayend.html",
		data:data,
		type:"get",
		dataType:"json",
		timeout:10000,
		success:function(data){
			//console.log(data);
			$("#loanRepayendTop").siblings().remove();
			if(data.results.length > 0){
				var html = template("loanRepayendList", data);
				$("#loanRepayendUl").append(html);
				
				pager.generPageHtml({
					pno: data.pageNum,			//当前页
					total: data.totalPage,		//总页码
					totalRecords: data.recordsTotal,//总数据条数
					mode: 'click', //默认值是link，可选link或者click
					click: function(n) {
						getRepayRecord(n,length);
						this.selectPage(n);
						return false;
					}
				});
				
			}else{
				$("#loanRepayendUl").append(noData);
			}
		},
		error:function(){
			layer.alert("请求异常，请稍后再试",{icon:2});
		}
	});
}