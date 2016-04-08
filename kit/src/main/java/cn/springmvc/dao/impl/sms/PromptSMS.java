package cn.springmvc.dao.impl.sms;

/**
 * 漫道发送短信返回值
* @author 张友 
* @Description: TODO 
* @since 
* @date 2016-3-25 下午2:03:35
 */
public class PromptSMS {
	/*
	 * 	-2 	帐号/密码不正确  -4	余额不足支持本次发送  -5 数据格式错误  -6 参数有误  -7 权限受限   -8 流量控制错误  -9 扩展码权限错误
	 *	-10	内容长度长  -11	内部数据库错误  -12	序列号状态错误  -14	服务器写文件失败  -17 没有权限  -19 禁止同时使用多个接口地址
	 *  -20 相同手机号，相同内容重复提交  -22 Ip鉴权失败  -23 缓存无此序列号信息
	 *	-601	序列号为空，参数错误  -602 序列号格式错误，参数错误  -603 密码为空，参数错误  -604 手机号码为空，参数错误
	 *	-605	内容为空，参数错误  -606 ext长度大于9，参数错误  -607 参数错误扩展码非数字  -608 参数错误定时时间非日期格式
	 *	-609	rrid长度大于18,参数错误  -610 参数错误rrid非数字  -611 参数错误内容编码不符合规范  -623 手机个数与内容个数不匹配
	 *	-624	扩展个数与手机个数数  -644 Rrid个数与手机号个数不一致
	 * 
	 */
	public static String GetSmsSendStatu(int iStatu){
		String sResult = "";
		switch (iStatu) {
		case 0:{
			sResult = "发送成功";
			break;
		}
		case -2:{
			sResult = "帐号/密码不正确";
			break;
		}
		case -4:{
			sResult = "余额不足支持本次发送";
			break;
		}
		case -5:{
			sResult = "数据格式错误";
			break;
		}
		case -6:{
			sResult = "参数有误";
			break;
		}
		case -7:{
			sResult = "权限受限";
			break;
		}
		case -8:{
			sResult = "流量控制错误";
			break;
		}
		case -9:{
			sResult = "扩展码权限错误";
			break;
		}
		case -10:{
			sResult = "内容长度长";
			break;
		}
		case -11:{
			sResult = "内部数据库错误";
			break;
		}
		case -12:{
			sResult = "序列号状态错误";
			break;
		}
		case -14:{
			sResult = "服务器写文件失败";
			break;
		}
		case -17:{
			sResult = "没有权限";
			break;
		}
		case -19:{
			sResult = "禁止同时使用多个接口地址";
			break;
		}
		case -20:{
			sResult = "相同手机号，相同内容重复提交";
			break;
		}
		case -22:{
			sResult = "Ip鉴权失败";
			break;
		}
		case -23:{
			sResult = "缓存无此序列号信息";
			break;
		}
		case -601:{
			sResult = "序列号为空，参数错误";
			break;
		}
		case -602:{
			sResult = "序列号格式错误，参数错误";
			break;
		}
		case -603:{
			sResult = "密码为空，参数错误";
			break;
		}
		case -604:{
			sResult = "手机号码为空，参数错误";
			break;
		}
		case -605:{
			sResult = "内容为空，参数错误";
			break;
		}
		case -606:{
			sResult = "ext长度大于9，参数错误";
			break;
		}
		case -607:{
			sResult = "参数错误扩展码非数字";
			break;
		}
		case -608:{
			sResult = "参数错误定时时间非日期格式";
			break;
		}
		case -609:{
			sResult = "rrid长度大于18,参数错误";
			break;
		}
		case -610:{
			sResult = "参数错误rrid非数字";
			break;
		}
		case -611:{
			sResult = "参数错误内容编码不符合规范";
			break;
		}
		case -623:{
			sResult = "手机个数与内容个数不匹配";
			break;
		}
		case -624:{
			sResult = "扩展个数与手机个数数";
			break;
		}
		case -644:{
			sResult = "Rrid个数与手机号个数不一致";
			break;
		}
		default:
			break;
		}
		return sResult;
	}
	
}
