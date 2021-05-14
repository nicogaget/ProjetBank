package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CompteReader {

    /**
     *
     * @param nomFichier
     * @return
     * @throws IOException
     */
    static List<String> readCompte(int numeroCompte) throws IOException {
        BufferedReader reader = null;
        List<String> resultats = new ArrayList<>();

        try {
            reader = new BufferedReader(new FileReader("sauvegarde/comptes/cpt"+numeroCompte+".txt"));
            String ligne = null;
            while ((ligne = reader.readLine()) != null) {
                System.out.println(ligne);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return resultats;
    }
}
