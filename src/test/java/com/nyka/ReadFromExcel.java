package com.nyka;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadFromExcel {
	
	public static void main(String[] args) throws IOException {
		
		File f = new File("D:\\Avadi\\workspace\\nyka\\excel\\Gmail_cred.xlsx");
		
		FileInputStream fis = new FileInputStream(f);
		
		Workbook wb = new XSSFWorkbook(fis);
		
		Sheet sheet = wb.getSheet("gmail");
		
		Row row = sheet.getRow(2);
		
		Cell cell = row.getCell(1);
		
		CellType cellType = cell.getCellType();
		
		System.out.println(cellType);
		
		System.out.println(cell);
		
		wb.close();
		
		
		
	}

}
