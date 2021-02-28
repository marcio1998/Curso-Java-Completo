import java.util.Locale;

public class SaidaDeDados {

	public static void main(String[] args) {
		int y = 32;
		double x = 10.35784;
		String nome = "Maria";
		int idade = 31;
		double renda = 4000.0;
		System.out.println(y);
		System.out.printf("%.2f%n", x);// printf para formatação.
		// Formatando o número do tipo double.
		Locale.setDefault(Locale.US);//trocar vírgula por ponto.
		System.out.printf("%.4f%n", x);
		System.out.println("Concatenação");
		System.out.println("RESULTADO = " + x + " Metros");
		// Concatenação usando o printf.
		System.out.println("Concatenação com printf");
		System.out.printf("RESULTADO = %.2f metros %n%n", x);
		System.out.printf("%s tem %d anos e ganha R$ %.2f reais%n", nome, idade, renda);

	}

}
