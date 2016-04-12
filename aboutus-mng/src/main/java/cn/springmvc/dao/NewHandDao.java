package cn.springmvc.dao;
  
import cn.springmvc.model.NewHandEntity;
/**
 * 
* @author 刘利 
* @Description: 新手指南 
* @since 
* @date 2016-3-19 下午9:46:32
 */
public interface NewHandDao {
	/**
	 * 添加新手指南
	 * @param entity  新手指南实体类
	 * @return	0：失败	1：成功
	 */
	public int insertNewHand(NewHandEntity entity);
 
	/**
	 * 修改新手指南
	 * @param entity 新手指南实体
	 * @return  0:失败 1：成功 
	 */
	public  int  updateNewHand(NewHandEntity entity); 
	/**
	 * 删除新手指南 
	 * @return 0:失败 1：成功 
	 */
	public  int  deleteNewHand();

}
