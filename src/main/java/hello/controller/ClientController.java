package hello.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import hello.dto.ClientDTO;
import hello.service.ClientService;

@Controller
@RequestMapping("/clients")
public class ClientController {

	@Autowired
	private ClientService clientService;

	@GetMapping
	public ResponseEntity<Object> getclientes() {
		List<ClientDTO> clientes = clientService.findClientes();
		return new ResponseEntity<>(clientes, HttpStatus.OK);
	}

	@PostMapping(value = "/Deletar")
	public ResponseEntity<Object> deletecliente(@RequestBody(required = true) ClientDTO cliente) {
		clientService.delete(cliente);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@PatchMapping(value = "/{id}")
	public ResponseEntity<Object> updateClient(@PathVariable(required = true, value = "id") Long id,
			@RequestBody(required = true) ClientDTO client) {	
		ClientDTO savedcliente = clientService.update(client, id);
		return new ResponseEntity<>(savedcliente, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Object> savecliente(@RequestBody(required = true) ClientDTO cliente) {
		ClientDTO savedcliente = clientService.save(cliente);
		return new ResponseEntity<>(savedcliente, HttpStatus.OK);
	}

}
