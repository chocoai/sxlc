/*折叠显示部分开始 王延君2016-03-29*/
$(".glyphicon").addClass("glyphicon-chevron-right");
$(function(){
	
	
	getRecruitment(1,5);
});
/*折叠显示部分结束 王延君2016-03-29*/


//function
//获取招贤纳士信息
function getRecruitment(start,length){
	var data = {};
	if (start!=undefined){
		data.start = start;
	};
	if (length!=undefined){
		data.length = length;
	};
	var url = "aboutUs/Recruitment.html";
	
	NetUtil.ajax(
    	url,
    	data,
    	function(r){
    		var data = JSON.parse(r);
    		console.log(data);
    		$("#recruitment-box").html("");//除标题外的内容移除
    		if(data.recordsTotal > 0) {
    			var html = template("recruitmentList",data);//模板生成 
				$("#recruitment-box").append(html);//页面赋值
	    		var totalPage    = Math.ceil(data.recordsTotal/data.pageSize);
				var totalRecords = data.recordsTotal;
				var pageNo       = data.pageNum;
				pager.generPageHtml({//调用分页
					pno : pageNo,				//当前页
					total : totalPage,			//总页码
					totalRecords : totalRecords,//总数据条数
					mode : 'click',				//默认值是link，可选link或者click
					click : function(n) {
						getRecruitment(n,length);
						this.selectPage(n);//点击重复调用
						return false;
					}
				});
				//绑定收缩展开事件;
				showInfo();
    		}else{
    			var noData = '<div class="noData">暂无数据</div>';
    			$("#recruitment-box").append(noData);//页面赋值
    		}
    	}
    );
}

//内容收缩展开
function showInfo(){
	$(".contentMiddleH").each(function(){
		$(this).click(function(){
			/*if($(this).children("span").children("i").hasClass('glyphicon-chevron-right')){
				$(this).parent().children(".job_middle_main").slideDown();
				$(this).children("span").children("i").removeClass("glyphicon-chevron-right").addClass("glyphicon-chevron-down");
				$(this).children("h4").css("color","#72c0f3");
			}else{
				$(this).parent().children(".job_middle_main").slideUp();
				$(this).children("span").children("i").removeClass("glyphicon-chevron-down").addClass("glyphicon-chevron-right");
				$(this).children("h4").css("color","#868686");
			}*/
			if($(this).children("h4").hasClass("active")){
				$(this).children("h4").removeClass("active");
			}else{
				$(this).children("h4").addClass("active");
			}
			$(this).siblings(".job_middle_main").slideToggle("200");
			$(this).parent().parent().siblings(".data-item").find(".job_middle_main").slideUp("200");
			$(this).parent().parent().siblings(".data-item").find("h4").removeClass("active");
		});
	});
}