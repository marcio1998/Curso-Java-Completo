package application;

import java.util.ArrayList;
import java.util.List;

import entities.Product;
import entities.product.ProductService;

public class Program3 {

	public static void main(String[] args) {
		List<Product> list = new ArrayList<>();
		list.add(new Product("TV", 900.00));
		list.add(new Product("Notebook", 1200.00));
		list.add(new Product("Tablet", 450.00));
		list.add(new Product("Mouse", 50.00));
		list.add(new Product("HD Case", 80.90));
		 ProductService ps = new ProductService();
		 
		 double sum = ps.filtredSum(list, p -> p.getName().charAt(0) == 'H');
		 System.out.println("Sum = " + String.format("%.2f", sum ));

	}

}
