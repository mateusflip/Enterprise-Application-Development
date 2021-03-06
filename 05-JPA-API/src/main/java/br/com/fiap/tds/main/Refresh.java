package br.com.fiap.tds.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.persistence.Filmes;

public class Refresh {

	public static void main(String[] args) {
		// Obter F?brica e o entity manager
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();
		
		//Pesquisar o filme de c?digo 1
		Filmes filme = em.find(Filmes.class, 1);
		
		//Exibir o nome do filme
		System.out.println(filme.getNome());
		
		//Alterar o nome do filme no objeto(setNome)
		filme.setNome("Liga da Justi?a");
		
		//Exibir o nome do filme
		System.out.println(filme.getNome());
		
		//Refresh
		em.refresh(filme);
		
		//Exibir o nome do filme
		System.out.println(filme.getNome());
		
		//Fechar
		em.close();
		fabrica.close();
	}

}
