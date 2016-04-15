//$(".mCoverContP").each(function(i){
//    var divH = $(this).height();
//    var $p = $("p", $(this)).eq(0);
//    while ($p.outerHeight() > divH) {
//        $p.text($p.text().replace(/(\s)*([a-zA-Z0-9]+|\W)(\.\.\.)?$/,"..."));
//    };
//});
$(function(){
	if($(".mCoverContP").find('p').html().length > 180){  
		$(".mCoverContP").find('p').html($(".mCoverContP").find('p').html().substr(0,180)+'...'+'<a href="mediaCoverageDetail.html">查看详情>></a>');  
	} 
});