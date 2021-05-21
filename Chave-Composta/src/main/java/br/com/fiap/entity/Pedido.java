package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_PEDIDO")
@SequenceGenerator(name="pedido", sequenceName="SQ_TB_PEDIDO", allocationSize= 1)
public class Pedido {

	@Id
	private int codigo;
	
	private String descricao;
	
	private Calendar data;
	
	public Pedido() {}

	
	
	public Pedido(String descricao, Calendar data) {
		super();
		this.descricao = descricao;
		this.data = data;
	}



	public Pedido(int codigo, String descricao, Calendar data) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.data = data;
	}



	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}
	
	
	
}
