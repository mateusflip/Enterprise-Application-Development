package br.com.fiap.persistence;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TB_FILME")
public class Filmes {
	
	@Id
	@Column(name ="CD_FILME")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="filme")
	private int codigo;
	
	@Column(name="NM_FILME", length=60, nullable=false)
	private String nome;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DT_LANCAMENTO")
	private Calendar lancamento;
	
	@Enumerated(EnumType.STRING)
	@Column(name="DS_GENERO", length=40)
	private Genero genero;
	
	@Column(name="DS_SINOPSE", length=255)
	private String sinopse;
	
	@Column(name="ST_PREMIADO")
	private boolean premiado;
	
	@CreationTimeStamp //Insere a data de cadastro automaticamente
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DT_CADASTRO", updatable=false)
	private Calendar dataCadastro;

	public Filmes() {}
	
	
	public Filmes(String nome, Calendar lancamento, Genero genero, String sinopse, boolean premiado) {
		super();
		this.nome = nome;
		this.lancamento = lancamento;
		this.genero = genero;
		this.sinopse = sinopse;
		this.premiado = premiado;
	}

	//CTRL + 3 = gcuf
	public Filmes(int codigo, String nome, Calendar lancamento, Genero genero, String sinopse, boolean premiado) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.lancamento = lancamento;
		this.genero = genero;
		this.sinopse = sinopse;
		this.premiado = premiado;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getLancamento() {
		return lancamento;
	}

	public void setLancamento(Calendar lancamento) {
		this.lancamento = lancamento;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public boolean isPremiado() {
		return premiado;
	}

	public void setPremiado(boolean premiado) {
		this.premiado = premiado;
	}

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	

}
