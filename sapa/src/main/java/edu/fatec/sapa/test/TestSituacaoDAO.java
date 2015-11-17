package edu.fatec.sapa.test;

import java.util.List;
import edu.fatec.sapa.dao.SituacaoDAO;
import edu.fatec.sapa.model.Situacao;

public class TestSituacaoDAO {

	public static void main(String[] args) {
		SituacaoDAO situacaoDAO = new SituacaoDAO();

		List<Object[]> list;
		list = situacaoDAO.getSituacao();
		//System.out.println(list.getClass());
		
		for (Object o : list) {
			Situacao e = (Situacao) o;
			System.out.println(e.getCod_situacao() + e.getSituacao());
		}

		/*
		 * Situacao situacao = new Situacao(); list = situacaoDAO.getSituacao();
		 */

		/*
		 * Situacao situacao = new Situacao(); situacaoDAO.search();
		 */

		/*
		 * SituacaoDAO situacaoDAO = new SituacaoDAO(); Situacao situacao = new
		 * Situacao(); situacao = situacaoDAO.getSituacao();
		 * System.out.println(situacao.getSituacao());
		 */

		/*
		 * UserDAO userDAO = new UserDAO(); User user = new User(); user =
		 * userDAO.getUser("usantos", "123"); System.out.println(user);
		 */
	}

}
