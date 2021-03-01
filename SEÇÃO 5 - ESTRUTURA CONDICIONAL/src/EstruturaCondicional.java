import java.util.Scanner;

public class EstruturaCondicional {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int horas;
		horas = sc.nextInt();
		if(horas < 12) {
			System.out.println("Bom Dia!");
		}else if(horas >= 12 && horas <=18) {
			System.out.println("Boa Tarde!");
		}else {
			System.out.println("Boa Noite");
		}

	}

}
