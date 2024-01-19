package fr.estiam.jeupokemon.models;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Joueur {
    private String nom;
    private int manchesGagnees;
    private double argent;
    private List<Pokemon> pokemons;

    public Joueur(String nom, double argent) {
        this.nom = nom;
        this.argent = argent;
        this.pokemons = new ArrayList<>();
    }

    public void choisirPokemon(List<Pokemon> pokemons) {
        Scanner scanner = new Scanner(System.in);
        List<Pokemon> listePokemons = new ArrayList<>();
        listePokemons.add(new Pokemon("Pikachu", 500, "Électrik", null, 70, 25, 50, 60, 40, 50));
        listePokemons.add(new Pokemon("Bulbizarre", 450, "Plante", "Poison", 60, 20, 45, 50, 40, 55));
        listePokemons.add(new Pokemon("Salamèche", 400, "Feu", null, 55, 18, 50, 40, 45, 65));
        listePokemons.add(new Pokemon("Carapuce", 470, "Eau", null, 65, 22, 40, 50, 65, 35));
        listePokemons.add(new Pokemon("Rondoudou", 520, "Fée", "Normal", 80, 30, 30, 50, 30, 35));
        listePokemons.add(new Pokemon("Racaillou", 480, "Roche", "Sol", 70, 28, 40, 30, 60, 25));

        for (int i = 0; i < 3; i++) {
            int choix = 0;
            try {
                System.out.print("Choisissez le numéro du Pokémon " + (i + 1) + ": ");
                choix = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Veuillez entrer un numéro valide.");
                // Ajoutez une logique pour gérer l'erreur ou redemandez à l'utilisateur de saisir un numéro.
            }

            if (choix < 1 || choix > listePokemons.size()) {
                System.out.println("Numéro invalide. Veuillez choisir un numéro de Pokémon valide.");
                i--;
                continue;
            }

            Pokemon pokemonChoisi = listePokemons.get(choix - 1);
            pokemons.add(pokemonChoisi);
            System.out.println("Vous avez choisi " + pokemonChoisi.getNom() + " !");
        }
    }

    public void afficherPokemonsChoisis() {
        System.out.println("Liste des Pokémons choisis par " + nom + ":");
        for (Pokemon pokemon : pokemons) {
            pokemon.afficher();
        }
    }



    public void ajouterPokemon(Pokemon pokemon) {
        pokemons.add(pokemon);
    }

    public Attaque choisirAttaque(Pokemon pokemon) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Liste des attaques pour " + pokemon.getNom() + ":");
        // Afficher les attaques du Pokémon (à compléter selon les propriétés de la classe Attaque)


        // Demander au joueur de choisir une attaque
        System.out.print("Choisissez le numéro de l'attaque: ");
        int choix = scanner.nextInt();
        return pokemon.getAttaques().get(choix - 1);
    }

    public Pokemon recupererPokemon(int numero) {
        if (numero >= 1 && numero <= pokemons.size()) {
            return pokemons.get(numero - 1);
        }
        else {
            System.out.println("Numéro de Pokémon invalide. Veuillez choisir un numéro de Pokémon valide.");
            return null;
        }
    }


    public void afficherPokemons() {
        System.out.println("Liste des Pokémons de " + nom + ":");
        for (Pokemon pokemon : pokemons) {
            System.out.println("Nom: " + pokemon.getNom() + ", PV: " + pokemon.getPv());
        }
    }

    public void afficher() {
        System.out.println("Informations sur le joueur " + nom + ":");
        System.out.println("Manches gagnées: " + manchesGagnees);
        System.out.println("Argent: " + argent);
        afficherPokemons();
    }

    public int getManchesGagnees() {

        return 0;
    }

    public boolean getNom() {

        return false;
    }

    public void attaquer(Pokemon pokemon2, Attaque attaque2, Pokemon pokemon1) {
    }

    public void gagnerManche() {
    }

}
