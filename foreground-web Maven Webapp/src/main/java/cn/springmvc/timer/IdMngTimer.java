package cn.springmvc.timer;

import java.util.TimerTask;

import cn.springmvc.dao.impl.IdGeneratorUtil;


public class IdMngTimer extends TimerTask{
	IdGeneratorUtil idMng = null;
	@Override
	public void run() {
		try {
			if(idMng == null){
				idMng = IdGeneratorUtil.GetIdGeneratorInstance();
			}
			idMng.IdFileMng();
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}

	/**
	 * @param args
	 */
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub

	}*/
}
