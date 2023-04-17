package com.insurance.management.platform.service;

import com.insurance.management.platform.entity.Client;

import java.util.List;

public interface ClientService {

    // create client
    Client createClient(Client client);

    // get client by id
    Client getClientById(Long clientId);

    // get all clients available in db
    List<Client> getAllClients();

    //update client by id
    Client updateClientById(Client client, Long clientId);

    // delete client by id
    void deleteClientById(Long clientId);



}
