package fengkongweishi.enums;

/**
 * 版本枚举类
 *
 * @author huanghengkun
 * @date 2018/01/08
 */
public enum SystemEditionEnum {
    /**
     * 基础版
     */
    PERSONJUNIOR(8, "基础版", "JC"),
    /**
     * 通信版
     */
    PERSONMOBILE(12, "通信版", "TX"),
    /**
     * 淘宝版
     */
    PERSONECOMMERCE(12, "淘宝版", "TB"),
    /**
     * 全面版
     */
    PERSONSENIOR(15, "全面版", "QM");

    private Integer price;
    private String message;
    private String shortName;

    SystemEditionEnum(Integer price, String message, String shortName) {
        this.price = price;
        this.message = message;
        this.shortName = shortName;
    }

    public Integer getPrice() {
        return price;
    }

    public String getMessage() {
        return message;
    }

    public String getShortName() {
        return shortName;
    }
}
