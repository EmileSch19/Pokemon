package fr.estiam.jeupokemon.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jeu {
    private List<Joueur> joueurs;

    public Jeu() {
        this.joueurs = new ArrayList<>();
    }

    public void jouer() {
        Scanner scanner = new Scanner(System.in);

        for (int i = 1; i <= 2; i++) {
            System.out.print("Entrez le nom du Joueur " + i + ": ");
            String nom = scanner.nextLine();
            System.out.print("Entrez l'argent pour acheter des Pokémons au Joueur " + i + ": ");
            double argent = scanner.nextDouble();
            scanner.nextLine(); // Pour consommer le retour à la ligne restant
            Joueur joueur = new Joueur(nom, argent);
            joueur.choisirPokemon(choisirPokemons());
            joueurs.add(joueur);
        }

        for (int round = 1; round <= 3; round++) {
            System.out.println("\n--- Round " + round + " ---");
            Joueur joueur1 = joueurs.get(0);
            Joueur joueur2 = joueurs.get(1);
            Pokemon pokemon1 = joueur1.recupererPokemon(round);
            Pokemon pokemon2 = joueur2.recupererPokemon(round);

            while (!pokemon1.estKo() && !pokemon2.estKo()) {
                System.out.println("\nTour du Joueur 1 (" + joueur1.getNom() + ")");
                Attaque attaque1 = joueur1.choisirAttaque(pokemon1);

                System.out.println("\nTour du Joueur 2 (" + joueur2.getNom() + ")");
                Attaque attaque2 = joueur2.choisirAttaque(pokemon2);

                // Déterminez l'ordre d'attaque en fonction de la vitesse des Pokémon
                if (pokemon1.getVitesse() >= pokemon2.getVitesse()) {
                    joueur1.attaquer(pokemon1, attaque1, pokemon2);
                    joueur2.attaquer(pokemon2, attaque2, pokemon1);
                } else {
                    joueur2.attaquer(pokemon2, attaque2, pokemon1);
                    joueur1.attaquer(pokemon1, attaque1, pokemon2);
                }
                afficherEtatCombat(pokemon1, pokemon2);
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
    }

<<<<<<< HEAD
    private List<Pokemon> choisirPokemons() {
        Pokemon pikachu = new Pokemon("Pikachu", 500, "Électrik", null, 70, 25, 50, 60, 40, 50);
        pikachu.ajouterAttaque(new Attaque("Éclair", "Électrik", "physique", 90, 40, 20));
        pikachu.ajouterAttaque(new Attaque("Queue de fer", "Acier", "physique", 85, 60, 15));

        Pokemon bulbizarre = new Pokemon("Bulbizarre", 450, "Plante", "Poison", 60, 20, 45, 50, 40, 55);
        bulbizarre.ajouterAttaque(new Attaque("Fouet lianes", "Plante", "physique", 95, 35, 25));
        bulbizarre.ajouterAttaque(new Attaque("Charge", "Normal", "physique", 100, 30, 15));

        Pokemon salamèche = new Pokemon("Salamèche", 400, "Feu", null, 55, 18, 50, 40, 45, 65);
        salamèche.ajouterAttaque(new Attaque("Lance-Flammes", "Feu", "spéciale", 85, 55, 20));
        salamèche.ajouterAttaque(new Attaque("Griffe", "Normal", "physique", 90, 40, 25));

        Pokemon carapuce = new Pokemon("Carapuce", 470, "Eau", null, 65, 22, 40, 50, 65, 35);
        carapuce.ajouterAttaque(new Attaque("Pistolet à O", "Eau", "spéciale", 95, 35, 20));
        carapuce.ajouterAttaque(new Attaque("Morsure", "Ténèbres", "physique", 90, 40, 25));

        Pokemon rondoudou = new Pokemon("Rondoudou", 520, "Fée", "Normal", 80, 30, 30, 50, 30, 35);
        rondoudou.ajouterAttaque(new Attaque("Chant Canon", "Normal", "spéciale", 75, 45, 15));
        rondoudou.ajouterAttaque(new Attaque("Métronome", "Normal", "spéciale", 80, 40, 20));

        Pokemon racaillou = new Pokemon("Racaillou", 480, "Roche", "Sol", 70, 28, 40, 30, 60, 25);
        racaillou.ajouterAttaque(new Attaque("Éboulement", "Roche", "physique", 85, 50, 15));
        racaillou.ajouterAttaque(new Attaque("Séisme", "Sol", "physique", 90, 55, 20));

        Pokemon psykokwak = new Pokemon("Psykokwak", 510, "Eau", null, 75, 32, 45, 50, 35, 55);
        psykokwak.ajouterAttaque(new Attaque("Hydrocanon", "Eau", "spéciale", 80, 60, 10));
        psykokwak.ajouterAttaque(new Attaque("Psyko", "Psy", "spéciale", 90, 55, 20));

        Pokemon machoc = new Pokemon("Machoc", 490, "Combat", null, 65, 28, 80, 30, 35, 45);
        machoc.ajouterAttaque(new Attaque("Dynamopoing", "Combat", "physique", 75, 55, 15));
        machoc.ajouterAttaque(new Attaque("Balayette", "Combat", "physique", 85, 40, 20));

        Pokemon abra = new Pokemon("Abra", 440, "Psy", null, 40, 15, 20, 105, 15, 90);
        abra.ajouterAttaque(new Attaque("Choc Mental", "Psy", "spéciale", 90, 30, 25));
        abra.ajouterAttaque(new Attaque("Téléport", "Psy", "spéciale", 100, 10, 40));

        Pokemon osselait = new Pokemon("Osselait", 470, "Sol", null, 55, 20, 50, 40, 65, 35);
        osselait.ajouterAttaque(new Attaque("Séisme", "Sol", "physique", 90, 55, 20));
        osselait.ajouterAttaque(new Attaque("Fracass'Tête", "Normal", "physique", 80, 45, 25));

        return new ArrayList<>();
    }

    private void afficherEtatCombat(Pokemon pokemon1, Pokemon pokemon2) {
        // Vous pouvez implémenter cette méthode pour afficher l'état actuel du combat.
        // Affichez les points de vie restants, les statuts, etc.
    }



=======
>>>>>>> 303a55267ddde604f204116aff89b16fcc9d53e3
}
