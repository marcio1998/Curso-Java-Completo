package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import entities.LogEntry;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String path = "C:\\Users\\Gabriel\\Desktop\\CURSOS\\Curso-Java-Completo\\SEÇÃO 19 - GENERICS - SET - MAP\\in.txt";
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			Set<LogEntry> set = new HashSet<>();
			String line = br.readLine();
			while(line != null ) {
				String [] fields = line.split(" ");
				String userName = fields[0];
				Date moment = Date.from(Instant.parse(fields[1]));
				set.add(new LogEntry(userName, moment));
				line = br.readLine();
				
			}
			System.out.println("Total Users: " + set.size());
		}catch(IOException e) {
			System.out.println("ERROR: " + e.getMessage());
		}
		sc.close();
	}

}
