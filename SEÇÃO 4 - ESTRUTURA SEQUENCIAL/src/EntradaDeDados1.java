import java.util.Locale;
import java.util.Scanner;//Importando a classe que permite acesso a leitura de dados.

public class EntradaDeDados1 {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in); // usar a classe Scanner na variavel sc.
		String nome;
		int x;
		double y;
		char z;
		// Leitura de dados é feita a paritr do console.
		nome = sc.next();// permitir a leitura de dados, para armazenar na variavel x.
		System.out.println("Você digitou: " + nome);
		// Lendo um número inteiro.
		x = sc.nextInt();
		System.out.println("Você digitou: " + x);
		y = sc.nextDouble();
		System.out.println("Você digitou: " + y);
		// Lendo uma variável do tipo char.
		z = sc.next().charAt(0);
		System.out.println("Você Digitou: " + z);
		sc.close();

	}

}
