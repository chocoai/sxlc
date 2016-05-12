/* 查看详情页面加载    */

function companyDetailView(){
	var rowdata = $('#table_id').DataTable().rows('.selected').data();
	if(rowdata.length<1){
		layer.alert("请选择要处理的事务！",{icon:0});
		return;
	}
	var content=rowdata[0].memberId;	
	$(".right_col").load("web/member/allMembers/companyMembersDetail.jsp?content="+content);
}






