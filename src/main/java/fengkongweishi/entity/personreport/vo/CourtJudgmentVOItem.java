package fengkongweishi.entity.personreport.vo;

import fengkongweishi.entity.personreport.po.CourtJudgmentPOItem;

import java.text.SimpleDateFormat;
import java.util.Objects;

/**
 * 法院裁决
 *
 * @author huanghengkun
 * @date 2018/01/09
 */
public class CourtJudgmentVOItem {
    /**
     * 文书编号
     */
    private String docId;
    /**
     * 案件标题
     */
    private String title;
    /**
     * 法院名称
     */
    private String court;
    /**
     * 案件类别
     */
    private String caseType;
    /**
     * 案号
     */
    private String caseNum;
    /**
     * 案由
     */
    private String caseCause;
    /**
     * 案由编码类型
     */
    private String caseCauseCode;
    /**
     * 上述人
     */
    private String appellant;
    /**
     * 被上述人
     */
    private String appellee;
    /**
     * 审结时间
     */
    private String concludeTime;
    /**
     * 判决结果
     */
    private String judgeResult;
    /**
     * 案例摘要
     */
    private String content;
    /**
     * 审理程序
     */
    private String trialProcedure;

    @Override
    public String toString() {
        return "CourtJudgmentVOItem{" +
                "docId='" + docId + '\'' +
                ",title='" + title + '\'' +
                ", court='" + court + '\'' +
                ", caseType='" + caseType + '\'' +
                ", caseNum='" + caseNum + '\'' +
                ", caseCause='" + caseCause + '\'' +
                ", caseCauseCode='" + caseCauseCode + '\'' +
                ", appellant='" + appellant + '\'' +
                ", appellee='" + appellee + '\'' +
                ", concludeTime=" + concludeTime +
                ", judgeResult='" + judgeResult + '\'' +
                ", content='" + content + '\'' +
                ", trialProcedure='" + trialProcedure + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CourtJudgmentVOItem that = (CourtJudgmentVOItem) o;
        return Objects.equals(docId, that.docId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(docId);
    }

    public CourtJudgmentVOItem(CourtJudgmentPOItem courtJudgmentPOItem) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.docId = courtJudgmentPOItem.getDocId();
        this.title = courtJudgmentPOItem.getTitle();
        this.court = courtJudgmentPOItem.getCourt();
        this.caseType = courtJudgmentPOItem.getCaseType();
        this.caseNum = courtJudgmentPOItem.getCaseNum();
        this.caseCause = courtJudgmentPOItem.getCaseCause();
        this.caseCauseCode = courtJudgmentPOItem.getCaseCauseCode();
        this.appellant = courtJudgmentPOItem.getAppellant();
        this.appellee = courtJudgmentPOItem.getAppellee();
        this.concludeTime = sdf.format(courtJudgmentPOItem.getConcludeTime());
        this.judgeResult = courtJudgmentPOItem.getJudgeResult();
        this.content = courtJudgmentPOItem.getContent();
        this.trialProcedure = courtJudgmentPOItem.getTrialProcedure();
    }

    public CourtJudgmentVOItem() {
    }

    public String getDocId() {
        return docId;
    }

    public String getTitle() {
        return title;
    }

    public String getCourt() {
        return court;
    }

    public String getCaseType() {
        return caseType;
    }

    public String getCaseNum() {
        return caseNum;
    }

    public String getCaseCause() {
        return caseCause;
    }

    public String getCaseCauseCode() {
        return caseCauseCode;
    }

    public String getAppellant() {
        return appellant;
    }

    public String getAppellee() {
        return appellee;
    }

    public String getConcludeTime() {
        return concludeTime;
    }

    public String getJudgeResult() {
        return judgeResult;
    }

    public String getContent() {
        return content;
    }

    public String getTrialProcedure() {
        return trialProcedure;
    }
}
