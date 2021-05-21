package application;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ReadFile {
	public static void main (String[] args) {
		//ler arquivo
		File file = new File("C:\\Users\\Gabriel\\Desktop\\CURSOS\\CURSOS UDEMY\\Java Completo\\SEÇÃO 17 - TRABALHANDO COM ARQUIVOS\\in.txt");
		Scanner sc = null;
		try {
			sc = new Scanner(file);
			while(sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
		}catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}finally {
			if(sc != null) {
				sc.close();
			}
			
		}
		
		
	}
}
