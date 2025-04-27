package service;

import model.Stagiaire;
import java.util.ArrayList;
import java.util.List;

public class GestionStagiaires implements IGestion<Stagiaire> {
    private List<Stagiaire> stagiaires = new ArrayList<>();

    @Override
    public void ajouter(Stagiaire s) {
        stagiaires.add(s);
    }

    @Override
    public void supprimer(int id) {
        stagiaires.removeIf(s -> s.getId() == id);
    }

    @Override
    public List<Stagiaire> afficherTous() {
        return stagiaires;
    }
}