$(function(){
	
	/**查询邀请好友列表**/
	quryFriendInviteList();
	
});

/**
 * 查询邀请好友列表
 */
function quryFriendInviteList(){
	var url="personalCenter/loadFriendInviteList.html";
	NetUtil.ajax(
			url,
			{start:"1",length:"20"},
			function(r){
				var object= JSON.parse(r);
				var html = template('friendList', object);
		        document.getElementById('friend').innerHTML = html;					
			}
		);
}

/**
 * 查询站内好友
 */
function quryFriendList(){
	
	var url="personalCenter/loadFriendList.html";
	NetUtil.ajax(
			url,
			{start:"1",length:"20"},
			function(r){
				var object= JSON.parse(r);
				var html = template('frindLineList', object);
		        document.getElementById('frindLine').innerHTML = html;					
			}
		);
}

/**
 * 查询待确认好友列表
 */
function quryConfirmFriend(){
	var url="personalCenter/selectConfirmFriendList.html";
	NetUtil.ajax(
			url,
			{start:"1",length:"20"},
			function(r){
				var object= JSON.parse(r);
				var html = template('undealList', object);
		        document.getElementById('undeal').innerHTML = html;
		        
		        sureConfirmFriend();
		        
			}
		);
	
}

/**
 * 确认好久申请
 */
function sureConfirmFriend(){
	
	$(".agree").click(function(){
		var fId=$(this).attr("id");
		layer.confirm('确认添加为好友?', {icon: 3, title:'提示'}, function(index){
			var encrypt = new JSEncrypt();
			encrypt.setPublicKey(publickey);		
			fId=encrypt.encrypt(fId+"");
			var url="personalCenter/agreeAapplyForFriend.html";
			NetUtil.ajax(
					url,
					{newFriendId:fId},
					function(r){
						var object= JSON.parse(r);	
						if(object.statu==0){
							layer.closeAll();//关闭弹窗
							quryFriendList();//刷新已是好友列表
						}else{
							layer.alert(object.message);
						}
					}
				);
		});			
	});
}

/**
 * 查找陌生人
 */
function serachMemberByParam(){
	
	var inputFriend=$(".inputFriend").val();
	if(inputFriend.length==0 || inputFriend=="用户名/姓名/手机号"){
		return;
	}
	
	var encrypt = new JSEncrypt();
	encrypt.setPublicKey(publickey);	
	inputFriend=encrypt.encrypt(inputFriend+"");
	var  url="personalCenter/serachMemberByParam.html";
	NetUtil.ajax(
			url,
			{memberName:inputFriend,start:"1",length:"5"},
			function(r){
				var object= JSON.parse(r);	
				var html = template('strangeList', object);
		        document.getElementById('strange').innerHTML = html;
		        
		        applyAddFriends();
		        
			}
	);
	
}

/**
 * 申请添加好友
 */
function applyAddFriends(){
	
	$(".add").click(function(){
		
		var fid=$(this).attr("id");
		
		layer.confirm('确定申请加为好友?', {icon: 3, title:'提示'}, function(index){
			var encrypt = new JSEncrypt();
			encrypt.setPublicKey(publickey);		
			fid=encrypt.encrypt(fid+"");
			var url="personalCenter/applyAddFriends.html";			 
			NetUtil.ajax(
					url,
					{newFriendId:fid},
					function(r){
						var object= JSON.parse(r);	
						if(object.statu==0){
							layer.closeAll();
						}else{
							layer.alert(object.message);
						}
					}
				);	
			});
		
	});
	
}
function friendTransfer(friendId,friendName){
	var url=baseUrl + "friendTransfer/friendManagementTransfer.html";
	var data = {};
	var encrypt = new JSEncrypt();
	encrypt.setPublicKey(publickey);
	data.friendId=encrypt.encrypt(friendId);
	data.friendName=encrypt.encrypt(friendName);
	
	window.location.href=url+"?start="+friendId+"&content="+friendName;
}
