/* 查看详情页面加载    */

var index3 = _index.m3;
function companyDetailView(){
	var rowdata = $('#table_id').DataTable().rows('.selected').data();
	if(rowdata.length<1){
		layer.alert("请选择要处理的事务！",{icon:0});
		return;
	}
	var content=rowdata[0].memberId;	
	window.location.href = appPath+"/web/member/allMembers/companyMembersDetail.jsp?content="+content+"&_index_m3="+index3;
}


/**
 * 返回
 * @param suffix
 */
function back(suffix){
	var URL =  appPath+"/"+suffix; 
	window.location.href  = URL;
	
	//window.history.back();
}


