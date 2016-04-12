
package cn.springmvc.Util; 

import java.util.List;

import javax.servlet.http.HttpSession;

import javax.servlet.http.HttpServletRequest;

import cn.springmvc.model.Module;
import cn.springmvc.model.Operation;

/**
 * 当前登录管理员权限判断
* @author 张友 
* @Description: TODO 
* @since 
* @date 2016-4-7 下午4:12:21
 */
public class AdminRightsMng {
	
	/**
	 * 验证当前登录管理员是否有本次操作权限
	* LoginAdminRightsCheck	验证当前登录管理员是否有本次操作权限
	* TODO(描述)
	* @author 张友  
	* * @Title: LoginAdminRightsCheck 
	* @Description: TODO 
	* @param @param request
	* @param @param lModId
	* @param @param lOptId
	* @param @return 设定文件 
	* @return int	0:无 1：有
	* @date 2016-4-7 下午4:14:51
	* @throws 无
	 */
	public static int LoginAdminRightsCheck(HttpServletRequest request,long lModId,long lOptId){
		int iResult = 0;
		
		if(request == null || (lModId<=0 && lOptId<=0)){
			return iResult;
		}
		
		HttpSession session = request.getSession();
		List<Module> modList = (List<Module>)session.getAttribute("modulelist");
		List<Operation> optList = (List<Operation>)session.getAttribute("operationList");
		
		if(lOptId >0){
			if(optList==null){
				return iResult;
			}
			int iSize = optList.size();
			Operation opt = null;
			for(int i=0;i<iSize;i++){
				opt = optList.get(i);
				if(opt.getOptID() == lOptId){
					iResult = 1;
					break;
				}
			}
		}else{
			if(modList==null){
				return iResult;
			}
			int iSize = modList.size();
			Module module = null;
			for(int i=0;i<iSize;i++){
				module = modList.get(i);
				if(module.getModuleId().longValue() == lModId){
					iResult = 1;
					break;
				}
			}
		}
		
		return iResult;
	}
}

