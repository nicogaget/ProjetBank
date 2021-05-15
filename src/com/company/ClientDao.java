package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClientDao {

    public static List<Client> getClients(){

        List<Client> clients = new ArrayList<>();

        Connection co =null;
        Statement stm = null;
        ResultSet rs=null;
        String query = "SELECT * FROM projetBank.client;";
        try {
            co = DriverManager.getConnection("jdbc:mysql://localhost/projetBank", "root", "mdp");
            stm = co.createStatement();
            stm.execute(query);
            rs=stm.getResultSet();

            while (rs.next()){
                //int clientId = rs.getInt("client_id");
                int clientNum = rs.getInt("numero_client");
                String nom= rs.getString("nom");
                String prenom = rs.getString("prenom");
                int age = rs.getInt("age");
                Client c = new Client(nom,prenom, age, clientNum);
                clients.add(c);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if (co != null) {
                try {
                    co.close();
                } catch (SQLException e) {
                    co = null;
                }
            }
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException e) {
                    stm = null;
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    rs = null;
                }
            }
        }
        return clients;
    }
}
