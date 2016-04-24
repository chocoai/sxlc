package cn.springmvc.controller.config; 

import java.util.HashMap;
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
import cn.springmvc.model.CreditLevelEntity;
import cn.springmvc.model.MemberLevelEntity;
import cn.springmvc.service.LevelSetService;
import cn.springmvc.util.HttpSessionUtil;
import cn.springmvc.util.LoadUrlUtil;

/** 
* @author 唐国峰
* @Description: 会员等级设置控制器  
* @date 2016-4-14 上午11:26:49 
*/
@Controller
@RequestMapping("config")
public class MemberLevelController {
	
	@Resource(name="levelSetServiceImpl")
	private LevelSetService levelSetService;
	
	/** 
	 * @author 唐国峰 
	 * @Description: 跳转到会员等级设置页面
	 * @param req
	 * @return String  
	 * @date 2016-4-14 上午11:50:49
	 * @throws 
	 */
	@RequestMapping("/toMemberGradeList")
	public String toMemberGradeList(HttpServletRequest req){
		return "config/member-grade";
	}
	
	/** 
	 * @author 唐国峰 
	 * @Description: 获取会员等级信息
	 * @return PageEntity  
	 * @date 2016-4-14 下午12:31:25
	 * @throws 
	 */
	@RequestMapping("/getMemberLevel")
	@ResponseBody
	public PageEntity getMemberLevel(HttpServletRequest req){
		int start = Integer.parseInt(req.getParameter("start"));
		int length = Integer.parseInt(req.getParameter("length"));
		PageEntity pager = new PageEntity();
		Map<String,Object> param=new HashMap<String,Object>();
		pager.setMap(param);
		pager.setPageNum(start/length+1);
		pager.setPageSize(length);
		levelSetService.selectAllMemberLevel(pager);
		return pager;
	}
	
	/** 
	 * @author 唐国峰 
	 * @Description: 添加会员等级
	 * @return int  
	 * @date 2016-4-14 下午3:03:55
	 * @throws 
	 */
	@RequestMapping("/addMemberLevel")
	@ResponseBody
	public int addMemberLevel(HttpServletRequest req){
		//操作日志参数
		HttpSession session = HttpSessionUtil.getSession(req);
		Admin admin = (Admin)session.getAttribute("LoginPerson");
		//moduleID=605(会员等级设置)
		//optID=60501(添加)
		InsertAdminLogEntity logEntity = new InsertAdminLogEntity();
		String [] sIpInfo = new String[8];
		logEntity.setiAdminId(admin.getId());
		logEntity.setlModuleId(605);
		logEntity.setlOptId(60501);
		logEntity.setsIp(AddressUtils.GetRemoteIpAddr(req, sIpInfo));
		logEntity.setsMac(null);
		logEntity.setsUrl(LoadUrlUtil.getFullURL(req));
		
		MemberLevelEntity entity = new MemberLevelEntity();
		String levelMark = req.getParameter("levelMark");
		entity.setLevelMark(levelMark);
		int scoreMin = Integer.parseInt(req.getParameter("scoreMin"));
		entity.setScoreMin(scoreMin);
		int scoreMax = Integer.parseInt(req.getParameter("scoreMax"));
		entity.setScoreMax(scoreMax);
		String levelDetail = req.getParameter("levelDetail");
		entity.setLevelDetail(levelDetail);
		int result=0;
		result = levelSetService.insertMemberLevel(entity,logEntity,sIpInfo);
		return result;
	}
	
	/** 
	 * @author 唐国峰 
	 * @Description: 删除会员等级
	 * @param id 会员等级id
	 * @return int  
	 * @date 2016-4-14 下午3:04:00
	 * @throws 
	 */
	@RequestMapping("/delMemberLevel")
	@ResponseBody
	public int delMemberLevel(HttpServletRequest req){
		//操作日志参数
		HttpSession session = HttpSessionUtil.getSession(req);
		Admin admin = (Admin)session.getAttribute("LoginPerson");
		//moduleID=605(会员等级设置)
		//optID=60502(删除)
		InsertAdminLogEntity logEntity = new InsertAdminLogEntity();
		String [] sIpInfo = new String[8];
		logEntity.setiAdminId(admin.getId());
		logEntity.setlModuleId(605);
		logEntity.setlOptId(60502);
		logEntity.setsIp(AddressUtils.GetRemoteIpAddr(req, sIpInfo));
		logEntity.setsMac(null);
		logEntity.setsUrl(LoadUrlUtil.getFullURL(req));
		
		String id = req.getParameter("id");
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("id", id);
		int result=0;
		result = levelSetService.deleteMemberLevelById(map,logEntity,sIpInfo);
		return result;
	}
	

	/** 
	 * @author 唐国峰 
	 * @Description: 跳转到会员信用等级设置页面
	 * @param req
	 * @return String  
	 * @date 2016-4-14 下午2:26:20
	 * @throws 
	 */
	@RequestMapping("/toMemberCreditList")
	public String toMemberCreditList(HttpServletRequest req){
		return "config/member-credit-grade";
	}
	
	
	
	/** 
	 * @author 唐国峰 
	 * @Description: 获取会员信用等级
	 * @param start
	 * @param length
	 * @return PageEntity  
	 * @date 2016-4-14 下午3:28:48
	 * @throws 
	 */
	@RequestMapping("/getCreditLevel")
	@ResponseBody
	public PageEntity getCreditLevel(HttpServletRequest req){
		int start = Integer.parseInt(req.getParameter("start"));
		int length = Integer.parseInt(req.getParameter("length"));
		PageEntity pager = new PageEntity();
		Map<String,Object> param=new HashMap<String,Object>();
		pager.setMap(param);
		pager.setPageNum(start/length+1);
		pager.setPageSize(length);
		levelSetService.selectAllCreditLevel(pager);
		return pager;
	}
	
	
	/** 
	 * @author 唐国峰 
	 * @Description: 新增会员信用等级
	 * @param entity
	 * @return int  
	 * @date 2016-4-14 下午3:30:31
	 * @throws 
	 */
	@RequestMapping("/addCreditLevel")
	@ResponseBody
	public int addCreditLevel(HttpServletRequest req){
		//操作日志参数
		HttpSession session = HttpSessionUtil.getSession(req);
		Admin admin = (Admin)session.getAttribute("LoginPerson");
		//moduleID=606(会员信用等级配置)
		//optID=60601(添加)
		InsertAdminLogEntity logEntity = new InsertAdminLogEntity();
		String [] sIpInfo = new String[8];
		logEntity.setiAdminId(admin.getId());
		logEntity.setlModuleId(606);
		logEntity.setlOptId(60601);
		logEntity.setsIp(AddressUtils.GetRemoteIpAddr(req, sIpInfo));
		logEntity.setsMac(null);
		logEntity.setsUrl(LoadUrlUtil.getFullURL(req));
		
		CreditLevelEntity entity = new CreditLevelEntity();
		String levelMark = req.getParameter("levelMark");
		entity.setLevelMark(levelMark);
		int creditScoreMin = Integer.parseInt(req.getParameter("creditScoreMin"));
		entity.setCreditScoreMin(creditScoreMin);
		int creditScoreMax = Integer.parseInt(req.getParameter("creditScoreMax"));
		entity.setCreditScoreMax(creditScoreMax);
		String levelDetail = req.getParameter("levelDetail");
		entity.setLevelDetail(levelDetail);
		//查询数据库中已有最大的分数
		int maxScore = levelSetService.selectMaxScore();
		if(maxScore>entity.getCreditScoreMin()){
			return -1;
		}
		int result=0;
		result = levelSetService.insertCreditLevel(entity,logEntity,sIpInfo);
		return result;
	}
	
	
	/** 
	 * @author 唐国峰 
	 * @Description: 删除会员信用等级
	 * @param id
	 * @return int  
	 * @date 2016-4-14 下午3:38:57
	 * @throws 
	 */
	@RequestMapping("/delCreditLevel")
	@ResponseBody
	public int delCreditLevel(HttpServletRequest req){
		//操作日志参数
		HttpSession session = HttpSessionUtil.getSession(req);
		Admin admin = (Admin)session.getAttribute("LoginPerson");
		//moduleID=606(会员信用等级配置)
		//optID=60602(删除)
		InsertAdminLogEntity logEntity = new InsertAdminLogEntity();
		String [] sIpInfo = new String[8];
		logEntity.setiAdminId(admin.getId());
		logEntity.setlModuleId(606);
		logEntity.setlOptId(60602);
		logEntity.setsIp(AddressUtils.GetRemoteIpAddr(req, sIpInfo));
		logEntity.setsMac(null);
		logEntity.setsUrl(LoadUrlUtil.getFullURL(req));
		
		String id = req.getParameter("id");
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("id", id);
		int result=0;
		result = levelSetService.deleteCreditLevelById(map,logEntity,sIpInfo);
		return result;
	}
}

