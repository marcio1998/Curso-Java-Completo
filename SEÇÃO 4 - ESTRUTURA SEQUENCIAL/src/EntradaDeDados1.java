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
		// Leitura de dados � feita a paritr do console.
		nome = sc.next();// permitir a leitura de dados, para armazenar na variavel x.
		System.out.println("Voc� digitou: " + nome);
		// Lendo um n�mero inteiro.
		x = sc.nextInt();
		System.out.println("Voc� digitou: " + x);
		y = sc.nextDouble();
		System.out.println("Voc� digitou: " + y);
		// Lendo uma vari�vel do tipo char.
		z = sc.next().charAt(0);
		System.out.println("Voc� Digitou: " + z);
		sc.close();

	}

}
