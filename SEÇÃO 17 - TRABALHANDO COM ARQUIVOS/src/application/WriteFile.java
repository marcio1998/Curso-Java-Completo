package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {
	public static void main(String [] args) {
		String[] lines = new String[] {"Good Morning", "Good Afternoon", "Good Night"};
		String path = "C:\\Users\\Gabriel\\Desktop\\CURSOS\\CURSOS UDEMY\\Java Completo\\SEÇÃO 17 - TRABALHANDO COM ARQUIVOS\\out.txt";
		
		try(BufferedWriter br = new BufferedWriter(new FileWriter(path, true))){
			for(String line : lines) {
				br.write(line);
				br.newLine();
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
