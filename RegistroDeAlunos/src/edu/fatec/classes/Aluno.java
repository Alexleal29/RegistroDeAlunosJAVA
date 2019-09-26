package edu.fatec.classes;

public class Aluno {

	private String matricula;
	private String nome;
	private String curso;
	private final int totalDeProvas = 4;
	private Prova[] provas = new Prova[this.totalDeProvas];
	
	public Aluno(String matricula, String nome, String curso, Prova[] provas) {
		this.setMatricula(matricula);
		this.setNome(nome);
		this.setCurso(curso);
		this.setProvas(provas);
	}
	
	public Aluno(String matricula, String nome, String curso) {
		this.setMatricula(matricula);
		this.setNome(nome);
		this.setCurso(curso);
		this.inicializaArrayDeProvas();
	}
	
	public Aluno(String matricula, String nome) {
		this.setMatricula(matricula);
		this.setNome(nome);
		this.inicializaArrayDeProvas();
	}
	
	public Aluno() {
		
	}
	
	protected void inicializaArrayDeProvas() {
		for(int i = 0; i < this.getProvas().length; i++)
			this.provas[i] = new Prova();
	}

	public String getMatricula() {
		return matricula;
	}

	protected void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	protected void setNome(String nome) {
		this.nome = nome;
	}

	public String getCurso() {
		return curso;
	}

	protected void setCurso(String curso) {
		this.curso = curso;
	}

	
	public int getTotalDeProvas() {
		return totalDeProvas;
	}

	public Prova[] getProvas() {
		return provas;
	}

	protected void setProvas(Prova[] provas) {
		if(provas.length == this.getTotalDeProvas())
			this.provas = provas;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Aluno [ matricula: ").append(matricula).append("\tnome: ").append(nome).append("\tcurso: ")
				.append(curso).append(" ]");
		return builder.toString();
	}
	
	public float calcularMedia() {
		float somatorioNotas = 0.0f;
		float somatorioPesos = 0.0f;
		for(int i = 0; i < 4; i++) {
			somatorioNotas += (this.getProvas()[i].getNota() * this.getProvas()[i].getPeso());
			somatorioPesos += this.getProvas()[i].getPeso();
		}
		return (somatorioNotas/somatorioPesos);
	}
	
}
