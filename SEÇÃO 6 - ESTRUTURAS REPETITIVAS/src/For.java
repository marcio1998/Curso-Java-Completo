import java.util.Scanner;

public class For {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int soma = 0;
		for(int i = 0; i<n; i++) {
			soma += i;
		}
		sc.close();
		System.out.println(soma);

	}

}
