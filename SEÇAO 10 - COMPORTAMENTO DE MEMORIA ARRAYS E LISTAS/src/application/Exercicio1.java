package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Aluguel;

public class Exercicio1 {
	public static void main(String args[]) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		System.out.println("Numero de Estudantes para Alugel: ");
		int n = sc.nextInt();
		if(n == 0 && n>10) {
			System.out.println("Inválido digete um número de 1 a 10");
			System.exit(0);
		}
		Aluguel[] vetorAluguel = new Aluguel[n];
		sc.nextLine();
		for(int i=0; i<vetorAluguel.length; i++) {
			System.out.println("Numero de Quarto: " + (i+1));
			System.out.println("Digite Nome: ");
			String name = sc.nextLine();
			System.out.println("Digite Email: ");
			String email = sc.nextLine();
			vetorAluguel[i] = new Aluguel(i+1, name, email);
			System.out.println();
		}
		for(int i=0; i<vetorAluguel.length;i++) {
			System.out.println(vetorAluguel[i].toString());
		}
		sc.close();
	}
}
