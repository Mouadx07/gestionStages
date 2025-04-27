import model.*;
import service.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestionStagiaires gestionStagiaires = new GestionStagiaires();
        GestionEntreprises gestionEntreprises = new GestionEntreprises();
        GestionStages gestionStages = new GestionStages();
        int choix;

        do {
            System.out.println("\n=== Menu Principal ===");
            System.out.println("1. Gérer les stagiaires");
            System.out.println("2. Gérer les entreprises");
            System.out.println("3. Gérer les stages");
            System.out.println("4. Quitter");
            System.out.print("Choix : ");
            choix = scanner.nextInt();

            switch (choix) {
                case 1 -> gererStagiaires(scanner, gestionStagiaires);
                case 2 -> gererEntreprises(scanner, gestionEntreprises);
                case 3 -> gererStages(scanner, gestionStages, gestionEntreprises, gestionStagiaires);
                case 4 -> System.out.println("Au revoir !");
                default -> System.out.println("Choix invalide !");
            }
        } while (choix != 4);
    }

    private static void gererStagiaires(Scanner scanner, GestionStagiaires gestion) {
        int choix;
        do {
            System.out.println("\n=== Gestion des Stagiaires ===");
            System.out.println("1. Ajouter un stagiaire");
            System.out.println("2. Afficher tous les stagiaires");
            System.out.println("3. Supprimer un stagiaire");
            System.out.println("4. Retour");
            System.out.print("Choix : ");
            choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    System.out.print("ID : ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nom : ");
                    String nom = scanner.nextLine();
                    System.out.print("Niveau d'étude : ");
                    String niveau = scanner.nextLine();
                    gestion.ajouter(new Stagiaire(id, nom, niveau));
                    break;
                case 2:
                    gestion.afficherTous().forEach(s ->
                            System.out.println(s.getId() + " | " + s.getNom() + " | " + s.getNiveauEtude())
                    );
                    break;
                case 3:
                    System.out.print("ID à supprimer : ");
                    gestion.supprimer(scanner.nextInt());
                    break;
            }
        } while (choix != 4);
    }

    private static void gererEntreprises(Scanner scanner, GestionEntreprises gestion) {
        int choix;
        do {
            System.out.println("\n=== Gestion des Entreprises ===");
            System.out.println("1. Ajouter une entreprise");
            System.out.println("2. Afficher toutes les entreprises");
            System.out.println("3. Supprimer une entreprise");
            System.out.println("4. Retour");
            System.out.print("Choix : ");
            choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    System.out.print("ID : ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nom : ");
                    String nom = scanner.nextLine();
                    System.out.print("Secteur : ");
                    String secteur = scanner.nextLine();
                    gestion.ajouter(new Entreprise(id, nom, secteur));
                    break;
                case 2:
                    gestion.afficherTous().forEach(e ->
                            System.out.println(e.getId() + " | " + e.getNom() + " | " + e.getSecteur())
                    );
                    break;
                case 3:
                    System.out.print("ID à supprimer : ");
                    gestion.supprimer(scanner.nextInt());
                    break;
            }
        } while (choix != 4);
    }

    private static void gererStages(Scanner scanner, GestionStages gestion,
                                    GestionEntreprises gesEntreprises, GestionStagiaires gesStagiaires) {
        int choix;
        do {
            System.out.println("\n=== Gestion des Stages ===");
            System.out.println("1. Ajouter un stage");
            System.out.println("2. Afficher tous les stages");
            System.out.println("3. Supprimer un stage");
            System.out.println("4. Retour");
            System.out.print("Choix : ");
            choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    System.out.print("ID du stage : ");
                    int idStage = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Titre : ");
                    String titre = scanner.nextLine();

                    System.out.print("ID de l'entreprise : ");
                    int idEntreprise = scanner.nextInt();
                    Entreprise entreprise = gesEntreprises.afficherTous().stream()
                            .filter(e -> e.getId() == idEntreprise)
                            .findFirst()
                            .orElse(null);

                    System.out.print("ID du stagiaire (0 si aucun) : ");
                    int idStagiaire = scanner.nextInt();
                    Stagiaire stagiaire = (idStagiaire == 0) ? null :
                            gesStagiaires.afficherTous().stream()
                                    .filter(s -> s.getId() == idStagiaire)
                                    .findFirst()
                                    .orElse(null);

                    gestion.ajouter(new Stage(idStage, titre, entreprise, stagiaire));
                    break;
                case 2:
                    gestion.afficherTous().forEach(s -> {
                        System.out.println(s.getId() + " | " + s.getTitre() +
                                " | Entreprise: " + s.getEntreprise().getNom() +
                                " | Stagiaire: " + (s.getStagiaire() != null ? s.getStagiaire().getNom() : "Aucun"));
                    });
                    break;
                case 3:
                    System.out.print("ID à supprimer : ");
                    gestion.supprimer(scanner.nextInt());
                    break;
            }
        } while (choix != 4);
    }
}