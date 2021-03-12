package util;

public class Calculator {
	//Membro Estático. final = constatne não pode mudar.
	public static final double PI = 3.14159;
	
	public static double circumference(double radius) {
		return 2*PI*radius;
	}
	
	//As funções são calculadas independentemente de objetos.
	public static double volume(double radius) {
		return (4*PI*radius*radius*radius)/3;
	}
}
