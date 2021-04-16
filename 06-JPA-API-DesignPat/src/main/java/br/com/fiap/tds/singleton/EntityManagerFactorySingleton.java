package br.com.fiap.tds.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactorySingleton {
	//1 - Atributo est�tico que armazena a �nica inst�ncia
	private static EntityManagerFactory fabrica;
	
	//2 - M�todo est�tico que cria e retorna a �nica inst�ncia
	public static EntityManagerFactory getInstance() {
		
		if(fabrica == null) {
			fabrica = Persistence.createEntityManagerFactory("oracle");
		}
		
		return fabrica;
	}
	
	//3 - Construtor Privado -> N�o � possivel instanciar o Singleton
	private EntityManagerFactorySingleton() {}
}
