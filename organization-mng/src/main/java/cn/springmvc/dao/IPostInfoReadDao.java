package cn.springmvc.dao; 

import java.util.List;

import product_p2p.kit.pageselect.PageEntity;
import cn.springmvc.model.PostInfo;



/***
* 职务
* @author 李杰
* @Description: TODO 
* @since 
* @date 2016-4-20 上午11:31:34 
*
*/
public interface IPostInfoReadDao {

	
	
	/***
	 * 获取职务列表
	 * @param deptNo					部门编号
	 * @param postName					职务名称
	 * @return
	 */
	public List<PostInfo> getListByParam(PageEntity entity);
		
	
	
	/***
	* 根据编号获取职务信息
	* 
	* @author 李杰
	* @Title: findById
	* @param id
	* @return
	* @date 2016-4-20 上午11:34:14
	 */
	public PostInfo findById(long id);
	
}

