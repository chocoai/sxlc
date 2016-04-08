

/** 
* @Title: Myinvest.java 
* @Package cn.springmvc.dao 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-31 下午2:03:16 
* @version V5.0 */
 
package cn.springmvc.dao; 

import java.util.List;

import cn.membermng.model.InvestIncomeEntity;
import cn.membermng.model.MyinvestEntity;

import product_p2p.kit.pageselect.PageEntity;

/** 
 * @author 刘利 
 * @Description: 个人中心我的投资
 * @since 
 * @date 2016-3-31 下午2:03:16  */

public interface MyinvestListDao {
	/**
	 * 分页查询我的投资-回收中 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param  PageEntity
	 * @param @return 设定文件 
	 * @return List<MyinvestEntity> 返回类型 
	 * @date 2016-3-31 下午2:05:41
	 */
	public List<MyinvestEntity>  selectMyinvestCollect(PageEntity pageEntity);
	/**
	 * 查询我的投资-已结清
	 * @author 刘利   
	 * @Description: TODO 
	 * @param PageEntity
	 * @param @return 设定文件 
	 * @return List<MyinvestEntity> 返回类型 
	 * @date 2016-3-31 下午2:45:13
	 */
	public List<MyinvestEntity>  selectMyinvestSettled(PageEntity pageEntity);
	/**
	 * 查询我的投资-投标中-已流标-投标结束
	 * @author 刘利   
	 * @Description: TODO 
	 * @param pageEntity
	 * @param @return 设定文件 
	 * @return List<MyinvestEntity> 返回类型 
	 * @date 2016-3-31 下午3:00:06
	 */
	public List<MyinvestEntity>  selectMyinvesting(PageEntity pageEntity);
	/**
	 * 查询已结清的收益记录
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param pageEntity
	 * @param @return 设定文件 
	 * @return List<InvestIncomeEntity> 返回类型 
	 * @date 2016-3-31 下午4:53:38
	 */
	public List<InvestIncomeEntity>  selectRealincome(PageEntity pageEntity);
	/**
	 * 查询回收中的收益计划
	 * @author 刘利   
	 * @Description: TODO 
	 * @param   pageEntity
	 * @param @return 设定文件 
	 * @return List<InvestIncomeEntity> 返回类型 
	 * @date 2016-3-31 下午4:53:38
	 */
	public List<InvestIncomeEntity>  selectInvestIncome(PageEntity pageEntity);

}

