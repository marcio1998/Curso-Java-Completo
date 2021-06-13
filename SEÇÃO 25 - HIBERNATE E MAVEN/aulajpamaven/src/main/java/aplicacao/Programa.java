package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
		//Pessoa p1 = new Pessoa(null, "Carlos da Silva", "Carlos@gmail.com");
		//Pessoa p2 = new Pessoa(null, "Josquim Torres", "joaquim@gmail.com");
		//Pessoa p3 = new Pessoa(null, "Ana Maria", "ana@gmail.com");
		
		//instanciando o EntityManagerFactory, que traz a conexão do banco de dados e toda persistência.
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();//inicio
		//em.persist(p1); //salvar no banco de dados
		//em.persist(p2); //salvar no banco de dados
		//em.persist(p3); //salvar no banco de dados
		
		System.out.println("Pronto");

		
		//Pessoa p = em.find(Pessoa.class, 2);
		//System.out.println(p);
		Pessoa p = em.find(Pessoa.class, 2);
		em.remove(p);
		em.getTransaction().commit();//fim
		em.close();
		emf.close();


	}

}
