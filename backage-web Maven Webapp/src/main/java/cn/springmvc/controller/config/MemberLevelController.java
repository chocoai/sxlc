package cn.springmvc.controller.config; 

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import product_p2p.kit.pageselect.PageEntity;
import cn.springmvc.model.CreditLevelEntity;
import cn.springmvc.model.MemberLevelEntity;
import cn.springmvc.service.LevelSetService;

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
	 * @Description: 
	 * @param start
	 * @param length
	 * @return PageEntity  
	 * @date 2016-4-14 下午12:31:25
	 * @throws 
	 */
	@RequestMapping("/getMemberLevel")
	@ResponseBody
	public PageEntity getMemberLevel(int start,int length){
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
	 * @param entity
	 * @return int  
	 * @date 2016-4-14 下午3:03:55
	 * @throws 
	 */
	@RequestMapping("/addMemberLevel")
	@ResponseBody
	public int addMemberLevel(MemberLevelEntity entity){
		int result=0;
		result = levelSetService.insertMemberLevel(entity);
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
	public int delMemberLevel(String id){
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("id", id);
		int result=0;
		result = levelSetService.deleteMemberLevelById(map);
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
	public PageEntity getCreditLevel(int start,int length){
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
	public int addCreditLevel(CreditLevelEntity entity){
		int maxScore = levelSetService.selectMaxScore();
		if(maxScore>entity.getCreditScoreMin()){
			return -1;
		}
		int result=0;
		result = levelSetService.insertCreditLevel(entity);
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
	public int delCreditLevel(String id){
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("id", id);
		int result=0;
		result = levelSetService.deleteCreditLevelById(map);
		return result;
	}
}

