package com.company;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CompteWriter {
    /**
     * Ecriture de l'ajout d'un compte dans le fichier client correspondant
     *
     * @param client
     * @param compte
     */
    public static void writeUserCompte(Compte compte,Client client) {

        BufferedWriter writer = null;
        int nomFichier = compte.getNumero();

        try {
            writer = new BufferedWriter(new FileWriter("sauvegarde/comptes/cpt" + nomFichier + ".txt"));
            writer.write(compte.toString());
            writer.newLine();
            System.out.println("Enregistrment du "+ compte.toString());


        } catch (IOException e) {
            e.getMessage();
        } finally
        {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.getMessage();
                }
            }
        }
    }
}
