package com.company;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompteDao {
    public static List<Compte> getComptesClient(int id) {
        List<Compte> comptes = new ArrayList<>();
        Connection co = null;
        Statement stm = null;
        ResultSet rs = null;
        String query = "SELECT * FROM projetBank.compte where compte.client=" + id;

        try {
            co = DriverManager.getConnection("jdbc:mysql://localhost/projetBank", "root", "mdp");
            stm = co.createStatement();
            stm.execute(query);
            rs = stm.getResultSet();
            ResultSetMetaData loRsmd = rs.getMetaData();
            int nbColonnes = loRsmd.getColumnCount();

            while (rs.next()){
               // double solde = rs.getDouble("solde");
                //int numero = rs.getInt("numero_client");
                //double taux = rs.getDouble("taux");
                //int seuil = rs.getInt("seuil");

                //Compte c = new Compte(solde,numero,seuil, taux);
                  //comptes.add(c);
                for (int i = 1; i <= nbColonnes ; i++) { //Maintenant on parcour chaque colonne du résultat
                    if (i > 1) System.out.print(",  ");
                    String laValeur= rs.getString(i); //Valeur de la colonne. Note : on peut lire dans d'autres types que du String
                    System.out.print(laValeur+ " " + loRsmd.getColumnName(i)); //Afficher du couple nom colonne et sa valeur
                }
                System.out.println("");

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    return comptes;
    }
}
