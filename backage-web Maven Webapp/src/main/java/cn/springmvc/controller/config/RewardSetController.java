package cn.springmvc.controller.config; 

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import product_p2p.kit.HttpIp.AddressUtils;
import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.model.Admin;
import cn.springmvc.model.MediaReportsEntity;
import cn.springmvc.model.MngTeamEntity;
import cn.springmvc.model.RewardSetEntity;
import cn.springmvc.service.RewarSetService;
import cn.springmvc.util.HttpSessionUtil;
import cn.springmvc.util.LoadUrlUtil;

/** 
* @author 唐国峰
* @Description:  提奖设置控制器
* @date 2016-4-25 下午1:46:00 
*/
@Controller
@RequestMapping("/config")
public class RewardSetController {
	
	@Resource(name="rewarSetServiceImpl")
	private RewarSetService rewarSetService;
	
	
	/** 
	 * @author 唐国峰 
	 * @Description: 跳转到理财顾问提奖设置页面
	 * @param req
	 * @return String  
	 * @date 2016-4-25 下午1:50:42
	 * @throws 
	 */
	@RequestMapping("/toFinadvSetting")
	public String toFinadvSetting(HttpServletRequest req){
		PageEntity pager = new PageEntity();
		Map<String,Object> param=new HashMap<String,Object>();
		param.put("type", 1);
		pager.setMap(param);
		List<RewardSetEntity> rewards = rewarSetService.selectRewarSetByType(pager);
		req.setAttribute("rewards", rewards.get(0));
		return "config/finadv-setting";
	}
	
	
	/** 
	 * @author 唐国峰 
	 * @Description: 修改理财顾问提奖设置
	 * @param req
	 * @return String  
	 * @date 2016-4-25 下午3:52:55
	 * @throws 
	 */
	@RequestMapping("/updateRewarSet")
	@ResponseBody
	public int updateRewarSet(HttpServletRequest req){
		//操作日志参数
		HttpSession session = HttpSessionUtil.getSession(req);
		Admin admin = (Admin)session.getAttribute("LoginPerson");
		//moduleID=60107(理财顾问提奖设置)
		//optID=6010701 修改
		InsertAdminLogEntity logEntity = new InsertAdminLogEntity();
		String [] sIpInfo = new String[8];
		logEntity.setiAdminId(admin.getId());
		logEntity.setlModuleId(60107);
		logEntity.setlOptId(6010701);
		logEntity.setsIp(AddressUtils.GetRemoteIpAddr(req, sIpInfo));
		logEntity.setsMac(null);
		logEntity.setsUrl(LoadUrlUtil.getFullURL(req));
		
		RewardSetEntity entity = new RewardSetEntity();
		//获取解密参数
		Long id = Long.parseLong(req.getParameter("id"));
		entity.setId(id);
		int vIPReward = Integer.parseInt(req.getParameter("vIPReward"));
		entity.setvIPReward(vIPReward);
		int borrowReward = Integer.parseInt(req.getParameter("borrowReward"));
		entity.setBorrowReward(borrowReward);
		int repayReward = Integer.parseInt(req.getParameter("repayReward"));
		entity.setRepayReward(repayReward);
		int investReward = Integer.parseInt(req.getParameter("investReward"));
		entity.setInvestReward(investReward);
		int type = Integer.parseInt(req.getParameter("type"));
		entity.setType(type);//提奖设置类型 1:理财顾问 0：推荐达人
		int result=0;
		result = rewarSetService.updateRewarSet(entity, logEntity, sIpInfo);
		return result;
	}
	
	
	/** 
	 * @author 唐国峰 
	 * @Description: 跳转到推荐达人提奖设置页面
	 * @param req
	 * @return String  
	 * @date 2016-4-25 下午5:15:43
	 * @throws 
	 */
	@RequestMapping("/toRectalSetList")
	public String toRectalSetList(HttpServletRequest req){
		return "config/rectal-setting";
	}
	
	
	/** 
	 * @author 唐国峰 
	 * @Description: 推荐达人提奖设置页面表格数据
	 * @param req
	 * @return String  
	 * @date 2016-4-25 下午5:21:14
	 * @throws 
	 */
	@RequestMapping("/getRectalSetData")
	@ResponseBody
	public PageEntity getRectalSetData(HttpServletRequest req){
		int start = Integer.parseInt(req.getParameter("start"));
		int length = Integer.parseInt(req.getParameter("length"));
		PageEntity pager = new PageEntity();
		Map<String,Object> param=new HashMap<String,Object>();
		param.put("type", 0);
		pager.setMap(param);
		pager.setPageNum(start/length+1);
		pager.setPageSize(length);
		rewarSetService.selectRewarSetByType(pager);
		return pager;
	}
	
	
	
	/** 
	 * @author 唐国峰 
	 * @Description: 新增或修改
	 * @param req
	 * @return int  
	 * @date 2016-4-26 下午2:45:53
	 * @throws 
	 */
	@RequestMapping("/addOrUpdateReward")
	@ResponseBody
	public int addOrUpdateReward(HttpServletRequest req){
		//操作日志参数
		HttpSession session = HttpSessionUtil.getSession(req);
		Admin admin = (Admin)session.getAttribute("LoginPerson");
		//moduleID=60106(推荐达人提奖设置)
		//optID=6010601(添加） 6010602(修改）
		InsertAdminLogEntity logEntity = new InsertAdminLogEntity();
		String [] sIpInfo = new String[8];
		logEntity.setiAdminId(admin.getId());
		logEntity.setlModuleId(60106);
		logEntity.setsIp(AddressUtils.GetRemoteIpAddr(req, sIpInfo));
		logEntity.setsMac(null);
		logEntity.setsUrl(LoadUrlUtil.getFullURL(req));
		
		RewardSetEntity entity = new  RewardSetEntity();
		String gradeName = req.getParameter("gradeName");
		entity.setGradeName(gradeName);
		Long totalInvest = Long.parseLong(req.getParameter("totalInvest"));
		entity.setTotalInvest(totalInvest);
		String gradeRemark = req.getParameter("gradeRemark");
		entity.setGradeRemark(gradeRemark);
		int vIPReward = Integer.parseInt(req.getParameter("vIPReward"));
		entity.setvIPReward(vIPReward);
		int borrowReward = Integer.parseInt(req.getParameter("borrowReward"));
		entity.setBorrowReward(borrowReward);
		int repayReward = Integer.parseInt(req.getParameter("repayReward"));
		entity.setRepayReward(repayReward);
		int investReward = Integer.parseInt(req.getParameter("investReward"));
		entity.setInvestReward(investReward);
		
		int result=0;
		entity.setStatu(1);
		
		String type = req.getParameter("type");//操作类型
		if(type.equals("1")){//增加操作
			logEntity.setlOptId(6010601);
			result = rewarSetService.insertRewarSet(entity,logEntity,sIpInfo);
		}else if(type.equals("2")){//修改操作
			logEntity.setlOptId(6010602);
			Long reportId = Long.parseLong(req.getParameter("reportId"));
			entity.setId(reportId);
			result = rewarSetService.updateRewarSet(entity,logEntity,sIpInfo);
		}
		return result;
	}
	
	
	/** 
	 * @author 唐国峰 
	 * @Description: 启用/停用推荐达人提奖设置
	 * @param req
	 * @return int  
	 * @date 2016-4-26 上午9:26:01
	 * @throws 
	 */
	@RequestMapping("/enableRewardSet")
	@ResponseBody
	public int enableRewardSet(HttpServletRequest req){
		//操作日志参数
		HttpSession session = HttpSessionUtil.getSession(req);
		Admin admin = (Admin)session.getAttribute("LoginPerson");
		//moduleID=60106(推荐达人提奖设置)
		//optID=6010603(停用/启用）
		InsertAdminLogEntity logEntity = new InsertAdminLogEntity();
		String [] sIpInfo = new String[8];
		logEntity.setiAdminId(admin.getId());
		logEntity.setlModuleId(60106);
		logEntity.setlOptId(6010603);
		logEntity.setsIp(AddressUtils.GetRemoteIpAddr(req, sIpInfo));
		logEntity.setsMac(null);
		logEntity.setsUrl(LoadUrlUtil.getFullURL(req));
		
		RewardSetEntity entity = new  RewardSetEntity();
//		int statu = Integer.parseInt(req.getParameter("statu"));
//		entity.setStatu(statu);
		Long id = Long.parseLong(req.getParameter("id"));
		entity.setId(id);
		int result=0;
		result = rewarSetService.deleteRewarSet(entity,logEntity,sIpInfo);
		return result;
	}
	
}

