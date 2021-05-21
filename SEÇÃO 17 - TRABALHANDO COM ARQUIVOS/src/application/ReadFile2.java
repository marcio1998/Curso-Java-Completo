package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile2 {

	public static void main(String[] args) {
		String path = "C:\\Users\\Gabriel\\Desktop\\CURSOS\\CURSOS UDEMY\\Java Completo\\SEÇÃO 17 - TRABALHANDO COM ARQUIVOS\\in.txt";
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			String line = br.readLine();
			while(line != null) {
				System.out.println(line);
				line = br.readLine();
			}
		}catch(IOException e) {
			System.out.println("ERROR: " + e.getMessage());
		}

	}

}
