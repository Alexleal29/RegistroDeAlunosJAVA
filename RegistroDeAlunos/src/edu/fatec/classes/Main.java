package edu.fatec.classes;

public final class Main {

	public static void main(String[] args) {
		Turma turma = new Turma(5);
		GerenciadorDeTurma gt = new GerenciadorDeTurma();
		
		/*gt.inserirAluno(turma, new Aluno("123", "Fulano", "Banco de Dados"));
		gt.inserirAluno(turma, new Aluno("124", "Beltrano", "Mecânica de Aeronaves"));
		gt.inserirAluno(turma, new Aluno("125", "Ciclano", "Logistica"));
		*/
		
		gt.inserirAluno(turma, new Aluno("1041", "Fulano", "Banco de Dados"));
		gt.inserirAluno(turma, new Aluno());
		gt.inserirAluno(turma, new Aluno("1042", "Ciclano", "ADS"));
		
		Prova[] provas = new Prova[4];
		for(int i = 0; i < provas.length; i++)
			provas[i] = new Prova();
		provas[0].setProva(10f, 1);
		provas[1].setProva(9f, 2);
		provas[2].setProva(8f, 1);
		provas[3].setProva(7f, 2);
		gt.inserirAluno(turma, new Aluno("1043", "Beltrano", "Matemática", provas));
		
		
		gt.imprimirListaDeAlunos(turma);
		System.out.println(turma.getAlunos()[1].getCurso());
		
	}

}
