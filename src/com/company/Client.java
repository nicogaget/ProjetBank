package com.company;

import java.util.*;

public class Client {

    private String nom;
    private String prenom;
    private int age;
    private int numeroClient;
    private Map<Integer,Compte> comptes = new Hashtable<>();

    public Client() {
    }

    public void setComptes(Map<Integer, Compte> comptes) {
        this.comptes = comptes;
    }

    public Client(String nom, String prenom, int age, int numeroClient) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.numeroClient = numeroClient;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNumeroClient() {
        return numeroClient;
    }

    private void setNumeroClient(int numeroClient) {
        this.numeroClient = numeroClient;
    }

    public Compte[] getComptes() {
        return comptes.values().toArray(new Compte[5]);
    }

    /**
     * Permet d'ajouter un compte à notre client
     * @param compte Compte
     */
    public void ajouterUnCompte(Compte compte) throws BanqueException {
        CompteWriter.writeUserCompte(compte, compte.getClient());
    }

    /**
     * Retourne un compte appartenant à notre client
     * @param numeroCompte int
     * @return Compte
     */
    public Compte getCompte(int numeroCompte) {
        Compte compte = null;
        boolean find = false;
        for (int i = 0; i < this.getComptes().length; i++) {
            if (numeroCompte == this.getComptes()[i].getNumero()) {
                compte = this.getComptes()[i];
                find = true;
                break;
            }
        }
        if (!find) {
            System.out.println("Le compte n°" + numeroCompte + " n'existe pas.");
        }
        return compte;
    }

    @Override
    public String toString() {
        return "Client{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", age=" + age +
                ", numeroClient=" + numeroClient +
                ", comptes=" + comptes.values().toString() +
                '}';
    }
}
