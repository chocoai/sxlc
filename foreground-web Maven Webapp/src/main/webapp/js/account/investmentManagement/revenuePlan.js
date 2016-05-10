	function GetQueryString(name){
			     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
			     var r = window.location.search.substr(1).match(reg);
			     if(r!=null)return  unescape(r[2]); return null;
		}

$(function(){
	var investId = GetQueryString("investId");
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
	hrefFormer : basePath + "investmentManagement/revenuePlan/"+investId+"/",
	//链接尾部
	hrefLatter : '.html?'+"investId="+investId,
	mode : 'link',//默认值是link，可选link或者click
	getLink : function(n) {
		return this.hrefFormer+ n + this.hrefLatter ;//自定义格式
	}
});
})