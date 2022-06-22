package ec.com.edimca.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ec.com.edimca.model.Client;
import ec.com.edimca.service.ClientService;

@RestController
@RequestMapping("/client")
public class ClientController {

	@Autowired
	ClientService clientService;

	@PostMapping("/add")
	public ResponseEntity<?> addClient(@RequestBody Client client) {
		Map<String, Object> response = new HashMap<>();
		String message = "";
		try {
			if (client.getId() != null) {
				Optional<Client> optionalCliente = clientService.findById(client.getId());
				optionalCliente.get().setDni(client.getDni());
				optionalCliente.get().setLastName(client.getLastName());
				optionalCliente.get().setName(client.getName());
				message = "Update client";
				clientService.save(optionalCliente.get());
			} else {
				message = "Registered client";
				clientService.save(client);
			}
			clientService.save(client);
			response.put("status", "ok");
			response.put("Message", message);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.put("status", "Error");
			response.put("Message", "Error server");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteClient(@PathVariable("id") String id) {
		Map<String, Object> response = new HashMap<>();
		try {
			clientService.deleteById(Long.valueOf(id));
			response.put("status", "ok");
			response.put("Message", "Client deleted");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.put("status", "Error");
			response.put("Message", "Error server");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<?> listClients() {
		Map<String, Object> response = new HashMap<>();
		List<Client> listClients = new ArrayList<>();
		try {
			listClients = clientService.findAll();
			return ResponseEntity.status(HttpStatus.OK).body(listClients);
		} catch (Exception e) {
			response.put("status", "Error");
			response.put("Message", "Error server");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
