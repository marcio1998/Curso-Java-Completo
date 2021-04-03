package exerciseApplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import exercisesEntities.ImportedProduct;
import exercisesEntities.Product;
import exercisesEntities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		List<Product>list = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat();
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		for(int i=1; i<=n; i++) {
			System.out.println("Product #" + i + " data: ");
			System.out.print("Commom, used or import (c/u/i)? ");
			char ch = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Price: ");
			Double price = sc.nextDouble();
			if(ch == 'i') {
				System.out.print("Customs fee: ");
				Double customsFee = sc.nextDouble();
				Product pd = new ImportedProduct(name, price, customsFee);
				list.add(pd);
			}else if(ch == 'u') {
				System.out.print("Manufacture Date (dd/MM/yyyy): ");
				String manufactureDate = sc.next();
				Date date = sdf.parse(manufactureDate);
				System.out.println(date);
				Product pd = new UsedProduct(name, price, date);
				list.add(pd);
				
			}else {
				Product pd = new Product(name, price);
				list.add(pd);
			}
		}
		for(Product pd: list) {
			System.out.println(pd.priceTag());
		}
		
		sc.close();

	}

}
