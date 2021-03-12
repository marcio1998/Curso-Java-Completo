package entities;

public class Traiangle {
	//atributos.
	public double a;
	public double b;
	public double c;
	/*public indica que o atributo pode ser usado em outros arquibvos*/
	
	//meotodo.
	public double area(){
		double p = (a + b + c) / 2.0;
		return  Math.sqrt(p * (p - a) * (p - b) * (p - c));
	}
	
	
}
