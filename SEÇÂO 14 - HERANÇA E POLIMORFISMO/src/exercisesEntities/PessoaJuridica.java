package exercisesEntities;

public class PessoaJuridica extends Pessoa{
	private int numeroFuncionarios;
	
	public PessoaJuridica() {
		super();
	}
	
	public PessoaJuridica(String nome, Double rendaAnual, int numeroFuncionarios) {
		super(nome, rendaAnual);
		this.numeroFuncionarios = numeroFuncionarios;
	}
	
	
	
	public int getNumeroFuncionarios() {
		return numeroFuncionarios;
	}

	public void setNumeroFuncionarios(int numeroFuncionarios) {
		this.numeroFuncionarios = numeroFuncionarios;
	}

	@Override
	public Double calculoImposto() {
		if(this.numeroFuncionarios < 10) {
			return super.rendaAnual * 0.16;
		}else {
			return super.rendaAnual * 0.14;
		}
	}
	
	@Override
	public String toString() {
		return super.nome + ": " + String.format("%.2f",this.calculoImposto());
	}
	
	
	


}
