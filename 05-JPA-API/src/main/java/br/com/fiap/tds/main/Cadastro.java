package br.com.fiap.tds.main;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.persistence.Filmes;
import br.com.fiap.persistence.Genero;

public class Cadastro {

	public static void main(String[] args) {
		//Obter uma fabrica e um entity manager
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();
		
		//Instanciar um filme sem o código (Estado novo - não gerenciado)
		Filmes filme = new Filmes("TENET",new GregorianCalendar(2021, Calendar.MARCH,9), Genero.ACAO,"Um filme bom", false);
		
		//Passa o filme paa o entity manager gerenciar
		em.persist(filme);
		
		//Começar uma transação
		em.getTransaction().begin();
		//Commit
		em.getTransaction().commit();
		
		System.out.println("Filme Cadastrado!");
		//Fechar
		em.close();
		fabrica.close();
	}

}
