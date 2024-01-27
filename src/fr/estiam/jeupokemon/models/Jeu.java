package fr.estiam.jeupokemon.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jeu {
    private List<Joueur> joueurs;

    public Jeu() {
        this.joueurs = new ArrayList<>();
    }

    public void jouer(List<Pokemon> pokemonsChoisisJoueur1, List<Pokemon> pokemonsChoisisJoueur2) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 1; i <= 2; i++) {
            System.out.print("Entrez le nom du Joueur " + i + ": ");
            String nom = scanner.nextLine();
            System.out.print("Entrez l'argent pour acheter des Pokémons au Joueur " + i + ": ");
            double argent = scanner.nextDouble();

            scanner.nextLine(); // Pour consommer le retour à la ligne restant
            Joueur joueur = new Joueur(nom, argent);
            joueur.choisirPokemon(choisirPokemons());
            joueur.choisirAttaque(); // Ajout de cette ligne pour choisir les attaques après les Pokémon
            joueurs.add(joueur);
        }

        Joueur joueur1 = joueurs.get(0);
        Joueur joueur2 = joueurs.get(1);

        joueur1.afficherPokemonsChoisis();
        joueur2.afficherPokemonsChoisis();


        joueur1.choisirAttaque();
        joueur2.choisirAttaque();

        

        for (int round = 1; round <= 3; round++) {
            System.out.println("\n--- Round " + round + " ---");
            Pokemon pokemon1 = joueur1.recupererPokemon(round);
            Pokemon pokemon2 = joueur2.recupererPokemon(round);

            // Vérifiez si les Pokémon ne sont pas null avant de commencer la boucle
            if (pokemon1 == null || pokemon2 == null) {
                System.out.println("Erreur : Pokémon null détecté.");
                break;
            }

            while (!pokemon1.estKo() && !pokemon2.estKo()) {
                System.out.println("\nTour du Joueur 1 (" + joueur1.getNom() + ")");
                Attaque attaque1 = joueur1.choisirAttaque(pokemon1);

                System.out.println("\nTour du Joueur 2 (" + joueur2.getNom() + ")");
                Attaque attaque2 = joueur2.choisirAttaque(pokemon2);

                // Déterminez l'ordre d'attaque en fonction de la vitesse des Pokémon
                if (pokemon1.getVitesse() >= pokemon2.getVitesse()) {
                    joueur1.attaquer(pokemon1, pokemon2, attaque1);
                    if (!pokemon2.estKo()){
                        joueur2.attaquer(pokemon2, pokemon1, attaque2);
                    }
                    else {
                        break;
                    }

                }

                else {
                    joueur2.attaquer(pokemon2 ,pokemon1, attaque2);
                    if (!pokemon1.estKo()){
                       joueur1.attaquer(pokemon1,pokemon2,attaque1);
                    }
                    else {
                        break;
                    }
                }
            }

            // Fin du round, déterminez le gagnant de la manche
            if (pokemon1.estKo()) {
                joueur2.gagnerManche();
                System.out.println(joueur2.getNom() + " remporte la manche!");
            } else {
                joueur1.gagnerManche();
                System.out.println(joueur1.getNom() + " remporte la manche!");
            }
        }

        // Fin du jeu, déterminez le gagnant final
        Joueur gagnant = (joueurs.get(0).getManchesGagnees() >= 2) ? joueurs.get(0) : joueurs.get(1);
        System.out.println("\n--- Fin du jeu ---");
        System.out.println(gagnant.getNom() + " remporte la partie!");
        gagnant.afficher();

    }

    private ArrayList<Pokemon> choisirPokemons() {
        return new ArrayList<>();
    }



}
