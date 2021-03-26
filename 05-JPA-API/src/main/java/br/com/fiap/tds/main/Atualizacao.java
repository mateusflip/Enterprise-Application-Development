package br.com.fiap.tds.main;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.persistence.Filmes;
import br.com.fiap.persistence.Genero;

public class Atualizacao {

	public static void main(String[] args) {
		// Obter a Fábrica e o entity Manager
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();
		
		//Instanciar um filme com um código (Estado deteched - não gerenciado)
		Filmes filme = new Filmes(1,"Climax", 
				new GregorianCalendar(2019, Calendar.JANUARY,15),
				Genero.DRAMA, "Um filme de Gaspar Noé", true);
		
		//O merge cria um novo objeto, caso queira manipular devemos usar o objeto que o merge criou
		em.merge(filme);
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		System.out.println("Filme " + filme.getNome() + " Atualizado");
		
		//Fechar
		em.close();
		fabrica.close();
		
	}

}
