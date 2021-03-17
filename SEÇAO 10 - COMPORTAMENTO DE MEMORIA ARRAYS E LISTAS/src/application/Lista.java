package application;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lista {
	public static void main(String args[]) {
		//<tipo da lista> / declara��o da lista. = instanciar.
		List<String> list = new ArrayList<>();
		
		//adicionar elementos na lista.
		list.add("Maria");
		list.add("Alex");
		list.add("Bob");
		list.add("Anna");
		//adicionar por posi��o - index da lista come�a em 0
		list.add(2,"Marco");
		//imprimir lista
		for(String x : list) {
			System.out.println(x);
		}
		System.out.println("Tamanho da lista: " + list.size());
		
		System.out.println("---------------------------------");
		//remover
		//list.remove("Anna");
		//remover por posi��o
		//list.remove(1);
		//remover por predicado. Remove todos que a primeira letra come�a com M
		//list.removeIf(x -> x.charAt(0) == 'M');
		//imprimir lista
		//for(String x : list) {
			//System.out.println(x);
		//}
		
		System.out.println("---------------------------------");
		//imprimindo o index da lista
		System.out.println("Index of Bob: " + list.indexOf("Bob"));
		
		
		System.out.println("---------------------------------");
		//filtar a lista como todos que come�am com a. stram, aceita opera��es com express�o lambda
		List<String> result = list.stream().filter(x -> x.charAt(0)== 'A').collect(Collectors.toList());
		//collect converte devolta para lista, pois o stream n�o � uma lista;
		for(String x : result) {
			System.out.println(x);
		}
		
		System.out.println("---------------------------------");
		//findFirst pega o primeiro elemente. orElse, se n�o existir retirna null
		String name = list.stream().filter(x -> x.charAt(0) == 'J').findFirst().orElse(null);
		System.out.println(name);
		
	}
}
