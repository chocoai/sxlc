package cn.springmvc.dao;
 
/**
 * 
* @author 刘利 
* @Description: 网站版权信息
* @since 
* @date 2016-3-19 下午9:49:09
 */
public interface SystemCopyrightListDao {
	/**
	 * 查询该网站版权信息是否存在 
	 * @return  safetyCertificationEntity 
	 */
	public  int  selectSystemCopyrightIsExist();
	/**
	 *  查询网站版权信息 
	 * @return
	 */
	public String selectSystemCopyright(); 
	
	 
}
