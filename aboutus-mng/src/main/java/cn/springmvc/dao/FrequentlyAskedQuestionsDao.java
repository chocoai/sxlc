package cn.springmvc.dao;
  
import cn.springmvc.model.FrequentlyAskedQuestionsEntity;
/**
 * 
* @author 刘利 
* @Description: 常见问题增加，删除，修改功能
* @since 
* @date 2016-3-19 下午8:02:59
 */
public interface FrequentlyAskedQuestionsDao {
	/**
	 * 添加常见问题
	 * @param entity  常见问题体类
	 * @return	0：失败	1：成功
	 */
	public int insertFrequentlyAskedQuestions(FrequentlyAskedQuestionsEntity entity);
 
	/**
	 * 通过ID修改常见问题
	 * @param entity 常见问题体
	 * @return  0:失败 1：成功 
	 */
	public  int  updateFrequentlyAskedQuestionsByID(FrequentlyAskedQuestionsEntity entity); 
	/**
	 * 通过ID删除常见问题
	 * @param id 常见问题id
	 * @return 0:失败 1：成功 
	 */
	public  int  deleteFrequentlyAskedQuestionsByID(int id);   
	/**
	 * 停用或启用常见问题
	 * @param entity 常见问题体
	 * @return 0:失败 1：成功 
	 */
	public  int  updateFrequentlyAskedQuestionsStatuByID(FrequentlyAskedQuestionsEntity entity);

}
