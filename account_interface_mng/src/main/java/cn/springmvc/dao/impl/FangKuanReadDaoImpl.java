
package cn.springmvc.dao.impl; 

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import cn.springmvc.dao.FangKuanReadDao;
import cn.sxlc.account.manager.model.LoanTransactionEntity;

public class FangKuanReadDaoImpl extends SqlSessionDaoSupport implements FangKuanReadDao {

	@Override
	public String GetFangKuanOrderList(long lProId) {
		String sResult = "";
		List<LoanTransactionEntity> list = null;
		LoanTransactionEntity entity = null;
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("applyId", lProId);
		list = getSqlSession().selectList("FangKuanDao.GetProjectFangKuanOrderList", param);
		int iSize = 0;
		if(list!=null){
			iSize = list.size();
			int iCount = 0;
			for(int i=0;i<iSize;i++){
				entity = list.get(i);
				if(entity.getBillNo()==null || entity.getBillNo().equals("")){
					if(!sResult.equals("")){
						sResult = sResult + ",";
					}
					sResult = sResult+ entity.getBillNo();
					iCount ++;
				}
				if(entity.getGiftBillNo() ==null || entity.getGiftBillNo().equals("")){
					if(!sResult.equals("")){
						sResult = sResult + ",";
					}
					sResult = sResult+ entity.getGiftBillNo();
					iCount ++;
				}
				if(iCount>=200){
					break;
				}
			}
		}
		return sResult;
	}

}

