package fengkongweishi.entity.personreport.vo;

import fengkongweishi.entity.personreport.po.CarrierPO;
import fengkongweishi.entity.personreport.po.IAnalyseItem;
import fengkongweishi.enums.Color;

/**
 * 运营商数据
 *
 * @author huanghengkun
 * @date 2018/01/09
 */
public class CarrierVO implements IAnalyseItem {
    /**
     * 实名认证
     */
    private String reliability;
    /**
     * 姓名匹配
     */
    private String nameMatch;
    /**
     * 现居地
     */
    private String liveAddress;
    /**
     * 网龄
     */
    private String inTime;
    /**
     * 套餐
     */
    private String packageName;
    /**
     * 月均流量使用 M/月
     */
    private Integer netUsedPerMonth;
    /**
     * 日均通话次数 次/天
     */
    private Double callCountPerDay;
    /**
     * 次均通话时长 秒/次
     */
    private Integer callTimePerTime;
    /**
     * 月均话费 元/月
     */
    private Double moneyPerMonth;

    private Color color;

    @Override
    public String toString() {
        return super.toString() +
                "CarrierVO{" +
                "reliability='" + reliability + '\'' +
                ", nameMatch='" + nameMatch + '\'' +
                ", liveAddress='" + liveAddress + '\'' +
                ", inTime='" + inTime + '\'' +
                ", packageName='" + packageName + '\'' +
                ", netUsedPerMonth='" + netUsedPerMonth + '\'' +
                ", callCountPerDay='" + callCountPerDay + '\'' +
                ", callTimePerTime='" + callTimePerTime + '\'' +
                ", moneyPerMonth='" + moneyPerMonth + '\'' +
                '}';
    }

    public CarrierVO(CarrierPO carrierPO) {
        if (carrierPO != null) {
            this.color = carrierPO.getColor();
            this.reliability = carrierPO.getReliability();
            this.nameMatch = carrierPO.getNameMatch();
            this.liveAddress = carrierPO.getLiveAddress();
            if (carrierPO.getInTime() != null && carrierPO.getInTime() > 0) {
                this.inTime = carrierPO.getInTime() + "个月";
            } else {
                this.inTime = "运营商未提供入网时间";
            }
            this.packageName = carrierPO.getPackageName();
            this.netUsedPerMonth = carrierPO.getNetUsedPerMonth();
            this.callCountPerDay = carrierPO.getCallCountPerDay();
            this.callTimePerTime = carrierPO.getCallTimePerTime();
            this.moneyPerMonth = carrierPO.getMoneyPerMonth();
        }
    }

    private void analyseColor(CarrierPO carrierPO) {
        // 实名
        Color reliabilityColor = "实名认证".equals(carrierPO.getReliability()) ? Color.SUCCESS : Color.DANGER;
        putColor(reliabilityColor);
        // 入网时间
        Color inTimeColor;
        if (carrierPO.getInTime() > 12) {
            inTimeColor = Color.SUCCESS;
        } else if (carrierPO.getInTime() > 6 || carrierPO.getInTime() < 0) {
            inTimeColor = Color.ATTENTION;
        } else {
            inTimeColor = Color.WARNING;
        }
        putColor(inTimeColor);
        // 匹配
        Color nameMatchColor = "匹配成功".equals(nameMatch) ? Color.SUCCESS : Color.DANGER;
        putColor(nameMatchColor);
    }

    private void putColor(Color color) {
        if (isRiskHigher(color)) {
            this.color = color;
        }
    }

    private boolean isRiskHigher(Color newColor) {
        return this.color == null || this.color.compareTo(newColor) < 0;
    }

    public String getReliability() {
        return reliability;
    }

    public String getNameMatch() {
        return nameMatch;
    }

    public String getLiveAddress() {
        return liveAddress;
    }

    public String getInTime() {
        return inTime;
    }

    public String getPackageName() {
        return packageName;
    }

    public Integer getNetUsedPerMonth() {
        return netUsedPerMonth;
    }

    public Double getCallCountPerDay() {
        return callCountPerDay;
    }

    public Integer getCallTimePerTime() {
        return callTimePerTime;
    }

    public Double getMoneyPerMonth() {
        return moneyPerMonth;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }
}
