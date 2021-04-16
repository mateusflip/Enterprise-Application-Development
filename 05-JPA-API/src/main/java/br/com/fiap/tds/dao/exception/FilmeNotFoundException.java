package br.com.fiap.tds.dao.exception;

public class FilmeNotFoundException extends Exception {
	
	
	public FilmeNotFoundException() {
		super("Filme n�o encontrado");
	}
	
	public FilmeNotFoundException(String msg) {
		super(msg);
	}
}
