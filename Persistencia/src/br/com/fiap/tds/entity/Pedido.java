package br.com.fiap.tds.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


//sequenceName = nome da sequencia no banco de dados
//allocationSize = incremento
@Entity
@Table(name="TB_PEDIDO")
@SequenceGenerator(name="pedido", sequenceName="SQ_TN_PEDIDO", allocationSize = 1)
public class Pedido {
	
	@Id
	@Column(name="CD_PEDIDO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pedido")
	private int codigo;
	
	@Column(name="DS_PEDIDO", length = 60)
	private String descricao;
	
	@Temporal(TemporalType.TIMESTAMP) //Grava data e hora
	@Column(name="DT_PEDIDO", nullable = false, updatable = false)
	private Calendar data;
	
	@Column(name="NM_CLIENTE", nullable = false, length = 100)
	private String cliente;
	
	@Column(name="VL_PEDIDO")
	private double valor;
	
	@Transient //Não é mapeado na tabela do banco
	private int diasPedido;
	
	@Lob
	@Column(name = "FL_NOTA_FISCAL")
	private byte[] notafiscal;
	
	@Enumerated(EnumType.STRING) //grava o texto da constante
	@Column(name="ST_PAGAMENTO", nullable= false)
	private StatusPagamento statusPagamento;

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

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getDiasPedido() {
		return diasPedido;
	}

	public void setDiasPedido(int diasPedido) {
		this.diasPedido = diasPedido;
	}

	public byte[] getNotafiscal() {
		return notafiscal;
	}

	public void setNotafiscal(byte[] notafiscal) {
		this.notafiscal = notafiscal;
	}

	public StatusPagamento getStatusPagamento() {
		return statusPagamento;
	}

	public void setStatusPagamento(StatusPagamento statusPagamento) {
		this.statusPagamento = statusPagamento;
	}
	
	
}
