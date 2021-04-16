package br.com.fiap.tds.dao;

import br.com.fiap.persistence.Filmes;
import br.com.fiap.tds.dao.exception.CommitException;
import br.com.fiap.tds.dao.exception.FilmeNotFoundException;


//Interface -> Diminui acoplamento entre objetos
public interface FilmeDao {
	//CRUD
	void create(Filmes filme);
	
	Filmes findByid(int id) throws FilmeNotFoundException;
	
	void update(Filmes filme);
	
	void remove(int id) throws FilmeNotFoundException;
	
	void commit() throws CommitException;
}
