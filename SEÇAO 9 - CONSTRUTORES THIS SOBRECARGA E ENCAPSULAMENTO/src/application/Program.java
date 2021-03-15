package application;

import java.util.Locale;
import java.util.Scanner;
import entities.Product;

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter product data: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Price: ");
		double price = sc.nextDouble();
	   //System.out.print("Quantity in stock: ");
		//int quantity = sc.nextInt();
		Product product = new Product(name, price);
		System.out.println();
		
		//Usando métodos get e set.
		product.setName("Computer");
		System.out.println("Updated Name: " +  product.getName());
		product.setPrice(1200.00);
		System.out.println("Updated Price: " + product.getPrice());
		
		
		System.out.println("Product data: " + product);
	
		sc.close();
	}
}
