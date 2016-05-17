package cn.springmvc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import cn.membermng.model.MemberTradingIdEntity;
import cn.springmvc.dao.impl.BalanceDealDaoImpl;


/**
 * 会员余额处理
* @author 张友 
* @Description: TODO 
* @since 
* @date 2016-5-5 下午8:11:31
 */
@Controller("BalanceDealUtil")
public class BalanceDealUtil {
	@Resource(name="balanceDealDaoImpl")
	private BalanceDealDaoImpl balanceDealDaoImpl;
	private static BalanceDealUtil idGeneratorUtil=null;
	public BalanceDealUtil(){
	    if(idGeneratorUtil == null){
			idGeneratorUtil = this;
		}
	}
	public static BalanceDealUtil GetIdGeneratorInstance(){
		if(idGeneratorUtil == null){
			idGeneratorUtil = new BalanceDealUtil();
		}
		return idGeneratorUtil;
	}
	
	/**
	 * 会员余额处理
	* MemberBalanceDeal			会员余额处理
	* TODO(描述)
	* @author 张友  
	* * @Title: MemberBalanceDeal 
	* @Description: TODO 
	* @param   
	* @return void 返回类型 
	* @date 2016-5-5 下午8:18:26
	* @throws
	 */
	public void MemberBalanceDeal(){
		List<MemberTradingIdEntity> list = balanceDealDaoImpl.GetUnDealRecordList();
		int iSize = 0;
		if(list != null){
			iSize = list.size();
		}
		MemberTradingIdEntity entity = null;
		for(int i=0;i<iSize;i++){
			entity = list.get(i);
			balanceDealDaoImpl.MemberBalanceDeal(entity.getlId());
		}
	}
	
	/**
	 * 会员账户余额处理
	* MemberAccountBalanceDeal				会员账户余额处理
	* TODO									会员账户余额处理
	* @author 张友  
	* * @Title: MemberAccountBalanceDeal 
	* @Description: TODO 
	* @param  设定文件 
	* @return void
	* @date 2016-5-5 下午9:50:24
	* @throws
	 */
	public void MemberAccountBalanceDeal(){
		List<MemberTradingIdEntity> list = balanceDealDaoImpl.GetUnDealAccountRecordList();
		int iSize = 0;
		if(list != null){
			iSize = list.size();
		}
		MemberTradingIdEntity entity = null;
		for(int i=0;i<iSize;i++){
			entity = list.get(i);
			balanceDealDaoImpl.MemberAccountDeal(entity.getlId());	//MemberBalanceDeal(entity.getlId());
		}
	}
}
