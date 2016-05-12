//$(".mCoverContP").each(function(i){
//    var divH = $(this).height();
//    var $p = $("p", $(this)).eq(0);
//    while ($p.outerHeight() > divH) {
//        $p.text($p.text().replace(/(\s)*([a-zA-Z0-9]+|\W)(\.\.\.)?$/,"..."));
//    };
//});
$(function(){
	/*if($(".mCoverContP").find('p').html().length > 180){  
		$(".mCoverContP").find('p').html($(".mCoverContP").find('p').html().substr(0,180)+'...'+'<a href="mediaCoverageDetail.html">查看详情>></a>');  
	}*/
	
	//截取字符串
	template.helper("$toSubStr",function(content){
		if(content.length > 180){
			return content.substr(0,180)+'...';
		}
	});
	//去掉时间后的.0
	template.helper("$toDelete",function(content){
		var index = content.indexOf(".");
		return content.substring(0,index);
	});
	
	
	getMediaCoverage(1,5);
});

//function
//获取媒体报道信息
function getMediaCoverage(start,length){
	var data = {};
	if (start!=undefined){
		data.start = start;
	};
	if (length!=undefined){
		data.length = length;
	};
	var url = "aboutUs/MediaReports.html";
	
	NetUtil.ajax(
    	url,
    	data,
    	function(r){
    		var data = JSON.parse(r);
    		console.log(data);
    		$("#mediaReports-box").html("");//除标题外的内容移除
    		if(data.recordsTotal > 0) {
    			var html = template("mediaReportsList",data);//模板生成 
				$("#mediaReports-box").append(html);//页面赋值
	    		var totalPage    = Math.ceil(data.recordsTotal/data.pageSize);
				var totalRecords = data.recordsTotal;
				var pageNo       = data.pageNum;
				pager.generPageHtml({//调用分页
					pno : pageNo,				//当前页
					total : totalPage,			//总页码
					totalRecords : totalRecords,//总数据条数
					mode : 'click',				//默认值是link，可选link或者click
					click : function(n) {
						getMediaCoverage(n,length);
						this.selectPage(n);//点击重复调用
						return false;
					}
				});
    		}else{
    			var noData = '<div class="noData">暂无数据</div>';
    			$("#mediaReports-box").append(noData);//页面赋值
    		}
    	}
    );
}