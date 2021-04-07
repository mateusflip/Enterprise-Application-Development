package exercicio1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_VEICULO")
public class Veiculo {
	
	@Id
	@Column(name="CD_VEICULO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="SQ_T_VEICULO")
	private int codigo;
	
	
	@Column(name="DS_PLACA", length= 9, nullable=false)
	private String placa;
	
	@Column(name = "")
	private String cor;

}
