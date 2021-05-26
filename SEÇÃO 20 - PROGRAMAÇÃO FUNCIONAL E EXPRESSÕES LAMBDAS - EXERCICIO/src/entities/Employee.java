package entities;

public class Employee {
	String name;
	String email;
	double salaray;
	
	public Employee() {
		
	}

	public Employee(String name, String email, double salaray) {
		super();
		this.name = name;
		this.email = email;
		this.salaray = salaray;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getSalaray() {
		return salaray;
	}

	public void setSalaray(double salaray) {
		this.salaray = salaray;
	}
	
	
}
