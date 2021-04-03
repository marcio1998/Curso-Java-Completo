package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Circle;
import entities.Rectangle;
import entities.Shape;
import entities.enums.Color;

public class Program3 {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Shape>list = new ArrayList<>();
		System.out.print("Enter the number of shapes: ");
		int n = sc.nextInt();
		for(int i = 1; i<=n; i++) {
			System.out.println("Shape #" + i + " Data:");
			System.out.print("Rectangle or Circle (r / c): ");
			char ch = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Color: (BLACK/ BLUE/ RED): ");
			Color color = Color.valueOf(sc.next());
			if(ch == 'r') {
				System.out.print("Width: ");
				Double width = sc.nextDouble();
				System.out.print("Height: ");
				Double height = sc.nextDouble();
				Rectangle rec = new Rectangle(color, width, height);
				list.add(rec);
			}else {
				System.out.print("Radius: ");
				Double radius = sc.nextDouble();
				Circle circ = new Circle(color, radius);
				list.add(circ);
			}
		}
		for(Shape sp : list) {
			System.out.println("Area: " + String.format("%.2f", sp.area()));
		}
		sc.close();

	}

}
