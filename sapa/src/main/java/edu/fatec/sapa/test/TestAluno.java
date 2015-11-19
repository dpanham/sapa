package edu.fatec.sapa.test;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.fatec.sapa.dao.PeriodoDAO;
import edu.fatec.sapa.dao.SituacaoDAO;
import edu.fatec.sapa.model.Aluno;
import edu.fatec.sapa.model.Periodo;
import edu.fatec.sapa.model.Situacao;
import edu.fatec.sapa.poi.DataPoi;
public class TestAluno {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("db_sapa");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction trx = manager.getTransaction();
		trx.begin();
		
		SituacaoDAO situacaoDAO = new SituacaoDAO();
		List<Object[]> listSituacao;
		listSituacao = situacaoDAO.getSituacao();
		
		PeriodoDAO periodoDAO = new PeriodoDAO();
		List<Object[]> listPeriodo;
		listPeriodo = periodoDAO.getPeriodo();
		
		ArrayList<String> data1 = new ArrayList<String>();
		ArrayList<String> data2 = new ArrayList<String>();
		ArrayList<String> data3 = new ArrayList<String>();
		ArrayList<String> data4 = new ArrayList<String>();
		ArrayList<String> data5 = new ArrayList<String>();
		ArrayList<String> data6 = new ArrayList<String>();
		ArrayList<String> data7 = new ArrayList<String>();
		ArrayList<String> data8 = new ArrayList<String>();
		
		DataPoi dataPoi = new DataPoi();
		//get data from selected Excel Column
		data1 = dataPoi.extractExcelContentByColumnIndex(5); //ra
		data2 = dataPoi.extractExcelContentByColumnIndex(7); //data nascimento
		data3 = dataPoi.extractExcelContentByColumnIndex(10); //sexo
		data4 = dataPoi.extractExcelContentByColumnIndex(11); //raça
		data5 = dataPoi.extractExcelContentByColumnIndex(13); //situacao
		data6 = dataPoi.extractExcelContentByColumnIndex(8); //ano ingresso
		data7 = dataPoi.extractExcelContentByColumnIndex(4); //periodo
		data8 = dataPoi.extractExcelContentByColumnIndex(9); //semestre ingresso
		
		for (int i = 0; i < data1.size(); i++) {			
			Aluno aluno = new Aluno();
			aluno.setRa(Long.parseLong(data1.get(i)));
			aluno.setSexo(Integer.parseInt(data3.get(i).trim()));
			aluno.setRaca(data4.get(i));
			
			//Compare situacao to fill foreign key
			for (Object o : listSituacao) {
				Situacao e = (Situacao) o;
				if (data5.get(i).equals(e.getSituacao())) {
					aluno.setCod_situacao(e.getCod_situacao());
				}
			}
			
			for (Object o : listPeriodo) {
				Periodo e = (Periodo) o;				
				if (Integer.parseInt(data6.get(i)) == e.getAno_ingresso() && data7.get(i).equals(e.getPeriodo()) && Integer.parseInt(data8.get(i).trim()) == e.getSemestre_ingresso()) {
					aluno.setCod_periodo(e.getCod_periodo());
				}
			}
			
			manager.persist(aluno);
		}
		trx.commit();
	}
}