package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Employee;

public class Exercicio2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("How Many employees will be registred? ");
		int n = sc.nextInt();
		List<Employee> list = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Salary: ");
			double salary = sc.nextDouble();
			Employee emplyoee = new Employee((i+1),name,salary);
			list.add(emplyoee);
		}
		
		for (Employee employee : list) {
			System.out.println(employee.toString());
		}
		System.out.println();
		System.out.print("Enter the employee id that will have salary increase: ");
		int id = sc.nextInt();
		Employee result = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		if(result == null) {
			System.out.println("This id does not exist");
			for (Employee employee : list) {
				System.out.println(employee.toString());
			}
		}else {
			System.out.print("Enter the percentage: ");
			double increase = sc.nextDouble();
			result.increaseSalary(increase);
			System.out.println(result.toString());
		}

		sc.close();
		
		
		
	}

}
