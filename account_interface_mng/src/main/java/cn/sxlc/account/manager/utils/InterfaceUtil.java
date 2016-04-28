package cn.sxlc.account.manager.utils;

import cn.springmvc.dao.impl.UtilDaoImpl;
import org.springframework.stereotype.Controller;
import product_p2p.kit.redisPlug.Core;

import javax.annotation.Resource;

@Controller("interfaceUtil")
public class InterfaceUtil {

    private static InterfaceUtil interfaceUtil;
    @Resource(name = "utilDaoImpl")
    private UtilDaoImpl utilDaoImpl;

    public InterfaceUtil() {
        if (interfaceUtil == null) {
            interfaceUtil = this;
        }
    }

    public static InterfaceUtil GetInterfaceUtilInstance() {
        if (interfaceUtil == null) {
            interfaceUtil = new InterfaceUtil();
        }
        return interfaceUtil;
    }

    /**
     * 获取平台第三方账户 标识
     * GetOwnAccountMark	获取平台第三方账户 标识
     * TODO(描述)
     *
     * @param @return 设定文件
     * @return String 返回类型
     * @throws
     * @author 张友
     * @Title: GetOwnAccountMark
     * @Description: TODO
     * @date 2016-3-30 下午8:56:33
     */
    public String GetOwnAccountMark() {
        String sResult = "";
        sResult = Core.getString("OwnAccountMark");
        if (sResult == null || sResult.equals("")) {
            sResult = utilDaoImpl.GetOwnAccountMark();
            Core.setObject("OwnAccountMark", sResult);
//			Core.expire("OwnAccountMark", InterfaceConstant.JEDIS_EXPIRE);
        }

        return sResult;
    }

    /**
     * 获取风险保证金账户标识
     * GetRiskMarginAccountMark 获取风险保证金账户标识
     * TODO(描述)
     *
     * @param @return 设定文件
     * @return String 返回类型 		风险保证金账户标识
     * @throws
     * @author 张友
     * @Title: GetRiskMarginAccountMark
     * @Description: TODO
     * @date 2016-3-31 下午6:45:31
     */
    public String GetRiskMarginAccountMark() {
        String sResult = "";

        sResult = Core.getString("OwnRiskMarginAccountMark");
        if (sResult == null || sResult.equals("")) {
            sResult = utilDaoImpl.GetOwnRiskMarginAccountMark();
            Core.setObject("OwnRiskMarginAccountMark", sResult);
//			Core.expire("OwnAccountMark", InterfaceConstant.JEDIS_EXPIRE);
        }

        return sResult;
    }

    /**
     * 获取平台第三方接口url
     * GetInterfaceUrl 获取平台第三方接口url
     * TODO(描述)
     *
     * @param iTypeId 接口类型  例如：	InterfaceConstant.IKAIHU
     * @param @return 设定文件
     * @return String 返回类型
     * @throws
     * @author 张友
     * @Title: GetInterfaceUrl
     * @Description: TODO
     * @date 2016-3-30 下午9:03:41
     */
    public String GetInterfaceUrl(int iTypeId) {
        String sResult = "";
        String sKey = "InterfaceUrl_" + iTypeId + "";
        sResult = Core.getString(sKey);
        if (sResult == null || sResult.equals("")) {
            sResult = utilDaoImpl.GetInterfaceUrl(iTypeId);
            Core.setObject(sKey, sResult);
//			Core.expire(sKey, InterfaceConstant.JEDIS_EXPIRE);
        }

        return sResult;
    }
}

