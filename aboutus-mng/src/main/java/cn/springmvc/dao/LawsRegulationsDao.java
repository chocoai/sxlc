package cn.springmvc.dao;
  
import cn.springmvc.model.LawsRegulationsEntity;
/**
 * 
* @author 刘利 
* @Description: 法律法规
* @since 
* @date 2016-3-19 下午9:43:47
 */
public interface LawsRegulationsDao {
	/**
	 * 添加法律法规
	 * @param entity  法律法规实体类
	 * @return	0：失败	1：成功
	 */
	public int insertLawsRegulations(LawsRegulationsEntity entity);
 
	/**
	 * 通过ID修改法律法规
	 * @param entity 法律法规实体
	 * @return  0:失败 1：成功 
	 */
	public  int  updateLawsRegulationsByID(LawsRegulationsEntity entity); 
	/**
	 * 通过ID删除法律法规
	 * @param id 法律法规id
	 * @return 0:失败 1：成功 
	 */
	public  int  deleteLawsRegulationsByID(int id);   
	/**
	 * 停用或启用法律法规
	 * @param entity 法律法规实体
	 * @return 0:失败 1：成功 
	 */
	public  int  updateLawsRegulationsStatuByID(LawsRegulationsEntity entity);

}
