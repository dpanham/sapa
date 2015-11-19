package edu.fatec.sapa.test;

import java.util.List;
import edu.fatec.sapa.dao.PeriodoDAO;
import edu.fatec.sapa.model.Periodo;

public class TestPeriodoDAO {

	public static void main(String[] args) {
		PeriodoDAO periodoDAO = new PeriodoDAO();

		List<Object[]> list;
		list = periodoDAO.getPeriodo();
		
		for (Object o : list) {
			Periodo e = (Periodo) o;
			System.out.println(e.getAno_ingresso() + e.getPeriodo());
		}

	}

}
