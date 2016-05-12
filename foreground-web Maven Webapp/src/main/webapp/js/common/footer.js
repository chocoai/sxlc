$(function(){
	$.ajax({
		url:"selectFriendShipLinkfront.html",
		type:"GET",
		success:function(r){
			var object=JSON.parse(r);
			if(object.code==200){
				var html = template('shipList',object);
		        document.getElementById('ship').innerHTML=html;				
			}
		}
	});
});