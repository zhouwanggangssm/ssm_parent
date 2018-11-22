package cn.xt.controller.cargo;

import cn.xt.service.ContractProductService;
import cn.xt.utils.DownloadUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@Controller
@RequestMapping("/cargo")
public class OutProductController {

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
    public ResponseEntity<byte[]> print(@RequestParam("inputDate") String inputDate, HttpServletResponse response) throws IOException {
        int rowNo = 0,cellNo=1;
        Row row = null;
        Cell cell = null;
        //1.创建工作簿
        Workbook wb = new HSSFWorkbook();

        //2.创建工作表
        Sheet sheet = wb.createSheet();
        //设置列宽
        sheet.setColumnWidth(cellNo++ ,26);
        sheet.setColumnWidth(cellNo++ ,11);
        sheet.setColumnWidth(cellNo++ ,29);
        sheet.setColumnWidth(cellNo++ ,12);
        sheet.setColumnWidth(cellNo++ ,15);
        sheet.setColumnWidth(cellNo++ ,10);
        sheet.setColumnWidth(cellNo++ ,10);
        sheet.setColumnWidth(cellNo++ ,8);

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
        cell.setCellValue(inputDate.replace("-0","-").replace("-","年")+"月出货表");

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
            row.createCell(cellNo++);//创建单元格对象
            cell.setCellValue(title);//设置内容
            cell.setCellStyle(this.title(wb));//设置样式
        }

  /*      //输出
        DownloadUtil downloadUtil = new DownloadUtil();
        //创建缓存区流对象
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        //输出流，将Excel中的数据输出到缓存区中
        wb.write(baos);
        //关闭
        baos.close();

        downloadUtil.download(baos ,response ,"itheima.xls");*/
      /*  byte[] buff = new byte[];

        ResponseEntity <byte[]> entity = new ResponseEntity<byte[]>(buff,);*/
        return null;
    }

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






















