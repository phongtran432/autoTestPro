package theLib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readExcelFile {
	String filePath;
	String sheetName;
	String rowName;
	ArrayList<String> values;
	
	public readExcelFile(String filePath, String sheetName, String rowName){
		this.filePath = filePath;
		this.sheetName = sheetName;
		this.rowName = rowName;
	}
	
	public ArrayList<String> getRowValues() throws IOException{
    	values = new ArrayList<String>();
		FileInputStream inputStream = new FileInputStream(new File(filePath));
    	Workbook workbook = new XSSFWorkbook(inputStream);
    	Sheet sheet = workbook.getSheet(sheetName);
    	Iterator<Row> iterator = sheet.iterator();
    	
    	while (iterator.hasNext()){
    		Row nextRow = iterator.next();
    		Iterator<Cell>cellIterator = nextRow.cellIterator();
    		Cell firtCell = cellIterator.next();
    		if(rowName.equals(firtCell.getStringCellValue().trim())){
    			while(cellIterator.hasNext()){
        			Cell cell = cellIterator.next();
        			values.add(cell.getStringCellValue());
        		}
			}
    	}
    
		return values;
	}
}
