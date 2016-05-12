$(function(){
	$(".choose2").attr("selected","selected");//Ĭ��ѡ����ʽ ���� 20160327
});


/*  20160410  胥福星    */
$(function(){
	$(".aboutUsNav input").val($(".choose2").html());
	getManagementTeam();
});

//function
//获取管理团队信息
function getManagementTeam(start,length){
	var data = {};
	if (start!=undefined){
		data.start = start;
	};
	if (length!=undefined){
		data.length = length;
	};
	var url = "aboutUs/MngTeam.html";
	
	NetUtil.ajax(
    	url,
    	data,
    	function(r){
    		var data = JSON.parse(r);
    		console.log(data);
    		$("#mngTeam-box").html("");//除标题外的内容移除
    		if(data.recordsTotal > 0) {
    			var html = template("mngTeamList",data);//模板生成 
				$("#mngTeam-box").append(html);//页面赋值
	    		var totalPage    = Math.ceil(data.recordsTotal/data.pageSize);
	    		//console.log(data.recordsTotal+"=========="+data.pageSize);
				var totalRecords = data.recordsTotal;
				var pageNo       = data.pageNum;
				pager.generPageHtml({//调用分页
					pno : pageNo,				//当前页
					total : totalPage,			//总页码
					totalRecords : totalRecords,//总数据条数
					mode : 'click',				//默认值是link，可选link或者click
					click : function(n) {
						getManagementTeam(n,length);
						this.selectPage(n);//点击重复调用
						return false;
					}
				});
    		}else{
    			var noData = '<div class="noData">暂无数据</div>';
    			$("#mngTeam-box").append(noData);//页面赋值
    		}
    	}
    );
}