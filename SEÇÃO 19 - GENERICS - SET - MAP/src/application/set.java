package application;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
//import Entities.Product;
import java.util.TreeSet;

public class set {
	public static void main(String[] args) {
		//hashset não garante a ordem.
		Set<String> set = new HashSet<>();
		set.add("TV");
		set.add("Notebook");
		set.add("Tablet");
		System.out.println(set.contains("Notebook"));
		for (String p : set) {
			System.out.println(p);
		}
		
		Set<String> set2 = new TreeSet<>();
		set2.add("TV");
		set2.add("Notebook");
		set2.add("Tablet");
		System.out.println(set.contains("Notebook"));
		for (String p : set) {
			System.out.println(p);
		}
		
		
		Set<String> set3 = new LinkedHashSet<>();
		set3.add("TV");
		set3.add("Notebook");
		set3.add("Tablet");
		System.out.println(set.contains("Notebook"));
		for (String p : set) {
			System.out.println(p);
		}
	}
}