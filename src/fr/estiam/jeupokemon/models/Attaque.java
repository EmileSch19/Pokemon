package fr.estiam.jeupokemon.models;

public class Attaque {
<<<<<<< HEAD
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
=======

 //declaration des attributs
    protected String nomAttaque;

    public String getNomAttaque() {
        return nomAttaque;
    }

    public void setNomAttaque(String nomAttaque) {
        this.nomAttaque = nomAttaque;
    }

    protected String [] typeAttaque;

    public String[] getTypeAttaque() {
        return typeAttaque;
    }

    public void setTypeAttaque(String[] typeAttaque) {
        this.typeAttaque = typeAttaque;
    }

    protected String catAttaque;

    public String getCatAttaque() {
        return catAttaque;
    }

    public void setCatAttaque(String catAttaque) {
        this.catAttaque = catAttaque;
    }

    protected double precAttaque;

    public double getPrecAttaque() {
        return precAttaque;
    }

    public void setPrecAttaque(double precAttaque) {
        this.precAttaque = precAttaque;
    }

    protected int puissance;

    public int getPuissance() {
        return puissance;
    }

    public void setPuissance(int puissance) {
        this.puissance = puissance;
    }

    protected int pp;

    public int getPp() {
        return pp;
    }

    public void setPp(int pp) {
        this.pp = pp;
    }
    //constructeur


    public Attaque(String nomAttaque, String[] typeAttaque, String catAttaque, double precAttaque, int puissance, int pp) {
        this.nomAttaque = nomAttaque;
        this.typeAttaque = typeAttaque;
        this.catAttaque = catAttaque;
        this.precAttaque = precAttaque;
>>>>>>> 303a55267ddde604f204116aff89b16fcc9d53e3
        this.puissance = puissance;
        this.pp = pp;
    }

<<<<<<< HEAD
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
=======
    public int AttaquePhysique(Pokemon Attaque, Pokemon defense){

        int atk = Attaque.getAttaque();
        int def = defense.getdefense();
        int niveau = Attaque.getniveau();
        int dommage = 0;
        int stab = 1;
        String typeAtk1 = Attaque.gettype1();
        String typeAtk2 = Attaque.gettype2();

        if(this.typeAttaque = )


    }





>>>>>>> 303a55267ddde604f204116aff89b16fcc9d53e3
}
