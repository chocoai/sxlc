package cn.springmvc.service; 

import product_p2p.kit.optrecord.InsertAdminLogEntity; 
  /**
   * 
   * @author 刘利 
   * @Description: 网站版权信息
   * @since 
   * @date 2016-3-19 下午10:08:35
   */
public interface SystemCopyrightService {
	/**
	 * 添加网站版权信息 
	 * @return	0：失败	1：成功
	 */
	public int insertSystemCopyright(String content,InsertAdminLogEntity 
			logentity,String[] sIpInfo);
	/**
	 *  查询网站版权信息 
	 * @return
	 */
	public String selectSystemCopyright(); 
}
