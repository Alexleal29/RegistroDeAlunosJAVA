package edu.fatec.classes;

public final class GerenciadorDeTurma {

	public void imprimirListaDeAlunos(Turma turma) {
		for(Aluno aluno : turma.getAlunos()) {
			if(aluno.getMatricula() != null)
				System.out.println(aluno);
		}
	}
	
	/**
	 *	Função que busca um aluno conforme o nome oferecido.
	 *	Retorna a posição dele no array ou -1 em caso dele não existir. 
	 */
	public int consultarAlunoPorNome(Turma turma, String nome) {
		for(int i = 0; i < turma.getQtdMaxAlunos(); i++) {
			try {
				Aluno aluno = turma.getAlunos()[i]; 
				if(aluno.getNome().equals(nome))
					return i;
			}catch(NullPointerException ex){}
		}
		return -1;
	}
	
	/**
	 *	Função que busca um aluno conforme a matricula oferecida.
	 *	Retorna a posição dele no array ou -1 em caso dele não existir. 
	 */
	public int consultarAlunoPorMatricula(Turma turma, String matricula) {
		for(int i = 0; i < turma.getQtdMaxAlunos(); i++) {
			try {
				Aluno aluno = turma.getAlunos()[i]; 
				if(aluno.getMatricula().equals(matricula))
					return i;
			}catch(NullPointerException ex) {}
		}
		return -1;
	}

	public boolean qtdMaximaDeAlunosCadastrados(Turma turma) {
		return (turma.getQtdAlunosCadastrados() == turma.getQtdMaxAlunos());
	}
	
	public boolean alunoJaInserido(Turma turma, String matricula) {
		return (this.consultarAlunoPorMatricula(turma, matricula) != -1);
	}
	
	public boolean inserirAluno(Turma turma, Aluno aluno) {
		boolean alunoNulo = aluno.getMatricula() == null;
		boolean atingiuLimite = this.qtdMaximaDeAlunosCadastrados(turma);
		boolean alunoJainserido = this.alunoJaInserido(turma, aluno.getMatricula()); 
		if(alunoNulo || atingiuLimite || alunoJainserido)
			return false;
		int posicaoVazia = turma.getQtdAlunosCadastrados();
		turma.setAlunos(aluno, posicaoVazia);
		turma.setQtdAlunosCadastrados(turma.getQtdAlunosCadastrados()+1);
		return true;
	}
	
	public boolean excluirAluno(Turma turma, String nome) {
		int posicaoAluno = this.consultarAlunoPorNome(turma, nome);
		boolean alunoExiste = (posicaoAluno != -1);
		if(alunoExiste) {
			GerenciadorDeAluno ger = new GerenciadorDeAluno();
			ger.apagarDadosDoAluno(turma.getAlunos()[posicaoAluno]);
			turma.setQtdAlunosCadastrados(turma.getQtdAlunosCadastrados()-1);
			this.realocarArrayDeAlunos(turma);
			return true;
		}
		return false;
	}
	
	/** 
	 * Função que desloca os elementos não nulos para as primeiras posições.
	 * Tem como finalidade garantir a ordem de inserção.
	 */
	private void realocarArrayDeAlunos(Turma turma) {
		Turma copia = new Turma(turma.getQtdMaxAlunos());
		copia.inicializaArrayDeAlunos(turma.getQtdMaxAlunos());
		copia.setAlunos(turma.getAlunos());
		for(int i = 0; i < turma.getQtdMaxAlunos(); i++) {
			boolean ultimaPosicao = (i == copia.getQtdMaxAlunos()-1);
			boolean alunoNulo = (copia.getAlunos()[i].getMatricula() == null); 
			if(!ultimaPosicao && alunoNulo) {
				int j = i + 1;
				while(j < copia.getQtdMaxAlunos() && copia.getAlunos()[j] == null) j++;  //será feita uma busca do próximo elemento não nulo
				if(copia.getAlunos()[j].getMatricula() == null)
					continue; //não foi encontrado, passa pra proxima interação
				//aqui é feito um swap entre o elemento atual (nulo) e o elemento buscado (não nulo)
				Aluno aux = copia.getAlunos()[i];
				copia.getAlunos()[i] = copia.getAlunos()[j];
				copia.getAlunos()[j] = aux;
			}
		}
		turma.setAlunos(copia.getAlunos());
	}
	
}
