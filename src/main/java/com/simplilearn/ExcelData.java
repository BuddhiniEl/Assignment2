package com.simplilearn;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {
	static String PATH = "./testdata.xlsx";
		
	public Object[][] getData()  throws Exception{

        FileInputStream excelFile = new FileInputStream(new File(PATH));
        XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
        XSSFSheet sheet = workbook.getSheet("Tests");
        
        List<Object[]> rows = new ArrayList<Object[]>();
        
        Iterator<Row> itr = sheet.iterator();
        
        while(itr.hasNext()) {
        	Row row = itr.next();
        	
        	Cell key = row.getCell(0);
        	Cell item = row.getCell(1);
        	
        	String[] data = new String[] {
        			key.getStringCellValue(),
        			item.getStringCellValue()
        	};
        	rows.add(data);
        }
        
        Object[][] objects = new Object[rows.size()][2];
        
        for(int row = 0; row < rows.size(); row++) {
        	objects[row] = rows.get(row);
        }
        
        return objects;
	}
}