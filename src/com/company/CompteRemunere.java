package com.company;

public class CompteRemunere extends Compte implements ICompteRemunere {
    private double taux = 0.3;

    public CompteRemunere() {
    }

    public CompteRemunere(double solde, int numero,  double taux) {
        super(solde, numero);
        this.taux = taux;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }

    /**
     * Permet de calculer les intérets du compte
     * @return double
     */
    public double calculerInterets() {
        return this.taux * this.getSolde();
    }

    /**
     * Verser les intérets au client
     */
    public void verserInterets(){
        this.setSolde(calculerInterets() + this.getSolde());
    }

    @Override
    public String toString() {
        return "CompteRemunere: cpt num " + this.getNumero() + ", solde " + this.getSolde() +
                ", taux=" + taux +
                "\n";
    }
}
