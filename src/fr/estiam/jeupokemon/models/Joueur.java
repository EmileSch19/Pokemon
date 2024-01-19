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

    public void choisirPokemon(List<Pokemon> listePokemons) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Liste des Pokémons disponibles:");
        for (int i = 0; i < listePokemons.size(); i++) {
            System.out.println((i + 1) + ". " + listePokemons.get(i).getNom());
        }

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
                i--; // Réduire i pour que l'utilisateur puisse saisir à nouveau le numéro correct.
                continue;
            }

            Pokemon pokemonChoisi = listePokemons.get(choix - 1);
            pokemons.add(pokemonChoisi);
            System.out.println("Vous avez choisi " + pokemonChoisi.getNom() + " !");
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
        return pokemons.get(numero - 1);
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
