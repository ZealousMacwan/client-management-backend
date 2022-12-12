package com.example.ClientManagementBackend.controllers;

import com.example.ClientManagementBackend.datamodels.Client;
import com.example.ClientManagementBackend.repositories.ClientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/clients")
@CrossOrigin(origins = "${allowed-origin}", maxAge = 3600)
@Slf4j
public class ClientsController {
    private final ClientRepository clientRepository;

    public ClientsController(ClientRepository clientRepository){
        this.clientRepository=clientRepository;
    }

    @GetMapping
    public List<Client> getClients(){
        return clientRepository.findAll();
    }

    @GetMapping("/{id}")
    public Client getClient(@PathVariable Long id){
        return clientRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping
    public ResponseEntity createClient(@RequestBody Client client) throws URISyntaxException{
        Client savedClient = clientRepository.save(client);
        log.info("Client created");
        return ResponseEntity.created(new URI("/clients/"+ savedClient.getId())).body(savedClient);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateClient(@PathVariable Long id, @RequestBody Client client){
        Client currentClient = clientRepository.findById(id).orElseThrow(RuntimeException::new);
        currentClient.setName(client.getName());
        currentClient.setEmail(client.getEmail());
        currentClient = clientRepository.save(client);
        log.info("Client updated");
        return ResponseEntity.ok(currentClient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteClient(@PathVariable Long id){
        clientRepository.deleteById(id);
        log.info("Client deleted");
        return ResponseEntity.ok().build();
    }
}
