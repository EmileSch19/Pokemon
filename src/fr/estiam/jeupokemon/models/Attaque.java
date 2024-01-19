package fr.estiam.jeupokemon.models;

public class Attaque {
    private String nom;
    private String type;
    private String categorie;
    private double precision;
    private int puissance;
    private int pp;

    // Constructeur
    public Attaque(String nom, String type, String categorie, double precision, int puissance, int pp) {
        this.nom = nom;
        this.type = type;
        this.categorie = categorie;
        this.precision = precision;
        this.puissance = puissance;
        this.pp = pp;
    }

    // Méthode pour calculer les dégâts
    /*public int calculerDegats(Pokemon attaquant, Pokemon attaque) {
        double stab = (attaquant.getType().equals(this.type)) ? 1.5 : 1.0;
        double coefMultiplicateur = stab * (Math.random() * 0.15 + 0.85); // Ajouter un facteur aléatoire entre 0.85 et 1.0
        //double attaqueUtilisee = (categorie.equals("physique")) ? attaquant.getAttaque() : attaquant.getAttaqueSpeciale();
        //double defenseCible = (categorie.equals("physique")) ? attaque.getDefense() : attaque.getDefenseSpeciale();
        //double degats = (((2 * 100 / 5 + 2) * attaqueUtilisee * puissance / defenseCible) / 50 + 2) * coefMultiplicateur;
        return (int) degats;
    }*/

    // Méthode pour afficher les informations de l'attaque
    public void afficher() {
        System.out.println("Nom de l'attaque: " + nom);
        System.out.println("Type: " + type);
        System.out.println("Catégorie: " + categorie);
        System.out.println("Précision: " + precision);
        System.out.println("Puissance: " + puissance);
        System.out.println("PP: " + pp);
    }
}