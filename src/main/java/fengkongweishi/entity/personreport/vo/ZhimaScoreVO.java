package fengkongweishi.entity.personreport.vo;

import fengkongweishi.entity.personreport.po.IAnalyseItem;
import fengkongweishi.entity.personreport.po.ZhimaScorePO;
import fengkongweishi.enums.Color;

/**
 * 芝麻信用
 *
 * @author huanghengkun
 * @date 2018/01/09
 */
public class ZhimaScoreVO implements IAnalyseItem {
    /**
     * 芝麻分
     */
    private String score;

    private Color color;

    @Override
    public String toString() {
        return super.toString() +
                "ZhimaScoreVO{" +
                "score='" + score + '\'' +
                '}';
    }

    public ZhimaScoreVO(ZhimaScorePO zhimaScorePO) {
        if (zhimaScorePO != null) {
            this.color = zhimaScorePO.getColor();
            this.score = translationScore(zhimaScorePO.getScore());
        }
    }

    private String translationScore(String oldScore) {
        if (oldScore == null) {
            return null;
        }
        switch (oldScore) {
            case "400+":
                return "350~500";
            case "500+":
                return "500~600";
            case "600+":
                return "600~700";
            case "700+":
                return "700+";
            default:
                return oldScore;
        }
    }

    public String getScore() {
        return score;
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
