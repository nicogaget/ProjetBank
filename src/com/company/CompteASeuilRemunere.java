package com.company;

public class CompteASeuilRemunere extends CompteRemunere implements ICompteASeuil {

    private double seuil;

    public CompteASeuilRemunere() {
    }

    public CompteASeuilRemunere(double seuil) {
        this.seuil = seuil;
    }

    public CompteASeuilRemunere(double solde, int numero, double taux) {
        super(solde, numero, taux);
    }

    public CompteASeuilRemunere(double solde, int numero, double taux, double seuil) {
        super(solde, numero, taux);
        this.seuil = seuil;
    }

    @Override
    public void retirer(double unMontant) throws BanqueException {
        double soldeTheorique = this.getSolde() - unMontant;
        if (soldeTheorique > this.seuil) {
            this.setSolde(soldeTheorique);
        } else {
            throw new BanqueException("Solde insufisant");
        }
    }

    @Override
    public double getSeuil() {
        return this.seuil;
    }

    @Override
    public void setSeuil(double unSeuil) {
        this.seuil = unSeuil;
    }

    @Override
    public String toString() {
        return "Compte A Seuil Remunere: cpt num : "+ this.getNumero() + ", solde : " +this.getSolde()+", taux : " + getTaux()+
                ",seuil: " + seuil +
                "\n";
    }
}
