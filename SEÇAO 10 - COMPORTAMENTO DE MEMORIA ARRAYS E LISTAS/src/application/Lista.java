package application;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lista {
	public static void main(String args[]) {
		//<tipo da lista> / declaração da lista. = instanciar.
		List<String> list = new ArrayList<>();
		
		//adicionar elementos na lista.
		list.add("Maria");
		list.add("Alex");
		list.add("Bob");
		list.add("Anna");
		//adicionar por posição - index da lista começa em 0
		list.add(2,"Marco");
		//imprimir lista
		for(String x : list) {
			System.out.println(x);
		}
		System.out.println("Tamanho da lista: " + list.size());
		
		System.out.println("---------------------------------");
		//remover
		//list.remove("Anna");
		//remover por posição
		//list.remove(1);
		//remover por predicado. Remove todos que a primeira letra começa com M
		//list.removeIf(x -> x.charAt(0) == 'M');
		//imprimir lista
		//for(String x : list) {
			//System.out.println(x);
		//}
		
		System.out.println("---------------------------------");
		//imprimindo o index da lista
		System.out.println("Index of Bob: " + list.indexOf("Bob"));
		
		
		System.out.println("---------------------------------");
		//filtar a lista como todos que começam com a. stram, aceita operações com expressão lambda
		List<String> result = list.stream().filter(x -> x.charAt(0)== 'A').collect(Collectors.toList());
		//collect converte devolta para lista, pois o stream não é uma lista;
		for(String x : result) {
			System.out.println(x);
		}
		
		System.out.println("---------------------------------");
		//findFirst pega o primeiro elemente. orElse, se não existir retirna null
		String name = list.stream().filter(x -> x.charAt(0) == 'J').findFirst().orElse(null);
		System.out.println(name);
		
	}
}
