package com.company;

public interface ICompteASeuil {
    void retirer(double uneValeur) throws BanqueException;
    double getSeuil();
    void setSeuil(double unSeuil);
}
