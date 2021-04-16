package br.com.fiap.tds.dao.exception;

public class CommitException extends Exception {
	
	public CommitException() {
		super("Erro ao realizar commit");
	}
	public CommitException(String msg) {
		super(msg);
	}
}
