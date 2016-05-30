/* 名单滚动伍成然 */
$(function() { 
	var $this = $("#news"); 
	var scrollTimer; 
	$this.hover(function() { 
		clearInterval(scrollTimer); 
	}, function() { 
			scrollTimer = setInterval(function() { 
					scrollNews($this); 
					}, 2000); 
			}).trigger("mouseleave"); 
function scrollNews(obj) { 
	var $self = obj.find("ul"); 
	var lineHeight = $self.find("li:first").height(); 
		$self.animate({ 
			"marginTop": -lineHeight + "px" 
		}, 600, function() { 
			$self.css({ 
				marginTop: 0 
			}).find("li:first").appendTo($self); 
		}) ;
	} 
}) ;
//获取红包领取记录
function getRedRecord(){
	$.ajax({
		url:"redRecord.html",
		type:"get",
		dataType:"json",
		success:function(r){
			console.log(r);
			var data = {data:r};
			var html = template("listM",data);
			$("#listUl").html(html);
		}
	})
}
function setInter(){
	window.setInterval(function(){
		getRedRecord()
	},30000)
}

$(function(){
	window.setTimeout(function(){
		getRedRecord();
		setInter();
	},30000);
	
})
/* 抢红包 */
$(".beginBtn").click(function(){
	var $this = $(this);
	if(optionStatu == "0"){
		layer.alert("您还未登陆，请先登录 !",function(index){
			layer.close(index);
			location.href="login.html";
		});
		return false;
	}else{
		$this.addClass("disabled");
		var encrypt = new JSEncrypt();
		encrypt.setPublicKey(publickey);
		var data = {affairId:encrypt.encrypt(affairId+"")};
		var url = "grabRedPackage.html";
		NetUtil.ajax(
				url,
				data,
				function(r){
					var data = JSON.parse(r);
					layer.alert(data.message,function(index){
						$this.removeClass("disabled");
						layer.close(index);
					});
				}
			)
	}
});