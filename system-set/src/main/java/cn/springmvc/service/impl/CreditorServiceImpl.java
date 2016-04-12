
package cn.springmvc.service.impl; 

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Service;

import cn.springmvc.dao.impl.HandleCreditorDaoImpl;
import cn.springmvc.dao.impl.HandleQuickRechargeFeeDaoImpl;
import cn.springmvc.dao.impl.SelectCreditorDaoImpl;
import cn.springmvc.dao.impl.SelectQuickRechargeFeeDaoImpl;
import cn.springmvc.model.CreditorEntity;
import cn.springmvc.model.QuickRechargeFeeEntity;
import cn.springmvc.service.CreditorService;
import cn.springmvc.service.QuickRechargeFeeService;

/** 
 * 债权转让设置 接口实现
* @author ZZY 
* @Description: TODO 
* @since 
* @date 2016-3-15 上午9:38:07  */
@Service("creditorServiceImpl")
public class CreditorServiceImpl implements
		CreditorService {
	@Resource(name="selectCreditorDaoImpl")
	private SelectCreditorDaoImpl  selectCreditorDaoImpl;
	
	@Resource(name="handleCreditorDaoImpl")
	private HandleCreditorDaoImpl  handleCreditorDaoImpl;
	
	/* * 
	 * 债权转让设置查询
	 *  
	 *  *  * @return * @see cn.springmvc.service.CreditorService#findAllCreditor() */
	@Override
	public CreditorEntity findAllCreditor() {
		// TODO Auto-generated method stub return null;
		return selectCreditorDaoImpl.findAllCreditor();
	}


	
	/* *  
	 * 添加债权转让设置
	 * *  * @param creditorEntity
	 */
	/* *  *  * @return * @see cn.springmvc.service.CreditorService#inserCreditor(cn.springmvc.model.CreditorEntity) */
	@Override
	public int inserCreditor(CreditorEntity creditorEntity) {
		
		// TODO Auto-generated method stub return 0;
		return handleCreditorDaoImpl.inserCreditor(creditorEntity);
	}



	
	/* * 
	 * 修改债权转让设置
	 *  
	 *  *  * @param map
	 *  holdDay;//	债权持有时间大于天数
	 *	rangeDay;//	债权距到期日大于天数
	 *	interestDay;//	转让日在付息日前天数
	 *	mngFee;	//债权转让手续费 （百万分之 / 分
	 *	mngType;//	手续费收取方向（0：转让人:1：购买人:2：全部）
	 *	checkType;//	是否需要审核 0：否 1：是
	 *	loanType;	// 放款方式 0：自动放款 1：手动放款
	 *	interestType;//利息生成方式 0：整期生成 1：按照转让时间点生成
	 *  type;// 0:债权转让手续费设置 1债权转让审核是否需要审核 2:债权转让放款是否需要手动放款 3:债权转让利息生成方式
	 *  
	 */
	/* *  *  * @return * @see cn.springmvc.service.CreditorService#updateCreditor(java.util.Map) */
	@Override
	public int updateCreditor(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return 0;
		return handleCreditorDaoImpl.updateCreditor(map);
	}
	

}

