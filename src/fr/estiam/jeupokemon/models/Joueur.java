package fr.estiam.jeupokemon.models;

import java.util.ArrayList;
import java.util.Scanner;

public class Joueur {
    private String nom;
    private int manchesGagnees;
    private double argent;
    private ArrayList<Pokemon> pokemons = new ArrayList<>();

    public Joueur(String nom, double argent) {
        this.nom = nom;
        this.argent = argent;
        this.pokemons = new ArrayList<>();
    }

    public void choisirPokemon(ArrayList<Pokemon> pokemons) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Pokemon> listePokemons = new ArrayList<>();
        Pokemon pikachu = new Pokemon("Pikachu", 500, "Électrik", null, 70, 25, 50, 60, 40, 50);
        pikachu.ajouterAttaque(new Attaque("Éclair", "Électrik", "physique", 90, 40, 20));
        pikachu.ajouterAttaque(new Attaque("Queue de fer", "Acier", "physique", 85, 60, 15));
        listePokemons.add(pikachu);

        Pokemon bulbizarre = new Pokemon("Bulbizarre", 450, "Plante", "Poison", 60, 20, 45, 50, 40, 55);
        bulbizarre.ajouterAttaque(new Attaque("Fouet lianes", "Plante", "physique", 95, 35, 25));
        bulbizarre.ajouterAttaque(new Attaque("Charge", "Normal", "physique", 100, 30, 15));
        listePokemons.add(bulbizarre);

        Pokemon salameche = new Pokemon("Salamèche", 400, "Feu", null, 55, 18, 50, 40, 45, 65);
        salameche.ajouterAttaque(new Attaque("Lance-Flammes", "Feu", "spéciale", 85, 55, 20));
        salameche.ajouterAttaque(new Attaque("Griffe", "Normal", "physique", 90, 40, 25));
        listePokemons.add(salameche);

        Pokemon carapuce = new Pokemon("Carapuce", 470, "Eau", null, 65, 22, 40, 50, 65, 35);
        carapuce.ajouterAttaque(new Attaque("Pistolet à O", "Eau", "spécial", 1, 40, 25));
        carapuce.ajouterAttaque(new Attaque("Morsure", "Ténèbres", "physique", 1, 60, 20));
        listePokemons.add(carapuce);

        Pokemon rondoudou = new Pokemon("Rondoudou", 520, "Fée", "Normal", 80, 30, 30, 50, 30, 35);
        rondoudou.ajouterAttaque(new Attaque("Écume", "Eau", "spécial", 1, 40, 30));
        rondoudou.ajouterAttaque(new Attaque("Charme", "Fée", "statut", 0.95, 0, 20));
        listePokemons.add(rondoudou);

        Pokemon racaillou = new Pokemon("Racaillou", 480, "Roche", "Sol", 70, 28, 40, 30, 60, 25);
        racaillou.ajouterAttaque(new Attaque("Jet-pierres", "Roche", "physique", 0.9, 50, 15));
        racaillou.ajouterAttaque(new Attaque("Grimace", "Normal", "statut", 1, 0, 30));
        listePokemons.add(racaillou);

        System.out.println("Liste des Pokémon disponibles :");
        for (int i = 0; i < listePokemons.size(); i++) {
            System.out.println((i + 1) + ". " + listePokemons.get(i).getNom());
        }

        for (int i = 0; i < 3; i++) {
            int choix = 0;
            do {
                System.out.print("Choisissez le numéro du Pokémon " + (i + 1) + ": ");
                choix = scanner.nextInt();

                if (choix < 1 || choix > listePokemons.size()) {
                    System.out.println("Numéro invalide. Veuillez choisir un numéro de Pokémon valide.");
                }

            } while (choix < 1 || choix > listePokemons.size());

            Pokemon pokemonChoisi = listePokemons.get(choix - 1);
            this.pokemons.add(pokemonChoisi);
            System.out.println("Vous avez choisi " + pokemonChoisi.getNom() + " !");

        }

    }

    public void afficherPokemonsChoisis() {
        System.out.println("Pokémons choisis par " + nom + ":");
        for (int i = 0; i < pokemons.size(); i++) {
            System.out.println((i + 1) + ". " + pokemons.get(i).getNom());
        }
    }


    public Pokemon recupererPokemon(int numero) {


            return pokemons.get(numero - 1);
    }


    public void ajouterPokemon(Pokemon pokemon) {

        pokemons.add(pokemon);
    }

    public Attaque choisirAttaque(Pokemon pokemon) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Liste des attaques pour " + pokemon.getNom() + ":");
        int index = 1;
        for (Attaque attaque : pokemon.getAttaques()) {
            System.out.println(index + ". " + attaque.getNom());
            index++;
        }

        System.out.print("Choisissez le numéro de l'attaque: ");
        int choix = scanner.nextInt();

        while (choix < 1 || choix > pokemon.getAttaques().size()) {
            System.out.println("Numéro invalide. Veuillez choisir un numéro d'attaque valide.");
            System.out.print("Choisissez le numéro de l'attaque: ");
            choix = scanner.nextInt();
        }

        return pokemon.getAttaques().get(choix - 1);
    }


    public void afficherPokemons() {
        System.out.println("Liste des Pokémons de " + nom + ":");
        for (Pokemon pokemon : pokemons) {
            System.out.println("Nom: " + pokemon.getNom() + ", PV: " + pokemon.getPv());
        }
    }

    public void choisirAttaque() {
        for (Pokemon pokemon : pokemons) {
            System.out.println("Choisissez les attaques pour " + pokemon.getNom() + ":");
            pokemon.afficherAttaques();
        }
    }


    public void afficher() {
        System.out.println("Informations sur le joueur " + nom + ":");
        System.out.println("Manches gagnées: " + manchesGagnees);
        System.out.println("Argent: " + argent);
        afficherPokemons();
    }

    public int getManchesGagnees() {

        return manchesGagnees;
    }

    public String getNom() {

        return nom;
    }


    public void gagnerManche() {
        manchesGagnees++;
    }

    public void attaquer(Pokemon attaquant, Pokemon cible, Attaque attaqueChoisie) {
        int degats = attaqueChoisie.calculerDegats(attaquant, cible);
        cible.subirDegats(degats);


        System.out.println(attaquant.getNom() + " attaque " + cible.getNom() + " avec " + attaqueChoisie.getNom() + " !");
        System.out.println(cible.getNom() + " subit " + degats + " dégâts.");

        if (cible.estKo()) {
            System.out.println(cible.getNom() + " est KO !");
        }
    }
}
