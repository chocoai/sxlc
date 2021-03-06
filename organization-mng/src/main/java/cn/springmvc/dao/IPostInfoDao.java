package cn.springmvc.dao;




import java.util.List;

import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.model.PostInfo;

/***
 * 职务数据访问层
 * @author LiJie
 *
 */
public interface IPostInfoDao {
	
	
	
	
	
	
	
	/**
	 * 持久化一个职务信息
	 * @param info						职务实体
	 * @return							返回1当前职务名称已存在、0持久化成功
	 */
	public int savePost(PostInfo info);
	
	
	
	
	/***
	 * 修改某个职务信息 
	 * @param info						职务信息实体
	 * @return							
	 */
	public int editPost(PostInfo info);
	
	
	
	
	/***
	 * 删除某个职务
	 * @param info						职务信息实体
	 * @return							
	 */
	public int delPost(PostInfo info);
	
	
	
	/***
	 * 停用某个职位
	 * @param info						职务信息实体
	 * @return							
	 */
	public int ofPost(PostInfo info);
	
	
}
