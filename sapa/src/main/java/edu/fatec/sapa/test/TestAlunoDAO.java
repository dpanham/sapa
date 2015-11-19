package edu.fatec.sapa.test;

import java.util.List;

import edu.fatec.sapa.dao.AlunoDAO;
import edu.fatec.sapa.model.Aluno;

public class TestAlunoDAO {

	public static void main(String[] args) {
		AlunoDAO alunoDAO = new AlunoDAO();
		List<Object[]> list;
		list = alunoDAO.getAluno();
		
		for (Object o : list) {
			Aluno e = (Aluno) o;
			System.out.println(e.getRa() + e.getRaca());
		}
	}
}
