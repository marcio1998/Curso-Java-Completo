package entities;

public class Product {
	private String name;
	private double price;

	public Product() {

	}

	public Product(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	/*
	 * public static boolean staticProductPredicate(Product p) { return p.getPrice()
	 * >= 100; }
	 */
	
	

	/*public boolean nonStaticProductPredicate() {
		return price >= 100;
	}*/
	
	/*public static void priceUpdate(Product p) {
		p.setPrice(p.getPrice() * 1.1);
	}*/
	/*public  void nonStaticpriceUpdate() {
		price = price * 1.1;
	}*/
	
	/*public static String staticUpperCaseName(Product p ) {
		return p.getName().toUpperCase();
	}*/
	
	/*public String nonStaticUpperCaseName() {
		return name.toUpperCase();
	}*/

	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + String.format("%.2f", price) + "]";
	}

}
