package edu.fatec.sapa.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.fatec.sapa.model.*;
import edu.fatec.sapa.poi.DataPoi;
public class TestSituacao {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("db_sapa");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction trx = manager.getTransaction();
		trx.begin();
		
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
			Situacao situacao = new Situacao();
			situacao.setSituacao(data.get(i));
			manager.persist(situacao);
		}
		trx.commit();		
	}
}