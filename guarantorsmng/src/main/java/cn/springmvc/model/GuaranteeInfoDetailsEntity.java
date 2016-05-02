
package cn.springmvc.model; 

import java.util.List;

/** 
 * 查询单个担保机构详情
* @author 朱祖轶 
* @Description: TODO 
* @since 
* @date 2016-4-29 下午2:28:06  */
public class GuaranteeInfoDetailsEntity {
	private GuaranteeInfoEntity guaranteeInfoEntity;//担保机构基本信息
	private List<GuaranteeCertificateEntity> lCertificateEntities;//担保机构证件信息
	private List<GuaranteeBorrowingEntity> lBorrowingEntities;//担保机构担保借款范围
	private List<GuaranteePeriodEntity> lGuaranteePeriodEntities;//根据保荐机构id,期限类型查询担保机构期限范围
	private List<GuaranteeRelationalEntity> lGuaranteeRelationalEntities;//担保项目类型
	private CompensationStatisticsEntity compensationStatisticsEntity;//代偿统计信息
	public GuaranteeInfoEntity getGuaranteeInfoEntity() {
		return guaranteeInfoEntity;
	}
	public void setGuaranteeInfoEntity(GuaranteeInfoEntity guaranteeInfoEntity) {
		this.guaranteeInfoEntity = guaranteeInfoEntity;
	}
	public List<GuaranteeCertificateEntity> getlCertificateEntities() {
		return lCertificateEntities;
	}
	public void setlCertificateEntities(
			List<GuaranteeCertificateEntity> lCertificateEntities) {
		this.lCertificateEntities = lCertificateEntities;
	}
	public List<GuaranteeBorrowingEntity> getlBorrowingEntities() {
		return lBorrowingEntities;
	}
	public void setlBorrowingEntities(
			List<GuaranteeBorrowingEntity> lBorrowingEntities) {
		this.lBorrowingEntities = lBorrowingEntities;
	}
	public List<GuaranteePeriodEntity> getlGuaranteePeriodEntities() {
		return lGuaranteePeriodEntities;
	}
	public void setlGuaranteePeriodEntities(
			List<GuaranteePeriodEntity> lGuaranteePeriodEntities) {
		this.lGuaranteePeriodEntities = lGuaranteePeriodEntities;
	}
	public List<GuaranteeRelationalEntity> getlGuaranteeRelationalEntities() {
		return lGuaranteeRelationalEntities;
	}
	public void setlGuaranteeRelationalEntities(
			List<GuaranteeRelationalEntity> lGuaranteeRelationalEntities) {
		this.lGuaranteeRelationalEntities = lGuaranteeRelationalEntities;
	}
	public CompensationStatisticsEntity getCompensationStatisticsEntity() {
		return compensationStatisticsEntity;
	}
	public void setCompensationStatisticsEntity(
			CompensationStatisticsEntity compensationStatisticsEntity) {
		this.compensationStatisticsEntity = compensationStatisticsEntity;
	}
	
}

