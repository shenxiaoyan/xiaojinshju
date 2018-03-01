package fengkongweishi.entity.personreport;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 违章信息传输类
 *
 * @author huanghengkun
 * @date 2018/01/31
 */
public class VehLicenseDTO {
    @NotBlank(message = "车牌不能为空")
    @Length(min = 7, max = 8, message = "车牌长度为7-8位")
    private String plateNumber;
    @NotBlank(message = "车辆识别代号不能为空")
    private String vin;
    @NotBlank(message = "发动机号不能为空")
    private String engineNo;
    @NotBlank(message = "车辆类型不能为空")
    private String carType;

    @Override
    public String toString() {
        return "VehLicenseDTO{" +
                "plateNumber='" + plateNumber + '\'' +
                ", vin='" + vin + '\'' +
                ", engineNo='" + engineNo + '\'' +
                ", carType='" + carType + '\'' +
                '}';
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getEngineNo() {
        return engineNo;
    }

    public void setEngineNo(String engineNo) {
        this.engineNo = engineNo;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }
}
