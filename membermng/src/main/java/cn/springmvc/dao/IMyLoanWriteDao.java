

/** 
* @Title: IMyLoanWriteDao.java 
* @Package cn.springmvc.dao 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-5-3 下午7:48:10 
* @version V5.0 */
 
package cn.springmvc.dao;  

import java.util.Map;

import cn.membermng.model.ComfirLoanInfo;

/** 自动还款设置
 * @author 刘利 
 * @Description: TODO 
 * @since 
 * @date 2016-5-3 下午7:48:10  */ 
public interface IMyLoanWriteDao {
	
	/**
	 * 开通自动投标
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param map
	 * @param @return 设定文件 
	 * @return int 返回类型 
	 * @date 2016-5-3 下午7:58:18
	 */
	public int updateAutoPay(Map<String,Object> map);

	
	
	 /***
	 * 确认借款申请
	 * 
	 * @author 李杰
	 * @param param
	 * @return
	 * @date 2016-5-12 下午2:33:15
	  */
	 public int confirmationLoan(Map<String, Object> param);
	 
}

