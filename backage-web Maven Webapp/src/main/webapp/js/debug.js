/**
 * 全局监控js错误并上报
 * @param {} msg	错误信息；
 * @param {} url	发生错误的文件；
 * @param {} line	发生错误的行号
 * @param {} col	发生错误的列好
 * @param {} error	错误类型
 * @return {Boolean}
 */
window.onerror = function(msg, url, line, col, error) {
  if (msg !== "Script error." && !url) {
    return true;
  }else {
  	alert("错误提示弹出，项目结束时会去除\n!!!警告："+url+"\n第"+line+"行\n"+msg);
  	//console.log("!!!警告："+url+"\n第"+line+"行\n"+msg);
  	return false;
  }
};