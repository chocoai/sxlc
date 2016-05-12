package cn.springmvc.service;
 
 
import product_p2p.kit.optrecord.InsertAdminLogEntity;
import cn.springmvc.model.ProjectPurposeEntity;
  
/**
 * 
* @author 刘利 
* @Description: 实现新增借款意向 
* @since 
* @date 2016-3-18 下午7:11:31
 */
public interface ProjectPurposeService {
	/**
	 * 新增借款意向
	 * @param entity 会员认证类型实体
	 * @return 0：数据为空;1:添加成功 -3;//黑名单会员禁止借款
	 */
	public int insertProjectPurpose(ProjectPurposeEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo); 
	/**
	 * 新增借款意向-前台会员
	 * @param entity 会员认证类型实体
	 * @return 0：数据为空;1:添加成功-1;//该会员未开通第三方-2;//该会员未授权二次分配授权 -3;//黑名单会员禁止借款
	 */
	public int insertProjectPurposeFront(ProjectPurposeEntity entity); 
	 
}
