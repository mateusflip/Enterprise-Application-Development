package br.com.fiap.tds.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.persistence.Filmes;
import br.com.fiap.persistence.Genero;

public class Pesquisa {

	public static void main(String[] args) {
		// Obter fabrica e o entity manager
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();
		
		//Pesquisar o filme de c�digo 1
		Filmes filme = em.find(Filmes.class,1);
		
		
		//Exibir o nome do filme
		if(filme != null) {
			System.out.println(filme.getNome());
		}else {
			System.out.println("Filme n�o encontrado");
		}
		
		filme.setGenero(Genero.DOCUMENTARIO);
		
		//S� usamos em caso de update e insert
		//em.getTransaction().begin();
		//em.getTransaction().commit();
		//fechar
		em.close();
		fabrica.close();

	}

}
