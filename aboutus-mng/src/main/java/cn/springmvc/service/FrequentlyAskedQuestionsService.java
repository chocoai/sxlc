package cn.springmvc.service;

import cn.springmvc.model.FrequentlyAskedQuestionsEntity;
 
/**
 * 
* @author 刘利 
* @Description: 常见问题
* @since 
* @date 2016-3-19 下午10:06:24
 */
public interface FrequentlyAskedQuestionsService {
	/**
	 * 新增常见问题
	 * @param entity 常见问题实体
	 * @return -1：数据为空;0：添加失败;1:添加成功
	 */
	public int insertFrequentlyAskedQuestions(FrequentlyAskedQuestionsEntity entity); 
	/**
	 * 删除常见问题
	 * @param id 常见问题id
	 * @return 0：失败；1成功
	 */
	public int deleteFrequentlyAskedQuestions(int id);  
	/**
	 * 停用或启用常见问题信息
	 * @param entity 常见问题实体 包含statu 常见问题状态(0:无效 1：有效-1：全部),id
	 * @return 0:失败 1：成功 
	 */
	public  int  updateFrequentlyAskedQuestionsStatuByID(FrequentlyAskedQuestionsEntity entity);
	/**
	 * 查询常见问题 
	 * @param statu 常见问题状态(0:无效 1：有效-1：全部)
	 * @return FrequentlyAskedQuestionsEntity 常见问题实体
	 */
	public  FrequentlyAskedQuestionsEntity selectFrequentlyAskedQuestionsList(int statu);
}
