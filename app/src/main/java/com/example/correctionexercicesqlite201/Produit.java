package com.example.correctionexercicesqlite201;

import java.io.Serializable;

public class Produit implements Serializable {

    private int id;
    private String libelle;
    private String famille;
    private double prixAchat;
    private double prixVente;

    public Produit() {
    }

    public Produit(int id, String libelle, String famille, double prixAchat, double prixVente) {
        this.id = id;
        this.libelle = libelle;
        this.famille = famille;
        this.prixAchat = prixAchat;
        this.prixVente = prixVente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getFamille() {
        return famille;
    }

    public void setFamille(String famille) {
        this.famille = famille;
    }

    public double getPrixAchat() {
        return prixAchat;
    }

    public void setPrixAchat(double prixAchat) {
        this.prixAchat = prixAchat;
    }

    public double getPrixVente() {
        return prixVente;
    }

    public void setPrixVente(double prixVente) {
        this.prixVente = prixVente;
    }
}
