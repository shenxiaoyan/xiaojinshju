package fengkongweishi.entity.personreport;

import fengkongweishi.entity.personreport.vo.*;
import fengkongweishi.enums.Level;

/**
 * 全面版视图
 *
 * @author huanghengkun
 * @date 2018/02/28
 */
public class PersonReportSeniorVO extends BasePersonReportVO {

    private String name;
    private String idcard;
    private String mobile;
    private String bankcard;
    private String commonAddress;
    private String servicePassword;
    private String linkman1Name;
    private String linkman1Relationship;
    private String linkman1Mobile;
    private String linkman2Name;
    private String linkman2Relationship;
    private String linkman2Mobile;
    private String plateNumber;
    private String vin;
    private String engineNo;
    private String carType;

    private IdCardVO idCardVO;
    private IdCheckVO idCheckVO;
    private ZhimaScoreVO zhimaScoreVO;
    private FraudVO fraudVO;
    private MultipleHeadLendVO multipleHeadLendVO;
    private OverdueCreditVO overdueCreditVO;
    private DishonestBlackVO dishonestBlackVO;
    private CriminalVO criminalVO;
    private CourtJudgmentVO courtJudgmentVO;
    private ViolationVO violationVO;

    private EducationVO educationVO;

    private CarrierVO carrierVO;
    private CallRiskVO callRiskVO;
    private SocialContactVO socialContactVO;
    private CallListVO callListVO;

    private WealthVO wealthVO;
    private ConsumeVO consumeVO;
    private DeliverAddressVO deliverAddressVO;

    public PersonReportSeniorVO(PersonReport report, boolean isHide) {
        super(report);
        this.name = report.getName();
        this.idcard = report.getIdCard();
        this.mobile = report.getMobile();
        this.bankcard = report.getBankCard();

        this.commonAddress = report.getCommonAddress();
        this.servicePassword = report.getServicePassword();
        this.linkman1Mobile = report.getLinkman1Mobile();
        this.linkman1Relationship = report.getLinkman1Relationship();
        this.linkman1Name = report.getLinkman1Name();
        this.linkman2Mobile = report.getLinkman2Mobile();
        this.linkman2Relationship = report.getLinkman2Relationship();
        this.linkman2Name = report.getLinkman2Name();
        this.plateNumber = report.getPlateNumber();
        this.vin = report.getVin();
        this.engineNo = report.getEngineNo();
        this.carType = report.getCarType();

        this.idCardVO = (report.getIdCardPO() == null && report.getBankPO() == null && report.getPhonePO() == null)
                ? null : new IdCardVO(report.getIdCardPO(), report.getBankPO(), report.getPhonePO(), isHide);
        this.idCheckVO = report.getIdCheckPO() != null ? new IdCheckVO(report.getIdCheckPO()) : null;
        this.zhimaScoreVO = report.getZhimaScorePO() != null ? new ZhimaScoreVO(report.getZhimaScorePO()) : null;
        this.fraudVO = report.getBlackRiskPO() != null ? new FraudVO(report.getBlackRiskPO()) : null;
        this.multipleHeadLendVO = report.getBlackRiskPO() != null ? new MultipleHeadLendVO(report.getBlackRiskPO()) : null;
        this.overdueCreditVO = report.getBlackRiskPO() != null ? new OverdueCreditVO(report.getBlackRiskPO()) : null;
        this.dishonestBlackVO = report.getDishonestBlackPO() != null ? new DishonestBlackVO(report.getDishonestBlackPO()) : null;
        this.criminalVO = report.getCriminalPO() != null ? new CriminalVO(report.getCriminalPO()) : null;
        this.courtJudgmentVO = report.getCourtJudgmentPO() != null ? new CourtJudgmentVO(report.getCourtJudgmentPO()) : null;

        this.educationVO = report.getEducationPO() != null ? new EducationVO(report.getEducationPO()) : null;

        this.violationVO = report.getViolationPO() == null && report.isViolationParamtersAllEmpty() ? null : new ViolationVO(report.getViolationPO());

        this.carrierVO = report.getCarrierPO() == null && !report.isMoxieCarrierFinished() ? null : new CarrierVO(report.getCarrierPO());
        this.callRiskVO = report.getCarrierPO() == null && !report.isMoxieCarrierFinished() ? null : new CallRiskVO(report.getCarrierPO());
        this.socialContactVO = report.getCarrierPO() == null && !report.isMoxieCarrierFinished() ? null : new SocialContactVO(report.getCarrierPO(), isHide);
        this.callListVO = report.getCarrierPO() == null && !report.isMoxieCarrierFinished() ? null : new CallListVO(report.getCarrierPO(), isHide);

        this.consumeVO = report.getTaoBaoPO() == null && !report.isMoxieTaobaoFinished() ? null : new ConsumeVO(report.getTaoBaoPO());
        this.deliverAddressVO = report.getTaoBaoPO() == null && !report.isMoxieTaobaoFinished() ? null : new DeliverAddressVO(report.getTaoBaoPO());
        this.wealthVO = report.getTaoBaoPO() == null && !report.isMoxieTaobaoFinished() ? null : new WealthVO(report.getTaoBaoPO());
    }

    public String getName() {
        return name;
    }

    public String getIdcard() {
        return idcard;
    }

    public String getMobile() {
        return mobile;
    }

    public String getBankcard() {
        return bankcard;
    }

    public String getCommonAddress() {
        return commonAddress;
    }

    public String getServicePassword() {
        return servicePassword;
    }

    public String getLinkman1Name() {
        return linkman1Name;
    }

    public String getLinkman1Relationship() {
        return linkman1Relationship;
    }

    public String getLinkman1Mobile() {
        return linkman1Mobile;
    }

    public String getLinkman2Name() {
        return linkman2Name;
    }

    public String getLinkman2Relationship() {
        return linkman2Relationship;
    }

    public String getLinkman2Mobile() {
        return linkman2Mobile;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public String getVin() {
        return vin;
    }

    public String getEngineNo() {
        return engineNo;
    }

    public String getCarType() {
        return carType;
    }

    public IdCardVO getIdCardVO() {
        return idCardVO;
    }

    public IdCheckVO getIdCheckVO() {
        return idCheckVO;
    }

    public ZhimaScoreVO getZhimaScoreVO() {
        return zhimaScoreVO;
    }

    public FraudVO getFraudVO() {
        return fraudVO;
    }

    public MultipleHeadLendVO getMultipleHeadLendVO() {
        return multipleHeadLendVO;
    }

    public OverdueCreditVO getOverdueCreditVO() {
        return overdueCreditVO;
    }

    public DishonestBlackVO getDishonestBlackVO() {
        return dishonestBlackVO;
    }

    public CriminalVO getCriminalVO() {
        return criminalVO;
    }

    public CourtJudgmentVO getCourtJudgmentVO() {
        return courtJudgmentVO;
    }

    public ViolationVO getViolationVO() {
        return violationVO;
    }

    public EducationVO getEducationVO() {
        return educationVO;
    }

    public CarrierVO getCarrierVO() {
        return carrierVO;
    }

    public CallRiskVO getCallRiskVO() {
        return callRiskVO;
    }

    public SocialContactVO getSocialContactVO() {
        return socialContactVO;
    }

    public CallListVO getCallListVO() {
        return callListVO;
    }

    public WealthVO getWealthVO() {
        return wealthVO;
    }

    public ConsumeVO getConsumeVO() {
        return consumeVO;
    }

    public DeliverAddressVO getDeliverAddressVO() {
        return deliverAddressVO;
    }

}
