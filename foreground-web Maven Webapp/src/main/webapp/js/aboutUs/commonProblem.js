$(function(){
	$(".choose9").attr("selected","selected");//Ĭ��ѡ����ʽ ���� 20160327
	/*折叠显示部分开始 王延君2016-03-29*/
	$(".problem_plat_btn").addClass("plat_btn_left");
	$(function(){
		$(".problem_plat_cont").hide();
		$(".problem_plat h5").click(function(){
			$(this).next().slideToggle();
		});
		var i=1;
		$(".problem_plat h5").click(function(){
			i++;
			if(i%2==0){
				$(this).children("span").removeClass("plat_btn_left").addClass("plat_btn_down");
			}else{
				$(this).children("span").removeClass("plat_btn_down").addClass("plat_btn_left");
			}
		});
	});
	/*折叠显示部分结束 王延君2016-03-29*/
});




/*  20160410  胥福星    */
$(function(){
	$(".aboutUsNav input").val($(".choose9").html());
	
	getCommonProblem();
});


//function
//获取常见问题
function getCommonProblem(){
	$.ajax({
    	url:"aboutUs/frequentlyAskedQuestion.html",
    	type:"get",
    	timeout:10000,
    	dataType:"json",
    	success:function(data){
    		if(data.content){
	    		$(".problem_content").append(data.content);
    		}else{
    			var noData = '<div class="noData">暂无数据</div>';
	    		$(".problem_content").append(noData);
    		}
    	},
    	error:function(XMLHttpRequest, textStatus, errorThrown){
        	layer.alert("请求异常，请稍后再试",{icon:2});
		}
    });
}