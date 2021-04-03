package exercisesEntities;

public class PessoaFisica extends Pessoa {
	private Double gastosComSaude;
	
	public PessoaFisica() {
		super();
	}
	
	
	
	
	public PessoaFisica(String nome, Double rendaAnual, Double gastosComSaude) {
		super(nome, rendaAnual);
		this.gastosComSaude = gastosComSaude;
	}
	
	

	public Double getGastosComSaude() {
		return gastosComSaude;
	}




	public void setGastosComSaude(Double gastosComSaude) {
		this.gastosComSaude = gastosComSaude;
	}


	@Override
	public Double calculoImposto() {
		if(super.rendaAnual < 20000) {
			return (super.rendaAnual * 0.15) - (this.gastosComSaude * 0.5);
		}else {
			return (super.rendaAnual * 0.25) - (this.gastosComSaude * 0.5);
		}
	}

	@Override
	public String toString() {
		return super.nome + ": " + String.format("%.2f",this.calculoImposto());
	}
	
	
}
