package cn.springmvc.dao.impl.sms;

/**
 * 亿美短信发送返回值
 * @author xq
 */
public class SDKerrorInfo {
	
	/**
	 * @param Num 返回码
	 * @return 描述
	 */
	public static String getSDKResultInfo(String Num){
		String massege = "";
		int NumInt = Integer.parseInt(Num);
		switch (NumInt) {
		case -1:
			massege = "系统异常";
		    break;
		case -2:
			massege = "客户端异常";
		    break;
		case -101:
			massege = "命令不被支持";
		    break;
		case -102:
			massege = "RegistryTransInfo删除信息失败";
		    break;
		case -103:
			massege = "RegistryInfo更新信息失败";
		    break;
		case -104:
			massege = "请求超过限制";
		    break;
		case -110:
			massege = "号码注册激活失败";
		    break;
		case -111:
			massege = "企业注册失败";
		    break;
		case -113:
			massege = "充值失败";
		    break;
		case -117:
			massege = "发送短信失败";
		    break;
		case -118:
			massege = "接收MO失败";
		    break;
		case -119:
			massege = "接收Report失败";
		    break;
		case -120:
			massege = "修改密码失败";
		    break;
		case -122:
			massege = "号码注销激活失败";
		    break;
		case -123:
			massege = "查询单价失败";
		    break;
		case -124:
			massege = "查询余额失败";
		    break;
		case -125:
			massege = "设置MO转发失败";
		    break;
		case -126:
			massege = "路由信息失败";
		    break;
		case -127:
			massege = "计费失败0余额";
		    break;
		case -128:
			massege = "计费失败余额不足";
		    break;
		case -190:
			massege = "数据操作失败";
		    break;
		case -1100:
			massege = "序列号错误,序列号不存在内存中,或尝试攻击的用户";
		    break;
		case -1102:
			massege = "序列号密码错误";
		    break;
		case -1103:
			massege = "序列号Key错误";
		    break;
		case -1104:
			massege = "路由失败，请联系系统管理员";
		    break;
		case -1105:
			massege = "注册号状态异常, 未用 1";
		    break;
		case -1107:
			massege = "注册号状态异常, 停用 3";
		    break;
		case -1108:
			massege = "注册号状态异常, 停止 5";
		    break;
		case -1131:
			massege = "充值卡无效";
		    break;
		case -1132:
			massege = "充值密码无效";
		    break;
		case -1133:
			massege = "充值卡绑定异常";
		    break;
		case -1134:
			massege = "充值状态无效";
		    break;
		case -1135:
			massege = "充值金额无效";
		    break;
		case -1901:
			massege = "数据库插入操作失败";
		    break;
		case -1902:
			massege = "数据库更新操作失败";
		    break;
		case -1903:
			massege = "数据库删除操作失败";
		    break;
		case -9000:
			massege = "数据格式错误,数据超出数据库允许范围";
		    break;
		case -9001:
			massege = "序列号格式错误";
		    break;
		case -9002:
			massege = "密码格式错误";
		    break;
		case -9003:
			massege = "客户端Key格式错误";
		    break;
		case -9004:
			massege = "设置转发格式错误";
		    break;
		case -9005:
			massege = "公司地址格式错误";
		    break;
		case -9006:
			massege = "企业中文名格式错误";
		    break;
		case -9007:
			massege = "企业中文名简称格式错误";
		    break;
		case -9008:
			massege = "邮件地址格式错误";
		    break;
		case -9009:
			massege = "企业英文名格式错误";
		    break;
		case -9010:
			massege = "企业英文名简称格式错误";
		    break;
		case -9011:
			massege = "传真格式错误";
		    break;
		case -9012:
			massege = "联系人格式错误";
		    break;
		case -9013:
			massege = "联系电话";
		    break;
		case -9014:
			massege = "邮编格式错误";
		    break;
		case -9015:
			massege = "新密码格式错误";
		    break;
		case -9016:
			massege = "发送短信包大小超出范围";
		    break;
		case -9017:
			massege = "发送短信内容格式错误";
		    break;
		case -9018:
			massege = "发送短信扩展号格式错误";
		    break;
		case -9019:
			massege = "发送短信优先级格式错误";
		    break;
		case -9020:
			massege = "发送短信手机号格式错误";
		    break;
		case -9021:
			massege = "发送短信定时时间格式错误";
		    break;
		case -9022:
			massege = "发送短信唯一序列值错误";
		    break;
		case -9023:
			massege = "充值卡号格式错误";
		    break;
		case -9024:
			massege = "充值密码格式错误";
		    break;
		case -9025:
			massege = "客户端请求sdk5超时";
		    break;
		default:
		    System.out.println("没有该命令 " + Num);
		    break;
	    }
		
		
		return massege;
	}
}
