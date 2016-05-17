package cn.springmvc.timer;

import java.util.TimerTask;

import cn.springmvc.dao.impl.IdGeneratorUtil;
import cn.springmvc.service.impl.BalanceDealUtil;


public class BalanceMngTimer extends TimerTask{
	BalanceDealUtil dealUtil = null;	//BalanceDealUtil.GetIdGeneratorInstance();
	@Override
	public void run() {
		try {
			if(dealUtil == null){
				dealUtil = BalanceDealUtil.GetIdGeneratorInstance();
			}
			dealUtil.MemberBalanceDeal();
			dealUtil.MemberAccountBalanceDeal();
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}
}
