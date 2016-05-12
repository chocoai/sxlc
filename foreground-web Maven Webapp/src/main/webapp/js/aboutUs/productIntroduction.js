$(function(){
	getProduct();
});

//function
//获取产品介绍信息
function getProduct(){
	$.ajax({
    	url:"aboutUs/ProductIntroduce.html",
    	type:"get",
    	timeout:10000,
    	dataType:"json",
    	success:function(data){
    		if(data && data.content){
				$(".production").append(data.content);//页面赋值
    		}else{
    			var noData = '<div class="noData">暂无数据</div>';
    			$(".production").append(noData);
    		}
    	},
    	error:function(XMLHttpRequest, textStatus, errorThrown){
        	layer.alert("请求异常，请稍后再试",{icon:2});
		}
    });
}