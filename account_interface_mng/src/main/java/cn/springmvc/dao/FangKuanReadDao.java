package cn.springmvc.dao; 




/**
 * 放款 数据库处理
* @author 张友 
* @Description: TODO 
* @since 
* @date 2016-4-6 下午4:20:25
 */
public interface FangKuanReadDao {

	/**
	 * 获取放款订单号列表
	* GetFangKuanOrderList	获取放款订单号列表，最多获取200条
	* TODO(描述)
	* @author 张友  
	* * @Title: GetFangKuanOrderList 
	* @Description: TODO 
	* @param @param lProId
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-4-6 下午8:24:54
	* @throws d
	 */
	public String GetFangKuanOrderList(long lProId);
}

