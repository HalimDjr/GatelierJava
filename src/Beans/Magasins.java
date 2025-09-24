package Beans;

public class Magasins {

    //declaration des attributs de class
    private int id;
    private String nom, addresse;

    public Magasins() {
    }

    public Magasins(int id, String nom, String addresse) {
        this.id = id;
        this.nom = nom;
        this.addresse = addresse;

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

    public String getAddresse() {
        return addresse;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

}
