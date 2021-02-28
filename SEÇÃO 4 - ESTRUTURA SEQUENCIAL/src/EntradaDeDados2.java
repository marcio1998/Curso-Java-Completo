import java.util.Scanner;

public class EntradaDeDados2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); //usar a classe Scanner na variavel sc.
		int x;
		String s1, s2, s3;
		//Ler um texto ate a quebra de linha. Para variável do tipo string
		x = sc.nextInt();
		sc.nextLine();
		s1 = sc.nextLine();
		s2 = sc.nextLine();
		s3 = sc.nextLine();
		System.out.println("Dados Digitados: ");
		System.out.println(x);
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		sc.close(); //Fechar a leitura de dados que não for mais utilizada.

	}

}
