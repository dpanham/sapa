package edu.fatec.sapa.test;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import edu.fatec.sapa.model.Endereco;
import edu.fatec.sapa.util.DataPoi;
public class TestEndereco {

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
		data1 = dataPoi.extractExcelContentByColumnIndex(21); //endereco residencial
		data2 = dataPoi.extractExcelContentByColumnIndex(35); //bairro residencial
		data3 = dataPoi.extractExcelContentByColumnIndex(36); //cidade residencial
		
		for (int i = 0; i < data1.size(); i++) {
			Endereco endereco = new Endereco();
			endereco.setEndereco(data1.get(i));
			endereco.setBairro(data2.get(i));
			endereco.setCidade(data3.get(i));
			
			manager.persist(endereco);
		}
		trx.commit();
	}
}