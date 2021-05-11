package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ClientReader {
    static List<String> readFichier(String nomFichier) throws IOException {
        BufferedReader reader = null;
        List<String> resultats = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader("src/com/sauvegarde/" + nomFichier + ".txt"));
            String ligne = null;
            while ((ligne = reader.readLine()) != null) {
                resultats.add(ligne);
            }
        } catch (IOException e) {
            System.err.println("erreur de lecture: " + e.getMessage());
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
