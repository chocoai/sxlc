package cn.springmvc.dao;

import cn.springmvc.model.LawsRegulationsEntity;
/**
 * 
* @author 刘利 
* @Description: 查询法律法规 
* @since 
* @date 2016-3-19 下午9:43:54
 */
public interface LawsRegulationsListDao {
	/**
	 * 查询法律法规
	 * @param statu 状态
	 * @return
	 */
	public  LawsRegulationsEntity  selectLawsRegulations(int statu); 
	/**
	 * 查询法律法规是否存在 
	 * @return  0：不存在	大于0：存在
	 */
	public  int  selectLawsRegulationsIsExist();
}
