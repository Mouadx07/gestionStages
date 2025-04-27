package model;

public abstract class Utilisateur {
    private int id;
    private String nom;

    public Utilisateur(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public int getId() { return id; }
    public String getNom() { return nom; }
}