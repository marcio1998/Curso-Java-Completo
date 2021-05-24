package application;

import java.util.Map;
import java.util.TreeMap;

public class maps {

	public static void main(String[] args) {
		Map<String, String> cookies = new TreeMap<>();
		//Operação Para enserir
		cookies.put("userName", "Maria");
		cookies.put("email", "maria@gmail.com");
		cookies.put("phone", "998563256");
		
		cookies.remove("email");
		System.out.println("Contain 'phone key: " + cookies.containsKey("phone"));
		System.out.println("Phone number: " + cookies.get("phone"));
		System.out.println("Email: " + cookies.get("email"));
		System.out.println("Size: " + cookies.size());
		System.out.println("All Cookies: ");
		for(String key : cookies.keySet()) {
			System.out.println(key + ": " + cookies.get(key));
		}

	}

}
