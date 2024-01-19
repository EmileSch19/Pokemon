package fr.estiam.jeupokemon.models;

import java.util.ArrayList;
import java.util.List;

public class Pokemon {
    private String nom;
    private double prix;
    private String type1;
    private String type2;
    private int pointsDeVie;
    private int niveau;
    private int attaque;
    private int attaqueSpeciale;
    private int defense;
    private int defenseSpeciale;
    private int vitesse;
    private List<Attaque> attaques;

    // Constructeur
    public Pokemon(String nom, double prix, String type1, String type2, int pointsDeVie, int niveau,
                   int attaque, int attaqueSpeciale, int defense, int defenseSpeciale) {
        this.nom = nom;
        this.prix = prix;
        this.type1 = type1;
        this.type2 = type2;
        this.pointsDeVie = pointsDeVie;
        this.niveau = niveau;
        this.attaque = attaque;
        this.attaqueSpeciale = attaqueSpeciale;
        this.defense = defense;
        this.defenseSpeciale = defenseSpeciale;
        this.vitesse = vitesse;
        this.attaques = new ArrayList<>();
    }

    // Méthode pour ajouter une attaque
    public void ajouterAttaque(Attaque attaque) {
        attaques.add(attaque);
    }

    // Méthode pour attaquer un autre Pokémon
    /*public void attaquer(Pokemon cible, Attaque attaqueUtilisee) {
        int degats = attaqueUtilisee.calculerDegats(this, cible);
        cible.subirDegats(degats);
    }*/

    // Méthode pour déterminer si le Pokémon est KO
    public boolean estKo() {
        return pointsDeVie <= 0;
    }

    // Méthode pour afficher les attaques du Pokémon
    public void afficherAttaques() {
        System.out.println("Liste des attaques de " + nom + ":");
        for (Attaque attaque : attaques) {
            attaque.afficher();
        }
    }

    // Méthode pour afficher les informations du Pokémon
    public void afficher() {
        System.out.println("Nom: " + nom);
        System.out.println("Type(s): " + type1 + ", " + type2);
        System.out.println("PV: " + pointsDeVie);
        System.out.println("Niveau: " + niveau);
        System.out.println("Attaque: " + attaque);
        System.out.println("Attaque Spéciale: " + attaqueSpeciale);
        System.out.println("Défense: " + defense);
        System.out.println("Défense Spéciale: " + defenseSpeciale);
        System.out.println("Vitesse: " + vitesse);
        afficherAttaques();
    }

    // Méthode pour subir des dégâts
    public void subirDegats(int degats) {
        pointsDeVie -= degats;
        if (pointsDeVie < 0) {
            pointsDeVie = 0;
        }
    }

    // Getter pour le nom du Pokémon
    public String getNom() {
        return nom;
    }

    // Getter pour les attaques du Pokémon
    public List<Attaque> getAttaques() {
        return attaques;
    }

    // Getter pour les points de vie du Pokémon
    public int getPv() {
        return pointsDeVie;
    }

    public int getVitesse() {
        return 0;
    }


    public String getType() {
        return null;
    }

    public double getDefense() {
        return 0;
    }

    public double getAttaque() {
        return 0;
    }

    public double getAttaqueSpeciale() {
        return 0;
    }

    public double getDefenseSpeciale() {
        return 0;
    }
}

