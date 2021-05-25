package application;

import java.util.ArrayList;
import java.util.List;

import entities.Product;

public class Program2 {
	
	public static int compareProduct(Product p1, Product p2) {
		if(p1.getPrice() < p2.getPrice()) {
			return -1;
		}else if(p1.getPrice() > p2.getPrice()) {
			return 1;
		}else {
			return 0;
		}
	}
	
	public static void main(String[] args) {
		List<Product> list = new ArrayList<>();
		list.add(new Product("TV", 900.00));
		list.add(new Product("Notebook", 1200.00));
		list.add(new Product("Tablet", 450.00));

	
		list.sort(Program2::compareProduct);

		for (Product p : list) {
			System.out.println(p.toString());
		}
	}
}
