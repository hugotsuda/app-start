package hello.entity;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "clientes")
public class ClientEntity {

	@Id
	@Basic
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_cli")
	private Long cod_cli;

	@Basic
	@Column(name = "nome_cli")
	private String nome_cli;

	@Basic
	@Column(name = "rg_cli")
	private String rg_cli;

	@Basic
	@Column(name = "cpf_cli")
	private String cpf_cli;

	@Basic
	@Column(name = "mae_cli")
	private String mae_cli;

	@Basic
	@Column(name = "pai_cli")
	private String pai_cli;

	@Basic
	@Column(name = "cidade_nasc")
	private String cidade_nasc;

	@Basic
	@Column(name = "data_nasc")
	private Date data_nasc;

	@Basic
	@Column(name = "data_cad")
	private Date data_cad;

}
