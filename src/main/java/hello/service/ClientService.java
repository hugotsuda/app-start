package hello.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hello.dto.ClientDTO;
import hello.entity.ClientEntity;
import hello.mapper.MapperClient;
import hello.repository.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private MapperClient mapperCliente;
	
	public ClientDTO findById(Long modelId) {
		return mapperCliente.convertToModel(findByIdReturnEntity(modelId));
	}
	private ClientEntity findByIdReturnEntity(Long modelId) {
	    Optional<ClientEntity> optionalSavedEntity = clientRepository.findById(modelId);
	    if (!optionalSavedEntity.isPresent()) {
	      return null;
	    }
	    return optionalSavedEntity.get();
	  }

	public List<ClientDTO> findClientes() {

		List<ClientEntity> entities = (List<ClientEntity>) clientRepository.findAll();
		return mapperCliente.converterToModelList(entities);
	}

	public ClientDTO save(ClientDTO model) {
		ClientEntity savedEntity = mapperCliente.convertToEntity(model);
		savedEntity = clientRepository.save(savedEntity);
		return mapperCliente.convertToModel(savedEntity);
	}

	public void delete(ClientDTO model) {
		ClientEntity deletedEntity = mapperCliente.convertToEntity(model);
		clientRepository.delete(deletedEntity);
	}


	public ClientDTO update(ClientDTO model, Long id) {		
		ClientDTO client = findById(id);		

		client.setNome_cli(model.getNome_cli());
		client.setRg_cli(model.getRg_cli());
		client.setCpf_cli(model.getCpf_cli());
		client.setPai_cli(model.getPai_cli());
		client.setMae_cli(model.getMae_cli());
		client.setCidade_nasc(model.getCidade_nasc());
		client.setData_nasc(model.getData_nasc());
		client.setData_cad(model.getData_cad());
		
		ClientEntity savedEntity = mapperCliente.convertToEntity(client);
		savedEntity = clientRepository.save(savedEntity);
		return mapperCliente.convertToModel(savedEntity);

	}
  

}
