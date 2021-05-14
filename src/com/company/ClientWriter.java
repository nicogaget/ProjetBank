package com.company;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ClientWriter {
    /**
     * Ajoute un client à un fichier client client.txt
     *
     * @param client
     */
    public static void writeUser(Client client) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("sauvegarde/client.txt",true));
            writer.write(
                    client.getNumeroClient() + ","
                            + client.getNom() + ","
                            + client.getPrenom() + ","
                            + client.getAge());

            writer.newLine();

            System.out.println("ecriture du client");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
