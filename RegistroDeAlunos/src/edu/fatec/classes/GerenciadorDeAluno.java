package edu.fatec.classes;

public final class GerenciadorDeAluno {
	
	public void alterarDadosDoAluno(Aluno aluno, String matricula, String nome, String curso, Prova provas[]) {
		aluno.setMatricula(matricula);
		aluno.setNome(nome);
		aluno.setCurso(curso);
		aluno.setProvas(provas);
	}
	
	public void alterarDadosDoAluno(Aluno aluno, String matricula, String nome, String curso) {
		aluno.setMatricula(matricula);
		aluno.setNome(nome);
		aluno.setCurso(curso);
	}
	
	public void alterarDadosDoAluno(Aluno aluno, String matricula, String nome) {
		aluno.setMatricula(matricula);
		aluno.setNome(nome);
	}
	
	public void apagarDadosDoAluno(Aluno aluno) {
		Prova[] provas = new Prova[4];
		for(int i = 0; i < 4; i++) {
			provas[i] = new Prova(0.0f, 0);
		}
		this.alterarDadosDoAluno(aluno, null, null, null, provas);
	}
	
}
