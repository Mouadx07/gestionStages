package model;

public class Stage {
    private int id;
    private String titre;
    private Entreprise entreprise;
    private Stagiaire stagiaire;

    public Stage(int id, String titre, Entreprise entreprise, Stagiaire stagiaire) {
        this.id = id;
        this.titre = titre;
        this.entreprise = entreprise;
        this.stagiaire = stagiaire;
    }

    // Getters (pas de setters pour simplifier)
    public int getId() { return id; }
    public String getTitre() { return titre; }
    public Entreprise getEntreprise() { return entreprise; }
    public Stagiaire getStagiaire() { return stagiaire; }
}