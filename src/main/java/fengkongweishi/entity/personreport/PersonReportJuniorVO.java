package fengkongweishi.entity.personreport;

import fengkongweishi.entity.personreport.vo.*;

/**
 * 基础版视图
 *
 * @author huanghengkun
 * @date 2018/02/28
 */
public class PersonReportJuniorVO extends BasePersonReportVO {

    private String name;
    private String idcard;
    private String mobile;
    private String bankcard;
    private String commonAddress;
    private String plateNumber;
    private String vin;
    private String engineNo;
    private String carType;

    private IdCardVO idCardVO;
    private IdCheckVO idCheckVO;
    private ZhimaScoreVO zhimaScoreVO;
    private FraudVO fraudVO;
    private MultipleHeadLendVO multipleHeadLendVO;
    private DishonestBlackVO dishonestBlackVO;
    private CriminalVO criminalVO;
    private CourtJudgmentVO courtJudgmentVO;
    private ViolationVO violationVO;
    private OverdueCreditVO overdueCreditVO;

    public PersonReportJuniorVO(PersonReport report, boolean isHide) {
        super(report);
        this.name = report.getName();
        this.idcard = report.getIdCard();
        this.mobile = report.getMobile();
        this.bankcard = report.getBankCard();
        this.commonAddress = report.getCommonAddress();
        this.plateNumber = report.getPlateNumber();
        this.vin = report.getVin();
        this.engineNo = report.getEngineNo();
        this.carType = report.getCarType();

        this.idCardVO = new IdCardVO(report.getIdCardPO(), report.getBankPO(), report.getPhonePO(), isHide);
        this.idCheckVO = new IdCheckVO(report.getIdCheckPO());
        this.zhimaScoreVO = new ZhimaScoreVO(report.getZhimaScorePO());
        this.fraudVO = new FraudVO(report.getBlackRiskPO());
        this.multipleHeadLendVO = new MultipleHeadLendVO(report.getBlackRiskPO());
        this.overdueCreditVO = new OverdueCreditVO(report.getBlackRiskPO());
        this.dishonestBlackVO = new DishonestBlackVO(report.getDishonestBlackPO());
        this.criminalVO = new CriminalVO(report.getCriminalPO());
        this.courtJudgmentVO = new CourtJudgmentVO(report.getCourtJudgmentPO());

        this.violationVO = report.getViolationPO() == null && report.isViolationParamtersAllEmpty() ? null : new ViolationVO(report.getViolationPO());
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

    public OverdueCreditVO getOverdueCreditVO() {
        return overdueCreditVO;
    }

}
