package com.company;


import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Bank bank = new Bank();

//        List<Client> clients = ClientDao.getClients();
//        System.out.println(clients);
        Client client;
        bank.ajouterClient(client =new Client("Fissot", "Antoine", 35, 32253524));
        bank.ajouterClient(client =new Client("Gaget", "Nico", 35, 53524));

        List<Compte>Comptes = CompteDao.getComptesClient(1);
        System.out.println(Comptes);

        Compte c1 = new CompteASeuil(100, 1);
        Compte c2 = new CompteRemunere(200,2,0.5);
        CompteASeuilRemunere c3 = new CompteASeuilRemunere(455, 3, 0.2, 10);
        CompteRemunere c4 = new CompteRemunere(400,4,0.2);

        try {
            client.ajouterUnCompte(c1);
        } catch (BanqueException e) {
            System.out.println(e.getMessage());
        }
        try {
            client.ajouterUnCompte(c2);
        } catch (BanqueException e) {
            System.out.println(e.getMessage());
        }
        try {
            client.ajouterUnCompte(c3);
        } catch (BanqueException e) {
            System.out.println(e.getMessage());
        }


        try {
            System.out.println("test1");
            System.out.println(CompteReader.readCompte(1));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            System.out.println(ClientReader.readFichier("client"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
