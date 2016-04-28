package cn.springmvc.dao;

import cn.sxlc.account.manager.model.LoanTransferReturnEntity;

public interface CreditorTransWriteDao {

    /**
     * 项目投资返回
     * processCreditorTransResult 项目投资返回
     * TODO(描述)
     *
     * @param returnEntity {@link LoanTransferReturnEntity}
     * @return int  0:失败 	1：成功
     * @throws null
     * @date 2016-4-14 下午 3:04:36
     */
    int processCreditorTransResult(LoanTransferReturnEntity returnEntity);
}

