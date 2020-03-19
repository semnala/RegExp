package com.regexp.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	
	private static XSSFWorkbook workbook;

	public static ArrayList<String> ExcelRead(String fileName, String uploadPath) {
		ArrayList<String> excelList = new ArrayList<String>();
		try {
			FileInputStream fis = new FileInputStream(uploadPath+File.separator+fileName);
			workbook = new XSSFWorkbook(fis);
			
			int rowIndex;
			int columIndex = 0;
			
			XSSFSheet sheet = workbook.getSheetAt(0); // 첫번째 시트만 읽는다.
			
			int rows = sheet.getPhysicalNumberOfRows(); // 전체 행의 수
			
			for(rowIndex=0 ; rowIndex<rows; rowIndex++ ) {
				XSSFRow row = sheet.getRow(rowIndex);
				if(row != null) {
					XSSFCell cell = row.getCell(columIndex);
					String value="";
					if(cell== null) {
						continue;
					} else {
						switch(cell.getCellType()) {
						case XSSFCell.CELL_TYPE_FORMULA:
							value = cell.getCellFormula();
							break;
						case XSSFCell.CELL_TYPE_NUMERIC:
							value = cell.getNumericCellValue()+"";
							break;
						case XSSFCell.CELL_TYPE_STRING:
							value = cell.getStringCellValue();
							break;
						}
						excelList.add(rowIndex, value);
					}
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return excelList;
	}

}
