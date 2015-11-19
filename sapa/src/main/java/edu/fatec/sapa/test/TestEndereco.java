package edu.fatec.sapa.test;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import edu.fatec.sapa.dao.AlunoDAO;
import edu.fatec.sapa.model.Aluno;
import edu.fatec.sapa.model.Endereco;
import edu.fatec.sapa.poi.DataPoi;
public class TestEndereco {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("db_sapa");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction trx = manager.getTransaction();
		trx.begin();
		
		AlunoDAO alunoDAO = new AlunoDAO();
		List<Object[]> list;
		list = alunoDAO.getAluno();
		
		ArrayList<String> data1 = new ArrayList<String>();
		ArrayList<String> data2 = new ArrayList<String>();
		ArrayList<String> data3 = new ArrayList<String>();
		ArrayList<String> data4 = new ArrayList<String>();
		
		DataPoi dataPoi = new DataPoi();
		//get data from selected Excel Column
		data1 = dataPoi.extractExcelContentByColumnIndex(21); //endereco residencial
		data2 = dataPoi.extractExcelContentByColumnIndex(35); //bairro residencial
		data3 = dataPoi.extractExcelContentByColumnIndex(36); //cidade residencial
		data4 = dataPoi.extractExcelContentByColumnIndex(5); //ra
		
		for (int i = 0; i < data1.size(); i++) {
			Endereco endereco = new Endereco();
			endereco.setEndereco(data1.get(i));
			endereco.setBairro(data2.get(i));
			endereco.setCidade(data3.get(i));
			
			for (Object o : list) {
				Aluno e = (Aluno) o;
				if (Long.parseLong(data4.get(i)) == e.getRa()) {
					endereco.setCod_aluno(e.getCod_aluno());
				}
			}			
			manager.persist(endereco);
		}
		trx.commit();
	}
}