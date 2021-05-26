package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Employee;

public class Program {
	public static void main(String [] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		String path = "C:\\Users\\Gabriel\\Desktop\\CURSOS\\CURSOS UDEMY\\Java Completo\\SEÇÃO 20 - PROGRAMAÇÃO FUNCIONAL E EXPRESSÕES LAMBDAS - EXERCICIO\\in.txt";
		
		List<Employee> list = new ArrayList<>();
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			String line = br.readLine();
			while( line != null) {
				String [] fields = line.split(",");
				list.add(new Employee(fields[0], fields[1], Double.parseDouble(fields[2])));
				line = br.readLine();
			}
		System.out.print("Enter Salary: ");
		double salary = sc.nextDouble();
		System.out.println("Email of people salary is more than " + salary);
		List<String> emails = list.stream().filter(s -> s.getSalaray() >= salary).map(e -> e.getEmail()).sorted((e1, e2) -> e1.toUpperCase().compareTo(e2.toUpperCase())).collect(Collectors.toList());
		emails.forEach(System.out::println);
		double sum = list.stream().filter(e -> e.getName().toUpperCase().charAt(0) == 'M').map(e -> e.getSalaray()).reduce(0.0, (x,y) -> x + y);
		System.out.println("Sum of salary people whose name starts with 'M': " + String.format("%.2f", sum));
		}catch(IOException e) {
			System.out.println("ERROR: " + e.getMessage());
		}
		sc.close();
	}
}
