package model;

public class Stagiaire extends Utilisateur {
    private String niveauEtude;

    public Stagiaire(int id, String nom, String niveauEtude) {
        super(id, nom);
        this.niveauEtude = niveauEtude;
    }

    public String getNiveauEtude() { return niveauEtude; }
}