package cn.springmvc.dao;

import cn.springmvc.model.FrequentlyAskedQuestionsEntity;
/**
 * 
* @author 刘利 
* @Description: 常见问题的查询类接口
* @since 
* @date 2016-3-19 下午8:03:27
 */
public interface FrequentlyAskedQuestionsListDao {
	/**
	 * 查询常见问题
	 * @param statu 常见问题状态 0无效，1有效,-1全部
	 * @return
	 */
	public  FrequentlyAskedQuestionsEntity  selectFrequentlyAskedQuestions(); 
	/**
	 * 查询常见问题是否存在 
	 * @return  0：不存在	大于0：存在
	 */
	public  int  selectFrequentlyAskedQuestionsIsExist();
}
