package service;

import model.Entreprise;
import java.util.ArrayList;
import java.util.List;

public class GestionEntreprises implements IGestion<Entreprise> {
    private List<Entreprise> entreprises = new ArrayList<>();

    @Override
    public void ajouter(Entreprise e) {
        entreprises.add(e);
    }

    @Override
    public void supprimer(int id) {
        entreprises.removeIf(e -> e.getId() == id);
    }

    @Override
    public List<Entreprise> afficherTous() {
        return entreprises;
    }
}