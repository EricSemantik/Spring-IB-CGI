package spring.formation.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import spring.formation.model.Client;
import spring.formation.model.Views;
import spring.formation.repo.IClientRepository;

@RestController
@RequestMapping("/api/client")
public class ClientRestController {
	@Autowired
	private IClientRepository clientRepository;

	@GetMapping("")
	@JsonView(Views.ViewClient.class)
	public List<Client> findAll() {
		return clientRepository.findAll();
	}
	
	@GetMapping("/{id}")
	@JsonView(Views.ViewClient.class)
	public Client findById(@PathVariable Long id) {
		Optional<Client> optPropduit = clientRepository.findById(id);
		
		if(optPropduit.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		return optPropduit.get();
	}
	
	@PostMapping("")
	@JsonView(Views.ViewClient.class)
	public Client create(@RequestBody Client client) {
		client =  clientRepository.save(client);
		
		return client;
	}
	
	@PutMapping("/{id}")
	@JsonView(Views.ViewClient.class)
	public Client update(@RequestBody Client client, @PathVariable Long id) {
		if(id != client.getId() || !clientRepository.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		
		client =  clientRepository.save(client);
		
		return client;
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		if(!clientRepository.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		clientRepository.deleteById(id);
	}
}
