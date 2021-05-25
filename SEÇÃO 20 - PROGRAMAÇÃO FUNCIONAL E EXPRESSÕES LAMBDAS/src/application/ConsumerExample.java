package application;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import entities.Product;

public class ConsumerExample {

	public static void main(String[] args) {
		List<Product> list = new ArrayList<>();
		list.add(new Product("TV", 900.00));
		list.add(new Product("Notebook", 1200.00));
		list.add(new Product("Tablet", 450.00));
		list.add(new Product("Mouse", 50.00));
		list.add(new Product("HD Case", 80.90));
		Consumer<Product> cons = p -> {
			p.setPrice(p.getPrice() * 1.1);
		};
		//list.forEach(new PriceUpdate());
		//list.forEach(Product::priceUpdate);
		//list.forEach(Product::nonStaticpriceUpdate);
		//list.forEach(cons);
		list.forEach(p -> p.setPrice(p.getPrice() * 1.1));
		list.forEach(System.out::println);

	}

}
