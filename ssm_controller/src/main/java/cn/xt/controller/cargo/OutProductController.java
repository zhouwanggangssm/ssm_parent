package cn.xt.controller.cargo;

import cn.xt.domain.ContractProduct;
import cn.xt.service.ContractProductService;
import cn.xt.utils.DownloadUtil;
import cn.xt.utils.UtilFuns;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 出货表打印
 */
@Controller
@RequestMapping("/cargo")
public class OutProductController {
    @Autowired
    private ContractProductService contractProductService;
    /**
     * 进入出货表打印页面
     * @return
     */
    @RequestMapping("/outProduct_toedit")
    public String toEdit(){
        return "cargo/outproduct/jOutProduct";
    }

    /**
     * 打印
     * 相当于下载
     * @return
     */
    @RequestMapping("/outProduct_print")
    public String print(@RequestParam("inputDate") String inputDate, HttpServletResponse response, HttpServletRequest request) throws IOException, ParseException {
        //行，列
        int rowNo = 0,cellNo=1;
        Row row = null;
        Cell cell = null;

        //1.读取工作簿
        String path = request.getSession().getServletContext().getRealPath("/")+"/make/xlsprint/tOUTPRODUCT.xlsx";
        //创建流
        InputStream is = new FileInputStream(path);
        Workbook wb = new XSSFWorkbook(is); //Excel导出 2007以上

        //2.创建工作表
        Sheet sheet = wb.getSheetAt(0);

        //重置
        cellNo = 1;

        //3.创建行对象
        //=======大标题==========
        row = sheet.getRow(rowNo++);//创建行对象
        cell = row.getCell(cellNo);//创建单元格

        //设置单元格内容
        cell.setCellValue(inputDate.replace("-0","-").replace("-","年")+"月份出货表");

        //===============小标题=================
        rowNo++;

        //数据输出==================
        row = sheet.getRow(rowNo); //读取第三行
        CellStyle customCellStyle = row.getCell(cellNo++).getCellStyle();
        CellStyle orderNoCellStyle = row.getCell(cellNo++).getCellStyle();
        CellStyle productNoCellStyle = row.getCell(cellNo++).getCellStyle();
        CellStyle cNumberCellStyle = row.getCell(cellNo++).getCellStyle();
        CellStyle factoryCellStyle = row.getCell(cellNo++).getCellStyle();
        CellStyle deliveryPeriodCellStyle = row.getCell(cellNo++).getCellStyle();
        CellStyle shipTimeCellStyle = row.getCell(cellNo++).getCellStyle();
        CellStyle tradeTermsCellStyle = row.getCell(cellNo++).getCellStyle();



        List<ContractProduct> shipTimeList = contractProductService.getShipTimeList(inputDate);

        //查询出符合指定船期的货物列表
        for (ContractProduct cp : shipTimeList) {
            //产生数据行
            row = sheet.createRow(rowNo++);
            //设置行高
            row.setHeightInPoints(24);

            //重置
            cellNo = 1;

            //产生单元格对象
            cell = row.createCell(cellNo++);
            //客户名称
            cell.setCellValue(cp.getContract().getCustomName());
            //设置文本样式
            cell.setCellStyle(customCellStyle);

            //产生单元格对象
            cell = row.createCell(cellNo++);
            //订单号 --合同号
            cell.setCellValue(cp.getContract().getContractNo());
            //设置文本样式
            cell.setCellStyle(orderNoCellStyle);

            //产生单元格对象
            cell = row.createCell(cellNo++);
            //货号
            cell.setCellValue(cp.getProductNo());
            //设置文本样式
            cell.setCellStyle(productNoCellStyle);


            //产生单元格对象
            cell = row.createCell(cellNo++);
            //数量
            cell.setCellValue(cp.getCnumber());
            //设置文本样式
            cell.setCellStyle(cNumberCellStyle);


            //产生单元格对象
            cell = row.createCell(cellNo++);
            //工厂厂家
            cell.setCellValue(cp.getFactoryName());
            //设置文本样式
            cell.setCellStyle(factoryCellStyle);

            //产生单元格对象
            cell = row.createCell(cellNo++);
            //工厂交期
            cell.setCellValue(UtilFuns.dateTimeFormat(cp.getContract().getDeliveryPeriod()));
            //设置文本样式
            cell.setCellStyle(deliveryPeriodCellStyle);

            //产生单元格对象
            cell = row.createCell(cellNo++);
            //船期
            cell.setCellValue(UtilFuns.dateTimeFormat(cp.getContract().getShipTime()));
            //设置文本样式
            cell.setCellStyle(shipTimeCellStyle);

            //产生单元格对象
            cell = row.createCell(cellNo++);
            //贸易条款
            cell.setCellValue(cp.getContract().getTradeTerms());
            //设置文本样式
            cell.setCellStyle(tradeTermsCellStyle);
        }

        //输出
        DownloadUtil downloadUtil = new DownloadUtil();
        //创建缓存区流对象
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        //输出流，将Excel中的数据输出到缓存区中
        wb.write(baos);
        //关闭
        baos.close();
        //调用下载方法
        downloadUtil.download(baos ,response ,request,"出货表.xlsx");

        return null;
    }

    /**
     * 没有模板打印
     * 相当于下载
     * @return
     */
/*    @RequestMapping("/outProduct_print")
    public String print(@RequestParam("inputDate") String inputDate, HttpServletResponse response, HttpServletRequest request) throws IOException, ParseException {
        //行，列
        int rowNo = 0,cellNo=1;
        Row row = null;
        Cell cell = null;
        //1.创建工作簿
        Workbook wb = new HSSFWorkbook();

        //2.创建工作表
        Sheet sheet = wb.createSheet();
        //设置列宽 本身是个bug
        sheet.setColumnWidth(cellNo++ ,26*256);
        sheet.setColumnWidth(cellNo++ ,11*256);
        sheet.setColumnWidth(cellNo++ ,29*256);
        sheet.setColumnWidth(cellNo++ ,12*256);
        sheet.setColumnWidth(cellNo++ ,15*256);
        sheet.setColumnWidth(cellNo++ ,10*256);
        sheet.setColumnWidth(cellNo++ ,10*256);
        sheet.setColumnWidth(cellNo++ ,8*256);

        //重置
        cellNo = 1;

        //3.创建行对象
        //=======大标题==========
        row = sheet.createRow(rowNo++);//创建行对象
        row.setHeightInPoints(36);//设置行高
        cell = row.createCell(cellNo);//创建单元格对象

        //合并单元格
        sheet.addMergedRegion(new CellRangeAddress(0,0,1,8));

        //设置单元格内容
        cell.setCellValue(inputDate.replace("-0","-").replace("-","年")+"月份出货表");

        //设置样式
        cell.setCellStyle(this.bigTitle(wb)); //大标题

        //===============小标题=================
        String titles[] = {"客户","订单号","货号","数量","工厂","工厂交期","船期","贸易条款"};

        //创建小标题
        row = sheet.createRow(rowNo++);
        //设置行高
        row.setHeightInPoints(26.25f);

        //创建单元格对象,并设置样式
        for (String title : titles) {
            Cell c= row.createCell(cellNo++);//创建单元格对象
            c.setCellValue(title);//设置内容
            c.setCellStyle(this.title(wb));//设置样式
        }

        //数据输出
        List<ContractProduct> shipTimeList = contractProductService.getShipTimeList(inputDate);

        //查询出符合指定船期的货物列表
        for (ContractProduct cp : shipTimeList) {
            //产生数据行
            row = sheet.createRow(rowNo++);
            //设置行高
            row.setHeightInPoints(24);

            //重置
            cellNo = 1;

            //产生单元格对象
            cell = row.createCell(cellNo++);
            //客户名称
            cell.setCellValue(cp.getContract().getCustomName());
            //设置文本样式
            cell.setCellStyle(this.text(wb));

            //产生单元格对象
            cell = row.createCell(cellNo++);
            //订单号 --合同号
            cell.setCellValue(cp.getContract().getContractNo());
            //设置文本样式
            cell.setCellStyle(this.text(wb));

            //产生单元格对象
            cell = row.createCell(cellNo++);
            //货号
            cell.setCellValue(cp.getProductNo());
            //设置文本样式
            cell.setCellStyle(this.text(wb));


            //产生单元格对象
            cell = row.createCell(cellNo++);
            //数量
            cell.setCellValue(cp.getCnumber());
            //设置文本样式
            cell.setCellStyle(this.text(wb));


            //产生单元格对象
            cell = row.createCell(cellNo++);
            //工厂厂家
            cell.setCellValue(cp.getFactoryName());
            //设置文本样式
            cell.setCellStyle(this.text(wb));

            //产生单元格对象
            cell = row.createCell(cellNo++);
            //工厂交期
            cell.setCellValue(UtilFuns.dateTimeFormat(cp.getContract().getDeliveryPeriod()));
            //设置文本样式
            cell.setCellStyle(this.text(wb));

            //产生单元格对象
            cell = row.createCell(cellNo++);
            //船期
            cell.setCellValue(UtilFuns.dateTimeFormat(cp.getContract().getShipTime()));
            //设置文本样式
            cell.setCellStyle(this.text(wb));

            //产生单元格对象
            cell = row.createCell(cellNo++);
            //贸易条款
            cell.setCellValue(cp.getContract().getTradeTerms());
            //设置文本样式
            cell.setCellStyle(this.text(wb));
        }

        //输出
        DownloadUtil downloadUtil = new DownloadUtil();
        //创建缓存区流对象
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        //输出流，将Excel中的数据输出到缓存区中
        wb.write(baos);
        //关闭
        baos.close();
        //调用下载方法
        downloadUtil.download(baos ,response ,request,"出货表.xls");

        return null;
    }*/

    //大标题的样式
    public CellStyle bigTitle(Workbook wb){
        CellStyle style = wb.createCellStyle();
        Font font = wb.createFont();
        font.setFontName("宋体");
        font.setFontHeightInPoints((short)16);
        font.setBoldweight(Font.BOLDWEIGHT_BOLD);					//字体加粗

        style.setFont(font);

        style.setAlignment(CellStyle.ALIGN_CENTER);					//横向居中
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);		//纵向居中

        return style;
    }
    //小标题的样式
    public CellStyle title(Workbook wb){
        CellStyle style = wb.createCellStyle();
        Font font = wb.createFont();
        font.setFontName("黑体");
        font.setFontHeightInPoints((short)12);

        style.setFont(font);

        style.setAlignment(CellStyle.ALIGN_CENTER);					//横向居中
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);		//纵向居中

        style.setBorderTop(CellStyle.BORDER_THIN);					//上细线
        style.setBorderBottom(CellStyle.BORDER_THIN);				//下细线
        style.setBorderLeft(CellStyle.BORDER_THIN);					//左细线
        style.setBorderRight(CellStyle.BORDER_THIN);				//右细线

        return style;
    }

    //文字样式
    public CellStyle text(Workbook wb){
        CellStyle style = wb.createCellStyle();
        Font font = wb.createFont();
        font.setFontName("Times New Roman");
        font.setFontHeightInPoints((short)10);

        style.setFont(font);

        style.setAlignment(CellStyle.ALIGN_LEFT);					//横向居左
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);		//纵向居中

        style.setBorderTop(CellStyle.BORDER_THIN);					//上细线
        style.setBorderBottom(CellStyle.BORDER_THIN);				//下细线
        style.setBorderLeft(CellStyle.BORDER_THIN);					//左细线
        style.setBorderRight(CellStyle.BORDER_THIN);				//右细线

        return style;
    }
}






















