package application;

import java.util.Locale;
import java.util.Scanner;

public class Vetores1 {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		//vetor tem que ser instanciado, opera na parte heap da memoria.
		double[] vect = new double[n];
		
		//Percorrer Vetor.
		for(int i=0; i<n; i++) {
			vect[i] = sc.nextDouble();
		}
		
		double sum = 0;
		for(int i=0; i<n; i++) {
			sum += vect[i];
		}
		
		double avg = sum/n;
		
		System.out.println("Average height: " + String.format("%.2f",avg));
		
		
		sc.close();

	}

}
