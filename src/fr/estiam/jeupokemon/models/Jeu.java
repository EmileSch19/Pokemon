package fr.estiam.jeupokemon.models;

import java.util.ArrayList;
import java.util.List;

public class Jeu {
    List<Joueur> joueurs;

    public Jeu() {
        this.joueurs = new ArrayList<>();
        joueurs.add(new Joueur("Joueur 1", 1000));
        joueurs.add(new Joueur("Joueur 2", 1000));
    }

    public void jouer() {
        // Implémentez la logique du jeu avec les rounds et les combats
        // ...
    }

    public static void main(String[] args) {
        Jeu jeu = new Jeu();
        jeu.jouer();
    }
}

