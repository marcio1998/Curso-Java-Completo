package application2;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException2;

public class Program2 {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		try {
		System.out.println("Enter Account Data");
		System.out.print("Number: ");
		Integer number = sc.nextInt();
		System.out.print("Holder: ");
		String holder = sc.next();
		sc.nextLine();
		System.out.print("Intial Balance: ");
		double balance = sc.nextDouble();
		System.out.print("Withdraw Limit: ");
		double withdrawLimit = sc.nextDouble();
		Account account = new Account(number, holder, balance, withdrawLimit);
		System.out.println();
		System.out.print("enter Amount for Withdraw: ");
		double amountWithdraw = sc.nextDouble();
		account.withdraw(amountWithdraw);
		}catch(DomainException2 e) {
			System.out.println("withdraw error: " + e.getMessage());
		}
		sc.close();

	}

}
