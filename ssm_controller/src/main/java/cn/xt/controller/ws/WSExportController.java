package cn.xt.controller.ws;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 在系统中调用cxf提供的WebService
 */
@Controller
public class WSExportController {

    @RequestMapping("/cargo/export_toedit")
    public String toedit() {
        return "ws/export/AjaxExport";
    }
}