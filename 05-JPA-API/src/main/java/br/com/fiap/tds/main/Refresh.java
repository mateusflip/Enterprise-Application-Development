package br.com.fiap.tds.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Refresh {

	public static void main(String[] args) {
		// Obter F�brica e o entity manager
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();
		//Pesquisar o filme de c�digo 1
		
		//Alterar o nome do filme no objeto(setNome)
		
		//Exibir o nome do filme
		
		//Refresh
		
		//Exibir o nome do filme
		
		//Fechar

	}

}
