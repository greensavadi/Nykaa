package com.nyka;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteDataIntoExcel {
	
	
	public static void main(String[] args) throws IOException {
		
		File f = new File("D:\\Avadi\\workspace\\nyka\\excel\\Gmail_cred.xlsx");
		
		FileInputStream fis = new FileInputStream(f);
		
		Workbook wb = new XSSFWorkbook(fis);
		
		Sheet sheet = wb.createSheet("insta1");
		
		Row row = sheet.createRow(0);
		
		Cell cell = row.createCell(0, CellType.STRING);
		
		cell.setCellValue("user");
		
		
		sheet.getRow(0).createCell(1, CellType.STRING).setCellValue("pass");
		sheet.getRow(0).createCell(2, CellType.STRING).setCellValue("contact");
		
		sheet.createRow(1).createCell(0, CellType.STRING).setCellValue("qwertyu");
		sheet.getRow(1).createCell(1).setCellValue("asdfg");
		
		
		FileOutputStream fos = new FileOutputStream(f);
		
		wb.write(fos);
		
		wb.close();
		
	}

}
