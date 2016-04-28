package cn.springmvc.dao;


public interface UtilDao {

    /**
     * 获取平台第三方账户标识
     * GetOwnAccountMark(这里用一句话描述这个方法的作用)
     * TODO(描述)
     *
     * @param @return 设定文件
     * @return String 返回类型
     * @throws
     * @author 张友
     * @Title: GetOwnAccountMark
     * @Description: TODO
     * @date 2016-3-30 下午8:20:10
     */
    public String GetOwnAccountMark();

    /**
     * 获取风险保证金第三方账户标识
     * GetOwnRiskMarginAccountMark	获取风险保证金第三方账户标识
     * TODO(描述)
     *
     * @param @return 设定文件
     * @return String 返回类型
     * @throws
     * @author 张友
     * @Title: GetOwnRiskMarginAccountMark
     * @Description: TODO
     * @date 2016-3-31 下午6:47:07
     */
    public String GetOwnRiskMarginAccountMark();

    /**
     * GetInterfaceUrl(这里用一句话描述这个方法的作用)
     * TODO(描述)
     *
     * @param @param  iType
     * @param @return 设定文件
     * @return String 返回类型
     * @throws
     * @author 张友
     * @Title: GetInterfaceUrl
     * @Description: TODO
     * @date 2016-3-30 下午8:23:23
     */
    public String GetInterfaceUrl(int iType);

}
