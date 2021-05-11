package com.company;

public class Compte {
    private double solde;
    private int numero;
    private Client client;

    public Compte() {
    }

    public Client getClient() {
        return client;
    }

    public Compte(double solde, int numero) {
        this.solde = solde;
        this.numero = numero;
        this.client =this.getClient();
    }

    public double getSolde() {
        return solde;
    }

    protected void setSolde(double solde) {
        this.solde = solde;
    }

    public int getNumero() {
        return numero;
    }

    private void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Permet d'ajouter un montant à mon solde de compte
     * @param unMontant double
     */
    public void ajouter(double unMontant) {
        this.setSolde(this.getSolde() + unMontant);
    }

    /**
     * Permet de retirer un montant à mon solde de compte
     * @param unMontant double
     */
    public void retirer(double unMontant) throws BanqueException {
        this.setSolde(this.getSolde() - unMontant);
    }

    @Override
    public String toString() {
        return "Compte : \n" +
                "cpt num " + numero +
                ", solde:" + solde +
                "\n";
    }
}
