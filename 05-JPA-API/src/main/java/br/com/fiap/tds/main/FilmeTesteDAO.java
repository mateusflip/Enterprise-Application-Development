package br.com.fiap.tds.main;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.persistence.Filmes;
import br.com.fiap.persistence.Genero;
import br.com.fiap.tds.dao.FilmeDao;
import br.com.fiap.tds.dao.exception.CommitException;
import br.com.fiap.tds.dao.exception.FilmeNotFoundException;
import br.com.fiap.tds.dao.implementacao.FilmeDaoImplementacao;

public class FilmeTesteDAO {

	public static void main(String[] args) {
		// Obter o Entity Manager
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();
		
		//Obter o filmeDao
		FilmeDao dao = new FilmeDaoImplementacao(em);
		//Cadastrar
		Filmes filme = new Filmes("Senhor dos aneis", new GregorianCalendar(2000, Calendar.FEBRUARY, 23), Genero.ACAO, "filme legalzao",false);
		try {
			dao.create(filme);
			dao.commit();
			System.out.println("Filme Cadastrado");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		//Pesquisar e exibir os dados
		
		try {
			filme = dao.findByid(1);
			System.out.println(filme.getNome());
		}catch(FilmeNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		//Atualizar
		filme = new Filmes(2, "Mulher Maravilha", Calendar.getInstance(), Genero.ACAO, "Super mulher", false);
		try {
			dao.update(filme);
			dao.commit();
			System.out.println("Filme Atualizado");
		}catch(CommitException e) {
			System.out.println(e.getMessage());
		}
		//Remover
		try {
			dao.remove(1952);
			dao.commit();
			System.out.println("Filme Removido");
		}catch(FilmeNotFoundException | CommitException e) {
			System.out.println(e.getMessage());
		}
		
		
		//Fechar
		em.close();
		fabrica.close();
	}

}
