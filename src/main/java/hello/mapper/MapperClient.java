package hello.mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import hello.dto.ClientDTO;
import hello.entity.ClientEntity;
import lombok.NonNull;

@Component
public class MapperClient {

	private ModelMapper modelMapper = new ModelMapper();

	public List<ClientDTO> converterToModelList(@NonNull List<ClientEntity> origins) {
		List<ClientDTO> result = new ArrayList<>();
		for (ClientEntity entity : origins) {
			result.add(convertToModel(entity));
		}
		return result;
	}

	public ClientDTO convertToModel(ClientEntity entity) {

		return modelMapper.map(entity, ClientDTO.class);
	}

	public ClientEntity convertToEntity(ClientDTO model) {

		return modelMapper.map(model, ClientEntity.class);
	}

}