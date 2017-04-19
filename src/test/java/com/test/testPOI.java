package com.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.xml.ws.wsaddressing.W3CEndpointReferenceBuilder;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

public class testPOI {
	@Test
	public void HSSF()throws IOException{
		//第一步:创建一个工作簿excel文件 
		
		Workbook workbook=new HSSFWorkbook();//HSSF操作Excel2003以下版本
		
		//第二步:创建一个工作表sheet
		
		Sheet sheet=workbook.createSheet();
		
		//第三步:创建一个行对象(我们放在第4行)
		
		Row nRow=sheet.createRow(3);
		
		//第四步:创建一个单元格对象，指定列
		//createCell参数有两个，一个是第几列一个是参数类型，  
        //这里我们使用默认参数类型
		Cell nCell=nRow.createCell(2);
		
		//第五步:给单元格设置内容  
        nCell.setCellValue("技术部门发红利");
        
        //创建单元格样式(样式整个工作簿通用)  
        CellStyle titleStyle=workbook.createCellStyle(); 
        
        Font titleFont=workbook.createFont(); 
        titleFont.setFontName("微软雅黑");          //设置字体  
        titleFont.setFontHeightInPoints((short)26); //设置字大小  
        
        titleStyle.setFont(titleFont);
        nCell.setCellStyle(titleStyle);
        
        //////
        
        Row xRow=sheet.createRow(4);  
        Cell xCell=xRow.createCell(3);  
        xCell.setCellValue("www.baidu.com");  
          
        CellStyle textStyle=workbook.createCellStyle();  
        Font textFont=workbook.createFont();  
        textFont.setFontName("Times News Roman");  
        textFont.setFontHeightInPoints((short)12);  
          
        textStyle.setFont(textFont);  
          
        xCell.setCellStyle(textStyle);  
        
      //第六步:保存
        OutputStream  os=new FileOutputStream(new File("F:\\testPOI.xls"));
		workbook.write(os);
		
		//第七步:关闭  
        os.close();
		
	}
}
