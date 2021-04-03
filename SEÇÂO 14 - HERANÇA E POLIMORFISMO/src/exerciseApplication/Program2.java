package exerciseApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import exercisesEntities.Pessoa;
import exercisesEntities.PessoaFisica;
import exercisesEntities.PessoaJuridica;

public class Program2 {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Pessoa>list = new ArrayList<>();
		System.out.print("Digite o Número de Pessoas que serão cadastradas: ");
		int n = sc.nextInt();
		for(int i = 1; i<=n; i++) {
			System.out.println("Cadastrar Pessoa #" + i + " :");
			char ch;
			do {
				System.out.print("Pessoa Física ou Pessoa Jurídica (f/j): ");
				ch = sc.next().charAt(0);
			}while(ch != 'f' && ch != 'j');
			sc.nextLine();
			System.out.print("Nome: ");
			String nome = sc.nextLine();
			System.out.print("Renda Anual: ");
			Double rendaAnual = sc.nextDouble();
			if(ch == 'f') {
				System.out.print("Despesas Com Saúde: ");
				Double gastosComSaude = sc.nextDouble();
				list.add(new PessoaFisica(nome, rendaAnual, gastosComSaude));
			}else {
				System.out.print("Número de Funcionários: ");
				int numeroFuncionarios = sc.nextInt();
				list.add(new PessoaJuridica(nome, rendaAnual, numeroFuncionarios));
			}
				
		}
		System.out.println("Impostos Pagos: ");
		double soma = 0;
		for(Pessoa pessoa: list) {
			System.out.println(pessoa.toString());
			soma += pessoa.calculoImposto();
		}
		System.out.println("Total de Impostos Pagos Fisica + Juridica: " + String.format("%.2f", soma));
		sc.close();

	}

}
