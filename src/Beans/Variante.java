package Beans;

public class Variante {

    //declaration des attributs de class
    private int id;
    private String nom, style;

    public Variante() {
    }

    public Variante(int id, String nom, String style) {
        this.id = id;
        this.nom = nom;
        this.style = style;

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

}
