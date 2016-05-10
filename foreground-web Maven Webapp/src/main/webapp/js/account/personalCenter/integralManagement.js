$(function(){
	$(".TB").addClass("down");
	$(".TB5").addClass("down2");
	/*$(".tab-head li").each(function(index){
		var liNode =$(this);
		$(this).click(function(){
			$(".tab-content .c-content").removeClass("content-active");
			$(".tab-head li").removeClass("tab-ing");
			$(".tab-content .c-content").eq(index).addClass("content-active");
			liNode.addClass("tab-ing");
		});
	});*/
	
	$("#tab-head>li:first").on("click",function(){
		window.location = basePath + "personalCenter/integralManagement/1/1.html";
	})
	
	$("#tab-head>li:last").on("click",function(){
		window.location = basePath + "personalCenter/integralManagement/1/2.html";
	})
	
	
	$(".confirm").on("click",function(){
		var exchangeId = $(this).attr("data-eid");
		var encrypt = new JSEncrypt();
		encrypt.setPublicKey(publickey);
		var data = {exchangeId:encrypt.encrypt(exchangeId+"")};
		var url = "personalCenter/confirmReceipt.html";
		NetUtil.ajax(
				url,
				data,
				function(r){
					var data = JSON.parse(r);
					if(data.status == 1){
						layer.alert("操作成功",function(){
							layer.closeAll();
						})
					}else{
						layer.alert("错误")
					}
				}
		)
	});
	
	//分页
	var type = $("#type").val();
	if (type == "1"){
			var pageSize = $("#pageSize").val();
			var totalRecords = $("#tol").val();
			var totalPage = Math.ceil(totalRecords/pageSize);
			var pageNo = $("#cpage").val();
			if (!pageNo) {
				pageNo = 1;
			};
			
			pager.generPageHtml({
			pno : pageNo,
			//总页码
			total : totalPage,
			//总数据条数
			totalRecords : totalRecords,
			//链接前部
			hrefFormer : basePath + "personalCenter/integralManagement/",
			//链接尾部
			hrefLatter : '/'+ type +'.html',
			mode : 'link',//默认值是link，可选link或者click
			getLink : function(n) {
				return this.hrefFormer+ n + this.hrefLatter ;//自定义格式
			}
		})
	}
		
		
		
	if(type == 2){
		var pageSize = $("#pageSize").val();
		var totalRecords = $("#tol").val();
		var totalPage = Math.ceil(totalRecords/pageSize);
		var pageNo = $("#cpage").val();
		if (!pageNo) {
			pageNo = 1;
		};
		
		pager1.generPageHtml({
		pno : pageNo,
		//总页码
		total : totalPage,
		//总数据条数
		totalRecords : totalRecords,
		//链接前部
		hrefFormer : basePath + "personalCenter/integralManagement/",
		//链接尾部
		hrefLatter :  '/'+ type +'.html',
		mode : 'link',//默认值是link，可选link或者click
		getLink : function(n) {
			return this.hrefFormer+ n + this.hrefLatter ;//自定义格式
			}
		})
	}
	
});