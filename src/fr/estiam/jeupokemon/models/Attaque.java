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

    // Méthodes getters
    public String getNom() {
        return nom;
    }

    public String getType() {
        return type;
    }

    public String getCategorie() {
        return categorie;
    }

    public double getPrecision() {
        return precision;
    }

    public int getPuissance() {
        return puissance;
    }

    public int getPp() {
        return pp;
    }


    public int calculerDegats(Pokemon attaquant, Pokemon attaque) {
        double stab = (attaquant.getType().equals(this.type)) ? 1.5 : 1.0;
        double coefMultiplicateur = stab + this.precision; // Ajouter un facteur aléatoire entre 0.85 et 1.0
        double attaqueUtilisee = (categorie.equals("physique")) ? attaquant.getAttaque() : attaquant.getAttaqueSpeciale();
        double defenseCible = (categorie.equals("physique")) ? attaque.getDefense() : attaque.getDefenseSpeciale();
        double degats = (((attaquant.getNiveau() * 0.4*2) * attaqueUtilisee * this.puissance) / (defenseCible * 50) + 2) * coefMultiplicateur;
        return (int) degats;
    }


    public void afficher() {
        System.out.println("Nom de l'attaque: " + getNom() +"Type: " + getType()+"Catégorie: " + getCategorie()+"Précision: " + getPrecision()+"Puissance: " + getPuissance()+"PP: " + getPp());

    }
}
