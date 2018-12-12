package test;

import org.apache.poi.ss.formula.functions.Rows;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class POITest {
    @Test
    public void testPrint() throws IOException {
        String xlxFile = "D:/test.xlsx";

        Workbook wb = new XSSFWorkbook();
        Sheet sheet = wb.createSheet("我的第一个工作簿");

        Row row = null;
        Cell cell = null;

        for (int i =0;i<100000;i++) {
            System.out.println(i);
            row = sheet.createRow(i);
            for(int j = 0;j<20;j++){
                cell = row.createCell(j);
                cell.setCellValue("哈哈啊哈哈哈");
            }
        }

        cell.setCellStyle(leftStyle(wb));

        FileOutputStream fos = new FileOutputStream(xlxFile);
        wb.write(fos);
        fos.flush();
        fos.close();
    }

    //设置单元格样式
    private CellStyle leftStyle(Workbook wb){
        CellStyle curStyle = wb.createCellStyle();
        Font curFont = wb.createFont();								//设置字体
        //curFont.setFontName("Times New Roman");						//设置英文字体
        curFont.setFontName("微软雅黑");								//设置英文字体
        curFont.setCharSet(Font.DEFAULT_CHARSET);					//设置中文字体，那必须还要再对单元格进行编码设置
        curFont.setFontHeightInPoints((short)10);						//字体大小
        curStyle.setFont(curFont);

        curStyle.setBorderTop(CellStyle.BORDER_THICK);				//粗实线
        curStyle.setBorderBottom(CellStyle.BORDER_THIN);			//实线
        curStyle.setBorderLeft(CellStyle.BORDER_MEDIUM);			//比较粗实线
        curStyle.setBorderRight(CellStyle.BORDER_THIN);				//实线

        curStyle.setWrapText(true);  									//换行
        curStyle.setAlignment(CellStyle.ALIGN_RIGHT);				//横向具右对齐
        curStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);	//单元格垂直居中

        return curStyle;
    }
}
