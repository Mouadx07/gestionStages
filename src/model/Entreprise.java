package model;

public class Entreprise {
    private int id;
    private String nom;
    private String secteur;

    public Entreprise(int id, String nom, String secteur) {
        this.id = id;
        this.nom = nom;
        this.secteur = secteur;
    }

    public int getId() { return id; }
    public String getNom() { return nom; }
    public String getSecteur() { return secteur; }
}