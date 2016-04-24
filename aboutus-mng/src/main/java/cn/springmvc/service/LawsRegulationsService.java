package cn.springmvc.service;

import product_p2p.kit.optrecord.InsertAdminLogEntity;
import cn.springmvc.model.LawsRegulationsEntity;
 
/**
 * 
* @author 刘利 
* @Description: 法律法规 
* @since 
* @date 2016-3-19 下午10:06:40
 */
public interface LawsRegulationsService {
	/**
	 * 新增法律法规
	 * @param entity 法律法规实体
	 * @return -1：数据为空;0：添加失败;1:添加成功
	 */
	public int insertLawsRegulations(LawsRegulationsEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo); 
	/**
	 * 删除法律法规
	 * @param id 法律法规id
	 * @return 0：失败；1成功
	 */
	public int deleteLawsRegulations(int id,InsertAdminLogEntity 
			logentity,String[] sIpInfo);  
	/**
	 * 停用或启用法律法规信息
	 * @param entity 法律法规实体  statu(0:无效 1：有效) ,id
	 * @return 0:失败 1：成功 
	 */
	public  int  updateLawsRegulationsStatuByID(LawsRegulationsEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo);
	/**
	 * 查询法律法规 
	 * param statu状态 statu(0:无效 1：有效,-1全部)
	 * @return LawsRegulationsEntity 法律法规实体
	 */
	public  LawsRegulationsEntity selectLawsRegulationsList(int statu);
}
