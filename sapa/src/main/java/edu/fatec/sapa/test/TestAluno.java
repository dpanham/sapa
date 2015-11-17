package edu.fatec.sapa.test;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.fatec.sapa.dao.SituacaoDAO;
import edu.fatec.sapa.model.Aluno;
import edu.fatec.sapa.model.Situacao;
import edu.fatec.sapa.poi.DataPoi;
public class TestAluno {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("db_sapa");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction trx = manager.getTransaction();
		trx.begin();
		
		SituacaoDAO situacaoDAO = new SituacaoDAO();
		List<Object[]> list;
		list = situacaoDAO.getSituacao();
		
		ArrayList<String> data1 = new ArrayList<String>();
		ArrayList<String> data2 = new ArrayList<String>();
		ArrayList<String> data3 = new ArrayList<String>();
		ArrayList<String> data4 = new ArrayList<String>();
		ArrayList<String> data5 = new ArrayList<String>();
		
		DataPoi dataPoi = new DataPoi();
		//get data from selected Excel Column
		data1 = dataPoi.extractExcelContentByColumnIndex(5); //ra
		data2 = dataPoi.extractExcelContentByColumnIndex(7); //data nascimento
		data3 = dataPoi.extractExcelContentByColumnIndex(10); //sexo
		data4 = dataPoi.extractExcelContentByColumnIndex(11); //raça
		data5 = dataPoi.extractExcelContentByColumnIndex(13); //situacao
		
		for (int i = 0; i < data1.size(); i++) {			
			Aluno aluno = new Aluno();
			aluno.setRa(Long.parseLong(data1.get(i)));
			aluno.setSexo(Integer.parseInt(data3.get(i).trim()));
			aluno.setRaca(data4.get(i));
			
			for (Object o : list) {
				Situacao e = (Situacao) o;
				if (data5.get(i).equals(e.getSituacao())) {
					aluno.setCod_situacao(e.getCod_situacao());
				}
			}
			
			manager.persist(aluno);			
		}
		trx.commit();
	}
}