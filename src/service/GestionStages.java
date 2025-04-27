package service;

import model.Stage;
import java.util.ArrayList;
import java.util.List;

public class GestionStages implements IGestion<Stage> {
    private List<Stage> stages = new ArrayList<>();

    @Override
    public void ajouter(Stage s) {
        stages.add(s);
    }

    @Override
    public void supprimer(int id) {
        stages.removeIf(s -> s.getId() == id);
    }

    @Override
    public List<Stage> afficherTous() {
        return stages;
    }
}