package Beans;

public class Client {

    //declaration des attributs de class
    private int id,age;
    private String nom, prenom,sex,adresse ;

    public Client() {
    }

    public Client(int id, String nom, String prenom,int age, String sex,String adresse) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.sex=sex;
        this.adresse=adresse;
    }
    

  

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setsex(String sex) {
        this.sex = sex;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getAdresse() {
        return adresse;
    }

    public int getAge() {
        return age;
    }
    

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getsex() {
        return sex;
    }

  
    
    

}
