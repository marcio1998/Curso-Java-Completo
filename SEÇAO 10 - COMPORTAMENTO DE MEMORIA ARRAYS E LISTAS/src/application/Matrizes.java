package application;

import java.util.Scanner;

public class Matrizes {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		//criando a matriz. instancia a matriz na memoria.
		int[][] mat = new int[n][n];
		
		//Propriedade length, para matriz - linhas e colunas
		for(int i = 0; i<mat.length; i++) {
			for(int j = 0; j<mat[i].length; j++) {
				mat[i][j] = sc.nextInt();
			}
		}
		
		//imprimir diagonal principal. 
		System.out.println("Main Diagonal: ");
		for(int i = 0; i<mat.length; i++) {
			System.out.println(mat[i][i]+ " ");
		}
		System.out.println();
		
		//imprimir a quantidade de números negativos.
		int negativeNumbers = 0;
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				if(mat[i][j] < 0) {
					negativeNumbers++;
				}
			}
		}
		System.out.println("Negative Numbers: " + negativeNumbers);
		
		sc.close();
	}
}
