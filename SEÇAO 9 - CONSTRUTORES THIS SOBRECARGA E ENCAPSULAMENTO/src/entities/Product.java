package entities;

public class Product {

	//Encapsulamento
	private String name;
	private double price;
	private int quantity;
	
	public Product() {
		super();
	}
	
	
	//Construtor, é executado na instaciação da classe.
	public Product(String name, double price) {
		this.name = name;
		this.price = price;
	}
	
	
	//metodos para acesso de de variáveis do tipo private. 
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


	public int getQuantity() {
		return quantity;
	}


	public String toString() {
		return name + ", $ " + String.format("%.2f", price) + ", " + quantity + " units, Total: $ ";
	}
}
