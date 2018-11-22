package test;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class POI01test {
    @Test
    public void testPoi()throws Exception{
        //1.创建工作薄
        Workbook wb = new HSSFWorkbook();

        //2.创建工作表sheet
        Sheet sheet = wb.createSheet();

        //3.创建Row对象 从0开始
        Row row = sheet.createRow(3);

        //4.创建单元格对象 从0开始
        Cell cell = row.createCell(3);

        //5.设置单元格内容
        cell.setCellValue("钢哥.好帅");

        //6.设置单元格的样式
        CellStyle cellStyle = wb.createCellStyle();

        //字体名称
        Font font = wb.createFont();
        //字体名称
        font.setFontName("微软雅黑");
        //设置字体大小
        font.setFontHeightInPoints((short) 48);
        //样式中添加一个字体样式
        cellStyle.setFont(font);

        cell.setCellStyle(cellStyle);

        //7.保存关闭流
        //创建一个输出流
        OutputStream os = new FileOutputStream("G:/商务综合管理平台项目/excel/abc.xls");

        wb.write(os);
        os.close();

        //8.下载
    }
}
