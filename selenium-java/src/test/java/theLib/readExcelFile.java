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

	public readExcelFile(String filePath, String sheetName, String rowName) {
		this.filePath = filePath;
		this.sheetName = sheetName;
		this.rowName = rowName;
	}

	public ArrayList<String> getRowValues() throws IOException {
		values = new ArrayList<String>();
		FileInputStream inputStream = new FileInputStream(new File(filePath));
		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		Iterator<Row> iterator = sheet.iterator();

		while (iterator.hasNext()) {
			Row nextRow = iterator.next();
			Iterator<Cell> cellIterator = nextRow.cellIterator();
			Cell firtCell = cellIterator.next();
			if (rowName.equals(firtCell.getStringCellValue().trim())) {
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					values.add(cell.getStringCellValue());
				}
			}
		}

		return values;
	}

	public String getFontFamily(ArrayList<String> rowExcel) {
		String fontFamily = "";
		for (String row : rowExcel) {
			if (row.contains("font_family")) {
				int colonPosition = row.indexOf(":");
				fontFamily = row.substring(colonPosition + 1).trim();
				break;
			}
		}
		return fontFamily;
	}

	public String getFontSize(ArrayList<String> rowExcel) {
		String fontSize = "";
		for (String row : rowExcel) {
			if (row.contains("font_size")) {
				int colonPosition = row.indexOf(":");
				fontSize = row.substring(colonPosition + 1).trim();
				break;
			}
		}
		return fontSize;
	}

	public String getFontColor(ArrayList<String> rowExcel) {
		String fontColor = "";
		for (String row : rowExcel) {
			if (row.contains("font_color")) {
				int colonPosition = row.indexOf(":");
				fontColor = row.substring(colonPosition + 1).trim();
				break;
			}
		}
		return fontColor;
	}
	
	public String getSortIconColor(ArrayList<String> rowExcel) {
		String sortIconColor = "";
		for (String row : rowExcel) {
			if (row.contains("sort_icon_color")) {
				int colonPosition = row.indexOf(":");
				sortIconColor = row.substring(colonPosition + 1).trim();
				break;
			}
		}
		return sortIconColor;
	}
}
