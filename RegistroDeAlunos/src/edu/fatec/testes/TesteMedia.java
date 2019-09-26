package edu.fatec.testes;

import static org.junit.Assert.*;
import edu.fatec.classes.*;

import org.junit.Test;

import edu.fatec.classes.GerenciadorDeAluno;
import edu.fatec.classes.GerenciadorDeTurma;
import edu.fatec.classes.Prova;

public class TesteMedia {

	GerenciadorDeTurma gt = new GerenciadorDeTurma();
	GerenciadorDeAluno ga = new GerenciadorDeAluno();
	
	@Test
	public void testaMedia() {
		Turma turma = new Turma(1);
		
		Prova[] provas = new Prova[4];
		for(int i = 0; i < provas.length; i++)
			provas[i] = new Prova();
		provas[0].setProva(5.5f, 1);
		provas[1].setProva(5f, 2);
		provas[2].setProva(3.5f, 1);
		provas[3].setProva(6.5f, 2);
		ga.alterarDadosDoAluno(turma.getAlunos()[0], "123", "Aluno", "BD", provas);
		assertEquals(5.33, turma.getAlunos()[0].calcularMedia(), 0.05);
	}

}
