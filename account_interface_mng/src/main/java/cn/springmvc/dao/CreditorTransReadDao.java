package cn.springmvc.dao;

import cn.sxlc.account.manager.model.TransferSubmitEntity;

/**
 * Created by yonghuang on 16/4/14.
 */
public interface CreditorTransReadDao {
    /**
     * getCreditorMaxInvestAmount	获取某个会员对债权最大可投金额
     * TODO(描述)
     *
     * @param lProjectId          项目id
     * @param lMemberId           会员id
     * @param lCreditorTransAppId 债权转让的申请id
     * @param sKey                加密，解密key值
     * @return long 返回类型       小于0:表示错误 -1 表示项目不存在,-2 已经达到最大投资笔数,-3 已经达到最大投资额度
     * @throws null <p>
     */
    long getCreditorMaxInvestAmount(long lProjectId, long lMemberId, long lCreditorTransAppId, String sKey);

    /**
     * @param lMemberId       会员ID
     * @param lProjectId      项目ID
     * @param sIsAuto         是否为自动投标	0:否	1：是
     * @param lAmount         投资总金额		(单位元，保留4位小数)
     * @param sRedPacketsInfo 红包使用金额		红包1ID,使用金额(单位元 格式：0.20元，保留2位小数);红包ID2,使用金额;
     * @param lVouchers       代金券金额		(单位元，保留4位小数)
     * @param sKey            加密解密key
     * @param lRedPackets     返回红包总额
     * @return long 返回类型   验证成功返回:success  其他为失败原因
     * 1：验证成功 0：验证失败
     * -1：投资金额超过最大投资金额
     * -2：使用红包金额比例大于项目最高红包比例
     * -3：红包已经过期
     * -4：红包使用金额大于红包总额
     * -5：代金券使用金额大于代金券可用余额
     * -6：红包、代金券总和不能超过或等于投资总额
     * -7：您投资的笔数已达上限不能再投资
     * -8: 不能超过自动投标比例上限
     * -9：自动投资未开始
     * -10: 项目未开标
     * -11：投资金额超过剩余投资金额
     * -12：项目已满标（投标时间结束，投标满标）
     * -13: 自己不能投资自己的借款
     * -14：余额不足
     * -15:定向标密码错误
     * -16: 借款人不能投资此债权
     * -17: 转让人不能投资此债权
     * @throws null TODO(描述)
     */
    long checkCreditorRecordByMember(long lProjectId, long lMemberId, long lCreditorTransAppId, short sIsAuto,
                                     long lAmount, String sRedPacketsInfo, long lVouchers, String sKey, long[] lRedPackets);

    /**
     * 获取债权转让详情
     * GetCreditorTransInfo 获取投资详情
     * TODO(描述)
     *
     * @param sIsAuto     自动投标	0：否 1：是
     * @param lMemberId   会员ID
     * @param lProjectId  项目ID
     * @param lAmount     投资总金额
     * @param lRedPackets 使用红包金额
     * @param lVouchers   使用代金券
     * @param sClient     使用客户端：0：pc 1：app 2：微信端
     * @return TransferSubmitEntity 返回类型 	返回调用投资接口对象
     * @throws null
     */
    TransferSubmitEntity getCreditorTransInfo(short sIsAuto, long lMemberId, long lProjectId, long lCreditorTransAppId,
                                              long lAmount, long lRedPackets, long lVouchers, short sClient);
}