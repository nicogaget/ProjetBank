package com.company;

public class CompteASeuil extends Compte implements ICompteASeuil{
    private double seuil = 10.00;

    public CompteASeuil(double seuil) {
        this.seuil = seuil;
    }

    public CompteASeuil(double solde, int numero) {
        super(solde, numero);
    }

    public CompteASeuil(double solde, int numero, double seuil) {
        super(solde, numero);
        this.seuil = seuil;
    }

    public double getSeuil() {
        return seuil;
    }

    public void setSeuil(double seuil) {
        this.seuil = seuil;
    }

    /**
     * Permet de retirer un montant du solde du compte
     * @param unMontant double
     */
    public void retirer(double unMontant) throws BanqueException {
        double soldeTheorique = this.getSolde() - unMontant;
        if (soldeTheorique > this.seuil) {
            this.setSolde(soldeTheorique);
        } else {
            throw new BanqueException("Solde insufisant");
        }
    }

    @Override
    public String toString() {
        return "Compte A seuil : cpt num " + this.getNumero() + ", solde :" + this.getSolde() +
                ", seuil :" + seuil +
                "\n";
    }
}
