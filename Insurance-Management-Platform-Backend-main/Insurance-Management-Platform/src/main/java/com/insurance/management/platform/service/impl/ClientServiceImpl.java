package com.insurance.management.platform.service.impl;

import com.insurance.management.platform.entity.Client;
import com.insurance.management.platform.repository.ClientRepository;
import com.insurance.management.platform.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client getClientById(Long clientId) {
        var client = clientRepository
                .findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client Not Found With Id " + clientId));
        return client;
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client updateClientById(Client client, Long clientId) {
        var existingClient = clientRepository.findById(clientId).orElseThrow(() -> new RuntimeException("Client Not Found With Id " + clientId));
        existingClient.setName(client.getName());
        existingClient.setDateOfBirth(client.getDateOfBirth());
        existingClient.setAddress(client.getAddress());
        existingClient.setPhone(client.getPhone());
        return clientRepository.save(existingClient);
    }

    @Override
    public void deleteClientById(Long clientId) {
        var client = clientRepository.findById(clientId).orElseThrow(() -> new RuntimeException("Client Not Found With Id " + clientId));
        clientRepository.delete(client);
    }
}
