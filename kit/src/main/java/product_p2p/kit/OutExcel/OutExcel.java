package product_p2p.kit.OutExcel; 

/***
* 导出数据成Excel
* @author 李杰
* @Description: TODO 
* @since 
* @date 2016-3-21 下午5:46:31
 */
public interface OutExcel {
	
	
	/***
	* 回调 解析元数据
	* @author 李杰 
	* @Title: readAttribute 
	* @Description: TODO 
	* @param obj	解析对象
	* @return String[] [张三,1277809053@qq.com,18328593406]
	* @date 2016-3-21 下午5:46:22
	 */
	public String[] readAttribute(Object obj);
	
	/***
	* 回调 设置文件标头信息
	* @author 李杰 
	* @Title: setHead 
	* @Description: TODO 
	* @return 数据标题[姓名,邮箱,电话]
	* @date 2016-3-21 下午5:47:41
	 */
	public String[] setHead();
	
}

