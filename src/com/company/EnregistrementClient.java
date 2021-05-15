package com.company;

public interface EnregistrementClient {
    default void EnregisterClient(Client client){
        ClientWriter.writeUser(client);
    }
}
