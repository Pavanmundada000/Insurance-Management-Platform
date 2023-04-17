package com.insurance.management.platform.controller;

import com.insurance.management.platform.entity.Client;
import com.insurance.management.platform.helper.ApiResponse;
import com.insurance.management.platform.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    @Autowired
    public ClientService clientService;

    // create new client endpoint
    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody Client client){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.clientService.createClient(client));
    }

    // get client by id endpoint
    @GetMapping(value = "/{clientId}")
    public ResponseEntity<Client> getClientById(@PathVariable Long clientId){
        return ResponseEntity.status(200).body(this.clientService.getClientById(clientId));
    }

    @GetMapping
    public ResponseEntity<List<Client>> getAllClients(){
        return ResponseEntity.status(200).body(this.clientService.getAllClients());
    }

    @PutMapping("/{clientId}")
    public ResponseEntity<Client> updateClientById(@RequestBody Client client, @PathVariable Long clientId){
        return ResponseEntity.status(200).body(this.clientService.updateClientById(client,clientId));
    }

    @DeleteMapping("/{clientId}")
    public ResponseEntity<ApiResponse> deleteClientById(@PathVariable Long clientId){
        this.clientService.deleteClientById(clientId);
        return ResponseEntity.status(204).body(new ApiResponse("Client Deleted Successfully!!", true));
    }
}
