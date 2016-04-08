

/** 
* @Title: MyinvestService.java 
* @Package cn.springmvc.service 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-31 下午2:13:44 
* @version V5.0 */
 
package cn.springmvc.service; 

import java.util.List;

import product_p2p.kit.pageselect.PageEntity;
import cn.membermng.model.InvestIncomeEntity;
import cn.membermng.model.MyinvestEntity;

/** 
 * @author 刘利 
 * @Description: 我的投资
 * @since 
 * @date 2016-3-31 下午2:13:44  */

public interface MyinvestService {
	/**
	 * 分页查询我的投资回收中 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param  PageEntity 
	 * <p> map {sKey, memberID,order(1根据剩余期数升序,-1根据剩余期数降序，2 根据下期回款时间升序，-2 根据下期回款时间降序)}</p> 
	 * @param @return 设定文件 
	 * @return List<MyinvestEntity> 返回类型 
	 * @date 2016-3-31 下午2:05:41
	 */
	public List<MyinvestEntity>  selectMyinvestCollect(PageEntity PageEntity);
	/**
	 * 查询我的投资-已结清
	 * @author 刘利   
	 * @Description: TODO 
	 * @param PageEntity
	 * <p> map {sKey,memberID, order(1根据投资金额升序,-1根据投资金额降序，2 根据收益总额升序，-2 根据收益总额降序
	 *         3根据放款时间升序,-3根据放款时间降序，4 根据结清时间时间升序，-4根据结清时间降序 )}
	 * </p> 
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
	 * <p> map {sKey,statu(0投标中,1已流标,2 投标完成 ),memberID 
	 *         order(1根据投资金额升序,-1 根据投资金额降序，2根据投资进度升序，-2 根据投资进度降序
	 *         3根据投标时间升序,-3根据投标时间降序，4  根据结束时间升序，-4根据结束时间降序 ，5 根据流标时间升序，-5 根据流标时间降序  )}
	 * </p>
	 * @param @return 设定文件 
	 * @return List<MyinvestEntity> 返回类型 
	 * @date 2016-3-31 下午3:00:06
	 */
	public List<MyinvestEntity>  selectMyinvesting(PageEntity pageEntity);
	/**
	 * 查询已结清的收益记录
	 * @author 刘利   
	 * @Description: TODO 
	 * @param  pageEntity  map {sKey,investID(投资ID),memberID}
	 * @param @return 设定文件 
	 * @return List<InvestIncomeEntity> 返回类型 
	 * @date 2016-3-31 下午4:53:38
	 */
	public List<InvestIncomeEntity>  selectRealincome(PageEntity pageEntity);
	/**
	 * 查询回收中的收益计划
	 * @author 刘利   
	 * @Description: TODO 
	 * @param   pageEntity map {sKey,investID(投资ID),memberID}
	 * @param @return 设定文件 
	 * @return List<InvestIncomeEntity> 返回类型 
	 * @date 2016-3-31 下午4:53:38
	 */
	public List<InvestIncomeEntity>  selectInvestIncome(PageEntity pageEntity);

}

