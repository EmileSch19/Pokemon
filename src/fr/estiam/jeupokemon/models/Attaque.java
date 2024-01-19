package fr.estiam.jeupokemon.models;

public class Attaque {

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
        this.puissance = puissance;
        this.pp = pp;
    }

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





}
