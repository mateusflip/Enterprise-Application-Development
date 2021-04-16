package br.com.fiap.tds.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.persistence.Filmes;

public class Remocao {

	public static void main(String[] args) {
		//Obter um entity manager
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();
		//Pesquisar um filme
		Filmes filme = em.find(Filmes.class, 1);
		
		//Remover o filme
		em.remove(filme);
		
		//Commit
		em.getTransaction().begin();
		em.getTransaction().commit();
		//fechar
		em.close();
		fabrica.close();
		
	}

}
