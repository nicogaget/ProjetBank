package com.company;

import java.util.Hashtable;

import java.util.Map;

public class Bank {
    Map<Integer, Client> client= new Hashtable<>();

    public Bank() {
    }

    public Bank(Map<Integer, Client> client) {
        this.client = client;
    }

    public void ajouterClient(Client client){
        ClientWriter.writeUser(client);
    }


    public Map<Integer, Client> getClient() {
        return client;
    }

    public void setClient(Map<Integer, Client> client) {
        this.client = client;
    }
}
