$(function(){
	//取天
	template.helper("$toGetDate",function(content){
		var index = content.indexOf("-",5);
		return content.substring(index+1,index+3);
	});
	//年月
	template.helper("$toGetMonth",function(content){
		var index = content.indexOf("-",5);
		return content.substring(0,index);
	});
	
	
	getWebBoard();
});

//function
//获取网站公告
function getWebBoard(start,length){
	var data = {};
	if (start!=undefined){
		data.start = start;
	};
	if (length!=undefined){
		data.length = length;
	};
	var url = "aboutUs/Platform.html";
	
	NetUtil.ajax(
    	url,
    	data,
    	function(r){
    		var data = JSON.parse(r);
    		console.log(data);
    		$("#webBoardUl").html("");//除标题外的内容移除
    		if(data.recordsTotal > 0) {
    			var html = template("webBoardList",data);//模板生成 
				$("#webBoardUl").append(html);//页面赋值
	    		var totalPage    = Math.ceil(data.recordsTotal/data.pageSize);
				var totalRecords = data.recordsTotal;
				var pageNo       = data.pageNum;
				pager.generPageHtml({//调用分页
					pno : pageNo,				//当前页
					total : totalPage,			//总页码
					totalRecords : totalRecords,//总数据条数
					mode : 'click',				//默认值是link，可选link或者click
					click : function(n) {
						getWebBoard(n,length);
						this.selectPage(n);//点击重复调用
						return false;
					}
				});
    		}else{
    			var noData = '<div class="noData">暂无数据</div>';
    			$("#webBoardUl").append(noData);//页面赋值
    		}
    	}
    );
}

//