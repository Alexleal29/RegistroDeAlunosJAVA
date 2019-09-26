package edu.fatec.classes;

public class Turma {
	
	private int qtdMaxAlunos;
	private int qtdAlunosCadastrados = 0;
	private Aluno[] alunos;
	
	public Turma(int qtdMaxAlunos) {
		this.qtdMaxAlunos = qtdMaxAlunos;
		this.alunos = new Aluno[this.getQtdMaxAlunos()]; //aqui a ideia é limitar o tamanho do array
		inicializaArrayDeAlunos(this.getQtdMaxAlunos()); //já aqui é pra evitar null pointers
	}
	
	protected void inicializaArrayDeAlunos(int qtdMax) {
		for(int i = 0; i < qtdMax; i++)
			this.alunos[i] = new Aluno();
	}
	
	public int getQtdMaxAlunos() {
		return qtdMaxAlunos;
	}
	
	public int getQtdAlunosCadastrados() {
		return this.qtdAlunosCadastrados;
	}

	public void setQtdAlunosCadastrados(int qtd) {
		this.qtdAlunosCadastrados = qtd;
	}
	
	public Aluno[] getAlunos() {
		return this.alunos;
	}
	
	public void setAlunos(Aluno aluno, int posicao) {
		try{
			this.alunos[posicao] = aluno;
		}catch(ArrayIndexOutOfBoundsException ex) {
			ex.printStackTrace();
		};
	}
	
	public void setAlunos(Aluno[] aluno) {
		if(aluno.length == this.getQtdMaxAlunos())
			this.alunos = aluno.clone();
	}
	
}
