package edu.fatec.classes;

public class Prova {
	private float nota;
	private int peso;	
	
	public Prova(float nota, int peso) {
		this.setProva(nota, peso);
	}

	public Prova() {
		
	}
	
	public float getNota() {
		return nota;
	}
	
	public void setNota(float nota) {
		if(nota >= 0 && nota <= 10)	
			this.nota = nota;
	}
	public int getPeso() {
		return peso;
	}
	
	public void setPeso(int peso) {
		if(peso > 0)
			this.peso = peso;
	}
	
	public void setProva(float nota, int peso) {
		this.setNota(nota);
		this.setPeso(peso);
	}
}
