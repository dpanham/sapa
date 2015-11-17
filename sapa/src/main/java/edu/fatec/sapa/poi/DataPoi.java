package edu.fatec.sapa.poi;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class DataPoi {

	public ArrayList<String> extractExcelContentByColumnIndex(int columnIndex) {
		ArrayList<String> columnData = new ArrayList<String>();

		try {
			// open file
			FileInputStream file = new FileInputStream(
			new File("D:\\eclipse-Mars\\sapa.git\\sapa\\src\\main\\java\\edu\\fatec\\sapa\\poi\\ss.xls"));
/*			new File("C:\\Users\\usantos\\Downloads\\soft\\eclipse-Mars\\ws\\sapa\\src\\main\\java\\edu\\fatec\\sapa\\poi\\ss.xls"));*/
			// Get the workbook instance for XLS file
			HSSFWorkbook workbook = new HSSFWorkbook(file);
			// Get first sheet from the workbook
			HSSFSheet sheet = workbook.getSheetAt(0);

			// Iterate through each rows from first sheet
			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) {
				Row row = (Row) rowIterator.next();
				
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					if(row.getRowNum() > 0){ //To filter column headings
						if (cell.getColumnIndex() == columnIndex) {// To match column index
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_BOOLEAN:
								columnData.add(cell.getBooleanCellValue()+"");
							case Cell.CELL_TYPE_NUMERIC:
								columnData.add(cell.getNumericCellValue()+"");
							case Cell.CELL_TYPE_STRING:
								columnData.add(cell.getStringCellValue());
								break;
							}
						}						
					}
				}
			}
			file.close();
			workbook.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return columnData;
	}
}
