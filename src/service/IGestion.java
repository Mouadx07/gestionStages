package service;

import java.util.List;

public interface IGestion<T> {
    void ajouter(T element);
    void supprimer(int id);
    List<T> afficherTous();
}