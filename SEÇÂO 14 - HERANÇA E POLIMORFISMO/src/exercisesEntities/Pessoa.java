package exercisesEntities;

public abstract class Pessoa {
	protected String nome;
	protected Double rendaAnual;
	
	public Pessoa() {
		
	}

	public Pessoa(String nome, Double rendaAnual) {
		this.nome = nome;
		this.rendaAnual = rendaAnual;
	}
	
	public abstract Double calculoImposto();
	
	
	
}
