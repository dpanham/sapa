package edu.fatec.sapa.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.fatec.sapa.util.DataPoi;
/**
 * Spreadsheet connection test (not used on program. only test purpose)
 */
public class Test {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("db_sapa");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction trx = manager.getTransaction();
		trx.begin();
		
		ArrayList<String> data1 = new ArrayList<String>();
		ArrayList<String> data2 = new ArrayList<String>();
		ArrayList<String> data3 = new ArrayList<String>();
		
		DataPoi dataPoi = new DataPoi();
		//get data from selected Excel Column
		data1 = dataPoi.extractExcelContentByColumnIndex(8);
		data2 = dataPoi.extractExcelContentByColumnIndex(9);
		data3 = dataPoi.extractExcelContentByColumnIndex(4);
		
		//Get distinct values from ArrayList and save the data back
		HashSet<String> distinctData1 = new HashSet<>(data1);
		data1.clear();
		data1.addAll(distinctData1);
		Collections.sort(data1); //sort data
		//Get distinct values from ArrayList and save the data back
		HashSet<String> distinctData2 = new HashSet<>(data2);
		data2.clear();
		data2.addAll(distinctData2);
		Collections.sort(data2); //sort data
		//Get distinct values from ArrayList and save the data back
		HashSet<String> distinctData3 = new HashSet<>(data3);
		data3.clear();
		data3.addAll(distinctData3);
		Collections.sort(data3); //sort data

		int i, j, k;
		int count = 0;
		for (i = 0; i < data1.size(); i++) {
		    for (j = 0; j < data2.size(); j++) {
		        for (k = 0; k < data3.size(); k++) {
		            count++;
		            System.out.println(count + ". " +data1.get(i) + data2.get(j) + data3.get(k));
		        }
		    }
		}

	}
}