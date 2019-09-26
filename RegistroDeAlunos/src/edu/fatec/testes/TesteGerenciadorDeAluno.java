package edu.fatec.testes;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.fatec.classes.Aluno;
import edu.fatec.classes.GerenciadorDeAluno;
import edu.fatec.classes.GerenciadorDeTurma;
import edu.fatec.classes.Prova;
import edu.fatec.classes.Turma;

public class TesteGerenciadorDeAluno {
	
	GerenciadorDeTurma gt = new GerenciadorDeTurma();
	GerenciadorDeAluno ga = new GerenciadorDeAluno();
	
	@Test
	public void testaAlteracoes() {
		Turma turma = new Turma(1);
		
		gt.inserirAluno(turma, new Aluno("0", "Fulano"));
		ga.apagarDadosDoAluno(turma.getAlunos()[0]);
		assertNull(turma.getAlunos()[0].getNome());
		
		ga.alterarDadosDoAluno(turma.getAlunos()[0], "0", "Fulano");
		assertEquals("0", turma.getAlunos()[0].getMatricula());
		assertEquals("Fulano", turma.getAlunos()[0].getNome());
		
		ga.alterarDadosDoAluno(turma.getAlunos()[0], "1", "Beltrano", "Hotelaria");
		assertEquals("Hotelaria", turma.getAlunos()[0].getCurso());
		
		Prova[] provas = new Prova[4];
		for(int i = 0; i < provas.length; i++)
			provas[i] = new Prova();
		provas[0].setProva(7.5f, 3);
		provas[1].setProva(5f, 2);
		provas[2].setProva(8.7f, 3);
		provas[3].setProva(7.2f, 2);
		ga.alterarDadosDoAluno(turma.getAlunos()[0], "2", "Ciclano", "Gastronomia", provas);
		assertArrayEquals(provas, turma.getAlunos()[0].getProvas());
	}

}
