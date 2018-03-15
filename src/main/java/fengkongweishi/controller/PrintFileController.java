package fengkongweishi.controller;

import fengkongweishi.enums.ExceptionEnum;
import fengkongweishi.service.PrintReportService;
import fengkongweishi.util.FailResponse;
import fengkongweishi.util.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jianger
 * @Description 打印报告
 * @Date 2018/2/1 上午10:57
 **/
@RestController
@RequestMapping("/print")
public class PrintFileController {

    @Autowired
    private PrintReportService printReportService;

    @RequestMapping(value = "/pdf/{reportId}", method = RequestMethod.GET)
    @PreAuthorize("hasRole('MANAGER') or hasRole('EMPLOYEE') or hasRole('LEADER')")
    public ResponseBody printPdf(@PathVariable("reportId") Integer id) throws Exception {

//        try {
            return new ResponseBody(printReportService.printReportPDF(id));
//        } catch (Exception e) {
//            throw new FailResponse(ExceptionEnum.PRINT_PDF_FAIL);
//        }
    }

}
