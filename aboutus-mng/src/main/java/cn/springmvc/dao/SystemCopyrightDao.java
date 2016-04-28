package cn.springmvc.dao;
  
/**
 * 
* @author 刘利 
* @Description: 网站版权信息
* @since 
* @date 2016-3-19 下午9:48:58
 */
public interface SystemCopyrightDao {
	/**
	 * 添加网站版权信息 
	 * @return	0：失败	1：成功
	 */
	public int insertSystemCopyright(String content);
 
	/**
	 * 修改网站版权信息 
	 * @return  0:失败 1：成功 
	 */
	public  int  updateSystemCopyright(String content); 
	 
}
