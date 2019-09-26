package edu.fatec.testes;

import static org.junit.Assert.*;
import org.junit.Test;
import edu.fatec.classes.*;

public class TesteGerenciadorDeTurma {

	GerenciadorDeTurma gt = new GerenciadorDeTurma();
	
	@Test
	public void testaInsercoes() {
		Turma turma = new Turma(2);
		
		boolean aluno = gt.inserirAluno(turma, new Aluno("1041", "Fulano", "Banco de Dados"));
		assertTrue(aluno);
		
		aluno = gt.inserirAluno(turma, new Aluno());
		assertFalse(aluno);
		
		Prova[] provas = new Prova[4];
		for(int i = 0; i < provas.length; i++)
			provas[i] = new Prova();
		provas[0].setProva(10f, 1);
		provas[1].setProva(9f, 2);
		provas[2].setProva(8f, 1);
		provas[3].setProva(7f, 2);
		gt.inserirAluno(turma, new Aluno("1042", "Beltrano", "Matemática", provas));
		assertArrayEquals(provas, turma.getAlunos()[gt.consultarAlunoPorMatricula(turma, "1042")].getProvas());
	}

	@Test
	public void testaRemocoes() {
		Turma turma = new Turma(3);
		
		gt.inserirAluno(turma, new Aluno("123", "Fulano", "Banco de Dados"));
		gt.inserirAluno(turma, new Aluno("124", "Beltrano", "Mecânica de Aeronaves"));
		gt.inserirAluno(turma, new Aluno("125", "Ciclano", "Logistica"));
		gt.excluirAluno(turma, "Beltrano");
		assertNotNull(turma.getAlunos()[1].getMatricula());
		assertNull(turma.getAlunos()[2].getMatricula());
	}
	
}
