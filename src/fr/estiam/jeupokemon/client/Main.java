package fr.estiam.jeupokemon.client;

import fr.estiam.jeupokemon.models.Jeu;
import fr.estiam.jeupokemon.models.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
       List<Pokemon> pokemonsChoisisJoueur1 = new ArrayList<>();
       List<Pokemon> pokemonsChoisisJoueur2 = new ArrayList<>();

        Jeu jeu = new Jeu();
        try {
            jeu.jouer(pokemonsChoisisJoueur1, pokemonsChoisisJoueur2);
        } catch (Exception e) {
            System.out.println("Une erreur s'est produite : " + e.getMessage());
        }


    }
}
