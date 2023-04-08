package com.example.Ins.mgmnt.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Ins.mgmnt.entities.Client;
import com.example.Ins.mgmnt.repository.ClientRepository;



@RestController
@RequestMapping("/api/clients")
public class ClientController {
	
	@Autowired
	private ClientRepository clientRepository;
	
	@GetMapping
	public List<Client>getAllClients(){
		return clientRepository.findAll();
	}
	
	@GetMapping("/{client_id}")
	public ResponseEntity<Client>getClientById(@PathVariable int client_id)
	{
		Optional<Client>optionalClient=clientRepository.findById(client_id);
		if(optionalClient.isPresent()) {
			return 
					ResponseEntity.ok(optionalClient.get());
		}
		else {
			return
					ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	public Client createClient(@RequestBody Client client) {
		return
				clientRepository.save(client);
	}
	
	@PutMapping("/{client_id}")
	public ResponseEntity<Client>updateClient(@PathVariable int client_id,@RequestBody Client client){
		Optional<Client>optionalClient=clientRepository.findById(client_id);
		if(optionalClient.isPresent()) {
			client.setClient_id(client_id);
			return
					ResponseEntity.ok(clientRepository.save(client));
		}else {
			return
					ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{client_id}")
	public ResponseEntity<Client>deleteClient(@PathVariable int client_id){
		Optional<Client>optionalClient=clientRepository.findById(client_id);
		if(optionalClient.isPresent()) {
			clientRepository.deleteById(client_id);
			return
					ResponseEntity.noContent().build();
		}else {
			return
					ResponseEntity.notFound().build();
		}
	}

}
