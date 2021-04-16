package br.com.fiap.tds.dao.implementacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.persistence.Filmes;
import br.com.fiap.tds.dao.FilmeDao;
import br.com.fiap.tds.dao.exception.CommitException;
import br.com.fiap.tds.dao.exception.FilmeNotFoundException;

public class FilmeDaoImplementacao implements FilmeDao{
	private EntityManager em;
	
	
	public FilmeDaoImplementacao(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public void create(Filmes filme){
		em.persist(filme);
	}
	
	@Override
	public Filmes findByid(int id) throws FilmeNotFoundException {
		Filmes filme = em.find(Filmes.class, id);
		if(filme == null)
			throw new FilmeNotFoundException();
		return filme;
	}
	
	@Override
	public void update(Filmes filme){
		em.merge(filme);	
	}
	
	
	
	@Override
	public void remove(int id) throws FilmeNotFoundException{
		Filmes filme = findByid(id);
		em.remove(id);
	}
	
	@Override
	public void commit() throws CommitException{
		try {em.getTransaction().begin();
		em.getTransaction().commit();
	}catch(Exception e) {
		em.getTransaction().rollback();
		e.printStackTrace();
		throw new CommitException();
	}
			
		}

}
