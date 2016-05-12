$(function(){
	getLegalRegulation();
});

//function
//获取法律法规信息
function getLegalRegulation(){
	$.ajax({
    	url:"aboutUs/LawsRegula.html",
    	type:"get",
    	timeout:10000,
    	dataType:"json",
    	success:function(data){
    		if(data.content){
	    		$(".lawy_content").append(data.content);
    		}else{
    			var noData = '<div class="noData">暂无数据</div>';
	    		$(".lawy_content").append(noData);
    		}
    	},
    	error:function(XMLHttpRequest, textStatus, errorThrown){
        	layer.alert("请求异常，请稍后再试",{icon:2});
		}
    });
}