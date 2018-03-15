package fengkongweishi.service.report;

import com.itextpdf.text.pdf.BaseFont;
import freemarker.template.*;
import org.xhtmlrenderer.pdf.ITextRenderer;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Locale;

/**
 * @author jianger
 * @Description
 * @Date 2018/2/8 上午10:48
 **/
public class PdfHelper {
//    private static String simsum = "http://xiaojincom.oss-cn-hangzhou.aliyuncs.com/simsun.ttc";
    String pathSimSun=System.getProperty("user.home")+"/simsun.ttc";
//    private static String simhei = "http://xiaojincom.oss-cn-hangzhou.aliyuncs.com/simhei.ttf";

    public ITextRenderer getRender() throws IOException, com.lowagie.text.DocumentException {
        ITextRenderer render = new ITextRenderer();
//        String path=getPath();
        render.getFontResolver().addFont(pathSimSun, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
//        render.getFontResolver().addFont(simhei, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        return render;
    }

    //获取要写入PDF的内容
    public static String getPdfContent(String ftlPath, String ftlName, Object o) throws IOException, TemplateException {
        return useTemplate(ftlPath, ftlName, o);
    }

    //使用freemarker得到html内容
    public static String useTemplate(String ftlPath, String ftlName, Object o) throws IOException, TemplateException {
        String html = null;
        Template tpl = getFreemarkerConfig(ftlPath).getTemplate(ftlName);
        tpl.setEncoding("UTF-8");
        StringWriter writer = new StringWriter();
        tpl.process(o, writer);
        writer.flush();
        html = writer.toString();
        return html;
    }

    /**
     * 获取Freemarker配置
     *
     * @param templatePath
     * @return
     * @throws IOException
     */
    private static Configuration getFreemarkerConfig(String templatePath) throws IOException {
        Configuration config = new Configuration();
        config.setDirectoryForTemplateLoading(new File(templatePath));
        config.setEncoding(Locale.CHINA, "utf-8");
        return config;
    }

    /**
     * 获取类路径
     *
     * @return
     */
    public String getPath() {
        return this.getClass().getResource("/").getPath() + "templates/simsun.ttc";
    }

    public String getPathWithHei() {
        return this.getClass().getResource("/").getPath() + "templates/simhei.ttf";
    }
}

