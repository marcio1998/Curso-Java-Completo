package application;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import entities.Product;

public class PredicateExample {

	public static void main(String[] args) {
		List<Product> list = new ArrayList<>();
		list.add(new Product("TV", 900.00));
		list.add(new Product("Notebook", 1200.00));
		list.add(new Product("Tablet", 450.00));
		list.add(new Product("Mouse", 50.00));
		list.add(new Product("HD Case", 80.90));
		double min = 100.00;
		Predicate<Product> pred = p -> p.getPrice() >= min; 
		//list.removeIf(p -> p.getPrice() >= 100);
		//list.removeIf(new ProductPredicate());
		//list.removeIf(Product::staticProductPredicate); 
		//list.removeIf(Product::nonStaticProductPredicate); 
		list.removeIf(pred); 
		for(Product p : list) {
			System.out.println(p);
		}
	}

}
