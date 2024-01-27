package fr.estiam.jeupokemon.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pokemon {
    private String nom;
    private double prix;
    private String type1;
    private String type2;
    private int pv;
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
        this.pv = pointsDeVie;
        this.niveau = niveau;
        this.attaque = attaque;
        this.attaqueSpeciale = attaqueSpeciale;
        this.defense = defense;
        this.defenseSpeciale = defenseSpeciale;
        this.vitesse = vitesse;
        this.attaques = new ArrayList<>();
        ListeAttaques();
    }

    private void ListeAttaques() {
        attaques = new ArrayList<>();

        // Ajoutez les attaques pour Pikachu
        if (nom.equals("Pikachu")) {
            attaques.add(new Attaque("Éclair", "Électrik", "physique", 90, 40, 20));
            attaques.add(new Attaque("Queue de fer", "Acier", "physique", 85, 60, 15));
        } else if (nom.equals("Bulbizarre")) {
            attaques.add(new Attaque("Fouet lianes", "Plante", "physique", 95, 35, 25));
            attaques.add(new Attaque("Charge", "Normal", "physique", 100, 30, 15));
        } else if (nom.equals("Salamèche")) {
            attaques.add(new Attaque("Lance-Flammes", "Feu", "spéciale", 85, 55, 20));
            attaques.add(new Attaque("Griffe", "Normal", "physique", 90, 40, 25));
        } else if (nom.equals("Carapuce")) {
            attaques.add(new Attaque("Pistolet à O", "Eau", "spéciale", 95, 35, 20));
            attaques.add(new Attaque("Morsure", "Ténèbres", "physique", 90, 40, 25));
        } else if (nom.equals("Rondoudou")) {
            attaques.add(new Attaque("Chant Canon", "Normal", "spéciale", 75, 45, 15));
            attaques.add(new Attaque("Métronome", "Normal", "spéciale", 80, 40, 20));
        } else if (nom.equals("Racaillou")) {
            attaques.add(new Attaque("Éboulement", "Roche", "physique", 85, 50, 15));
            attaques.add(new Attaque("Séisme", "Sol", "physique", 90, 55, 20));
        }


    }
//Getter
    public String getNom() {
        return nom;
    }

    public double getPrix() {
        return prix;
    }

    public String getType1() {
        return type1;
    }

    public String getType2() {
        return type2;
    }

    public int getNiveau() {
        return niveau;
    }

    public int getAttaque() {
        return attaque;
    }

    public int getAttaqueSpeciale() {
        return attaqueSpeciale;
    }

    public int getDefense() {
        return defense;
    }

    public int getDefenseSpeciale() {
        return defenseSpeciale;
    }

    public int getVitesse() {
        return vitesse;
    }

    public List<Attaque> getAttaques() {
        return attaques;
    }

    public String getType() {
        return type1;
    }

    public void ajouterAttaque(Attaque attaque) {

    } 
   

    public void afficherAttaques() {
        System.out.println("Liste des attaques de " + nom + ":");
        for (Attaque attaque : attaques) {
            System.out.println("Nom: " + attaque.getNom());
            System.out.println("Type: " + attaque.getType());
            System.out.println("Catégorie: " + attaque.getCategorie());
            System.out.println("Précision: " + attaque.getPrecision());
            System.out.println("Puissance: " + attaque.getPuissance());
            System.out.println("PP: " + attaque.getPp());
            System.out.println();
        }
    }

    public boolean estKo() {
        if (pv <= 0) {
            pv = 0;
            return true;
        }
        else{
            return false;
        }
    }


    // Méthode pour subir des dégâts
    public void subirDegats ( int degats){
        pv -= degats;

    }

    public int getPv() {
        return pv;
    }
}

