package hello.dto;
import java.util.Date;

import lombok.Data; 

@Data  
public class ClientDTO {
	 
 
	   private Long cod_cli; 
	  
	   private String nome_cli;
	   
	   private String mae_cli;
	   
	   private String pai_cli;
	   
	   private String rg_cli;

	   private String cpf_cli; 
	   
	   private String cidade_nasc;	
	   
	   private Date data_nasc;
	   
	   private Date data_cad;
	   
	
}
