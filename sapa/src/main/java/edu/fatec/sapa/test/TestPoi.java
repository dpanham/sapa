package edu.fatec.sapa.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

import edu.fatec.sapa.poi.DataPoi;

/**
 * Spreadsheet connection test (not used on program. only test purpose)
 */
public class TestPoi {

	public static void main(String[] args) {
		ArrayList<String> data = new ArrayList<String>();
		DataPoi dataPoi = new DataPoi();
		//get data from selected Excel Column
		data = dataPoi.extractExcelContentByColumnIndex(13);
		
		//Get distinct values from ArrayList and save the data back
		HashSet<String> distinctData = new HashSet<>(data);
		data.clear();
		data.addAll(distinctData);
		//sort data
		Collections.sort(data);
		
		for (int i = 0; i < data.size(); i++) {
			System.out.println(data.get(i));
		}
	}
}
