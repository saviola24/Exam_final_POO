package hei.school;

import java.time.Instant;

public class Examen {
    private int id;
    private String nom;
    private String titre;
    private Cours cours;
    private Instant dateEtHeure;
    private int coefficient;

    public Examen(int id,String nom,Cours cours,Instant dateEtHeure,int coefficient) {
        this.id = id;
        this.nom = nom;
        this.cours = cours;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Cours getCours() {
        return cours;
    }

    public void setCours(Cours cours) {
        this.cours = cours;
    }

    public Instant getDateEtHeure() {
        return dateEtHeure;
    }

    public void setDateEtHeure(Instant dateEtHeure) {
        this.dateEtHeure = dateEtHeure;
    }

    public int getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(int coefficient) {
        this.coefficient = coefficient;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }
}
