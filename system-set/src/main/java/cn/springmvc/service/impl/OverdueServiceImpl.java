
package cn.springmvc.service.impl; 

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Service;

import product_p2p.kit.pageselect.PageEntity;
import product_p2p.kit.pageselect.PageUtil;

import cn.springmvc.dao.impl.HandleCreditorDaoImpl;
import cn.springmvc.dao.impl.HandleOverdueDaoImpl;
import cn.springmvc.dao.impl.HandleQuickRechargeFeeDaoImpl;
import cn.springmvc.dao.impl.IdGeneratorUtil;
import cn.springmvc.dao.impl.SelectCreditorDaoImpl;
import cn.springmvc.dao.impl.SelectOverdueDaoImpl;
import cn.springmvc.dao.impl.SelectQuickRechargeFeeDaoImpl;
import cn.springmvc.model.CreditorEntity;
import cn.springmvc.model.OverdueEntity;
import cn.springmvc.model.QuickRechargeFeeEntity;
import cn.springmvc.service.CreditorService;
import cn.springmvc.service.OverdueService;
import cn.springmvc.service.QuickRechargeFeeService;

/** 
 * 逾期设置 接口实现
* @author ZZY 
* @Description: TODO 
* @since 
* @date 2016-3-15 上午9:38:07  */
@Service("overdueServiceImpl")
public class OverdueServiceImpl implements OverdueService {
	@Resource(name="selectOverdueDaoImpl")
	private SelectOverdueDaoImpl  selectOverdueDaoImpl;
	@Resource(name="handleOverdueDaoImpl")
	private HandleOverdueDaoImpl  handleOverdueDaoImpl;
	
	/* * 
	 * 查询所有的逾期天数设置
	 *  *  * @return * @see cn.springmvc.service.OverdueService#findAllOverdue() */
	@Override
	public List<OverdueEntity> findAllOverdue(PageEntity pageEntity) {
		List<OverdueEntity> list = selectOverdueDaoImpl.findAllOverdue(pageEntity);
		PageUtil.ObjectToPage(pageEntity, list);
		return list;
	}

	
	/* * 
	 * 查询逾期程度
	 *  *  * @return * @see cn.springmvc.service.OverdueService#findOverdueLimit() */
	@Override
	public Integer findOverdueLimit() {
		
		// TODO Auto-generated method stub return 0;
		return selectOverdueDaoImpl.findOverdueLimit();
	}
	
	/* * 
	 * 查询最大的逾期天数 *  * @return * @see cn.springmvc.service.OverdueService#findMaxOverdue() */
	@Override
	public Integer findMaxOverdue() {
		
		// TODO Auto-generated method stub return null;
		return selectOverdueDaoImpl.findMaxOverdue();
	}

	
	/* *  
	 * 添加逾期程度
	 * *  * @param map
	 */
	/* *  *  * @return * @see cn.springmvc.service.OverdueService#insertOverdueLimit(java.util.Map) */
	@Override
	public int insertOverdueLimit(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return 0;
		return handleOverdueDaoImpl.insertOverdueLimit(map);
	}

	
	/* * 
	 * 修改逾期程度
	 *  *  * @param map
	 */
	/* *  *  * @return * @see cn.springmvc.service.OverdueService#updateOverdueLimit(java.util.Map) */
	@Override
	public int updateOverdueLimit(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return 0;
		return handleOverdueDaoImpl.updateOverdueLimit(map);
	}

	
	/* * 
	 * 添加逾期天数设置
	 *  *  * @param overdueEntity
	 */
	/* *  *  * @return * @see cn.springmvc.service.OverdueService#insertOverdue(cn.springmvc.model.OverdueEntity) */
	@Override
	public int insertOverdue(OverdueEntity overdueEntity) {
		IdGeneratorUtil generatorUtil = IdGeneratorUtil.GetIdGeneratorInstance();
		long id = generatorUtil.GetId();
		overdueEntity.setId((int)id);
		int result =  handleOverdueDaoImpl.insertOverdue(overdueEntity);
		if(result == 0) {
			generatorUtil.SetIdUsedFail(id);
		}else{
			generatorUtil.SetIdUsed(id);
		}
		return result;
	}

	
	/* * 
	 * 删除逾期天数设置
	 *  *  * @param map
	 */
	/* *  *  * @return * @see cn.springmvc.service.OverdueService#deleteOverdue(java.util.Map) */
	@Override
	public int deleteOverdue(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return 0;
		return handleOverdueDaoImpl.deleteOverdue(map);
	}
	

}

